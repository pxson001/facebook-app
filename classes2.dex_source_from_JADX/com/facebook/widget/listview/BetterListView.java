package com.facebook.widget.listview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.NoSaveStateView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.R;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.OnDrawListenerSet;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.ScrollableView;
import com.facebook.widget.listeners.BetterViewOnScrollListener;
import com.facebook.widget.listview.ScrollState.ScrollPosition;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.touch.MultitouchResampler;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: messenger_customization_threadbased_holdout */
public class BetterListView extends ListView implements NoSaveStateView, ScrollableView {
    private static final Class<?> f14050a = BetterListView.class;
    public boolean f14051A = false;
    public BetterViewOnScrollListener f14052b;
    private MultitouchResampler f14053c;
    private MotionEvent f14054d;
    public DefaultUserInteractionController f14055e;
    public MonotonicClock f14056f;
    private OnScrollListener f14057g;
    private OnPreDrawListener f14058h;
    private Runnable f14059i;
    public int f14060j = 0;
    private boolean f14061k = true;
    private boolean f14062l;
    private boolean f14063m;
    private boolean f14064n;
    private MyDataSetObserver f14065o;
    private boolean f14066p = true;
    private OnDrawListenerSet f14067q;
    public StickyHeader f14068r;
    private long f14069s;
    public MeasuringListViewScrollListenerProvider f14070t;
    private int f14071u;
    public boolean f14072v;
    private boolean f14073w;
    private boolean f14074x;
    public OnTouchDownListener f14075y;
    public OnInterceptTouchEventListener f14076z;

    private static <T extends View> void m20355a(Class<T> cls, T t) {
        m20356a((Object) t, t.getContext());
    }

