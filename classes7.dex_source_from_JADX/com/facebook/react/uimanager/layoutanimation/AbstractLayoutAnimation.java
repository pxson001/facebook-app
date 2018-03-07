package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: fmt  */
public abstract class AbstractLayoutAnimation {
    private static final Map<InterpolatorType, Interpolator> f11915c = MapBuilder.m13608a(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator(), InterpolatorType.SPRING, new SimpleSpringInterpolator());
    @Nullable
    protected AnimatedPropertyType f11916a;
    protected int f11917b;
    @Nullable
    private Interpolator f11918d;
    private int f11919e;

    @Nullable
    abstract Animation mo754a(View view, int i, int i2, int i3, int i4);

    abstract boolean mo755a();

    AbstractLayoutAnimation() {
    }

    public final void m14183b() {
        this.f11916a = null;
        this.f11917b = 0;
        this.f11919e = 0;
        this.f11918d = null;
    }

    public final void m14180a(ReadableMap readableMap, int i) {
        Interpolator interpolator = null;
        this.f11916a = readableMap.hasKey("property") ? AnimatedPropertyType.fromString(readableMap.getString("property")) : null;
        if (readableMap.hasKey("duration")) {
            i = readableMap.getInt("duration");
        }
        this.f11917b = i;
        this.f11919e = readableMap.hasKey("delay") ? readableMap.getInt("delay") : 0;
        if (readableMap.hasKey("type")) {
            interpolator = m14178a(InterpolatorType.fromString(readableMap.getString("type")));
        }
        this.f11918d = interpolator;
        if (!mo755a()) {
            throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
        }
    }

    @Nullable
    public final Animation m14182b(View view, int i, int i2, int i3, int i4) {
        if (!mo755a()) {
            return null;
        }
        Animation a = mo754a(view, i, i2, i3, i4);
        if (a == null) {
            return a;
        }
        a.setDuration((long) (this.f11917b * 1));
        a.setStartOffset((long) (this.f11919e * 1));
        a.setInterpolator(this.f11918d);
        return a;
    }

    private static Interpolator m14178a(InterpolatorType interpolatorType) {
        Interpolator interpolator = (Interpolator) f11915c.get(interpolatorType);
        if (interpolator != null) {
            return interpolator;
        }
        throw new IllegalArgumentException("Missing interpolator for type : " + interpolatorType);
    }
}
