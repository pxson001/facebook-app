package com.facebook.feedplugins.feedbackreactions.ui;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.AnalyticsHelper;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLoggerProvider;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.feedplugins.base.footer.ui.CommentCacheStateUtil;
import com.facebook.feedplugins.base.footer.ui.CommentClickedUtil;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterBinderUtil;
import com.facebook.feedplugins.base.footer.ui.FooterLikeButton;
import com.facebook.feedplugins.share.ShareLauncher;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringSystem;
import com.facebook.ufiservices.event.UfiEvents$ReactionUpdatedEvent;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.ImmutableList;
import java.util.EnumMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: has_pending_stories */
public class BaseReactionsFooterPartDefinition<E extends HasFeedListType & HasPersistentState> extends BaseSinglePartDefinition<Props, State, E, ReactionsFooterView> {
    private static final InterstitialTrigger f21321a = new InterstitialTrigger(Action.UFI_CLICKED);
    private static BaseReactionsFooterPartDefinition f21322x;
    private static final Object f21323y = new Object();
    public final NewsfeedAnalyticsLogger f21324b;
    private final QeAccessor f21325c;
    public final ReactionsMutationController f21326d;
    private final ReactionsDockOverlay f21327e;
    private final SpringSystem f21328f;
    public final FeedEventBus f21329g;
    public final CommentClickedUtil f21330h;
    public final ShareLauncher f21331i;
    public final Lazy<NavigationLogger> f21332j;
    public final AbstractFbErrorReporter f21333k;
    private final Provider<TouchSpring> f21334l;
    private final ReactionsFooterInteractionLoggerProvider f21335m;
    public final Lazy<FBSoundUtil> f21336n;
    private final InterstitialManager f21337o;
    public final FeedbackReactionsUtils f21338p;
    private final ReactionsExperimentUtil f21339q;
    private final ReactionsNuxLogger f21340r;
    public final FeedbackReactionsController f21341s;
    public final FeedDiscoveryFunnelLoggerUtil f21342t;
    private final GraphQLStoryUtil f21343u;
    private final CommentCacheStateUtil f21344v;
    public final FloatingReactionsLauncher f21345w;

    /* compiled from: has_pending_stories */
    public class Props {
        public final FeedProps<GraphQLStory> f22360a;
        public final boolean f22361b;

        public Props(FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f22360a = feedProps;
            this.f22361b = z;
        }
    }

    /* compiled from: has_pending_stories */
    public class State {
        public final ButtonClickedListener f22406a;
        public final ReactionMutateListener f22407b;
        public final Spring f22408c;
        public final ReactionsFooterInteractionLogger f22409d;
        public final String f22410e;
        public final FeedbackLoggingParams f22411f;
        @Nullable
        public final EnumMap<FooterButtonId, TouchSpring> f22412g;
        public final DockTheme f22413h;
        public final ImmutableList<FeedbackReaction> f22414i;

        public State(ButtonClickedListener buttonClickedListener, ReactionMutateListener reactionMutateListener, Spring spring, ReactionsFooterInteractionLogger reactionsFooterInteractionLogger, String str, FeedbackLoggingParams feedbackLoggingParams, EnumMap<FooterButtonId, TouchSpring> enumMap, DockTheme dockTheme, ImmutableList<FeedbackReaction> immutableList) {
            this.f22406a = buttonClickedListener;
            this.f22407b = reactionMutateListener;
            this.f22408c = spring;
            this.f22409d = reactionsFooterInteractionLogger;
            this.f22410e = str;
            this.f22411f = feedbackLoggingParams;
            this.f22412g = enumMap;
            this.f22413h = dockTheme;
            this.f22414i = immutableList;
        }
    }

