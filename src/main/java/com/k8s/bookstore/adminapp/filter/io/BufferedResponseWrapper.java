package com.k8s.bookstore.adminapp.filter.io;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class BufferedResponseWrapper extends HttpServletResponseWrapper {

    private TeeServletOutputStream tee;
    private ByteArrayOutputStream bos;
    private TeePrintWriter teePrintWriter;

    public BufferedResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public String getContent() {
        if (bos != null) {
            return bos.toString();
        } else if (teePrintWriter != null) {
            return teePrintWriter.toString();
        }
        return "";
    }

    public PrintWriter getWriter() throws IOException {
        if (teePrintWriter == null) {
            teePrintWriter = new TeePrintWriter(this.getResponse().getWriter());
        }
        return teePrintWriter;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if (tee == null) {
            bos = new ByteArrayOutputStream();
            tee = new TeeServletOutputStream(this.getResponse().getOutputStream(), bos);
        }
        return tee;
    }

}
