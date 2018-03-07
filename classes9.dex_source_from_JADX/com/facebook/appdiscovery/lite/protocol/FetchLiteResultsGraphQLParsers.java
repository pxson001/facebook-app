package com.facebook.appdiscovery.lite.protocol;

import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStoreApplicationFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.ActorFacePileFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.AppStoreAppFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.UserFacePileFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLMoreAppsUnitRenderStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: sendChannel */
public class FetchLiteResultsGraphQLParsers {

    /* compiled from: sendChannel */
    public final class AppDiscoveryLiteQueryFragmentParser {

        /* compiled from: sendChannel */
        public final class AppDiscoveryLiteParser {
            public static int m4155a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(AppSectionQueryFragmentParser.m4163b(jsonParser, flatBufferBuilder)));
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

            public static void m4156a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        AppSectionQueryFragmentParser.m4164b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m4157a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("app_discovery_lite")) {
                        iArr[0] = AppDiscoveryLiteParser.m4155a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m4158a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("app_discovery_lite");
                AppDiscoveryLiteParser.m4156a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: sendChannel */
    public final class AppSectionQueryFragmentParser {

        /* compiled from: sendChannel */
        public final class AppSectionUnitsParser {

            /* compiled from: sendChannel */
            public final class NodesParser {
                public static int m4159b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[9];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("actors")) {
                                iArr[1] = ActorFacePileFragmentParser.m4009a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("app_section_actor")) {
                                iArr[2] = UserFacePileFragmentParser.m4044a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("app_section_message")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("app_section_time_created")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("app_store_application")) {
                                iArr[5] = AppStoreAppFragmentParser.m4017a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("attachments")) {
                                iArr[6] = AttachmentsParser.m4169a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("cache_id")) {
                                iArr[7] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("message")) {
                                iArr[8] = MessageParser.m4173a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    flatBufferBuilder.b(7, iArr[7]);
                    flatBufferBuilder.b(8, iArr[8]);
                    return flatBufferBuilder.d();
                }

                public static void m4160b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("actors");
                        ActorFacePileFragmentParser.m4010a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("app_section_actor");
                        UserFacePileFragmentParser.m4047b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("app_section_message");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("app_section_time_created");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    g = mutableFlatBuffer.g(i, 5);
                    if (g != 0) {
                        jsonGenerator.a("app_store_application");
                        AppStoreAppFragmentParser.m4018a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("attachments");
                        AttachmentsParser.m4170a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 7) != 0) {
                        jsonGenerator.a("cache_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("message");
                        MessageParser.m4174a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m4161a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m4159b(jsonParser, flatBufferBuilder)));
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

            public static void m4162a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m4160b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m4163b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("app_section_name")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("app_section_render_style")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLMoreAppsUnitRenderStyle.fromString(jsonParser.o()));
                    } else if (i.equals("app_section_units")) {
                        iArr[2] = AppSectionUnitsParser.m4161a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
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

        public static void m4164b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("app_section_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("app_section_render_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("app_section_units");
                AppSectionUnitsParser.m4162a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: sendChannel */
    public final class AppStoryQueryFragmentParser {

        /* compiled from: sendChannel */
        public final class AttachmentsParser {

            /* compiled from: sendChannel */
            public final class ActionLinksParser {
                public static int m4166b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("destination_type")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o()));
                            } else if (i.equals("link_title")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("link_type")) {
                                iArr[3] = flatBufferBuilder.a(GraphQLCallToActionType.fromString(jsonParser.o()));
                            } else if (i.equals("title")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
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

                public static void m4165a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("destination_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("link_title");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("link_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("title");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: sendChannel */
            public final class DescriptionParser {
                public static int m4167a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m4168a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m4171b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action_links")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ActionLinksParser.m4166b(jsonParser, flatBufferBuilder)));
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
                        } else if (i.equals("associated_application")) {
                            iArr[1] = AppStoreApplicationFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("description")) {
                            iArr[2] = DescriptionParser.m4167a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media")) {
                            iArr[3] = FBGenericAttachmentMediaQueryFragmentParser.m4178a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("style_list")) {
                            iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                return flatBufferBuilder.d();
            }

            public static int m4169a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m4171b(jsonParser, flatBufferBuilder)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return 0;
                }
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                return flatBufferBuilder.a(iArr, true);
            }

            public static void m4170a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m4172b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m4172b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action_links");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ActionLinksParser.m4165a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("associated_application");
                    AppStoreApplicationFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DescriptionParser.m4168a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("media");
                    FBGenericAttachmentMediaQueryFragmentParser.m4179a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: sendChannel */
        public final class MessageParser {
            public static int m4173a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m4174a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m4175a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actors")) {
                        iArr[0] = ActorFacePileFragmentParser.m4009a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attachments")) {
                        iArr[1] = AttachmentsParser.m4169a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cache_id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message")) {
                        iArr[3] = MessageParser.m4173a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: sendChannel */
    public final class FBGenericAttachmentMediaQueryFragmentParser {

        /* compiled from: sendChannel */
        public final class AnimatedImageParser {
            public static int m4176a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m4177a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m4178a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("animated_image")) {
                        iArr[1] = AnimatedImageParser.m4176a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLargeSquare")) {
                        iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageSmallCover")) {
                        iArr[3] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageSmallSquare")) {
                        iArr[4] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageTallCover")) {
                        iArr[5] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_playable")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("playable_duration")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(7, iArr2[0], 0);
            }
            flatBufferBuilder.b(8, iArr[8]);
            return flatBufferBuilder.d();
        }

        public static void m4179a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("animated_image");
                AnimatedImageParser.m4177a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("imageLargeSquare");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("imageSmallCover");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("imageSmallSquare");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("imageTallCover");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 7, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: sendChannel */
    public final class FetchLiteResultsQueryParser {
        public static MutableFlatBuffer m4180a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("actor")) {
                        iArr[0] = AppDiscoveryLiteQueryFragmentParser.m4157a(jsonParser, flatBufferBuilder);
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
