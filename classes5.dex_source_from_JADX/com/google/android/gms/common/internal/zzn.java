package com.google.android.gms.common.internal;

import android.net.Uri;

public class zzn {
    private static final Uri f6582a;
    private static final Uri f6583b;

    static {
        Uri parse = Uri.parse("http://plus.google.com/");
        f6582a = parse;
        f6583b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
