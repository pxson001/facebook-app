package com.facebook.widget.refreshableview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.common.ui.util.ColorDrawableCompat;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.FacebookProgressCircleView;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBar;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBarXConfigReader;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reactions_dock_select_2 */
public class RefreshableViewItem extends CustomFrameLayout {
    private static final Class<?> f6195a = RefreshableViewItem.class;
    private static final SpringConfig f6196b = SpringConfig.b(3.0d, 15.0d);
    private static final SpringConfig f6197c = SpringConfig.b(3.0d, 5.0d);
    private static final Interpolator f6198d = new DecelerateInterpolator(2.0f);
    public ImageView f6199e;
    private FacebookProgressCircleView f6200f;
    private FrameRateProgressBar f6201g;
    public Optional<LoadingIndicatorView> f6202h;
    private SpringSystem f6203i;
    public Spring f6204j;
    private Spring f6205k;
    private VelocityRotationAnimation f6206l;
    private float f6207m;
    private int f6208n;
    public RefreshableViewState f6209o;
    private int f6210p = -1;
    private FrameRateProgressBarXConfigReader f6211q;

    /* compiled from: reactions_dock_select_2 */
    class C03731 implements AnimationListener {
        final /* synthetic */ RefreshableViewItem f6192a;

        C03731(RefreshableViewItem refreshableViewItem) {
            this.f6192a = refreshableViewItem;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            RefreshableViewItem.m8762h(this.f6192a);
        }
    }

    /* compiled from: reactions_dock_select_2 */
    class ErrorAnimationListener extends SimpleSpringListener {
        final /* synthetic */ RefreshableViewItem f6193a;

        public ErrorAnimationListener(RefreshableViewItem refreshableViewItem) {
            this.f6193a = refreshableViewItem;
        }

        public final void m8746a(Spring spring) {
            float d = (float) spring.d();
            ((LoadingIndicatorView) this.f6193a.f6202h.get()).setScaleX(d);
            ((LoadingIndicatorView) this.f6193a.f6202h.get()).setScaleY(d);
        }
    }

    /* compiled from: reactions_dock_select_2 */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ RefreshableViewItem f6194a;

        public SpringListener(RefreshableViewItem refreshableViewItem) {
            this.f6194a = refreshableViewItem;
        }

