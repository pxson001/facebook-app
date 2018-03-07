package com.facebook.react.uimanager;

import android.view.View;

/* compiled from: framing bit expected to be set */
public abstract class SimpleViewManager<T extends View> extends BaseViewManager<T, LayoutShadowNode> {
    public final ReactShadowNode mo742c() {
        return new LayoutShadowNode();
    }

    public final Class<LayoutShadowNode> mo741b() {
        return LayoutShadowNode.class;
    }

    public final void mo740a(T t, Object obj) {
    }
}