    private static BaseReactionsFooterPartDefinition m29030b(InjectorLike injectorLike) {
        return new BaseReactionsFooterPartDefinition(QeInternalImplMethodAutoProvider.m3744a(injectorLike), ReactionsMutationController.m29035a(injectorLike), ReactionsDockOverlay.m29052a(injectorLike), (ReactionsFooterInteractionLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsFooterInteractionLoggerProvider.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10994), InterstitialManager.m8082a(injectorLike), FeedbackReactionsUtils.m29074a(injectorLike), ReactionsNuxLogger.m29080a(injectorLike), FeedbackReactionsController.m29084a(injectorLike), SpringSystem.m7833a(injectorLike), FeedEventBus.m4573a(injectorLike), CommentClickedUtil.m28992a(injectorLike), ShareLauncher.m28986a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), FbErrorReporterImpl.m2317a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3736), ReactionsExperimentUtil.m10410a(injectorLike), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), CommentCacheStateUtil.m28980a(injectorLike), NewsfeedAnalyticsLogger.m26297a(injectorLike), FloatingReactionsLauncher.m29208a(injectorLike));
    }

    public static BaseReactionsFooterPartDefinition m29025a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21323y) {
                BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition;
                if (a2 != null) {
                    baseReactionsFooterPartDefinition = (BaseReactionsFooterPartDefinition) a2.mo818a(f21323y);
                } else {
                    baseReactionsFooterPartDefinition = f21322x;
                }
                if (baseReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29030b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21323y, b3);
                        } else {
                            f21322x = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        final CacheableEntity cacheableEntity = (GraphQLStory) props.f22360a.f13444a;
        ReactionsFooterInteractionLogger a = this.f21335m.m29073a(cacheableEntity.m22350c(), cacheableEntity.mo2890l() != null ? cacheableEntity.mo2890l().z_() : null, "native_newsfeed");
        EnumMap a2 = FooterBinderUtil.m30294a((HasPersistentState) hasFeedListType, (GraphQLStory) cacheableEntity, hasFeedListType.mo2446c());
        FooterBinderUtil.m30300a(cacheableEntity.m22369z(), cacheableEntity.m22315A(), StorySharingHelper.m30305b(cacheableEntity), a2, this.f21334l);
        if (this.f21325c.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6717g, false)) {
            for (TouchSpring touchSpring : a2.values()) {
                touchSpring.f22380d = true;
            }
        }
        String a3 = AnalyticsHelper.m28995a(hasFeedListType.mo2446c());
        Builder newBuilder = FeedbackLoggingParams.newBuilder();
        newBuilder.f22397a = TrackableFeedProps.m27451a(props.f22360a);
        newBuilder = newBuilder;
        newBuilder.f22398b = AnalyticsHelper.m28996b(hasFeedListType.mo2446c());
        newBuilder = newBuilder;
        newBuilder.f22399c = a3;
        final Builder builder = newBuilder;
        return new State(m29024a(props, hasFeedListType, builder, a3), new ReactionMutateListener(this) {
            final /* synthetic */ BaseReactionsFooterPartDefinition f22422c;

            public final void mo3277a(View view, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
                if (feedbackReaction != FeedbackReaction.f21477d) {
                    this.f22422c.f21324b.m26301a(cacheableEntity, builder);
                    this.f22422c.f21338p.m29077b();
                    this.f22422c.f21326d.m29040a(cacheableEntity.mo2890l(), feedbackReaction, builder.m30319a(), disposableFutureCallback);
                    this.f22422c.f21329g.mo651a(new UfiEvents$ReactionUpdatedEvent(cacheableEntity.m22350c(), cacheableEntity.mo2507g(), feedbackReaction, false));
                    if (feedbackReaction.f21478e == 11) {
                        this.f22422c.f21345w.m29213a(view);
                    }
                }
            }
        }, (Spring) ((HasPersistentState) hasFeedListType).mo2425a(new ReactionsFooterSpringKey(m29026a(cacheableEntity, hasFeedListType.mo2446c()), this.f21328f), cacheableEntity), a, a3, builder.m30319a(), a2, ReactionsFooterBinderUtil.m30327a(hasFeedListType.mo2446c()), this.f21341s.m29088a(cacheableEntity.mo2890l().m23217K()));
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReactionsFooterBinderUtil.m30328a((ReactionsFooterView) view, this.f21327e);
    }

    @Inject
    public BaseReactionsFooterPartDefinition(QeAccessor qeAccessor, ReactionsMutationController reactionsMutationController, ReactionsDockOverlay reactionsDockOverlay, ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider, Lazy<FBSoundUtil> lazy, InterstitialManager interstitialManager, FeedbackReactionsUtils feedbackReactionsUtils, ReactionsNuxLogger reactionsNuxLogger, FeedbackReactionsController feedbackReactionsController, SpringSystem springSystem, FeedEventBus feedEventBus, CommentClickedUtil commentClickedUtil, ShareLauncher shareLauncher, Lazy<NavigationLogger> lazy2, FbErrorReporter fbErrorReporter, Provider<TouchSpring> provider, ReactionsExperimentUtil reactionsExperimentUtil, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil, GraphQLStoryUtil graphQLStoryUtil, CommentCacheStateUtil commentCacheStateUtil, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, FloatingReactionsLauncher floatingReactionsLauncher) {
        this.f21325c = qeAccessor;
        this.f21326d = reactionsMutationController;
        this.f21327e = reactionsDockOverlay;
        this.f21336n = lazy;
        this.f21337o = interstitialManager;
        this.f21338p = feedbackReactionsUtils;
        this.f21339q = reactionsExperimentUtil;
        this.f21340r = reactionsNuxLogger;
        this.f21341s = feedbackReactionsController;
        this.f21328f = springSystem;
        this.f21329g = feedEventBus;
        this.f21330h = commentClickedUtil;
        this.f21331i = shareLauncher;
        this.f21332j = lazy2;
        this.f21333k = fbErrorReporter;
        this.f21334l = provider;
        this.f21342t = feedDiscoveryFunnelLoggerUtil;
        this.f21343u = graphQLStoryUtil;
        this.f21335m = reactionsFooterInteractionLoggerProvider;
        this.f21344v = commentCacheStateUtil;
        this.f21324b = newsfeedAnalyticsLogger;
        this.f21345w = floatingReactionsLauncher;
    }

    private static String m29026a(GraphQLStory graphQLStory, FeedListType feedListType) {
        return StoryKeyUtil.m28909a(graphQLStory) + feedListType.toString();
    }

    private void m29027a(Props props, State state, ReactionsFooterView reactionsFooterView) {
        GraphQLStory graphQLStory = (GraphQLStory) props.f22360a.f13444a;
        FooterBinderUtil.m30298a(reactionsFooterView, state.f22412g, graphQLStory.mo2890l(), state.f22406a);
        ReactionsFooterBinderUtil.m30329a(reactionsFooterView, graphQLStory.mo2890l(), state.f22407b, state.f22408c, state.f22409d, this.f21341s, state.f22413h, state.f22414i);
        this.f21344v.m28982a(reactionsFooterView, graphQLStory);
        reactionsFooterView.f22308s = this.f21325c.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6717g, false);
    }

    private ButtonClickedListener m29024a(Props props, E e, Builder builder, String str) {
        final Props props2 = props;
        final String str2 = str;
        final Builder builder2 = builder;
        final E e2 = e;
        return new ButtonClickedListener(this) {
            final /* synthetic */ BaseReactionsFooterPartDefinition f22419e;

            public final void mo3276a(View view, FooterButtonId footerButtonId) {
                GraphQLStory graphQLStory = (GraphQLStory) props2.f22360a.f13444a;
                switch (3.a[footerButtonId.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        this.f22419e.f21342t.m28903f(graphQLStory);
                        FeedbackReaction d = graphQLStory.mo2890l().m23225S() == 0 ? this.f22419e.f21341s.m29093d() : FeedbackReaction.f21476c;
                        ReactionsFooterBinderUtil.m30330a(this.f22419e.f21336n, d);
                        boolean a = BaseReactionsFooterPartDefinition.m29028a(this.f22419e, view, d, str2, graphQLStory);
                        this.f22419e.f21324b.m26301a((FeedUnit) graphQLStory, builder2);
                        this.f22419e.f21326d.m29040a(graphQLStory.mo2890l(), d, builder2.m30319a(), null);
                        this.f22419e.f21329g.mo651a(new UfiEvents$ReactionUpdatedEvent(graphQLStory.m22350c(), graphQLStory.mo2507g(), d, a));
                        if (view instanceof FooterLikeButton) {
                            ((FooterLikeButton) view).setReaction(d);
                            return;
                        }
                        return;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        boolean z = props2.f22361b;
                        if (BaseReactionsFooterPartDefinition.m29029a(this.f22419e, e2, graphQLStory)) {
                            z = false;
                        }
                        FooterBinderUtil.m30296a(view, props2.f22360a, e2.mo2446c(), this.f22419e.f21330h, z, this.f22419e.f21342t);
                        return;
                    case 3:
                        FooterBinderUtil.m30295a(view, (NavigationLogger) this.f22419e.f21332j.get(), this.f22419e.f21331i, props2.f22360a, e2.mo2446c(), this.f22419e.f21329g, this.f22419e.f21333k, this.f22419e.f21342t);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public static boolean m29028a(BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition, View view, FeedbackReaction feedbackReaction, String str, GraphQLStory graphQLStory) {
        return ReactionsFooterBinderUtil.m30331a(baseReactionsFooterPartDefinition.f21337o, baseReactionsFooterPartDefinition.f21338p, baseReactionsFooterPartDefinition.f21339q, f21321a, baseReactionsFooterPartDefinition.f21340r, str, graphQLStory.mo2890l(), view, feedbackReaction);
    }

    public static boolean m29029a(BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition, HasFeedListType hasFeedListType, GraphQLStory graphQLStory) {
        if (!(hasFeedListType instanceof CanShowVideoInFullScreen)) {
            return false;
        }
        CanShowVideoInFullScreen canShowVideoInFullScreen = (CanShowVideoInFullScreen) hasFeedListType;
        GraphQLStoryAttachment p = GraphQLStoryUtil.m9585p(graphQLStory);
        if (!canShowVideoInFullScreen.mo2447c(p)) {
            return false;
        }
        canShowVideoInFullScreen.mo2443b(p);
        return true;
    }
}
