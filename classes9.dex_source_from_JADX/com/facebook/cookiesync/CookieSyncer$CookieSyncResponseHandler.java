package com.facebook.cookiesync;

import android.os.Build.VERSION;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: place_tag_id */
class CookieSyncer$CookieSyncResponseHandler implements ResponseHandler {
    final /* synthetic */ CookieSyncer f6558a;
    private final String f6559b;

    public CookieSyncer$CookieSyncResponseHandler(CookieSyncer cookieSyncer, String str) {
        this.f6558a = cookieSyncer;
        this.f6559b = str;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        if (headers != null) {
            if (this.f6558a.h == null) {
                CookieSyncer.b(this.f6558a);
            }
            for (Header value : headers) {
                this.f6558a.h.setCookie(this.f6559b, value.getValue());
            }
        }
        if (VERSION.SDK_INT >= 21) {
            this.f6558a.h.flush();
        }
        return null;
    }
}
