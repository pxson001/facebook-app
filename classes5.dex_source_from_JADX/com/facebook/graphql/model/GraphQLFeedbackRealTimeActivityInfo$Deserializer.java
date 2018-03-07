package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackRealTimeActivityInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hideStory */
public class GraphQLFeedbackRealTimeActivityInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackRealTimeActivityInfo.class, new GraphQLFeedbackRealTimeActivityInfo$Deserializer());
    }

    public Object m7501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedbackRealTimeActivityInfoDeserializer.m4908a(jsonParser, (short) 212);
        Object graphQLFeedbackRealTimeActivityInfo = new GraphQLFeedbackRealTimeActivityInfo();
        ((BaseModel) graphQLFeedbackRealTimeActivityInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedbackRealTimeActivityInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedbackRealTimeActivityInfo).a();
        }
        return graphQLFeedbackRealTimeActivityInfo;
    }
}
