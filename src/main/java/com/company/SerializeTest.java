package com.company;

import java.beans.Transient;
import java.io.Serializable;

public class SerializeTest implements Serializable {
    transient int f1 = 1;
    static String f2 = "a";
    static String f3 = "#";
    public static final long serialVersionUID = 1L;
}
