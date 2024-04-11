package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Map;

public class CheckoutSolution {

private static final Map<Character, Integer> prices = Map.of(
        'A', 50, 'B', 30, 'C', 20, 'D', 15, 'F', 10, 'G', 20,
        'H', 10, 'I', 35, 'J', 60, 'K', 80, 'L', 90, 'M', 15, 'N', 40, 'O', 10,
        'P', 50, 'Q', 30, 'R', 50, 'S', 30, 'T', 20, 'U', 40, 'V', 50, 'W', 20,
        'X', 90, 'Y', 10, 'Z', 50);
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




