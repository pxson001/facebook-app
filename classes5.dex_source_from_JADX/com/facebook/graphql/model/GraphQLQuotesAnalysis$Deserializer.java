package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQuotesAnalysisDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIEW_GUEST_LIST */
public class GraphQLQuotesAnalysis$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysis.class, new GraphQLQuotesAnalysis$Deserializer());
    }

    public Object m21269a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLQuotesAnalysisDeserializer.m5767a(jsonParser, (short) 485);
        Object graphQLQuotesAnalysis = new GraphQLQuotesAnalysis();
        ((BaseModel) graphQLQuotesAnalysis).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLQuotesAnalysis instanceof Postprocessable) {
            return ((Postprocessable) graphQLQuotesAnalysis).a();
        }
        return graphQLQuotesAnalysis;
    }
}
