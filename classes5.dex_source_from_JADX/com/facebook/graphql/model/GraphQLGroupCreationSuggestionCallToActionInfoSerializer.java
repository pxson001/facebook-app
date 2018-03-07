package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_center */
public class GraphQLGroupCreationSuggestionCallToActionInfoSerializer extends JsonSerializer<GraphQLGroupCreationSuggestionCallToActionInfo> {
    public final void m8417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupCreationSuggestionCallToActionInfo graphQLGroupCreationSuggestionCallToActionInfo = (GraphQLGroupCreationSuggestionCallToActionInfo) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupCreationSuggestionCallToActionInfo.m8414a() != null) {
            jsonGenerator.a("creation_suggestion");
            GraphQLGroupCreationSuggestion__JsonHelper.m8430a(jsonGenerator, graphQLGroupCreationSuggestionCallToActionInfo.m8414a(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupCreationSuggestionCallToActionInfo.class, new GraphQLGroupCreationSuggestionCallToActionInfoSerializer());
    }
}
