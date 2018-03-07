package com.facebook.widget.refreshableview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.facebook.R;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;

/* compiled from: reactions_dock_select_3 */
public abstract class RefreshableViewContainer extends ViewGroup implements RefreshableViewContainerLike {
    private static final Class<?> f6151f = RefreshableViewContainer.class;
    public VelocityTracker f6152A;
    public Handler f6153B = new Handler();
    private RetryClickedListener f6154C;
    private Runnable f6155D;
    private Rect f6156E = new Rect();
    private boolean f6157F = false;
    private boolean f6158G = true;
    protected Scroller f6159a;
    public RefreshableViewState f6160b = RefreshableViewState.NORMAL;
    public int f6161c = 0;
    public float f6162d = 0.0f;
    public DefaultUserInteractionController f6163e;
    private int f6164g;
    public float f6165h;
    private OnRefreshListener f6166i;
    private int f6167j;
    private int f6168k = 0;
    public int f6169l = 0;
    private int f6170m;
    private double f6171n = 1.0d;
    private float f6172o = 0.0f;
    public float f6173p = 0.0f;
    private float f6174q;
    private float f6175r = -1.0f;
    private float f6176s = -1.0f;
    private float f6177t = -1.0f;
    private boolean f6178u;
    private boolean f6179v = true;
    private boolean f6180w = false;
    public boolean f6181x = false;
    public MonotonicClock f6182y;
    public long f6183z;

    /* compiled from: reactions_dock_select_3 */
    class C03701 implements RetryClickedListener {
        final /* synthetic */ RefreshableViewContainer f6188a;

        C03701(RefreshableViewContainer refreshableViewContainer) {
            this.f6188a = refreshableViewContainer;
        }

        public final void m8743a() {
            RefreshableViewContainer.m8710a(this.f6188a, RefreshableViewState.LOADING, true);
        }
    }

    /* compiled from: reactions_dock_select_3 */
    class C03712 implements Runnable {
        final /* synthetic */ RefreshableViewContainer f6189a;

        C03712(RefreshableViewContainer refreshableViewContainer) {
            this.f6189a = refreshableViewContainer;
        }

        public void run() {
            this.f6189a.m8733i();
        }
    }

