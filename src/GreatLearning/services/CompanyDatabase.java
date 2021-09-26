package GreatLearning.services;
import GreatLearning.models.Company;

import java.util.*;

public class CompanyDatabase {
    Scanner sc = new Scanner( System.in );
    public BinarySearchTree binarySearchTree = new BinarySearchTree();
    public MergeSort mergeSort = new MergeSort();

    private ArrayList<Company> companies = new ArrayList<>();
    private int riseCounter = 0;
    private int declineCounter = 0;

    public CompanyDatabase(){}

    public CompanyDatabase(int numberOfCompanies){
        companies = CreateDatabase(numberOfCompanies);
    }

    public ArrayList<Company> CreateDatabase(int numberOfCompanies){

        for(int i = 0; i < numberOfCompanies ; i++){

            String companyName = "Company " + (i+1);
            System.out.print("Enter the Share Price of "+ companyName + " : ");

            double sharePrice = sc.nextDouble();

            System.out.print("Whether "+ companyName +"'s stock price rose today compare to yesterday?");
            boolean sharePriceIncreased = sc.nextBoolean();
            if(sharePriceIncreased)
                riseCounter++;
            else declineCounter++;

            Company company = new Company(companyName, sharePrice, true);
            companies.add( company );
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
