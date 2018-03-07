package com.facebook.groups.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.GroupForsaleAvailableStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedMallIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedMallIdsParser.GroupFeedParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedMallIdsParser.GroupFeedParser.NodesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedNotForSalePostIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedNotForSalePostIdsParser.GroupNotForsaleStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedPendingPostIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedPendingPostIdsParser.GroupPendingStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedPinnedPostIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedPinnedPostIdsParser.GroupPinnedStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedReportedPostIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedReportedPostIdsParser.GroupReportedStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsStoriesMallIdsParser;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsStoriesMallIdsParser.GroupStoriesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: query_count */
public class FetchGroupsFeedIdsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2002972436)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedAuthoredAvailableForSalePostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupOwnerAuthoredStoriesModel f5624d;
        @Nullable
        private String f5625e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.Deserializer.<init>():void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6537a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r5 = this;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.m6762a(r6);
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 505772315)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupOwnerAuthoredStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5623d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6538a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6760a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5622d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6539a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6759b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6540a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r7 = this;
                        r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6541a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6758a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.<init>():void");
                }

                public final void m6544a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m6545a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6546b() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r2 = this;
                    r0 = r2.f5622d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f5622d = r0;
                    r0 = r2.f5622d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6543a() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = r1.m6546b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6542a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6541a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r2 = this;
                    r2.h();
                    r0 = r2.m6546b();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupOwnerAuthoredStoriesModel> {
                public final void m6547a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r7 = this;
                    r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6548a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6761a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.<clinit>():void");
                }
            }

            public GroupOwnerAuthoredStoriesModel() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel> m6550a() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r3 = this;
                r0 = r3.f5623d;
                r1 = 0;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f5623d = r0;
                r0 = r3.f5623d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r1 = this;
                r0 = -2125813741; // 0xffffffff814aa813 float:-3.7222128E-38 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6549a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m6550a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m6550a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
                r1 = r1.b();
                r0.f5623d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6548a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r2 = this;
                r2.h();
                r0 = r2.m6550a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedAuthoredAvailableForSalePostIdsModel> {
            public final void m6551a(java.lang.Object r10, com.fasterxml.jackson.core.JsonGenerator r11, com.fasterxml.jackson.databind.SerializerProvider r12) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r9 = this;
                r10 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel) r10;
                r2 = 0;
                r0 = r10.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r10.m6553a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r10.a(r0, r1);
            L_0x0035:
                r0 = r10.w_();
                r1 = r10.u_();
                r8 = 1;
                r11.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0050;
            L_0x0048:
                r7 = "group_owner_authored_stories";
                r11.a(r7);
                com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredAvailableForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6761a(r0, r6, r11, r12);
            L_0x0050:
                r6 = r0.g(r1, r8);
                if (r6 == 0) goto L_0x0062;
            L_0x0056:
                r6 = "id";
                r11.a(r6);
                r6 = r0.c(r1, r8);
                r11.b(r6);
            L_0x0062:
                r11.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.Serializer.<clinit>():void");
            }
        }

        public FetchGroupsFeedAuthoredAvailableForSalePostIdsModel() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.<init>():void");
        }

        public final void m6556a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m6557a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel m6558j() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r0 = r3.f5624d;
            r1 = 0;
            r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r3.f5624d = r0;
            r0 = r3.f5624d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.j():com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredAvailableForSalePostIdsModel$GroupOwnerAuthoredStoriesModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m6552k() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r2 = this;
            r0 = r2.f5625e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f5625e = r0;
            r0 = r2.f5625e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.k():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m6555a() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = r1.m6552k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6554a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m6558j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m6558j();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r2 = r3.m6558j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel) r1;
            r1.f5624d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m6553a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r3.h();
            r0 = r3.m6558j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m6552k();
            r1 = r4.b(r1);
            r2 = 2;
            r4.c(r2);
            r2 = 0;
            r4.b(r2, r0);
            r0 = 1;
            r4.b(r0, r1);
            r3.i();
            r0 = r4.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1445152079)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedAuthoredExpiredForSalePostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupOwnerAuthoredStoriesModel f5628d;
        @Nullable
        private String f5629e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6559a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r5 = this;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.m6767a(r6);
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1331267762)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupOwnerAuthoredStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5627d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6560a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6765a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5626d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6561a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6764b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6562a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r7 = this;
                        r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6563a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6763a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
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
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.<init>():void");
                }

                public final void m6566a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m6567a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6568b() {
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
                    r2 = this;
                    r0 = r2.f5626d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f5626d = r0;
                    r0 = r2.f5626d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6565a() {
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
                    r1 = this;
                    r0 = r1.m6568b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a():java.lang.String");
                }

                public final int jK_() {
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
                    r1 = this;
                    r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6564a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6563a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2 = this;
                    r2.h();
                    r0 = r2.m6568b();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupOwnerAuthoredStoriesModel> {
                public final void m6569a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r7 = this;
                    r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6570a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6766a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.<clinit>():void");
                }
            }

            public GroupOwnerAuthoredStoriesModel() {
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
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel> m6572a() {
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
                r3 = this;
                r0 = r3.f5627d;
                r1 = 0;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f5627d = r0;
                r0 = r3.f5627d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel>");
            }

            public final int jK_() {
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
                r1 = this;
                r0 = -2125813741; // 0xffffffff814aa813 float:-3.7222128E-38 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6571a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m6572a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m6572a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
                r1 = r1.b();
                r0.f5627d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6570a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r2 = this;
                r2.h();
                r0 = r2.m6572a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedAuthoredExpiredForSalePostIdsModel> {
            public final void m6573a(java.lang.Object r10, com.fasterxml.jackson.core.JsonGenerator r11, com.fasterxml.jackson.databind.SerializerProvider r12) {
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
                r9 = this;
                r10 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel) r10;
                r2 = 0;
                r0 = r10.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r10.m6575a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r10.a(r0, r1);
            L_0x0035:
                r0 = r10.w_();
                r1 = r10.u_();
                r8 = 1;
                r11.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0050;
            L_0x0048:
                r7 = "group_owner_authored_stories";
                r11.a(r7);
                com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredExpiredForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6766a(r0, r6, r11, r12);
            L_0x0050:
                r6 = r0.g(r1, r8);
                if (r6 == 0) goto L_0x0062;
            L_0x0056:
                r6 = "id";
                r11.a(r6);
                r6 = r0.c(r1, r8);
                r11.b(r6);
            L_0x0062:
                r11.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.Serializer.<clinit>():void");
            }
        }

        public FetchGroupsFeedAuthoredExpiredForSalePostIdsModel() {
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
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.<init>():void");
        }

        public final void m6578a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m6579a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel m6580j() {
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
            r3 = this;
            r0 = r3.f5628d;
            r1 = 0;
            r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r3.f5628d = r0;
            r0 = r3.f5628d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.j():com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredExpiredForSalePostIdsModel$GroupOwnerAuthoredStoriesModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m6574k() {
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
            r2 = this;
            r0 = r2.f5629e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f5629e = r0;
            r0 = r2.f5629e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.k():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m6577a() {
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
            r1 = this;
            r0 = r1.m6574k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.a():java.lang.String");
        }

        public final int jK_() {
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
            r1 = this;
            r0 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6576a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m6580j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m6580j();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r2 = r3.m6580j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel) r1;
            r1.f5628d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m6575a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
            r3 = this;
            r3.h();
            r0 = r3.m6580j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m6574k();
            r1 = r4.b(r1);
            r2 = 2;
            r4.c(r2);
            r2 = 0;
            r4.b(r2, r0);
            r0 = 1;
            r4.b(r0, r1);
            r3.i();
            r0 = r4.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 488849578)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedAuthoredSoldForSalePostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupOwnerAuthoredStoriesModel f5632d;
        @Nullable
        private String f5633e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Deserializer.<init>():void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6581a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r5 = this;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.m6772a(r6);
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1712419710)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupOwnerAuthoredStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5631d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.<init>():void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6582a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6770a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5630d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.<init>():void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6583a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6769b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.<init>():void");
                    }

                    public final void m6584a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r7 = this;
                        r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6585a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.NodesParser.m6768a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.<init>():void");
                }

                public final void m6588a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m6589a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6590b() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r2 = this;
                    r0 = r2.f5630d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f5630d = r0;
                    r0 = r2.f5630d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6587a() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = r1.m6590b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r1 = this;
                    r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6586a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6585a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r2 = this;
                    r2.h();
                    r0 = r2.m6590b();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupOwnerAuthoredStoriesModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.<init>():void");
                }

                public final void m6591a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r7 = this;
                    r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6592a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6771a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.Serializer.<clinit>():void");
                }
            }

            public GroupOwnerAuthoredStoriesModel() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel> m6594a() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r3 = this;
                r0 = r3.f5631d;
                r1 = 0;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f5631d = r0;
                r0 = r3.f5631d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel$NodesModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r1 = this;
                r0 = -2125813741; // 0xffffffff814aa813 float:-3.7222128E-38 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6593a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m6594a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m6594a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
                r1 = r1.b();
                r0.f5631d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6592a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r2 = this;
                r2.h();
                r0 = r2.m6594a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedAuthoredSoldForSalePostIdsModel> {
            public Serializer() {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Serializer.<init>():void");
            }

            public final void m6595a(java.lang.Object r10, com.fasterxml.jackson.core.JsonGenerator r11, com.fasterxml.jackson.databind.SerializerProvider r12) {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r9 = this;
                r10 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel) r10;
                r2 = 0;
                r0 = r10.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r10.m6597a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r10.a(r0, r1);
            L_0x0035:
                r0 = r10.w_();
                r1 = r10.u_();
                r8 = 1;
                r11.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0050;
            L_0x0048:
                r7 = "group_owner_authored_stories";
                r11.a(r7);
                com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAuthoredSoldForSalePostIdsParser.GroupOwnerAuthoredStoriesParser.m6771a(r0, r6, r11, r12);
            L_0x0050:
                r6 = r0.g(r1, r8);
                if (r6 == 0) goto L_0x0062;
            L_0x0056:
                r6 = "id";
                r11.a(r6);
                r6 = r0.c(r1, r8);
                r11.b(r6);
            L_0x0062:
                r11.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.Serializer.<clinit>():void");
            }
        }

        public FetchGroupsFeedAuthoredSoldForSalePostIdsModel() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.<init>():void");
        }

        public final void m6600a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m6601a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel m6602j() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r0 = r3.f5632d;
            r1 = 0;
            r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r3.f5632d = r0;
            r0 = r3.f5632d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.j():com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAuthoredSoldForSalePostIdsModel$GroupOwnerAuthoredStoriesModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m6596k() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r2 = this;
            r0 = r2.f5633e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f5633e = r0;
            r0 = r2.f5633e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.k():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m6599a() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = r1.m6596k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r1 = this;
            r0 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6598a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m6602j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m6602j();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel) r0;
            r2 = r3.m6602j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel) r1;
            r1.f5632d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m6597a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: java.lang.ClassCastException: java.util.Collections$UnmodifiableRandomAccessList cannot be cast to java.util.ArrayList
	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:407)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:37)
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
            r3 = this;
            r3.h();
            r0 = r3.m6602j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m6596k();
            r1 = r4.b(r1);
            r2 = 2;
            r4.c(r2);
            r2 = 0;
            r4.b(r2, r0);
            r0 = 1;
            r4.b(r0, r1);
            r3.i();
            r0 = r4.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1907842508)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedAvailableForSalePostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupForsaleAvailableStoriesModel f5636d;
        @Nullable
        private String f5637e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
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
                r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.class;
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6603a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r5 = this;
                r2 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.m6777a(r6);
                r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1250570316)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupForsaleAvailableStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5635d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6604a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.GroupForsaleAvailableStoriesParser.m6775a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5634d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6605a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.GroupForsaleAvailableStoriesParser.NodesParser.m6774b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel$NodesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6606a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r7 = this;
                        r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6607a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.GroupForsaleAvailableStoriesParser.NodesParser.m6773a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
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
                        r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.class;
                        r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
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
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.<init>():void");
                }

                public final void m6610a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m6611a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6612b() {
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
                    r2 = this;
                    r0 = r2.f5634d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f5634d = r0;
                    r0 = r2.f5634d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6609a() {
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
                    r1 = this;
                    r0 = r1.m6612b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.a():java.lang.String");
                }

                public final int jK_() {
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
                    r1 = this;
                    r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6608a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6607a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2 = this;
                    r2.h();
                    r0 = r2.m6612b();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupForsaleAvailableStoriesModel> {
                public final void m6613a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r7 = this;
                    r8 = (com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6614a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.groups.feed.protocol.FetchGroupsFeedIdsParsers.FetchGroupsFeedAvailableForSalePostIdsParser.GroupForsaleAvailableStoriesParser.m6776a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
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
                    r0 = com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.class;
                    r1 = new com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels$FetchGroupsFeedAvailableForSalePostIdsModel$GroupForsaleAvailableStoriesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.Serializer.<clinit>():void");
                }
            }

            public GroupForsaleAvailableStoriesModel() {
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
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.<init>():void");
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6616a() {
                this.f5635d = super.a(this.f5635d, 0, NodesModel.class);
                return (ImmutableList) this.f5635d;
            }

            public final int jK_() {
                return -2074114567;
            }

            public final GraphQLVisitableModel m6615a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6616a() != null) {
                    Builder a = ModelHelper.a(m6616a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (GroupForsaleAvailableStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5635d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6614a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m6616a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedAvailableForSalePostIdsModel> {
            public final void m6617a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedAvailableForSalePostIdsModel fetchGroupsFeedAvailableForSalePostIdsModel = (FetchGroupsFeedAvailableForSalePostIdsModel) r10;
                if (fetchGroupsFeedAvailableForSalePostIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedAvailableForSalePostIdsModel.m6619a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedAvailableForSalePostIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedAvailableForSalePostIdsModel.w_();
                int u_ = fetchGroupsFeedAvailableForSalePostIdsModel.u_();
                r11.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    r11.a("group_forsale_available_stories");
                    GroupForsaleAvailableStoriesParser.m6776a(mutableFlatBuffer, g, r11, r12);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    r11.a("id");
                    r11.b(mutableFlatBuffer.c(u_, 1));
                }
                r11.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedAvailableForSalePostIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedAvailableForSalePostIdsModel() {
            super(2);
        }

        public final void m6622a(String str, ConsistencyTuple consistencyTuple) {
            r2.a();
        }

        public final void m6623a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupForsaleAvailableStoriesModel m6624j() {
            this.f5636d = (GroupForsaleAvailableStoriesModel) super.a(this.f5636d, 0, GroupForsaleAvailableStoriesModel.class);
            return this.f5636d;
        }

        @Nullable
        private String m6618k() {
            this.f5637e = super.a(this.f5637e, 1);
            return this.f5637e;
        }

        @Nullable
        public final String m6621a() {
            return m6618k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6620a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6624j() != null) {
                GroupForsaleAvailableStoriesModel groupForsaleAvailableStoriesModel = (GroupForsaleAvailableStoriesModel) r4.b(m6624j());
                if (m6624j() != groupForsaleAvailableStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsFeedAvailableForSalePostIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5636d = groupForsaleAvailableStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6619a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r4, m6624j());
            int b = r4.b(m6618k());
            r4.c(2);
            r4.b(0, a);
            r4.b(1, b);
            i();
            return r4.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 903102854)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedMallIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupFeedModel f5642d;
        @Nullable
        private String f5643e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsFeedMallIdsModel.class, new Deserializer());
            }

            public Object m6625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsFeedMallIdsParser.m6782a(jsonParser);
                Object fetchGroupsFeedMallIdsModel = new FetchGroupsFeedMallIdsModel();
                ((BaseModel) fetchGroupsFeedMallIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsFeedMallIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsFeedMallIdsModel).a();
                }
                return fetchGroupsFeedMallIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -806020)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupFeedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5641d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupFeedModel.class, new Deserializer());
                }

                public Object m6626a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupFeedParser.m6780a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupFeedModel = new GroupFeedModel();
                    ((BaseModel) groupFeedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupFeedModel instanceof Postprocessable) {
                        return ((Postprocessable) groupFeedModel).a();
                    }
                    return groupFeedModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -634746366)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f5638d;
                @Nullable
                private String f5639e;
                @Nullable
                private String f5640f;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6627a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m6779b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6628a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6632a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m6778a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                private GraphQLObjectType m6629j() {
                    if (this.b != null && this.f5638d == null) {
                        this.f5638d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5638d;
                }

                @Nullable
                private String m6630k() {
                    this.f5639e = super.a(this.f5639e, 1);
                    return this.f5639e;
                }

                @Nullable
                private String m6631l() {
                    this.f5640f = super.a(this.f5640f, 2);
                    return this.f5640f;
                }

                @Nullable
                public final String m6634a() {
                    return m6631l();
                }

                public final int jK_() {
                    return -127231902;
                }

                public final GraphQLVisitableModel m6633a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6632a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6629j());
                    int b = flatBufferBuilder.b(m6630k());
                    int b2 = flatBufferBuilder.b(m6631l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupFeedModel> {
                public final void m6635a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupFeedModel groupFeedModel = (GroupFeedModel) obj;
                    if (groupFeedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupFeedModel.m6637a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupFeedParser.m6781a(groupFeedModel.w_(), groupFeedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupFeedModel.class, new Serializer());
                }
            }

            public GroupFeedModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m6636a() {
                this.f5641d = super.a(this.f5641d, 0, NodesModel.class);
                return (ImmutableList) this.f5641d;
            }

            public final int jK_() {
                return 1273041755;
            }

            public final GraphQLVisitableModel m6638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6636a() != null) {
                    Builder a = ModelHelper.a(m6636a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupFeedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5641d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6637a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6636a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedMallIdsModel> {
            public final void m6639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedMallIdsModel fetchGroupsFeedMallIdsModel = (FetchGroupsFeedMallIdsModel) obj;
                if (fetchGroupsFeedMallIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedMallIdsModel.m6642a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedMallIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedMallIdsModel.w_();
                int u_ = fetchGroupsFeedMallIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_feed");
                    GroupFeedParser.m6781a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedMallIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedMallIdsModel() {
            super(2);
        }

        public final void m6645a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6646a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupFeedModel m6640j() {
            this.f5642d = (GroupFeedModel) super.a(this.f5642d, 0, GroupFeedModel.class);
            return this.f5642d;
        }

        @Nullable
        private String m6641k() {
            this.f5643e = super.a(this.f5643e, 1);
            return this.f5643e;
        }

        @Nullable
        public final String m6644a() {
            return m6641k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6643a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6640j() != null) {
                GroupFeedModel groupFeedModel = (GroupFeedModel) graphQLModelMutatingVisitor.b(m6640j());
                if (m6640j() != groupFeedModel) {
                    graphQLVisitableModel = (FetchGroupsFeedMallIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5642d = groupFeedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6642a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6640j());
            int b = flatBufferBuilder.b(m6641k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1334542707)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedNotForSalePostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupNotForsaleStoriesModel f5646d;
        @Nullable
        private String f5647e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsFeedNotForSalePostIdsModel.class, new Deserializer());
            }

            public Object m6647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsFeedNotForSalePostIdsParser.m6787a(jsonParser);
                Object fetchGroupsFeedNotForSalePostIdsModel = new FetchGroupsFeedNotForSalePostIdsModel();
                ((BaseModel) fetchGroupsFeedNotForSalePostIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsFeedNotForSalePostIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsFeedNotForSalePostIdsModel).a();
                }
                return fetchGroupsFeedNotForSalePostIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 973753231)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupNotForsaleStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5645d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupNotForsaleStoriesModel.class, new Deserializer());
                }

                public Object m6648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupNotForsaleStoriesParser.m6785a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupNotForsaleStoriesModel = new GroupNotForsaleStoriesModel();
                    ((BaseModel) groupNotForsaleStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupNotForsaleStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupNotForsaleStoriesModel).a();
                    }
                    return groupNotForsaleStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5644d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupNotForsaleStoriesParser.NodesParser.m6784b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6650a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6652a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupNotForsaleStoriesParser.NodesParser.m6783a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m6655a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6656a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m6651j() {
                    this.f5644d = super.a(this.f5644d, 0);
                    return this.f5644d;
                }

                @Nullable
                public final String m6654a() {
                    return m6651j();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6652a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6651j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupNotForsaleStoriesModel> {
                public final void m6657a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupNotForsaleStoriesModel groupNotForsaleStoriesModel = (GroupNotForsaleStoriesModel) obj;
                    if (groupNotForsaleStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupNotForsaleStoriesModel.m6659a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupNotForsaleStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupNotForsaleStoriesParser.m6786a(groupNotForsaleStoriesModel.w_(), groupNotForsaleStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupNotForsaleStoriesModel.class, new Serializer());
                }
            }

            public GroupNotForsaleStoriesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m6658a() {
                this.f5645d = super.a(this.f5645d, 0, NodesModel.class);
                return (ImmutableList) this.f5645d;
            }

            public final int jK_() {
                return 1357278784;
            }

            public final GraphQLVisitableModel m6660a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6658a() != null) {
                    Builder a = ModelHelper.a(m6658a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupNotForsaleStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5645d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6659a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6658a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedNotForSalePostIdsModel> {
            public final void m6661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedNotForSalePostIdsModel fetchGroupsFeedNotForSalePostIdsModel = (FetchGroupsFeedNotForSalePostIdsModel) obj;
                if (fetchGroupsFeedNotForSalePostIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedNotForSalePostIdsModel.m6664a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedNotForSalePostIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedNotForSalePostIdsModel.w_();
                int u_ = fetchGroupsFeedNotForSalePostIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_not_forsale_stories");
                    GroupNotForsaleStoriesParser.m6786a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedNotForSalePostIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedNotForSalePostIdsModel() {
            super(2);
        }

        public final void m6667a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6668a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupNotForsaleStoriesModel m6662j() {
            this.f5646d = (GroupNotForsaleStoriesModel) super.a(this.f5646d, 0, GroupNotForsaleStoriesModel.class);
            return this.f5646d;
        }

        @Nullable
        private String m6663k() {
            this.f5647e = super.a(this.f5647e, 1);
            return this.f5647e;
        }

        @Nullable
        public final String m6666a() {
            return m6663k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6662j() != null) {
                GroupNotForsaleStoriesModel groupNotForsaleStoriesModel = (GroupNotForsaleStoriesModel) graphQLModelMutatingVisitor.b(m6662j());
                if (m6662j() != groupNotForsaleStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsFeedNotForSalePostIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5646d = groupNotForsaleStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6664a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6662j());
            int b = flatBufferBuilder.b(m6663k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1337850538)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedPendingPostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupPendingStoriesModel f5650d;
        @Nullable
        private String f5651e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsFeedPendingPostIdsModel.class, new Deserializer());
            }

            public Object m6669a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsFeedPendingPostIdsParser.m6792a(jsonParser);
                Object fetchGroupsFeedPendingPostIdsModel = new FetchGroupsFeedPendingPostIdsModel();
                ((BaseModel) fetchGroupsFeedPendingPostIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsFeedPendingPostIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsFeedPendingPostIdsModel).a();
                }
                return fetchGroupsFeedPendingPostIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 598059546)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupPendingStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5649d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPendingStoriesModel.class, new Deserializer());
                }

                public Object m6670a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPendingStoriesParser.m6790a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPendingStoriesModel = new GroupPendingStoriesModel();
                    ((BaseModel) groupPendingStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPendingStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPendingStoriesModel).a();
                    }
                    return groupPendingStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5648d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6671a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupPendingStoriesParser.NodesParser.m6789b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6673a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupPendingStoriesParser.NodesParser.m6788a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m6676a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6677a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m6678b() {
                    this.f5648d = super.a(this.f5648d, 0);
                    return this.f5648d;
                }

                @Nullable
                public final String m6675a() {
                    return m6678b();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6674a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6673a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6678b());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupPendingStoriesModel> {
                public final void m6679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPendingStoriesModel groupPendingStoriesModel = (GroupPendingStoriesModel) obj;
                    if (groupPendingStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPendingStoriesModel.m6680a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPendingStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPendingStoriesParser.m6791a(groupPendingStoriesModel.w_(), groupPendingStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupPendingStoriesModel.class, new Serializer());
                }
            }

            public GroupPendingStoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6682a() {
                this.f5649d = super.a(this.f5649d, 0, NodesModel.class);
                return (ImmutableList) this.f5649d;
            }

            public final int jK_() {
                return 1621009465;
            }

            public final GraphQLVisitableModel m6681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6682a() != null) {
                    Builder a = ModelHelper.a(m6682a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupPendingStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5649d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6680a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6682a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedPendingPostIdsModel> {
            public final void m6683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedPendingPostIdsModel fetchGroupsFeedPendingPostIdsModel = (FetchGroupsFeedPendingPostIdsModel) obj;
                if (fetchGroupsFeedPendingPostIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedPendingPostIdsModel.m6685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedPendingPostIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedPendingPostIdsModel.w_();
                int u_ = fetchGroupsFeedPendingPostIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_pending_stories");
                    GroupPendingStoriesParser.m6791a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedPendingPostIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedPendingPostIdsModel() {
            super(2);
        }

        public final void m6688a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6689a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupPendingStoriesModel m6690j() {
            this.f5650d = (GroupPendingStoriesModel) super.a(this.f5650d, 0, GroupPendingStoriesModel.class);
            return this.f5650d;
        }

        @Nullable
        private String m6684k() {
            this.f5651e = super.a(this.f5651e, 1);
            return this.f5651e;
        }

        @Nullable
        public final String m6687a() {
            return m6684k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6686a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6690j() != null) {
                GroupPendingStoriesModel groupPendingStoriesModel = (GroupPendingStoriesModel) graphQLModelMutatingVisitor.b(m6690j());
                if (m6690j() != groupPendingStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsFeedPendingPostIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5650d = groupPendingStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6690j());
            int b = flatBufferBuilder.b(m6684k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -510240171)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedPinnedPostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupPinnedStoriesModel f5654d;
        @Nullable
        private String f5655e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsFeedPinnedPostIdsModel.class, new Deserializer());
            }

            public Object m6691a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsFeedPinnedPostIdsParser.m6797a(jsonParser);
                Object fetchGroupsFeedPinnedPostIdsModel = new FetchGroupsFeedPinnedPostIdsModel();
                ((BaseModel) fetchGroupsFeedPinnedPostIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsFeedPinnedPostIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsFeedPinnedPostIdsModel).a();
                }
                return fetchGroupsFeedPinnedPostIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1442407838)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupPinnedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5653d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPinnedStoriesModel.class, new Deserializer());
                }

                public Object m6692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPinnedStoriesParser.m6795a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPinnedStoriesModel = new GroupPinnedStoriesModel();
                    ((BaseModel) groupPinnedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPinnedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPinnedStoriesModel).a();
                    }
                    return groupPinnedStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5652d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupPinnedStoriesParser.NodesParser.m6794b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6694a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6695a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupPinnedStoriesParser.NodesParser.m6793a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m6698a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6699a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m6700b() {
                    this.f5652d = super.a(this.f5652d, 0);
                    return this.f5652d;
                }

                @Nullable
                public final String m6697a() {
                    return m6700b();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6695a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6700b());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupPinnedStoriesModel> {
                public final void m6701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) obj;
                    if (groupPinnedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPinnedStoriesModel.m6702a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPinnedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPinnedStoriesParser.m6796a(groupPinnedStoriesModel.w_(), groupPinnedStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupPinnedStoriesModel.class, new Serializer());
                }
            }

            public GroupPinnedStoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6704a() {
                this.f5653d = super.a(this.f5653d, 0, NodesModel.class);
                return (ImmutableList) this.f5653d;
            }

            public final int jK_() {
                return -216392390;
            }

            public final GraphQLVisitableModel m6703a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6704a() != null) {
                    Builder a = ModelHelper.a(m6704a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupPinnedStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5653d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6702a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6704a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedPinnedPostIdsModel> {
            public final void m6705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedPinnedPostIdsModel fetchGroupsFeedPinnedPostIdsModel = (FetchGroupsFeedPinnedPostIdsModel) obj;
                if (fetchGroupsFeedPinnedPostIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedPinnedPostIdsModel.m6707a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedPinnedPostIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedPinnedPostIdsModel.w_();
                int u_ = fetchGroupsFeedPinnedPostIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_pinned_stories");
                    GroupPinnedStoriesParser.m6796a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedPinnedPostIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedPinnedPostIdsModel() {
            super(2);
        }

        public final void m6710a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6711a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupPinnedStoriesModel m6712j() {
            this.f5654d = (GroupPinnedStoriesModel) super.a(this.f5654d, 0, GroupPinnedStoriesModel.class);
            return this.f5654d;
        }

        @Nullable
        private String m6706k() {
            this.f5655e = super.a(this.f5655e, 1);
            return this.f5655e;
        }

        @Nullable
        public final String m6709a() {
            return m6706k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6708a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6712j() != null) {
                GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) graphQLModelMutatingVisitor.b(m6712j());
                if (m6712j() != groupPinnedStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsFeedPinnedPostIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5654d = groupPinnedStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6707a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6712j());
            int b = flatBufferBuilder.b(m6706k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1879437304)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsFeedReportedPostIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupReportedStoriesModel f5658d;
        @Nullable
        private String f5659e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsFeedReportedPostIdsModel.class, new Deserializer());
            }

            public Object m6713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsFeedReportedPostIdsParser.m6802a(jsonParser);
                Object fetchGroupsFeedReportedPostIdsModel = new FetchGroupsFeedReportedPostIdsModel();
                ((BaseModel) fetchGroupsFeedReportedPostIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsFeedReportedPostIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsFeedReportedPostIdsModel).a();
                }
                return fetchGroupsFeedReportedPostIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1999741248)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupReportedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5657d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupReportedStoriesModel.class, new Deserializer());
                }

                public Object m6714a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupReportedStoriesParser.m6800a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupReportedStoriesModel = new GroupReportedStoriesModel();
                    ((BaseModel) groupReportedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupReportedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupReportedStoriesModel).a();
                    }
                    return groupReportedStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5656d;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupReportedStoriesParser.NodesParser.m6799b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6718a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupReportedStoriesParser.NodesParser.m6798a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m6721a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6722a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m6717j() {
                    this.f5656d = super.a(this.f5656d, 0);
                    return this.f5656d;
                }

                @Nullable
                public final String m6720a() {
                    return m6717j();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6718a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6717j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupReportedStoriesModel> {
                public final void m6723a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupReportedStoriesModel groupReportedStoriesModel = (GroupReportedStoriesModel) obj;
                    if (groupReportedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupReportedStoriesModel.m6725a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupReportedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupReportedStoriesParser.m6801a(groupReportedStoriesModel.w_(), groupReportedStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupReportedStoriesModel.class, new Serializer());
                }
            }

            public GroupReportedStoriesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m6724a() {
                this.f5657d = super.a(this.f5657d, 0, NodesModel.class);
                return (ImmutableList) this.f5657d;
            }

            public final int jK_() {
                return -35660449;
            }

            public final GraphQLVisitableModel m6726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6724a() != null) {
                    Builder a = ModelHelper.a(m6724a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupReportedStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5657d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6725a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6724a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsFeedReportedPostIdsModel> {
            public final void m6727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsFeedReportedPostIdsModel fetchGroupsFeedReportedPostIdsModel = (FetchGroupsFeedReportedPostIdsModel) obj;
                if (fetchGroupsFeedReportedPostIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsFeedReportedPostIdsModel.m6730a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsFeedReportedPostIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsFeedReportedPostIdsModel.w_();
                int u_ = fetchGroupsFeedReportedPostIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_reported_stories");
                    GroupReportedStoriesParser.m6801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsFeedReportedPostIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsFeedReportedPostIdsModel() {
            super(2);
        }

        public final void m6733a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6734a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupReportedStoriesModel m6728j() {
            this.f5658d = (GroupReportedStoriesModel) super.a(this.f5658d, 0, GroupReportedStoriesModel.class);
            return this.f5658d;
        }

        @Nullable
        private String m6729k() {
            this.f5659e = super.a(this.f5659e, 1);
            return this.f5659e;
        }

        @Nullable
        public final String m6732a() {
            return m6729k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6731a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6728j() != null) {
                GroupReportedStoriesModel groupReportedStoriesModel = (GroupReportedStoriesModel) graphQLModelMutatingVisitor.b(m6728j());
                if (m6728j() != groupReportedStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsFeedReportedPostIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5658d = groupReportedStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6730a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6728j());
            int b = flatBufferBuilder.b(m6729k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1174383370)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: query_count */
    public final class FetchGroupsStoriesMallIdsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupStoriesModel f5663d;
        @Nullable
        private String f5664e;

        /* compiled from: query_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupsStoriesMallIdsModel.class, new Deserializer());
            }

            public Object m6735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupsStoriesMallIdsParser.m6807a(jsonParser);
                Object fetchGroupsStoriesMallIdsModel = new FetchGroupsStoriesMallIdsModel();
                ((BaseModel) fetchGroupsStoriesMallIdsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupsStoriesMallIdsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupsStoriesMallIdsModel).a();
                }
                return fetchGroupsStoriesMallIdsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -100396462)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: query_count */
        public final class GroupStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5662d;

            /* compiled from: query_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupStoriesModel.class, new Deserializer());
                }

                public Object m6736a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupStoriesParser.m6805a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupStoriesModel = new GroupStoriesModel();
                    ((BaseModel) groupStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupStoriesModel).a();
                    }
                    return groupStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1739105429)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: query_count */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5660d;
                @Nullable
                private String f5661e;

                /* compiled from: query_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6737a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupStoriesParser.NodesParser.m6804b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: query_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6738a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6739a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupStoriesParser.NodesParser.m6803a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m6742a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6743a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m6744j() {
                    this.f5660d = super.a(this.f5660d, 0);
                    return this.f5660d;
                }

                @Nullable
                public final String m6745k() {
                    this.f5661e = super.a(this.f5661e, 1);
                    return this.f5661e;
                }

                @Nullable
                public final String m6741a() {
                    return m6745k();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6740a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6739a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6744j());
                    int b2 = flatBufferBuilder.b(m6745k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: query_count */
            public class Serializer extends JsonSerializer<GroupStoriesModel> {
                public final void m6746a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupStoriesModel groupStoriesModel = (GroupStoriesModel) obj;
                    if (groupStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupStoriesModel.m6747a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupStoriesParser.m6806a(groupStoriesModel.w_(), groupStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupStoriesModel.class, new Serializer());
                }
            }

            public GroupStoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6749a() {
                this.f5662d = super.a(this.f5662d, 0, NodesModel.class);
                return (ImmutableList) this.f5662d;
            }

            public final int jK_() {
                return 1229624050;
            }

            public final GraphQLVisitableModel m6748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6749a() != null) {
                    Builder a = ModelHelper.a(m6749a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5662d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6747a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6749a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: query_count */
        public class Serializer extends JsonSerializer<FetchGroupsStoriesMallIdsModel> {
            public final void m6750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupsStoriesMallIdsModel fetchGroupsStoriesMallIdsModel = (FetchGroupsStoriesMallIdsModel) obj;
                if (fetchGroupsStoriesMallIdsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupsStoriesMallIdsModel.m6752a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupsStoriesMallIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupsStoriesMallIdsModel.w_();
                int u_ = fetchGroupsStoriesMallIdsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_stories");
                    GroupStoriesParser.m6806a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupsStoriesMallIdsModel.class, new Serializer());
            }
        }

        public FetchGroupsStoriesMallIdsModel() {
            super(2);
        }

        public final void m6755a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6756a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupStoriesModel m6757j() {
            this.f5663d = (GroupStoriesModel) super.a(this.f5663d, 0, GroupStoriesModel.class);
            return this.f5663d;
        }

        @Nullable
        private String m6751k() {
            this.f5664e = super.a(this.f5664e, 1);
            return this.f5664e;
        }

        @Nullable
        public final String m6754a() {
            return m6751k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6753a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6757j() != null) {
                GroupStoriesModel groupStoriesModel = (GroupStoriesModel) graphQLModelMutatingVisitor.b(m6757j());
                if (m6757j() != groupStoriesModel) {
                    graphQLVisitableModel = (FetchGroupsStoriesMallIdsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5663d = groupStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6752a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6757j());
            int b = flatBufferBuilder.b(m6751k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
