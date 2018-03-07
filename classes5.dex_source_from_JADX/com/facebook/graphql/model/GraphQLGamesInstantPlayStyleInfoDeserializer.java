package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_nax */
public class GraphQLGamesInstantPlayStyleInfoDeserializer extends FbJsonDeserializer {
    public Object m7760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGamesInstantPlayStyleInfo graphQLGamesInstantPlayStyleInfo = new GraphQLGamesInstantPlayStyleInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGamesInstantPlayStyleInfo = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("game_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGamesInstantPlayStyleInfo.f3843d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGamesInstantPlayStyleInfo, "game_uri", graphQLGamesInstantPlayStyleInfo.a_, 0, false);
                } else if ("instant_game_id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGamesInstantPlayStyleInfo.f3844e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGamesInstantPlayStyleInfo, "instant_game_id", graphQLGamesInstantPlayStyleInfo.a_, 1, false);
                } else if ("mobile_game_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGamesInstantPlayStyleInfo.f3845f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGamesInstantPlayStyleInfo, "mobile_game_uri", graphQLGamesInstantPlayStyleInfo.a_, 2, false);
                } else if ("splash_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGamesInstantPlayStyleInfo.f3846g = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGamesInstantPlayStyleInfo, "splash_uri", graphQLGamesInstantPlayStyleInfo.a_, 3, false);
                } else if ("video_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGamesInstantPlayStyleInfo.f3847h = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGamesInstantPlayStyleInfo, "video_uri", graphQLGamesInstantPlayStyleInfo.a_, 4, false);
                }
                jsonParser.f();
            }
        }
        return graphQLGamesInstantPlayStyleInfo;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGamesInstantPlayStyleInfo.class, new GraphQLGamesInstantPlayStyleInfoDeserializer());
    }

    public GraphQLGamesInstantPlayStyleInfoDeserializer() {
        a(GraphQLGamesInstantPlayStyleInfo.class);
    }
}
