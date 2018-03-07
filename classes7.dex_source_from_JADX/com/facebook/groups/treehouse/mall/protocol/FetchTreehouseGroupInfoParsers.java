package com.facebook.groups.treehouse.mall.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupPinnedPostParser.GroupPinnedStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupViewerInviteInformationParser.ViewerInviteToGroupParser;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLParsers.GroupPurposesInformationParser.GroupPurposesParser;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLParsers.GroupPurposesInformationParser.SuggestedPurposeParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataParsers.MembersBarDataParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: profile_image_background_height_ratio */
public class FetchTreehouseGroupInfoParsers {

    /* compiled from: profile_image_background_height_ratio */
    public final class FetchTreehouseGroupInfoParser {

        /* compiled from: profile_image_background_height_ratio */
        public final class GroupPendingMembersParser {
            public static int m7538a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m7539a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: profile_image_background_height_ratio */
        public final class GroupPendingStoriesParser {
            public static int m7540a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m7541a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m7542a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[16];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("admin_aware_group")) {
                        iArr[0] = AdminAwareGroupParser.m7484a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_change_cover_photo")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("group_members")) {
                        iArr[2] = MembersBarDataParser.m7846a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_pending_members")) {
                        iArr[3] = GroupPendingMembersParser.m7538a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_pending_stories")) {
                        iArr[4] = GroupPendingStoriesParser.m7540a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_pinned_stories")) {
                        iArr[5] = GroupPinnedStoriesParser.m6471a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_purposes")) {
                        iArr[6] = GroupPurposesParser.m7031a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_sell_config")) {
                        iArr[7] = GroupSellConfigParser.m6174a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("should_show_notif_settings_transition_nux")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("subscribe_status")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLSubscribeStatus.fromString(jsonParser.o()));
                    } else if (i.equals("suggested_purpose")) {
                        iArr[11] = SuggestedPurposeParser.m7033a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_admin_type")) {
                        iArr[12] = flatBufferBuilder.a(GraphQLGroupAdminType.fromString(jsonParser.o()));
                    } else if (i.equals("viewer_invite_to_group")) {
                        iArr[13] = ViewerInviteToGroupParser.m6483a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_join_state")) {
                        iArr[14] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                    } else if (i.equals("viewer_post_status")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLGroupPostStatus.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[1]) {
                flatBufferBuilder.a(9, zArr2[1]);
            }
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            return flatBufferBuilder.d();
        }

        public static void m7543a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("admin_aware_group");
                AdminAwareGroupParser.m7485a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_change_cover_photo");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("group_members");
                MembersBarDataParser.m7847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("group_pending_members");
                GroupPendingMembersParser.m7539a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("group_pending_stories");
                GroupPendingStoriesParser.m7541a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("group_pinned_stories");
                GroupPinnedStoriesParser.m6472a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("group_purposes");
                GroupPurposesParser.m7032a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("group_sell_config");
                GroupSellConfigParser.m6175a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("should_show_notif_settings_transition_nux");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("subscribe_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("suggested_purpose");
                SuggestedPurposeParser.m7034a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("viewer_admin_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("viewer_invite_to_group");
                ViewerInviteToGroupParser.m6484a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("viewer_join_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 14));
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("viewer_post_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            jsonGenerator.g();
        }
    }
}