    private static void m20356a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        BetterListView betterListView = (BetterListView) obj;
        DefaultUserInteractionController a = DefaultUserInteractionController.m1747a(injectorLike);
        MonotonicClock a2 = AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike);
        MeasuringListViewScrollListenerProvider measuringListViewScrollListenerProvider = (MeasuringListViewScrollListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MeasuringListViewScrollListenerProvider.class);
        BetterViewOnScrollListener a3 = BetterViewOnScrollListener.a(injectorLike);
        betterListView.f14055e = a;
        betterListView.f14056f = a2;
        betterListView.f14070t = measuringListViewScrollListenerProvider;
        betterListView.f14052b = a3;
    }

    public final void m20372b(ListScrollStateSnapshot listScrollStateSnapshot) {
        setSelectionFromTop(listScrollStateSnapshot.f13816a, -listScrollStateSnapshot.f13818c);
    }

    public BetterListView(Context context) {
        super(context);
        m20351a(context, null, 0);
    }

    public BetterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20351a(context, attributeSet, 0);
    }

    public BetterListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20351a(context, attributeSet, i);
    }

    private void m20351a(Context context, AttributeSet attributeSet, int i) {
        m20355a(BetterListView.class, (View) this);
        super.setOnScrollListener(this.f14052b);
        this.f14057g = new 1(this);
        this.f14059i = new 2(this);
        this.f14058h = new 3(this);
        this.f14067q = new OnDrawListenerSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterListView, i, 0);
        this.f14073w = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.f14066p = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f14066p) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f14066p) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    public ViewGroup asViewGroup() {
        return this;
    }

    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.f14052b.b = onScrollListener;
    }

    public final void mo2699a(OnScrollListener onScrollListener) {
        this.f14052b.b(onScrollListener);
    }

    public final void m20371b(OnScrollListener onScrollListener) {
        this.f14052b.a.remove(onScrollListener);
    }

    public void setOnScrollListenerLogging(int i) {
        MeasuringListViewScrollListenerProvider measuringListViewScrollListenerProvider = this.f14070t;
        super.setOnScrollListener(new MeasuringListViewScrollListener(QuickPerformanceLoggerMethodAutoProvider.m2859a(measuringListViewScrollListenerProvider), Random_InsecureRandomMethodAutoProvider.m2102a(measuringListViewScrollListenerProvider), Integer.valueOf(i), this.f14052b));
    }

    protected BetterViewOnScrollListener getOnScrollListenerProxy() {
        return this.f14052b;
    }

    public void setBroadcastInteractionChanges(boolean z) {
        if (z) {
            mo2699a(this.f14057g);
        } else {
            m20371b(this.f14057g);
        }
    }

    public void setPreventScrollListenerDuringLayout(boolean z) {
        this.f14051A = z;
    }

    public void setOnTouchDownListener(OnTouchDownListener onTouchDownListener) {
        this.f14075y = onTouchDownListener;
    }

    public void setInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.f14076z = onInterceptTouchEventListener;
    }

    public static void m20360b(BetterListView betterListView, int i) {
        if (i != betterListView.f14060j) {
            betterListView.f14060j = i;
            if (i == 0) {
                betterListView.f14055e.m1755b((View) betterListView);
                return;
            }
            betterListView.f14055e.m1753a((View) betterListView);
            betterListView.postDelayed(betterListView.f14059i, 3000);
        }
    }

    private void m20363g() {
        this.f14069s = this.f14056f.now();
    }

    public static void m20364h(BetterListView betterListView) {
        long now = betterListView.f14056f.now();
        if (betterListView.f14060j != 0) {
            long j = betterListView.f14069s + 3000;
            if (now >= j) {
                m20360b(betterListView, 0);
                return;
            }
            betterListView.postDelayed(betterListView.f14059i, j - now);
        }
    }

    public final boolean m20370a() {
        return getChildCount() == 0 || (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0);
    }

    @SuppressLint({"ImprovedNewApi"})
    public boolean canScrollVertically(int i) {
        if (i >= 0) {
            return super.canScrollVertically(i);
        }
        int paddingTop = getClipToPadding() ? 0 : getPaddingTop();
        if (getChildAt(0) == null || getChildAt(0).getTop() >= paddingTop) {
            return false;
        }
        return true;
    }

    @DoNotStrip
    public boolean isAtBottom() {
        return getChildCount() == 0 || (getLastVisiblePosition() == this.f14071u - 1 && getChildAt(getChildCount() - 1).getBottom() <= getHeight());
    }

    public final void m20369a(ListScrollStateSnapshot listScrollStateSnapshot) {
        int i;
        int height;
        int lastVisiblePosition;
        int i2 = 0;
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(getChildCount() - 1);
        int firstVisiblePosition = childAt != null ? getFirstVisiblePosition() : 0;
        if (childAt != null) {
            i = -childAt.getTop();
        } else {
            i = 0;
        }
        if (childAt != null) {
            height = childAt.getHeight();
        } else {
            height = 0;
        }
        if (childAt2 != null) {
            lastVisiblePosition = getLastVisiblePosition();
        } else {
            lastVisiblePosition = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getBottom();
        }
        listScrollStateSnapshot.m20223a(firstVisiblePosition, height, i, lastVisiblePosition, i2);
    }

    public ScrollState getScrollState() {
        return new ScrollState(getScrollPosition(), getOffsetsOfVisibleItems());
    }

    public ScrollPosition getScrollPosition() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        boolean isStackFromBottom = isStackFromBottom();
        int i = this.f14071u;
        if (isStackFromBottom) {
            if (i == 0 || lastVisiblePosition == i - 1) {
                return ScrollPosition.BOTTOM;
            }
            if (firstVisiblePosition == 0) {
                return ScrollPosition.TOP;
            }
        } else if (i == 0 || firstVisiblePosition == 0) {
            return ScrollPosition.TOP;
        } else {
            if (lastVisiblePosition == i - 1) {
                return ScrollPosition.BOTTOM;
            }
        }
        return ScrollPosition.MIDDLE;
    }

    public ImmutableMap<Long, Integer> getOffsetsOfVisibleItems() {
        if (this.f14072v) {
            return getOffsetsOfVisibleItemsWhenInSync();
        }
        return getOffsetsOfVisibleItemsWhenNotInSync();
    }

    private ImmutableMap<Long, Integer> getOffsetsOfVisibleItemsWhenInSync() {
        Preconditions.checkState(this.f14072v);
        Map d = Maps.m840d();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        ListAdapter adapter = getAdapter();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < adapter.getCount()) {
            long itemId = adapter.getItemId(i);
            if (itemId != Long.MIN_VALUE) {
                View childAt = getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    d.put(Long.valueOf(itemId), Integer.valueOf(childAt.getTop()));
                }
            }
            i++;
        }
        return ImmutableMap.copyOf(d);
    }

    private ImmutableMap<Long, Integer> getOffsetsOfVisibleItemsWhenNotInSync() {
        boolean z;
        int i = 0;
        if (this.f14072v) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        Map d = Maps.m840d();
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                Object a = ListViewItemWithDataUtil.a(childAt);
                if (a != null && (a instanceof DataItemWithId)) {
                    long a2 = ((DataItemWithId) a).a();
                    if (a2 != Long.MIN_VALUE) {
                        d.put(Long.valueOf(a2), Integer.valueOf(childAt.getTop()));
                    }
                }
            }
            i++;
        }
        return ImmutableMap.copyOf(d);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1871302560);
        getViewTreeObserver().addOnPreDrawListener(this.f14058h);
        super.onAttachedToWindow();
        this.f14062l = true;
        m20358b(getAdapter());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1240708457, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2088298725);
        this.f14063m = true;
        getViewTreeObserver().removeOnPreDrawListener(this.f14058h);
        super.onDetachedFromWindow();
        this.f14055e.m1755b((View) this);
        this.f14062l = false;
        m20362c(getAdapter());
        this.f14063m = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 482569917, a);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f14068r != null) {
            StickyHeader stickyHeader = this.f14068r;
            boolean z = false;
            if (stickyHeader.e != null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    Rect rect = new Rect();
                    stickyHeader.e.getHitRect(rect);
                    rect.offsetTo(0, 0);
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        stickyHeader.d = true;
                    }
                }
                if (stickyHeader.d) {
                    if (action == 0) {
                        z = true;
                    } else if (action == 1 || action == 3) {
                        stickyHeader.d = false;
                        z = true;
                    }
                    if (z) {
                        stickyHeader.e.invalidate();
                    }
                    z = stickyHeader.e.dispatchTouchEvent(MotionEvent.obtain(motionEvent));
                }
            }
            if (z) {
                invalidate();
                return true;
            }
        }
        if (this.f14075y != null && motionEvent.getActionMasked() == 0) {
            this.f14075y.a();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1792070108);
        if (VERSION.SDK_INT < 14 || VERSION.SDK_INT > 15 || this.f14064n) {
            z = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 935684481, a);
            return z;
        }
        if (this.f14053c == null) {
            this.f14053c = new MultitouchResampler();
        }
        if (isEnabled()) {
            this.f14053c.a(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (this.f14054d != null) {
                        this.f14054d.recycle();
                    }
                    this.f14054d = MotionEvent.obtain(motionEvent);
                    invalidate();
                    LogUtils.a(-1977027973, a);
                    return true;
                default:
                    if (this.f14054d != null) {
                        this.f14054d.recycle();
                        this.f14054d = null;
                    }
                    z = super.onTouchEvent(motionEvent);
                    LogUtils.a(1590233795, a);
                    return z;
            }
        }
        if (!(isClickable() || isLongClickable())) {
            z = false;
        }
        LogUtils.a(1664276489, a);
        return z;
    }

    private long getNextEstimatedDrawTime() {
        return SystemClock.uptimeMillis();
    }

    private void m20365i() {
        if (this.f14054d != null) {
            MotionEvent a = this.f14053c.a(this.f14054d, 2, getNextEstimatedDrawTime());
            this.f14054d.recycle();
            this.f14054d = null;
            this.f14064n = true;
            super.onTouchEvent(a);
            this.f14064n = false;
            a.recycle();
        }
    }

    private View m20361c(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    @Nullable
    public final View m20366a(int i) {
        if (getAdapter() == null || i < 0) {
            return null;
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        if (headerViewsCount < getAdapter().getCount() - getFooterViewsCount()) {
            return m20361c(headerViewsCount);
        }
        return null;
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        ListAdapter adapter = getAdapter();
        if (adapter != listAdapter) {
            m20362c(adapter);
            m20358b(listAdapter);
        }
        if (this.f14068r != null) {
            this.f14068r.c = m20350a(listAdapter);
        }
        super.setAdapter(listAdapter);
    }

    public void layoutChildren() {
        if (BLog.b(2)) {
            getListViewLayoutModeDebugString();
            Boolean.valueOf(this.f14074x);
        }
        ScrollPosition scrollPosition = getScrollPosition();
        super.layoutChildren();
        this.f14071u = getCount();
        this.f14072v = true;
        if (this.f14074x) {
            if (scrollPosition == ScrollPosition.BOTTOM) {
                setSelection(getCount() - 1);
            }
            this.f14074x = false;
        }
        if (BLog.b(2)) {
            getListViewLayoutModeDebugString();
            getScrollPosition();
        }
    }

    protected void handleDataChanged() {
        super.handleDataChanged();
        if (BLog.b(2)) {
            getListViewLayoutModeDebugString();
        }
    }

    public final boolean m20373b() {
        int childCount = getChildCount();
        int lastVisiblePosition = getLastVisiblePosition();
        if (childCount <= 0 || lastVisiblePosition != this.f14071u - 1) {
            if (childCount == 0) {
                return true;
            }
        } else if (getChildAt(getChildCount() - 1).getBottom() == getHeight() - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    @TargetApi(14)
    public final void m20374c() {
        setOverScrollMode(2);
    }

    public boolean isAttachedToWindow() {
        return this.f14062l;
    }

    public void setStickyHeaderEnabled(boolean z) {
        if (z && this.f14068r == null) {
            this.f14068r = new StickyHeader(this, m20350a(getAdapter()));
            invalidate();
        } else if (!z && this.f14068r != null) {
            this.f14068r = null;
            invalidate();
        }
    }

    private static StickyHeaderAdapter m20350a(ListAdapter listAdapter) {
        if (listAdapter == null) {
            return null;
        }
        if (listAdapter instanceof HeaderViewListAdapter) {
            Object wrappedAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            ListAdapter listAdapter2 = listAdapter;
        }
        if (wrappedAdapter instanceof StickyHeaderAdapter) {
            return (StickyHeaderAdapter) wrappedAdapter;
        }
        throw new RuntimeException(wrappedAdapter.getClass().getName() + " must implement StickyHeaderAdapter");
    }

    @Nullable
    public StickyHeader getStickyHeader() {
        return this.f14068r;
    }

    public int getCurrentScrollState() {
        return this.f14060j;
    }

    public void setClipToPadding(boolean z) {
        this.f14061k = z;
        super.setClipToPadding(z);
    }

    public boolean getClipToPadding() {
        if (VERSION.SDK_INT >= 21) {
            return super.getClipToPadding();
        }
        return this.f14061k;
    }

    public final void m20375d() {
        if (this.f14073w && getTranscriptMode() == 1 && this.f14060j == 0) {
            this.f14074x = true;
            requestLayout();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f14067q.m17178a();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1615667991);
        super.onSizeChanged(i, i2, i3, i4);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1413651264, a);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f14076z != null) {
            z = this.f14076z.a(motionEvent);
        }
        if (z) {
            return z;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void m20358b(@Nullable ListAdapter listAdapter) {
        if (listAdapter != null && this.f14065o == null) {
            this.f14065o = new MyDataSetObserver(this);
            listAdapter.registerDataSetObserver(this.f14065o);
        }
    }

    private void m20362c(@Nullable ListAdapter listAdapter) {
        if (listAdapter != null && this.f14065o != null) {
            listAdapter.unregisterDataSetObserver(this.f14065o);
            this.f14065o = null;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14068r != null) {
            this.f14068r.a(canvas);
        }
    }

    public final void m20368a(OnDrawListener onDrawListener) {
        this.f14067q.m17179a(onDrawListener);
    }

    public final void m20376e() {
        this.f14067q.m17180b();
    }

    public void setOnDrawListenerTo(OnDrawListener onDrawListener) {
        this.f14067q.m17181b(onDrawListener);
    }

    public final boolean m20377f() {
        return this.f14072v;
    }

    private String getListViewLayoutModeDebugString() {
        String str;
        switch (ListViewReflectionUtil.a(this)) {
            case 0:
                str = "LAYOUT_NORMAL";
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = "LAYOUT_FORCE_TOP";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = "LAYOUT_SET_SELECTION";
                break;
            case 3:
                str = "LAYOUT_FORCE_BOTTOM";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = "LAYOUT_SPECIFIC";
                break;
            case 5:
                str = "LAYOUT_SYNC";
                break;
            case 6:
                str = "LAYOUT_MOVE_SELECTION";
                break;
            default:
                str = "unknown";
                break;
        }
        return str;
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        if (getAdapter() != null) {
            throw new IllegalStateException("Phones up until 4.4 may crash if addHeaderView is called after setAdapter.  Keep the header permanently added and use visibility instead");
        }
        super.addHeaderView(view, obj, z);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, false);
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.f14063m) {
            return false;
        }
        return super.performItemClick(view, i, j);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            if (this.f14051A) {
                this.f14052b.a(false);
            }
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            this.f14052b.a(true);
        }
    }
}
