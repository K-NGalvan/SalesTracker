import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        String[] monthArray = {"Januray", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        double[] monthlySales = new double[12]; 

        //get sales to prompt user for monthly sales
        getSales(monthArray, monthlySales);
        
        // Call computeTotalSales to compute the total sales for the year
        double totalSales = computeTotalSales(monthlySales);

        double averageSales = computeAverageSales(monthlySales);

        int highestMonth = computeHighestMonth(monthlySales);

        int lowestMonth = computeLowestMonth(monthlySales);

        // Call displaySaleInfo to display all the computed data
        displaySaleInfo(totalSales, averageSales, monthArray[highestMonth], monthlySales[highestMonth], monthArray[lowestMonth], monthlySales[lowestMonth]);
        
    }

    // This method prompts the user for the sales for each month and stores them in the monthlySales array
    public static void getSales(String[] monthArray, double[] monthlySales) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < monthArray.length; i++) {
            System.out.print("Enter sales for " + monthArray[i] + ": ");
            monthlySales[i] = scanner.nextDouble();
        }
        scanner.close();
    }

    //This method receives the monthly sales array as an argument and returns the total sales of the year.
    public static double computeTotalSales(double[] monthlySales){
        double totalSales = 0;

        for(int i = 0; i < 12; i++){
            totalSales += monthlySales[i];
        }
        return totalSales; 
    }

    //This method receives the monthly sales array as an argument and returns the average sales for the year.
    public static double computeAverageSales(double[] monthlySales){
        double averageSales = 0; 

        averageSales = computeTotalSales(monthlySales);
        return averageSales / 12;
    }

    public static int computeHighestMonth(double[] monthlySales){
       int highestMonth = 0; 

        for(int i = 0; i < 12; i++){
            if(monthlySales[i] > monthlySales[highestMonth]){
                highestMonth = i; 
            }
       }
       return highestMonth; 
    }

    public static int computeLowestMonth(double[] monthlySales){
        int lowestMonth = 0;
        
        for(int i = 0; i < 12; i++){
            if(monthlySales[i] < monthlySales[lowestMonth]){
                lowestMonth = i; 
            }
       }
       return lowestMonth;
    }


    public static void displaySaleInfo(Double totalSales, Double averageSales, String highestMonth, double highestSales, String lowestMonth, double lowestSales){

        System.out.printf("Total sales for the year: $%.2f%n", totalSales);
        System.out.printf("Average monthly sales: $%.2f%n", averageSales);
        System.out.println("Month with the highest sales: " + highestMonth + " with sales of $" + highestSales);
        System.out.println("Month with the lowest sales: " + lowestMonth + " with sales of $" + lowestSales);
        
    }
    
}
