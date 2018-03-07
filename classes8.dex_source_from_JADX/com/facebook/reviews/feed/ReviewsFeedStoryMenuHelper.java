package com.facebook.reviews.feed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.environment.ReviewsFeedEnvironment;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Trying to like null product */
public class ReviewsFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f21580o = new C23101();
    public final ReviewsFeedEnvironment f21581p;
    public final ReviewsLogger f21582q;

    /* compiled from: Trying to like null product */
    final class C23101 implements Provider<Boolean> {
        C23101() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: Trying to like null product */
    public class C23112 implements OnMenuItemClickListener {
        final /* synthetic */ GraphQLStory f21570a;
        final /* synthetic */ FeedProps f21571b;
        final /* synthetic */ Context f21572c;
        final /* synthetic */ ReviewsFeedStoryMenuHelper f21573d;

        public C23112(ReviewsFeedStoryMenuHelper reviewsFeedStoryMenuHelper, GraphQLStory graphQLStory, FeedProps feedProps, Context context) {
            this.f21573d = reviewsFeedStoryMenuHelper;
            this.f21570a = graphQLStory;
            this.f21571b = feedProps;
            this.f21572c = context;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f21573d.f21582q.g("delete_menu_option_tap", this.f21570a.c());
            ReviewsFeedStoryMenuHelper reviewsFeedStoryMenuHelper = this.f21573d;
            FeedProps feedProps = this.f21571b;
            Context context = this.f21572c;
            new Builder(context).b(context.getResources().getString(2131235332)).a(2131233456, new C23123(reviewsFeedStoryMenuHelper, (GraphQLStory) feedProps.a, feedProps)).b(2131233563, null).b();
            return true;
        }
    }

    /* compiled from: Trying to like null product */
    public class C23123 implements OnClickListener {
        final /* synthetic */ GraphQLStory f21574a;
        final /* synthetic */ FeedProps f21575b;
        final /* synthetic */ ReviewsFeedStoryMenuHelper f21576c;

        public C23123(ReviewsFeedStoryMenuHelper reviewsFeedStoryMenuHelper, GraphQLStory graphQLStory, FeedProps feedProps) {
            this.f21576c = reviewsFeedStoryMenuHelper;
            this.f21574a = graphQLStory;
            this.f21575b = feedProps;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f21576c.f21582q.g("delete_dialog_confirmation_button_tap", this.f21574a.c());
            this.f21576c.m25133a(this.f21575b);
        }
    }

    /* compiled from: Trying to like null product */
    class ReviewFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        final /* synthetic */ ReviewsFeedStoryMenuHelper f21579b;

        public final void m25130a(Menu menu, FeedProps<GraphQLStory> feedProps, View view) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (this.f21579b.f(graphQLStory)) {
                b(menu, feedProps, view.getContext());
            }
            if (this.f21579b.i(graphQLStory)) {
                ReviewsFeedStoryMenuHelper reviewsFeedStoryMenuHelper = this.f21579b;
                Context context = view.getContext();
                GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.a;
                MenuItem add = menu.add(2131233440);
                add.setOnMenuItemClickListener(new C23112(reviewsFeedStoryMenuHelper, graphQLStory2, feedProps, context));
                reviewsFeedStoryMenuHelper.a(add, 2130840135, graphQLStory2);
            }
            if (c(feedProps)) {
                this.f21579b.a(menu, feedProps, view);
            }
        }

        public final boolean m25131a(FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            return super.a(feedProps) || this.f21579b.f(graphQLStory) || this.f21579b.i(graphQLStory) || c(feedProps);
        }

        public ReviewFeedStoryMenuOptions(ReviewsFeedStoryMenuHelper reviewsFeedStoryMenuHelper) {
            this.f21579b = reviewsFeedStoryMenuHelper;
            super(reviewsFeedStoryMenuHelper);
        }

        protected final ComposerSourceType m25129a() {
            return ComposerSourceType.REVIEWS_LIST;
        }
    }

    protected final void m25133a(FeedProps<GraphQLStory> feedProps) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        this.c.a(new StoryDeleteEvent(feedProps));
        this.b.a(((GraphPostService) this.a.get()).a(graphQLStory, true), new OperationResultFutureCallback(this) {
            final /* synthetic */ ReviewsFeedStoryMenuHelper f21578b;

            protected final void m25127a(ServiceException serviceException) {
                ((Toaster) this.f21578b.d.get()).b(new ToastBuilder(2131235334));
                this.f21578b.c.a(new StoryVisibilityEvent(graphQLStory.g(), graphQLStory.ai(), null, StoryVisibility.VISIBLE, graphQLStory.p()));
            }

            protected final void m25128a(Object obj) {
                ((Toaster) this.f21578b.d.get()).b(new ToastBuilder(2131235335));
                this.f21578b.f21581p.f21537o.m25086f();
            }
        });
    }

    @Inject
    public ReviewsFeedStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider5, Provider<Toaster> provider6, Clock clock, Provider<EditPrivacyIntentBuilder> provider7, Provider<Boolean> provider8, Provider<StoryReviewComposerLauncherAndHandler> provider9, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider10, ReviewsLogger reviewsLogger, @Assisted ReviewsFeedEnvironment reviewsFeedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, f21580o, f21580o, analyticsLogger, newsFeedAnalyticsEventBuilder, provider5, provider6, clock, provider7, provider8, provider9, graphQLStoryUtil, qeAccessor, provider10, reviewsFeedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f21582q = reviewsLogger;
        this.f21581p = reviewsFeedEnvironment;
    }

    protected final String m25136c() {
        return "reviews_feed";
    }

    protected final boolean m25134a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return GraphQLNegativeFeedbackActionType.DONT_LIKE.equals(graphQLNegativeFeedbackAction.b());
    }

    public final NegativeFeedbackExperienceLocation m25132a() {
        return NegativeFeedbackExperienceLocation.PAGE_REVIEW;
    }

    protected final CurationSurface m25135b() {
        return CurationSurface.PAGE_SEE_ALL_REVIEWS;
    }

    protected final BaseFeedStoryMenuOptions m25137d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new ReviewFeedStoryMenuOptions(this);
        }
        return super.d(feedUnit);
    }

    protected final boolean m25139i() {
        return true;
    }

    public final /* synthetic */ FeedEnvironment m25138f() {
        return this.f21581p;
    }
}
