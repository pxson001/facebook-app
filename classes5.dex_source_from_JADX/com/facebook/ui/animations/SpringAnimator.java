package com.facebook.ui.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: component_tracking_data */
public class SpringAnimator extends ValueAnimator {
    public final AnimatorUpdateListener f5371a = new C04961(this);
    public final ObjectAnimator f5372b;
    public float f5373c = 0.1f;
    public float f5374d = 0.7f;
    public float f5375e = 0.01f;
    public float f5376f = 0.6f;
    public float f5377g = 0.0f;
    private Method f5378h;
    private Class f5379i;
    private boolean f5380j = false;
    public Number f5381k;
    public Number f5382l;
    public float f5383m;
    public long f5384n;
    public int f5385o;
    public ImmutableList<AnimatorUpdateListener> f5386p = RegularImmutableList.a;
    public boolean f5387q;

    /* compiled from: component_tracking_data */
    class C04961 implements AnimatorUpdateListener {
        final /* synthetic */ SpringAnimator f5368a;

        C04961(SpringAnimator springAnimator) {
            this.f5368a = springAnimator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int size = this.f5368a.f5386p.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorUpdateListener) this.f5368a.f5386p.get(i)).onAnimationUpdate(this.f5368a);
            }
        }
    }

    /* compiled from: component_tracking_data */
    public class C04972 implements AnimatorListener {
        final /* synthetic */ SpringAnimator f5369a;

        public C04972(SpringAnimator springAnimator) {
            this.f5369a = springAnimator;
        }

        public void onAnimationStart(Animator animator) {
            Collection listeners = this.f5369a.getListeners();
            if (listeners != null) {
                ImmutableList copyOf = ImmutableList.copyOf(listeners);
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) copyOf.get(i)).onAnimationStart(this.f5369a);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            Collection listeners = this.f5369a.getListeners();
            if (listeners != null) {
                ImmutableList copyOf = ImmutableList.copyOf(listeners);
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) copyOf.get(i)).onAnimationEnd(this.f5369a);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
            Collection listeners = this.f5369a.getListeners();
            if (listeners != null) {
                ImmutableList copyOf = ImmutableList.copyOf(listeners);
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) copyOf.get(i)).onAnimationCancel(this.f5369a);
                }
            }
        }

        public void onAnimationRepeat(Animator animator) {
            Collection listeners = this.f5369a.getListeners();
            if (listeners != null) {
                ImmutableList copyOf = ImmutableList.copyOf(listeners);
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) copyOf.get(i)).onAnimationRepeat(this.f5369a);
                }
            }
        }
    }

    /* compiled from: component_tracking_data */
    class SpringInterpolator implements Interpolator {
        final /* synthetic */ SpringAnimator f5370a;

        public SpringInterpolator(SpringAnimator springAnimator) {
            this.f5370a = springAnimator;
        }

        public float getInterpolation(float f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f5370a.f5384n == 0) {
                this.f5370a.f5384n = currentTimeMillis - 16;
            }
            int round = Math.round(((float) (currentTimeMillis - this.f5370a.f5384n)) / 16.0f);
            int i = round - this.f5370a.f5385o;
            float floatValue = this.f5370a.f5382l.floatValue();
            float floatValue2 = this.f5370a.f5381k.floatValue();
            for (int i2 = 0; i2 < i; i2++) {
                float f2 = (floatValue - this.f5370a.f5383m) * this.f5370a.f5373c;
                SpringAnimator springAnimator = this.f5370a;
                springAnimator.f5377g += f2 * 60.0f;
                SpringAnimator springAnimator2 = this.f5370a;
                springAnimator2.f5377g *= this.f5370a.f5374d;
                springAnimator2 = this.f5370a;
                springAnimator2.f5383m += this.f5370a.f5377g / 60.0f;
            }
            this.f5370a.f5385o = round;
            float f3 = floatValue - floatValue2;
            float f4 = this.f5370a.f5383m - floatValue2;
            if (f4 == 0.0f || f3 == 0.0f) {
                f3 = 1.0f;
            } else {
                f3 = f4 / f3;
                if (this.f5370a.f5387q) {
                    f3 = Math.min(f3, 1.0f);
                }
            }
            f4 = Math.abs(1.0f - f3);
            if (Math.abs(this.f5370a.f5377g) >= this.f5370a.f5376f || f4 >= this.f5370a.f5375e) {
                this.f5370a.f5372b.setDuration(2147483647L);
                return f3;
            }
            this.f5370a.f5377g = 0.0f;
            this.f5370a.f5372b.setDuration(0);
            return 1.0f;
        }
    }

    public /* synthetic */ Animator clone() {
        return m10272i();
    }

    public /* synthetic */ ValueAnimator m23578clone() {
        return m10272i();
    }

    public /* synthetic */ Object m23579clone() {
        return m10272i();
    }

    public void removeAllUpdateListeners() {
        this.f5386p = RegularImmutableList.a;
        m10268c();
    }

    public static SpringAnimator m10264a(Object obj, String str, float f) {
        SpringAnimator springAnimator = new SpringAnimator(m10261a(obj, str));
        springAnimator.m10262a(Float.valueOf(f));
        return springAnimator;
    }

    public static SpringAnimator m10265a(Object obj, String str, float f, float f2) {
        SpringAnimator springAnimator = new SpringAnimator(m10261a(obj, str));
        springAnimator.f5381k = Float.valueOf(f);
        springAnimator.f5380j = true;
        springAnimator.m10262a(Float.valueOf(f2));
        return springAnimator;
    }

    private static SpringAnimator m10266a(Object obj, String str, int i) {
        SpringAnimator springAnimator = new SpringAnimator(m10261a(obj, str));
        springAnimator.m10263a(Integer.valueOf(i));
        return springAnimator;
    }

    private static ObjectAnimator m10261a(Object obj, String str) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(obj);
        objectAnimator.setPropertyName(str);
        return objectAnimator;
    }

    private SpringAnimator(ObjectAnimator objectAnimator) {
        this.f5372b = objectAnimator;
        this.f5372b.setInterpolator(new SpringInterpolator(this));
        this.f5372b.addListener(new C04972(this));
    }

    private void m10268c() {
        this.f5372b.removeUpdateListener(this.f5371a);
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        Preconditions.checkNotNull(animatorUpdateListener);
        if (!this.f5386p.contains(animatorUpdateListener)) {
            if (this.f5386p.isEmpty()) {
                this.f5372b.addUpdateListener(this.f5371a);
            }
            Builder builder = ImmutableList.builder();
            builder.b(this.f5386p);
            builder.c(animatorUpdateListener);
            this.f5386p = builder.b();
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        Preconditions.checkNotNull(animatorUpdateListener);
        ImmutableList asList = this.f5386p.asList();
        asList.remove(animatorUpdateListener);
        this.f5386p = ImmutableList.copyOf(asList);
        if (this.f5386p.isEmpty()) {
            m10268c();
        }
    }

    private Object m10269d() {
        return this.f5372b.getTarget();
    }

    public void setTarget(Object obj) {
        this.f5372b.setTarget(obj);
    }

    private String m10270e() {
        return this.f5372b.getPropertyName();
    }

    private SpringAnimator m10262a(Float f) {
        this.f5379i = Float.class;
        this.f5382l = f;
        if (isStarted()) {
            this.f5381k = m10271h();
            this.f5372b.setFloatValues(new float[]{((Float) this.f5381k).floatValue(), ((Float) this.f5382l).floatValue()});
            this.f5372b.setDuration(2147483647L);
        }
        return this;
    }

    private SpringAnimator m10263a(Integer num) {
        this.f5379i = Integer.class;
        this.f5382l = num;
        if (isStarted()) {
            this.f5381k = m10271h();
            this.f5372b.setIntValues(new int[]{((Integer) this.f5381k).intValue(), ((Integer) this.f5382l).intValue()});
            this.f5372b.setDuration(2147483647L);
        }
        return this;
    }

    private Method m10267b(Object obj, String str) {
        if (this.f5378h == null) {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            String str2 = "get" + toUpperCase + str.substring(1);
            Class cls = obj.getClass();
            try {
                this.f5378h = cls.getMethod(str2, new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new RuntimeException("No getter found for " + cls.getName() + ":" + str);
            }
        }
        return this.f5378h;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.f5372b.setEvaluator(typeEvaluator);
    }

    public void start() {
        this.f5384n = 0;
        this.f5385o = 0;
        if (!this.f5380j) {
            this.f5381k = m10271h();
        }
        this.f5383m = this.f5381k.floatValue();
        if (this.f5379i == Integer.class) {
            this.f5372b.setIntValues(new int[]{((Integer) this.f5381k).intValue(), ((Integer) this.f5382l).intValue()});
        } else {
            this.f5372b.setFloatValues(new float[]{((Float) this.f5381k).floatValue(), ((Float) this.f5382l).floatValue()});
        }
        this.f5372b.start();
    }

    private Number m10271h() {
        Object d = m10269d();
        Method b = m10267b(d, m10270e());
        try {
            return (Number) b.invoke(d, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred invoking " + b.getName() + " on " + m10269d().getClass().getName());
        }
    }

    public void cancel() {
        this.f5372b.cancel();
        this.f5384n = 0;
        this.f5385o = 0;
    }

    public void end() {
        this.f5372b.end();
        this.f5384n = 0;
        this.f5385o = 0;
    }

    public long getStartDelay() {
        return this.f5372b.getStartDelay();
    }

    public void setStartDelay(long j) {
        this.f5372b.setStartDelay(j);
    }

    public boolean isRunning() {
        return this.f5372b.isRunning();
    }

    public boolean isStarted() {
        return this.f5372b.isStarted();
    }

    private SpringAnimator m10272i() {
        SpringAnimator a;
        int i;
        int i2 = 0;
        if (this.f5379i == Float.class) {
            a = m10264a(m10269d(), m10270e(), this.f5382l.floatValue());
        } else {
            a = m10266a(m10269d(), m10270e(), this.f5382l.intValue());
        }
        if (a.getListeners() != null) {
            ArrayList listeners = getListeners();
            int size = listeners.size();
            for (i = 0; i < size; i++) {
                a.addListener((AnimatorListener) listeners.get(i));
            }
        }
        i = this.f5386p.size();
        while (i2 < i) {
            a.addUpdateListener((AnimatorUpdateListener) this.f5386p.get(i2));
            i2++;
        }
        return a;
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("setDuration is not supported for SpringAnimator");
    }

    public long getDuration() {
        throw new UnsupportedOperationException("getDuration is not supported for SpringAnimator");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("setInterpolator is not supported for SpringAnimator");
    }
}
