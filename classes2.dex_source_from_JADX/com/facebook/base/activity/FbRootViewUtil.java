package com.facebook.base.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.common.util.ContextUtils;

/* compiled from: profile */
public class FbRootViewUtil {
    public static View m13815a(Context context) {
        FbRootViewOwner fbRootViewOwner = (FbRootViewOwner) ContextUtils.m2500a(context, FbRootViewOwner.class);
        if (fbRootViewOwner != null) {
            return fbRootViewOwner.m13817a();
        }
        return ((Activity) ContextUtils.m2500a(context, Activity.class)).getWindow().getDecorView().findViewById(16908290);
    }

    public static int m13816b(Context context) {
        View a = m13815a(context);
        return a != null ? a.getId() : 16908290;
    }
}
