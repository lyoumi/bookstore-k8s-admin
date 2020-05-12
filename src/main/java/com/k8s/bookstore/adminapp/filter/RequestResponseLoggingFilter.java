package com.k8s.bookstore.adminapp.filter;

import static java.lang.String.format;

import com.k8s.bookstore.adminapp.filter.io.BufferedRequestWrapper;
import com.k8s.bookstore.adminapp.filter.io.BufferedResponseWrapper;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//TODO: make it configurable
@Slf4j
@Component
public class RequestResponseLoggingFilter implements Filter {

    private static final String BODY_TEMPLATE = "Body: %s%s";
    private static final String CORRELATION_ID = "correlationId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
        BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);

        populateCorrelationIdFromRequest(bufferedRequest, bufferedResponse);

        traceRequest(httpServletRequest, bufferedRequest);

        chain.doFilter(bufferedRequest, bufferedResponse);

        traceResponse(httpServletRequest, bufferedResponse);
    }

    private void populateCorrelationIdFromRequest(BufferedRequestWrapper bufferedRequest,
        BufferedResponseWrapper bufferedResponse) {
        bufferedResponse.addHeader(CORRELATION_ID, bufferedRequest.getHeader(CORRELATION_ID));
    }

    protected void traceRequest(HttpServletRequest httpServletRequest,
        BufferedRequestWrapper bufferedRequest) {
        log.info("Incoming HTTP(s) request: {} {}{} {}Headers: {}",
            httpServletRequest.getMethod(), httpServletRequest.getRequestURI(),
            getRequestParams(httpServletRequest),
            getRequestBody(bufferedRequest), getHeaders(bufferedRequest));
    }

    protected void traceResponse(HttpServletRequest httpServletRequest,
        BufferedResponseWrapper bufferedResponse) {
        log.info("Outgoing HTTP(s) response: '{}' from {} {} {}Headers: {}",
            bufferedResponse.getStatus(), httpServletRequest.getMethod(),
            httpServletRequest.getRequestURI(),
            getResponseBody(bufferedResponse), getHeaders(bufferedResponse));
    }

    protected String getRequestParams(HttpServletRequest httpServletRequest) {
        List<String> requestParams = httpServletRequest.getParameterMap().entrySet()
            .stream()
            .map(stringEntry -> format("%s : %s", stringEntry.getKey(),
                Arrays.toString(stringEntry.getValue())))
            .collect(Collectors.toList());
        return requestParams.isEmpty() ? ""
            : format(" with params: %s", String.join(", ", requestParams));
    }

    protected Map<String, Collection<String>> getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, Collection<String>> headers = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, Collections.list(request.getHeaders(headerName)));
        }
        return headers;
    }

    protected Map<String, Collection<String>> getHeaders(HttpServletResponse response) {
        Collection<String> headerNames = response.getHeaderNames();
        return headerNames.stream()
            .collect(Collectors.toMap(headerName -> headerName, response::getHeaders, (a, b) -> b));
    }

    private String getRequestBody(BufferedRequestWrapper bufferedRequest) {
        String requestBody = getRequestBodyContent(bufferedRequest);
        return format(BODY_TEMPLATE, requestBody, System.lineSeparator());
    }

    private String getRequestBodyContent(BufferedRequestWrapper bufferedRequest) {
        return bufferedRequest.getRequestBody();
    }

    private String getResponseBody(BufferedResponseWrapper bufferedResponse) {
        String responseBody = getResponseBodyContent(bufferedResponse);
        return format(BODY_TEMPLATE, responseBody, System.lineSeparator());
    }

    private String getResponseBodyContent(BufferedResponseWrapper bufferedResponse) {
        return bufferedResponse.getContent();
    }
}
