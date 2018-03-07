package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: proximity cm changed to  */
public class ViewUtils {
    static final Creator f7145a = new C04201();
    public static final ViewUtilsImpl f7146b;

    /* compiled from: proximity cm changed to  */
    final class C04201 implements Creator {
        C04201() {
        }

        public final ValueAnimatorCompat mo893a() {
            return new ValueAnimatorCompat(VERSION.SDK_INT >= 12 ? new ValueAnimatorCompatImplHoneycombMr1() : new ValueAnimatorCompatImplEclairMr1());
        }
    }

    /* compiled from: proximity cm changed to  */
    public interface ViewUtilsImpl {
        void mo894a(View view);
    }

    /* compiled from: proximity cm changed to  */
    class ViewUtilsImplBase implements ViewUtilsImpl {
        public final void mo894a(View view) {
        }
    }

    /* compiled from: proximity cm changed to  */
    class ViewUtilsImplLollipop implements ViewUtilsImpl {
        public final void mo894a(View view) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    ViewUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f7146b = new ViewUtilsImplLollipop();
        } else {
            f7146b = new ViewUtilsImplBase();
        }
    }

    public static ValueAnimatorCompat m10279a() {
        return f7145a.mo893a();
    }
}
