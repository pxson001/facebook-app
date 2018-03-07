package com.facebook.spherical.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.spherical.model.KeyframeParams;
import com.facebook.spherical.model.SphericalParams;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: error_details */
public class SphericalHeadingIndicatorPlugin extends FrameLayout {
    public final List<KeyframeParams> f16357a;
    public SphericalParams f16358b;
    public HeadingBackgroundView f16359c;
    public HeadingFovView f16360d;
    public HeadingPoiView f16361e;
    public View f16362f;
    private ValueAnimator f16363g;
    private ValueAnimator f16364h;
    private ValueAnimator f16365i;
    private ValueAnimator f16366j;
    public HeadingListener f16367k;
    private OnClickListener f16368l;
    private CameraUpdateListener f16369m;
    private FadeUpdateListener f16370n;
    private CompassUpdateListener f16371o;
    private InitialFadeUpdateListener f16372p;
    public NoInteractionTimer f16373q;
    public boolean f16374r;
    private boolean f16375s;
    private boolean f16376t;
    private boolean f16377u;
    private int f16378v;
    public int f16379w;
    public float f16380x;
    public float f16381y;
    public float f16382z;

    /* compiled from: error_details */
    public interface HeadingListener {
        void mo1251a();

        void mo1252a(float f, float f2, int i);

        void mo1253a(int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    /* compiled from: error_details */
    class C11451 implements OnClickListener {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16345a;

        C11451(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
            this.f16345a = sphericalHeadingIndicatorPlugin;
        }

        public void onClick(View view) {
            float f;
            float f2;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1895048594);
            this.f16345a.f16379w;
            float f3 = this.f16345a.f16380x;
            float f4 = this.f16345a.f16381y;
            float f5 = this.f16345a.f16382z;
            float defaultFov = SphericalHeadingIndicatorPlugin.getDefaultFov(this.f16345a);
            if (SphericalHeadingIndicatorPlugin.getDefaultFov(this.f16345a)) {
                this.f16345a.f16367k;
                f = (float) (-((KeyframeParams) this.f16345a.f16357a.get(this.f16345a.f16379w)).f16164b);
                f2 = (float) ((KeyframeParams) this.f16345a.f16357a.get(this.f16345a.f16379w)).f16165c;
            } else {
                Preconditions.checkNotNull(this.f16345a.f16358b);
                f = this.f16345a.f16358b.mo1243b();
                f2 = this.f16345a.f16358b.mo1244c();
            }
            this.f16345a.f16367k.mo1253a((int) f2, (int) f, (int) defaultFov, (int) f4, (int) f3, (int) f5, 1000);
            LogUtils.a(-5350232, a);
        }
    }

    /* compiled from: error_details */
    class CameraUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16346a;
        private float f16347b;
        private float f16348c;
        private float f16349d;
        private float f16350e;

        public CameraUpdateListener(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin, float f, float f2, float f3, float f4) {
            this.f16346a = sphericalHeadingIndicatorPlugin;
            this.f16347b = f;
            this.f16348c = f2;
            this.f16349d = f3;
            this.f16350e = f4;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = this.f16348c - this.f16347b;
            if (f > 180.0f) {
                f -= 360.0f;
            } else if (f < -180.0f) {
                f += 360.0f;
            }
            this.f16346a.f16360d.setFovYaw((f * floatValue) + this.f16347b);
            this.f16346a.f16360d.setFov(((this.f16350e - this.f16349d) * floatValue) + this.f16349d);
        }
    }

    /* compiled from: error_details */
    class CompassUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16351a;
        private float f16352b;
        private float f16353c;

