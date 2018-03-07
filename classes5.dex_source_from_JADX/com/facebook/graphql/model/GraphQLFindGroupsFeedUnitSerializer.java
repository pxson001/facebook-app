package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: header_text */
public class GraphQLFindGroupsFeedUnitSerializer extends JsonSerializer<GraphQLFindGroupsFeedUnit> {
    public final void m7516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindGroupsFeedUnit graphQLFindGroupsFeedUnit = (GraphQLFindGroupsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFindGroupsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLFindGroupsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLFindGroupsFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFindGroupsFeedUnit.class, new GraphQLFindGroupsFeedUnitSerializer());
    }
}
