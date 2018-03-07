package com.facebook.api.graphql.reactions;

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

/* compiled from: android_place_picker_long_press */
public class ReactionsGraphQLParsers {

    /* compiled from: android_place_picker_long_press */
    public final class CompleteReactionsCountFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class TopReactionsParser {

            /* compiled from: android_place_picker_long_press */
            public final class EdgesParser {

                /* compiled from: android_place_picker_long_press */
                public final class NodeParser {
                    public static int m17145a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        boolean[] zArr = new boolean[1];
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("key")) {
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

                    public static void m17146a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("key");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m17147b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    int[] iArr2 = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m17145a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("reaction_count")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, iArr2[0], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m17148b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m17146a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.a(i, 1, 0);
                    if (g != 0) {
                        jsonGenerator.a("reaction_count");
                        jsonGenerator.b(g);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m17149a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m17147b(jsonParser, flatBufferBuilder)));
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

            public static void m17150a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m17148b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m17151a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("top_reactions")) {
                        iArr[0] = TopReactionsParser.m17149a(jsonParser, flatBufferBuilder);
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

    /* compiled from: android_place_picker_long_press */
    public final class CompleteReactionsFeedbackFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class ReactorsParser {
            public static int m17152a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m17153a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m17154a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[2];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_react")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("display_reactions")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("important_reactors")) {
                        iArr[2] = ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reactors")) {
                        iArr[3] = ReactorsParser.m17152a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("supported_reactions")) {
                        iArr[4] = SupportedReactionsParser.m17165a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("top_reactions")) {
                        iArr[5] = TopReactionsParser.m17149a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_acts_as_person")) {
                        iArr[6] = ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_feedback_reaction_key")) {
                        zArr[2] = true;
                        iArr2[0] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[2]) {
                flatBufferBuilder.a(7, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: android_place_picker_long_press */
    public final class ReactionsCountFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class TopReactionsParser {

            /* compiled from: android_place_picker_long_press */
            public final class EdgesParser {

                /* compiled from: android_place_picker_long_press */
                public final class NodeParser {
                    public static int m17155a(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                        r6 = 1;
                        r5 = 0;
                        r0 = new boolean[r6];
                        r1 = new int[r6];
                    L_0x0006:
                        r2 = r7.c();
                        r3 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                        if (r2 == r3) goto L_0x0034;
                    L_0x000e:
                        r2 = r7.i();
                        r7.c();
                        r3 = r7.g();
                        r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                        if (r3 == r4) goto L_0x0006;
                    L_0x001d:
                        if (r2 == 0) goto L_0x0006;
                    L_0x001f:
                        r3 = "key";
                        r2 = r2.equals(r3);
                        if (r2 == 0) goto L_0x0030;
                    L_0x0027:
                        r0[r5] = r6;
                        r2 = r7.E();
                        r1[r5] = r2;
                        goto L_0x0006;
                    L_0x0030:
                        r7.f();
                        goto L_0x0006;
                    L_0x0034:
                        r8.c(r6);
                        r0 = r0[r5];
                        if (r0 == 0) goto L_0x0040;
                    L_0x003b:
                        r0 = r1[r5];
                        r8.a(r5, r0, r5);
                    L_0x0040:
                        r0 = r8.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public static void m17156a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
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
                        r0 = 0;
                        r4.f();
                        r0 = r2.a(r3, r0, r0);
                        if (r0 == 0) goto L_0x0012;
                    L_0x000a:
                        r1 = "key";
                        r4.a(r1);
                        r4.b(r0);
                    L_0x0012:
                        r4.g();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                    }
                }

                public static int m17157b(com.fasterxml.jackson.core.JsonParser r9, com.facebook.flatbuffers.FlatBufferBuilder r10) {
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
                    r8 = 2;
                    r7 = 1;
                    r6 = 0;
                    r0 = new int[r8];
                    r1 = new boolean[r7];
                    r2 = new int[r7];
                L_0x0009:
                    r3 = r9.c();
                    r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r3 == r4) goto L_0x0046;
                L_0x0011:
                    r3 = r9.i();
                    r9.c();
                    r4 = r9.g();
                    r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r4 == r5) goto L_0x0009;
                L_0x0020:
                    if (r3 == 0) goto L_0x0009;
                L_0x0022:
                    r4 = "node";
                    r4 = r3.equals(r4);
                    if (r4 == 0) goto L_0x0031;
                L_0x002a:
                    r3 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser.m17155a(r9, r10);
                    r0[r6] = r3;
                    goto L_0x0009;
                L_0x0031:
                    r4 = "reaction_count";
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x0042;
                L_0x0039:
                    r1[r6] = r7;
                    r3 = r9.E();
                    r2[r6] = r3;
                    goto L_0x0009;
                L_0x0042:
                    r9.f();
                    goto L_0x0009;
                L_0x0046:
                    r10.c(r8);
                    r0 = r0[r6];
                    r10.b(r6, r0);
                    r0 = r1[r6];
                    if (r0 == 0) goto L_0x0057;
                L_0x0052:
                    r0 = r2[r6];
                    r10.a(r7, r0, r6);
                L_0x0057:
                    r0 = r10.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m17158b(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, com.fasterxml.jackson.core.JsonGenerator r5, com.fasterxml.jackson.databind.SerializerProvider r6) {
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
                    r2 = 0;
                    r5.f();
                    r0 = r3.g(r4, r2);
                    if (r0 == 0) goto L_0x0012;
                L_0x000a:
                    r1 = "node";
                    r5.a(r1);
                    com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser.m17156a(r3, r0, r5);
                L_0x0012:
                    r0 = 1;
                    r0 = r3.a(r4, r0, r2);
                    if (r0 == 0) goto L_0x0021;
                L_0x0019:
                    r1 = "reaction_count";
                    r5.a(r1);
                    r5.b(r0);
                L_0x0021:
                    r5.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }
            }

            public static int m17159a(com.fasterxml.jackson.core.JsonParser r10, com.facebook.flatbuffers.FlatBufferBuilder r11) {
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
                r5 = 1;
                r4 = 0;
                r0 = new int[r5];
            L_0x0004:
                r1 = r10.c();
                r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                if (r1 == r2) goto L_0x0055;
            L_0x000c:
                r1 = r10.i();
                r10.c();
                r2 = r10.g();
                r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                if (r2 == r3) goto L_0x0004;
            L_0x001b:
                if (r1 == 0) goto L_0x0004;
            L_0x001d:
                r2 = "edges";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x0051;
            L_0x0025:
                r6 = 0;
                r8 = new java.util.ArrayList;
                r8.<init>();
                r7 = r10.g();
                r9 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
                if (r7 != r9) goto L_0x0047;
            L_0x0033:
                r7 = r10.c();
                r9 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
                if (r7 == r9) goto L_0x0047;
            L_0x003b:
                r7 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.m17157b(r10, r11);
                r7 = java.lang.Integer.valueOf(r7);
                r8.add(r7);
                goto L_0x0033;
            L_0x0047:
                r7 = r8.isEmpty();
                if (r7 == 0) goto L_0x0062;
            L_0x004d:
                r1 = r6;
                r0[r4] = r1;
                goto L_0x0004;
            L_0x0051:
                r10.f();
                goto L_0x0004;
            L_0x0055:
                r11.c(r5);
                r0 = r0[r4];
                r11.b(r4, r0);
                r0 = r11.d();
                return r0;
            L_0x0062:
                r7 = r8.size();
                r9 = new int[r7];
                r7 = r6;
            L_0x0069:
                r6 = r8.size();
                if (r7 >= r6) goto L_0x007f;
            L_0x006f:
                r6 = r8.get(r7);
                r6 = (java.lang.Integer) r6;
                r6 = r6.intValue();
                r9[r7] = r6;
                r6 = r7 + 1;
                r7 = r6;
                goto L_0x0069;
            L_0x007f:
                r6 = 1;
                r6 = r11.a(r9, r6);
                goto L_0x004d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m17160a(com.facebook.flatbuffers.MutableFlatBuffer r4, int r5, com.fasterxml.jackson.core.JsonGenerator r6, com.fasterxml.jackson.databind.SerializerProvider r7) {
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
                r6.f();
                r0 = 0;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0026;
            L_0x000a:
                r1 = "edges";
                r6.a(r1);
                r6.d();
                r2 = 0;
            L_0x0013:
                r3 = r4.c(r0);
                if (r2 >= r3) goto L_0x0023;
            L_0x0019:
                r3 = r4.m(r0, r2);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.m17158b(r4, r3, r6, r7);
                r2 = r2 + 1;
                goto L_0x0013;
            L_0x0023:
                r6.e();
            L_0x0026:
                r6.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        public static com.facebook.flatbuffers.MutableFlatBuffer m17161a(com.fasterxml.jackson.core.JsonParser r12) {
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
            r11 = 1;
            r10 = 0;
            r6 = new int[r11];
        L_0x000d:
            r7 = r12.c();
            r8 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
            if (r7 == r8) goto L_0x0039;
        L_0x0015:
            r7 = r12.i();
            r12.c();
            r8 = r12.g();
            r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
            if (r8 == r9) goto L_0x000d;
        L_0x0024:
            if (r7 == 0) goto L_0x000d;
        L_0x0026:
            r8 = "top_reactions";
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x0035;
        L_0x002e:
            r7 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.m17159a(r12, r0);
            r6[r10] = r7;
            goto L_0x000d;
        L_0x0035:
            r12.f();
            goto L_0x000d;
        L_0x0039:
            r0.c(r11);
            r6 = r6[r10];
            r0.b(r10, r6);
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.a(com.fasterxml.jackson.core.JsonParser):com.facebook.flatbuffers.MutableFlatBuffer");
        }
    }

    /* compiled from: android_place_picker_long_press */
    public final class SimpleReactionsFeedbackFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class ReactorsParser {
            public static int m17162a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m17163a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m17164a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[2];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_react")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("display_reactions")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("important_reactors")) {
                        iArr[2] = ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reactors")) {
                        iArr[3] = ReactorsParser.m17162a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("supported_reactions")) {
                        iArr[4] = SupportedReactionsParser.m17165a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("top_reactions")) {
                        iArr[5] = TopReactionsParser.m17159a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_acts_as_person")) {
                        iArr[6] = ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_feedback_reaction_key")) {
                        zArr[2] = true;
                        iArr2[0] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[2]) {
                flatBufferBuilder.a(7, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: android_place_picker_long_press */
    public final class ViewerReactionsFeedbackFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class SupportedReactionsParser {
            public static int m17168b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("key")) {
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

            public static int m17165a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m17168b(jsonParser, flatBufferBuilder)));
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

            public static void m17167a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m17166a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m17166a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("key");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m17169a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[2];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_react")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("display_reactions")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("important_reactors")) {
                        iArr[2] = ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("supported_reactions")) {
                        iArr[3] = SupportedReactionsParser.m17165a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_acts_as_person")) {
                        iArr[4] = ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_feedback_reaction_key")) {
                        zArr[2] = true;
                        iArr2[0] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(6);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: android_place_picker_long_press */
    public final class ViewerReactionsMutationFragmentParser {

        /* compiled from: android_place_picker_long_press */
        public final class FeedbackParser {

            /* compiled from: android_place_picker_long_press */
            public final class LikersParser {
                public static int m17170a(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                    r6 = 1;
                    r5 = 0;
                    r0 = new boolean[r6];
                    r1 = new int[r6];
                L_0x0006:
                    r2 = r7.c();
                    r3 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r2 == r3) goto L_0x0034;
                L_0x000e:
                    r2 = r7.i();
                    r7.c();
                    r3 = r7.g();
                    r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r3 == r4) goto L_0x0006;
                L_0x001d:
                    if (r2 == 0) goto L_0x0006;
                L_0x001f:
                    r3 = "count";
                    r2 = r2.equals(r3);
                    if (r2 == 0) goto L_0x0030;
                L_0x0027:
                    r0[r5] = r6;
                    r2 = r7.E();
                    r1[r5] = r2;
                    goto L_0x0006;
                L_0x0030:
                    r7.f();
                    goto L_0x0006;
                L_0x0034:
                    r8.c(r6);
                    r0 = r0[r5];
                    if (r0 == 0) goto L_0x0040;
                L_0x003b:
                    r0 = r1[r5];
                    r8.a(r5, r0, r5);
                L_0x0040:
                    r0 = r8.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.LikersParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m17171a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
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
                    r0 = 0;
                    r4.f();
                    r0 = r2.a(r3, r0, r0);
                    if (r0 == 0) goto L_0x0012;
                L_0x000a:
                    r1 = "count";
                    r4.a(r1);
                    r4.b(r0);
                L_0x0012:
                    r4.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.LikersParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                }
            }

            /* compiled from: android_place_picker_long_press */
            public final class ReactorsParser {
                public static int m17172a(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                    r6 = 1;
                    r5 = 0;
                    r0 = new boolean[r6];
                    r1 = new int[r6];
                L_0x0006:
                    r2 = r7.c();
                    r3 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r2 == r3) goto L_0x0034;
                L_0x000e:
                    r2 = r7.i();
                    r7.c();
                    r3 = r7.g();
                    r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r3 == r4) goto L_0x0006;
                L_0x001d:
                    if (r2 == 0) goto L_0x0006;
                L_0x001f:
                    r3 = "count";
                    r2 = r2.equals(r3);
                    if (r2 == 0) goto L_0x0030;
                L_0x0027:
                    r0[r5] = r6;
                    r2 = r7.E();
                    r1[r5] = r2;
                    goto L_0x0006;
                L_0x0030:
                    r7.f();
                    goto L_0x0006;
                L_0x0034:
                    r8.c(r6);
                    r0 = r0[r5];
                    if (r0 == 0) goto L_0x0040;
                L_0x003b:
                    r0 = r1[r5];
                    r8.a(r5, r0, r5);
                L_0x0040:
                    r0 = r8.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ReactorsParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m17173a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
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
                    r0 = 0;
                    r4.f();
                    r0 = r2.a(r3, r0, r0);
                    if (r0 == 0) goto L_0x0012;
                L_0x000a:
                    r1 = "count";
                    r4.a(r1);
                    r4.b(r0);
                L_0x0012:
                    r4.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ReactorsParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                }
            }

            /* compiled from: android_place_picker_long_press */
            public final class ViewerFeedbackReactionParser {
                public static int m17174a(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                    r6 = 1;
                    r5 = 0;
                    r0 = new boolean[r6];
                    r1 = new int[r6];
                L_0x0006:
                    r2 = r7.c();
                    r3 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                    if (r2 == r3) goto L_0x0034;
                L_0x000e:
                    r2 = r7.i();
                    r7.c();
                    r3 = r7.g();
                    r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r3 == r4) goto L_0x0006;
                L_0x001d:
                    if (r2 == 0) goto L_0x0006;
                L_0x001f:
                    r3 = "key";
                    r2 = r2.equals(r3);
                    if (r2 == 0) goto L_0x0030;
                L_0x0027:
                    r0[r5] = r6;
                    r2 = r7.E();
                    r1[r5] = r2;
                    goto L_0x0006;
                L_0x0030:
                    r7.f();
                    goto L_0x0006;
                L_0x0034:
                    r8.c(r6);
                    r0 = r0[r5];
                    if (r0 == 0) goto L_0x0040;
                L_0x003b:
                    r0 = r1[r5];
                    r8.a(r5, r0, r5);
                L_0x0040:
                    r0 = r8.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ViewerFeedbackReactionParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m17175a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
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
                    r0 = 0;
                    r4.f();
                    r0 = r2.a(r3, r0, r0);
                    if (r0 == 0) goto L_0x0012;
                L_0x000a:
                    r1 = "key";
                    r4.a(r1);
                    r4.b(r0);
                L_0x0012:
                    r4.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ViewerFeedbackReactionParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                }
            }

            public static int m17176a(com.fasterxml.jackson.core.JsonParser r11, com.facebook.flatbuffers.FlatBufferBuilder r12) {
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
                r10 = 4;
                r9 = 3;
                r8 = 2;
                r7 = 1;
                r6 = 0;
                r0 = 9;
                r0 = new int[r0];
                r1 = new boolean[r7];
                r2 = new int[r7];
            L_0x000d:
                r3 = r11.c();
                r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                if (r3 == r4) goto L_0x00c2;
            L_0x0015:
                r3 = r11.i();
                r11.c();
                r4 = r11.g();
                r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                if (r4 == r5) goto L_0x000d;
            L_0x0024:
                if (r3 == 0) goto L_0x000d;
            L_0x0026:
                r4 = "id";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0039;
            L_0x002e:
                r3 = r11.o();
                r3 = r12.b(r3);
                r0[r6] = r3;
                goto L_0x000d;
            L_0x0039:
                r4 = "important_reactors";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0048;
            L_0x0041:
                r3 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser.m17181a(r11, r12);
                r0[r7] = r3;
                goto L_0x000d;
            L_0x0048:
                r4 = "legacy_api_post_id";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x005b;
            L_0x0050:
                r3 = r11.o();
                r3 = r12.b(r3);
                r0[r8] = r3;
                goto L_0x000d;
            L_0x005b:
                r4 = "likers";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x006a;
            L_0x0063:
                r3 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.LikersParser.m17170a(r11, r12);
                r0[r9] = r3;
                goto L_0x000d;
            L_0x006a:
                r4 = "reactors";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0079;
            L_0x0072:
                r3 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ReactorsParser.m17172a(r11, r12);
                r0[r10] = r3;
                goto L_0x000d;
            L_0x0079:
                r4 = "top_reactions";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x0089;
            L_0x0081:
                r3 = 5;
                r4 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.m17159a(r11, r12);
                r0[r3] = r4;
                goto L_0x000d;
            L_0x0089:
                r4 = "viewer_acts_as_person";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x009a;
            L_0x0091:
                r3 = 6;
                r4 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ViewerActsAsPersonParser.m17183a(r11, r12);
                r0[r3] = r4;
                goto L_0x000d;
            L_0x009a:
                r4 = "viewer_feedback_reaction";
                r4 = r3.equals(r4);
                if (r4 == 0) goto L_0x00ab;
            L_0x00a2:
                r3 = 7;
                r4 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ViewerFeedbackReactionParser.m17174a(r11, r12);
                r0[r3] = r4;
                goto L_0x000d;
            L_0x00ab:
                r4 = "viewer_feedback_reaction_key";
                r3 = r3.equals(r4);
                if (r3 == 0) goto L_0x00bd;
            L_0x00b3:
                r1[r6] = r7;
                r3 = r11.E();
                r2[r6] = r3;
                goto L_0x000d;
            L_0x00bd:
                r11.f();
                goto L_0x000d;
            L_0x00c2:
                r3 = 9;
                r12.c(r3);
                r3 = r0[r6];
                r12.b(r6, r3);
                r3 = r0[r7];
                r12.b(r7, r3);
                r3 = r0[r8];
                r12.b(r8, r3);
                r3 = r0[r9];
                r12.b(r9, r3);
                r3 = r0[r10];
                r12.b(r10, r3);
                r3 = 5;
                r4 = 5;
                r4 = r0[r4];
                r12.b(r3, r4);
                r3 = 6;
                r4 = 6;
                r4 = r0[r4];
                r12.b(r3, r4);
                r3 = 7;
                r4 = 7;
                r0 = r0[r4];
                r12.b(r3, r0);
                r0 = r1[r6];
                if (r0 == 0) goto L_0x0100;
            L_0x00f9:
                r0 = 8;
                r1 = r2[r6];
                r12.a(r0, r1, r6);
            L_0x0100:
                r0 = r12.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m17177a(com.facebook.flatbuffers.MutableFlatBuffer r4, int r5, com.fasterxml.jackson.core.JsonGenerator r6, com.fasterxml.jackson.databind.SerializerProvider r7) {
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
                r3 = 2;
                r2 = 0;
                r6.f();
                r0 = r4.g(r5, r2);
                if (r0 == 0) goto L_0x0017;
            L_0x000b:
                r0 = "id";
                r6.a(r0);
                r0 = r4.c(r5, r2);
                r6.b(r0);
            L_0x0017:
                r0 = 1;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0026;
            L_0x001e:
                r1 = "important_reactors";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser.m17182a(r4, r0, r6, r7);
            L_0x0026:
                r0 = r4.g(r5, r3);
                if (r0 == 0) goto L_0x0038;
            L_0x002c:
                r0 = "legacy_api_post_id";
                r6.a(r0);
                r0 = r4.c(r5, r3);
                r6.b(r0);
            L_0x0038:
                r0 = 3;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0047;
            L_0x003f:
                r1 = "likers";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.LikersParser.m17171a(r4, r0, r6);
            L_0x0047:
                r0 = 4;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0056;
            L_0x004e:
                r1 = "reactors";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ReactorsParser.m17173a(r4, r0, r6);
            L_0x0056:
                r0 = 5;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0065;
            L_0x005d:
                r1 = "top_reactions";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.m17160a(r4, r0, r6, r7);
            L_0x0065:
                r0 = 6;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0074;
            L_0x006c:
                r1 = "viewer_acts_as_person";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ViewerActsAsPersonParser.m17184a(r4, r0, r6);
            L_0x0074:
                r0 = 7;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0083;
            L_0x007b:
                r1 = "viewer_feedback_reaction";
                r6.a(r1);
                com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ViewerFeedbackReactionParser.m17175a(r4, r0, r6);
            L_0x0083:
                r0 = 8;
                r0 = r4.a(r5, r0, r2);
                if (r0 == 0) goto L_0x0093;
            L_0x008b:
                r1 = "viewer_feedback_reaction_key";
                r6.a(r1);
                r6.b(r0);
            L_0x0093:
                r6.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        public static com.facebook.flatbuffers.MutableFlatBuffer m17178a(com.fasterxml.jackson.core.JsonParser r12) {
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
            r11 = 1;
            r10 = 0;
            r6 = new int[r11];
        L_0x000d:
            r7 = r12.c();
            r8 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
            if (r7 == r8) goto L_0x0039;
        L_0x0015:
            r7 = r12.i();
            r12.c();
            r8 = r12.g();
            r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
            if (r8 == r9) goto L_0x000d;
        L_0x0024:
            if (r7 == 0) goto L_0x000d;
        L_0x0026:
            r8 = "feedback";
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x0035;
        L_0x002e:
            r7 = com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.m17176a(r12, r0);
            r6[r10] = r7;
            goto L_0x000d;
        L_0x0035:
            r12.f();
            goto L_0x000d;
        L_0x0039:
            r0.c(r11);
            r6 = r6[r10];
            r0.b(r10, r6);
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.a(com.fasterxml.jackson.core.JsonParser):com.facebook.flatbuffers.MutableFlatBuffer");
        }
    }

    /* compiled from: android_place_picker_long_press */
    public final class ViewerReactionsSocialFeedbackFieldsParser {

        /* compiled from: android_place_picker_long_press */
        public final class ImportantReactorsParser {

            /* compiled from: android_place_picker_long_press */
            public final class NodesParser {
                public static int m17180b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("name")) {
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

                public static void m17179a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m17181a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m17180b(jsonParser, flatBufferBuilder)));
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

            public static void m17182a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m17179a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: android_place_picker_long_press */
        public final class ViewerActsAsPersonParser {
            public static int m17183a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("name")) {
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

            public static void m17184a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m17185a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("important_reactors")) {
                        iArr[0] = ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_acts_as_person")) {
                        iArr[1] = ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
