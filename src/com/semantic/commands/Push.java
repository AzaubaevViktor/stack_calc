package com.semantic.commands;

import com.interpreter.State;
import com.interpreter.UnknownVariableException;
import com.parser.Line;
import com.parser.Token;
import com.parser.TokenType;
import com.semantic.Command;
import com.semantic.WrongArgumentsException;


public class Push extends Command {
    boolean isVar;
    String key;
    Float val;

    @Override
    public void init(Line line) throws WrongArgumentsException {
        Token[] arr = new Token[line.tokens.size()];
        line.tokens.toArray(arr);

        if (2 > arr.length) {
            throw new WrongArgumentsException(true, false, arr[3]);
        } else if (2 < arr.length) {
            throw new WrongArgumentsException(false, true, arr[arr.length]);
        }

        if (TokenType.STRING == arr[1].type) {
            isVar = true;
            key = arr[1].str;
        } else {
            isVar = false;
            val = arr[1].value;
        }
    }

    @Override
    public void calculate(State st) throws UnknownVariableException {
        if (isVar) {
            st.stack.push(st.getVariable(key));
        } else {
            st.stack.push(val);
        }
    }
}
