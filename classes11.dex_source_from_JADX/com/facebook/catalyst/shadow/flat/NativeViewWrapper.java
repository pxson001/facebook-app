package com.facebook.catalyst.shadow.flat;

import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import javax.annotation.Nullable;

/* compiled from: location_services_off */
final class NativeViewWrapper extends FlatShadowNode implements AndroidView {
    @Nullable
    private final ReactShadowNode f5768h;
    private final boolean f5769i;
    private boolean f5770j = false;

    NativeViewWrapper(ViewManager viewManager) {
        ReactShadowNode c = viewManager.c();
        if (c instanceof MeasureFunction) {
            this.f5768h = c;
            a((MeasureFunction) c);
        } else {
            this.f5768h = null;
        }
        if (viewManager instanceof ViewGroupManager) {
            this.f5769i = ((ViewGroupManager) viewManager).e();
        } else {
            this.f5769i = false;
        }
        ae();
    }

    public final boolean nZ_() {
        return this.f5769i;
    }

    public final boolean oa_() {
        return this.f5770j;
    }

    public final void mo162c() {
        this.f5770j = false;
    }

    public final void setBackgroundColor(int i) {
    }

    public final void m7103a(ThemedReactContext themedReactContext) {
        super.a(themedReactContext);
        if (this.f5768h != null) {
            this.f5768h.a(themedReactContext);
        }
    }

    final void mo161b(ReactStylesDiffMap reactStylesDiffMap) {
        if (this.f5768h != null) {
            ViewManagerPropertyUpdater.a(this.f5768h, reactStylesDiffMap);
        }
    }

    public final void m7102a(CSSNode cSSNode, int i) {
        super.a(cSSNode, i);
        if (cSSNode instanceof FlatShadowNode) {
            ((FlatShadowNode) cSSNode).ae();
        }
    }

    public final void m7104b(int i, float f) {
        if (k_().a(i, f)) {
            this.f5770j = true;
            f();
        }
    }
}
