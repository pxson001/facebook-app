package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendlist */
public class GraphQLGroupCreationSuggestionDefaultMembersConnectionSerializer extends JsonSerializer<GraphQLGroupCreationSuggestionDefaultMembersConnection> {
    public final void m8424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C0396xbb7ddb05.m8426a(jsonGenerator, (GraphQLGroupCreationSuggestionDefaultMembersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class, new GraphQLGroupCreationSuggestionDefaultMembersConnectionSerializer());
    }
}
