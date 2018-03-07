package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: logo_url */
public class DbMessageClientTagsSerialization {
    private final ObjectMapperWithUncheckedException f8841a;

    public static DbMessageClientTagsSerialization m9184b(InjectorLike injectorLike) {
        return new DbMessageClientTagsSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbMessageClientTagsSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8841a = objectMapperWithUncheckedException;
    }

    public static String m9183a(ImmutableMap<String, String> immutableMap) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (immutableMap != null) {
            Iterator it = immutableMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                objectNode.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return objectNode.toString();
    }

    public final ImmutableMap<String, String> m9185a(String str) {
        Builder builder = ImmutableMap.builder();
        if (!StringUtil.a(str)) {
            Iterator H = this.f8841a.a(str).H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                builder.b(entry.getKey(), ((JsonNode) entry.getValue()).B());
            }
        }
        return builder.b();
    }

    public static DbMessageClientTagsSerialization m9182a(InjectorLike injectorLike) {
        return m9184b(injectorLike);
    }
}
