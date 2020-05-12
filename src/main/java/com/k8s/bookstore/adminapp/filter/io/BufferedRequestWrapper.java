package com.k8s.bookstore.adminapp.filter.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;

public class BufferedRequestWrapper extends HttpServletRequestWrapper {

    private final BufferedServletInputStream bsis;
    private final byte[] clientContent;

    public BufferedRequestWrapper(HttpServletRequest req) throws IOException {
        super(req);
        this.clientContent = IOUtils.toByteArray(req.getInputStream());
        this.bsis = new BufferedServletInputStream(new ByteArrayInputStream(clientContent));
    }

    @Override
    public ServletInputStream getInputStream() {
        return bsis;
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream(), StandardCharsets.UTF_8));
    }

    @SuppressWarnings("squid:S1943")
    public String getRequestBody() {
        return new String(clientContent);
    }

}
