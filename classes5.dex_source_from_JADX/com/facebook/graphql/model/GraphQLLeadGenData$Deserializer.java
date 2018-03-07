package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLeadGenDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feed_type_name */
public class GraphQLLeadGenData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenData.class, new GraphQLLeadGenData$Deserializer());
    }

    public Object m8816a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLeadGenDataDeserializer.m5284a(jsonParser, (short) 168);
        Object graphQLLeadGenData = new GraphQLLeadGenData();
        ((BaseModel) graphQLLeadGenData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLeadGenData instanceof Postprocessable) {
            return ((Postprocessable) graphQLLeadGenData).a();
        }
        return graphQLLeadGenData;
    }
}
