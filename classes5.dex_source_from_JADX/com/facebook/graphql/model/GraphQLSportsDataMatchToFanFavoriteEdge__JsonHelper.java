package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unknown action= */
public final class GraphQLSportsDataMatchToFanFavoriteEdge__JsonHelper {
    public static GraphQLSportsDataMatchToFanFavoriteEdge m21815a(JsonParser jsonParser) {
        GraphQLSportsDataMatchToFanFavoriteEdge graphQLSportsDataMatchToFanFavoriteEdge = new GraphQLSportsDataMatchToFanFavoriteEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLMediaQuestion graphQLMediaQuestion;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLMediaQuestion = null;
                } else {
                    graphQLMediaQuestion = GraphQLMediaQuestion__JsonHelper.m9061a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLSportsDataMatchToFanFavoriteEdge.f13074d = graphQLMediaQuestion;
                FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchToFanFavoriteEdge, "node", graphQLSportsDataMatchToFanFavoriteEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSportsDataMatchToFanFavoriteEdge;
    }

    public static void m21816a(JsonGenerator jsonGenerator, GraphQLSportsDataMatchToFanFavoriteEdge graphQLSportsDataMatchToFanFavoriteEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSportsDataMatchToFanFavoriteEdge.m21811a() != null) {
            jsonGenerator.a("node");
            GraphQLMediaQuestion__JsonHelper.m9062a(jsonGenerator, graphQLSportsDataMatchToFanFavoriteEdge.m21811a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
