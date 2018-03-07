package com.facebook.events.feed.ui;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.events.data.EventAdminStatusRecord;
import com.facebook.events.feed.ui.EventFeedStoryModerationHelper.C24581;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.CanPinAndUnpinPosts;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
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
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.TokenCachingStrategy.Token */
public class EventFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f17415o = new C24531();
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f17416p = ImmutableSet.of(GraphQLNegativeFeedbackActionType.DONT_LIKE, GraphQLNegativeFeedbackActionType.UNTAG);
    public final Provider<EventFeedStoryModerationHelper> f17417q;
    public final Lazy<EventAdminStatusRecord> f17418r;
    public final CanPinAndUnpinPosts f17419s;

    /* compiled from: com.facebook.TokenCachingStrategy.Token */
    final class C24531 implements Provider<Boolean> {
        C24531() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: com.facebook.TokenCachingStrategy.Token */
    public class EventsFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        public final /* synthetic */ EventFeedStoryMenuHelper f17414b;

        public final void m17777a(Menu menu, final FeedProps<GraphQLStory> feedProps, View view) {
            Object obj;
            final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            final Context context = view.getContext();
            if (a(graphQLStory)) {
                b(menu, feedProps, view);
            }
            if (graphQLStory.aJ() == null || graphQLStory.aJ().j() == null || graphQLStory.aJ().j().g() != 67338874 || !((EventAdminStatusRecord) this.f17414b.f17418r.get()).c(graphQLStory.aJ().b())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                final boolean b = ((EventAdminStatusRecord) this.f17414b.f17418r.get()).b(graphQLStory.c(), graphQLStory.aJ().b());
                MenuItem add = menu.add(b ? 2131241906 : 2131241905);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EventsFeedStoryMenuOptions f17404d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (b) {
                            this.f17404d.f17414b.f17419s.b(graphQLStory, context);
                        } else {
                            this.f17404d.f17414b.f17419s.a(graphQLStory, context);
                        }
                        return true;
                    }
                });
                this.f17414b.a(add, 2130839719, graphQLStory);
            }
            if (this.f17414b.g(graphQLStory)) {
                add = menu.add(2131233471);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EventsFeedStoryMenuOptions f17407c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f17407c.f17414b.a(graphQLStory, context);
                        return true;
                    }
                });
                this.f17414b.a(add, 2130840013, graphQLStory);
            }
            EventFeedStoryMenuHelper eventFeedStoryMenuHelper = this.f17414b;
            if (BaseFeedStoryMenuHelper.h(graphQLStory)) {
                add = menu.add(2131233473);
                this.f17414b.a(add, 2130839800, graphQLStory);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EventsFeedStoryMenuOptions f17410c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f17410c.f17414b.b(graphQLStory, context);
                        return true;
                    }
                });
            }
            if (c(feedProps)) {
                this.f17414b.a(menu, feedProps, view);
            }
            if (this.f17414b.i(graphQLStory)) {
                add = menu.add(2131233440);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EventsFeedStoryMenuOptions f17413c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        EventFeedStoryModerationHelper eventFeedStoryModerationHelper = (EventFeedStoryModerationHelper) this.f17413c.f17414b.f17417q.get();
                        FeedProps feedProps = feedProps;
                        Context context = context;
                        new Builder(context).b(context.getResources().getString(2131233442)).a(2131233456, new C24581(eventFeedStoryModerationHelper, feedProps)).b(2131233563, null).b();
                        return true;
                    }
                });
                this.f17414b.a(add, 2130840135, graphQLStory);
            }
            a(menu, feedProps);
            if (b(feedProps)) {
                a(menu, feedProps, context);
            }
        }

        public final boolean m17778a(FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (!(c(feedProps) || this.f17414b.i(graphQLStory) || this.f17414b.g(graphQLStory))) {
                EventFeedStoryMenuHelper eventFeedStoryMenuHelper = this.f17414b;
                if (!(BaseFeedStoryMenuHelper.h(graphQLStory) || a(graphQLStory) || c(graphQLStory))) {
                    return false;
                }
            }
            return true;
        }

        public EventsFeedStoryMenuOptions(EventFeedStoryMenuHelper eventFeedStoryMenuHelper) {
            this.f17414b = eventFeedStoryMenuHelper;
            super(eventFeedStoryMenuHelper);
        }
    }

    @Inject
    public EventFeedStoryMenuHelper(@Assisted CanPinAndUnpinPosts canPinAndUnpinPosts, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider5, Provider<Toaster> provider6, Clock clock, Provider<EventFeedStoryModerationHelper> provider7, Provider<EditPrivacyIntentBuilder> provider8, Provider<Boolean> provider9, Provider<StoryReviewComposerLauncherAndHandler> provider10, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider11, Lazy<EventAdminStatusRecord> lazy, @Assisted FeedEnvironment feedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, f17415o, f17415o, analyticsLogger, newsFeedAnalyticsEventBuilder, provider5, provider6, clock, provider8, provider9, provider10, graphQLStoryUtil, qeAccessor, provider11, feedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f17417q = provider7;
        this.f17418r = lazy;
        this.f17419s = canPinAndUnpinPosts;
    }

    @Nonnull
    protected final CurationSurface m17781b() {
        return CurationSurface.NATIVE_STORY_EVENT;
    }

    protected final String m17782c() {
        return "event_feed";
    }

    protected final boolean m17780a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return f17416p.contains(graphQLNegativeFeedbackAction.b());
    }

    public final NegativeFeedbackExperienceLocation m17779a() {
        return NegativeFeedbackExperienceLocation.EVENT;
    }

    protected final BaseFeedStoryMenuOptions m17783d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new EventsFeedStoryMenuOptions(this);
        }
        return super.d(feedUnit);
    }

    protected final boolean m17784i() {
        return true;
    }
}
