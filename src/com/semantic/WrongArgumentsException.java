package com.semantic;

public class WrongArgumentsException extends Exception {
    public boolean toMany = false;
    public boolean toFew = false;
    public int incorrect = -1;
    public WrongArgumentsException(boolean isToMany,
                                   boolean isToFew,
                                   int nIncorrect) {
        toMany = isToMany;
        toFew = isToFew;
        incorrect = nIncorrect;
    }
}
