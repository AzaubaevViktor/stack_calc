package com.semantic;

import com.interpreter.State;
import com.interpreter.UnknownVariableException;


public abstract class Command {
    public abstract void calculate(State st) throws UnknownVariableException;
}
