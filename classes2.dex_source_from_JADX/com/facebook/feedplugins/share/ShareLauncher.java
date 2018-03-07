package com.facebook.feedplugins.share;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.event.FbEventBus;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.DefaultShareComposerLauncher;
import com.facebook.ipc.composer.launch.ShareComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents$FlyoutOnResumeEvent;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEvent;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: has_seen_emoji_color_nux */
public class ShareLauncher {
    private static ShareLauncher f21277m;
    private static final Object f21278n = new Object();
    private final FeedEventBus f21279a;
    private final Provider<Boolean> f21280b;
    private final NewsfeedAnalyticsLogger f21281c;
    private final Provider<ViewerContext> f21282d;
    private final IFeedIntentBuilder f21283e;
    private final AnalyticsLogger f21284f;
    private final Lazy<NavigationLogger> f21285g;
    private final NewsFeedAnalyticsEventBuilder f21286h;
    private final Lazy<FbErrorReporter> f21287i;
    private final Lazy<ShareMenuPopoverFactory> f21288j;
    private final Lazy<ShareComposerLauncher> f21289k;
    public final FlyoutEventBus f21290l;

    private static ShareLauncher m28988b(InjectorLike injectorLike) {
        return new ShareLauncher(FeedEventBus.m4573a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3973), NewsfeedAnalyticsLogger.m26299b(injectorLike), IdBasedProvider.m1811a(injectorLike, 372), DefaultFeedIntentBuilder.m26214a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedSingletonScopeProvider.m1810b(injectorLike, 6557), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7300), FlyoutEventBus.m14086a(injectorLike));
    }

    public static ShareLauncher m28986a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21278n) {
                ShareLauncher shareLauncher;
                if (a2 != null) {
                    shareLauncher = (ShareLauncher) a2.mo818a(f21278n);
                } else {
                    shareLauncher = f21277m;
                }
                if (shareLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28988b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21278n, b3);
                        } else {
                            f21277m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = shareLauncher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ShareLauncher(FeedEventBus feedEventBus, Provider<Boolean> provider, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, Provider<ViewerContext> provider2, IFeedIntentBuilder iFeedIntentBuilder, AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Lazy<FbErrorReporter> lazy2, Lazy<ShareMenuPopoverFactory> lazy3, Lazy<ShareComposerLauncher> lazy4, FlyoutEventBus flyoutEventBus) {
        this.f21279a = feedEventBus;
        this.f21280b = provider;
        this.f21281c = newsfeedAnalyticsLogger;
        this.f21282d = provider2;
        this.f21283e = iFeedIntentBuilder;
        this.f21284f = analyticsLogger;
        this.f21285g = lazy;
        this.f21286h = newsFeedAnalyticsEventBuilder;
        this.f21287i = lazy2;
        this.f21288j = lazy3;
        this.f21289k = lazy4;
        this.f21290l = flyoutEventBus;
    }

    private void m28989b(FeedProps<GraphQLStory> feedProps, View view, ComposerSourceType composerSourceType, Surface surface) {
        Flattenable flattenable = feedProps.f13444a;
        ShareMenuPopoverFactory shareMenuPopoverFactory = (ShareMenuPopoverFactory) this.f21288j.get();
        PopoverMenuWindow a = shareMenuPopoverFactory.a(feedProps, view, "newsfeed_ufi", new 1(this, feedProps, view, composerSourceType, surface), new 2(this), composerSourceType);
        if (a == null) {
            m28990c(feedProps, view, composerSourceType, surface);
            return;
        }
        this.f21290l.mo651a(new FlyoutEvents$FlyoutOnResumeEvent());
        a.d();
    }

    public final void m28991a(FeedProps<GraphQLStory> feedProps, View view, ComposerSourceType composerSourceType, Surface surface) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (StorySharingHelper.m30305b(graphQLStory)) {
            if (((NavigationLogger) this.f21285g.get()).f3310u == null) {
                ((NavigationLogger) this.f21285g.get()).m5498a("tap_share");
            }
            m28989b(feedProps, view, composerSourceType, surface);
            return;
        }
        ((AbstractFbErrorReporter) this.f21287i.get()).m2350b(getClass().getSimpleName(), "Attempting to share a story that is not shareable. Story ID: " + graphQLStory.m22350c());
    }

    private void m28990c(FeedProps<GraphQLStory> feedProps, View view, ComposerSourceType composerSourceType, Surface surface) {
        String g;
        String str = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        FeedProps o = GraphQLStoryUtil.m9583o((FeedProps) feedProps);
        GraphQLStory graphQLStory2 = (GraphQLStory) o.m19804a();
        GraphQLStory c = StoryProps.m27456c(o);
        FbEventBus fbEventBus = this.f21279a;
        String g2 = graphQLStory2.mo2507g();
        String j = graphQLStory2.mo2890l() != null ? graphQLStory2.mo2890l().mo2933j() : null;
        if (c != null) {
            g = c.mo2507g();
        } else {
            g = null;
        }
        fbEventBus.mo651a(new UfiEvents$ShareStoryPublishEvent(g2, j, g));
        if (((Boolean) this.f21280b.get()).booleanValue()) {
            this.f21281c.m26302a("newsfeed_ufi", graphQLStory2.m22350c(), ((ViewerContext) this.f21282d.get()).m1525a(), graphQLStory2.av().mo2906d());
        }
        Builder a = this.f21283e.mo3013a(o, composerSourceType);
        HoneyClientEvent c2 = NewsFeedAnalyticsEventBuilder.m14119c(StoryProps.m27466p(feedProps), TrackableFeedProps.m27451a(feedProps));
        TrackingNodes.m27142a(c2, view);
        this.f21284f.mo528a(c2);
        a.setNectarModule("newsfeed_ufi").setAllowsRedSpaceToggle(true).setReactionSurface(surface).setTopics(graphQLStory.m22340Z() != null ? graphQLStory.m22340Z().m24195a() : ImmutableList.of());
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        if (activity != null) {
            GraphQLStory c3 = StoryProps.m27456c(feedProps);
            FbEventBus fbEventBus2 = this.f21279a;
            String g3 = graphQLStory.mo2507g();
            String j2 = graphQLStory.mo2890l() != null ? graphQLStory.mo2890l().mo2933j() : null;
            if (c3 != null) {
                str = c3.mo2507g();
            }
            fbEventBus2.mo651a(new UfiEvents$ShareStoryPublishEvent(g3, j2, str));
            ((DefaultShareComposerLauncher) this.f21289k.get()).a(a.a(), 1756, activity);
        }
    }
}
