package com.facebook.feed.rows.core;

import android.view.View;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.rows.core.binding.Binder;
import javax.annotation.Nullable;

/* compiled from: message_capping_setting */
public class ViewBindingsMap {
    private static final String f14338a = ViewBindingsMap.class.getSimpleName();

    private ViewBindingsMap() {
    }

    public static <V extends View> void m20701a(V v, Binder<V> binder, FbErrorReporter fbErrorReporter) {
        if (v.getTag(2131558605) != null) {
            fbErrorReporter.m2350b(f14338a, "Recycle callback has not happened for View " + v);
        }
        v.setTag(2131558605, binder);
        binder.f13436a = v;
    }

    public static <V extends View> Binder<V> m20700a(@Nullable V v) {
        if (v == null) {
            return null;
        }
        Binder<V> binder = (Binder) v.getTag(2131558605);
        if (binder == null) {
            return binder;
        }
        binder.f13436a = null;
        v.setTag(2131558605, null);
        return binder;
    }

    @Nullable
    public static <V extends View> V m20699a(@Nullable Binder<V> binder) {
        if (binder == null) {
            return null;
        }
        return binder.f13436a;
    }

    @Nullable
    public static <V extends View> Binder<V> m20702b(@Nullable V v) {
        if (v == null) {
            return null;
        }
        return (Binder) v.getTag(2131558605);
    }
}
