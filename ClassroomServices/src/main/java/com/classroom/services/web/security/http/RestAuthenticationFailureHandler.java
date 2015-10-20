/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import com.classroom.services.web.dto.response.ErrorResponse;


public class RestAuthenticationFailureHandler implements
        AuthenticationFailureHandler {
    private List<HttpMessageConverter<?>> messageConverters;

    /**
     * Sets the message converters.
     * 
     * @param messageConverters
     *            the message converters
     */
    public void setMessageConverters(
            List<HttpMessageConverter<?>> messageConverters) {
        this.messageConverters = messageConverters;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.AuthenticationFailureHandler
     * #onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.AuthenticationException)
     */
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        HttpInputMessage inputMessage = createHttpInputMessage(request);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        HttpOutputMessage outputMessage = createHttpOutputMessage(response);
        ErrorResponse error = new ErrorResponse(exception.getMessage());
        writeWithMessageConverters(error, inputMessage, outputMessage);
    }

    /**
     * Write with message converters.
     * 
     * @param returnValue
     *            the return value
     * @param inputMessage
     *            the input message
     * @param outputMessage
     *            the output message
     * @throws IOException
     *             the IO exception
     * @throws HttpMediaTypeNotAcceptableException
     *             the http media type not acceptable exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void writeWithMessageConverters(Object returnValue,
            HttpInputMessage inputMessage, HttpOutputMessage outputMessage)
            throws IOException, HttpMediaTypeNotAcceptableException {
        List<MediaType> acceptedMediaTypes = inputMessage.getHeaders()
                .getAccept();
        if (acceptedMediaTypes.isEmpty()) {
            acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
        }
        MediaType.sortByQualityValue(acceptedMediaTypes);
        Class<?> returnValueType = returnValue.getClass();
        List<MediaType> allSupportedMediaTypes = new ArrayList<MediaType>();
        for (MediaType acceptedMediaType : acceptedMediaTypes) {
            for (HttpMessageConverter messageConverter : messageConverters) {
                if (messageConverter.canWrite(returnValueType,
                        acceptedMediaType)) {
                    messageConverter.write(returnValue, acceptedMediaType,
                            outputMessage);
                    return;
                }
            }
        }
        for (HttpMessageConverter messageConverter : messageConverters) {
            allSupportedMediaTypes.addAll(messageConverter
                    .getSupportedMediaTypes());
        }
        throw new HttpMediaTypeNotAcceptableException(allSupportedMediaTypes);
    }

    /**
     * Creates the http input message.
     * 
     * @param servletRequest
     *            the servlet request
     * @return the http input message
     */
    private HttpInputMessage createHttpInputMessage(
            HttpServletRequest servletRequest) {
        return new ServletServerHttpRequest(servletRequest);
    }

    /**
     * Creates the http output message.
     * 
     * @param servletResponse
     *            the servlet response
     * @return the http output message
     */
    private HttpOutputMessage createHttpOutputMessage(
            HttpServletResponse servletResponse) {
        return new ServletServerHttpResponse(servletResponse);
    }
}
