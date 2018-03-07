package com.facebook.android.maps.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* compiled from: back_pressed */
public class ValueAnimator {
    private static final Object f8491a = new Object();
    private static AnimationHandler f8492b = null;
    public static final ArrayList<ValueAnimator> f8493c = new ArrayList();
    public static final ArrayList<ValueAnimator> f8494d = new ArrayList();
    public static final ArrayList<ValueAnimator> f8495e = new ArrayList();
    public static final ArrayList<ValueAnimator> f8496f = new ArrayList();
    public static final ArrayList<ValueAnimator> f8497g = new ArrayList();
    private static final Interpolator f8498h = new AccelerateDecelerateInterpolator();
    private static final SynchronizedPool<ValueAnimator> f8499i = new SynchronizedPool(64);
    public static long f8500w = 10;
    public Object f8501A;
    public Interpolator f8502B = f8498h;
    public float f8503C;
    private ArrayList<AnimatorListener> f8504D = null;
    public float[] f8505E = new float[2];
    public float[] f8506F = new float[2];
    public int f8507G;
    public float f8508H;
    public boolean f8509I = true;
    public long f8510j;
    private long f8511k = -1;
    private boolean f8512l = false;
    private int f8513m = 0;
    private float f8514n = 0.0f;
    private boolean f8515o = false;
    private long f8516p;
    public int f8517q = 0;
    public boolean f8518r = false;
    public boolean f8519s = false;
    public boolean f8520t = false;
    private long f8521u = 300;
    public long f8522v = 0;
    public int f8523x = 0;
    private int f8524y = 1;
    private ArrayList<AnimatorUpdateListener> f8525z = null;

    /* compiled from: back_pressed */
    public interface AnimatorListener {
        void mo1037b(ValueAnimator valueAnimator);

        void mo1040c(ValueAnimator valueAnimator);
    }

    /* compiled from: back_pressed */
    public interface AnimatorUpdateListener {
        void mo1033a(ValueAnimator valueAnimator);
    }

