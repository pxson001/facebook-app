package com.facebook.catalyst.views.maps;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import javax.annotation.Nullable;

/* compiled from: last_location */
public class ReactMapView extends MapView implements OnPreDrawListener, LifecycleEventListener, OnCameraChangeListener {
    @Nullable
    private LatLngBounds f5871a;
    public boolean f5872b = false;
    private int f5873c = 2;
    private final Point f5874d = new Point();
    private final Point f5875e = new Point();

    public ReactMapView(Context context) {
        super(context);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        if (this.f5872b && this.f5873c > 0) {
            this.f5873c--;
        }
        return this.f5872b && this.f5873c == 0;
    }

    public final void hf_() {
        a();
    }

    public final void hg_() {
        b();
    }

    public final void hh_() {
        c();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (this.f5871a != null && i5 > 0 && i6 > 0) {
            m7275a(this.f5871a, i5, i6);
            this.f5871a = null;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void m7277a(LatLngBounds latLngBounds) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            this.f5871a = latLngBounds;
        } else {
            m7275a(latLngBounds, width, height);
        }
    }

    private void m7275a(LatLngBounds latLngBounds, int i, int i2) {
        getMap().a(CameraUpdateFactory.a(latLngBounds, i, i2, 0));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void m7276a(CameraPosition cameraPosition) {
        this.f5872b = true;
        m7274a((ReactContext) getContext());
    }

    private void m7274a(ReactContext reactContext) {
        Projection f = getMap().f();
        this.f5874d.set(0, 0);
        LatLng a = f.a(this.f5874d);
        this.f5875e.set(getWidth(), getHeight());
        LatLng a2 = f.a(this.f5875e);
        double abs = Math.abs(a2.b - a.b);
        if (Math.signum(a.b) > 0.0d && Math.signum(a2.b) < 0.0d) {
            abs += 360.0d;
        }
        ((UIManagerModule) reactContext.b(UIManagerModule.class)).r().a(new RegionChangeEvent(getId(), SystemClock.b(), getMap().b().a.a, getMap().b().a.b, Math.abs(a2.a - a.a), abs));
    }
}
