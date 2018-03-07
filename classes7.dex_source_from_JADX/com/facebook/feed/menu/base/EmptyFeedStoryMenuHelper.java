package com.facebook.feed.menu.base;

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
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
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
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: allowOfflinePosting */
public class EmptyFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f19438o = new C16791();

    /* compiled from: allowOfflinePosting */
    final class C16791 implements Provider<Boolean> {
        C16791() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    public static EmptyFeedStoryMenuHelper m22813b(InjectorLike injectorLike) {
        return new EmptyFeedStoryMenuHelper(IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedSingletonScopeProvider.a(injectorLike, 2347), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TasksManager.a(injectorLike), ProductItemUpdateAvailabilityHelper.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), SaveButtonUtils.a(injectorLike), SaveAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 216), DefaultAndroidThreadUtil.a(injectorLike), FeedEventBus.a(injectorLike), IdBasedProvider.a(injectorLike, 3989), IdBasedProvider.a(injectorLike, 3988), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 3588), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 9702), IdBasedProvider.a(injectorLike, 3990), IdBasedProvider.a(injectorLike, 10288), GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 11752), OptimisticStoryStateCache.a(injectorLike), XConfigReader.a(injectorLike), RapidReportingController.a(injectorLike), ControllerMutationGatekeepers.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (SetNotifyMeLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }

    @Inject
    public EmptyFeedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, Provider<Boolean> provider5, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider6, Provider<Toaster> provider7, Clock clock, Provider<EditPrivacyIntentBuilder> provider8, Provider<Boolean> provider9, Provider<StoryReviewComposerLauncherAndHandler> provider10, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider11, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, provider5, f19438o, analyticsLogger, newsFeedAnalyticsEventBuilder, provider6, provider7, clock, provider8, provider9, provider10, graphQLStoryUtil, qeAccessor, provider11, null, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    protected final boolean m22815a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return false;
    }

    public final NegativeFeedbackExperienceLocation m22814a() {
        return null;
    }

    @Nonnull
    protected final CurationSurface m22816b() {
        return null;
    }

    protected final String m22817c() {
        return null;
    }
}
