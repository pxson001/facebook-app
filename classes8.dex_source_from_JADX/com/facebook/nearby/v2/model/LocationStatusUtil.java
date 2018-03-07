package com.facebook.nearby.v2.model;

import android.app.Activity;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: disable */
public class LocationStatusUtil {
    private static final String[] f15295a = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private static volatile LocationStatusUtil f15296d;
    private ActivityRuntimePermissionsManagerProvider f15297b;
    private Lazy<FbLocationStatusUtil> f15298c;

    /* compiled from: disable */
    public enum LocationStatus {
        OKAY,
        LOCATION_PERMISSION_OFF,
        DEVICE_LOCATION_OFF,
        DEVICE_NON_OPTIMAL_LOCATION_SETTING
    }

    public static com.facebook.nearby.v2.model.LocationStatusUtil m17732a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15296d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.v2.model.LocationStatusUtil.class;
        monitor-enter(r1);
        r0 = f15296d;	 Catch:{ all -> 0x003a }
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
        r0 = m17733b(r0);	 Catch:{ all -> 0x0035 }
        f15296d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15296d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.v2.model.LocationStatusUtil.a(com.facebook.inject.InjectorLike):com.facebook.nearby.v2.model.LocationStatusUtil");
    }

    private static LocationStatusUtil m17733b(InjectorLike injectorLike) {
        return new LocationStatusUtil((ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 2483));
    }

    @Inject
    public LocationStatusUtil(ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Lazy<FbLocationStatusUtil> lazy) {
        this.f15297b = activityRuntimePermissionsManagerProvider;
        this.f15298c = lazy;
    }

    public final LocationStatus m17734a(Activity activity) {
        if (!this.f15297b.a(activity).a(f15295a)) {
            return LocationStatus.LOCATION_PERMISSION_OFF;
        }
        if (((FbLocationStatusUtil) this.f15298c.get()).a() != State.OKAY) {
            return LocationStatus.DEVICE_LOCATION_OFF;
        }
        if (((FbLocationStatusUtil) this.f15298c.get()).b().c.contains("network")) {
            return LocationStatus.DEVICE_NON_OPTIMAL_LOCATION_SETTING;
        }
        return LocationStatus.OKAY;
    }
}
