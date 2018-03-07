package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventInviteesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: inheritableThreadLocals */
public class GraphQLEventInviteesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventInviteesConnection.class, new GraphQLEventInviteesConnection$Deserializer());
    }

    public Object m7202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventInviteesConnectionDeserializer.m4804a(jsonParser, (short) 301);
        Object graphQLEventInviteesConnection = new GraphQLEventInviteesConnection();
        ((BaseModel) graphQLEventInviteesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventInviteesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventInviteesConnection).a();
        }
        return graphQLEventInviteesConnection;
    }
}
