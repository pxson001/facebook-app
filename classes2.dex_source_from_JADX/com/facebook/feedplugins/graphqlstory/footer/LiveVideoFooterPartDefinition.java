package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.AnalyticsHelper;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedplugins.base.footer.ui.CommentClickedUtil;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterBinderUtil;
import com.facebook.feedplugins.base.footer.ui.FooterButtonAndTouchSpringKey;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.share.ShareLauncher;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: has_viewer_favorited */
public class LiveVideoFooterPartDefinition<E extends CanFeedback & CanShowVideoInFullScreen & HasFeedListType & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, DefaultFooterView> {
    private static LiveVideoFooterPartDefinition f21230m;
    private static final Object f21231n = new Object();
    private final DefaultFooterPartDefinition f21232a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f21233b;
    private final GraphQLStoryUtil f21234c;
    private final EventsStream f21235d;
    private final ShareLauncher f21236e;
    private final AbstractFbErrorReporter f21237f;
    private final Provider<TouchSpring> f21238g;
    private final Lazy<NavigationLogger> f21239h;
    private final CommentClickedUtil f21240i;
    private final FeedEventBus f21241j;
    private final AnalyticsHelper f21242k;
    private final FeedDiscoveryFunnelLoggerUtil f21243l;

    private static LiveVideoFooterPartDefinition m28954b(InjectorLike injectorLike) {
        return new LiveVideoFooterPartDefinition(DefaultFooterPartDefinition.m28960a(injectorLike), FooterBackgroundPartDefinition.m28997a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), EventsStream.m15220a(injectorLike), ShareLauncher.m28986a(injectorLike), CommentClickedUtil.m28992a(injectorLike), AnalyticsHelper.m28994a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), IdBasedProvider.m1811a(injectorLike, 3736), FeedEventBus.m4573a(injectorLike), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        CanFeedback canFeedback = (CanFeedback) anyEnvironment;
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.f13444a;
        EnumMap enumMap = (EnumMap) ((HasPersistentState) canFeedback).mo2425a(new FooterButtonAndTouchSpringKey(cacheableEntity, ((HasFeedListType) canFeedback).mo2446c()), cacheableEntity);
        ButtonClickedListener 1 = new 1(this, feedProps, canFeedback);
        FooterBinderUtil.m30300a(cacheableEntity.m22369z(), cacheableEntity.m22315A(), StorySharingHelper.m30305b(cacheableEntity), enumMap, this.f21238g);
        subParts.mo2756a(this.f21233b, new Props(feedProps, this.f21232a.m28963a(feedProps, (HasPersistentState) canFeedback)));
        return new State(enumMap, 1);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1101577702);
        State state = (State) obj2;
        FooterBinderUtil.m30298a((DefaultFooterView) view, state.a, ((GraphQLStory) ((FeedProps) obj).f13444a).mo2890l(), state.b);
        Logger.a(8, EntryType.MARK_POP, 205000182, a);
    }

    public final boolean m28958a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f21234c.m9604o((GraphQLStory) feedProps.f13444a) && this.f21234c.m9594c(feedProps);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((DefaultFooterView) view).mo3251a();
    }

    public static LiveVideoFooterPartDefinition m28952a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveVideoFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21231n) {
                LiveVideoFooterPartDefinition liveVideoFooterPartDefinition;
                if (a2 != null) {
                    liveVideoFooterPartDefinition = (LiveVideoFooterPartDefinition) a2.mo818a(f21231n);
                } else {
                    liveVideoFooterPartDefinition = f21230m;
                }
                if (liveVideoFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28954b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21231n, b3);
                        } else {
                            f21230m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = liveVideoFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public LiveVideoFooterPartDefinition(DefaultFooterPartDefinition defaultFooterPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, GraphQLStoryUtil graphQLStoryUtil, FbErrorReporter fbErrorReporter, EventsStream eventsStream, ShareLauncher shareLauncher, CommentClickedUtil commentClickedUtil, AnalyticsHelper analyticsHelper, Lazy<NavigationLogger> lazy, Provider<TouchSpring> provider, FeedEventBus feedEventBus, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        this.f21232a = defaultFooterPartDefinition;
        this.f21233b = footerBackgroundPartDefinition;
        this.f21234c = graphQLStoryUtil;
        this.f21237f = fbErrorReporter;
        this.f21235d = eventsStream;
        this.f21236e = shareLauncher;
        this.f21240i = commentClickedUtil;
        this.f21242k = analyticsHelper;
        this.f21239h = lazy;
        this.f21238g = provider;
        this.f21241j = feedEventBus;
        this.f21243l = feedDiscoveryFunnelLoggerUtil;
    }

    public static void m28953a(LiveVideoFooterPartDefinition liveVideoFooterPartDefinition, FeedProps feedProps, View view, CanFeedback canFeedback, FooterButtonId footerButtonId) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        boolean z = true;
        switch (2.a[footerButtonId.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                FooterBinderUtil.m30297a(feedProps, liveVideoFooterPartDefinition.f21242k, ((HasFeedListType) canFeedback).mo2446c(), liveVideoFooterPartDefinition.f21235d, liveVideoFooterPartDefinition.f21243l);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                GraphQLStoryAttachment p = GraphQLStoryUtil.m9585p(graphQLStory);
                if (((CanShowVideoInFullScreen) canFeedback).mo2447c(p)) {
                    ((CanShowVideoInFullScreen) canFeedback).mo2443b(p);
                    z = false;
                }
                FooterBinderUtil.m30296a(view, feedProps, ((HasFeedListType) canFeedback).mo2446c(), liveVideoFooterPartDefinition.f21240i, z, liveVideoFooterPartDefinition.f21243l);
                return;
            case 3:
                FooterBinderUtil.m30295a(view, (NavigationLogger) liveVideoFooterPartDefinition.f21239h.get(), liveVideoFooterPartDefinition.f21236e, feedProps, ((HasFeedListType) canFeedback).mo2446c(), liveVideoFooterPartDefinition.f21241j, liveVideoFooterPartDefinition.f21237f, liveVideoFooterPartDefinition.f21243l);
                return;
            default:
                return;
        }
    }

    public final ViewType mo2547a() {
        return DefaultFooterView.f22314a;
    }
}
