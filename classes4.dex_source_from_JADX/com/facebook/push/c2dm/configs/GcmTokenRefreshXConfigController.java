package com.facebook.push.c2dm.configs;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inForegroundDevice */
public class GcmTokenRefreshXConfigController {
    private static final Class<?> f10426a = GcmTokenRefreshXConfigController.class;
    private static volatile GcmTokenRefreshXConfigController f10427d;
    private final XConfigReader f10428b;
    private final ObjectMapper f10429c;

    public static com.facebook.push.c2dm.configs.GcmTokenRefreshXConfigController m10966a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10427d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.c2dm.configs.GcmTokenRefreshXConfigController.class;
        monitor-enter(r1);
        r0 = f10427d;	 Catch:{ all -> 0x003a }
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
        r0 = m10967b(r0);	 Catch:{ all -> 0x0035 }
        f10427d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10427d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.c2dm.configs.GcmTokenRefreshXConfigController.a(com.facebook.inject.InjectorLike):com.facebook.push.c2dm.configs.GcmTokenRefreshXConfigController");
    }

    private static GcmTokenRefreshXConfigController m10967b(InjectorLike injectorLike) {
        return new GcmTokenRefreshXConfigController(XConfigReader.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GcmTokenRefreshXConfigController(XConfigReader xConfigReader, ObjectMapper objectMapper) {
        this.f10428b = xConfigReader;
        this.f10429c = objectMapper;
    }

    public final GcmTokenRefreshParameters m10968a(String str) {
        Map map;
        long longValue;
        GcmTokenRefreshConfig gcmTokenRefreshConfig = new GcmTokenRefreshConfig(this.f10428b);
        Long.valueOf(gcmTokenRefreshConfig.b);
        Long.valueOf(gcmTokenRefreshConfig.a);
        long j = gcmTokenRefreshConfig.a;
        long j2 = gcmTokenRefreshConfig.b;
        if (!StringUtil.a(gcmTokenRefreshConfig.c)) {
            try {
                map = (Map) this.f10429c.a(gcmTokenRefreshConfig.c, new 1(this));
                if (map.containsKey(str)) {
                    longValue = ((Long) map.get(str)).longValue();
                } else {
                    longValue = j;
                }
                j = longValue;
            } catch (Throwable th) {
                BLog.a(f10426a, "", th);
            }
        }
        if (!StringUtil.a(gcmTokenRefreshConfig.d)) {
            try {
                map = (Map) this.f10429c.a(gcmTokenRefreshConfig.d, new 2(this));
                if (map.containsKey(str)) {
                    longValue = ((Long) map.get(str)).longValue();
                } else {
                    longValue = j2;
                }
                j2 = longValue;
            } catch (Throwable th2) {
                BLog.a(f10426a, "", th2);
            }
        }
        Long.valueOf(j);
        Long.valueOf(j2);
        return new GcmTokenRefreshParameters(j, j2);
    }
}
