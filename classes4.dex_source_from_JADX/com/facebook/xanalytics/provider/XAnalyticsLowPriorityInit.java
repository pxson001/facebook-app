package com.facebook.xanalytics.provider;

import com.facebook.common.init.INeedInit;
import com.facebook.config.server.PlatformAppHttpConfigMethodAutoProvider;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.tigon.Tigon4aHttpServiceHolder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lastname */
public class XAnalyticsLowPriorityInit implements INeedInit {
    private static volatile XAnalyticsLowPriorityInit f9510d;
    private final PlatformAppHttpConfig f9511a;
    private final Tigon4aHttpServiceHolder f9512b;
    private final DefaultXAnalyticsProvider f9513c;

    public static com.facebook.xanalytics.provider.XAnalyticsLowPriorityInit m9878a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9510d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.xanalytics.provider.XAnalyticsLowPriorityInit.class;
        monitor-enter(r1);
        r0 = f9510d;	 Catch:{ all -> 0x003a }
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
        r0 = m9879b(r0);	 Catch:{ all -> 0x0035 }
        f9510d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9510d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.xanalytics.provider.XAnalyticsLowPriorityInit.a(com.facebook.inject.InjectorLike):com.facebook.xanalytics.provider.XAnalyticsLowPriorityInit");
    }

    private static XAnalyticsLowPriorityInit m9879b(InjectorLike injectorLike) {
        return new XAnalyticsLowPriorityInit(PlatformAppHttpConfigMethodAutoProvider.b(injectorLike), Tigon4aHttpServiceHolder.m9881b(injectorLike), DefaultXAnalyticsProvider.a(injectorLike));
    }

    @Inject
    public XAnalyticsLowPriorityInit(PlatformAppHttpConfig platformAppHttpConfig, Tigon4aHttpServiceHolder tigon4aHttpServiceHolder, DefaultXAnalyticsProvider defaultXAnalyticsProvider) {
        this.f9511a = platformAppHttpConfig;
        this.f9512b = tigon4aHttpServiceHolder;
        this.f9513c = defaultXAnalyticsProvider;
    }

    public void init() {
        this.f9513c.c.updateTigonInstance(null, this.f9511a.b().build().getHost(), this.f9512b);
    }
}