    public static void m8711a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RefreshableViewContainer refreshableViewContainer = (RefreshableViewContainer) obj;
        MonotonicClock monotonicClock = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
        DefaultUserInteractionController a = DefaultUserInteractionController.a(fbInjector);
        refreshableViewContainer.f6182y = monotonicClock;
        refreshableViewContainer.f6163e = a;
    }

    protected abstract boolean mo447a();

    protected abstract boolean mo448a(float f);

    protected abstract boolean mo449b();

    public RefreshableViewContainer(Context context) {
        super(context);
        m8708a(context, null);
    }

    public RefreshableViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8708a(context, attributeSet);
    }

    public RefreshableViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8708a(context, attributeSet);
    }

    private void m8708a(Context context, AttributeSet attributeSet) {
        Class cls = RefreshableViewContainer.class;
        m8711a((Object) this, getContext());
        this.f6159a = new Scroller(context);
        this.f6161c = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefreshListView).getInt(0, 0);
        this.f6164g = (int) (getResources().getDisplayMetrics().density * 5.0f);
        this.f6165h = getResources().getDimension(2131428340);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefreshableListViewContainer);
        this.f6168k = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        this.f6170m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f6154C = new C03701(this);
        this.f6155D = new C03712(this);
    }

    public final ViewGroup mo440c() {
        return this;
    }

    public OnRefreshListener getOnRefreshListener() {
        return this.f6166i;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f6166i = onRefreshListener;
    }

    public int getDirection() {
        return this.f6161c;
    }

    public void setDirection(int i) {
        this.f6161c = i;
    }

    public void setCustomTriggerMultiplier(double d) {
        this.f6171n = d;
    }

    public void setOverflowListOverlap(int i) {
        this.f6168k = getContext().getResources().getDimensionPixelSize(i);
    }

    public void setTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) getHeaderView().findViewById(2131564988).getLayoutParams();
        layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(i);
        getHeaderView().setLayoutParams(layoutParams);
        this.f6169l = layoutParams.topMargin;
    }

    public void setErrorVerticalPadding(int i) {
        getHeaderView().setErrorVerticalPadding(i);
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return true;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        TracerDetour.a("RefreshableListViewContainer.onMeasure", -704144299);
        try {
            int childCount = getChildCount();
            int i4 = 0;
            int i5 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                measureChild(childAt, i, i2);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
                i5 = Math.max(i5, childAt.getMeasuredHeight());
                i3++;
            }
            setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i5, getSuggestedMinimumHeight()), i2));
            this.f6167j = getOverScrollHeaderView().getMeasuredHeight();
        } finally {
            TracerDetour.a(1354421880);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (getChildCount() == 3) {
            TracerDetour.a("RefreshableListViewContainer.onLayout", 713586358);
            try {
                if (this.f6161c == 0) {
                    if (this.f6157F) {
                        i5 = -this.f6168k;
                    }
                    getView().layout(0, i5, i3 - i, i4 - i2);
                    getHeaderHeight();
                    i5 += this.f6168k;
                    getHeaderView().layout(0, i5, i3 - i, getHeaderHeight() + i5);
                    getOverScrollHeaderView().layout(0, i5 - this.f6167j, i3 - i, i5);
                } else if (this.f6161c == 1) {
                    i5 = i4 - i2;
                    getView().layout(0, 0, i3 - i, i5);
                    getHeaderHeight();
                    getHeaderView().layout(0, getHeaderHeight() + i5, i3 - i, i5);
                    getOverScrollHeaderView().layout(0, i5, i3 - i, this.f6167j + i5);
                } else {
                    throw new IllegalStateException("Unknown direction: " + this.f6161c);
                }
                setCurrentHeaderHeightExposed(0.0f);
                m8719j();
            } finally {
                TracerDetour.a(1242608381);
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m8719j();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f6181x;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -386006745);
        if (this.f6181x) {
            Logger.a(2, EntryType.UI_INPUT_END, 429282745, a);
            return false;
        } else if (getView() == null) {
            LogUtils.a(187886266, a);
            return false;
        } else {
            int action = motionEvent.getAction();
            float y = motionEvent.getY();
            boolean a2 = m8713a(motionEvent, action, true, y);
            this.f6174q = y;
            m8719j();
            LogUtils.a(960711372, a);
            return a2;
        }
    }

    private boolean m8713a(MotionEvent motionEvent, int i, boolean z, float f) {
        boolean z2 = true;
        getHeaderView().dispatchTouchEvent(motionEvent);
        switch (i) {
            case 0:
                this.f6152A = VelocityTracker.obtain();
                this.f6152A.addMovement(motionEvent);
                this.f6175r = f;
                this.f6178u = false;
                if (!this.f6159a.isFinished()) {
                    this.f6159a.abortAnimation();
                }
                return m8712a(motionEvent);
            case 1:
            case 3:
                if (this.f6160b == RefreshableViewState.PULL_TO_REFRESH || this.f6160b == RefreshableViewState.PUSH_TO_REFRESH || this.f6160b == RefreshableViewState.BUFFERING || this.f6160b == RefreshableViewState.FINISHED) {
                    m8721a(RefreshableViewState.NORMAL);
                    m8717b(this, false);
                } else if (this.f6160b == RefreshableViewState.LOADING) {
                    m8717b(this, false);
                    if (this.f6162d > ((float) getHeaderHeight())) {
                        this.f6162d = (float) getHeaderHeight();
                    }
                } else if (this.f6160b == RefreshableViewState.NORMAL || this.f6160b == RefreshableViewState.COLLAPSING_AFTER_REFRESH) {
                    this.f6162d = 0.0f;
                } else if (this.f6160b == RefreshableViewState.FAILED) {
                    m8717b(this, false);
                }
                this.f6172o = 0.0f;
                z = m8712a(motionEvent);
                if (this.f6152A == null) {
                    return z;
                }
                this.f6152A.recycle();
                this.f6152A = null;
                return z;
            case 2:
                boolean z3;
                float b;
                boolean z4;
                float f2;
                int triggerHeight;
                View view;
                float f3 = f - this.f6174q;
                if (this.f6160b == RefreshableViewState.NORMAL || this.f6160b == RefreshableViewState.POPUP || this.f6160b == RefreshableViewState.COLLAPSING_AFTER_REFRESH) {
                    if (mo447a()) {
                        z = m8712a(motionEvent);
                        z3 = false;
                        if (this.f6160b != RefreshableViewState.BUFFERING) {
                            b = m8715b(f3);
                            if (this.f6172o >= ((float) this.f6164g)) {
                                m8721a(mo446a(this.f6161c));
                            } else if (this.f6172o == 0.0f) {
                                m8721a(RefreshableViewState.NORMAL);
                            }
                            z4 = false;
                        } else {
                            f2 = f3;
                            z4 = z3;
                            b = f2;
                        }
                        if (this.f6160b != RefreshableViewState.PULL_TO_REFRESH || this.f6160b == RefreshableViewState.PUSH_TO_REFRESH) {
                            m8718c(b);
                            if (this.f6162d != 0.0f) {
                                m8721a(RefreshableViewState.NORMAL);
                            } else {
                                triggerHeight = getTriggerHeight();
                                if (Math.abs(this.f6162d) < ((float) triggerHeight)) {
                                    if (this.f6152A != null) {
                                        this.f6152A.addMovement(motionEvent);
                                    }
                                    m8710a(this, RefreshableViewState.LOADING, true);
                                } else {
                                    getHeaderView().m8764a(Math.round((100.0f * this.f6162d) / ((float) triggerHeight)), 0.0f);
                                }
                                z4 = false;
                            }
                        } else if (mo448a(b) && (this.f6160b == RefreshableViewState.FINISHED || m8720k(this))) {
                            m8718c(b);
                            z4 = false;
                        }
                        if (z4) {
                            z = m8712a(motionEvent);
                        } else if (m8720k(this)) {
                            m8716b(motionEvent);
                        }
                        if (this.f6158G) {
                            return z;
                        }
                        view = getView();
                        if (this.f6162d != 0.0f) {
                            z2 = false;
                        }
                        view.setVerticalScrollBarEnabled(z2);
                        return z;
                    } else if (mo449b() && mo448a(f3)) {
                        m8721a(RefreshableViewState.BUFFERING);
                    }
                }
                z3 = true;
                if (this.f6160b != RefreshableViewState.BUFFERING) {
                    f2 = f3;
                    z4 = z3;
                    b = f2;
                } else {
                    b = m8715b(f3);
                    if (this.f6172o >= ((float) this.f6164g)) {
                        m8721a(mo446a(this.f6161c));
                    } else if (this.f6172o == 0.0f) {
                        m8721a(RefreshableViewState.NORMAL);
                    }
                    z4 = false;
                }
                if (this.f6160b != RefreshableViewState.PULL_TO_REFRESH) {
                    break;
                }
                m8718c(b);
                if (this.f6162d != 0.0f) {
                    triggerHeight = getTriggerHeight();
                    if (Math.abs(this.f6162d) < ((float) triggerHeight)) {
                        getHeaderView().m8764a(Math.round((100.0f * this.f6162d) / ((float) triggerHeight)), 0.0f);
                    } else {
                        if (this.f6152A != null) {
                            this.f6152A.addMovement(motionEvent);
                        }
                        m8710a(this, RefreshableViewState.LOADING, true);
                    }
                    z4 = false;
                } else {
                    m8721a(RefreshableViewState.NORMAL);
                }
                if (z4) {
                    z = m8712a(motionEvent);
                } else if (m8720k(this)) {
                    m8716b(motionEvent);
                }
                if (this.f6158G) {
                    return z;
                }
                view = getView();
                if (this.f6162d != 0.0f) {
                    z2 = false;
                }
                view.setVerticalScrollBarEnabled(z2);
                return z;
            default:
                return m8712a(motionEvent);
        }
    }

    private int getTriggerHeight() {
        return ((int) (((double) getHeaderHeight()) + (((double) (0.03f * ((float) getHeight()))) * this.f6171n))) - this.f6169l;
    }

    private boolean m8712a(MotionEvent motionEvent) {
        View view = getView();
        if (view == null) {
            return false;
        }
        if (view.getVisibility() == 0 && view.getAnimation() == null) {
            float x = motionEvent.getX();
            x += (float) getScrollX();
            float y = motionEvent.getY() + ((float) getScrollY());
            int i = (int) x;
            int i2 = (int) y;
            if (motionEvent.getActionMasked() == 0) {
                view.getHitRect(this.f6156E);
                this.f6180w = this.f6156E.contains(i, i2);
            }
            if (this.f6180w) {
                x -= (float) view.getLeft();
                y -= (float) view.getTop();
                this.f6176s = x;
                this.f6177t = y;
                motionEvent.setLocation(x, y);
                return m8714a(view, motionEvent);
            }
        }
        return true;
    }

    private void m8716b(MotionEvent motionEvent) {
        if (!this.f6178u && Math.abs(motionEvent.getY() - this.f6175r) >= ((float) this.f6170m)) {
            View view = getView();
            if (view.getVisibility() == 0 && view.getAnimation() == null) {
                int i = this.f6170m + 1;
                if (this.f6161c == 1) {
                    i = -i;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation(this.f6176s, this.f6177t - ((float) i));
                m8714a(view, obtain);
                obtain.setLocation(this.f6176s, this.f6177t);
                m8714a(view, obtain);
                this.f6178u = true;
            }
        }
    }

    private static boolean m8714a(View view, MotionEvent motionEvent) {
        try {
            return view.dispatchTouchEvent(motionEvent);
        } catch (Throwable e) {
            BLog.a(f6151f, "Caught and ignoring ArrayIndexOutOfBoundsException", e);
            return true;
        }
    }

    private void m8719j() {
        if (this.f6159a.computeScrollOffset()) {
            this.f6162d = (float) this.f6159a.getCurrY();
            if (!this.f6159a.isFinished()) {
                invalidate();
            }
        }
        if (this.f6160b == RefreshableViewState.COLLAPSING_AFTER_REFRESH && this.f6173p < 1.0E-4f && this.f6162d < 1.0E-4f) {
            m8721a(RefreshableViewState.NORMAL);
        }
        if (this.f6173p != this.f6162d) {
            int i = (int) (this.f6162d - this.f6173p);
            if (i != 0) {
                setCurrentHeaderHeightExposed(this.f6173p + ((float) i));
                getView().offsetTopAndBottom(i);
                getOverScrollHeaderView().offsetTopAndBottom(i);
                int bottom = getOverScrollHeaderView().getBottom();
                int bottom2 = getHeaderView().getBottom();
                View findViewById = getHeaderView().findViewById(2131564991);
                i = findViewById.getHeight() + bottom2;
                findViewById.offsetTopAndBottom(this.f6169l + bottom >= i ? (i - findViewById.getBottom()) - 1 : ((bottom - findViewById.getBottom()) - 1) + this.f6169l);
                findViewById = getHeaderView().findViewById(2131564992);
                findViewById.offsetTopAndBottom(this.f6169l + bottom >= bottom2 ? (bottom2 - findViewById.getTop()) - 1 : ((bottom - findViewById.getTop()) - 1) + this.f6169l);
                invalidate();
            }
        } else if (this.f6159a.isFinished() && this.f6160b == RefreshableViewState.POPUP && this.f6173p != ((float) getHeaderHeight())) {
            m8717b(this, true);
            invalidate();
        }
    }

    public int getHeaderHeight() {
        int measuredHeight = getHeaderView().getMeasuredHeight();
        if (measuredHeight > 0) {
            return measuredHeight;
        }
        getHeaderView().measure(0, 0);
        return getHeaderView().getMeasuredHeight();
    }

    private float m8715b(float f) {
        if (this.f6161c == 0) {
            if (f > 0.0f) {
                this.f6172o += f;
                if (this.f6172o <= ((float) this.f6164g)) {
                    return 0.0f;
                }
                f = this.f6172o - ((float) this.f6164g);
                this.f6172o = (float) this.f6164g;
                return f;
            }
            this.f6172o = 0.0f;
            return f;
        } else if (f < 0.0f) {
            this.f6172o -= f;
            if (this.f6172o <= ((float) this.f6164g)) {
                return 0.0f;
            }
            f = -(this.f6172o - ((float) this.f6164g));
            this.f6172o = (float) this.f6164g;
            return f;
        } else {
            this.f6172o = 0.0f;
            return f;
        }
    }

    private void m8718c(float f) {
        if (!m8720k(this) || ((this.f6161c != 0 || f >= 0.0f) && (this.f6161c != 1 || f <= 0.0f))) {
            float f2 = this.f6162d;
            float f3 = this.f6161c == 0 ? 1.0f : -1.0f;
            f3 *= (float) Math.sqrt((double) Math.max(0.0f, ((f * f3) * this.f6165h) + (f2 * f2)));
            if (Math.abs(f3) < Math.abs(this.f6165h)) {
                f3 = (0.5f * f) + f2;
            }
            this.f6162d = f3;
        } else {
            this.f6162d += f;
        }
        if (this.f6161c == 0) {
            this.f6162d = Math.max(0.0f, this.f6162d);
        } else {
            this.f6162d = Math.min(0.0f, this.f6162d);
        }
    }

    public final void mo441d() {
        if (this.f6160b != RefreshableViewState.LOADING) {
            m8721a(RefreshableViewState.LOADING);
            m8717b(this, true);
        }
    }

    public final void mo442e() {
        if (this.f6160b != RefreshableViewState.LOADING) {
            m8721a(RefreshableViewState.LOADING);
            m8733i();
        }
    }

    public final void mo443f() {
        long now = this.f6182y.now() - this.f6183z;
        now = (now >= 2000 || 1 != 0) ? 0 : 2000 - now;
        HandlerDetour.b(this.f6153B, new Runnable(this, false) {
            final /* synthetic */ RefreshableViewContainer f6191b;

            public void run() {
                if (this.f6191b.mo449b()) {
                    this.f6191b.m8721a(RefreshableViewState.FINISHED);
                } else if (RefreshableViewContainer.m8720k(this.f6191b)) {
                    RefreshableViewContainer.m8710a(this.f6191b, RefreshableViewState.COLLAPSING_AFTER_REFRESH, false);
                    RefreshableViewContainer.m8717b(this.f6191b, true);
                }
            }
        }, now, 355284999);
    }

    public final void m8731g() {
        m8722a(getContext().getResources().getString(2131230811));
    }

    public final void mo439b(int i) {
        m8722a(getContext().getResources().getString(i));
    }

    public void m8722a(String str) {
        if (this.f6160b == RefreshableViewState.LOADING) {
            getHeaderView().m8765a(str, this.f6154C, this.f6155D);
            m8721a(RefreshableViewState.FAILED);
        }
    }

    public void m8732h() {
        if (this.f6160b != RefreshableViewState.BUFFERING) {
            m8721a(RefreshableViewState.BUFFERING);
        }
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        m8709a(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m8709a(drawable);
    }

    private void m8709a(Drawable drawable) {
        RefreshableViewItem headerView = getHeaderView();
        if (headerView != null) {
            CustomViewUtils.b(headerView, drawable);
        }
    }

    public static boolean m8720k(RefreshableViewContainer refreshableViewContainer) {
        return refreshableViewContainer.f6160b == RefreshableViewState.LOADING || refreshableViewContainer.f6160b == RefreshableViewState.FAILED;
    }

    protected final void m8721a(RefreshableViewState refreshableViewState) {
        m8710a(this, refreshableViewState, false);
    }

    public static void m8710a(RefreshableViewContainer refreshableViewContainer, RefreshableViewState refreshableViewState, boolean z) {
        if (!refreshableViewContainer.f6181x && refreshableViewState != refreshableViewContainer.f6160b) {
            RefreshableViewState refreshableViewState2 = refreshableViewContainer.f6160b;
            refreshableViewContainer.f6160b = refreshableViewState;
            RefreshableViewItem headerView = refreshableViewContainer.getHeaderView();
            headerView.setDirection(refreshableViewContainer.f6161c);
            if (refreshableViewState == RefreshableViewState.NORMAL || refreshableViewState == RefreshableViewState.COLLAPSING_AFTER_REFRESH) {
                headerView.f6209o = mo446a(refreshableViewContainer.f6161c);
            } else {
                headerView.f6209o = refreshableViewState;
            }
            if (refreshableViewContainer.f6166i == null) {
                return;
            }
            if (refreshableViewState == RefreshableViewState.LOADING) {
                float yVelocity;
                if (refreshableViewContainer.f6152A != null) {
                    refreshableViewContainer.f6152A.computeCurrentVelocity(1000);
                    yVelocity = refreshableViewContainer.f6152A.getYVelocity();
                } else {
                    yVelocity = 0.0f;
                }
                float f = yVelocity;
                refreshableViewContainer.f6166i.m8745b(z);
                if (refreshableViewContainer.f6160b != RefreshableViewState.FAILED) {
                    refreshableViewContainer.getHeaderView().m8764a(100, f);
                }
                refreshableViewContainer.f6183z = refreshableViewContainer.f6182y.now();
            } else if (refreshableViewState == RefreshableViewState.NORMAL) {
                refreshableViewContainer.f6166i.m8744a();
                refreshableViewContainer.getHeaderView().m8766b();
            } else if (refreshableViewState == RefreshableViewState.FAILED && refreshableViewState2 == RefreshableViewState.LOADING) {
                refreshableViewContainer.getHeaderView().m8763a();
            } else {
                refreshableViewState2 = RefreshableViewState.COLLAPSING_AFTER_REFRESH;
            }
        }
    }

    public static void m8717b(RefreshableViewContainer refreshableViewContainer, boolean z) {
        if (!refreshableViewContainer.f6181x) {
            int i;
            if (refreshableViewContainer.f6160b == RefreshableViewState.POPUP) {
                i = (int) refreshableViewContainer.f6162d;
                refreshableViewContainer.f6159a.startScroll(0, i, 0, refreshableViewContainer.getHeaderHeight() - i, 500);
            } else if (refreshableViewContainer.f6160b == RefreshableViewState.NORMAL || refreshableViewContainer.f6160b == RefreshableViewState.COLLAPSING_AFTER_REFRESH || (m8720k(refreshableViewContainer) && refreshableViewContainer.f6173p + ((float) refreshableViewContainer.f6169l) < ((float) refreshableViewContainer.getHeaderHeight()))) {
                float headerHeight = (float) (refreshableViewContainer.getHeaderHeight() + refreshableViewContainer.f6167j);
                int max = Math.max((int) ((refreshableViewContainer.f6162d / headerHeight) * 1200.0f), 300);
                i = (int) refreshableViewContainer.f6162d;
                int i2 = (int) (headerHeight * 0.05f);
                if (i < i2) {
                    max = (max * i) / i2;
                }
                refreshableViewContainer.f6159a.startScroll(0, i, 0, -i, max);
                refreshableViewContainer.invalidate();
            } else {
                Object obj;
                if (!m8720k(refreshableViewContainer) || refreshableViewContainer.f6173p + ((float) refreshableViewContainer.f6169l) < ((float) refreshableViewContainer.getHeaderHeight()) || z) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    refreshableViewContainer.m8733i();
                } else if (m8720k(refreshableViewContainer) && z) {
                    refreshableViewContainer.invalidate();
                }
            }
        }
    }

    public final void m8733i() {
        if (!this.f6181x) {
            int headerHeight;
            int i = (int) this.f6162d;
            if (this.f6161c == 0) {
                headerHeight = (getHeaderHeight() - i) - this.f6169l;
            } else {
                headerHeight = ((-getHeaderHeight()) - i) - this.f6169l;
            }
            this.f6159a.startScroll(0, i, 0, headerHeight, 500);
            invalidate();
        }
    }

    private static RefreshableViewState mo446a(int i) {
        if (i == 0) {
            return RefreshableViewState.PULL_TO_REFRESH;
        }
        if (i == 1) {
            return RefreshableViewState.PUSH_TO_REFRESH;
        }
        throw new IllegalArgumentException("Unknown direction: " + i);
    }

    private View getOverScrollHeaderView() {
        if (getChildCount() <= 0) {
            return null;
        }
        return getChildAt(0);
    }

    protected RefreshableViewItem getHeaderView() {
        if (getChildCount() <= 0) {
            return null;
        }
        return (RefreshableViewItem) getChildAt(1);
    }

    protected View getView() {
        if (getChildCount() <= 0) {
            return null;
        }
        return getChildAt(2);
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        this.f6158G = z;
    }

    public void setHeaderVisibility(int i) {
        getHeaderView().setVisibility(i);
    }

    public void setOverlapOnBottom(boolean z) {
        this.f6157F = z;
    }

    private void setCurrentHeaderHeightExposed(float f) {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.f6173p < 1.0E-4f) {
            i = 1;
        } else {
            i = 0;
        }
        if (f >= 1.0E-4f) {
            i2 = 0;
        }
        if (i != i2) {
            if (f < 1.0E-4f) {
                i3 = 4;
            }
            setHeaderVisibility(i3);
        }
        this.f6173p = f;
    }
}
