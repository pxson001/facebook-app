package com.facebook.widget.recyclerview;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewCacheExtension;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: not a valid int value */
public class LayoutManagerWithKeepAttachedHack extends BetterLinearLayoutManager {
    private final BetterRecyclerView f12184a;
    private final DoNothingAdapter f12185b;
    public final SparseArrayCompat<List<ViewHolder>> f12186c;
    public final Set<ViewHolder> f12187d;
    private final AdapterDataObserver f12188e;
    public boolean f12189f;

    /* compiled from: not a valid int value */
    class DoNothingAdapter extends Adapter {
        public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void mo2225a(ViewHolder viewHolder, int i) {
        }

        public final int aZ_() {
            return 0;
        }
    }

    /* compiled from: not a valid int value */
    class C05091 extends SimpleAdapterDataObserver {
        final /* synthetic */ LayoutManagerWithKeepAttachedHack f12213a;

        C05091(LayoutManagerWithKeepAttachedHack layoutManagerWithKeepAttachedHack) {
            this.f12213a = layoutManagerWithKeepAttachedHack;
        }

        public final void mo2216b() {
            this.f12213a.f12189f = true;
        }
    }

    /* compiled from: not a valid int value */
    class KeepAttachedHackViewCacheExtension extends ViewCacheExtension {
        final /* synthetic */ LayoutManagerWithKeepAttachedHack f12214a;

        public KeepAttachedHackViewCacheExtension(LayoutManagerWithKeepAttachedHack layoutManagerWithKeepAttachedHack) {
            this.f12214a = layoutManagerWithKeepAttachedHack;
        }

        public final View mo2338a(int i, int i2) {
            ViewHolder viewHolder = null;
            List list = (List) this.f12214a.f12186c.m6350a(i2);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int i3;
            ViewHolder viewHolder2;
            ViewHolder viewHolder3;
            int size = list.size();
            for (i3 = 0; i3 < size; i3++) {
                if (((ViewHolder) list.get(i3)).m20406e() == i) {
                    viewHolder2 = (ViewHolder) list.remove(i3);
                    LayoutManagerWithKeepAttachedHack.m17908a(this.f12214a, viewHolder2, i, true);
                    viewHolder = viewHolder2;
                    break;
                }
            }
            if (viewHolder == null) {
                size = list.size();
                for (i3 = 0; i3 < size; i3++) {
                    if (!this.f12214a.f12187d.contains((ViewHolder) list.get(i3))) {
                        viewHolder2 = (ViewHolder) list.remove(i3);
                        LayoutManagerWithKeepAttachedHack.m17908a(this.f12214a, viewHolder2, i, false);
                        break;
                    }
                }
            }
            viewHolder2 = viewHolder;
            if (viewHolder2 == null) {
                viewHolder3 = (ViewHolder) list.remove(0);
                LayoutManagerWithKeepAttachedHack.m17908a(this.f12214a, viewHolder3, i, false);
            } else {
                viewHolder3 = viewHolder2;
            }
            this.f12214a.m17347e(viewHolder3.f14095a);
            return viewHolder3.f14095a;
        }
    }

    public LayoutManagerWithKeepAttachedHack(BetterRecyclerView betterRecyclerView) {
        this(betterRecyclerView, null);
    }

    public LayoutManagerWithKeepAttachedHack(BetterRecyclerView betterRecyclerView, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(betterRecyclerView.getContext());
        this.f12185b = new DoNothingAdapter();
        this.f12186c = new SparseArrayCompat();
        this.f12187d = new HashSet();
        this.f12188e = new C05091(this);
        m17920a(abstractFbErrorReporter);
        this.f12184a = betterRecyclerView;
        this.f12184a.setViewCacheExtension(new KeepAttachedHackViewCacheExtension(this));
    }

    public final void mo2293a(Adapter adapter, Adapter adapter2) {
        if (adapter != null) {
            adapter.mo2227b(this.f12188e);
        }
        if (adapter2 != null) {
            adapter2.mo2223a(this.f12188e);
        }
    }

    public final void mo2292a(int i, Recycler recycler) {
        mo2296a(m17351f(i), recycler);
    }

    public void mo2296a(View view, Recycler recycler) {
        if (m17909l(view)) {
            m17907a(view, false);
        } else {
            super.mo2296a(view, recycler);
        }
    }

    public final void mo2294a(Recycler recycler) {
        for (int v = m17367v() - 1; v >= 0; v--) {
            View f = m17351f(v);
            if (m17909l(f)) {
                boolean z;
                if (this.f12189f) {
                    z = false;
                } else {
                    z = true;
                }
                m17907a(f, z);
            }
        }
        this.f12189f = false;
        super.mo2294a(recycler);
    }

    public final void mo2295a(RecyclerView recyclerView, Recycler recycler) {
        for (int i = 0; i < this.f12186c.m6348a(); i++) {
            List list = (List) this.f12186c.m6350a(this.f12186c.m6356e(i));
            for (int i2 = 0; i2 < list.size(); i2++) {
                super.mo2296a(((ViewHolder) list.get(i2)).f14095a, recycler);
            }
        }
        this.f12186c.m6352b();
        this.f12187d.clear();
        super.mo2295a(recyclerView, recycler);
    }

    private void m17907a(View view, boolean z) {
        ViewHolder a = this.f12184a.m17138a(view);
        if (z) {
            this.f12187d.add(a);
        } else if (this.f12184a.f11774F != null) {
            this.f12184a.f11774F.mo2653a(a);
        }
        m17343d(view);
        int i = a.f14099e;
        List list = (List) this.f12186c.m6350a(i);
        if (list == null) {
            list = new ArrayList();
            this.f12186c.m6351a(i, list);
        }
        list.add(a);
    }

    private static boolean m17909l(View view) {
        return (view instanceof RecyclerViewKeepAttached) && !((LayoutParams) view.getLayoutParams()).m20424c() && ((RecyclerViewKeepAttached) view).gK_();
    }

    public static void m17908a(LayoutManagerWithKeepAttachedHack layoutManagerWithKeepAttachedHack, ViewHolder viewHolder, int i, boolean z) {
        boolean remove = layoutManagerWithKeepAttachedHack.f12187d.remove(viewHolder);
        if (z && remove) {
            layoutManagerWithKeepAttachedHack.f12185b.m17225b(viewHolder, i);
            return;
        }
        if (remove) {
            layoutManagerWithKeepAttachedHack.f12184a.f11774F.mo2653a(viewHolder);
        }
        layoutManagerWithKeepAttachedHack.f12184a.f11831o.m17225b(viewHolder, i);
    }
}
