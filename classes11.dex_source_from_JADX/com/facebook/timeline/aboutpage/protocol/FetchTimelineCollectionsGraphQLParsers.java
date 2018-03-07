package com.facebook.timeline.aboutpage.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.strictmode.ActivityManagerProxifier.ActivityManagerNativeClass;
import com.facebook.strictmode.ActivityManagerProxifier.IActivityManagerClass;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsAppSectionParser.SubtitleParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsAppSectionParser.TitleParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLParsers.CollectionWithItemsAndSuggestionsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* compiled from: MOCK */
public class FetchTimelineCollectionsGraphQLParsers {

    /* compiled from: MOCK */
    public final class FetchTimelineCollectionsSectionViewQueryParser {

        /* compiled from: MOCK */
        public final class CollectionsParser {
            public static int m14737a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            iArr[1] = CollectionWithItemsAndSuggestionsParser.m14689a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_info")) {
                            iArr[2] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m14738a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("nodes");
                    CollectionWithItemsAndSuggestionsParser.m14690a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m14739a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("collections")) {
                        iArr[0] = CollectionsParser.m14737a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("section_type")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLTimelineAppSectionType.fromString(jsonParser.o()));
                    } else if (i.equals("standalone_url")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subtitle")) {
                        iArr[6] = SubtitleParser.m14466a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[7] = TitleParser.m14468a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tracking")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }

        public static void m14740a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("collections");
                CollectionsParser.m14738a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
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
                jsonGenerator.a("section_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("standalone_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                SubtitleParser.m14467a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("title");
                TitleParser.m14469a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: MOCK */
    public final class FetchTimelineSingleCollectionViewQueryParser {

        /* compiled from: MOCK */
        public final class CollectionsParser {
            public static int m14741a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            iArr[0] = CollectionWithItemsAndSuggestionsParser.m14689a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m14742a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    CollectionWithItemsAndSuggestionsParser.m14690a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static Class<?> m14747b() {
            return Class.forName("android.app.ActivityManagerNative");
        }

        public static Object m14744a(Object obj) {
            ActivityManagerNativeClass.m13699a();
            Class b = m14747b();
            Class b2 = IActivityManagerClass.m13700b();
            Field declaredField = b.getDeclaredField("gDefault");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            b = obj2.getClass();
            if (b2.isAssignableFrom(b)) {
                Object obj3 = declaredField.get(null);
                declaredField.set(null, obj);
                return obj3;
            }
            b = b.getSuperclass();
            if (!b.getName().equals("android.util.Singleton")) {
                return null;
            }
            Field declaredField2 = b.getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            obj3 = declaredField2.get(obj2);
            declaredField2.set(obj2, obj);
            return obj3;
        }

        public static void m14745a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            jsonGenerator.g();
        }

        public static MutableFlatBuffer m14743a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("collections")) {
                        iArr[0] = CollectionsParser.m14741a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("section_type")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLTimelineAppSectionType.fromString(jsonParser.o()));
                    } else if (i.equals("standalone_url")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subtitle")) {
                        iArr[6] = SubtitleParser.m14466a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[7] = TitleParser.m14468a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tracking")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }

        public static void m14746a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("collections");
                CollectionsParser.m14742a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
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
                jsonGenerator.a("section_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("standalone_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                SubtitleParser.m14467a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("title");
                TitleParser.m14469a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            jsonGenerator.g();
        }

        public static void m14748b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("profile_picture");
                m14745a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
