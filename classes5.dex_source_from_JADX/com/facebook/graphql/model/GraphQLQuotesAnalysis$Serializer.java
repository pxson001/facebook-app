package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLQuotesAnalysisDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_GUEST_LIST */
public final class GraphQLQuotesAnalysis$Serializer extends JsonSerializer<GraphQLQuotesAnalysis> {
    public final void m21270a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuotesAnalysis graphQLQuotesAnalysis = (GraphQLQuotesAnalysis) obj;
        GraphQLQuotesAnalysisDeserializer.m5768a(graphQLQuotesAnalysis.w_(), graphQLQuotesAnalysis.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLQuotesAnalysis.class, new GraphQLQuotesAnalysis$Serializer());
        FbSerializerProvider.a(GraphQLQuotesAnalysis.class, new GraphQLQuotesAnalysis$Serializer());
    }
}
