package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAndroidAppConfigDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: japan_mobile_invite */
public class GraphQLAndroidAppConfig$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAndroidAppConfig.class, new GraphQLAndroidAppConfig$Deserializer());
    }

    public Object m6536a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAndroidAppConfigDeserializer.m4562a(jsonParser, (short) 139);
        Object graphQLAndroidAppConfig = new GraphQLAndroidAppConfig();
        ((BaseModel) graphQLAndroidAppConfig).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAndroidAppConfig instanceof Postprocessable) {
            return ((Postprocessable) graphQLAndroidAppConfig).a();
        }
        return graphQLAndroidAppConfig;
    }
}
