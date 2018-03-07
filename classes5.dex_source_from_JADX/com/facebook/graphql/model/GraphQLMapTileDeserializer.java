package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fb_http_flow_statistics */
public class GraphQLMapTileDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4424a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMapTile.class, new GraphQLMapTileDeserializer());
        m8993e();
    }

    public GraphQLMapTileDeserializer() {
        a(GraphQLMapTile.class);
    }

    private static synchronized Map<String, FbJsonField> m8993e() {
        Map<String, FbJsonField> map;
        synchronized (GraphQLMapTileDeserializer.class) {
            if (f4424a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("tile_key", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("id")));
                    builder.b("creation_time", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("creationTime")));
                    builder.b("ttl", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("timeToLiveInSeconds")));
                    builder.b("bounds", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("bounds")));
                    builder.b("min_zoom", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("minZoom")));
                    builder.b("max_zoom", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("maxZoom")));
                    builder.b("placesRenderPriority1", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("places")));
                    builder.b("placesRenderPriority2", FbJsonField.jsonField(GraphQLMapTile.class.getDeclaredField("backgroundPlaces")));
                    f4424a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4424a;
        }
        return map;
    }

    public final FbJsonField m8994a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8993e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8993e().keySet());
    }
}
