package com.facebook.fbreact.views.shimmer;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import com.facebook.widget.ShimmerFrameLayout;
import java.util.HashMap;
import java.util.Map;

/* compiled from: eligibleItemsSuggestions */
public class FbReactShimmerFrameLayoutManager$$PropsSetter implements ViewManagerSetter<FbReactShimmerFrameLayoutManager, ShimmerFrameLayout> {
    public final void m8664a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        FbReactShimmerFrameLayoutManager fbReactShimmerFrameLayoutManager = (FbReactShimmerFrameLayoutManager) viewManager;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view;
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
            case -1609594047:
                if (str.equals("enabled")) {
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
            case 109641799:
                if (str.equals("speed")) {
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
                AccessibilityHelper.a(shimmerFrameLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                shimmerFrameLayout.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setAccessibilityLiveRegion(shimmerFrameLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setBackgroundColor(shimmerFrameLayout, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setDecomposedMatrix(shimmerFrameLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setElevation(shimmerFrameLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setDisabled(shimmerFrameLayout, reactStylesDiffMap.a(str, false));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setImportantForAccessibility(shimmerFrameLayout, reactStylesDiffMap.c(str));
                return;
            case true:
                shimmerFrameLayout.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setRenderToHardwareTexture(shimmerFrameLayout, reactStylesDiffMap.a(str, false));
                return;
            case true:
                shimmerFrameLayout.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                shimmerFrameLayout.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                shimmerFrameLayout.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                shimmerFrameLayout.setDuration(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                shimmerFrameLayout.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setTransform(shimmerFrameLayout, reactStylesDiffMap.e(str));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setTranslateX(shimmerFrameLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                fbReactShimmerFrameLayoutManager.setTranslateY(shimmerFrameLayout, reactStylesDiffMap.a(str, 0.0f));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m8663a() {
        Map<String, String> hashMap = new HashMap(18);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("enabled", "boolean");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("speed", "number");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        return hashMap;
    }
}
