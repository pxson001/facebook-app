package com.facebook.bookmark.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: recycler_view_enabled */
public class BookmarksGroupDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5673a;

    static {
        GlobalAutoGenDeserializerCache.a(BookmarksGroup.class, new BookmarksGroupDeserializer());
        m5887e();
    }

    public BookmarksGroupDeserializer() {
        a(BookmarksGroup.class);
    }

    private static synchronized Map<String, FbJsonField> m5887e() {
        Map<String, FbJsonField> map;
        synchronized (BookmarksGroupDeserializer.class) {
            if (f5673a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(BookmarksGroup.class.getDeclaredField("id")));
                    builder.b("name", FbJsonField.jsonField(BookmarksGroup.class.getDeclaredField("name")));
                    builder.b("visible_count", FbJsonField.jsonField(BookmarksGroup.class.getDeclaredField("mVisibleCount")));
                    builder.b("all", FbJsonField.jsonField(BookmarksGroup.class.getDeclaredField("mAll"), Bookmark.class));
                    f5673a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5673a;
        }
        return map;
    }

    public final FbJsonField m5888a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m5887e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m5887e().keySet());
    }
}
