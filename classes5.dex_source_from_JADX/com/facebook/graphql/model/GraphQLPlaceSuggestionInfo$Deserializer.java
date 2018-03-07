package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceSuggestionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WATCHED_RECOMMENDATIONS */
public class GraphQLPlaceSuggestionInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceSuggestionInfo.class, new GraphQLPlaceSuggestionInfo$Deserializer());
    }

    public Object m20914a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceSuggestionInfoDeserializer.m5671a(jsonParser, (short) 457);
        Object graphQLPlaceSuggestionInfo = new GraphQLPlaceSuggestionInfo();
        ((BaseModel) graphQLPlaceSuggestionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlaceSuggestionInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlaceSuggestionInfo).a();
        }
        return graphQLPlaceSuggestionInfo;
    }
}
