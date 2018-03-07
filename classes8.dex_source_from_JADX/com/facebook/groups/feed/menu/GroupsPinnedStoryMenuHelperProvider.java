package com.facebook.groups.feed.menu;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.FbAppType;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: faceweb/f?href=/%s/allactivity */
public class GroupsPinnedStoryMenuHelperProvider extends AbstractAssistedProvider<GroupsPinnedStoryMenuHelper> {
    public final GroupsPinnedStoryMenuHelper m15678a(BaseFeedEnvironment baseFeedEnvironment) {
        return new GroupsPinnedStoryMenuHelper(IdBasedSingletonScopeProvider.a(this, 968), IdBasedSingletonScopeProvider.a(this, 2347), (ComposerLauncher) ComposerLauncherImpl.a(this), TasksManager.a(this), ProductItemUpdateAvailabilityHelper.a(this), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), SaveButtonUtils.a(this), SaveAnalyticsLogger.a(this), IdBasedProvider.a(this, 216), DefaultAndroidThreadUtil.a(this), FeedEventBus.a(this), IdBasedProvider.a(this, 3989), IdBasedProvider.a(this, 3982), IdBasedProvider.a(this, 3983), AnalyticsLoggerMethodAutoProvider.a(this), NewsFeedAnalyticsEventBuilder.a(this), IdBasedProvider.a(this, 640), IdBasedProvider.a(this, 4442), IdBasedProvider.a(this, 3588), (Clock) SystemClockMethodAutoProvider.a(this), GroupsFeedStoryModerationHelper.m15664a((InjectorLike) this), GroupsDisableCommentsHelper.m488a((InjectorLike) this), getLazy(FbAppType.class), IdBasedProvider.a(this, 9702), IdBasedProvider.a(this, 3990), IdBasedProvider.a(this, 10288), ViewerStatusCache.m15635a((InjectorLike) this), GraphQLStoryUtil.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedProvider.a(this, 12), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), IdBasedProvider.a(this, 11752), baseFeedEnvironment, OptimisticStoryStateCache.a(this), XConfigReader.a(this), RapidReportingController.a(this), ControllerMutationGatekeepers.a(this), GraphQLQueryExecutor.a(this), (SetNotifyMeLegacyMutationProvider) getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }
}
