package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFindGroupsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: headline_source */
public class GraphQLFindGroupsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindGroupsFeedUnit.class, new GraphQLFindGroupsFeedUnit$Deserializer());
    }

    public Object m7513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFindGroupsFeedUnitDeserializer.m4914a(jsonParser, (short) 411);
        Object graphQLFindGroupsFeedUnit = new GraphQLFindGroupsFeedUnit();
        ((BaseModel) graphQLFindGroupsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFindGroupsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLFindGroupsFeedUnit).a();
        }
        return graphQLFindGroupsFeedUnit;
    }
}
