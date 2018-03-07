package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: isCheckin */
public final class GraphQLContact__JsonHelper {
    public static GraphQLContact m6884a(JsonParser jsonParser) {
        GraphQLContact graphQLContact = new GraphQLContact();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6886a(graphQLContact, i, jsonParser);
            jsonParser.f();
        }
        return graphQLContact;
    }

    private static boolean m6886a(GraphQLContact graphQLContact, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("added_time".equals(str)) {
            long j;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                j = 0;
            } else {
                j = jsonParser.F();
            }
            graphQLContact.d = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "added_time", graphQLContact.a_, 0, false);
            return true;
        } else if ("bigPictureUrl".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "bigPictureUrl"));
            }
            graphQLContact.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "bigPictureUrl", graphQLContact.B_(), 1, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLContact.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "feedAwesomizerProfilePicture", graphQLContact.B_(), 2, true);
            return true;
        } else if ("graph_api_write_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLContact.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "graph_api_write_id", graphQLContact.B_(), 3, false);
            return true;
        } else if ("hugePictureUrl".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "hugePictureUrl"));
            }
            graphQLContact.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "hugePictureUrl", graphQLContact.B_(), 4, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLContact.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "id", graphQLContact.B_(), 5, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLContact.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "imageHighOrig", graphQLContact.B_(), 6, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLContact.k = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "inline_activities", graphQLContact.B_(), 7, true);
            return true;
        } else if ("is_on_viewer_contact_list".equals(str)) {
            graphQLContact.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "is_on_viewer_contact_list", graphQLContact.B_(), 8, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLContact.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "name", graphQLContact.B_(), 9, false);
            return true;
        } else if ("phonetic_name".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLName__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "phonetic_name"));
            }
            graphQLContact.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "phonetic_name", graphQLContact.B_(), 10, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLContact.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profileImageLarge", graphQLContact.B_(), 11, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLContact.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profileImageSmall", graphQLContact.B_(), 12, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLContact.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profilePicture50", graphQLContact.B_(), 13, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLContact.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profilePictureHighRes", graphQLContact.B_(), 14, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLContact.s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profilePictureLarge", graphQLContact.B_(), 15, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLContact.t = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profile_photo", graphQLContact.B_(), 16, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLContact.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profile_picture", graphQLContact.B_(), 17, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLContact.v = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "profile_picture_is_silhouette", graphQLContact.B_(), 18, false);
            return true;
        } else if ("represented_profile".equals(str)) {
            GraphQLActor a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "represented_profile"));
            }
            graphQLContact.w = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "represented_profile", graphQLContact.B_(), 19, true);
            return true;
        } else if ("smallPictureUrl".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "smallPictureUrl"));
            }
            graphQLContact.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "smallPictureUrl", graphQLContact.B_(), 20, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLContact.y = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "streaming_profile_picture", graphQLContact.B_(), 21, true);
            return true;
        } else if ("structured_name".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLName__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "structured_name"));
            }
            graphQLContact.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "structured_name", graphQLContact.B_(), 22, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLContact.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "taggable_object_profile_picture", graphQLContact.B_(), 23, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLContact.B = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLContact, "url", graphQLContact.B_(), 24, false);
            return true;
        }
    }

    public static void m6885a(JsonGenerator jsonGenerator, GraphQLContact graphQLContact, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("added_time", graphQLContact.j());
        if (graphQLContact.k() != null) {
            jsonGenerator.a("bigPictureUrl");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.k(), true);
        }
        if (graphQLContact.l() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.l(), true);
        }
        if (graphQLContact.m() != null) {
            jsonGenerator.a("graph_api_write_id", graphQLContact.m());
        }
        if (graphQLContact.n() != null) {
            jsonGenerator.a("hugePictureUrl");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.n(), true);
        }
        if (graphQLContact.o() != null) {
            jsonGenerator.a("id", graphQLContact.o());
        }
        if (graphQLContact.p() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.p(), true);
        }
        if (graphQLContact.q() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLContact.q(), true);
        }
        jsonGenerator.a("is_on_viewer_contact_list", graphQLContact.r());
        if (graphQLContact.s() != null) {
            jsonGenerator.a("name", graphQLContact.s());
        }
        if (graphQLContact.t() != null) {
            jsonGenerator.a("phonetic_name");
            GraphQLName__JsonHelper.a(jsonGenerator, graphQLContact.t(), true);
        }
        if (graphQLContact.u() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.u(), true);
        }
        if (graphQLContact.v() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.v(), true);
        }
        if (graphQLContact.w() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.w(), true);
        }
        if (graphQLContact.x() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.x(), true);
        }
        if (graphQLContact.y() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.y(), true);
        }
        if (graphQLContact.z() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLContact.z(), true);
        }
        if (graphQLContact.A() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.A(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLContact.B());
        if (graphQLContact.C() != null) {
            jsonGenerator.a("represented_profile");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLContact.C(), true);
        }
        if (graphQLContact.D() != null) {
            jsonGenerator.a("smallPictureUrl");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.D(), true);
        }
        if (graphQLContact.E() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLContact.E(), true);
        }
        if (graphQLContact.F() != null) {
            jsonGenerator.a("structured_name");
            GraphQLName__JsonHelper.a(jsonGenerator, graphQLContact.F(), true);
        }
        if (graphQLContact.G() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLContact.G(), true);
        }
        if (graphQLContact.H() != null) {
            jsonGenerator.a("url", graphQLContact.H());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
