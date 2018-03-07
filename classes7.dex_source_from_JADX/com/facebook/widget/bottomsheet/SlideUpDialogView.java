package com.facebook.widget.bottomsheet;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.bottomsheet.ViewDragHelper.Callback;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: deltas_count */
public class SlideUpDialogView extends ViewGroup {
    @Inject
    public SpringSystem f15878a;
    @Inject
    public AccessibilityManager f15879b;
    public final Set<View> f15880c = Sets.a();
    public float f15881d = 0.5f;
    public float f15882e = 0.5f;
    private final float f15883f = 1.0f;
    public View f15884g;
    public RecyclerView f15885h;
    public LinearLayoutManager f15886i;
    public ViewDragHelper f15887j;
    public Spring f15888k;
    public int f15889l;
    public float f15890m;
    public boolean f15891n;
    public Listener f15892o;
    private float f15893p;
    private float f15894q;
    private boolean f15895r;

    /* compiled from: deltas_count */
    public interface Listener {
        void mo1206a();
    }

    /* compiled from: deltas_count */
    public class C12112 extends SimpleSpringListener {
        final /* synthetic */ SlideUpDialogView f15851a;

        public C12112(SlideUpDialogView slideUpDialogView) {
            this.f15851a = slideUpDialogView;
        }

        public final void m19824a(Spring spring) {
            this.f15851a.f15884g.offsetTopAndBottom(((int) ((1.0d - spring.d()) * ((double) this.f15851a.getBottom()))) - this.f15851a.f15885h.getTop());
        }

        public final void m19825b(Spring spring) {
            if (spring.d() == 0.0d && this.f15851a.f15892o != null) {
                this.f15851a.f15892o.mo1206a();
            }
        }
    }

    /* compiled from: deltas_count */
    public class ScrollProxyView extends View {
        public final /* synthetic */ SlideUpDialogView f15852a;

        public ScrollProxyView(SlideUpDialogView slideUpDialogView, Context context) {
            this.f15852a = slideUpDialogView;
            super(context);
            setWillNotDraw(true);
        }

        public void offsetTopAndBottom(int i) {
            int a = m19826a(i);
            super.offsetTopAndBottom(a);
            this.f15852a.invalidate();
            if (!m19827b(a)) {
                if (i < 0) {
                    int o = this.f15852a.f15886i.o();
                    if (o == this.f15852a.f15885h.o.aZ_() - 1 && this.f15852a.f15886i.c(o).getBottom() == this.f15852a.getBottom()) {
                        this.f15852a.f15885h.scrollBy(0, SizeUtil.a(getContext(), 1000.0f));
                    }
                }
                if (this.f15852a.f15887j.f15853a != 1) {
                    this.f15852a.f15887j.m19849b();
                }
            }
            SlideUpDialogView slideUpDialogView = this.f15852a;
            if (!slideUpDialogView.f15891n && slideUpDialogView.f15887j.f15853a == 2) {
                SlideUpDialogView.m19863e(slideUpDialogView);
            }
            if (slideUpDialogView.getBottom() > 0) {
                slideUpDialogView.getBackground().mutate().setAlpha(Math.max(0, Math.min((int) ((1.0f - (((float) slideUpDialogView.f15885h.getTop()) / ((float) slideUpDialogView.getBottom()))) * 153.0f), 255)));
            }
        }

        private int m19826a(int i) {
            int n = this.f15852a.f15886i.n();
            if (n != this.f15852a.f15885h.o.aZ_() - 1) {
                return i;
            }
            View c = this.f15852a.f15886i.c(n);
            return c != null ? Math.max(-((c.getBottom() + this.f15852a.f15885h.getTop()) - this.f15852a.getHeight()), i) : i;
        }

