package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhotoTagsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WILDE_GROUPS_TAB_MENU */
public class GraphQLPhotoTagsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoTagsConnection.class, new GraphQLPhotoTagsConnection$Deserializer());
    }

    public Object m20747a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhotoTagsConnectionDeserializer.m5618a(jsonParser, (short) 277);
        Object graphQLPhotoTagsConnection = new GraphQLPhotoTagsConnection();
        ((BaseModel) graphQLPhotoTagsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhotoTagsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhotoTagsConnection).a();
        }
        return graphQLPhotoTagsConnection;
    }
}
