package com.facebook.richdocument.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentMediaSnappingEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentMediaTransitionEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onscreen_time */
public class RichDocumentCollapsingHeaderAndRecyclerViewLayout extends CustomFrameLayout implements NestedScrollingParent {
    @Inject
    public RichDocumentEventBus f7278a;
    private final NestedScrollingParentHelper f7279b;
    private final RichDocumentMediaTransitionEventSubscriber f7280c;
    private final RichDocumentMediaSnappingEventSubscriber f7281d;
    private final RichDocumentStartupUiTasksCompletedSubscriber f7282e;
    private final ValueAnimator f7283f;
    private RecyclerView f7284g;
    private LinearLayoutManager f7285h;
    public CollapsingHeader f7286i;
    private int f7287j;
    private int f7288k;
    private int f7289l;
    private int f7290m;
    public int f7291n;
    public boolean f7292o;
    public MediaTransitionState f7293p;
    public boolean f7294q;
    public boolean f7295r;
    private boolean f7296s;
    public boolean f7297t;

    /* compiled from: onscreen_time */
    public interface CollapsingHeader {
        View mo448a();

        void mo449a(int i);

        int getCollapsedHeight();

        int getCurrentBottom();

        int getCurrentHeight();

        int getExpandedHeight();
    }

    /* compiled from: onscreen_time */
    class C08301 extends RichDocumentMediaTransitionEventSubscriber {
        final /* synthetic */ RichDocumentCollapsingHeaderAndRecyclerViewLayout f7274a;

        C08301(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout) {
            this.f7274a = richDocumentCollapsingHeaderAndRecyclerViewLayout;
        }

        public final void m7541b(FbEvent fbEvent) {
            RichDocumentMediaTransitionEvent richDocumentMediaTransitionEvent = (RichDocumentMediaTransitionEvent) fbEvent;
            MediaTransitionState mediaTransitionState = richDocumentMediaTransitionEvent.f5177b;
            PresentationMode presentationMode = mediaTransitionState.f6981e;
            Orientation orientation = mediaTransitionState.f6982f;
            if (!(this.f7274a.f7292o && presentationMode == this.f7274a.f7293p.f6981e && orientation == this.f7274a.f7293p.f6982f)) {
                this.f7274a.f7292o = true;
                this.f7274a.f7293p = mediaTransitionState;
                if (RichDocumentCollapsingHeaderAndRecyclerViewLayout.m7553a(mediaTransitionState)) {
                    if (this.f7274a.f7286i.getCurrentHeight() != 0) {
                        this.f7274a.f7291n = this.f7274a.f7286i.getCurrentHeight();
                    }
                    this.f7274a.f7294q = true;
                    this.f7274a.m7566e();
                    this.f7274a.m7547a(this.f7274a.f7286i.getCurrentHeight(), 0);
                } else {
                    this.f7274a.f7294q = false;
                    this.f7274a.f7293p;
                    this.f7274a.m7547a(this.f7274a.f7286i.getCurrentHeight(), this.f7274a.f7291n);
                }
            }
            if (richDocumentMediaTransitionEvent.f5179d) {
                this.f7274a.f7292o = false;
            }
        }
    }

    /* compiled from: onscreen_time */
    class C08312 extends RichDocumentMediaSnappingEventSubscriber {
        final /* synthetic */ RichDocumentCollapsingHeaderAndRecyclerViewLayout f7275a;

        C08312(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout) {
            this.f7275a = richDocumentCollapsingHeaderAndRecyclerViewLayout;
        }

        public final void m7542b(FbEvent fbEvent) {
            this.f7275a.f7295r = true;
        }
    }

    /* compiled from: onscreen_time */
    class C08323 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ RichDocumentCollapsingHeaderAndRecyclerViewLayout f7276a;

        C08323(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout) {
            this.f7276a = richDocumentCollapsingHeaderAndRecyclerViewLayout;
        }

