package com.semantic;

import com.parser.File;
import com.parser.Line;
import com.parser.Token;
import com.semantic.commands.push.PushCreator;

import java.util.ArrayList;
import java.util.Hashtable;


public class Generator {
    CommandCreator[] commandCreators = {
            new PushCreator()
    };
    Hashtable<String, CommandCreator> creatorsHashtable = new Hashtable<String, CommandCreator>();
    ArrayList<Command> cmds = new ArrayList<Command>();

    public Generator(File file) throws UnknownCommandException, WrongArgumentsException {
        for (CommandCreator creator: commandCreators) {
            creatorsHashtable.put(creator.commandName(), creator);
        }

        for (Line line: file.getLines()) {
            Token[] tokens = line.getTokens();
            if (!creatorsHashtable.containsKey(tokens[0].str)) {
                throw new UnknownCommandException(tokens[0]);
            }
            cmds.add(
                    creatorsHashtable.get(tokens[0].str).lineHandler(line)
            );
        }
    }
}
