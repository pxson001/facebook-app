package com.facebook.groups.memberrequests.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: TRY_HARDER */
public class FetchMemberRequestsParsers {

    /* compiled from: TRY_HARDER */
    public final class FetchMemberRequestsParser {

        /* compiled from: TRY_HARDER */
        public final class AdminAwareGroupParser {

            /* compiled from: TRY_HARDER */
            public final class CoverPhotoParser {

                /* compiled from: TRY_HARDER */
                public final class PhotoParser {

                    /* compiled from: TRY_HARDER */
                    public final class ImageParser {
                        public static int m24152a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("uri")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, iArr[0]);
                            return flatBufferBuilder.d();
                        }

                        public static void m24153a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m24154a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("image")) {
                                    iArr[0] = ImageParser.m24152a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m24155a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("image");
                            ImageParser.m24153a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m24156a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("photo")) {
                                iArr[0] = PhotoParser.m24154a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m24157a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("photo");
                        PhotoParser.m24155a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: TRY_HARDER */
            public final class GroupPendingMembersParser {

                /* compiled from: TRY_HARDER */
                public final class EdgesParser {

                    /* compiled from: TRY_HARDER */
                    public final class InviterParser {
                        public static int m24158a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("id")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("name")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            return flatBufferBuilder.d();
                        }

                        public static void m24159a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("name");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: TRY_HARDER */
                    public final class NodeParser {

                        /* compiled from: TRY_HARDER */
                        public final class GroupsParser {
                            public static int m24160a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                boolean[] zArr = new boolean[1];
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("open_group_count")) {
                                            zArr[0] = true;
                                            iArr[0] = jsonParser.E();
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(0, iArr[0], 0);
                                }
                                return flatBufferBuilder.d();
                            }

                            public static void m24161a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                int a = mutableFlatBuffer.a(i, 0, 0);
                                if (a != 0) {
                                    jsonGenerator.a("open_group_count");
                                    jsonGenerator.b(a);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: TRY_HARDER */
                        public final class MutualFriendsParser {
                            public static int m24162a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                boolean[] zArr = new boolean[1];
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("count")) {
                                            zArr[0] = true;
                                            iArr[0] = jsonParser.E();
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(0, iArr[0], 0);
                                }
                                return flatBufferBuilder.d();
                            }

                            public static void m24163a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                int a = mutableFlatBuffer.a(i, 0, 0);
                                if (a != 0) {
                                    jsonGenerator.a("count");
                                    jsonGenerator.b(a);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: TRY_HARDER */
                        public final class ProfilePictureParser {
                            public static int m24164a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("uri")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m24165a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("uri");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m24166a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[7];
                            boolean[] zArr = new boolean[1];
                            long[] jArr = new long[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("groups")) {
                                        iArr[0] = GroupsParser.m24160a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("id")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("mutual_friends")) {
                                        iArr[2] = MutualFriendsParser.m24162a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("name")) {
                                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("profile_picture")) {
                                        iArr[4] = ProfilePictureParser.m24164a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("registration_time")) {
                                        zArr[0] = true;
                                        jArr[0] = jsonParser.F();
                                    } else if (i.equals("url")) {
                                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(7);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            flatBufferBuilder.b(3, iArr[3]);
                            flatBufferBuilder.b(4, iArr[4]);
                            if (zArr[0]) {
                                flatBufferBuilder.a(5, jArr[0], 0);
                            }
                            flatBufferBuilder.b(6, iArr[6]);
                            return flatBufferBuilder.d();
                        }

                        public static void m24167a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("groups");
                                GroupsParser.m24161a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            g = mutableFlatBuffer.g(i, 2);
                            if (g != 0) {
                                jsonGenerator.a("mutual_friends");
                                MutualFriendsParser.m24163a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("name");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                            }
                            g = mutableFlatBuffer.g(i, 4);
                            if (g != 0) {
                                jsonGenerator.a("profile_picture");
                                ProfilePictureParser.m24165a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            long a = mutableFlatBuffer.a(i, 5, 0);
                            if (a != 0) {
                                jsonGenerator.a("registration_time");
                                jsonGenerator.a(a);
                            }
                            if (mutableFlatBuffer.g(i, 6) != 0) {
                                jsonGenerator.a("url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m24168b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[4];
                        boolean[] zArr = new boolean[2];
                        int[] iArr2 = new int[1];
                        long[] jArr = new long[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("group_friend_count")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("inviter")) {
                                    iArr[1] = InviterParser.m24158a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("node")) {
                                    iArr[2] = NodeParser.m24166a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("request_time")) {
                                    zArr[1] = true;
                                    jArr[0] = jsonParser.F();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(4);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, iArr2[0], 0);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        flatBufferBuilder.b(2, iArr[2]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(3, jArr[0], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m24169b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("group_friend_count");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.g(i, 1);
                        if (a != 0) {
                            jsonGenerator.a("inviter");
                            InviterParser.m24159a(mutableFlatBuffer, a, jsonGenerator);
                        }
                        a = mutableFlatBuffer.g(i, 2);
                        if (a != 0) {
                            jsonGenerator.a("node");
                            NodeParser.m24167a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                        }
                        long a2 = mutableFlatBuffer.a(i, 3, 0);
                        if (a2 != 0) {
                            jsonGenerator.a("request_time");
                            jsonGenerator.a(a2);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: TRY_HARDER */
                public final class PageInfoParser {
                    public static int m24170a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[4];
                        boolean[] zArr = new boolean[2];
                        boolean[] zArr2 = new boolean[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("end_cursor")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("has_next_page")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("has_previous_page")) {
                                    zArr[1] = true;
                                    zArr2[1] = jsonParser.H();
                                } else if (i.equals("start_cursor")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, zArr2[0]);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, zArr2[1]);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        return flatBufferBuilder.d();
                    }

                    public static void m24171a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("end_cursor");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        boolean a = mutableFlatBuffer.a(i, 1);
                        if (a) {
                            jsonGenerator.a("has_next_page");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 2);
                        if (a) {
                            jsonGenerator.a("has_previous_page");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("start_cursor");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m24172a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    boolean[] zArr = new boolean[1];
                    int[] iArr2 = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("count")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("edges")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(EdgesParser.m24168b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr3 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr3, true);
                                }
                                iArr[1] = i2;
                            } else if (i.equals("page_info")) {
                                iArr[2] = PageInfoParser.m24170a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(3);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    return flatBufferBuilder.d();
                }

                public static void m24173a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.g(i, 1);
                    if (a != 0) {
                        jsonGenerator.a("edges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                            EdgesParser.m24169b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    a = mutableFlatBuffer.g(i, 2);
                    if (a != 0) {
                        jsonGenerator.a("page_info");
                        PageInfoParser.m24171a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: TRY_HARDER */
            public final class VisibilitySentenceParser {
                public static int m24174a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("text")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m24175a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m24176a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cover_photo")) {
                            iArr[0] = CoverPhotoParser.m24156a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_pending_members")) {
                            iArr[1] = GroupPendingMembersParser.m24172a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_admin_type")) {
                            iArr[4] = flatBufferBuilder.a(GraphQLGroupAdminType.fromString(jsonParser.o()));
                        } else if (i.equals("visibility_sentence")) {
                            iArr[5] = VisibilitySentenceParser.m24174a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                return flatBufferBuilder.d();
            }

            public static void m24177a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m24157a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("group_pending_members");
                    GroupPendingMembersParser.m24173a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("viewer_admin_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("visibility_sentence");
                    VisibilitySentenceParser.m24175a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m24178a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("admin_aware_group")) {
                        iArr[0] = AdminAwareGroupParser.m24176a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
