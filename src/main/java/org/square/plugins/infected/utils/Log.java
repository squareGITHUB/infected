package org.square.plugins.infected.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log
{
    private static final Logger log = Logger.getLogger("Minecraft");
    private static final String prefix = "[SMPItems]";

    private static void log(String s, Level l)
    {
        log.log(l, prefix + " " + s);
    }

    public static void info(String s)
    {
        log(s, Level.INFO);
    }

    public static void warn(String s)
    {
        log(s, Level.WARNING);
    }

    public static void severe(String s)
    {
        log(s, Level.SEVERE);
    }
}