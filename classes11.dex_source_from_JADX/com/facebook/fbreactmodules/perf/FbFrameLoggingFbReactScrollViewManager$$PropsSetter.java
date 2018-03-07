package com.facebook.fbreactmodules.perf;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.fbreact.views.fbscroll.FbReactScrollView;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: early_fetch */
public class FbFrameLoggingFbReactScrollViewManager$$PropsSetter implements ViewManagerSetter<FbFrameLoggingFbReactScrollViewManager, FbReactScrollView> {
    public final void m8717a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        FbFrameLoggingFbReactScrollViewManager fbFrameLoggingFbReactScrollViewManager = (FbFrameLoggingFbReactScrollViewManager) viewManager;
        FbReactScrollView fbReactScrollView = (FbReactScrollView) view;
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
            case -1553096443:
                if (str.equals("endFillColor")) {
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
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    z = true;
                    break;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
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
            case -252105751:
                if (str.equals("removeClippedSubviews")) {
                    z = true;
                    break;
                }
                break;
            case -220307356:
                if (str.equals("scrollPerfTag")) {
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
            case 692181369:
                if (str.equals("sendMomentumEvents")) {
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
            case 811343908:
                if (str.equals("contentInset")) {
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
                AccessibilityHelper.a(fbReactScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactScrollView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setAccessibilityLiveRegion(fbReactScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setBackgroundColor(fbReactScrollView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setContentInset(fbReactScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setDecomposedMatrix(fbReactScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setElevation(fbReactScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                int a = reactStylesDiffMap.a(str, 0);
                if (a != fbReactScrollView.f7449l) {
                    fbReactScrollView.f7449l = a;
                    fbReactScrollView.f7448k = new ColorDrawable(fbReactScrollView.f7449l);
                }
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setImportantForAccessibility(fbReactScrollView, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactScrollView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                z = reactStylesDiffMap.a(str, false);
                if (z && fbReactScrollView.f7440c == null) {
                    fbReactScrollView.f7440c = new Rect();
                }
                fbReactScrollView.f7439b = z;
                fbReactScrollView.m8632a();
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setRenderToHardwareTexture(fbReactScrollView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                fbReactScrollView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactScrollView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactScrollView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactScrollView.f7445h = reactStylesDiffMap.a(str, true);
                return;
            case true:
                fbReactScrollView.f7447j = reactStylesDiffMap.c(str);
                return;
            case true:
                fbReactScrollView.f7441d = reactStylesDiffMap.a(str, false);
                return;
            case true:
                fbReactScrollView.setVerticalScrollBarEnabled(reactStylesDiffMap.a(str, false));
                return;
            case true:
                fbReactScrollView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setTransform(fbReactScrollView, reactStylesDiffMap.e(str));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setTranslateX(fbReactScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbFrameLoggingFbReactScrollViewManager.setTranslateY(fbReactScrollView, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m8716a() {
        Map<String, String> hashMap = new HashMap(23);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("contentInset", "Map");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("endFillColor", "Color");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("removeClippedSubviews", "boolean");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("scrollEnabled", "boolean");
        hashMap.put("scrollPerfTag", "String");
        hashMap.put("sendMomentumEvents", "boolean");
        hashMap.put("showsVerticalScrollIndicator", "boolean");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
