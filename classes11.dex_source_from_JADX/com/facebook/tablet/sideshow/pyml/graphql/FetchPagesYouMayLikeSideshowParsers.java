package com.facebook.tablet.sideshow.pyml.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: on upload progress */
public class FetchPagesYouMayLikeSideshowParsers {

    /* compiled from: on upload progress */
    public final class FetchPagesYouMayLikeSideshowParser {

        /* compiled from: on upload progress */
        public final class PagesYouMayLikeParser {

            /* compiled from: on upload progress */
            public final class NodesParser {

                /* compiled from: on upload progress */
                public final class EntityCardSubtitleParser {
                    public static int m6042a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m6043a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: on upload progress */
                public final class PageLikersParser {
                    public static int m6044a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m6045a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: on upload progress */
                public final class ProfilePictureParser {
                    public static int m6046a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m6047a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m6048b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[8];
                    boolean[] zArr = new boolean[2];
                    boolean[] zArr2 = new boolean[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("can_viewer_like")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("display_name")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("does_viewer_like")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("entity_card_subtitle")) {
                                iArr[3] = EntityCardSubtitleParser.m6042a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("name")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("page_likers")) {
                                iArr[6] = PageLikersParser.m6044a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_picture")) {
                                iArr[7] = ProfilePictureParser.m6046a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(8);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, zArr2[0]);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, zArr2[1]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    flatBufferBuilder.b(7, iArr[7]);
                    return flatBufferBuilder.d();
                }

                public static void m6049b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    boolean a = mutableFlatBuffer.a(i, 0);
                    if (a) {
                        jsonGenerator.a("can_viewer_like");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("display_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    int g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("entity_card_subtitle");
                        EntityCardSubtitleParser.m6043a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("page_likers");
                        PageLikersParser.m6045a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("profile_picture");
                        ProfilePictureParser.m6047a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6050a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m6048b(jsonParser, flatBufferBuilder)));
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

            public static void m6051a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m6049b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6052a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("pages_you_may_like")) {
                        iArr[0] = PagesYouMayLikeParser.m6050a(jsonParser, flatBufferBuilder);
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
