package com.facebook.react.views.drawer;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SECTION_LOADING */
public class ReactDrawerLayoutManager$$PropsSetter implements ViewManagerSetter<ReactDrawerLayoutManager, ReactDrawerLayout> {
    public final void m11809a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactDrawerLayoutManager reactDrawerLayoutManager = (ReactDrawerLayoutManager) viewManager;
        ReactDrawerLayout reactDrawerLayout = (ReactDrawerLayout) view;
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
            case 268251989:
                if (str.equals("drawerWidth")) {
                    z = true;
                    break;
                }
                break;
            case 695891258:
                if (str.equals("drawerPosition")) {
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
            case 1857208703:
                if (str.equals("drawerLockMode")) {
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
                AccessibilityHelper.a(reactDrawerLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayout.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayoutManager.setAccessibilityLiveRegion(reactDrawerLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayoutManager.setBackgroundColor(reactDrawerLayout, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactDrawerLayoutManager.setDecomposedMatrix(reactDrawerLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                reactDrawerLayoutManager.setDrawerLockMode(reactDrawerLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayoutManager.setDrawerPosition(reactDrawerLayout, reactStylesDiffMap.a(str, 8388611));
                return;
            case true:
                reactDrawerLayoutManager.getDrawerWidth(reactDrawerLayout, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                ReactDrawerLayoutManager.m11814a(reactDrawerLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactDrawerLayoutManager.setImportantForAccessibility(reactDrawerLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayout.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactDrawerLayoutManager.setRenderToHardwareTexture(reactDrawerLayout, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactDrawerLayout.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactDrawerLayout.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactDrawerLayout.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactDrawerLayout.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactDrawerLayoutManager.setTransform(reactDrawerLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                reactDrawerLayoutManager.setTranslateX(reactDrawerLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactDrawerLayoutManager.setTranslateY(reactDrawerLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11808a() {
        Map<String, String> hashMap = new HashMap(19);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("drawerLockMode", "String");
        hashMap.put("drawerPosition", "number");
        hashMap.put("drawerWidth", "number");
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
