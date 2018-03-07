package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: background_started */
public class ReactHorizontalScrollViewManager$$PropsSetter implements ViewManagerSetter<ReactHorizontalScrollViewManager, ReactHorizontalScrollView> {
    public final void m19042a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactHorizontalScrollViewManager reactHorizontalScrollViewManager = (ReactHorizontalScrollViewManager) viewManager;
        ReactHorizontalScrollView reactHorizontalScrollView = (ReactHorizontalScrollView) view;
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
            case -1553096443:
                if (str.equals("endFillColor")) {
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
            case -1151046732:
                if (str.equals("scrollEnabled")) {
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
            case -502352363:
                if (str.equals("pagingEnabled")) {
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
            case -220307356:
                if (str.equals("scrollPerfTag")) {
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
            case 692181369:
                if (str.equals("sendMomentumEvents")) {
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
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
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
                AccessibilityHelper.a(reactHorizontalScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactHorizontalScrollView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactHorizontalScrollViewManager.setAccessibilityLiveRegion(reactHorizontalScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactHorizontalScrollViewManager.setBackgroundColor(reactHorizontalScrollView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactHorizontalScrollViewManager.setDecomposedMatrix(reactHorizontalScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactHorizontalScrollViewManager.setElevation(reactHorizontalScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactHorizontalScrollView.setEndFillColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactHorizontalScrollViewManager.setImportantForAccessibility(reactHorizontalScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactHorizontalScrollView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactHorizontalScrollView.f19068e = reactStylesDiffMap.a(str, false);
                return;
            case true:
                reactHorizontalScrollView.setRemoveClippedSubviews(reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactHorizontalScrollViewManager.setRenderToHardwareTexture(reactHorizontalScrollView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactHorizontalScrollView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactHorizontalScrollView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactHorizontalScrollView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactHorizontalScrollView.f19071h = reactStylesDiffMap.a(str, true);
                return;
            case true:
                reactHorizontalScrollView.f19074k = reactStylesDiffMap.c(str);
                return;
            case true:
                reactHorizontalScrollView.f19072i = reactStylesDiffMap.a(str, false);
                return;
            case true:
                reactHorizontalScrollView.setHorizontalScrollBarEnabled(reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactHorizontalScrollView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactHorizontalScrollViewManager.setTransform(reactHorizontalScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactHorizontalScrollViewManager.setTranslateX(reactHorizontalScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactHorizontalScrollViewManager.setTranslateY(reactHorizontalScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m19041a() {
        Map<String, String> hashMap = new HashMap(23);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("endFillColor", "Color");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("pagingEnabled", "boolean");
        hashMap.put("removeClippedSubviews", "boolean");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("scrollEnabled", "boolean");
        hashMap.put("scrollPerfTag", "String");
        hashMap.put("sendMomentumEvents", "boolean");
        hashMap.put("showsHorizontalScrollIndicator", "boolean");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
