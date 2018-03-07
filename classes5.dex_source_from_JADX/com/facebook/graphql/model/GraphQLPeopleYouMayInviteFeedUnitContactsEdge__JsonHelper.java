package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WORK_ANNOUNCEMENT */
public final class GraphQLPeopleYouMayInviteFeedUnitContactsEdge__JsonHelper {
    public static GraphQLPeopleYouMayInviteFeedUnitContactsEdge m20668a(JsonParser jsonParser) {
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = new GraphQLPeopleYouMayInviteFeedUnitContactsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("contact_name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPeopleYouMayInviteFeedUnitContactsEdge.f12473d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsEdge, "contact_name", graphQLPeopleYouMayInviteFeedUnitContactsEdge.a_, 0, false);
            } else if ("display_credential".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPeopleYouMayInviteFeedUnitContactsEdge.f12474e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsEdge, "display_credential", graphQLPeopleYouMayInviteFeedUnitContactsEdge.a_, 1, false);
            } else if ("tracking".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPeopleYouMayInviteFeedUnitContactsEdge.f12475f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsEdge, "tracking", graphQLPeopleYouMayInviteFeedUnitContactsEdge.a_, 2, false);
            } else if ("node".equals(i)) {
                GraphQLContactPoint graphQLContactPoint;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLContactPoint = null;
                } else {
                    graphQLContactPoint = GraphQLContactPoint__JsonHelper.m6874a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLPeopleYouMayInviteFeedUnitContactsEdge.f12476g = graphQLContactPoint;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsEdge, "node", graphQLPeopleYouMayInviteFeedUnitContactsEdge.a_, 3, true);
            }
            jsonParser.f();
        }
        return graphQLPeopleYouMayInviteFeedUnitContactsEdge;
    }

    public static void m20669a(JsonGenerator jsonGenerator, GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20661j() != null) {
            jsonGenerator.a("contact_name", graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20661j());
        }
        if (graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20663l() != null) {
            jsonGenerator.a("display_credential", graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20663l());
        }
        if (graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20662k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20662k());
        }
        if (graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20664m() != null) {
            jsonGenerator.a("node");
            GraphQLContactPoint__JsonHelper.m6875a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnitContactsEdge.m20664m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
