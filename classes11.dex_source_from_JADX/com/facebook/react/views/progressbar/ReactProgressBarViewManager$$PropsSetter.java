package com.facebook.react.views.progressbar;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestStats */
public class ReactProgressBarViewManager$$PropsSetter implements ViewManagerSetter<ReactProgressBarViewManager, ProgressBarContainerView> {
    public final void m11914a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactProgressBarViewManager reactProgressBarViewManager = (ReactProgressBarViewManager) viewManager;
        ProgressBarContainerView progressBarContainerView = (ProgressBarContainerView) view;
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
            case -1001078227:
                if (str.equals("progress")) {
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
            case 94842723:
                if (str.equals("color")) {
                    z = true;
                    break;
                }
                break;
            case 633138363:
                if (str.equals("indeterminate")) {
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
            case 1118509918:
                if (str.equals("animating")) {
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
            case 1804741442:
                if (str.equals("styleAttr")) {
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
                AccessibilityHelper.a(progressBarContainerView, reactStylesDiffMap.c(str));
                return;
            case true:
                progressBarContainerView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactProgressBarViewManager.setAccessibilityLiveRegion(progressBarContainerView, reactStylesDiffMap.c(str));
                return;
            case true:
                progressBarContainerView.f11485c = reactStylesDiffMap.a(str, false);
                return;
            case true:
                reactProgressBarViewManager.setBackgroundColor(progressBarContainerView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                Integer num;
                if (reactStylesDiffMap.b(str)) {
                    num = null;
                } else {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                progressBarContainerView.f11483a = num;
                return;
            case true:
                reactProgressBarViewManager.setDecomposedMatrix(progressBarContainerView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactProgressBarViewManager.setElevation(progressBarContainerView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactProgressBarViewManager.setImportantForAccessibility(progressBarContainerView, reactStylesDiffMap.c(str));
                return;
            case true:
                progressBarContainerView.f11484b = reactStylesDiffMap.a(str, false);
                return;
            case true:
                progressBarContainerView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                progressBarContainerView.f11486d = reactStylesDiffMap.a(str, 0.0d);
                return;
            case true:
                reactProgressBarViewManager.setRenderToHardwareTexture(progressBarContainerView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                progressBarContainerView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                progressBarContainerView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                progressBarContainerView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                progressBarContainerView.m11906a(reactStylesDiffMap.c(str));
                return;
            case true:
                progressBarContainerView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactProgressBarViewManager.setTransform(progressBarContainerView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactProgressBarViewManager.setTranslateX(progressBarContainerView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactProgressBarViewManager.setTranslateY(progressBarContainerView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11913a() {
        Map<String, String> hashMap = new HashMap(21);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("animating", "boolean");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("color", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("indeterminate", "boolean");
        hashMap.put("opacity", "number");
        hashMap.put("progress", "number");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("styleAttr", "String");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
