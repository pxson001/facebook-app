package com.facebook.feed.ui;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.api.ufiservices.common.NotificationSourceUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.feedback.ui.OriginalPostButtonUtil;
import com.facebook.feedback.ui.OriginalPostButtonUtil.SwapStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: id_ID */
public class FlyoutLauncher {
    private static final StoryRenderContext f20612a = StoryRenderContext.NEWSFEED;
    private static FlyoutLauncher f20613m;
    private static final Object f20614n = new Object();
    private final AnalyticsLogger f20615b;
    private final UFIServicesAnalyticsEventBuilder f20616c;
    private final NavigationLogger f20617d;
    private final FeedbackPopoverLauncher f20618e;
    private final QeAccessor f20619f;
    private final NewsfeedAnalyticsLogger f20620g;
    private final FbSharedPreferences f20621h;
    private final Lazy<IFeedIntentBuilder> f20622i;
    private final Lazy<SecureContextHelper> f20623j;
    private final OriginalPostButtonUtil f20624k;
    private final AbstractFbErrorReporter f20625l;

    private static FlyoutLauncher m28362b(InjectorLike injectorLike) {
        return new FlyoutLauncher(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), UFIServicesAnalyticsEventBuilder.m28369a(injectorLike), NavigationLogger.m5475a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FeedbackPopoverLauncher.m26450a(injectorLike), NewsfeedAnalyticsLogger.m26299b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), OriginalPostButtonUtil.m28370a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2347), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public static FlyoutLauncher m28357a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FlyoutLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20614n) {
                FlyoutLauncher flyoutLauncher;
                if (a2 != null) {
                    flyoutLauncher = (FlyoutLauncher) a2.mo818a(f20614n);
                } else {
                    flyoutLauncher = f20613m;
                }
                if (flyoutLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28362b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20614n, b3);
                        } else {
                            f20613m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = flyoutLauncher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m28364a(FeedProps<GraphQLStory> feedProps, FeedListType feedListType, View view, FlyoutContext flyoutContext) {
        m28361a(feedProps, feedListType, ((GraphQLStory) feedProps.f13444a).mo2890l(), null, view, flyoutContext, f20612a);
    }

    @Inject
    public FlyoutLauncher(AnalyticsLogger analyticsLogger, UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder, NavigationLogger navigationLogger, QeAccessor qeAccessor, FeedbackPopoverLauncher feedbackPopoverLauncher, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, FbSharedPreferences fbSharedPreferences, Lazy<SecureContextHelper> lazy, OriginalPostButtonUtil originalPostButtonUtil, Lazy<IFeedIntentBuilder> lazy2, FbErrorReporter fbErrorReporter) {
        this.f20615b = analyticsLogger;
        this.f20616c = uFIServicesAnalyticsEventBuilder;
        this.f20617d = navigationLogger;
        this.f20618e = feedbackPopoverLauncher;
        this.f20619f = qeAccessor;
        this.f20620g = newsfeedAnalyticsLogger;
        this.f20621h = fbSharedPreferences;
        this.f20623j = lazy;
        this.f20622i = lazy2;
        this.f20624k = originalPostButtonUtil;
        this.f20625l = fbErrorReporter;
    }

    public final void m28363a(FeedProps<GraphQLStory> feedProps, View view, FlyoutContext flyoutContext) {
        m28360a((FeedProps) feedProps, view, flyoutContext, f20612a);
    }

    private void m28360a(FeedProps<GraphQLStory> feedProps, View view, FlyoutContext flyoutContext, StoryRenderContext storyRenderContext) {
        m28361a(feedProps, null, ((GraphQLStory) feedProps.f13444a).mo2890l(), null, view, flyoutContext, storyRenderContext);
    }

    public final void m28366a(FeedProps<GraphQLStory> feedProps, GraphQLFeedback graphQLFeedback, View view, FlyoutContext flyoutContext, StoryRenderContext storyRenderContext) {
        m28361a(feedProps, null, graphQLFeedback, null, view, flyoutContext, storyRenderContext);
    }

    public final void m28365a(FeedProps<GraphQLStory> feedProps, GraphQLComment graphQLComment, View view, FlyoutContext flyoutContext, StoryRenderContext storyRenderContext) {
        m28361a(feedProps, null, ((GraphQLStory) feedProps.f13444a).mo2890l(), graphQLComment, view, flyoutContext, storyRenderContext);
    }

    private void m28361a(FeedProps<GraphQLStory> feedProps, @Nullable FeedListType feedListType, GraphQLFeedback graphQLFeedback, @Nullable GraphQLComment graphQLComment, View view, FlyoutContext flyoutContext, StoryRenderContext storyRenderContext) {
        if (graphQLComment == null) {
            SwapStory a = this.f20624k.m28373a(feedProps, feedListType);
            if (a.a) {
                GraphQLFeedback l = ((GraphQLStory) a.b.m19804a()).mo2890l();
                if (l != null) {
                    FeedProps feedProps2 = a.b;
                    graphQLFeedback = l;
                }
            }
        }
        if (this.f20621h.mo286a(FeedPrefKeys.f5738b, false)) {
            m28359a(feedProps2, view.getContext());
            return;
        }
        Long l2;
        boolean z;
        JsonNode a2 = TrackableFeedProps.m27451a(feedProps2);
        HoneyClientEvent a3 = UFIServicesAnalyticsEventBuilder.m28367a(StoryProps.m27466p(feedProps2), null, graphQLFeedback.z_(), graphQLFeedback.mo2933j(), a2, storyRenderContext.analyticModule);
        GraphQLStory graphQLStory = (GraphQLStory) feedProps2.m19804a();
        if (!TrackingNodes.m27144a(a3)) {
            TrackingNodes.m27142a(a3, view);
        }
        this.f20615b.mo528a(a3);
        NotificationSource a4 = NotificationSourceUtil.a(this.f20617d.m5515b());
        this.f20617d.m5498a(flyoutContext.navigationTapPoint);
        String a5 = m28358a(view.getContext(), storyRenderContext);
        Builder newBuilder = FeedbackLoggingParams.newBuilder();
        newBuilder.f22397a = a2;
        newBuilder = newBuilder;
        newBuilder.f22398b = flyoutContext.nectarModule;
        newBuilder = newBuilder;
        newBuilder.f22401e = a4;
        Builder builder = newBuilder;
        builder.f22399c = a5;
        Builder builder2 = builder;
        this.f20620g.m26301a((FeedUnit) graphQLStory, builder2);
        boolean z2 = flyoutContext == FlyoutContext.BLINGBAR ? GraphQLHelper.m22504f(graphQLFeedback) == 0 : false;
        if (graphQLStory.aJ() == null || graphQLStory.aJ().m23000j() == null || graphQLStory.aJ().m23000j().m22301g() != 69076575) {
            l2 = null;
        } else {
            l2 = Long.valueOf(Long.parseLong(graphQLStory.aJ().m22999b()));
        }
        String y = graphQLComment != null ? graphQLComment.m27192y() : null;
        a5 = (graphQLComment == null || graphQLComment.m27189v() == null) ? null : graphQLComment.m27189v().m27192y();
        FeedbackParams.Builder builder3 = new FeedbackParams.Builder();
        builder3.a = graphQLFeedback;
        builder3 = builder3;
        builder3.d = graphQLFeedback.z_();
        builder3 = builder3;
        builder3.e = graphQLFeedback.mo2933j();
        builder3 = builder3;
        builder3.g = builder2.m30319a();
        FeedbackParams.Builder a6 = builder3.a(l2);
        a6.i = flyoutContext.showKeyboardOnFirstLoad;
        a6 = a6;
        a6.h = flyoutContext.scrollToBottomOnFirstLoad;
        a6 = a6;
        a6.j = z2;
        FeedbackParams.Builder builder4 = a6;
        builder4.m = y;
        builder4 = builder4;
        builder4.n = a5;
        builder4 = builder4;
        builder4.o = CommentOrderType.getOrder(graphQLFeedback.m23252s());
        builder4 = builder4;
        builder4.p = GraphQLHelper.m22491b(graphQLFeedback);
        builder4 = builder4;
        builder4.q = GraphQLHelper.m22521o(graphQLStory);
        builder4 = builder4;
        builder4.r = GraphQLStoryUtil.m9573b(graphQLStory);
        FeedbackParams.Builder builder5 = builder4;
        builder5.c = feedProps2;
        FeedbackParams a7 = builder5.a();
        int f = PropertyHelper.m21303f((FeedUnit) feedProps2.m19804a());
        if (f == -1) {
            this.f20625l.m2340a("flyoutLauncherStoryIndex", "story index -1 in flyout launch");
        }
        FeedbackPopoverLauncher feedbackPopoverLauncher = this.f20618e;
        Context context = view.getContext();
        if (this.f20619f.mo596a(ExperimentsForFeedbackTestModule.f6845w, false)) {
            z = false;
        } else {
            z = true;
        }
        feedbackPopoverLauncher.m26457a(context, a7, z, f);
    }

    private String m28358a(Context context, StoryRenderContext storyRenderContext) {
        if (storyRenderContext == StoryRenderContext.CHANNEL_VIDEO_PLAYER || storyRenderContext == StoryRenderContext.FULLSCREEN_VIDEO_PLAYER || storyRenderContext == StoryRenderContext.PHOTOS_FEED) {
            return storyRenderContext.analyticModule;
        }
        String str;
        AnalyticsActivity analyticsActivity = (AnalyticsActivity) ContextUtils.m2500a(context, AnalyticsActivity.class);
        if (analyticsActivity == null) {
            str = "unknown";
        } else {
            str = analyticsActivity.am_();
            if (str == null) {
                str = "unknown";
            }
        }
        return str;
    }

    private void m28359a(FeedProps<GraphQLStory> feedProps, Context context) {
        ((SecureContextHelper) this.f20623j.get()).mo662a(((IFeedIntentBuilder) this.f20622i.get()).mo3007a((GraphQLStory) feedProps.f13444a), context);
    }
}
