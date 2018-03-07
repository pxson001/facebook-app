package com.facebook.notifications.mqtt;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.JewelCountHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONArray;

/* compiled from: fetchStickyGuardrailInfo */
public class NotificationsMqttPushHandler implements MqttPushHandler {
    private static final Class<?> f11688a = NotificationsMqttPushHandler.class;
    private final ObjectMapper f11689b;
    private final JewelCounters f11690c;
    private final NotificationsSyncManager f11691d;
    private final Provider<ViewerContext> f11692e;
    private final JewelCountHelper f11693f;
    private final AnalyticsLogger f11694g;
    private final FbSharedPreferences f11695h;
    private final GraphQLNotificationsContentProviderHelper f11696i;

    public static NotificationsMqttPushHandler m12238b(InjectorLike injectorLike) {
        return new NotificationsMqttPushHandler((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), JewelCounters.a(injectorLike), NotificationsSyncManager.m7821a(injectorLike), IdBasedProvider.a(injectorLike, 372), JewelCountHelper.m7817a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GraphQLNotificationsContentProviderHelper.m7861a(injectorLike));
    }

    @Inject
    public NotificationsMqttPushHandler(ObjectMapper objectMapper, JewelCounters jewelCounters, NotificationsSyncManager notificationsSyncManager, Provider<ViewerContext> provider, JewelCountHelper jewelCountHelper, AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper) {
        this.f11689b = objectMapper;
        this.f11690c = jewelCounters;
        this.f11691d = notificationsSyncManager;
        this.f11692e = provider;
        this.f11693f = jewelCountHelper;
        this.f11694g = analyticsLogger;
        this.f11695h = fbSharedPreferences;
        this.f11696i = graphQLNotificationsContentProviderHelper;
    }

    public void onMessage(String str, byte[] bArr) {
        try {
            if (this.f11692e.get() != null) {
                GraphQLStorySeenState graphQLStorySeenState = null;
                if ("/notifications_read".equals(str)) {
                    graphQLStorySeenState = GraphQLStorySeenState.SEEN_AND_READ;
                }
                if ("/notifications_seen".equals(str)) {
                    graphQLStorySeenState = GraphQLStorySeenState.SEEN_BUT_UNREAD;
                }
                if (graphQLStorySeenState != null) {
                    this.f11696i.m7892a(m12234a(bArr), graphQLStorySeenState, false);
                }
                if ("/notifications_sync".equals(str)) {
                    m12237a("mqtt_notifications_sync_received");
                    JsonNode a = this.f11689b.a(StringUtil.a(bArr));
                    if (a.d("u")) {
                        m12236a(a);
                    }
                    if (a.d("n")) {
                        this.f11695h.edit().a(NotificationsSyncConstants.f7690b, JSONUtil.a(a.b("i"), 30000));
                        m12235a();
                    }
                    if (a.d("s")) {
                        m12239b();
                    }
                    if (a.d("f")) {
                        m12240c();
                    }
                    if (a.d("r")) {
                        m12241d();
                    }
                }
            }
        } catch (Throwable e) {
            BLog.a(f11688a, "Failed to read mqtt message", e);
        }
    }

    private void m12236a(JsonNode jsonNode) {
        m12237a("mqtt_notifications_unseen_count");
        this.f11690c.a(Jewel.NOTIFICATIONS, JSONUtil.d(jsonNode.b("u")));
    }

    private void m12235a() {
        m12237a("mqtt_notifications_sync_new");
        this.f11691d.m7829a((ViewerContext) this.f11692e.get(), SyncSource.MQTT_NEW);
    }

    private void m12239b() {
        m12237a("mqtt_notifications_sync_full");
        this.f11691d.m7829a((ViewerContext) this.f11692e.get(), SyncSource.MQTT_FULL);
    }

    private void m12240c() {
        m12237a("mqtt_notifications_fetch_counts");
        this.f11693f.m7820a();
    }

    private void m12241d() {
        m12237a("mqtt_notifications_fetch_seen_state");
        this.f11691d.m7828a((ViewerContext) this.f11692e.get());
    }

    private ImmutableList<String> m12234a(byte[] bArr) {
        ImmutableList<String> immutableList = null;
        try {
            JsonNode b = this.f11689b.a(StringUtil.a(bArr)).b("graphql_ids");
            if (!(b == null || b.q())) {
                JSONArray jSONArray = new JSONArray(b.toString());
                Builder builder = ImmutableList.builder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    builder.c(jSONArray.getString(i));
                }
                immutableList = builder.b();
            }
        } catch (Throwable e) {
            BLog.a(f11688a, "Failed to read mqtt message", e);
        } catch (Throwable e2) {
            BLog.a(f11688a, "Failed to read graphql ids in mqtt message", e2);
        }
        return immutableList;
    }

    private void m12237a(String str) {
        HoneyClientEventFast a = this.f11694g.a(str, false);
        if (a.a()) {
            a.b();
        }
    }
}
