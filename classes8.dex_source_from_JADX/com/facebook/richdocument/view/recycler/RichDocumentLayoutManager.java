package com.facebook.richdocument.view.recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewCacheExtension;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.device.yearclass.YearClass;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.abtest.BlockCacheSizeExperiment;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.WebViewBlockPresenter;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.richdocument.view.widget.RichDocumentScrollbarHelper;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: persist_data */
public class RichDocumentLayoutManager extends BetterLinearLayoutManager implements RichDocumentCacheableLayoutManager {
    private static final Map<Integer, Integer> f6932c = new C07881();
    @Inject
    public BlockCacheSizeExperiment f6933a;
    SparseArrayCompat<ViewCache> f6934b = new SparseArrayCompat();
    public final RecyclerView f6935d;
    private RichDocumentScrollbarHelper f6936e;
    public Recycler f6937f;
    private boolean f6938g;
    public boolean f6939h;
    public int f6940i = -1;
    public boolean f6941t = true;

    /* compiled from: persist_data */
    public interface KeepAttached {
        boolean mo370c();
    }

    /* compiled from: persist_data */
    public interface SingleBind extends KeepAttached {
        boolean mo369b();
    }

    /* compiled from: persist_data */
    final class C07881 extends HashMap<Integer, Integer> {
        C07881() {
            put(Integer.valueOf(5), Integer.valueOf(100));
        }
    }

    /* compiled from: persist_data */
    public class C07903 extends ViewCacheExtension {
        final /* synthetic */ RichDocumentLayoutManager f6927a;

        public C07903(RichDocumentLayoutManager richDocumentLayoutManager) {
            this.f6927a = richDocumentLayoutManager;
        }

        public final View m7164a(int i, int i2) {
            ViewCache viewCache = (ViewCache) this.f6927a.f6934b.a(i2);
            if (viewCache != null) {
                Object obj = (viewCache.f6928a.isEmpty() && viewCache.f6929b.size() == 0) ? 1 : null;
                if (obj == null) {
                    ViewHolder viewHolder = (ViewHolder) viewCache.f6929b.get(Integer.valueOf(i));
                    viewCache.f6929b.remove(Integer.valueOf(i));
                    if (viewHolder == null && !viewCache.f6928a.isEmpty()) {
                        viewHolder = (ViewHolder) viewCache.f6928a.remove(0);
                    }
                    ViewHolder viewHolder2 = viewHolder;
                    if (viewHolder2 == null) {
                        return null;
                    }
                    if (!RichDocumentLayoutManager.m7176m(this.f6927a, viewHolder2.a)) {
                        this.f6927a.f6935d.o.b(viewHolder2, i);
                    }
                    this.f6927a.e(viewHolder2.a);
                    if (!this.f6927a.f6939h) {
                        this.f6927a.f6935d.o.c(viewHolder2);
                    }
                    return viewHolder2.a;
                }
            }
            return null;
        }
    }

    /* compiled from: persist_data */
    public class ViewCache {
        public final List<ViewHolder> f6928a = new ArrayList();
        public final Map<Integer, ViewHolder> f6929b = new HashMap();
        final int f6930c;
        public final /* synthetic */ RichDocumentLayoutManager f6931d;

        public ViewCache(RichDocumentLayoutManager richDocumentLayoutManager, int i) {
            this.f6931d = richDocumentLayoutManager;
            this.f6930c = i;
        }

        public final void m7167a(ViewHolder viewHolder, int i) {
            if (RichDocumentLayoutManager.m7176m(this.f6931d, viewHolder.a)) {
                int d = m7166d(i);
                if (d != i) {
                    if (d != -1) {
                        ViewHolder viewHolder2 = (ViewHolder) this.f6929b.get(Integer.valueOf(d));
                        if (viewHolder2 != null) {
                            this.f6929b.remove(Integer.valueOf(d));
                            super.a(viewHolder2.a, this.f6931d.f6937f);
                            RichDocumentLayoutManager richDocumentLayoutManager = this.f6931d;
                            RichDocumentLayoutManager.m7172b(viewHolder2);
                        }
                    }
                    this.f6929b.put(Integer.valueOf(i), viewHolder);
                    return;
                }
                return;
            }
            this.f6928a.add(viewHolder);
        }

