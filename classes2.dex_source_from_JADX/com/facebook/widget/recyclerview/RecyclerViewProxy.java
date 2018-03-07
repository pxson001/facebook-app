package com.facebook.widget.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.5;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ListViewAdapterWrapper;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemLongClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnTouchDownListener;
import com.facebook.widget.listview.ScrollingViewProxy.RecyclerListener;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapperMarker;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.http.MethodNotSupportedException;

/* compiled from: nonemployee_mode */
public class RecyclerViewProxy implements InjectableComponentWithContext, ScrollingViewProxy {
    private static final String f12217b = RecyclerViewProxy.class.getSimpleName();
    public int f12218a;
    public final BetterRecyclerView f12219c;
    public final List<OnScrollListener> f12220d = new ArrayList();
    @Nullable
    public OnScrollListener f12221e;
    @Nullable
    private RecyclerViewAdapterWithHeadersAndFooters f12222f;
    @Nullable
    private ListAdapter f12223g;
    private ArrayList<View> f12224h = new ArrayList();
    private ArrayList<View> f12225i = new ArrayList();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f12226j = UltralightRuntime.f368b;
    public int f12227k;
    public int f12228l;
    public int f12229m = 0;
    private boolean f12230n = false;

    /* compiled from: nonemployee_mode */
    public class C05106 extends RecyclerView.OnScrollListener {
        final /* synthetic */ RecyclerViewProxy f12245a;

        public C05106(RecyclerViewProxy recyclerViewProxy) {
            this.f12245a = recyclerViewProxy;
        }

        public final void mo2219a(RecyclerView recyclerView, int i) {
            this.f12245a.f12229m = i;
            int size = this.f12245a.f12220d.size();
            if (this.f12245a.f12221e != null) {
                this.f12245a.f12221e.mo1262a(this.f12245a, i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ((OnScrollListener) this.f12245a.f12220d.get(i2)).mo1262a(this.f12245a, i);
            }
        }

        public final void mo2220a(RecyclerView recyclerView, int i, int i2) {
            int size = this.f12245a.f12220d.size();
            BetterLayoutManager betterLayoutManager = this.f12245a.f12219c.getBetterLayoutManager();
            this.f12245a.f12227k = betterLayoutManager.mo2297I();
            if (this.f12245a.f12227k != -1) {
                this.f12245a.f12228l = betterLayoutManager.m17375n();
                int i3 = (this.f12245a.f12228l - this.f12245a.f12227k) + 1;
                int s = this.f12245a.mo2404s();
                this.f12245a.f12218a = i2;
                if (this.f12245a.f12221e != null) {
                    this.f12245a.f12221e.mo1263a(this.f12245a, this.f12245a.f12227k, i3, s);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    ((OnScrollListener) this.f12245a.f12220d.get(i4)).mo1263a(this.f12245a, this.f12245a.f12227k, i3, s);
                }
                this.f12245a.f12218a = 0;
            }
        }
    }

    public static void m18044a(Object obj, Context context) {
        ((RecyclerViewProxy) obj).f12226j = IdBasedSingletonScopeProvider.m1810b(FbInjector.get(context), 494);
    }

    public final void mo2368b(ListScrollStateSnapshot listScrollStateSnapshot) {
        mo2378d(listScrollStateSnapshot.f13816a, -listScrollStateSnapshot.f13818c);
    }

    public RecyclerViewProxy(BetterRecyclerView betterRecyclerView) {
        Preconditions.checkState(betterRecyclerView.getLayoutManager() instanceof BetterLayoutManager);
        this.f12219c = betterRecyclerView;
        this.f12219c.mo2191a(new C05106(this));
        this.f12219c.setTag(2131558446, new WeakReference(this));
        Class cls = RecyclerViewProxy.class;
        m18044a((Object) this, getContext());
    }

    public final View ix_() {
        return this.f12219c;
    }

    public final ViewGroup mo2363b() {
        return this.f12219c;
    }

    public final BetterListView mo2377d() {
        throw Throwables.propagate(new MethodNotSupportedException("RecyclerViewProxy has no BetterListView to expose."));
    }

