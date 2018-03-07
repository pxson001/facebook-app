package com.facebook.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: image/x-auto */
public final class LazyResources {

    /* compiled from: image/x-auto */
    final class LazyStringFromContext implements Lazy<String> {
        @Nullable
        private Context f20495a;
        private final int f20496b;
        private String f20497c;

        public LazyStringFromContext(Context context, int i) {
            this.f20495a = (Context) Preconditions.checkNotNull(context);
            this.f20496b = i;
        }

        public final Object get() {
            if (this.f20495a != null) {
                synchronized (this) {
                    if (this.f20495a != null) {
                        this.f20497c = this.f20495a.getString(this.f20496b);
                        this.f20495a = null;
                    }
                }
            }
            return this.f20497c;
        }
    }

    /* compiled from: image/x-auto */
    final class LazyDimensFromResources implements Lazy<Float> {
        @Nullable
        private Resources f20498a;
        private final int f20499b;
        private Float f20500c;

        public LazyDimensFromResources(Resources resources, int i) {
            this.f20498a = (Resources) Preconditions.checkNotNull(resources);
            this.f20499b = i;
        }

        public final Object get() {
            if (this.f20498a != null) {
                synchronized (this) {
                    if (this.f20498a != null) {
                        this.f20500c = Float.valueOf(this.f20498a.getDimension(this.f20499b));
                        this.f20498a = null;
                    }
                }
            }
            return this.f20500c;
        }
    }

    /* compiled from: image/x-auto */
    final class LazyDrawableFromContext implements Lazy<Drawable> {
        @Nullable
        private Context f20749a;
        private final int f20750b;
        private Drawable f20751c;

        public LazyDrawableFromContext(Context context, int i) {
            this.f20749a = (Context) Preconditions.checkNotNull(context);
            this.f20750b = i;
        }

        public final Object get() {
            if (this.f20749a != null) {
                synchronized (this) {
                    if (this.f20749a != null) {
                        this.f20751c = this.f20749a.getResources().getDrawable(this.f20750b);
                        this.f20749a = null;
                    }
                }
            }
            return this.f20751c;
        }
    }

    private LazyResources() {
    }

    public static Lazy<String> m28239a(Context context, int i) {
        return new LazyStringFromContext(context, i);
    }

    public static Lazy<Drawable> m28241b(Context context, int i) {
        return new LazyDrawableFromContext(context, i);
    }

    public static Lazy<Float> m28240a(Resources resources, int i) {
        return new LazyDimensFromResources(resources, i);
    }
}
