package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_checkin_add_place_button */
public class GraphQLEmotionalAnalysis$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysis.class, new GraphQLEmotionalAnalysis$Deserializer());
    }

    public Object m7001a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEmotionalAnalysisDeserializer.m4735a(jsonParser, (short) 478);
        Object graphQLEmotionalAnalysis = new GraphQLEmotionalAnalysis();
        ((BaseModel) graphQLEmotionalAnalysis).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEmotionalAnalysis instanceof Postprocessable) {
            return ((Postprocessable) graphQLEmotionalAnalysis).a();
        }
        return graphQLEmotionalAnalysis;
    }
}
