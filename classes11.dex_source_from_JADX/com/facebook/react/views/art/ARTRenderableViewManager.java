package com.facebook.react.views.art;

import android.view.View;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

/* compiled from: SERVICE_ITEM_LARGE */
public class ARTRenderableViewManager extends ViewManager<View, ReactShadowNode> {
    private final String f11418a;

    public static ARTRenderableViewManager m11769d() {
        return new ARTRenderableViewManager("ARTGroup");
    }

    public static ARTRenderableViewManager m11770e() {
        return new ARTRenderableViewManager("ARTShape");
    }

    public static ARTRenderableViewManager m11771k() {
        return new ARTRenderableViewManager("ARTText");
    }

    private ARTRenderableViewManager(String str) {
        this.f11418a = str;
    }

    public final String m11773a() {
        return this.f11418a;
    }

    public final ReactShadowNode m11776c() {
        if (this.f11418a == "ARTGroup") {
            return new ARTGroupShadowNode();
        }
        if (this.f11418a == "ARTShape") {
            return new ARTShapeShadowNode();
        }
        if (this.f11418a == "ARTText") {
            return new ARTTextShadowNode();
        }
        throw new IllegalStateException("Unexpected type " + this.f11418a);
    }

    public final Class<? extends ReactShadowNode> m11775b() {
        if (this.f11418a == "ARTGroup") {
            return ARTGroupShadowNode.class;
        }
        if (this.f11418a == "ARTShape") {
            return ARTShapeShadowNode.class;
        }
        if (this.f11418a == "ARTText") {
            return ARTTextShadowNode.class;
        }
        throw new IllegalStateException("Unexpected type " + this.f11418a);
    }

    protected final View m11772a(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }

    public final void m11774a(View view, Object obj) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }
}
