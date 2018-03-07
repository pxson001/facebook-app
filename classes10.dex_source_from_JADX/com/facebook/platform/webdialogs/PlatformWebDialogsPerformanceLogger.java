package com.facebook.platform.webdialogs;

import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.perflogging.PlatformPerformanceLogger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: locationPingToUser */
public class PlatformWebDialogsPerformanceLogger {
    private static volatile PlatformWebDialogsPerformanceLogger f8512d;
    public final SequenceLogger f8513a;
    public final PlatformWebDialogsLaunchSequenceDefinition f8514b;
    private final PlatformPerformanceLogger f8515c;

    public static com.facebook.platform.webdialogs.PlatformWebDialogsPerformanceLogger m8413a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8512d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.PlatformWebDialogsPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f8512d;	 Catch:{ all -> 0x003a }
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
        r0 = m8416b(r0);	 Catch:{ all -> 0x0035 }
        f8512d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8512d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.PlatformWebDialogsPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.PlatformWebDialogsPerformanceLogger");
    }

    private static PlatformWebDialogsPerformanceLogger m8416b(InjectorLike injectorLike) {
        return new PlatformWebDialogsPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), PlatformWebDialogsLaunchSequenceDefinition.m8411a(injectorLike), PlatformPerformanceLogger.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsPerformanceLogger(SequenceLogger sequenceLogger, PlatformWebDialogsLaunchSequenceDefinition platformWebDialogsLaunchSequenceDefinition, PlatformPerformanceLogger platformPerformanceLogger) {
        this.f8513a = sequenceLogger;
        this.f8514b = platformWebDialogsLaunchSequenceDefinition;
        this.f8515c = platformPerformanceLogger;
    }

    public final void m8419a(PlatformAppCall platformAppCall) {
        this.f8515c.a(this.f8514b);
        m8415a("PlatformWebDialogs_onCreateExecutor", ImmutableMap.of("call_id", platformAppCall.a, "action_name", platformAppCall.i));
    }

    public final void m8418a() {
        m8414a("PlatformWebDialogs_onCreateExecutor");
        m8415a("PlatformWebDialogs_startActivity", null);
    }

    public final void m8423b() {
        m8414a("PlatformWebDialogs_startActivity");
        m8415a("PlatformWebDialogs_addFragment", null);
    }

    public final void m8424c() {
        m8414a("PlatformWebDialogs_addFragment");
        m8415a("PlatformWebDialogs_Fragment_onCreate", null);
    }

    public final void m8425d() {
        m8414a("PlatformWebDialogs_Fragment_onCreate");
    }

    public final void m8426e() {
        m8415a("PlatformWebDialogs_Fragment_onCreateView", null);
    }

    public final void m8427f() {
        m8414a("PlatformWebDialogs_Fragment_onCreateView");
    }

    public final void m8428g() {
        m8415a("PlatformWebDialogs_Fragment_fetchManifest", null);
    }

    public final void m8422a(PlatformWebViewActionManifest platformWebViewActionManifest, boolean z, boolean z2) {
        Object obj = z2 ? "dialog_not_cached" : z ? "dialog_cached_not_loaded" : "dialog_loaded";
        m8417b("PlatformWebDialogs_Fragment_fetchManifest", ImmutableMap.of("action_name", platformWebViewActionManifest.a(), "dialog_version", platformWebViewActionManifest.b(), "dialog_cache_status", obj));
    }

    public final void m8421a(PlatformAppCall platformAppCall, boolean z) {
        String str = platformAppCall.i;
        m8417b("PlatformWebDialogs_Fragment_loadJSDialog", ImmutableBiMap.b("action_name", str));
        if (z) {
            m8415a("PlatformWebDialogs_Fragment_JSDialog_uiloading", ImmutableBiMap.b("action_name", str));
        } else {
            this.f8513a.b(this.f8514b);
        }
    }

    public final void m8420a(PlatformAppCall platformAppCall, PlatformWebViewActionManifest platformWebViewActionManifest) {
        m8415a("PlatformWebDialogs_Fragment_setupWebView", ImmutableMap.of("call_id", platformAppCall.a, "action_name", platformAppCall.i, "dialog_version", platformWebViewActionManifest.b()));
    }

    public final void m8429h() {
        m8414a("PlatformWebDialogs_Fragment_setupWebView");
        m8415a("PlatformWebDialogs_Fragment_loadJSDialog", null);
    }

    public final void m8430i() {
        m8415a("PlatformWebDialogs_setCookies", null);
    }

    public final void m8431j() {
        m8414a("PlatformWebDialogs_setCookies");
    }

    public final void m8432k() {
        m8414a("PlatformWebDialogs_Fragment_JSDialog_uiloading");
        this.f8513a.b(this.f8514b);
    }

    public final void m8433l() {
        this.f8513a.c(this.f8514b);
    }

    private void m8415a(String str, ImmutableMap<String, String> immutableMap) {
        Sequence e = this.f8513a.e(this.f8514b);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, null, immutableMap, 969747827);
        }
    }

    private void m8414a(String str) {
        m8417b(str, null);
    }

    private void m8417b(String str, ImmutableMap<String, String> immutableMap) {
        Sequence e = this.f8513a.e(this.f8514b);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, null, immutableMap, -1676999693);
        }
    }
}
