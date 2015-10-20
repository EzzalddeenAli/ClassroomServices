/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.authentication.algorithms;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.StringUtils;


/**
 * Password encoder
 * 
 * @author mkol
 * 
 */
public class HMacShaPasswordEncoder implements PasswordEncoder {

    private static final int DEFAULT_ENCRYPTION_STRENGTH = 128;
    private static final String ENCODING_FOR_ENCRYPTION = "UTF-8";

    private boolean encodeHashAsBas64 = false;
    private final String algorithm;

    /**
     * Initializes the ShaPasswordEncoder for SHA-1 strength.
     */
    public HMacShaPasswordEncoder() {
        this(DEFAULT_ENCRYPTION_STRENGTH);
    }

    /**
     * Initialize the ShaPasswordEncoder with a given SHA stength as supported
     * by the JVM EX:
     * <code>HMacShaPasswordEncoder encoder = new HMacShaPasswordEncoder(256);</code>
     * initializes with SHA-256.
     * 
     * @param strength
     *            EX: 1, 256, 384, 512
     */
    public HMacShaPasswordEncoder(int strength) {
        this(strength, false);
    }

    /**
     * The Constructor.
     * 
     * @param strength
     *            the strength
     * @param encodeHashAsBase64
     *            the encode hash as base64
     */
    public HMacShaPasswordEncoder(int strength, boolean encodeHashAsBase64) {
        this("HmacSHA" + strength , encodeHashAsBase64);
    }

    /**
     * The Constructor.
     * 
     * @param algorithm
     *            the algorithm
     * @param encodeHashAsBase64
     *            the encode hash as base64
     */
    public HMacShaPasswordEncoder(String algorithm, boolean encodeHashAsBase64) {
        this.algorithm = algorithm;
        setEncodeHashAsBas64(encodeHashAsBase64);
        // validity Check
        getMac();

    }

    /**
     * Gets the mac.
     * 
     * @return the mac
     * @throws IllegalArgumentException
     *             the illegal argument exception
     */
    protected final Mac getMac() throws IllegalArgumentException {
        try {
            return Mac.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm ["
                    + algorithm + "]", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.authentication.encoding.PasswordEncoder#
     * encodePassword(java.lang.String, java.lang.Object)
     */
    public String encodePassword(String rawDataToBeEncrypted, Object salt) {
        byte[] hmacData = null;
        if (rawDataToBeEncrypted != null) {
            try {
                SecretKeySpec secretKey = new SecretKeySpec(
                        rawDataToBeEncrypted.getBytes(ENCODING_FOR_ENCRYPTION),
                        this.algorithm);
                Mac mac = getMac();
                mac.init(secretKey);
                hmacData = mac.doFinal(salt.toString().getBytes(
                        ENCODING_FOR_ENCRYPTION));

                if (isEncodeHashAsBas64()) {
                    return new String(Base64.encode(hmacData),
                            ENCODING_FOR_ENCRYPTION);
                } else {
                    return new String(hmacData, ENCODING_FOR_ENCRYPTION);
                }

            } catch (InvalidKeyException ike) {
                throw new RuntimeException("Invalid Key while encrypting.", ike);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(
                        "Unsupported Encoding while encrypting.", e);
            }
        }
        return "";

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.authentication.encoding.PasswordEncoder#
     * isPasswordValid(java.lang.String, java.lang.String, java.lang.Object)
     */
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        if (!StringUtils.hasText(encPass) || !StringUtils.hasText(rawPass)) {
            return false;
        }
        String pass1 = "" + encPass;
        String pass2 = encodePassword(rawPass, salt);

        return equals(pass1, pass2);
    }

    /**
     * Checks if is encode hash as bas64.
     * 
     * @return true, if checks if is encode hash as bas64
     */
    public boolean isEncodeHashAsBas64() {
        return encodeHashAsBas64;
    }

    /**
     * Sets the encode hash as bas64.
     * 
     * @param encodeHashAsBas64
     *            the encode hash as bas64
     */
    public void setEncodeHashAsBas64(boolean encodeHashAsBas64) {
        this.encodeHashAsBas64 = encodeHashAsBas64;
    }

    /**
     * Equals.
     * 
     * @param expected
     *            the expected
     * @param actual
     *            the actual
     * @return true, if equals
     */
    private static boolean equals(String expected, String actual) {
        byte[] expectedBytes = null;
        byte[] actualBytes = null;
        try {
            expectedBytes = expected.getBytes(ENCODING_FOR_ENCRYPTION);
            actualBytes = actual.getBytes(ENCODING_FOR_ENCRYPTION);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(
                    "Unsupported Encoding while encrypting.", e);
        }

        int expectedLength = expectedBytes.length;
        int actualLength = actualBytes.length;
        if (expectedLength != actualLength) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < expectedLength; i++) {
            result |= expectedBytes[i] ^ actualBytes[i];
        }
        return result == 0;
    }
}
