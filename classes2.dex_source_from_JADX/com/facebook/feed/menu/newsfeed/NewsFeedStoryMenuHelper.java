package com.facebook.feed.menu.newsfeed;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.bugreporter.BugReporter;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.curationflow.CurationFlowManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginConfig;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.FeedStoryMenuActionType;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.menu.base.StoryMenuIconUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents$StoryDeleteEvent;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feed.util.story.FeedStoryUtilModelConverter;
import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutator;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstoneStateManager;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.friends.FriendingClient;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLName;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsConnection;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.feed.menu.common.GroupsReportToAdminHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.topics.data.UserTopicHideMutator;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: new_build */
public class NewsFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final String f12315o = NewsFeedStoryMenuHelper.class.getSimpleName();
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f12316p = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNTAG, GraphQLNegativeFeedbackActionType.HIDE, GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE, GraphQLNegativeFeedbackActionType.HIDE_ADVERTISER, GraphQLNegativeFeedbackActionType.HIDE_AD, GraphQLNegativeFeedbackActionType.HIDE_APP, GraphQLNegativeFeedbackActionType.HIDE_RESEARCH_POLLS, GraphQLNegativeFeedbackActionType.HIDE_TOPIC_MISCLASSIFICATION);
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f12317q = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE);
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f12318r = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNTAG);
    public static final ImmutableSet<GraphQLNegativeFeedbackActionType> f12319s = ImmutableSet.of(GraphQLNegativeFeedbackActionType.HIDE);
    private final SeeFirstStateManager f12320A;
    public final Provider<Boolean> f12321B;
    private final FeedStoryUtil f12322C;
    public final GroupsReportToAdminHelper f12323D;
    public final SocialSearchInternalActionsHelper f12324E;
    public final GatekeeperStoreImpl f12325F;
    public final DefaultPrivacyScopeResourceResolver f12326G;
    public final QeAccessor f12327H;
    public final ArticleHideSuggestionMutator f12328I;
    public final UserTopicHideMutator f12329J;
    public final UserTopicTombstoneStateManager f12330K;
    private final String f12331L;
    private final ComposerLauncher f12332t;
    private final PlayerActivityManager f12333u;
    private final Provider<BugReporter> f12334v;
    public final CurationFlowManager f12335w;
    private GoodFriendsComposerPluginHelper f12336x;
    public final AbstractFbErrorReporter f12337y;
    public final Lazy<FriendingClient> f12338z;

    /* compiled from: new_build */
    public class NewsFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        public final /* synthetic */ NewsFeedStoryMenuHelper f21762b;

        private void m29467c(Menu menu, FeedProps<GraphQLStory> feedProps, Context context) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            String name = FeedStoryMenuActionType.DELETE.name();
            MenuItem add = menu.add(2131233440);
            add.setOnMenuItemClickListener(new 2(this, feedProps, name, feedUnit, context));
            this.f21762b.m18411a(add, 2130840135, feedUnit);
            this.f21762b.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
        }

        private void m29468c(Menu menu, FeedProps<GraphQLStory> feedProps, View view) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            ImmutableList b = m29465b();
            for (int i = 0; i < b.size(); i++) {
                switch (12.b[((MenuItemType) b.get(i)).ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        if (!mo3190c((FeedProps) feedProps)) {
                            break;
                        }
                        this.f21762b.mo2466a(menu, (FeedProps) feedProps, view);
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        if (!m29486a(feedUnit)) {
                            break;
                        }
                        m29490b(menu, (FeedProps) feedProps, view);
                        break;
                    case 3:
                        if (!this.f21762b.m18392j(feedUnit)) {
                            break;
                        }
                        NewsFeedStoryMenuHelper.m18369a(this.f21762b, view.getContext(), menu, (FeedProps) feedProps);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        if (!NewsFeedStoryMenuHelper.m18375k(this.f21762b, feedUnit)) {
                            break;
                        }
                        NewsFeedStoryMenuHelper.m18371b(this.f21762b, view.getContext(), menu, feedProps);
                        break;
                    default:
                        break;
                }
            }
        }

        public boolean mo3188a(FeedProps<GraphQLStory> feedProps) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            if (!(super.mo3188a((FeedProps) feedProps) || mo3190c((FeedProps) feedProps) || this.f21762b.m18440i(feedUnit) || this.f21762b.m18433e(feedUnit))) {
                NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f21762b;
                if (!(BaseFeedStoryMenuHelper.m18404h(feedUnit) || m29486a(feedUnit) || this.f21762b.m18435f(feedUnit) || this.f21762b.m18437g(feedUnit) || NewsFeedStoryMenuHelper.m18376l(feedUnit) || m29494c(feedUnit) || this.f21762b.m18392j(feedUnit) || m29470d(feedUnit) || NewsFeedStoryMenuHelper.m18375k(this.f21762b, feedUnit))) {
                    return false;
                }
            }
            return true;
        }

        @VisibleForTesting
        public boolean mo3190c(FeedProps<? extends FeedUnit> feedProps) {
            boolean l;
            if (((FeedUnit) feedProps.f13444a) instanceof GraphQLStory) {
                GraphQLStoryUtil graphQLStoryUtil = this.f21762b.f12360l;
                l = GraphQLStoryUtil.m9580l(feedProps);
            } else {
                l = false;
            }
            return !l && mo3191d((FeedProps) feedProps);
        }

        protected final boolean mo3191d(FeedProps<? extends FeedUnit> feedProps) {
            return ((Boolean) this.f21762b.f12354f.get()).booleanValue() && super.mo3190c((FeedProps) feedProps) && !((GraphQLStory) ((FeedUnit) feedProps.f13444a)).m22329O();
        }

        public NewsFeedStoryMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
            this.f21762b = newsFeedStoryMenuHelper;
            super(newsFeedStoryMenuHelper);
        }

        public final void mo3187a(Menu menu, FeedProps<GraphQLStory> feedProps, View view) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            Context context = view.getContext();
            Object obj = (feedUnit.mo2890l() == null || !feedUnit.mo2890l().m23207A()) ? null : 1;
            if (obj != null) {
                m29482a(menu, feedProps);
            }
            m29468c(menu, (FeedProps) feedProps, view);
            if (m29487a((GraphQLStory) feedUnit)) {
                m29488b(menu, feedProps);
            }
            Object obj2 = (m29465b().contains(MenuItemType.SAVE) || !m29486a(feedUnit)) ? null : 1;
            if (obj2 != null) {
                m29490b(menu, (FeedProps) feedProps, view);
            }
            if (this.f21762b.m18440i(feedUnit)) {
                m29467c(menu, (FeedProps) feedProps, context);
            }
            if (this.f21762b.m18437g(feedUnit)) {
                m29464a(menu, feedProps, feedUnit, context);
            }
            if (this.f21762b.m18435f(feedUnit)) {
                m29489b(menu, (FeedProps) feedProps, context);
            }
            NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f21762b;
            if (BaseFeedStoryMenuHelper.m18404h(feedUnit)) {
                m29466b(menu, feedProps, feedUnit, context);
            }
            if (this.f21762b.m18433e(feedUnit)) {
                m29469c(menu, feedProps, feedUnit, context);
            }
            obj2 = (m29465b().contains(MenuItemType.NEGATIVE_FEEDBACK_ACTION) || !mo3190c((FeedProps) feedProps)) ? null : 1;
            if (obj2 != null) {
                this.f21762b.mo2466a(menu, (FeedProps) feedProps, view);
            }
            if (m29465b().contains(MenuItemType.UN_SEE_FIRST) || !this.f21762b.m18392j(feedUnit)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                NewsFeedStoryMenuHelper.m18369a(this.f21762b, context, menu, (FeedProps) feedProps);
            }
            if (NewsFeedStoryMenuHelper.m18376l(feedUnit)) {
                NewsFeedStoryMenuHelper.m18372d(this.f21762b, menu, feedProps, view);
            }
            if (obj == null) {
                m29482a(menu, feedProps);
            }
            if (m29491b((FeedProps) feedProps)) {
                m29483a(menu, (FeedProps) feedProps, context);
            }
            if (m29470d(feedUnit)) {
                MenuItem add = menu.add(2131233459);
                add.setOnMenuItemClickListener(new 1(this, context, feedUnit));
                this.f21762b.m18411a(add, 2130840081, feedUnit);
            }
            if (m29476e(feedUnit)) {
                mo3189c(menu, feedProps);
            }
            if (this.f21762b.f12324E.m18600a(feedUnit)) {
                this.f21762b.f12324E.m18599a(menu, feedUnit, context);
            }
            Object obj3 = (m29465b().contains(MenuItemType.HIDE_TOPIC_FROM_USER) || !NewsFeedStoryMenuHelper.m18375k(this.f21762b, feedUnit)) ? null : 1;
            if (obj3 != null) {
                NewsFeedStoryMenuHelper.m18371b(this.f21762b, context, menu, feedProps);
            }
            super.mo3187a(menu, (FeedProps) feedProps, view);
        }

        protected static boolean m29470d(FeedUnit feedUnit) {
            ImmutableList a = StoryActionLinkHelper.m28074a((GraphQLStory) feedUnit);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLObjectType a2 = ((GraphQLStoryActionLink) a.get(i)).m22901a();
                if (a2 != null && a2.m22301g() == 1464405859) {
                    return true;
                }
            }
            return false;
        }

        protected boolean m29476e(FeedUnit feedUnit) {
            return false;
        }

        protected void mo3189c(Menu menu, FeedProps<GraphQLStory> feedProps) {
        }

        private void m29464a(Menu menu, FeedProps<? extends FeedUnit> feedProps, GraphQLStory graphQLStory, Context context) {
            String name = FeedStoryMenuActionType.EDIT_POST.name();
            MenuItem add = menu.add(2131233471);
            this.f21762b.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 3(this, feedProps, name, graphQLStory, context));
            this.f21762b.m18411a(add, 2130840013, (FeedUnit) graphQLStory);
        }

        private void m29466b(Menu menu, FeedProps<? extends FeedUnit> feedProps, GraphQLStory graphQLStory, Context context) {
            String name = FeedStoryMenuActionType.VIEW_EDIT_HISTORY.name();
            MenuItem add = menu.add(2131233473);
            this.f21762b.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 4(this, feedProps, name, context));
            this.f21762b.m18411a(add, 2130839800, (FeedUnit) graphQLStory);
        }

        private void m29469c(Menu menu, FeedProps<? extends FeedUnit> feedProps, GraphQLStory graphQLStory, Context context) {
            String name = FeedStoryMenuActionType.EDIT_PRIVACY.name();
            MenuItem add = menu.add(2131233468);
            this.f21762b.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 5(this, feedProps, name, context));
            this.f21762b.m18411a(add, this.f21762b.f12326G.m18603a(graphQLStory.ao().m23522s()), (FeedUnit) graphQLStory);
        }

        private ImmutableList<MenuItemType> m29465b() {
            if (this.f21762b.f12325F.m2189a(1113, false)) {
                return ImmutableList.of(MenuItemType.SAVE, MenuItemType.NEGATIVE_FEEDBACK_ACTION, MenuItemType.UN_SEE_FIRST, MenuItemType.HIDE_TOPIC_FROM_USER);
            }
            return ImmutableList.of(MenuItemType.NEGATIVE_FEEDBACK_ACTION, MenuItemType.UN_SEE_FIRST, MenuItemType.HIDE_TOPIC_FROM_USER, MenuItemType.SAVE);
        }
    }

    public static void m18370a(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, View view, HoneyClientEvent honeyClientEvent) {
        HideableUnit hideableUnit = (HideableUnit) feedProps.f13444a;
        if (hideableUnit.mo2881q() == null || ((hideableUnit instanceof FollowUpFeedUnit) && PropertyHelper.m21286a((FollowUpFeedUnit) hideableUnit))) {
            newsFeedStoryMenuHelper.f12357i.mo526a((HoneyAnalyticsEvent) honeyClientEvent);
            return;
        }
        newsFeedStoryMenuHelper.f12350b.m1651a(((GraphPostService) newsFeedStoryMenuHelper.f12349a.get()).m18481a(hideableUnit, TrackableFeedProps.m27452b(feedProps).toString()), new 1(newsFeedStoryMenuHelper, honeyClientEvent, hideableUnit, view));
    }

    private void m18374f(Menu menu, FeedProps<? extends FeedUnit> feedProps, View view) {
        FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
        Resources resources = view.getResources();
        boolean z = ((Sponsorable) feedUnit).ab_().f21624w;
        CharSequence string = resources.getString(z ? 2131233633 : 2131233631);
        if (!Strings.isNullOrEmpty(string)) {
            String name = z ? FeedStoryMenuActionType.MARK_AS_USEFUL.name() : FeedStoryMenuActionType.THIS_AD_IS_USEFUL.name();
            MenuItem add = menu.add(string);
            add.setIcon(2130838036);
            add.setOnMenuItemClickListener(new 11(this, feedProps, name, feedUnit));
            m18414a((FeedProps) feedProps, add.getItemId(), name, false);
        }
    }

    protected final void mo2467a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        this.f12351c.mo651a(new HideEvents$StoryDeleteEvent(feedProps));
        this.f12351c.mo651a(new HideEvents$ChangeRendererEvent());
        this.f12350b.m1651a(((GraphPostService) this.f12349a.get()).m18479a(graphQLStory), new 5(this, graphQLStory));
    }

    @Inject
    public NewsFeedStoryMenuHelper(Provider<IFeedIntentBuilder> provider, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<GraphPostService> provider6, Provider<BugReporter> provider7, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider8, Provider<SecureContextHelper> provider9, Provider<Toaster> provider10, Clock clock, PlayerActivityManager playerActivityManager, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<EditPrivacyIntentBuilder> provider11, Provider<Boolean> provider12, Provider<StoryReviewComposerLauncherAndHandler> provider13, GraphQLStoryUtil graphQLStoryUtil, CurationFlowManager curationFlowManager, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider14, Lazy<FriendingClient> lazy, SeeFirstStateManager seeFirstStateManager, FeedStoryUtil feedStoryUtil, @Assisted FeedEnvironment feedEnvironment, GroupsReportToAdminHelper groupsReportToAdminHelper, SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, GatekeeperStore gatekeeperStore, OptimisticStoryStateCache optimisticStoryStateCache, PrivacyScopeResourceResolver privacyScopeResourceResolver, ArticleHideSuggestionMutator articleHideSuggestionMutator, XConfigReader xConfigReader, RapidReportingController rapidReportingController, UserTopicHideMutator userTopicHideMutator, UserTopicTombstoneStateManager userTopicTombstoneStateManager, String str, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider, GoodFriendsComposerPluginHelper goodFriendsComposerPluginHelper) {
        super(provider9, provider, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider6, androidThreadUtil, feedEventBus, provider2, provider3, provider4, analyticsLogger, newsFeedAnalyticsEventBuilder, provider8, provider10, clock, provider11, provider12, provider13, graphQLStoryUtil, qeAccessor, provider14, feedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f12332t = composerLauncher;
        this.f12333u = playerActivityManager;
        this.f12334v = provider7;
        this.f12335w = curationFlowManager;
        this.f12336x = goodFriendsComposerPluginHelper;
        this.m = true;
        this.f12337y = fbErrorReporter;
        this.f12338z = lazy;
        this.f12320A = seeFirstStateManager;
        this.f12321B = provider5;
        this.f12322C = feedStoryUtil;
        this.f12323D = groupsReportToAdminHelper;
        this.f12324E = socialSearchInternalActionsHelper;
        this.f12325F = gatekeeperStore;
        this.f12326G = privacyScopeResourceResolver;
        this.f12327H = qeAccessor;
        this.f12328I = articleHideSuggestionMutator;
        this.f12329J = userTopicHideMutator;
        this.f12330K = userTopicTombstoneStateManager;
        this.f12331L = str;
    }

    @Nonnull
    protected CurationSurface mo2472b() {
        return CurationSurface.NATIVE_STORY;
    }

    protected String mo2474c() {
        return "native_newsfeed";
    }

    public boolean mo2471a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        if (f12317q.contains(graphQLNegativeFeedbackAction.m27654b()) && m18392j(negativeFeedbackActionsUnit)) {
            GraphQLStory graphQLStory = (GraphQLStory) negativeFeedbackActionsUnit;
            GraphQLProfile q = graphQLNegativeFeedbackAction.m27662q();
            ImmutableList at = graphQLStory.at();
            int size = at.size();
            for (int i = 0; i < size; i++) {
                GraphQLActor graphQLActor = (GraphQLActor) at.get(i);
                if (graphQLActor.m23765H().equals(q.m22999b()) && graphQLActor.an() == GraphQLSecondarySubscribeStatus.SEE_FIRST) {
                    return false;
                }
            }
        }
        return f12316p.contains(graphQLNegativeFeedbackAction.m27654b());
    }

    protected final void mo2469a(GraphQLStory graphQLStory, Context context) {
        Builder a = m18407a(graphQLStory);
        if (GraphQLStoryHelper.m10202d(graphQLStory)) {
            a.setPluginConfig(this.f12336x.f12552a.mo2485a(GoodFriendsComposerPluginConfig.a("")));
        }
        this.f12332t.mo1955a(null, a.a(), 1758, (Activity) ContextUtils.m2500a(context, Activity.class));
    }

    public final void mo2468a(FeedProps<? extends Flattenable> feedProps, View view) {
        super.mo2468a((FeedProps) feedProps, view);
        if (this.f12333u != null) {
            this.f12333u.m12998a(EventTriggerType.BY_DIALOG);
        }
    }

    protected final String mo2475c(FeedUnit feedUnit) {
        String name = feedUnit.getClass().getName();
        if ((feedUnit instanceof GraphQLStory) && FeedStoryUtil.m18580a(FeedStoryUtilModelConverter.m29448b((GraphQLStory) feedUnit))) {
            return name + ":OrganicHScroll";
        }
        return name;
    }

    protected BaseFeedStoryMenuOptions mo2476d(FeedUnit feedUnit) {
        if ((feedUnit instanceof GraphQLStorySet) && !((GraphQLStorySet) feedUnit).mo2895u()) {
            return new ScrollableNewsFeedStoryMenuOptions(this);
        }
        if ((feedUnit instanceof GraphQLPageStoriesYouMissedFeedUnit) || (feedUnit instanceof GraphQLGroupTopStoriesFeedUnit)) {
            return new NetEgoStoriesFeedUnitStoryMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLStory) {
            return new NewsFeedStoryMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLCreativePagesYouMayLikeFeedUnit) {
            return new CreativePagesYouMayLikeFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit) {
            return new PYMLWithLargeImageFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit) {
            return new PagesYouMayLikeFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLPagesYouMayAdvertiseFeedUnit) {
            return new PagesYouMayAdvertiseFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLPeopleYouMayInviteFeedUnit) {
            return new PeopleYouMayInviteFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLSurveyFeedUnit) {
            return new SurveyFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLResearchPollFeedUnit) {
            return new ResearchPollFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof GraphQLFriendsLocationsFeedUnit) {
            return new FriendsNearbyFeedUnitMenuOptions(this);
        }
        if (feedUnit instanceof HideableUnit) {
            return new DefaultHideableFeedUnitMenuOptions(this);
        }
        return null;
    }

    protected final GraphQLArticleChainingFeedUnitMenuOptions mo2473b(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLArticleChainingFeedUnit) {
            return new GraphQLArticleChainingFeedUnitMenuOptions(this);
        }
        return null;
    }

    protected final Provider<BugReporter> mo2477g() {
        return this.f12334v;
    }

    public NegativeFeedbackExperienceLocation mo2465a() {
        return NegativeFeedbackExperienceLocation.NEWSFEED;
    }

    protected final void mo2466a(Menu menu, FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view) {
        int i = 0;
        Flattenable flattenable = feedProps.f13444a;
        GraphQLNegativeFeedbackActionsConnection t = ((NegativeFeedbackActionsUnit) feedProps.f13444a).mo2894t();
        if (t != null && t.m24597a() != null) {
            int i2;
            GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge;
            ImmutableList a = t.m24597a();
            int size = a.size();
            for (i2 = 0; i2 < size; i2++) {
                graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i2);
                if (f12318r.contains(graphQLNegativeFeedbackActionsEdge.m27648a().m27654b())) {
                    m18410a(menu, (FeedProps) feedProps, graphQLNegativeFeedbackActionsEdge, view);
                }
            }
            i2 = a.size();
            while (i < i2) {
                graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i);
                if (!f12318r.contains(graphQLNegativeFeedbackActionsEdge.m27648a().m27654b())) {
                    m18410a(menu, (FeedProps) feedProps, graphQLNegativeFeedbackActionsEdge, view);
                }
                i++;
            }
        }
    }

    protected final boolean m18392j(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return SeeFirstStateManager.m16870a((GraphQLStory) feedUnit);
        }
        return false;
    }

    public static void m18369a(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, Context context, Menu menu, FeedProps feedProps) {
        String name = FeedStoryMenuActionType.UN_SEE_FIRST.name();
        ImmutableList at = ((GraphQLStory) feedProps.f13444a).at();
        int size = at.size();
        for (int i = 0; i < size; i++) {
            GraphQLActor graphQLActor = (GraphQLActor) at.get(i);
            if (graphQLActor.an() == GraphQLSecondarySubscribeStatus.SEE_FIRST && !graphQLActor.m23768K()) {
                newsFeedStoryMenuHelper.m18367a(context, menu, feedProps, name, graphQLActor);
            }
        }
    }

    private void m18367a(Context context, Menu menu, FeedProps<GraphQLStory> feedProps, String str, GraphQLActor graphQLActor) {
        FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
        GraphQLName as = graphQLActor.as();
        String a = as != null ? GraphQLHelper.m22473a(as) : graphQLActor.aa();
        MenuItem add = menu.add(context.getString(2131233474, new Object[]{a}));
        if (add instanceof MenuItemImpl) {
            ((MenuItemImpl) add).a(m18366a(graphQLActor));
        }
        add.setOnMenuItemClickListener(new 7(this, graphQLActor, feedProps, str, feedUnit));
        m18411a(add, 2130843816, feedUnit);
        m18414a((FeedProps) feedProps, add.getItemId(), str, false);
    }

    private static int m18366a(GraphQLActor graphQLActor) {
        switch (12.a[graphQLActor.m23763F().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 2131233475;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 2131233476;
            default:
                return 2131233477;
        }
    }

    public static boolean m18375k(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        return (graphQLStory.m22340Z() == null || graphQLStory.m22349b() == null || graphQLStory.m22340Z().m24195a().isEmpty() || graphQLStory.m22349b().isEmpty() || newsFeedStoryMenuHelper.f12331L.equals(((GraphQLActor) graphQLStory.m22349b().get(0)).m23765H())) ? false : true;
    }

    public static void m18371b(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, Context context, Menu menu, FeedProps feedProps) {
        String name = FeedStoryMenuActionType.HIDE_TOPIC_FROM_USER.name();
        ImmutableList a = ((GraphQLStory) feedProps.f13444a).m22340Z().m24195a();
        for (int i = 0; i < a.size(); i++) {
            newsFeedStoryMenuHelper.m18368a(context, menu, name, feedProps, (GraphQLExploreFeed) a.get(i));
        }
    }

    private void m18368a(Context context, Menu menu, String str, FeedProps<GraphQLStory> feedProps, GraphQLExploreFeed graphQLExploreFeed) {
        FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
        MenuItem add = menu.add(context.getString(2131233478, new Object[]{graphQLExploreFeed.q(), ((GraphQLActor) feedUnit.m22349b().get(0)).aa()}));
        if (add instanceof MenuItemImpl) {
            ((MenuItemImpl) add).a(context.getString(2131233479, new Object[]{graphQLExploreFeed.q(), r5.aa()}));
        }
        add.setOnMenuItemClickListener(new 8(this, feedProps, str, graphQLExploreFeed, r5, feedUnit));
        m18411a(add, StoryMenuIconUtil.n(), feedUnit);
        m18414a((FeedProps) feedProps, add.getItemId(), str, false);
    }

    protected final boolean mo2479i() {
        return true;
    }

    private static boolean m18376l(FeedUnit feedUnit) {
        if (!(feedUnit instanceof Sponsorable)) {
            return false;
        }
        SponsoredImpression ab_ = ((Sponsorable) feedUnit).ab_();
        if (ab_ != null && ab_.mo3121k() && ab_.f21623v) {
            return true;
        }
        return false;
    }

    protected final void mo2470a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, OperationResult operationResult) {
        if (negativeFeedbackActionsUnit.mo2892r() != null) {
            this.f12335w.m18573a(negativeFeedbackActionsUnit.mo2892r(), graphQLNegativeFeedbackAction.m27654b(), new 9(this, negativeFeedbackActionsUnit));
        }
        this.f12335w.m18574a(negativeFeedbackActionsUnit.mo2892r(), operationResult.f22221c);
    }

    protected final boolean mo2478h() {
        return false;
    }

    public static void m18372d(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, Menu menu, FeedProps feedProps, View view) {
        Preconditions.checkNotNull(feedProps);
        FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
        Preconditions.checkState(m18376l(feedUnit));
        JsonNode b = TrackableFeedProps.m27452b(feedProps);
        Preconditions.checkNotNull(((Sponsorable) feedUnit).ab_());
        HoneyAnalyticsEvent a = new HoneyClientEvent("xout_menu_opened").m5085a("tracking", b);
        a.f3099c = "native_newsfeed";
        newsFeedStoryMenuHelper.f12357i.mo533c(a);
        FeedUnit feedUnit2 = (FeedUnit) feedProps.f13444a;
        CharSequence string = view.getResources().getString(2131233630);
        if (!Strings.isNullOrEmpty(string)) {
            String name = FeedStoryMenuActionType.WHY_AM_I_SEEING_THIS.name();
            MenuItem add = menu.add(string);
            add.setOnMenuItemClickListener(new 10(newsFeedStoryMenuHelper, feedProps, name, view));
            newsFeedStoryMenuHelper.m18414a(feedProps, add.getItemId(), name, false);
            add.setIcon(((Sponsorable) feedUnit2).ab_().f21625x ? 2130840281 : 2130839943);
        }
        newsFeedStoryMenuHelper.m18374f(menu, feedProps, view);
    }
}
