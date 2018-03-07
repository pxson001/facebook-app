package com.facebook.catalyst.views.gradient;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: latitudeDelta */
public class ReactAxialGradientManager$$PropsSetter implements ViewManagerSetter<ReactAxialGradientManager, ReactLinearGradient> {
    public final void m7245a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactAxialGradientManager reactAxialGradientManager = (ReactAxialGradientManager) viewManager;
        ReactLinearGradient reactLinearGradient = (ReactLinearGradient) view;
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
            case -1197189282:
                if (str.equals("locations")) {
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
            case -892483530:
                if (str.equals("startX")) {
                    z = true;
                    break;
                }
                break;
            case -892483529:
                if (str.equals("startY")) {
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
            case 3117789:
                if (str.equals("endX")) {
                    z = true;
                    break;
                }
                break;
            case 3117790:
                if (str.equals("endY")) {
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
                AccessibilityHelper.a(reactLinearGradient, reactStylesDiffMap.c(str));
                return;
            case true:
                reactLinearGradient.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactAxialGradientManager.setAccessibilityLiveRegion(reactLinearGradient, reactStylesDiffMap.c(str));
                return;
            case true:
                reactAxialGradientManager.setBackgroundColor(reactLinearGradient, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactAxialGradientManager.setColors(reactLinearGradient, reactStylesDiffMap.d(str));
                return;
            case true:
                reactAxialGradientManager.setDecomposedMatrix(reactLinearGradient, reactStylesDiffMap.e(str));
                return;
            case true:
                reactAxialGradientManager.setElevation(reactLinearGradient, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactLinearGradient.f5835c = reactStylesDiffMap.a(str, 0.0f);
                return;
            case true:
                reactLinearGradient.f5836d = reactStylesDiffMap.a(str, 0.0f);
                return;
            case true:
                reactAxialGradientManager.setImportantForAccessibility(reactLinearGradient, reactStylesDiffMap.c(str));
                return;
            case true:
                reactAxialGradientManager.setLocations(reactLinearGradient, reactStylesDiffMap.d(str));
                return;
            case true:
                reactLinearGradient.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactAxialGradientManager.setRenderToHardwareTexture(reactLinearGradient, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactLinearGradient.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactLinearGradient.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactLinearGradient.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactLinearGradient.f5833a = reactStylesDiffMap.a(str, 0.0f);
                return;
            case true:
                reactLinearGradient.f5834b = reactStylesDiffMap.a(str, 0.0f);
                return;
            case true:
                reactLinearGradient.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactAxialGradientManager.setTransform(reactLinearGradient, reactStylesDiffMap.e(str));
                return;
            case true:
                reactAxialGradientManager.setTranslateX(reactLinearGradient, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactAxialGradientManager.setTranslateY(reactLinearGradient, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7244a() {
        Map<String, String> hashMap = new HashMap(22);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("colors", "ColorArray");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("endX", "number");
        hashMap.put("endY", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("locations", "Array");
        hashMap.put("opacity", "number");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("startX", "number");
        hashMap.put("startY", "number");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
