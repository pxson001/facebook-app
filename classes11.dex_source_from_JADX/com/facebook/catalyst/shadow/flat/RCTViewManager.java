package com.facebook.catalyst.shadow.flat;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactDrawableHelper;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: like_page_fail */
final class RCTViewManager extends FlatViewManager {
    private static final int[] f5806a = new int[2];

    RCTViewManager() {
    }

    public final void m7212a(View view, int i, @Nullable ReadableArray readableArray) {
        FlatViewGroup flatViewGroup = (FlatViewGroup) view;
        switch (i) {
            case 1:
                if (readableArray == null || readableArray.size() != 2) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
                } else if (VERSION.SDK_INT >= 21) {
                    flatViewGroup.getLocationOnScreen(f5806a);
                    flatViewGroup.drawableHotspotChanged(PixelUtil.a(readableArray.getDouble(0)) - ((float) f5806a[0]), PixelUtil.a(readableArray.getDouble(1)) - ((float) f5806a[1]));
                    return;
                } else {
                    return;
                }
            case 2:
                if (readableArray == null || readableArray.size() != 1) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
                }
                flatViewGroup.setPressed(readableArray.getBoolean(0));
                return;
            default:
                return;
        }
    }

    public final /* synthetic */ ReactShadowNode m7214c() {
        return m7210k();
    }

    public final /* synthetic */ LayoutShadowNode m7215d() {
        return m7210k();
    }

    public final String m7211a() {
        return "RCTView";
    }

    public final Map<String, Integer> m7216f() {
        return MapBuilder.a("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
    }

    private static RCTView m7210k() {
        return new RCTView();
    }

    public final Class<RCTView> m7213b() {
        return RCTView.class;
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public final void setHotspot(FlatViewGroup flatViewGroup, @Nullable ReadableMap readableMap) {
        Drawable drawable;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = ReactDrawableHelper.a(flatViewGroup.getContext(), readableMap);
        }
        if (flatViewGroup.f5741k != null) {
            flatViewGroup.f5741k.setCallback(null);
            flatViewGroup.unscheduleDrawable(flatViewGroup.f5741k);
        }
        if (drawable != null) {
            drawable.setCallback(flatViewGroup);
            if (drawable.isStateful()) {
                drawable.setState(flatViewGroup.getDrawableState());
            }
        }
        flatViewGroup.f5741k = drawable;
        flatViewGroup.invalidate();
    }

    @ReactProp(name = "pointerEvents")
    public final void setPointerEvents(FlatViewGroup flatViewGroup, @Nullable String str) {
        flatViewGroup.f5742l = m7209a(str);
    }

    @ReactProp(name = "removeClippedSubviews")
    public final void setRemoveClippedSubviews(FlatViewGroup flatViewGroup, boolean z) {
        flatViewGroup.m7082b(z);
    }

    private static PointerEvents m7209a(@Nullable String str) {
        if (str != null) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -2089141766:
                    if (str.equals("box-none")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -2089112978:
                    if (str.equals("box-only")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return PointerEvents.NONE;
                case 1:
                    return PointerEvents.AUTO;
                case 2:
                    return PointerEvents.BOX_NONE;
                case 3:
                    return PointerEvents.BOX_ONLY;
            }
        }
        return PointerEvents.AUTO;
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public final void setNeedsOffscreenAlphaCompositing(FlatViewGroup flatViewGroup, boolean z) {
        flatViewGroup.f5740j = z;
    }
}
