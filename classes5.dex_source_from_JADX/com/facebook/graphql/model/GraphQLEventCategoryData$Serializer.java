package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventCategoryDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: install_messenger_learn_more_button */
public final class GraphQLEventCategoryData$Serializer extends JsonSerializer<GraphQLEventCategoryData> {
    public final void m7119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventCategoryData graphQLEventCategoryData = (GraphQLEventCategoryData) obj;
        GraphQLEventCategoryDataDeserializer.m4775a(graphQLEventCategoryData.w_(), graphQLEventCategoryData.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLEventCategoryData.class, new GraphQLEventCategoryData$Serializer());
        FbSerializerProvider.a(GraphQLEventCategoryData.class, new GraphQLEventCategoryData$Serializer());
    }
}
