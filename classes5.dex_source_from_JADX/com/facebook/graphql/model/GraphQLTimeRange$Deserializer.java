package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimeRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNLABELED_LINE_CHART */
public class GraphQLTimeRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimeRange.class, new GraphQLTimeRange$Deserializer());
    }

    public Object m22110a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimeRangeDeserializer.m6062a(jsonParser, (short) 242);
        Object graphQLTimeRange = new GraphQLTimeRange();
        ((BaseModel) graphQLTimeRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimeRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimeRange).a();
        }
        return graphQLTimeRange;
    }
}
