package com.parser;
import com.parser.Line;

import java.util.ArrayList;

/**
 * Created by `ktulhy` on 2/17/15.
 */


public class Parser {
    public ArrayList<Line> lines;

    public Parser() {
        lines = new ArrayList<Line>();
    }

    public void parse(long lineN, String str) {
        Line line = new Line(lineN);

        Character ch = '\0';
        Token token = new Token(0, "");
        for (int pos = 0; pos < str.length(); pos++) {
            ch = str.charAt(pos);
            if (ch.equals(' ')) {
                line.add(token);
                token = new Token(pos + 1, "");
            } else {
                token.add(ch);
            }
        }
        lines.add(line);
    }
}
