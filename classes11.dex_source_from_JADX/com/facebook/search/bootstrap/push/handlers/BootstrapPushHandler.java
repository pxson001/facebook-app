package com.facebook.search.bootstrap.push.handlers;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: outputCLosed */
public class BootstrapPushHandler extends BaseFbPushDataHandler {
    private static volatile BootstrapPushHandler f4562d;
    public final BootstrapEntitiesLoader f4563b;
    public final BootstrapKeywordsLoader f4564c;

    public static com.facebook.search.bootstrap.push.handlers.BootstrapPushHandler m5822a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4562d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.push.handlers.BootstrapPushHandler.class;
        monitor-enter(r1);
        r0 = f4562d;	 Catch:{ all -> 0x003a }
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
        r0 = m5823b(r0);	 Catch:{ all -> 0x0035 }
        f4562d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4562d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.push.handlers.BootstrapPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.push.handlers.BootstrapPushHandler");
    }

    private static BootstrapPushHandler m5823b(InjectorLike injectorLike) {
        return new BootstrapPushHandler(ReliabilityAnalyticsLogger.a(injectorLike), BootstrapEntitiesLoader.a(injectorLike), BootstrapKeywordsLoader.a(injectorLike));
    }

    @Inject
    public BootstrapPushHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, BootstrapEntitiesLoader bootstrapEntitiesLoader, BootstrapKeywordsLoader bootstrapKeywordsLoader) {
        super(reliabilityAnalyticsLogger);
        this.f4563b = bootstrapEntitiesLoader;
        this.f4564c = bootstrapKeywordsLoader;
    }

    public final void m5824b(JsonNode jsonNode, PushProperty pushProperty) {
        if ("bootstrap_updated".equals(JSONUtil.b(jsonNode.b("type")))) {
            this.f4563b.b();
            BootstrapKeywordsLoader.a(this.f4564c, 0);
        }
    }
}
