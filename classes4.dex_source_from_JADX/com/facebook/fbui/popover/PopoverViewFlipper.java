package com.facebook.fbui.popover;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.ui.animations.AnimationUtil;
import javax.inject.Inject;

/* compiled from: otp */
public class PopoverViewFlipper extends FrameLayout {
    private static final SpringConfig f5821a = SpringConfig.b(15.0d, 5.0d);
    private static final SpringConfig f5822b = SpringConfig.a(40.0d, 7.0d);
    public AnimationUtil f5823c;
    private SpringSystem f5824d;
    private ShowListener f5825e;
    private TransitionListener f5826f;
    public Spring f5827g;
    public Spring f5828h;
    private Spring f5829i;
    public int f5830j = 0;
    private Drawable f5831k;
    private Drawable f5832l;
    private NubShown f5833m;
    public TransitionType f5834n;

    /* compiled from: otp */
    public enum TransitionType {
        NONE,
        ALPHA,
        SLIDE_LEFT,
        SLIDE_RIGHT,
        SLIDE_UP,
        SLIDE_DOWN
    }

    /* compiled from: otp */
    class ShowListener extends SimpleSpringListener {
        final /* synthetic */ PopoverViewFlipper f5835a;

        public ShowListener(PopoverViewFlipper popoverViewFlipper) {
            this.f5835a = popoverViewFlipper;
        }

        public final void m6330c(Spring spring) {
            AnimationUtil animationUtil = this.f5835a.f5823c;
            if (AnimationUtil.a()) {
                this.f5835a.f5823c.a(this.f5835a);
            }
        }

        public final void m6328a(Spring spring) {
            if (spring.g(0.0d) && spring.i == 0.0d) {
                spring.l();
                return;
            }
            float d = (float) spring.d();
            PopoverViewFlipper popoverViewFlipper = this.f5835a;
            popoverViewFlipper.setAlpha((float) SpringUtil.a((double) d, 0.0d, 1.0d));
            popoverViewFlipper.setScaleX(d);
            popoverViewFlipper.setScaleY(d);
        }

        public final void m6329b(Spring spring) {
            AnimationUtil animationUtil = this.f5835a.f5823c;
            if (AnimationUtil.a()) {
                this.f5835a.f5823c.b(this.f5835a);
            }
        }
    }

    /* compiled from: otp */
    public class TransitionListener extends SimpleSpringListener {
        protected View f5836a;
        protected View f5837b;
        protected int f5838c;
        protected int f5839d;
        protected int f5840e;
        protected int f5841f;
        final /* synthetic */ PopoverViewFlipper f5842g;

        protected TransitionListener(PopoverViewFlipper popoverViewFlipper) {
            this.f5842g = popoverViewFlipper;
        }

        public final void m6332a(View view, View view2) {
            this.f5836a = view;
            this.f5837b = view2;
        }

        public void m6331a() {
            DisplayMetrics displayMetrics = this.f5842g.getResources().getDisplayMetrics();
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
            this.f5836a.measure(makeMeasureSpec, makeMeasureSpec2);
            this.f5837b.measure(makeMeasureSpec, makeMeasureSpec2);
            makeMeasureSpec2 = this.f5842g.getPaddingLeft() + this.f5842g.getPaddingRight();
            this.f5840e = this.f5836a.getMeasuredWidth() + makeMeasureSpec2;
            this.f5841f = makeMeasureSpec2 + this.f5837b.getMeasuredWidth();
            makeMeasureSpec2 = this.f5842g.getPaddingTop() + this.f5842g.getPaddingBottom();
            this.f5838c = this.f5836a.getMeasuredHeight() + makeMeasureSpec2;
            this.f5839d = makeMeasureSpec2 + this.f5837b.getMeasuredHeight();
        }

        public final void m6335c(Spring spring) {
            AnimationUtil animationUtil = this.f5842g.f5823c;
            if (AnimationUtil.a()) {
                this.f5842g.f5823c.a(this.f5842g);
            }
            if (this.f5836a != null && this.f5837b != null) {
                this.f5836a.setVisibility(0);
                this.f5837b.setVisibility(0);
                m6331a();
            }
        }

