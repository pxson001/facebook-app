package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friending_card */
public class GraphQLGroupCreationSuggestionSerializer extends JsonSerializer<GraphQLGroupCreationSuggestion> {
    public final void m8428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupCreationSuggestion__JsonHelper.m8430a(jsonGenerator, (GraphQLGroupCreationSuggestion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupCreationSuggestion.class, new GraphQLGroupCreationSuggestionSerializer());
    }
}
