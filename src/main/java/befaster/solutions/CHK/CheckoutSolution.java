package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CheckoutSolution {

private static final Map<Character, Integer> prices = Map.ofEntries(
       Map.entry('A', 50), Map.entry('B', 30), Map.entry('C', 20), Map.entry('D', 15),
       Map.entry('E', 40), Map.entry('F', 10), Map.entry('G', 20), Map.entry('H', 10),
       Map.entry('I', 35), Map.entry('J', 60), Map.entry('K', 80), Map.entry('L', 90),
       Map.entry('M', 15), Map.entry('N', 40), Map.entry('O', 10), Map.entry('P', 50),
       Map.entry('Q', 30), Map.entry('R', 50), Map.entry('S', 30), Map.entry('T', 20),
       Map.entry('U', 40), Map.entry('V', 50), Map.entry('W', 20), Map.entry('X', 90),
       Map.entry('Y', 10), Map.entry('Z', 50));


private static final Map<Character, Map<Integer, Integer>> offers = new HashMap<>();

static{
    offers.put('A', new TreeMap<>(Map.of(5, 200, 3, 130)));
    offers.put('B', new TreeMap<>(Map.of(2, 45)));
    offers.put('H', new TreeMap<>(Map.of(10, 80, 5, 45)));
    offers.put('K', new TreeMap<>(Map.of(2, 120)));
    offers.put('P', new TreeMap<>(Map.of(5, 200)));
    offers.put('Q', new TreeMap<>(Map.of(3, 80)));
    offers.put('V', new TreeMap<>(Map.of(3, 130, 2, 90)));
}
    public Integer checkout(String skus) {

      Map<Character, Integer> basket = new HashMap<>();
      for(char skusChr: skus.toCharArray()){
          if(!prices.containsKey(skusChr))
              return -1;
          basket.merge(skusChr, 1, Integer::sum);
      }

      applySpecialOffers(basket);

      int total = 0;

      for(Map.Entry<Character, Integer> entry : basket.entrySet()){
          char skusChr = entry.getKey();
          int count = entry.getValue();

              TreeMap<Integer, Integer> skuOffers = (TreeMap<Integer, Integer>) offers.get(skusChr);
              if(skuOffers != null) {
                 for (Map.Entry<Integer, Integer> offer : skuOffers.descendingMap().entrySet()){
                    while(count >= offer.getKey()) {
                        total+= offer.getValue();
                        count -= offer.getKey();
                    }
                  }
              }


          total += count * prices.get(skusChr);
      }

      return total;

        }

       private void applySpecialOffers(Map<Character, Integer> basket){

    if(basket.containsKey('E')){
        int freeB = basket.get('E') / 2;
        basket.computeIfPresent('B', (k, v) -> Math.max(v - freeB, 0));
    }

    if(basket.containsKey('N')){
        int freeM = basket.get('N') / 3;
        basket.computeIfPresent('M', (k, v) -> Math.max(v - freeM, 0));
    }

    if(basket.containsKey('R')){
        int freeQ = basket.get('R') / 3;
        basket.computeIfPresent('Q', (k, v) -> Math.max(v - freeQ, 0));
    }

    if(basket.containsKey('U')){
        int countU = basket.get('U');
        int freeU = basket.get('U') / 4;
        basket.put('U', countU - freeU);
    }

           if(basket.containsKey('F')){
               int countF = basket.get('F');
               int freeF = basket.get('F') / 3;
               basket.put('F', countF - freeF);
           }

}
}
