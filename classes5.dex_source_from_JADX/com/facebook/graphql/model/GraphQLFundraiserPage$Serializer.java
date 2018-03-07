package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFundraiserPageDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_story_chattable_members */
public final class GraphQLFundraiserPage$Serializer extends JsonSerializer<GraphQLFundraiserPage> {
    public final void m7679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserPage graphQLFundraiserPage = (GraphQLFundraiserPage) obj;
        GraphQLFundraiserPageDeserializer.m4980a(graphQLFundraiserPage.w_(), graphQLFundraiserPage.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserPage.class, new GraphQLFundraiserPage$Serializer());
        FbSerializerProvider.a(GraphQLFundraiserPage.class, new GraphQLFundraiserPage$Serializer());
    }
}
