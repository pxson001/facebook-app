package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: media_id */
public class MarginLayoutParamsCompat {
    static final MarginLayoutParamsCompatImpl f14541a;

    /* compiled from: media_id */
    class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
        public final int mo2808a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        public final int mo2810b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        public final void mo2809a(MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginStart(i);
        }

        public final void mo2811b(MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginEnd(i);
        }

        MarginLayoutParamsCompatImplJbMr1() {
        }
    }

    /* compiled from: media_id */
    interface MarginLayoutParamsCompatImpl {
        int mo2808a(MarginLayoutParams marginLayoutParams);

        void mo2809a(MarginLayoutParams marginLayoutParams, int i);

        int mo2810b(MarginLayoutParams marginLayoutParams);

        void mo2811b(MarginLayoutParams marginLayoutParams, int i);
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f14541a = new MarginLayoutParamsCompatImplJbMr1();
        } else {
            f14541a = new MarginLayoutParamsCompatImplBase();
        }
    }

    public static int m20965a(MarginLayoutParams marginLayoutParams) {
        return f14541a.mo2808a(marginLayoutParams);
    }

    public static int m20967b(MarginLayoutParams marginLayoutParams) {
        return f14541a.mo2810b(marginLayoutParams);
    }

    public static void m20966a(MarginLayoutParams marginLayoutParams, int i) {
        f14541a.mo2809a(marginLayoutParams, i);
    }

    public static void m20968b(MarginLayoutParams marginLayoutParams, int i) {
        f14541a.mo2811b(marginLayoutParams, i);
    }
}
