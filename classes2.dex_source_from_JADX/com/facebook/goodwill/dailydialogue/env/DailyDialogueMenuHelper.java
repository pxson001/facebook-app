package com.facebook.goodwill.dailydialogue.env;

import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.Assisted;
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
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: method/mobile.zeroOptout */
public class DailyDialogueMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f13569o = new C05451();
    public static final Provider<Boolean> f13570p = new C05462();
    protected static final ImmutableSet<GraphQLNegativeFeedbackActionType> f13571q = ImmutableSet.of(GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE);
    public final Runnable f13572r;

    /* compiled from: method/mobile.zeroOptout */
    final class C05451 implements Provider<Boolean> {
        C05451() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: method/mobile.zeroOptout */
    final class C05462 implements Provider<Boolean> {
        C05462() {
        }

        public final Object get() {
            return Boolean.TRUE;
        }
    }

    @Inject
    public DailyDialogueMenuHelper(@Assisted Runnable runnable, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<Toaster> provider4, Clock clock, Provider<EditPrivacyIntentBuilder> provider5, Provider<StoryReviewComposerLauncherAndHandler> provider6, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider7, @Assisted BaseFeedEnvironment baseFeedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, f13569o, f13570p, f13569o, analyticsLogger, newsFeedAnalyticsEventBuilder, null, provider4, clock, provider5, f13569o, provider6, graphQLStoryUtil, qeAccessor, provider7, baseFeedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f13572r = runnable;
    }

    public final boolean mo2471a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return f13571q.contains(graphQLNegativeFeedbackAction.m27654b());
    }

    public final NegativeFeedbackExperienceLocation mo2465a() {
        return NegativeFeedbackExperienceLocation.NEWSFEED;
    }

    protected final CurationSurface mo2472b() {
        return CurationSurface.NATIVE_GOOD_MORNING;
    }

    protected final String mo2474c() {
        return "daily_dialogue";
    }

    protected final BaseFeedStoryMenuOptions mo2476d(FeedUnit feedUnit) {
        return new DailyDialogueMenuOptions(this);
    }

    protected final boolean mo2479i() {
        return true;
    }
}
