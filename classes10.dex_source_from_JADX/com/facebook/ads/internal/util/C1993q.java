package com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C1993q {
    static final int f14362a;
    static final ExecutorService f14363b;
    private static volatile boolean f14364c = true;
    private final Bitmap f14365d;
    private Bitmap f14366e;
    private final C1990n f14367f = new C1990n();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f14362a = availableProcessors;
        f14363b = Executors.newFixedThreadPool(availableProcessors);
    }

    public C1993q(Bitmap bitmap) {
        this.f14365d = bitmap;
    }

    public final Bitmap m14484a() {
        return this.f14366e;
    }

    public final Bitmap m14485a(int i) {
        this.f14366e = this.f14367f.m14480a(this.f14365d, (float) i);
        return this.f14366e;
    }
}
