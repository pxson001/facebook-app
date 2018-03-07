package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGeoRectangleDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: group_leaderboard */
public class GraphQLGeoRectangle$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGeoRectangle.class, new GraphQLGeoRectangle$Deserializer());
    }

    public Object m7762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGeoRectangleDeserializer.m4994a(jsonParser, (short) 163);
        Object graphQLGeoRectangle = new GraphQLGeoRectangle();
        ((BaseModel) graphQLGeoRectangle).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGeoRectangle instanceof Postprocessable) {
            return ((Postprocessable) graphQLGeoRectangle).a();
        }
        return graphQLGeoRectangle;
    }
}