        private boolean m19827b(int i) {
            int max;
            if (i <= 0) {
                max = Math.max(0, this.f15852a.f15885h.getTop() + i) - this.f15852a.f15885h.getTop();
                i -= max;
            } else if (this.f15852a.f15886i.l() != 0) {
                max = 0;
            } else {
                int min = Math.min(i, -this.f15852a.f15886i.c(0).getTop());
                max = i - min;
                i = min;
            }
            if (i != 0) {
                this.f15852a.f15885h.scrollBy(0, -i);
            }
            if (max != 0) {
                this.f15852a.f15885h.offsetTopAndBottom(max);
            }
            if (i == 0 && max == 0) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: deltas_count */
    public class ScrollProxyViewDragHelper extends ViewDragHelper {
        final /* synthetic */ SlideUpDialogView f15876a;

        public ScrollProxyViewDragHelper(SlideUpDialogView slideUpDialogView, Callback callback) {
            this.f15876a = slideUpDialogView;
            super(slideUpDialogView.getContext(), slideUpDialogView, callback);
        }

        public final View mo1212a(int i, int i2) {
            RecyclerView recyclerView = this.f15876a.f15885h;
            if (i < recyclerView.getLeft() || i >= recyclerView.getRight() || i2 < recyclerView.getTop() || i2 >= recyclerView.getBottom()) {
                return null;
            }
            return this.f15876a.f15884g;
        }
    }

    /* compiled from: deltas_count */
    public class ViewDragHelperCallback extends Callback {
        final /* synthetic */ SlideUpDialogView f15877a;

        public ViewDragHelperCallback(SlideUpDialogView slideUpDialogView) {
            this.f15877a = slideUpDialogView;
        }

        public final int mo1213a() {
            return this.f15877a.getHeight();
        }

        public final boolean mo1216b() {
            return true;
        }

        public final int mo1214a(int i) {
            return i;
        }

        public final void mo1215a(View view, float f) {
            ViewDragHelper viewDragHelper = this.f15877a.f15887j;
            int i = (int) f;
            viewDragHelper.f15869q.abortAnimation();
            viewDragHelper.f15869q.fling(0, 0, 0, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int finalY = viewDragHelper.f15869q.getFinalY();
            viewDragHelper.f15869q.abortAnimation();
            int i2 = finalY;
            this.f15877a.f15889l = i2 + view.getTop();
            SlideUpDialogView.m19863e(this.f15877a);
            if (this.f15877a.f15891n) {
                this.f15877a.f15888k.c((double) ((-f) / ((float) this.f15877a.getHeight())));
                return;
            }
            if (Math.abs(f) >= this.f15877a.f15890m) {
                this.f15877a.f15887j.m19847a(0, Integer.MIN_VALUE, 0, this.f15877a.getHeight());
            } else {
                this.f15877a.f15887j.m19852b(0, this.f15877a.f15889l);
            }
            ViewCompat.d(this.f15877a);
        }
    }

    public static void m19862a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SlideUpDialogView slideUpDialogView = (SlideUpDialogView) obj;
        SpringSystem b = SpringSystem.b(fbInjector);
        AccessibilityManager b2 = AccessibilityManagerMethodAutoProvider.b(fbInjector);
        slideUpDialogView.f15878a = b;
        slideUpDialogView.f15879b = b2;
    }

    public SlideUpDialogView(Context context) {
        super(context);
        Class cls = SlideUpDialogView.class;
        m19862a(this, getContext());
        setBackgroundDrawable(new ColorDrawable(-16777216));
        getBackground().mutate().setAlpha(0);
        this.f15890m = (float) ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.f15887j = new ScrollProxyViewDragHelper(this, new ViewDragHelperCallback(this));
        this.f15886i = new LinearLayoutManager(getContext());
        this.f15885h = new RecyclerView(this, getContext()) {
            final /* synthetic */ SlideUpDialogView f15850h;

            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return false;
            }
        };
        this.f15885h.setLayoutManager(this.f15886i);
        this.f15885h.setBackgroundDrawable(new ColorDrawable(-1));
        addView(this.f15885h);
        this.f15884g = new ScrollProxyView(this, getContext());
        addView(this.f15884g, new LayoutParams(0, -1));
        this.f15888k = this.f15878a.a().a(new SpringConfig(700.0d, 48.0d)).a(new C12112(this));
    }

    private float getDefaultShowRatio() {
        if (this.f15879b.isEnabled() && this.f15879b.isTouchExplorationEnabled()) {
            return 1.0f;
        }
        if (getContext().getResources().getConfiguration().orientation == 1) {
            return this.f15881d;
        }
        return this.f15882e;
    }

