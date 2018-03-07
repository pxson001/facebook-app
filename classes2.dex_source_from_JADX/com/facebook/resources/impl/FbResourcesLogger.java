package com.facebook.resources.impl;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.resources.impl.StringResourcesDelegate.Source;
import com.facebook.resources.impl.loading.LanguageRequest;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_left_comment_reaction/ */
public class FbResourcesLogger {
    private static volatile FbResourcesLogger f1431d;
    private final Lazy<PerformanceLogger> f1432a;
    public final Lazy<AnalyticsLogger> f1433b;
    private boolean f1434c = false;

    public static com.facebook.resources.impl.FbResourcesLogger m2736a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1431d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.FbResourcesLogger.class;
        monitor-enter(r1);
        r0 = f1431d;	 Catch:{ all -> 0x003a }
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
        r0 = m2739b(r0);	 Catch:{ all -> 0x0035 }
        f1431d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1431d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.FbResourcesLogger.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.FbResourcesLogger");
    }

    private static FbResourcesLogger m2739b(InjectorLike injectorLike) {
        return new FbResourcesLogger(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2952), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175));
    }

    @Inject
    public FbResourcesLogger(Lazy<PerformanceLogger> lazy, Lazy<AnalyticsLogger> lazy2) {
        this.f1432a = lazy;
        this.f1433b = lazy2;
    }

    public final void m2742a() {
        m2737a(4456449, "FbResourcesLoadingAssetStrings");
    }

    public final void m2747b() {
        m2740b(4456449, "FbResourcesLoadingAssetStrings");
    }

    public final void m2750c() {
        m2741c(4456449, "FbResourcesLoadingAssetStrings");
    }

    public final void m2753d() {
        m2737a(4456450, "FbResourcesLoadingDownloadedStrings");
    }

    public final void m2755e() {
        m2740b(4456450, "FbResourcesLoadingDownloadedStrings");
    }

    public final void m2757f() {
        m2741c(4456450, "FbResourcesLoadingDownloadedStrings");
    }

    public final void m2758g() {
        m2737a(4456452, "FbResourcesWaitingActivity");
    }

    public final void m2759h() {
        m2740b(4456452, "FbResourcesWaitingActivity");
    }

    public final void m2760i() {
        m2741c(4456452, "FbResourcesWaitingActivity");
    }

    public final void m2761j() {
        m2737a(4456451, "FbResourcesDownloadFile");
    }

    public final void m2762k() {
        m2740b(4456451, "FbResourcesDownloadFile");
    }

    public final void m2763l() {
        m2741c(4456451, "FbResourcesDownloadFile");
    }

    public final void m2764m() {
        if (!this.f1434c) {
            ((AnalyticsLogger) this.f1433b.get()).mo526a(new HoneyClientEvent("fbresources_not_available"));
            this.f1434c = true;
        }
    }

    public final void m2745a(String str, int i) {
        ((AnalyticsLogger) this.f1433b.get()).mo526a(m2735a(str, i, "fbresources_prefetch_query_miss"));
    }

    public final void m2748b(String str, int i) {
        ((AnalyticsLogger) this.f1433b.get()).mo526a(m2735a(str, i, "fbresources_prefetch_query_failure"));
    }

    public final void m2751c(String str, int i) {
        ((AnalyticsLogger) this.f1433b.get()).mo526a(m2735a(str, i, "fbresources_prefetch_query_success"));
    }

    public final void m2756e(String str, int i) {
        ((AnalyticsLogger) this.f1433b.get()).mo526a(m2735a(str, i, "fbresources_prefetch_download_success"));
    }

    public final void m2744a(String str) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("fbresources_prefetch_download_failure");
        honeyClientEvent.m5090b("extra", str);
        ((AnalyticsLogger) this.f1433b.get()).mo526a(honeyClientEvent);
    }

    public final void m2743a(Source source, LanguageRequest languageRequest) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("fbresources_loading_success");
        honeyClientEvent.m5090b("source", source.getLoggingValue());
        honeyClientEvent.m5090b("locale", languageRequest.m4962d());
        ((AnalyticsLogger) this.f1433b.get()).mo526a(honeyClientEvent);
    }

    public final void m2746a(Map<String, String> map) {
        m2738a("too_many", (Map) map);
    }

    public final void m2749b(Map<String, String> map) {
        m2738a("json", (Map) map);
    }

    public final void m2752c(Map<String, String> map) {
        m2738a("invalid", (Map) map);
    }

    public final void m2754d(Map<String, String> map) {
        m2738a("empty", (Map) map);
    }

    private void m2738a(String str, Map<String, String> map) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("fbresources_bad_language_pack_info");
        honeyClientEvent.m5090b("type", str);
        honeyClientEvent.m5088a((Map) map);
        ((AnalyticsLogger) this.f1433b.get()).mo526a(honeyClientEvent);
    }

    public static HoneyClientEvent m2735a(String str, int i, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str2);
        honeyClientEvent.m5090b("locale", str);
        honeyClientEvent.m5083a("version_code", i);
        return honeyClientEvent;
    }

    private void m2737a(int i, String str) {
        ((PerformanceLogger) this.f1432a.get()).mo392d(i, str);
    }

    private void m2740b(int i, String str) {
        ((PerformanceLogger) this.f1432a.get()).mo389c(i, str);
    }

    private void m2741c(int i, String str) {
        ((PerformanceLogger) this.f1432a.get()).mo397f(i, str);
    }
}
