package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivateReplyContextDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Value returned by 'any-getter' ( */
public class GraphQLPrivateReplyContext$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivateReplyContext.class, new GraphQLPrivateReplyContext$Deserializer());
    }

    public Object m21035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivateReplyContextDeserializer.m5709a(jsonParser, (short) 270);
        Object graphQLPrivateReplyContext = new GraphQLPrivateReplyContext();
        ((BaseModel) graphQLPrivateReplyContext).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivateReplyContext instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivateReplyContext).a();
        }
        return graphQLPrivateReplyContext;
    }
}