        public final void m6333a(Spring spring) {
            if (this.f5836a != null && this.f5837b != null) {
                PopoverViewFlipper popoverViewFlipper = this.f5842g;
                float d = (float) spring.d();
                int i = this.f5838c + this.f5839d;
                switch (1.a[this.f5842g.f5834n.ordinal()]) {
                    case 1:
                        this.f5836a.setAlpha((float) SpringUtil.a((double) d, 0.0d, 1.0d));
                        this.f5837b.setTranslationX(1.0f - d);
                        break;
                    case 2:
                        this.f5836a.setTranslationX((-d) * ((float) this.f5840e));
                        this.f5837b.setTranslationX((1.0f - d) * ((float) this.f5841f));
                        break;
                    case 3:
                        this.f5836a.setTranslationX(((float) this.f5840e) * d);
                        this.f5837b.setTranslationX((d - 1.0f) * ((float) this.f5841f));
                        break;
                    case 4:
                        this.f5836a.setTranslationY((-d) * ((float) i));
                        this.f5837b.setTranslationY(((float) i) * (1.0f - d));
                        break;
                    case 5:
                        this.f5836a.setTranslationY(((float) i) * d);
                        this.f5837b.setTranslationY(((float) i) * (d - 1.0f));
                        break;
                }
                popoverViewFlipper.getLayoutParams().width = (int) ((((float) (this.f5841f - this.f5840e)) * d) + ((float) this.f5840e));
                i = (int) ((((float) (this.f5839d - this.f5838c)) * d) + ((float) this.f5838c));
                popoverViewFlipper.getLayoutParams().height = i;
                this.f5842g.m6309a(i);
                popoverViewFlipper.requestLayout();
            }
        }

        public final void m6334b(Spring spring) {
            AnimationUtil animationUtil = this.f5842g.f5823c;
            if (AnimationUtil.a()) {
                this.f5842g.f5823c.b(this.f5842g);
            }
            if (this.f5836a != null && this.f5837b != null) {
                this.f5836a.setVisibility(8);
                this.f5837b.setVisibility(0);
                this.f5836a = null;
                this.f5837b = null;
            }
        }
    }

    /* compiled from: otp */
    public enum NubShown {
        NONE,
        ABOVE,
        BELOW
    }

    private static <T extends View> void m6313a(Class<T> cls, T t) {
        m6314a((Object) t, t.getContext());
    }

