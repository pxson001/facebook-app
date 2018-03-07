package com.facebook.pages.identity.timeline.storymenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.timeline.event.StoryMenuEvents.BanUserClickedEvent;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.units.storymenu.TimelineFeedStoryMenuHelper;
import com.facebook.timeline.units.storymenu.TimelineFeedStoryMenuHelper.FeedStoryMenuOptions;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_identity_report_fail */
public class PagesTimelineFeedStoryMenuHelper extends TimelineFeedStoryMenuHelper {
    public static final Class<?> f4232u = PagesTimelineFeedStoryMenuHelper.class;
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f4233v = ImmutableSet.of(GraphQLNegativeFeedbackActionType.DONT_LIKE, GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE);
    @Nullable
    public Fragment f4234w;
    private Lazy<ComposerLauncher> f4235x;

    /* compiled from: page_identity_report_fail */
    public class C05891 implements OnClickListener {
        final /* synthetic */ GraphQLActor f4224a;
        final /* synthetic */ GraphQLStory f4225b;
        final /* synthetic */ View f4226c;
        final /* synthetic */ PagesTimelineFeedStoryMenuHelper f4227d;

        public C05891(PagesTimelineFeedStoryMenuHelper pagesTimelineFeedStoryMenuHelper, GraphQLActor graphQLActor, GraphQLStory graphQLStory, View view) {
            this.f4227d = pagesTimelineFeedStoryMenuHelper;
            this.f4224a = graphQLActor;
            this.f4225b = graphQLStory;
            this.f4226c = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4227d.p.a(new BanUserClickedEvent(this.f4227d.o.d, this.f4227d.o.b, Long.parseLong(this.f4224a.H()), this.f4225b.g(), this.f4226c));
        }
    }

    /* compiled from: page_identity_report_fail */
    class PagesFeedStoryMenuOptions extends FeedStoryMenuOptions {
        final /* synthetic */ PagesTimelineFeedStoryMenuHelper f4231c;

        public final boolean m5207a(FeedProps<GraphQLStory> feedProps) {
            return super.a(feedProps) || PagesTimelineFeedStoryMenuHelper.m5208d(this.f4231c, (GraphQLStory) feedProps.a);
        }

        public PagesFeedStoryMenuOptions(PagesTimelineFeedStoryMenuHelper pagesTimelineFeedStoryMenuHelper) {
            this.f4231c = pagesTimelineFeedStoryMenuHelper;
            super(pagesTimelineFeedStoryMenuHelper);
        }

        public final void m5206a(Menu menu, FeedProps<GraphQLStory> feedProps, final View view) {
            super.a(menu, feedProps, view);
            FeedUnit feedUnit = (FeedUnit) feedProps.a;
            if (feedUnit instanceof GraphQLStory) {
                final GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (PagesTimelineFeedStoryMenuHelper.m5208d(this.f4231c, graphQLStory)) {
                    MenuItem add = menu.add(2131234900);
                    add.setIcon(2130839984);
                    add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ PagesFeedStoryMenuOptions f4230c;

                        public boolean onMenuItemClick(MenuItem menuItem) {
                            PagesTimelineFeedStoryMenuHelper pagesTimelineFeedStoryMenuHelper = this.f4230c.f4231c;
                            GraphQLStory graphQLStory = graphQLStory;
                            View view = view;
                            GraphQLActor c = TimelineFeedStoryMenuHelper.c(graphQLStory);
                            if (c == null) {
                                BLog.b(PagesTimelineFeedStoryMenuHelper.f4232u, "Error: ban user action see empty actor");
                            } else {
                                Context context = view.getContext();
                                new Builder(context).b(StringLocaleUtil.a(context.getResources().getString(2131234901), new Object[]{c.aa()})).a(2131234900, new C05891(pagesTimelineFeedStoryMenuHelper, c, graphQLStory, view)).b(2131234960, null).b();
                            }
                            return true;
                        }
                    });
                }
            }
        }
    }

    @Inject
    public PagesTimelineFeedStoryMenuHelper(@Assisted TimelineContext timelineContext, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<GraphPostService> provider5, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, TimelineStoryEventBus timelineStoryEventBus, Provider<TriState> provider6, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<Toaster> provider7, Clock clock, FeedEventBus feedEventBus, AndroidThreadUtil androidThreadUtil, Provider<EditPrivacyIntentBuilder> provider8, Provider<Boolean> provider9, Provider<StoryReviewComposerLauncherAndHandler> provider10, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider11, Lazy<ComposerLauncher> lazy, SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, @Assisted BaseFeedEnvironment baseFeedEnvironment, Boolean bool, OptimisticStoryStateCache optimisticStoryStateCache, PrivacyScopeResourceResolver privacyScopeResourceResolver, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(timelineContext, provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, provider3, provider4, provider5, analyticsLogger, newsFeedAnalyticsEventBuilder, timelineStoryEventBus, provider6, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider7, clock, feedEventBus, androidThreadUtil, provider8, provider9, provider10, graphQLStoryUtil, qeAccessor, provider11, socialSearchInternalActionsHelper, baseFeedEnvironment, bool, optimisticStoryStateCache, privacyScopeResourceResolver, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f4235x = lazy;
    }

    protected final BaseFeedStoryMenuOptions m5213d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new PagesFeedStoryMenuOptions(this);
        }
        return null;
    }

    protected final boolean m5212b(GraphQLStory graphQLStory) {
        if (this.o.a() && graphQLStory.getType() != null && graphQLStory.getType().g() == 80218325 && graphQLStory.c() != null) {
            return true;
        }
        return false;
    }

    protected final boolean m5211a(GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        return f4233v.contains(graphQLNegativeFeedbackActionType);
    }

    protected final void m5210a(GraphQLStory graphQLStory, Context context) {
        if (this.f4234w != null) {
            ((ComposerLauncher) this.f4235x.get()).a(null, a(graphQLStory).a(), 1758, this.f4234w);
        } else {
            super.a(graphQLStory, context);
        }
    }

    public static boolean m5208d(PagesTimelineFeedStoryMenuHelper pagesTimelineFeedStoryMenuHelper, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return false;
        }
        if (!pagesTimelineFeedStoryMenuHelper.o.a() || TimelineFeedStoryMenuHelper.c(graphQLStory) == null) {
            return false;
        }
        Long valueOf = Long.valueOf(Long.parseLong(((GraphQLActor) graphQLStory.b().get(0)).H()));
        return (valueOf.longValue() == 0 || valueOf.longValue() == pagesTimelineFeedStoryMenuHelper.o.b || valueOf.longValue() == pagesTimelineFeedStoryMenuHelper.o.a) ? false : true;
    }

    public final NegativeFeedbackExperienceLocation m5209a() {
        return NegativeFeedbackExperienceLocation.PAGE_TIMELINE;
    }
}
