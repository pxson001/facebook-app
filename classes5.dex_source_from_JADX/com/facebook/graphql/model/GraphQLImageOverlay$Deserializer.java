package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLImageOverlayDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: focus */
public class GraphQLImageOverlay$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImageOverlay.class, new GraphQLImageOverlay$Deserializer());
    }

    public Object m8626a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLImageOverlayDeserializer.m5227a(jsonParser, (short) 179);
        Object graphQLImageOverlay = new GraphQLImageOverlay();
        ((BaseModel) graphQLImageOverlay).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLImageOverlay instanceof Postprocessable) {
            return ((Postprocessable) graphQLImageOverlay).a();
        }
        return graphQLImageOverlay;
    }
}
