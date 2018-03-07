package com.facebook.pages.app.data.protocol.methods.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: survey_question */
public class MessageContentSearchParsers {

    /* compiled from: survey_question */
    public final class MessageContentSearchQueryParser {

        /* compiled from: survey_question */
        public final class MessageThreadsParser {

            /* compiled from: survey_question */
            public final class EdgesParser {

                /* compiled from: survey_question */
                public final class MatchedMessagesParser {
                    public static int m1770b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("message_id")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("snippet")) {
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

                    public static void m1769a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("message_id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("snippet");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: survey_question */
                public final class NodeParser {

                    /* compiled from: survey_question */
                    public final class OtherParticipantsParser {

                        /* compiled from: survey_question */
                        public final class OtherParticipantsEdgesParser {

                            /* compiled from: survey_question */
                            public final class OtherParticipantsEdgesNodeParser {

                                /* compiled from: survey_question */
                                public final class MessagingActorParser {
                                    public static int m1771a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[3];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("__type__")) {
                                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
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

                                    public static void m1772a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("__type__");
                                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
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

                                public static int m1773a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("messaging_actor")) {
                                                iArr[0] = MessagingActorParser.m1771a(jsonParser, flatBufferBuilder);
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, iArr[0]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m1774a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    int g = mutableFlatBuffer.g(i, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("messaging_actor");
                                        MessagingActorParser.m1772a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m1775b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = OtherParticipantsEdgesNodeParser.m1773a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m1776b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    OtherParticipantsEdgesNodeParser.m1774a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m1777a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(OtherParticipantsEdgesParser.m1775b(jsonParser, flatBufferBuilder)));
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

                        public static void m1778a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("edges");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    OtherParticipantsEdgesParser.m1776b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: survey_question */
                    public final class ThreadKeyParser {
                        public static int m1779a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("other_user_id")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("thread_fbid")) {
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

                        public static void m1780a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("other_user_id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("thread_fbid");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m1781a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[4];
                        boolean[] zArr = new boolean[1];
                        int[] iArr2 = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("other_participants")) {
                                    iArr[0] = OtherParticipantsParser.m1777a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("thread_key")) {
                                    iArr[1] = ThreadKeyParser.m1779a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("unread_count")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("updated_time_precise")) {
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
                            flatBufferBuilder.a(2, iArr2[0], 0);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        return flatBufferBuilder.d();
                    }

                    public static void m1782a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("other_participants");
                            OtherParticipantsParser.m1778a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("thread_key");
                            ThreadKeyParser.m1780a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.a(i, 2, 0);
                        if (g != 0) {
                            jsonGenerator.a("unread_count");
                            jsonGenerator.b(g);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("updated_time_precise");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m1783b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("matched_messages")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(MatchedMessagesParser.m1770b(jsonParser, flatBufferBuilder)));
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
                            } else if (i.equals("node")) {
                                iArr[1] = NodeParser.m1781a(jsonParser, flatBufferBuilder);
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

                public static void m1784b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("matched_messages");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            MatchedMessagesParser.m1769a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                        }
                        jsonGenerator.e();
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m1782a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m1785a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m1783b(jsonParser, flatBufferBuilder)));
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

            public static void m1786a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m1784b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1787a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("message_threads")) {
                        iArr[0] = MessageThreadsParser.m1785a(jsonParser, flatBufferBuilder);
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
