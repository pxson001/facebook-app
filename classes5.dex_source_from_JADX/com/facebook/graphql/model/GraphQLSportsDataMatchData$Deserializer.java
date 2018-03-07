package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unmatched second part of surrogate pair (0x */
public class GraphQLSportsDataMatchData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchData.class, new GraphQLSportsDataMatchData$Deserializer());
    }

    public Object m21758a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSportsDataMatchDataDeserializer.m5925a(jsonParser, (short) 78);
        Object graphQLSportsDataMatchData = new GraphQLSportsDataMatchData();
        ((BaseModel) graphQLSportsDataMatchData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSportsDataMatchData instanceof Postprocessable) {
            return ((Postprocessable) graphQLSportsDataMatchData).a();
        }
        return graphQLSportsDataMatchData;
    }
}
