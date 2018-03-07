package com.facebook.common.loader;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader.Callback;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: place_picker_phrase_row_shown */
public abstract class AbstractListenableFutureFbLoader<PARAMS, RESULT> implements FbLoader<PARAMS, RESULT, Throwable> {
    public static final LoaderResult<?> f7745a = new LoaderResult(null, LoaderResultType.NOT_AVAILABLE);
    private final Executor f7746b;
    @GuardedBy("ui-thread")
    public FutureAndCallbackHolder f7747c;
    @GuardedBy("ui-thread")
    public Callback<PARAMS, RESULT, Throwable> f7748d = FbLoaders.m11062a();

    /* compiled from: place_picker_phrase_row_shown */
    class C04582 implements Function<RESULT, LoaderResult<RESULT>> {
        final /* synthetic */ AbstractListenableFutureFbLoader f7742a;

        C04582(AbstractListenableFutureFbLoader abstractListenableFutureFbLoader) {
            this.f7742a = abstractListenableFutureFbLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return LoaderResult.m11050b(obj);
        }
    }

    /* compiled from: place_picker_phrase_row_shown */
    public class LoaderResult<RESULT> {
        @Nullable
        public final RESULT f7743a;
        public final LoaderResultType f7744b;

        public static <RESULT> LoaderResult<RESULT> m11049a(RESULT result) {
            return new LoaderResult(result, LoaderResultType.INTERMEDIATE);
        }

        public static <RESULT> LoaderResult<RESULT> m11050b(RESULT result) {
            return new LoaderResult(result, LoaderResultType.FINAL);
        }

        public LoaderResult(RESULT result, LoaderResultType loaderResultType) {
            this.f7743a = result;
            this.f7744b = (LoaderResultType) Preconditions.checkNotNull(loaderResultType);
        }
    }

    /* compiled from: place_picker_phrase_row_shown */
    public enum LoaderResultType {
        NOT_AVAILABLE,
        INTERMEDIATE,
        FINAL
    }

    protected abstract LoaderResult<RESULT> mo1287b(PARAMS params);

    protected AbstractListenableFutureFbLoader(Executor executor) {
        this.f7746b = executor;
    }

    public final void m11056a(Callback<PARAMS, RESULT, Throwable> callback) {
        if (callback == null) {
            this.f7748d = FbLoaders.m11062a();
        } else {
            this.f7748d = callback;
        }
    }

    public final void m11057a(PARAMS params) {
        Object obj;
        m11055a();
        LoaderResult b = mo1287b(params);
        Preconditions.checkNotNull(b);
        if (b.f7744b != LoaderResultType.NOT_AVAILABLE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            Object obj2 = b.f7743a;
            this.f7748d.a(params, obj2);
            if (b.f7744b == LoaderResultType.FINAL) {
                this.f7748d.b(params, obj2);
                return;
            }
        }
        m11051a(params, b, 1);
    }

    private void m11051a(final PARAMS params, LoaderResult<RESULT> loaderResult, final int i) {
        ListenableFuture b = m11059b(params, loaderResult);
        m11061c();
        this.f7748d.a(params, b);
        C04571 c04571 = new AbstractDisposableFutureCallback<LoaderResult<RESULT>>(this) {
            final /* synthetic */ AbstractListenableFutureFbLoader f7741c;

            protected final void m11047a(Object obj) {
                AbstractListenableFutureFbLoader.m11052b(this.f7741c, params, (LoaderResult) obj, i);
            }

            protected final void m11048a(Throwable th) {
                this.f7741c.f7747c = null;
                this.f7741c.f7748d.c(params, th);
            }
        };
        this.f7747c = FutureAndCallbackHolder.a(b, c04571);
        Futures.a(b, c04571, this.f7746b);
    }

    public static void m11052b(AbstractListenableFutureFbLoader abstractListenableFutureFbLoader, Object obj, LoaderResult loaderResult, int i) {
        abstractListenableFutureFbLoader.f7747c = null;
        abstractListenableFutureFbLoader.f7748d.a(obj, loaderResult.f7743a);
        if (loaderResult.f7744b == LoaderResultType.FINAL) {
            abstractListenableFutureFbLoader.f7748d.b(obj, loaderResult.f7743a);
        } else if (i >= 2) {
            abstractListenableFutureFbLoader.f7748d.c(obj, new Exception("Too many attempts"));
        } else {
            abstractListenableFutureFbLoader.m11051a(obj, loaderResult, i + 1);
        }
    }

    public final void m11055a() {
        if (this.f7747c != null) {
            FutureAndCallbackHolder futureAndCallbackHolder = this.f7747c;
            this.f7747c = null;
            futureAndCallbackHolder.a(false);
        }
    }

    protected ListenableFuture<RESULT> mo1286a(PARAMS params, LoaderResult<RESULT> loaderResult) {
        throw new IllegalStateException();
    }

    protected ListenableFuture<LoaderResult<RESULT>> m11059b(PARAMS params, LoaderResult<RESULT> loaderResult) {
        return Futures.a(mo1286a(params, loaderResult), new C04582(this));
    }

    public final boolean m11060b() {
        return this.f7747c != null;
    }

    protected void m11061c() {
    }
}
