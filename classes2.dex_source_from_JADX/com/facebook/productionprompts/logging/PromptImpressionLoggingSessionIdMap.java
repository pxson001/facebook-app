package com.facebook.productionprompts.logging;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import javax.inject.Singleton;

@Singleton
/* compiled from: models */
public class PromptImpressionLoggingSessionIdMap {
    private static volatile PromptImpressionLoggingSessionIdMap f13372b;
    private final Cache<String, String> f13373a = CacheBuilder.newBuilder().m1122a(10).m1148q();

    public static com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap m19701a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f13372b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap.class;
        monitor-enter(r1);
        r0 = f13372b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m19700a();	 Catch:{ all -> 0x0034 }
        f13372b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13372b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap");
    }

    private static PromptImpressionLoggingSessionIdMap m19700a() {
        return new PromptImpressionLoggingSessionIdMap();
    }

    public final void m19703a(String str, String str2) {
        this.f13373a.mo114a((Object) str, (Object) str2);
    }

    public final String m19702a(String str) {
        Object obj = (String) this.f13373a.mo110a((Object) str);
        if (obj == null) {
            obj = SafeUUIDGenerator.m2795a().toString();
            m19703a(str, obj);
        }
        return (String) Preconditions.checkNotNull(obj);
    }
}
