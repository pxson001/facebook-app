package com.facebook.react.views.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.csslayout.CSSConstants;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: firstDeltaSequenceId =  */
public class ReactViewManager extends ViewGroupManager<ReactViewGroup> {
    private static final int[] f11972a = new int[]{8, 0, 2, 1, 3};

    public final int mo763a(ViewGroup viewGroup) {
        ReactViewGroup reactViewGroup = (ReactViewGroup) viewGroup;
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.f11964e;
        }
        return reactViewGroup.getChildCount();
    }

    public final void mo765a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactViewGroup reactViewGroup = (ReactViewGroup) view;
        switch (i) {
            case 1:
                if (readableArray == null || readableArray.size() != 2) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
                } else if (VERSION.SDK_INT >= 21) {
                    reactViewGroup.drawableHotspotChanged(PixelUtil.m13923a(readableArray.getDouble(0)), PixelUtil.m13923a(readableArray.getDouble(1)));
                    return;
                } else {
                    return;
                }
            case 2:
                if (readableArray == null || readableArray.size() != 1) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
                }
                reactViewGroup.setPressed(readableArray.getBoolean(0));
                return;
            default:
                return;
        }
    }

    public final void mo766a(ViewGroup viewGroup, View view, int i) {
        ReactViewGroup reactViewGroup = (ReactViewGroup) viewGroup;
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.m14232a(view, i);
        } else {
            reactViewGroup.addView(view, i);
        }
    }

    public final void mo767b(ViewGroup viewGroup) {
        ReactViewGroup reactViewGroup = (ReactViewGroup) viewGroup;
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.m14233b();
        } else {
            reactViewGroup.removeAllViews();
        }
    }

    public final void mo768b(ViewGroup viewGroup, int i) {
        ReactViewGroup reactViewGroup = (ReactViewGroup) viewGroup;
        if (reactViewGroup.getRemoveClippedSubviews()) {
            View a = m14237a(reactViewGroup, i);
            if (a.getParent() != null) {
                reactViewGroup.removeView(a);
            }
            reactViewGroup.m14231a(a);
            return;
        }
        reactViewGroup.removeViewAt(i);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setFocusable(z);
    }

    @ReactPropGroup(a = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"}, b = Float.NaN)
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i, float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        if (i == 0) {
            reactViewGroup.setBorderRadius(f);
        } else {
            reactViewGroup.m14228a(f, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, @Nullable String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, @Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            reactViewGroup.f11966g = null;
        } else {
            reactViewGroup.f11966g = new Rect((int) PixelUtil.m13923a(readableMap.getDouble("left")), (int) PixelUtil.m13923a(readableMap.getDouble("top")), (int) PixelUtil.m13923a(readableMap.getDouble("right")), (int) PixelUtil.m13923a(readableMap.getDouble("bottom")));
        }
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, @Nullable String str) {
        if (str != null) {
            reactViewGroup.f11967h = PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, @Nullable ReadableMap readableMap) {
        reactViewGroup.setTranslucentBackgroundDrawable(readableMap == null ? null : ReactDrawableHelper.m14202a(reactViewGroup.getContext(), readableMap));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setRemoveClippedSubviews(z);
    }

    @ReactPropGroup(a = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"}, b = Float.NaN)
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i, float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        reactViewGroup.m14229a(f11972a[i], f);
    }

    @ReactPropGroup(a = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"}, customType = "Color")
    public void setBorderColor(ReactViewGroup reactViewGroup, int i, Integer num) {
        reactViewGroup.m14234b(f11972a[i], num == null ? Float.NaN : (float) num.intValue());
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z) {
    }

    public final String mo744a() {
        return "RCTView";
    }

    public final View mo743a(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }

    public final Map<String, Integer> mo769f() {
        return MapBuilder.m13605a("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.f11971l = z;
    }

    private static View m14237a(ReactViewGroup reactViewGroup, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.m14226a(i);
        }
        return reactViewGroup.getChildAt(i);
    }
}
