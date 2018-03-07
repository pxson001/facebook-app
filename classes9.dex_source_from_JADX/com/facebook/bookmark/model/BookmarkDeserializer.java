package com.facebook.bookmark.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reference_no_1 */
public class BookmarkDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5670a;

    static {
        GlobalAutoGenDeserializerCache.a(Bookmark.class, new BookmarkDeserializer());
        m5865e();
    }

    public BookmarkDeserializer() {
        a(Bookmark.class);
    }

    private static synchronized Map<String, FbJsonField> m5865e() {
        Map<String, FbJsonField> map;
        synchronized (BookmarkDeserializer.class) {
            if (f5670a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(Bookmark.class.getDeclaredField("id")));
                    builder.b("name", FbJsonField.jsonField(Bookmark.class.getDeclaredField("name")));
                    builder.b("url", FbJsonField.jsonField(Bookmark.class.getDeclaredField("url")));
                    builder.b("pic", FbJsonField.jsonField(Bookmark.class.getDeclaredField("pic")));
                    builder.b("type", FbJsonField.jsonField(Bookmark.class.getDeclaredField("type")));
                    builder.b("client_token", FbJsonField.jsonField(Bookmark.class.getDeclaredField("clientToken")));
                    builder.b("count", FbJsonField.jsonField(Bookmark.class.getDeclaredField("mCount")));
                    builder.b("count_string", FbJsonField.jsonField(Bookmark.class.getDeclaredField("mCountString")));
                    f5670a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5670a;
        }
        return map;
    }

    public final FbJsonField m5866a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m5865e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m5865e().keySet());
    }
}
