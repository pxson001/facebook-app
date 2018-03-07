package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;

public class C1892b {
    public static C1891a m14213a(Context context, Uri uri) {
        String authority = uri.getAuthority();
        return "store".equals(authority) ? uri.getQueryParameter("video_url") != null ? null : new C1893c(context, uri) : "open_link".equals(authority) ? new C1894d(context, uri) : null;
    }
}
