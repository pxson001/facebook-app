package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCustomizedStoryDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_post_checkin_upload_photo */
public class GraphQLCustomizedStory$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCustomizedStory.class, new GraphQLCustomizedStory$Deserializer());
    }

    public Object m6926a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCustomizedStoryDeserializer.m4704a(jsonParser, (short) 30);
        Object graphQLCustomizedStory = new GraphQLCustomizedStory();
        ((BaseModel) graphQLCustomizedStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCustomizedStory instanceof Postprocessable) {
            return ((Postprocessable) graphQLCustomizedStory).a();
        }
        return graphQLCustomizedStory;
    }
}
