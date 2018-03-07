package com.facebook.maps;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.view.View.OnTouchListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.maps.GoogleMapFragment.GoogleMapOverlayElement;
import com.facebook.nearby.places.NearbyMapAreaFragment.12;
import com.facebook.nearby.places.NearbyMapAreaFragment.9;
import com.google.android.maps.Projection;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: wifi_available */
public abstract class MapFragment extends FbFragment {

    /* compiled from: wifi_available */
    public interface OnMapReadyListener {
        void m231a();
    }

    public abstract GoogleMapOverlayElement mo11a(double d, double d2, Drawable drawable);

    public abstract void mo12a(double d);

    public abstract void mo13a(int i, int i2);

    public abstract void mo14a(Location location);

    public abstract void mo15a(OnTouchListener onTouchListener);

    public abstract void mo16a(@Nullable GoogleMapOverlayElement googleMapOverlayElement);

    public abstract void mo17a(OnMapReadyListener onMapReadyListener);

    public abstract void mo18a(12 12);

    public abstract void mo19a(9 9);

    public abstract void mo20a(boolean z);

    public abstract Location aq();

    public abstract ListenableFuture<Location> ar();

    public abstract void as();

    public abstract Location at();

    public abstract Location au();

    public abstract Location av();

    public abstract Location aw();

    public abstract RectF ax();

    public abstract Projection ay();

    public abstract boolean az();

    public abstract Location mo31b();

    public abstract ListenableFuture<Void> mo32b(Location location);

    public abstract void mo33b(GoogleMapOverlayElement googleMapOverlayElement);

    public abstract void mo34b(boolean z);

    public abstract double mo35e();
}
