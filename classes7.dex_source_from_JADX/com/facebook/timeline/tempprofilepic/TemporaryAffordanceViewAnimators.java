package com.facebook.timeline.tempprofilepic;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* compiled from: facecast_broadcaster_update */
public class TemporaryAffordanceViewAnimators {
    public static ObjectAnimator m18793b(View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        float a = m18792a(view.getContext()) + view.getY();
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("Y", new float[]{view.getY(), a});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        ofPropertyValuesHolder.setStartDelay(150);
        return ofPropertyValuesHolder;
    }

    public static ObjectAnimator m18794c(View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        float y = view.getY() - m18792a(view.getContext());
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("Y", new float[]{view.getY(), y});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    private static float m18792a(Context context) {
        return TypedValue.applyDimension(1, -3.0f, context.getResources().getDisplayMetrics());
    }
}
