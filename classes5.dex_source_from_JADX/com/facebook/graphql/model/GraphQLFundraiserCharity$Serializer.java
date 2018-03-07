package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFundraiserCharityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: groups_rhc_module */
public final class GraphQLFundraiserCharity$Serializer extends JsonSerializer<GraphQLFundraiserCharity> {
    public final void m7672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserCharity graphQLFundraiserCharity = (GraphQLFundraiserCharity) obj;
        GraphQLFundraiserCharityDeserializer.m4977a(graphQLFundraiserCharity.w_(), graphQLFundraiserCharity.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserCharity.class, new GraphQLFundraiserCharity$Serializer());
        FbSerializerProvider.a(GraphQLFundraiserCharity.class, new GraphQLFundraiserCharity$Serializer());
    }
}
