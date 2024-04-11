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
                default -> System.out.println("Product doesn't exist");
            }

        }

        int total = 0;

        
    }
}





