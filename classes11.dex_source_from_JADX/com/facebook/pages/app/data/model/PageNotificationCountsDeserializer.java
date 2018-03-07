package com.facebook.pages.app.data.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: tap_add_edit_button */
public class PageNotificationCountsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1133a;

    static {
        GlobalAutoGenDeserializerCache.a(PageNotificationCounts.class, new PageNotificationCountsDeserializer());
        m1530e();
    }

    public PageNotificationCountsDeserializer() {
        a(PageNotificationCounts.class);
    }

    private static synchronized Map<String, FbJsonField> m1530e() {
        Map<String, FbJsonField> map;
        synchronized (PageNotificationCountsDeserializer.class) {
            if (f1133a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("new_like_count", FbJsonField.jsonField(PageNotificationCounts.class.getDeclaredField("newLikeCount")));
                    builder.b("unseen_message_count", FbJsonField.jsonField(PageNotificationCounts.class.getDeclaredField("unseenMessageCount")));
                    builder.b("unread_message_count", FbJsonField.jsonField(PageNotificationCounts.class.getDeclaredField("unreadMessageCount")));
                    builder.b("unread_notif_count", FbJsonField.jsonField(PageNotificationCounts.class.getDeclaredField("unreadNotifCount")));
                    f1133a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1133a;
        }
        return map;
    }

    public final FbJsonField m1531a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1530e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1530e().keySet());
    }
}
