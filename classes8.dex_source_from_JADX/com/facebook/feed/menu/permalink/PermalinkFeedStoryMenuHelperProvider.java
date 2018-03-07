package com.facebook.feed.menu.permalink;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.curationflow.CurationFlowManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginHelper;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutator;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstoneStateManager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.groups.feed.menu.common.GroupsReportToAdminHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.topics.data.UserTopicHideMutator;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: group_join_tap */
public class PermalinkFeedStoryMenuHelperProvider extends AbstractAssistedProvider<PermalinkFeedStoryMenuHelper> {
    public final PermalinkFeedStoryMenuHelper m14020a(FeedEnvironment feedEnvironment) {
        return new PermalinkFeedStoryMenuHelper(IdBasedSingletonScopeProvider.a(this, 2347), (ComposerLauncher) ComposerLauncherImpl.a(this), TasksManager.a(this), ProductItemUpdateAvailabilityHelper.a(this), IdBasedProvider.a(this, 3989), IdBasedProvider.a(this, 3988), IdBasedProvider.a(this, 3982), IdBasedProvider.a(this, 3983), IdBasedProvider.a(this, 216), IdBasedSingletonScopeProvider.a(this, 5011), DefaultAndroidThreadUtil.a(this), FeedEventBus.a(this), AnalyticsLoggerMethodAutoProvider.a(this), NewsFeedAnalyticsEventBuilder.a(this), IdBasedProvider.a(this, 640), IdBasedSingletonScopeProvider.a(this, 968), IdBasedProvider.a(this, 3588), (Clock) SystemClockMethodAutoProvider.a(this), PlayerActivityManager.a(this), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), SaveButtonUtils.a(this), SaveAnalyticsLogger.a(this), IdBasedProvider.a(this, 9702), IdBasedProvider.a(this, 3990), IdBasedProvider.a(this, 10288), GraphQLStoryUtil.a(this), CurationFlowManager.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedProvider.a(this, 11752), IdBasedLazy.a(this, 2073), SeeFirstStateManager.a(this), FeedStoryUtil.a(this), feedEnvironment, GroupsReportToAdminHelper.a(this), GroupsDisableCommentsHelper.m488a((InjectorLike) this), SocialSearchInternalActionsHelper.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), OptimisticStoryStateCache.a(this), DefaultPrivacyScopeResourceResolver.a(this), ArticleHideSuggestionMutator.a(this), XConfigReader.a(this), RapidReportingController.a(this), UserTopicHideMutator.a(this), UserTopicTombstoneStateManager.a(this), String_LoggedInUserIdMethodAutoProvider.a(this), ControllerMutationGatekeepers.a(this), GraphQLQueryExecutor.a(this), (SetNotifyMeLegacyMutationProvider) getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class), GoodFriendsComposerPluginHelper.a(this));
    }
}
