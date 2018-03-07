package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RCTStickerView */
public class ReactViewPagerManager$$PropsSetter implements ViewManagerSetter<ReactViewPagerManager, ReactViewPager> {
    public final void m12129a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactViewPagerManager reactViewPagerManager = (ReactViewPagerManager) viewManager;
        ReactViewPager reactViewPager = (ReactViewPager) view;
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
            case 1097821469:
                if (str.equals("pageMargin")) {
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
                AccessibilityHelper.a(reactViewPager, reactStylesDiffMap.c(str));
                return;
            case true:
                reactViewPager.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactViewPagerManager.setAccessibilityLiveRegion(reactViewPager, reactStylesDiffMap.c(str));
                return;
            case true:
                reactViewPagerManager.setBackgroundColor(reactViewPager, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactViewPagerManager.setDecomposedMatrix(reactViewPager, reactStylesDiffMap.e(str));
                return;
            case true:
                reactViewPagerManager.setElevation(reactViewPager, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactViewPagerManager.setImportantForAccessibility(reactViewPager, reactStylesDiffMap.c(str));
                return;
            case true:
                reactViewPager.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactViewPagerManager.setPageMargin(reactViewPager, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactViewPagerManager.setRenderToHardwareTexture(reactViewPager, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactViewPager.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactViewPager.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactViewPager.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactViewPager.f11626c = reactStylesDiffMap.a(str, true);
                return;
            case true:
                reactViewPager.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactViewPagerManager.setTransform(reactViewPager, reactStylesDiffMap.e(str));
                return;
            case true:
                reactViewPagerManager.setTranslateX(reactViewPager, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactViewPagerManager.setTranslateY(reactViewPager, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m12128a() {
        Map<String, String> hashMap = new HashMap(18);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("pageMargin", "number");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("scrollEnabled", "boolean");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
