package com.parser;
import com.parser.Token;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created by `ktulhy` on 2/17/15.
 */
public class Line {
    public long lineN = 0;
    ArrayList<Token> tokens;

    public Line(long lineN) {
        this.lineN = lineN;
        this.tokens = new ArrayList<Token>();
    }

    public Line(long lineN, ArrayList<Token> tokens) {
        this.lineN = lineN;
        this.tokens = tokens;
    }

    public void add(Token token) {
        tokens.add(token);
    }

    public String toString() {
        return String.format("#%d:`%s`#", lineN, tokens);
    }
}
