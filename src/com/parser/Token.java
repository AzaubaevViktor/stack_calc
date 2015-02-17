package com.parser;

/**
 * Created by `ktulhy` on 2/17/15.
 */
public class Token {
    public int pos = 0;
    public String str;

    public Token(int pos, String str) {
        this.pos = pos;
        this.str = str;
    }

    public void add(Character ch) {
        str += ch;
    }

    public String toString() {
        return String.format("<%d:%s>", pos, str);
    }
}
