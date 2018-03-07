package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEntityWithImageDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: instant_game_id */
public class GraphQLEntityWithImage$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityWithImage.class, new GraphQLEntityWithImage$Deserializer());
    }

    public Object m7096a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEntityWithImageDeserializer.m4768a(jsonParser, (short) 141);
        Object graphQLEntityWithImage = new GraphQLEntityWithImage();
        ((BaseModel) graphQLEntityWithImage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEntityWithImage instanceof Postprocessable) {
            return ((Postprocessable) graphQLEntityWithImage).a();
        }
        return graphQLEntityWithImage;
    }
}
