package com.facebook.notifications.impressionlogging;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.apptab.state.TabTag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: next_page_title */
public class NotificationsFeedViewportEventListener extends BaseViewportEventListener {
    private final AnalyticsLogger f8160a;
    private final int f8161b;
    private final Clock f8162c;
    private final DefaultNotificationsRenderer f8163d;
    private final NotificationFeedViewportLoggingDataController f8164e;

    public static NotificationsFeedViewportEventListener m9786a(InjectorLike injectorLike) {
        return new NotificationsFeedViewportEventListener(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), NotificationFeedViewportLoggingDataController.m9783a(injectorLike), DefaultNotificationsRenderer.a(injectorLike));
    }

    @Inject
    public NotificationsFeedViewportEventListener(AnalyticsLogger analyticsLogger, Clock clock, Context context, NotificationFeedViewportLoggingDataController notificationFeedViewportLoggingDataController, DefaultNotificationsRenderer defaultNotificationsRenderer) {
        this.f8160a = analyticsLogger;
        this.f8162c = clock;
        this.f8164e = notificationFeedViewportLoggingDataController;
        this.f8163d = defaultNotificationsRenderer;
        this.f8161b = this.f8163d.a(context);
    }

    private long m9785a(TransientNotifImpressionLoggingData transientNotifImpressionLoggingData) {
        return this.f8162c.a() - transientNotifImpressionLoggingData.f8168d;
    }

    public final void m9792a(Object obj) {
        NotificationsEdgeFields c = m9789c(obj);
        if (c != null) {
            this.f8164e.m9784a(c).f8168d = this.f8162c.a();
        }
    }

    public final void m9791a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        View f = scrollingViewProxy.f(i2);
        if (f != null) {
            NotificationsEdgeFields c = m9789c(obj);
            if (c != null) {
                TransientNotifImpressionLoggingData a = this.f8164e.m9784a(c);
                a.f8167c = f.getMeasuredWidth();
                int measuredHeight = f.getMeasuredHeight();
                a.f8166b.put(m9790d(obj), Integer.valueOf(measuredHeight));
                a.f8165a = i + i2;
            }
        }
    }

    public final void m9793b(Object obj) {
        NotificationsEdgeFields c = m9789c(obj);
        if (c != null) {
            m9788a(c, this.f8164e.m9784a(c));
        }
    }

    private void m9788a(NotificationsEdgeFields notificationsEdgeFields, TransientNotifImpressionLoggingData transientNotifImpressionLoggingData) {
        boolean z;
        GraphQLStory k = notificationsEdgeFields.k();
        HoneyClientEvent a = new HoneyClientEvent("notification_unbatched_true_impression").b("cache_id", k.g()).b("graphql_id", k.c()).a("width_of_notification", transientNotifImpressionLoggingData.f8167c);
        String str = "height_of_notification";
        int i = 0;
        for (int i2 = 0; i2 < transientNotifImpressionLoggingData.f8166b.size(); i2++) {
            i += ((Integer) transientNotifImpressionLoggingData.f8166b.get(transientNotifImpressionLoggingData.f8166b.keyAt(i2))).intValue();
        }
        HoneyClientEvent a2 = a.a(str, i).a("is_highlighted", GraphQLNotifImportanceType.IMPORTANT.equals(notificationsEdgeFields.g()));
        String str2 = "is_rich_notif";
        if (notificationsEdgeFields.n() == null || notificationsEdgeFields.gs_()) {
            z = false;
        } else {
            z = true;
        }
        a = a2.a(str2, z).b("notif_type", m9787a(k)).a("offset_from_top", transientNotifImpressionLoggingData.f8165a * this.f8161b).a("row_number", transientNotifImpressionLoggingData.f8165a).b("seen_state", k.au().name()).a("visible_duration", m9785a(transientNotifImpressionLoggingData));
        a.c = TabTag.Notifications.analyticsTag;
        this.f8160a.a(a);
    }

    private static NotificationsEdgeFields m9789c(@Nullable Object obj) {
        if (!(obj instanceof BoundedAdapter)) {
            return null;
        }
        BoundedAdapter boundedAdapter = (BoundedAdapter) obj;
        if (boundedAdapter.a == null || boundedAdapter.a.b == null || !(boundedAdapter.a.b instanceof NotificationsEdgeFields)) {
            return null;
        }
        return (NotificationsEdgeFields) boundedAdapter.a.b;
    }

    private static String m9787a(GraphQLStory graphQLStory) {
        String str = null;
        if (graphQLStory.k() != null) {
            try {
                JSONObject jSONObject = new JSONObject(graphQLStory.k());
                if (jSONObject.getString("notif_type") != null) {
                    str = jSONObject.getString("notif_type");
                }
            } catch (JSONException e) {
            }
        }
        return str;
    }

    private static int m9790d(Object obj) {
        if (!(obj instanceof BoundedAdapter)) {
            return 0;
        }
        BoundedAdapter boundedAdapter = (BoundedAdapter) obj;
        if (boundedAdapter.a != null) {
            return boundedAdapter.b;
        }
        return 0;
    }
}
