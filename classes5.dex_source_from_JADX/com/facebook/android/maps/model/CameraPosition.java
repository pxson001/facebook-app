package com.facebook.android.maps.model;

import android.util.AttributeSet;

/* compiled from: auto */
public final class CameraPosition {
    public final LatLng f8546a;
    public final float f8547b;
    public final float f8548c;
    public final float f8549d;

    /* compiled from: auto */
    public final class Builder {
        public LatLng f8542a;
        public float f8543b = Float.MIN_VALUE;
        public float f8544c = Float.MIN_VALUE;
        public float f8545d = Float.MIN_VALUE;
    }

    public static CameraPosition m14560a(AttributeSet attributeSet) {
        float parseFloat;
        LatLng latLng;
        Object obj;
        float parseFloat2;
        float f = Float.MIN_VALUE;
        Object obj2 = 1;
        Object obj3 = null;
        try {
            parseFloat = Float.parseFloat(attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "cameraBearing"));
            obj3 = 1;
        } catch (Exception e) {
            parseFloat = f;
        }
        try {
            latLng = new LatLng(Double.parseDouble(attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "cameraTargetLat")), Double.parseDouble(attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "cameraTargetLng")));
            obj = 1;
        } catch (Exception e2) {
            latLng = null;
            obj = obj3;
        }
        try {
            parseFloat2 = Float.parseFloat(attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "cameraTilt"));
            obj = 1;
        } catch (Exception e3) {
            parseFloat2 = f;
        }
        try {
            f = Float.parseFloat(attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "cameraZoom"));
        } catch (Exception e4) {
            obj2 = obj;
        }
        if (obj2 != null) {
            return new CameraPosition(latLng, f, parseFloat2, parseFloat);
        }
        return null;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this.f8546a = latLng;
        this.f8547b = f;
        this.f8548c = f2;
        this.f8549d = f3;
    }

    public final int hashCode() {
        float f = 17.0f;
        if (this.f8546a != null) {
            f = 527.0f + ((float) this.f8546a.hashCode());
        }
        return (int) ((((((f * 31.0f) + this.f8547b) * 31.0f) + this.f8548c) * 31.0f) + this.f8549d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.f8549d == cameraPosition.f8549d) {
            if (this.f8546a == null) {
                if (cameraPosition.f8546a == null) {
                    return true;
                }
            } else if (this.f8546a.equals(cameraPosition.f8546a) && this.f8548c == cameraPosition.f8548c && this.f8547b == cameraPosition.f8547b) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{target=" + this.f8546a + ", zoom=" + this.f8547b + ", tilt=" + this.f8548c + ", bearing=" + this.f8549d + "}";
    }
}
