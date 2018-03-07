package com.facebook.feed.menu.permalink;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.bugreporter.BugReporter;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.curationflow.CurationFlowManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutator;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstoneStateManager;
import com.facebook.friends.FriendingClient;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.groups.feed.menu.common.GroupsReportToAdminHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.topics.data.UserTopicHideMutator;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: group_leave_tap */
public class PermalinkFeedStoryMenuHelper extends NewsFeedStoryMenuHelper {
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f11923o = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNTAG, GraphQLNegativeFeedbackActionType.DONT_LIKE);
    public GroupsDisableCommentsHelper f11924p;

    /* compiled from: group_leave_tap */
    class PermalinkFeedStoryMenuOptions extends NewsFeedStoryMenuOptions {
        final /* synthetic */ PermalinkFeedStoryMenuHelper f11922c;

        public final boolean m14008a(FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (!(this.f11922c.i(graphQLStory) || this.f11922c.e(graphQLStory) || this.f11922c.g(graphQLStory) || this.f11922c.f(graphQLStory))) {
                PermalinkFeedStoryMenuHelper permalinkFeedStoryMenuHelper = this.f11922c;
                if (!(BaseFeedStoryMenuHelper.h(graphQLStory) || m14010c(feedProps) || a(graphQLStory) || NewsFeedStoryMenuOptions.d(graphQLStory) || m14011e(graphQLStory))) {
                    return false;
                }
            }
            return true;
        }

        protected final void m14009c(Menu menu, final FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            MenuItem add = menu.add(this.f11922c.f11924p.m495b(graphQLStory));
            add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ PermalinkFeedStoryMenuOptions f11921b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f11921b.f11922c.f11924p.m494a(feedProps);
                    return true;
                }
            });
            this.f11922c.a(add, 2130839805, graphQLStory);
        }

        public PermalinkFeedStoryMenuOptions(PermalinkFeedStoryMenuHelper permalinkFeedStoryMenuHelper) {
            this.f11922c = permalinkFeedStoryMenuHelper;
            super(permalinkFeedStoryMenuHelper);
        }

        public final boolean m14010c(FeedProps<? extends FeedUnit> feedProps) {
            return d(feedProps);
        }

        protected final boolean m14011e(FeedUnit feedUnit) {
            GroupsDisableCommentsHelper groupsDisableCommentsHelper = this.f11922c.f11924p;
            return GroupsDisableCommentsHelper.m490a(feedUnit);
        }
    }

    @Inject
    public PermalinkFeedStoryMenuHelper(Provider<IFeedIntentBuilder> provider, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<GraphPostService> provider6, Provider<BugReporter> provider7, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider8, Provider<SecureContextHelper> provider9, Provider<Toaster> provider10, Clock clock, PlayerActivityManager playerActivityManager, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<EditPrivacyIntentBuilder> provider11, Provider<Boolean> provider12, Provider<StoryReviewComposerLauncherAndHandler> provider13, GraphQLStoryUtil graphQLStoryUtil, CurationFlowManager curationFlowManager, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider14, Lazy<FriendingClient> lazy, SeeFirstStateManager seeFirstStateManager, FeedStoryUtil feedStoryUtil, @Assisted FeedEnvironment feedEnvironment, GroupsReportToAdminHelper groupsReportToAdminHelper, GroupsDisableCommentsHelper groupsDisableCommentsHelper, SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, GatekeeperStore gatekeeperStore, OptimisticStoryStateCache optimisticStoryStateCache, PrivacyScopeResourceResolver privacyScopeResourceResolver, ArticleHideSuggestionMutator articleHideSuggestionMutator, XConfigReader xConfigReader, RapidReportingController rapidReportingController, UserTopicHideMutator userTopicHideMutator, UserTopicTombstoneStateManager userTopicTombstoneStateManager, String str, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider, GoodFriendsComposerPluginHelper goodFriendsComposerPluginHelper) {
        super(provider, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, provider2, provider3, provider4, provider5, provider6, provider7, androidThreadUtil, feedEventBus, analyticsLogger, newsFeedAnalyticsEventBuilder, provider8, provider9, provider10, clock, playerActivityManager, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider11, provider12, provider13, graphQLStoryUtil, curationFlowManager, fbErrorReporter, qeAccessor, provider14, lazy, seeFirstStateManager, feedStoryUtil, feedEnvironment, groupsReportToAdminHelper, socialSearchInternalActionsHelper, gatekeeperStore, optimisticStoryStateCache, privacyScopeResourceResolver, articleHideSuggestionMutator, xConfigReader, rapidReportingController, userTopicHideMutator, userTopicTombstoneStateManager, str, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider, goodFriendsComposerPluginHelper);
        this.f11924p = groupsDisableCommentsHelper;
    }

    @Nonnull
    protected final CurationSurface m14014b() {
        return CurationSurface.NATIVE_STORY_PERMALINK;
    }

    protected final String m14015c() {
        return "native_permalink";
    }

    public final NegativeFeedbackExperienceLocation m14012a() {
        return NegativeFeedbackExperienceLocation.PERMALINK;
    }

    public final boolean m14013a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return f11923o.contains(graphQLNegativeFeedbackAction.b());
    }

    protected final BaseFeedStoryMenuOptions m14016d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new PermalinkFeedStoryMenuOptions(this);
        }
        return null;
    }
}
