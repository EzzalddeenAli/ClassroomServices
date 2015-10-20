/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.controllers.wadl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.classroom.services.web.controllers.wadl.artifact.WadlApplication;
import com.classroom.services.web.controllers.wadl.artifact.WadlDoc;
import com.classroom.services.web.controllers.wadl.artifact.WadlMethod;
import com.classroom.services.web.controllers.wadl.artifact.WadlParam;
import com.classroom.services.web.controllers.wadl.artifact.WadlParamStyle;
import com.classroom.services.web.controllers.wadl.artifact.WadlRepresentation;
import com.classroom.services.web.controllers.wadl.artifact.WadlRequest;
import com.classroom.services.web.controllers.wadl.artifact.WadlResource;
import com.classroom.services.web.controllers.wadl.artifact.WadlResources;
import com.classroom.services.web.controllers.wadl.artifact.WadlResponse;


/**
 * Type name:WadlController.java Description: This Class will be responsible for
 * generation the Web application descriptor file based upon the References:
 * 
 * 
 * 
 * 
 * @author Pankaj Bhatt.
 * @version 1.0, June 2012
 */

@Controller
@RequestMapping()
public class WadlController {

    // @Autowired
    private final RequestMappingHandlerMapping handlerMapping;

    /**
     * Constructor for initializing the Wadl Controller.
     * 
     * @param handlerMapping
     *            the handler mapping
     */
    @Autowired
    public WadlController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    /**
     * This is a function which will be responsible for generating the WADL
     * file.
     * 
     * @param request
     *            : Represents the Request
     * @return WadlApplication : This object will be converted to the WADL File.
     */
    @RequestMapping(value = "wadl.xml", method = RequestMethod.GET, produces = { "application/xml" })
    @ResponseBody
    public WadlApplication generateWadl(HttpServletRequest request) {
        WadlApplication result = new WadlApplication();
        WadlDoc doc = new WadlDoc();
        doc.setTitle("UPS REST Service WADL");
        result.getDoc().add(doc);
        WadlResources wadResources = new WadlResources();
        wadResources.setBase(getBaseUrl(request));

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping
                .getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods
                .entrySet()) {
            WadlResource wadlResource = new WadlResource();

            HandlerMethod handlerMethod = entry.getValue();
            RequestMappingInfo mappingInfo = entry.getKey();

            Set<String> pattern = mappingInfo.getPatternsCondition()
                    .getPatterns();
            Set<RequestMethod> httpMethods = mappingInfo.getMethodsCondition()
                    .getMethods();
            ProducesRequestCondition producesRequestCondition = mappingInfo
                    .getProducesCondition();
            Set<MediaType> mediaTypes = producesRequestCondition
                    .getProducibleMediaTypes();

            for (RequestMethod httpMethod : httpMethods) {
                WadlMethod wadlMethod = new WadlMethod();

                for (String uri : pattern) {
                    wadlResource.setPath(uri);
                }

                wadlMethod.setName(httpMethod.name());
                Method javaMethod = handlerMethod.getMethod();
                wadlMethod.setId(javaMethod.getName());
                WadlDoc wadlDocMethod = new WadlDoc();
                wadlDocMethod.setTitle(javaMethod.getDeclaringClass().getName()
                        + "." + javaMethod.getName());
                wadlMethod.getDoc().add(wadlDocMethod);

                // Request
                WadlRequest wadlRequest = new WadlRequest();

                Annotation[][] annotations = javaMethod
                        .getParameterAnnotations();
                Class[] paramTypes = javaMethod.getParameterTypes();
                int parameterCounter = 0;

                for (Annotation[] annotation : annotations) {
                    for (Annotation annotation2 : annotation) {
                        if (annotation2 instanceof RequestParam) {
                            RequestParam param2 = (RequestParam) annotation2;

                            WadlParam waldParam = new WadlParam();

                            waldParam.setName(param2.value());

                            waldParam.setStyle(WadlParamStyle.QUERY);
                            waldParam.setRequired(param2.required());

                            if (paramTypes != null
                                    && paramTypes.length > parameterCounter) {
                                if (paramTypes.length > parameterCounter
                                        && (paramTypes[parameterCounter] == javax.servlet.http.HttpServletRequest.class || paramTypes[parameterCounter] == javax.servlet.http.HttpServletResponse.class)) {
                                    parameterCounter++;
                                }
                                if (paramTypes.length > parameterCounter
                                        && (paramTypes[parameterCounter] == javax.servlet.http.HttpServletRequest.class || paramTypes[parameterCounter] == javax.servlet.http.HttpServletResponse.class)) {
                                    parameterCounter++;
                                }

                                if (paramTypes.length > parameterCounter) {
                                    waldParam
                                            .setType(getQNameForType(paramTypes[parameterCounter]));
                                    parameterCounter++;
                                }
                            }

                            String defaultValue = cleanDefault(param2
                                    .defaultValue());
                            if (!defaultValue.equals("")) {
                                waldParam.setDefault(defaultValue);
                            }
                            wadlRequest.getParam().add(waldParam);
                        } else if (annotation2 instanceof PathVariable) {
                            PathVariable param2 = (PathVariable) annotation2;

                            WadlParam waldParam = new WadlParam();
                            waldParam.setName(param2.value());
                            waldParam.setStyle(WadlParamStyle.TEMPLATE);
                            waldParam.setRequired(true);
                            if (paramTypes != null
                                    && paramTypes.length > parameterCounter) {
                                if (paramTypes.length > parameterCounter
                                        && (paramTypes[parameterCounter] == javax.servlet.http.HttpServletRequest.class || paramTypes[parameterCounter] == javax.servlet.http.HttpServletResponse.class))
                                    {
                                    parameterCounter++;
                                    }
                                if (paramTypes.length > parameterCounter
                                        && (paramTypes[parameterCounter] == javax.servlet.http.HttpServletRequest.class || paramTypes[parameterCounter] == javax.servlet.http.HttpServletResponse.class))
                                    {
                                    parameterCounter++;
                                    }

                                if (paramTypes.length > parameterCounter) {

                                    waldParam
                                            .setType(getQNameForType(paramTypes[parameterCounter]));
                                    parameterCounter++;
                                }
                            }

                            wadlRequest.getParam().add(waldParam);
                        }
                        if (annotation2 instanceof RequestBody) {
                            WadlRepresentation representation = new WadlRepresentation();
                            representation.setMediaType("application/xml");
                            wadlRequest.getRepresentation().add(representation);
                            representation = new WadlRepresentation();
                            representation.setMediaType("application/json");
                            wadlRequest.getRepresentation().add(representation);
                        } else {
                            parameterCounter++;
                        }
                    }
                }
                wadlMethod.setRequest(wadlRequest);

                // Response
                if (!mediaTypes.isEmpty()) {
                    WadlResponse wadlResponse = new WadlResponse();
                    wadlResponse.getStatus().add(200l);
                    for (MediaType mediaType : mediaTypes) {
                        WadlRepresentation wadlRepresentation = new WadlRepresentation();
                        wadlRepresentation.setMediaType(mediaType.toString());
                        wadlResponse.getRepresentation()
                                .add(wadlRepresentation);
                    }
                    wadlMethod.getResponse().add(wadlResponse);
                }

                wadlResource.getMethodOrResource().add(wadlMethod);

            }

            wadResources.getResource().add(wadlResource);

        }
        result.getResources().add(wadResources);

