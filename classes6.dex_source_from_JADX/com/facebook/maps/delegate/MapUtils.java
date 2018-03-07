package com.facebook.maps.delegate;

import android.util.AttributeSet;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: vnd.android.cursor.item/relation */
public class MapUtils {
    public static int m347a(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "map_source");
        if ("facebook".equalsIgnoreCase(attributeValue)) {
            return 0;
        }
        if ("google".equalsIgnoreCase(attributeValue)) {
            return 1;
        }
        return 2;
    }

    public static Integer m355b(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/facebook", "report_button_position");
        if ("bottom_left".equalsIgnoreCase(attributeValue)) {
            return Integer.valueOf(1);
        }
        if ("top_left".equalsIgnoreCase(attributeValue)) {
            return Integer.valueOf(3);
        }
        if ("top_right".equalsIgnoreCase(attributeValue)) {
            return Integer.valueOf(2);
        }
        if ("bottom_right".equalsIgnoreCase(attributeValue)) {
            return Integer.valueOf(0);
        }
        return null;
    }

    public static GoogleMapOptions m350a(FacebookMapOptions facebookMapOptions) {
        if (facebookMapOptions == null) {
            return null;
        }
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        googleMapOptions.f6639e = m352a(facebookMapOptions.a);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6641g = Boolean.valueOf(facebookMapOptions.b);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6638d = facebookMapOptions.c;
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6642h = Boolean.valueOf(facebookMapOptions.e);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6645k = Boolean.valueOf(facebookMapOptions.d);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6644j = Boolean.valueOf(facebookMapOptions.f);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6637c = Boolean.valueOf(facebookMapOptions.g);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6636b = Boolean.valueOf(facebookMapOptions.h);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6640f = Boolean.valueOf(facebookMapOptions.i);
        googleMapOptions = googleMapOptions;
        googleMapOptions.f6643i = Boolean.valueOf(facebookMapOptions.j);
        return googleMapOptions;
    }

    public static BitmapDescriptor m351a(com.facebook.android.maps.model.BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return null;
        }
        return BitmapDescriptorFactory.m9649a(bitmapDescriptor.a);
    }

    public static LatLng m353a(com.facebook.android.maps.model.LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new LatLng(latLng.a, latLng.b);
    }

    public static com.facebook.android.maps.model.LatLng m349a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.facebook.android.maps.model.LatLng(latLng.f6746a, latLng.f6747b);
    }

    public static CameraPosition m348a(com.google.android.gms.maps.model.CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = cameraPosition.f6723d;
        builder = builder;
        builder.a = m349a(cameraPosition.f6720a);
        builder = builder;
        builder.c = cameraPosition.f6722c;
        builder = builder;
        builder.b = cameraPosition.f6721b;
        builder = builder;
        return new CameraPosition(builder.a, builder.b, builder.c, builder.d);
    }

    public static com.google.android.gms.maps.model.CameraPosition m352a(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new com.google.android.gms.maps.model.CameraPosition(m353a(cameraPosition.a), cameraPosition.b, 0.0f, 0.0f);
    }

    public static LatLngBounds m354a(com.facebook.android.maps.model.LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        return new LatLngBounds(m353a(latLngBounds.c), m353a(latLngBounds.b));
    }
}
