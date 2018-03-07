package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.internal.util.C1975b.C1974a;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1991o;
import com.facebook.ads.internal.util.C1994r;

public abstract class C1891a {
    protected static void m14210a(Context context, Uri uri) {
        if (!C1994r.m14486a(uri.getQueryParameter("native_click_report_url"))) {
            new C1991o().execute(new String[]{r0});
            C1983g.m14461a(context, "Click logged");
        }
    }

    public abstract C1974a mo704a();

    public abstract void mo705b();
}
