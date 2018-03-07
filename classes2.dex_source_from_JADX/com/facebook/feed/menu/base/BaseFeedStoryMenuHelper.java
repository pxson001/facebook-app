package com.facebook.feed.menu.base;

import android.app.Activity;
import android.content.Context;
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
import com.facebook.attachments.angora.actionbutton.StorySaveTypeResources.StorySaveTypeResource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.GraphQLArticleChainingFeedUnitMenuOptions;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.GraphQLArticleChainingFeedUnitMenuOptions.1;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.GraphQLArticleChainingFeedUnitMenuOptions.2;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.api.FeedMenuHelper.IFeedUnitMenuOptions;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents$StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsConnection;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.negativefeedback.video.ui.SystemUIAwareDialogHelper;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.zero.common.constants.AssistedOnboardingConst.LinkSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: new_android_ci_invite_all_only */
public abstract class BaseFeedStoryMenuHelper {
    public static final Class<?> f12339o = BaseFeedStoryMenuHelper.class;
    public final Provider<StoryReviewComposerLauncherAndHandler> f12340A;
    public final QeAccessor f12341B;
    public final XConfigReader f12342C;
    public FeedEnvironment f12343D;
    private final OptimisticStoryStateCache f12344E;
    private Provider<BottomSheetDialog> f12345F;
    public final ControllerMutationGatekeepers f12346G;
    public final GraphQLQueryExecutor f12347H;
    public final SetNotifyMeLegacyMutationProvider f12348I;
    protected final Provider<GraphPostService> f12349a;
    protected final DefaultAndroidThreadUtil f12350b;
    public final FeedEventBus f12351c;
    public final Provider<Toaster> f12352d;
    protected final Map<String, IFeedUnitMenuOptions> f12353e = Maps.m838c();
    public final Provider<Boolean> f12354f;
    protected final Provider<Boolean> f12355g;
    protected final Provider<Boolean> f12356h;
    public final AnalyticsLogger f12357i;
    public final NewsFeedAnalyticsEventBuilder f12358j;
    protected final Provider<TriState> f12359k;
    public final GraphQLStoryUtil f12360l;
    protected boolean f12361m;
    protected final RapidReportingController f12362n;
    private final Provider<SecureContextHelper> f12363p;
    private final Provider<IFeedIntentBuilder> f12364q;
    private final ComposerLauncher f12365r;
    private final TasksManager f12366s;
    public final ProductItemUpdateAvailabilityHelper f12367t;
    public final ObjectMapper f12368u;
    public final SaveButtonUtils f12369v;
    public final SaveAnalyticsLogger f12370w;
    private final Clock f12371x;
    private final Provider<EditPrivacyIntentBuilder> f12372y;
    public final Provider<Boolean> f12373z;

    @VisibleForTesting
    /* compiled from: new_android_ci_invite_all_only */
    public class BaseFeedStoryMenuOptions<T extends FeedUnit> {
        public final /* synthetic */ BaseFeedStoryMenuHelper f21763a;

        public void m29482a(Menu menu, FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
            if (!((Boolean) this.f21763a.f12373z.get()).booleanValue()) {
                return;
            }
            if (m29477b(graphQLStory)) {
                mo3189c(menu, feedProps);
                return;
            }
            Flattenable L = graphQLStory.m22326L();
            FeedProps a = feedProps.m19803a(L);
            if (L != null) {
                m29482a(menu, a);
            }
        }

