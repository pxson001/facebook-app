package com.facebook.timeline.units.storymenu;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.ui.futures.TasksManager;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: extra_events_note_text */
public class SelfTimelineFeedStoryMenuHelperProvider extends AbstractAssistedProvider<SelfTimelineFeedStoryMenuHelper> {
    public final SelfTimelineFeedStoryMenuHelper m12771a(TimelineContext timelineContext, FeedEnvironment feedEnvironment) {
        return new SelfTimelineFeedStoryMenuHelper(timelineContext, IdBasedSingletonScopeProvider.a(this, 968), IdBasedSingletonScopeProvider.a(this, 2347), (ComposerLauncher) ComposerLauncherImpl.a(this), TasksManager.a(this), ProductItemUpdateAvailabilityHelper.a(this), IdBasedProvider.a(this, 3989), IdBasedProvider.a(this, 3988), IdBasedProvider.a(this, 216), AnalyticsLoggerMethodAutoProvider.a(this), NewsFeedAnalyticsEventBuilder.a(this), TimelineStoryEventBus.a(this), IdBasedProvider.a(this, 640), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), SaveButtonUtils.a(this), SaveAnalyticsLogger.a(this), IdBasedProvider.a(this, 3588), (Clock) SystemClockMethodAutoProvider.a(this), FeedEventBus.a(this), DefaultAndroidThreadUtil.a(this), IdBasedProvider.a(this, 9702), IdBasedProvider.a(this, 3990), IdBasedProvider.a(this, 10288), GraphQLStoryUtil.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedProvider.a(this, 11752), SocialSearchInternalActionsHelper.a(this), feedEnvironment, Boolean_IsWorkBuildMethodAutoProvider.a(this), OptimisticStoryStateCache.a(this), DefaultPrivacyScopeResourceResolver.a(this), XConfigReader.a(this), RapidReportingController.a(this), ControllerMutationGatekeepers.a(this), GraphQLQueryExecutor.a(this), (SetNotifyMeLegacyMutationProvider) getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }
}
