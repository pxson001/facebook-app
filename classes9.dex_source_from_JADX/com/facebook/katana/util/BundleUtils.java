package com.facebook.katana.util;

import android.os.Bundle;
import java.io.Serializable;

/* compiled from: p2p_mark_sold_button_clicked */
public class BundleUtils {
    public static Bundle m7871a(Object... objArr) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < objArr.length; i += 2) {
            String str = (String) objArr[i];
            Object obj = objArr[i + 1];
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
        return bundle;
    }
}
