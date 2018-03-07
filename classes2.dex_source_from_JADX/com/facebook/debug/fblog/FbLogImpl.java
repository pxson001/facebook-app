package com.facebook.debug.fblog;

import android.util.Log;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.logging.LoggingDelegate;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessName;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_channel_is_viewer_pinned */
public class FbLogImpl implements LoggingDelegate {
    private static volatile FbLogImpl f1234e;
    private final String f1235a;
    private final AbstractFbErrorReporter f1236b;
    private final ProcessName f1237c;
    private int f1238d;

    public static com.facebook.debug.fblog.FbLogImpl m2373a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1234e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.fblog.FbLogImpl.class;
        monitor-enter(r1);
        r0 = f1234e;	 Catch:{ all -> 0x003a }
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
        r0 = m2375b(r0);	 Catch:{ all -> 0x0035 }
        f1234e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1234e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.fblog.FbLogImpl.a(com.facebook.inject.InjectorLike):com.facebook.debug.fblog.FbLogImpl");
    }

    private static FbLogImpl m2375b(InjectorLike injectorLike) {
        return new FbLogImpl("fb4a", FbErrorReporterImpl.m2317a(injectorLike), DefaultProcessUtil.m2387a(injectorLike));
    }

    @Inject
    public FbLogImpl(String str, AbstractFbErrorReporter abstractFbErrorReporter, DefaultProcessUtil defaultProcessUtil) {
        this.f1235a = str;
        this.f1236b = abstractFbErrorReporter;
        this.f1237c = defaultProcessUtil.m2389a();
    }

    public final void m2377a(int i) {
        this.f1238d = i;
    }

    public final int m2381b() {
        return this.f1238d;
    }

    public final boolean m2384b(int i) {
        return this.f1238d <= i;
    }

    public final void m2379a(String str, String str2) {
        m2378a(5, str, str2);
    }

    public final void m2380a(String str, String str2, Throwable th) {
        m2378a(5, str, str2 + '\n' + ExceptionUtil.a(th));
    }

    public final void m2382b(String str, String str2) {
        m2378a(6, str, str2);
    }

    public final void m2383b(String str, String str2, Throwable th) {
        m2378a(6, str, str2 + '\n' + ExceptionUtil.a(th));
    }

    public final void m2385c(String str, String str2) {
        m2376d(str, str2, null);
        m2378a(6, str, str2);
    }

    public final void m2386c(String str, String str2, Throwable th) {
        m2376d(str, str2, th);
        m2378a(6, str, str2 + '\n' + ExceptionUtil.a(th));
    }

    public final void m2378a(int i, String str, String str2) {
        Log.println(i, m2374a(str), str2);
    }

    private void m2376d(String str, String str2, Throwable th) {
        TerribleFailure terribleFailure = new TerribleFailure(str + ": " + str2, th);
        AbstractFbErrorReporter abstractFbErrorReporter = this.f1236b;
        SoftErrorBuilder a = SoftError.a(str, str2);
        a.c = terribleFailure;
        abstractFbErrorReporter.mo336a(a.g());
    }

    private String m2374a(String str) {
        if (this.f1235a == null) {
            return str;
        }
        if (this.f1237c != null) {
            return this.f1235a + "(:" + this.f1237c.f() + "):" + str;
        }
        return this.f1235a + ":" + str;
    }
}
