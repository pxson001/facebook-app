package com.facebook.search.api.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: extra_logger_params */
public class SearchTypeaheadJsonResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15536a;

    static {
        GlobalAutoGenDeserializerCache.a(SearchTypeaheadJsonResult.class, new SearchTypeaheadJsonResultDeserializer());
        m23170e();
    }

    public SearchTypeaheadJsonResultDeserializer() {
        a(SearchTypeaheadJsonResult.class);
    }

    private static synchronized Map<String, FbJsonField> m23170e() {
        Map<String, FbJsonField> map;
        synchronized (SearchTypeaheadJsonResultDeserializer.class) {
            if (f15536a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("category", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("category")));
                    builder.b("friendship_status", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("friendshipStatus")));
                    builder.b("is_verified", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("isVerified")));
                    builder.b("native_android_url", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("nativeAndroidUrl")));
                    builder.b("path", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("path")));
                    builder.b("fallback_path", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("fallbackPath")));
                    builder.b("photo", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("photo")));
                    builder.b("subtext", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("subtext")));
                    builder.b("text", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("text")));
                    builder.b("type", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("type")));
                    builder.b("uid", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("uid")));
                    builder.b("matched_tokens", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("matchedTokens"), String.class));
                    builder.b("saved_state", FbJsonField.jsonField(SearchTypeaheadJsonResult.class.getDeclaredField("savedState")));
                    f15536a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15536a;
        }
        return map;
    }

    public final FbJsonField m23171a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23170e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23170e().keySet());
    }
}
