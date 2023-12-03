package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class App 
{
    static public double findAvgBillByBranc(CustomerInformation[] cust,String bName){
       // System.out.println("custid"+cust[0].getBranchName());
        int bcount=0;
        int total=0;
        for(CustomerInformation c: cust){
            //System.out.println(c.getCustomer_name());
            if(c.getBranchName().equalsIgnoreCase(bName)){
                total+=c.getBillAmount();
                bcount++;
            }
        }
        if(bcount>0){
            return total/bcount;
        }else {
            return 0;
        }

    }

    static public String discountByBillAmount(CustomerInformation[] cust,int threshold,String starting_letter){
        double discount=0;
        String customer="";
        double amount=0;
        for(CustomerInformation c:cust){
            //System.out.println(c.getCustomer_name().charAt(0));
            starting_letter=starting_letter.toLowerCase();
            String objchar=c.getCustomer_name().toLowerCase();
           if(objchar.startsWith(starting_letter)){
                if(c.getBillAmount()>threshold){
                    discount=c.getBillAmount()*20/100;
                    amount=c.getBillAmount()-discount;
                    c.setBillAmount(amount);
                    customer=c.getCustomer_name();

                }else{
                    discount=c.getBillAmount()*10/100;
                    amount=c.getBillAmount()-discount;
                    c.setBillAmount(amount);
                    customer=c.getCustomer_name();
                }
           }
        }

        return customer;
    }

    public static void main( String[] args )
    {
        final Logger logger = LoggerFactory.getLogger(App.class);
        Scanner sc=new Scanner(System.in);
        logger.info("enter the size of customer details");
        int n=sc.nextInt();
        CustomerInformation[] customerInfo = new CustomerInformation[n];
        //List<CustomerInformation> custData=new ArrayList<>();
        for(int i=0;i<n;i++){
            logger.info("enter the customerId");
            int id=sc.nextInt();

            logger.info("enter the customer Name");
            String name=sc.next();

            logger.info("enter the bill amount");
            double amount=sc.nextDouble();

            logger.info("enter the number of items");
            int items=sc.nextInt();

            logger.info("enter the branch names");
            String bName=sc.next();

            customerInfo[i] = new CustomerInformation(id, name, amount, items, bName);
        }

        for(int i=0;i<n;i++){
           logger.info("custId: {}, customerName: {}, Bill: {}, No of Items: {}, branchName: {} ", customerInfo[i].getCustomerId(), customerInfo[i].getCustomer_name(),customerInfo[i].getBillAmount(),customerInfo[i].getNoOfItems(), customerInfo[i].getBranchName());
        }

        logger.info("enter the branch name to get Avg");
        String branch=sc.next();
        logger.info("enter the threshold amount");
        int threshold=sc.nextInt();
        logger.info("enter the name starting latter");
        String starting_latter=sc.next();
        double avg=findAvgBillByBranc(customerInfo,branch);
        if(avg>0){
            logger.info("average value of "+branch+" branch is:"+avg);
        }else{
            logger.info("There are no customer purchase in that particular branch");
        }
       String cust=discountByBillAmount(customerInfo,threshold,starting_latter);
        double amount=0;
        for(CustomerInformation c:customerInfo){
            if (c.getCustomer_name().equalsIgnoreCase(cust)) {
                amount=c.getBillAmount();
            }
        }
        logger.info("customer: {} amount {}",cust,amount);

    }

}
