package com.facebook.feedback.reactions.api;

import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionSettingsQueryModel.Deserializer;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionSettingsQueryModel.Serializer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 11307321)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: growth_set_native_name */
public final class C0850x41c6c670 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private FeedbackReactionSettingsModel f21500d;

    @JsonDeserialize(using = FeedbackReactionSettingsModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1153617432)
    @JsonSerialize(using = FeedbackReactionSettingsModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: growth_set_native_name */
    public final class FeedbackReactionSettingsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ReactionInfosModel> f22097d;

        @JsonDeserialize(using = ReactionInfosModel.Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2088925977)
        @JsonSerialize(using = ReactionInfosModel.Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: growth_set_native_name */
        public final class ReactionInfosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AnimationModel f22098d;
            @Nullable
            private String f22099e;
            private boolean f22100f;
            private int f22101g;
            @Nullable
            private C0892xd41607c3 f22102h;
            @Nullable
            private String f22103i;
            @Nullable
            private C0892xd41607c3 f22104j;
            @Nullable
            private C0892xd41607c3 f22105k;

            @JsonDeserialize(using = AnimationModel.Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1170637390)
            @JsonSerialize(using = AnimationModel.Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: growth_set_native_name */
            public final class AnimationModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f22106d;
                @Nullable
                private String f22107e;

                public AnimationModel() {
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
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.<init>():void");
                }

                @javax.annotation.Nullable
                private java.lang.String m29988j() {
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
                    r2 = this;
                    r0 = r2.f22106d;
                    r1 = 0;
                    r0 = super.m9948a(r0, r1);
                    r2.f22106d = r0;
                    r0 = r2.f22106d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m29991a() {
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
                    r2 = this;
                    r0 = r2.f22107e;
                    r1 = 1;
                    r0 = super.m9948a(r0, r1);
                    r2.f22107e = r0;
                    r0 = r2.f22107e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a():java.lang.String");
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel mo1404a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0 = this;
                    r0.m9958h();
                    r0.m9959i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int mo1403a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                    r3 = this;
                    r3.m9958h();
                    r0 = r3.m29988j();
                    r0 = r4.m21502b(r0);
                    r1 = r3.m29991a();
                    r1 = r4.m21502b(r1);
                    r2 = 2;
                    r4.m21510c(r2);
                    r2 = 0;
                    r4.m21507b(r2, r0);
                    r0 = 1;
                    r4.m21507b(r0, r1);
                    r3.m9959i();
                    r0 = r4.m21511d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            public ReactionInfosModel() {
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
                r0 = 8;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel m29978a() {
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
                r3 = this;
                r0 = r3.f22098d;
                r1 = 0;
                r2 = com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel.class;
                r0 = super.m9947a(r0, r1, r2);
                r0 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel) r0;
                r3.f22098d = r0;
                r0 = r3.f22098d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionSettingsQueryModel$FeedbackReactionSettingsModel$ReactionInfosModel$AnimationModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m29981j() {
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
                r0 = r2.f22099e;
                r1 = 1;
                r0 = super.m9948a(r0, r1);
                r2.f22099e = r0;
                r0 = r2.f22099e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.j():java.lang.String");
            }

            public final boolean m29982k() {
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
                r0 = 0;
                r1 = 2;
                r2.m9949a(r0, r1);
                r0 = r2.f22100f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.k():boolean");
            }

            public final int m29983l() {
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
                r0 = 0;
                r1 = 3;
                r2.m9949a(r0, r1);
                r0 = r2.f22101g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.l():int");
            }

            @javax.annotation.Nullable
            public final com.facebook.feedback.reactions.api.C0892xd41607c3 m29984m() {
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
                r3 = this;
                r0 = r3.f22102h;
                r1 = 4;
                r2 = com.facebook.feedback.reactions.api.C0892xd41607c3.class;
                r0 = super.m9947a(r0, r1, r2);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r3.f22102h = r0;
                r0 = r3.f22102h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.m():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$ReactionImageFragmentModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m29985n() {
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
                r0 = r2.f22103i;
                r1 = 5;
                r0 = super.m9948a(r0, r1);
                r2.f22103i = r0;
                r0 = r2.f22103i;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.n():java.lang.String");
            }

            @javax.annotation.Nullable
            public final com.facebook.feedback.reactions.api.C0892xd41607c3 m29986o() {
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
                r3 = this;
                r0 = r3.f22104j;
                r1 = 6;
                r2 = com.facebook.feedback.reactions.api.C0892xd41607c3.class;
                r0 = super.m9947a(r0, r1, r2);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r3.f22104j = r0;
                r0 = r3.f22104j;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.o():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$ReactionImageFragmentModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.feedback.reactions.api.C0892xd41607c3 m29987p() {
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
                r3 = this;
                r0 = r3.f22105k;
                r1 = 7;
                r2 = com.facebook.feedback.reactions.api.C0892xd41607c3.class;
                r0 = super.m9947a(r0, r1, r2);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r3.f22105k = r0;
                r0 = r3.f22105k;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.p():com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$ReactionImageFragmentModel");
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
                r0 = -1654469956; // 0xffffffff9d62cabc float:-3.0015662E-21 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel mo1404a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r3 = this;
                r1 = 0;
                r3.m9958h();
                r0 = r3.m29978a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m29978a();
                r0 = r4.mo2928b(r0);
                r0 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel) r0;
                r2 = r3.m29978a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.m23095a(r1, r3);
                r1 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel) r1;
                r1.f22098d = r0;
            L_0x0022:
                r0 = r3.m29984m();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m29984m();
                r0 = r4.mo2928b(r0);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r2 = r3.m29984m();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.m23095a(r1, r3);
                r1 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel) r1;
                r1.f22102h = r0;
            L_0x0040:
                r0 = r3.m29986o();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m29986o();
                r0 = r4.mo2928b(r0);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r2 = r3.m29986o();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.m23095a(r1, r3);
                r1 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel) r1;
                r1.f22104j = r0;
            L_0x005e:
                r0 = r3.m29987p();
                if (r0 == 0) goto L_0x007c;
            L_0x0064:
                r0 = r3.m29987p();
                r0 = r4.mo2928b(r0);
                r0 = (com.facebook.feedback.reactions.api.C0892xd41607c3) r0;
                r2 = r3.m29987p();
                if (r2 == r0) goto L_0x007c;
            L_0x0074:
                r1 = com.facebook.graphql.modelutil.ModelHelper.m23095a(r1, r3);
                r1 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel) r1;
                r1.f22105k = r0;
            L_0x007c:
                r3.m9959i();
                if (r1 != 0) goto L_0x0082;
            L_0x0081:
                return r3;
            L_0x0082:
                r3 = r1;
                goto L_0x0081;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int mo1403a(com.facebook.flatbuffers.FlatBufferBuilder r9) {
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
                r8 = this;
                r7 = 0;
                r8.m9958h();
                r0 = r8.m29978a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.m23093a(r9, r0);
                r1 = r8.m29981j();
                r1 = r9.m21502b(r1);
                r2 = r8.m29984m();
                r2 = com.facebook.graphql.modelutil.ModelHelper.m23093a(r9, r2);
                r3 = r8.m29985n();
                r3 = r9.m21502b(r3);
                r4 = r8.m29986o();
                r4 = com.facebook.graphql.modelutil.ModelHelper.m23093a(r9, r4);
                r5 = r8.m29987p();
                r5 = com.facebook.graphql.modelutil.ModelHelper.m23093a(r9, r5);
                r6 = 8;
                r9.m21510c(r6);
                r9.m21507b(r7, r0);
                r0 = 1;
                r9.m21507b(r0, r1);
                r0 = 2;
                r1 = r8.f22100f;
                r9.m21498a(r0, r1);
                r0 = 3;
                r1 = r8.f22101g;
                r9.m21494a(r0, r1, r7);
                r0 = 4;
                r9.m21507b(r0, r2);
                r0 = 5;
                r9.m21507b(r0, r3);
                r0 = 6;
                r9.m21507b(r0, r4);
                r0 = 7;
                r9.m21507b(r0, r5);
                r8.m9959i();
                r0 = r9.m21511d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void mo1406a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
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
                super.mo1406a(r3, r4, r5);
                r0 = 2;
                r0 = r3.m21540a(r4, r0);
                r2.f22100f = r0;
                r0 = 3;
                r1 = 0;
                r0 = r3.m21524a(r4, r0, r1);
                r2.f22101g = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        public FeedbackReactionSettingsModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.<init>():void");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel> m29976a() {
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
            r0 = r3.f22097d;
            r1 = 0;
            r2 = com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel.class;
            r0 = super.m9944a(r0, r1, r2);
            r3.f22097d = r0;
            r0 = r3.f22097d;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.a():com.google.common.collect.ImmutableList<com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$FetchFeedbackReactionSettingsQueryModel$FeedbackReactionSettingsModel$ReactionInfosModel>");
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
            r0 = -1873384655; // 0xffffffff90566b31 float:-4.2286636E-29 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel mo1404a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
            r2.m9958h();
            r1 = r2.m29976a();
            if (r1 == 0) goto L_0x0020;
        L_0x000a:
            r1 = r2.m29976a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.m23097a(r1, r3);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.m23095a(r0, r2);
            r0 = (com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel) r0;
            r1 = r1.m1068b();
            r0.f22097d = r1;
        L_0x0020:
            r2.m9959i();
            if (r0 != 0) goto L_0x0026;
        L_0x0025:
            return r2;
        L_0x0026:
            r2 = r0;
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int mo1403a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r2.m9958h();
            r0 = r2.m29976a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.m23094a(r3, r0);
            r1 = 1;
            r3.m21510c(r1);
            r1 = 0;
            r3.m21507b(r1, r0);
            r2.m9959i();
            r0 = r3.m21511d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    public C0850x41c6c670() {
        super(1);
    }

    @Nullable
    public final FeedbackReactionSettingsModel m29206a() {
        this.f21500d = (FeedbackReactionSettingsModel) super.m9947a(this.f21500d, 0, FeedbackReactionSettingsModel.class);
        return this.f21500d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29206a() != null) {
            FeedbackReactionSettingsModel feedbackReactionSettingsModel = (FeedbackReactionSettingsModel) graphQLModelMutatingVisitor.mo2928b(m29206a());
            if (m29206a() != feedbackReactionSettingsModel) {
                graphQLVisitableModel = (C0850x41c6c670) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21500d = feedbackReactionSettingsModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m29206a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
