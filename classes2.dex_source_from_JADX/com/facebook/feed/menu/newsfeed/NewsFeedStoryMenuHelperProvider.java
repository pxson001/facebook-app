package com.facebook.feed.menu.newsfeed;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
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
import com.facebook.groups.feed.menu.common.GroupsReportToAdminHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.topics.data.UserTopicHideMutator;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: new_build_url */
public class NewsFeedStoryMenuHelperProvider extends AbstractAssistedProvider<NewsFeedStoryMenuHelper> {
    public final NewsFeedStoryMenuHelper m18365a(FeedEnvironment feedEnvironment) {
        return new NewsFeedStoryMenuHelper(IdBasedSingletonScopeProvider.m1809a(this, 2347), ComposerLauncherImpl.m14892a(this), TasksManager.m14546a((InjectorLike) this), ProductItemUpdateAvailabilityHelper.m18443a((InjectorLike) this), IdBasedProvider.m1811a(this, 3989), IdBasedProvider.m1811a(this, 3988), IdBasedProvider.m1811a(this, 3982), IdBasedProvider.m1811a(this, 3983), IdBasedProvider.m1811a(this, 216), IdBasedSingletonScopeProvider.m1809a(this, 5011), DefaultAndroidThreadUtil.m1645a((InjectorLike) this), FeedEventBus.m4573a(this), AnalyticsLoggerMethodAutoProvider.m3509a(this), NewsFeedAnalyticsEventBuilder.m14112a((InjectorLike) this), IdBasedProvider.m1811a(this, 640), IdBasedSingletonScopeProvider.m1809a(this, 968), IdBasedProvider.m1811a(this, 3588), SystemClockMethodAutoProvider.m1498a(this), PlayerActivityManager.m12995a((InjectorLike) this), FbObjectMapperMethodAutoProvider.m6609a(this), SaveButtonUtils.m18452a((InjectorLike) this), SaveAnalyticsLogger.m13117a(this), IdBasedProvider.m1811a(this, 9702), IdBasedProvider.m1811a(this, 3990), IdBasedProvider.m1811a(this, 10288), GraphQLStoryUtil.m9565a((InjectorLike) this), CurationFlowManager.m18565a((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), IdBasedProvider.m1811a(this, 11752), IdBasedLazy.m1808a(this, 2073), SeeFirstStateManager.m16868a((InjectorLike) this), FeedStoryUtil.m18578a((InjectorLike) this), feedEnvironment, GroupsReportToAdminHelper.m18595a(this), SocialSearchInternalActionsHelper.m18598a((InjectorLike) this), GatekeeperStoreImplMethodAutoProvider.m2131a(this), OptimisticStoryStateCache.m9726a((InjectorLike) this), DefaultPrivacyScopeResourceResolver.m18602a((InjectorLike) this), ArticleHideSuggestionMutator.m18604a((InjectorLike) this), XConfigReader.m2681a(this), RapidReportingController.m18608a((InjectorLike) this), UserTopicHideMutator.m18620a(this), UserTopicTombstoneStateManager.m18624a(this), String_LoggedInUserIdMethodAutoProvider.m4328a(this), ControllerMutationGatekeepers.m18448a(this), GraphQLQueryExecutor.m10435a((InjectorLike) this), (SetNotifyMeLegacyMutationProvider) getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class), GoodFriendsComposerPluginHelper.m18627a(this));
    }
}
