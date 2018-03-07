package com.facebook.widget.images;

import android.graphics.drawable.Drawable;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@Deprecated
/* compiled from: report_a_problem_fork_tag */
public class DrawableFetch {
    public final ListenableFuture<Drawable> f5767a;
    private final DelayedDrawable f5768b;

    @Inject
    public DrawableFetch(DelayedDrawableProvider delayedDrawableProvider, @Assisted Drawable drawable, @Assisted ListenableFuture<Drawable> listenableFuture, @Assisted DrawableFetchRequest drawableFetchRequest) {
        this.f5767a = listenableFuture;
        this.f5768b = new DelayedDrawable((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(delayedDrawableProvider), drawable, this.f5767a, Integer.valueOf(drawableFetchRequest.f5783d), Integer.valueOf(drawableFetchRequest.f5782c));
    }
}
