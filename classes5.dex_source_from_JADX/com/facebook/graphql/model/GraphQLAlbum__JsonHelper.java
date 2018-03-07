package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: jobId = -1 */
public final class GraphQLAlbum__JsonHelper {
    public static GraphQLAlbum m6510a(JsonParser jsonParser) {
        GraphQLAlbum graphQLAlbum = new GraphQLAlbum();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6512a(graphQLAlbum, i, jsonParser);
            jsonParser.f();
        }
        return graphQLAlbum;
    }

    private static boolean m6512a(GraphQLAlbum graphQLAlbum, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection = null;
        if ("album_cover_photo".equals(str)) {
            GraphQLPhoto a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "album_cover_photo"));
            }
            graphQLAlbum.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "album_cover_photo", graphQLAlbum.a_, 0, true);
            return true;
        } else if ("album_type".equals(str)) {
            graphQLAlbum.e = GraphQLPhotosAlbumAPIType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "album_type", graphQLAlbum.B_(), 1, false);
            return true;
        } else if ("allow_contributors".equals(str)) {
            graphQLAlbum.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "allow_contributors", graphQLAlbum.B_(), 2, false);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLAlbum.g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "application", graphQLAlbum.B_(), 3, true);
            return true;
        } else if ("can_edit_caption".equals(str)) {
            graphQLAlbum.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "can_edit_caption", graphQLAlbum.B_(), 4, false);
            return true;
        } else if ("can_upload".equals(str)) {
            graphQLAlbum.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "can_upload", graphQLAlbum.B_(), 5, false);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLAlbum.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "can_viewer_delete", graphQLAlbum.B_(), 6, false);
            return true;
        } else if ("contributors".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a3 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "contributors"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLAlbum.k = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "contributors", graphQLAlbum.B_(), 7, true);
            return true;
        } else if ("created_time".equals(str)) {
            graphQLAlbum.l = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "created_time", graphQLAlbum.B_(), 8, false);
            return true;
        } else if ("explicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
            }
            graphQLAlbum.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "explicit_place", graphQLAlbum.B_(), 9, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLAlbum.n = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "feedback", graphQLAlbum.B_(), 10, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLAlbum.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "id", graphQLAlbum.B_(), 11, false);
            return true;
        } else if ("implicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "implicit_place"));
            }
            graphQLAlbum.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "implicit_place", graphQLAlbum.B_(), 12, true);
            return true;
        } else if ("media".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLMediaSetMediaConnection = GraphQLMediaSetMediaConnection__JsonHelper.m9073a(FieldAccessQueryTracker.a(jsonParser, "media"));
            }
            graphQLAlbum.q = graphQLMediaSetMediaConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "media", graphQLAlbum.B_(), 13, true);
            return true;
        } else if ("media_owner_object".equals(str)) {
            GraphQLProfile a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "media_owner_object"));
            }
            graphQLAlbum.r = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "media_owner_object", graphQLAlbum.B_(), 14, true);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLAlbum.s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "message", graphQLAlbum.B_(), 15, true);
            return true;
        } else if ("modified_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLAlbum.t = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "modified_time", graphQLAlbum.B_(), 16, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLAlbum.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "name", graphQLAlbum.B_(), 17, false);
            return true;
        } else if ("owner".equals(str)) {
            GraphQLActor a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
            }
            graphQLAlbum.v = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "owner", graphQLAlbum.B_(), 18, true);
            return true;
        } else if ("photo_items".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLMediaSetMediaConnection = GraphQLMediaSetMediaConnection__JsonHelper.m9073a(FieldAccessQueryTracker.a(jsonParser, "photo_items"));
            }
            graphQLAlbum.w = graphQLMediaSetMediaConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "photo_items", graphQLAlbum.B_(), 19, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLAlbum.x = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "privacy_scope", graphQLAlbum.B_(), 20, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLAlbum.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "title", graphQLAlbum.B_(), 22, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLAlbum.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "titleForSummary", graphQLAlbum.B_(), 23, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLAlbum.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "url", graphQLAlbum.B_(), 24, false);
            return true;
        } else if (!"media_list".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLMediaSetMediaConnection = GraphQLMediaSetMediaConnection__JsonHelper.m9073a(FieldAccessQueryTracker.a(jsonParser, "media_list"));
            }
            graphQLAlbum.B = graphQLMediaSetMediaConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLAlbum, "media_list", graphQLAlbum.B_(), 25, true);
            return true;
        }
    }

    public static void m6511a(JsonGenerator jsonGenerator, GraphQLAlbum graphQLAlbum, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAlbum.j() != null) {
            jsonGenerator.a("album_cover_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLAlbum.j(), true);
        }
        if (graphQLAlbum.k() != null) {
            jsonGenerator.a("album_type", graphQLAlbum.k().toString());
        }
        jsonGenerator.a("allow_contributors", graphQLAlbum.l());
        if (graphQLAlbum.m() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLAlbum.m(), true);
        }
        jsonGenerator.a("can_edit_caption", graphQLAlbum.n());
        jsonGenerator.a("can_upload", graphQLAlbum.o());
        jsonGenerator.a("can_viewer_delete", graphQLAlbum.p());
        jsonGenerator.a("contributors");
        if (graphQLAlbum.q() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLAlbum.q()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("created_time", graphQLAlbum.r());
        if (graphQLAlbum.s() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLAlbum.s(), true);
        }
        if (graphQLAlbum.t() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLAlbum.t(), true);
        }
        if (graphQLAlbum.u() != null) {
            jsonGenerator.a("id", graphQLAlbum.u());
        }
        if (graphQLAlbum.v() != null) {
            jsonGenerator.a("implicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLAlbum.v(), true);
        }
        if (graphQLAlbum.w() != null) {
            jsonGenerator.a("media");
            GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, graphQLAlbum.w(), true);
        }
        if (graphQLAlbum.x() != null) {
            jsonGenerator.a("media_owner_object");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLAlbum.x(), true);
        }
        if (graphQLAlbum.y() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAlbum.y(), true);
        }
        jsonGenerator.a("modified_time", graphQLAlbum.z());
        if (graphQLAlbum.A() != null) {
            jsonGenerator.a("name", graphQLAlbum.A());
        }
        if (graphQLAlbum.B() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLAlbum.B(), true);
        }
        if (graphQLAlbum.C() != null) {
            jsonGenerator.a("photo_items");
            GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, graphQLAlbum.C(), true);
        }
        if (graphQLAlbum.D() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLAlbum.D(), true);
        }
        if (graphQLAlbum.E() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAlbum.E(), true);
        }
        if (graphQLAlbum.F() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAlbum.F(), true);
        }
        if (graphQLAlbum.G() != null) {
            jsonGenerator.a("url", graphQLAlbum.G());
        }
        if (graphQLAlbum.H() != null) {
            jsonGenerator.a("media_list");
            GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, graphQLAlbum.H(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
