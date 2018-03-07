package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: graph_search_chevron_incorrect_page_category */
public final class GraphQLGoodwillHappyBirthdayCard__JsonHelper {
    public static GraphQLGoodwillHappyBirthdayCard m7888a(JsonParser jsonParser) {
        GraphQLGoodwillHappyBirthdayCard graphQLGoodwillHappyBirthdayCard = new GraphQLGoodwillHappyBirthdayCard();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("action_links".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLGoodwillHappyBirthdayCard.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayCard, "action_links", graphQLGoodwillHappyBirthdayCard.a_, 0, true);
            } else if ("birthday_stories".equals(i)) {
                GraphQLGoodwillHappyBirthdayStoriesConnection a2;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a2 = GraphQLGoodwillHappyBirthdayStoriesConnection__JsonHelper.m7898a(FieldAccessQueryTracker.a(jsonParser, "birthday_stories"));
                }
                graphQLGoodwillHappyBirthdayCard.e = a2;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayCard, "birthday_stories", graphQLGoodwillHappyBirthdayCard.a_, 1, true);
            } else if ("full_width_image".equals(i)) {
                GraphQLImage a3;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "full_width_image"));
                }
                graphQLGoodwillHappyBirthdayCard.f = a3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayCard, "full_width_image", graphQLGoodwillHappyBirthdayCard.a_, 2, true);
            } else if ("social_context".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
                }
                graphQLGoodwillHappyBirthdayCard.g = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayCard, "social_context", graphQLGoodwillHappyBirthdayCard.a_, 3, true);
            } else if ("title".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                }
                graphQLGoodwillHappyBirthdayCard.h = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayCard, "title", graphQLGoodwillHappyBirthdayCard.a_, 4, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillHappyBirthdayCard;
    }

    public static void m7889a(JsonGenerator jsonGenerator, GraphQLGoodwillHappyBirthdayCard graphQLGoodwillHappyBirthdayCard, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("action_links");
        if (graphQLGoodwillHappyBirthdayCard.a() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLGoodwillHappyBirthdayCard.a()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillHappyBirthdayCard.j() != null) {
            jsonGenerator.a("birthday_stories");
            GraphQLGoodwillHappyBirthdayStoriesConnection__JsonHelper.m7899a(jsonGenerator, graphQLGoodwillHappyBirthdayCard.j(), true);
        }
        if (graphQLGoodwillHappyBirthdayCard.k() != null) {
            jsonGenerator.a("full_width_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillHappyBirthdayCard.k(), true);
        }
        if (graphQLGoodwillHappyBirthdayCard.l() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillHappyBirthdayCard.l(), true);
        }
        if (graphQLGoodwillHappyBirthdayCard.m() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillHappyBirthdayCard.m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
