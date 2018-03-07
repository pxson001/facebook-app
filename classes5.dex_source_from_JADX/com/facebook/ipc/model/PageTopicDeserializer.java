package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEST_SPLITTABLE */
public class PageTopicDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14133a;

    static {
        GlobalAutoGenDeserializerCache.a(PageTopic.class, new PageTopicDeserializer());
        m23518e();
    }

    public PageTopicDeserializer() {
        a(PageTopic.class);
    }

    private static synchronized Map<String, FbJsonField> m23518e() {
        Map<String, FbJsonField> map;
        synchronized (PageTopicDeserializer.class) {
            if (f14133a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(PageTopic.class.getDeclaredField("id")));
                    builder.b("name", FbJsonField.jsonField(PageTopic.class.getDeclaredField("displayName")));
                    builder.b("pic_square", FbJsonField.jsonField(PageTopic.class.getDeclaredField("pic")));
                    builder.b("parent_ids", FbJsonField.jsonField(PageTopic.class.getDeclaredField("parentIds"), Long.class));
                    builder.b("count", FbJsonField.jsonField(PageTopic.class.getDeclaredField("pageCount")));
                    f14133a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14133a;
        }
        return map;
    }

    public final FbJsonField m23519a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23518e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23518e().keySet());
    }
}
