package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLProfileDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VOIP_CALL */
public class GraphQLProfile$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfile.class, new GraphQLProfile$Deserializer());
    }

    public Object m21096a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLProfileDeserializer.m5718a(jsonParser, (short) 154);
        Object graphQLProfile = new GraphQLProfile();
        ((BaseModel) graphQLProfile).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLProfile instanceof Postprocessable) {
            return ((Postprocessable) graphQLProfile).a();
        }
        return graphQLProfile;
    }
}
