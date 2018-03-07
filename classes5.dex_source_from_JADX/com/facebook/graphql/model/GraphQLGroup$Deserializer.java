package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friends_invited */
public class GraphQLGroup$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroup.class, new GraphQLGroup$Deserializer());
    }

    public Object m8379a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupDeserializer.m5158a(jsonParser, (short) 54);
        Object graphQLGroup = new GraphQLGroup();
        ((BaseModel) graphQLGroup).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroup instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroup).a();
        }
        return graphQLGroup;
    }
}
