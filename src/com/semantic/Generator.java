package com.semantic;

import com.parser.File;
import com.parser.Line;
import com.parser.Token;
import com.semantic.commands.Push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;


public class Generator {
    Hashtable<String, String> creatorsHashtable = new Hashtable<String, String>();

    public void loadConfig() throws IOException, ConfigErrorException {
        InputStream commandsResources = System.class.getResourceAsStream("/com/semantic/config");
        if (null == commandsResources) {
            throw new IOException();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(commandsResources));
        String lineStr;
        String[] parsedLine;

        while (true) {
            lineStr = reader.readLine();
            if ((null == lineStr) || lineStr.equals("exit")) break;
            parsedLine = lineStr.split(":");
            if (2 != parsedLine.length) {
                throw new ConfigErrorException(lineStr);
            }
            creatorsHashtable.put(parsedLine[0], parsedLine[1]);
        }
    }

    public Command parse(Line lineTokens) throws UnknownCommandException, ClassNotFoundException, IllegalAccessException, InstantiationException, WrongArgumentsException {



        Token[] tokens = lineTokens.getTokens();
        if (!creatorsHashtable.containsKey(tokens[0].str)) {
            throw new UnknownCommandException(tokens[0]);
        }

        Class<?> loaded = Class.forName(creatorsHashtable.get(tokens[0].str));
        Command cmd = (Command) loaded.newInstance();
        cmd.init(lineTokens);
        return cmd;
    }
}