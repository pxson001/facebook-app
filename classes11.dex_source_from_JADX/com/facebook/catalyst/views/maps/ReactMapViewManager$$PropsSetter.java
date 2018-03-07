package com.facebook.catalyst.views.maps;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import com.google.android.gms.maps.MapView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: last_gull_gc_length */
public class ReactMapViewManager$$PropsSetter implements ViewManagerSetter<ReactMapViewManager, MapView> {
    public final void m7279a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactMapViewManager reactMapViewManager = (ReactMapViewManager) viewManager;
        MapView mapView = (MapView) view;
        Boolean bool = null;
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
            case -1422950650:
                if (str.equals("active")) {
                    z = true;
                    break;
                }
                break;
            case -1375324191:
                if (str.equals("pitchEnabled")) {
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
            case -1040869018:
                if (str.equals("rotateEnabled")) {
                    z = true;
                    break;
                }
                break;
            case -934795532:
                if (str.equals("region")) {
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
            case 1174265046:
                if (str.equals("showsUserLocation")) {
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
            case 1755945966:
                if (str.equals("zoomEnabled")) {
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
                AccessibilityHelper.a(mapView, reactStylesDiffMap.c(str));
                return;
            case true:
                mapView.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactMapViewManager.setAccessibilityLiveRegion(mapView, reactStylesDiffMap.c(str));
                return;
            case true:
                reactMapViewManager.setActive(mapView, reactStylesDiffMap.a(str, true));
                return;
            case true:
                reactMapViewManager.setBackgroundColor(mapView, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactMapViewManager.setDecomposedMatrix(mapView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactMapViewManager.setElevation(mapView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactMapViewManager.setImportantForAccessibility(mapView, reactStylesDiffMap.c(str));
                return;
            case true:
                mapView.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    bool = Boolean.valueOf(reactStylesDiffMap.a(str, false));
                }
                reactMapViewManager.setPitchEnabled(mapView, bool);
                return;
            case true:
                reactMapViewManager.setRegion(mapView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactMapViewManager.setRenderToHardwareTexture(mapView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    bool = Boolean.valueOf(reactStylesDiffMap.a(str, false));
                }
                reactMapViewManager.setRotateEnabled(mapView, bool);
                return;
            case true:
                mapView.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                mapView.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                mapView.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    bool = Boolean.valueOf(reactStylesDiffMap.a(str, false));
                }
                reactMapViewManager.setScrollEnabled(mapView, bool);
                return;
            case true:
                reactMapViewManager.setShowsUserLocation(mapView, reactStylesDiffMap.a(str, false));
                return;
            case true:
                mapView.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactMapViewManager.setTransform(mapView, reactStylesDiffMap.e(str));
                return;
            case true:
                reactMapViewManager.setTranslateX(mapView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactMapViewManager.setTranslateY(mapView, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    bool = Boolean.valueOf(reactStylesDiffMap.a(str, false));
                }
                reactMapViewManager.setZoomEnabled(mapView, bool);
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7278a() {
        Map<String, String> hashMap = new HashMap(23);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("active", "boolean");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("elevation", "number");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("opacity", "number");
        hashMap.put("pitchEnabled", "boolean");
        hashMap.put("region", "Map");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("rotateEnabled", "boolean");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("scrollEnabled", "boolean");
        hashMap.put("showsUserLocation", "boolean");
        hashMap.put("testID", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        hashMap.put("zoomEnabled", "boolean");
        return hashMap;
    }
}
