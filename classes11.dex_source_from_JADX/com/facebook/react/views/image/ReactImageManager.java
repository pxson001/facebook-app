package com.facebook.react.views.image;

import android.graphics.PorterDuff.Mode;
import android.view.View;
import com.facebook.csslayout.CSSConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SCROLL_TO_TOP */
public class ReactImageManager extends SimpleViewManager<ReactImageView> {
    private ResourceDrawableIdHelper f11438a;
    @Nullable
    private AbstractDraweeControllerBuilder f11439b;
    @Nullable
    public final Object f11440c;

    protected final void m11850b(View view) {
        ReactImageView reactImageView = (ReactImageView) view;
        super.b(reactImageView);
        reactImageView.m11870c();
    }

    public final String m11849a() {
        return "RCTImageView";
    }

    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.f11439b = abstractDraweeControllerBuilder;
        this.f11440c = obj;
        this.f11438a = new ResourceDrawableIdHelper();
    }

    public ReactImageManager() {
        this.f11439b = null;
        this.f11440c = null;
        this.f11438a = new ResourceDrawableIdHelper();
    }

    public final AbstractDraweeControllerBuilder m11851d() {
        if (this.f11439b == null) {
            this.f11439b = Fresco.a();
        }
        return this.f11439b;
    }

    public final Object m11852e() {
        return this.f11440c;
    }

    public final View m11848a(ThemedReactContext themedReactContext) {
        return new ReactImageView(themedReactContext, m11851d(), this.f11440c);
    }

    @ReactProp(name = "src")
    public void setSource(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.m11868a(str, this.f11438a);
    }

    @ReactProp(name = "loadingIndicatorSrc")
    public void setLoadingIndicatorSource(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.m11869b(str, this.f11438a);
    }

    @ReactProp(customType = "Color", name = "borderColor")
    public void setBorderColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.setBorderColor(0);
        } else {
            reactImageView.setBorderColor(num.intValue());
        }
    }

    @ReactProp(name = "overlayColor")
    public void setOverlayColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.setOverlayColor(0);
        } else {
            reactImageView.setOverlayColor(num.intValue());
        }
    }

    @ReactProp(name = "borderWidth")
    public void setBorderWidth(ReactImageView reactImageView, float f) {
        reactImageView.setBorderWidth(f);
    }

    @ReactPropGroup(a = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"}, b = Float.NaN)
    public void setBorderRadius(ReactImageView reactImageView, int i, float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.a(f);
        }
        if (i == 0) {
            reactImageView.setBorderRadius(f);
        } else {
            reactImageView.m11867a(f, i - 1);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.setScaleType(ImageResizeMode.m11845a(str));
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.clearColorFilter();
        } else {
            reactImageView.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(name = "shouldNotifyLoadEvents")
    public void setLoadHandlersRegistered(ReactImageView reactImageView, boolean z) {
        reactImageView.setShouldNotifyLoadEvents(z);
    }

    @Nullable
    public final Map m11853h() {
        return MapBuilder.a(ImageLoadEvent.m11840a(4), MapBuilder.a("registrationName", "onLoadStart"), ImageLoadEvent.m11840a(2), MapBuilder.a("registrationName", "onLoad"), ImageLoadEvent.m11840a(3), MapBuilder.a("registrationName", "onLoadEnd"));
    }

    @ReactProp(name = "progressiveRenderingEnabled")
    public void setProgressiveRenderingEnabled(ReactImageView reactImageView, boolean z) {
        reactImageView.f11463t = z;
    }

    @ReactProp(name = "fadeDuration")
    public void setFadeDuration(ReactImageView reactImageView, int i) {
        reactImageView.f11462s = i;
    }
}
