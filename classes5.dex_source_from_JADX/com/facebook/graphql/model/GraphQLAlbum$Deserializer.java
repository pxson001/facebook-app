package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAlbumDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: job_tag */
public class GraphQLAlbum$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAlbum.class, new GraphQLAlbum$Deserializer());
    }

    public Object m6506a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAlbumDeserializer.m4550a(jsonParser, (short) 82);
        Object graphQLAlbum = new GraphQLAlbum();
        ((BaseModel) graphQLAlbum).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAlbum instanceof Postprocessable) {
            return ((Postprocessable) graphQLAlbum).a();
        }
        return graphQLAlbum;
    }
}
