package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackReactionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: history */
public class GraphQLFeedbackReactionInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackReactionInfo.class, new GraphQLFeedbackReactionInfo$Deserializer());
    }

    public Object m7487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedbackReactionInfoDeserializer.m4902a(jsonParser, (short) 45);
        Object graphQLFeedbackReactionInfo = new GraphQLFeedbackReactionInfo();
        ((BaseModel) graphQLFeedbackReactionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedbackReactionInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedbackReactionInfo).a();
        }
        return graphQLFeedbackReactionInfo;
    }
}
