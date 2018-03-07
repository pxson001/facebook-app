package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSavedCollectionFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VETERINARIAN */
public class GraphQLSavedCollectionFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSavedCollectionFeedUnit.class, new GraphQLSavedCollectionFeedUnit$Deserializer());
    }

    public Object m21532a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSavedCollectionFeedUnitDeserializer.m5852a(jsonParser, (short) 125);
        Object graphQLSavedCollectionFeedUnit = new GraphQLSavedCollectionFeedUnit();
        ((BaseModel) graphQLSavedCollectionFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSavedCollectionFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLSavedCollectionFeedUnit).a();
        }
        return graphQLSavedCollectionFeedUnit;
    }
}
