package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewCacheExtension;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.recycler.RichDocumentCacheableLayoutManager;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager.KeepAttached;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager.SingleBind;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SHARING_UPSELL */
public class InstantShoppingGridLayoutManager extends GridLayoutManager implements RichDocumentCacheableLayoutManager {
    SparseArrayCompat<ViewCache> f23879t = new SparseArrayCompat();
    public RecyclerView f23880u;
    public Recycler f23881v;
    private boolean f23882w;
    public boolean f23883x;

    /* compiled from: SHARING_UPSELL */
    public class C34261 extends ViewCacheExtension {
        final /* synthetic */ InstantShoppingGridLayoutManager f23875a;

        public C34261(InstantShoppingGridLayoutManager instantShoppingGridLayoutManager) {
            this.f23875a = instantShoppingGridLayoutManager;
        }

        public final View m25155a(int i, int i2) {
            ViewCache viewCache = (ViewCache) this.f23875a.f23879t.a(i2);
            if (viewCache != null) {
                Object obj = (viewCache.f23876a.isEmpty() && viewCache.f23877b.size() == 0) ? 1 : null;
                if (obj == null) {
                    ViewHolder viewHolder = (ViewHolder) viewCache.f23877b.get(Integer.valueOf(i));
                    viewCache.f23877b.remove(Integer.valueOf(i));
                    if (viewHolder == null && !viewCache.f23876a.isEmpty()) {
                        viewHolder = (ViewHolder) viewCache.f23876a.remove(0);
                    }
                    ViewHolder viewHolder2 = viewHolder;
                    if (viewHolder2 == null) {
                        return null;
                    }
                    if (!InstantShoppingGridLayoutManager.m25164m(this.f23875a, viewHolder2.a)) {
                        this.f23875a.f23880u.o.b(viewHolder2, i);
                    }
                    this.f23875a.e(viewHolder2.a);
                    if (!this.f23875a.f23883x) {
                        this.f23875a.f23880u.o.c(viewHolder2);
                    }
                    return viewHolder2.a;
                }
            }
            return null;
        }
    }

    /* compiled from: SHARING_UPSELL */
    public class ViewCache {
        public final List<ViewHolder> f23876a = new ArrayList();
        public final Map<Integer, ViewHolder> f23877b = new HashMap();
        public final /* synthetic */ InstantShoppingGridLayoutManager f23878c;

        public ViewCache(InstantShoppingGridLayoutManager instantShoppingGridLayoutManager) {
            this.f23878c = instantShoppingGridLayoutManager;
        }

        public final void m25158a(ViewHolder viewHolder, int i) {
            if (InstantShoppingGridLayoutManager.m25164m(this.f23878c, viewHolder.a)) {
                int d = m25157d(i);
                if (d != i) {
                    if (d != -1) {
                        ViewHolder viewHolder2 = (ViewHolder) this.f23877b.get(Integer.valueOf(d));
                        if (viewHolder2 != null) {
                            this.f23877b.remove(Integer.valueOf(d));
                            super.a(viewHolder2.a, this.f23878c.f23881v);
                        }
                    }
                    this.f23877b.put(Integer.valueOf(i), viewHolder);
                    return;
                }
                return;
            }
            this.f23876a.add(viewHolder);
        }

        private int m25157d(int i) {
            if (this.f23877b.size() + 1 <= 3) {
                return -1;
            }
            int l = this.f23878c.l();
            int n = this.f23878c.n();
            int a = m25156a(l, n, i);
            int i2 = a;
            for (Entry entry : this.f23877b.entrySet()) {
                int a2 = m25156a(l, n, ((Integer) entry.getKey()).intValue());
                if (a2 > i2) {
                    i = ((Integer) entry.getKey()).intValue();
                    a = a2;
                } else {
                    a = i2;
                }
                i2 = a;
            }
            return i;
        }

