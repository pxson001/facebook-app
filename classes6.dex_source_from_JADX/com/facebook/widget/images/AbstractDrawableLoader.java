package com.facebook.widget.images;

import android.graphics.drawable.Drawable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: requireOpenNow */
public abstract class AbstractDrawableLoader {
    @VisibleForTesting
    public final Map<DrawableFetchRequest, ListenableFuture<?>> f5741a = Maps.c();
    private final Executor f5742b;
    public final DrawableFetchProvider f5743c;

    abstract ListenableFuture<?> mo393a(DrawableFetchRequest drawableFetchRequest);

    public abstract ListenableFuture<Drawable> mo394c(DrawableFetchRequest drawableFetchRequest);

    AbstractDrawableLoader(Executor executor, DrawableFetchProvider drawableFetchProvider) {
        this.f5742b = executor;
        this.f5743c = drawableFetchProvider;
    }
}
