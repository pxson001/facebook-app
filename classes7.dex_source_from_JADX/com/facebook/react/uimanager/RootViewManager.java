package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: fri */
public class RootViewManager extends ViewGroupManager<ViewGroup> {
    public final String mo744a() {
        return "RootView";
    }

    protected final View mo743a(ThemedReactContext themedReactContext) {
        return new SizeMonitoringFrameLayout(themedReactContext);
    }
}
