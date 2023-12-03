package org.example;

public class CustomerInformation {
    private int customerId;
    private String customer_name;
    private double billAmount;
    private int noOfItems;
    private String branchName;

    public CustomerInformation() {
    }

    public CustomerInformation(int customerId, String customer_name, double billAmount, int noOfItems, String branchName) {
        this.customerId = customerId;
        this.customer_name = customer_name;
        this.billAmount = billAmount;
        this.noOfItems = noOfItems;
        this.branchName = branchName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
