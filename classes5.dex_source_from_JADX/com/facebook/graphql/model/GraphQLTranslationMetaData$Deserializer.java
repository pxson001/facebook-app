package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTranslationMetaDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TrueTopicFeedOptionsEdge */
public class GraphQLTranslationMetaData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTranslationMetaData.class, new GraphQLTranslationMetaData$Deserializer());
    }

    public Object m22280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTranslationMetaDataDeserializer.m6122a(jsonParser, (short) 156);
        Object graphQLTranslationMetaData = new GraphQLTranslationMetaData();
        ((BaseModel) graphQLTranslationMetaData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTranslationMetaData instanceof Postprocessable) {
            return ((Postprocessable) graphQLTranslationMetaData).a();
        }
        return graphQLTranslationMetaData;
    }
}
