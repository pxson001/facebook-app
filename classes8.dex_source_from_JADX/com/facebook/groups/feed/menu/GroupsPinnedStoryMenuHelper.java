package com.facebook.groups.feed.menu;

import android.content.ComponentName;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: faceweb/f?href=/%s/get_notification */
public class GroupsPinnedStoryMenuHelper extends GroupsFeedStoryMenuHelper {
    @Inject
    public GroupsPinnedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider7, Provider<String> provider8, Provider<Toaster> provider9, Clock clock, GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, GroupsDisableCommentsHelper groupsDisableCommentsHelper, Lazy<FbAppType> lazy, Provider<EditPrivacyIntentBuilder> provider10, Provider<Boolean> provider11, Provider<StoryReviewComposerLauncherAndHandler> provider12, ViewerStatusCache viewerStatusCache, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, @FragmentChromeActivity Provider<ComponentName> provider13, FbErrorReporter fbErrorReporter, Provider<BottomSheetDialog> provider14, @Assisted BaseFeedEnvironment baseFeedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, provider5, provider6, analyticsLogger, newsFeedAnalyticsEventBuilder, provider7, provider8, provider9, clock, groupsFeedStoryModerationHelper, groupsDisableCommentsHelper, lazy, provider10, provider11, provider12, viewerStatusCache, graphQLStoryUtil, qeAccessor, provider13, fbErrorReporter, provider14, baseFeedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    protected final boolean mo839j(FeedUnit feedUnit) {
        return false;
    }

    protected final boolean mo841l(FeedUnit feedUnit) {
        return m15660o(feedUnit);
    }
}
