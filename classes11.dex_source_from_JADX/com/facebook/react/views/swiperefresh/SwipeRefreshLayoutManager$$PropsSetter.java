package com.facebook.react.views.swiperefresh;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Red Space Friend view mutation failed */
public class SwipeRefreshLayoutManager$$PropsSetter implements ViewManagerSetter<SwipeRefreshLayoutManager, ReactSwipeRefreshLayout> {
    public final void m11959a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        SwipeRefreshLayoutManager swipeRefreshLayoutManager = (SwipeRefreshLayoutManager) viewManager;
        ReactSwipeRefreshLayout reactSwipeRefreshLayout = (ReactSwipeRefreshLayout) view;
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
            case -1609594047:
                if (str.equals("enabled")) {
                    z = true;
                    break;
                }
                break;
            case -1354842768:
                if (str.equals("colors")) {
                    z = true;
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
            case -885150488:
                if (str.equals("progressBackgroundColor")) {
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
            case -416037467:
                if (str.equals("progressViewOffset")) {
                    z = true;
                    break;
                }
                break;
            case -321826009:
                if (str.equals("refreshing")) {
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
            case 3530753:
                if (str.equals("size")) {
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
                AccessibilityHelper.a(reactSwipeRefreshLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactSwipeRefreshLayout.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                swipeRefreshLayoutManager.setAccessibilityLiveRegion(reactSwipeRefreshLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                swipeRefreshLayoutManager.setBackgroundColor(reactSwipeRefreshLayout, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                swipeRefreshLayoutManager.setColors(reactSwipeRefreshLayout, reactStylesDiffMap.d(str));
                return;
            case true:
                swipeRefreshLayoutManager.setDecomposedMatrix(reactSwipeRefreshLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                swipeRefreshLayoutManager.setElevation(reactSwipeRefreshLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setEnabled(reactStylesDiffMap.a(str, true));
                return;
            case true:
                swipeRefreshLayoutManager.setImportantForAccessibility(reactSwipeRefreshLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                reactSwipeRefreshLayout.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactSwipeRefreshLayout.setProgressViewOffset(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setRefreshing(reactStylesDiffMap.a(str, false));
                return;
            case true:
                swipeRefreshLayoutManager.setRenderToHardwareTexture(reactSwipeRefreshLayout, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactSwipeRefreshLayout.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactSwipeRefreshLayout.setSize(reactStylesDiffMap.a(str, 1));
                return;
            case true:
                reactSwipeRefreshLayout.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                swipeRefreshLayoutManager.setTransform(reactSwipeRefreshLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                swipeRefreshLayoutManager.setTranslateX(reactSwipeRefreshLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                swipeRefreshLayoutManager.setTranslateY(reactSwipeRefreshLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11958a() {
        Map<String, String> hashMap = new HashMap(22);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("colors", "ColorArray");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("enabled", "boolean");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("progressBackgroundColor", "Color");
        hashMap.put("progressViewOffset", "number");
        hashMap.put("refreshing", "boolean");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("size", "number");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
