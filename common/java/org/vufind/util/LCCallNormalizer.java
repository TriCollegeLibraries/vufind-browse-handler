package org.vufind.util;

import java.util.Arrays;
import org.solrmarc.callnum.LCCallNumber;
import java.lang.NullPointerException;

public class LCCallNormalizer implements Normalizer {
    @Override
    public byte[] normalize(String s)
    {
        try {
            LCCallNumber lccn = new LCCallNumber(s);
            String n = lccn.getShelfKey();
            Utils.logInfo("Normalized: " + s + " to: " + n);
            byte[] key = n.getBytes();
            //Utils.logInfo("Normalizer Returning: " + Arrays.toString(key));
            return key;
        }
        catch (NullPointerException E) {
            Utils.logInfo("LCCallNormalizer could not return a value for " + s);
            return null;
        }
    }

}
