package com.facebook.push.mqtt.service;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.AppInfo;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: slider= */
public class ServicePublishTargetResolver {
    private static final String f4316a = ServicePublishTargetResolver.class.getSimpleName();
    private static volatile ServicePublishTargetResolver f4317h;
    private final PackageManager f4318b;
    private final Map<String, PackageInfo> f4319c = Maps.c();
    private final Map<String, Set<Signature>> f4320d = Maps.c();
    private long f4321e;
    private final MonotonicClock f4322f;
    private final AppInfo f4323g;

    public static com.facebook.push.mqtt.service.ServicePublishTargetResolver m6411a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4317h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.ServicePublishTargetResolver.class;
        monitor-enter(r1);
        r0 = f4317h;	 Catch:{ all -> 0x003a }
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
        r0 = m6412b(r0);	 Catch:{ all -> 0x0035 }
        f4317h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4317h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.ServicePublishTargetResolver.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.ServicePublishTargetResolver");
    }

    private static ServicePublishTargetResolver m6412b(InjectorLike injectorLike) {
        return new ServicePublishTargetResolver(PackageManagerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AppInfo.a(injectorLike));
    }

    @Inject
    public ServicePublishTargetResolver(PackageManager packageManager, MonotonicClock monotonicClock, AppInfo appInfo) {
        this.f4318b = packageManager;
        this.f4322f = monotonicClock;
        this.f4321e = monotonicClock.now();
        this.f4323g = appInfo;
    }
}
