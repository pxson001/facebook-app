package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: friend_finder_2.0 */
public class RootViewManager$$PropsSetter implements ViewManagerSetter<RootViewManager, ViewGroup> {
    public final void mo739a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RootViewManager rootViewManager = (RootViewManager) viewManager;
        view = (ViewGroup) view;
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
            case 1948272180:
                if (str.equals("decomposedMatrix")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                AccessibilityHelper.m13786a(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                view.setContentDescription(reactStylesDiffMap.m13945c(str));
                return;
            case true:
                rootViewManager.setAccessibilityLiveRegion(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                rootViewManager.setBackgroundColor(view, reactStylesDiffMap.m13941a(str, 0));
                return;
            case true:
                rootViewManager.setDecomposedMatrix(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                rootViewManager.setElevation(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                rootViewManager.setImportantForAccessibility(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                view.setAlpha(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                rootViewManager.setRenderToHardwareTexture(view, reactStylesDiffMap.m13943a(str, false));
                return;
            case true:
                view.setRotation(reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                view.setScaleX(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                view.setScaleY(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                view.setTag(reactStylesDiffMap.m13945c(str));
                return;
            case true:
                rootViewManager.setTransform(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                rootViewManager.setTranslateX(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                rootViewManager.setTranslateY(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> mo733a() {
        Map<String, String> hashMap = new HashMap(16);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
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
