package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTICAL */
public class GraphQLSearchAwarenessSuggestionSerializer extends JsonSerializer<GraphQLSearchAwarenessSuggestion> {
    public final void m21572a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSearchAwarenessSuggestion graphQLSearchAwarenessSuggestion = (GraphQLSearchAwarenessSuggestion) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSearchAwarenessSuggestion.m21564j() != null) {
            jsonGenerator.a("id", graphQLSearchAwarenessSuggestion.m21564j());
        }
        jsonGenerator.a("keywords_suggestions");
        if (graphQLSearchAwarenessSuggestion.m21565k() != null) {
            jsonGenerator.d();
            for (String str : graphQLSearchAwarenessSuggestion.m21565k()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSearchAwarenessSuggestion.m21566l() != null) {
            jsonGenerator.a("suggestion_description", graphQLSearchAwarenessSuggestion.m21566l());
        }
        if (graphQLSearchAwarenessSuggestion.m21567m() != null) {
            jsonGenerator.a("suggestion_template", graphQLSearchAwarenessSuggestion.m21567m().toString());
        }
        if (graphQLSearchAwarenessSuggestion.m21568n() != null) {
            jsonGenerator.a("suggestion_title", graphQLSearchAwarenessSuggestion.m21568n());
        }
        if (graphQLSearchAwarenessSuggestion.m21569o() != null) {
            jsonGenerator.a("test_name", graphQLSearchAwarenessSuggestion.m21569o());
        }
        if (graphQLSearchAwarenessSuggestion.m21570p() != null) {
            jsonGenerator.a("url", graphQLSearchAwarenessSuggestion.m21570p());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSearchAwarenessSuggestion.class, new GraphQLSearchAwarenessSuggestionSerializer());
    }
}
