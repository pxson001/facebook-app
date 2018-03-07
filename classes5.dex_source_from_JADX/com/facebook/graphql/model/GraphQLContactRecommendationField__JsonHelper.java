package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLContactFieldLabelType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: isCurrent */
public final class GraphQLContactRecommendationField__JsonHelper {
    public static GraphQLContactRecommendationField m6880a(JsonParser jsonParser) {
        GraphQLContactRecommendationField graphQLContactRecommendationField = new GraphQLContactRecommendationField();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6882a(graphQLContactRecommendationField, i, jsonParser);
            jsonParser.f();
        }
        return graphQLContactRecommendationField;
    }

    private static boolean m6882a(GraphQLContactRecommendationField graphQLContactRecommendationField, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("creation_time".equals(str)) {
            long j;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                j = 0;
            } else {
                j = jsonParser.F();
            }
            graphQLContactRecommendationField.d = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "creation_time", graphQLContactRecommendationField.a_, 0, false);
            return true;
        } else if ("creator".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creator"));
            }
            graphQLContactRecommendationField.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "creator", graphQLContactRecommendationField.B_(), 1, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLContactRecommendationField.f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "feedback", graphQLContactRecommendationField.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLContactRecommendationField.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "id", graphQLContactRecommendationField.B_(), 3, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLContactRecommendationField.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "image", graphQLContactRecommendationField.B_(), 4, true);
            return true;
        } else if ("label".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLContactRecommendationField.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "label", graphQLContactRecommendationField.B_(), 5, false);
            return true;
        } else if ("label_type".equals(str)) {
            graphQLContactRecommendationField.j = GraphQLContactFieldLabelType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "label_type", graphQLContactRecommendationField.B_(), 6, false);
            return true;
        } else if ("page_rating".equals(str)) {
            graphQLContactRecommendationField.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "page_rating", graphQLContactRecommendationField.B_(), 7, false);
            return true;
        } else if ("photos".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhoto a2 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "photos"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLContactRecommendationField.l = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "photos", graphQLContactRecommendationField.B_(), 8, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLContactRecommendationField.m = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "privacy_scope", graphQLContactRecommendationField.B_(), 9, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLContactRecommendationField.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "profileImageLarge", graphQLContactRecommendationField.B_(), 10, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLContactRecommendationField.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "profileImageSmall", graphQLContactRecommendationField.B_(), 11, true);
            return true;
        } else if ("represented_profile".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "represented_profile"));
            }
            graphQLContactRecommendationField.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "represented_profile", graphQLContactRecommendationField.B_(), 12, true);
            return true;
        } else if ("story".equals(str)) {
            GraphQLStory a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "story"));
            }
            graphQLContactRecommendationField.q = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "story", graphQLContactRecommendationField.B_(), 13, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLContactRecommendationField.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "url", graphQLContactRecommendationField.B_(), 14, false);
            return true;
        } else if (!"value".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "value"));
            }
            graphQLContactRecommendationField.s = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLContactRecommendationField, "value", graphQLContactRecommendationField.B_(), 15, true);
            return true;
        }
    }

    public static void m6881a(JsonGenerator jsonGenerator, GraphQLContactRecommendationField graphQLContactRecommendationField, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("creation_time", graphQLContactRecommendationField.j());
        if (graphQLContactRecommendationField.k() != null) {
            jsonGenerator.a("creator");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.k(), true);
        }
        if (graphQLContactRecommendationField.l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.l(), true);
        }
        if (graphQLContactRecommendationField.m() != null) {
            jsonGenerator.a("id", graphQLContactRecommendationField.m());
        }
        if (graphQLContactRecommendationField.n() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.n(), true);
        }
        if (graphQLContactRecommendationField.o() != null) {
            jsonGenerator.a("label", graphQLContactRecommendationField.o());
        }
        if (graphQLContactRecommendationField.p() != null) {
            jsonGenerator.a("label_type", graphQLContactRecommendationField.p().toString());
        }
        jsonGenerator.a("page_rating", graphQLContactRecommendationField.q());
        jsonGenerator.a("photos");
        if (graphQLContactRecommendationField.r() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLContactRecommendationField.r()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLContactRecommendationField.s() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLContactRecommendationField.s(), true);
        }
        if (graphQLContactRecommendationField.t() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.t(), true);
        }
        if (graphQLContactRecommendationField.u() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.u(), true);
        }
        if (graphQLContactRecommendationField.v() != null) {
            jsonGenerator.a("represented_profile");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.v(), true);
        }
        if (graphQLContactRecommendationField.w() != null) {
            jsonGenerator.a("story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLContactRecommendationField.w(), true);
        }
        if (graphQLContactRecommendationField.x() != null) {
            jsonGenerator.a("url", graphQLContactRecommendationField.x());
        }
        if (graphQLContactRecommendationField.y() != null) {
            jsonGenerator.a("value");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLContactRecommendationField.y(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
