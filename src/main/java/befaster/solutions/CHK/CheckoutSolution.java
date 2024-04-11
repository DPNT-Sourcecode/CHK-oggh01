package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;


import java.util.HashMap;
import java.util.Map;

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
    offers.put('A', Map.of(3, 130, 5, 200));
    offers.put('B', Map.of(2, 45));
    offers.put('H', Map.of(5, 45, 10, 80));
    offers.put('K', Map.of(2,150));
    offers.put('P', Map.of(5,200));
    offers.put('Q', Map.of(3,80));
    offers.put('V', Map.of(2, 90, 3,130));
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

          if(offers.containsKey(skusChr)){
              Map<Integer,Integer> skuOffers = offers.get(skusChr);
              for(Integer threshold : skuOffers.keySet()){
                  while(count >= threshold){
                      total += skuOffers.get(threshold);
                      count -= threshold;
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
        basket.computeIfPresent('U', (k, v) -> Math.max(v - freeU, 0));
    }

}
}






