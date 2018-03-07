package com.facebook.ufiservices.util;

import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: crop_box */
public class LinkifyUtilGraphQLParsers {

    /* compiled from: crop_box */
    public final class LinkableUtilAddLikeSentenceLinkGraphQLParser {

        /* compiled from: crop_box */
        public final class AggregatedRangesParser {
            public static int m26924b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("length")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("offset")) {
                            zArr[1] = true;
                            iArr[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, iArr[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m26923a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("length");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("offset");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: crop_box */
        public final class RangesParser {

            /* compiled from: crop_box */
            public final class EntityParser {
                public static int m26925a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[11];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("android_urls")) {
                                iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("app_section")) {
                                iArr[2] = AppSectionParser.m26951a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("backing_application")) {
                                iArr[3] = GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12666a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("name")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("page")) {
                                iArr[6] = PageParser.m26932a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_picture")) {
                                iArr[7] = ProfilePictureParser.m26934a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("redirection_info")) {
                                iArr[8] = RedirectionInfoParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("tag")) {
                                iArr[9] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
                                iArr[10] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(11);
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
                    flatBufferBuilder.b(10, iArr[10]);
                    return flatBufferBuilder.d();
                }

                public static void m26926a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("android_urls");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("app_section");
                        AppSectionParser.m26952a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("backing_application");
                        GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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
                        jsonGenerator.a("page");
                        PageParser.m26933a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("profile_picture");
                        ProfilePictureParser.m26935a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("redirection_info");
                        RedirectionInfoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 9) != 0) {
                        jsonGenerator.a("tag");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                    }
                    if (mutableFlatBuffer.g(i, 10) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m26928b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("entity")) {
                            iArr[0] = EntityParser.m26925a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("length")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("offset")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m26927a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m26928b(jsonParser, flatBufferBuilder)));
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

            public static void m26929b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("entity");
                    EntityParser.m26926a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("length");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("offset");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static int m26930a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("aggregated_ranges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(AggregatedRangesParser.m26924b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("ranges")) {
                        iArr[1] = RangesParser.m26927a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text")) {
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
    }

    /* compiled from: crop_box */
    public final class LinkableUtilAddLinksGraphQLParser {
        public static MutableFlatBuffer m26931a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("aggregated_ranges")) {
                        iArr[0] = AggregatedRangesParser.m26946a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("ranges")) {
                        iArr[1] = RangesParser.m26938a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text")) {
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: crop_box */
    public final class LinkableUtilApplyActorsLinksGraphQLParser {

        /* compiled from: crop_box */
        public final class RangesParser {

            /* compiled from: crop_box */
            public final class EntityParser {

                /* compiled from: crop_box */
                public final class PageParser {
                    public static int m26932a(com.fasterxml.jackson.core.JsonParser r9, com.facebook.flatbuffers.FlatBufferBuilder r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r8 = 4;
                        r7 = 3;
                        r6 = 2;
                        r5 = 1;
                        r4 = 0;
                        r0 = 5;
                        r0 = new int[r0];
                    L_0x0008:
                        r1 = r9.c();
                        r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                        if (r1 == r2) goto L_0x0080;
                    L_0x0010:
                        r1 = r9.i();
                        r9.c();
                        r2 = r9.g();
                        r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                        if (r2 == r3) goto L_0x0008;
                    L_0x001f:
                        if (r1 == 0) goto L_0x0008;
                    L_0x0021:
                        r2 = "__type__";
                        r2 = r1.equals(r2);
                        if (r2 == 0) goto L_0x0034;
                    L_0x0029:
                        r1 = com.facebook.graphql.enums.GraphQLObjectType.a(r9);
                        r1 = r10.a(r1);
                        r0[r4] = r1;
                        goto L_0x0008;
                    L_0x0034:
                        r2 = "id";
                        r2 = r1.equals(r2);
                        if (r2 == 0) goto L_0x0047;
                    L_0x003c:
                        r1 = r9.o();
                        r1 = r10.b(r1);
                        r0[r5] = r1;
                        goto L_0x0008;
                    L_0x0047:
                        r2 = "name";
                        r2 = r1.equals(r2);
                        if (r2 == 0) goto L_0x005a;
                    L_0x004f:
                        r1 = r9.o();
                        r1 = r10.b(r1);
                        r0[r6] = r1;
                        goto L_0x0008;
                    L_0x005a:
                        r2 = "profile_picture";
                        r2 = r1.equals(r2);
                        if (r2 == 0) goto L_0x0069;
                    L_0x0062:
                        r1 = com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser.a(r9, r10);
                        r0[r7] = r1;
                        goto L_0x0008;
                    L_0x0069:
                        r2 = "url";
                        r1 = r1.equals(r2);
                        if (r1 == 0) goto L_0x007c;
                    L_0x0071:
                        r1 = r9.o();
                        r1 = r10.b(r1);
                        r0[r8] = r1;
                        goto L_0x0008;
                    L_0x007c:
                        r9.f();
                        goto L_0x0008;
                    L_0x0080:
                        r1 = 5;
                        r10.c(r1);
                        r1 = r0[r4];
                        r10.b(r4, r1);
                        r1 = r0[r5];
                        r10.b(r5, r1);
                        r1 = r0[r6];
                        r10.b(r6, r1);
                        r1 = r0[r7];
                        r10.b(r7, r1);
                        r0 = r0[r8];
                        r10.b(r8, r0);
                        r0 = r10.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.PageParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public static void m26933a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, com.fasterxml.jackson.core.JsonGenerator r7, com.fasterxml.jackson.databind.SerializerProvider r8) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r4 = 4;
                        r3 = 2;
                        r2 = 1;
                        r1 = 0;
                        r7.f();
                        r0 = r5.g(r6, r1);
                        if (r0 == 0) goto L_0x0015;
                    L_0x000d:
                        r0 = "__type__";
                        r7.a(r0);
                        com.facebook.graphql.modelutil.SerializerHelpers.b(r5, r6, r1, r7);
                    L_0x0015:
                        r0 = r5.g(r6, r2);
                        if (r0 == 0) goto L_0x0027;
                    L_0x001b:
                        r0 = "id";
                        r7.a(r0);
                        r0 = r5.c(r6, r2);
                        r7.b(r0);
                    L_0x0027:
                        r0 = r5.g(r6, r3);
                        if (r0 == 0) goto L_0x0039;
                    L_0x002d:
                        r0 = "name";
                        r7.a(r0);
                        r0 = r5.c(r6, r3);
                        r7.b(r0);
                    L_0x0039:
                        r0 = 3;
                        r0 = r5.g(r6, r0);
                        if (r0 == 0) goto L_0x0048;
                    L_0x0040:
                        r1 = "profile_picture";
                        r7.a(r1);
                        com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser.a(r5, r0, r7);
                    L_0x0048:
                        r0 = r5.g(r6, r4);
                        if (r0 == 0) goto L_0x005a;
                    L_0x004e:
                        r0 = "url";
                        r7.a(r0);
                        r0 = r5.c(r6, r4);
                        r7.b(r0);
                    L_0x005a:
                        r7.g();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.PageParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }
                }

                /* compiled from: crop_box */
                public final class ProfilePictureParser {
                    public static int m26934a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r5 = 1;
                        r4 = 0;
                        r0 = new int[r5];
                    L_0x0004:
                        r1 = r6.c();
                        r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                        if (r1 == r2) goto L_0x0034;
                    L_0x000c:
                        r1 = r6.i();
                        r6.c();
                        r2 = r6.g();
                        r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                        if (r2 == r3) goto L_0x0004;
                    L_0x001b:
                        if (r1 == 0) goto L_0x0004;
                    L_0x001d:
                        r2 = "uri";
                        r1 = r1.equals(r2);
                        if (r1 == 0) goto L_0x0030;
                    L_0x0025:
                        r1 = r6.o();
                        r1 = r7.b(r1);
                        r0[r4] = r1;
                        goto L_0x0004;
                    L_0x0030:
                        r6.f();
                        goto L_0x0004;
                    L_0x0034:
                        r7.c(r5);
                        r0 = r0[r4];
                        r7.b(r4, r0);
                        r0 = r7.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public static void m26935a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = 0;
                        r4.f();
                        r0 = r2.g(r3, r1);
                        if (r0 == 0) goto L_0x0016;
                    L_0x000a:
                        r0 = "uri";
                        r4.a(r0);
                        r0 = r2.c(r3, r1);
                        r4.b(r0);
                    L_0x0016:
                        r4.g();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                    }
                }

                public static int m26936a(com.fasterxml.jackson.core.JsonParser r9, com.facebook.flatbuffers.FlatBufferBuilder r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = 4;
                    r7 = 3;
                    r6 = 2;
                    r5 = 1;
                    r4 = 0;
                    r0 = 11;
                    r0 = new int[r0];
                L_0x0009:
                    r1 = r9.c();
                    r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r1 == r2) goto L_0x00ee;
                L_0x0011:
                    r1 = r9.i();
                    r9.c();
                    r2 = r9.g();
                    r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r2 == r3) goto L_0x0009;
                L_0x0020:
                    if (r1 == 0) goto L_0x0009;
                L_0x0022:
                    r2 = "__type__";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0035;
                L_0x002a:
                    r1 = com.facebook.graphql.enums.GraphQLObjectType.a(r9);
                    r1 = r10.a(r1);
                    r0[r4] = r1;
                    goto L_0x0009;
                L_0x0035:
                    r2 = "android_urls";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0044;
                L_0x003d:
                    r1 = com.facebook.graphql.modelutil.DeserializerHelpers.a(r9, r10);
                    r0[r5] = r1;
                    goto L_0x0009;
                L_0x0044:
                    r2 = "app_section";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0053;
                L_0x004c:
                    r1 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.StoryHeaderSectionOnClickGraphQLParser.AppSectionParser.m26951a(r9, r10);
                    r0[r6] = r1;
                    goto L_0x0009;
                L_0x0053:
                    r2 = "backing_application";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0062;
                L_0x005b:
                    r1 = com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12666a(r9, r10);
                    r0[r7] = r1;
                    goto L_0x0009;
                L_0x0062:
                    r2 = "id";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0075;
                L_0x006a:
                    r1 = r9.o();
                    r1 = r10.b(r1);
                    r0[r8] = r1;
                    goto L_0x0009;
                L_0x0075:
                    r2 = "name";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0089;
                L_0x007d:
                    r1 = 5;
                    r2 = r9.o();
                    r2 = r10.b(r2);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x0089:
                    r2 = "page";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x009a;
                L_0x0091:
                    r1 = 6;
                    r2 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.PageParser.m26932a(r9, r10);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x009a:
                    r2 = "profile_picture";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x00ab;
                L_0x00a2:
                    r1 = 7;
                    r2 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.m26934a(r9, r10);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x00ab:
                    r2 = "redirection_info";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x00bd;
                L_0x00b3:
                    r1 = 8;
                    r2 = com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser.a(r9, r10);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x00bd:
                    r2 = "tag";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x00d3;
                L_0x00c5:
                    r1 = 9;
                    r2 = r9.o();
                    r2 = r10.b(r2);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x00d3:
                    r2 = "url";
                    r1 = r1.equals(r2);
                    if (r1 == 0) goto L_0x00e9;
                L_0x00db:
                    r1 = 10;
                    r2 = r9.o();
                    r2 = r10.b(r2);
                    r0[r1] = r2;
                    goto L_0x0009;
                L_0x00e9:
                    r9.f();
                    goto L_0x0009;
                L_0x00ee:
                    r1 = 11;
                    r10.c(r1);
                    r1 = r0[r4];
                    r10.b(r4, r1);
                    r1 = r0[r5];
                    r10.b(r5, r1);
                    r1 = r0[r6];
                    r10.b(r6, r1);
                    r1 = r0[r7];
                    r10.b(r7, r1);
                    r1 = r0[r8];
                    r10.b(r8, r1);
                    r1 = 5;
                    r2 = 5;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 6;
                    r2 = 6;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 7;
                    r2 = 7;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 8;
                    r2 = 8;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 9;
                    r2 = 9;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 10;
                    r2 = 10;
                    r0 = r0[r2];
                    r10.b(r1, r0);
                    r0 = r10.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m26937a(com.facebook.flatbuffers.MutableFlatBuffer r6, int r7, com.fasterxml.jackson.core.JsonGenerator r8, com.fasterxml.jackson.databind.SerializerProvider r9) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = 9;
                    r4 = 5;
                    r3 = 4;
                    r2 = 1;
                    r1 = 0;
                    r8.f();
                    r0 = r6.g(r7, r1);
                    if (r0 == 0) goto L_0x0017;
                L_0x000f:
                    r0 = "__type__";
                    r8.a(r0);
                    com.facebook.graphql.modelutil.SerializerHelpers.b(r6, r7, r1, r8);
                L_0x0017:
                    r0 = r6.g(r7, r2);
                    if (r0 == 0) goto L_0x0029;
                L_0x001d:
                    r0 = "android_urls";
                    r8.a(r0);
                    r0 = r6.f(r7, r2);
                    com.facebook.graphql.modelutil.SerializerHelpers.a(r0, r8);
                L_0x0029:
                    r0 = 2;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x0038;
                L_0x0030:
                    r1 = "app_section";
                    r8.a(r1);
                    com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.StoryHeaderSectionOnClickGraphQLParser.AppSectionParser.m26952a(r6, r0, r8);
                L_0x0038:
                    r0 = 3;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x0047;
                L_0x003f:
                    r1 = "backing_application";
                    r8.a(r1);
                    com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12667a(r6, r0, r8, r9);
                L_0x0047:
                    r0 = r6.g(r7, r3);
                    if (r0 == 0) goto L_0x0059;
                L_0x004d:
                    r0 = "id";
                    r8.a(r0);
                    r0 = r6.c(r7, r3);
                    r8.b(r0);
                L_0x0059:
                    r0 = r6.g(r7, r4);
                    if (r0 == 0) goto L_0x006b;
                L_0x005f:
                    r0 = "name";
                    r8.a(r0);
                    r0 = r6.c(r7, r4);
                    r8.b(r0);
                L_0x006b:
                    r0 = 6;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x007a;
                L_0x0072:
                    r1 = "page";
                    r8.a(r1);
                    com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.PageParser.m26933a(r6, r0, r8, r9);
                L_0x007a:
                    r0 = 7;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x0089;
                L_0x0081:
                    r1 = "profile_picture";
                    r8.a(r1);
                    com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.m26935a(r6, r0, r8);
                L_0x0089:
                    r0 = 8;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x0099;
                L_0x0091:
                    r1 = "redirection_info";
                    r8.a(r1);
                    com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser.a(r6, r0, r8, r9);
                L_0x0099:
                    r0 = r6.g(r7, r5);
                    if (r0 == 0) goto L_0x00ab;
                L_0x009f:
                    r0 = "tag";
                    r8.a(r0);
                    r0 = r6.c(r7, r5);
                    r8.b(r0);
                L_0x00ab:
                    r0 = 10;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x00c1;
                L_0x00b3:
                    r0 = "url";
                    r8.a(r0);
                    r0 = 10;
                    r0 = r6.c(r7, r0);
                    r8.b(r0);
                L_0x00c1:
                    r8.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }
            }

