package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: image_pipeline */
public final class GraphQLEventTicketProvider__JsonHelper {
    public static GraphQLEventTicketProvider m7297a(JsonParser jsonParser) {
        GraphQLEventTicketProvider graphQLEventTicketProvider = new GraphQLEventTicketProvider();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("delivery_info_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTicketProvider.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "delivery_info_text", graphQLEventTicketProvider.a_, 0, false);
            } else if ("delivery_requirements_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTicketProvider.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "delivery_requirements_text", graphQLEventTicketProvider.a_, 1, false);
            } else if ("learn_more_text".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "learn_more_text"));
                }
                graphQLEventTicketProvider.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "learn_more_text", graphQLEventTicketProvider.a_, 2, true);
            } else if ("logo_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTicketProvider.g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "logo_url", graphQLEventTicketProvider.a_, 3, false);
            } else if ("name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTicketProvider.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "name", graphQLEventTicketProvider.a_, 4, false);
            } else if ("post_purchase_additional_note".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "post_purchase_additional_note"));
                }
                graphQLEventTicketProvider.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "post_purchase_additional_note", graphQLEventTicketProvider.a_, 5, true);
            } else if ("terms_and_policy_text".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "terms_and_policy_text"));
                }
                graphQLEventTicketProvider.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "terms_and_policy_text", graphQLEventTicketProvider.a_, 6, true);
            } else if ("ticket_redemption_note".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTicketProvider.k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketProvider, "ticket_redemption_note", graphQLEventTicketProvider.a_, 7, false);
            }
            jsonParser.f();
        }
        return graphQLEventTicketProvider;
    }

    public static void m7298a(JsonGenerator jsonGenerator, GraphQLEventTicketProvider graphQLEventTicketProvider, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventTicketProvider.a() != null) {
            jsonGenerator.a("delivery_info_text", graphQLEventTicketProvider.a());
        }
        if (graphQLEventTicketProvider.j() != null) {
            jsonGenerator.a("delivery_requirements_text", graphQLEventTicketProvider.j());
        }
        if (graphQLEventTicketProvider.k() != null) {
            jsonGenerator.a("learn_more_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEventTicketProvider.k(), true);
        }
        if (graphQLEventTicketProvider.l() != null) {
            jsonGenerator.a("logo_url", graphQLEventTicketProvider.l());
        }
        if (graphQLEventTicketProvider.m() != null) {
            jsonGenerator.a("name", graphQLEventTicketProvider.m());
        }
        if (graphQLEventTicketProvider.n() != null) {
            jsonGenerator.a("post_purchase_additional_note");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEventTicketProvider.n(), true);
        }
        if (graphQLEventTicketProvider.o() != null) {
            jsonGenerator.a("terms_and_policy_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEventTicketProvider.o(), true);
        }
        if (graphQLEventTicketProvider.p() != null) {
            jsonGenerator.a("ticket_redemption_note", graphQLEventTicketProvider.p());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
