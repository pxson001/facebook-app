package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewCacheExtension;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.recyclerview.SimpleAdapterDataObserver;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: date_summary_text_long */
public class HScrollKeepAttachedLinearLayoutManager extends HScrollLinearLayoutManager {
    private final HScrollRecyclerView f16127e;
    private final DoNothingAdapter f16128f = new DoNothingAdapter();
    public final SparseArrayCompat<List<ViewHolder>> f16129g = new SparseArrayCompat();
    public final Set<ViewHolder> f16130h = new HashSet();
    private final AdapterDataObserver f16131i = new C12731(this);
    public boolean f16132t;
    private View f16133u = null;

    /* compiled from: date_summary_text_long */
    class C12731 extends SimpleAdapterDataObserver {
        final /* synthetic */ HScrollKeepAttachedLinearLayoutManager f16125a;

        C12731(HScrollKeepAttachedLinearLayoutManager hScrollKeepAttachedLinearLayoutManager) {
            this.f16125a = hScrollKeepAttachedLinearLayoutManager;
        }

        public final void m20156b() {
            this.f16125a.f16132t = true;
        }
    }

    /* compiled from: date_summary_text_long */
    class DoNothingAdapter extends Adapter {
        public final ViewHolder m20157a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void m20158a(ViewHolder viewHolder, int i) {
        }

        public final int aZ_() {
            return 0;
        }
    }

    /* compiled from: date_summary_text_long */
    class KeepAttachedHackViewCacheExtension extends ViewCacheExtension {
        final /* synthetic */ HScrollKeepAttachedLinearLayoutManager f16126a;

        public KeepAttachedHackViewCacheExtension(HScrollKeepAttachedLinearLayoutManager hScrollKeepAttachedLinearLayoutManager) {
            this.f16126a = hScrollKeepAttachedLinearLayoutManager;
        }

        public final View m20159a(int i, int i2) {
            ViewHolder viewHolder = null;
            List list = (List) this.f16126a.f16129g.a(i2);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int i3;
            ViewHolder viewHolder2;
            ViewHolder viewHolder3;
            int size = list.size();
            for (i3 = 0; i3 < size; i3++) {
                if (((ViewHolder) list.get(i3)).e() == i) {
                    viewHolder2 = (ViewHolder) list.remove(i3);
                    HScrollKeepAttachedLinearLayoutManager.m20161a(this.f16126a, viewHolder2, i, true);
                    viewHolder = viewHolder2;
                    break;
                }
            }
            if (viewHolder == null) {
                size = list.size();
                for (i3 = 0; i3 < size; i3++) {
                    if (!this.f16126a.f16130h.contains((ViewHolder) list.get(i3))) {
                        viewHolder2 = (ViewHolder) list.remove(i3);
                        HScrollKeepAttachedLinearLayoutManager.m20161a(this.f16126a, viewHolder2, i, false);
                        break;
                    }
                }
            }
            viewHolder2 = viewHolder;
            if (viewHolder2 == null) {
                viewHolder3 = (ViewHolder) list.remove(0);
                HScrollKeepAttachedLinearLayoutManager.m20161a(this.f16126a, viewHolder3, i, false);
            } else {
                viewHolder3 = viewHolder2;
            }
            this.f16126a.e(viewHolder3.a);
            return viewHolder3.a;
        }
    }

    @Inject
    public HScrollKeepAttachedLinearLayoutManager(@Assisted HScrollRecyclerView hScrollRecyclerView, @Assisted Context context, HScrollRecyclerViewChildMeasurer hScrollRecyclerViewChildMeasurer, HScrollDimensionCache hScrollDimensionCache) {
        super(context, hScrollRecyclerViewChildMeasurer, hScrollDimensionCache);
        this.f16127e = hScrollRecyclerView;
        this.f16127e.setViewCacheExtension(new KeepAttachedHackViewCacheExtension(this));
        b(0);
    }

    public final void m20167a(Adapter adapter, Adapter adapter2) {
        if (adapter != null) {
            adapter.b(this.f16131i);
        }
        if (adapter2 != null) {
            adapter2.a(this.f16131i);
        }
        this.f16133u = null;
    }

    public final void m20166a(int i, Recycler recycler) {
        a(f(i), recycler);
    }

