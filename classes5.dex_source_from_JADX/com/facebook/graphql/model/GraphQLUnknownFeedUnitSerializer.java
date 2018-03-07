package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Total radio usage  */
public class GraphQLUnknownFeedUnitSerializer extends JsonSerializer<GraphQLUnknownFeedUnit> {
    public final void m22351a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUnknownFeedUnit graphQLUnknownFeedUnit = (GraphQLUnknownFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLUnknownFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLUnknownFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLUnknownFeedUnit.m22348g() != null) {
            jsonGenerator.a("cache_id", graphQLUnknownFeedUnit.m22348g());
        }
        if (graphQLUnknownFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLUnknownFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLUnknownFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLUnknownFeedUnit.class, new GraphQLUnknownFeedUnitSerializer());
    }
}
