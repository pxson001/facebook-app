package com.facebook.fbreact.views.shimmer;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.widget.ShimmerFrameLayout;

/* compiled from: elapsed_time_to_interaction */
public class FbReactShimmerFrameLayoutManager extends ViewGroupManager<ShimmerFrameLayout> {
    public final View m8665a(ThemedReactContext themedReactContext) {
        ShimmerFrameLayout shimmerFrameLayout = new ShimmerFrameLayout(themedReactContext);
        shimmerFrameLayout.setAutoStart(false);
        return shimmerFrameLayout;
    }

    public final String m8666a() {
        return "RKShimmeringView";
    }

    @ReactProp(name = "enabled")
    public void setDisabled(ShimmerFrameLayout shimmerFrameLayout, boolean z) {
        if (z) {
            shimmerFrameLayout.b();
        } else {
            shimmerFrameLayout.c();
        }
    }

    @ReactProp(name = "speed")
    public void setSpeed(ShimmerFrameLayout shimmerFrameLayout, int i) {
        shimmerFrameLayout.setDuration(i);
    }
}
