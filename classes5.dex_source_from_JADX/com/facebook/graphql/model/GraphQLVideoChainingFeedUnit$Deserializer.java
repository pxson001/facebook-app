package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoChainingFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TimeRange */
public class GraphQLVideoChainingFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoChainingFeedUnit.class, new GraphQLVideoChainingFeedUnit$Deserializer());
    }

    public Object m22431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoChainingFeedUnitDeserializer.m6174a(jsonParser, (short) 42);
        Object graphQLVideoChainingFeedUnit = new GraphQLVideoChainingFeedUnit();
        ((BaseModel) graphQLVideoChainingFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideoChainingFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideoChainingFeedUnit).a();
        }
        return graphQLVideoChainingFeedUnit;
    }
}
