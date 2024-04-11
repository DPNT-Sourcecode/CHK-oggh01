package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
     char[] skusArray =  skus.toCharArray();
     int countA = 0, countB = 0, countC = 0, countD = 0;
        for(char skusChr : skusArray){
            switch (skusChr){
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                default -> System.out.println("Product doesn't exist");
            }

        }
    }
}




