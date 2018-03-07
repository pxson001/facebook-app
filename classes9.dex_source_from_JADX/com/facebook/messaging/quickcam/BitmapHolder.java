package com.facebook.messaging.quickcam;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: deserializeTheme */
public class BitmapHolder {
    private final ListeningExecutorService f16405a;
    @GuardedBy("this")
    public Bitmap f16406b;
    private ListenableFuture<Bitmap> f16407c;

    public static BitmapHolder m16464a(InjectorLike injectorLike) {
        return new BitmapHolder(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BitmapHolder(ListeningExecutorService listeningExecutorService) {
        this.f16405a = listeningExecutorService;
    }

    public final synchronized ListenableFuture<Bitmap> m16466a(final int i, final int i2) {
        ListenableFuture<Bitmap> a;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("The bitmap dimensions must be positive");
        } else if (m16465b(i, i2)) {
            a = Futures.a(this.f16406b);
        } else {
            if (this.f16407c != null) {
                this.f16407c.cancel(true);
            }
            this.f16407c = this.f16405a.a(new Callable<Bitmap>(this) {
                final /* synthetic */ BitmapHolder f16404c;

                public Object call() {
                    Bitmap bitmap;
                    synchronized (this.f16404c) {
                        if (this.f16404c.f16406b != null) {
                            this.f16404c.f16406b.recycle();
                        }
                        this.f16404c.f16406b = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                        bitmap = this.f16404c.f16406b;
                    }
                    return bitmap;
                }
            });
            a = this.f16407c;
        }
        return a;
    }

    private synchronized boolean m16465b(int i, int i2) {
        boolean z;
        z = this.f16406b != null && this.f16406b.getWidth() == i && this.f16406b.getHeight() == i2;
        return z;
    }

    public final synchronized void m16467a() {
        if (this.f16407c != null) {
            this.f16407c.cancel(true);
            this.f16407c = null;
        }
        if (this.f16406b != null) {
            this.f16406b.recycle();
            this.f16406b = null;
        }
    }
}
