package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

public class CheckoutSolution {

private static final Map<Character, Integer> prices = Map.ofEntries(
        new SimpleEntry<>('A', 50), new SimpleEntry<>('B', 30), new SimpleEntry<>('C', 20), new SimpleEntry<>('D', 15),
        new SimpleEntry<>('E', 40), new SimpleEntry<>('F', 10), new SimpleEntry<>('G', 20), new SimpleEntry<>('H', 10),
        new SimpleEntry<>('I', 35), new SimpleEntry<>('J', 60), new SimpleEntry<>('K', 80), new SimpleEntry<>('L', 90),
        new SimpleEntry<>('M', 15), new SimpleEntry<>('N', 40), new SimpleEntry<>('O', 10), new SimpleEntry<>('P', 50),
        new SimpleEntry<>('Q', 30), new SimpleEntry<>('R', 50), new SimpleEntry<>('S', 30), new SimpleEntry<>('T', 20),
        new SimpleEntry<>('U', 40), new SimpleEntry<>('V', 50), new SimpleEntry<>('W', 20), new SimpleEntry<>('X', 90),
        new SimpleEntry<>('Y', 10), new SimpleEntry<>('Z', 50));
    public Integer checkout(String skus) {

        int priceA = 50, priceB = 30, priceC = 20, priceD = 15, priceE = 40, priceF = 10;
        int offerThreeA = 130, offerFiveA = 200, offerB = 45;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0;

        for(char skusChr : skus.toCharArray()){
            switch (skusChr){
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                case 'E' -> countE++;
                case 'F' -> countF++;
                default -> { return -1; }
            }

        }

        int total = 0;

     total += (countA / 5) * offerFiveA + ((countA % 5) / 3) * offerThreeA + ((countA % 5) % 3) * priceA;

     int freeB = countE / 2;

     if(countB > freeB)
     {
         countB -= freeB;
     }
     else {
         countB = 0;
     }

     total+= (countB / 2) * offerB + (countB % 2) * priceB;

     total += countC * priceC + countD * priceD + countE * priceE;

     total += ((countF / 3) * 2 + (countF % 3)) * priceF;

     return total;
    }
}
