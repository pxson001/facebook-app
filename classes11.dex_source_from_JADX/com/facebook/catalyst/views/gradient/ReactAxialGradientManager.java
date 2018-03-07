package com.facebook.catalyst.views.gradient;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: later_total_rss_kb */
public class ReactAxialGradientManager extends SimpleViewManager<ReactLinearGradient> {
    public final void m7248b(View view) {
        ((ReactLinearGradient) view).invalidate();
    }

    public final String m7247a() {
        return "RCTAxialGradientView";
    }

    protected final View m7246a(ThemedReactContext themedReactContext) {
        return new ReactLinearGradient(themedReactContext);
    }

    @ReactProp(name = "startX")
    public void setStartX(ReactLinearGradient reactLinearGradient, float f) {
        reactLinearGradient.f5833a = f;
    }

    @ReactProp(name = "startY")
    public void setStartY(ReactLinearGradient reactLinearGradient, float f) {
        reactLinearGradient.f5834b = f;
    }

    @ReactProp(name = "endX")
    public void setEndX(ReactLinearGradient reactLinearGradient, float f) {
        reactLinearGradient.f5835c = f;
    }

    @ReactProp(name = "endY")
    public void setEndY(ReactLinearGradient reactLinearGradient, float f) {
        reactLinearGradient.f5836d = f;
    }

    @ReactProp(customType = "ColorArray", name = "colors")
    public void setColors(ReactLinearGradient reactLinearGradient, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() < 2) {
            throw new JSApplicationIllegalArgumentException("The gradient must contain at least 2 colors");
        }
        int[] iArr = new int[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            iArr[i] = (int) readableArray.getDouble(i);
        }
        reactLinearGradient.f5837e = iArr;
    }

    @ReactProp(name = "locations")
    public void setLocations(ReactLinearGradient reactLinearGradient, @Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            reactLinearGradient.f5838f = null;
            return;
        }
        float[] fArr = new float[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        reactLinearGradient.f5838f = fArr;
    }
}
