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
        Log.info("Normalizing: " + s);
        try {
            // there's a bug!
            // https://groups.google.com/forum/#!topic/solrmarc-tech/1oXBjl4JoAU
            // workaround is to insert a space between the class letters and numbers (not sure why this works, though).
            //String n = CallNumUtils.getLCShelfkey(s, null);
            LCCallNumber lccn = new LCCallNumber(s);
            String n = lccn.getShelfKey();
            Log.info("Normalized: " + lccn.toString() + " to: " + n);
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
