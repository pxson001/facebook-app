package com.facebook.timeline.units.storymenu;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_greeting_card */
public class NonSelfTimelineFeedStoryMenuHelper extends TimelineFeedStoryMenuHelper {
    @Inject
    public NonSelfTimelineFeedStoryMenuHelper(@Assisted TimelineContext timelineContext, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<GraphPostService> provider5, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, TimelineStoryEventBus timelineStoryEventBus, Provider<TriState> provider6, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<Toaster> provider7, Clock clock, FeedEventBus feedEventBus, AndroidThreadUtil androidThreadUtil, Provider<EditPrivacyIntentBuilder> provider8, Provider<Boolean> provider9, Provider<StoryReviewComposerLauncherAndHandler> provider10, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider11, SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, @Assisted FeedEnvironment feedEnvironment, Boolean bool, OptimisticStoryStateCache optimisticStoryStateCache, PrivacyScopeResourceResolver privacyScopeResourceResolver, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(timelineContext, provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, provider3, provider4, provider5, analyticsLogger, newsFeedAnalyticsEventBuilder, timelineStoryEventBus, provider6, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider7, clock, feedEventBus, androidThreadUtil, provider8, provider9, provider10, graphQLStoryUtil, qeAccessor, provider11, socialSearchInternalActionsHelper, feedEnvironment, bool, optimisticStoryStateCache, privacyScopeResourceResolver, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    protected final boolean mo558a(GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        return TimelineFeedStoryMenuHelper.f12800s.contains(graphQLNegativeFeedbackActionType);
    }

    protected final boolean mo559b(GraphQLStory graphQLStory) {
        return false;
    }

    public final NegativeFeedbackExperienceLocation m12764a() {
        return NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE;
    }
}
