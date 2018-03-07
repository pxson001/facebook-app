package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAggregatedEntitiesAtRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: journal.tmp */
public class GraphQLAggregatedEntitiesAtRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAggregatedEntitiesAtRange.class, new GraphQLAggregatedEntitiesAtRange$Deserializer());
    }

    public Object m6498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAggregatedEntitiesAtRangeDeserializer.m4547a(jsonParser, (short) 138);
        Object graphQLAggregatedEntitiesAtRange = new GraphQLAggregatedEntitiesAtRange();
        ((BaseModel) graphQLAggregatedEntitiesAtRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAggregatedEntitiesAtRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLAggregatedEntitiesAtRange).a();
        }
        return graphQLAggregatedEntitiesAtRange;
    }
}
