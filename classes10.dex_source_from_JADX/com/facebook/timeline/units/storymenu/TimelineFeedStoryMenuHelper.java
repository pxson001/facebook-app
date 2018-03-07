package com.facebook.timeline.units.storymenu;

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
import com.facebook.checkin.socialsearch.utils.SocialSearchInternalActionsHelper;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEvent;
import com.facebook.timeline.event.StoryMenuEvents.EditStoryEvent;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: extra_group_name */
public abstract class TimelineFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    protected static final ImmutableSet<GraphQLNegativeFeedbackActionType> f12800s = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNTAG, GraphQLNegativeFeedbackActionType.DONT_LIKE, GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE);
    public static final Provider<Boolean> f12801t = new C17901();
    public final TimelineContext f12802o;
    public final TimelineStoryEventBus f12803p;
    @Nullable
    public final SocialSearchInternalActionsHelper f12804q;
    public DefaultPrivacyScopeResourceResolver f12805r;
    private final boolean f12806u;
    public final QeAccessor f12807v;

    /* compiled from: extra_group_name */
    final class C17901 implements Provider<Boolean> {
        C17901() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: extra_group_name */
    public class C17912 implements OnClickListener {
        final /* synthetic */ FeedUnit f12808a;
        final /* synthetic */ View f12809b;
        final /* synthetic */ TimelineFeedStoryMenuHelper f12810c;

        public C17912(TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper, FeedUnit feedUnit, View view) {
            this.f12810c = timelineFeedStoryMenuHelper;
            this.f12808a = feedUnit;
            this.f12809b = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f12808a instanceof GraphQLStory) {
                this.f12810c.m12755a((GraphQLStory) this.f12808a, this.f12809b);
            }
        }
    }

    /* compiled from: extra_group_name */
    public class C17923 implements OnClickListener {
        final /* synthetic */ FeedUnit f12811a;
        final /* synthetic */ Context f12812b;
        final /* synthetic */ TimelineFeedStoryMenuHelper f12813c;

        public C17923(TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper, FeedUnit feedUnit, Context context) {
            this.f12813c = timelineFeedStoryMenuHelper;
            this.f12811a = feedUnit;
            this.f12812b = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f12811a instanceof GraphQLStory) {
                this.f12813c.a((GraphQLStory) this.f12811a, this.f12812b);
            }
        }
    }

    /* compiled from: extra_group_name */
    public class C17934 implements OnClickListener {
        final /* synthetic */ FeedUnit f12814a;
        final /* synthetic */ View f12815b;
        final /* synthetic */ TimelineFeedStoryMenuHelper f12816c;

        public C17934(TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper, FeedUnit feedUnit, View view) {
            this.f12816c = timelineFeedStoryMenuHelper;
            this.f12814a = feedUnit;
            this.f12815b = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f12814a instanceof GraphQLStory) {
                this.f12816c.m12755a((GraphQLStory) this.f12814a, this.f12815b);
            }
        }
    }

    @VisibleForTesting
    /* compiled from: extra_group_name */
    public class FeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        public final /* synthetic */ TimelineFeedStoryMenuHelper f12829b;

        public void m12772a(Menu menu, FeedProps<GraphQLStory> feedProps, final View view) {
            final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            final Context context = view.getContext();
            if (a(graphQLStory)) {
                b(menu, feedProps, view);
            }
            TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper = this.f12829b;
            if (BaseFeedStoryMenuHelper.h(graphQLStory)) {
                MenuItem add = menu.add(2131233473);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ FeedStoryMenuOptions f12819c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f12819c.f12829b.m12759b(graphQLStory, context);
                        return true;
                    }
                });
                this.f12829b.a(add, 2130839800, graphQLStory);
            }
            if (this.f12829b.g(graphQLStory)) {
                add = menu.add(2131233471);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ FeedStoryMenuOptions f12822c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f12822c.f12829b.a(graphQLStory, context);
                        return true;
                    }
                });
                this.f12829b.a(add, 2130840013, graphQLStory);
            }
            if (this.f12829b.e(graphQLStory)) {
                add = menu.add(2131233468);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ FeedStoryMenuOptions f12825c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f12825c.f12829b.m12754a(graphQLStory, context);
                        return true;
                    }
                });
                this.f12829b.a(add, this.f12829b.f12805r.a(graphQLStory.ao().s()), graphQLStory);
            }
            if (c(feedProps)) {
                this.f12829b.a(menu, feedProps, view);
            }
            if (this.f12829b.i(graphQLStory)) {
                add = menu.add(2131234899);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ FeedStoryMenuOptions f12828c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper;
                        GraphQLStory graphQLStory;
                        View view;
                        Context context;
                        if (this.f12828c.f12829b.g(graphQLStory) && this.f12828c.f12829b.f12807v.a(ExperimentsForFeedUtilComposerAbtestModule.ad, false)) {
                            timelineFeedStoryMenuHelper = this.f12828c.f12829b;
                            graphQLStory = graphQLStory;
                            view = view;
                            context = view.getContext();
                            AlertDialog b = new Builder(context).a(context.getResources().getString(2131233464)).b(context.getResources().getString(2131233443)).c(2131233464, new C17934(timelineFeedStoryMenuHelper, graphQLStory, view)).b(2131233471, new C17923(timelineFeedStoryMenuHelper, graphQLStory, context)).a(2131234960, null).b();
                            b.a(-3).setTextColor(b.a(-1).getTextColors());
                            b.a(-1).setTextColor(b.a(-2).getTextColors());
                        } else {
                            timelineFeedStoryMenuHelper = this.f12828c.f12829b;
                            graphQLStory = graphQLStory;
                            view = view;
                            context = view.getContext();
                            new Builder(context).b(context.getResources().getString(2131234931)).a(2131234899, new C17912(timelineFeedStoryMenuHelper, graphQLStory, view)).b(2131234960, null).b();
                        }
                        return true;
                    }
                });
                this.f12829b.a(add, 2130840135, graphQLStory);
            }
            a(menu, feedProps);
            if (b(feedProps)) {
                a(menu, feedProps, context);
            }
            if (this.f12829b.f12804q.a(graphQLStory)) {
                this.f12829b.f12804q.a(menu, graphQLStory, context);
            }
            super.a(menu, feedProps, view);
        }

        public boolean m12773a(FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (!(super.a(feedProps) || c(feedProps) || this.f12829b.i(graphQLStory) || this.f12829b.e(graphQLStory))) {
                TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper = this.f12829b;
                if (!(BaseFeedStoryMenuHelper.h(graphQLStory) || a(graphQLStory) || this.f12829b.g(graphQLStory) || c(graphQLStory))) {
                    return false;
                }
            }
            return true;
        }

        protected FeedStoryMenuOptions(TimelineFeedStoryMenuHelper timelineFeedStoryMenuHelper) {
            this.f12829b = timelineFeedStoryMenuHelper;
            super(timelineFeedStoryMenuHelper);
        }
    }

    protected abstract boolean mo558a(GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType);

    protected abstract boolean mo559b(GraphQLStory graphQLStory);

    public TimelineFeedStoryMenuHelper(TimelineContext timelineContext, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<GraphPostService> provider5, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, TimelineStoryEventBus timelineStoryEventBus, Provider<TriState> provider6, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<Toaster> provider7, Clock clock, FeedEventBus feedEventBus, AndroidThreadUtil androidThreadUtil, Provider<EditPrivacyIntentBuilder> provider8, Provider<Boolean> provider9, Provider<StoryReviewComposerLauncherAndHandler> provider10, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider11, SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, FeedEnvironment feedEnvironment, Boolean bool, OptimisticStoryStateCache optimisticStoryStateCache, PrivacyScopeResourceResolver privacyScopeResourceResolver, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider5, androidThreadUtil, feedEventBus, provider3, provider4, f12801t, analyticsLogger, newsFeedAnalyticsEventBuilder, provider6, provider7, clock, provider8, provider9, provider10, graphQLStoryUtil, qeAccessor, provider11, feedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f12805r = privacyScopeResourceResolver;
        this.f12802o = timelineContext;
        this.f12803p = timelineStoryEventBus;
        this.f12804q = socialSearchInternalActionsHelper;
        this.f12806u = bool.booleanValue();
        this.f12807v = qeAccessor;
    }

    public final boolean m12757a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        GraphQLNegativeFeedbackActionType b = graphQLNegativeFeedbackAction.b();
        if (!Boolean.valueOf(mo558a(b)).booleanValue()) {
            return false;
        }
        if (b == GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE) {
            return mo559b((GraphQLStory) negativeFeedbackActionsUnit);
        }
        if (b != GraphQLNegativeFeedbackActionType.DONT_LIKE) {
            return true;
        }
        if (i(negativeFeedbackActionsUnit)) {
            return false;
        }
        return true;
    }

    @Nonnull
    protected final CurationSurface m12758b() {
        return CurationSurface.NATIVE_STORY_TIMELINE;
    }

    protected final String m12761c() {
        return "native_timeline";
    }

    protected BaseFeedStoryMenuOptions m12762d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new FeedStoryMenuOptions(this);
        }
        return null;
    }

    public static GraphQLActor m12752c(GraphQLStory graphQLStory) {
        if (graphQLStory != null) {
            try {
                if (!(graphQLStory.b() == null || graphQLStory.b().size() != 1 || graphQLStory.b().get(0) == null)) {
                    return (GraphQLActor) graphQLStory.b().get(0);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    protected final void m12754a(FeedUnit feedUnit, Context context) {
        this.f12803p.a(new EditStoryEvent(this.f12802o.d, feedUnit.g()));
        super.a(feedUnit, context);
    }

    protected final void m12759b(FeedUnit feedUnit, Context context) {
        a(feedUnit, "native_timeline", context);
    }

    protected final ComposerConfiguration.Builder m12753a(GraphQLStory graphQLStory) {
        return super.a(graphQLStory).setSourceType(ComposerSourceType.TIMELINE);
    }

    protected final void m12755a(GraphQLStory graphQLStory, View view) {
        this.f12803p.a(new DeleteStoryClickedEvent(this.f12802o.d, graphQLStory.ai(), graphQLStory.g(), graphQLStory.c(), view));
    }

    protected final boolean m12763i() {
        return true;
    }
}
