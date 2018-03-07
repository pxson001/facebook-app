package com.facebook.location;

import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import com.facebook.common.android.LocationManagerMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: sms_takeover_disable_mms_auto_download_by_default */
public class FbLocationStatusUtil {
    private static final Class<?> f4545a = FbLocationStatusUtil.class;
    private static final ImmutableSet<String> f4546b = ImmutableSet.of("gps", "network");
    private static volatile FbLocationStatusUtil f4547f;
    private final Context f4548c;
    private final LocationManager f4549d;
    private final Lazy<ZeroFeatureVisibilityHelper> f4550e;

    public static com.facebook.location.FbLocationStatusUtil m8253a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4547f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.FbLocationStatusUtil.class;
        monitor-enter(r1);
        r0 = f4547f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8254b(r0);	 Catch:{ all -> 0x0035 }
        f4547f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4547f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.FbLocationStatusUtil.a(com.facebook.inject.InjectorLike):com.facebook.location.FbLocationStatusUtil");
    }

    private static FbLocationStatusUtil m8254b(InjectorLike injectorLike) {
        return new FbLocationStatusUtil((Context) injectorLike.getInstance(Context.class), LocationManagerMethodAutoProvider.m8262b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3754));
    }

    @Inject
    public FbLocationStatusUtil(Context context, LocationManager locationManager, Lazy<ZeroFeatureVisibilityHelper> lazy) {
        this.f4548c = context;
        this.f4549d = locationManager;
        this.f4550e = lazy;
    }

    public final State m8257a() {
        return m8250a(Priority.HIGH_ACCURACY, null, null);
    }

    final State m8258a(Priority priority) {
        return m8250a(priority, null, null);
    }

    public final FbLocationStatus m8259b() {
        return m8260b(Priority.HIGH_ACCURACY);
    }

    final FbLocationStatus m8260b(Priority priority) {
        if (!m8256c()) {
            return new FbLocationStatus(State.PERMISSION_DENIED, RegularImmutableSet.f688a, RegularImmutableSet.f688a);
        }
        Builder builder = ImmutableSet.builder();
        Builder builder2 = ImmutableSet.builder();
        return new FbLocationStatus(m8250a(priority, builder, builder2), builder.m4812b(), builder2.m4812b());
    }

    private State m8250a(Priority priority, @Nullable Builder<String> builder, @Nullable Builder<String> builder2) {
        Iterator it = f4546b.iterator();
        State state = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            State a = m8252a(str, priority);
            if (a == State.OKAY) {
                if (builder != null) {
                    builder.m4813c(str);
                }
            } else if (a == State.LOCATION_DISABLED && builder2 != null) {
                builder2.m4813c(str);
            }
            state = m8251a(state, a);
        }
        return state;
    }

    private State m8252a(String str, Priority priority) {
        try {
            LocationProvider a = m8249a(str);
            if (a == null) {
                return State.LOCATION_UNSUPPORTED;
            }
            if (a.getPowerRequirement() == 3 && priority != Priority.HIGH_ACCURACY) {
                return State.LOCATION_UNSUPPORTED;
            }
            if (a.hasMonetaryCost() && this.f4550e.get() != null && ((FbZeroFeatureVisibilityHelper) this.f4550e.get()).m7924a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL)) {
                return State.LOCATION_UNSUPPORTED;
            }
            if (this.f4549d.isProviderEnabled(str)) {
                return State.OKAY;
            }
            return State.LOCATION_DISABLED;
        } catch (SecurityException e) {
            return State.PERMISSION_DENIED;
        }
    }

    @Nullable
    private LocationProvider m8249a(String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(this.f4549d);
        try {
            return this.f4549d.getProvider(str);
        } catch (NullPointerException e) {
            new Object[1][0] = str;
            return null;
        } catch (IllegalArgumentException e2) {
            new Object[1][0] = str;
            return null;
        } catch (IllegalStateException e3) {
            new Object[1][0] = str;
            return null;
        }
    }

    private static State m8251a(@Nullable State state, @Nullable State state2) {
        if (state == null) {
            return state2;
        }
        if (state2 == null) {
            return state;
        }
        State[] stateArr = new State[]{state2};
        int length = stateArr.length;
        int i = 0;
        Comparable comparable = state;
        while (i < length) {
            Comparable comparable2 = stateArr[i];
            if (comparable.compareTo(comparable2) >= 0) {
                comparable2 = comparable;
            }
            i++;
            comparable = comparable2;
        }
        return (State) comparable;
    }

    private boolean m8256c() {
        return m8255b("android.permission.ACCESS_COARSE_LOCATION") || m8255b("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean m8255b(String str) {
        try {
            return this.f4548c.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable th) {
            return false;
        }
    }
}
