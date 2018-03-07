package com.facebook.catalyst.shadow.flat;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

/* compiled from: load_success */
abstract class VirtualViewManager<C extends FlatShadowNode> extends ViewManager<View, C> {
    VirtualViewManager() {
    }

    protected final View m7133a(ThemedReactContext themedReactContext) {
        throw new RuntimeException(a() + " doesn't map to a View");
    }

    public final void m7134a(View view, Object obj) {
    }
}
