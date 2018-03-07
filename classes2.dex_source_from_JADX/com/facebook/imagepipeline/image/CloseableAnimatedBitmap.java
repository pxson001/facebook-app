package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: last_prompt_id_hidden */
public class CloseableAnimatedBitmap extends CloseableBitmap {
    @GuardedBy("this")
    private List<CloseableReference<Bitmap>> f17914a;
    public volatile List<Bitmap> f17915b;
    public volatile List<Integer> f17916c;

    public CloseableAnimatedBitmap(List<CloseableReference<Bitmap>> list, List<Integer> list2) {
        boolean z = true;
        Preconditions.a(list);
        Preconditions.b(list.size() > 0, "Need at least 1 frame!");
        this.f17914a = new ArrayList();
        this.f17915b = new ArrayList();
        for (CloseableReference closeableReference : list) {
            this.f17914a.add(closeableReference.m15683b());
            this.f17915b.add(closeableReference.m15682a());
        }
        this.f17916c = (List) Preconditions.a(list2);
        if (this.f17916c.size() != this.f17915b.size()) {
            z = false;
        }
        Preconditions.b(z, "Arrays length mismatch!");
    }

    public void close() {
        synchronized (this) {
            if (this.f17914a == null) {
                return;
            }
            Iterable iterable = this.f17914a;
            this.f17914a = null;
            this.f17915b = null;
            this.f17916c = null;
            CloseableReference.m15678a(iterable);
        }
    }

    public final synchronized boolean mo2981c() {
        return this.f17915b == null;
    }

    public final Bitmap mo2979a() {
        List list = this.f17915b;
        return list != null ? (Bitmap) list.get(0) : null;
    }

    public final int mo2980b() {
        List list = this.f17915b;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return BitmapUtil.m25068a((Bitmap) list.get(0)) * list.size();
    }

    public final int mo2984f() {
        List list = this.f17915b;
        if (list == null) {
            return 0;
        }
        return ((Bitmap) list.get(0)).getWidth();
    }

    public final int mo2985g() {
        List list = this.f17915b;
        if (list == null) {
            return 0;
        }
        return ((Bitmap) list.get(0)).getHeight();
    }
}
