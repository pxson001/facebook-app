package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceOpenStatusFormatDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WEATHER_CONDITION_ALERT */
public class GraphQLPlaceOpenStatusFormat$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceOpenStatusFormat.class, new GraphQLPlaceOpenStatusFormat$Deserializer());
    }

    public Object m20882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceOpenStatusFormatDeserializer.m5656a(jsonParser, (short) 241);
        Object graphQLPlaceOpenStatusFormat = new GraphQLPlaceOpenStatusFormat();
        ((BaseModel) graphQLPlaceOpenStatusFormat).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlaceOpenStatusFormat instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlaceOpenStatusFormat).a();
        }
        return graphQLPlaceOpenStatusFormat;
    }
}
