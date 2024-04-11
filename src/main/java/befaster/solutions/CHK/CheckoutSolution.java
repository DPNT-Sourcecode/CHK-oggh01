package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {


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
     int freeF = 0;

     if(countF > 3){

         freeF = countF / 2;

         countF -= freeF;
     }

     if(countB > freeB)
     {
         countB -= freeB;
     }
     else {
         countB = 0;
     }

     total+= (countB / 2) * offerB + (countB % 2) * priceB;

     total += countC * priceC + countD * priceD + countE * priceE;

     total += countF * priceF;

     return total;
    }
}

