package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewGroupFragmentHost */
public final class GraphQLPrivacyOption$Serializer extends JsonSerializer<GraphQLPrivacyOption> {
    public final void m20993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) obj;
        GraphQLPrivacyOptionDeserializer.a(graphQLPrivacyOption.w_(), graphQLPrivacyOption.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOption.class, new GraphQLPrivacyOption$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyOption.class, new GraphQLPrivacyOption$Serializer());
    }
}
