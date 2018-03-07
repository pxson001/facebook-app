package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLRedSpaceStoryInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_PLAY */
public class GraphQLRedSpaceStoryInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRedSpaceStoryInfo.class, new GraphQLRedSpaceStoryInfo$Deserializer());
    }

    public Object m21371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLRedSpaceStoryInfoDeserializer.m5797a(jsonParser, (short) 282);
        Object graphQLRedSpaceStoryInfo = new GraphQLRedSpaceStoryInfo();
        ((BaseModel) graphQLRedSpaceStoryInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLRedSpaceStoryInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLRedSpaceStoryInfo).a();
        }
        return graphQLRedSpaceStoryInfo;
    }
}
