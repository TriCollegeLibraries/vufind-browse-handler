package org.vufind.util;

import java.util.Arrays;
import org.solrmarc.callnum.LCCallNumber;
import java.util.logging.Logger;
import java.lang.NullPointerException;

class Log
{
     private static Logger log ()
     {
         // Caller's class
         return Logger.getLogger
             (new Throwable ().getStackTrace ()[2].getClassName ());
     }
     public static void info (String s) { log ().info (s); }
}

public class LCCallNormalizer implements Normalizer {
    @Override
    public byte[] normalize(String s)
    {
        try {
            LCCallNumber lccn = new LCCallNumber(s);
            String n = lccn.getShelfKey();
            Log.info("Normalized: " + s + " to: " + n);
            byte[] key = n.getBytes();
            //Log.info("Normalizer Returning: " + Arrays.toString(key));
            return key;
        }
        catch (NullPointerException E) {
            Log.info("LCCallNormalizer could not return a value for " + s);
            return null;
        }
    }

}
