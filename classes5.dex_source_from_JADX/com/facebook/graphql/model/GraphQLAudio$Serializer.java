package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAudioDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_playable */
public final class GraphQLAudio$Serializer extends JsonSerializer<GraphQLAudio> {
    public final void m6624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAudio graphQLAudio = (GraphQLAudio) obj;
        GraphQLAudioDeserializer.m4602a(graphQLAudio.w_(), graphQLAudio.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLAudio.class, new GraphQLAudio$Serializer());
        FbSerializerProvider.a(GraphQLAudio.class, new GraphQLAudio$Serializer());
    }
}
