package com.facebook.groups.treehouse.groupsstore;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: profile_picture_popover_menu_item_click */
public class GroupsStoreUnseenCountUpdateDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5815a;

    static {
        GlobalAutoGenDeserializerCache.a(GroupsStoreUnseenCountUpdate.class, new GroupsStoreUnseenCountUpdateDeserializer());
        m7216e();
    }

    public GroupsStoreUnseenCountUpdateDeserializer() {
        a(GroupsStoreUnseenCountUpdate.class);
    }

    private static synchronized Map<String, FbJsonField> m7216e() {
        Map<String, FbJsonField> map;
        synchronized (GroupsStoreUnseenCountUpdateDeserializer.class) {
            if (f5815a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("group_id", FbJsonField.jsonField(GroupsStoreUnseenCountUpdate.class.getDeclaredField("groupId")));
                    builder.b("unseen", FbJsonField.jsonField(GroupsStoreUnseenCountUpdate.class.getDeclaredField("unseenCount")));
                    f5815a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5815a;
        }
        return map;
    }

    public final FbJsonField m7217a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7216e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7216e().keySet());
    }
}
