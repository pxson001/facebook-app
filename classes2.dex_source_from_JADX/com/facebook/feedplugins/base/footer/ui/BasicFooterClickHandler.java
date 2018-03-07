package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.AnalyticsHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.share.ShareLauncher;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_seen_full_screen_emoji_nux */
public class BasicFooterClickHandler {
    private static BasicFooterClickHandler f21267i;
    private static final Object f21268j = new Object();
    private final EventsStream f21269a;
    private final ShareLauncher f21270b;
    private final AbstractFbErrorReporter f21271c;
    private final Lazy<NavigationLogger> f21272d;
    private final CommentClickedUtil f21273e;
    private final FeedEventBus f21274f;
    private final AnalyticsHelper f21275g;
    private final FeedDiscoveryFunnelLoggerUtil f21276h;

    private static BasicFooterClickHandler m28984b(InjectorLike injectorLike) {
        return new BasicFooterClickHandler(FbErrorReporterImpl.m2317a(injectorLike), EventsStream.m15220a(injectorLike), ShareLauncher.m28986a(injectorLike), CommentClickedUtil.m28992a(injectorLike), AnalyticsHelper.m28994a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), FeedEventBus.m4573a(injectorLike), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike));
    }

    @Inject
    public BasicFooterClickHandler(FbErrorReporter fbErrorReporter, EventsStream eventsStream, ShareLauncher shareLauncher, CommentClickedUtil commentClickedUtil, AnalyticsHelper analyticsHelper, Lazy<NavigationLogger> lazy, FeedEventBus feedEventBus, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        this.f21271c = fbErrorReporter;
        this.f21269a = eventsStream;
        this.f21270b = shareLauncher;
        this.f21273e = commentClickedUtil;
        this.f21275g = analyticsHelper;
        this.f21274f = feedEventBus;
        this.f21276h = feedDiscoveryFunnelLoggerUtil;
        this.f21272d = lazy;
    }

    public static BasicFooterClickHandler m28983a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterClickHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21268j) {
                BasicFooterClickHandler basicFooterClickHandler;
                if (a2 != null) {
                    basicFooterClickHandler = (BasicFooterClickHandler) a2.mo818a(f21268j);
                } else {
                    basicFooterClickHandler = f21267i;
                }
                if (basicFooterClickHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28984b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21268j, b3);
                        } else {
                            f21267i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterClickHandler;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m28985a(FeedProps<GraphQLStory> feedProps, View view, FooterButtonId footerButtonId, boolean z, FeedListType feedListType) {
        switch (1.a[footerButtonId.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                FooterBinderUtil.m30297a((FeedProps) feedProps, this.f21275g, feedListType, this.f21269a, this.f21276h);
                view.sendAccessibilityEvent(8);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                FooterBinderUtil.m30296a(view, feedProps, feedListType, this.f21273e, z, this.f21276h);
                return;
            case 3:
                FooterBinderUtil.m30295a(view, (NavigationLogger) this.f21272d.get(), this.f21270b, feedProps, feedListType, this.f21274f, this.f21271c, this.f21276h);
                return;
            default:
                return;
        }
    }
}
