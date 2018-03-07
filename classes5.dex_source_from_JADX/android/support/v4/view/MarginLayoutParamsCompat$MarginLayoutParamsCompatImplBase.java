package android.support.v4.view;

import android.support.v4.view.MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: video_frame */
class MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
    MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase() {
    }

    public final int m342a(MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    public final int m344b(MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    public final void m343a(MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.leftMargin = i;
    }

    public final void m345b(MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.rightMargin = i;
    }
}
