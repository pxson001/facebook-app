package com.facebook.graphql.error;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: pb_tfa */
public class GraphQLErrorDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3193a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLError.class, new GraphQLErrorDeserializer());
        m6241e();
    }

    public GraphQLErrorDeserializer() {
        a(GraphQLError.class);
    }

    private static synchronized Map<String, FbJsonField> m6241e() {
        Map<String, FbJsonField> map;
        synchronized (GraphQLErrorDeserializer.class) {
            if (f3193a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("code", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("code")));
                    builder.b("summary", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("summary")));
                    builder.b("description", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("description")));
                    builder.b("is_silent", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("isSilent")));
                    builder.b("is_transient", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("isTransient")));
                    builder.b("requires_reauth", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("requiresReauth")));
                    builder.b("debug_info", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("debugInfo")));
                    builder.b("query_path", FbJsonField.jsonField(GraphQLError.class.getDeclaredField("queryPath")));
                    f3193a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3193a;
        }
        return map;
    }

    public final FbJsonField m6242a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6241e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6241e().keySet());
    }
}
