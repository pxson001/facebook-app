package com.facebook.groups.editsettings.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentParsers.GroupPurposeParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: Unable to parse bridge_args JSON */
public class FetchGroupSettingsParsers {

    /* compiled from: Unable to parse bridge_args JSON */
    public final class FetchGroupSettingsParser {

        /* compiled from: Unable to parse bridge_args JSON */
        public final class CoverPhotoParser {

            /* compiled from: Unable to parse bridge_args JSON */
            public final class PhotoParser {
                public static int m22816a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
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

                public static void m22817a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22818a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("photo")) {
                            iArr[0] = PhotoParser.m22816a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m22819a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m22817a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class GroupConfigsParser {

            /* compiled from: Unable to parse bridge_args JSON */
            public final class NodesParser {
                public static int m22821b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[1];
                    boolean[] zArr2 = new boolean[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("enabled")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, zArr2[0]);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m22820a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    boolean a = mutableFlatBuffer.a(i, 0);
                    if (a) {
                        jsonGenerator.a("enabled");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22822a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(NodesParser.m22821b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m22823a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m22820a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class GroupMembersParser {
            public static int m22824a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m22825a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class GroupPurposesParser {
            public static int m22826a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            iArr[0] = GroupPurposeParser.m22869a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m22827a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    GroupPurposeParser.m22870a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class ParentGroupParser {
            public static int m22828a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("community_category")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLGroupCategory.fromString(jsonParser.o()));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m22829a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("community_category");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class PossibleJoinApprovalSettingsParser {

            /* compiled from: Unable to parse bridge_args JSON */
            public final class EdgesParser {
                public static int m22831b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("display_name")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("node")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLGroupJoinApprovalSetting.fromString(jsonParser.o()));
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

                public static void m22830a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("display_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("node");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22832a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m22831b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m22833a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        EdgesParser.m22830a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class PossiblePostPermissionSettingsParser {

            /* compiled from: Unable to parse bridge_args JSON */
            public final class EdgesParser {
                public static int m22835b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("display_name")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("node")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLGroupPostPermissionSetting.fromString(jsonParser.o()));
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

                public static void m22834a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("display_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("node");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22836a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m22835b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m22837a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        EdgesParser.m22834a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: Unable to parse bridge_args JSON */
        public final class PossibleVisibilitySettingsParser {

            /* compiled from: Unable to parse bridge_args JSON */
            public final class EdgesParser {
                public static int m22839b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("description")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("display_name")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("node")) {
                                iArr[2] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    return flatBufferBuilder.d();
                }

                public static void m22838a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("description");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("display_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("node");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22840a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m22839b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m22841a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m22838a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m22842a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[20];
            boolean[] zArr = new boolean[5];
            boolean[] zArr2 = new boolean[3];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_change_cover_photo")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_change_name")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("cover_photo")) {
                        iArr[2] = CoverPhotoParser.m22818a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("end_of_privacy_grace_period")) {
                        zArr[2] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("group_configs")) {
                        iArr[5] = GroupConfigsParser.m22822a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_members")) {
                        iArr[6] = GroupMembersParser.m22824a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_purposes")) {
                        iArr[7] = GroupPurposesParser.m22826a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("join_approval_setting")) {
                        iArr[9] = flatBufferBuilder.a(GraphQLGroupJoinApprovalSetting.fromString(jsonParser.o()));
                    } else if (i.equals("name")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("parent_group")) {
                        iArr[11] = ParentGroupParser.m22828a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("possible_join_approval_settings")) {
                        iArr[12] = PossibleJoinApprovalSettingsParser.m22832a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("possible_post_permission_settings")) {
                        iArr[13] = PossiblePostPermissionSettingsParser.m22836a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("possible_visibility_settings")) {
                        iArr[14] = PossibleVisibilitySettingsParser.m22840a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("post_permission_setting")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLGroupPostPermissionSetting.fromString(jsonParser.o()));
                    } else if (i.equals("previous_visibility")) {
                        iArr[16] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                    } else if (i.equals("privacy_change_threshold")) {
                        zArr[3] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("requires_post_approval")) {
                        zArr[4] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("visibility")) {
                        iArr[19] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(20);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[2]) {
                flatBufferBuilder.a(4, jArr[0], 0);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            if (zArr[3]) {
                flatBufferBuilder.a(17, iArr2[0], 0);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(18, zArr2[2]);
            }
            flatBufferBuilder.b(19, iArr[19]);
            return flatBufferBuilder.d();
        }

        public static void m22843a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_change_cover_photo");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_change_name");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                CoverPhotoParser.m22819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            long a2 = mutableFlatBuffer.a(i, 4, 0);
            if (a2 != 0) {
                jsonGenerator.a("end_of_privacy_grace_period");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("group_configs");
                GroupConfigsParser.m22823a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("group_members");
                GroupMembersParser.m22825a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("group_purposes");
                GroupPurposesParser.m22827a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("join_approval_setting");
                jsonGenerator.b(mutableFlatBuffer.b(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("parent_group");
                ParentGroupParser.m22829a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("possible_join_approval_settings");
                PossibleJoinApprovalSettingsParser.m22833a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("possible_post_permission_settings");
                PossiblePostPermissionSettingsParser.m22837a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("possible_visibility_settings");
                PossibleVisibilitySettingsParser.m22841a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("post_permission_setting");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("previous_visibility");
                jsonGenerator.b(mutableFlatBuffer.b(i, 16));
            }
            g = mutableFlatBuffer.a(i, 17, 0);
            if (g != 0) {
                jsonGenerator.a("privacy_change_threshold");
                jsonGenerator.b(g);
            }
            a = mutableFlatBuffer.a(i, 18);
            if (a) {
                jsonGenerator.a("requires_post_approval");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("visibility");
                jsonGenerator.b(mutableFlatBuffer.b(i, 19));
            }
            jsonGenerator.g();
        }
    }
}
