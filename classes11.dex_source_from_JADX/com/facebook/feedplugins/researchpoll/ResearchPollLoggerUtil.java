package com.facebook.feedplugins.researchpoll;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.SubmitResearchPollResponseParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: calendar_id=? */
public class ResearchPollLoggerUtil {
    private static volatile ResearchPollLoggerUtil f9066d;
    public final DefaultBlueServiceOperationFactory f9067a;
    public final CallerContext f9068b = CallerContext.a(ResearchPollLoggerUtil.class);
    private final AnalyticsLogger f9069c;

    public static com.facebook.feedplugins.researchpoll.ResearchPollLoggerUtil m9760a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9066d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.researchpoll.ResearchPollLoggerUtil.class;
        monitor-enter(r1);
        r0 = f9066d;	 Catch:{ all -> 0x003a }
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
        r0 = m9761b(r0);	 Catch:{ all -> 0x0035 }
        f9066d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9066d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.researchpoll.ResearchPollLoggerUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.researchpoll.ResearchPollLoggerUtil");
    }

    private static ResearchPollLoggerUtil m9761b(InjectorLike injectorLike) {
        return new ResearchPollLoggerUtil(DefaultBlueServiceOperationFactory.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ResearchPollLoggerUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AnalyticsLogger analyticsLogger) {
        this.f9067a = defaultBlueServiceOperationFactory;
        this.f9069c = analyticsLogger;
    }

    public final void m9762a(String str, String str2) {
        this.f9069c.a(new HoneyClientEvent("research_poll_interaction").b("interaction_type", str2).a("survey_id", Long.parseLong(str)));
    }

    public final void m9764a(boolean z, int i, String str, String str2, String str3) {
        this.f9069c.c(new HoneyClientEvent("research_poll_interaction").b("interaction_type", z ? "select_response" : "deselect_response").a("response_id", Long.parseLong(str2)).a("answer_index", i).a("question_id", Long.parseLong(str)).a("survey_id", Long.parseLong(str3)));
    }

    public final void m9763a(String str, String str2, List<String> list, String str3) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("submitResearchPollResponseParamsKey", new SubmitResearchPollResponseParams(str, str3, Boolean.valueOf(false), str2, list));
        BlueServiceOperationFactoryDetour.a(this.f9067a, "feed_submit_research_poll_response", bundle, ErrorPropagation.BY_EXCEPTION, this.f9068b, -1429440373).a(true).a();
    }
}
