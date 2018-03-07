package com.facebook.maps;

import android.os.Handler;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.2;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: website */
public class MapMarkerPositionAnimator {
    public final Clock f264a;
    public final Handler f265b;
    public final Interpolator f266c = new LinearInterpolator();

    public static MapMarkerPositionAnimator m235b(InjectorLike injectorLike) {
        return new MapMarkerPositionAnimator((Clock) SystemClockMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MapMarkerPositionAnimator(Clock clock, Handler handler) {
        this.f264a = clock;
        this.f265b = handler;
    }

    public final void m236a(MarkerDelegate markerDelegate, LatLng latLng, int i, MapDelegate mapDelegate, @Nullable 2 2) {
        final long a = this.f264a.a();
        final LatLng a2 = markerDelegate.m361a();
        LatLngBounds latLngBounds = mapDelegate.m337b().m368a().e;
        if (latLngBounds.a(a2) || latLngBounds.a(latLng)) {
            final int i2 = i;
            final MarkerDelegate markerDelegate2 = markerDelegate;
            final LatLng latLng2 = latLng;
            final 2 22 = 2;
            HandlerDetour.a(this.f265b, new Runnable(this) {
                final /* synthetic */ MapMarkerPositionAnimator f263g;

                public void run() {
                    float interpolation = this.f263g.f266c.getInterpolation(((float) (this.f263g.f264a.a() - a)) / ((float) i2));
                    if (interpolation >= 1.0f) {
                        markerDelegate2.m363a(latLng2);
                        MapMarkerPositionAnimator mapMarkerPositionAnimator = this.f263g;
                        MapMarkerPositionAnimator.m234a(22);
                        return;
                    }
                    double d = (((double) interpolation) * latLng2.a) + (((double) (1.0f - interpolation)) * a2.a);
                    markerDelegate2.m363a(new LatLng(d, (((double) interpolation) * latLng2.b) + (((double) (1.0f - interpolation)) * a2.b)));
                    if (interpolation < 1.0f) {
                        HandlerDetour.b(this.f263g.f265b, this, 40, 1269072796);
                    }
                }
            }, 1691735031);
            return;
        }
        markerDelegate.m363a(latLng);
        m234a(2);
    }

    public static void m234a(@Nullable 2 2) {
        if (2 != null && Objects.equal(2.d.az, 2.a)) {
            FriendsNearbyMapFragment.a(2.d, 2.b, (double) ((Float) 2.c.c().get()).floatValue());
        }
    }
}
