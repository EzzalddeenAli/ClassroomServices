/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
//
//@Entity
//@Table(name = "transactions")
public class BankTransaction extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "TransactionID")
    private Long id;

    @Column(name = "FromAccountNumber")
    private String fromAccountNumber;

    @Column(name = "FromAccountBalance")
    private BigDecimal fromAccountBalance;

    @Column(name = "ToAccountNumber")
    private String toAccountNumber;

    @Column(name = "ToAccountBalance")
    private BigDecimal toAccountBalance;

    @Column(name = "TransactionAmount")
    private BigDecimal transactionAmount;

    @Column(name = "CustomerID")
    private String customerID;

    @Column(name = "TransactionNotes")
    private String notes;

    @Column(name = "CreatedDate")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime createdDate;

    @Column(name = "TransactionDate")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime transactionDate;

    @Column(name = "TransactionType")
    private String transactionType;

    @Column(name = "TransactionCategory")
    private String transactionCategory;

    @Column(name = "CheckNumber")
    private String checkNumber;

    @Column(name = "Status")
    private String status;

    @Column(nullable = true, name = "TransactionEndDate")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime transactionEndDate;

    @Column(nullable = true, name = "TransactionFrequency")
    private String transactionFrequency;

    @Column(nullable = true, name = "RecuranceType")
    private Integer reccuranceType;

    @Column(nullable = true, name = "NoOfInstallments")
    private Integer noOfInstallments;

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.domain.model.AbstractEntity#getId()
     */
    public Long getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.domain.model.AbstractEntity#setId(java.lang.Object)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the from account number.
     * 
     * @return the from account number
     */
    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    /**
     * Sets the from account number.
     * 
     * @param fromAccountNumber
     *            the from account number
     */
    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    /**
     * Gets the from account balance.
     * 
     * @return the from account balance
     */
    public BigDecimal getFromAccountBalance() {
        return fromAccountBalance;
    }

    /**
     * Sets the from account balance.
     * 
     * @param fromAccountBalance
     *            the from account balance
     */
    public void setFromAccountBalance(BigDecimal fromAccountBalance) {
        this.fromAccountBalance = fromAccountBalance;
    }

    /**
     * Gets the to account number.
     * 
     * @return the to account number
     */
    public String getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Sets the to account number.
     * 
     * @param toAccountNumber
     *            the to account number
     */
    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    /**
     * Gets the to account balance.
     * 
     * @return the to account balance
     */
    public BigDecimal getToAccountBalance() {
        return toAccountBalance;
    }

    /**
     * Sets the to account balance.
     * 
     * @param toAccountBalance
     *            the to account balance
     */
    public void setToAccountBalance(BigDecimal toAccountBalance) {
        this.toAccountBalance = toAccountBalance;
    }

    /**
     * Gets the transaction amount.
     * 
     * @return the transaction amount
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the transaction amount.
     * 
     * @param transactionAmount
     *            the transaction amount
     */
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * Gets the customer id.
     * 
     * @return the customer id
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer id.
     * 
     * @param customerID
     *            the customer id
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * Gets the notes.
     * 
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     * 
     * @param notes
     *            the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets the created date.
     * 
     * @return the created date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     * 
     * @param createdDate
     *            the created date
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the transaction date.
     * 
     * @return the transaction date
     */
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the transaction date.
     * 
     * @param transactionDate
     *            the transaction date
     */
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Gets the transaction type.
     * 
     * @return the transaction type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the transaction type.
     * 
     * @param transactionType
     *            the transaction type
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Gets the transaction category.
     * 
     * @return the transaction category
     */
    public String getTransactionCategory() {
        return transactionCategory;
    }

    /**
     * Sets the transaction category.
     * 
     * @param transactionCategory
     *            the transaction category
     */
    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    /**
     * Gets the check number.
     * 
     * @return the check number
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the check number.
     * 
     * @param checkNumber
     *            the check number
     */
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the transaction end date.
     * 
     * @return the transaction end date
     */
    public LocalDateTime getTransactionEndDate() {
        return transactionEndDate;
    }

    /**
     * Sets the transaction end date.
     * 
     * @param transactionEndDate
     *            the transaction end date
     */
    public void setTransactionEndDate(LocalDateTime transactionEndDate) {
        this.transactionEndDate = transactionEndDate;
    }

    /**
     * Gets the transaction frequency.
     * 
     * @return the transaction frequency
     */
    public String getTransactionFrequency() {
        return transactionFrequency;
    }

    /**
     * Sets the transaction frequency.
     * 
     * @param transactionFrequency
     *            the transaction frequency
     */
    public void setTransactionFrequency(String transactionFrequency) {
        this.transactionFrequency = transactionFrequency;
    }

    /**
     * Gets the reccurance type.
     * 
     * @return the reccurance type
     */
    public Integer getReccuranceType() {
        return reccuranceType;
    }

    /**
     * Sets the reccurance type.
     * 
     * @param reccuranceType
     *            the reccurance type
     */
    public void setReccuranceType(Integer reccuranceType) {
        this.reccuranceType = reccuranceType;
    }

    /**
     * Gets the no of installments.
     * 
     * @return the no of installments
     */
    public Integer getNoOfInstallments() {
        return noOfInstallments;
    }

    /**
     * Sets the no of installments.
     * 
     * @param noOfInstallments
     *            the no of installments
     */
    public void setNoOfInstallments(Integer noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

}
