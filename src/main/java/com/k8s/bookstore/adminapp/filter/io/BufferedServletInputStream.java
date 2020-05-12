package com.k8s.bookstore.adminapp.filter.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BufferedServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream bais;

    @Override
    public int available() {
        return this.bais.available();
    }

    @Override
    public boolean markSupported() {
        return bais.markSupported();
    }

    @Override
    public void mark(int readAheadLimit) {
        bais.mark(readAheadLimit);
    }

    @Override
    public synchronized void reset() {
        bais.reset();
    }

    @Override
    public void close() throws IOException {
        bais.close();
    }

    @Override
    public int read() {
        return bais.read();
    }

    @Override
    public int read(byte[] buf, int off, int len) {
        return bais.read(buf, off, len);
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return this.bais.read(bytes);
    }

    @Override
    public long skip(long number) {
        return bais.skip(number);
    }

    @Override
    public boolean isFinished() {
        return bais.available() == 0;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
