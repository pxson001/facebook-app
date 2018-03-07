package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLResearchPollFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_HOME_PINNED_TOPICS_LIVE */
public class GraphQLResearchPollFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollFeedUnit.class, new GraphQLResearchPollFeedUnit$Deserializer());
    }

    public Object m21399a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLResearchPollFeedUnitDeserializer.m5811a(jsonParser, (short) 39);
        Object graphQLResearchPollFeedUnit = new GraphQLResearchPollFeedUnit();
        ((BaseModel) graphQLResearchPollFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLResearchPollFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLResearchPollFeedUnit).a();
        }
        return graphQLResearchPollFeedUnit;
    }
}
