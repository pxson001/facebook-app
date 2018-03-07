package com.facebook.widget.images;

import android.graphics.drawable.Drawable;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@Deprecated
/* compiled from: requestActionId */
public class DelayedDrawable extends ForwardingDrawable {
    public static final Class<?> f5762a = DelayedDrawable.class;
    private final int f5763c;
    private final int f5764d;
    public final Executor f5765e;
    public boolean f5766f = false;

    /* compiled from: requestActionId */
    class C03371 implements FutureCallback<Drawable> {
        final /* synthetic */ DelayedDrawable f5761a;

        C03371(DelayedDrawable delayedDrawable) {
            this.f5761a = delayedDrawable;
        }

        public void onSuccess(Object obj) {
            Drawable drawable = (Drawable) obj;
            this.f5761a.f5766f = true;
            this.f5761a.b(drawable);
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                BLog.b(DelayedDrawable.f5762a, "Failure updating DelayedDrawable", th);
            }
        }
    }

    @Inject
    public DelayedDrawable(Executor executor, @Assisted Drawable drawable, @Assisted ListenableFuture<Drawable> listenableFuture, @Assisted Integer num, @Assisted Integer num2) {
        ListeningExecutorService a;
        super(drawable);
        this.f5763c = num.intValue();
        this.f5764d = num2.intValue();
        this.f5765e = executor;
        C03371 c03371 = new C03371(this);
        if (listenableFuture.isDone()) {
            a = MoreExecutors.a();
        } else {
            a = this.f5765e;
        }
        Futures.a(listenableFuture, c03371, a);
    }

    public int getIntrinsicWidth() {
        return this.f5763c;
    }

    public int getIntrinsicHeight() {
        return this.f5764d;
    }
}
