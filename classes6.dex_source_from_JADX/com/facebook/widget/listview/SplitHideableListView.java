package com.facebook.widget.listview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.R;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.HeightAnimation;
import com.google.common.base.Preconditions;

/* compiled from: redspace_self_view */
public class SplitHideableListView extends BetterListView {
    public final Runnable f6081a = new C03591(this);
    public final Runnable f6082b = new C03602(this);
    private HeightAnimation f6083c;
    private HeightAnimation f6084d;
    private HeightAnimation f6085e;
    private View f6086f;
    private float f6087g;
    public OnSplitHeightChangedListener f6088h;
    private WindowManager f6089i;
    private int f6090j;
    private int f6091k;
    private int f6092l;
    private int f6093m;
    private boolean f6094n;
    public boolean f6095o = false;
    private boolean f6096p;

    /* compiled from: redspace_self_view */
    class C03591 implements Runnable {
        final /* synthetic */ SplitHideableListView f6072a;

        C03591(SplitHideableListView splitHideableListView) {
            this.f6072a = splitHideableListView;
        }

        public void run() {
            SplitHideableListView.m8663o(this.f6072a);
        }
    }

    /* compiled from: redspace_self_view */
    class C03602 implements Runnable {
        final /* synthetic */ SplitHideableListView f6073a;

        C03602(SplitHideableListView splitHideableListView) {
            this.f6073a = splitHideableListView;
        }

        public void run() {
            if (this.f6073a.f6088h != null) {
                this.f6073a.f6088h.m8651a();
            }
        }
    }

    /* compiled from: redspace_self_view */
    class C03613 implements OnScrollListener {
        final /* synthetic */ SplitHideableListView f6074a;

        C03613(SplitHideableListView splitHideableListView) {
            this.f6074a = splitHideableListView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f6074a.post(this.f6074a.f6081a);
        }
    }

    /* compiled from: redspace_self_view */
    class C03634 implements AnimationListener {
        final /* synthetic */ SplitHideableListView f6077a;

        C03634(SplitHideableListView splitHideableListView) {
            this.f6077a = splitHideableListView;
        }

        public void onAnimationStart(Animation animation) {
            this.f6077a.f6095o = false;
            final HeightAnimation heightAnimation = (HeightAnimation) animation;
            heightAnimation.b.postDelayed(new Runnable(this) {
                final /* synthetic */ C03634 f6076b;

                public void run() {
                    heightAnimation.a();
                }
            }, heightAnimation.getDuration());
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: redspace_self_view */
    class C03655 implements AnimationListener {
        final /* synthetic */ SplitHideableListView f6080a;

        C03655(SplitHideableListView splitHideableListView) {
            this.f6080a = splitHideableListView;
        }

        public void onAnimationStart(Animation animation) {
            this.f6080a.f6095o = true;
            final HeightAnimation heightAnimation = (HeightAnimation) animation;
            heightAnimation.b.postDelayed(new Runnable(this) {
                final /* synthetic */ C03655 f6079b;

                public void run() {
                    heightAnimation.a();
                    this.f6079b.f6080a.post(this.f6079b.f6080a.f6082b);
                }
            }, heightAnimation.getDuration());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }
    }

    /* compiled from: redspace_self_view */
    public interface OnSplitHeightChangedListener {
        void m8651a();

        void m8652a(int i);
    }

    public SplitHideableListView(Context context) {
        super(context);
        m8653a(context, null);
    }

    public SplitHideableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8653a(context, attributeSet);
    }

    public SplitHideableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8653a(context, attributeSet);
    }

    public void setOnSplitHeightChangedListener(OnSplitHeightChangedListener onSplitHeightChangedListener) {
        this.f6088h = onSplitHeightChangedListener;
    }

    public void setExpandableHeader(View view) {
        boolean z = this.f6086f == null || view == null || view == this.f6086f;
        Preconditions.checkState(z);
        if (view != this.f6086f) {
            if (view == null) {
                removeHeaderView(this.f6086f);
            } else {
                view.getLayoutParams().height = this.f6096p ? 0 : this.f6092l;
                view.requestLayout();
                addHeaderView(view, null, false);
            }
            this.f6086f = view;
        }
    }

    public final long m8664g() {
        if (this.f6095o) {
            return 0;
        }
        int abs = (int) (((float) Math.abs(this.f6086f.getTop())) * 0.23f);
        smoothScrollBy(this.f6086f.getTop(), abs);
        this.f6086f.clearAnimation();
        if (this.f6084d == null) {
            this.f6095o = true;
            return 0;
        }
        this.f6084d.reset();
        this.f6086f.startAnimation(this.f6084d);
        return ((long) abs) + this.f6084d.getDuration();
    }

    private void m8659k() {
        this.f6095o = true;
        this.f6086f.clearAnimation();
        this.f6086f.getLayoutParams().height = getHeight();
        this.f6086f.requestLayout();
    }

    public final long m8665h() {
        if (!this.f6095o) {
            return 0;
        }
        this.f6086f.clearAnimation();
        if (this.f6085e == null) {
            this.f6095o = false;
            return 0;
        }
        this.f6085e.reset();
        this.f6086f.startAnimation(this.f6085e);
        return this.f6085e.getDuration();
    }

