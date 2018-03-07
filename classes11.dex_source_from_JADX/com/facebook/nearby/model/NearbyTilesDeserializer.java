package com.facebook.nearby.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.graphql.model.GraphQLMapTileNode;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unread_notif_count */
public class NearbyTilesDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f390a;

    static {
        GlobalAutoGenDeserializerCache.a(NearbyTiles.class, new NearbyTilesDeserializer());
        m510e();
    }

    public NearbyTilesDeserializer() {
        a(NearbyTiles.class);
    }

    private static synchronized Map<String, FbJsonField> m510e() {
        Map<String, FbJsonField> map;
        synchronized (NearbyTilesDeserializer.class) {
            if (f390a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("edges", FbJsonField.jsonField(NearbyTiles.class.getDeclaredField("tiles"), GraphQLMapTileNode.class));
                    builder.b("version", FbJsonField.jsonField(NearbyTiles.class.getDeclaredField("version")));
                    builder.b("canonicalization", FbJsonField.jsonField(NearbyTiles.class.getDeclaredField("canonicalization")));
                    builder.b("display_region_hint", FbJsonField.jsonField(NearbyTiles.class.getDeclaredField("displayRegionHint")));
                    f390a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f390a;
        }
        return map;
    }

    public final FbJsonField m511a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m510e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m510e().keySet());
    }
}
