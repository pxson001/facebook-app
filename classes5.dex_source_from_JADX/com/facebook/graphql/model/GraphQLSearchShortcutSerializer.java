package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_PLACE_INFORMATION */
public class GraphQLSearchShortcutSerializer extends JsonSerializer<GraphQLSearchShortcut> {
    public final void m21587a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSearchShortcut graphQLSearchShortcut = (GraphQLSearchShortcut) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSearchShortcut.m21578j() != null) {
            jsonGenerator.a("fallback_path", graphQLSearchShortcut.m21578j());
        }
        if (graphQLSearchShortcut.m21579k() != null) {
            jsonGenerator.a("icon_uri", graphQLSearchShortcut.m21579k());
        }
        if (graphQLSearchShortcut.m21580l() != null) {
            jsonGenerator.a("id", graphQLSearchShortcut.m21580l());
        }
        if (graphQLSearchShortcut.m21581m() != null) {
            jsonGenerator.a("name", graphQLSearchShortcut.m21581m());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLSearchShortcut.m21582n() != null) {
            jsonGenerator.d();
            for (String str : graphQLSearchShortcut.m21582n()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSearchShortcut.m21583o() != null) {
            jsonGenerator.a("page_uri", graphQLSearchShortcut.m21583o());
        }
        if (graphQLSearchShortcut.m21584p() != null) {
            jsonGenerator.a("path", graphQLSearchShortcut.m21584p());
        }
        if (graphQLSearchShortcut.m21585q() != null) {
            jsonGenerator.a("url", graphQLSearchShortcut.m21585q());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSearchShortcut.class, new GraphQLSearchShortcutSerializer());
    }
}
