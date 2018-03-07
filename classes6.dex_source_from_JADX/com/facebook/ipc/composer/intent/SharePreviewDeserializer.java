package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: life_event_type */
public class SharePreviewDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11602a;

    static {
        GlobalAutoGenDeserializerCache.a(SharePreview.class, new SharePreviewDeserializer());
        m18303e();
    }

    public SharePreviewDeserializer() {
        a(SharePreview.class);
    }

    private static synchronized Map<String, FbJsonField> m18303e() {
        Map<String, FbJsonField> map;
        synchronized (SharePreviewDeserializer.class) {
            if (f11602a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(SharePreview.class.getDeclaredField("title")));
                    builder.b("sub_title", FbJsonField.jsonField(SharePreview.class.getDeclaredField("subTitle")));
                    builder.b("summary", FbJsonField.jsonField(SharePreview.class.getDeclaredField("summary")));
                    builder.b("original_share_actor_name", FbJsonField.jsonField(SharePreview.class.getDeclaredField("originalShareActorName")));
                    builder.b("reshare_message", FbJsonField.jsonField(SharePreview.class.getDeclaredField("reshareMessage")));
                    builder.b("image_url", FbJsonField.jsonField(SharePreview.class.getDeclaredField("imageUrl")));
                    builder.b("image_width", FbJsonField.jsonField(SharePreview.class.getDeclaredField("imageWidth")));
                    builder.b("image_height", FbJsonField.jsonField(SharePreview.class.getDeclaredField("imageHeight")));
                    builder.b("is_override", FbJsonField.jsonField(SharePreview.class.getDeclaredField("isOverride")));
                    f11602a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11602a;
        }
        return map;
    }

    public final FbJsonField m18304a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18303e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18303e().keySet());
    }
}
