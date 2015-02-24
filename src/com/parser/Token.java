package com.parser;

import static com.parser.TokenType.*;


public class Token {
    public int line = 0;
    public int pos = 0;
    public TokenType type = UNKNOWN;
    public float value = 0;
    public String str;
    Line parent;

    public Token(Line parent, int line, int pos, String str) {
        this.parent = parent;
        this.line = line;
        this.pos = pos;
        this.str = str;
    }

    public boolean isEmpty() {
        return this.str.equals("");
    }

    public void add(Character ch) {
        str += ch;
    }

    public void typecast() {
        try {
            value = Float.parseFloat(str);
            type = FLOAT;
        } catch (NumberFormatException e) {
            type = STRING;
        }
    }

    private char getCharByType() {
        switch (type) {
            case STRING:
                return 'S';
            case FLOAT:
                return 'F';
            default:
                return 'U';
        }
    }

    public String toString() {
        return String.format("T%c%d<%s>", getCharByType(), pos, str);
    }
}