    public final void m20171a(View view, Recycler recycler) {
        if (m20165l(view)) {
            m20160a(view, false);
        } else {
            super.a(view, recycler);
        }
    }

    public final void m20168a(Recycler recycler) {
        for (int v = v() - 1; v >= 0; v--) {
            View f = f(v);
            if (m20165l(f)) {
                boolean z;
                if (this.f16132t) {
                    z = false;
                } else {
                    z = true;
                }
                m20160a(f, z);
            }
        }
        this.f16132t = false;
        super.a(recycler);
    }

    public final void m20170a(RecyclerView recyclerView, Recycler recycler) {
        for (ViewHolder viewHolder : this.f16130h) {
            super.a(viewHolder.a, recycler);
        }
        this.f16129g.b();
        this.f16130h.clear();
        super.a(recyclerView, recycler);
    }

    private void m20160a(View view, boolean z) {
        ViewHolder a = this.f16127e.a(view);
        if (z) {
            this.f16130h.add(a);
        } else {
            this.f16127e.o.a(a);
        }
        d(view);
        int i = a.e;
        List list = (List) this.f16129g.a(i);
        if (list == null) {
            list = new ArrayList();
            this.f16129g.a(i, list);
        }
        list.add(a);
    }

    private static boolean m20165l(View view) {
        return (view instanceof RecyclerViewKeepAttached) && !((LayoutParams) view.getLayoutParams()).c() && ((RecyclerViewKeepAttached) view).gK_();
    }

    public static void m20161a(HScrollKeepAttachedLinearLayoutManager hScrollKeepAttachedLinearLayoutManager, ViewHolder viewHolder, int i, boolean z) {
        boolean remove = hScrollKeepAttachedLinearLayoutManager.f16130h.remove(viewHolder);
        if (z && remove) {
            hScrollKeepAttachedLinearLayoutManager.f16128f.b(viewHolder, i);
            return;
        }
        if (remove) {
            hScrollKeepAttachedLinearLayoutManager.f16127e.o.a(viewHolder);
        }
        hScrollKeepAttachedLinearLayoutManager.f16127e.o.b(viewHolder, i);
    }

    public final void m20169a(Recycler recycler, State state, int i, int i2) {
        try {
            TracerDetour.a("HScrollLinearLayoutManager.onMeasure", -1284365440);
            Adapter adapter = this.f16127e.getAdapter();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (adapter == null || adapter.aZ_() == 0) {
                e(m20164f(mode, size), m20164f(mode2, size2));
                return;
            }
            if (this.f16133u == null) {
                this.f16133u = adapter.a(this.f16127e, adapter.getItemViewType(0)).a;
            }
            if ((mode == 1073741824 && i() == 1) || (mode2 == 1073741824 && i() == 0)) {
                super.a(recycler, state, i, i2);
                TracerDetour.a(807894325);
                return;
            }
            int[] a;
            String c = m20163c();
            if (this.d.b(c)) {
                a = this.d.a(c);
            } else {
                a = new int[]{0, 0};
                if (D() > 0) {
                    m20162a(a, c);
                }
            }
            if (mode == 1073741824) {
                a[0] = m20164f(mode, size);
            }
            if (mode2 == 1073741824) {
                a[1] = m20164f(mode2, size2);
            }
            e(a[0], a[1]);
            TracerDetour.a(-1049355768);
        } finally {
            TracerDetour.a(-1286000484);
        }
    }

    private int m20164f(int i, int i2) {
        switch (i) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return i2;
            default:
                return ViewCompat.s(this.f16127e);
        }
    }

    private String m20163c() {
        return this.f16127e.o instanceof HScrollRecyclerViewAdapter ? (String) ((HScrollRecyclerViewAdapter) this.f16127e.o).e.get() : this.a;
    }

    private void m20162a(int[] iArr, String str) {
        this.b = this.c.a(this.f16133u, (HScrollRecyclerViewAdapter) this.f16127e.o, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        if (this.j == 0) {
            iArr[0] = iArr[0] + this.b[0];
            iArr[1] = (this.b[1] + z()) + B();
        } else {
            iArr[1] = iArr[1] + this.b[1];
            iArr[0] = (this.b[0] + y()) + A();
        }
        if (!StringUtil.a(str)) {
            this.d.a(str, iArr);
        }
    }
}
