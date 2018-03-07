package com.facebook.katana.fragment;

import com.facebook.debug.tracer.Tracer;

/* compiled from: feed_fetch_followup_feed_unit */
public class FbChromeFragment$3 implements Runnable {
    final /* synthetic */ FbChromeFragment f11885a;

    public FbChromeFragment$3(FbChromeFragment fbChromeFragment) {
        this.f11885a = fbChromeFragment;
    }

    public void run() {
        Tracer.b("FbChromeFragment Preload");
        this.f11885a.a(true);
    }
}
