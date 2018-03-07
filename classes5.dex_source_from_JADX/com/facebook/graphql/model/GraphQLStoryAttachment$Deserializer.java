package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryAttachmentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to retrieve radio power stats */
public class GraphQLStoryAttachment$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryAttachment.class, new GraphQLStoryAttachment$Deserializer());
    }

    public Object m21851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryAttachmentDeserializer.m5954a(jsonParser, (short) 202);
        Object graphQLStoryAttachment = new GraphQLStoryAttachment();
        ((BaseModel) graphQLStoryAttachment).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryAttachment instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryAttachment).a();
        }
        return graphQLStoryAttachment;
    }
}
