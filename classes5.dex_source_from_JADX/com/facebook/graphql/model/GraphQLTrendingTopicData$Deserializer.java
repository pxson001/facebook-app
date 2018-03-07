package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTrendingTopicDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TrendingEntitiesEdge */
public class GraphQLTrendingTopicData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrendingTopicData.class, new GraphQLTrendingTopicData$Deserializer());
    }

    public Object m22297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTrendingTopicDataDeserializer.m6128a(jsonParser, (short) 106);
        Object graphQLTrendingTopicData = new GraphQLTrendingTopicData();
        ((BaseModel) graphQLTrendingTopicData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTrendingTopicData instanceof Postprocessable) {
            return ((Postprocessable) graphQLTrendingTopicData).a();
        }
        return graphQLTrendingTopicData;
    }
}
