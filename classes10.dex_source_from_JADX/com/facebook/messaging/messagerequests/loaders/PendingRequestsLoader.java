package com.facebook.messaging.messagerequests.loaders;

import android.support.annotation.Nullable;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsLoader.LoadType;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsLoader.Params;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsLoader.Result;
import com.facebook.messaging.model.folders.FolderName;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: saved_dashboard_filter_canceled */
public class PendingRequestsLoader {
    private static final FolderName f3254a = FolderName.PENDING;
    public final MessageRequestsLoader f3255b;
    @Nullable
    public Callback f3256c;

    /* compiled from: saved_dashboard_filter_canceled */
    public class C05251 implements com.facebook.common.loader.FbLoader.Callback<Params, Result, Throwable> {
        final /* synthetic */ PendingRequestsLoader f3253a;

        public C05251(PendingRequestsLoader pendingRequestsLoader) {
            this.f3253a = pendingRequestsLoader;
        }

        public final void m3166a(Object obj, ListenableFuture listenableFuture) {
            Params params = (Params) obj;
            if (this.f3253a.f3256c == null) {
                return;
            }
            Callback callback;
            if (params.f3234b == LoadType.THREAD_LIST) {
                callback = this.f3253a.f3256c;
            } else if (params.f3234b == LoadType.MORE_THREADS) {
                callback = this.f3253a.f3256c;
            }
        }

        public final void m3167a(Object obj, Object obj2) {
            Result result = (Result) obj2;
            if (this.f3253a.f3256c != null) {
                Callback callback = this.f3253a.f3256c;
            }
        }

        public final void m3168b(Object obj, Object obj2) {
            Params params = (Params) obj;
            if (this.f3253a.f3256c == null) {
                return;
            }
            Callback callback;
            if (params.f3234b == LoadType.THREAD_LIST) {
                callback = this.f3253a.f3256c;
            } else if (params.f3234b == LoadType.MORE_THREADS) {
                callback = this.f3253a.f3256c;
            }
        }

        public final void m3169c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            if (this.f3253a.f3256c != null) {
                Callback callback = this.f3253a.f3256c;
            }
        }
    }

    /* compiled from: saved_dashboard_filter_canceled */
    public interface Callback {
    }

    private static PendingRequestsLoader m3170b(InjectorLike injectorLike) {
        return new PendingRequestsLoader(MessageRequestsLoader.m3157b(injectorLike));
    }

    @Inject
    public PendingRequestsLoader(MessageRequestsLoader messageRequestsLoader) {
        this.f3255b = messageRequestsLoader;
        this.f3255b.m3159a(new C05251(this));
    }
}
