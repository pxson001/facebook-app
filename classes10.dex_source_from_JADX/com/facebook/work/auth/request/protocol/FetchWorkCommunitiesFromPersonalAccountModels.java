package com.facebook.work.auth.request.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: expand_video */
public class FetchWorkCommunitiesFromPersonalAccountModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -433875139)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: expand_video */
    public final class FetchWorkCommunitiesFromPersonalAccountQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private WorkCommunityModel f13018d;
        @Nullable
        private List<WorkUsersModel> f13019e;

        /* compiled from: expand_video */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
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
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Deserializer.<init>():void");
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
                r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.class;
                r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m13049a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.m13100a(r11, r4);
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
                r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: expand_video */
        public class Serializer extends JsonSerializer<FetchWorkCommunitiesFromPersonalAccountQueryModel> {
            public Serializer() {
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
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Serializer.<init>():void");
            }

            public final void m13050a(java.lang.Object r11, com.fasterxml.jackson.core.JsonGenerator r12, com.fasterxml.jackson.databind.SerializerProvider r13) {
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
                r10 = this;
                r11 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel) r11;
                r2 = 0;
                r0 = r11.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r11.m13087a(r0);
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
                r11.a(r0, r1);
            L_0x0035:
                r0 = r11.w_();
                r1 = r11.u_();
                r12.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "work_community";
                r12.a(r7);
                com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkCommunityParser.m13093a(r0, r6, r12, r13);
            L_0x004f:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0072;
            L_0x0056:
                r7 = "work_users";
                r12.a(r7);
                r12.d();
                r8 = 0;
            L_0x005f:
                r9 = r0.c(r6);
                if (r8 >= r9) goto L_0x006f;
            L_0x0065:
                r9 = r0.m(r6, r8);
                com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.m13099b(r0, r9, r12, r13);
                r8 = r8 + 1;
                goto L_0x005f;
            L_0x006f:
                r12.e();
            L_0x0072:
                r12.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.class;
                r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -735042123)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: expand_video */
        public final class WorkCommunityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f13008d;
            @Nullable
            private String f13009e;
            @Nullable
            private WorkLogoModel f13010f;

            /* compiled from: expand_video */
            public class Deserializer extends FbJsonDeserializer {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public Deserializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.class;
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Deserializer.<clinit>():void");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object m13051a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                    r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkCommunityParser.m13092a(r11, r4);
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
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: expand_video */
            public class Serializer extends JsonSerializer<WorkCommunityModel> {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public Serializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Serializer.<init>():void");
                }

                public final void m13052a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                    r8 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m13060a(r0);
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
                    com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkCommunityParser.m13093a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.class;
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.Serializer.<clinit>():void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: expand_video */
            public final class WorkLogoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13007d;

                /* compiled from: expand_video */
                public class Deserializer extends FbJsonDeserializer {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.class;
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$WorkLogoModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Deserializer.<clinit>():void");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public java.lang.Object m13053a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                        r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkCommunityParser.WorkLogoParser.m13090a(r11, r4);
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
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$WorkLogoModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: expand_video */
                public class Serializer extends JsonSerializer<WorkLogoModel> {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Serializer.<init>():void");
                    }

                    public final void m13054a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                        r8 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m13055a(r0);
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
                        com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkCommunityParser.WorkLogoParser.m13091a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.class;
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$WorkLogoModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.Serializer.<clinit>():void");
                    }
                }

                public WorkLogoModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13057a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r0 = r2.f13007d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f13007d = r0;
                    r0 = r2.f13007d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.a():java.lang.String");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r1 = this;
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m13056a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m13055a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m13057a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            public WorkCommunityModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.<init>():void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void m13063a(java.lang.String r2, com.facebook.graphql.visitor.ConsistencyTuple r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = "name";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0018;
            L_0x0008:
                r0 = r1.m13065j();
                r3.a = r0;
                r0 = r1.u_();
                r3.b = r0;
                r0 = 1;
                r3.c = r0;
            L_0x0017:
                return;
            L_0x0018:
                r3.a();
                goto L_0x0017;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void m13064a(java.lang.String r2, java.lang.Object r3, boolean r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = "name";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x000d;
            L_0x0008:
                r3 = (java.lang.String) r3;
                r1.m13058a(r3);
            L_0x000d:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nullable
            private java.lang.String m13059l() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.f13008d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f13008d = r0;
                r0 = r2.f13008d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.l():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m13065j() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.f13009e;
                r1 = 1;
                r0 = super.a(r0, r1);
                r2.f13009e = r0;
                r0 = r2.f13009e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.j():java.lang.String");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void m13058a(@javax.annotation.Nullable java.lang.String r5) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                r4.f13009e = r5;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0015;
            L_0x0006:
                r0 = r4.b;
                r3 = r0.d;
                r0 = r3;
                if (r0 == 0) goto L_0x0015;
            L_0x000d:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 1;
                r0.a(r1, r2, r5);
            L_0x0015:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a(java.lang.String):void");
            }

            @javax.annotation.Nullable
            public final com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel m13066k() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r3 = this;
                r0 = r3.f13010f;
                r1 = 2;
                r2 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel) r0;
                r3.f13010f = r0;
                r0 = r3.f13010f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.k():com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel$WorkLogoModel");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            @javax.annotation.Nullable
            public final java.lang.String m13062a() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = r1.m13059l();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a():java.lang.String");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.jK_():int");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.facebook.graphql.visitor.GraphQLVisitableModel m13061a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                r0 = r3.m13066k();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m13066k();
                r0 = r4.b(r0);
                r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.WorkLogoModel) r0;
                r2 = r3.m13066k();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel) r1;
                r1.f13010f = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m13060a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r4.h();
                r0 = r4.m13059l();
                r0 = r5.b(r0);
                r1 = r4.m13065j();
                r1 = r5.b(r1);
                r2 = r4.m13066k();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r2);
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1903316288)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: expand_video */
        public final class WorkUsersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CommunityModel f13015d;
            @Nullable
            private String f13016e;
            @Nullable
            private String f13017f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 202013384)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: expand_video */
            public final class CommunityModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13012d;
                @Nullable
                private LogoModel f13013e;
                @Nullable
                private String f13014f;

                /* compiled from: expand_video */
                public class Deserializer extends FbJsonDeserializer {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.class;
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Deserializer.<clinit>():void");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public java.lang.Object m13067a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                        r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.CommunityParser.m13096a(r11, r4);
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
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: expand_video */
                public final class LogoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f13011d;

                    /* compiled from: expand_video */
                    public class Deserializer extends FbJsonDeserializer {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public Deserializer() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.class;
                            r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$LogoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Deserializer.<clinit>():void");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public java.lang.Object m13068a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.CommunityParser.LogoParser.m13094a(r11, r4);
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
                            r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$LogoModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: expand_video */
                    public class Serializer extends JsonSerializer<LogoModel> {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public Serializer() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                            /*
                            r0 = this;
                            r0.<init>();
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Serializer.<init>():void");
                        }

                        public final void m13069a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                            r7 = this;
                            r8 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m13071a(r0);
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
                            com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.CommunityParser.LogoParser.m13095a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.class;
                            r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$LogoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.Serializer.<clinit>():void");
                        }
                    }

                    public LogoModel() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m13070a() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r2 = this;
                        r0 = r2.f13011d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f13011d = r0;
                        r0 = r2.f13011d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.a():java.lang.String");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r1 = this;
                        r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m13072a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m13071a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m13070a();
                        r0 = r3.b(r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: expand_video */
                public class Serializer extends JsonSerializer<CommunityModel> {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Serializer.<init>():void");
                    }

                    public final void m13073a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                        r8 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m13077a(r0);
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
                        com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.CommunityParser.m13097a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.class;
                        r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.Serializer.<clinit>():void");
                    }
                }

                public CommunityModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r1 = this;
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.<init>():void");
                }

                @javax.annotation.Nullable
                private java.lang.String m13074a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r0 = r2.f13012d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f13012d = r0;
                    r0 = r2.f13012d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.a():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel m13075j() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r3 = this;
                    r0 = r3.f13013e;
                    r1 = 1;
                    r2 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel) r0;
                    r3.f13013e = r0;
                    r0 = r3.f13013e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.j():com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel$LogoModel");
                }

                @javax.annotation.Nullable
                private java.lang.String m13076k() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r0 = r2.f13014f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f13014f = r0;
                    r0 = r2.f13014f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.k():java.lang.String");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r1 = this;
                    r0 = -1282382541; // 0xffffffffb3906533 float:-6.7239306E-8 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.jK_():int");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final com.facebook.graphql.visitor.GraphQLVisitableModel m13078a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                    r0 = r3.m13075j();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m13075j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.LogoModel) r0;
                    r2 = r3.m13075j();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel) r1;
                    r1.f13013e = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m13077a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r4 = this;
                    r4.h();
                    r0 = r4.m13074a();
                    r0 = r5.b(r0);
                    r1 = r4.m13075j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = r4.m13076k();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: expand_video */
            public class Deserializer extends FbJsonDeserializer {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.class;
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Deserializer.<clinit>():void");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object m13079a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                    r5 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.m13098b(r11, r4);
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
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: expand_video */
            public class Serializer extends JsonSerializer<WorkUsersModel> {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Serializer.<init>():void");
                }

                public final void m13080a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                    r8 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m13084a(r0);
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
                    com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountParsers.FetchWorkCommunitiesFromPersonalAccountQueryParser.WorkUsersParser.m13099b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.class;
                    r1 = new com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.Serializer.<clinit>():void");
                }
            }

            public WorkUsersModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel m13081a() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r3 = this;
                r0 = r3.f13015d;
                r1 = 0;
                r2 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel) r0;
                r3.f13015d = r0;
                r0 = r3.f13015d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.a():com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel$CommunityModel");
            }

            @javax.annotation.Nullable
            private java.lang.String m13082j() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.f13016e;
                r1 = 1;
                r0 = super.a(r0, r1);
                r2.f13016e = r0;
                r0 = r2.f13016e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.j():java.lang.String");
            }

            @javax.annotation.Nullable
            private java.lang.String m13083k() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.f13017f;
                r1 = 2;
                r0 = super.a(r0, r1);
                r2.f13017f = r0;
                r0 = r2.f13017f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.k():java.lang.String");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = -506605033; // 0xffffffffe1cdd217 float:-4.7459014E20 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.jK_():int");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.facebook.graphql.visitor.GraphQLVisitableModel m13085a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
                r0 = r3.m13081a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m13081a();
                r0 = r4.b(r0);
                r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.CommunityModel) r0;
                r2 = r3.m13081a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel) r1;
                r1.f13015d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m13084a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r4.h();
                r0 = r4.m13081a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                r1 = r4.m13082j();
                r1 = r5.b(r1);
                r2 = r4.m13083k();
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public FetchWorkCommunitiesFromPersonalAccountQueryModel() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel m13089a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f13018d;
            r1 = 0;
            r2 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel) r0;
            r3.f13018d = r0;
            r0 = r3.f13018d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.a():com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkCommunityModel");
        }

        @javax.annotation.Nonnull
        private com.google.common.collect.ImmutableList<com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel> m13086j() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f13019e;
            r1 = 1;
            r2 = com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkUsersModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f13019e = r0;
            r0 = r3.f13019e;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.j():com.google.common.collect.ImmutableList<com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels$FetchWorkCommunitiesFromPersonalAccountQueryModel$WorkUsersModel>");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = -1732764110; // 0xffffffff98b81e32 float:-4.7593375E-24 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.jK_():int");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.graphql.visitor.GraphQLVisitableModel m13088a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:68)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:38)
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
            r0 = r3.m13089a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m13089a();
            r0 = r4.b(r0);
            r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel) r0;
            r2 = r3.m13089a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel) r1;
            r1.f13018d = r0;
        L_0x0022:
            r0 = r3.m13086j();
            if (r0 == 0) goto L_0x003f;
        L_0x0028:
            r0 = r3.m13086j();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
            if (r2 == 0) goto L_0x003f;
        L_0x0032:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r0 = (com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel) r0;
            r1 = r2.b();
            r0.f13019e = r1;
            r1 = r0;
        L_0x003f:
            r3.i();
            if (r1 != 0) goto L_0x0045;
        L_0x0044:
            return r3;
        L_0x0045:
            r3 = r1;
            goto L_0x0044;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m13087a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r3.h();
            r0 = r3.m13089a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m13086j();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
