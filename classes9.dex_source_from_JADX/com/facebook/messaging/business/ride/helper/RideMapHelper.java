package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.location.Location;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsModels.BusinessRideLocationModel;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: moments_invite_clicked_bad_link */
public class RideMapHelper {
    private static volatile RideMapHelper f9175b;
    private final int f9176a;

    public static com.facebook.messaging.business.ride.helper.RideMapHelper m9708a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9175b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.business.ride.helper.RideMapHelper.class;
        monitor-enter(r1);
        r0 = f9175b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9710b(r0);	 Catch:{ all -> 0x0035 }
        f9175b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9175b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.ride.helper.RideMapHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.business.ride.helper.RideMapHelper");
    }

    private static RideMapHelper m9710b(InjectorLike injectorLike) {
        return new RideMapHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public RideMapHelper(Context context) {
        BitmapDescriptorFactory.a(context.getApplicationContext());
        this.f9176a = context.getResources().getDimensionPixelSize(2131430977);
    }

    public final void m9711a(MapDelegate mapDelegate, LatLng latLng, @Nullable LatLng latLng2) {
        Object obj = 1;
        mapDelegate.a();
        Builder a = LatLngBounds.a();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.c = BitmapDescriptorFactory.a(2130841418);
        markerOptions = markerOptions;
        markerOptions.b = latLng;
        markerOptions = markerOptions;
        markerOptions.j = 1.0f;
        mapDelegate.a(markerOptions);
        a.a(latLng);
        if (latLng2 != null) {
            MarkerOptions markerOptions2 = new MarkerOptions();
            markerOptions2.c = BitmapDescriptorFactory.a(2130841461);
            markerOptions2 = markerOptions2;
            markerOptions2.b = latLng2;
            markerOptions2 = markerOptions2;
            markerOptions2.j = 1.0f;
            mapDelegate.a(markerOptions2);
            a.a(latLng2);
            obj = null;
        }
        mapDelegate.a(obj != null ? CameraUpdateFactoryDelegate.a(latLng, 14.0f) : CameraUpdateFactoryDelegate.a(a.a(), this.f9176a));
    }

    @Nullable
    public static LatLng m9707a(@Nullable BusinessRideLocationModel businessRideLocationModel) {
        return businessRideLocationModel != null ? new LatLng(businessRideLocationModel.a(), businessRideLocationModel.b()) : null;
    }

    public static boolean m9709a(@Nullable LatLng latLng, @Nullable LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return false;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(latLng.a, latLng.b, latLng2.a, latLng2.b, fArr);
        return ((double) fArr[0]) <= 1.0d;
    }
}
