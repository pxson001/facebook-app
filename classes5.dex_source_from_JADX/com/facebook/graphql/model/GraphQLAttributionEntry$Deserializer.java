package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAttributionEntryDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_save_primary_action */
public class GraphQLAttributionEntry$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAttributionEntry.class, new GraphQLAttributionEntry$Deserializer());
    }

    public Object m6612a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAttributionEntryDeserializer.m4593a(jsonParser, (short) 389);
        Object graphQLAttributionEntry = new GraphQLAttributionEntry();
        ((BaseModel) graphQLAttributionEntry).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAttributionEntry instanceof Postprocessable) {
            return ((Postprocessable) graphQLAttributionEntry).a();
        }
        return graphQLAttributionEntry;
    }
}
