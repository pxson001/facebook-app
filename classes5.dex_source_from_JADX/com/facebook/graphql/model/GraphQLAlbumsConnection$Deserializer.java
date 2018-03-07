package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAlbumsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: jewel_install_messenger_promo_fragment */
public class GraphQLAlbumsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAlbumsConnection.class, new GraphQLAlbumsConnection$Deserializer());
    }

    public Object m6514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAlbumsConnectionDeserializer.m4553a(jsonParser, (short) 454);
        Object graphQLAlbumsConnection = new GraphQLAlbumsConnection();
        ((BaseModel) graphQLAlbumsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAlbumsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLAlbumsConnection).a();
        }
        return graphQLAlbumsConnection;
    }
}
