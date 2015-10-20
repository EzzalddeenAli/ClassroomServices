/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto.entities;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDateTime;

import com.abharana.services.web.dto.mappers.LocalDateTimeAdapter;


public class AccountDTO extends AbstractDTO<String> {
    private String id;
    private String maskedNumber;
    private String userId;
    private String type;
    private String nickName;
    private String status;
    private Boolean supportBillPay;
    private Boolean supportTransferFrom;
    private Boolean supportTransferTo;
    private BigDecimal availableBalance;
    private BigDecimal currentBalance;
    private BigDecimal interestRate;
    private Boolean displayTransactions;
    private BigDecimal availableCredit;
    private String creditCardType;
    private BigDecimal minimumDue;
    private String accountCategory;
    private LocalDateTime dueDate;

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.facade.dto.entities.AbstractDTO#getId()
     */
    public String getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.dto.entities.AbstractDTO#setId(java.lang.Object)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the user id.
     * 
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     * 
     * @param userId
     *            the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * 
     * @param type
     *            the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the nick name.
     * 
     * @return the nick name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the nick name.
     * 
     * @param nickName
     *            the nick name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * Gets the support bill pay.
     * 
     * @return the support bill pay
     */
    public Boolean getSupportBillPay() {
        return supportBillPay;
    }

    /**
     * Sets the support bill pay.
     * 
     * @param supportBillPay
     *            the support bill pay
     */
    public void setSupportBillPay(Boolean supportBillPay) {
        this.supportBillPay = supportBillPay;
    }

    /**
     * Gets the support transfer from.
     * 
     * @return the support transfer from
     */
    public Boolean getSupportTransferFrom() {
        return supportTransferFrom;
    }

    /**
     * Sets the support transfer from.
     * 
     * @param supportTransferFrom
     *            the support transfer from
     */
    public void setSupportTransferFrom(Boolean supportTransferFrom) {
        this.supportTransferFrom = supportTransferFrom;
    }

    /**
     * Gets the support transfer to.
     * 
     * @return the support transfer to
     */
    public Boolean getSupportTransferTo() {
        return supportTransferTo;
    }

    /**
     * Sets the support transfer to.
     * 
     * @param supportTransferTo
     *            the support transfer to
     */
    public void setSupportTransferTo(Boolean supportTransferTo) {
        this.supportTransferTo = supportTransferTo;
    }

    /**
     * Gets the available balance.
     * 
     * @return the available balance
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the available balance.
     * 
     * @param availableBalance
     *            the available balance
     */
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * Gets the current balance.
     * 
     * @return the current balance
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the current balance.
     * 
     * @param currentBalance
     *            the current balance
     */
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Gets the interest rate.
     * 
     * @return the interest rate
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate.
     * 
     * @param interestRate
     *            the interest rate
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Gets the display transactions.
     * 
     * @return the display transactions
     */
    public Boolean getDisplayTransactions() {
        return displayTransactions;
    }

    /**
     * Sets the display transactions.
     * 
     * @param displayTransactions
     *            the display transactions
     */
    public void setDisplayTransactions(Boolean displayTransactions) {
        this.displayTransactions = displayTransactions;
    }

    /**
     * Gets the available credit.
     * 
     * @return the available credit
     */
    public BigDecimal getAvailableCredit() {
        return availableCredit;
    }

    /**
     * Sets the available credit.
     * 
     * @param availableCredit
     *            the available credit
     */
    public void setAvailableCredit(BigDecimal availableCredit) {
        this.availableCredit = availableCredit;
    }

    /**
     * Gets the credit card type.
     * 
     * @return the credit card type
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * Sets the credit card type.
     * 
     * @param creditCardType
     *            the credit card type
     */
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    /**
     * Gets the minimum due.
     * 
     * @return the minimum due
     */
    public BigDecimal getMinimumDue() {
        return minimumDue;
    }

    /**
     * Sets the minimum due.
     * 
     * @param minimumDue
     *            the minimum due
     */
    public void setMinimumDue(BigDecimal minimumDue) {
        this.minimumDue = minimumDue;
    }

    /**
     * Gets the account category.
     * 
     * @return the account category
     */
    public String getAccountCategory() {
        return accountCategory;
    }

    /**
     * Sets the account category.
     * 
     * @param accountCategory
     *            the account category
     */
    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    /**
     * Gets the due date.
     * 
     * @return the due date
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date.
     * 
     * @param dueDate
     *            the due date
     */
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the masked number.
     * 
     * @return the masked number
     */
    public String getMaskedNumber() {
        return maskedNumber;
    }

    /**
     * Sets the masked number.
     * 
     * @param maskedNumber
     *            the masked number
     */
    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

}
