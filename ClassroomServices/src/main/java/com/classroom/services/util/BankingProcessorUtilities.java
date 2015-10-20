/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.joda.time.LocalDateTime;


public class BankingProcessorUtilities {

    /**
     * Gets the masked account number.
     * 
     * @param accountNumber
     *            the account number
     * @param maskingCharacter
     *            the masking character
     * @param noOfMaskingCharactersFromLeft
     *            the no of masking characters from left
     * @param noOfCharactersToDisplayFromRight
     *            the no of characters to display from right
     * @return the masked account number
     */
    public static String getMaskedAccountNumber(String accountNumber,
            String maskingCharacter, int noOfMaskingCharactersFromLeft,
            int noOfCharactersToDisplayFromRight) {
        String repeatX = "";
        for (int i = 0; i < noOfMaskingCharactersFromLeft; i++) {
            repeatX = repeatX.concat(maskingCharacter);

        }
        accountNumber = repeatX.concat(accountNumber.substring(accountNumber.length()
                - noOfCharactersToDisplayFromRight));
        return accountNumber;
    }

    /**
     * Compare two given dates without time.
     * 
     * @param date1
     *            the date1
     * @param date2
     *            the date2
     * @return the int
     */
    public static int compareDateWithoutTime(LocalDateTime date1,
            LocalDateTime date2) {
        int flag = 0;
        Date dt1 = date1.toDate();
        Date dt2 = date2.toDate();
        SimpleDateFormat sdfWithoutTime = new SimpleDateFormat("MM/dd/yyyy");
        try {
            dt1 = sdfWithoutTime.parse(sdfWithoutTime.format(dt1));
            dt2 = sdfWithoutTime.parse(sdfWithoutTime.format(dt2));
            if (dt1.getTime() < dt2.getTime()) {
                flag = -1;
            } else if (dt1.getTime() > dt2.getTime()) {
                flag = 1;
            }
        } catch (ParseException e) {
            flag = 0;
        }
        return flag;
    }

    /**
     * Encode base64.
     * 
     * @param data
     *            the data
     * @return the string
     */
    public static String encodeBase64(String data) {
        byte[] encoded = Base64.encodeBase64(data.getBytes());
        return new String(encoded);
    }

    /**
     * Decode base64.
     * 
     * @param encryptedData
     *            the encrypted data
     * @return the string
     */
    public static String decodeBase64(String encryptedData) {
        byte[] decoded = Base64.decodeBase64(encryptedData);
        return new String(decoded);
    }

    /**
     * Encrypt.
     * 
     * @param data
     *            the data
     * @return the string
     */
    public static String encrypt(String data) {
        return encodeBase64(data);
    }

    /**
     * Decrypt.
     * 
     * @param encryptedData
     *            the encrypted data
     * @return the string
     */
    public static String decrypt(String encryptedData) {
        return decodeBase64(encryptedData);
    }
}