    private static void m6314a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PopoverViewFlipper) obj).m6312a(SpringSystem.b(fbInjector), AnimationUtil.a(fbInjector));
    }

    public PopoverViewFlipper(Context context) {
        super(context);
        m6316g();
    }

    public PopoverViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6316g();
    }

    public PopoverViewFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6316g();
    }

    private final void m6316g() {
        m6313a(PopoverViewFlipper.class, (View) this);
        this.f5834n = TransitionType.NONE;
        this.f5825e = new ShowListener(this);
        this.f5827g = this.f5824d.a().a(f5821a).a(0.0d).b(0.0d).l();
        this.f5827g.a(this.f5825e);
        this.f5826f = m6319a();
        Spring a = this.f5824d.a().a(f5822b);
        a.c = true;
        this.f5829i = a.a(0.0d).b(0.0d).l();
        this.f5829i.a(this.f5826f);
        this.f5833m = NubShown.NONE;
        Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(2130772481, typedValue, true);
        if (typedValue.resourceId > 0) {
            this.f5831k = getResources().getDrawable(typedValue.resourceId);
        } else {
            this.f5831k = null;
        }
        theme.resolveAttribute(2130772482, typedValue, true);
        if (typedValue.resourceId > 0) {
            this.f5832l = getResources().getDrawable(typedValue.resourceId);
        } else {
            this.f5832l = null;
        }
        setWillNotDraw(false);
    }

    protected TransitionListener m6319a() {
        return new TransitionListener(this);
    }

    @Inject
    private void m6312a(SpringSystem springSystem, AnimationUtil animationUtil) {
        this.f5824d = springSystem;
        this.f5823c = animationUtil;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1017053284);
        super.onAttachedToWindow();
        this.f5827g.b(1.0d);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -356898874, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1433774556);
        super.onDetachedFromWindow();
        this.f5829i.m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1317722678, a);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5829i.k()) {
            View childAt = getChildAt(this.f5830j);
            if (childAt != null) {
                setMeasuredDimension((Math.min(childAt.getMeasuredWidth(), getResources().getDisplayMetrics().widthPixels) + getPaddingLeft()) + getPaddingRight(), (childAt.getMeasuredHeight() + getPaddingBottom()) + getPaddingTop());
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f5833m != NubShown.NONE) {
            canvas.save();
            if (this.f5833m == NubShown.ABOVE) {
                if (this.f5831k != null) {
                    this.f5831k.draw(canvas);
                }
            } else if (this.f5833m == NubShown.BELOW && this.f5832l != null) {
                this.f5832l.draw(canvas);
            }
            canvas.restore();
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        if (getChildCount() != 1) {
            view.setVisibility(8);
        }
    }

    protected final void m6322a(SimpleSpringListener simpleSpringListener) {
        if (m6323b()) {
            if (!this.f5827g.k()) {
                this.f5827g.l();
            }
            if (this.f5828h.k()) {
                this.f5828h.a(simpleSpringListener).b(0.0d);
            }
        } else if (simpleSpringListener != null) {
            simpleSpringListener.b(this.f5828h);
        }
    }

    public void setShowSpring(Spring spring) {
        this.f5827g = spring;
    }

    public void setDismissSpring(Spring spring) {
        this.f5828h = spring;
    }

    public final boolean m6323b() {
        return this.f5828h != null;
    }

    public final boolean m6324c() {
        return !this.f5829i.k();
    }

    public void setTransitionType(TransitionType transitionType) {
        if (this.f5834n != transitionType) {
            this.f5834n = transitionType;
        }
    }

    public TransitionType getTransitionType() {
        return this.f5834n;
    }

    public final void m6320a(int i, int i2) {
        setPivotX((float) i);
        setPivotY((float) i2);
    }

    public void setNubShown(NubShown nubShown) {
        if (this.f5833m != nubShown) {
            this.f5833m = nubShown;
            invalidate();
            requestLayout();
        }
    }

    public void setNubOffset(int i) {
        if (this.f5833m != NubShown.NONE) {
            int intrinsicWidth;
            int intrinsicHeight;
            int i2;
            int measuredHeight;
            if (this.f5833m == NubShown.ABOVE) {
                if (this.f5831k != null) {
                    intrinsicWidth = this.f5831k.getIntrinsicWidth();
                    intrinsicHeight = this.f5831k.getIntrinsicHeight();
                    i2 = i - (intrinsicWidth / 2);
                    measuredHeight = getMeasuredHeight() - getPaddingBottom();
                    this.f5831k.setBounds(i2, measuredHeight, intrinsicWidth + i2, intrinsicHeight + measuredHeight);
                }
            } else if (this.f5832l != null) {
                intrinsicWidth = this.f5832l.getIntrinsicWidth();
                intrinsicHeight = this.f5832l.getIntrinsicHeight();
                i2 = i - (intrinsicWidth / 2);
                measuredHeight = getPaddingTop() - intrinsicHeight;
                this.f5832l.setBounds(i2, measuredHeight, intrinsicWidth + i2, intrinsicHeight + measuredHeight);
            }
        }
    }

    public void setContentView(View view) {
        if (view != null) {
            removeAllViews();
            addView(view, new LayoutParams(-1, -2));
        }
    }

    public final void m6321a(View view) {
        if (view != null) {
            addView(view, getChildCount(), new LayoutParams(-1, -2));
        }
    }

    private boolean m6317h() {
        return this.f5830j + 1 < getChildCount();
    }

    private boolean m6318i() {
        return this.f5830j > 0;
    }

    public final void m6325d() {
        if (m6317h()) {
            m6310a(getChildAt(this.f5830j), getChildAt(this.f5830j + 1));
            this.f5830j++;
        }
    }

    public final void m6326e() {
        if (m6318i()) {
            m6310a(getChildAt(this.f5830j), getChildAt(this.f5830j - 1));
            this.f5830j--;
        }
    }

    private void m6310a(View view, View view2) {
        if (this.f5834n == TransitionType.NONE) {
            view.setVisibility(8);
            view2.setVisibility(0);
            requestLayout();
            return;
        }
        this.f5829i.a(0.0d);
        this.f5826f.m6332a(view, view2);
        this.f5829i.b(1.0d);
    }

    private void m6309a(int i) {
        if (this.f5833m != NubShown.NONE && this.f5833m != NubShown.BELOW) {
            Rect bounds = this.f5831k.getBounds();
            int paddingBottom = i - getPaddingBottom();
            this.f5831k.setBounds(bounds.left, paddingBottom, bounds.right, this.f5831k.getIntrinsicHeight() + paddingBottom);
        }
    }

    protected final void m6327f() {
        this.f5826f.m6331a();
        this.f5826f.a(this.f5829i);
    }

    protected int getCurrentChild() {
        return this.f5830j;
    }
}
