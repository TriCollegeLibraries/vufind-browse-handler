package org.vufind.util;

import java.util.logging.Logger;
public class Utils
{
    public static String getEnvironment (String var)
    {
        return (System.getenv (var) != null) ?
            System.getenv (var) : System.getProperty (var.toLowerCase ());
    }

    private static Logger log ()
    {
        // Caller's class
        return Logger.getLogger
            (new Throwable().getStackTrace()[2].getClassName());
    }

    public static void logInfo (String s) { log().info(s); }
}
