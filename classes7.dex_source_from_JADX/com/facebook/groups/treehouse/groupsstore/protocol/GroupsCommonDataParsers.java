package com.facebook.groups.treehouse.groupsstore.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupFeedParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupItemCoverPhotoParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSettingsRowDataParser.SettingsRowCoverPhotoParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser.PossiblePushSubscriptionLevelsParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser.PossibleSubscriptionLevelsParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.PendingMembersParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.PendingStoriesParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.ReportedStoriesParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseMembersParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseheaderCoverPhotoParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.VisibilitySentenceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: profile_overlay_category */
public class GroupsCommonDataParsers {

    /* compiled from: profile_overlay_category */
    public final class GroupCacheDeltaSyncParser {

        /* compiled from: profile_overlay_category */
        public final class ActorParser {

            /* compiled from: profile_overlay_category */
            public final class GroupsParser {

                /* compiled from: profile_overlay_category */
                public final class DeltasParser {

                    /* compiled from: profile_overlay_category */
                    public final class NodesParser {

                        /* compiled from: profile_overlay_category */
                        public final class AddedEdgeParser {
                            public static int m7443a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = GroupCommonDataParser.m7486a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m7444a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    GroupCommonDataParser.m7487b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: profile_overlay_category */
                        public final class ModifiedEdgeParser {
                            public static int m7445a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = GroupCommonDataParser.m7486a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m7446a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    GroupCommonDataParser.m7487b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m7447b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[4];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("added_edge")) {
                                        iArr[0] = AddedEdgeParser.m7443a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("modified_edge")) {
                                        iArr[1] = ModifiedEdgeParser.m7445a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("removed")) {
                                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("unchanged")) {
                                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(4);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            flatBufferBuilder.b(3, iArr[3]);
                            return flatBufferBuilder.d();
                        }