        public final void m29483a(Menu menu, FeedProps<GraphQLStory> feedProps, Context context) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            MenuItem add = menu.add(2131232720);
            String name = LinkSource.COPY_LINK.name();
            this.f21763a.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 1(this, feedProps, name, context));
            this.f21763a.m18411a(add, 2130839954, feedUnit);
        }

        public void mo3187a(Menu menu, FeedProps<T> feedProps, View view) {
            FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
            if (m29492b(feedUnit)) {
                Context context = view.getContext();
                MenuItem add = menu.add(this.f21763a.mo2477g() != null ? "Report issue to Feed Team (FB Only)" : "Mail story debug info (FB Only)");
                add.setOnMenuItemClickListener(new 4(this, context, feedUnit));
                this.f21763a.m18411a(add, 2130840081, feedUnit);
            }
        }

        public boolean mo3188a(FeedProps<T> feedProps) {
            return m29492b((FeedUnit) feedProps.f13444a);
        }

        protected final void m29488b(Menu menu, FeedProps<GraphQLStory> feedProps) {
            String name;
            int i;
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            boolean dV = ((GraphQLStoryAttachment) Iterables.m973f(feedUnit.m22367x(), new 7(this))).m23987z().dV();
            int i2 = dV ? 2131237863 : 2131237862;
            if (dV) {
                name = FeedStoryMenuActionType.MARK_AS_AVAILABLE.name();
            } else {
                name = FeedStoryMenuActionType.MARK_AS_SOLD.name();
            }
            MenuItem add = menu.add(i2);
            this.f21763a.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 8(this, feedProps, name));
            if (dV) {
                i = 2130839777;
            } else {
                i = 2130839760;
            }
            this.f21763a.m18411a(add, i, feedUnit);
        }

        protected final void m29489b(Menu menu, FeedProps<GraphQLStory> feedProps, Context context) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            MenuItem add = menu.add(2131233472);
            String name = FeedStoryMenuActionType.EDIT_REVIEW.name();
            int itemId = add.getItemId();
            this.f21763a.m18414a((FeedProps) feedProps, itemId, name, false);
            add.setOnMenuItemClickListener(new 5(this, feedProps, itemId, name, feedUnit, context));
            this.f21763a.m18411a(add, 2130840013, feedUnit);
        }

        protected BaseFeedStoryMenuOptions(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper) {
            this.f21763a = baseFeedStoryMenuHelper;
        }

        public boolean m29491b(FeedProps<GraphQLStory> feedProps) {
            return GraphQLStoryUtil.m9586q((FeedProps) feedProps) != null;
        }

        public boolean m29486a(FeedUnit feedUnit) {
            if (!(feedUnit instanceof GraphQLStory)) {
                return false;
            }
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            if (graphQLStory.as() == null || !GraphQLHelper.m22485a(graphQLStory.as())) {
                return false;
            }
            return true;
        }

        public final void m29490b(Menu menu, FeedProps<GraphQLStory> feedProps, View view) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
            String c = this.f21763a.mo2474c();
            GraphQLStorySaveInfo as = feedUnit.as();
            StorySaveTypeResource a;
            if (as.m24778m() != GraphQLSavedState.SAVED) {
                MenuItem add;
                this.f21763a.f12370w.m13124a(c, feedUnit.m22350c(), this.f21763a.mo2472b());
                String name = FeedStoryMenuActionType.SAVE.name();
                a = this.f21763a.f12369v.m18466a(as.m24777l());
                add = menu.add(a.f12404a);
                if (add instanceof MenuItemImpl) {
                    ((MenuItemImpl) add).a(a.f12405b);
                }
                add.setOnMenuItemClickListener(new 2(this, feedProps, name, view));
                this.f21763a.m18411a(add, 2130839719, feedUnit);
                this.f21763a.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
                return;
            }
            this.f21763a.f12370w.m13124a(c, feedUnit.m22350c(), this.f21763a.mo2472b());
            name = FeedStoryMenuActionType.UNSAVE.name();
            a = this.f21763a.f12369v.m18466a(as.m24777l());
            add = menu.add(a.f12406c);
            if (add instanceof MenuItemImpl) {
                ((MenuItemImpl) add).a(a.f12407d);
            }
            add.setOnMenuItemClickListener(new 3(this, feedProps, name));
            add.setCheckable(true);
            add.setChecked(true);
            this.f21763a.m18411a(add, 2130839719, feedUnit);
            this.f21763a.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
        }

        public ComposerSourceType m29481a() {
            return ComposerSourceType.PERMALINK;
        }

        @VisibleForTesting
        public boolean m29492b(FeedUnit feedUnit) {
            if (feedUnit.S_() == null || this.f21763a.f12359k == null || this.f21763a.f12359k.get() != TriState.YES) {
                return false;
            }
            return true;
        }

        public static String m29479d(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedUnit feedUnit) {
            StringBuilder stringBuilder = new StringBuilder("The data below can be used to debug the selected feed story. If available, the value in 'serialized' field can be used to reproduce it.");
            stringBuilder.append("\n\n");
            stringBuilder.append(feedUnit.S_());
            stringBuilder.append("\n\n");
            try {
                stringBuilder.append(baseFeedStoryMenuOptions.f21763a.f12368u.m6670g().a().a(feedUnit));
            } catch (JsonProcessingException e) {
                stringBuilder.append("Exception occured while converting FeedUnit to JSON: " + e.getMessage());
            }
            return stringBuilder.toString();
        }

        private static boolean m29477b(GraphQLStory graphQLStory) {
            return (graphQLStory.mo2890l() == null || !graphQLStory.mo2890l().m23248o() || graphQLStory.m22350c() == null || graphQLStory.m22350c().isEmpty()) ? false : true;
        }

        private void mo3189c(Menu menu, FeedProps<GraphQLStory> feedProps) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.m19804a();
            boolean A = feedUnit.mo2890l().m23207A();
            String ai = feedUnit.ai();
            String j = feedUnit.mo2890l().mo2933j();
            String z_ = feedUnit.mo2890l().z_();
            String g = feedUnit.mo2507g();
            String c = feedUnit.m22350c();
            String g2 = BaseFeedStoryMenuHelper.m18403d((FeedProps) feedProps) ? feedUnit.mo2507g() : mo3191d(feedProps);
            int i = A ? 2131233470 : 2131233469;
            String name = A ? FeedStoryMenuActionType.TURN_OFF_NOTIFICATION.name() : FeedStoryMenuActionType.TURN_ON_NOTIFICATION.name();
            MenuItem add = menu.add(i);
            this.f21763a.m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 6(this, feedProps, name, feedUnit, A, ai, j, z_, c, g, g2));
            this.f21763a.m18411a(add, StoryMenuIconUtil.c(), feedUnit);
        }

        private static String mo3191d(FeedProps<GraphQLStory> feedProps) {
            GraphQLStorySet h = StoryProps.m27460h(feedProps);
            if (h != null) {
                return h.mo2507g();
            }
            GraphQLStory d = StoryProps.m27457d(feedProps);
            if (d != null) {
                return d.mo2507g();
            }
            return null;
        }

        protected final boolean m29494c(FeedUnit feedUnit) {
            if (!(feedUnit instanceof GraphQLStory) || !((Boolean) this.f21763a.f12373z.get()).booleanValue()) {
                return false;
            }
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            return m29477b(graphQLStory) || m29494c(graphQLStory.m22326L());
        }

        @VisibleForTesting
        public boolean mo3190c(FeedProps<? extends FeedUnit> feedProps) {
            FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
            if (!(feedUnit instanceof NegativeFeedbackActionsUnit)) {
                return false;
            }
            NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedUnit;
            if (((Boolean) this.f21763a.f12354f.get()).booleanValue() && negativeFeedbackActionsUnit.mo2881q() != null) {
                Object obj;
                BaseFeedStoryMenuHelper baseFeedStoryMenuHelper = this.f21763a;
                GraphQLNegativeFeedbackActionsConnection t = negativeFeedbackActionsUnit.mo2894t();
                if (t == null || t.m24597a() == null || t.m24597a().isEmpty()) {
                    obj = null;
                } else {
                    ImmutableList a = t.m24597a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i);
                        if (graphQLNegativeFeedbackActionsEdge.m27648a() != null && baseFeedStoryMenuHelper.mo2471a(negativeFeedbackActionsUnit, graphQLNegativeFeedbackActionsEdge.m27648a())) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                }
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }

        public boolean m29487a(GraphQLStory graphQLStory) {
            return StoryCommerceHelper.c(graphQLStory);
        }
    }

    public abstract NegativeFeedbackExperienceLocation mo2465a();

    public abstract boolean mo2471a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction);

    public abstract CurationSurface mo2472b();

    protected abstract String mo2474c();

    private void m18395a(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        String q = negativeFeedbackActionsUnit.mo2881q();
        String c = mo2474c();
        HoneyAnalyticsEvent b = new HoneyClientEvent("story_hidden").m5090b("hideable_token", q);
        b.f3099c = c;
        HoneyAnalyticsEvent honeyAnalyticsEvent = b;
        if (negativeFeedbackActionsUnit.mo2881q() == null) {
            this.f12357i.mo526a(honeyAnalyticsEvent);
            return;
        }
        this.f12350b.m1651a(((GraphPostService) this.f12349a.get()).m18478a(feedProps, graphQLNegativeFeedbackAction, mo2465a().stringValueOf(), ""), new 5(this, negativeFeedbackActionsUnit, view, honeyAnalyticsEvent, graphQLNegativeFeedbackAction));
    }

    private void m18396a(GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, FeedProps<NegativeFeedbackActionsUnit> feedProps, Context context) {
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        m18432e().mo3016a(context, StringLocaleUtil.m21640a(FBLinks.cA, negativeFeedbackActionsUnit.mo2881q(), negativeFeedbackActionsUnit.mo2892r(), graphQLNegativeFeedbackActionsEdge.m27648a().m27654b().name(), mo2465a().stringValueOf(), TrackableFeedProps.m27452b(feedProps).toString()));
    }

    private void m18398b(GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view) {
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        GraphQLNegativeFeedbackActionType b = graphQLNegativeFeedbackActionsEdge.m27648a().m27654b();
        FeedUnit feedUnit = (NegativeFeedbackActionsUnit) FeedUnitMutator.a(negativeFeedbackActionsUnit).a(b).a();
        FeedProps b2 = feedProps.m19805b(feedUnit);
        if (b.equals(GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM)) {
            m18426b(b2, view);
            if (feedUnit.mo2892r() == null) {
                m18396a(graphQLNegativeFeedbackActionsEdge, b2, view.getContext());
            }
        } else if (b.equals(GraphQLNegativeFeedbackActionType.DONT_LIKE)) {
            if (feedUnit.mo2892r() != null) {
                boolean z = false;
                if (mo2465a() == NegativeFeedbackExperienceLocation.TIMELINE_SELF || mo2465a() == NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE) {
                    z = this.f12341B.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6723m, false);
                }
                if (z) {
                    m18401c(b2, view);
                }
            }
            m18396a(graphQLNegativeFeedbackActionsEdge, b2, view.getContext());
        } else {
            m18418a(feedUnit, view);
        }
        if (!b.equals(GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM)) {
            m18395a(b2, view, graphQLNegativeFeedbackActionsEdge.m27648a());
        }
    }

    public static void m18400c(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        baseFeedStoryMenuHelper.f12366s.m14553a("toggle_availability" + graphQLStory.m22350c(), baseFeedStoryMenuHelper.f12367t.m18446a(graphQLStory, ToggleAvailabilitySurface.DELETE_INTERCEPT), new 10(baseFeedStoryMenuHelper, feedProps));
    }

    public void mo2466a(Menu menu, FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view) {
        Flattenable flattenable = feedProps.f13444a;
        GraphQLNegativeFeedbackActionsConnection t = ((NegativeFeedbackActionsUnit) feedProps.f13444a).mo2894t();
        if (t != null && t.m24597a() != null) {
            ImmutableList a = t.m24597a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i);
                GraphQLNegativeFeedbackAction a2 = graphQLNegativeFeedbackActionsEdge.m27648a();
                if (a2 == null || a2.m27654b() != GraphQLNegativeFeedbackActionType.HIDE || mo2465a() != NegativeFeedbackExperienceLocation.SEARCH_RESULTS) {
                    m18410a(menu, (FeedProps) feedProps, graphQLNegativeFeedbackActionsEdge, view);
                }
            }
        }
    }

    public void mo2467a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        this.f12351c.mo651a(new HideEvents$StoryDeleteEvent(feedProps));
        this.f12351c.mo651a(new HideEvents$ChangeRendererEvent());
        this.f12350b.m1651a(((GraphPostService) this.f12349a.get()).m18479a(graphQLStory), new 11(this, graphQLStory));
    }

    public BaseFeedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider7, Provider<Toaster> provider8, Clock clock, Provider<EditPrivacyIntentBuilder> provider9, Provider<Boolean> provider10, Provider<StoryReviewComposerLauncherAndHandler> provider11, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider12, FeedEnvironment feedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        this.f12363p = provider;
        this.f12364q = provider2;
        this.f12365r = composerLauncher;
        this.f12366s = tasksManager;
        this.f12367t = productItemUpdateAvailabilityHelper;
        this.f12368u = objectMapper;
        this.f12369v = saveButtonUtils;
        this.f12370w = saveAnalyticsLogger;
        this.f12349a = provider3;
        this.f12350b = androidThreadUtil;
        this.f12351c = feedEventBus;
        this.f12354f = provider4;
        this.f12355g = provider5;
        this.f12356h = provider6;
        this.f12371x = clock;
        this.f12340A = provider11;
        this.f12372y = provider9;
        this.f12358j = (NewsFeedAnalyticsEventBuilder) Preconditions.checkNotNull(newsFeedAnalyticsEventBuilder);
        this.f12357i = (AnalyticsLogger) Preconditions.checkNotNull(analyticsLogger);
        this.f12359k = provider7;
        this.f12352d = provider8;
        this.f12373z = provider10;
        this.f12360l = graphQLStoryUtil;
        this.f12345F = provider12;
        this.f12343D = feedEnvironment;
        this.f12341B = qeAccessor;
        this.f12344E = optimisticStoryStateCache;
        this.f12342C = xConfigReader;
        this.f12362n = rapidReportingController;
        this.f12346G = controllerMutationGatekeepers;
        this.f12347H = graphQLQueryExecutor;
        this.f12348I = setNotifyMeLegacyMutationProvider;
    }

    public final SecureContextHelper m18430d() {
        return (SecureContextHelper) this.f12363p.get();
    }

    public final IFeedIntentBuilder m18432e() {
        return (IFeedIntentBuilder) this.f12364q.get();
    }

    public BaseFeedStoryMenuOptions m18406a(FeedUnit feedUnit) {
        String c = mo2475c(feedUnit);
        BaseFeedStoryMenuOptions baseFeedStoryMenuOptions = (BaseFeedStoryMenuOptions) this.f12353e.get(c);
        if (baseFeedStoryMenuOptions == null) {
            baseFeedStoryMenuOptions = mo2476d(feedUnit);
            if (baseFeedStoryMenuOptions != null) {
                this.f12353e.put(c, baseFeedStoryMenuOptions);
            }
        }
        return baseFeedStoryMenuOptions;
    }

    protected GraphQLArticleChainingFeedUnitMenuOptions mo2473b(FeedUnit feedUnit) {
        return null;
    }

    protected String mo2475c(FeedUnit feedUnit) {
        return feedUnit.getClass().getName();
    }

    protected BaseFeedStoryMenuOptions mo2476d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new BaseFeedStoryMenuOptions(this);
        }
        return null;
    }

    public FeedEnvironment m18434f() {
        return this.f12343D;
    }

    public final void m18412a(FeedEnvironment feedEnvironment) {
        this.f12343D = feedEnvironment;
    }

    public Provider<BugReporter> mo2477g() {
        return null;
    }

    public final boolean m18433e(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        return (!((Boolean) this.f12355g.get()).booleanValue() || graphQLStory.m22350c() == null || graphQLStory.mo2507g() == null || GraphQLStoryHelper.m10201c(graphQLStory) == null || !GraphQLStoryHelper.m10201c(graphQLStory).m23512a() || GraphQLStoryHelper.m10202d(graphQLStory) || GraphQLStoryUtil.m9590s(graphQLStory)) ? false : true;
    }

    public final boolean m18435f(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (m18399b(graphQLStory) && GraphQLStoryUtil.m9590s(graphQLStory)) {
            return true;
        }
        return false;
    }

    public final boolean m18437g(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (!m18399b(graphQLStory) || GraphQLStoryUtil.m9590s(graphQLStory)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m18399b(com.facebook.graphql.model.GraphQLStory r5) {
        /*
        r4 = this;
        r0 = r5.ai();
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r0 = r4.f12344E;
        r0 = r0.m9730b(r5);
        if (r0 != 0) goto L_0x003b;
    L_0x000e:
        r0 = r5.m22330P();
        if (r0 == 0) goto L_0x003b;
    L_0x0014:
        r0 = com.facebook.graphql.model.PropertyHelper.m21282a(r5);
        if (r0 != 0) goto L_0x003b;
    L_0x001a:
        r1 = 0;
        r2 = com.facebook.graphql.model.StoryAttachmentHelper.m28029a(r5);
        if (r2 != 0) goto L_0x003d;
    L_0x0021:
        r0 = r1;
        if (r0 != 0) goto L_0x0039;
    L_0x0024:
        r1 = 0;
        r2 = com.facebook.graphql.model.StoryAttachmentHelper.m28039l(r5);
        if (r2 == 0) goto L_0x0036;
    L_0x002b:
        r2 = r4.f12341B;
        r3 = com.facebook.composer.abtest.ExperimentsForComposerAbTestModule.P;
        r2 = r2.mo596a(r3, r1);
        if (r2 != 0) goto L_0x0036;
    L_0x0035:
        r1 = 1;
    L_0x0036:
        r0 = r1;
        if (r0 != 0) goto L_0x003b;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        return r0;
    L_0x003b:
        r0 = 0;
        goto L_0x003a;
    L_0x003d:
        r2 = com.facebook.graphql.model.StoryAttachmentHelper.m28042o(r5);
        r3 = r2.m23987z();
        if (r3 == 0) goto L_0x0064;
    L_0x0047:
        r3 = r2.m23987z();
        r3 = r3.m23390j();
        if (r3 == 0) goto L_0x0064;
    L_0x0051:
        r2 = r2.m23987z();
        r2 = r2.m23390j();
        r2 = r2.m22301g();
        r3 = 1814734639; // 0x6c2aa72f float:8.252276E26 double:8.965980414E-315;
        if (r2 != r3) goto L_0x0021;
    L_0x0062:
        r1 = 1;
        goto L_0x0021;
    L_0x0064:
        r3 = r2.m23984w();
        if (r3 == 0) goto L_0x0021;
    L_0x006a:
        r1 = r2.m23984w();
        r2 = com.facebook.graphql.enums.GraphQLStoryAttachmentStyle.SOUVENIR;
        r1 = r1.contains(r2);
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.b(com.facebook.graphql.model.GraphQLStory):boolean");
    }

    public void m18417a(FeedUnit feedUnit, Context context) {
        if (feedUnit instanceof GraphQLStory) {
            ((SecureContextHelper) this.f12363p.get()).mo660a(((EditPrivacyIntentBuilder) this.f12372y.get()).a((GraphQLStory) feedUnit), 1856, (Activity) ContextUtils.m2500a(context, Activity.class));
        }
    }

    public static boolean m18404h(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (StringUtil.m3589a(graphQLStory.m22350c()) || !GraphQLHelper.m22515l(graphQLStory) || PropertyHelper.m21282a(graphQLStory)) {
            return false;
        }
        return true;
    }

    public void m18427b(FeedUnit feedUnit, Context context) {
        m18419a(feedUnit, "native_newsfeed", context);
    }

    protected final void m18419a(FeedUnit feedUnit, String str, Context context) {
        if (m18404h(feedUnit)) {
            ((SecureContextHelper) this.f12363p.get()).mo662a(((IFeedIntentBuilder) this.f12364q.get()).mo3009a((GraphQLStory) feedUnit, str.toString()), context);
        }
    }

    public void mo2468a(FeedProps<? extends Flattenable> feedProps, View view) {
        m18397a((BottomSheetDialog) this.f12345F.get(), (FeedProps) feedProps, view);
    }

    private boolean m18402c(Menu menu, FeedProps<? extends Flattenable> feedProps, View view) {
        if (!(feedProps.f13444a instanceof GraphQLStoryAttachment) || !(feedProps.m19807c() instanceof FeedUnit)) {
            return false;
        }
        FeedUnit feedUnit = (FeedUnit) feedProps.m19807c();
        Flattenable flattenable = feedProps.f13444a;
        GraphQLArticleChainingFeedUnitMenuOptions b = mo2473b(feedUnit);
        if (b == null) {
            return false;
        }
        if (feedProps.m19808d().size() == 2) {
            flattenable = (Flattenable) feedProps.m19808d().get(1);
            if (flattenable instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) flattenable;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
                MenuItem add = menu.add(2131233430);
                add.setIcon(2130839920);
                add.setOnMenuItemClickListener(new 1(b, graphQLStory, graphQLStoryAttachment, feedProps));
                add = menu.add(2131233431);
                add.setIcon(2130840081);
                add.setOnMenuItemClickListener(new 2(b, graphQLStory, graphQLStoryAttachment, feedProps));
            }
        }
        return true;
    }

    private void m18397a(BottomSheetDialog bottomSheetDialog, FeedProps<? extends Flattenable> feedProps, View view) {
        Activity activity = (Activity) ContextUtils.m2500a(bottomSheetDialog.getContext(), Activity.class);
        if (activity != null && !activity.isFinishing()) {
            Object obj;
            activity.getApplication().registerActivityLifecycleCallbacks(new 1(this, activity, bottomSheetDialog));
            Menu bottomSheetAdapter = new BottomSheetAdapter(activity);
            if (feedProps.f13444a instanceof FeedUnit) {
                BaseFeedStoryMenuOptions a = m18406a((FeedUnit) feedProps.f13444a);
                if (a == null) {
                    obj = null;
                } else {
                    a.mo3187a(bottomSheetAdapter, (FeedProps) feedProps, view);
                    obj = 1;
                }
            } else {
                obj = null;
            }
            if (obj != null || m18402c(bottomSheetAdapter, feedProps, view)) {
                bottomSheetDialog.a(bottomSheetAdapter);
                SystemUIAwareDialogHelper.a(bottomSheetDialog);
            }
        }
    }

    public void mo2469a(GraphQLStory graphQLStory, Context context) {
        this.f12365r.mo1955a(null, m18407a(graphQLStory).a(), 1758, (Activity) ContextUtils.m2500a(context, Activity.class));
    }

    protected Builder m18407a(GraphQLStory graphQLStory) {
        return m18432e().mo3021b(graphQLStory);
    }

    public final void m18410a(Menu menu, FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, View view) {
        FeedUnit feedUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        if (graphQLNegativeFeedbackActionsEdge.m27648a() != null && mo2471a((NegativeFeedbackActionsUnit) feedUnit, graphQLNegativeFeedbackActionsEdge.m27648a())) {
            MenuItem add = menu.add(0, graphQLNegativeFeedbackActionsEdge.m27648a().m27654b().ordinal(), 0, graphQLNegativeFeedbackActionsEdge.m27648a().m27664s().mo2911a());
            CharSequence a = m18408a(view.getContext(), graphQLNegativeFeedbackActionsEdge.m27648a());
            if (a != null && (add instanceof MenuItemImpl)) {
                ((MenuItemImpl) add).a(a);
            }
            String name = graphQLNegativeFeedbackActionsEdge.m27648a().m27654b().name();
            GraphQLNegativeFeedbackActionType b = graphQLNegativeFeedbackActionsEdge.m27648a().m27654b();
            m18414a((FeedProps) feedProps, add.getItemId(), name, false);
            add.setOnMenuItemClickListener(new 2(this, feedProps, name, graphQLNegativeFeedbackActionsEdge, view));
            m18411a(add, StoryMenuIconUtil.a(b), feedUnit);
        }
    }

    @Nullable
    protected String m18408a(Context context, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        String a = graphQLNegativeFeedbackAction.m27661p() == null ? null : graphQLNegativeFeedbackAction.m27661p().mo2911a();
        switch (12.a[graphQLNegativeFeedbackAction.m27654b().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
                return m18393a(context, graphQLNegativeFeedbackAction, a);
            default:
                return a;
        }
    }

    private static String m18393a(Context context, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, String str) {
        switch (12.b[graphQLNegativeFeedbackAction.m27663r().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return BuildConstants.j ? context.getString(2131233527) : context.getString(2131233526);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return context.getString(2131233529);
            case 3:
                return context.getString(2131233528);
            default:
                return str;
        }
    }

    public final void m18426b(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view) {
        m18401c((FeedProps) feedProps, view);
    }

    private void m18401c(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, View view) {
        this.f12362n.m18612a(view.getContext(), feedProps, mo2465a().stringValueOf(), view.getMeasuredHeight());
    }

    protected boolean mo2478h() {
        return true;
    }

    protected boolean mo2479i() {
        return false;
    }

    public final void m18418a(FeedUnit feedUnit, View view) {
        if ((feedUnit instanceof FollowUpFeedUnit) && PropertyHelper.m21286a((FollowUpFeedUnit) feedUnit)) {
            FeedUnitCommon feedUnitCommon = (HideableUnit) feedUnit;
            long a = this.f12371x.mo211a();
            StoryVisibility storyVisibility = StoryVisibility.CONTRACTING;
            int measuredHeight = view.getMeasuredHeight();
            FetchTimeMsHelper.m22314a(feedUnitCommon, a);
            FeedUnitMutator.a(feedUnitCommon, storyVisibility);
            FeedUnitMutator.a(feedUnitCommon, measuredHeight);
        } else {
            this.f12351c.mo651a(new HideEvents$StoryVisibilityEvent(feedUnit.mo2507g(), null, null, mo2465a() == NegativeFeedbackExperienceLocation.PERMALINK ? StoryVisibility.HIDDEN : StoryVisibility.CONTRACTING, view.getMeasuredHeight()));
        }
        this.f12351c.mo651a(new HideEvents$ChangeRendererEvent());
    }

    protected void mo2470a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, OperationResult operationResult) {
    }

    public final boolean m18440i(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (!graphQLStory.m22329O()) {
            return false;
        }
        if (graphQLStory.m22350c() == null && this.f12344E.m9730b(graphQLStory)) {
            return false;
        }
        return true;
    }

    protected ToggleAvailabilitySurface m18441j() {
        return ToggleAvailabilitySurface.FEED_POST_CHEVRON;
    }

    public final void m18414a(FeedProps<? extends FeedUnit> feedProps, int i, String str, boolean z) {
        if (this.f12361m) {
            boolean a;
            boolean z2;
            FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
            if (feedUnit instanceof GraphQLStory) {
                boolean z3;
                a = GraphQLStoryUtil.m9567a((FeedProps) feedProps);
                GraphQLStoryUtil graphQLStoryUtil = this.f12360l;
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (graphQLStory == null || StoryActorHelper.m27492b(graphQLStory) == null || !((String) graphQLStoryUtil.f5606e.get()).equals(StoryActorHelper.m27492b(graphQLStory).m23765H())) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                z2 = z3;
            } else if (feedUnit instanceof GraphQLStorySet) {
                a = ((GraphQLStorySet) feedUnit).mo2895u();
                z2 = false;
            } else {
                return;
            }
            this.f12357i.mo526a(NewsFeedAnalyticsEventBuilder.m14107a(str, i, z, false, a, z2, TrackableFeedProps.m27452b(feedProps)));
        }
    }

    public final void m18411a(MenuItem menuItem, int i, FeedUnit feedUnit) {
        if (mo2479i()) {
            menuItem.setIcon(i);
        }
    }

    public final void m18415a(FeedProps<GraphQLStory> feedProps, Context context) {
        boolean booleanValue = ((Boolean) this.f12356h.get()).booleanValue();
        int i = booleanValue ? 2131237875 : 2131233445;
        AlertDialog.Builder b = new FbAlertDialogBuilder(context).b(context.getResources().getString(i)).a(booleanValue ? 2131237872 : 2131237862, new 7(this, booleanValue, feedProps)).c(booleanValue ? 2131237873 : 2131233456, new 6(this, feedProps)).b(2131233563, null);
        if (booleanValue) {
            b.a(context.getResources().getString(2131237874));
        }
        b.b();
    }

    public final void m18425b(FeedProps<GraphQLStory> feedProps, Context context) {
        new AlertDialog.Builder(context).b(context.getResources().getString(2131237876)).a(2131230735, new 9(this, feedProps)).c(2131230727, null).b(2131230736, new 8(this, feedProps)).b();
    }

    public static boolean m18403d(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory c = StoryProps.m27456c(feedProps);
        return c != null && StoryHierarchyHelper.m27437d(c) && StoryProps.m27456c(StoryProps.m27455b(feedProps)) == null;
    }
}
