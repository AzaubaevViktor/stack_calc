package com.interpreter;

import java.util.*;

public class State {
    public Stack<Float> stack = new Stack<Float>();
    private Hashtable<String, Float> variables = new Hashtable<String, Float>();

    public void addVariable (String k, Float v) {
        variables.put(k, v);
    }

    public Float getVariable (String k) throws UnknownVariableException {
        if (!variables.containsKey(k)) {
            throw new UnknownVariableException();
        }
        return variables.get(k);
    }
}
