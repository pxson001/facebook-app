package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNSUBSCRIBED */
public class GraphQLTaggableActivity$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivity.class, new GraphQLTaggableActivity$Deserializer());
    }

    public Object m22039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTaggableActivityDeserializer.m6033a(jsonParser, (short) 67);
        Object graphQLTaggableActivity = new GraphQLTaggableActivity();
        ((BaseModel) graphQLTaggableActivity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTaggableActivity instanceof Postprocessable) {
            return ((Postprocessable) graphQLTaggableActivity).a();
        }
        return graphQLTaggableActivity;
    }
}
