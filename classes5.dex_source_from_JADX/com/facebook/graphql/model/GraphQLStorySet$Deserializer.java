package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStorySetDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UTF-8 */
public class GraphQLStorySet$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySet.class, new GraphQLStorySet$Deserializer());
    }

    public Object m21890a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStorySetDeserializer.m5980a(jsonParser, (short) 32);
        Object graphQLStorySet = new GraphQLStorySet();
        ((BaseModel) graphQLStorySet).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStorySet instanceof Postprocessable) {
            return ((Postprocessable) graphQLStorySet).a();
        }
        return graphQLStorySet;
    }
}
