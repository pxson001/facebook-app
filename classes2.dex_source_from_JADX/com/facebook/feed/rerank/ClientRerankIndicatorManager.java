package com.facebook.feed.rerank;

import com.facebook.common.util.StringUtil;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: http */
public class ClientRerankIndicatorManager {
    private static volatile ClientRerankIndicatorManager f20800c;
    private final FbSharedPreferences f20801a;
    private final QeAccessor f20802b;

    public static com.facebook.feed.rerank.ClientRerankIndicatorManager m28518a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20800c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rerank.ClientRerankIndicatorManager.class;
        monitor-enter(r1);
        r0 = f20800c;	 Catch:{ all -> 0x003a }
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
        r0 = m28520b(r0);	 Catch:{ all -> 0x0035 }
        f20800c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20800c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rerank.ClientRerankIndicatorManager.a(com.facebook.inject.InjectorLike):com.facebook.feed.rerank.ClientRerankIndicatorManager");
    }

    private static ClientRerankIndicatorManager m28520b(InjectorLike injectorLike) {
        return new ClientRerankIndicatorManager(FbSharedPreferencesImpl.m1826a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ClientRerankIndicatorManager(FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor) {
        this.f20801a = fbSharedPreferences;
        this.f20802b = qeAccessor;
    }

    public final boolean m28525a() {
        return this.f20801a.mo286a(FeedPrefKeys.f5760x, false);
    }

    public static boolean m28519a(String str) {
        return StringUtil.m3590a(str, "1");
    }

    public static boolean m28521b(String str) {
        return StringUtil.m3590a(str, "-1");
    }

    public static boolean m28522c(String str) {
        return StringUtil.m3590a(str, "0");
    }

    public static boolean m28523d(String str) {
        return StringUtil.m3590a(str, "1");
    }

    public static boolean m28524e(String str) {
        return StringUtil.m3590a(str, "0");
    }

    public final boolean m28526b() {
        return this.f20802b.mo596a(ExperimentsForNewsFeedAbTestModule.f5083J, false);
    }
}
