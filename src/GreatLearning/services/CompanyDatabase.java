package GreatLearning.services;
import GreatLearning.models.Company;

import java.util.*;

public class CompanyDatabase {
    Scanner sc = new Scanner( System.in );
    public BinarySearchTree binarySearchTree = new BinarySearchTree();
    public MergeSort mergeSort = new MergeSort();

    /***
     * Array list for the Collection of companies
     */
    private ArrayList<Company> companies = new ArrayList<>();

    /**
     *  Counter for the companies whose shares increased
     */
    private int riseCounter = 0;

    /**
     *  Counter for the companies whose shares decreased
     */
    private int declineCounter = 0;

    /**
     * Constructor
     */
    public CompanyDatabase(){}

    /**
     * Parameterized Constructor
     * @param numberOfCompanies : number of companies input from the user.
     */
    public CompanyDatabase(int numberOfCompanies){
        companies = CreateDatabase(numberOfCompanies);
    }

    /***
     * Setting the Values of each Company based on the user input.
     * @param numberOfCompanies: number of companies input from the user.
     * @return : Array list for the Collection of companies
     */
    public ArrayList<Company> CreateDatabase(int numberOfCompanies){
        for(int i = 0; i < numberOfCompanies ; i++){
            String companyName = "Company " + (i+1);

            System.out.print("Enter the Share Price of "+ companyName + " : ");
            double sharePrice = 0;
            try {
                sharePrice = sc.nextDouble();
            }
            catch (Exception e ){
                System.out.println("Wrong input, you have to enter a number : exception : " + e);
                System.exit( 0 );
            }

            try {
                System.out.print( "Whether " + companyName + "'s stock price rose today compare to yesterday?" );
                boolean sharePriceIncreased = sc.nextBoolean();
                if(sharePriceIncreased)
                    riseCounter++;
                else declineCounter++;
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong input, you have to enter \"true\" or \"false\"  : exception : " + e);
                System.exit( 0 );
            }

            Company company = new Company(companyName, sharePrice, true);

            /* * Adding the company variable to the Array list */
            companies.add( company );

            /* Adding the share price to the BST. */
            binarySearchTree.Insert( (double) sharePrice );
        }

        return companies;
    }


    public void MergeSortAscending(){
        double [] sharesArray = new double[companies.size()];
        for(int i = 0; i < companies.size(); i++){
            sharesArray[i] = companies.get( i ).getSharePrice();
        }
        mergeSort.Sort(sharesArray, 0 , companies.size() -1, true);
        for (double i : sharesArray) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public void MergeSortDescending(){
        double [] sharesArray = new double[companies.size()];
        for(int i = 0; i < companies.size(); i++){
            sharesArray[i] = companies.get( i ).getSharePrice();
        }
        mergeSort.Sort(sharesArray, 0 , companies.size() -1, false);
        for (double i : sharesArray) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public int StockPriceRise(){
        return riseCounter;
    }

    public int StockPriceDecline(){
        return declineCounter;
    }

    public void SearchInDatabase(double val){
        if(binarySearchTree.Search( val )) {
            System.out.println("Stock of value "+ val +" is present ");
        }
        else {
            System.out.println( "Value not found" );
        }
    }

    public ArrayList<Company> getCompanyDatabase(){
        return companies;
    }
}