    public final void mo2351a(View view, Object obj, boolean z) {
        this.f12224h.add(view);
        m18042H();
    }

    public final void mo2366b(View view, Object obj, boolean z) {
        this.f12225i.add(view);
        m18042H();
    }

    public final void mo2350a(View view) {
        this.f12224h.remove(view);
        m18042H();
    }

    public final void mo2365b(View view) {
        this.f12225i.remove(view);
        m18042H();
    }

    public final void mo2357a(OnScrollListener onScrollListener) {
        this.f12221e = onScrollListener;
    }

    public final void mo2398m() {
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0);
        this.f12219c.dispatchTouchEvent(obtain);
        obtain.recycle();
    }

    public final void mo2370b(boolean z) {
        this.f12219c.setVerticalScrollBarEnabled(z);
    }

    public final void mo2375c(boolean z) {
        m18043I();
    }

    public final boolean mo2399n() {
        return mo2401p() == 0 || (m18040F() == 0 && mo2386f(0).getTop() >= 0);
    }

    public final boolean mo2397l() {
        return mo2401p() == 0 || (mo2403r() == mo2404s() - 1 && mo2386f(mo2401p() - 1).getBottom() <= mo2381e());
    }

    public final View mo2372c(int i) {
        if (this.f12219c.f11831o == null) {
            if (!this.f12230n) {
                this.f12230n = true;
                ((AbstractFbErrorReporter) this.f12226j.get()).m2340a(f12217b, StringFormatUtil.formatStrLocaleSafe("Attempting to getViewFromIndex without an adapter set (index: %d)", Integer.valueOf(i)));
            }
            return null;
        } else if (i < 0) {
            if (!this.f12230n) {
                this.f12230n = true;
                ((AbstractFbErrorReporter) this.f12226j.get()).m2340a(f12217b, StringFormatUtil.formatStrLocaleSafe("Attempting to getViewFromIndex from an invalid index: %d", Integer.valueOf(i)));
            }
            return null;
        } else {
            int u = i + mo2406u();
            int s = mo2404s() - this.f12225i.size();
            if (u < s) {
                return this.f12219c.getLayoutManager().mo2312c(u);
            }
            if (!this.f12230n) {
                this.f12230n = true;
                ((AbstractFbErrorReporter) this.f12226j.get()).m2340a(f12217b, StringFormatUtil.formatStrLocaleSafe("Attempting to getViewFromIndex from an invalid index: %d, footer index: %d", Integer.valueOf(u), Integer.valueOf(s)));
            }
            return null;
        }
    }

    public final <T extends View> T mo2376d(int i) {
        return this.f12219c.findViewById(i);
    }

    public final int mo2381e() {
        return this.f12219c.getHeight();
    }

    public final void mo2362a(int[] iArr) {
        this.f12219c.getLocationOnScreen(iArr);
    }

    public final int mo2385f() {
        return this.f12219c.getPaddingBottom();
    }

    public final void mo2345a(int i, int i2) {
        this.f12219c.m17142a(0, i);
    }

    public final void mo2373c(int i, int i2) {
        this.f12219c.getBetterLayoutManager().m17373d(i, i2);
    }

    public final int mo2388g() {
        return this.f12219c.getPaddingTop();
    }

    public final int mo2390h() {
        return this.f12219c.getPaddingLeft();
    }

    public final int mo2392i() {
        return this.f12219c.getPaddingRight();
    }

    public final boolean mo2395j() {
        return this.f12219c.getClipToPadding();
    }

    public final void mo2361a(boolean z) {
        this.f12219c.setClipToPadding(z);
    }

    public final void mo2346a(int i, int i2, int i3, int i4) {
        this.f12219c.setPadding(i, i2, i3, i4);
    }

    public final int mo2371c(View view) {
        if (view.getParent() instanceof ViewDiagnosticsWrapperMarker) {
            return this.f12219c.m17158c((View) view.getParent());
        }
        return this.f12219c.m17158c(view);
    }

