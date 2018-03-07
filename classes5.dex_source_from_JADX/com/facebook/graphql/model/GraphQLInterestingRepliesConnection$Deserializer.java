package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInterestingRepliesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feedback_subscribe */
public class GraphQLInterestingRepliesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInterestingRepliesConnection.class, new GraphQLInterestingRepliesConnection$Deserializer());
    }

    public Object m8747a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInterestingRepliesConnectionDeserializer.m5275a(jsonParser, (short) 274);
        Object graphQLInterestingRepliesConnection = new GraphQLInterestingRepliesConnection();
        ((BaseModel) graphQLInterestingRepliesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInterestingRepliesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLInterestingRepliesConnection).a();
        }
        return graphQLInterestingRepliesConnection;
    }
}
