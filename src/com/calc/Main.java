package com.calc;
import com.parser.Parser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser();
        parser.parse(0, "V rot ebal lalka");

        System.out.print(parser.lines);
    }
}
