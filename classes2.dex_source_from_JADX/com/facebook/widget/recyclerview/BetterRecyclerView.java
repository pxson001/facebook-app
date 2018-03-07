package com.facebook.widget.recyclerview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.OnDrawListenerSet;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nux_completed */
public class BetterRecyclerView extends RecyclerView {
    private boolean f11769A;
    private boolean f11770B;
    public int f11771C = 0;
    private int f11772D;
    public boolean f11773E;
    public RecyclerListener f11774F;
    @Inject
    public DefaultUserInteractionController f11775h;
    @Inject
    public MeasuringRecyclerViewScrollListenerProvider f11776i;
    @Inject
    public BetterRecyclerViewOnScrollListener f11777j;
    @Inject
    public DefaultAndroidThreadUtil f11778k;
    private final OnDrawListenerSet f11779l = new OnDrawListenerSet();
    private final EmptyAdapterDataObserver f11780m = new EmptyAdapterDataObserver(this);
    public final GestureDetector f11781n = new GestureDetector(getContext(), new ClickGestureListener(this));
    public final GestureDetector f11782o = new GestureDetector(getContext(), new LongClickGestureListener(this));
    private final OnItemTouchListener f11783p = new OnItemTouchListenerForClick(this);
    private final OnItemTouchListener f11784q = new OnItemTouchListenerForLongClick(this);
    private final SimpleAdapterDataObserver f11785r = new C04931(this);
    private final SimpleAdapterDataObserver f11786s = new C04942(this);
    @Nullable
    private View f11787t;
    public OnTouchDownListener f11788u;
    public OnItemClickListener f11789v;
    public OnItemLongClickListener f11790w;
    public OnInterceptTouchEventListener f11791x;
    private InteractionListener f11792y;
    private boolean f11793z;

    /* compiled from: nux_completed */
    class EmptyAdapterDataObserver extends AdapterDataObserver {
        final /* synthetic */ BetterRecyclerView f11852a;

        public EmptyAdapterDataObserver(BetterRecyclerView betterRecyclerView) {
            this.f11852a = betterRecyclerView;
        }

        public final void bb_() {
            this.f11852a.m17040p();
        }

        public final void mo2210b(int i, int i2) {
            this.f11852a.m17040p();
        }

        public final void mo2212c(int i, int i2) {
            this.f11852a.m17040p();
        }
    }

    /* compiled from: nux_completed */
    class ClickGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ BetterRecyclerView f11853a;

