package com.facebook.feed.autoplay;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.InjectorLike;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nearbyplaces */
public class CenterDistanceVideoDisplaySelector implements VideoDisplayedSelector {
    private final int f10127a = 60;
    private final ScreenUtil f10128b;
    public final Rect f10129c = new Rect(0, 0, 0, 0);

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: nearbyplaces */
    public @interface ListPosition {
    }

    public static CenterDistanceVideoDisplaySelector m15801b(InjectorLike injectorLike) {
        return new CenterDistanceVideoDisplaySelector(ScreenUtil.a(injectorLike));
    }

    @Inject
    public CenterDistanceVideoDisplaySelector(ScreenUtil screenUtil) {
        this.f10128b = screenUtil;
    }

    public final <V extends View> V m15803a(Set<V> set) {
        if (set.isEmpty()) {
            return null;
        }
        V c = m15802c(set);
        if (c == null) {
            return c;
        }
        Set hashSet = new HashSet();
        c.getGlobalVisibleRect(this.f10129c);
        int i = this.f10129c.top;
        for (V v : set) {
            v.getGlobalVisibleRect(this.f10129c);
            if (i == this.f10129c.top) {
                hashSet.add(v);
            }
        }
        return m15798b(hashSet);
    }

    @Nullable
    private <V extends View> V m15798b(Set<V> set) {
        V v = null;
        if (set == null || set.isEmpty()) {
            return null;
        }
        int c = this.f10128b.c();
        int i = c / 2;
        int i2 = 0;
        float f = 0.0f;
        for (V v2 : set) {
            V v22;
            v22.getGlobalVisibleRect(this.f10129c);
            if (this.f10129c.top != 0) {
                int width;
                float f2;
                float f3;
                int i3;
                if (this.f10129c.left + v22.getWidth() >= c) {
                    width = this.f10129c.left + (v22.getWidth() / 2);
                } else {
                    width = this.f10129c.right - (v22.getWidth() / 2);
                }
                int abs = Math.abs(width - i);
                Rect rect = new Rect(0, 0, 0, 0);
                v22.getGlobalVisibleRect(rect);
                int width2 = rect.width();
                v22.getHitRect(rect);
                int width3 = rect.width();
                if (width3 == 0) {
                    f2 = 0.0f;
                } else {
                    f2 = ((float) width2) / ((float) width3);
                }
                float f4 = f2;
                if (f < f4 || (f == f4 && abs < i2)) {
                    f3 = f4;
                    i3 = abs;
                } else {
                    v22 = v;
                    f3 = f;
                    i3 = i2;
                }
                i2 = i3;
                f = f3;
                v = v22;
            }
        }
        if (v == null || v.getParent() == null) {
            return v;
        }
        ViewGroup b = m15800b((View) v);
        if (b == null) {
            return v;
        }
        if (!b.canScrollHorizontally(-1)) {
            return m15799b(set, 2);
        }
        if (b.canScrollHorizontally(1)) {
            return v;
        }
        return m15799b(set, 3);
    }

    @Nullable
    private <V extends View> V m15802c(Set<V> set) {
        V v = null;
        if (set == null || set.isEmpty()) {
            return null;
        }
        int d = this.f10128b.d();
        int i = (this.f10127a + d) / 2;
        int i2 = 0;
        for (V v2 : set) {
            V v22;
            v22.getGlobalVisibleRect(this.f10129c);
            if (this.f10129c.top != 0) {
                int height;
                int i3;
                if (this.f10129c.top + v22.getHeight() >= d) {
                    height = this.f10129c.top + (v22.getHeight() / 2);
                } else {
                    height = this.f10129c.bottom - (v22.getHeight() / 2);
                }
                height = Math.abs(height - i);
                if (v == null || height < i2) {
                    i3 = height;
                } else {
                    v22 = v;
                    i3 = i2;
                }
                i2 = i3;
                v = v22;
            }
        }
        if (v == null || v.getParent() == null) {
            return v;
        }
        ViewGroup b = m15800b((View) v);
        if (b == null) {
            return v;
        }
        i2 = (b.canScrollHorizontally(-1) || b.canScrollHorizontally(1)) ? 1 : 0;
        if (i2 != 0) {
            b = m15800b((View) b);
        }
        if (b == null) {
            return v;
        }
        if (!b.canScrollVertically(-1)) {
            return m15797a(set, 0);
        }
        if (b.canScrollVertically(1)) {
            return v;
        }
        return m15797a(set, 1);
    }

    private <V extends View> V m15797a(Set<V> set, int i) {
        V v = null;
        int i2 = -1;
        for (V v2 : set) {
            V v22;
            v22.getGlobalVisibleRect(this.f10129c);
            if (this.f10129c.top != 0) {
                if (v == null || ((i == 0 && this.f10129c.top < r1) || (i == 1 && this.f10129c.bottom > r1))) {
                    i2 = i == 0 ? this.f10129c.top : this.f10129c.bottom;
                } else {
                    v22 = v;
                }
                v = v22;
            }
        }
        return v;
    }

    private <V extends View> V m15799b(Set<V> set, int i) {
        V v = null;
        int i2 = -1;
        for (V v2 : set) {
            V v22;
            v22.getGlobalVisibleRect(this.f10129c);
            if (this.f10129c.top != 0) {
                if (v == null || ((i == 2 && this.f10129c.left < r1) || (i == 3 && this.f10129c.right > r1))) {
                    i2 = i == 2 ? this.f10129c.left : this.f10129c.right;
                } else {
                    v22 = v;
                }
                v = v22;
            }
        }
        return v;
    }

    @Nullable
    private static ViewGroup m15800b(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return (ViewGroup) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }
}
