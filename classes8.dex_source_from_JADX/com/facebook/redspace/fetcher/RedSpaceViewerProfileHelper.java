package com.facebook.redspace.fetcher;

import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Singleton;

@Singleton
/* compiled from: USER_PRESSED_BACK */
public class RedSpaceViewerProfileHelper {
    private static volatile RedSpaceViewerProfileHelper f21330b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LoggedInUserAuthDataStore> f21331a = UltralightRuntime.b;

    public static com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper m24951a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21330b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper.class;
        monitor-enter(r1);
        r0 = f21330b;	 Catch:{ all -> 0x003a }
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
        r0 = m24953b(r0);	 Catch:{ all -> 0x0035 }
        f21330b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21330b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper.a(com.facebook.inject.InjectorLike):com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper");
    }

    private static RedSpaceViewerProfileHelper m24953b(InjectorLike injectorLike) {
        RedSpaceViewerProfileHelper redSpaceViewerProfileHelper = new RedSpaceViewerProfileHelper();
        redSpaceViewerProfileHelper.f21331a = IdBasedSingletonScopeProvider.b(injectorLike, 339);
        return redSpaceViewerProfileHelper;
    }

    public static boolean m24952a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        return (redSpaceFeedProfileFragmentModel.m() == null || "no_context_token".equals(redSpaceFeedProfileFragmentModel.m().k())) ? false : true;
    }
}
