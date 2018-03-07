package com.facebook.pages.common.bannedusers.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: message_sender_context */
public class PagesBanUserAnalytics {
    private static volatile PagesBanUserAnalytics f9085d;
    public final AnalyticsLogger f9086a;
    private final Product f9087b;
    private final Lazy<FbErrorReporter> f9088c;

    public static com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics m10907a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9085d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics.class;
        monitor-enter(r1);
        r0 = f9085d;	 Catch:{ all -> 0x003a }
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
        r0 = m10908b(r0);	 Catch:{ all -> 0x0035 }
        f9085d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9085d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics");
    }

    private static PagesBanUserAnalytics m10908b(InjectorLike injectorLike) {
        return new PagesBanUserAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public PagesBanUserAnalytics(AnalyticsLogger analyticsLogger, Product product, Lazy<FbErrorReporter> lazy) {
        this.f9086a = analyticsLogger;
        this.f9087b = product;
        this.f9088c = lazy;
    }

    public static HoneyClientEvent m10906a(AdminBanUserEvent adminBanUserEvent, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(adminBanUserEvent.getName());
        honeyClientEvent.c = "pages_public_view";
        return honeyClientEvent.a("page_id", j);
    }

    public final void m10909a(String str, PagesBanUserReferrer pagesBanUserReferrer) {
        if (Strings.isNullOrEmpty(str)) {
            ((AbstractFbErrorReporter) this.f9088c.get()).b("PagesBanUserAnalytics", "Fail to log banning user actions in reactors list: page id is null.");
        } else if (this.f9087b == Product.PAA) {
            this.f9086a.a(m10906a(AdminBanUserEvent.PMA_BAN_USER_ACTIONS, Long.parseLong(str)).b("referrer", pagesBanUserReferrer.getName()));
        } else if (this.f9087b == Product.FB4A) {
            this.f9086a.a(m10906a(AdminBanUserEvent.FB4A_BAN_USER_ACTIONS, Long.parseLong(str)).b("referrer", pagesBanUserReferrer.getName()));
        } else {
            ((AbstractFbErrorReporter) this.f9088c.get()).b("PagesBanUserAnalytics", "Fail to log banning user actions in reactors list: not in PMA or FB4A.");
        }
    }
}
