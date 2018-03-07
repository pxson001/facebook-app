package com.facebook.ipc.pages;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: place_save_success */
public class PageInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f6185a;

    static {
        GlobalAutoGenDeserializerCache.a(PageInfo.class, new PageInfoDeserializer());
        m8056e();
    }

    public PageInfoDeserializer() {
        a(PageInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m8056e() {
        Map<String, FbJsonField> map;
        synchronized (PageInfoDeserializer.class) {
            if (f6185a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("page_id", FbJsonField.jsonField(PageInfo.class.getDeclaredField("pageId")));
                    builder.b("name", FbJsonField.jsonField(PageInfo.class.getDeclaredField("pageName")));
                    builder.b("access_token", FbJsonField.jsonField(PageInfo.class.getDeclaredField("accessToken")));
                    builder.b("square_pic_url", FbJsonField.jsonField(PageInfo.class.getDeclaredField("squareProfilePicUrl")));
                    builder.b("perms", FbJsonField.jsonField(PageInfo.class.getDeclaredField("permission"), String.class));
                    builder.b("page_url", FbJsonField.jsonField(PageInfo.class.getDeclaredField("pageUrl")));
                    f6185a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f6185a;
        }
        return map;
    }

    public final FbJsonField m8057a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8056e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8056e().keySet());
    }
}
