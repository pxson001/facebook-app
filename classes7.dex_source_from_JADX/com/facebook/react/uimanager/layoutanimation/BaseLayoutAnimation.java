package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

/* compiled from: flyout_threaded_comments_feedback_animation_perf */
abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    abstract boolean mo756c();

    BaseLayoutAnimation() {
    }

    final boolean mo755a() {
        return this.f11917b > 0 && this.f11916a != null;
    }

    final Animation mo754a(View view, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        float f2 = mo756c() ? 1.0f : 0.0f;
        if (!mo756c()) {
            f = 1.0f;
        }
        if (this.f11916a != null) {
            switch (this.f11916a) {
                case OPACITY:
                    return new OpacityAnimation(view, f2, f);
                case SCALE_XY:
                    return new ScaleAnimation(f2, f, f2, f, 1, 0.5f, 1, 0.5f);
                default:
                    throw new IllegalViewOperationException("Missing animation for property : " + this.f11916a);
            }
        }
        throw new IllegalViewOperationException("Missing animated property from animation config");
    }
}
