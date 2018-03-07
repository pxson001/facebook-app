package com.facebook.react.uimanager;

import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

/* compiled from: friend_finder_send_invite_all */
public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> {
    @ReactProp(c = 0, customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(T t, int i) {
        t.setBackgroundColor(i);
    }

    @ReactProp(name = "decomposedMatrix")
    public void setDecomposedMatrix(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            m13804c(t);
        } else {
            m13803a(t, readableMap);
        }
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            m13804c(t);
        } else {
            m13803a(t, readableMap);
        }
    }

    @ReactProp(b = 1.0f, name = "opacity")
    public void setOpacity(T t, float f) {
        t.setAlpha(f);
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f) {
        if (VERSION.SDK_INT >= 21) {
            t.setElevation(PixelUtil.m13924a(f));
        }
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setLayerType(z ? 2 : 0, null);
    }

    @ReactProp(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(str);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setContentDescription(str);
    }

    @ReactProp(name = "accessibilityComponentType")
    public void setAccessibilityComponentType(T t, String str) {
        AccessibilityHelper.m13786a((View) t, str);
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str == null || str.equals("auto")) {
            t.setImportantForAccessibility(0);
        } else if (str.equals("yes")) {
            t.setImportantForAccessibility(1);
        } else if (str.equals("no")) {
            t.setImportantForAccessibility(2);
        } else if (str.equals("no-hide-descendants")) {
            t.setImportantForAccessibility(4);
        }
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f) {
        t.setRotation(f);
    }

    @ReactProp(b = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f) {
        t.setScaleX(f);
    }

    @ReactProp(b = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f) {
        t.setScaleY(f);
    }

    @ReactProp(b = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f) {
        t.setTranslationX(PixelUtil.m13924a(f));
    }

    @ReactProp(b = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f) {
        t.setTranslationY(PixelUtil.m13924a(f));
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (VERSION.SDK_INT < 19) {
            return;
        }
        if (str == null || str.equals("none")) {
            t.setAccessibilityLiveRegion(0);
        } else if (str.equals("polite")) {
            t.setAccessibilityLiveRegion(1);
        } else if (str.equals("assertive")) {
            t.setAccessibilityLiveRegion(2);
        }
    }

    private static void m13803a(View view, ReadableMap readableMap) {
        view.setTranslationX(PixelUtil.m13924a((float) readableMap.getDouble("translateX")));
        view.setTranslationY(PixelUtil.m13924a((float) readableMap.getDouble("translateY")));
        view.setRotation((float) readableMap.getDouble("rotate"));
        view.setRotationX((float) readableMap.getDouble("rotateX"));
        view.setRotationY((float) readableMap.getDouble("rotateY"));
        view.setScaleX((float) readableMap.getDouble("scaleX"));
        view.setScaleY((float) readableMap.getDouble("scaleY"));
    }

    private static void m13804c(View view) {
        view.setTranslationX(PixelUtil.m13924a(0.0f));
        view.setTranslationY(PixelUtil.m13924a(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }
}
