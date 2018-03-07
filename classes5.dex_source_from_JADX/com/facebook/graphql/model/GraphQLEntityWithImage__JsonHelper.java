package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: instant_article */
public final class GraphQLEntityWithImage__JsonHelper {
    public static GraphQLEntityWithImage m7100a(JsonParser jsonParser) {
        GraphQLEntityWithImage graphQLEntityWithImage = new GraphQLEntityWithImage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLImage graphQLImage = null;
            if ("__type__".equals(i)) {
                GraphQLObjectType a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLObjectType.a(jsonParser);
                }
                graphQLEntityWithImage.d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityWithImage, "__type__", graphQLEntityWithImage.a_, 0, false);
            } else if ("id".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLEntityWithImage.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityWithImage, "id", graphQLEntityWithImage.a_, 1, false);
            } else if ("image".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLEntityWithImage.f = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityWithImage, "image", graphQLEntityWithImage.a_, 2, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEntityWithImage;
    }

    public static void m7101a(JsonGenerator jsonGenerator, GraphQLEntityWithImage graphQLEntityWithImage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEntityWithImage.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLEntityWithImage.j().e());
            jsonGenerator.g();
        }
        if (graphQLEntityWithImage.k() != null) {
            jsonGenerator.a("id", graphQLEntityWithImage.k());
        }
        if (graphQLEntityWithImage.l() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntityWithImage.l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
