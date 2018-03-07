package com.facebook.goodfriends.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image/x-best */
public class GoodFriendsFeedPrivacyRenderingQEStore {
    private static volatile GoodFriendsFeedPrivacyRenderingQEStore f20491d;
    public final QeAccessor f20492a;
    private Integer f20493b = null;
    private Integer f20494c = null;

    public static com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore m28232a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20491d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore.class;
        monitor-enter(r1);
        r0 = f20491d;	 Catch:{ all -> 0x003a }
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
        r0 = m28233b(r0);	 Catch:{ all -> 0x0035 }
        f20491d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20491d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore.a(com.facebook.inject.InjectorLike):com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore");
    }

    private static GoodFriendsFeedPrivacyRenderingQEStore m28233b(InjectorLike injectorLike) {
        return new GoodFriendsFeedPrivacyRenderingQEStore(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public GoodFriendsFeedPrivacyRenderingQEStore(QeAccessor qeAccessor) {
        this.f20492a = qeAccessor;
    }

    public final boolean m28234a() {
        return this.f20492a.mo596a(ExperimentsForGoodFriendsAbtestModule.f8971a, false);
    }

    public final boolean m28235c() {
        return this.f20492a.mo596a(ExperimentsForGoodFriendsAbtestModule.f8974d, false);
    }

    public final boolean m28236d() {
        return this.f20492a.mo596a(ExperimentsForGoodFriendsAbtestModule.f8973c, false);
    }

    public final int m28237e() {
        if (this.f20493b == null) {
            this.f20493b = Integer.valueOf(FeedPrivacyRenderingQEStore.m28223a(this.f20492a.mo581a(ExperimentsForGoodFriendsAbtestModule.f8976f, ""), -7235677));
        }
        return this.f20493b.intValue();
    }

    public final int m28238f() {
        if (this.f20494c == null) {
            this.f20494c = Integer.valueOf(FeedPrivacyRenderingQEStore.m28223a(this.f20492a.mo581a(ExperimentsForGoodFriendsAbtestModule.f8975e, ""), -1447187));
        }
        return this.f20494c.intValue();
    }
}
