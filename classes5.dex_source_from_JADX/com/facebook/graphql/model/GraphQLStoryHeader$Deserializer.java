package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryHeaderDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to fetch user credentials from FbSharedPreferences. */
public class GraphQLStoryHeader$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryHeader.class, new GraphQLStoryHeader$Deserializer());
    }

    public Object m21871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryHeaderDeserializer.m5971a(jsonParser, (short) 203);
        Object graphQLStoryHeader = new GraphQLStoryHeader();
        ((BaseModel) graphQLStoryHeader).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryHeader instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryHeader).a();
        }
        return graphQLStoryHeader;
    }
}
