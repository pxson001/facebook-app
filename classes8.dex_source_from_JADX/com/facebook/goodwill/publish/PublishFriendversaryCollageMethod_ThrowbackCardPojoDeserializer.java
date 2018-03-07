package com.facebook.goodwill.publish;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.goodwill.publish.PublishFriendversaryCollageMethod.ThrowbackCardPojo;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: www. */
public class PublishFriendversaryCollageMethod_ThrowbackCardPojoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f182a;

    static {
        GlobalAutoGenDeserializerCache.a(ThrowbackCardPojo.class, new PublishFriendversaryCollageMethod_ThrowbackCardPojoDeserializer());
        m174e();
    }

    public PublishFriendversaryCollageMethod_ThrowbackCardPojoDeserializer() {
        a(ThrowbackCardPojo.class);
    }

    private static synchronized Map<String, FbJsonField> m174e() {
        Map<String, FbJsonField> map;
        synchronized (PublishFriendversaryCollageMethod_ThrowbackCardPojoDeserializer.class) {
            if (f182a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("campaign_id", FbJsonField.jsonField(ThrowbackCardPojo.class.getDeclaredField("campaign_id")));
                    builder.b("source", FbJsonField.jsonField(ThrowbackCardPojo.class.getDeclaredField("source")));
                    builder.b("media_ids", FbJsonField.jsonField(ThrowbackCardPojo.class.getDeclaredField("media_ids"), String.class));
                    f182a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f182a;
        }
        return map;
    }

    public final FbJsonField m175a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m174e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m174e().keySet());
    }
}
