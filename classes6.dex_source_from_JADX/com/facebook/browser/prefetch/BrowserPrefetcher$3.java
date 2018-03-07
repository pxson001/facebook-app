package com.facebook.browser.prefetch;

import android.net.Uri;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Strings;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: privacy_scope_edit */
class BrowserPrefetcher$3 implements Callable<Boolean> {
    final /* synthetic */ String f7425a;
    final /* synthetic */ boolean f7426b;
    final /* synthetic */ String f7427c;
    final /* synthetic */ BrowserPrefetcher f7428d;

    BrowserPrefetcher$3(BrowserPrefetcher browserPrefetcher, String str, boolean z, String str2) {
        this.f7428d = browserPrefetcher;
        this.f7425a = str;
        this.f7426b = z;
        this.f7427c = str2;
    }

    public Object call() {
        Object obj;
        HttpFutureWrapper httpFutureWrapper = null;
        Future future = null;
        String str = this.f7425a;
        int i = 0;
        FbHttpRequest fbHttpRequest = null;
        while (str != null) {
            try {
                if (!this.f7428d.b(Uri.parse(str))) {
                    break;
                } else if (this.f7426b || !str.equalsIgnoreCase(this.f7427c)) {
                    BrowserPrefetcher.k();
                    fbHttpRequest = BrowserPrefetcher.d(this.f7428d, this.f7425a, str, true);
                    httpFutureWrapper = this.f7428d.h.b(fbHttpRequest);
                    future = httpFutureWrapper.a();
                    String str2 = (String) FutureDetour.a(future, 1176342818);
                    if (Strings.isNullOrEmpty(str2)) {
                        obj = Boolean.TRUE;
                        if (!(future == null || future.isDone())) {
                            fbHttpRequest.a().abort();
                            httpFutureWrapper.b();
                            BrowserPrefetcher.k();
                        }
                    } else if (i >= 30) {
                        obj = Boolean.FALSE;
                        if (!(future == null || future.isDone())) {
                            fbHttpRequest.a().abort();
                            httpFutureWrapper.b();
                            BrowserPrefetcher.k();
                        }
                    } else {
                        i++;
                        str = BrowserPrefetcher.b(str, str2);
                    }
                    return obj;
                } else {
                    BrowserPrefetcher.k();
                    obj = Boolean.TRUE;
                    if (!(future == null || future.isDone())) {
                        fbHttpRequest.a().abort();
                        httpFutureWrapper.b();
                        BrowserPrefetcher.k();
                    }
                    return obj;
                }
            } catch (Throwable th) {
                if (!(future == null || future.isDone())) {
                    fbHttpRequest.a().abort();
                    httpFutureWrapper.b();
                    BrowserPrefetcher.k();
                }
            }
        }
        obj = Boolean.FALSE;
        if (!(future == null || future.isDone())) {
            fbHttpRequest.a().abort();
            httpFutureWrapper.b();
            BrowserPrefetcher.k();
        }
        return obj;
    }
}
