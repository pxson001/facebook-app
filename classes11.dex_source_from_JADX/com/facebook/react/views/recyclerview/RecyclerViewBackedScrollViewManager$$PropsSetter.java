package com.facebook.react.views.recyclerview;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Referrer */
public class RecyclerViewBackedScrollViewManager$$PropsSetter implements ViewManagerSetter<RecyclerViewBackedScrollViewManager, RecyclerViewBackedScrollView> {
    public final void m11955a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RecyclerViewBackedScrollViewManager recyclerViewBackedScrollViewManager = (RecyclerViewBackedScrollViewManager) viewManager;
        RecyclerViewBackedScrollView recyclerViewBackedScrollView = (RecyclerViewBackedScrollView) view;
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
            case 1056207947:
                if (str.equals("onContentSizeChange")) {
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
                AccessibilityHelper.a(recyclerViewBackedScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                recyclerViewBackedScrollView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setAccessibilityLiveRegion(recyclerViewBackedScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setBackgroundColor(recyclerViewBackedScrollView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setDecomposedMatrix(recyclerViewBackedScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setElevation(recyclerViewBackedScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setImportantForAccessibility(recyclerViewBackedScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                recyclerViewBackedScrollView.f11504h = reactStylesDiffMap.a(str, false);
                return;
            case true:
                recyclerViewBackedScrollView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setRenderToHardwareTexture(recyclerViewBackedScrollView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                recyclerViewBackedScrollView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                recyclerViewBackedScrollView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                recyclerViewBackedScrollView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                recyclerViewBackedScrollView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setTransform(recyclerViewBackedScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setTranslateX(recyclerViewBackedScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                recyclerViewBackedScrollViewManager.setTranslateY(recyclerViewBackedScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11954a() {
        Map<String, String> hashMap = new HashMap(17);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("onContentSizeChange", "boolean");
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
