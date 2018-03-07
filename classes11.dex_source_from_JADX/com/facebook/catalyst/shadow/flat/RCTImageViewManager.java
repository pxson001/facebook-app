package com.facebook.catalyst.shadow.flat;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;

/* compiled from: local_module */
final class RCTImageViewManager extends FlatViewManager {
    RCTImageViewManager() {
    }

    public final /* synthetic */ ReactShadowNode m7124c() {
        return m7121k();
    }

    public final /* synthetic */ LayoutShadowNode m7125d() {
        return m7121k();
    }

    public final String m7122a() {
        return "RCTImageView";
    }

    private static RCTImageView m7121k() {
        return new RCTImageView(new DrawImageWithDrawee());
    }

    public final Class<RCTImageView> m7123b() {
        return RCTImageView.class;
    }
}
