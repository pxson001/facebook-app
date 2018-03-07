package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTopLevelCommentsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNBLOCK_PROMOTION */
public class GraphQLTopLevelCommentsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopLevelCommentsConnection.class, new GraphQLTopLevelCommentsConnection$Deserializer());
    }

    public Object m22244a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTopLevelCommentsConnectionDeserializer.m6102a(jsonParser, (short) 214);
        Object graphQLTopLevelCommentsConnection = new GraphQLTopLevelCommentsConnection();
        ((BaseModel) graphQLTopLevelCommentsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTopLevelCommentsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTopLevelCommentsConnection).a();
        }
        return graphQLTopLevelCommentsConnection;
    }
}
