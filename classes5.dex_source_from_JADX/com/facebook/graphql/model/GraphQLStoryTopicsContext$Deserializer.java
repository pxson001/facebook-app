package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryTopicsContextDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: USER_INTERACTIONS */
public class GraphQLStoryTopicsContext$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryTopicsContext.class, new GraphQLStoryTopicsContext$Deserializer());
    }

    public Object m21916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryTopicsContextDeserializer.m5989a(jsonParser, (short) 206);
        Object graphQLStoryTopicsContext = new GraphQLStoryTopicsContext();
        ((BaseModel) graphQLStoryTopicsContext).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryTopicsContext instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryTopicsContext).a();
        }
        return graphQLStoryTopicsContext;
    }
}