        public ClickGestureListener(BetterRecyclerView betterRecyclerView) {
            this.f11853a = betterRecyclerView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View a = this.f11853a.m17139a(motionEvent.getX(), motionEvent.getY());
            if (!(a == null || this.f11853a.f11789v == null)) {
                int d = RecyclerView.m17093d(a);
                if (d != -1) {
                    this.f11853a.f11789v.m17252a(this.f11853a, a, d, this.f11853a.m17168f(a));
                }
            }
            return true;
        }
    }

    /* compiled from: nux_completed */
    class LongClickGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ BetterRecyclerView f11854a;

        public LongClickGestureListener(BetterRecyclerView betterRecyclerView) {
            this.f11854a = betterRecyclerView;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View a = this.f11854a.m17139a(motionEvent.getX(), motionEvent.getY());
            if (a != null && this.f11854a.f11790w != null) {
                int d = RecyclerView.m17093d(a);
                if (d != -1 && this.f11854a.f11790w.m17253a(this.f11854a, a, d, this.f11854a.m17168f(a))) {
                    this.f11854a.performHapticFeedback(0);
                }
            }
        }
    }

    /* compiled from: nux_completed */
    class OnItemTouchListenerForClick implements OnItemTouchListener {
        final /* synthetic */ BetterRecyclerView f11855a;

        public OnItemTouchListenerForClick(BetterRecyclerView betterRecyclerView) {
            this.f11855a = betterRecyclerView;
        }

        public final boolean mo2214a(MotionEvent motionEvent) {
            this.f11855a.f11781n.onTouchEvent(motionEvent);
            return false;
        }

        public final void mo2215b(MotionEvent motionEvent) {
        }

        public final void mo2213a(boolean z) {
        }
    }

    /* compiled from: nux_completed */
    class OnItemTouchListenerForLongClick implements OnItemTouchListener {
        final /* synthetic */ BetterRecyclerView f11856a;

        public OnItemTouchListenerForLongClick(BetterRecyclerView betterRecyclerView) {
            this.f11856a = betterRecyclerView;
        }

        public final boolean mo2214a(MotionEvent motionEvent) {
            this.f11856a.f11782o.onTouchEvent(motionEvent);
            return false;
        }

        public final void mo2215b(MotionEvent motionEvent) {
        }

        public final void mo2213a(boolean z) {
        }
    }

    /* compiled from: nux_completed */
    class C04931 extends SimpleAdapterDataObserver {
        final /* synthetic */ BetterRecyclerView f11857a;

        C04931(BetterRecyclerView betterRecyclerView) {
            this.f11857a = betterRecyclerView;
        }

        public final void mo2216b() {
            this.f11857a.f11778k.m1654a("The Adapter must be notified of changes on the UI thread.");
        }
    }

    /* compiled from: nux_completed */
    class C04942 extends SimpleAdapterDataObserver {
        final /* synthetic */ BetterRecyclerView f11858a;

        C04942(BetterRecyclerView betterRecyclerView) {
            this.f11858a = betterRecyclerView;
        }

        public final void mo2216b() {
            this.f11858a.f11773E = false;
        }
    }

    /* compiled from: nux_completed */
    public interface OnItemClickListener {
        void m17252a(BetterRecyclerView betterRecyclerView, View view, int i, long j);
    }

    /* compiled from: nux_completed */
    public interface OnItemLongClickListener {
        boolean m17253a(BetterRecyclerView betterRecyclerView, View view, int i, long j);
    }

    /* compiled from: nux_completed */
    public interface OnTouchDownListener {
        void mo2673a();
    }

    /* compiled from: nux_completed */
    public interface OnInterceptTouchEventListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: nux_completed */
    class InteractionListener extends OnScrollListener {
        final /* synthetic */ BetterRecyclerView f11878a;

        public InteractionListener(BetterRecyclerView betterRecyclerView) {
            this.f11878a = betterRecyclerView;
        }

        public final void mo2219a(RecyclerView recyclerView, int i) {
            if (i != this.f11878a.f11771C) {
                this.f11878a.f11771C = i;
                if (i == 0) {
                    this.f11878a.f11775h.m1755b(this.f11878a);
                } else {
                    this.f11878a.f11775h.m1753a(this.f11878a);
                }
            }
        }
    }

    private static <T extends View> void m17030a(Class<T> cls, T t) {
        m17031a((Object) t, t.getContext());
    }

    private static void m17031a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) obj;
        DefaultUserInteractionController a = DefaultUserInteractionController.m1747a(injectorLike);
        MeasuringRecyclerViewScrollListenerProvider measuringRecyclerViewScrollListenerProvider = (MeasuringRecyclerViewScrollListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MeasuringRecyclerViewScrollListenerProvider.class);
        BetterRecyclerViewOnScrollListener b = BetterRecyclerViewOnScrollListener.m17207b(injectorLike);
        DefaultAndroidThreadUtil b2 = DefaultAndroidThreadUtil.m1646b(injectorLike);
        betterRecyclerView.f11775h = a;
        betterRecyclerView.f11776i = measuringRecyclerViewScrollListenerProvider;
        betterRecyclerView.f11777j = b;
        betterRecyclerView.f11778k = b2;
    }

    public BetterRecyclerView(Context context) {
        super(context);
        mo2187o();
    }

    public BetterRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo2187o();
    }

    public BetterRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo2187o();
    }

    private void mo2187o() {
        m17030a(BetterRecyclerView.class, (View) this);
        super.setOnScrollListener(this.f11777j);
        this.f11772D = super.getVisibility();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f11777j.f11863e = onScrollListener;
    }

    public final void mo2191a(OnScrollListener onScrollListener) {
        this.f11777j.m17211b(onScrollListener);
    }

    public final void mo2192b(OnScrollListener onScrollListener) {
        this.f11777j.m17212c(onScrollListener);
    }

    @TargetApi(14)
    public final void mo2196l() {
        setOverScrollMode(2);
    }

    public void draw(Canvas canvas) {
        TracerDetour.a("BetterRecyclerView.draw", -1552026474);
        try {
            super.draw(canvas);
            try {
                this.f11779l.m17178a();
            } finally {
                TracerDetour.a(678047310);
            }
        } catch (Throwable e) {
            int childCount = getChildCount();
            List arrayList = new ArrayList(childCount);
            for (int i = 0; i < childCount; i++) {
                arrayList.add(getChildAt(i));
            }
            throw new RuntimeException("Expected:" + childCount + " Children:" + arrayList, e);
        }
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f11774F = recyclerListener;
        super.setRecyclerListener(recyclerListener);
    }

    public void setVisibility(int i) {
        this.f11772D = i;
        m17040p();
    }

    public int getVisibility() {
        return this.f11772D;
    }

    public int getRecyclerViewVisibility() {
        return super.getVisibility();
    }

    public void setOnScrollListenerLogging(int i) {
        InjectorLike injectorLike = this.f11776i;
        super.setOnScrollListener(new MeasuringRecyclerViewScrollListener(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), Integer.valueOf(i), this.f11777j));
    }

    public final void m17042a(OnDrawListener onDrawListener) {
        this.f11779l.m17179a(onDrawListener);
    }

    public final void mo2197m() {
        this.f11779l.m17180b();
    }

    public void setEmptyView(@Nullable View view) {
        this.f11787t = view;
        m17040p();
    }

    private void m17040p() {
        int i = 8;
        if (this.f11787t == null) {
            super.setVisibility(this.f11772D);
            return;
        }
        Object obj;
        int i2;
        if (m17032a(this.f11831o)) {
            obj = null;
        } else {
            obj = 1;
        }
        View view = this.f11787t;
        if (obj != null) {
            i2 = this.f11772D;
        } else {
            i2 = 8;
        }
        view.setVisibility(i2);
        if (obj == null) {
            i = this.f11772D;
        }
        super.setVisibility(i);
    }

    private static boolean m17032a(@Nullable Adapter adapter) {
        if (adapter == null) {
            return false;
        }
        if (adapter instanceof RecyclerViewAdapterWithHeadersAndFooters) {
            return ((RecyclerViewAdapterWithHeadersAndFooters) adapter).f11867a.aZ_() > 0;
        } else if (adapter.aZ_() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setOnTouchDownListener(OnTouchDownListener onTouchDownListener) {
        this.f11788u = onTouchDownListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11788u != null && motionEvent.getActionMasked() == 0) {
            this.f11788u.mo2673a();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setBroadcastInteractionChanges(boolean z) {
        if (z) {
            if (this.f11792y == null) {
                this.f11792y = new InteractionListener(this);
            }
            mo2191a(this.f11792y);
            return;
        }
        mo2192b(this.f11792y);
    }

    public void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null && this.f11769A) {
            m17155b(this.f11783p);
        }
        if (!(this.f11769A || onItemClickListener == null)) {
            m17147a(this.f11783p);
        }
        this.f11789v = onItemClickListener;
        this.f11769A = onItemClickListener != null;
    }

    public void setOnItemLongClickListener(@Nullable OnItemLongClickListener onItemLongClickListener) {
        boolean z = true;
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        if (onItemLongClickListener == null && this.f11770B) {
            m17155b(this.f11784q);
        }
        if (!(this.f11770B || onItemLongClickListener == null)) {
            m17147a(this.f11784q);
        }
        this.f11790w = onItemLongClickListener;
        if (onItemLongClickListener == null) {
            z = false;
        }
        this.f11770B = z;
    }

    public void setInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.f11791x = onInterceptTouchEventListener;
    }

    public int getLastVisiblePosition() {
        return getBetterLayoutManager().m17375n();
    }

    public final boolean mo2198n() {
        return this.f11773E;
    }

    public void setClipToPadding(boolean z) {
        this.f11793z = z;
        super.setClipToPadding(z);
    }

    public boolean getClipToPadding() {
        if (VERSION.SDK_INT >= 21) {
            return super.getClipToPadding();
        }
        return this.f11793z;
    }

    @SuppressLint({"ImprovedNewApi"})
    public boolean canScrollVertically(int i) {
        if (i >= 0) {
            return super.canScrollVertically(i);
        }
        int paddingTop = getClipToPadding() ? 0 : getPaddingTop();
        if ((getLayoutManager() == null || !(getLayoutManager() instanceof BetterLayoutManager) || getBetterLayoutManager().mo2297I() <= 0) && (getChildAt(0) == null || getChildAt(0).getTop() >= paddingTop)) {
            return false;
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f11791x != null) {
            z = this.f11791x.onInterceptTouchEvent(motionEvent);
        }
        if (z) {
            return z;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void mo2193d(int i) {
        TracerDetour.a("BetterRecyclerView.offsetChildrenVertical", 1953632976);
        try {
            super.mo2193d(i);
        } finally {
            TracerDetour.a(-2056748962);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11773E = true;
    }

    public void setSelection(int i) {
        m17141a(i);
    }

    public final void mo2195g(int i, int i2) {
        getBetterLayoutManager().m17373d(i, i2);
    }

    public RecyclerListener getRecyclerListener() {
        return this.f11774F;
    }

    protected <T extends BetterLayoutManager> T getBetterLayoutManager() {
        Preconditions.checkState(getLayoutManager() instanceof BetterLayoutManager);
        return (BetterLayoutManager) getLayoutManager();
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.f11831o;
        if (adapter2 != null) {
            adapter2.mo2227b(this.f11780m);
            adapter2.mo2227b(this.f11785r);
            adapter2.mo2227b(this.f11786s);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.mo2223a(this.f11785r);
            adapter.mo2223a(this.f11780m);
            adapter.mo2223a(this.f11786s);
        }
        m17040p();
    }
}
