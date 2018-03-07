package com.facebook.groups.docsandfiles.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: UnreadThreadsOnClient */
public class FileUploadingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1764536919)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UnreadThreadsOnClient */
    public final class CreateFileMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StoryModel f21467d;

        /* compiled from: UnreadThreadsOnClient */
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
                r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.class;
                r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m22385a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.m22449a(r6);
                r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: UnreadThreadsOnClient */
        public class Serializer extends JsonSerializer<CreateFileMutationModel> {
            public final void m22386a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r8 = this;
                r9 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m22434a(r0);
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
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r10.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "story";
                r10.a(r7);
                com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.m22448a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.class;
                r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1023031836)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UnreadThreadsOnClient */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private List<ActorsModel> f21461d;
            @Nullable
            private List<AttachmentsModel> f21462e;
            @Nullable
            private String f21463f;
            private long f21464g;
            @Nullable
            private String f21465h;
            @Nullable
            private TitleModel f21466i;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UnreadThreadsOnClient */
            public final class ActorsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f21450d;
                @Nullable
                private String f21451e;
                @Nullable
                private String f21452f;

                /* compiled from: UnreadThreadsOnClient */
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$ActorsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m22387a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.ActorsParser.m22439b(r11, r4);
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
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$ActorsModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: UnreadThreadsOnClient */
                public class Serializer extends JsonSerializer<ActorsModel> {
                    public final void m22388a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m22391a(r0);
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
                        com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.ActorsParser.m22438a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$ActorsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.Serializer.<clinit>():void");
                    }
                }

                public ActorsModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.<init>():void");
                }

                public final void m22394a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m22395a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                private com.facebook.graphql.enums.GraphQLObjectType m22389k() {
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
                    r4 = this;
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f21450d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f21450d = r0;
                L_0x0017:
                    r0 = r4.f21450d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.k():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                private java.lang.String m22390l() {
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
                    r0 = r2.f21451e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f21451e = r0;
                    r0 = r2.f21451e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.l():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m22396j() {
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
                    r0 = r2.f21452f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f21452f = r0;
                    r0 = r2.f21452f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m22393a() {
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
                    r0 = r1.m22390l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.a():java.lang.String");
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
                    r0 = 63093205; // 0x3c2b9d5 float:1.144496E-36 double:3.1172185E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m22392a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m22391a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4 = this;
                    r4.h();
                    r0 = r4.m22389k();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m22390l();
                    r1 = r5.b(r1);
                    r2 = r4.m22396j();
                    r2 = r5.b(r2);
                    r3 = 3;
                    r5.c(r3);
                    r3 = 0;
                    r5.b(r3, r0);
                    r0 = 1;
                    r5.b(r0, r1);
                    r0 = 2;
                    r5.b(r0, r2);
                    r4.i();
                    r0 = r5.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 342527588)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UnreadThreadsOnClient */
            public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private TargetModel f21457d;
                @Nullable
                private String f21458e;
                @Nullable
                private String f21459f;

                /* compiled from: UnreadThreadsOnClient */
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m22397a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.AttachmentsParser.m22443b(r11, r4);
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
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: UnreadThreadsOnClient */
                public class Serializer extends JsonSerializer<AttachmentsModel> {
                    public final void m22398a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m22411a(r0);
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
                        com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.AttachmentsParser.m22444b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.Serializer.<clinit>():void");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1547237110)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: UnreadThreadsOnClient */
                public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f21453d;
                    @Nullable
                    private String f21454e;
                    @Nullable
                    private String f21455f;
                    @Nullable
                    private String f21456g;

                    /* compiled from: UnreadThreadsOnClient */
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.class;
                            r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$TargetModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m22399a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.AttachmentsParser.TargetParser.m22440a(r11, r4);
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
                            r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$TargetModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: UnreadThreadsOnClient */
                    public class Serializer extends JsonSerializer<TargetModel> {
                        public final void m22400a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m22404a(r0);
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
                            com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.AttachmentsParser.TargetParser.m22441a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.class;
                            r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$TargetModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.Serializer.<clinit>():void");
                        }
                    }

                    public TargetModel() {
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
                        r0 = 4;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.<init>():void");
                    }

                    public final void m22407a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                        r2.a();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                    }

                    public final void m22408a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.a(java.lang.String, java.lang.Object, boolean):void");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.graphql.enums.GraphQLObjectType m22401k() {
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
                        r4 = this;
                        r0 = r4.b;
                        if (r0 == 0) goto L_0x0017;
                    L_0x0004:
                        r0 = r4.f21453d;
                        if (r0 != 0) goto L_0x0017;
                    L_0x0008:
                        r0 = r4.b;
                        r1 = r4.c;
                        r2 = 0;
                        r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                        r0 = r0.d(r1, r2, r3);
                        r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                        r4.f21453d = r0;
                    L_0x0017:
                        r0 = r4.f21453d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.k():com.facebook.graphql.enums.GraphQLObjectType");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m22409j() {
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
                        r0 = r2.f21454e;
                        r1 = 1;
                        r0 = super.a(r0, r1);
                        r2.f21454e = r0;
                        r0 = r2.f21454e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.j():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m22402l() {
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
                        r0 = r2.f21455f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f21455f = r0;
                        r0 = r2.f21455f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.l():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m22403m() {
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
                        r0 = r2.f21456g;
                        r1 = 3;
                        r0 = super.a(r0, r1);
                        r2.f21456g = r0;
                        r0 = r2.f21456g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.m():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m22406a() {
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
                        r0 = r1.m22402l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.a():java.lang.String");
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
                        r0 = 2433570; // 0x252222 float:3.410158E-39 double:1.2023433E-317;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m22405a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m22404a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
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
                        r5 = this;
                        r5.h();
                        r0 = r5.m22401k();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r0);
                        r1 = r5.m22409j();
                        r1 = r6.b(r1);
                        r2 = r5.m22402l();
                        r2 = r6.b(r2);
                        r3 = r5.m22403m();
                        r3 = r6.b(r3);
                        r4 = 4;
                        r6.c(r4);
                        r4 = 0;
                        r6.b(r4, r0);
                        r0 = 1;
                        r6.b(r0, r1);
                        r0 = 2;
                        r6.b(r0, r2);
                        r0 = 3;
                        r6.b(r0, r3);
                        r5.i();
                        r0 = r6.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                public AttachmentsModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel m22413a() {
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
                    r0 = r3.f21457d;
                    r1 = 0;
                    r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel) r0;
                    r3.f21457d = r0;
                    r0 = r3.f21457d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.a():com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel$TargetModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m22414j() {
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
                    r0 = r2.f21458e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f21458e = r0;
                    r0 = r2.f21458e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                private java.lang.String m22410k() {
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
                    r0 = r2.f21459f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f21459f = r0;
                    r0 = r2.f21459f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.k():java.lang.String");
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
                    r0 = -1267730472; // 0xffffffffb46ff7d8 float:-2.2348775E-7 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m22412a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r3.h();
                    r0 = r3.m22413a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m22413a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.TargetModel) r0;
                    r2 = r3.m22413a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel) r1;
                    r1.f21457d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m22411a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4 = this;
                    r4.h();
                    r0 = r4.m22413a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m22414j();
                    r1 = r5.b(r1);
                    r2 = r4.m22410k();
                    r2 = r5.b(r2);
                    r3 = 3;
                    r5.c(r3);
                    r3 = 0;
                    r5.b(r3, r0);
                    r0 = 1;
                    r5.b(r0, r1);
                    r0 = 2;
                    r5.b(r0, r2);
                    r4.i();
                    r0 = r5.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: UnreadThreadsOnClient */
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
                    r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.class;
                    r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m22415a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.m22447a(r11, r4);
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
                    r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: UnreadThreadsOnClient */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m22416a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m22424a(r0);
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
                    com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.m22448a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.class;
                    r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.Serializer.<clinit>():void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UnreadThreadsOnClient */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f21460d;

                /* compiled from: UnreadThreadsOnClient */
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$TitleModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m22417a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.TitleParser.m22445a(r11, r4);
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
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$TitleModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: UnreadThreadsOnClient */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m22418a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m22420a(r0);
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
                        com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsParsers.CreateFileMutationParser.StoryParser.TitleParser.m22446a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.class;
                        r1 = new com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$TitleModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.Serializer.<clinit>():void");
                    }
                }

                public TitleModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.<init>():void");
                }

                @javax.annotation.Nullable
                private java.lang.String m22419a() {
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
                    r0 = r2.f21460d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f21460d = r0;
                    r0 = r2.f21460d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.a():java.lang.String");
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
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m22421a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m22420a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m22419a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            public StoryModel() {
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
                r0 = 6;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.<init>():void");
            }

            public final void m22428a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                r0 = this;
                r2.a();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            public final void m22429a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                r0 = this;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel> m22430j() {
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
                r0 = r3.f21461d;
                r1 = 0;
                r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f21461d = r0;
                r0 = r3.f21461d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.j():com.google.common.collect.ImmutableList<com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$ActorsModel>");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel> m22431k() {
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
                r0 = r3.f21462e;
                r1 = 1;
                r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f21462e = r0;
                r0 = r3.f21462e;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.k():com.google.common.collect.ImmutableList<com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$AttachmentsModel>");
            }

            @javax.annotation.Nullable
            private java.lang.String m22422n() {
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
                r0 = r2.f21463f;
                r1 = 2;
                r0 = super.a(r0, r1);
                r2.f21463f = r0;
                r0 = r2.f21463f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.n():java.lang.String");
            }

            public final long m22432l() {
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
                r1 = 3;
                r2.a(r0, r1);
                r0 = r2.f21464g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.l():long");
            }

            @javax.annotation.Nullable
            public final java.lang.String m22433m() {
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
                r0 = r2.f21465h;
                r1 = 4;
                r0 = super.a(r0, r1);
                r2.f21465h = r0;
                r0 = r2.f21465h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.m():java.lang.String");
            }

            @javax.annotation.Nullable
            private com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel m22423o() {
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
                r0 = r3.f21466i;
                r1 = 5;
                r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel) r0;
                r3.f21466i = r0;
                r0 = r3.f21466i;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.o():com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel$TitleModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m22426a() {
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
                r0 = r1.m22433m();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a():java.lang.String");
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
                r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m22425a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = 0;
                r3.h();
                r1 = r3.m22430j();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r3.m22430j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r0;
                r1 = r1.b();
                r0.f21461d = r1;
            L_0x0020:
                r1 = r3.m22431k();
                if (r1 == 0) goto L_0x003c;
            L_0x0026:
                r1 = r3.m22431k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                if (r1 == 0) goto L_0x003c;
            L_0x0030:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r0;
                r1 = r1.b();
                r0.f21462e = r1;
            L_0x003c:
                r1 = r0;
                r0 = r3.m22423o();
                if (r0 == 0) goto L_0x005b;
            L_0x0043:
                r0 = r3.m22423o();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.TitleModel) r0;
                r2 = r3.m22423o();
                if (r2 == r0) goto L_0x005b;
            L_0x0053:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r1;
                r1.f21466i = r0;
            L_0x005b:
                r3.i();
                if (r1 != 0) goto L_0x0061;
            L_0x0060:
                return r3;
            L_0x0061:
                r3 = r1;
                goto L_0x0060;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m22424a(com.facebook.flatbuffers.FlatBufferBuilder r9) {
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
                r8 = this;
                r8.h();
                r0 = r8.m22430j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r0);
                r1 = r8.m22431k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r1);
                r2 = r8.m22422n();
                r2 = r9.b(r2);
                r3 = r8.m22433m();
                r6 = r9.b(r3);
                r3 = r8.m22423o();
                r7 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r3);
                r3 = 6;
                r9.c(r3);
                r3 = 0;
                r9.b(r3, r0);
                r0 = 1;
                r9.b(r0, r1);
                r0 = 2;
                r9.b(r0, r2);
                r1 = 3;
                r2 = r8.f21464g;
                r4 = 0;
                r0 = r9;
                r0.a(r1, r2, r4);
                r0 = 4;
                r9.b(r0, r6);
                r0 = 5;
                r9.b(r0, r7);
                r8.i();
                r0 = r9.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m22427a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                r4 = this;
                super.a(r5, r6, r7);
                r0 = 3;
                r2 = 0;
                r0 = r5.a(r6, r0, r2);
                r4.f21464g = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        public CreateFileMutationModel() {
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
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel m22436a() {
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
            r0 = r3.f21467d;
            r1 = 0;
            r2 = com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r0;
            r3.f21467d = r0;
            r0 = r3.f21467d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.a():com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels$CreateFileMutationModel$StoryModel");
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
            r0 = -1184016484; // 0xffffffffb96d579c float:-2.2634718E-4 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m22435a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m22436a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m22436a();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel) r0;
            r2 = r3.m22436a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel) r1;
            r1.f21467d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m22434a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r2.h();
            r0 = r2.m22436a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
