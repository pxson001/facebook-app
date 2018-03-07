package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_ticket_provider_name */
public class GraphQLNoContentFeedUnitSerializer extends JsonSerializer<GraphQLNoContentFeedUnit> {
    public final void m9277a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNoContentFeedUnit graphQLNoContentFeedUnit = (GraphQLNoContentFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNoContentFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLNoContentFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLNoContentFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNoContentFeedUnit.class, new GraphQLNoContentFeedUnitSerializer());
    }
}
