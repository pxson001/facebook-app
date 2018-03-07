package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTemporalEventInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNOWNED_PAGE_ACTION_MENU_REPORT_PAGE */
public final class GraphQLTemporalEventInfo$Serializer extends JsonSerializer<GraphQLTemporalEventInfo> {
    public final void m22100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTemporalEventInfo graphQLTemporalEventInfo = (GraphQLTemporalEventInfo) obj;
        GraphQLTemporalEventInfoDeserializer.m6055a(graphQLTemporalEventInfo.w_(), graphQLTemporalEventInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTemporalEventInfo.class, new GraphQLTemporalEventInfo$Serializer());
        FbSerializerProvider.a(GraphQLTemporalEventInfo.class, new GraphQLTemporalEventInfo$Serializer());
    }
}
