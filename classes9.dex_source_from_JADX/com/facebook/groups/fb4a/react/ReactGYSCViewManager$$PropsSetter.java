package com.facebook.groups.fb4a.react;

import android.view.View;
import com.facebook.groups.gysc.ReactGYSCRowView;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: payments_add_card_success */
public class ReactGYSCViewManager$$PropsSetter implements ViewManagerSetter<ReactGYSCViewManager, ReactGYSCRowView> {
    public final void m7206a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactGYSCViewManager reactGYSCViewManager = (ReactGYSCViewManager) viewManager;
        ReactGYSCRowView reactGYSCRowView = (ReactGYSCRowView) view;
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
                AccessibilityHelper.a(reactGYSCRowView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactGYSCRowView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactGYSCViewManager.setAccessibilityLiveRegion(reactGYSCRowView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactGYSCViewManager.setBackgroundColor(reactGYSCRowView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactGYSCViewManager.setDecomposedMatrix(reactGYSCRowView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactGYSCViewManager.setElevation(reactGYSCRowView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactGYSCViewManager.setImportantForAccessibility(reactGYSCRowView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactGYSCRowView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactGYSCViewManager.setRenderToHardwareTexture(reactGYSCRowView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactGYSCRowView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactGYSCRowView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactGYSCRowView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactGYSCRowView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactGYSCViewManager.setTransform(reactGYSCRowView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactGYSCViewManager.setTranslateX(reactGYSCRowView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactGYSCViewManager.setTranslateY(reactGYSCRowView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7205a() {
        Map<String, String> hashMap = new HashMap(16);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
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
        return hashMap;
    }
}