    public final void m8666i() {
        if (!this.f6096p) {
            this.f6096p = true;
            this.f6086f.getLayoutParams().height = 0;
            this.f6086f.requestLayout();
        }
    }

    public final void m8667j() {
        if (this.f6096p) {
            this.f6096p = false;
            this.f6086f.getLayoutParams().height = this.f6092l;
            this.f6086f.requestLayout();
        }
    }

    private void m8660l() {
        this.f6083c.reset();
        this.f6086f.startAnimation(this.f6083c);
    }

    private void m8653a(Context context, AttributeSet attributeSet) {
        boolean z = false;
        this.f6089i = WindowManagerMethodAutoProvider.b(FbInjector.get(getContext()));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SplitHideableListView);
        this.f6094n = obtainStyledAttributes.getBoolean(4, false);
        this.f6090j = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f6091k = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.f6092l = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.f6093m = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        boolean z2 = (this.f6090j == -1 && this.f6092l == -1) ? false : true;
        Preconditions.checkArgument(z2, "must specify listStartHeight or headerStartHeight");
        if (!(!this.f6094n && this.f6091k == -1 && this.f6093m == -1)) {
            z = true;
        }
        Preconditions.checkArgument(z, "must specify listHideThreshold or headerHideThreshold, or disableScrollHideList");
        m8661m();
        obtainStyledAttributes.recycle();
        a(new C03613(this));
    }

    private void m8661m() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f6089i.getDefaultDisplay().getMetrics(displayMetrics);
        if (this.f6092l == -1) {
            this.f6092l = displayMetrics.heightPixels - this.f6090j;
        }
        if (!this.f6094n && this.f6093m == -1) {
            this.f6093m = displayMetrics.heightPixels - this.f6091k;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            m8662n();
            if (this.f6095o && this.f6086f != null) {
                m8659k();
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            m8661m();
            if (this.f6086f != null && !this.f6096p) {
                this.f6086f.getLayoutParams().height = this.f6092l;
            }
        }
    }

    private void m8662n() {
        this.f6083c = new HeightAnimation(this.f6086f, this.f6092l);
        this.f6083c.setInterpolator(new DecelerateInterpolator());
        this.f6083c.setDuration(250);
        this.f6085e = new HeightAnimation(this.f6086f, this.f6092l);
        this.f6085e.setInterpolator(new DecelerateInterpolator());
        this.f6085e.setDuration(200);
        this.f6085e.setAnimationListener(new C03634(this));
        this.f6084d = new HeightAnimation(this.f6086f, getHeight());
        this.f6084d.setInterpolator(new AccelerateInterpolator());
        this.f6084d.setDuration((long) (0.23f * ((float) this.f6092l)));
        this.f6084d.setAnimationListener(new C03655(this));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6095o) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 80919739);
        boolean onTouchEvent;
        if (this.f6086f == null || this.f6096p) {
            onTouchEvent = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 467381639, a);
            return onTouchEvent;
        } else if (this.f6095o) {
            LogUtils.a(861399351, a);
            return false;
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f6086f.clearAnimation();
                    this.f6087g = -1.0f;
                    break;
                case 1:
                    int height = this.f6086f.getHeight();
                    if (this.f6094n || height < this.f6093m) {
                        if (height > this.f6092l) {
                            m8660l();
                            break;
                        }
                    }
                    m8664g();
                    break;
                    break;
                case 2:
                    if (this.f6086f.getTop() == 0) {
                        if (this.f6087g < 0.0f) {
                            this.f6087g = motionEvent.getRawY();
                        }
                        float rawY = motionEvent.getRawY() - this.f6087g;
                        int height2 = getHeight();
                        int max = (int) Math.max((float) this.f6092l, (rawY * ((((float) height2) - (rawY / 2.0f)) / ((float) height2))) + ((float) this.f6092l));
                        if (!this.f6094n || max <= this.f6092l) {
                            height2 = this.f6086f.getHeight();
                            this.f6086f.getLayoutParams().height = max;
                            this.f6086f.requestLayout();
                            post(this.f6081a);
                            if (max <= this.f6092l) {
                                if (max == this.f6092l && max < height2) {
                                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                                    obtain.setAction(0);
                                    super.onTouchEvent(obtain);
                                    break;
                                }
                            }
                            if (height2 == this.f6092l) {
                                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                                obtain2.setAction(3);
                                super.onTouchEvent(obtain2);
                            }
                            LogUtils.a(-349084103, a);
                            return true;
                        }
                    }
                    break;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(2005967471, a);
            return onTouchEvent;
        }
    }

    public static void m8663o(SplitHideableListView splitHideableListView) {
        int i = 0;
        if (splitHideableListView.f6088h != null) {
            if (splitHideableListView.getFirstVisiblePosition() == 0 && splitHideableListView.f6086f != null) {
                i = Math.max(0, splitHideableListView.f6086f.getHeight() + splitHideableListView.f6086f.getTop());
            }
            splitHideableListView.f6088h.m8652a(i);
        }
    }
}
