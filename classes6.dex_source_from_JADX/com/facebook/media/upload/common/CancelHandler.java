package com.facebook.media.upload.common;

import com.facebook.fbuploader.FbUploaderImpl;
import com.facebook.fbuploader.FbUploaderImpl.FbUploadJobHandleImpl;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.http.protocol.HttpRequestAbortHandler;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: keywordSource */
public class CancelHandler {
    public final HttpRequestAbortHandler f11914a = new HttpRequestAbortHandler();
    private final FbUploaderImpl f11915b;
    private boolean f11916c = false;
    public FbUploadJobHandleImpl f11917d;

    @Inject
    public CancelHandler(FbUploaderSingletonWrapper fbUploaderSingletonWrapper) {
        this.f11915b = fbUploaderSingletonWrapper.f10102a;
    }

    public final HttpRequestAbortHandler m18857a() {
        return this.f11914a;
    }

    public final synchronized void m18859b() {
        if (!this.f11916c) {
            this.f11916c = true;
            this.f11914a.a();
            if (this.f11917d != null) {
                this.f11915b.m15755a(this.f11917d);
            }
        }
    }

    public final void m18858a(String str) {
        if (Thread.currentThread().isInterrupted()) {
            m18859b();
        }
        if (this.f11916c) {
            throw new CancellationException(str);
        }
    }
}
