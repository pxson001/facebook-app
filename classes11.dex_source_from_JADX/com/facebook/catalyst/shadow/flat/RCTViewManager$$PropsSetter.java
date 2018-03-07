package com.facebook.catalyst.shadow.flat;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: like_page_success */
public class RCTViewManager$$PropsSetter implements ViewManagerSetter<RCTViewManager, FlatViewGroup> {
    public final void m7208a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RCTViewManager rCTViewManager = (RCTViewManager) viewManager;
        FlatViewGroup flatViewGroup = (FlatViewGroup) view;
        boolean z = true;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals("translateX")) {
                    z = true;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    z = true;
                    break;
                }
                break;
            case -1702963415:
                if (str.equals("accessibilityComponentType")) {
                    z = false;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    z = true;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    z = true;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    z = true;
                    break;
                }
                break;
            case -252105751:
                if (str.equals("removeClippedSubviews")) {
                    z = true;
                    break;
                }
                break;
            case -80891667:
                if (str.equals("renderToHardwareTextureAndroid")) {
                    z = true;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    z = true;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                break;
            case 36255470:
                if (str.equals("accessibilityLiveRegion")) {
                    z = true;
                    break;
                }
                break;
            case 746986311:
                if (str.equals("importantForAccessibility")) {
                    z = true;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    z = true;
                    break;
                }
                break;
            case 1146842694:
                if (str.equals("accessibilityLabel")) {
                    z = true;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    z = true;
                    break;
                }
                break;
            case 1667773924:
                if (str.equals("needsOffscreenAlphaCompositing")) {
                    z = true;
                    break;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
                    z = true;
                    break;
                }
                break;
            case 1948272180:
                if (str.equals("decomposedMatrix")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                AccessibilityHelper.a(flatViewGroup, reactStylesDiffMap.c(str));
                return;
            case true:
                flatViewGroup.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTViewManager.setAccessibilityLiveRegion(flatViewGroup, reactStylesDiffMap.c(str));
                return;
            case true:
                reactStylesDiffMap.a(str, 0);
                return;
            case true:
                rCTViewManager.setDecomposedMatrix(flatViewGroup, reactStylesDiffMap.e(str));
                return;
            case true:
                rCTViewManager.setElevation(flatViewGroup, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTViewManager.setImportantForAccessibility(flatViewGroup, reactStylesDiffMap.c(str));
                return;
            case true:
                rCTViewManager.setHotspot(flatViewGroup, reactStylesDiffMap.e(str));
                return;
            case true:
                flatViewGroup.f5740j = reactStylesDiffMap.a(str, false);
                return;
            case true:
                flatViewGroup.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                rCTViewManager.setPointerEvents(flatViewGroup, reactStylesDiffMap.c(str));
                return;
            case true:
                flatViewGroup.m7082b(reactStylesDiffMap.a(str, false));
                return;
            case true:
                rCTViewManager.setRenderToHardwareTexture(flatViewGroup, reactStylesDiffMap.a(str, false));
                return;
            case true:
                flatViewGroup.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                flatViewGroup.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                flatViewGroup.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                flatViewGroup.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTViewManager.setTransform(flatViewGroup, reactStylesDiffMap.e(str));
                return;
            case true:
                rCTViewManager.setTranslateX(flatViewGroup, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTViewManager.setTranslateY(flatViewGroup, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7207a() {
        Map<String, String> hashMap = new HashMap(20);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("nativeBackgroundAndroid", "Map");
        hashMap.put("needsOffscreenAlphaCompositing", "boolean");
        hashMap.put("opacity", "number");
        hashMap.put("pointerEvents", "String");
        hashMap.put("removeClippedSubviews", "boolean");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
