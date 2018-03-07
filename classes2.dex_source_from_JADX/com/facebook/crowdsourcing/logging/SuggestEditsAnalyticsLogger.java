package com.facebook.crowdsourcing.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_attempts */
public class SuggestEditsAnalyticsLogger {
    private static volatile SuggestEditsAnalyticsLogger f14943c;
    private final AnalyticsLogger f14944a;
    private final CrowdsourcingSession f14945b;

    public static com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger m21377a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14943c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f14943c;	 Catch:{ all -> 0x003a }
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
        r0 = m21378b(r0);	 Catch:{ all -> 0x0035 }
        f14943c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14943c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger");
    }

    private static SuggestEditsAnalyticsLogger m21378b(InjectorLike injectorLike) {
        return new SuggestEditsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), CrowdsourcingSession.m21386a(injectorLike));
    }

    @Inject
    public SuggestEditsAnalyticsLogger(AnalyticsLogger analyticsLogger, CrowdsourcingSession crowdsourcingSession) {
        this.f14944a = analyticsLogger;
        this.f14945b = crowdsourcingSession;
    }

    public final void m21380a(CrowdEntryPoint crowdEntryPoint, Optional<String> optional) {
        this.f14944a.mo526a(m21376a(crowdEntryPoint, "entry_point_impression", (Optional) optional));
    }

    public final void m21381a(CrowdsourcingContext crowdsourcingContext, String str) {
        m21379b(crowdsourcingContext, "endpoint_impression", str);
    }

    public final void m21383b(CrowdsourcingContext crowdsourcingContext, String str) {
        m21379b(crowdsourcingContext, "render_complete", str);
    }

    public final void m21384c(CrowdsourcingContext crowdsourcingContext, String str) {
        m21379b(crowdsourcingContext, "suggestion_edited", str);
    }

    public final void m21385d(CrowdsourcingContext crowdsourcingContext, String str) {
        m21379b(crowdsourcingContext, "session_ended", str);
    }

    public final void m21382a(CrowdsourcingContext crowdsourcingContext, String str, String str2) {
        HoneyAnalyticsEvent a = m21376a(crowdsourcingContext.a, "expanded_question_impression", Optional.of(str));
        a.m5085a("endpoint", new TextNode(crowdsourcingContext.b.getFullName()));
        a.m5090b("question_id", str2);
        this.f14944a.mo526a(a);
    }

    private void m21379b(CrowdsourcingContext crowdsourcingContext, String str, String str2) {
        HoneyAnalyticsEvent a = m21376a(crowdsourcingContext.a, str, Optional.of(str2));
        a.m5085a("endpoint", new TextNode(crowdsourcingContext.b.getFullName()));
        this.f14944a.mo526a(a);
    }

    private HoneyClientEvent m21376a(CrowdEntryPoint crowdEntryPoint, String str, Optional<String> optional) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("crowdsourcing_session_" + str);
        honeyClientEvent.f3099c = "crowdsourcing_edit";
        return honeyClientEvent.m5090b("entry_point", crowdEntryPoint.getFullName()).m5090b("page_id", (String) optional.orNull()).m5084a("session_id", this.f14945b.m21388a());
    }
}
