package com.facebook.translation;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.model.GraphQLPostTranslatability;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTranslationMetaData;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.InjectorLike;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_source */
public class TranslationRatingLogger {
    private static volatile TranslationRatingLogger f24368b;
    private final AnalyticsLogger f24369a;

    public static com.facebook.translation.TranslationRatingLogger m32680a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24368b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.translation.TranslationRatingLogger.class;
        monitor-enter(r1);
        r0 = f24368b;	 Catch:{ all -> 0x003a }
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
        r0 = m32681b(r0);	 Catch:{ all -> 0x0035 }
        f24368b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24368b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.translation.TranslationRatingLogger.a(com.facebook.inject.InjectorLike):com.facebook.translation.TranslationRatingLogger");
    }

    private static TranslationRatingLogger m32681b(InjectorLike injectorLike) {
        return new TranslationRatingLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public TranslationRatingLogger(AnalyticsLogger analyticsLogger) {
        this.f24369a = analyticsLogger;
    }

    public final void m32682a(GraphQLStory graphQLStory, int i, String str) {
        if (graphQLStory != null) {
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("ltg_translation_user_feedback_mobile");
            honeyClientEvent.f3099c = "translation";
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.m5090b("fbid", graphQLStory.m22350c()).m5090b("input_text", StoryTextHelper.m31226a(graphQLStory)).m5090b("translated_text", str).m5090b("viewer_id", "").m5083a("user_rating", i).m5090b("author_id", "");
            GraphQLPostTranslatability aL = graphQLStory.aL();
            if (aL != null) {
                honeyClientEvent.m5090b("translation_trigger", aL.m24912o().toString().toLowerCase(Locale.US)).m5090b("content_locale", aL.m24907j()).m5090b("target_locale", aL.m24909l());
                if (aL.m24911n() != null) {
                    honeyClientEvent.m5090b("translation_id", aL.m24911n().m24917j()).m5083a("original_translation_confidence", aL.m24911n().m24913a());
                }
            }
            GraphQLTranslationMetaData aN = graphQLStory.aN();
            if (aN != null) {
                honeyClientEvent.m5090b("translation_id", aN.m24917j());
                honeyClientEvent.m5083a("original_translation_confidence", aN.m24913a());
            }
            this.f24369a.mo526a(honeyClientEvent);
        }
    }
}
