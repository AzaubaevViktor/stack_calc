package com.semantic.commands.push;

import com.interpreter.State;
import com.interpreter.UnknownVariableException;
import com.semantic.Command;


public class Push extends Command {
    boolean isVar;
    String key;
    Float val;

    public Push(String key) {
        isVar = true;
        this.key = key;
    }

    public Push(float val) {
        isVar = false;
        this.val = val;
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
