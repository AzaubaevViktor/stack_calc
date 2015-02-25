package com.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class File {
    public Parser parser;
    public String filename;

    public File(String filename) throws IOException {
        this.filename = filename;
        parser = new Parser();
        int i = 0;
        for (String line: Files.readAllLines(Paths.get(filename))) {
            i++;
            parser.parseLine(i, line);
        }

    }

    public Line[] getLines() {
//        Line[] lines = new Line[parser.lines.size()];
//        parser.lines.toArray(lines);
//        return lines;
        return null;
    }

    public String errorString(Token token, String msg) {
        String line = token.parent.originalLine;
        String indent = "";
        for (int i = 0; i < token.pos; i++) {
            indent += " ";
        }
        for (int i = 0; i < token.str.length(); i++) {
            indent += "^";
        }
        return String.format("%s\n%s %s", line, indent, msg);
    }

    public String toString() {
        return String.format("F`%s`:\n%s", filename, null);
    }
}
