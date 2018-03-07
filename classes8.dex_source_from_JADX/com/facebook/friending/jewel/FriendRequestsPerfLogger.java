package com.facebook.friending.jewel;

import com.facebook.apptab.state.TabTag;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QPLVisitorForNetworkInfo;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: first_open_since_start */
public class FriendRequestsPerfLogger {
    public static final ImmutableMap<FriendingLocation, MarkerConfig> f13202a = ImmutableMap.of(FriendingLocation.JEWEL, new MarkerConfig(3080198, "FriendRequestsHarrisonTabSwitchTTI"), FriendingLocation.NUX, new MarkerConfig(3080199, "NuxAddFriendsStepTTI"));
    private static final Class<?> f13203b = FriendRequestsPerfLogger.class;
    private static volatile FriendRequestsPerfLogger f13204e;
    public final PerformanceLogger f13205c;
    private final QuickPerformanceLogger f13206d;

    public static com.facebook.friending.jewel.FriendRequestsPerfLogger m14864a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13204e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friending.jewel.FriendRequestsPerfLogger.class;
        monitor-enter(r1);
        r0 = f13204e;	 Catch:{ all -> 0x003a }
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
        r0 = m14865b(r0);	 Catch:{ all -> 0x0035 }
        f13204e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13204e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friending.jewel.FriendRequestsPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.friending.jewel.FriendRequestsPerfLogger");
    }

    private static FriendRequestsPerfLogger m14865b(InjectorLike injectorLike) {
        return new FriendRequestsPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), QPLVisitorForNetworkInfo.a(injectorLike));
    }

    @Inject
    public FriendRequestsPerfLogger(PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, QPLVisitorForNetworkInfo qPLVisitorForNetworkInfo) {
        this.f13205c = performanceLogger;
        this.f13206d = quickPerformanceLogger;
        qPLVisitorForNetworkInfo.a(3080198);
    }

    public final void m14866a(FriendingLocation friendingLocation) {
        MarkerConfig markerConfig = (MarkerConfig) f13202a.get(friendingLocation);
        if (markerConfig != null) {
            PerformanceLogger performanceLogger = this.f13205c;
            markerConfig = new MarkerConfig(markerConfig).a(new String[]{TabTag.FriendRequests.analyticsTag});
            markerConfig.n = true;
            performanceLogger.a(markerConfig, true);
        }
    }

    public final void m14867a(FriendingLocation friendingLocation, long j) {
        MarkerConfig markerConfig = (MarkerConfig) f13202a.get(friendingLocation);
        if (markerConfig != null) {
            this.f13205c.a(markerConfig.a, markerConfig.d, "query_time", Long.toString(j), false);
            this.f13205c.b(markerConfig);
        }
    }

    public final void m14868b(FriendingLocation friendingLocation) {
        MarkerConfig markerConfig = (MarkerConfig) f13202a.get(friendingLocation);
        if (markerConfig != null) {
            this.f13205c.a(markerConfig);
        }
    }
}
