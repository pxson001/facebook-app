package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEvent;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterPersistentState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.links.AttachmentLinkLauncher;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_stickers */
public class DefaultAttachmentLinkClickHandler {
    private static final String f23897a = DefaultAttachmentLinkClickHandler.class.getSimpleName();
    private static DefaultAttachmentLinkClickHandler f23898o;
    private static final Object f23899p = new Object();
    public final CommonEventsBuilder f23900b;
    public final AttachmentLinkInspector f23901c;
    private final AttachmentLinkLauncher f23902d;
    private final AnalyticsLogger f23903e;
    private final Lazy<NavigationLogger> f23904f;
    private final LongClickTracker f23905g;
    private final FeedEventBus f23906h;
    public final NewsFeedAnalyticsEventBuilder f23907i;
    private final AbstractFbErrorReporter f23908j;
    private final InlineCommentComposerCache f23909k;
    private final NetworkMonitor f23910l;
    private final Clock f23911m;
    private final NewsfeedAnalyticsLogger f23912n;

    /* compiled from: fetch_stickers */
    public class AttachmentLinkFactory implements LinkEventFactory<FeedProps<GraphQLStoryAttachment>> {
        final /* synthetic */ DefaultAttachmentLinkClickHandler f23938a;
        private Map<String, ?> f23939b;

        public final HoneyClientEvent mo3510a(Object obj, View view) {
            FeedProps feedProps = (FeedProps) obj;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
            if (view instanceof HasFeedItemPageIndex) {
                FeedProps e = AttachmentProps.m28715e(feedProps);
                return this.f23938a.f23900b.m14542a(Strings.nullToEmpty(graphQLStoryAttachment.m23966C()), StoryProps.m27466p(e), TrackableFeedProps.m27451a(e), "native_newsfeed", ((HasFeedItemPageIndex) view).a());
            }
            FeedProps g = AttachmentProps.m28717g(feedProps);
            JsonNode b = g != null ? TrackableFeedProps.m27452b(g) : null;
            AttachmentLinkInspector attachmentLinkInspector = this.f23938a.f23901c;
            String str;
            if (AttachmentLinkInspector.m32231a(graphQLStoryAttachment)) {
                HoneyClientEvent honeyClientEvent;
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f23938a.f23907i;
                String dp = graphQLStoryAttachment.m23987z().dp();
                str = "open_graph";
                attachmentLinkInspector = this.f23938a.f23901c;
                boolean b2 = AttachmentLinkInspector.m32233b(feedProps);
                if (NewsFeedAnalyticsEventBuilder.m14092B(b) || dp == null || str == null) {
                    honeyClientEvent = null;
                } else {
                    honeyClientEvent = new HoneyClientEvent("open_open_graph_object").m5085a("tracking", b).m5097j(dp).m5090b("unit_type", str).mo699b(b2);
                    honeyClientEvent.f3099c = "native_newsfeed";
                    honeyClientEvent = honeyClientEvent;
                }
                return honeyClientEvent;
            }
            CommonEventsBuilder commonEventsBuilder = this.f23938a.f23900b;
            str = this.f23938a.f23901c.m32235a(feedProps);
            attachmentLinkInspector = this.f23938a.f23901c;
            return commonEventsBuilder.m14544a(str, AttachmentLinkInspector.m32233b(feedProps), b, "native_newsfeed", this.f23939b);
        }

        public AttachmentLinkFactory(DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler) {
            this.f23938a = defaultAttachmentLinkClickHandler;
        }

        public AttachmentLinkFactory(DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler, Map<String, ?> map) {
            this.f23938a = defaultAttachmentLinkClickHandler;
            this.f23939b = map;
        }
    }

