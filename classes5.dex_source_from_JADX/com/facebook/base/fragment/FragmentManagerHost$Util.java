package com.facebook.base.fragment;

import android.content.Context;
import com.facebook.common.util.ContextUtils;

/* compiled from: substory_count */
public class FragmentManagerHost$Util {
    public static FragmentManagerHost m3544a(Context context) {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(context, FragmentManagerHost.class);
        if (fragmentManagerHost != null) {
            return fragmentManagerHost;
        }
        throw new IllegalArgumentException("Context has no associated FragmentManagerHost");
    }
}
