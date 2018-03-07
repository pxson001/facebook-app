package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WHITELIST_AND_RELOAD_UNIT */
public final class GraphQLPhrasesAnalysis$Serializer extends JsonSerializer<GraphQLPhrasesAnalysis> {
    public final void m20787a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhrasesAnalysis graphQLPhrasesAnalysis = (GraphQLPhrasesAnalysis) obj;
        GraphQLPhrasesAnalysisDeserializer.m5628a(graphQLPhrasesAnalysis.w_(), graphQLPhrasesAnalysis.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPhrasesAnalysis.class, new GraphQLPhrasesAnalysis$Serializer());
        FbSerializerProvider.a(GraphQLPhrasesAnalysis.class, new GraphQLPhrasesAnalysis$Serializer());
    }
}
