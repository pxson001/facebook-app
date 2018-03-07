package com.facebook.ipc.pages;

import android.content.ContentResolver;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_report_claimed_open */
public class PagesManagerLoggedInUserUtils extends BaseAppUserStatusUtils {
    private static volatile PagesManagerLoggedInUserUtils f6186b;

    public static com.facebook.ipc.pages.PagesManagerLoggedInUserUtils m8058a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6186b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ipc.pages.PagesManagerLoggedInUserUtils.class;
        monitor-enter(r1);
        r0 = f6186b;	 Catch:{ all -> 0x003a }
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
        r0 = m8059b(r0);	 Catch:{ all -> 0x0035 }
        f6186b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6186b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ipc.pages.PagesManagerLoggedInUserUtils.a(com.facebook.inject.InjectorLike):com.facebook.ipc.pages.PagesManagerLoggedInUserUtils");
    }

    private static PagesManagerLoggedInUserUtils m8059b(InjectorLike injectorLike) {
        return new PagesManagerLoggedInUserUtils(ContentResolverMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    protected final String m8060a() {
        return "content://com.facebook.pages.app.provider.PagesManagerLoggedInUserProvider/logged_in_user";
    }

    @Inject
    public PagesManagerLoggedInUserUtils(ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter, MonotonicClock monotonicClock) {
        super(contentResolver, abstractFbErrorReporter, monotonicClock);
    }
}
