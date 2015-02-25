package com.parser;

import java.lang.Character;

public class Parser {
    public Line parseLine(int lineN, String lineStr) {
        Line line = new Line(lineN, lineStr);

        Character ch;
        Token token = new Token(line, lineN, 0, "");
        for (int pos = 0; pos < lineStr.length(); pos++) {
            ch = lineStr.charAt(pos);

            if (Character.isWhitespace(ch)) {
                line.add(token);
                token = new Token(line, lineN, pos + 1, "");
            } else {
                token.add(ch);
            }
        }

        if (!token.isEmpty()) {
            line.add(token);
        }

        return line;
    }
}
