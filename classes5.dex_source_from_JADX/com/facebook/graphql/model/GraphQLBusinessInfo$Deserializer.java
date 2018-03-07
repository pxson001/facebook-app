package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLBusinessInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_game */
public class GraphQLBusinessInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBusinessInfo.class, new GraphQLBusinessInfo$Deserializer());
    }

    public Object m6701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLBusinessInfoDeserializer.m4628a(jsonParser, (short) 453);
        Object graphQLBusinessInfo = new GraphQLBusinessInfo();
        ((BaseModel) graphQLBusinessInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLBusinessInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLBusinessInfo).a();
        }
        return graphQLBusinessInfo;
    }
}
