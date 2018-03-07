package com.facebook.ui.images.webp;

import android.graphics.Bitmap;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: search_term */
public class AnimatedImage {
    public final int f5147a;
    public final int f5148b;
    public final boolean f5149c;
    private final boolean f5150d;
    public final ImmutableList<Bitmap> f5151e;
    public final ImmutableList<Integer> f5152f;

    public AnimatedImage(int i, int i2, boolean z, boolean z2, List<Bitmap> list, List<Integer> list2) {
        this.f5147a = i;
        this.f5148b = i2;
        this.f5149c = z;
        this.f5150d = z2;
        this.f5151e = ImmutableList.copyOf(list);
        this.f5152f = ImmutableList.copyOf(list2);
    }

    public final ImmutableList<Bitmap> m7882d() {
        return this.f5151e;
    }

    public final ImmutableList<Integer> m7883e() {
        return this.f5152f;
    }
}
