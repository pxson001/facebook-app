package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLArticleChainingFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_spherical */
public class GraphQLArticleChainingFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLArticleChainingFeedUnit.class, new GraphQLArticleChainingFeedUnit$Deserializer());
    }

    public Object m6600a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLArticleChainingFeedUnitDeserializer.m4586a(jsonParser, (short) 33);
        Object graphQLArticleChainingFeedUnit = new GraphQLArticleChainingFeedUnit();
        ((BaseModel) graphQLArticleChainingFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLArticleChainingFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLArticleChainingFeedUnit).a();
        }
        return graphQLArticleChainingFeedUnit;
    }
}
