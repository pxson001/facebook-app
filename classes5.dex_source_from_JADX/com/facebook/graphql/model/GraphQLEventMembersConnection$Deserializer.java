package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventMembersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: in_progress */
public class GraphQLEventMembersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMembersConnection.class, new GraphQLEventMembersConnection$Deserializer());
    }

    public Object m7241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventMembersConnectionDeserializer.m4818a(jsonParser, (short) 300);
        Object graphQLEventMembersConnection = new GraphQLEventMembersConnection();
        ((BaseModel) graphQLEventMembersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventMembersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventMembersConnection).a();
        }
        return graphQLEventMembersConnection;
    }
}
