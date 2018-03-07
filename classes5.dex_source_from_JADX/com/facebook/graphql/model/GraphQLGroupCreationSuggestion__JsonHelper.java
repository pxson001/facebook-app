package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friending */
public final class GraphQLGroupCreationSuggestion__JsonHelper {
    public static GraphQLGroupCreationSuggestion m8429a(JsonParser jsonParser) {
        GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion = new GraphQLGroupCreationSuggestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("default_group_name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGroupCreationSuggestion.f4192d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "default_group_name", graphQLGroupCreationSuggestion.a_, 0, false);
            } else if ("default_visibility".equals(i)) {
                graphQLGroupCreationSuggestion.f4193e = GraphQLGroupVisibility.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "default_visibility", graphQLGroupCreationSuggestion.a_, 1, false);
            } else if ("suggested_members".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggested_members"));
                        if (a != null) {
                            collection.add(a);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLGroupCreationSuggestion.f4194f = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "suggested_members", graphQLGroupCreationSuggestion.a_, 2, true);
            } else if ("suggestion_cover_image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggestion_cover_image"));
                }
                graphQLGroupCreationSuggestion.f4195g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "suggestion_cover_image", graphQLGroupCreationSuggestion.a_, 3, true);
            } else if ("suggestion_identifier".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGroupCreationSuggestion.f4196h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "suggestion_identifier", graphQLGroupCreationSuggestion.a_, 4, false);
            } else if ("suggestion_message".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggestion_message"));
                }
                graphQLGroupCreationSuggestion.f4197i = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "suggestion_message", graphQLGroupCreationSuggestion.a_, 5, true);
            } else if ("suggestion_type".equals(i)) {
                graphQLGroupCreationSuggestion.f4198j = GraphQLGroupCreationSuggestionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestion, "suggestion_type", graphQLGroupCreationSuggestion.a_, 6, false);
            }
            jsonParser.f();
        }
        return graphQLGroupCreationSuggestion;
    }

    public static void m8430a(JsonGenerator jsonGenerator, GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupCreationSuggestion.m8404a() != null) {
            jsonGenerator.a("default_group_name", graphQLGroupCreationSuggestion.m8404a());
        }
        if (graphQLGroupCreationSuggestion.m8405j() != null) {
            jsonGenerator.a("default_visibility", graphQLGroupCreationSuggestion.m8405j().toString());
        }
        jsonGenerator.a("suggested_members");
        if (graphQLGroupCreationSuggestion.m8406k() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGroupCreationSuggestion.m8406k()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupCreationSuggestion.m8407l() != null) {
            jsonGenerator.a("suggestion_cover_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroupCreationSuggestion.m8407l(), true);
        }
        if (graphQLGroupCreationSuggestion.m8408m() != null) {
            jsonGenerator.a("suggestion_identifier", graphQLGroupCreationSuggestion.m8408m());
        }
        if (graphQLGroupCreationSuggestion.m8409n() != null) {
            jsonGenerator.a("suggestion_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupCreationSuggestion.m8409n(), true);
        }
        if (graphQLGroupCreationSuggestion.m8410o() != null) {
            jsonGenerator.a("suggestion_type", graphQLGroupCreationSuggestion.m8410o().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
