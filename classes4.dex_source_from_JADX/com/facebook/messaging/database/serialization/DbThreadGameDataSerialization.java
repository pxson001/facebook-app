package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.threads.ThreadGameData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: low_power_cpu_max_freq */
public class DbThreadGameDataSerialization {
    private final Lazy<ObjectMapperWithUncheckedException> f8811a;

    public static DbThreadGameDataSerialization m9131b(InjectorLike injectorLike) {
        return new DbThreadGameDataSerialization(IdBasedSingletonScopeProvider.b(injectorLike, 575));
    }

    @Inject
    public DbThreadGameDataSerialization(Lazy<ObjectMapperWithUncheckedException> lazy) {
        this.f8811a = lazy;
    }

    public static String m9130a(Map<String, ThreadGameData> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (String str : map.keySet()) {
            ThreadGameData threadGameData = (ThreadGameData) map.get(str);
            objectNode.k(str).a("high_score_user", threadGameData.a).a("high_score", threadGameData.b);
        }
        return objectNode.toString();
    }

    public static DbThreadGameDataSerialization m9129a(InjectorLike injectorLike) {
        return m9131b(injectorLike);
    }

    public final ImmutableMap<String, ThreadGameData> m9132a(@Nullable String str) {
        if (str == null || str.equals("{}")) {
            return RegularImmutableBiMap.a;
        }
        JsonNode a = ((ObjectMapperWithUncheckedException) this.f8811a.get()).a(str);
        Builder builder = ImmutableMap.builder();
        Iterator H = a.H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            Object key = entry.getKey();
            a = (JsonNode) entry.getValue();
            builder.b(key, new ThreadGameData(a.b("high_score_user").B(), a.b("high_score").C()));
        }
        return builder.b();
    }
}