        public final void m8747a(Spring spring) {
            float d = (float) spring.d();
            float f = (0.35f * d) + 1.0f;
            this.f6194a.f6199e.setScaleX(f);
            this.f6194a.f6199e.setScaleY(f);
            if (d > 1.0f) {
                this.f6194a.f6204j.b(0.0d);
            }
        }
    }

    private static <T extends View> void m8753a(Class<T> cls, T t) {
        m8754a((Object) t, t.getContext());
    }

    private static void m8754a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RefreshableViewItem) obj).m8752a(SpringSystem.b(fbInjector), FrameRateProgressBarXConfigReader.a(fbInjector));
    }

    public RefreshableViewItem(Context context) {
        super(context);
        m8759e();
    }

    public RefreshableViewItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8759e();
    }

    public RefreshableViewItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8759e();
    }

    @Inject
    private void m8752a(SpringSystem springSystem, FrameRateProgressBarXConfigReader frameRateProgressBarXConfigReader) {
        this.f6203i = springSystem;
        this.f6211q = frameRateProgressBarXConfigReader;
    }

    private void m8759e() {
        m8753a(RefreshableViewItem.class, (View) this);
        m8760f();
    }

    private void m8760f() {
        int b = ContextUtils.b(getContext(), 2130772936, 2130905827);
        LayoutInflater from = LayoutInflater.from(getContext());
        from.inflate(b, this);
        if (this.f6211q.a() != 60) {
            FbRelativeLayout fbRelativeLayout = (FbRelativeLayout) findViewById(2131564988);
            from.inflate(2130906509, fbRelativeLayout);
            this.f6201g = (FrameRateProgressBar) fbRelativeLayout.findViewById(2131566445);
        }
        this.f6202h = d(2131565084);
        this.f6199e = (ImageView) findViewById(2131564989);
        this.f6200f = (FacebookProgressCircleView) findViewById(2131564990);
        this.f6208n = getResources().getColor(2131361864);
        this.f6207m = getResources().getDisplayMetrics().density;
        if (this.f6204j == null) {
            this.f6204j = this.f6203i.a().a(f6196b).a(0.0d).b(0.0d).l().a(new SpringListener(this));
        }
        if (this.f6205k == null && this.f6202h.isPresent()) {
            this.f6205k = this.f6203i.a().a(f6197c).a(0.0d).l().a(new ErrorAnimationListener(this));
        }
        if (this.f6206l == null) {
            this.f6206l = new VelocityRotationAnimation(this.f6199e.getDrawable(), 800);
            this.f6206l.setRepeatMode(1);
            this.f6206l.setRepeatCount(-1);
            this.f6206l.setInterpolator(new LinearInterpolator());
        }
        m8761g();
    }

    private int m8748a(@Nullable View view) {
        if (view == null) {
            BLog.b(f6195a, "No background color set for PTR fragment");
            return this.f6208n;
        }
        Drawable background = view.getBackground();
        if (background == null || background.equals(getResources().getDrawable(2131361871))) {
            return m8748a((View) view.getParent());
        }
        if (background instanceof ColorDrawable) {
            int color;
            ColorDrawable colorDrawable = (ColorDrawable) background;
            if (VERSION.SDK_INT >= 11) {
                color = colorDrawable.getColor();
            } else {
                if (ColorDrawableCompat.a == null) {
                    ColorDrawableCompat.b = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
                    ColorDrawableCompat.a = new Canvas(ColorDrawableCompat.b);
                }
                ColorDrawableCompat.b.eraseColor(0);
                colorDrawable.draw(ColorDrawableCompat.a);
                color = ColorDrawableCompat.b.getPixel(0, 0);
            }
            return color;
        }
        BLog.b(f6195a, "Non color drawables not supported for PTR backgrounds");
        return this.f6208n;
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        m8761g();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m8761g();
    }

    private void m8761g() {
        View findViewById = findViewById(2131564992);
        View findViewById2 = findViewById(2131564991);
        if (findViewById != null && findViewById2 != null) {
            int a = m8748a((View) this);
            CustomViewUtils.b(findViewById, new ColorDrawable(a));
            CustomViewUtils.b(findViewById2, m8749a(a));
            this.f6200f.setProgressBarColor(a);
        }
    }

    private static Drawable m8749a(int i) {
        int i2 = (16777215 & i) | 0;
        return new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{i2, i});
    }

    public void setDirection(int i) {
        if (i != this.f6210p) {
            this.f6210p = i;
        }
    }

    public void setState(RefreshableViewState refreshableViewState) {
        this.f6209o = refreshableViewState;
    }

    public final void m8764a(int i, float f) {
        if (this.f6206l == null || !this.f6206l.hasStarted() || this.f6206l.hasEnded()) {
            this.f6200f.setProgress((long) i);
            this.f6199e.getDrawable().setLevel(i * 100);
            if (i >= 100) {
                m8751a(f);
            }
        }
    }

    private void m8751a(float f) {
        this.f6200f.setVisibility(8);
        if (this.f6202h.isPresent() && ((LoadingIndicatorView) this.f6202h.get()).getVisibility() != 8) {
            ((LoadingIndicatorView) this.f6202h.get()).setVisibility(4);
        }
        if (this.f6201g == null) {
            this.f6199e.setVisibility(0);
            float f2 = f / this.f6207m;
            if (f2 > 1900.0f) {
                f2 = 1900.0f;
            }
            VelocityRotationAnimation velocityRotationAnimation = this.f6206l;
            f2 *= 0.8f;
            Interpolator interpolator = f6198d;
            velocityRotationAnimation.f6217f = f2;
            velocityRotationAnimation.f6218g = 2000;
            velocityRotationAnimation.f6219h = interpolator;
            VelocityRotationAnimation velocityRotationAnimation2 = this.f6206l;
            velocityRotationAnimation2.f6214c = 0.0f;
            velocityRotationAnimation2.f6215d = 0.0f;
            velocityRotationAnimation2.f6216e = 0.0f;
            startAnimation(this.f6206l);
            this.f6204j.b(1.0d);
            setAnimationRestartListeners(this);
            for (int i = 0; i < getChildCount(); i++) {
                setAnimationRestartListeners(getChildAt(i));
            }
            return;
        }
        this.f6199e.setVisibility(8);
        this.f6201g.setVisibility(0);
    }

    private void setAnimationRestartListeners(View view) {
        if (view.getAnimation() != null) {
            view.getAnimation().setAnimationListener(getAnimationRestartListener());
        }
    }

    public final void m8763a() {
        m8766b();
        this.f6199e.setVisibility(8);
        if (this.f6201g != null) {
            this.f6201g.setVisibility(8);
        }
        if (this.f6202h.isPresent()) {
            ((LoadingIndicatorView) this.f6202h.get()).setVisibility(0);
            this.f6205k.b(1.0d);
        }
    }

    public final void m8765a(String str, RetryClickedListener retryClickedListener, Runnable runnable) {
        if (this.f6202h.isPresent()) {
            ((LoadingIndicatorView) this.f6202h.get()).a(str, retryClickedListener, runnable);
        }
    }

    public void setErrorVerticalPadding(int i) {
        if (this.f6202h.isPresent()) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i);
            ((LoadingIndicatorView) this.f6202h.get()).a(dimensionPixelSize, dimensionPixelSize);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 0));
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 185267693);
        super.onAttachedToWindow();
        if (!(this.f6209o != RefreshableViewState.LOADING || this.f6206l == null || this.f6206l.hasStarted())) {
            startAnimation(this.f6206l);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1127705845, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1174882610);
        super.onDetachedFromWindow();
        m8766b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1557593617, a);
    }

    public final void m8766b() {
        if (this.f6200f != null) {
            this.f6200f.setVisibility(0);
            this.f6200f.setProgress(0);
        }
        if (this.f6202h.isPresent()) {
            ((LoadingIndicatorView) this.f6202h.get()).setVisibility(8);
        }
        if (this.f6204j != null) {
            this.f6204j.a(0.0d);
            this.f6204j.l();
        }
        if (this.f6205k != null) {
            this.f6205k.a(0.0d);
            this.f6205k.l();
        }
        if (this.f6199e != null) {
            this.f6199e.setVisibility(0);
            this.f6199e.getDrawable().setLevel(0);
        }
        if (this.f6201g != null) {
            this.f6201g.setVisibility(8);
        }
        m8756b((View) this);
        for (int i = 0; i < getChildCount(); i++) {
            m8756b(getChildAt(i));
        }
    }

    private static void m8756b(View view) {
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.reset();
        }
        view.clearAnimation();
    }

    public AnimationListener getAnimationRestartListener() {
        return new C03731(this);
    }

    public static void m8762h(RefreshableViewItem refreshableViewItem) {
        Context context = refreshableViewItem.getContext();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            refreshableViewItem.m8766b();
        }
    }
}
