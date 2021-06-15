package com.splitwise.models;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Expense extends Auditable {
    private String description;
    private Set<User> participants;
    private Double totalAmount;
    private Date date;
    private Boolean isSettled;
    private Map<User,Double> paidAmount;
    private Map<User,Double> owedAmount;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group;

    public Expense(Date date, String description,Set<User> participants){
        this.date=date;
        this.description=description;
        this.participants=participants;
    }
    public Expense(String description,Date date,Set<User> participants){
        this.description=description;
        this.date=date;
        this.participants=participants;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSettled() {
        return isSettled;
    }

    public void setSettled(Boolean settled) {
        isSettled = settled;
    }

    public Map<User, Double> getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Map<User, Double> paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Map<User, Double> getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(Map<User, Double> owedAmount) {
        this.owedAmount = owedAmount;
    }
}
