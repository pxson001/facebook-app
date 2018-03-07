package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getTotalTimeLocked */
public class GraphQLGoodwillThrowbackOriginalPostActionLinkSerializer extends JsonSerializer<GraphQLGoodwillThrowbackOriginalPostActionLink> {
    public final void m8059a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackOriginalPostActionLink graphQLGoodwillThrowbackOriginalPostActionLink = (GraphQLGoodwillThrowbackOriginalPostActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackOriginalPostActionLink.m8056a() != null) {
            jsonGenerator.a("title", graphQLGoodwillThrowbackOriginalPostActionLink.m8056a());
        }
        if (graphQLGoodwillThrowbackOriginalPostActionLink.m8057j() != null) {
            jsonGenerator.a("url", graphQLGoodwillThrowbackOriginalPostActionLink.m8057j());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackOriginalPostActionLink.class, new GraphQLGoodwillThrowbackOriginalPostActionLinkSerializer());
    }
}
