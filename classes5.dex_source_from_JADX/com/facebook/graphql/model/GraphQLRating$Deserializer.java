package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLRatingDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIEWER_SELF */
public class GraphQLRating$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRating.class, new GraphQLRating$Deserializer());
    }

    public Object m21306a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLRatingDeserializer.m5779a(jsonParser, (short) 159);
        Object graphQLRating = new GraphQLRating();
        ((BaseModel) graphQLRating).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLRating instanceof Postprocessable) {
            return ((Postprocessable) graphQLRating).a();
        }
        return graphQLRating;
    }
}
