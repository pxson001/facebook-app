package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_REVIEW */
public class GraphQLPagesYouMayLikeFeedUnitItemContentConnectionSerializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnitItemContentConnection> {
    public final void m20574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayLikeFeedUnitItemContentConnection__JsonHelper.m20576a(jsonGenerator, (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class, new GraphQLPagesYouMayLikeFeedUnitItemContentConnectionSerializer());
    }
}
