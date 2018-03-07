package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.util.C1991o;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.ads.internal.view.C1998d;
import java.util.Collections;
import java.util.Map;

public class C1914m extends C1896b {
    public static final String f14053b = C1914m.class.getSimpleName();
    public final C1998d f14054c;
    public C1912l f14055d;
    private boolean f14056e;

    class C19131 implements Runnable {
        final /* synthetic */ C1914m f14052a;

        C19131(C1914m c1914m) {
            this.f14052a = c1914m;
        }

        public void run() {
            if (this.f14052a.f14054c.f14373a) {
                Log.w(C1914m.f14053b, "Webview already destroyed, cannot activate");
            } else {
                this.f14052a.f14054c.loadUrl("javascript:" + this.f14052a.f14055d.f14043b);
            }
        }
    }

    public C1914m(Context context, C1998d c1998d, C1885c c1885c) {
        super(context, c1885c);
        this.f14054c = c1998d;
    }

    protected final void mo734b() {
        if (this.f14055d != null) {
            if (!(this.f14054c == null || C1994r.m14486a("facebookAd.sendImpression();"))) {
                if (this.f14054c.f14373a) {
                    Log.w(f14053b, "Webview already destroyed, cannot send impression");
                } else {
                    this.f14054c.loadUrl("javascript:" + "facebookAd.sendImpression();");
                }
            }
            Map singletonMap = Collections.singletonMap("evt", "native_imp");
            if (this.f14055d != null) {
                if (!C1994r.m14486a(this.f14055d.f14044c)) {
                    new C1991o(singletonMap).execute(new String[]{r3});
                }
            }
        }
    }

    public final synchronized void m14302c() {
        if (!(this.f14056e || this.f14055d == null)) {
            this.f14056e = true;
            if (!(this.f14054c == null || C1994r.m14486a(this.f14055d.m14300e()))) {
                this.f14054c.post(new C19131(this));
            }
        }
    }
}
