package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: feed_unit_celebrations */
public final class GraphQLLeadGenContextPage__JsonHelper {
    public static GraphQLLeadGenContextPage m8814a(JsonParser jsonParser) {
        GraphQLLeadGenContextPage graphQLLeadGenContextPage = new GraphQLLeadGenContextPage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("context_content".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLLeadGenContextPage.f4363d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_content", graphQLLeadGenContextPage.a_, 0, false);
            } else if ("context_content_style".equals(i)) {
                graphQLLeadGenContextPage.f4364e = GraphQLLeadGenContextPageContentStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_content_style", graphQLLeadGenContextPage.a_, 1, false);
            } else if ("context_cta".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenContextPage.f4365f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_cta", graphQLLeadGenContextPage.a_, 2, false);
            } else if ("context_image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "context_image"));
                }
                graphQLLeadGenContextPage.f4366g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_image", graphQLLeadGenContextPage.a_, 3, true);
            } else if ("context_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenContextPage.f4367h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_title", graphQLLeadGenContextPage.a_, 4, false);
            } else if ("context_card_photo".equals(i)) {
                GraphQLPhoto graphQLPhoto;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhoto = null;
                } else {
                    graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "context_card_photo"));
                }
                graphQLLeadGenContextPage.f4368i = graphQLPhoto;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenContextPage, "context_card_photo", graphQLLeadGenContextPage.a_, 5, true);
            }
            jsonParser.f();
        }
        return graphQLLeadGenContextPage;
    }

    public static void m8815a(JsonGenerator jsonGenerator, GraphQLLeadGenContextPage graphQLLeadGenContextPage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("context_content");
        if (graphQLLeadGenContextPage.m8806a() != null) {
            jsonGenerator.d();
            for (String str : graphQLLeadGenContextPage.m8806a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenContextPage.m8807j() != null) {
            jsonGenerator.a("context_content_style", graphQLLeadGenContextPage.m8807j().toString());
        }
        if (graphQLLeadGenContextPage.m8808k() != null) {
            jsonGenerator.a("context_cta", graphQLLeadGenContextPage.m8808k());
        }
        if (graphQLLeadGenContextPage.m8809l() != null) {
            jsonGenerator.a("context_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLLeadGenContextPage.m8809l(), true);
        }
        if (graphQLLeadGenContextPage.m8810m() != null) {
            jsonGenerator.a("context_title", graphQLLeadGenContextPage.m8810m());
        }
        if (graphQLLeadGenContextPage.m8811n() != null) {
            jsonGenerator.a("context_card_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLLeadGenContextPage.m8811n(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
