package com.facebook.dracula.runtime.base;

import com.facebook.dracula.api.DraculaHelper;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groups.feed.ui.GroupsFeedFragment.1.1;

/* compiled from: saheli_feed_unit */
public class DraculaRuntime {
    public static boolean m4076a(MutableFlatBuffer mutableFlatBuffer, int i, MutableFlatBuffer mutableFlatBuffer2, int i2) {
        if ((mutableFlatBuffer == null && i != 0) || (mutableFlatBuffer2 == null && i2 != 0)) {
            1 1 = (1) DraculaHelper.f2922a.get();
            if (1 != null) {
                String str;
                StringBuilder append = new StringBuilder(64).append("#11331948 DraculaRuntime.equalEqual(");
                if (mutableFlatBuffer == null) {
                    str = "null";
                } else {
                    str = "b0";
                }
                append = append.append(str).append(", ").append(i).append(", ");
                if (mutableFlatBuffer2 == null) {
                    str = "null";
                } else {
                    str = "b1";
                }
                1.a(append.append(str).append(", ").append(i2).append(")").toString());
            }
        }
        if (i2 == 0 || mutableFlatBuffer2 == null) {
            return i == 0 || mutableFlatBuffer == null;
        } else {
            if (i == 0 || mutableFlatBuffer == null) {
                return false;
            }
            return i == i2 && mutableFlatBuffer == mutableFlatBuffer2;
        }
    }

    public static String m4075a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        if (i == 0) {
            return "null";
        }
        return "(" + mutableFlatBuffer + "," + i + "," + i2 + ")";
    }
}
