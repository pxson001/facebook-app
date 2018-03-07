package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friendEventMembers */
public class GraphQLGroupTopStoriesFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnit.class, new GraphQLGroupTopStoriesFeedUnit$Deserializer());
    }

    public Object m8494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupTopStoriesFeedUnitDeserializer.m5186a(jsonParser, (short) 549);
        Object graphQLGroupTopStoriesFeedUnit = new GraphQLGroupTopStoriesFeedUnit();
        ((BaseModel) graphQLGroupTopStoriesFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupTopStoriesFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupTopStoriesFeedUnit).a();
        }
        return graphQLGroupTopStoriesFeedUnit;
    }
}
