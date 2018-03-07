package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageStarRatersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: enable_feedback_for_reply_previews */
public class GraphQLPageStarRatersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStarRatersConnection.class, new GraphQLPageStarRatersConnection$Deserializer());
    }

    public Object m9517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageStarRatersConnectionDeserializer.m5522a(jsonParser, (short) 442);
        Object graphQLPageStarRatersConnection = new GraphQLPageStarRatersConnection();
        ((BaseModel) graphQLPageStarRatersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageStarRatersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageStarRatersConnection).a();
        }
        return graphQLPageStarRatersConnection;
    }
}
