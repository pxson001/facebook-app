package com.facebook.common.errorreporting;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.net.Proxy;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: start_timestamp */
public class StubFbErrorReporter extends AbstractFbErrorReporter {
    private static volatile StubFbErrorReporter f2542b;
    private final Provider<TriState> f2543a;

    public static com.facebook.common.errorreporting.StubFbErrorReporter m3648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2542b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.StubFbErrorReporter.class;
        monitor-enter(r1);
        r0 = f2542b;	 Catch:{ all -> 0x003a }
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
        r0 = m3653b(r0);	 Catch:{ all -> 0x0035 }
        f2542b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2542b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.StubFbErrorReporter.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.StubFbErrorReporter");
    }

    private static StubFbErrorReporter m3653b(InjectorLike injectorLike) {
        return new StubFbErrorReporter(IdBasedProvider.a(injectorLike, 640));
    }

    @Inject
    public StubFbErrorReporter(Provider<TriState> provider) {
        this.f2543a = provider;
    }

    public final void m3659a(String str, String str2, String str3) {
        m3650a("STRICT_MODE", str, str2, str3);
    }

    private void m3654b(String str, String str2, Map<String, String> map) {
        m3652a("RUNTIME_LINTER", str, str2, (Map) map);
    }

    public final void m3660a(String str, String str2, Map<String, String> map) {
        m3654b(str, str2, map);
    }

    public final void m3656a(SoftError softError) {
        String str = softError.a;
        String str2 = softError.b;
        Throwable th = softError.c;
        if (softError.d && this.f2543a.get() == TriState.YES) {
            throw new RuntimeException("Soft Error FAILING HARDER: " + str + "\nMessage:" + str2, th);
        }
        m3651a("SOFT_ERROR", str, str2, th, new Throwable());
    }

    public final void m3661a(Proxy proxy) {
    }

    public final void m3665c(String str, String str2) {
    }

    public final void m3657a(String str) {
    }

    public final void m3658a(String str, FbCustomReportDataSupplier fbCustomReportDataSupplier) {
    }

    public final void m3663b(String str) {
    }

    public final void m3664c(String str) {
    }

    public final void m3666d(String str) {
    }

    public final void m3655a() {
    }

    public final void m3662b() {
    }

    private void m3651a(String str, String str2, String str3, Throwable th, Throwable th2) {
        m3649a(str, str2, str3, (Object) th, (Object) th2);
    }

    private void m3650a(String str, String str2, String str3, String str4) {
        m3649a(str, str2, str3, (Object) str4, null);
    }

    private void m3652a(String str, String str2, String str3, Map<String, String> map) {
        m3649a(str, str2, str3, map.get("stackTrace"), null);
    }

    private void m3649a(String str, String str2, String str3, Object obj, Object obj2) {
        final String str4 = str2;
        final String str5 = str3;
        final Object obj3 = obj;
        final Object obj4 = obj2;
        final String str6 = str;
        ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ StubFbErrorReporter f2541f;

            public void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("Category: %s\nMessage: %s", str4, str5));
                    if (obj3 != null) {
                        stringBuilder.append("\nCaused By: ").append(obj3);
                    }
                    if (obj4 != null) {
                        BLog.a(str6, stringBuilder.toString(), new Object[]{obj4});
                        return;
                    }
                    BLog.a(str6, stringBuilder.toString());
                } catch (Throwable th) {
                }
            }
        }, 2128369983).start();
    }
}
