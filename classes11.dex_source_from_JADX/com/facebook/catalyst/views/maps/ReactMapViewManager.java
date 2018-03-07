package com.facebook.catalyst.views.maps;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: last_full_gc_length */
public class ReactMapViewManager extends SimpleViewManager<MapView> {
    private static final Bundle f5876a = new Bundle();
    private static boolean f5877b;
    private static boolean f5878d;
    private static boolean f5879e;
    private static boolean f5880f;
    private static boolean f5881g;
    private final ReactContext f5882c;

    public final void m7285a(View view) {
        MapView mapView = (MapView) view;
        ((ReactContext) mapView.getContext()).b((ReactMapView) mapView);
        mapView.b();
        mapView.c();
    }

    private static boolean m7282a(Context context) {
        try {
            return GooglePlayServicesUtil.a(context) == 0;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public ReactMapViewManager(ReactContext reactContext) {
        this.f5882c = reactContext;
    }

    public final String m7284a() {
        return "RCTMap";
    }

    protected final View m7283a(ThemedReactContext themedReactContext) {
        if (GooglePlayServicesUtil.a(themedReactContext) != 0) {
            throw new JSApplicationCausedNativeException("Google Maps are not available on this device");
        }
        MapsInitializer.a(themedReactContext);
        Object reactMapView = new ReactMapView(themedReactContext);
        reactMapView.a(f5876a);
        reactMapView.a();
        reactMapView.getMap().a(reactMapView);
        if (!f5877b) {
            f5877b = true;
            m7281a(reactMapView.getMap().e());
        }
        themedReactContext.a(reactMapView);
        return reactMapView;
    }

    private static void m7281a(UiSettings uiSettings) {
        f5878d = uiSettings.b();
        f5879e = uiSettings.d();
        f5880f = uiSettings.a();
        f5881g = uiSettings.c();
    }

    @ReactProp(name = "showsUserLocation")
    public void setShowsUserLocation(MapView mapView, boolean z) {
        mapView.getMap().a(z);
    }

    @ReactProp(name = "zoomEnabled")
    public void setZoomEnabled(MapView mapView, @Nullable Boolean bool) {
        mapView.getMap().e().e(bool == null ? f5878d : bool.booleanValue());
    }

    @ReactProp(name = "rotateEnabled")
    public void setRotateEnabled(MapView mapView, @Nullable Boolean bool) {
        mapView.getMap().e().g(bool == null ? f5879e : bool.booleanValue());
    }

    @ReactProp(name = "scrollEnabled")
    public void setScrollEnabled(MapView mapView, @Nullable Boolean bool) {
        mapView.getMap().e().d(bool == null ? f5880f : bool.booleanValue());
    }

    @ReactProp(name = "pitchEnabled")
    public void setPitchEnabled(MapView mapView, @Nullable Boolean bool) {
        mapView.getMap().e().f(bool == null ? f5881g : bool.booleanValue());
    }

    @ReactProp(name = "region")
    public void setRegion(MapView mapView, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            ((ReactMapView) mapView).m7277a(m7280a(readableMap));
        }
    }

    @ReactProp(d = true, name = "active")
    public void setActive(MapView mapView, boolean z) {
        if (z) {
            mapView.a();
        } else {
            mapView.b();
        }
    }

    private static LatLngBounds m7280a(ReadableMap readableMap) {
        if (readableMap.hasKey("latitude") && readableMap.hasKey("latitudeDelta") && readableMap.hasKey("longitude") && readableMap.hasKey("longitudeDelta")) {
            double d = readableMap.getDouble("latitude");
            double d2 = readableMap.getDouble("longitude");
            double d3 = readableMap.getDouble("latitudeDelta");
            double d4 = readableMap.getDouble("longitudeDelta");
            return LatLngBounds.b().a(new LatLng(d - (0.5d * d3), d2 - (0.5d * d4))).a(new LatLng(d + (d3 * 0.5d), d2 + (0.5d * d4))).a();
        }
        throw new JSApplicationIllegalArgumentException("Region description is invalid");
    }

    public final Map<String, Object> m7286i() {
        Map hashMap = new HashMap();
        hashMap.put("IsGoogleMapsAvailable", Boolean.valueOf(m7282a(this.f5882c)));
        return hashMap;
    }
}
