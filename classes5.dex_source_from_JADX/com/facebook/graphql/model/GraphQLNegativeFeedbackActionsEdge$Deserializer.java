package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: events_occurring_here */
public class GraphQLNegativeFeedbackActionsEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackActionsEdge.class, new GraphQLNegativeFeedbackActionsEdge$Deserializer());
    }

    public Object m9245a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNegativeFeedbackActionsEdgeDeserializer.m5419a(jsonParser, (short) 153);
        Object graphQLNegativeFeedbackActionsEdge = new GraphQLNegativeFeedbackActionsEdge();
        ((BaseModel) graphQLNegativeFeedbackActionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNegativeFeedbackActionsEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLNegativeFeedbackActionsEdge).a();
        }
        return graphQLNegativeFeedbackActionsEdge;
    }
}
