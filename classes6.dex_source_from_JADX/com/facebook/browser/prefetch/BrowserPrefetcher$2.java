package com.facebook.browser.prefetch;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Strings;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: privacy_scope_edit */
class BrowserPrefetcher$2 implements Callable<Boolean> {
    final /* synthetic */ String f7423a;
    final /* synthetic */ BrowserPrefetcher f7424b;

    BrowserPrefetcher$2(BrowserPrefetcher browserPrefetcher, String str) {
        this.f7424b = browserPrefetcher;
        this.f7423a = str;
    }

    public Object call() {
        Object obj;
        HttpFutureWrapper httpFutureWrapper = null;
        int i = 0;
        String str = this.f7423a;
        long uptimeMillis = SystemClock.uptimeMillis();
        FbHttpRequest fbHttpRequest = null;
        Future future = null;
        String str2 = str;
        while (str2 != null) {
            try {
                if (!this.f7424b.b(Uri.parse(str2))) {
                    break;
                }
                fbHttpRequest = BrowserPrefetcher.d(this.f7424b, this.f7423a, str2, false);
                httpFutureWrapper = this.f7424b.h.b(fbHttpRequest);
                future = httpFutureWrapper.a();
                str = (String) FutureDetour.a(future, 274924660);
                if (Strings.isNullOrEmpty(str)) {
                    this.f7424b.e.a(this.f7423a, SystemClock.uptimeMillis() - uptimeMillis, i, true);
                    obj = Boolean.TRUE;
                    if (!(future == null || future.isDone())) {
                        fbHttpRequest.a().abort();
                        httpFutureWrapper.b();
                        BrowserPrefetcher.k();
                    }
                } else if (i >= 30) {
                    this.f7424b.e.a(this.f7423a, SystemClock.uptimeMillis() - uptimeMillis, i, false);
                    obj = Boolean.FALSE;
                    if (!(future == null || future.isDone())) {
                        fbHttpRequest.a().abort();
                        httpFutureWrapper.b();
                        BrowserPrefetcher.k();
                    }
                } else {
                    i++;
                    str2 = BrowserPrefetcher.b(str2, str);
                }
                return obj;
            } catch (Throwable th) {
                r1 = httpFutureWrapper;
                r2 = fbHttpRequest;
                r3 = future;
                Future future2;
                if (!(future2 == null || future2.isDone())) {
                    HttpFutureWrapper httpFutureWrapper2;
                    FbHttpRequest fbHttpRequest2;
                    fbHttpRequest2.a().abort();
                    httpFutureWrapper2.b();
                    BrowserPrefetcher.k();
                }
            }
        }
        this.f7424b.e.a(this.f7423a, SystemClock.uptimeMillis() - uptimeMillis, i, false);
        obj = Boolean.FALSE;
        if (!(future == null || future.isDone())) {
            fbHttpRequest.a().abort();
            httpFutureWrapper.b();
            BrowserPrefetcher.k();
        }
        return obj;
    }
}
