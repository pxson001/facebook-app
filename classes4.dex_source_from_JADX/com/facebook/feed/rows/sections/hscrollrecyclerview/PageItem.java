package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.view.View;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.EnvironmentControllerUtil;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.recyclablepager.PagerViewType;

/* compiled from: detachFromView */
public class PageItem {
    public final PagerViewType f13934a;
    public final Binder f13935b;
    public boolean f13936c;

    public <V extends View> PageItem(PagerViewType<V> pagerViewType, Binder<V> binder) {
        this.f13934a = pagerViewType;
        this.f13935b = binder;
    }

    public final PagerViewType m14747a() {
        return this.f13934a;
    }

    public final Binder m14750b() {
        return this.f13935b;
    }

    public final void m14748a(RowKey rowKey, AnyEnvironment anyEnvironment) {
        TracerDetour.a("PageItem.prepare", 1013753211);
        try {
            EnvironmentController a = EnvironmentControllerUtil.a(anyEnvironment, null, null, null, null, null, rowKey, m14746a(anyEnvironment));
            this.f13935b.a(anyEnvironment);
            EnvironmentControllerUtil.a(a, anyEnvironment);
            this.f13936c = true;
        } finally {
            TracerDetour.a(-395649675);
        }
    }

    public final <V extends View> void m14749a(RowKey rowKey, AnyEnvironment anyEnvironment, V v) {
        if (!this.f13936c) {
            m14748a(rowKey, anyEnvironment);
        }
        TracerDetour.a("PageItem.bind", -1479219248);
        try {
            this.f13935b.a(v);
        } finally {
            TracerDetour.a(-739513682);
        }
    }

    private static boolean m14746a(AnyEnvironment anyEnvironment) {
        return (anyEnvironment instanceof HasIsAsync) && ((HasIsAsync) anyEnvironment).hM_();
    }
}