    public void setAdapter(Adapter adapter) {
        if (this.f15885h != null) {
            this.f15885h.setAdapter(adapter);
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(MeasureSpec.getMode(i) != 0);
        if (MeasureSpec.getMode(i2) == 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        measureChildren(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int top = this.f15884g.getTop();
        this.f15884g.layout(0, top, 0, getHeight() + top);
        top = this.f15885h.getTop();
        this.f15885h.layout(0, top, getWidth(), getHeight() + top);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f15891n) {
            this.f15889l = 0;
            this.f15888k.a(0.0d);
            this.f15888k.c = false;
            this.f15888k.b((double) getDefaultShowRatio());
        }
    }

    public void computeScroll() {
        int currY;
        ViewDragHelper viewDragHelper = this.f15887j;
        if (viewDragHelper.f15853a == 2) {
            boolean isFinished;
            boolean computeScrollOffset = viewDragHelper.f15869q.computeScrollOffset();
            currY = viewDragHelper.f15869q.getCurrY();
            int top = currY - viewDragHelper.f15872t.getTop();
            if (top > 0) {
                currY = Math.min(currY, viewDragHelper.f15870r);
            } else if (top < 0) {
                currY = Math.max(currY, viewDragHelper.f15870r);
            }
            top = currY - viewDragHelper.f15872t.getTop();
            if (top != 0) {
                viewDragHelper.f15872t.offsetTopAndBottom(top);
            }
            if (computeScrollOffset && currY == viewDragHelper.f15870r) {
                viewDragHelper.f15869q.abortAnimation();
                isFinished = viewDragHelper.f15869q.isFinished();
            } else {
                isFinished = computeScrollOffset;
            }
            if (!isFinished) {
                if (1 != 0) {
                    viewDragHelper.f15874v.post(viewDragHelper.f15875w);
                } else {
                    viewDragHelper.m19850b(0);
                }
            }
        }
        if (viewDragHelper.f15853a == 2) {
            currY = 1;
        } else {
            currY = 0;
        }
        if (currY != 0) {
            ViewCompat.d(this);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -751035519);
        super.onAttachedToWindow();
        this.f15891n = false;
        this.f15888k.a(0.0d);
        this.f15888k.c = false;
        this.f15888k.b((double) getDefaultShowRatio());
        this.f15886i.d(0, 0);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1450538032, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1872243697);
        super.onDetachedFromWindow();
        this.f15888k.l();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1038403861, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f15891n) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 0:
                if (motionEvent.getY() >= ((float) this.f15885h.getTop())) {
                    if (!this.f15888k.k()) {
                        this.f15888k.l();
                        break;
                    }
                }
                m19864a();
                return true;
                break;
        }
        float x = actionMasked == 0 ? 0.0f : motionEvent.getX() - this.f15893p;
        float y = actionMasked == 0 ? 0.0f : motionEvent.getY() - this.f15894q;
        this.f15893p = motionEvent.getX();
        this.f15894q = motionEvent.getY();
        if (!this.f15880c.isEmpty()) {
            this.f15887j.m19849b();
            this.f15895r = false;
            return false;
        } else if (this.f15895r) {
            this.f15895r = false;
            return true;
        } else if (!this.f15887j.m19848a(motionEvent)) {
            return false;
        } else {
            if (x == 0.0f || Math.abs(x) / Math.abs(y) <= 0.7f) {
                return true;
            }
            this.f15895r = true;
            this.f15887j.m19851b(motionEvent);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1846190007);
        if (!this.f15891n) {
            this.f15887j.m19851b(motionEvent);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1561307092, a);
        return true;
    }

    public void setRecyclerViewBackground(Drawable drawable) {
        this.f15885h.setBackgroundDrawable(drawable);
    }

    public final void m19864a() {
        this.f15891n = true;
        this.f15887j.m19849b();
        this.f15888k.a((double) (1.0f - (((float) this.f15885h.getTop()) / ((float) getBottom()))));
        this.f15888k.l();
        this.f15888k.c = true;
        this.f15888k.b(0.0d);
        if (this.f15888k.k() && this.f15892o != null) {
            this.f15892o.mo1206a();
        }
    }

    public static void m19863e(SlideUpDialogView slideUpDialogView) {
        if (slideUpDialogView.f15886i.l() == 0 && (slideUpDialogView.f15885h.getTop() + slideUpDialogView.f15886i.c(0).getTop()) + (slideUpDialogView.f15889l - slideUpDialogView.f15884g.getTop()) >= (slideUpDialogView.getHeight() * 3) / 4) {
            slideUpDialogView.m19864a();
        }
    }
}
