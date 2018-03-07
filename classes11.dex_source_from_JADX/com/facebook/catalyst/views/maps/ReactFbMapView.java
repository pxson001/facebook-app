package com.facebook.catalyst.views.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapReporterLauncher;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.ReportButtonDrawable;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.react.C1381R;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;
import javax.annotation.Nullable;

/* compiled from: last_server_ping_time */
public class ReactFbMapView extends MapView implements OnPreDrawListener, LifecycleEventListener {
    public boolean f5845t = false;
    private int f5846u = 2;
    private final Point f5847v = new Point();
    private final Point f5848w = new Point();
    @Nullable
    public ReportButtonDrawable f5849x;
    @Nullable
    public MapReporterLauncher f5850y;

    /* compiled from: last_server_ping_time */
    public class C07291 implements OnMapReadyCallback {
        final /* synthetic */ LatLngBounds f5840a;
        final /* synthetic */ ReactFbMapView f5841b;

        public C07291(ReactFbMapView reactFbMapView, LatLngBounds latLngBounds) {
            this.f5841b = reactFbMapView;
            this.f5840a = latLngBounds;
        }

        public final void m7249a(FacebookMap facebookMap) {
            facebookMap.b(CameraUpdateFactory.a(this.f5840a, this.f5841b.getWidth(), this.f5841b.getHeight(), 0));
        }
    }

    public ReactFbMapView(final Context context) {
        super(context);
        getViewTreeObserver().addOnPreDrawListener(this);
        final Resources resources = getResources();
        a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapView f5844c;

            public final void m7250a(FacebookMap facebookMap) {
                if (this.f5844c.f5850y == null) {
                    this.f5844c.f5850y = new MapReporterLauncher(context, resources.getString(C1381R.string.catalyst_maps_open_map_reporter), resources.getString(C1381R.string.catalyst_maps_reporter_dialog_message), null, null);
                }
                if (this.f5844c.f5849x == null) {
                    this.f5844c.f5849x = new ReportButtonDrawable(facebookMap, 0, this.f5844c.f5850y, resources.getString(C1381R.string.catalyst_maps_report_button));
                }
                ((ReportButtonDrawable) facebookMap.a(this.f5844c.f5849x)).a(true);
            }
        });
    }

    public boolean onPreDraw() {
        if (this.f5845t && this.f5846u > 0) {
            this.f5846u--;
        }
        return this.f5845t && this.f5846u == 0;
    }

    public final void hf_() {
    }

    public final void hg_() {
    }

    public final void hh_() {
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

    public final void m7252a(FacebookMap facebookMap, CameraPosition cameraPosition) {
        this.f5845t = true;
        m7251a((ReactContext) getContext(), facebookMap, cameraPosition);
    }

    private void m7251a(ReactContext reactContext, FacebookMap facebookMap, CameraPosition cameraPosition) {
        Projection h = facebookMap.h();
        this.f5847v.set(0, 0);
        LatLng a = h.a(this.f5847v);
        this.f5848w.set(getWidth(), getHeight());
        LatLng a2 = h.a(this.f5848w);
        double abs = Math.abs(a2.b - a.b);
        if (Math.signum(a.b) > 0.0d && Math.signum(a2.b) < 0.0d) {
            abs += 360.0d;
        }
        ((UIManagerModule) reactContext.b(UIManagerModule.class)).r().a(new RegionChangeEvent(getId(), SystemClock.b(), cameraPosition.a.a, cameraPosition.a.b, Math.abs(a2.a - a.a), abs));
    }
}
