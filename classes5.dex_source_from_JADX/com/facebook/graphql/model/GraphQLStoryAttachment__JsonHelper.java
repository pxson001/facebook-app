package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unable to retrieve Sensor power stats */
public final class GraphQLStoryAttachment__JsonHelper {
    public static GraphQLStoryAttachment m21862a(JsonParser jsonParser) {
        GraphQLStoryAttachment graphQLStoryAttachment = new GraphQLStoryAttachment();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21864a(graphQLStoryAttachment, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStoryAttachment;
    }

    private static boolean m21864a(GraphQLStoryAttachment graphQLStoryAttachment, String str, JsonParser jsonParser) {
        String str2 = null;
        Collection arrayList;
        List copyOf;
        if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
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
            graphQLStoryAttachment.d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "action_links", graphQLStoryAttachment.a_, 0, true);
            return true;
        } else if ("associated_application".equals(str)) {
            GraphQLAppStoreApplication a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLAppStoreApplication__JsonHelper.m6574a(FieldAccessQueryTracker.a(jsonParser, "associated_application"));
            }
            graphQLStoryAttachment.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "associated_application", graphQLStoryAttachment.B_(), 1, true);
            return true;
        } else if ("attachment_properties".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLAttachmentProperty a3 = GraphQLAttachmentProperty__JsonHelper.m6609a(FieldAccessQueryTracker.a(jsonParser, "attachment_properties"));
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
            graphQLStoryAttachment.f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "attachment_properties", graphQLStoryAttachment.B_(), 2, true);
            return true;
        } else if ("deduplication_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "deduplication_key", graphQLStoryAttachment.B_(), 3, false);
            return true;
        } else if ("description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
            }
            graphQLStoryAttachment.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "description", graphQLStoryAttachment.B_(), 4, true);
            return true;
        } else if ("genie_message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "genie_message"));
            }
            graphQLStoryAttachment.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "genie_message", graphQLStoryAttachment.B_(), 5, true);
            return true;
        } else if ("is_album_attachment".equals(str)) {
            graphQLStoryAttachment.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "is_album_attachment", graphQLStoryAttachment.B_(), 6, false);
            return true;
        } else if ("is_media_local".equals(str)) {
            graphQLStoryAttachment.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "is_media_local", graphQLStoryAttachment.B_(), 7, false);
            return true;
        } else if ("media".equals(str)) {
            GraphQLMedia a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLMedia__JsonHelper.m9078a(FieldAccessQueryTracker.a(jsonParser, "media"));
            }
            graphQLStoryAttachment.l = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "media", graphQLStoryAttachment.B_(), 8, true);
            return true;
        } else if ("media_owner_object_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "media_owner_object_id", graphQLStoryAttachment.B_(), 9, false);
            return true;
        } else if ("media_reference_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "media_reference_token", graphQLStoryAttachment.B_(), 10, false);
            return true;
        } else if ("source".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "source"));
            }
            graphQLStoryAttachment.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "source", graphQLStoryAttachment.B_(), 11, true);
            return true;
        } else if ("style_infos".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryAttachmentStyleInfo a5 = GraphQLStoryAttachmentStyleInfo__JsonHelper.m21859a(FieldAccessQueryTracker.a(jsonParser, "style_infos"));
                    if (a5 != null) {
                        arrayList.add(a5);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLStoryAttachment.p = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "style_infos", graphQLStoryAttachment.B_(), 12, true);
            return true;
        } else if ("style_list".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryAttachmentStyle fromString = GraphQLStoryAttachmentStyle.fromString(jsonParser.o());
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLStoryAttachment.q = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "style_list", graphQLStoryAttachment.B_(), 13, false);
            return true;
        } else if ("subattachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryAttachment a6 = m21862a(FieldAccessQueryTracker.a(jsonParser, "subattachments"));
                    if (a6 != null) {
                        arrayList.add(a6);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLStoryAttachment.r = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "subattachments", graphQLStoryAttachment.B_(), 14, true);
            return true;
        } else if ("subtitle".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "subtitle", graphQLStoryAttachment.B_(), 15, false);
            return true;
        } else if ("target".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "target"));
            }
            graphQLStoryAttachment.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "target", graphQLStoryAttachment.B_(), 16, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.u = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "title", graphQLStoryAttachment.B_(), 17, false);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "tracking", graphQLStoryAttachment.B_(), 18, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachment.w = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachment, "url", graphQLStoryAttachment.B_(), 19, false);
            return true;
        }
    }

    public static void m21863a(JsonGenerator jsonGenerator, GraphQLStoryAttachment graphQLStoryAttachment, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("action_links");
        if (graphQLStoryAttachment.j() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLStoryAttachment.j()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryAttachment.k() != null) {
            jsonGenerator.a("associated_application");
            GraphQLAppStoreApplication__JsonHelper.m6575a(jsonGenerator, graphQLStoryAttachment.k(), true);
        }
        jsonGenerator.a("attachment_properties");
        if (graphQLStoryAttachment.l() != null) {
            jsonGenerator.d();
            for (GraphQLAttachmentProperty graphQLAttachmentProperty : graphQLStoryAttachment.l()) {
                if (graphQLAttachmentProperty != null) {
                    GraphQLAttachmentProperty__JsonHelper.m6610a(jsonGenerator, graphQLAttachmentProperty, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryAttachment.m() != null) {
            jsonGenerator.a("deduplication_key", graphQLStoryAttachment.m());
        }
        if (graphQLStoryAttachment.n() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryAttachment.n(), true);
        }
        if (graphQLStoryAttachment.o() != null) {
            jsonGenerator.a("genie_message");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLStoryAttachment.o(), true);
        }
        jsonGenerator.a("is_album_attachment", graphQLStoryAttachment.p());
        jsonGenerator.a("is_media_local", graphQLStoryAttachment.q());
        if (graphQLStoryAttachment.r() != null) {
            jsonGenerator.a("media");
            GraphQLMedia__JsonHelper.m9079a(jsonGenerator, graphQLStoryAttachment.r(), true);
        }
        if (graphQLStoryAttachment.s() != null) {
            jsonGenerator.a("media_owner_object_id", graphQLStoryAttachment.s());
        }
        if (graphQLStoryAttachment.t() != null) {
            jsonGenerator.a("media_reference_token", graphQLStoryAttachment.t());
        }
        if (graphQLStoryAttachment.u() != null) {
            jsonGenerator.a("source");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryAttachment.u(), true);
        }
        jsonGenerator.a("style_infos");
        if (graphQLStoryAttachment.v() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo : graphQLStoryAttachment.v()) {
                if (graphQLStoryAttachmentStyleInfo != null) {
                    GraphQLStoryAttachmentStyleInfo__JsonHelper.m21860a(jsonGenerator, graphQLStoryAttachmentStyleInfo, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("style_list");
        if (graphQLStoryAttachment.w() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle : graphQLStoryAttachment.w()) {
                if (graphQLStoryAttachmentStyle != null) {
                    jsonGenerator.b(graphQLStoryAttachmentStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("subattachments");
        if (graphQLStoryAttachment.x() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLStoryAttachment.x()) {
                if (graphQLStoryAttachment2 != null) {
                    m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryAttachment.y() != null) {
            jsonGenerator.a("subtitle", graphQLStoryAttachment.y());
        }
        if (graphQLStoryAttachment.z() != null) {
            jsonGenerator.a("target");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLStoryAttachment.z(), true);
        }
        if (graphQLStoryAttachment.A() != null) {
            jsonGenerator.a("title", graphQLStoryAttachment.A());
        }
        if (graphQLStoryAttachment.B() != null) {
            jsonGenerator.a("tracking", graphQLStoryAttachment.B());
        }
        if (graphQLStoryAttachment.C() != null) {
            jsonGenerator.a("url", graphQLStoryAttachment.C());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
