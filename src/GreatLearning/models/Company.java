package GreatLearning.models;

public class Company {

    private double sharePrice;
    private boolean shareValueIncreased;
    private String companyName;

    public Company() {};

    public Company(String companyName, double sharePrice, boolean shareValueIncreased) {
        this.companyName = companyName;
        this.sharePrice = sharePrice;
        this.shareValueIncreased = shareValueIncreased;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public boolean isShareValueIncreased() {
        return shareValueIncreased;
    }
}
