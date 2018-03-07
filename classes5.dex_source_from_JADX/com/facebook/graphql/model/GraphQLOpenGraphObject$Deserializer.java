package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLOpenGraphObjectDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: eventType= */
public class GraphQLOpenGraphObject$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphObject.class, new GraphQLOpenGraphObject$Deserializer());
    }

    public Object m9405a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLOpenGraphObjectDeserializer.m5466a(jsonParser, (short) 76);
        Object graphQLOpenGraphObject = new GraphQLOpenGraphObject();
        ((BaseModel) graphQLOpenGraphObject).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLOpenGraphObject instanceof Postprocessable) {
            return ((Postprocessable) graphQLOpenGraphObject).a();
        }
        return graphQLOpenGraphObject;
    }
}
