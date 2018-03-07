package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import javax.annotation.Nullable;

/* compiled from: REQUEST_FAILED */
public class FrescoBasedReactTextInlineImageViewManager extends ViewManager<View, FrescoBasedReactTextInlineImageShadowNode> {
    @Nullable
    private final AbstractDraweeControllerBuilder f11560a;
    @Nullable
    private final Object f11561b;

    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, null);
    }

    public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, @Nullable Object obj) {
        this.f11560a = abstractDraweeControllerBuilder;
        this.f11561b = obj;
    }

    public final String m12038a() {
        return "RCTTextInlineImage";
    }

    public final View m12037a(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    public final ReactShadowNode m12041c() {
        return new FrescoBasedReactTextInlineImageShadowNode(this.f11560a != null ? this.f11560a : Fresco.a(), this.f11561b);
    }

    public final Class<FrescoBasedReactTextInlineImageShadowNode> m12040b() {
        return FrescoBasedReactTextInlineImageShadowNode.class;
    }

    public final void m12039a(View view, Object obj) {
    }
}
