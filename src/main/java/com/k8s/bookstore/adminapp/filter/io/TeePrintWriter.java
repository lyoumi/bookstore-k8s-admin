package com.k8s.bookstore.adminapp.filter.io;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TeePrintWriter extends PrintWriter {

    private StringWriter branch;

    public TeePrintWriter(PrintWriter main) {
        super(main, true);
        this.branch = new StringWriter();
    }

    @Override
    public void write(char[] buf, int off, int len) {
        super.write(buf, off, len);
        branch.write(buf, off, len);
    }

    @Override
    public void write(String str, int off, int len) {
        super.write(str, off, len);
        branch.write(str, off, len);
    }

    @Override
    public void write(int integer) {
        super.write(integer);
        branch.write(integer);
    }

    @Override
    public void flush() {
        super.flush();
        branch.flush();
    }

    public String toString() {
        return branch.toString();
    }
}
