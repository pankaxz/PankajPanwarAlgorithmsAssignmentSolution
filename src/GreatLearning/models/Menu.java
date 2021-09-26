package GreatLearning.models;

import GreatLearning.services.CompanyDatabase;
import java.util.Scanner;

public class Menu {
    CompanyDatabase companyDatabase = new CompanyDatabase();
    Scanner sc = new Scanner( System.in );

    public void InitialiseDB() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Enter the number of companies : " );
        int numberOfCompanies = sc.nextInt();

        companyDatabase.CreateDatabase( numberOfCompanies );
    }

    public void InitialiseMenu() {
        System.out.println( "----------------------------------------------- " );
        System.out.println( "Enter the operation that you want to perform" );
        System.out.println( "1. Display the companies stock prices in ascending order" );
        System.out.println( "2. Display the companies stock prices in descending order" );
        System.out.println( "3. Display the total no of companies for which stock prices rose today" );
        System.out.println( "4. Display the total no of companies for which stock prices declined today" );
        System.out.println( "5. Search a specific stock price" );
        System.out.println( "6. press 0 to exit" );
        System.out.println( "----------------------------------------------- " );
    }

    public void AnalyseInput(int input) {
        switch ( input ) {
            case 0 -> {
                System.exit( 0 );
            }
            case 1 -> {
                System.out.println( "Stock prices in ascending order are : " );
                companyDatabase.MergeSortAscending();
            }
            case 2 -> {
                System.out.println( "Stock prices in descending order are : " );
                companyDatabase.MergeSortDescending();
            }
            case 3 -> {
                System.out.println( "Total no of companies whose stock price rose today : " + companyDatabase.StockPriceRise() );
            }
            case 4 -> {
                System.out.println( "Total no of companies whose stock price declined today : " + companyDatabase.StockPriceDecline() );
            }
            case 5 -> {
                System.out.println( "enter the key value : " );
                double key = sc.nextDouble();
                companyDatabase.SearchInDatabase( key );

            }
            default -> throw new IllegalStateException( "Invalid value: " + input + ". You have to enter a value from 0 to 5");
        }
    }

}
