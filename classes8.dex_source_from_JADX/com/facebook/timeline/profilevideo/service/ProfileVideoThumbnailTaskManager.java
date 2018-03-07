package com.facebook.timeline.profilevideo.service;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.timeline.profilevideo.CallableAndCallbackHolder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mLatitude */
public class ProfileVideoThumbnailTaskManager {
    private final ListeningExecutorService f9397a;
    private final ListeningExecutorService f9398b;
    public CallableAndCallbackHolder<CloseableReference<Bitmap>> f9399c;
    public List<CallableAndCallbackHolder<CloseableReference<Bitmap>>> f9400d = new ArrayList();
    public boolean f9401e = false;
    public boolean f9402f = false;

    /* compiled from: mLatitude */
    public class C09822 implements FutureCallback<CloseableReference<Bitmap>> {
        final /* synthetic */ FutureCallback f9395a;
        final /* synthetic */ ProfileVideoThumbnailTaskManager f9396b;

        public C09822(ProfileVideoThumbnailTaskManager profileVideoThumbnailTaskManager, FutureCallback futureCallback) {
            this.f9396b = profileVideoThumbnailTaskManager;
            this.f9395a = futureCallback;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f9395a.onSuccess((CloseableReference) obj);
            ProfileVideoThumbnailTaskManager.m11157b(this.f9396b);
        }

        public void onFailure(Throwable th) {
            this.f9395a.onFailure(th);
            ProfileVideoThumbnailTaskManager.m11157b(this.f9396b);
        }
    }

    @Inject
    public ProfileVideoThumbnailTaskManager(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2) {
        this.f9397a = listeningExecutorService;
        this.f9398b = listeningExecutorService2;
    }

    public final void m11159a(Callable<CloseableReference<Bitmap>> callable, final FutureCallback<CloseableReference<Bitmap>> futureCallback) {
        this.f9399c = new CallableAndCallbackHolder(callable, new FutureCallback<CloseableReference<Bitmap>>(this) {
            final /* synthetic */ ProfileVideoThumbnailTaskManager f9394b;

            public void onSuccess(@Nullable Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                this.f9394b.f9402f = false;
                futureCallback.onSuccess(closeableReference);
                ProfileVideoThumbnailTaskManager.m11157b(this.f9394b);
            }

            public void onFailure(Throwable th) {
                try {
                    this.f9394b.f9402f = false;
                    futureCallback.onFailure(th);
                } finally {
                    ProfileVideoThumbnailTaskManager.m11157b(this.f9394b);
                }
            }
        });
        if (!this.f9401e) {
            this.f9401e = true;
            m11158c();
        }
    }

    public static void m11157b(ProfileVideoThumbnailTaskManager profileVideoThumbnailTaskManager) {
        if (profileVideoThumbnailTaskManager.f9400d.isEmpty()) {
            profileVideoThumbnailTaskManager.m11158c();
            return;
        }
        CallableAndCallbackHolder callableAndCallbackHolder = (CallableAndCallbackHolder) profileVideoThumbnailTaskManager.f9400d.remove(0);
        Futures.a(profileVideoThumbnailTaskManager.f9397a.a(callableAndCallbackHolder.f9252a), callableAndCallbackHolder.f9253b, profileVideoThumbnailTaskManager.f9398b);
    }

    private void m11158c() {
        if (this.f9399c != null) {
            this.f9402f = true;
            Futures.a(this.f9397a.a(this.f9399c.f9252a), this.f9399c.f9253b, this.f9398b);
            this.f9399c = null;
            return;
        }
        this.f9401e = false;
    }
}
