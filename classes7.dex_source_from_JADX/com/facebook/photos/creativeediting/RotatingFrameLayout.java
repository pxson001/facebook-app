package com.facebook.photos.creativeediting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: magic_stories_feed_prompt_displayed */
public class RotatingFrameLayout extends CustomFrameLayout {
    public static final AtomicBoolean f9499b = new AtomicBoolean(false);
    @Inject
    public SpringSystem f9500a;
    public double f9501c;
    public double f9502d;
    private Spring f9503e;
    private boolean f9504f;
    public boolean f9505g;
    private int f9506h;
    private int f9507i;
    private final SpringListener f9508j = new C07741(this);

    /* compiled from: magic_stories_feed_prompt_displayed */
    class C07741 implements SpringListener {
        final /* synthetic */ RotatingFrameLayout f9498a;

        C07741(RotatingFrameLayout rotatingFrameLayout) {
            this.f9498a = rotatingFrameLayout;
        }

        public final void m11426a(Spring spring) {
            this.f9498a.setRotation((float) (((spring.d() > 1.0d ? 1.0d : spring.d()) * (this.f9498a.f9502d - this.f9498a.f9501c)) + this.f9498a.f9501c));
            if (spring.d() > 1.0d) {
                spring.l();
            }
        }

        public final void m11427b(Spring spring) {
            this.f9498a.setRotation((float) this.f9498a.f9502d);
            RotatingFrameLayout.m11431a(this.f9498a, -360.0d);
            this.f9498a.f9501c = this.f9498a.f9502d;
            RotatingFrameLayout.f9499b.set(false);
            this.f9498a.m11436a(false);
        }

        public final void m11428c(Spring spring) {
        }

        public final void m11429d(Spring spring) {
        }
    }

    private static <T extends View> void m11434a(Class<T> cls, T t) {
        m11435a((Object) t, t.getContext());
    }

    private static void m11435a(Object obj, Context context) {
        ((RotatingFrameLayout) obj).f9500a = SpringSystem.b(FbInjector.get(context));
    }

    static /* synthetic */ double m11431a(RotatingFrameLayout rotatingFrameLayout, double d) {
        double d2 = rotatingFrameLayout.f9502d % d;
        rotatingFrameLayout.f9502d = d2;
        return d2;
    }

    private void m11433a(SpringSystem springSystem) {
        this.f9500a = springSystem;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1695230073);
        super.onAttachedToWindow();
        this.f9504f = getContext().getResources().getConfiguration().orientation == 2;
        LogUtils.g(-846910651, a);
    }

    private void m11436a(boolean z) {
        if (z || this.f9502d % 180.0d == 0.0d) {
            setScaleX(1.0f);
            setScaleY(1.0f);
        } else {
            float scaleForRotation = getScaleForRotation();
            setScaleX(scaleForRotation);
            setScaleY(scaleForRotation);
        }
        requestLayout();
    }

    private float getScaleForRotation() {
        float measuredHeight = ((float) getMeasuredHeight()) / ((float) getMeasuredWidth());
        if (this.f9507i > this.f9506h) {
            if (measuredHeight > 1.0f) {
                measuredHeight = 1.0f / measuredHeight;
            }
        } else if (measuredHeight < 1.0f) {
            measuredHeight = 1.0f / measuredHeight;
        }
        if (this.f9504f) {
            return 1.0f / measuredHeight;
        }
        return measuredHeight;
    }

    public RotatingFrameLayout(Context context) {
        super(context);
        m11440f();
    }

    public RotatingFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11440f();
    }

    public RotatingFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11440f();
    }

    private void m11440f() {
        m11434a(RotatingFrameLayout.class, (View) this);
    }

    public int getFinalRotation() {
        return (int) (this.f9502d + 360.0d);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("super_state", super.onSaveInstanceState());
        bundle.putDouble("rotate_by", this.f9502d);
        bundle.putInt("original_image_width", this.f9506h);
        bundle.putInt("original_image_height", this.f9507i);
        bundle.putInt("measured_width", getMeasuredWidth());
        bundle.putInt("measured_height", getMeasuredHeight());
        bundle.putBoolean("is_landscape", this.f9504f);
        bundle.putBoolean("is_rotated", this.f9505g);
        return bundle;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 2) {
            this.f9504f = true;
        } else {
            this.f9504f = false;
        }
        m11436a(true);
        super.onConfigurationChanged(configuration);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            double d = bundle.getDouble("rotate_by");
            this.f9502d = d;
            this.f9501c = d;
            this.f9504f = bundle.getBoolean("is_landscape");
            m11442a(bundle.getInt("original_image_width"), bundle.getInt("original_image_height"));
            setMeasuredDimension(bundle.getInt("measured_width"), bundle.getInt("measured_height"));
            setRotation((float) ((int) this.f9502d));
            this.f9505g = bundle.getBoolean("is_rotated");
            parcelable = bundle.getParcelable("super_state");
        }
        m11436a(false);
        super.onRestoreInstanceState(parcelable);
    }

    public final void m11441a(double d) {
        if (!f9499b.getAndSet(true)) {
            this.f9505g = true;
            this.f9502d = this.f9501c + d;
            this.f9503e = this.f9500a.a().a(SpringConfig.a(40.0d, 5.0d)).b(0.0d).a(this.f9508j);
            this.f9503e.b(1.0d);
        }
    }

    public final void m11442a(int i, int i2) {
        this.f9506h = i;
        this.f9507i = i2;
    }

    public final boolean m11443a() {
        return this.f9505g;
    }

    public final void m11444b() {
        this.f9505g = false;
        this.f9501c = 0.0d;
        this.f9502d = 0.0d;
        setRotation(0.0f);
        m11436a(false);
    }
}