    public final void mo2360a(Runnable runnable) {
        this.f12219c.post(runnable);
    }

    public final void mo2347a(Drawable drawable) {
        m18043I();
    }

    public final void mo2355a(OnItemClickListener onItemClickListener) {
        this.f12219c.setOnItemClickListener(onItemClickListener == null ? null : new 1(this, onItemClickListener));
    }

    public final void mo2356a(OnItemLongClickListener onItemLongClickListener) {
        BetterRecyclerView.OnItemLongClickListener onItemLongClickListener2;
        if (onItemLongClickListener == null) {
            onItemLongClickListener2 = null;
        } else {
            onItemLongClickListener2 = new 2(this, onItemLongClickListener);
        }
        this.f12219c.setOnItemLongClickListener(onItemLongClickListener2);
    }

    public final void mo2344a(int i) {
        this.f12219c.setVisibility(i);
    }

    public final void mo2379d(View view) {
        mo2351a(view, null, true);
    }

    public final void mo2359a(final RecyclerListener recyclerListener) {
        this.f12219c.setRecyclerListener(recyclerListener == null ? null : new RecyclerView.RecyclerListener(this) {
            final /* synthetic */ RecyclerViewProxy f13578b;

            public final void mo2653a(ViewHolder viewHolder) {
                recyclerListener.mo2652a(viewHolder.f14095a);
            }
        });
    }

    public final void mo2353a(OnDrawListener onDrawListener) {
        this.f12219c.mo2197m();
        this.f12219c.m17042a(onDrawListener);
    }

    public final void mo2364b(int i) {
        m18043I();
    }

    @TargetApi(14)
    public final void mo2396k() {
        this.f12219c.setOverScrollMode(2);
    }

    public final void mo2382e(int i) {
        this.f12219c.m17152b(i);
    }

    public final ListAdapter mo2400o() {
        return this.f12223g;
    }

    public final int mo2401p() {
        return this.f12219c.getChildCount();
    }

    public final View mo2386f(int i) {
        return this.f12219c.getChildAt(i);
    }

    public final int mo2402q() {
        if (this.f12229m != 0) {
            return this.f12227k;
        }
        return m18040F();
    }

    public final int mo2403r() {
        if (this.f12229m != 0) {
            return this.f12228l;
        }
        return m18041G();
    }

    public final int mo2404s() {
        return this.f12222f != null ? this.f12222f.aZ_() : 0;
    }

    public final boolean mo2405t() {
        return this.f12222f == null || this.f12222f.aZ_() == 0;
    }

    public final Object mo2389g(int i) {
        return this.f12222f != null ? this.f12222f.getItem(i) : null;
    }

    public final int mo2406u() {
        return this.f12224h.size();
    }

    public final int mo2407v() {
        return this.f12225i.size();
    }

    public final void mo2369b(OnScrollListener onScrollListener) {
        this.f12220d.add(onScrollListener);
    }

    public final void mo2367b(OnDrawListener onDrawListener) {
        this.f12219c.m17042a(onDrawListener);
    }

    public final void mo2383e(View view) {
        mo2366b(view, null, true);
    }

    public final void mo2387f(View view) {
        this.f12219c.setEmptyView(view);
    }

    public final void mo2349a(OnTouchListener onTouchListener) {
        this.f12219c.setOnTouchListener(onTouchListener);
    }

    public final void mo2358a(final OnTouchDownListener onTouchDownListener) {
        this.f12219c.f11788u = onTouchDownListener == null ? null : new BetterRecyclerView.OnTouchDownListener(this) {
            final /* synthetic */ RecyclerViewProxy f13802b;

            public final void mo2673a() {
                onTouchDownListener.mo2672a(this.f13802b);
            }
        };
    }

    public final void mo2352a(5 5) {
        this.f12219c.f11791x = 5 == null ? null : new 5(this, 5);
    }

    public final void mo2380d(boolean z) {
        this.f12219c.setBroadcastInteractionChanges(z);
    }

