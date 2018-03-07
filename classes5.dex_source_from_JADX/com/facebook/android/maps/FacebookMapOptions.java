package com.facebook.android.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.android.maps.model.CameraPosition;

/* compiled from: b10d9bd021be3b388270971fd5c4673c */
public final class FacebookMapOptions {
    public CameraPosition f8153a;
    public boolean f8154b;
    public int f8155c = 1;
    public boolean f8156d = true;
    public boolean f8157e = true;
    public boolean f8158f;
    public boolean f8159g;
    public boolean f8160h;
    public boolean f8161i;
    public boolean f8162j = true;
    public float f8163k = 2.0f;
    public float f8164l = 19.0f;
    public String f8165m;

    public static FacebookMapOptions m14310a(Context context, AttributeSet attributeSet) {
        FacebookMapOptions facebookMapOptions = new FacebookMapOptions();
        if (attributeSet != null) {
            facebookMapOptions.f8153a = CameraPosition.m14560a(attributeSet);
            facebookMapOptions.f8154b = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiCompass", facebookMapOptions.f8154b);
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "mapType");
            if ("satellite".equalsIgnoreCase(attributeValue)) {
                facebookMapOptions.f8155c = 2;
            } else if ("terrain".equalsIgnoreCase(attributeValue)) {
                facebookMapOptions.f8155c = 3;
            } else if ("hybrid".equalsIgnoreCase(attributeValue)) {
                facebookMapOptions.f8155c = 4;
            } else if ("live".equalsIgnoreCase(attributeValue)) {
                facebookMapOptions.f8155c = 5;
            }
            facebookMapOptions.f8156d = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiRotateGestures", facebookMapOptions.f8156d);
            facebookMapOptions.f8157e = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiScrollGestures", facebookMapOptions.f8157e);
            facebookMapOptions.f8158f = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiTiltGestures", facebookMapOptions.f8158f);
            facebookMapOptions.f8159g = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "mUseViewLifecycleInFragment", facebookMapOptions.f8159g);
            facebookMapOptions.f8160h = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "zOrderOnTop", facebookMapOptions.f8160h);
            facebookMapOptions.f8161i = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiZoomControls", facebookMapOptions.f8161i);
            facebookMapOptions.f8162j = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/facebook", "uiZoomGestures", facebookMapOptions.f8162j);
            facebookMapOptions.f8164l = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/facebook", "maxZoomLevel", facebookMapOptions.f8164l);
            facebookMapOptions.f8163k = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/facebook", "minZoomLevel", facebookMapOptions.f8163k);
            facebookMapOptions.f8165m = attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "surface");
        }
        return facebookMapOptions;
    }

    public final String m14311m() {
        return this.f8165m;
    }
}