                        public static void m7448b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("added_edge");
                                AddedEdgeParser.m7444a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("modified_edge");
                                ModifiedEdgeParser.m7446a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 2) != 0) {
                                jsonGenerator.a("removed");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("unchanged");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m7449a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                            arrayList.add(Integer.valueOf(NodesParser.m7447b(jsonParser, flatBufferBuilder)));
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

                    public static void m7450a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("nodes");
                            jsonGenerator.d();
                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                NodesParser.m7448b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                            }
                            jsonGenerator.e();
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: profile_overlay_category */
                public final class PageInfoParser {
                    public static int m7451a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("delta_cursor")) {
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

                    public static void m7452a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("delta_cursor");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m7453a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            } else if (i.equals("deltas")) {
                                iArr[1] = DeltasParser.m7449a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_info")) {
                                iArr[2] = PageInfoParser.m7451a(jsonParser, flatBufferBuilder);
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

                public static void m7454a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.g(i, 1);
                    if (a != 0) {
                        jsonGenerator.a("deltas");
                        DeltasParser.m7450a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                    }
                    a = mutableFlatBuffer.g(i, 2);
                    if (a != 0) {
                        jsonGenerator.a("page_info");
                        PageInfoParser.m7452a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7455a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("groups")) {
                            iArr[1] = GroupsParser.m7453a(jsonParser, flatBufferBuilder);
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

            public static void m7456a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("groups");
                    GroupsParser.m7454a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7457a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actor")) {
                        iArr[0] = ActorParser.m7455a(jsonParser, flatBufferBuilder);
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

    /* compiled from: profile_overlay_category */
    public final class GroupCacheInitialSyncParser {

        /* compiled from: profile_overlay_category */
        public final class ActorParser {

            /* compiled from: profile_overlay_category */
            public final class GroupsParser {
                public static int m7458a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            } else if (i.equals("nodes")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(GroupCommonDataParser.m7486a(jsonParser, flatBufferBuilder)));
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
                                iArr[2] = GroupCommonDataPageInfoParser.m7472a(jsonParser, flatBufferBuilder);
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

                public static void m7459a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.g(i, 1);
                    if (a != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                            GroupCommonDataParser.m7487b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    a = mutableFlatBuffer.g(i, 2);
                    if (a != 0) {
                        jsonGenerator.a("page_info");
                        GroupCommonDataPageInfoParser.m7473a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7460a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("groups")) {
                            iArr[1] = GroupsParser.m7458a(jsonParser, flatBufferBuilder);
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

            public static void m7461a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("groups");
                    GroupsParser.m7459a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7462a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actor")) {
                        iArr[0] = ActorParser.m7460a(jsonParser, flatBufferBuilder);
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

    /* compiled from: profile_overlay_category */
    public final class GroupCacheUnseenSyncParser {

        /* compiled from: profile_overlay_category */
        public final class ActorParser {

            /* compiled from: profile_overlay_category */
            public final class GroupsParser {

                /* compiled from: profile_overlay_category */
                public final class NodesParser {

                    /* compiled from: profile_overlay_category */
                    public final class GroupFeedParser {
                        public static int m7463a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            boolean[] zArr = new boolean[1];
                            int[] iArr = new int[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("unseen_count")) {
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

                        public static void m7464a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            int a = mutableFlatBuffer.a(i, 0, 0);
                            if (a != 0) {
                                jsonGenerator.a("unseen_count");
                                jsonGenerator.b(a);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m7465b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("group_feed")) {
                                    iArr[0] = GroupFeedParser.m7463a(jsonParser, flatBufferBuilder);
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

                    public static void m7466b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("group_feed");
                            GroupFeedParser.m7464a(mutableFlatBuffer, g, jsonGenerator);
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

                public static int m7467a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(NodesParser.m7465b(jsonParser, flatBufferBuilder)));
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

                public static void m7468a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            NodesParser.m7466b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7469a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("groups")) {
                            iArr[1] = GroupsParser.m7467a(jsonParser, flatBufferBuilder);
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

            public static void m7470a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("groups");
                    GroupsParser.m7468a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7471a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actor")) {
                        iArr[0] = ActorParser.m7469a(jsonParser, flatBufferBuilder);
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

    /* compiled from: profile_overlay_category */
    public final class GroupCommonDataPageInfoParser {
        public static int m7472a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("delta_cursor")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("end_cursor")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("has_next_page")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("start_cursor")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static void m7473a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("delta_cursor");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("end_cursor");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("has_next_page");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("start_cursor");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: profile_overlay_category */
    public final class GroupCommonDataParser {

        /* compiled from: profile_overlay_category */
        public final class AdminAwareGroupParser {

            /* compiled from: profile_overlay_category */
            public final class LastViewTimeParser {
                public static int m7474a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[1];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("last_view_time")) {
                                zArr[0] = true;
                                jArr[0] = jsonParser.F();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, jArr[0], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m7475a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    long a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("last_view_time");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: profile_overlay_category */
            public final class ParentGroupParser {
                public static int m7476a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("name")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
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

                public static void m7477a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: profile_overlay_category */
            public final class PhotoForLauncherShortcutParser {

                /* compiled from: profile_overlay_category */
                public final class PhotoParser {

                    /* compiled from: profile_overlay_category */
                    public final class ImageParser {
                        public static int m7478a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m7479a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m7480a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("image")) {
                                    iArr[1] = ImageParser.m7478a(jsonParser, flatBufferBuilder);
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

                    public static void m7481a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("image");
                            ImageParser.m7479a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m7482a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("photo")) {
                                iArr[0] = PhotoParser.m7480a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m7483a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("photo");
                        PhotoParser.m7481a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7484a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[33];
                boolean[] zArr = new boolean[5];
                boolean[] zArr2 = new boolean[3];
                long[] jArr = new long[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("delta_hash")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("description")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("groupItemCoverPhoto")) {
                            iArr[2] = GroupItemCoverPhotoParser.m7601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("groupPurposeFirst")) {
                            iArr[3] = GroupPurposeFirstParser.m7492a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_feed")) {
                            iArr[4] = GroupFeedParser.m7595a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("has_viewer_favorited")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("has_viewer_hidden")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("is_viewer_newly_added")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("lastViewTime")) {
                            iArr[9] = LastViewTimeParser.m7474a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("last_activity_time")) {
                            zArr[3] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("name")) {
                            iArr[11] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("parent_group")) {
                            iArr[12] = ParentGroupParser.m7476a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("pendingMembers")) {
                            iArr[13] = PendingMembersParser.m7769a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("pendingStories")) {
                            iArr[14] = PendingStoriesParser.m7771a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photoForLauncherShortcut")) {
                            iArr[15] = PhotoForLauncherShortcutParser.m7482a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("possible_push_subscription_levels")) {
                            iArr[16] = PossiblePushSubscriptionLevelsParser.m7691a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("possible_subscription_levels")) {
                            iArr[17] = PossibleSubscriptionLevelsParser.m7695a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("reportedStories")) {
                            iArr[18] = ReportedStoriesParser.m7773a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("settingsRowCoverPhoto")) {
                            iArr[19] = SettingsRowCoverPhotoParser.m7685a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("treehouseMembers")) {
                            iArr[20] = TreehouseMembersParser.m7775a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("treehouseheaderCoverPhoto")) {
                            iArr[21] = TreehouseheaderCoverPhotoParser.m7781a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
                            iArr[22] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_admin_type")) {
                            iArr[23] = flatBufferBuilder.a(GraphQLGroupAdminType.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_join_state")) {
                            iArr[24] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_last_visited_time")) {
                            zArr[4] = true;
                            jArr[1] = jsonParser.F();
                        } else if (i.equals("viewer_leave_scenario")) {
                            iArr[26] = flatBufferBuilder.a(GraphQLLeavingGroupScenario.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_post_status")) {
                            iArr[27] = flatBufferBuilder.a(GraphQLGroupPostStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_push_subscription_level")) {
                            iArr[28] = flatBufferBuilder.a(GraphQLGroupPushSubscriptionLevel.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_request_to_join_subscription_level")) {
                            iArr[29] = flatBufferBuilder.a(GraphQLGroupRequestToJoinSubscriptionLevel.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_subscription_level")) {
                            iArr[30] = flatBufferBuilder.a(GraphQLGroupSubscriptionLevel.fromString(jsonParser.o()));
                        } else if (i.equals("visibility")) {
                            iArr[31] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                        } else if (i.equals("visibility_sentence")) {
                            iArr[32] = VisibilitySentenceParser.m7783a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(33);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                if (zArr[0]) {
                    flatBufferBuilder.a(5, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(6, zArr2[1]);
                }
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[2]) {
                    flatBufferBuilder.a(8, zArr2[2]);
                }
                flatBufferBuilder.b(9, iArr[9]);
                if (zArr[3]) {
                    flatBufferBuilder.a(10, jArr[0], 0);
                }
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                flatBufferBuilder.b(13, iArr[13]);
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                flatBufferBuilder.b(24, iArr[24]);
                if (zArr[4]) {
                    flatBufferBuilder.a(25, jArr[1], 0);
                }
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                flatBufferBuilder.b(28, iArr[28]);
                flatBufferBuilder.b(29, iArr[29]);
                flatBufferBuilder.b(30, iArr[30]);
                flatBufferBuilder.b(31, iArr[31]);
                flatBufferBuilder.b(32, iArr[32]);
                return flatBufferBuilder.d();
            }

            public static void m7485a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("delta_hash");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("description");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("groupItemCoverPhoto");
                    GroupItemCoverPhotoParser.m7602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("groupPurposeFirst");
                    GroupPurposeFirstParser.m7493a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("group_feed");
                    GroupFeedParser.m7596a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 5);
                if (a) {
                    jsonGenerator.a("has_viewer_favorited");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("has_viewer_hidden");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                a = mutableFlatBuffer.a(i, 8);
                if (a) {
                    jsonGenerator.a("is_viewer_newly_added");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("lastViewTime");
                    LastViewTimeParser.m7475a(mutableFlatBuffer, g, jsonGenerator);
                }
                long a2 = mutableFlatBuffer.a(i, 10, 0);
                if (a2 != 0) {
                    jsonGenerator.a("last_activity_time");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("parent_group");
                    ParentGroupParser.m7477a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("pendingMembers");
                    PendingMembersParser.m7770a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("pendingStories");
                    PendingStoriesParser.m7772a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("photoForLauncherShortcut");
                    PhotoForLauncherShortcutParser.m7483a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("possible_push_subscription_levels");
                    PossiblePushSubscriptionLevelsParser.m7692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("possible_subscription_levels");
                    PossibleSubscriptionLevelsParser.m7696a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("reportedStories");
                    ReportedStoriesParser.m7774a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("settingsRowCoverPhoto");
                    SettingsRowCoverPhotoParser.m7686a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 20);
                if (g != 0) {
                    jsonGenerator.a("treehouseMembers");
                    TreehouseMembersParser.m7776a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("treehouseheaderCoverPhoto");
                    TreehouseheaderCoverPhotoParser.m7782a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                }
                if (mutableFlatBuffer.g(i, 23) != 0) {
                    jsonGenerator.a("viewer_admin_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 23));
                }
                if (mutableFlatBuffer.g(i, 24) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 24));
                }
                a2 = mutableFlatBuffer.a(i, 25, 0);
                if (a2 != 0) {
                    jsonGenerator.a("viewer_last_visited_time");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 26) != 0) {
                    jsonGenerator.a("viewer_leave_scenario");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 26));
                }
                if (mutableFlatBuffer.g(i, 27) != 0) {
                    jsonGenerator.a("viewer_post_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 27));
                }
                if (mutableFlatBuffer.g(i, 28) != 0) {
                    jsonGenerator.a("viewer_push_subscription_level");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 28));
                }
                if (mutableFlatBuffer.g(i, 29) != 0) {
                    jsonGenerator.a("viewer_request_to_join_subscription_level");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 29));
                }
                if (mutableFlatBuffer.g(i, 30) != 0) {
                    jsonGenerator.a("viewer_subscription_level");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 30));
                }
                if (mutableFlatBuffer.g(i, 31) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 31));
                }
                g = mutableFlatBuffer.g(i, 32);
                if (g != 0) {
                    jsonGenerator.a("visibility_sentence");
                    VisibilitySentenceParser.m7784a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m7486a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("admin_aware_group")) {
                        iArr[0] = AdminAwareGroupParser.m7484a(jsonParser, flatBufferBuilder);
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
            return flatBufferBuilder.d();
        }

        public static void m7487b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("admin_aware_group");
                AdminAwareGroupParser.m7485a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: profile_overlay_category */
    public final class GroupPurposesFragmentParser {

        /* compiled from: profile_overlay_category */
        public final class GroupPurposeFirstParser {

            /* compiled from: profile_overlay_category */
            public final class EdgesParser {

                /* compiled from: profile_overlay_category */
                public final class NodeParser {
                    public static int m7488a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("purpose_enum")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLGroupPurposeType.fromString(jsonParser.o()));
                                } else if (i.equals("purpose_name")) {
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

                    public static void m7489a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("purpose_enum");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("purpose_name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m7490b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m7488a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m7491b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m7489a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7492a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m7490b(jsonParser, flatBufferBuilder)));
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

            public static void m7493a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        EdgesParser.m7491b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7494a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("groupPurposeFirst")) {
                        iArr[0] = GroupPurposeFirstParser.m7492a(jsonParser, flatBufferBuilder);
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
