package org.vufind.util;

import java.util.Arrays;
import org.solrmarc.callnum.DeweyCallNumber;
import java.lang.NullPointerException;

public class DeweyCallNormalizer implements Normalizer {
    @Override
    public byte[] normalize(String s)
    {
        try {
            DeweyCallNumber dewey = new DeweyCallNumber(s);
            String n = dewey.getShelfKey();
            Utils.logInfo("Normalized: " + s + " to: " + n);
            byte[] key = n.getBytes();
            //Utils.logInfo("Normalizer Returning: " + Arrays.toString(key));
            return key;
        }
        catch (NullPointerException E) {
            Utils.logInfo("DeweyCallNormalizer could not return a value for " + s);
            return null;
        }
    }

}
