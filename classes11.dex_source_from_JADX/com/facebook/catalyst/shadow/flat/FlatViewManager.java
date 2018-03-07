package com.facebook.catalyst.shadow.flat;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/* compiled from: locked_privacy */
abstract class FlatViewManager extends ViewGroupManager<FlatViewGroup> {
    FlatViewManager() {
    }

    public /* bridge */ /* synthetic */ void setBackgroundColor(View view, int i) {
    }

    protected final View m7084a(ThemedReactContext themedReactContext) {
        return new FlatViewGroup(themedReactContext);
    }
}
