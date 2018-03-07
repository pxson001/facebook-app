package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventTimeRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: image_overlays */
public class GraphQLEventTimeRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventTimeRange.class, new GraphQLEventTimeRange$Deserializer());
    }

    public Object m7299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventTimeRangeDeserializer.m4834a(jsonParser, (short) 428);
        Object graphQLEventTimeRange = new GraphQLEventTimeRange();
        ((BaseModel) graphQLEventTimeRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventTimeRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventTimeRange).a();
        }
        return graphQLEventTimeRange;
    }
}
