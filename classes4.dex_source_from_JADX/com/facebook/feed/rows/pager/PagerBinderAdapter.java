package com.facebook.feed.rows.pager;

import android.app.Activity;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.EnvironmentControllerUtil;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter.PageStyler;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageItem;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerBinderDelegate;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.IRecyclableViewFactory;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

@Deprecated
/* compiled from: nux_reject */
public class PagerBinderAdapter extends RecyclablePagerAdapter<Binder> {
    private final PagerBinderDelegate f6435a;
    private final PageStyler f6436b;
    private final AbstractFbErrorReporter f6437c;
    private final ArrayList<PageItem> f6438d = Lists.a();
    private final RecyclableViewPoolManager f6439e;
    private final Activity f6440f;

    protected final void mo582a(View view, Object obj, int i) {
        Binder binder = (Binder) obj;
        TracerDetour.a("PagerBinderAdapter.bindView", -1142637963);
        try {
            ViewBindingsMap.a(view, binder, this.f6437c);
            this.f6436b.mo580a(view, i, b());
            binder.a(view);
        } finally {
            TracerDetour.a(-1448984856);
        }
    }

    public final void mo584b(View view, Object obj) {
        Binder binder = (Binder) obj;
        ViewBindingsMap.a(view);
        binder.b(view);
    }

    @Inject
    public PagerBinderAdapter(Activity activity, RecyclableViewPoolManager recyclableViewPoolManager, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted PagerBinderDelegate pagerBinderDelegate, @Assisted PageStyler pageStyler) {
        super(recyclableViewPoolManager);
        this.f6435a = pagerBinderDelegate;
        this.f6436b = pageStyler;
        this.f6437c = abstractFbErrorReporter;
        this.f6439e = recyclableViewPoolManager;
        this.f6440f = activity;
    }

    public final void m6873a(RowKey rowKey, AnyEnvironment anyEnvironment) {
        int b = b();
        Set hashSet = new HashSet();
        for (int i = 0; i < b; i++) {
            PageItem a = this.f6435a.m14710a(i);
            this.f6438d.add(a);
            EnvironmentController a2 = EnvironmentControllerUtil.a(anyEnvironment, null, null, null, null, null, rowKey, m6870a(anyEnvironment));
            a.f13935b.a(anyEnvironment);
            EnvironmentControllerUtil.a(a2, anyEnvironment);
            if (hashSet.add(a.m14747a().mo1000a())) {
                m6869a(a.m14747a());
            }
        }
    }

    private static boolean m6870a(AnyEnvironment anyEnvironment) {
        return (anyEnvironment instanceof HasIsAsync) && ((HasIsAsync) anyEnvironment).hM_();
    }

    protected final Object mo583b(int i) {
        return ((PageItem) this.f6438d.get(i)).f13935b;
    }

    protected final PagerViewType<? extends View> mo581a(int i) {
        return ((PageItem) this.f6438d.get(i)).f13934a;
    }

    public final int m6874b() {
        return this.f6435a.m14715e();
    }

    public final float m6877d(int i) {
        return this.f6436b.mo578a(i, this.f6435a.m14715e());
    }

    private void m6869a(PagerViewType pagerViewType) {
        this.f6439e.m6900a(pagerViewType.mo1000a(), (IRecyclableViewFactory) pagerViewType, this.f6440f);
    }
}
