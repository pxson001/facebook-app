package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLUserDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TopicCustomizationStory */
public class GraphQLUser$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUser.class, new GraphQLUser$Deserializer());
    }

    public Object m22382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLUserDeserializer.m6149a(jsonParser, (short) 2);
        Object graphQLUser = new GraphQLUser();
        ((BaseModel) graphQLUser).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLUser instanceof Postprocessable) {
            return ((Postprocessable) graphQLUser).a();
        }
        return graphQLUser;
    }
}
