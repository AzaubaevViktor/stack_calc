package com.semantic;


public class SemanticException extends Exception {
    public int line = -1;
    public int pos = -1;
    public String err = "";
    public SemanticException(int line, int pos, String err) {
        this.line = line;
        this.pos = pos;
        this.err = err;
    }
}
