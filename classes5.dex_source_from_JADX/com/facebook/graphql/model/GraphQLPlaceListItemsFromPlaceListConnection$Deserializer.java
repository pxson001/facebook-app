package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceListItemsFromPlaceListConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WEATHER_FORECAST */
public class GraphQLPlaceListItemsFromPlaceListConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItemsFromPlaceListConnection.class, new GraphQLPlaceListItemsFromPlaceListConnection$Deserializer());
    }

    public Object m20876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5653a(jsonParser, (short) 518);
        Object graphQLPlaceListItemsFromPlaceListConnection = new GraphQLPlaceListItemsFromPlaceListConnection();
        ((BaseModel) graphQLPlaceListItemsFromPlaceListConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlaceListItemsFromPlaceListConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlaceListItemsFromPlaceListConnection).a();
        }
        return graphQLPlaceListItemsFromPlaceListConnection;
    }
}
