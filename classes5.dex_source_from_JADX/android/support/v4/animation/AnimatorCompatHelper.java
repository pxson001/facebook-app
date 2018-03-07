package android.support.v4.animation;

import android.os.Build.VERSION;

/* compiled from: work_manager_group */
public abstract class AnimatorCompatHelper {
    public static AnimatorProvider f1a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f1a = new HoneycombMr1AnimatorCompatProvider();
        } else {
            f1a = new DonutAnimatorCompatProvider();
        }
    }

    AnimatorCompatHelper() {
    }
}
