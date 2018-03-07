package com.facebook.messaging.location.sending;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.CancelableCallback;
import com.facebook.maps.delegate.MapDelegate.OnMyLocationChangeListener;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.resources.ui.FbTextView;
import com.facebook.uicontrib.fab.FabView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mMethodCategory */
public class MapDisplayFragment extends FbFragment {
    private FabView f11430a;
    private FbTextView f11431b;
    private FbMapViewDelegate f11432c;
    private ImageView f11433d;
    private CameraMovementType f11434e = CameraMovementType.USER;
    @Nullable
    public MapDisplayListener f11435f;
    @Nullable
    private MapDelegate f11436g;
    @Nullable
    private LatLng f11437h;

    /* compiled from: mMethodCategory */
    public interface MapDisplayListener {
        void mo437a();

        void mo438a(Location location);

        void mo439a(LatLng latLng);
    }

    /* compiled from: mMethodCategory */
    class C12711 implements OnMapReadyDelegateCallback {
        final /* synthetic */ MapDisplayFragment f11423a;

        C12711(MapDisplayFragment mapDisplayFragment) {
            this.f11423a = mapDisplayFragment;
        }

        public final void m12025a(MapDelegate mapDelegate) {
            this.f11423a.m12034a(mapDelegate);
        }
    }

    /* compiled from: mMethodCategory */
    class C12722 implements OnClickListener {
        final /* synthetic */ MapDisplayFragment f11424a;

        C12722(MapDisplayFragment mapDisplayFragment) {
            this.f11424a = mapDisplayFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 661971741);
            if (this.f11424a.f11435f != null) {
                this.f11424a.f11435f.mo437a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1446166228, a);
        }
    }

    /* compiled from: mMethodCategory */
    class C12744 implements OnMyLocationChangeListener {
        final /* synthetic */ MapDisplayFragment f11427a;

        C12744(MapDisplayFragment mapDisplayFragment) {
            this.f11427a = mapDisplayFragment;
        }

        public final void m12027a(Location location) {
            if (this.f11427a.f11435f != null) {
                this.f11427a.f11435f.mo438a(location);
            }
        }
    }

    /* compiled from: mMethodCategory */
    class C12755 implements OnCameraChangeListener {
        final /* synthetic */ MapDisplayFragment f11428a;

        C12755(MapDisplayFragment mapDisplayFragment) {
            this.f11428a = mapDisplayFragment;
        }

        public final void m12028a(CameraPosition cameraPosition) {
            this.f11428a.m12032a(cameraPosition);
        }
    }

    /* compiled from: mMethodCategory */
    class C12766 implements CancelableCallback {
        final /* synthetic */ MapDisplayFragment f11429a;

        C12766(MapDisplayFragment mapDisplayFragment) {
            this.f11429a = mapDisplayFragment;
        }

        public final void m12029a() {
            MapDisplayFragment.aq(this.f11429a);
        }

        public final void m12030b() {
            MapDisplayFragment.aq(this.f11429a);
        }
    }

    /* compiled from: mMethodCategory */
    enum CameraMovementType {
        USER,
        PROGRAMATIC
    }

    public final View m12044a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1292265036);
        View inflate = layoutInflater.inflate(2130905160, viewGroup);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -155033901, a);
        return inflate;
    }

    public final void m12046a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f11431b = (FbTextView) e(2131563665);
        this.f11433d = (ImageView) e(2131563664);
        this.f11432c = (FbMapViewDelegate) e(2131563544);
        this.f11432c.a(bundle);
        this.f11432c.a(new C12711(this));
        this.f11430a = (FabView) e(2131562517);
        this.f11430a.setOnClickListener(new C12722(this));
    }

    public final void m12049a(final boolean z) {
        this.f11432c.a(new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ MapDisplayFragment f11426b;

            public final void m12026a(MapDelegate mapDelegate) {
                mapDelegate.a(z);
            }
        });
    }

    private void m12034a(MapDelegate mapDelegate) {
        this.f11436g = mapDelegate;
        this.f11436g.a(new C12744(this));
        this.f11436g.c().c(false);
        this.f11436g.a(new C12755(this));
        this.f11436g.a(true);
    }

    private void m12032a(CameraPosition cameraPosition) {
        if (this.f11435f != null && this.f11434e != CameraMovementType.PROGRAMATIC && !cameraPosition.a.equals(this.f11437h)) {
            this.f11435f.mo439a(cameraPosition.a);
        }
    }

    public final void m12047a(MapDisplayListener mapDisplayListener) {
        this.f11435f = mapDisplayListener;
    }

    public final void m12050b() {
        m12040e();
        this.f11433d.setVisibility(0);
    }

    public final void m12048a(NearbyPlace nearbyPlace) {
        m12040e();
        this.f11433d.setVisibility(8);
        m12033a(nearbyPlace.f11447d);
        m12037b(nearbyPlace.f11447d);
    }

    public final void m12045a(Location location) {
        m12040e();
        this.f11433d.setVisibility(8);
        m12037b(new LatLng(location.getLatitude(), location.getLongitude()));
    }

    private void m12040e() {
        if (this.f11436g != null) {
            this.f11436g.a();
        }
    }

    private void m12033a(LatLng latLng) {
        if (this.f11436g != null) {
            MapDelegate mapDelegate = this.f11436g;
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.b = latLng;
            markerOptions = markerOptions;
            markerOptions.c = BitmapDescriptorFactory.a(2130841461);
            mapDelegate.a(markerOptions.a(0.5f, 1.0f));
        }
    }

    private void m12037b(LatLng latLng) {
        if (this.f11436g != null) {
            m12039b(false);
            this.f11434e = CameraMovementType.PROGRAMATIC;
            this.f11436g.a(CameraUpdateFactoryDelegate.a(latLng, 14.0f), 500, new C12766(this));
        }
    }

    public static void aq(MapDisplayFragment mapDisplayFragment) {
        Preconditions.checkNotNull(mapDisplayFragment.f11436g, "mMapDelegate became null after animation was started and before that animation was finished. That's super weird.");
        CameraPosition e = mapDisplayFragment.f11436g.e();
        mapDisplayFragment.f11437h = e == null ? null : e.a;
        mapDisplayFragment.f11434e = CameraMovementType.USER;
    }

    private void m12039b(boolean z) {
        if (z) {
            this.f11431b.setVisibility(0);
            this.f11430a.setVisibility(8);
            return;
        }
        this.f11431b.setVisibility(8);
        this.f11430a.setVisibility(0);
    }

    public final void m12041G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -927306017);
        super.G();
        this.f11432c.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -653187779, a);
    }

    public final void m12042H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1188938904);
        super.H();
        this.f11432c.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1498782337, a);
    }

    public final void m12043I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 218352420);
        super.I();
        this.f11432c.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1422539331, a);
    }

    public final void m12051e(Bundle bundle) {
        super.e(bundle);
        this.f11432c.b(bundle);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f11432c.b();
    }
}
