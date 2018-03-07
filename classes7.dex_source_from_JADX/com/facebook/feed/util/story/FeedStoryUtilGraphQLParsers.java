package com.facebook.feed.util.story;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: TPREFETCH_DATA_TYPE; */
public class FeedStoryUtilGraphQLParsers {

    /* compiled from: TPREFETCH_DATA_TYPE; */
    public final class IsPopularObjectsStoryGraphQLParser {

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class AttachmentsParser {
            public static int m25184b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("style_list")) {
                            iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static int m25181a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m25184b(jsonParser, flatBufferBuilder)));
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

            public static void m25183a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m25182a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m25182a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m25185a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("attachments")) {
                        iArr[0] = AttachmentsParser.m25181a(jsonParser, flatBufferBuilder);
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

    /* compiled from: TPREFETCH_DATA_TYPE; */
    public final class ShouldDisplayProfilePictureGraphQLParser {

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class ActorsParser {

            /* compiled from: TPREFETCH_DATA_TYPE; */
            public final class ProfileBadgeParser {

                /* compiled from: TPREFETCH_DATA_TYPE; */
                public final class BadgeIconParser {

                    /* compiled from: TPREFETCH_DATA_TYPE; */
                    public final class ImageParser {
                        public static int m25186a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                            /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.ImageParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public static void m25187a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                            /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.ImageParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                        }
                    }

                    public static int m25188a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        if (r1 == r2) goto L_0x0030;
                    L_0x000c:
                        r1 = r6.i();
                        r6.c();
                        r2 = r6.g();
                        r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                        if (r2 == r3) goto L_0x0004;
                    L_0x001b:
                        if (r1 == 0) goto L_0x0004;
                    L_0x001d:
                        r2 = "image";
                        r1 = r1.equals(r2);
                        if (r1 == 0) goto L_0x002c;
                    L_0x0025:
                        r1 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.ImageParser.m25186a(r6, r7);
                        r0[r4] = r1;
                        goto L_0x0004;
                    L_0x002c:
                        r6.f();
                        goto L_0x0004;
                    L_0x0030:
                        r7.c(r5);
                        r0 = r0[r4];
                        r7.b(r4, r0);
                        r0 = r7.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public static void m25189a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4, com.fasterxml.jackson.databind.SerializerProvider r5) {
                        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r4.f();
                        r0 = 0;
                        r0 = r2.g(r3, r0);
                        if (r0 == 0) goto L_0x0012;
                    L_0x000a:
                        r1 = "image";
                        r4.a(r1);
                        com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.ImageParser.m25187a(r2, r0, r4);
                    L_0x0012:
                        r4.g();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }
                }

                public static int m25190a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    if (r1 == r2) goto L_0x0030;
                L_0x000c:
                    r1 = r6.i();
                    r6.c();
                    r2 = r6.g();
                    r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                    if (r2 == r3) goto L_0x0004;
                L_0x001b:
                    if (r1 == 0) goto L_0x0004;
                L_0x001d:
                    r2 = "badge_icon";
                    r1 = r1.equals(r2);
                    if (r1 == 0) goto L_0x002c;
                L_0x0025:
                    r1 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.m25188a(r6, r7);
                    r0[r4] = r1;
                    goto L_0x0004;
                L_0x002c:
                    r6.f();
                    goto L_0x0004;
                L_0x0030:
                    r7.c(r5);
                    r0 = r0[r4];
                    r7.b(r4, r0);
                    r0 = r7.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m25191a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4, com.fasterxml.jackson.databind.SerializerProvider r5) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    r4.f();
                    r0 = 0;
                    r0 = r2.g(r3, r0);
                    if (r0 == 0) goto L_0x0012;
                L_0x000a:
                    r1 = "badge_icon";
                    r4.a(r1);
                    com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.m25189a(r2, r0, r4, r5);
                L_0x0012:
                    r4.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }
            }

            /* compiled from: TPREFETCH_DATA_TYPE; */
            public final class ProfilePictureParser {
                public static int m25192a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfilePictureParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m25193a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfilePictureParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
                }
            }

            public static int m25195b(com.fasterxml.jackson.core.JsonParser r9, com.facebook.flatbuffers.FlatBufferBuilder r10) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r0 = new int[r8];
            L_0x0007:
                r1 = r9.c();
                r2 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
                if (r1 == r2) goto L_0x0068;
            L_0x000f:
                r1 = r9.i();
                r9.c();
                r2 = r9.g();
                r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
                if (r2 == r3) goto L_0x0007;
            L_0x001e:
                if (r1 == 0) goto L_0x0007;
            L_0x0020:
                r2 = "__type__";
                r2 = r1.equals(r2);
                if (r2 == 0) goto L_0x0033;
            L_0x0028:
                r1 = com.facebook.graphql.enums.GraphQLObjectType.a(r9);
                r1 = r10.a(r1);
                r0[r4] = r1;
                goto L_0x0007;
            L_0x0033:
                r2 = "id";
                r2 = r1.equals(r2);
                if (r2 == 0) goto L_0x0046;
            L_0x003b:
                r1 = r9.o();
                r1 = r10.b(r1);
                r0[r5] = r1;
                goto L_0x0007;
            L_0x0046:
                r2 = "profile_badge";
                r2 = r1.equals(r2);
                if (r2 == 0) goto L_0x0055;
            L_0x004e:
                r1 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.m25190a(r9, r10);
                r0[r6] = r1;
                goto L_0x0007;
            L_0x0055:
                r2 = "profile_picture";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x0064;
            L_0x005d:
                r1 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfilePictureParser.m25192a(r9, r10);
                r0[r7] = r1;
                goto L_0x0007;
            L_0x0064:
                r9.f();
                goto L_0x0007;
            L_0x0068:
                r10.c(r8);
                r1 = r0[r4];
                r10.b(r4, r1);
                r1 = r0[r5];
                r10.b(r5, r1);
                r1 = r0[r6];
                r10.b(r6, r1);
                r0 = r0[r7];
                r10.b(r7, r0);
                r0 = r10.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static int m25194a(com.fasterxml.jackson.core.JsonParser r4, com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r1 = m25195b(r4, r5);
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m25196b(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, com.fasterxml.jackson.core.JsonGenerator r5, com.fasterxml.jackson.databind.SerializerProvider r6) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r2 = 1;
                r1 = 0;
                r5.f();
                r0 = r3.g(r4, r1);
                if (r0 == 0) goto L_0x0013;
            L_0x000b:
                r0 = "__type__";
                r5.a(r0);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r3, r4, r1, r5);
            L_0x0013:
                r0 = r3.g(r4, r2);
                if (r0 == 0) goto L_0x0025;
            L_0x0019:
                r0 = "id";
                r5.a(r0);
                r0 = r3.c(r4, r2);
                r5.b(r0);
            L_0x0025:
                r0 = 2;
                r0 = r3.g(r4, r0);
                if (r0 == 0) goto L_0x0034;
            L_0x002c:
                r1 = "profile_badge";
                r5.a(r1);
                com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.m25191a(r3, r0, r5, r6);
            L_0x0034:
                r0 = 3;
                r0 = r3.g(r4, r0);
                if (r0 == 0) goto L_0x0043;
            L_0x003b:
                r1 = "profile_picture";
                r5.a(r1);
                com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfilePictureParser.m25193a(r3, r0, r5);
            L_0x0043:
                r5.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class AllSubstoriesParser {

            /* compiled from: TPREFETCH_DATA_TYPE; */
            public final class NodesParser {
                public static int m25197b(com.fasterxml.jackson.core.JsonParser r7, com.facebook.flatbuffers.FlatBufferBuilder r8) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    r2 = "attachments";
                    r2 = r1.equals(r2);
                    if (r2 == 0) goto L_0x002d;
                L_0x0026:
                    r1 = com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser.NodesParser.AttachmentsParser.a(r7, r8);
                    r0[r4] = r1;
                    goto L_0x0005;
                L_0x002d:
                    r2 = "id";
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.NodesParser.b(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public static void m25198b(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, com.fasterxml.jackson.core.JsonGenerator r5, com.fasterxml.jackson.databind.SerializerProvider r6) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    r2 = 1;
                    r5.f();
                    r0 = 0;
                    r0 = r3.g(r4, r0);
                    if (r0 == 0) goto L_0x0013;
                L_0x000b:
                    r1 = "attachments";
                    r5.a(r1);
                    com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser.NodesParser.AttachmentsParser.a(r3, r0, r5, r6);
                L_0x0013:
                    r0 = r3.g(r4, r2);
                    if (r0 == 0) goto L_0x0025;
                L_0x0019:
                    r0 = "id";
                    r5.a(r0);
                    r0 = r3.c(r4, r2);
                    r5.b(r0);
                L_0x0025:
                    r5.g();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.NodesParser.b(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }
            }

            public static int m25199a(com.fasterxml.jackson.core.JsonParser r10, com.facebook.flatbuffers.FlatBufferBuilder r11) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r2 = "nodes";
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
                r7 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.NodesParser.m25197b(r10, r11);
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m25200a(com.facebook.flatbuffers.MutableFlatBuffer r4, int r5, com.fasterxml.jackson.core.JsonGenerator r6, com.fasterxml.jackson.databind.SerializerProvider r7) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r6.f();
                r0 = 0;
                r0 = r4.g(r5, r0);
                if (r0 == 0) goto L_0x0026;
            L_0x000a:
                r1 = "nodes";
                r6.a(r1);
                r6.d();
                r2 = 0;
            L_0x0013:
                r3 = r4.c(r0);
                if (r2 >= r3) goto L_0x0023;
            L_0x0019:
                r3 = r4.m(r0, r2);
                com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.NodesParser.m25198b(r4, r3, r6, r7);
                r2 = r2 + 1;
                goto L_0x0013;
            L_0x0023:
                r6.e();
            L_0x0026:
                r6.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }
        }

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class AttachedStoryParser {
            public static int m25201a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r2 = "id";
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AttachedStoryParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m25202a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r1 = 0;
                r4.f();
                r0 = r2.g(r3, r1);
                if (r0 == 0) goto L_0x0016;
            L_0x000a:
                r0 = "id";
                r4.a(r0);
                r0 = r2.c(r3, r1);
                r4.b(r0);
            L_0x0016:
                r4.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AttachedStoryParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
            }
        }

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class FeedbackParser {
            public static int m25203a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r2 = "id";
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.FeedbackParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m25204a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r1 = 0;
                r4.f();
                r0 = r2.g(r3, r1);
                if (r0 == 0) goto L_0x0016;
            L_0x000a:
                r0 = "id";
                r4.a(r0);
                r0 = r2.c(r3, r1);
                r4.b(r0);
            L_0x0016:
                r4.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.FeedbackParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
            }
        }

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class MessageParser {
            public static int m25205a(com.fasterxml.jackson.core.JsonParser r6, com.facebook.flatbuffers.FlatBufferBuilder r7) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r2 = "text";
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.MessageParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public static void m25206a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, com.fasterxml.jackson.core.JsonGenerator r4) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
	at jadx.core.dex.nodes.BlockNode.addDominatesOn(BlockNode.java:166)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:135)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                r1 = 0;
                r4.f();
                r0 = r2.g(r3, r1);
                if (r0 == 0) goto L_0x0016;
            L_0x000a:
                r0 = "text";
                r4.a(r0);
                r0 = r2.c(r3, r1);
                r4.b(r0);
            L_0x0016:
                r4.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.MessageParser.a(com.facebook.flatbuffers.MutableFlatBuffer, int, com.fasterxml.jackson.core.JsonGenerator):void");
            }
        }

        public static int m25207a(com.fasterxml.jackson.core.JsonParser r11, com.facebook.flatbuffers.FlatBufferBuilder r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.splitBasicBlocks(BlockSplitter.java:55)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:44)
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
            r0 = 7;
            r0 = new int[r0];
            r1 = new boolean[r7];
            r2 = new boolean[r7];
        L_0x000c:
            r3 = r11.c();
            r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT;
            if (r3 == r4) goto L_0x0097;
        L_0x0014:
            r3 = r11.i();
            r11.c();
            r4 = r11.g();
            r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
            if (r4 == r5) goto L_0x000c;
        L_0x0023:
            if (r3 == 0) goto L_0x000c;
        L_0x0025:
            r4 = "actors";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0034;
        L_0x002d:
            r3 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.m25194a(r11, r12);
            r0[r6] = r3;
            goto L_0x000c;
        L_0x0034:
            r4 = "all_substories";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0043;
        L_0x003c:
            r3 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser.m25199a(r11, r12);
            r0[r7] = r3;
            goto L_0x000c;
        L_0x0043:
            r4 = "attached_story";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0052;
        L_0x004b:
            r3 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AttachedStoryParser.m25201a(r11, r12);
            r0[r8] = r3;
            goto L_0x000c;
        L_0x0052:
            r4 = "attachments";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0061;
        L_0x005a:
            r3 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.IsPopularObjectsStoryGraphQLParser.AttachmentsParser.m25181a(r11, r12);
            r0[r9] = r3;
            goto L_0x000c;
        L_0x0061:
            r4 = "feedback";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0070;
        L_0x0069:
            r3 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.FeedbackParser.m25203a(r11, r12);
            r0[r10] = r3;
            goto L_0x000c;
        L_0x0070:
            r4 = "has_comprehensive_title";
            r4 = r3.equals(r4);
            if (r4 == 0) goto L_0x0081;
        L_0x0078:
            r1[r6] = r7;
            r3 = r11.H();
            r2[r6] = r3;
            goto L_0x000c;
        L_0x0081:
            r4 = "message";
            r3 = r3.equals(r4);
            if (r3 == 0) goto L_0x0092;
        L_0x0089:
            r3 = 6;
            r4 = com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.MessageParser.m25205a(r11, r12);
            r0[r3] = r4;
            goto L_0x000c;
        L_0x0092:
            r11.f();
            goto L_0x000c;
        L_0x0097:
            r3 = 7;
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
            r1 = r1[r6];
            if (r1 == 0) goto L_0x00be;
        L_0x00b8:
            r1 = 5;
            r2 = r2[r6];
            r12.a(r1, r2);
        L_0x00be:
            r1 = 6;
            r2 = 6;
            r0 = r0[r2];
            r12.b(r1, r0);
            r0 = r12.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.a(com.fasterxml.jackson.core.JsonParser, com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    /* compiled from: TPREFETCH_DATA_TYPE; */
    public final class ShouldRenderOrganicHScrollGraphQLParser {

        /* compiled from: TPREFETCH_DATA_TYPE; */
        public final class AllSubstoriesParser {

            /* compiled from: TPREFETCH_DATA_TYPE; */
            public final class NodesParser {

                /* compiled from: TPREFETCH_DATA_TYPE; */
                public final class AttachmentsParser {

                    /* compiled from: TPREFETCH_DATA_TYPE; */
                    public final class TargetParser {
                        public static int m25208a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("__type__")) {
                                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
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

                        public static void m25209a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("__type__");
                                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m25210b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("target")) {
                                    iArr[0] = TargetParser.m25208a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m25211b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("target");
                            TargetParser.m25209a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m25212b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("attachments")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(AttachmentsParser.m25210b(jsonParser, flatBufferBuilder)));
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

                public static void m25213b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("attachments");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            AttachmentsParser.m25211b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m25214a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                        } else if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(NodesParser.m25212b(jsonParser, flatBufferBuilder)));
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

            public static void m25215a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        NodesParser.m25213b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m25216a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_substories")) {
                        iArr[0] = AllSubstoriesParser.m25214a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("substories_grouping_reasons")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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
