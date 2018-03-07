package com.facebook.fbreact.views.fbvpvlogger;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: empty_view */
public class FbReactVpvLoggerFlagManager$$PropsSetter implements ViewManagerSetter<FbReactVpvLoggerFlagManager, FbReactVpvLoggerFlag> {
    public final void m8656a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        FbReactVpvLoggerFlagManager fbReactVpvLoggerFlagManager = (FbReactVpvLoggerFlagManager) viewManager;
        FbReactVpvLoggerFlag fbReactVpvLoggerFlag = (FbReactVpvLoggerFlag) view;
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
            case 100479947:
                if (str.equals("isTop")) {
                    z = true;
                    break;
                }
                break;
            case 290731261:
                if (str.equals("feedUnitId")) {
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
                AccessibilityHelper.a(fbReactVpvLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactVpvLoggerFlag.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setAccessibilityLiveRegion(fbReactVpvLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setBackgroundColor(fbReactVpvLoggerFlag, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setDecomposedMatrix(fbReactVpvLoggerFlag, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setElevation(fbReactVpvLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactVpvLoggerFlag.f7481a = reactStylesDiffMap.c(str);
                return;
            case true:
                fbReactVpvLoggerFlagManager.setImportantForAccessibility(fbReactVpvLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactVpvLoggerFlag.f7482b = reactStylesDiffMap.a(str, false);
                return;
            case true:
                fbReactVpvLoggerFlag.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setRenderToHardwareTexture(fbReactVpvLoggerFlag, reactStylesDiffMap.a(str, false));
                return;
            case true:
                fbReactVpvLoggerFlag.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactVpvLoggerFlag.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactVpvLoggerFlag.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactVpvLoggerFlag.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setTransform(fbReactVpvLoggerFlag, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setTranslateX(fbReactVpvLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactVpvLoggerFlagManager.setTranslateY(fbReactVpvLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m8655a() {
        Map<String, String> hashMap = new HashMap(18);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("feedUnitId", "String");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("isTop", "boolean");
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
