package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_ask_friends_enabled */
public class GraphQLCommentPlaceInfoToPlaceListItemsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class, new GraphQLCommentPlaceInfoToPlaceListItemsConnection$Deserializer());
    }

    public Object m6806a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4663a(jsonParser, (short) 239);
        Object graphQLCommentPlaceInfoToPlaceListItemsConnection = new GraphQLCommentPlaceInfoToPlaceListItemsConnection();
        ((BaseModel) graphQLCommentPlaceInfoToPlaceListItemsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCommentPlaceInfoToPlaceListItemsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLCommentPlaceInfoToPlaceListItemsConnection).a();
        }
        return graphQLCommentPlaceInfoToPlaceListItemsConnection;
    }
}