        public final boolean m25159b(int i) {
            return m25157d(i) != i;
        }

        private static int m25156a(int i, int i2, int i3) {
            return Math.abs(((i + i2) / 2) - i3);
        }
    }

    public InstantShoppingGridLayoutManager(Context context, RecyclerView recyclerView, int i) {
        super(context, i);
        this.f23880u = recyclerView;
        this.f23880u.setViewCacheExtension(new C34261(this));
    }

    public final void m25165a(int i, Recycler recycler) {
        a(f(i), recycler);
    }

    public final void m25169a(View view, Recycler recycler) {
        if (m25163l(view)) {
            this.f23880u.o.d(this.f23880u.a(view));
            m25161c(view, RecyclerView.d(view));
            return;
        }
        super.a(view, recycler);
    }

    public final void m25166a(Recycler recycler) {
        for (int i = 0; i < v(); i++) {
            View f = f(i);
            if (m25163l(f)) {
                m25161c(f, RecyclerView.d(f));
            }
        }
        super.a(recycler);
    }

    public final void m25168a(RecyclerView recyclerView, Recycler recycler) {
        super.a(recyclerView, recycler);
        m25162d(recycler);
    }

    private void m25162d(Recycler recycler) {
        this.f23882w = true;
        for (int i = 0; i < this.f23879t.a(); i++) {
            ViewCache viewCache = (ViewCache) this.f23879t.a(this.f23879t.e(i));
            for (int i2 = 0; i2 < viewCache.f23876a.size(); i2++) {
                super.a(((ViewHolder) viewCache.f23876a.get(i2)).a, recycler);
            }
            for (Entry value : viewCache.f23877b.entrySet()) {
                super.a(((ViewHolder) value.getValue()).a, recycler);
            }
        }
        this.f23879t.b();
        this.f23882w = false;
    }

    public final boolean a_(int i, int i2) {
        if (this.f23881v == null) {
            return false;
        }
        if (this.f23882w) {
            return false;
        }
        if (i < 0 || i >= D()) {
            return false;
        }
        ViewCache viewCache = (ViewCache) this.f23879t.a(i2);
        if (viewCache != null && viewCache.f23877b.get(Integer.valueOf(i)) != null) {
            return false;
        }
        if (viewCache != null && !viewCache.m25159b(i)) {
            return false;
        }
        View c = this.f23881v.c(i);
        b(c);
        m25161c(c, i);
        return true;
    }

    public final void m25167a(Recycler recycler, State state, int i, int i2) {
        super.a(recycler, state, i, i2);
        this.f23881v = recycler;
    }

    public final void m25170c(Recycler recycler, State state) {
        this.f23883x = true;
        super.c(recycler, state);
        this.f23883x = false;
    }

    private void m25161c(View view, int i) {
        ViewHolder a = this.f23880u.a(view);
        d(view);
        int i2 = a.e;
        ViewCache viewCache = (ViewCache) this.f23879t.a(i2);
        if (viewCache == null) {
            viewCache = new ViewCache(this);
            this.f23879t.a(i2, viewCache);
        }
        viewCache.m25158a(a, i);
    }

    private boolean m25163l(View view) {
        ViewHolder a = this.f23880u.a(view);
        if (a != null && (a instanceof BlockViewHolder)) {
            AbstractBlockPresenter w = ((BlockViewHolder) a).w();
            if (w instanceof KeepAttached) {
                return ((KeepAttached) w).c();
            }
        }
        return false;
    }

    public static boolean m25164m(InstantShoppingGridLayoutManager instantShoppingGridLayoutManager, View view) {
        ViewHolder a = instantShoppingGridLayoutManager.f23880u.a(view);
        if (a != null && (a instanceof BlockViewHolder)) {
            AbstractBlockPresenter w = ((BlockViewHolder) a).w();
            if (w instanceof SingleBind) {
                return ((SingleBind) w).b();
            }
        }
        return false;
    }
}