    /* compiled from: back_pressed */
    class AnimationHandler extends Handler {
        public void handleMessage(Message message) {
            boolean z;
            int size;
            int i;
            ValueAnimator valueAnimator;
            int i2 = 0;
            switch (message.what) {
                case 0:
                    if (ValueAnimator.f8493c.size() > 0 || ValueAnimator.f8495e.size() > 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    while (ValueAnimator.f8494d.size() > 0) {
                        size = ValueAnimator.f8494d.size();
                        for (i = 0; i < size; i++) {
                            valueAnimator = (ValueAnimator) ValueAnimator.f8494d.get(i);
                            if (valueAnimator.f8522v == 0) {
                                ValueAnimator.m14537p(valueAnimator);
                            } else {
                                ValueAnimator.f8495e.add(valueAnimator);
                            }
                        }
                        ValueAnimator.f8494d.clear();
                    }
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            size = ValueAnimator.f8495e.size();
            for (i = 0; i < size; i++) {
                valueAnimator = (ValueAnimator) ValueAnimator.f8495e.get(i);
                if (ValueAnimator.m14533c(valueAnimator, currentAnimationTimeMillis)) {
                    ValueAnimator.f8497g.add(valueAnimator);
                }
            }
            if (ValueAnimator.f8497g.size() > 0) {
                size = ValueAnimator.f8497g.size();
                for (i = 0; i < size; i++) {
                    valueAnimator = (ValueAnimator) ValueAnimator.f8497g.get(i);
                    ValueAnimator.m14537p(valueAnimator);
                    valueAnimator.f8518r = true;
                    ValueAnimator.f8495e.remove(valueAnimator);
                }
                ValueAnimator.f8497g.clear();
            }
            i = 0;
            size = ValueAnimator.f8493c.size();
            while (i < size) {
                valueAnimator = (ValueAnimator) ValueAnimator.f8493c.get(i);
                if (ValueAnimator.m14534d(valueAnimator, currentAnimationTimeMillis)) {
                    ValueAnimator.f8496f.add(valueAnimator);
                }
                if (ValueAnimator.f8493c.size() == size) {
                    i++;
                } else {
                    size--;
                    ValueAnimator.f8496f.remove(valueAnimator);
                }
            }
            if (ValueAnimator.f8496f.size() > 0) {
                i = ValueAnimator.f8496f.size();
                while (i2 < i) {
                    ValueAnimator.m14536o((ValueAnimator) ValueAnimator.f8496f.get(i2));
                    i2++;
                }
                ValueAnimator.f8496f.clear();
            }
            if (!z) {
                return;
            }
            if (!ValueAnimator.f8493c.isEmpty() || !ValueAnimator.f8495e.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.f8500w - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    private ValueAnimator() {
    }

    private static AnimationHandler m14535m() {
        AnimationHandler animationHandler;
        synchronized (f8491a) {
            if (f8492b == null) {
                f8492b = new AnimationHandler();
            }
            animationHandler = f8492b;
        }
        return animationHandler;
    }

    public static ValueAnimator m14529a(float f, float f2) {
        ValueAnimator valueAnimator = (ValueAnimator) f8499i.m14516c();
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        valueAnimator.f8507G = 2;
        valueAnimator.f8505E[0] = 0.0f;
        valueAnimator.f8506F[0] = f;
        valueAnimator.f8505E[1] = 1.0f;
        valueAnimator.f8506F[1] = f2;
        valueAnimator.f8520t = false;
        return valueAnimator;
    }

    public final void m14541a(AnimatorListener animatorListener) {
        if (this.f8504D == null) {
            this.f8504D = new ArrayList();
        }
        this.f8504D.add(animatorListener);
    }

    public final void m14539a() {
        if (this.f8504D != null) {
            this.f8504D.clear();
        }
        if (this.f8525z != null) {
            this.f8525z.clear();
        }
        this.f8501A = null;
        this.f8510j = 0;
        this.f8511k = -1;
        this.f8512l = false;
        this.f8513m = 0;
        this.f8514n = 0.0f;
        this.f8515o = false;
        this.f8516p = 0;
        this.f8517q = 0;
        this.f8518r = false;
        this.f8519s = false;
        this.f8520t = false;
        this.f8521u = 300;
        this.f8522v = 0;
        this.f8523x = 0;
        this.f8524y = 1;
        this.f8502B = f8498h;
        this.f8503C = 0.0f;
        this.f8509I = true;
        f8499i.m14515a(this);
    }

    public final ValueAnimator m14538a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f8521u = j;
        return this;
    }

    private void m14532b(long j) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f8517q != 1) {
            this.f8511k = j;
            this.f8517q = this.f8520t ? 2 : 0;
        }
        this.f8510j = currentAnimationTimeMillis - j;
        this.f8520t = true;
        m14534d(this, currentAnimationTimeMillis);
    }

    public final void m14542a(AnimatorUpdateListener animatorUpdateListener) {
        if (this.f8525z == null) {
            this.f8525z = new ArrayList();
        }
        this.f8525z.add(animatorUpdateListener);
    }

    public final void m14540a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f8502B = interpolator;
        } else {
            this.f8502B = new LinearInterpolator();
        }
    }

