package com.facebook.feed.loader;

import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: wear_app_reachable */
public class OnlineFeedGapConditionCheck {
    private static volatile OnlineFeedGapConditionCheck f166d;
    public final FbNetworkManager f167a;
    public final AsyncFeedXConfigReader f168b;
    private final QeAccessor f169c;

    public static com.facebook.feed.loader.OnlineFeedGapConditionCheck m196a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f166d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.loader.OnlineFeedGapConditionCheck.class;
        monitor-enter(r1);
        r0 = f166d;	 Catch:{ all -> 0x003a }
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
        r0 = m197b(r0);	 Catch:{ all -> 0x0035 }
        f166d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f166d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.loader.OnlineFeedGapConditionCheck.a(com.facebook.inject.InjectorLike):com.facebook.feed.loader.OnlineFeedGapConditionCheck");
    }

    private static OnlineFeedGapConditionCheck m197b(InjectorLike injectorLike) {
        return new OnlineFeedGapConditionCheck(FbNetworkManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike));
    }

    @Inject
    public OnlineFeedGapConditionCheck(FbNetworkManager fbNetworkManager, QeAccessor qeAccessor, AsyncFeedXConfigReader asyncFeedXConfigReader) {
        this.f167a = fbNetworkManager;
        this.f169c = qeAccessor;
        this.f168b = asyncFeedXConfigReader;
    }

    public static boolean m198b() {
        return true;
    }

    public final boolean m199d() {
        return this.f168b.a(false);
    }
}
