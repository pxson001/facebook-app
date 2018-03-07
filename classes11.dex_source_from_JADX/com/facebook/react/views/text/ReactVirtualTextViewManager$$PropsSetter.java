package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RKAnalytics */
public class ReactVirtualTextViewManager$$PropsSetter implements ViewManagerSetter<ReactVirtualTextViewManager, ReactTextView> {
    public final void m12018a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactVirtualTextViewManager reactVirtualTextViewManager = (ReactVirtualTextViewManager) viewManager;
        ReactTextView reactTextView = (ReactTextView) view;
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
            case -1329887265:
                if (str.equals("numberOfLines")) {
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
            case -1065511464:
                if (str.equals("textAlign")) {
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
            case -515807685:
                if (str.equals("lineHeight")) {
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
            case 1869416814:
                if (str.equals("textAlignVertical")) {
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
                AccessibilityHelper.a(reactTextView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setAccessibilityLiveRegion(reactTextView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setBackgroundColor(reactTextView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactVirtualTextViewManager.setDecomposedMatrix(reactTextView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactVirtualTextViewManager.setElevation(reactTextView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactVirtualTextViewManager.setImportantForAccessibility(reactTextView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setLineHeight(reactTextView, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                reactVirtualTextViewManager.setNumberOfLines(reactTextView, reactStylesDiffMap.a(str, Integer.MAX_VALUE));
                return;
            case true:
                reactTextView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactVirtualTextViewManager.setRenderToHardwareTexture(reactTextView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactTextView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactTextView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactTextView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactTextView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setTextAlign(reactTextView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setTextAlignVertical(reactTextView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactVirtualTextViewManager.setTransform(reactTextView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactVirtualTextViewManager.setTranslateX(reactTextView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactVirtualTextViewManager.setTranslateY(reactTextView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m12017a() {
        Map<String, String> hashMap = new HashMap(20);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("lineHeight", "number");
        hashMap.put("numberOfLines", "number");
        hashMap.put("opacity", "number");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("testID", "String");
        hashMap.put("textAlign", "String");
        hashMap.put("textAlignVertical", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
