package com.facebook.nearby.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: update_optin_state */
public class MapTileDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f379a;

    static {
        GlobalAutoGenDeserializerCache.a(MapTile.class, new MapTileDeserializer());
        m485e();
    }

    public MapTileDeserializer() {
        a(MapTile.class);
    }

    private static synchronized Map<String, FbJsonField> m485e() {
        Map<String, FbJsonField> map;
        synchronized (MapTileDeserializer.class) {
            if (f379a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(MapTile.class.getDeclaredField("id")));
                    builder.b("creationTime", FbJsonField.jsonField(MapTile.class.getDeclaredField("creationTime")));
                    builder.b("timeToLiveInSeconds", FbJsonField.jsonField(MapTile.class.getDeclaredField("timeToLiveInSeconds")));
                    builder.b("bounds", FbJsonField.jsonField(MapTile.class.getDeclaredField("bounds")));
                    builder.b("minZoom", FbJsonField.jsonField(MapTile.class.getDeclaredField("minZoom")));
                    builder.b("maxZoom", FbJsonField.jsonField(MapTile.class.getDeclaredField("maxZoom")));
                    builder.b("places", FbJsonField.jsonField(MapTile.class.getDeclaredField("places"), NearbyPlaceEdgeWithLayout.class));
                    builder.b("backgroundPlaces", FbJsonField.jsonField(MapTile.class.getDeclaredField("backgroundPlaces"), NearbyPlaceEdgeWithLayout.class));
                    f379a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f379a;
        }
        return map;
    }

    public final FbJsonField m486a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m485e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m485e().keySet());
    }
}