        public CompassUpdateListener(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin, float f, float f2) {
            this.f16351a = sphericalHeadingIndicatorPlugin;
            this.f16352b = f;
            this.f16353c = f2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            float f = this.f16353c - this.f16352b;
            if (f > 180.0f) {
                f -= 360.0f;
            } else if (f < -180.0f) {
                f += 360.0f;
            }
            this.f16351a.f16360d.setCompassYaw((animatedFraction * f) + this.f16352b);
            if (animatedFraction == 0.0f) {
                this.f16351a.f16361e.setRotation(this.f16353c);
                this.f16351a.f16361e.setVisibility(0);
            }
            if (this.f16351a.f16361e.getVisibility() != 0) {
                return;
            }
            if (animatedFraction == 1.0f || Math.abs(f) < 10.0f) {
                this.f16351a.f16361e.setVisibility(8);
            }
        }
    }

    /* compiled from: error_details */
    class FadeUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16354a;

        public FadeUpdateListener(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
            this.f16354a = sphericalHeadingIndicatorPlugin;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = (0.39999998f * floatValue) + 0.5f;
            this.f16354a.f16359c.setAlpha((floatValue * 0.5f) + 0.2f);
            this.f16354a.f16360d.setAlpha(f);
            this.f16354a.f16361e.setAlpha(f);
            this.f16354a.f16362f.setAlpha(f);
        }
    }

    /* compiled from: error_details */
    class InitialFadeUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16355a;

        public InitialFadeUpdateListener(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
            this.f16355a = sphericalHeadingIndicatorPlugin;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = 0.9f * floatValue;
            this.f16355a.f16359c.setAlpha(0.7f * floatValue);
            this.f16355a.f16360d.setAlpha(f);
            this.f16355a.f16361e.setAlpha(f);
            this.f16355a.f16362f.setAlpha(f);
            if (floatValue == 1.0f) {
                this.f16355a.f16373q.start();
            }
        }
    }

    /* compiled from: error_details */
    class NoInteractionTimer extends CountDownTimer {
        final /* synthetic */ SphericalHeadingIndicatorPlugin f16356a;

        public NoInteractionTimer(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin, long j, long j2) {
            this.f16356a = sphericalHeadingIndicatorPlugin;
            super(j, j2);
        }

        public void onTick(long j) {
        }

        public void onFinish() {
            this.f16356a.f16374r = false;
            this.f16356a.f16357a;
        }
    }

    public SphericalHeadingIndicatorPlugin(Context context) {
        this(context, null);
    }

    public SphericalHeadingIndicatorPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalHeadingIndicatorPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16357a = new ArrayList();
        this.f16374r = true;
        this.f16375s = true;
        this.f16376t = false;
        m23831a(context);
    }

    private void m23831a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(2130907185, this);
        this.f16359c = (HeadingBackgroundView) inflate.findViewById(2131567556);
        this.f16360d = (HeadingFovView) inflate.findViewById(2131567557);
        this.f16361e = (HeadingPoiView) inflate.findViewById(2131567558);
        this.f16362f = inflate.findViewById(2131567559);
        this.f16373q = new NoInteractionTimer(this, 1400, 1400);
        this.f16370n = new FadeUpdateListener(this);
        this.f16372p = new InitialFadeUpdateListener(this);
        m23846g();
        m23841d();
    }

    private void m23841d() {
        setTouchDelegate(TouchDelegateUtils.a(this.f16359c, getResources().getDimensionPixelSize(2131428275)));
    }

    private void m23844f() {
        if (this.f16358b != null && this.f16358b.mo1245d() != null && this.f16358b.mo1245d().f16159a != null) {
            this.f16357a.clear();
            ImmutableList immutableList = this.f16358b.mo1245d().f16159a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                KeyframeParams keyframeParams = (KeyframeParams) immutableList.get(i);
                if (m23834a(keyframeParams)) {
                    this.f16357a.add(keyframeParams);
                }
            }
        }
    }

    public static float getDefaultFov(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        if (sphericalHeadingIndicatorPlugin.f16358b == null) {
            return 70.0f;
        }
        float a = sphericalHeadingIndicatorPlugin.f16358b.mo1242a();
        if (a > 0.0f) {
            return Math.max(Math.min(a, 120.0f), 40.0f);
        }
        return a;
    }

    public static SphericalParams getSphericalParams(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        return sphericalHeadingIndicatorPlugin.f16358b;
    }

    public static boolean m23843e(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        if (sphericalHeadingIndicatorPlugin.f16358b == null || !sphericalHeadingIndicatorPlugin.f16377u || sphericalHeadingIndicatorPlugin.f16358b.mo1245d() == null || sphericalHeadingIndicatorPlugin.f16357a.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean m23834a(KeyframeParams keyframeParams) {
        if (keyframeParams.f16164b > 90 || keyframeParams.f16164b < -90) {
            return false;
        }
        return true;
    }

    private void m23846g() {
        this.f16368l = new C11451(this);
    }

    public final void m23864a(float f, float f2, float f3, int i) {
        if (this.f16375s) {
            this.f16381y = f;
            this.f16380x = f2;
            this.f16382z = f3;
            this.f16375s = false;
        } else {
            float c;
            if (this.f16363g != null && this.f16363g.isRunning()) {
                this.f16363g.end();
            }
            this.f16363g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f16363g.setInterpolator(new LinearInterpolator());
            this.f16363g.setDuration(150);
            float f4 = this.f16381y;
            if (this.f16358b != null) {
                f4 -= this.f16358b.mo1244c();
                c = f - this.f16358b.mo1244c();
            } else {
                c = f;
            }
            this.f16369m = new CameraUpdateListener(this, f4, c, this.f16382z, f3);
            this.f16363g.addUpdateListener(this.f16369m);
            this.f16363g.start();
            this.f16381y = f;
            this.f16382z = f3;
        }
        if (getDefaultFov(this)) {
            int c2 = m23839c(i);
            int abs = Math.abs(this.f16378v - i);
            this.f16378v = i;
            if (this.f16379w != c2) {
                if (abs >= 1000) {
                    m23837b(c2);
                } else {
                    m23830a(c2);
                }
                this.f16379w = c2;
            }
        }
    }

    private void m23830a(int i) {
        if (this.f16365i != null) {
            this.f16365i.cancel();
        }
        this.f16365i = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f16365i.setInterpolator(new LinearInterpolator());
        this.f16365i.setDuration(2000);
        this.f16371o = new CompassUpdateListener(this, (float) ((KeyframeParams) this.f16357a.get(this.f16379w)).f16165c, (float) ((KeyframeParams) this.f16357a.get(i)).f16165c);
        this.f16365i.addUpdateListener(this.f16371o);
        this.f16365i.start();
        if (this.f16376t) {
            this.f16367k.mo1252a((float) ((KeyframeParams) this.f16357a.get(i)).f16165c, (float) (-((KeyframeParams) this.f16357a.get(i)).f16164b), 2000);
        }
    }

    private void m23837b(int i) {
        if (getDefaultFov(this)) {
            this.f16360d.setCompassYaw((float) ((KeyframeParams) this.f16357a.get(i)).f16165c);
        }
    }

    private int m23839c(int i) {
        if (!getDefaultFov(this)) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f16357a.size() && ((long) i) >= ((KeyframeParams) this.f16357a.get(i2)).f16163a - 2000) {
            i3 = i2;
            i2++;
        }
        return i3;
    }

    public final void m23863a() {
        this.f16379w;
        m23856l();
    }

    public static void m23849h(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        sphericalHeadingIndicatorPlugin.f16373q.cancel();
        if (sphericalHeadingIndicatorPlugin.f16366j != null && sphericalHeadingIndicatorPlugin.f16366j.isRunning()) {
            sphericalHeadingIndicatorPlugin.f16366j.end();
        }
        if (!sphericalHeadingIndicatorPlugin.f16374r) {
            sphericalHeadingIndicatorPlugin.f16374r = true;
            sphericalHeadingIndicatorPlugin.m23853j();
        }
        sphericalHeadingIndicatorPlugin.f16373q.start();
        sphericalHeadingIndicatorPlugin.f16367k.mo1251a();
    }

    public static void m23851i(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        sphericalHeadingIndicatorPlugin.m23829a(1.0f, 0.0f);
    }

    private void m23853j() {
        m23829a(0.0f, 1.0f);
    }

    private void m23829a(float f, float f2) {
        if (this.f16364h != null) {
            this.f16364h.cancel();
        }
        this.f16364h = ValueAnimator.ofFloat(new float[]{f, f2});
        this.f16364h.setInterpolator(new LinearInterpolator());
        this.f16364h.setDuration(400);
        this.f16364h.addUpdateListener(this.f16370n);
        this.f16364h.start();
    }

    public final void m23865a(SphericalParams sphericalParams, boolean z, boolean z2, int i, HeadingListener headingListener) {
        if (sphericalParams != null) {
            this.f16358b = sphericalParams;
        }
        this.f16367k = headingListener;
        this.f16377u = z2;
        this.f16375s = true;
        m23844f();
        if (getDefaultFov(this)) {
            this.f16379w = m23839c(i);
            this.f16378v = i;
            this.f16360d.setCompassYaw((float) ((KeyframeParams) this.f16357a.get(this.f16379w)).f16165c);
            if (this.f16376t) {
                this.f16367k;
            } else {
                m23856l();
            }
        }
        if (z) {
            this.f16359c.setVisibility(0);
            this.f16360d.setVisibility(0);
            this.f16361e.setVisibility(8);
            this.f16359c.setAlpha(0.0f);
            this.f16360d.setAlpha(0.0f);
            this.f16360d.setFov(getDefaultFov(this));
            if (this.f16376t) {
                this.f16362f.setVisibility(0);
                this.f16362f.setAlpha(0.0f);
            }
            this.f16359c.setOnClickListener(this.f16368l);
            if (this.f16366j != null) {
                this.f16366j.cancel();
            }
            this.f16366j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f16366j.setInterpolator(new LinearInterpolator());
            this.f16366j.setDuration(1000);
            this.f16366j.addUpdateListener(this.f16372p);
            this.f16366j.start();
        }
    }

    public final void m23866b() {
        this.f16373q.cancel();
        if (this.f16363g != null) {
            this.f16363g.cancel();
        }
        if (this.f16364h != null) {
            this.f16364h.cancel();
        }
        if (this.f16366j != null) {
            this.f16366j.cancel();
        }
        if (this.f16365i != null) {
            this.f16365i.cancel();
        }
        this.f16359c.setVisibility(8);
        this.f16360d.setVisibility(8);
        this.f16361e.setVisibility(8);
    }

    private static void m23832a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i;
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(i);
        }
        view.setLayoutParams(layoutParams);
    }

    public final void m23867c() {
        m23832a((View) this, (int) getResources().getDimension(2131428273));
    }

    public static void m23855k(SphericalHeadingIndicatorPlugin sphericalHeadingIndicatorPlugin) {
        sphericalHeadingIndicatorPlugin.f16376t = true;
        HeadingIndicatorView headingIndicatorView = sphericalHeadingIndicatorPlugin.f16360d;
        headingIndicatorView.f16283a = true;
        headingIndicatorView.invalidate();
        sphericalHeadingIndicatorPlugin.f16362f.setVisibility(0);
    }

    private void m23856l() {
        this.f16376t = false;
        HeadingIndicatorView headingIndicatorView = this.f16360d;
        headingIndicatorView.f16283a = false;
        headingIndicatorView.invalidate();
        this.f16362f.setVisibility(8);
    }
}
