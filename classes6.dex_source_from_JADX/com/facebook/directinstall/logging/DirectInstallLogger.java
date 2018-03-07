package com.facebook.directinstall.logging;

import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: old_api_exo_deprecated */
public class DirectInstallLogger {
    public static final String f8813a = DirectInstallLogger.class.getSimpleName();
    private static volatile DirectInstallLogger f8814d;
    private AnalyticsLogger f8815b;
    public AbstractFbErrorReporter f8816c;

    public static com.facebook.directinstall.logging.DirectInstallLogger m12558a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8814d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.directinstall.logging.DirectInstallLogger.class;
        monitor-enter(r1);
        r0 = f8814d;	 Catch:{ all -> 0x003a }
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
        r0 = m12559b(r0);	 Catch:{ all -> 0x0035 }
        f8814d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8814d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.directinstall.logging.DirectInstallLogger.a(com.facebook.inject.InjectorLike):com.facebook.directinstall.logging.DirectInstallLogger");
    }

    private static DirectInstallLogger m12559b(InjectorLike injectorLike) {
        return new DirectInstallLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DirectInstallLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8815b = analyticsLogger;
        this.f8816c = abstractFbErrorReporter;
    }

    public final void m12561a(String str, @Nullable NativeAppDetails nativeAppDetails, @Nullable ImmutableMap<String, Object> immutableMap) {
        Builder builder = new Builder();
        if (immutableMap != null) {
            builder.a(immutableMap);
        }
        builder.b("qe_experience_type", str);
        m12562b("neko_di_entering_qe_experience", nativeAppDetails, builder.b());
    }

    public final void m12562b(String str, @Nullable NativeAppDetails nativeAppDetails, @Nullable ImmutableMap<String, ?> immutableMap) {
        HoneyClientEventFast a = this.f8815b.a(str, false);
        if (a.a()) {
            if (nativeAppDetails != null) {
                a.a("progress", nativeAppDetails.n.toString());
                a.a("story_cache_id", nativeAppDetails.i);
                a.a("package_name", nativeAppDetails.e);
                a.a(nativeAppDetails.s);
                if (!TextUtils.isEmpty(nativeAppDetails.l)) {
                    a.c(nativeAppDetails.l);
                }
            }
            if (immutableMap != null) {
                a.a(immutableMap);
            }
            a.b();
        }
    }

    public final void m12560a(NativeAppDetails nativeAppDetails, String str) {
        Builder builder = new Builder();
        builder.b("route_to_google_reason", str);
        m12562b("neko_di_install_routed_to_google_play", nativeAppDetails, builder.b());
    }
}
