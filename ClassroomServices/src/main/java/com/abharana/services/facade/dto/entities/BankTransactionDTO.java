/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto.entities;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDateTime;

import com.abharana.services.web.dto.mappers.LocalDateTimeAdapter;


@XmlRootElement(name = "Transaction")
public class BankTransactionDTO extends AbstractDTO<Long> {
    private Long id;
    private String fromAccountNumberMasked;
    private BigDecimal fromAccountBalance;
    private String toAccountNumberMasked;
    private BigDecimal toAccountBalance;
    private BigDecimal transactionAmount;
    private String customerID;
    private String notes;
    private LocalDateTime createdDate;
    private LocalDateTime transactionDate;
    private String transactionType;
    private String transactionCategory;
    private String checkNumber;
    private String status;
    private LocalDateTime transactionEndDate;
    private String transactionFrequency;
    private Integer reccuranceType;
    private Integer noOfInstallments;

    /**
     * Gets the pkey.
     * 
     * @return the pkey
     */
    public Long getPkey() {
        return id;
    }

    /**
     * Sets the pkey.
     * 
     * @param pkey
     *            the pkey
     */
    public void setPkey(Long pkey) {
        this.id = pkey;
    }

    /**
     * Gets the from account number masked.
     * 
     * @return the from account number masked
     */
    public String getFromAccountNumberMasked() {
        return fromAccountNumberMasked;
    }

    /**
     * Sets the from account number masked.
     * 
     * @param fromAccountNumber
     *            the from account number masked
     */
    public void setFromAccountNumberMasked(String fromAccountNumber) {
        this.fromAccountNumberMasked = fromAccountNumber;
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
     * Gets the to account number masked.
     * 
     * @return the to account number masked
     */
    public String getToAccountNumberMasked() {
        return toAccountNumberMasked;
    }

    /**
     * Sets the to account number masked.
     * 
     * @param toAccountNumber
     *            the to account number masked
     */
    public void setToAccountNumberMasked(String toAccountNumber) {
        this.toAccountNumberMasked = toAccountNumber;
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
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
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
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
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
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
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
