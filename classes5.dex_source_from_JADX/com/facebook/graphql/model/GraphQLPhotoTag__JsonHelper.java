package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WILDE_GROUP_PROFILE_MORE */
public final class GraphQLPhotoTag__JsonHelper {
    public static GraphQLPhotoTag m20744a(JsonParser jsonParser) {
        GraphQLPhotoTag graphQLPhotoTag = new GraphQLPhotoTag();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20746a(graphQLPhotoTag, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPhotoTag;
    }

    private static boolean m20746a(GraphQLPhotoTag graphQLPhotoTag, String str, JsonParser jsonParser) {
        GraphQLActor graphQLActor = null;
        if ("can_viewer_remove_tag".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLPhotoTag.f12558d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTag, "can_viewer_remove_tag", graphQLPhotoTag.a_, 0, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLVect2 a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLPhotoTag.f12559e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTag, "location", graphQLPhotoTag.B_(), 1, true);
            return true;
        } else if ("tagger".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "tagger"));
            }
            graphQLPhotoTag.f12560f = graphQLActor;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTag, "tagger", graphQLPhotoTag.B_(), 2, true);
            return true;
        } else if (!"time".equals(str)) {
            return false;
        } else {
            graphQLPhotoTag.f12561g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTag, "time", graphQLPhotoTag.B_(), 3, false);
            return true;
        }
    }

    public static void m20745a(JsonGenerator jsonGenerator, GraphQLPhotoTag graphQLPhotoTag, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_viewer_remove_tag", graphQLPhotoTag.m20738a());
        if (graphQLPhotoTag.m20739j() != null) {
            jsonGenerator.a("location");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLPhotoTag.m20739j(), true);
        }
        if (graphQLPhotoTag.m20740k() != null) {
            jsonGenerator.a("tagger");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLPhotoTag.m20740k(), true);
        }
        jsonGenerator.a("time", graphQLPhotoTag.m20741l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
