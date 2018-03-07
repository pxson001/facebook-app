package com.facebook.crudolib.netengine.fbhttp;

import com.facebook.crudolib.netengine.HttpHeaders;
import org.apache.http.Header;
import org.apache.http.HttpMessage;

/* compiled from: TincanCacheServiceHandler */
public abstract class FbHttpHeaders implements HttpHeaders {
    private volatile HttpMessage f24059a;
    private volatile Header[] f24060b;

    FbHttpHeaders() {
    }

    public final void m26005a(HttpMessage httpMessage) {
        this.f24059a = httpMessage;
        this.f24060b = httpMessage.getAllHeaders();
    }

    public final int mo1117d() {
        return this.f24060b.length;
    }

    public final String mo1115a(int i) {
        return this.f24060b[i].getName();
    }

    public final String mo1116b(int i) {
        return this.f24060b[i].getValue();
    }
}
