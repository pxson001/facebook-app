package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIEW_PYML */
public final class GraphQLQuestionOptionVotersConnection__JsonHelper {
    public static GraphQLQuestionOptionVotersConnection m21180a(JsonParser jsonParser) {
        GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection = new GraphQLQuestionOptionVotersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLQuestionOptionVotersConnection.f12839d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOptionVotersConnection, "count", graphQLQuestionOptionVotersConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLQuestionOptionVotersConnection.f12840e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOptionVotersConnection, "nodes", graphQLQuestionOptionVotersConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLQuestionOptionVotersConnection.f12841f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOptionVotersConnection, "page_info", graphQLQuestionOptionVotersConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLQuestionOptionVotersConnection;
    }

    public static void m21181a(JsonGenerator jsonGenerator, GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLQuestionOptionVotersConnection.m21171a());
        jsonGenerator.a("nodes");
        if (graphQLQuestionOptionVotersConnection.m21176j() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLQuestionOptionVotersConnection.m21176j()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLQuestionOptionVotersConnection.m21177k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLQuestionOptionVotersConnection.m21177k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
