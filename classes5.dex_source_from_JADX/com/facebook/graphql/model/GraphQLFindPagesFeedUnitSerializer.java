package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: header_color */
public class GraphQLFindPagesFeedUnitSerializer extends JsonSerializer<GraphQLFindPagesFeedUnit> {
    public final void m7520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindPagesFeedUnit graphQLFindPagesFeedUnit = (GraphQLFindPagesFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFindPagesFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLFindPagesFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLFindPagesFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFindPagesFeedUnit.class, new GraphQLFindPagesFeedUnitSerializer());
    }
}
