package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackReactionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hoisted_story_ids */
public class GraphQLFeedbackReaction$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackReaction.class, new GraphQLFeedbackReaction$Deserializer());
    }

    public Object m7483a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedbackReactionDeserializer.m4897a(jsonParser, (short) 208);
        Object graphQLFeedbackReaction = new GraphQLFeedbackReaction();
        ((BaseModel) graphQLFeedbackReaction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedbackReaction instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedbackReaction).a();
        }
        return graphQLFeedbackReaction;
    }
}
