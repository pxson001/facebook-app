package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclableviewpool.IRecyclableViewFactory;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

/* compiled from: device_based_login */
public class HScrollRecyclerViewAdapter extends Adapter<HScrollRecyclerViewHolder> {
    public static final PageStyler f13924a = new C06481();
    private PageItems f13925b;
    private HScrollViewTypes f13926c;
    private PageStyler f13927d;
    public AtomicReference<String> f13928e = new AtomicReference();

    /* compiled from: device_based_login */
    public interface PageStyler {
        float mo578a(int i, int i2);

        void mo579a(View view);

        void mo580a(View view, int i, int i2);
    }

    /* compiled from: device_based_login */
    final class C06481 implements PageStyler {
        C06481() {
        }

        public final void mo580a(View view, int i, int i2) {
        }

        public final void mo579a(View view) {
        }

        public final float mo578a(int i, int i2) {
            return 1.0f;
        }
    }

    /* compiled from: device_based_login */
    public class HScrollRecyclerViewHolder extends ViewHolder {
        public HScrollRecyclerViewHolder(View view) {
            super(view);
        }
    }

    public final void m14730a(ViewHolder viewHolder) {
        HScrollRecyclerViewHolder hScrollRecyclerViewHolder = (HScrollRecyclerViewHolder) viewHolder;
        super.a(hScrollRecyclerViewHolder);
        PageItems pageItems = this.f13925b;
        int e = hScrollRecyclerViewHolder.e();
        View view = hScrollRecyclerViewHolder.a;
        if (ViewBindingsMap.b(view) != null) {
            PageItem a = pageItems.m14716a(e);
            if (a != null) {
                Lazy lazy = pageItems.f13919c;
                if (a.f13936c) {
                    a.f13935b.b(view);
                } else {
                    ((AbstractFbErrorReporter) lazy.get()).b("Unbind_Error", "Calling unbind without calling prepare/bind should never happen");
                }
            }
            ViewBindingsMap.a(view);
        }
    }

    public final void m14731a(ViewHolder viewHolder, int i) {
        HScrollRecyclerViewHolder hScrollRecyclerViewHolder = (HScrollRecyclerViewHolder) viewHolder;
        TracerDetour.a("HScrollRecyclerViewAdapter.onBindViewHolder", -1409980830);
        try {
            this.f13927d.mo579a(hScrollRecyclerViewHolder.a);
            this.f13927d.mo580a(hScrollRecyclerViewHolder.a, -1, -1);
            this.f13925b.m14717a(i, hScrollRecyclerViewHolder.a);
        } finally {
            TracerDetour.a(79749527);
        }
    }

    @Inject
    public HScrollRecyclerViewAdapter(HScrollViewTypes hScrollViewTypes, @Assisted PageStyler pageStyler, @Assisted PageItems pageItems) {
        this.f13926c = hScrollViewTypes;
        this.f13927d = pageStyler;
        this.f13925b = pageItems;
        this.f13928e.set(String.valueOf(hashCode()));
    }

    public int getItemViewType(int i) {
        PagerViewType pagerViewType;
        PageItem a = this.f13925b.m14716a(i);
        if (a == null) {
            pagerViewType = null;
        } else {
            pagerViewType = a.f13934a;
        }
        PagerViewType pagerViewType2 = pagerViewType;
        if (pagerViewType2 == null) {
            return -1;
        }
        HScrollViewTypes hScrollViewTypes = this.f13926c;
        if (!hScrollViewTypes.b.containsKey(pagerViewType2.mo1000a())) {
            int size = hScrollViewTypes.a.size();
            hScrollViewTypes.a.add(pagerViewType2);
            hScrollViewTypes.b.put(pagerViewType2.mo1000a(), Integer.valueOf(size));
            hScrollViewTypes.d.a(size, 4);
        }
        return ((Integer) hScrollViewTypes.b.get(pagerViewType2.mo1000a())).intValue();
    }

    public final ViewHolder m14729a(ViewGroup viewGroup, int i) {
        return m14728a(viewGroup.getContext(), i);
    }

    private HScrollRecyclerViewHolder m14728a(Context context, int i) {
        IRecyclableViewFactory a = this.f13926c.a(i);
        TracerDetour.a("HScrollRecyclerViewAdapter.onCreateViewHolder", 2090119796);
        try {
            HScrollRecyclerViewHolder hScrollRecyclerViewHolder = new HScrollRecyclerViewHolder(a.mo999a(context));
            return hScrollRecyclerViewHolder;
        } finally {
            int i2 = 2023635312;
            TracerDetour.a(2023635312);
        }
    }

    public final int aZ_() {
        return this.f13925b.m14720b();
    }

    public final void m14732a(View view, int i) {
        this.f13927d.mo579a(view);
        this.f13927d.mo580a(view, -1, -1);
        PageItem a = this.f13925b.m14716a(i);
        if (a != null) {
            Binder binder = a.f13935b;
            binder.a(this.f13925b.f13921e);
            view.setTag(2131558601, Boolean.valueOf(true));
            binder.a(view);
        }
    }

    public final void m14734b(View view, int i) {
        PageItem a = this.f13925b.m14716a(i);
        if (a != null) {
            a.f13935b.b(view);
            view.setTag(2131558601, null);
        }
    }

    public final void m14733a(String str) {
        this.f13928e.set(str);
    }
}
