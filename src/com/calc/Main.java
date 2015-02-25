package com.calc;


import com.parser.Line;
import com.parser.Parser;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputStream in;
        boolean systemInput;

        if (args.length < 1) {
            in = System.in;
            systemInput = true;
        } else {
            try {
                in = new FileInputStream(new File(args[0]));
                systemInput = false;
            } catch (FileNotFoundException e) {
                System.out.printf("!E File `%s` not found:\n   %s\n", args[0], e);
                return;
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String lineStr = "";
        Parser parser = new Parser();

        if (systemInput) {
            System.out.print("Interactive mode, Stack Calc v-.-.-\n");
        }

        try {
            while (true) {
                if (systemInput) System.out.print("> ");

                lineStr = reader.readLine();
                if ((null == lineStr) || lineStr.equals("exit")) break;

                Line lineTokens = parser.parseLine(0, lineStr);

                System.out.printf("!D `%s`\n", lineTokens);

            }
        } catch (IOException e) {
            System.out.printf("!E %s\n", e);
        }


    }
}
