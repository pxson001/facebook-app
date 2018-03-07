package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getWakelockStats */
public final class GraphQLGoodwillThrowbackFriendversaryStory__JsonHelper {
    public static boolean m8034a(GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory, String str, JsonParser jsonParser) {
        GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillThrowbackFriendversaryStory.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("accent_image".equals(str)) {
            GraphQLImage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "accent_image"));
            }
            graphQLGoodwillThrowbackFriendversaryStory.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "accent_image", graphQLGoodwillThrowbackFriendversaryStory.a_, 0, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGoodwillThrowbackFriendversaryStory.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "fetchTimeMs", graphQLGoodwillThrowbackFriendversaryStory.B_(), 1, false);
            return true;
        } else if ("friend_list".equals(str)) {
            GraphQLGoodwillThrowbackFriendListConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8001a(FieldAccessQueryTracker.a(jsonParser, "friend_list"));
            }
            graphQLGoodwillThrowbackFriendversaryStory.g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "friend_list", graphQLGoodwillThrowbackFriendversaryStory.B_(), 2, true);
            return true;
        } else if ("title".equals(str)) {
            GraphQLTextWithEntities a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGoodwillThrowbackFriendversaryStory.h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "title", graphQLGoodwillThrowbackFriendversaryStory.B_(), 3, true);
            return true;
        } else if ("render_style".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLGoodwillThrowbackFriendversaryStory.i = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "render_style", graphQLGoodwillThrowbackFriendversaryStory.B_(), 4, false);
            return true;
        } else if (!"section_header".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLGoodwillThrowbackSection = GraphQLGoodwillThrowbackSection__JsonHelper.m8116a(FieldAccessQueryTracker.a(jsonParser, "section_header"));
            }
            graphQLGoodwillThrowbackFriendversaryStory.j = graphQLGoodwillThrowbackSection;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryStory, "section_header", graphQLGoodwillThrowbackFriendversaryStory.B_(), 5, true);
            return true;
        }
    }
}
