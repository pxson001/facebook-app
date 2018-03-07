package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNodeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_privacy_type */
public class GraphQLNode$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNode.class, new GraphQLNode$Deserializer());
    }

    public Object m9288a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNodeDeserializer.m5437a(jsonParser, (short) 108);
        Object graphQLNode = new GraphQLNode();
        ((BaseModel) graphQLNode).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNode instanceof Postprocessable) {
            return ((Postprocessable) graphQLNode).a();
        }
        return graphQLNode;
    }
}
