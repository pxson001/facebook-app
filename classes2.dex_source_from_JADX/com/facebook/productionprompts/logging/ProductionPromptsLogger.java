package com.facebook.productionprompts.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: net.dns1 */
public class ProductionPromptsLogger {
    public static final String f12837a = ProductionPromptsLogger.class.getSimpleName();
    private static volatile ProductionPromptsLogger f12838d;
    private final AnalyticsLogger f12839b;
    public final AbstractFbErrorReporter f12840c;

    public static com.facebook.productionprompts.logging.ProductionPromptsLogger m18862a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12838d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.productionprompts.logging.ProductionPromptsLogger.class;
        monitor-enter(r1);
        r0 = f12838d;	 Catch:{ all -> 0x003a }
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
        r0 = m18864b(r0);	 Catch:{ all -> 0x0035 }
        f12838d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12838d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.logging.ProductionPromptsLogger.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.logging.ProductionPromptsLogger");
    }

    private static ProductionPromptsLogger m18864b(InjectorLike injectorLike) {
        return new ProductionPromptsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ProductionPromptsLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12839b = analyticsLogger;
        this.f12840c = abstractFbErrorReporter;
    }

    public final String m18866a(InlineComposerPromptSession inlineComposerPromptSession) {
        String uuid = SafeUUIDGenerator.m2795a().toString();
        m18865c(EventAction.IMPRESSION, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13409a.mo2494c(), uuid, null, inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()));
        return uuid;
    }

    public final String m18868a(ProductionPrompt productionPrompt, String str) {
        String uuid = SafeUUIDGenerator.m2795a().toString();
        m18865c(EventAction.OPEN_SUGGESTING_CONTENT, PromptAnalytics.a(productionPrompt.a(), productionPrompt.i(), str, uuid, productionPrompt.o(), PromptViewState$Visibility.MAXIMIZED.getName()));
        return uuid;
    }

    public final void m18869a(PromptAnalytics promptAnalytics) {
        m18865c(EventAction.OPEN_SELECTING_CONTENT, promptAnalytics);
    }

    public final String m18867a(InlineComposerPromptSession inlineComposerPromptSession, String str) {
        String uuid = SafeUUIDGenerator.m2795a().toString();
        m18865c(EventAction.OPEN_SELECTING_CONTENT, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, str, uuid, inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()));
        return uuid;
    }

    public final void m18871b(PromptAnalytics promptAnalytics) {
        m18865c(EventAction.CLOSE_SUGGESTION, promptAnalytics);
    }

    public final void m18873c(PromptAnalytics promptAnalytics) {
        m18865c(EventAction.POST_WITH_PROMPT, promptAnalytics);
    }

    public final void m18874d(PromptAnalytics promptAnalytics) {
        m18865c(EventAction.POST_WITHOUT_PROMPT, promptAnalytics);
    }

    public final void m18875e(PromptAnalytics promptAnalytics) {
        m18865c(EventAction.CANCEL_COMPOSER, promptAnalytics);
    }

    public final void m18870a(PromptAnalytics promptAnalytics, TapSource tapSource) {
        HoneyAnalyticsEvent b = m18863b(EventAction.HIDE_FLYOUT, promptAnalytics);
        if (tapSource != TapSource.IMPLICIT) {
            b.m5090b("tap_origin", tapSource.getName());
        }
        this.f12839b.mo526a(b);
    }

    public final void m18872b(PromptAnalytics promptAnalytics, TapSource tapSource) {
        HoneyAnalyticsEvent b = m18863b(EventAction.SHOW_FLYOUT, promptAnalytics);
        if (tapSource != TapSource.IMPLICIT) {
            b.m5090b("tap_origin", tapSource.getName());
        }
        this.f12839b.mo526a(b);
    }

    private HoneyClientEvent m18863b(EventAction eventAction, PromptAnalytics promptAnalytics) {
        HoneyClientEvent b = new HoneyClientEvent("inline_composer_prompt_event").m5090b("action", eventAction.getName()).m5090b("prompt_id", promptAnalytics.promptId).m5090b("prompt_session_id", promptAnalytics.promptSessionId).m5090b("prompt_type", promptAnalytics.promptType);
        if (promptAnalytics.trackingString != null) {
            b.m5090b("tracking_string", promptAnalytics.trackingString);
        }
        if (promptAnalytics.composerSessionId != null) {
            b.m5090b("composer_session_id", promptAnalytics.composerSessionId);
        }
        if (eventAction.equals(EventAction.IMPRESSION)) {
            b.m5090b("prompt_state", promptAnalytics.promptViewState);
        }
        boolean isNullOrEmpty = Strings.isNullOrEmpty(promptAnalytics.promptId);
        boolean isNullOrEmpty2 = Strings.isNullOrEmpty(promptAnalytics.promptType);
        boolean isNullOrEmpty3 = Strings.isNullOrEmpty(promptAnalytics.trackingString);
        if (isNullOrEmpty || isNullOrEmpty2 || isNullOrEmpty3) {
            this.f12840c.m2350b(f12837a, "PromptAnalytics validation failed when logging " + eventAction.getName() + ": Missing required field -  prompt_id=" + promptAnalytics.promptId + " prompt_type=" + promptAnalytics.promptType + " tracking_string=" + promptAnalytics.trackingString);
        }
        if (!(isNullOrEmpty || isNullOrEmpty2)) {
            Object obj;
            String toUpperCase = promptAnalytics.promptType.toUpperCase();
            if (toUpperCase.equals(GraphQLPromptType.PHOTO.toString()) || toUpperCase.equals(GraphQLPromptType.CLIPBOARD.toString()) || toUpperCase.equals(GraphQLPromptType.SOUVENIR.toString())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || promptAnalytics.promptId.contains(":"))) {
                this.f12840c.m2350b(f12837a, "PromptAnalytics validation failed when logging " + eventAction.getName() + ": no ':' in promptId prompt_id=" + promptAnalytics.promptId + " prompt_type=" + promptAnalytics.promptType + " tracking_string=" + promptAnalytics.trackingString);
            }
        }
        return b;
    }

    private void m18865c(EventAction eventAction, PromptAnalytics promptAnalytics) {
        this.f12839b.mo526a(m18863b(eventAction, promptAnalytics));
    }
}
