package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WHITELIST_AND_RELOAD_UNIT */
public class GraphQLPhrasesAnalysis$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysis.class, new GraphQLPhrasesAnalysis$Deserializer());
    }

    public Object m20786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhrasesAnalysisDeserializer.m5627a(jsonParser, (short) 482);
        Object graphQLPhrasesAnalysis = new GraphQLPhrasesAnalysis();
        ((BaseModel) graphQLPhrasesAnalysis).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhrasesAnalysis instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhrasesAnalysis).a();
        }
        return graphQLPhrasesAnalysis;
    }
}
