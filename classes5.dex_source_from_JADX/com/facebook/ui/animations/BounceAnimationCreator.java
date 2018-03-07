package com.facebook.ui.animations;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import java.util.ArrayList;

/* compiled from: composer_add_photo */
public class BounceAnimationCreator {

    /* compiled from: composer_add_photo */
    class OscillationData {
        public Keyframe[] f5358a;
        public float f5359b;
    }

    public static ObjectAnimator m10254a(Object obj) {
        return m10253a(m10256a(0.1d, 10.0d, 0.9d, 0.1d, 0.2d), obj, "scaleX", "scaleY", 1);
    }

    public static ObjectAnimator m10255a(Object obj, String str, String str2) {
        return m10253a(m10256a(0.1d, 10.0d, 0.9d, 0.1d, 0.2d), obj, str, str2, -1);
    }

    private static ObjectAnimator m10253a(OscillationData oscillationData, Object obj, String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < oscillationData.f5358a.length; i2++) {
            float fraction = oscillationData.f5358a[i2].getFraction();
            float floatValue = ((((Float) oscillationData.f5358a[i2].getValue()).floatValue() * 0.6f) * ((float) i)) + 1.0f;
            if (fraction >= 0.0f && fraction <= 0.508489f) {
                arrayList.add(Keyframe.ofFloat((fraction - 0.0f) / 0.508489f, floatValue));
            }
        }
        ((Keyframe) arrayList.get(arrayList.size() - 1)).setValue(Float.valueOf(1.0f));
        long round = (long) Math.round(((oscillationData.f5359b - (oscillationData.f5359b * 0.508489f)) * 1000.0f) * 0.5f);
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(str, (Keyframe[]) arrayList.toArray(new Keyframe[arrayList.size()]));
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(str2, (Keyframe[]) arrayList.toArray(new Keyframe[arrayList.size()]));
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
        ofPropertyValuesHolder.setDuration(round);
        return ofPropertyValuesHolder;
    }

    private static OscillationData m10256a(double d, double d2, double d3, double d4, double d5) {
        OscillationData oscillationData = new OscillationData();
        double sqrt = Math.sqrt(d2 / d4);
        double sqrt2 = d3 / Math.sqrt((2.0d * d4) * d2);
        double sqrt3 = sqrt * Math.sqrt(1.0d - Math.pow(sqrt2, 2.0d));
        double d6 = d5 + (sqrt * d);
        oscillationData.f5359b = (float) ((-Math.log(0.01d / (d + d6))) / (sqrt2 * sqrt));
        double d7 = 2.0d * sqrt3;
        double d8 = 1.0d / d7;
        int ceil = ((int) Math.ceil(d7 * ((double) oscillationData.f5359b))) + 1;
        oscillationData.f5358a = new Keyframe[ceil];
        int i = 0;
        for (d7 = 0.0d; d7 < ((double) oscillationData.f5359b); d7 += d8) {
            double d9 = sqrt3 * d7;
            d9 = ((Math.sin(d9) * d6) + (Math.cos(d9) * d)) * Math.exp(-((sqrt2 * sqrt) * d7));
            oscillationData.f5358a[i] = Keyframe.ofFloat((float) (d7 / ((double) oscillationData.f5359b)), (float) d9);
            i++;
        }
        oscillationData.f5358a[ceil - 1] = Keyframe.ofFloat(1.0f, 0.0f);
        return oscillationData;
    }
}
