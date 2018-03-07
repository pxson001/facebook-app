package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fb_data_policy_setting_description */
public class GraphQLMapTileNodeDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4425a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMapTileNode.class, new GraphQLMapTileNodeDeserializer());
        m8996e();
    }

    public GraphQLMapTileNodeDeserializer() {
        a(GraphQLMapTileNode.class);
    }

    private static synchronized Map<String, FbJsonField> m8996e() {
        Map<String, FbJsonField> map;
        synchronized (GraphQLMapTileNodeDeserializer.class) {
            if (f4425a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("node", FbJsonField.jsonField(GraphQLMapTileNode.class.getDeclaredField("tile")));
                    f4425a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4425a;
        }
        return map;
    }

    public final FbJsonField m8997a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8996e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8996e().keySet());
    }
}
