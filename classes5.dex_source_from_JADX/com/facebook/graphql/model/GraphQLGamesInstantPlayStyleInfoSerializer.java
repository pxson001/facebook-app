package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_logo */
public class GraphQLGamesInstantPlayStyleInfoSerializer extends JsonSerializer<GraphQLGamesInstantPlayStyleInfo> {
    public final void m7761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGamesInstantPlayStyleInfo graphQLGamesInstantPlayStyleInfo = (GraphQLGamesInstantPlayStyleInfo) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGamesInstantPlayStyleInfo.m7755a() != null) {
            jsonGenerator.a("game_uri", graphQLGamesInstantPlayStyleInfo.m7755a());
        }
        if (graphQLGamesInstantPlayStyleInfo.m7756j() != null) {
            jsonGenerator.a("instant_game_id", graphQLGamesInstantPlayStyleInfo.m7756j());
        }
        if (graphQLGamesInstantPlayStyleInfo.m7757k() != null) {
            jsonGenerator.a("mobile_game_uri", graphQLGamesInstantPlayStyleInfo.m7757k());
        }
        if (graphQLGamesInstantPlayStyleInfo.m7758l() != null) {
            jsonGenerator.a("splash_uri", graphQLGamesInstantPlayStyleInfo.m7758l());
        }
        if (graphQLGamesInstantPlayStyleInfo.m7759m() != null) {
            jsonGenerator.a("video_uri", graphQLGamesInstantPlayStyleInfo.m7759m());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGamesInstantPlayStyleInfo.class, new GraphQLGamesInstantPlayStyleInfoSerializer());
    }
}
