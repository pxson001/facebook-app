package com.facebook.photos.creativeediting.model;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.drawee.view.DraweeHolder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: syncSeqId */
public class DraweeSwipeableItem {
    public final String f3391a;
    public final HashMap<StickerParams, DraweeHolder> f3392b = new HashMap();
    @Nullable
    public final DraweeHolder f3393c;
    public Callback f3394d;
    public AtomicBoolean f3395e = new AtomicBoolean(false);

    public DraweeSwipeableItem(@Nullable DraweeHolder draweeHolder, String str) {
        this.f3393c = draweeHolder;
        this.f3391a = (String) Preconditions.checkNotNull(str);
    }

    public final void m4495a(StickerParams stickerParams, DraweeHolder draweeHolder) {
        this.f3392b.put(Preconditions.checkNotNull(stickerParams), Preconditions.checkNotNull(draweeHolder));
        if (draweeHolder.h() != null) {
            draweeHolder.h().setCallback(this.f3394d);
        }
        if (this.f3395e.get()) {
            draweeHolder.b();
        }
    }

    public final boolean m4497b() {
        return !this.f3392b.isEmpty();
    }

    public final ImmutableList<StickerParams> m4498c() {
        return ImmutableList.copyOf(this.f3392b.keySet());
    }

    @Nullable
    public final DraweeHolder m4493a(StickerParams stickerParams) {
        return (DraweeHolder) this.f3392b.get(stickerParams);
    }

    public final void m4494a(Callback callback) {
        this.f3394d = callback;
        if (!(this.f3393c == null || this.f3393c.h() == null)) {
            this.f3393c.h().setCallback(callback);
        }
        for (DraweeHolder draweeHolder : this.f3392b.values()) {
            if (draweeHolder.h() != null) {
                draweeHolder.h().setCallback(callback);
            }
        }
    }

    public final boolean m4496a(Drawable drawable) {
        if (this.f3393c != null && this.f3393c.h() == drawable) {
            return true;
        }
        for (DraweeHolder h : this.f3392b.values()) {
            if (h.h() == drawable) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Swipeable item name : " + this.f3391a + ", isFrame : " + m4497b();
    }
}
