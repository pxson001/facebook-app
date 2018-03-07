package com.facebook.messaging.messagerequests.loaders;

import android.support.annotation.Nullable;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsLoader.Params;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsLoader.Result;
import com.facebook.messaging.model.folders.FolderName;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: saved_dashboard_imp */
public class OtherRequestsLoader {
    private static final FolderName f3250a = FolderName.OTHER;
    public final MessageRequestsLoader f3251b;
    @Nullable
    public Callback f3252c;

    /* compiled from: saved_dashboard_imp */
    public class C05241 implements com.facebook.common.loader.FbLoader.Callback<Params, Result, Throwable> {
        final /* synthetic */ OtherRequestsLoader f3249a;

        public C05241(OtherRequestsLoader otherRequestsLoader) {
            this.f3249a = otherRequestsLoader;
        }

        public final void m3162a(Object obj, Object obj2) {
            Result result = (Result) obj2;
            if (this.f3249a.f3252c != null) {
                Callback callback = this.f3249a.f3252c;
            }
        }

        public final void m3164c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            if (this.f3249a.f3252c != null) {
                Callback callback = this.f3249a.f3252c;
            }
        }

        public final void m3161a(Object obj, ListenableFuture listenableFuture) {
            if (this.f3249a.f3252c != null) {
                Callback callback = this.f3249a.f3252c;
            }
        }

        public final void m3163b(Object obj, Object obj2) {
            if (this.f3249a.f3252c != null) {
                Callback callback = this.f3249a.f3252c;
            }
        }
    }

    /* compiled from: saved_dashboard_imp */
    public interface Callback {
    }

    private static OtherRequestsLoader m3165b(InjectorLike injectorLike) {
        return new OtherRequestsLoader(MessageRequestsLoader.m3157b(injectorLike));
    }

    @Inject
    public OtherRequestsLoader(MessageRequestsLoader messageRequestsLoader) {
        this.f3251b = messageRequestsLoader;
        this.f3251b.m3159a(new C05241(this));
    }
}
