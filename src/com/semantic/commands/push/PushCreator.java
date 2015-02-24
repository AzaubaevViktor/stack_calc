package com.semantic.commands.push;

import com.parser.Line;
import com.parser.Token;
import com.parser.TokenType;
import com.semantic.Command;
import com.semantic.CommandCreator;
import com.semantic.WrongArgumentsException;


public class PushCreator extends CommandCreator {
    @Override
    public String commandName() {
        return "PUSH";
    }

    @Override
    public Command lineHandler(Line line) throws WrongArgumentsException{
        Token[] arr = new Token[line.tokens.size()];
        line.tokens.toArray(arr);

        if (2 > arr.length) {
            throw new WrongArgumentsException(true, false, -1);
        } else if (2 < arr.length) {
            throw new WrongArgumentsException(false, true, -1);
        }

        if (TokenType.STRING == arr[1].type) {
            return new Push(arr[1].str);
        } else {
            return new Push(arr[1].value);
        }
    }

}


