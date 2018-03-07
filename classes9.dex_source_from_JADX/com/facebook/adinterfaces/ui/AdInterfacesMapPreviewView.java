package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.adinterfaces.util.MapPickerLocaleAwareGeoHelper;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: V2_MESSAGE_REQUEST_HEADER */
public class AdInterfacesMapPreviewView extends CustomRelativeLayout implements OnMapReadyCallback {
    @Inject
    public MapPickerLocaleAwareGeoHelper f22783a;
    private MapView f22784b;
    private int f22785c;
    private double f22786d;
    private LatLng f22787e;

    private static <T extends View> void m24701a(Class<T> cls, T t) {
        m24702a((Object) t, t.getContext());
    }

    private static void m24702a(Object obj, Context context) {
        ((AdInterfacesMapPreviewView) obj).f22783a = MapPickerLocaleAwareGeoHelper.m25281a(FbInjector.get(context));
    }

    public AdInterfacesMapPreviewView(Context context) {
        super(context);
        m24699a();
    }

    public AdInterfacesMapPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24699a();
    }

    public AdInterfacesMapPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24699a();
    }

    private void m24699a() {
        m24701a(AdInterfacesMapPreviewView.class, (View) this);
        setContentView(2130903126);
        this.f22785c = (int) (getResources().getDimension(2131429293) / 2.0f);
        this.f22784b = (MapView) a(2131559307);
        this.f22784b.a(null);
    }

    public final void m24704a(LatLng latLng, double d) {
        this.f22787e = latLng;
        this.f22786d = d;
        this.f22784b.a(this);
    }

    public final void m24703a(FacebookMap facebookMap) {
        facebookMap.b(CameraUpdateFactory.a(this.f22787e, this.f22783a.m25284a(facebookMap, this.f22787e, this.f22786d, this.f22785c)));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void m24700a(MapPickerLocaleAwareGeoHelper mapPickerLocaleAwareGeoHelper) {
        this.f22783a = mapPickerLocaleAwareGeoHelper;
    }

    public final void m24705a(final LatLng latLng, Bitmap bitmap) {
        final BitmapDescriptor a = BitmapDescriptorFactory.a(bitmap);
        this.f22784b.a(new OnMapReadyCallback(this) {
            final /* synthetic */ AdInterfacesMapPreviewView f22782c;

            public final void m24698a(FacebookMap facebookMap) {
                facebookMap.b();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.c = a;
                markerOptions = markerOptions.a(0.5f, 0.93f);
                markerOptions.b = latLng;
                facebookMap.a(markerOptions);
            }
        });
    }
}
