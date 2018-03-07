package com.facebook.groups.editsettings.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: Unable to respond to token refresh request */
public class FetchGroupEditSettingsParsers {

    /* compiled from: Unable to respond to token refresh request */
    public final class FBGroupEditSettingsMutationParser {

        /* compiled from: Unable to respond to token refresh request */
        public final class GroupParser {

            /* compiled from: Unable to respond to token refresh request */
            public final class VisibilitySentenceParser {
                public static int m22683a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m22684a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m22685a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[12];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_post")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("description")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("join_approval_setting")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLGroupJoinApprovalSetting.fromString(jsonParser.o()));
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("post_permission_setting")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLGroupPostPermissionSetting.fromString(jsonParser.o()));
                        } else if (i.equals("requires_admin_membership_approval")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("requires_post_approval")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("viewer_join_state")) {
                            iArr[8] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_post_status")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLGroupPostStatus.fromString(jsonParser.o()));
                        } else if (i.equals("visibility")) {
                            iArr[10] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                        } else if (i.equals("visibility_sentence")) {
                            iArr[11] = VisibilitySentenceParser.m22683a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(12);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[1]) {
                    flatBufferBuilder.a(6, zArr2[1]);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(7, zArr2[2]);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                return flatBufferBuilder.d();
            }

            public static void m22686a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_post");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("description");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("join_approval_setting");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("post_permission_setting");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("requires_admin_membership_approval");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("requires_post_approval");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("viewer_post_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 10));
                }
                int g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("visibility_sentence");
                    VisibilitySentenceParser.m22684a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m22687a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("group")) {
                        iArr[0] = GroupParser.m22685a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
