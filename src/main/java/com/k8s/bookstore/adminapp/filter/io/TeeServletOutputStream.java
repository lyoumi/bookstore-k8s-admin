package com.k8s.bookstore.adminapp.filter.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import org.apache.commons.io.output.TeeOutputStream;

public class TeeServletOutputStream extends ServletOutputStream {

    private final TeeOutputStream targetStream;

    TeeServletOutputStream(OutputStream one, OutputStream two) {
        targetStream = new TeeOutputStream(one, two);
    }

    @Override
    public void write(int arg0) throws IOException {
        targetStream.write(arg0);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        targetStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int off, int len) throws IOException {
        targetStream.write(bytes, off, len);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
        targetStream.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
        targetStream.close();
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
