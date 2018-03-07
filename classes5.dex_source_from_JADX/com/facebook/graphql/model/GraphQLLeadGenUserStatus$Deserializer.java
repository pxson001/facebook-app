package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLeadGenUserStatusDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feed_chaining */
public class GraphQLLeadGenUserStatus$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenUserStatus.class, new GraphQLLeadGenUserStatus$Deserializer());
    }

    public Object m8904a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLeadGenUserStatusDeserializer.m5313a(jsonParser, (short) 29);
        Object graphQLLeadGenUserStatus = new GraphQLLeadGenUserStatus();
        ((BaseModel) graphQLLeadGenUserStatus).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLeadGenUserStatus instanceof Postprocessable) {
            return ((Postprocessable) graphQLLeadGenUserStatus).a();
        }
        return graphQLLeadGenUserStatus;
    }
}