        private int m7166d(int i) {
            if (this.f6929b.size() + 1 <= this.f6930c) {
                return -1;
            }
            int l = this.f6931d.l();
            int n = this.f6931d.n();
            int a = m7165a(l, n, i);
            int i2 = a;
            for (Entry entry : this.f6929b.entrySet()) {
                int a2 = m7165a(l, n, ((Integer) entry.getKey()).intValue());
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

        public final boolean m7168b(int i) {
            return m7166d(i) != i;
        }

        private static int m7165a(int i, int i2, int i3) {
            return Math.abs(((i + i2) / 2) - i3);
        }
    }

    public static void m7171a(Object obj, Context context) {
        ((RichDocumentLayoutManager) obj).f6933a = BlockCacheSizeExperiment.m5121a(FbInjector.get(context));
    }

    public RichDocumentLayoutManager(Context context, RecyclerView recyclerView) {
        super(context);
        this.f6935d = recyclerView;
        this.f6935d.setViewCacheExtension(new C07903(this));
        Class cls = RichDocumentLayoutManager.class;
        m7171a((Object) this, context);
        Map map = f6932c;
        Integer valueOf = Integer.valueOf(8);
        BlockCacheSizeExperiment blockCacheSizeExperiment = this.f6933a;
        int a = YearClass.a(context);
        if (a >= 2013) {
            a = blockCacheSizeExperiment.f5147a.a(ExperimentsForRichDocumentAbtestModule.w, 3);
        } else if (a == 2012) {
            a = blockCacheSizeExperiment.f5147a.a(ExperimentsForRichDocumentAbtestModule.v, 3);
        } else {
            a = blockCacheSizeExperiment.f5147a.a(ExperimentsForRichDocumentAbtestModule.u, 3);
        }
        map.put(valueOf, Integer.valueOf(a));
    }

    public final void m7187e(int i) {
        this.f6940i = i;
        super.e(i);
    }

    public final void m7185c(Recycler recycler, State state) {
        this.f6939h = true;
        super.c(recycler, state);
        this.f6939h = false;
        if (this.f6940i != -1 && this.f6941t && this.f6935d != null && this.f6935d.o != null && (this.f6935d.o instanceof RichDocumentAdapter)) {
            d(this.f6940i, (this.f6935d.getHeight() - this.f6935d.getChildAt(0).getHeight()) / 2);
            this.f6940i = -1;
        }
    }

    public final void m7177a(int i, Recycler recycler) {
        a(f(i), recycler);
    }

    public final void m7182a(View view, Recycler recycler) {
        if (m7175l(view)) {
            RecyclerView.d(view);
            this.f6935d.o.d(this.f6935d.a(view));
            m7173c(view, RecyclerView.d(view));
            return;
        }
        super.a(view, recycler);
    }

    public final void m7179a(Recycler recycler) {
        for (int i = 0; i < v(); i++) {
            View f = f(i);
            if (m7175l(f)) {
                m7173c(f, RecyclerView.d(f));
            }
        }
        super.a(recycler);
    }

    public final void m7181a(RecyclerView recyclerView, Recycler recycler) {
        super.a(recyclerView, recycler);
        m7174d(recycler);
    }

    public final void m7184c() {
        if (this.f6937f != null) {
            m7174d(this.f6937f);
        }
    }

    private void m7174d(Recycler recycler) {
        this.f6938g = true;
        for (int i = 0; i < this.f6934b.a(); i++) {
            ViewCache viewCache = (ViewCache) this.f6934b.a(this.f6934b.e(i));
            for (int i2 = 0; i2 < viewCache.f6928a.size(); i2++) {
                ViewHolder viewHolder = (ViewHolder) viewCache.f6928a.get(i2);
                super.a(viewHolder.a, recycler);
                m7172b(viewHolder);
                if ((viewHolder instanceof BlockViewHolder) && (((BlockViewHolder) viewHolder).m7383w() instanceof WebViewBlockPresenter)) {
                    m7169a(viewHolder);
                }
            }
            for (Entry value : viewCache.f6929b.entrySet()) {
                ViewHolder viewHolder2 = (ViewHolder) value.getValue();
                super.a(viewHolder2.a, recycler);
                m7172b(viewHolder2);
                if ((viewHolder2 instanceof BlockViewHolder) && (((BlockViewHolder) viewHolder2).m7383w() instanceof WebViewBlockPresenter)) {
                    m7169a(viewHolder2);
                }
            }
        }
        this.f6934b.b();
        this.f6938g = false;
    }

    private static void m7169a(ViewHolder viewHolder) {
        ((WebViewBlockPresenter) ((BlockViewHolder) viewHolder).m7383w()).m6843e();
    }

    public static void m7172b(ViewHolder viewHolder) {
        if (viewHolder instanceof BlockViewHolder) {
            AbstractBlockPresenter w = ((BlockViewHolder) viewHolder).m7383w();
            if (w != null) {
                w.mo371b(new Bundle());
            }
        }
    }

    public final boolean a_(int i, int i2) {
        if (this.f6937f == null) {
            return false;
        }
        if (this.f6938g) {
            return false;
        }
        if (i < 0 || i >= D()) {
            return false;
        }
        if (i >= l() && i <= n()) {
            return false;
        }
        ViewCache viewCache = (ViewCache) this.f6934b.a(i2);
        if (viewCache != null && viewCache.f6929b.get(Integer.valueOf(i)) != null) {
            return false;
        }
        if (viewCache != null && !viewCache.m7168b(i)) {
            return false;
        }
        try {
            final View c = this.f6937f.c(i);
            if (this.f6935d.getAdapter() instanceof RichDocumentAdapter) {
                ((RichDocumentAdapter) this.f6935d.getAdapter()).m6880d();
            }
            b(c);
            new Runnable(this) {
                final /* synthetic */ RichDocumentLayoutManager f6926b;

                public void run() {
                    if (this.f6926b.f6935d.getWidth() == 0 || this.f6926b.f6935d.getHeight() == 0) {
                        this.f6926b.f6935d.postDelayed(this, 50);
                    }
                    int width = this.f6926b.f6935d.getWidth();
                    int height = this.f6926b.f6935d.getHeight();
                    c.measure(MeasureSpec.makeMeasureSpec(width, 1073741824), MeasureSpec.makeMeasureSpec(height, 0));
                    c.layout(0, 0, Math.min(width, c.getMeasuredWidth()), c.getMeasuredHeight());
                }
            }.run();
            m7173c(c, i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final void m7180a(Recycler recycler, State state, int i, int i2) {
        super.a(recycler, state, i, i2);
        this.f6937f = recycler;
    }

    private void m7173c(View view, int i) {
        ViewHolder a = this.f6935d.a(view);
        d(view);
        int i2 = a.e;
        ViewCache viewCache = (ViewCache) this.f6934b.a(i2);
        if (viewCache == null) {
            ViewCache viewCache2 = new ViewCache(this, f6932c.get(Integer.valueOf(i2)) != null ? ((Integer) f6932c.get(Integer.valueOf(i2))).intValue() : 3);
            this.f6934b.a(i2, viewCache2);
            viewCache = viewCache2;
        }
        viewCache.m7167a(a, i);
    }

    private boolean m7175l(View view) {
        ViewHolder a = this.f6935d.a(view);
        if (a != null && (a instanceof BlockViewHolder)) {
            AbstractBlockPresenter w = ((BlockViewHolder) a).m7383w();
            if (w instanceof KeepAttached) {
                return ((KeepAttached) w).mo370c();
            }
        }
        return false;
    }

    public static boolean m7176m(RichDocumentLayoutManager richDocumentLayoutManager, View view) {
        ViewHolder a = richDocumentLayoutManager.f6935d.a(view);
        if (a != null && (a instanceof BlockViewHolder)) {
            AbstractBlockPresenter w = ((BlockViewHolder) a).m7383w();
            if (w instanceof SingleBind) {
                return ((SingleBind) w).mo369b();
            }
        }
        return false;
    }

    public final void m7178a(Adapter adapter, Adapter adapter2) {
        super.a(adapter, adapter2);
        this.f6936e = new RichDocumentScrollbarHelper(this.f6935d.getContext(), this, (RichDocumentAdapter) adapter2);
    }

    public final int m7188g(State state) {
        if (this.f6936e != null) {
            return this.f6936e.m7608a();
        }
        return super.g(state);
    }

    public final int m7183c(State state) {
        if (this.f6936e != null) {
            return this.f6936e.m7609b();
        }
        return super.c(state);
    }

    public final int m7186e(State state) {
        if (this.f6936e != null) {
            return this.f6936e.m7610c();
        }
        return super.e(state);
    }
}