    private static DefaultAttachmentLinkClickHandler m32292b(InjectorLike injectorLike) {
        return new DefaultAttachmentLinkClickHandler(CommonEventsBuilder.m14539b(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AttachmentLinkInspector.m32230a(injectorLike), AttachmentLinkLauncher.m32296a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), LongClickTracker.m14087a(injectorLike), FeedEventBus.m4573a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), NetworkMonitor.m13133a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), InlineCommentComposerCache.m14459a(injectorLike), NewsfeedAnalyticsLogger.m26299b(injectorLike));
    }

    public static DefaultAttachmentLinkClickHandler m32288a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultAttachmentLinkClickHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23899p) {
                DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler;
                if (a2 != null) {
                    defaultAttachmentLinkClickHandler = (DefaultAttachmentLinkClickHandler) a2.mo818a(f23899p);
                } else {
                    defaultAttachmentLinkClickHandler = f23898o;
                }
                if (defaultAttachmentLinkClickHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32292b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23899p, b3);
                        } else {
                            f23898o = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultAttachmentLinkClickHandler;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultAttachmentLinkClickHandler(CommonEventsBuilder commonEventsBuilder, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AttachmentLinkInspector attachmentLinkInspector, AttachmentLinkLauncher attachmentLinkLauncher, AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy, LongClickTracker longClickTracker, FeedEventBus feedEventBus, FbErrorReporter fbErrorReporter, NetworkMonitor networkMonitor, Clock clock, InlineCommentComposerCache inlineCommentComposerCache, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger) {
        this.f23901c = attachmentLinkInspector;
        this.f23902d = attachmentLinkLauncher;
        this.f23903e = analyticsLogger;
        this.f23904f = lazy;
        this.f23905g = longClickTracker;
        this.f23906h = feedEventBus;
        this.f23908j = fbErrorReporter;
        this.f23911m = clock;
        this.f23910l = networkMonitor;
        this.f23909k = inlineCommentComposerCache;
        this.f23900b = commonEventsBuilder;
        this.f23907i = newsFeedAnalyticsEventBuilder;
        this.f23912n = newsfeedAnalyticsLogger;
    }

    public final <E extends HasInvalidate & HasPersistentState> void m32295a(View view, FeedProps<GraphQLStoryAttachment> feedProps, LinkEventFactory<FeedProps<GraphQLStoryAttachment>> linkEventFactory, String str, FollowShareAttachmentPersistentState followShareAttachmentPersistentState, OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState, boolean z, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        ArrayNode b = m32293b((FeedProps) feedProps);
        String str2 = AttachmentLinkInspector.m32231a(graphQLStoryAttachment) ? "open_graph" : "other";
        ((NavigationLogger) this.f23904f.get()).m5498a("tap_story_attachment");
        HoneyClientEvent a = linkEventFactory.mo3510a(feedProps, view);
        FeedProps e2 = AttachmentProps.m28715e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e2.m19804a();
        this.f23909k.m14462a(graphQLStory, e, Boolean.valueOf(true));
        this.f23902d.m32305a(view.getContext(), str, this.f23902d.m32303a(b, (FeedProps) feedProps, str, m32289a(e, e2, null)), m32290a(feedProps, str2));
        if (graphQLStory != null) {
            this.f23912n.m26300a(a, (FeedUnit) graphQLStory);
        }
        if (!TrackingNodes.m27144a(a)) {
            TrackingNodes.m27142a(a, view);
        }
        if (m32291a(graphQLStoryAttachment)) {
            a.m5090b("article_ID", graphQLStoryAttachment.m23987z().dB().m23349m());
        }
        this.f23903e.mo528a(a);
        if (z) {
            followShareAttachmentPersistentState.m32607a(true);
            FetchTimeMsHelper.m22313a(graphQLStory, this.f23911m.mo211a() + 1);
            e.mo2437a(feedProps);
        }
        if (!this.f23910l.m13137a()) {
            offlineAttachmentSaveFooterPersistentState.m32620a(true);
            e.mo2437a(feedProps);
        }
        if (b != null && b.mo712e() != 0) {
            if (graphQLStory != null) {
                this.f23905g.m14090a(TrackableFeedProps.m27451a(e2), str);
            }
            FbEvent a2 = m32287a((FeedProps) feedProps);
            if (a2 != null) {
                this.f23906h.mo651a(a2);
            }
        }
    }

    public static String m32289a(Object obj, @Nullable FeedProps<GraphQLStory> feedProps, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null) {
            stringBuilder.append(str);
        }
        if (obj instanceof HasFeedListType) {
            FeedListType c = ((HasFeedListType) obj).mo2446c();
            if (c != null) {
                stringBuilder.append(c.mo2419a().name().toLowerCase());
            }
        }
        if (GraphQLStoryUtil.m9567a((FeedProps) feedProps)) {
            stringBuilder.append("_ads");
        }
        return stringBuilder.toString();
    }

    public final LinkEventFactory<FeedProps<GraphQLStoryAttachment>> m32294a() {
        return new AttachmentLinkFactory(this);
    }

    private static StoryEvents$OutboundClickedEvent m32287a(FeedProps<GraphQLStoryAttachment> feedProps) {
        String str = null;
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        if (feedProps == null) {
            return null;
        }
        if (AttachmentProps.m28712a((FeedProps) feedProps) != c) {
            str = AttachmentProps.m28712a((FeedProps) feedProps).mo2507g();
        }
        return new StoryEvents$OutboundClickedEvent(c.mo2507g(), str);
    }

    private ArrayNode m32293b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        FeedProps g = AttachmentProps.m28717g(feedProps);
        if (g != null) {
            return TrackableFeedProps.m27452b(g);
        }
        SoftErrorBuilder a = SoftError.a(StringFormatUtil.a("%s parent:%s, url:%s mediaUrl:%s title:%s subtitle:%s dedupkey:%s", new Object[]{f23897a, g, Strings.nullToEmpty(graphQLStoryAttachment.m23966C()), GraphQLStoryAttachmentUtil.m28064o(graphQLStoryAttachment), graphQLStoryAttachment.m23964A(), GraphQLStoryAttachmentUtil.m28068s(graphQLStoryAttachment), graphQLStoryAttachment.m23974m()}), "NPE of attachment story");
        a.f = true;
        this.f23908j.mo336a(a.g());
        return null;
    }

    private Map<String, Object> m32290a(FeedProps<GraphQLStoryAttachment> feedProps, String str) {
        JsonNode jsonNode = null;
        if (!AttachmentLinkInspector.m32234c(feedProps)) {
            return null;
        }
        FeedProps g = AttachmentProps.m28717g(feedProps);
        if (g != null) {
            jsonNode = TrackableFeedProps.m27452b(g);
        }
        return NewsFeedAnalyticsEventBuilder.m14117b(str, "native", AttachmentLinkInspector.m32233b((FeedProps) feedProps), jsonNode);
    }

    private static boolean m32291a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().dB() == null) ? false : true;
    }
}
