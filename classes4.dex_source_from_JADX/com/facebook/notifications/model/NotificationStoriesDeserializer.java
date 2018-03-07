package com.facebook.notifications.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: hash_secret_salt */
public class NotificationStoriesDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10811a;

    static {
        GlobalAutoGenDeserializerCache.a(NotificationStories.class, new NotificationStoriesDeserializer());
        m11246e();
    }

    public NotificationStoriesDeserializer() {
        a(NotificationStories.class);
    }

    private static synchronized Map<String, FbJsonField> m11246e() {
        Map<String, FbJsonField> map;
        synchronized (NotificationStoriesDeserializer.class) {
            if (f10811a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("edges", FbJsonField.jsonField(NotificationStories.class.getDeclaredField("newStories"), FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.class));
                    builder.b("deltas", FbJsonField.jsonField(NotificationStories.class.getDeclaredField("deltaStories")));
                    builder.b("page_info", FbJsonField.jsonField(NotificationStories.class.getDeclaredField("pageInfo")));
                    f10811a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10811a;
        }
        return map;
    }

    public final FbJsonField m11247a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11246e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11246e().keySet());
    }
}
