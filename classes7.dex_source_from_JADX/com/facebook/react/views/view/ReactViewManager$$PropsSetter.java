package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: first_attachment_view */
public class ReactViewManager$$PropsSetter implements ViewManagerSetter<ReactViewManager, ReactViewGroup> {
    public final void mo739a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactViewManager reactViewManager = (ReactViewManager) viewManager;
        view = (ReactViewGroup) view;
        Integer num = null;
        boolean z = true;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    z = true;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals("borderRightWidth")) {
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
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    z = true;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals("borderTopWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1325118190:
                if (str.equals("collapsable")) {
                    z = true;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    z = true;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals("borderBottomWidth")) {
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
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    z = true;
                    break;
                }
                break;
            case -1141400650:
                if (str.equals("accessible")) {
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
            case -293492298:
                if (str.equals("pointerEvents")) {
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
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    z = true;
                    break;
                }
                break;
            case -223992013:
                if (str.equals("borderLeftWidth")) {
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
            case 737768677:
                if (str.equals("borderStyle")) {
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
            case 926871597:
                if (str.equals("hitSlop")) {
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
            case 1349188574:
                if (str.equals("borderRadius")) {
                    z = true;
                    break;
                }
                break;
            case 1667773924:
                if (str.equals("needsOffscreenAlphaCompositing")) {
                    z = true;
                    break;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
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
                AccessibilityHelper.m13786a(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                view.setContentDescription(reactStylesDiffMap.m13945c(str));
                return;
            case true:
                reactViewManager.setAccessibilityLiveRegion(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                view.setFocusable(reactStylesDiffMap.m13943a(str, false));
                return;
            case true:
                reactViewManager.setBackgroundColor(view, reactStylesDiffMap.m13941a(str, 0));
                return;
            case true:
                if (!reactStylesDiffMap.m13944b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.m13941a(str, 0));
                }
                reactViewManager.setBorderColor(view, 4, num);
                return;
            case true:
                reactViewManager.setBorderRadius(view, 4, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderRadius(view, 3, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderWidth(view, 4, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                if (!reactStylesDiffMap.m13944b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.m13941a(str, 0));
                }
                reactViewManager.setBorderColor(view, 0, num);
                return;
            case true:
                if (!reactStylesDiffMap.m13944b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.m13941a(str, 0));
                }
                reactViewManager.setBorderColor(view, 1, num);
                return;
            case true:
                reactViewManager.setBorderWidth(view, 1, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderRadius(view, 0, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                if (!reactStylesDiffMap.m13944b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.m13941a(str, 0));
                }
                reactViewManager.setBorderColor(view, 2, num);
                return;
            case true:
                reactViewManager.setBorderWidth(view, 2, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                view.setBorderStyle(reactStylesDiffMap.m13945c(str));
                return;
            case true:
                if (!reactStylesDiffMap.m13944b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.m13941a(str, 0));
                }
                reactViewManager.setBorderColor(view, 3, num);
                return;
            case true:
                reactViewManager.setBorderRadius(view, 1, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderRadius(view, 2, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderWidth(view, 3, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                reactViewManager.setBorderWidth(view, 0, reactStylesDiffMap.m13940a(str, Float.NaN));
                return;
            case true:
                boolean a = reactStylesDiffMap.m13943a(str, false);
                return;
            case true:
                reactViewManager.setDecomposedMatrix(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                reactViewManager.setElevation(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                reactViewManager.setHitSlop(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                reactViewManager.setImportantForAccessibility(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                reactViewManager.setNativeBackground(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                view.f11971l = reactStylesDiffMap.m13943a(str, false);
                return;
            case true:
                view.setAlpha(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                reactViewManager.setPointerEvents(view, reactStylesDiffMap.m13945c(str));
                return;
            case true:
                view.setRemoveClippedSubviews(reactStylesDiffMap.m13943a(str, false));
                return;
            case true:
                reactViewManager.setRenderToHardwareTexture(view, reactStylesDiffMap.m13943a(str, false));
                return;
            case true:
                view.setRotation(reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                view.setScaleX(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                view.setScaleY(reactStylesDiffMap.m13940a(str, 1.0f));
                return;
            case true:
                view.setTag(reactStylesDiffMap.m13945c(str));
                return;
            case true:
                reactViewManager.setTransform(view, reactStylesDiffMap.m13947e(str));
                return;
            case true:
                reactViewManager.setTranslateX(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            case true:
                reactViewManager.setTranslateY(view, reactStylesDiffMap.m13940a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> mo733a() {
        Map<String, String> hashMap = new HashMap(39);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("accessible", "boolean");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("borderBottomColor", "Color");
        hashMap.put("borderBottomLeftRadius", "number");
        hashMap.put("borderBottomRightRadius", "number");
        hashMap.put("borderBottomWidth", "number");
        hashMap.put("borderColor", "Color");
        hashMap.put("borderLeftColor", "Color");
        hashMap.put("borderLeftWidth", "number");
        hashMap.put("borderRadius", "number");
        hashMap.put("borderRightColor", "Color");
        hashMap.put("borderRightWidth", "number");
        hashMap.put("borderStyle", "String");
        hashMap.put("borderTopColor", "Color");
        hashMap.put("borderTopLeftRadius", "number");
        hashMap.put("borderTopRightRadius", "number");
        hashMap.put("borderTopWidth", "number");
        hashMap.put("borderWidth", "number");
        hashMap.put("collapsable", "boolean");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("hitSlop", "Map");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("nativeBackgroundAndroid", "Map");
        hashMap.put("needsOffscreenAlphaCompositing", "boolean");
        hashMap.put("opacity", "number");
        hashMap.put("pointerEvents", "String");
        hashMap.put("removeClippedSubviews", "boolean");
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
