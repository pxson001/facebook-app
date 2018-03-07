package com.facebook.view.inflation.utils;

import java.util.HashMap;
import java.util.Map;

/* compiled from: location_opt_in_lh_notification_learn_more_tapped */
public class ViewIdentifier {
    public final Map<String, Integer> f9828a = new HashMap();
    public int f9829b = 1;

    public final int m11549b(String str) {
        Integer num = (Integer) this.f9828a.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unrecognized id = " + str);
    }
}
