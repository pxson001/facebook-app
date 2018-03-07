package com.facebook.video.server;

import com.facebook.http.common.FbHttpRequest;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: commerce_items */
class NetworkAsyncWriter$1 implements FutureCallback<Void> {
    final /* synthetic */ FbHttpRequest f19491a;
    final /* synthetic */ AsyncWriter$Handler f19492b;
    final /* synthetic */ NetworkAsyncWriter f19493c;

    public void onFailure(Throwable th) {
        String str = NetworkAsyncWriter.a;
        NetworkAsyncWriter.b(this.f19493c, this.f19491a);
        if (!(th instanceof HandleResponseIOException)) {
            this.f19492b.mo1419a(new IOException("Request wasn't executed", th));
        }
    }

    NetworkAsyncWriter$1(NetworkAsyncWriter networkAsyncWriter, FbHttpRequest fbHttpRequest, AsyncWriter$Handler asyncWriter$Handler) {
        this.f19493c = networkAsyncWriter;
        this.f19491a = fbHttpRequest;
        this.f19492b = asyncWriter$Handler;
    }

    public void onSuccess(@Nullable Object obj) {
        NetworkAsyncWriter.b(this.f19493c, this.f19491a);
    }
}
