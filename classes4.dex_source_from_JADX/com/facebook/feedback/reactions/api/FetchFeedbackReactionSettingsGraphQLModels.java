package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: selected_privacy_option */
public class FetchFeedbackReactionSettingsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1221840448)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: selected_privacy_option */
    public final class FetchFeedbackReactionsVectorDataQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackReactionSettingsModel f2935d;

        /* compiled from: selected_privacy_option */
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
                r0 = com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.class;
                r1 = new com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionsVectorDataQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m3181a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r5 = this;
                r2 = com.facebook.feedback.reactions.api.C0136x3d686921.m3182a(r6);
                r1 = new com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionsVectorDataQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1756228812)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: selected_privacy_option */
        public final class FeedbackReactionSettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ReactionInfosModel> f2945d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -795359468)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: selected_privacy_option */
            public final class ReactionInfosModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private AnimationModel f2946d;
                private int f2947e;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1714087988)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: selected_privacy_option */
                public final class AnimationModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f2948d;

                    public AnimationModel() {
                        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
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
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m3199a() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                        r0 = r2.f2948d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f2948d = r0;
                        r0 = r2.f2948d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a():java.lang.String");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                        r0 = 1649233462; // 0x624d4e36 float:9.4680456E20 double:8.148295955E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m3198a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m3197a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                        r0 = r2.m3199a();
                        r0 = r3.b(r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                public ReactionInfosModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel m3193a() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
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
                    r3 = this;
                    r0 = r3.f2946d;
                    r1 = 0;
                    r2 = com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel) r0;
                    r3.f2946d = r0;
                    r0 = r3.f2946d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionsVectorDataQueryModel$FeedbackReactionSettingsModel$ReactionInfosModel$AnimationModel");
                }

                public final int m3196j() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                    r1 = 1;
                    r2.a(r0, r1);
                    r0 = r2.f2947e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.j():int");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
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
                    r1 = this;
                    r0 = -1654469956; // 0xffffffff9d62cabc float:-3.0015662E-21 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m3194a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.removeInsns(BlockSplitter.java:219)
	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(BlockSplitter.java:45)
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
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m3193a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m3193a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel) r0;
                    r2 = r3.m3193a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel) r1;
                    r1.f2946d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m3192a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                    r2 = 0;
                    r3.h();
                    r0 = r3.m3193a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                    r1 = 2;
                    r4.c(r1);
                    r4.b(r2, r0);
                    r0 = 1;
                    r1 = r3.f2947e;
                    r4.a(r0, r1, r2);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m3195a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                    super.a(r3, r4, r5);
                    r0 = 1;
                    r1 = 0;
                    r0 = r3.a(r4, r0, r1);
                    r2.f2947e = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            public FeedbackReactionSettingsModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel> m3191a() {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
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
                r3 = this;
                r0 = r3.f2945d;
                r1 = 0;
                r2 = com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f2945d = r0;
                r0 = r3.f2945d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.a():com.google.common.collect.ImmutableList<com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionsVectorDataQueryModel$FeedbackReactionSettingsModel$ReactionInfosModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                r0 = -1873384655; // 0xffffffff90566b31 float:-4.2286636E-29 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m3190a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                r0 = 0;
                r2.h();
                r1 = r2.m3191a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m3191a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel) r0;
                r1 = r1.b();
                r0.f2945d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m3189a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
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
                r2.h();
                r0 = r2.m3191a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public FetchFeedbackReactionsVectorDataQueryModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel m3179a() {
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
            r0 = r3.f2935d;
            r1 = 0;
            r2 = com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel) r0;
            r3.f2935d = r0;
            r0 = r3.f2935d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.a():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionsVectorDataQueryModel$FeedbackReactionSettingsModel");
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
            r0 = -1732764110; // 0xffffffff98b81e32 float:-4.7593375E-24 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m3180a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r1 = 0;
            r3.h();
            r0 = r3.m3179a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m3179a();
            r0 = r4.b(r0);
            r0 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel) r0;
            r2 = r3.m3179a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel) r1;
            r1.f2935d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m3178a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r0 = r2.m3179a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
