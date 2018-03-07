package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_checkin_add_place_button */
public final class GraphQLEmotionalAnalysis$Serializer extends JsonSerializer<GraphQLEmotionalAnalysis> {
    public final void m7002a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEmotionalAnalysis graphQLEmotionalAnalysis = (GraphQLEmotionalAnalysis) obj;
        GraphQLEmotionalAnalysisDeserializer.m4736a(graphQLEmotionalAnalysis.w_(), graphQLEmotionalAnalysis.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEmotionalAnalysis.class, new GraphQLEmotionalAnalysis$Serializer());
        FbSerializerProvider.a(GraphQLEmotionalAnalysis.class, new GraphQLEmotionalAnalysis$Serializer());
    }
}
