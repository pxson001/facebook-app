package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLApplicationDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_video_broadcast */
public class GraphQLApplication$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLApplication.class, new GraphQLApplication$Deserializer());
    }

    public Object m6583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLApplicationDeserializer.m4580a(jsonParser, (short) 12);
        Object graphQLApplication = new GraphQLApplication();
        ((BaseModel) graphQLApplication).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLApplication instanceof Postprocessable) {
            return ((Postprocessable) graphQLApplication).a();
        }
        return graphQLApplication;
    }
}
