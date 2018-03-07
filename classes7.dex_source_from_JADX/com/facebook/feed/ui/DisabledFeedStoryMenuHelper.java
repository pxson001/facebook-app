package com.facebook.feed.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: Trying to remove a view index above child count  */
public class DisabledFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f21737o = new C18231();
    private static volatile DisabledFeedStoryMenuHelper f21738p;

    /* compiled from: Trying to remove a view index above child count  */
    final class C18231 implements Provider<Boolean> {
        C18231() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    public static com.facebook.feed.ui.DisabledFeedStoryMenuHelper m24318a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21738p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.ui.DisabledFeedStoryMenuHelper.class;
        monitor-enter(r1);
        r0 = f21738p;	 Catch:{ all -> 0x003a }
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
        r0 = m24319b(r0);	 Catch:{ all -> 0x0035 }
        f21738p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21738p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.ui.DisabledFeedStoryMenuHelper.a(com.facebook.inject.InjectorLike):com.facebook.feed.ui.DisabledFeedStoryMenuHelper");
    }

    private static DisabledFeedStoryMenuHelper m24319b(InjectorLike injectorLike) {
        return new DisabledFeedStoryMenuHelper(IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedSingletonScopeProvider.a(injectorLike, 2347), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TasksManager.a(injectorLike), ProductItemUpdateAvailabilityHelper.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), SaveButtonUtils.a(injectorLike), SaveAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 216), DefaultAndroidThreadUtil.a(injectorLike), FeedEventBus.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 3588), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 9702), IdBasedProvider.a(injectorLike, 10288), GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 11752), OptimisticStoryStateCache.a(injectorLike), XConfigReader.a(injectorLike), RapidReportingController.a(injectorLike), ControllerMutationGatekeepers.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (SetNotifyMeLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }

    @Inject
    public DisabledFeedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<Toaster> provider4, Clock clock, Provider<EditPrivacyIntentBuilder> provider5, Provider<StoryReviewComposerLauncherAndHandler> provider6, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider7, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, f21737o, f21737o, f21737o, analyticsLogger, newsFeedAnalyticsEventBuilder, null, provider4, clock, provider5, f21737o, provider6, graphQLStoryUtil, qeAccessor, provider7, null, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    protected final boolean m24321a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return false;
    }

    @Nullable
    public final NegativeFeedbackExperienceLocation m24320a() {
        return null;
    }

    @Nullable
    protected final CurationSurface m24322b() {
        return null;
    }

    @Nullable
    protected final String m24323c() {
        return null;
    }
}
