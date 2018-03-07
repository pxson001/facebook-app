package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVect2Deserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TimelineAppSection */
public class GraphQLVect2$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVect2.class, new GraphQLVect2$Deserializer());
    }

    public Object m22417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVect2Deserializer.m6166a(jsonParser, (short) 224);
        Object graphQLVect2 = new GraphQLVect2();
        ((BaseModel) graphQLVect2).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVect2 instanceof Postprocessable) {
            return ((Postprocessable) graphQLVect2).a();
        }
        return graphQLVect2;
    }
}
