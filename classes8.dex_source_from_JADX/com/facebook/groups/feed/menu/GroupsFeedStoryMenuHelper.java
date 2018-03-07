package com.facebook.groups.feed.menu;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;
import com.facebook.graphql.calls.GroupBlockInputData.Source;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGroupMessageChattableMembersConnection;
import com.facebook.graphql.model.GraphQLGroupMessageChattableMembersEdge;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.groups.composer.composerlauncher.GroupsComposerLauncher;
import com.facebook.groups.feed.data.PinState;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper.C15066;
import com.facebook.groups.feed.menu.common.GroupsDisableCommentsHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: faceweb/f?href=/ads/create/choose_objective/?page_id=%s%%26source_location=promote_action_button */
public class GroupsFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f14078o = new C14911();
    public static final String f14079p = GroupsFeedStoryMenuHelper.class.getSimpleName();
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f14080q = ImmutableSet.of(GraphQLNegativeFeedbackActionType.DONT_LIKE, GraphQLNegativeFeedbackActionType.UNTAG);
    public final Provider<Boolean> f14081A;
    public final AnalyticsLogger f14082r;
    public final GroupsFeedStoryModerationHelper f14083s;
    public final GroupsDisableCommentsHelper f14084t;
    public final Lazy<FbAppType> f14085u;
    private final ViewerStatusCache f14086v;
    private final String f14087w;
    public final Provider<ComponentName> f14088x;
    public final AbstractFbErrorReporter f14089y;
    private final ComposerLauncher f14090z;

    /* compiled from: faceweb/f?href=/ads/create/choose_objective/?page_id=%s%%26source_location=promote_action_button */
    final class C14911 implements Provider<Boolean> {
        C14911() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: faceweb/f?href=/ads/create/choose_objective/?page_id=%s%%26source_location=promote_action_button */
    class GroupsFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        final /* synthetic */ GroupsFeedStoryMenuHelper f14077b;

        public final void m15640a(Menu menu, final FeedProps<GraphQLStory> feedProps, View view) {
            final FeedUnit feedUnit = (GraphQLStory) feedProps.a;
            final Context context = view.getContext();
            if (this.f14077b.m15659n(feedUnit)) {
                MenuItem add = menu.add(2131237822);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14054c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        GroupsFeedStoryMenuHelper groupsFeedStoryMenuHelper = this.f14054c.f14077b;
                        GraphQLStory graphQLStory = feedUnit;
                        Context context = context;
                        String a = GroupsFeedStoryModerationHelper.m15665a(graphQLStory);
                        GraphQLStoryActionLink a2 = StoryActionLinkHelper.a(graphQLStory, 1373114851);
                        if (a != null && a2 != null) {
                            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("group_side_conversation_displayed");
                            honeyClientEvent.c = "group_feed";
                            honeyClientEvent = honeyClientEvent;
                            honeyClientEvent.b("group_id", a);
                            groupsFeedStoryMenuHelper.f14082r.a(honeyClientEvent);
                            Builder builder = ImmutableList.builder();
                            GraphQLGroupMessageChattableMembersConnection H = a2.H();
                            if (H != null) {
                                ImmutableList a3 = H.a();
                                int size = a3.size();
                                for (int i = 0; i < size; i++) {
                                    GraphQLGroupMessageChattableMembersEdge graphQLGroupMessageChattableMembersEdge = (GraphQLGroupMessageChattableMembersEdge) a3.get(i);
                                    if (!(graphQLGroupMessageChattableMembersEdge.a() == null || graphQLGroupMessageChattableMembersEdge.a().H() == null || graphQLGroupMessageChattableMembersEdge.a().aa() == null)) {
                                        UserBuilder a4 = new UserBuilder().a(Type.FACEBOOK, graphQLGroupMessageChattableMembersEdge.a().H());
                                        a4.h = graphQLGroupMessageChattableMembersEdge.a().aa();
                                        builder.c(a4.aa());
                                    }
                                }
                            }
                            Intent component = new Intent().setComponent((ComponentName) groupsFeedStoryMenuHelper.f14088x.get());
                            component.putExtra("group_feed_id", a);
                            component.putExtra("target_fragment", ContentFragmentType.GROUP_CREATE_SIDE_CONVERSATION_FRAGMENT.ordinal());
                            component.putExtra("PRE_SELECT_MEMBERS", builder.b());
                            groupsFeedStoryMenuHelper.d().a(component, context);
                        } else if (a == null) {
                            groupsFeedStoryMenuHelper.f14089y.a(GroupsFeedStoryMenuHelper.f14079p, "Cannot start side conversation from group story. It is missing group id.");
                        } else {
                            groupsFeedStoryMenuHelper.f14089y.a(GroupsFeedStoryMenuHelper.f14079p, "Cannot start side conversation from group story. It is missing action link.");
                        }
                        return true;
                    }
                });
                this.f14077b.a(add, AppGlyphResolver.a(), feedUnit);
            }
            if (a(feedUnit)) {
                b(menu, feedProps);
            }
            if (m15642a(feedUnit)) {
                b(menu, feedProps, view);
            }
            if (this.f14077b.g(feedUnit)) {
                add = menu.add(2131233471);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14057c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14057c.f14077b.m15647a(feedUnit, context);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840013, feedUnit);
            }
            GroupsFeedStoryMenuHelper groupsFeedStoryMenuHelper = this.f14077b;
            if (BaseFeedStoryMenuHelper.h(feedUnit)) {
                add = menu.add(2131233473);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14060c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14060c.f14077b.b(feedUnit, context);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130839800, feedUnit);
            }
            if (c(feedProps)) {
                this.f14077b.a(menu, feedProps, view);
            }
            if (this.f14077b.mo839j(feedUnit)) {
                add = menu.add(2131239413);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14062b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14062b.f14077b.f14083s.m15671a(feedProps, PinState.Pin);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840062, feedUnit);
            }
            if (this.f14077b.mo841l(feedUnit)) {
                add = menu.add(2131239417);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14064b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14064b.f14077b.f14083s.m15671a(feedProps, PinState.Unpin);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840062, feedUnit);
            }
            a(menu, feedProps);
            if (this.f14077b.mo840m(feedUnit)) {
                menu.add(2131239416).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14066b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14066b.f14077b.f14083s.m15672b(feedProps);
                        return true;
                    }
                });
            }
            if (this.f14077b.i(feedUnit)) {
                add = menu.add(2131233440);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14070d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (StoryCommerceHelper.e(feedUnit)) {
                            this.f14070d.f14077b.a(feedProps, context);
                        } else if (((Boolean) this.f14070d.f14077b.f14081A.get()).booleanValue() && StoryCommerceHelper.f(feedUnit)) {
                            this.f14070d.f14077b.b(feedProps, context);
                        } else {
                            this.f14070d.f14077b.f14083s.m15670a(feedProps, context);
                        }
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840135, feedUnit);
            }
            if (this.f14077b.m15650b(feedUnit)) {
                add = menu.add(2131233463);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14073c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper = this.f14073c.f14077b.f14083s;
                        Context context = context;
                        FeedProps feedProps = feedProps;
                        new AlertDialog.Builder(context).b(context.getResources().getString(2131233450)).a(2131233463, new C15066(groupsFeedStoryModerationHelper, (GraphQLStory) feedProps.a, feedProps)).b(2131233563, null).b();
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840135, feedUnit);
                add = menu.add(2131239415);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14076c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14076c.f14077b.f14083s.m15669a(context, feedProps, Source.TREEHOUSE_GROUP_MALL);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840135, feedUnit);
            } else if (this.f14077b.m15652c(feedUnit)) {
                add = menu.add(2131239415);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14046c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14046c.f14077b.f14083s.m15669a(context, feedProps, Source.TREEHOUSE_GROUP_MALL);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840135, feedUnit);
            }
            if (GroupsFeedStoryMenuHelper.m15645k(feedUnit)) {
                add = menu.add(2131239414);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14049c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper = this.f14049c.f14077b.f14083s;
                        groupsFeedStoryModerationHelper.f14125j.a(context, feedUnit);
                        return true;
                    }
                });
                this.f14077b.a(add, 2130840081, feedUnit);
            }
            if (b(feedProps)) {
                a(menu, feedProps, context);
            }
            GroupsDisableCommentsHelper groupsDisableCommentsHelper = this.f14077b.f14084t;
            if (GroupsDisableCommentsHelper.m490a(feedUnit) && this.f14077b.f14084t.m495b(feedUnit) != null) {
                MenuItem add2 = menu.add(this.f14077b.f14084t.m495b(feedUnit));
                add2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ GroupsFeedStoryMenuOptions f14051b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14051b.f14077b.f14084t.m494a(feedProps);
                        return true;
                    }
                });
                this.f14077b.a(add2, 2130839805, feedUnit);
            }
        }

        public final boolean m15641a(FeedProps<GraphQLStory> feedProps) {
            FeedUnit feedUnit = (GraphQLStory) feedProps.a;
            if (!(c(feedProps) || this.f14077b.i(feedUnit) || this.f14077b.g(feedUnit))) {
                GroupsFeedStoryMenuHelper groupsFeedStoryMenuHelper = this.f14077b;
                if (!(BaseFeedStoryMenuHelper.h(feedUnit) || m15642a(feedUnit) || c(feedUnit) || this.f14077b.mo839j(feedUnit) || this.f14077b.mo841l(feedUnit) || this.f14077b.mo840m(feedUnit))) {
                    GroupsDisableCommentsHelper groupsDisableCommentsHelper = this.f14077b.f14084t;
                    if (!GroupsDisableCommentsHelper.m490a(feedUnit)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public GroupsFeedStoryMenuOptions(GroupsFeedStoryMenuHelper groupsFeedStoryMenuHelper) {
            this.f14077b = groupsFeedStoryMenuHelper;
            super(groupsFeedStoryMenuHelper);
        }

        public final boolean m15642a(FeedUnit feedUnit) {
            if (((FbAppType) this.f14077b.f14085u.get()).j == Product.GROUPS) {
                return false;
            }
            return super.a(feedUnit);
        }
    }

    @Inject
    public GroupsFeedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider7, Provider<String> provider8, Provider<Toaster> provider9, Clock clock, GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, GroupsDisableCommentsHelper groupsDisableCommentsHelper, Lazy<FbAppType> lazy, Provider<EditPrivacyIntentBuilder> provider10, Provider<Boolean> provider11, Provider<StoryReviewComposerLauncherAndHandler> provider12, ViewerStatusCache viewerStatusCache, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, @FragmentChromeActivity Provider<ComponentName> provider13, FbErrorReporter fbErrorReporter, Provider<BottomSheetDialog> provider14, @Assisted BaseFeedEnvironment baseFeedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, f14078o, provider5, analyticsLogger, newsFeedAnalyticsEventBuilder, provider7, provider9, clock, provider10, provider11, provider12, graphQLStoryUtil, qeAccessor, provider14, baseFeedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f14082r = analyticsLogger;
        this.f14083s = groupsFeedStoryModerationHelper;
        this.f14084t = groupsDisableCommentsHelper;
        this.f14085u = lazy;
        this.f14086v = viewerStatusCache;
        this.f14090z = composerLauncher;
        this.f14087w = (String) provider8.get();
        this.f14088x = provider13;
        this.f14089y = fbErrorReporter;
        this.f14081A = provider6;
    }

    @Nonnull
    protected final CurationSurface m15649b() {
        return CurationSurface.NATIVE_STORY_GROUP;
    }

    protected final String m15651c() {
        return "group_feed";
    }

    protected final boolean m15648a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return f14080q.contains(graphQLNegativeFeedbackAction.b());
    }

    public final NegativeFeedbackExperienceLocation m15646a() {
        return NegativeFeedbackExperienceLocation.GROUP;
    }

    protected final BaseFeedStoryMenuOptions m15653d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new GroupsFeedStoryMenuOptions(this);
        }
        return super.d(feedUnit);
    }

    protected boolean mo839j(FeedUnit feedUnit) {
        return m15660o(feedUnit);
    }

    protected static boolean m15645k(FeedUnit feedUnit) {
        return StoryActionLinkHelper.a((GraphQLStory) feedUnit, 1464405859) != null;
    }

    protected boolean mo841l(FeedUnit feedUnit) {
        return false;
    }

    protected boolean mo840m(FeedUnit feedUnit) {
        return false;
    }

    protected final boolean m15659n(FeedUnit feedUnit) {
        String a = GroupsFeedStoryModerationHelper.m15665a((GraphQLStory) feedUnit);
        boolean z = (a == null || this.f14086v == null || !this.f14086v.m15639b(a)) ? false : true;
        boolean z2;
        if (StoryActionLinkHelper.a((GraphQLStory) feedUnit, 1373114851) != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    private static int m15643d(GraphQLStory graphQLStory) {
        ImmutableList a = StoryActionLinkHelper.a(graphQLStory);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) a.get(i);
            if (graphQLStoryActionLink.a() != null) {
                int g = graphQLStoryActionLink.a().g();
                if (g == -1486461411) {
                    return -1486461411;
                }
                if (g == -2057370740) {
                    return -2057370740;
                }
            }
        }
        return 0;
    }

    protected final boolean m15650b(GraphQLStory graphQLStory) {
        return m15644e(graphQLStory) && m15643d(graphQLStory) == -2057370740;
    }

    protected final boolean m15652c(GraphQLStory graphQLStory) {
        return m15644e(graphQLStory) && m15643d(graphQLStory) == -1486461411;
    }

    private boolean m15644e(GraphQLStory graphQLStory) {
        boolean z;
        if (StoryActorHelper.b(graphQLStory) == null || StoryActorHelper.b(graphQLStory).H() == null) {
            z = false;
        } else {
            z = StoryActorHelper.b(graphQLStory).H().equals(this.f14087w);
        }
        if (z || !m15660o(graphQLStory)) {
            return false;
        }
        return true;
    }

    protected final boolean m15660o(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        String a = GroupsFeedStoryModerationHelper.m15665a((GraphQLStory) feedUnit);
        if (a == null || this.f14086v == null || !this.f14086v.m15638a(a)) {
            return false;
        }
        return true;
    }

    protected final boolean m15654i() {
        return true;
    }

    protected final void m15647a(GraphQLStory graphQLStory, Context context) {
        ComposerConfiguration a = a(graphQLStory).a();
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        if (activity instanceof FbFragmentActivity) {
            GroupsComposerLauncher groupsComposerLauncher = (GroupsComposerLauncher) ((FbFragmentActivity) activity).a(GroupsComposerLauncher.class);
            if (groupsComposerLauncher != null && groupsComposerLauncher.m438a()) {
                return;
            }
        }
        this.f14090z.a(null, a, 1758, activity);
    }

    protected final ToggleAvailabilitySurface m15655j() {
        return ToggleAvailabilitySurface.GROUP_POST_CHEVRON;
    }
}
