package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendsWhoVisitedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: harmonization_employee_curation */
public class GraphQLFriendsWhoVisitedConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoVisitedConnection.class, new GraphQLFriendsWhoVisitedConnection$Deserializer());
    }

    public Object m7643a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendsWhoVisitedConnectionDeserializer.m4963a(jsonParser, (short) 445);
        Object graphQLFriendsWhoVisitedConnection = new GraphQLFriendsWhoVisitedConnection();
        ((BaseModel) graphQLFriendsWhoVisitedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendsWhoVisitedConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendsWhoVisitedConnection).a();
        }
        return graphQLFriendsWhoVisitedConnection;
    }
}