            public static int m26940b(com.fasterxml.jackson.core.JsonParser r10, com.facebook.flatbuffers.FlatBufferBuilder r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r9 = 3;
                r8 = 2;
                r7 = 1;
                r6 = 0;
                r0 = new int[r9];
                r1 = new boolean[r8];
                r2 = new int[r8];
            L_0x000a:
                r3 = r10.c();
                r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                if (r3 == r4) goto L_0x0058;
            L_0x0012:
                r3 = r10.i();
                r10.c();
                r4 = r10.g();
                r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                if (r4 == r5) goto L_0x000a;
            L_0x0021:
                if (r3 == 0) goto L_0x000a;
            L_0x0023:
                r4 = "entity";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0032;
            L_0x002b:
                r3 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.m26936a(r10, r11);
                r0[r6] = r3;
                goto L_0x000a;
            L_0x0032:
                r4 = "length";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0043;
            L_0x003a:
                r1[r6] = r7;
                r3 = r10.E();
                r2[r6] = r3;
                goto L_0x000a;
            L_0x0043:
                r4 = "offset";
                r3 = r3.equals(r4);
                if (r3 == 0) goto L_0x0054;
            L_0x004b:
                r1[r7] = r7;
                r3 = r10.E();
                r2[r7] = r3;
                goto L_0x000a;
            L_0x0054:
                r10.f();
                goto L_0x000a;
            L_0x0058:
                r11.c(r9);
                r0 = r0[r6];
                r11.b(r6, r0);
                r0 = r1[r6];
                if (r0 == 0) goto L_0x0069;
            L_0x0064:
                r0 = r2[r6];
                r11.a(r7, r0, r6);
            L_0x0069:
                r0 = r1[r7];
                if (r0 == 0) goto L_0x0072;
            L_0x006d:
                r0 = r2[r7];
                r11.a(r8, r0, r6);
            L_0x0072:
                r0 = r11.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static int m26938a(com.fasterxml.jackson.core.JsonParser r4, com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = 0;
                r2 = new java.util.ArrayList;
                r2.<init>();
                r1 = r4.g();
                r3 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
                if (r1 != r3) goto L_0x0022;
            L_0x000e:
                r1 = r4.c();
                r3 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
                if (r1 == r3) goto L_0x0022;
            L_0x0016:
                r1 = m26940b(r4, r5);
                r1 = java.lang.Integer.valueOf(r1);
                r2.add(r1);
                goto L_0x000e;
            L_0x0022:
                r1 = r2.isEmpty();
                if (r1 == 0) goto L_0x0029;
            L_0x0028:
                return r0;
            L_0x0029:
                r1 = r2.size();
                r3 = new int[r1];
                r1 = r0;
            L_0x0030:
                r0 = r2.size();
                if (r1 >= r0) goto L_0x0046;
            L_0x0036:
                r0 = r2.get(r1);
                r0 = (java.lang.Integer) r0;
                r0 = r0.intValue();
                r3[r1] = r0;
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0030;
            L_0x0046:
                r0 = 1;
                r0 = r5.a(r3, r0);
                goto L_0x0028;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m26939a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4, com.fasterxml.jackson.databind.SerializerProvider r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4.d();
                r0 = 0;
            L_0x0004:
                r1 = r2.c(r3);
                if (r0 >= r1) goto L_0x0014;
            L_0x000a:
                r1 = r2.m(r3, r0);
                m26941b(r2, r1, r4, r5);
                r0 = r0 + 1;
                goto L_0x0004;
            L_0x0014:
                r4.e();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            public static void m26941b(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, com.fasterxml.jackson.core.JsonGenerator r5, com.fasterxml.jackson.databind.SerializerProvider r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = 0;
                r5.f();
                r0 = r3.g(r4, r2);
                if (r0 == 0) goto L_0x0012;
            L_0x000a:
                r1 = "entity";
                r5.a(r1);
                com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.m26937a(r3, r0, r5, r6);
            L_0x0012:
                r0 = 1;
                r0 = r3.a(r4, r0, r2);
                if (r0 == 0) goto L_0x0021;
            L_0x0019:
                r1 = "length";
                r5.a(r1);
                r5.b(r0);
            L_0x0021:
                r0 = 2;
                r0 = r3.a(r4, r0, r2);
                if (r0 == 0) goto L_0x0030;
            L_0x0028:
                r1 = "offset";
                r5.a(r1);
                r5.b(r0);
            L_0x0030:
                r5.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        public static int m26942a(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = 2;
            r5 = 1;
            r4 = 0;
            r0 = new int[r6];
        L_0x0005:
            r1 = r7.c();
            r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
            if (r1 == r2) goto L_0x0044;
        L_0x000d:
            r1 = r7.i();
            r7.c();
            r2 = r7.g();
            r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
            if (r2 == r3) goto L_0x0005;
        L_0x001c:
            if (r1 == 0) goto L_0x0005;
        L_0x001e:
            r2 = "ranges";
            r2 = r1.equals(r2);
            if (r2 == 0) goto L_0x002d;
        L_0x0026:
            r1 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.m26938a(r7, r8);
            r0[r4] = r1;
            goto L_0x0005;
        L_0x002d:
            r2 = "text";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0040;
        L_0x0035:
            r1 = r7.o();
            r1 = r8.b(r1);
            r0[r5] = r1;
            goto L_0x0005;
        L_0x0040:
            r7.f();
            goto L_0x0005;
        L_0x0044:
            r8.c(r6);
            r1 = r0[r4];
            r8.b(r4, r1);
            r0 = r0[r5];
            r8.b(r5, r0);
            r0 = r8.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public static void m26943a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, com.fasterxml.jackson.core.JsonGenerator r5, com.fasterxml.jackson.databind.SerializerProvider r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = 1;
            r5.f();
            r0 = 0;
            r0 = r3.g(r4, r0);
            if (r0 == 0) goto L_0x0013;
        L_0x000b:
            r1 = "ranges";
            r5.a(r1);
            com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.m26939a(r3, r0, r5, r6);
        L_0x0013:
            r0 = r3.g(r4, r2);
            if (r0 == 0) goto L_0x0025;
        L_0x0019:
            r0 = "text";
            r5.a(r0);
            r0 = r3.c(r4, r2);
            r5.b(r0);
        L_0x0025:
            r5.g();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
        }
    }

    /* compiled from: crop_box */
    public final class LinkableUtilApplyAggregatedLinksGraphQLParser {

        /* compiled from: crop_box */
        public final class AggregatedRangesParser {

            /* compiled from: crop_box */
            public final class SampleEntitiesParser {
                public static int m26944b(com.fasterxml.jackson.core.JsonParser r9, com.facebook.flatbuffers.FlatBufferBuilder r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = 4;
                    r7 = 3;
                    r6 = 2;
                    r5 = 1;
                    r4 = 0;
                    r0 = 7;
                    r0 = new int[r0];
                L_0x0008:
                    r1 = r9.c();
                    r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r1 == r2) goto L_0x00ab;
                L_0x0010:
                    r1 = r9.i();
                    r9.c();
                    r2 = r9.g();
                    r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r2 == r3) goto L_0x0008;
                L_0x001f:
                    if (r1 == 0) goto L_0x0008;
                L_0x0021:
                    r2 = "__type__";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0034;
                L_0x0029:
                    r1 = com.facebook.graphql.enums.GraphQLObjectType.a(r9);
                    r1 = r10.a(r1);
                    r0[r4] = r1;
                    goto L_0x0008;
                L_0x0034:
                    r2 = "friendship_status";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x004b;
                L_0x003c:
                    r1 = r9.o();
                    r1 = com.facebook.graphql.enums.GraphQLFriendshipStatus.fromString(r1);
                    r1 = r10.a(r1);
                    r0[r5] = r1;
                    goto L_0x0008;
                L_0x004b:
                    r2 = "id";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x005e;
                L_0x0053:
                    r1 = r9.o();
                    r1 = r10.b(r1);
                    r0[r6] = r1;
                    goto L_0x0008;
                L_0x005e:
                    r2 = "mutual_friends";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x006d;
                L_0x0066:
                    r1 = com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLParsers.ProfileListFriendingControllerGraphQLParser.MutualFriendsParser.m26819a(r9, r10);
                    r0[r7] = r1;
                    goto L_0x0008;
                L_0x006d:
                    r2 = "name";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0080;
                L_0x0075:
                    r1 = r9.o();
                    r1 = r10.b(r1);
                    r0[r8] = r1;
                    goto L_0x0008;
                L_0x0080:
                    r2 = "profile_picture";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x0091;
                L_0x0088:
                    r1 = 5;
                    r2 = com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLParsers.UFIProfileListFragmentGraphQLParser.ProfilePictureParser.m26681a(r9, r10);
                    r0[r1] = r2;
                    goto L_0x0008;
                L_0x0091:
                    r2 = "url";
                    r1 = r1.equals(r2);
                    if (r1 == 0) goto L_0x00a6;
                L_0x0099:
                    r1 = 6;
                    r2 = r9.o();
                    r2 = r10.b(r2);
                    r0[r1] = r2;
                    goto L_0x0008;
                L_0x00a6:
                    r9.f();
                    goto L_0x0008;
                L_0x00ab:
                    r1 = 7;
                    r10.c(r1);
                    r1 = r0[r4];
                    r10.b(r4, r1);
                    r1 = r0[r5];
                    r10.b(r5, r1);
                    r1 = r0[r6];
                    r10.b(r6, r1);
                    r1 = r0[r7];
                    r10.b(r7, r1);
                    r1 = r0[r8];
                    r10.b(r8, r1);
                    r1 = 5;
                    r2 = 5;
                    r2 = r0[r2];
                    r10.b(r1, r2);
                    r1 = 6;
                    r2 = 6;
                    r0 = r0[r2];
                    r10.b(r1, r0);
                    r0 = r10.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m26945b(com.facebook.flatbuffers.MutableFlatBuffer r6, int r7, com.fasterxml.jackson.core.JsonGenerator r8, com.fasterxml.jackson.databind.SerializerProvider r9) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = 6;
                    r4 = 4;
                    r3 = 2;
                    r2 = 1;
                    r1 = 0;
                    r8.f();
                    r0 = r6.g(r7, r1);
                    if (r0 == 0) goto L_0x0016;
                L_0x000e:
                    r0 = "__type__";
                    r8.a(r0);
                    com.facebook.graphql.modelutil.SerializerHelpers.b(r6, r7, r1, r8);
                L_0x0016:
                    r0 = r6.g(r7, r2);
                    if (r0 == 0) goto L_0x0028;
                L_0x001c:
                    r0 = "friendship_status";
                    r8.a(r0);
                    r0 = r6.b(r7, r2);
                    r8.b(r0);
                L_0x0028:
                    r0 = r6.g(r7, r3);
                    if (r0 == 0) goto L_0x003a;
                L_0x002e:
                    r0 = "id";
                    r8.a(r0);
                    r0 = r6.c(r7, r3);
                    r8.b(r0);
                L_0x003a:
                    r0 = 3;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x0049;
                L_0x0041:
                    r1 = "mutual_friends";
                    r8.a(r1);
                    com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLParsers.ProfileListFriendingControllerGraphQLParser.MutualFriendsParser.m26820a(r6, r0, r8);
                L_0x0049:
                    r0 = r6.g(r7, r4);
                    if (r0 == 0) goto L_0x005b;
                L_0x004f:
                    r0 = "name";
                    r8.a(r0);
                    r0 = r6.c(r7, r4);
                    r8.b(r0);
                L_0x005b:
                    r0 = 5;
                    r0 = r6.g(r7, r0);
                    if (r0 == 0) goto L_0x006a;
                L_0x0062:
                    r1 = "profile_picture";
                    r8.a(r1);
                    com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLParsers.UFIProfileListFragmentGraphQLParser.ProfilePictureParser.m26682a(r6, r0, r8);
                L_0x006a:
                    r0 = r6.g(r7, r5);
                    if (r0 == 0) goto L_0x007c;
                L_0x0070:
                    r0 = "url";
                    r8.a(r0);
                    r0 = r6.c(r7, r5);
                    r8.b(r0);
                L_0x007c:
                    r8.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }
            }

            public static int m26948b(com.fasterxml.jackson.core.JsonParser r14, com.facebook.flatbuffers.FlatBufferBuilder r15) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r9 = 3;
                r8 = 2;
                r7 = 1;
                r6 = 0;
                r0 = new int[r9];
                r1 = new boolean[r8];
                r2 = new int[r8];
            L_0x000a:
                r3 = r14.c();
                r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                if (r3 == r4) goto L_0x007d;
            L_0x0012:
                r3 = r14.i();
                r14.c();
                r4 = r14.g();
                r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                if (r4 == r5) goto L_0x000a;
            L_0x0021:
                if (r3 == 0) goto L_0x000a;
            L_0x0023:
                r4 = "length";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0034;
            L_0x002b:
                r1[r6] = r7;
                r3 = r14.E();
                r2[r6] = r3;
                goto L_0x000a;
            L_0x0034:
                r4 = "offset";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0045;
            L_0x003c:
                r1[r7] = r7;
                r3 = r14.E();
                r2[r7] = r3;
                goto L_0x000a;
            L_0x0045:
                r4 = "sample_entities";
                r3 = r3.equals(r4);
                if (r3 == 0) goto L_0x0079;
            L_0x004d:
                r10 = 0;
                r12 = new java.util.ArrayList;
                r12.<init>();
                r11 = r14.g();
                r13 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
                if (r11 != r13) goto L_0x006f;
            L_0x005b:
                r11 = r14.c();
                r13 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
                if (r11 == r13) goto L_0x006f;
            L_0x0063:
                r11 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser.m26944b(r14, r15);
                r11 = java.lang.Integer.valueOf(r11);
                r12.add(r11);
                goto L_0x005b;
            L_0x006f:
                r11 = r12.isEmpty();
                if (r11 == 0) goto L_0x009c;
            L_0x0075:
                r3 = r10;
                r0[r8] = r3;
                goto L_0x000a;
            L_0x0079:
                r14.f();
                goto L_0x000a;
            L_0x007d:
                r15.c(r9);
                r3 = r1[r6];
                if (r3 == 0) goto L_0x0089;
            L_0x0084:
                r3 = r2[r6];
                r15.a(r6, r3, r6);
            L_0x0089:
                r1 = r1[r7];
                if (r1 == 0) goto L_0x0092;
            L_0x008d:
                r1 = r2[r7];
                r15.a(r7, r1, r6);
            L_0x0092:
                r0 = r0[r8];
                r15.b(r8, r0);
                r0 = r15.d();
                return r0;
            L_0x009c:
                r11 = r12.size();
                r13 = new int[r11];
                r11 = r10;
            L_0x00a3:
                r10 = r12.size();
                if (r11 >= r10) goto L_0x00b9;
            L_0x00a9:
                r10 = r12.get(r11);
                r10 = (java.lang.Integer) r10;
                r10 = r10.intValue();
                r13[r11] = r10;
                r10 = r11 + 1;
                r11 = r10;
                goto L_0x00a3;
            L_0x00b9:
                r10 = 1;
                r10 = r15.a(r13, r10);
                goto L_0x0075;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static int m26946a(com.fasterxml.jackson.core.JsonParser r4, com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = 0;
                r2 = new java.util.ArrayList;
                r2.<init>();
                r1 = r4.g();
                r3 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
                if (r1 != r3) goto L_0x0022;
            L_0x000e:
                r1 = r4.c();
                r3 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
                if (r1 == r3) goto L_0x0022;
            L_0x0016:
                r1 = m26948b(r4, r5);
                r1 = java.lang.Integer.valueOf(r1);
                r2.add(r1);
                goto L_0x000e;
            L_0x0022:
                r1 = r2.isEmpty();
                if (r1 == 0) goto L_0x0029;
            L_0x0028:
                return r0;
            L_0x0029:
                r1 = r2.size();
                r3 = new int[r1];
                r1 = r0;
            L_0x0030:
                r0 = r2.size();
                if (r1 >= r0) goto L_0x0046;
            L_0x0036:
                r0 = r2.get(r1);
                r0 = (java.lang.Integer) r0;
                r0 = r0.intValue();
                r3[r1] = r0;
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0030;
            L_0x0046:
                r0 = 1;
                r0 = r5.a(r3, r0);
                goto L_0x0028;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m26947a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4, com.fasterxml.jackson.databind.SerializerProvider r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4.d();
                r0 = 0;
            L_0x0004:
                r1 = r2.c(r3);
                if (r0 >= r1) goto L_0x0014;
            L_0x000a:
                r1 = r2.m(r3, r0);
                m26949b(r2, r1, r4, r5);
                r0 = r0 + 1;
                goto L_0x0004;
            L_0x0014:
                r4.e();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            public static void m26949b(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, com.fasterxml.jackson.core.JsonGenerator r7, com.fasterxml.jackson.databind.SerializerProvider r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = 0;
                r7.f();
                r0 = r5.a(r6, r2, r2);
                if (r0 == 0) goto L_0x0012;
            L_0x000a:
                r1 = "length";
                r7.a(r1);
                r7.b(r0);
            L_0x0012:
                r0 = 1;
                r0 = r5.a(r6, r0, r2);
                if (r0 == 0) goto L_0x0021;
            L_0x0019:
                r1 = "offset";
                r7.a(r1);
                r7.b(r0);
            L_0x0021:
                r0 = 2;
                r0 = r5.g(r6, r0);
                if (r0 == 0) goto L_0x0044;
            L_0x0028:
                r1 = "sample_entities";
                r7.a(r1);
                r7.d();
                r3 = 0;
            L_0x0031:
                r4 = r5.c(r0);
                if (r3 >= r4) goto L_0x0041;
            L_0x0037:
                r4 = r5.m(r0, r3);
                com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser.m26945b(r5, r4, r7, r8);
                r3 = r3 + 1;
                goto L_0x0031;
            L_0x0041:
                r7.e();
            L_0x0044:
                r7.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        public static com.facebook.flatbuffers.MutableFlatBuffer m26950a(com.fasterxml.jackson.core.JsonParser r13) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = 1;
            r2 = 0;
            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            r0.<init>(r1);
            r12 = 2;
            r11 = 1;
            r10 = 0;
            r6 = new int[r12];
        L_0x000e:
            r7 = r13.c();
            r8 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
            if (r7 == r8) goto L_0x004d;
        L_0x0016:
            r7 = r13.i();
            r13.c();
            r8 = r13.g();
            r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
            if (r8 == r9) goto L_0x000e;
        L_0x0025:
            if (r7 == 0) goto L_0x000e;
        L_0x0027:
            r8 = "aggregated_ranges";
            r8 = r7.equals(r8);
            if (r8 == 0) goto L_0x0036;
        L_0x002f:
            r7 = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.m26946a(r13, r0);
            r6[r10] = r7;
            goto L_0x000e;
        L_0x0036:
            r8 = "text";
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x0049;
        L_0x003e:
            r7 = r13.o();
            r7 = r0.b(r7);
            r6[r11] = r7;
            goto L_0x000e;
        L_0x0049:
            r13.f();
            goto L_0x000e;
        L_0x004d:
            r0.c(r12);
            r7 = r6[r10];
            r0.b(r10, r7);
            r6 = r6[r11];
            r0.b(r11, r6);
            r6 = r0.d();
            r1 = r6;
            r0.d(r1);
            r0 = r0.e();
            r1 = java.nio.ByteBuffer.wrap(r0);
            r0 = 0;
            r1.position(r0);
            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
            r3 = r2;
            r5 = r2;
            r0.<init>(r1, r2, r3, r4, r5);
            r1 = 4;
            r2 = java.lang.Boolean.valueOf(r4);
            r0.a(r1, r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.a(com.fasterxml.jackson.core.JsonParser):com.facebook.flatbuffers.MutableFlatBuffer");
        }
    }

    /* compiled from: crop_box */
    public final class StoryHeaderSectionOnClickGraphQLParser {

        /* compiled from: crop_box */
        public final class AppSectionParser {
            public static int m26951a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m26952a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m26953a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("app_section")) {
                        iArr[1] = AppSectionParser.m26951a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
