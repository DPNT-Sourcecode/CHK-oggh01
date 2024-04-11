package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {


    public Integer checkout(String skus) {

        int priceA = 50, priceB = 30, priceC = 20, priceD = 15;
        int offerA = 130, offerB = 45;
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for(char skusChr : skus.toCharArray()){
            switch (skusChr){
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                default -> { return -1; }
            }

        }

        int total = 0;

     total += (countA / 3) * offerA + (countA % 3) * priceA;

     total+= (countB / 2) * offerB + (countB % 2) * priceB;

     total += countC * priceC + countD * priceD;

     return total;
    }
}







