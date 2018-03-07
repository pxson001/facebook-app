package com.facebook.photos.upload.constants;

import com.facebook.bitmaps.Dimension;

/* compiled from: graph_search_v2_spelling_correction_escape */
public class PhotoProcessingConstantsUtils {
    public static boolean m21272a(Dimension dimension) {
        int i = 960;
        int i2;
        if (dimension.b >= dimension.a && dimension.b > 960) {
            i2 = (dimension.a * 960) / dimension.b;
        } else if (dimension.a < dimension.b || dimension.a <= 960) {
            i = dimension.b;
            i2 = dimension.a;
        } else {
            i = (dimension.b * 960) / dimension.a;
            i2 = 960;
        }
        if (i < 400 || r0 < 150) {
            return false;
        }
        return true;
    }
}
