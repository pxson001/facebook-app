package com.facebook.ads.internal.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.C1975b.C1974a;

public class C1894d extends C1891a {
    private static final String f13981a = C1894d.class.getSimpleName();
    private final Context f13982b;
    private final Uri f13983c;

    public C1894d(Context context, Uri uri) {
        this.f13982b = context;
        this.f13983c = uri;
    }

    public final C1974a mo704a() {
        return C1974a.OPEN_LINK;
    }

    public final void mo705b() {
        C1891a.m14210a(this.f13982b, this.f13983c);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f13983c.getQueryParameter("link")));
        intent.addFlags(268435456);
        try {
            this.f13982b.startActivity(intent);
        } catch (Throwable e) {
            Log.d(f13981a, "Failed to open market url: " + this.f13983c.toString(), e);
        }
    }
}
