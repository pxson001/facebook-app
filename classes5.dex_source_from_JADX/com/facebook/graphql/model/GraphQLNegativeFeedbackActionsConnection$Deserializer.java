package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: exception occured while trying to create the socket factory */
public class GraphQLNegativeFeedbackActionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackActionsConnection.class, new GraphQLNegativeFeedbackActionsConnection$Deserializer());
    }

    public Object m9239a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5416a(jsonParser, (short) 152);
        Object graphQLNegativeFeedbackActionsConnection = new GraphQLNegativeFeedbackActionsConnection();
        ((BaseModel) graphQLNegativeFeedbackActionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNegativeFeedbackActionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLNegativeFeedbackActionsConnection).a();
        }
        return graphQLNegativeFeedbackActionsConnection;
    }
}
