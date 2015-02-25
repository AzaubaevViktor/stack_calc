package com.parser;

import java.util.ArrayList;

public class Line {
    public int lineN = 0;
    public ArrayList<Token> tokens;
    public String originalLine;

    public Line(int lineN, String originalLine) {
        this.lineN = lineN;
        this.originalLine = originalLine;
        this.tokens = new ArrayList<Token>();
    }

    public Line(int lineN, String originalLine, ArrayList<Token> tokens) {
        this.lineN = lineN;
        this.originalLine = originalLine;
        this.tokens = tokens;
    }

    public void add(Token token) {
        token.typecast();
        tokens.add(token);
    }

    public Token[] getTokens() {
        Token[] tokensArr = new Token[tokens.size()];
        tokens.toArray(tokensArr);
        return tokensArr;
    }

    public String errorString(Token token, String msg) {
        StringBuffer indent = new StringBuffer();
        for (int i = 0; i < token.pos; i++) {
            indent.append(' ');
        }
        for (int i = 0; i < token.str.length(); i++) {
            indent.append('^');
        }
        return String.format("%s\n%s %s", originalLine, indent, msg);
    }

    public String toString() {
        return String.format("L%d:%s", lineN, tokens);
    }
}
