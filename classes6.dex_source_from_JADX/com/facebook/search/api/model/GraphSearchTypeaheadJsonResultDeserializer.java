package com.facebook.search.api.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: extra_logging_params */
public class GraphSearchTypeaheadJsonResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15535a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphSearchTypeaheadJsonResult.class, new GraphSearchTypeaheadJsonResultDeserializer());
        m23168e();
    }

    public GraphSearchTypeaheadJsonResultDeserializer() {
        a(GraphSearchTypeaheadJsonResult.class);
    }

    private static synchronized Map<String, FbJsonField> m23168e() {
        Map<String, FbJsonField> map;
        synchronized (GraphSearchTypeaheadJsonResultDeserializer.class) {
            if (f15535a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("grammar_result_set_type", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("grammerResultSetType")));
                    builder.b("result_type", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("resultType")));
                    builder.b("fragments", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("fragments"), GraphSearchQueryFragment.class));
                    builder.b("semantic", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("semantic")));
                    builder.b("grammar_type", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("grammarType")));
                    builder.b("name", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("name")));
                    builder.b("category", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("category")));
                    builder.b("subtext", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("subtext")));
                    builder.b("bolded_subtext", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("boldedSubtext")));
                    builder.b("keyword_type", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("keywordType")));
                    builder.b("keyword_source", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("keywordSource")));
                    builder.b("photo", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("photoUri")));
                    builder.b("matched_pos", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("matchedPos")));
                    builder.b("matched_length", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("matchedLength")));
                    builder.b("friendship_status", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("friendshipStatus")));
                    builder.b("is_verified", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("isVerified")));
                    builder.b("verification_status", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("verificationStatus")));
                    builder.b("can_like", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("canLike")));
                    builder.b("path", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("path")));
                    builder.b("fallback_path", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("fallbackPath")));
                    builder.b("is_scoped", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("isScoped")));
                    builder.b("uid", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("uid")));
                    builder.b("creation_time", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("creationTime")));
                    builder.b("all_shared_stories_count", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("allSharedStoriesCount")));
                    builder.b("text", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("text")));
                    builder.b("source", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("source")));
                    builder.b("external_url", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("externalUrl")));
                    builder.b("type", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("link")));
                    builder.b("is_live", FbJsonField.jsonField(GraphSearchTypeaheadJsonResult.class.getDeclaredField("isLive")));
                    f15535a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15535a;
        }
        return map;
    }

    public final FbJsonField m23169a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23168e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23168e().keySet());
    }
}
