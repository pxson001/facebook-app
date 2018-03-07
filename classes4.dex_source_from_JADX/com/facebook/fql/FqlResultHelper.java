package com.facebook.fql;

import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: push_reg_gcm_initial_status */
public class FqlResultHelper {
    private final Map<String, JsonNode> f4010a;

    public FqlResultHelper(JsonNode jsonNode) {
        if (!(jsonNode.h() || jsonNode.b("data") == null)) {
            jsonNode = jsonNode.b("data");
        }
        this.f4010a = Maps.c();
        for (int i = 0; i < jsonNode.e(); i++) {
            JsonNode a = jsonNode.a(i);
            this.f4010a.put(JSONUtil.b(a.b("name")), a.b("fql_result_set"));
        }
    }

    public final JsonNode m4512a(String str) {
        return (JsonNode) this.f4010a.get(str);
    }
}
