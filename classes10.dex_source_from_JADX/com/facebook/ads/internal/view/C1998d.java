package com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebView;

public class C1998d extends WebView {
    public boolean f14373a;

    public C1998d(Context context) {
        super(context);
    }

    public void destroy() {
        this.f14373a = true;
        super.destroy();
    }
}
