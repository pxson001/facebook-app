package com.facebook.groups.groupsections.noncursored.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupFeedParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupItemCoverPhotoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: ZJ */
public class FetchGroupSectionParsers {

    /* compiled from: ZJ */
    public final class FetchGroupSectionParser {

        /* compiled from: ZJ */
        public final class ActorParser {

            /* compiled from: ZJ */
            public final class GroupsParser {

                /* compiled from: ZJ */
                public final class NodesParser {
                    public static int m10722b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[12];
                        boolean[] zArr = new boolean[5];
                        boolean[] zArr2 = new boolean[3];
                        long[] jArr = new long[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("groupItemCoverPhoto")) {
                                    iArr[0] = GroupItemCoverPhotoParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("group_feed")) {
                                    iArr[1] = GroupFeedParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("has_viewer_favorited")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("has_viewer_hidden")) {
                                    zArr[1] = true;
                                    zArr2[1] = jsonParser.H();
                                } else if (i.equals("id")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("is_viewer_newly_added")) {
                                    zArr[2] = true;
                                    zArr2[2] = jsonParser.H();
                                } else if (i.equals("last_activity_time")) {
                                    zArr[3] = true;
                                    jArr[0] = jsonParser.F();
                                } else if (i.equals("name")) {
                                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("viewer_join_state")) {
                                    iArr[8] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                                } else if (i.equals("viewer_last_visited_time")) {
                                    zArr[4] = true;
                                    jArr[1] = jsonParser.F();
                                } else if (i.equals("viewer_leave_scenario")) {
                                    iArr[10] = flatBufferBuilder.a(GraphQLLeavingGroupScenario.fromString(jsonParser.o()));
                                } else if (i.equals("viewer_subscription_level")) {
                                    iArr[11] = flatBufferBuilder.a(GraphQLGroupSubscriptionLevel.fromString(jsonParser.o()));
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(12);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(2, zArr2[0]);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(3, zArr2[1]);
                        }
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(5, zArr2[2]);
                        }
                        if (zArr[3]) {
                            flatBufferBuilder.a(6, jArr[0], 0);
                        }
                        flatBufferBuilder.b(7, iArr[7]);
                        flatBufferBuilder.b(8, iArr[8]);
                        if (zArr[4]) {
                            flatBufferBuilder.a(9, jArr[1], 0);
                        }
                        flatBufferBuilder.b(10, iArr[10]);
                        flatBufferBuilder.b(11, iArr[11]);
                        return flatBufferBuilder.d();
                    }

                    public static void m10723b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("groupItemCoverPhoto");
                            GroupItemCoverPhotoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("group_feed");
                            GroupFeedParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        boolean a = mutableFlatBuffer.a(i, 2);
                        if (a) {
                            jsonGenerator.a("has_viewer_favorited");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 3);
                        if (a) {
                            jsonGenerator.a("has_viewer_hidden");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5);
                        if (a) {
                            jsonGenerator.a("is_viewer_newly_added");
                            jsonGenerator.a(a);
                        }
                        long a2 = mutableFlatBuffer.a(i, 6, 0);
                        if (a2 != 0) {
                            jsonGenerator.a("last_activity_time");
                            jsonGenerator.a(a2);
                        }
                        if (mutableFlatBuffer.g(i, 7) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                        }
                        if (mutableFlatBuffer.g(i, 8) != 0) {
                            jsonGenerator.a("viewer_join_state");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                        }
                        a2 = mutableFlatBuffer.a(i, 9, 0);
                        if (a2 != 0) {
                            jsonGenerator.a("viewer_last_visited_time");
                            jsonGenerator.a(a2);
                        }
                        if (mutableFlatBuffer.g(i, 10) != 0) {
                            jsonGenerator.a("viewer_leave_scenario");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 10));
                        }
                        if (mutableFlatBuffer.g(i, 11) != 0) {
                            jsonGenerator.a("viewer_subscription_level");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 11));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: ZJ */
                public final class PageInfoParser {
                    public static int m10724a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        boolean[] zArr = new boolean[1];
                        boolean[] zArr2 = new boolean[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("end_cursor")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("has_next_page")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, zArr2[0]);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m10725a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                        jsonGenerator.g();
                    }
                }

                public static int m10726a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("nodes")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(NodesParser.m10722b(jsonParser, flatBufferBuilder)));
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
                            } else if (i.equals("page_info")) {
                                iArr[1] = PageInfoParser.m10724a(jsonParser, flatBufferBuilder);
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

                public static void m10727a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            NodesParser.m10723b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("page_info");
                        PageInfoParser.m10725a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m10728a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("groups")) {
                            iArr[1] = GroupsParser.m10726a(jsonParser, flatBufferBuilder);
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

            public static void m10729a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("groups");
                    GroupsParser.m10727a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m10730a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actor")) {
                        iArr[0] = ActorParser.m10728a(jsonParser, flatBufferBuilder);
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
