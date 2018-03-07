package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNKNOWN TYPE */
public final class GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper {
    public static GraphQLTimelineAppCollectionMembershipStateInfo m22157a(JsonParser jsonParser) {
        GraphQLTimelineAppCollectionMembershipStateInfo graphQLTimelineAppCollectionMembershipStateInfo = new GraphQLTimelineAppCollectionMembershipStateInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            int i2;
            if ("name".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLTimelineAppCollectionMembershipStateInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionMembershipStateInfo, "name", graphQLTimelineAppCollectionMembershipStateInfo.a_, 0, false);
                i2 = 1;
            } else if ("tip".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "tip"));
                }
                graphQLTimelineAppCollectionMembershipStateInfo.e = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionMembershipStateInfo, "tip", graphQLTimelineAppCollectionMembershipStateInfo.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLTimelineAppCollectionMembershipStateInfo;
    }

    public static void m22158a(JsonGenerator jsonGenerator, GraphQLTimelineAppCollectionMembershipStateInfo graphQLTimelineAppCollectionMembershipStateInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimelineAppCollectionMembershipStateInfo.a() != null) {
            jsonGenerator.a("name", graphQLTimelineAppCollectionMembershipStateInfo.a());
        }
        if (graphQLTimelineAppCollectionMembershipStateInfo.j() != null) {
            jsonGenerator.a("tip");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionMembershipStateInfo.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
