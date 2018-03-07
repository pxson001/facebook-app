package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: end_timestamp */
public class GraphQLPageInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageInfo.class, new GraphQLPageInfo$Deserializer());
    }

    public Object m9487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageInfoDeserializer.m5507a(jsonParser, (short) 248);
        Object graphQLPageInfo = new GraphQLPageInfo();
        ((BaseModel) graphQLPageInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageInfo).a();
        }
        return graphQLPageInfo;
    }
}
