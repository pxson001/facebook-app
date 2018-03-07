package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.adapters.C1900e;
import com.facebook.ads.internal.adapters.C1900e.C1882a;
import com.facebook.ads.internal.adapters.C1907i.C19051;
import com.facebook.ads.internal.util.C1973a;
import com.facebook.ads.internal.util.C1975b;
import com.facebook.ads.internal.util.C1976c;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1984h;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

public class C1999a extends C1998d {
    public final C19051 f14374a;
    public C1900e f14375b;

    class C1996b extends WebViewClient {
        final /* synthetic */ C1999a f14370a;

        public C1996b(C1999a c1999a) {
            this.f14370a = c1999a;
        }

        public void onReceivedSslError(WebView webView, @NonNull SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C1983g.m14462a()) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.f14370a.f14374a.m14243a(str);
            return true;
        }
    }

    public class C1997c {
        final /* synthetic */ C1999a f14371a;
        private final String f14372b = C1997c.class.getSimpleName();

        public C1997c(C1999a c1999a) {
            this.f14371a = c1999a;
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f14372b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C1983g.m14458a(C1973a.m14441a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!this.f14371a.f14373a) {
                this.f14371a.f14374a.f14017b.f14021c.m14302c();
                if (this.f14371a.f14375b != null) {
                    this.f14371a.f14375b.m14236a();
                }
            }
        }
    }

    public C1999a(Context context, final C19051 c19051, int i) {
        super(context);
        this.f14374a = c19051;
        setWebViewClient(new C1996b(this));
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        C1984h.m14472b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new C1997c(this), "AdControl");
        this.f14375b = new C1900e(getContext(), this, i, new C1882a(this) {
            final /* synthetic */ C1999a f14369b;

            public final void mo700a() {
                c19051.f14017b.mo709c();
            }
        });
    }

    public void destroy() {
        if (this.f14375b != null) {
            this.f14375b.m14237b();
            this.f14375b = null;
        }
        C1984h.m14471a((WebView) this);
        super.destroy();
    }

    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2014428499);
        super.onWindowVisibilityChanged(i);
        if (this.f14374a != null) {
            C19051 c19051 = this.f14374a;
            if (i == 0 && c19051.f14017b.f14026h > 0 && c19051.f14017b.f14027i != null) {
                C1976c.m14446a(C1975b.m14442a(c19051.f14017b.f14026h, c19051.f14017b.f14027i, c19051.f14016a.f14049h));
                c19051.f14017b.f14026h = 0;
                c19051.f14017b.f14027i = null;
            }
        }
        if (i == 0) {
            if (this.f14375b != null) {
                this.f14375b.m14236a();
            }
        } else if (i == 8 && this.f14375b != null) {
            this.f14375b.m14237b();
        }
        LogUtils.g(1384792941, a);
    }
}
