package com.facebook.fbreact.views.fbperflogger;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: eom */
public class FbReactPerfLoggerFlagManager$$PropsSetter implements ViewManagerSetter<FbReactPerfLoggerFlagManager, FbReactPerfLoggerFlag> {
    public final void m8646a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        FbReactPerfLoggerFlagManager fbReactPerfLoggerFlagManager = (FbReactPerfLoggerFlagManager) viewManager;
        FbReactPerfLoggerFlag fbReactPerfLoggerFlag = (FbReactPerfLoggerFlag) view;
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
            case -253792294:
                if (str.equals("extraData")) {
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
            case 31228997:
                if (str.equals("eventName")) {
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
                AccessibilityHelper.a(fbReactPerfLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactPerfLoggerFlag.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setAccessibilityLiveRegion(fbReactPerfLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setBackgroundColor(fbReactPerfLoggerFlag, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setDecomposedMatrix(fbReactPerfLoggerFlag, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setElevation(fbReactPerfLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactPerfLoggerFlag.f7476b = reactStylesDiffMap.c(str);
                return;
            case true:
                fbReactPerfLoggerFlag.f7477c = reactStylesDiffMap.e(str);
                return;
            case true:
                fbReactPerfLoggerFlagManager.setImportantForAccessibility(fbReactPerfLoggerFlag, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactPerfLoggerFlag.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setRenderToHardwareTexture(fbReactPerfLoggerFlag, reactStylesDiffMap.a(str, false));
                return;
            case true:
                fbReactPerfLoggerFlag.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactPerfLoggerFlag.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactPerfLoggerFlag.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactPerfLoggerFlag.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setTransform(fbReactPerfLoggerFlag, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setTranslateX(fbReactPerfLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactPerfLoggerFlagManager.setTranslateY(fbReactPerfLoggerFlag, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m8645a() {
        Map<String, String> hashMap = new HashMap(18);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("eventName", "String");
        hashMap.put("extraData", "Map");
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
