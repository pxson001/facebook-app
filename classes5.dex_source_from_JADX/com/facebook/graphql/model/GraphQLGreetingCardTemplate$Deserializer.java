package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGreetingCardTemplateDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friends_who_like */
public class GraphQLGreetingCardTemplate$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardTemplate.class, new GraphQLGreetingCardTemplate$Deserializer());
    }

    public Object m8359a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGreetingCardTemplateDeserializer.m5137a(jsonParser, (short) 53);
        Object graphQLGreetingCardTemplate = new GraphQLGreetingCardTemplate();
        ((BaseModel) graphQLGreetingCardTemplate).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGreetingCardTemplate instanceof Postprocessable) {
            return ((Postprocessable) graphQLGreetingCardTemplate).a();
        }
        return graphQLGreetingCardTemplate;
    }
}
