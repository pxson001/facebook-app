package com.facebook.photos.upload.uploaders;

import com.facebook.fbuploader.FbUploader.FbUploadJobHandle;
import com.facebook.fbuploader.FbUploaderImpl;
import com.facebook.fbuploader.FbUploaderImpl.FbUploadJobHandleImpl;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.http.protocol.HttpRequestAbortHandler;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: friends_sticky */
public class MediaUploadCancelHandler {
    private static final Class<?> f14348c = MediaUploadCancelHandler.class;
    private ArrayList<FbUploadJobHandle> f14349a;
    private final FbUploaderImpl f14350b;
    @GuardedBy("this for writes")
    public volatile boolean f14351d;
    @GuardedBy("this")
    private volatile boolean f14352e;
    private HttpRequestAbortHandler f14353f;
    private ListenableFuture<VideoResizeResult> f14354g;

    public static MediaUploadCancelHandler m21997b(InjectorLike injectorLike) {
        return new MediaUploadCancelHandler(FbUploaderSingletonWrapper.m15786a(injectorLike));
    }

    @Inject
    public MediaUploadCancelHandler(FbUploaderSingletonWrapper fbUploaderSingletonWrapper) {
        this.f14349a = null;
        this.f14351d = false;
        this.f14352e = true;
        this.f14353f = new HttpRequestAbortHandler();
        if (fbUploaderSingletonWrapper != null) {
            this.f14350b = fbUploaderSingletonWrapper.f10102a;
        } else {
            this.f14350b = null;
        }
    }

    public MediaUploadCancelHandler() {
        this(null);
    }

    public static MediaUploadCancelHandler m21996a(InjectorLike injectorLike) {
        return m21997b(injectorLike);
    }

    public final synchronized void m21999a() {
        this.f14351d = false;
        this.f14352e = true;
        this.f14353f = new HttpRequestAbortHandler();
    }

    public final void m22002a(ArrayList<FbUploadJobHandle> arrayList) {
        this.f14349a = arrayList;
    }

    public final void m22000a(ListenableFuture<VideoResizeResult> listenableFuture) {
        this.f14354g = listenableFuture;
    }

    public final void m22003b() {
        this.f14354g = null;
    }

    public final synchronized boolean m22005c() {
        boolean z = false;
        synchronized (this) {
            if (this.f14352e) {
                this.f14351d = true;
                if (this.f14354g != null) {
                    z = this.f14354g.cancel(true);
                    String.valueOf(z);
                } else {
                    if (!(this.f14349a == null || this.f14350b == null || this.f14349a.isEmpty())) {
                        synchronized (this.f14349a) {
                            int size = this.f14349a.size();
                            for (int i = 0; i < size; i++) {
                                this.f14350b.m15755a((FbUploadJobHandleImpl) this.f14349a.get(i));
                            }
                        }
                    }
                    z = this.f14353f.a();
                    String.valueOf(z);
                }
            }
        }
        return z;
    }

    public final HttpRequestAbortHandler m22006d() {
        return this.f14353f;
    }

    public final boolean m22007e() {
        return this.f14351d;
    }

    public final void m22001a(String str) {
        if (this.f14351d) {
            m21998c(str);
        }
    }

    public final synchronized void m22004b(String str) {
        this.f14352e = false;
        if (this.f14351d) {
            m21998c(str);
        }
    }

    private static void m21998c(String str) {
        new StringBuilder("Cancelling at ").append(str);
        throw new CancellationException(str);
    }
}
