package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLRedirectionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_ONLY */
public class GraphQLRedirectionInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRedirectionInfo.class, new GraphQLRedirectionInfo$Deserializer());
    }

    public Object m21377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLRedirectionInfoDeserializer.m5800a(jsonParser, (short) 136);
        Object graphQLRedirectionInfo = new GraphQLRedirectionInfo();
        ((BaseModel) graphQLRedirectionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLRedirectionInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLRedirectionInfo).a();
        }
        return graphQLRedirectionInfo;
    }
}
