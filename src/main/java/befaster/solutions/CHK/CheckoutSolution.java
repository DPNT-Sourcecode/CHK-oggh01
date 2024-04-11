package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {


    public Integer checkout(String skus) {

        int priceA = 50, priceB = 30, priceC = 20, priceD = 15, priceE = 40;
        int offerThreeA = 130, offerFiveA = 200, offerB = 45;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0;

        for(char skusChr : skus.toCharArray()){
            switch (skusChr){
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                case 'E' -> countE++;
                default -> { return -1; }
            }

        }

        int total = 0;

     total += (countA / 5) * offerFiveA + ((countA % 5) / 3) * offerThreeA + ((countA % 5) % 3) * priceA;

     int freeB = countE / 2;

     if(countB > freeB) countB -= freeB;

     total += (countA / 3) * offerThreeA + (countA % 3) * priceA;

     total+= (countB / 2) * offerB + (countB % 2) * priceB;

     total += countC * priceC + countD * priceD;

     return total;
    }
}




