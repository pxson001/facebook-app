package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLeadGenDeepLinkUserStatusDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feed_topic_content */
public class GraphQLLeadGenDeepLinkUserStatus$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenDeepLinkUserStatus.class, new GraphQLLeadGenDeepLinkUserStatus$Deserializer());
    }

    public Object m8823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLeadGenDeepLinkUserStatusDeserializer.m5287a(jsonParser, (short) 60);
        Object graphQLLeadGenDeepLinkUserStatus = new GraphQLLeadGenDeepLinkUserStatus();
        ((BaseModel) graphQLLeadGenDeepLinkUserStatus).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLeadGenDeepLinkUserStatus instanceof Postprocessable) {
            return ((Postprocessable) graphQLLeadGenDeepLinkUserStatus).a();
        }
        return graphQLLeadGenDeepLinkUserStatus;
    }
}
