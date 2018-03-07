package com.facebook.video.server;

import com.facebook.common.iolite.BoundedInputStream;
import com.facebook.http.common.FbHttpRequest;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: commerce_items */
class NetworkAsyncWriter$ResponseHandlerImpl implements ResponseHandler<Void> {
    final /* synthetic */ NetworkAsyncWriter f19494a;
    private final boolean f19495b;
    private final long f19496c;
    private final AsyncWriter$Handler f19497d;
    private FbHttpRequest<Void> f19498e;

    /* compiled from: commerce_items */
    class HandleResponseIOException extends IOException {
        public HandleResponseIOException(IOException iOException) {
            super(iOException);
        }
    }

    public Object handleResponse(HttpResponse httpResponse) {
        NetworkAsyncWriter.a(this.f19494a, httpResponse);
        try {
            OutputStream a = this.f19497d.mo1418a(NetworkAsyncWriter.a(httpResponse, this.f19495b));
            if (a != null) {
                try {
                    InputStream boundedInputStream;
                    InputStream content = httpResponse.getEntity().getContent();
                    if (this.f19496c > 0) {
                        boundedInputStream = new BoundedInputStream(content, this.f19496c, false);
                    } else {
                        boundedInputStream = content;
                    }
                    OutputStream a2 = this.f19494a.i.a(a);
                    try {
                        ByteStreams.a(new CheckedInputStream(boundedInputStream), a2);
                        this.f19497d.mo1420a(a, null);
                    } finally {
                        this.f19494a.i.b(a2);
                    }
                } catch (IOException e) {
                    this.f19494a.c.c(this.f19498e);
                    this.f19497d.mo1420a(a, e);
                    throw new HandleResponseIOException(e);
                }
            }
        } catch (IOException e2) {
            this.f19497d.mo1419a(e2);
        }
        return null;
    }

    public NetworkAsyncWriter$ResponseHandlerImpl(NetworkAsyncWriter networkAsyncWriter, boolean z, long j, AsyncWriter$Handler asyncWriter$Handler) {
        this.f19494a = networkAsyncWriter;
        this.f19495b = z;
        this.f19496c = j;
        this.f19497d = asyncWriter$Handler;
    }

    public final void m28240a(FbHttpRequest<Void> fbHttpRequest) {
        this.f19498e = fbHttpRequest;
    }
}
