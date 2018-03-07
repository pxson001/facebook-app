package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_real_time_activity_info */
public class GraphQLPageOutcomeButtonSerializer extends JsonSerializer<GraphQLPageOutcomeButton> {
    public final void m9505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageOutcomeButton__JsonHelper.m9507a(jsonGenerator, (GraphQLPageOutcomeButton) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageOutcomeButton.class, new GraphQLPageOutcomeButtonSerializer());
    }
}
