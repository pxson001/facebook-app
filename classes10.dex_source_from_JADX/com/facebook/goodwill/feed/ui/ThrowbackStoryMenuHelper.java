package com.facebook.goodwill.feed.ui;

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
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.FeedStoryMenuActionType;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsConnection;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLStory;
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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VALIDATION_SUCCESS */
public class ThrowbackStoryMenuHelper extends BaseFeedStoryMenuHelper {
    public static final Provider<Boolean> f21265o = new C30211();
    public static final Provider<Boolean> f21266p = new C30222();
    protected static final ImmutableSet<GraphQLNegativeFeedbackActionType> f21267q = ImmutableSet.of(GraphQLNegativeFeedbackActionType.UNTAG, GraphQLNegativeFeedbackActionType.DONT_LIKE, GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE);

    /* compiled from: VALIDATION_SUCCESS */
    final class C30211 implements Provider<Boolean> {
        C30211() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: VALIDATION_SUCCESS */
    final class C30222 implements Provider<Boolean> {
        C30222() {
        }

        public final Object get() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: VALIDATION_SUCCESS */
    public class C30233 implements OnClickListener {
        final /* synthetic */ FeedProps f21243a;
        final /* synthetic */ ThrowbackStoryMenuHelper f21244b;

        public C30233(ThrowbackStoryMenuHelper throwbackStoryMenuHelper, FeedProps feedProps) {
            this.f21244b = throwbackStoryMenuHelper;
            this.f21243a = feedProps;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f21244b.a(this.f21243a);
        }
    }

    /* compiled from: VALIDATION_SUCCESS */
    class ThrowbackFeedMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        final /* synthetic */ ThrowbackStoryMenuHelper f21264b;

        public final boolean m22160a(FeedProps<GraphQLStory> feedProps) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (!(super.a(feedProps) || m22161c(feedProps) || this.f21264b.i(graphQLStory) || this.f21264b.e(graphQLStory))) {
                ThrowbackStoryMenuHelper throwbackStoryMenuHelper = this.f21264b;
                if (!(BaseFeedStoryMenuHelper.h(graphQLStory) || this.f21264b.g(graphQLStory))) {
                    return false;
                }
            }
            return true;
        }

        ThrowbackFeedMenuOptions(ThrowbackStoryMenuHelper throwbackStoryMenuHelper) {
            this.f21264b = throwbackStoryMenuHelper;
            super(throwbackStoryMenuHelper);
        }

        public final void m22159a(Menu menu, final FeedProps<GraphQLStory> feedProps, View view) {
            final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            final Context context = view.getContext();
            if (this.f21264b.i(graphQLStory)) {
                final String name = FeedStoryMenuActionType.DELETE.name();
                MenuItem add = menu.add(2131233440);
                add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ThrowbackFeedMenuOptions f21248d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f21248d.f21264b.a(feedProps, menuItem.getItemId(), name, true);
                        ThrowbackStoryMenuHelper throwbackStoryMenuHelper = this.f21248d.f21264b;
                        FeedProps feedProps = feedProps;
                        Context context = context;
                        new Builder(context).b(context.getResources().getString(2131233442)).a(2131233456, new C30233(throwbackStoryMenuHelper, feedProps)).b(2131233563, null).b();
                        return true;
                    }
                });
                this.f21264b.a(feedProps, add.getItemId(), name, false);
                this.f21264b.a(add, 2130840135, graphQLStory);
            }
            if (this.f21264b.g(graphQLStory)) {
                final String name2 = FeedStoryMenuActionType.EDIT_POST.name();
                MenuItem add2 = menu.add(2131233471);
                final FeedProps<GraphQLStory> feedProps2 = feedProps;
                add2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ThrowbackFeedMenuOptions f21253e;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f21253e.f21264b.a(feedProps2, menuItem.getItemId(), name2, true);
                        this.f21253e.f21264b.a(graphQLStory, context);
                        return true;
                    }
                });
                this.f21264b.a(feedProps, add2.getItemId(), name2, false);
                this.f21264b.a(add2, 2130840013, graphQLStory);
            }
            ThrowbackStoryMenuHelper throwbackStoryMenuHelper = this.f21264b;
            if (BaseFeedStoryMenuHelper.h(graphQLStory)) {
                name2 = FeedStoryMenuActionType.VIEW_EDIT_HISTORY.name();
                add2 = menu.add(2131233473);
                feedProps2 = feedProps;
                add2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ThrowbackFeedMenuOptions f21258e;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f21258e.f21264b.a(feedProps2, menuItem.getItemId(), name2, true);
                        this.f21258e.f21264b.b(graphQLStory, context);
                        return true;
                    }
                });
                this.f21264b.a(feedProps, add2.getItemId(), name2, false);
                this.f21264b.a(add2, 2130839800, graphQLStory);
            }
            if (this.f21264b.e(graphQLStory)) {
                name2 = FeedStoryMenuActionType.EDIT_PRIVACY.name();
                add2 = menu.add(2131233468);
                feedProps2 = feedProps;
                add2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ThrowbackFeedMenuOptions f21263e;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f21263e.f21264b.a(feedProps2, menuItem.getItemId(), name2, true);
                        this.f21263e.f21264b.a(graphQLStory, context);
                        return true;
                    }
                });
                this.f21264b.a(feedProps, add2.getItemId(), name2, false);
                this.f21264b.a(add2, 2130840013, graphQLStory);
            }
            this.f21264b.a(menu, feedProps, view);
            super.a(menu, feedProps, view);
        }

        @VisibleForTesting
        public final boolean m22161c(FeedProps<? extends FeedUnit> feedProps) {
            FeedUnit feedUnit = (FeedUnit) feedProps.a;
            if (!(feedUnit instanceof NegativeFeedbackActionsUnit)) {
                return false;
            }
            NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedUnit;
            if (negativeFeedbackActionsUnit.q() != null) {
                Object obj;
                ThrowbackStoryMenuHelper throwbackStoryMenuHelper = this.f21264b;
                GraphQLNegativeFeedbackActionsConnection t = negativeFeedbackActionsUnit.t();
                if (t == null || t.a() == null || t.a().isEmpty()) {
                    obj = null;
                } else {
                    ImmutableList a = t.a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i);
                        if (graphQLNegativeFeedbackActionsEdge.a() != null && throwbackStoryMenuHelper.m22163a(negativeFeedbackActionsUnit, graphQLNegativeFeedbackActionsEdge.a())) {
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
    }

    @Inject
    public ThrowbackStoryMenuHelper(Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<Toaster> provider4, Clock clock, Provider<EditPrivacyIntentBuilder> provider5, Provider<StoryReviewComposerLauncherAndHandler> provider6, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider7, @Assisted BaseFeedEnvironment baseFeedEnvironment, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, f21265o, f21266p, f21265o, analyticsLogger, newsFeedAnalyticsEventBuilder, null, provider4, clock, provider5, f21265o, provider6, graphQLStoryUtil, qeAccessor, provider7, baseFeedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
    }

    public final boolean m22163a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return f21267q.contains(graphQLNegativeFeedbackAction.b());
    }

    public final NegativeFeedbackExperienceLocation m22162a() {
        return NegativeFeedbackExperienceLocation.THROWBACK;
    }

    protected final CurationSurface m22164b() {
        return CurationSurface.OTD_PERMALINK;
    }

    protected final String m22165c() {
        return "goodwill_throwback";
    }

    protected final BaseFeedStoryMenuOptions m22166d(FeedUnit feedUnit) {
        return new ThrowbackFeedMenuOptions(this);
    }

    protected final boolean m22167i() {
        return true;
    }
}