        return result;
    }

    /**
     * Gets the base url.
     * 
     * @param request
     *            the request
     * @return the base url
     */
    private String getBaseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "" + request.getContextPath();
    }

    /**
     * Clean default.
     * 
     * @param value
     *            the value
     * @return the string
     */
    private String cleanDefault(String value) {
        value = value.replaceAll("\t", "");
        value = value.replaceAll("\n", "");

        value = value.replaceAll("\uE000", "");
        value = value.replaceAll("\uE001", "");
        value = value.replaceAll("\uE002", "");
        return value;
    }

    /**
     * This is an private function, which will return the QName based upon the
     * Java Type.
     * 
     * @param classType
     *            : Represent the type of class
     * @return QName
     */
    private QName getQNameForType(Class classType) {
        QName qName = null;

        /**
         * Check whether the thing that is coming is an Array of a data type or
         * not.
         */
        if (classType.isArray()) {
            classType = classType.getComponentType();
        }

        if (classType == java.lang.Long.class) {
            qName = new QName("http://www.w3.org/2001/XMLSchema", "long");
        } else if (classType == java.lang.Integer.class) {
            qName = new QName("http://www.w3.org/2001/XMLSchema", "integer");
        } else if (classType == java.lang.Double.class) {
            qName = new QName("http://www.w3.org/2001/XMLSchema", "double");
        } else if (classType == java.lang.String.class) {
            qName = new QName("http://www.w3.org/2001/XMLSchema", "string");
        } else if (classType == java.util.Date.class) {
            qName = new QName("http://www.w3.org/2001/XMLSchema", "date");
        }

        return qName;
    }

}
