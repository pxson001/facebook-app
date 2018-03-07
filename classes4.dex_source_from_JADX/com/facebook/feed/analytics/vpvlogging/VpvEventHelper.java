package com.facebook.feed.analytics.vpvlogging;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.analytics.vpvlogging.debugger.VpvLoggingDebugger;
import com.facebook.feed.data.freshfeed.ranking.ClientRankingSignal;
import com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore;
import com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.ViewportViewEvents.FeedVisibilityEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.Boolean_IsTabletLandscapeMethodAutoProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import com.facebook.video.videohome.logging.VideoVPVParametersHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: property ' */
public class VpvEventHelper {
    private static final String f4068a = VpvEventHelper.class.getSimpleName();
    private final Boolean f4069b;
    private final Boolean f4070c;
    private final FbObjectMapper f4071d;
    private final AbstractFbErrorReporter f4072e;
    private final FeedEventBus f4073f;
    private final Clock f4074g;
    private final VpvLoggingHandler f4075h;
    private final NewsfeedAnalyticsLogger f4076i;
    private final GatekeeperStoreImpl f4077j;
    private final VideoVPVParametersHelper f4078k;
    private final VpvLoggingDebugger f4079l;
    private final ClientRankingSignalStore f4080m;
    private long f4081n;

    public static VpvEventHelper m4603b(InjectorLike injectorLike) {
        return new VpvEventHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FeedEventBus.a(injectorLike), Boolean_IsTabletLandscapeMethodAutoProvider.m4616a(injectorLike), Boolean_IsTabletMethodAutoProvider.a(injectorLike), VpvLoggingHandler.m4618a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), NewsfeedAnalyticsLogger.b(injectorLike), VideoVPVParametersHelper.m4622a(injectorLike), VpvLoggingDebuggerMethodAutoProvider.m4624b(injectorLike), ClientRankingSignalStore.a(injectorLike));
    }

    public static VpvEventHelper m4599a(InjectorLike injectorLike) {
        return m4603b(injectorLike);
    }

    @Inject
    public VpvEventHelper(Clock clock, FbObjectMapper fbObjectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FeedEventBus feedEventBus, Boolean bool, Boolean bool2, VpvLoggingHandler vpvLoggingHandler, GatekeeperStoreImpl gatekeeperStoreImpl, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, VideoVPVParametersHelper videoVPVParametersHelper, VpvLoggingDebugger vpvLoggingDebugger, ClientRankingSignalStore clientRankingSignalStore) {
        this.f4072e = abstractFbErrorReporter;
        this.f4071d = fbObjectMapper;
        this.f4073f = feedEventBus;
        this.f4074g = clock;
        this.f4069b = bool;
        this.f4070c = bool2;
        this.f4075h = vpvLoggingHandler;
        this.f4077j = gatekeeperStoreImpl;
        this.f4076i = newsfeedAnalyticsLogger;
        this.f4078k = videoVPVParametersHelper;
        this.f4079l = vpvLoggingDebugger;
        this.f4080m = clientRankingSignalStore;
    }

    public final void m4609a(@Nullable JsonNode jsonNode, long j, String str) {
        m4611a(jsonNode, j, str, null, -1, null, null);
    }

    public final void m4611a(@Nullable JsonNode jsonNode, long j, String str, FeedUnit feedUnit, int i, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        m4610a(jsonNode, j, str, feedUnit, i, str2, 0, immutableMap);
    }

    public final void m4610a(@Nullable JsonNode jsonNode, long j, String str, FeedUnit feedUnit, int i, String str2, int i2, @Nullable ImmutableMap<String, String> immutableMap) {
        if (m4602a(jsonNode)) {
            HoneyClientEvent g = new HoneyClientEvent("vpv_duration").a("tracking", jsonNode).a("vpvd_time_delta", j).g(str);
            if ("native_timeline".equals(str)) {
                m4604b(g, feedUnit);
            }
            long j2 = 0;
            if (feedUnit != null && feedUnit.T_() > 0) {
                j2 = this.f4074g.a() - feedUnit.T_();
            }
            NewsfeedAnalyticsLogger.a(g, i, str2, j2, i2);
            if ("video_home".equals(str)) {
                m4605c(g, feedUnit);
            }
            m4600a(g, feedUnit);
            m4601a(g, (ImmutableMap) immutableMap);
            this.f4079l.mo329a(feedUnit, j);
            Integer.valueOf(i);
            Long.valueOf(j);
            if (m4606c()) {
                this.f4075h.m4621b(g);
            } else {
                this.f4075h.m4620a(g);
            }
        }
    }

    private void m4600a(HoneyClientEvent honeyClientEvent, FeedUnit feedUnit) {
        if (m4607d() && feedUnit != null && feedUnit.g() != null) {
            ClientRankingSignal a = this.f4080m.a(feedUnit.g());
            GlobalClientRankingSignal a2 = this.f4080m.a();
            if (a != null) {
                try {
                    honeyClientEvent.b("client_feature", this.f4071d.a(a));
                } catch (Throwable e) {
                    BLog.b(f4068a, "Error creating client feature json string", e);
                    return;
                }
            }
            if (a2 != null) {
                honeyClientEvent.b("global_feature", this.f4071d.a(a2));
            }
        }
    }

    private static void m4601a(HoneyClientEvent honeyClientEvent, @Nullable ImmutableMap<String, String> immutableMap) {
        if (immutableMap != null) {
            honeyClientEvent.a(immutableMap);
        }
    }

    public final void m4614a(@Nullable String str, long j, String str2) {
        if (str != null) {
            JsonNode jsonNode = null;
            try {
                jsonNode = this.f4071d.a(str);
            } catch (Throwable e) {
                this.f4072e.a(SoftError.m4758a("VpvEventHelper", "parse trackingCodes error").m4762a(e).m4765g());
            }
            m4609a(jsonNode, j, str2);
        }
    }

    public final void m4612a(JsonNode jsonNode, String str, int i, int i2, String str2, FeedUnit feedUnit, ImmutableMap<String, String> immutableMap) {
        Preconditions.checkArgument(m4602a(jsonNode));
        HoneyClientEvent a = new HoneyClientEvent("viewport_visible").a("tracking", jsonNode).a("vpv_seq_id", i);
        a.c = str;
        HoneyClientEvent honeyClientEvent = a;
        if ("native_timeline".equals(str)) {
            m4604b(honeyClientEvent, feedUnit);
        }
        NewsfeedAnalyticsLogger.a(honeyClientEvent, i2, str2, 0, 0);
        if (this.f4070c.booleanValue()) {
            honeyClientEvent.b("impression_type", this.f4069b.booleanValue() ? "landscape" : "portrait");
        }
        m4601a(honeyClientEvent, (ImmutableMap) immutableMap);
        Integer.valueOf(i2);
        if (m4606c()) {
            this.f4075h.m4621b(honeyClientEvent);
        } else {
            this.f4075h.m4620a(honeyClientEvent);
        }
    }

    private static boolean m4602a(@Nullable JsonNode jsonNode) {
        return jsonNode != null && (!(jsonNode.k() == JsonNodeType.STRING && jsonNode.q()) && (jsonNode.k() == JsonNodeType.STRING || jsonNode.e() != 0));
    }

    private static void m4604b(HoneyClientEvent honeyClientEvent, FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            honeyClientEvent.a("vpv_seen_state", ((GraphQLStory) feedUnit).au().ordinal());
        }
    }

    private void m4605c(HoneyClientEvent honeyClientEvent, FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            VideoVPVParametersHelper videoVPVParametersHelper = this.f4078k;
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            if (graphQLStory != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                if (o != null) {
                    GraphQLVideo b = GraphQLMediaConversionHelper.b(o.r());
                    if (b != null) {
                        String J = b.J();
                        if (J != null) {
                            ImmutableMap a = videoVPVParametersHelper.f4090a.a(J);
                            if (a != null) {
                                honeyClientEvent.a(a);
                            }
                        }
                    }
                }
            }
            if (videoVPVParametersHelper.f4091b.i()) {
                honeyClientEvent.b(VideoHomeAnalyticsAttributes.SESSION_ID.value, videoVPVParametersHelper.f4091b.d);
            }
        }
    }

    public final void m4608a() {
        this.f4073f.a(new FeedVisibilityEvent(false));
    }

    public final void m4615b() {
        this.f4081n = this.f4074g.a();
    }

    public final void m4613a(ArrayNode arrayNode, String str) {
        long a = this.f4074g.a() - this.f4081n;
        if (arrayNode != null) {
            m4609a((JsonNode) arrayNode, a, str);
        }
    }

    private boolean m4606c() {
        return this.f4077j.a(775, false);
    }

    private boolean m4607d() {
        return this.f4077j.a(652, false);
    }
}
