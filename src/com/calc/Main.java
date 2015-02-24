package com.calc;


import com.parser.File;
import com.semantic.Generator;
import com.semantic.UnknownCommandException;
import com.semantic.WrongArgumentsException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws UnknownCommandException, WrongArgumentsException {
	// write your code here
        File file;
        if (args.length < 1) {
            System.out.print("!E Use: stack_calc filename");
            return;
        }

        try {
            file = new File(args[0]);
        } catch (IOException e) {
            System.out.printf("Error open file `%s`:\n!E %s", args[0], e);
            return;
        }

        System.out.print(file);
        System.out.print("\n");

        Generator generator;
        try {
            generator = new Generator(file);
        } catch (UnknownCommandException e) {
            System.out.print(file.errorString(e.token, "!E Unknown command"));
        } catch (WrongArgumentsException e) {
            // TODO: Сделать нормальную обработку
            System.out.print("WATAFUCK ARGUMENT");
        }


    }
}
