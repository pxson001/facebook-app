package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryAttachmentStyleInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to retrieve idle power stats */
public class GraphQLStoryAttachmentStyleInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryAttachmentStyleInfo.class, new GraphQLStoryAttachmentStyleInfo$Deserializer());
    }

    public Object m21855a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryAttachmentStyleInfoDeserializer.m5959a(jsonParser, (short) 502);
        Object graphQLStoryAttachmentStyleInfo = new GraphQLStoryAttachmentStyleInfo();
        ((BaseModel) graphQLStoryAttachmentStyleInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryAttachmentStyleInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryAttachmentStyleInfo).a();
        }
        return graphQLStoryAttachmentStyleInfo;
    }
}
