package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TWO_PLAYER_MATCH_STATUS */
public class GraphQLWriteReviewActionLinkSerializer extends JsonSerializer<GraphQLWriteReviewActionLink> {
    public final void m22546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWriteReviewActionLink graphQLWriteReviewActionLink = (GraphQLWriteReviewActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLWriteReviewActionLink.m22539a() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLWriteReviewActionLink.m22539a(), true);
        }
        jsonGenerator.a("rating", graphQLWriteReviewActionLink.m22542j());
        if (graphQLWriteReviewActionLink.m22543k() != null) {
            jsonGenerator.a("title", graphQLWriteReviewActionLink.m22543k());
        }
        if (graphQLWriteReviewActionLink.m22544l() != null) {
            jsonGenerator.a("url", graphQLWriteReviewActionLink.m22544l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLWriteReviewActionLink.class, new GraphQLWriteReviewActionLinkSerializer());
    }
}
