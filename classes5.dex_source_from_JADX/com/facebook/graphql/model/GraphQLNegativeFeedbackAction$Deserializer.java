package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: expected closing END_ARRAY after type information and deserialized value */
public class GraphQLNegativeFeedbackAction$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackAction.class, new GraphQLNegativeFeedbackAction$Deserializer());
    }

    public Object m9232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNegativeFeedbackActionDeserializer.m5413a(jsonParser, (short) 72);
        Object graphQLNegativeFeedbackAction = new GraphQLNegativeFeedbackAction();
        ((BaseModel) graphQLNegativeFeedbackAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNegativeFeedbackAction instanceof Postprocessable) {
            return ((Postprocessable) graphQLNegativeFeedbackAction).a();
        }
        return graphQLNegativeFeedbackAction;
    }
}
