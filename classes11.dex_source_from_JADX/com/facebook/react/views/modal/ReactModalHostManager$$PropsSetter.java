package com.facebook.react.views.modal;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SAVE_LINK */
public class ReactModalHostManager$$PropsSetter implements ViewManagerSetter<ReactModalHostManager, ReactModalHostView> {
    public final void m11878a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactModalHostManager reactModalHostManager = (ReactModalHostManager) viewManager;
        ReactModalHostView reactModalHostView = (ReactModalHostView) view;
        boolean z = true;
        switch (str.hashCode()) {
            case -1726194350:
                if (str.equals("transparent")) {
                    z = true;
                    break;
                }
                break;
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
            case 2031205598:
                if (str.equals("animationType")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                AccessibilityHelper.a(reactModalHostView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostManager.setAccessibilityLiveRegion(reactModalHostView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostView.setAnimationType(reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostManager.setBackgroundColor(reactModalHostView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactModalHostManager.setDecomposedMatrix(reactModalHostView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactModalHostManager.setElevation(reactModalHostView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactModalHostManager.setImportantForAccessibility(reactModalHostView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactModalHostManager.setRenderToHardwareTexture(reactModalHostView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactModalHostView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactModalHostView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactModalHostView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactModalHostView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactModalHostManager.setTransform(reactModalHostView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactModalHostManager.setTranslateX(reactModalHostView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactModalHostManager.setTranslateY(reactModalHostView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactModalHostView.f11478c = reactStylesDiffMap.a(str, false);
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11877a() {
        Map<String, String> hashMap = new HashMap(18);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("animationType", "String");
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
        hashMap.put("transparent", "boolean");
        return hashMap;
    }
}
