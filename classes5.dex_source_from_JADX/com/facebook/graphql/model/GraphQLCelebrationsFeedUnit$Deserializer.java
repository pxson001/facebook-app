package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCelebrationsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_editable */
public class GraphQLCelebrationsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCelebrationsFeedUnit.class, new GraphQLCelebrationsFeedUnit$Deserializer());
    }

    public Object m6743a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCelebrationsFeedUnitDeserializer.m4641a(jsonParser, (short) 111);
        Object graphQLCelebrationsFeedUnit = new GraphQLCelebrationsFeedUnit();
        ((BaseModel) graphQLCelebrationsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCelebrationsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLCelebrationsFeedUnit).a();
        }
        return graphQLCelebrationsFeedUnit;
    }
}
