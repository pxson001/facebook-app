package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.CancelableCallback;
import com.facebook.maps.delegate.MapDelegate.OnMyLocationChangeListener;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.ride.gating.IsRideGoogleMapEnabled;
import com.facebook.messaging.business.ride.helper.RideMapHelper;
import com.facebook.resources.ui.FbTextView;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mn_platform_msg_imp */
public class RideMapView extends CustomFrameLayout {
    @Inject
    RideMapHelper f9339a;
    @IsRideGoogleMapEnabled
    @Inject
    Provider<Boolean> f9340b;
    private FabView f9341c;
    private FbTextView f9342d;
    private FbMapViewDelegate f9343e;
    public ImageView f9344f;
    private CameraMovementType f9345g = CameraMovementType.USER;
    @Nullable
    public MapDisplayListener f9346h;
    @Nullable
    private LatLng f9347i;

    /* compiled from: mn_platform_msg_imp */
    class C10761 implements OnClickListener {
        final /* synthetic */ RideMapView f9326a;

        C10761(RideMapView rideMapView) {
            this.f9326a = rideMapView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1982559303);
            if (this.f9326a.f9346h != null) {
                this.f9326a.f9346h.mo333a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 337082887, a);
        }
    }

    /* compiled from: mn_platform_msg_imp */
    class C10782 implements OnMapReadyDelegateCallback {
        final /* synthetic */ RideMapView f9328a;

        /* compiled from: mn_platform_msg_imp */
        class C10771 implements OnMyLocationChangeListener {
            final /* synthetic */ C10782 f9327a;

            C10771(C10782 c10782) {
                this.f9327a = c10782;
            }

            public final void m9776a(Location location) {
                if (this.f9327a.f9328a.f9346h != null) {
                    this.f9327a.f9328a.f9346h.mo334a(location);
                }
            }
        }

        C10782(RideMapView rideMapView) {
            this.f9328a = rideMapView;
        }

        public final void m9777a(MapDelegate mapDelegate) {
            mapDelegate.a(new C10771(this));
            mapDelegate.a(true);
        }
    }

    /* compiled from: mn_platform_msg_imp */
    class C10803 implements OnMapReadyDelegateCallback {
        final /* synthetic */ RideMapView f9330a;

        /* compiled from: mn_platform_msg_imp */
        class C10791 implements OnCameraChangeListener {
            final /* synthetic */ C10803 f9329a;

            C10791(C10803 c10803) {
                this.f9329a = c10803;
            }

            public final void m9778a(CameraPosition cameraPosition) {
                this.f9329a.f9330a.m9789a(cameraPosition);
            }
        }

        C10803(RideMapView rideMapView) {
            this.f9330a = rideMapView;
        }

        public final void m9779a(MapDelegate mapDelegate) {
            mapDelegate.a(new C10791(this));
            mapDelegate.c().c(false);
        }
    }

    /* compiled from: mn_platform_msg_imp */
    class C10814 implements OnMapReadyDelegateCallback {
        final /* synthetic */ RideMapView f9331a;

        C10814(RideMapView rideMapView) {
            this.f9331a = rideMapView;
        }

        public final void m9780a(MapDelegate mapDelegate) {
            mapDelegate.a();
            this.f9331a.f9344f.setVisibility(0);
        }
    }

    /* compiled from: mn_platform_msg_imp */
    enum CameraMovementType {
        USER,
        PROGRAMATIC
    }

    /* compiled from: mn_platform_msg_imp */
    public interface MapDisplayListener {
        void mo333a();

        void mo334a(Location location);

        void mo335a(LatLng latLng);
    }

    private static <T extends View> void m9795a(Class<T> cls, T t) {
        m9796a((Object) t, t.getContext());
    }

    private static void m9796a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RideMapView) obj).m9792a(RideMapHelper.m9708a(injectorLike), IdBasedProvider.a(injectorLike, 4120));
    }

    private void m9792a(RideMapHelper rideMapHelper, Provider<Boolean> provider) {
        this.f9339a = rideMapHelper;
        this.f9340b = provider;
    }

    public RideMapView(Context context) {
        super(context);
        m9801h();
    }

    public RideMapView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m9801h();
    }

    public RideMapView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9801h();
    }

    private void m9801h() {
        int i;
        setContentView(2130906889);
        m9795a(RideMapView.class, (View) this);
        this.f9342d = (FbTextView) c(2131567054);
        this.f9344f = (ImageView) c(2131567053);
        this.f9343e = (FbMapViewDelegate) c(2131567052);
        FbMapViewDelegate fbMapViewDelegate = this.f9343e;
        if (((Boolean) this.f9340b.get()).booleanValue()) {
            i = 1;
        } else {
            i = 0;
        }
        fbMapViewDelegate.a = i;
        this.f9341c = (FabView) c(2131567055);
        this.f9341c.setOnClickListener(new C10761(this));
    }

    public final void m9804a() {
        this.f9343e.a(new C10782(this));
    }

    private void m9802i() {
        this.f9343e.a(new C10803(this));
    }

    private void m9789a(CameraPosition cameraPosition) {
        if (this.f9346h != null && this.f9345g != CameraMovementType.PROGRAMATIC && !cameraPosition.a.equals(this.f9347i)) {
            this.f9346h.mo335a(cameraPosition.a);
        }
    }

    public void setMapDisplayListener(MapDisplayListener mapDisplayListener) {
        this.f9346h = mapDisplayListener;
    }

    private void m9803j() {
        this.f9343e.a(new C10814(this));
    }

    public final void m9806a(Location location) {
        m9790a(m9800c(location));
    }

    private void m9790a(final LatLng latLng) {
        m9797a(false);
        this.f9345g = CameraMovementType.PROGRAMATIC;
        this.f9343e.a(new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ RideMapView f9335b;

            public final void m9783a(final MapDelegate mapDelegate) {
                mapDelegate.a(CameraUpdateFactoryDelegate.a(latLng, 15.0f), 500, new CancelableCallback(this) {
                    final /* synthetic */ C10835 f9333b;

                    public final void m9781a() {
                        this.f9333b.f9335b.m9791a(mapDelegate);
                    }

                    public final void m9782b() {
                        this.f9333b.f9335b.m9791a(mapDelegate);
                    }
                });
            }
        });
    }

    public final void m9805a(double d, double d2) {
        m9803j();
        m9790a(new LatLng(d, d2));
    }

    public final void m9807a(final Location location, final Location location2) {
        this.f9344f.setVisibility(4);
        this.f9343e.a(new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ RideMapView f9338c;

            public final void m9784a(MapDelegate mapDelegate) {
                this.f9338c.f9339a.m9711a(mapDelegate, RideMapView.m9800c(location), RideMapView.m9800c(location2));
            }
        });
    }

    private void m9791a(MapDelegate mapDelegate) {
        CameraPosition e = mapDelegate.e();
        this.f9347i = e == null ? null : e.a;
        this.f9345g = CameraMovementType.USER;
    }

    private void m9797a(boolean z) {
        if (z) {
            this.f9342d.setVisibility(0);
            this.f9341c.setVisibility(8);
            return;
        }
        this.f9342d.setVisibility(8);
        this.f9341c.setVisibility(0);
    }

    public static LatLng m9800c(Location location) {
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

    public final void m9808a(Bundle bundle) {
        this.f9343e.a(bundle);
        m9802i();
    }

    public final void m9809b() {
        this.f9343e.d();
    }

    public final void m9811e() {
        this.f9343e.c();
    }

    public final void m9812f() {
        this.f9343e.a();
    }

    public final void m9810b(Bundle bundle) {
        this.f9343e.b(bundle);
    }

    public final void m9813g() {
        this.f9343e.b();
    }
}
