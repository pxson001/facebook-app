package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: landing_page_redirect_instruction */
public final class GraphQLAdditionalSuggestedPostAdItemsConnection$Serializer extends JsonSerializer<GraphQLAdditionalSuggestedPostAdItemsConnection> {
    public final void m6450a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = (GraphQLAdditionalSuggestedPostAdItemsConnection) obj;
        GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4530a(graphQLAdditionalSuggestedPostAdItemsConnection.w_(), graphQLAdditionalSuggestedPostAdItemsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsConnection.class, new GraphQLAdditionalSuggestedPostAdItemsConnection$Serializer());
        FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsConnection.class, new GraphQLAdditionalSuggestedPostAdItemsConnection$Serializer());
    }
}
