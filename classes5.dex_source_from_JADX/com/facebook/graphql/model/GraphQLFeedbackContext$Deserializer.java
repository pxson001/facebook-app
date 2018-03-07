package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackContextDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: home_team_name */
public class GraphQLFeedbackContext$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackContext.class, new GraphQLFeedbackContext$Deserializer());
    }

    public Object m7475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedbackContextDeserializer.m4890a(jsonParser, (short) 374);
        Object graphQLFeedbackContext = new GraphQLFeedbackContext();
        ((BaseModel) graphQLFeedbackContext).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedbackContext instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedbackContext).a();
        }
        return graphQLFeedbackContext;
    }
}
