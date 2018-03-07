package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: treehouse_reported_posts_queue */
class ScrollbarHelper {
    ScrollbarHelper() {
    }

    static int m1962a(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.v() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (state.e() - Math.max(LayoutManager.c(view), LayoutManager.c(view2))) - 1) : Math.max(0, Math.min(LayoutManager.c(view), LayoutManager.c(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(orientationHelper.b(view2) - orientationHelper.a(view))) / ((float) (Math.abs(LayoutManager.c(view) - LayoutManager.c(view2)) + 1)))) + ((float) (orientationHelper.c() - orientationHelper.a(view))));
    }

    static int m1961a(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.v() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(LayoutManager.c(view) - LayoutManager.c(view2)) + 1;
        }
        return Math.min(orientationHelper.f(), orientationHelper.b(view2) - orientationHelper.a(view));
    }

    static int m1963b(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.v() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.e();
        }
        return (int) ((((float) (orientationHelper.b(view2) - orientationHelper.a(view))) / ((float) (Math.abs(LayoutManager.c(view) - LayoutManager.c(view2)) + 1))) * ((float) state.e()));
    }
}
