package com.facebook.maps.delegate;

import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;

/* compiled from: vnd.android.cursor.item/website */
public class CameraUpdateFactoryDelegate {
    public static CameraUpdateDelegate m296a(CameraPosition cameraPosition) {
        CameraUpdateDelegate cameraUpdateDelegate = new CameraUpdateDelegate(0);
        cameraUpdateDelegate.f344b = cameraPosition;
        return cameraUpdateDelegate;
    }

    public static CameraUpdateDelegate m297a(LatLng latLng) {
        CameraUpdateDelegate cameraUpdateDelegate = new CameraUpdateDelegate(1);
        cameraUpdateDelegate.f345c = latLng;
        return cameraUpdateDelegate;
    }

    public static CameraUpdateDelegate m299a(LatLngBounds latLngBounds, int i) {
        CameraUpdateDelegate cameraUpdateDelegate = new CameraUpdateDelegate(2);
        cameraUpdateDelegate.f346d = latLngBounds;
        cameraUpdateDelegate.f354l = i;
        return cameraUpdateDelegate;
    }

    public static CameraUpdateDelegate m298a(LatLng latLng, float f) {
        CameraUpdateDelegate cameraUpdateDelegate = new CameraUpdateDelegate(4);
        cameraUpdateDelegate.f345c = latLng;
        cameraUpdateDelegate.f348f = f;
        return cameraUpdateDelegate;
    }
}
