package com.facebook.feedplugins.base.footer.ui;

import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.analytics.AnalyticsHelper;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.events.LikeClicked;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.share.ShareLauncher;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ufiservices.event.UfiEvents$CommentButtonClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.ShareClickedEvent;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import javax.inject.Provider;

/* compiled from: gifdrawable */
public class FooterBinderUtil {
    public static void m30295a(View view, NavigationLogger navigationLogger, ShareLauncher shareLauncher, FeedProps<GraphQLStory> feedProps, FeedListType feedListType, FeedEventBus feedEventBus, FbErrorReporter fbErrorReporter, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        ComposerSourceType composerSourceType;
        Surface surface;
        feedDiscoveryFunnelLoggerUtil.m28904g((GraphQLStory) feedProps.f13444a);
        navigationLogger.m5498a("tap_share");
        feedEventBus.mo651a(new ShareClickedEvent());
        switch (1.a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                composerSourceType = ComposerSourceType.FEED;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                composerSourceType = ComposerSourceType.PERMALINK;
                break;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                composerSourceType = ComposerSourceType.TIMELINE;
                break;
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                composerSourceType = ComposerSourceType.GROUP;
                break;
            case 9:
                composerSourceType = ComposerSourceType.EVENT;
                break;
            case 10:
            case 11:
            case 12:
                composerSourceType = ComposerSourceType.SEARCH;
                break;
            case 13:
            case 14:
                composerSourceType = ComposerSourceType.ON_THIS_DAY_FEED;
                break;
            case 15:
                composerSourceType = ComposerSourceType.ON_THIS_DAY_BIRTHDAY_CARD;
                break;
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                composerSourceType = ComposerSourceType.REACTION;
                break;
            case 17:
                composerSourceType = ComposerSourceType.PHOTOS_FEED;
                break;
            case 18:
                composerSourceType = ComposerSourceType.VIDEO_CHANNEL;
                break;
            case 19:
                composerSourceType = ComposerSourceType.REDSPACE_SELF_INLINE;
                break;
            case 20:
                composerSourceType = ComposerSourceType.REDSPACE_FRIEND_INLINE;
                break;
            case 21:
                composerSourceType = ComposerSourceType.REVIEWS_LIST;
                break;
            default:
                fbErrorReporter.m2350b("composer_source_type_not_found", "No ComposerSourceType for " + feedListType);
                composerSourceType = ComposerSourceType.UNKNOWN;
                break;
        }
        ComposerSourceType composerSourceType2 = composerSourceType;
        switch (1.a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                surface = Surface.ANDROID_FEED_COMPOSER;
                break;
            case 3:
                surface = Surface.ANDROID_PAGE_COMPOSER;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                surface = Surface.ANDROID_TIMELINE_COMPOSER;
                break;
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                surface = Surface.ANDROID_GROUP_COMPOSER;
                break;
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                surface = Surface.ANDROID_AFTER_PARTY_COMPOSER;
                break;
            default:
                surface = Surface.ANDROID_COMPOSER;
                break;
        }
        shareLauncher.m28991a(feedProps, view, composerSourceType2, surface);
    }

    public static void m30296a(View view, FeedProps<GraphQLStory> feedProps, FeedListType feedListType, CommentClickedUtil commentClickedUtil, boolean z, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        feedDiscoveryFunnelLoggerUtil.m28902e((GraphQLStory) feedProps.f13444a);
        if (view != null) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
            if (z) {
                commentClickedUtil.f21293a.m28364a((FeedProps) feedProps, feedListType, view, FlyoutContext.FOOTER);
            }
            String g = graphQLStory.mo2507g();
            graphQLStory = StoryProps.m27456c(feedProps);
            commentClickedUtil.f21294b.mo651a(new UfiEvents$CommentButtonClickedEvent(g, graphQLStory != null ? graphQLStory.mo2507g() : null));
        }
    }

    public static void m30297a(FeedProps<GraphQLStory> feedProps, AnalyticsHelper analyticsHelper, FeedListType feedListType, EventsStream eventsStream, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        feedDiscoveryFunnelLoggerUtil.m28903f((GraphQLStory) feedProps.f13444a);
        eventsStream.m15231a(new LikeClicked(feedProps, AnalyticsHelper.m28995a(feedListType)));
    }

    public static EnumMap<FooterButtonId, TouchSpring> m30294a(HasPersistentState hasPersistentState, GraphQLStory graphQLStory, FeedListType feedListType) {
        return (EnumMap) hasPersistentState.mo2425a(new FooterButtonAndTouchSpringKey(graphQLStory, feedListType), (CacheableEntity) graphQLStory);
    }

    public static void m30300a(boolean z, boolean z2, boolean z3, EnumMap<FooterButtonId, TouchSpring> enumMap, Provider<TouchSpring> provider) {
        if (!enumMap.isEmpty()) {
            Object obj;
            if (z == enumMap.containsKey(FooterButtonId.LIKE) && z2 == enumMap.containsKey(FooterButtonId.COMMENT) && z3 == enumMap.containsKey(FooterButtonId.SHARE)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                enumMap.clear();
            } else {
                return;
            }
        }
        if (z) {
            m30299a((Provider) provider, (EnumMap) enumMap, FooterButtonId.LIKE);
        }
        if (z2) {
            m30299a((Provider) provider, (EnumMap) enumMap, FooterButtonId.COMMENT);
        }
        if (z3) {
            m30299a((Provider) provider, (EnumMap) enumMap, FooterButtonId.SHARE);
        }
    }

    public static void m30298a(Footer footer, EnumMap<FooterButtonId, TouchSpring> enumMap, GraphQLFeedback graphQLFeedback, ButtonClickedListener buttonClickedListener) {
        boolean z;
        footer.setButtons(enumMap.keySet());
        footer.setSprings(enumMap);
        if (graphQLFeedback == null) {
            z = false;
        } else {
            z = graphQLFeedback.y_();
        }
        footer.setIsLiked(z);
        footer.setOnButtonClickedListener(buttonClickedListener);
    }

    private static void m30299a(Provider<TouchSpring> provider, EnumMap<FooterButtonId, TouchSpring> enumMap, FooterButtonId footerButtonId) {
        enumMap.put(footerButtonId, (TouchSpring) provider.get());
    }
}