    private void m14531a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f8512l = z;
        this.f8513m = 0;
        this.f8517q = 0;
        this.f8519s = true;
        this.f8515o = false;
        f8494d.add(this);
        if (this.f8522v == 0) {
            long j;
            if (!this.f8520t || this.f8517q == 0) {
                j = 0;
            } else {
                j = AnimationUtils.currentAnimationTimeMillis() - this.f8510j;
            }
            m14532b(j);
            this.f8518r = true;
            if (this.f8504D != null) {
                int size = this.f8504D.size();
                for (int i = 0; i < size; i++) {
                    this.f8504D.get(i);
                }
            }
        }
        m14535m().sendEmptyMessage(0);
    }

    public final void m14543c() {
        m14531a(false);
    }

    public final void m14544d() {
        if (this.f8517q != 0 || f8494d.contains(this) || f8495e.contains(this)) {
            if (this.f8518r && this.f8504D != null) {
                int size = this.f8504D.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) this.f8504D.get(i)).mo1040c(this);
                }
            }
            m14536o(this);
        }
    }

    public final boolean m14545e() {
        return this.f8517q == 1 || this.f8518r;
    }

    public static void m14536o(ValueAnimator valueAnimator) {
        f8493c.remove(valueAnimator);
        f8494d.remove(valueAnimator);
        f8495e.remove(valueAnimator);
        valueAnimator.f8517q = 0;
        valueAnimator.f8519s = false;
        if (valueAnimator.f8518r) {
            valueAnimator.f8518r = false;
            if (valueAnimator.f8504D != null) {
                int size = valueAnimator.f8504D.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) valueAnimator.f8504D.get(i)).mo1037b(valueAnimator);
                }
            }
        }
    }

    public static void m14537p(ValueAnimator valueAnimator) {
        valueAnimator.f8520t = true;
        f8493c.add(valueAnimator);
        if (valueAnimator.f8522v > 0 && valueAnimator.f8504D != null) {
            int size = valueAnimator.f8504D.size();
            for (int i = 0; i < size; i++) {
                valueAnimator.f8504D.get(i);
            }
        }
    }

    public static boolean m14533c(ValueAnimator valueAnimator, long j) {
        if (valueAnimator.f8515o) {
            long j2 = j - valueAnimator.f8516p;
            if (j2 > valueAnimator.f8522v) {
                valueAnimator.f8510j = j - (j2 - valueAnimator.f8522v);
                valueAnimator.f8517q = 1;
                return true;
            }
        }
        valueAnimator.f8515o = true;
        valueAnimator.f8516p = j;
        return false;
    }

    public static boolean m14534d(ValueAnimator valueAnimator, long j) {
        boolean z = true;
        boolean z2 = false;
        if (valueAnimator.f8517q == 0) {
            valueAnimator.f8517q = 1;
            if (valueAnimator.f8511k < 0) {
                valueAnimator.f8510j = j;
            } else {
                valueAnimator.f8510j = j - valueAnimator.f8511k;
                valueAnimator.f8511k = -1;
            }
        }
        switch (valueAnimator.f8517q) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                float f;
                float f2 = valueAnimator.f8521u > 0 ? ((float) (j - valueAnimator.f8510j)) / ((float) valueAnimator.f8521u) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (valueAnimator.f8513m < valueAnimator.f8523x || valueAnimator.f8523x == -1) {
                    if (valueAnimator.f8504D != null) {
                        int size = valueAnimator.f8504D.size();
                        for (int i = 0; i < size; i++) {
                            valueAnimator.f8504D.get(i);
                        }
                    }
                    if (valueAnimator.f8524y == 2) {
                        if (valueAnimator.f8512l) {
                            z = false;
                        }
                        valueAnimator.f8512l = z;
                    }
                    valueAnimator.f8513m += (int) f2;
                    f = f2 % 1.0f;
                    valueAnimator.f8510j += valueAnimator.f8521u;
                } else {
                    z2 = true;
                    f = Math.min(f2, 1.0f);
                }
                if (valueAnimator.f8512l) {
                    f = 1.0f - f;
                }
                valueAnimator.m14530a(f);
                break;
        }
        return z2;
    }

    private void m14530a(float f) {
        float interpolation;
        this.f8514n = f;
        int i = 1;
        if (this.f8507G == 2) {
            if (this.f8509I) {
                this.f8509I = false;
                this.f8508H = this.f8506F[1] - this.f8506F[0];
            }
            interpolation = this.f8502B.getInterpolation(f);
            interpolation = (interpolation * this.f8508H) + this.f8506F[0];
        } else if (f <= 0.0f) {
            r4 = (this.f8502B.getInterpolation(f) - this.f8505E[0]) / (this.f8505E[1] - this.f8505E[0]);
            interpolation = ((this.f8506F[1] - this.f8506F[0]) * r4) + this.f8506F[0];
        } else if (f >= 1.0f) {
            interpolation = (this.f8502B.getInterpolation(f) - this.f8505E[this.f8507G - 2]) / (this.f8505E[this.f8507G - 1] - this.f8505E[this.f8507G - 2]);
            interpolation = (interpolation * (this.f8506F[this.f8507G - 1] - this.f8506F[this.f8507G - 2])) + this.f8506F[this.f8507G - 2];
        } else {
            while (i < this.f8507G) {
                if (f < this.f8505E[i]) {
                    r4 = (this.f8502B.getInterpolation(f) - this.f8505E[i - 1]) / (this.f8505E[i] - this.f8505E[i - 1]);
                    interpolation = ((this.f8506F[i] - this.f8506F[i - 1]) * r4) + this.f8506F[i - 1];
                    break;
                }
                i++;
            }
            interpolation = this.f8506F[this.f8507G - 1];
        }
        this.f8503C = interpolation;
        if (this.f8525z != null) {
            int size = this.f8525z.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((AnimatorUpdateListener) this.f8525z.get(i2)).mo1033a(this);
            }
        }
    }
}