    public void mo2339a(ListAdapter listAdapter) {
        if (listAdapter == null) {
            this.f12222f = null;
            this.f12223g = null;
            this.f12219c.setAdapter(null);
        } else if (listAdapter instanceof FbListAdapter) {
            this.f12223g = listAdapter;
            this.f12222f = new RecyclerViewAdapterWithHeadersAndFooters(new DelegatingAdapter((FbListAdapter) listAdapter, this.f12219c));
            m18042H();
            this.f12219c.setAdapter(this.f12222f);
        } else {
            throw Throwables.propagate(new MethodNotSupportedException("RecyclerViewProxy can only create delegate for Adapters which implement FbListAdapter"));
        }
    }

    public void mo2340a(AdapterCompatibleWithListView<? extends ViewHolder> adapterCompatibleWithListView) {
        if (adapterCompatibleWithListView == null) {
            this.f12222f = null;
            this.f12223g = null;
            this.f12219c.setAdapter(null);
            return;
        }
        this.f12223g = new ListViewAdapterWrapper(adapterCompatibleWithListView);
        this.f12222f = new RecyclerViewAdapterWithHeadersAndFooters(adapterCompatibleWithListView);
        m18042H();
        this.f12219c.setAdapter(this.f12222f);
    }

    public final void mo2391h(int i) {
        this.f12219c.m17141a(i);
    }

    public final void mo2378d(int i, int i2) {
        if (!this.f12219c.getClipToPadding()) {
            i2 -= mo2388g();
        }
        this.f12219c.mo2195g(i, i2);
    }

    public final void mo2408w() {
        this.f12219c.m17141a(mo2406u());
    }

    public final void mo2374c(OnScrollListener onScrollListener) {
        this.f12220d.remove(onScrollListener);
    }

    public final void mo2409x() {
        this.f12219c.mo2197m();
    }

    public final void mo2410y() {
        this.f12219c.destroyDrawingCache();
    }

    public final void mo2354a(ListScrollStateSnapshot listScrollStateSnapshot) {
        int i;
        int height;
        int G;
        int i2 = 0;
        View f = mo2386f(0);
        View f2 = mo2386f(mo2401p() - 1);
        int F = f != null ? m18040F() : 0;
        if (f != null) {
            i = -f.getTop();
        } else {
            i = 0;
        }
        if (f != null) {
            height = f.getHeight();
        } else {
            height = 0;
        }
        if (f2 != null) {
            G = m18041G();
        } else {
            G = 0;
        }
        if (f2 != null) {
            i2 = f2.getBottom();
        }
        listScrollStateSnapshot.m20223a(F, height, i, G, i2);
    }

    public final int mo2411z() {
        return this.f12218a;
    }

    public final void mo2384e(boolean z) {
    }

    public final ImmutableMap<Long, Integer> mo2341A() {
        Map linkedHashMap = new LinkedHashMap();
        int q = mo2402q();
        int r = mo2403r();
        Adapter adapter = this.f12219c.f11831o;
        while (q <= r && q < adapter.aZ_()) {
            View f = mo2386f(q);
            if (f != null) {
                linkedHashMap.put(Long.valueOf((long) q), Integer.valueOf(f.getTop()));
            }
            q++;
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    public final long mo2393i(int i) {
        return (long) i;
    }

    public final Parcelable mo2342B() {
        return this.f12219c.onSaveInstanceState();
    }

    public final void mo2348a(Parcelable parcelable) {
        this.f12219c.onRestoreInstanceState(parcelable);
    }

    public final boolean mo2343C() {
        return this.f12219c.f11773E;
    }

    public Context getContext() {
        return this.f12219c.getContext();
    }

    private int m18040F() {
        return this.f12219c.getBetterLayoutManager().mo2297I();
    }

    private int m18041G() {
        return this.f12219c.getBetterLayoutManager().m17375n();
    }

    private void m18042H() {
        if (this.f12222f != null) {
            this.f12222f.m17238a(this.f12224h);
            this.f12222f.m17240b(this.f12225i);
        }
    }

    private static void m18043I() {
        throw Throwables.propagate(new MethodNotSupportedException("RecyclerViewProxy has not yet implemented this method."));
    }
}
