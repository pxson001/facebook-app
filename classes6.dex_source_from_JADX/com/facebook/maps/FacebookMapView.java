package com.facebook.maps;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbui.draggable.HorizontalScrollInterceptingView;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.MapFragment.OnMapReadyListener;
import com.facebook.nearby.maps.MapCoordinateHelper;
import com.facebook.nearby.places.NearbyMapAreaFragment;
import com.facebook.nearby.places.NearbyMapAreaFragment.9;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;

/* compiled from: {%s %s} */
public class FacebookMapView extends MapView implements HorizontalScrollInterceptingView {
    private GeoPoint f125a = new GeoPoint(0, 0);
    public 9 f126b;
    public OnMapReadyListener f127c;
    private GeoPoint f128d = new GeoPoint(0, 0);
    private boolean f129e;
    private int f130f;
    public boolean f131g = false;
    private DefaultAndroidThreadUtil f132h = DefaultAndroidThreadUtil.b(FbInjector.get(getContext()));

    /* compiled from: {%s %s} */
    class C00191 implements Runnable {
        final /* synthetic */ FacebookMapView f122a;

        C00191(FacebookMapView facebookMapView) {
            this.f122a = facebookMapView;
        }

        public void run() {
            if (this.f122a.f126b != null) {
                9 9 = this.f122a.f126b;
                MapCoordinateHelper mapCoordinateHelper = 9.a.aU;
                GraphQLGeoRectangle a = MapCoordinateHelper.a(9.a.aB.c());
                9.a.h.a(9.a.at, 9.a.e, a);
                9.a.e = a;
                if (9.a.e() != null && 9.a.aA) {
                    9.a.a(9.a.ao.a(), false);
                    NearbyMapAreaFragment.aI(9.a);
                }
            }
        }
    }

    /* compiled from: {%s %s} */
    class C00202 implements Runnable {
        final /* synthetic */ FacebookMapView f123a;

        C00202(FacebookMapView facebookMapView) {
            this.f123a = facebookMapView;
        }

        public void run() {
            if (this.f123a.f126b != null) {
                9 9 = this.f123a.f126b;
                MapCoordinateHelper mapCoordinateHelper = 9.a.aU;
                GraphQLGeoRectangle a = MapCoordinateHelper.a(9.a.aB.c());
                9.a.h.a(9.a.at, 9.a.e, a);
                9.a.e = a;
                9.a.a(9.a.ao.a(), false);
                NearbyMapAreaFragment.aI(9.a);
            }
        }
    }

    /* compiled from: {%s %s} */
    class C00213 implements Runnable {
        final /* synthetic */ FacebookMapView f124a;

        C00213(FacebookMapView facebookMapView) {
            this.f124a = facebookMapView;
        }

        public void run() {
            if (!(this.f124a.f131g || this.f124a.f127c == null)) {
                this.f124a.f127c.m231a();
            }
            this.f124a.f131g = true;
        }
    }

    public FacebookMapView(Context context, String str) {
        super(context, str);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int zoomLevel = getZoomLevel();
        if (zoomLevel != this.f130f) {
            this.f130f = zoomLevel;
            if (this.f126b != null && !this.f129e) {
                this.f132h.a(new C00191(this), 500);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        FacebookMapView facebookMapView;
        FacebookMapView facebookMapView2;
        boolean z = true;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -577551623);
        GeoPoint mapCenter = getMapCenter();
        if (motionEvent.getAction() == 0) {
            this.f125a = mapCenter;
            facebookMapView = this;
        } else {
            if (motionEvent.getAction() == 1) {
                if (this.f125a.equals(mapCenter)) {
                    facebookMapView = this;
                } else {
                    facebookMapView2 = this;
                    facebookMapView2.f129e = z;
                }
            }
            z = super.onTouchEvent(motionEvent);
            LogUtils.a(-197334201, a);
            return z;
        }
        facebookMapView2 = facebookMapView;
        z = false;
        facebookMapView2.f129e = z;
        z = super.onTouchEvent(motionEvent);
        LogUtils.a(-197334201, a);
        return z;
    }

    public void computeScroll() {
        super.computeScroll();
        GeoPoint mapCenter = getMapCenter();
        if (this.f129e && this.f128d.equals(mapCenter)) {
            this.f132h.b(new C00202(this));
            this.f129e = false;
            return;
        }
        this.f128d = mapCenter;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f132h.b(new C00213(this));
    }
}
