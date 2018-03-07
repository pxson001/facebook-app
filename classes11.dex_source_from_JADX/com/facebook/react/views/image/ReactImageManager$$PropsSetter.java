package com.facebook.react.views.image;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SEARCHPORT.UPNP.ORG */
public class ReactImageManager$$PropsSetter implements ViewManagerSetter<ReactImageManager, ReactImageView> {
    public final void m11847a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactImageManager reactImageManager = (ReactImageManager) viewManager;
        ReactImageView reactImageView = (ReactImageView) view;
        Integer num = null;
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
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
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
            case -197243856:
                if (str.equals("fadeDuration")) {
                    z = true;
                    break;
                }
                break;
            case -138423119:
                if (str.equals("loadingIndicatorSrc")) {
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
            case 114148:
                if (str.equals("src")) {
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
            case 167841179:
                if (str.equals("shouldNotifyLoadEvents")) {
                    z = true;
                    break;
                }
                break;
            case 259927283:
                if (str.equals("overlayColor")) {
                    z = true;
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    z = true;
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    z = true;
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    z = true;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    z = true;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
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
            case 844292288:
                if (str.equals("progressiveRenderingEnabled")) {
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
            case 1327599912:
                if (str.equals("tintColor")) {
                    z = true;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
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
            case 2049757303:
                if (str.equals("resizeMode")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                AccessibilityHelper.a(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageManager.setAccessibilityLiveRegion(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageManager.setBackgroundColor(reactImageView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactImageManager.setBorderRadius(reactImageView, 4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                reactImageManager.setBorderRadius(reactImageView, 3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactImageManager.setBorderColor(reactImageView, num);
                return;
            case true:
                reactImageManager.setBorderRadius(reactImageView, 0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                reactImageManager.setBorderRadius(reactImageView, 1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                reactImageManager.setBorderRadius(reactImageView, 2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                reactImageView.setBorderWidth(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactImageManager.setDecomposedMatrix(reactImageView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactImageManager.setElevation(reactImageView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactImageView.f11462s = reactStylesDiffMap.a(str, 0);
                return;
            case true:
                reactImageManager.setImportantForAccessibility(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageManager.setLoadingIndicatorSource(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactImageManager.setOverlayColor(reactImageView, num);
                return;
            case true:
                reactImageView.f11463t = reactStylesDiffMap.a(str, false);
                return;
            case true:
                reactImageManager.setRenderToHardwareTexture(reactImageView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactImageManager.setResizeMode(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactImageView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactImageView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactImageView.setShouldNotifyLoadEvents(reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactImageManager.setSource(reactImageView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactImageView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactImageManager.setTintColor(reactImageView, num);
                return;
            case true:
                reactImageManager.setTransform(reactImageView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactImageManager.setTranslateX(reactImageView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactImageManager.setTranslateY(reactImageView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11846a() {
        Map<String, String> hashMap = new HashMap(31);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("borderBottomLeftRadius", "number");
        hashMap.put("borderBottomRightRadius", "number");
        hashMap.put("borderColor", "Color");
        hashMap.put("borderRadius", "number");
        hashMap.put("borderTopLeftRadius", "number");
        hashMap.put("borderTopRightRadius", "number");
        hashMap.put("borderWidth", "number");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("fadeDuration", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("loadingIndicatorSrc", "String");
        hashMap.put("opacity", "number");
        hashMap.put("overlayColor", "number");
        hashMap.put("progressiveRenderingEnabled", "boolean");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("resizeMode", "String");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("shouldNotifyLoadEvents", "boolean");
        hashMap.put("src", "String");
        hashMap.put("testID", "String");
        hashMap.put("tintColor", "Color");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
