package com.facebook.fql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: push_reg_server_initial_status */
public class FqlMultiQueryHelper {
    private Map<String, String> f4008a = Maps.c();

    public final void m4506a(String str, String str2) {
        this.f4008a.put(str, str2);
    }

    public final JsonNode m4505a() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : this.f4008a.entrySet()) {
            objectNode.a((String) entry.getKey(), (String) entry.getValue());
        }
        return objectNode;
    }
}
