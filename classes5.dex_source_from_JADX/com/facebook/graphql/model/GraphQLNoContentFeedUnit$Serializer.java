package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNoContentFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_tips */
public final class GraphQLNoContentFeedUnit$Serializer extends JsonSerializer<GraphQLNoContentFeedUnit> {
    public final void m9275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNoContentFeedUnit graphQLNoContentFeedUnit = (GraphQLNoContentFeedUnit) obj;
        GraphQLNoContentFeedUnitDeserializer.m5432a(graphQLNoContentFeedUnit.w_(), graphQLNoContentFeedUnit.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLNoContentFeedUnit.class, new GraphQLNoContentFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLNoContentFeedUnit.class, new GraphQLNoContentFeedUnit$Serializer());
    }
}
