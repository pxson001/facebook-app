package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import javax.annotation.Nullable;

/* compiled from: flexWrap */
class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    LayoutUpdateAnimation() {
    }

    final boolean mo755a() {
        return this.f11917b > 0;
    }

    @Nullable
    final Animation mo754a(View view, int i, int i2, int i3, int i4) {
        Object obj = null;
        Object obj2 = (view.getX() == ((float) i) && view.getY() == ((float) i2)) ? null : 1;
        if (!(view.getWidth() == i3 && view.getHeight() == i4)) {
            obj = 1;
        }
        if (obj2 == null && r1 == null) {
            return null;
        }
        return new PositionAndSizeAnimation(view, i, i2, i3, i4);
    }
}
