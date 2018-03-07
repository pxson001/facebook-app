package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAppStoreApplicationDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: item_availability */
public class GraphQLAppStoreApplication$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppStoreApplication.class, new GraphQLAppStoreApplication$Deserializer());
    }

    public Object m6570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAppStoreApplicationDeserializer.m4574a(jsonParser, (short) 137);
        Object graphQLAppStoreApplication = new GraphQLAppStoreApplication();
        ((BaseModel) graphQLAppStoreApplication).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAppStoreApplication instanceof Postprocessable) {
            return ((Postprocessable) graphQLAppStoreApplication).a();
        }
        return graphQLAppStoreApplication;
    }
}
