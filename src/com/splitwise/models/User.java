package com.splitwise.models;

import com.splitwise.exceptions.InvalidUserNameException;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class User extends Auditable{


    private String fullName;
    private String hashedSaltedPassword;
    private String phoneNumber;
    private String userName;

    private List<Expense> expenses;
    private List<Group> groups;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHashedSaltedPassword() {
        return hashedSaltedPassword;
    }

    public void setHashedSaltedPassword(String hashedSaltedPassword) {
        this.hashedSaltedPassword = hashedSaltedPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.length()<2){
            throw new InvalidUserNameException("Length is too small");
        }
        this.userName = userName;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


    public double getTotalAmount(){
         double sum=0;
        for(Expense expense:expenses){
            sum += expense.getTotalAmount();
        }
        return sum;
    }
}