        public final void m7543b(FbEvent fbEvent) {
            this.f7276a.f7297t = true;
        }
    }

    /* compiled from: onscreen_time */
    class C08334 implements AnimatorUpdateListener {
        final /* synthetic */ RichDocumentCollapsingHeaderAndRecyclerViewLayout f7277a;

        C08334(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout) {
            this.f7277a = richDocumentCollapsingHeaderAndRecyclerViewLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7277a.f7291n = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
    }

    private static <T extends View> void m7551a(Class<T> cls, T t) {
        m7552a((Object) t, t.getContext());
    }

    private static void m7552a(Object obj, Context context) {
        ((RichDocumentCollapsingHeaderAndRecyclerViewLayout) obj).f7278a = RichDocumentEventBus.m5130a(FbInjector.get(context));
    }

    public RichDocumentCollapsingHeaderAndRecyclerViewLayout(Context context) {
        this(context, null);
    }

    public RichDocumentCollapsingHeaderAndRecyclerViewLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichDocumentCollapsingHeaderAndRecyclerViewLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7279b = new NestedScrollingParentHelper(this);
        this.f7280c = new C08301(this);
        this.f7281d = new C08312(this);
        this.f7282e = new C08323(this);
        this.f7283f = new ValueAnimator();
        this.f7292o = false;
        m7546a();
    }

    private void m7546a() {
        m7551a(RichDocumentCollapsingHeaderAndRecyclerViewLayout.class, (View) this);
        this.f7283f.setInterpolator(new DecelerateInterpolator());
        this.f7283f.addUpdateListener(new C08334(this));
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 435372675);
        super.onAttachedToWindow();
        this.f7284g = getRecyclerView();
        if (this.f7284g != null) {
            this.f7289l = this.f7284g.getPaddingBottom();
            if (this.f7284g.getLayoutManager() instanceof LinearLayoutManager) {
                this.f7285h = (LinearLayoutManager) this.f7284g.getLayoutManager();
            }
        }
        this.f7286i = getCollapsingHeader();
        if (this.f7286i != null) {
            this.f7287j = this.f7286i.getCollapsedHeight();
            this.f7288k = this.f7286i.getExpandedHeight();
            this.f7293p;
        }
        this.f7278a.a(this.f7282e);
        this.f7278a.a(this.f7280c);
        this.f7278a.a(this.f7281d);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1699157911, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -850314057);
        super.onDetachedFromWindow();
        this.f7278a.b(this.f7282e);
        this.f7278a.b(this.f7280c);
        this.f7278a.b(this.f7281d);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1930345315, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7284g != null) {
            ViewCompat.g(this.f7284g, this.f7284g.getTop() + this.f7286i.getCurrentBottom());
        }
    }

    protected RecyclerView getRecyclerView() {
        return (RecyclerView) findViewById(2131559427);
    }

    protected CollapsingHeader getCollapsingHeader() {
        return (CollapsingHeader) findViewById(2131562992);
    }

    public static void m7549a(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout, int i) {
        if (richDocumentCollapsingHeaderAndRecyclerViewLayout.f7286i != null) {
            LayoutParams layoutParams = richDocumentCollapsingHeaderAndRecyclerViewLayout.f7286i.mo448a().getLayoutParams();
            layoutParams.height = i;
            richDocumentCollapsingHeaderAndRecyclerViewLayout.f7286i.mo448a().setLayoutParams(layoutParams);
            richDocumentCollapsingHeaderAndRecyclerViewLayout.f7286i.mo449a(i);
        }
    }

    public static void m7558b(RichDocumentCollapsingHeaderAndRecyclerViewLayout richDocumentCollapsingHeaderAndRecyclerViewLayout) {
        if (richDocumentCollapsingHeaderAndRecyclerViewLayout.f7284g != null) {
            richDocumentCollapsingHeaderAndRecyclerViewLayout.f7284g.setPadding(richDocumentCollapsingHeaderAndRecyclerViewLayout.f7284g.getPaddingLeft(), richDocumentCollapsingHeaderAndRecyclerViewLayout.f7284g.getPaddingTop(), richDocumentCollapsingHeaderAndRecyclerViewLayout.f7284g.getPaddingRight(), (richDocumentCollapsingHeaderAndRecyclerViewLayout.f7289l + richDocumentCollapsingHeaderAndRecyclerViewLayout.f7288k) - richDocumentCollapsingHeaderAndRecyclerViewLayout.f7287j);
        }
    }

    private void m7566e() {
        if (this.f7284g != null) {
            this.f7284g.setPadding(this.f7284g.getPaddingLeft(), this.f7284g.getPaddingTop(), this.f7284g.getPaddingRight(), this.f7289l);
        }
    }

    private void m7547a(int i, int i2) {
        if (i != i2) {
            this.f7283f.setDuration((long) (Math.round((((float) Math.abs(i2 - i)) / getContext().getResources().getDisplayMetrics().density) * 1000.0f) / 100));
            this.f7283f.setIntValues(new int[]{i, i2});
            this.f7283f.start();
        } else if (this.f7283f.isRunning()) {
            this.f7283f.cancel();
        }
    }

    private void m7548a(RichDocumentEventBus richDocumentEventBus) {
        this.f7278a = richDocumentEventBus;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        this.f7296s = false;
        boolean z = (i & 2) != 0;
        if (this.f7294q && this.f7295r) {
            this.f7294q = false;
            this.f7295r = false;
        }
        if (this.f7297t && z && !this.f7294q) {
            return true;
        }
        return false;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f7279b.b = i;
    }

    public int getNestedScrollAxes() {
        return this.f7279b.b;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        if (i2 != 0) {
            iArr[1] = m7556b(i2);
        }
    }

    private int m7556b(int i) {
        int i2 = i > 0 ? 0 : 1;
        int currentHeight = this.f7286i.getCurrentHeight();
        if (i2 == 1 && currentHeight == this.f7288k) {
            return 0;
        }
        if (i2 == 0 && currentHeight == this.f7287j) {
            return 0;
        }
        if (m7569f() && this.f7284g.computeVerticalScrollOffset() != 0 && !this.f7296s) {
            return 0;
        }
        int min;
        int i3;
        this.f7290m = i2;
        int currentHeight2 = this.f7286i.getCurrentHeight();
        if (i2 == 0) {
            min = Math.min(currentHeight - this.f7287j, i);
            this.f7296s = true;
            i3 = currentHeight2 - min;
        } else {
            min = Math.min(this.f7288k - currentHeight, -i);
            i3 = currentHeight2 + min;
        }
        this.f7291n = i3;
        ViewCompat.g(this.f7284g, i3 - currentHeight);
        if (i2 != 0) {
            return -min;
        }
        return min;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            m7556b(i4);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        if (m7569f() && !this.f7294q && ((f2 > 0.0f && m7570g()) || f2 < -2500.0f)) {
            m7547a(this.f7286i.getCurrentHeight(), this.f7288k);
        }
        return false;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public void onStopNestedScroll(View view) {
        this.f7279b.b();
        int currentHeight = this.f7286i.getCurrentHeight();
        if (currentHeight != this.f7286i.getCollapsedHeight() && currentHeight != this.f7286i.getExpandedHeight()) {
            m7547a(currentHeight, this.f7290m == 0 ? this.f7286i.getCollapsedHeight() : this.f7286i.getExpandedHeight());
        }
    }

    private boolean m7569f() {
        return this.f7286i.getCurrentHeight() == this.f7287j;
    }

    private boolean m7570g() {
        if (this.f7285h != null && this.f7285h.o() == this.f7285h.D() - 1) {
            return true;
        }
        return false;
    }

    private static boolean m7553a(MediaTransitionState mediaTransitionState) {
        return mediaTransitionState.equals(MediaTransitionState.f6978b) || mediaTransitionState.equals(MediaTransitionState.f6979c) || mediaTransitionState.equals(MediaTransitionState.f6980d);
    }
}
