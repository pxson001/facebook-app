package com.facebook.groups.feed.menu;

import android.content.ComponentName;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.FbAppType;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
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
import com.google.inject.util.Providers;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: faceweb/f?href=/%s/settings/add_services/ */
public class GroupsPendingStoryMenuHelper extends GroupsFeedStoryMenuHelper {
    private static GroupsPendingStoryMenuHelper m15673b(InjectorLike injectorLike) {
        return new GroupsPendingStoryMenuHelper(IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedSingletonScopeProvider.a(injectorLike, 2347), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TasksManager.a(injectorLike), ProductItemUpdateAvailabilityHelper.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), SaveButtonUtils.a(injectorLike), SaveAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 216), DefaultAndroidThreadUtil.a(injectorLike), FeedEventBus.a(injectorLike), IdBasedProvider.a(injectorLike, 3989), IdBasedProvider.a(injectorLike, 3982), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 3588), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GroupsFeedStoryModerationHelper.m15664a(injectorLike), GroupsDisableCommentsHelper.m488a(injectorLike), injectorLike.getLazy(FbAppType.class), IdBasedProvider.a(injectorLike, 9702), IdBasedProvider.a(injectorLike, 3990), IdBasedProvider.a(injectorLike, 10288), ViewerStatusCache.m15635a(injectorLike), GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 12), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 11752), OptimisticStoryStateCache.a(injectorLike), XConfigReader.a(injectorLike), RapidReportingController.a(injectorLike), ControllerMutationGatekeepers.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (SetNotifyMeLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }

    @Inject
    public GroupsPendingStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, Provider<Boolean> provider5, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider6, Provider<String> provider7, Provider<Toaster> provider8, Clock clock, GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, GroupsDisableCommentsHelper groupsDisableCommentsHelper, Lazy<FbAppType> lazy, Provider<EditPrivacyIntentBuilder> provider9, Provider<Boolean> provider10, Provider<StoryReviewComposerLauncherAndHandler> provider11, ViewerStatusCache viewerStatusCache, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, @FragmentChromeActivity Provider<ComponentName> provider12, FbErrorReporter fbErrorReporter, Provider<BottomSheetDialog> provider13, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, provider5, Providers.a(Boolean.valueOf(false)), analyticsLogger, newsFeedAnalyticsEventBuilder, provider6, provider7, provider8, clock, groupsFeedStoryModerationHelper, groupsDisableCommentsHelper, lazy, provider9, provider10, provider11, viewerStatusCache, graphQLStoryUtil, qeAccessor, provider12, fbErrorReporter, provider13, null, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    protected final boolean mo840m(FeedUnit feedUnit) {
        return m15660o(feedUnit);
    }

    protected final boolean mo839j(FeedUnit feedUnit) {
        return false;
    }
}
