package com.facebook.groups.memberrequests.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: TURN_ON_MESSAGING */
public class FetchMemberRequestsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -716599322)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TURN_ON_MESSAGING */
    public final class FetchMemberRequestsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private AdminAwareGroupModel f22985d;
        @Nullable
        private String f22986e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -6871693)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TURN_ON_MESSAGING */
        public final class AdminAwareGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private CoverPhotoModel f22979d;
            @Nullable
            private GroupPendingMembersModel f22980e;
            @Nullable
            private String f22981f;
            @Nullable
            private String f22982g;
            @Nullable
            private GraphQLGroupAdminType f22983h;
            @Nullable
            private VisibilitySentenceModel f22984i;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1543275506)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TURN_ON_MESSAGING */
            public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PhotoModel f22954d;

                /* compiled from: TURN_ON_MESSAGING */
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24043a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.m24156a(r11, r4);
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
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 247028168)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TURN_ON_MESSAGING */
                public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ImageModel f22953d;

                    /* compiled from: TURN_ON_MESSAGING */
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m24044a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.PhotoParser.m24154a(r11, r4);
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
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: TURN_ON_MESSAGING */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f22952d;

                        /* compiled from: TURN_ON_MESSAGING */
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$ImageModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m24045a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.PhotoParser.ImageParser.m24152a(r11, r4);
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
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$ImageModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: TURN_ON_MESSAGING */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m24046a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m24047a(r0);
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
                                com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.PhotoParser.ImageParser.m24153a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$ImageModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.Serializer.<clinit>():void");
                            }
                        }

                        public ImageModel() {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.<init>():void");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m24049a() {
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
                            r0 = r2.f22952d;
                            r1 = 0;
                            r0 = super.a(r0, r1);
                            r2.f22952d = r0;
                            r0 = r2.f22952d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.a():java.lang.String");
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
                            r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m24048a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m24047a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                            r0 = r2.m24049a();
                            r0 = r3.b(r0);
                            r1 = 1;
                            r3.c(r1);
                            r1 = 0;
                            r3.b(r1, r0);
                            r2.i();
                            r0 = r3.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }
                    }

                    /* compiled from: TURN_ON_MESSAGING */
                    public class Serializer extends JsonSerializer<PhotoModel> {
                        public final void m24050a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m24051a(r0);
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
                            com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.PhotoParser.m24155a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.Serializer.<clinit>():void");
                        }
                    }

                    public PhotoModel() {
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
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel m24053a() {
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
                        r3 = this;
                        r0 = r3.f22953d;
                        r1 = 0;
                        r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel) r0;
                        r3.f22953d = r0;
                        r0 = r3.f22953d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.a():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel$ImageModel");
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
                        r0 = 77090322; // 0x4984e12 float:3.5806725E-36 double:3.80876797E-316;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m24052a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m24053a();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m24053a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.ImageModel) r0;
                        r2 = r3.m24053a();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel) r1;
                        r1.f22953d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m24051a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                        r2 = this;
                        r2.h();
                        r0 = r2.m24053a();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: TURN_ON_MESSAGING */
                public class Serializer extends JsonSerializer<CoverPhotoModel> {
                    public final void m24054a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24055a(r0);
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
                        com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.CoverPhotoParser.m24157a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.Serializer.<clinit>():void");
                    }
                }

                public CoverPhotoModel() {
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
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel m24057a() {
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
                    r0 = r3.f22954d;
                    r1 = 0;
                    r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel) r0;
                    r3.f22954d = r0;
                    r0 = r3.f22954d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.a():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel$PhotoModel");
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
                    r0 = 497264923; // 0x1da3a91b float:4.332059E-21 double:2.456815153E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24056a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r1 = 0;
                    r3.h();
                    r0 = r3.m24057a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m24057a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.PhotoModel) r0;
                    r2 = r3.m24057a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel) r1;
                    r1.f22954d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24055a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2.h();
                    r0 = r2.m24057a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: TURN_ON_MESSAGING */
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
                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.class;
                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m24058a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.m24176a(r11, r4);
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
                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1639078275)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TURN_ON_MESSAGING */
            public final class GroupPendingMembersModel extends BaseModel implements GraphQLVisitableModel {
                private int f22975d;
                @Nullable
                private List<EdgesModel> f22976e;
                @Nullable
                private PageInfoModel f22977f;

                /* compiled from: TURN_ON_MESSAGING */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24059a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.m24172a(r11, r4);
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
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 226628219)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TURN_ON_MESSAGING */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    private int f22967d;
                    @Nullable
                    private InviterModel f22968e;
                    @Nullable
                    private NodeModel f22969f;
                    private long f22970g;

                    /* compiled from: TURN_ON_MESSAGING */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m24060a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.m24168b(r11, r4);
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
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1185712657)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: TURN_ON_MESSAGING */
                    public final class InviterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f22955d;
                        @Nullable
                        private String f22956e;

                        /* compiled from: TURN_ON_MESSAGING */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Deserializer.<init>():void");
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$InviterModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m24061a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.InviterParser.m24158a(r11, r4);
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
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$InviterModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: TURN_ON_MESSAGING */
                        public class Serializer extends JsonSerializer<InviterModel> {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Serializer.<init>():void");
                            }

                            public final void m24062a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m24063a(r0);
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
                                com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.InviterParser.m24159a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$InviterModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.Serializer.<clinit>():void");
                            }
                        }

                        public InviterModel() {
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
                            r0 = 2;
                            r1.<init>(r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.<init>():void");
                        }

                        public final void m24066a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                        }

                        public final void m24067a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.a(java.lang.String, java.lang.Object, boolean):void");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m24068j() {
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
                            r0 = r2.f22955d;
                            r1 = 0;
                            r0 = super.a(r0, r1);
                            r2.f22955d = r0;
                            r0 = r2.f22955d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.j():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m24069k() {
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
                            r0 = r2.f22956e;
                            r1 = 1;
                            r0 = super.a(r0, r1);
                            r2.f22956e = r0;
                            r0 = r2.f22956e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.k():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m24065a() {
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
                            r0 = r1.m24068j();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.a():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
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
                            r0 = 2645995; // 0x285feb float:3.707829E-39 double:1.307295E-317;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m24064a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m24063a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                            r3.h();
                            r0 = r3.m24068j();
                            r0 = r4.b(r0);
                            r1 = r3.m24069k();
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1931551493)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: TURN_ON_MESSAGING */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private GroupsModel f22960d;
                        @Nullable
                        private String f22961e;
                        @Nullable
                        private MutualFriendsModel f22962f;
                        @Nullable
                        private String f22963g;
                        @Nullable
                        private ProfilePictureModel f22964h;
                        private long f22965i;
                        @Nullable
                        private String f22966j;

                        /* compiled from: TURN_ON_MESSAGING */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Deserializer.<init>():void");
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public java.lang.Object m24070a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.m24166a(r11, r4);
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
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 461768017)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: TURN_ON_MESSAGING */
                        public final class GroupsModel extends BaseModel implements GraphQLVisitableModel {
                            private int f22957d;

                            /* compiled from: TURN_ON_MESSAGING */
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Deserializer.<init>():void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$GroupsModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m24071a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                    r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.GroupsParser.m24160a(r11, r4);
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
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$GroupsModel;
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: TURN_ON_MESSAGING */
                            public class Serializer extends JsonSerializer<GroupsModel> {
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Serializer.<init>():void");
                                }

                                public final void m24072a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                    r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m24074a(r0);
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
                                    com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.GroupsParser.m24161a(r0, r1, r9);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$GroupsModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.Serializer.<clinit>():void");
                                }
                            }

                            public GroupsModel() {
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
                                r0 = 1;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.<init>():void");
                            }

                            public final int m24073a() {
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
                                r0 = 0;
                                r1.a(r0, r0);
                                r0 = r1.f22957d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.a():int");
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
                                r0 = 222380018; // 0xd413ff2 float:5.954969E-31 double:1.09870327E-315;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24075a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m24074a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                                r1 = 0;
                                r2.h();
                                r0 = 1;
                                r3.c(r0);
                                r0 = r2.f22957d;
                                r3.a(r1, r0, r1);
                                r2.i();
                                r0 = r3.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }

                            public final void m24076a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                                r0 = 0;
                                super.a(r2, r3, r4);
                                r0 = r2.a(r3, r0, r0);
                                r1.f22957d = r0;
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1723990064)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: TURN_ON_MESSAGING */
                        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                            private int f22958d;

                            /* compiled from: TURN_ON_MESSAGING */
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Deserializer.<init>():void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$MutualFriendsModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m24077a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                    r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.MutualFriendsParser.m24162a(r11, r4);
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
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$MutualFriendsModel;
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: TURN_ON_MESSAGING */
                            public class Serializer extends JsonSerializer<MutualFriendsModel> {
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Serializer.<init>():void");
                                }

                                public final void m24078a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                    r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m24080a(r0);
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
                                    com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.MutualFriendsParser.m24163a(r0, r1, r9);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$MutualFriendsModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.Serializer.<clinit>():void");
                                }
                            }

                            public MutualFriendsModel() {
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
                                r0 = 1;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.<init>():void");
                            }

                            public final int m24079a() {
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
                                r0 = 0;
                                r1.a(r0, r0);
                                r0 = r1.f22958d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.a():int");
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
                                r0 = 1532278911; // 0x5b54b87f float:5.9875551E16 double:7.5704637E-315;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24081a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m24080a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                                r1 = 0;
                                r2.h();
                                r0 = 1;
                                r3.c(r0);
                                r0 = r2.f22958d;
                                r3.a(r1, r0, r1);
                                r2.i();
                                r0 = r3.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }

                            public final void m24082a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                                r0 = 0;
                                super.a(r2, r3, r4);
                                r0 = r2.a(r3, r0, r0);
                                r1.f22958d = r0;
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: TURN_ON_MESSAGING */
                        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f22959d;

                            /* compiled from: TURN_ON_MESSAGING */
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Deserializer.<init>():void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$ProfilePictureModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m24083a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                                    r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.ProfilePictureParser.m24164a(r11, r4);
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
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$ProfilePictureModel;
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            /* compiled from: TURN_ON_MESSAGING */
                            public class Serializer extends JsonSerializer<ProfilePictureModel> {
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Serializer.<init>():void");
                                }

                                public final void m24084a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                    r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel) r8;
                                    r2 = 0;
                                    r0 = r8.w_();
                                    if (r0 != 0) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                    r0.<init>(r1);
                                    r1 = r8.m24085a(r0);
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
                                    com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.ProfilePictureParser.m24165a(r0, r1, r9);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.class;
                                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$ProfilePictureModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.Serializer.<clinit>():void");
                                }
                            }

                            public ProfilePictureModel() {
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
                                r0 = 1;
                                r1.<init>(r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.<init>():void");
                            }

                            @javax.annotation.Nullable
                            public final java.lang.String m24087a() {
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
                                r0 = r2.f22959d;
                                r1 = 0;
                                r0 = super.a(r0, r1);
                                r2.f22959d = r0;
                                r0 = r2.f22959d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.a():java.lang.String");
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
                                r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24086a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m24085a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                                r2.h();
                                r0 = r2.m24087a();
                                r0 = r3.b(r0);
                                r1 = 1;
                                r3.c(r1);
                                r1 = 0;
                                r3.b(r1, r0);
                                r2.i();
                                r0 = r3.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }
                        }

                        /* compiled from: TURN_ON_MESSAGING */
                        public class Serializer extends JsonSerializer<NodeModel> {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Serializer.<init>():void");
                            }

                            public final void m24088a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                                r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m24090a(r0);
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
                                com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.NodeParser.m24167a(r0, r1, r9, r10);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.class;
                                r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                            }
                        }

                        public NodeModel() {
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
                            r0 = 7;
                            r1.<init>(r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.<init>():void");
                        }

                        public final void m24094a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                        }

                        public final void m24095a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel m24097j() {
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
                            r0 = r3.f22960d;
                            r1 = 0;
                            r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel) r0;
                            r3.f22960d = r0;
                            r0 = r3.f22960d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.j():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$GroupsModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m24096b() {
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
                            r0 = r2.f22961e;
                            r1 = 1;
                            r0 = super.a(r0, r1);
                            r2.f22961e = r0;
                            r0 = r2.f22961e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.b():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel m24098k() {
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
                            r0 = r3.f22962f;
                            r1 = 2;
                            r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel) r0;
                            r3.f22962f = r0;
                            r0 = r3.f22962f;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.k():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$MutualFriendsModel");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m24099l() {
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
                            r0 = r2.f22963g;
                            r1 = 3;
                            r0 = super.a(r0, r1);
                            r2.f22963g = r0;
                            r0 = r2.f22963g;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.l():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel m24100m() {
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
                            r0 = r3.f22964h;
                            r1 = 4;
                            r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel.class;
                            r0 = super.a(r0, r1, r2);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel) r0;
                            r3.f22964h = r0;
                            r0 = r3.f22964h;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.m():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel$ProfilePictureModel");
                        }

                        public final long m24101n() {
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
                            r1 = 5;
                            r2.a(r0, r1);
                            r0 = r2.f22965i;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.n():long");
                        }

                        @javax.annotation.Nullable
                        private java.lang.String m24089o() {
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
                            r0 = r2.f22966j;
                            r1 = 6;
                            r0 = super.a(r0, r1);
                            r2.f22966j = r0;
                            r0 = r2.f22966j;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.o():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m24092a() {
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
                            r0 = r1.m24096b();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a():java.lang.String");
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
                            r0 = 2645995; // 0x285feb float:3.707829E-39 double:1.307295E-317;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m24091a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                            r0 = r3.m24097j();
                            if (r0 == 0) goto L_0x0022;
                        L_0x000a:
                            r0 = r3.m24097j();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.GroupsModel) r0;
                            r2 = r3.m24097j();
                            if (r2 == r0) goto L_0x0022;
                        L_0x001a:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r1;
                            r1.f22960d = r0;
                        L_0x0022:
                            r0 = r3.m24098k();
                            if (r0 == 0) goto L_0x0040;
                        L_0x0028:
                            r0 = r3.m24098k();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.MutualFriendsModel) r0;
                            r2 = r3.m24098k();
                            if (r2 == r0) goto L_0x0040;
                        L_0x0038:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r1;
                            r1.f22962f = r0;
                        L_0x0040:
                            r0 = r3.m24100m();
                            if (r0 == 0) goto L_0x005e;
                        L_0x0046:
                            r0 = r3.m24100m();
                            r0 = r4.b(r0);
                            r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.ProfilePictureModel) r0;
                            r2 = r3.m24100m();
                            if (r2 == r0) goto L_0x005e;
                        L_0x0056:
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r1;
                            r1.f22964h = r0;
                        L_0x005e:
                            r3.i();
                            if (r1 != 0) goto L_0x0064;
                        L_0x0063:
                            return r3;
                        L_0x0064:
                            r3 = r1;
                            goto L_0x0063;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m24090a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                            r7.h();
                            r0 = r7.m24097j();
                            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
                            r1 = r7.m24096b();
                            r1 = r8.b(r1);
                            r2 = r7.m24098k();
                            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r2);
                            r3 = r7.m24099l();
                            r3 = r8.b(r3);
                            r4 = r7.m24100m();
                            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r4);
                            r5 = r7.m24089o();
                            r6 = r8.b(r5);
                            r5 = 7;
                            r8.c(r5);
                            r5 = 0;
                            r8.b(r5, r0);
                            r0 = 1;
                            r8.b(r0, r1);
                            r0 = 2;
                            r8.b(r0, r2);
                            r0 = 3;
                            r8.b(r0, r3);
                            r0 = 4;
                            r8.b(r0, r4);
                            r1 = 5;
                            r2 = r7.f22965i;
                            r4 = 0;
                            r0 = r8;
                            r0.a(r1, r2, r4);
                            r0 = 6;
                            r8.b(r0, r6);
                            r7.i();
                            r0 = r8.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public final void m24093a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                            super.a(r5, r6, r7);
                            r0 = 5;
                            r2 = 0;
                            r0 = r5.a(r6, r0, r2);
                            r4.f22965i = r0;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                        }
                    }

                    /* compiled from: TURN_ON_MESSAGING */
                    public class Serializer extends JsonSerializer<EdgesModel> {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Serializer.<init>():void");
                        }

                        public final void m24102a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m24103a(r0);
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
                            com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.EdgesParser.m24169b(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.Serializer.<clinit>():void");
                        }
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel m24105a() {
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
                        r0 = r1.m24109l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.a():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel");
                    }

                    public EdgesModel() {
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
                        r0 = 4;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.<init>():void");
                    }

                    public final int m24107j() {
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
                        r0 = 0;
                        r1.a(r0, r0);
                        r0 = r1.f22967d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.j():int");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel m24108k() {
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
                        r0 = r3.f22968e;
                        r1 = 1;
                        r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel) r0;
                        r3.f22968e = r0;
                        r0 = r3.f22968e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.k():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$InviterModel");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel m24109l() {
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
                        r0 = r3.f22969f;
                        r1 = 2;
                        r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r0;
                        r3.f22969f = r0;
                        r0 = r3.f22969f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.l():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel$NodeModel");
                    }

                    public final long m24110m() {
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
                        r0 = r2.f22970g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.m():long");
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
                        r0 = -3405538; // 0xffffffffffcc091e float:NaN double:NaN;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m24104a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                        r0 = r3.m24108k();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m24108k();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.InviterModel) r0;
                        r2 = r3.m24108k();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel) r1;
                        r1.f22968e = r0;
                    L_0x0022:
                        r0 = r3.m24109l();
                        if (r0 == 0) goto L_0x0040;
                    L_0x0028:
                        r0 = r3.m24109l();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.NodeModel) r0;
                        r2 = r3.m24109l();
                        if (r2 == r0) goto L_0x0040;
                    L_0x0038:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel) r1;
                        r1.f22969f = r0;
                    L_0x0040:
                        r3.i();
                        if (r1 != 0) goto L_0x0046;
                    L_0x0045:
                        return r3;
                    L_0x0046:
                        r3 = r1;
                        goto L_0x0045;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m24103a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
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
                        r6 = this;
                        r3 = 0;
                        r6.h();
                        r0 = r6.m24108k();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r0);
                        r1 = r6.m24109l();
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r1);
                        r2 = 4;
                        r7.c(r2);
                        r2 = r6.f22967d;
                        r7.a(r3, r2, r3);
                        r2 = 1;
                        r7.b(r2, r0);
                        r0 = 2;
                        r7.b(r0, r1);
                        r1 = 3;
                        r2 = r6.f22970g;
                        r4 = 0;
                        r0 = r7;
                        r0.a(r1, r2, r4);
                        r6.i();
                        r0 = r7.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m24106a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                        r0 = 0;
                        super.a(r5, r6, r7);
                        r0 = r5.a(r6, r0, r0);
                        r4.f22967d = r0;
                        r0 = 3;
                        r2 = 0;
                        r0 = r5.a(r6, r0, r2);
                        r4.f22970g = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 921619519)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TURN_ON_MESSAGING */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f22971d;
                    private boolean f22972e;
                    private boolean f22973f;
                    @Nullable
                    private String f22974g;

                    /* compiled from: TURN_ON_MESSAGING */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$PageInfoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m24111a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.PageInfoParser.m24170a(r11, r4);
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
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$PageInfoModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: TURN_ON_MESSAGING */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Serializer.<init>():void");
                        }

                        public final void m24112a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m24114a(r0);
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
                            com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.PageInfoParser.m24171a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.class;
                            r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$PageInfoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.Serializer.<clinit>():void");
                        }
                    }

                    public PageInfoModel() {
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
                        r0 = 4;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m24116a() {
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
                        r0 = r2.f22971d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f22971d = r0;
                        r0 = r2.f22971d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.a():java.lang.String");
                    }

                    public final boolean m24118j() {
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
                        r1 = 1;
                        r2.a(r0, r1);
                        r0 = r2.f22972e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.j():boolean");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m24113k() {
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
                        r0 = r2.f22974g;
                        r1 = 3;
                        r0 = super.a(r0, r1);
                        r2.f22974g = r0;
                        r0 = r2.f22974g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.k():java.lang.String");
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
                        r0 = 923779069; // 0x370fbffd float:8.568165E-6 double:4.564075023E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m24115a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m24114a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                        r3.h();
                        r0 = r3.m24116a();
                        r0 = r4.b(r0);
                        r1 = r3.m24113k();
                        r1 = r4.b(r1);
                        r2 = 4;
                        r4.c(r2);
                        r2 = 0;
                        r4.b(r2, r0);
                        r0 = 1;
                        r2 = r3.f22972e;
                        r4.a(r0, r2);
                        r0 = 2;
                        r2 = r3.f22973f;
                        r4.a(r0, r2);
                        r0 = 3;
                        r4.b(r0, r1);
                        r3.i();
                        r0 = r4.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m24117a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                        super.a(r2, r3, r4);
                        r0 = 1;
                        r0 = r2.a(r3, r0);
                        r1.f22972e = r0;
                        r0 = 2;
                        r0 = r2.a(r3, r0);
                        r1.f22973f = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: TURN_ON_MESSAGING */
                public class Serializer extends JsonSerializer<GroupPendingMembersModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Serializer.<init>():void");
                    }

                    public final void m24119a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r7 = this;
                        r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24120a(r0);
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
                        com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.GroupPendingMembersParser.m24173a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.Serializer.<clinit>():void");
                    }
                }

                public GroupPendingMembersModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel> m24122a() {
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
                    r0 = r3.f22976e;
                    r1 = 1;
                    r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f22976e = r0;
                    r0 = r3.f22976e;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$EdgesModel>");
                }

                @javax.annotation.Nullable
                public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel m24124j() {
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
                    r0 = r3.f22977f;
                    r1 = 2;
                    r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel) r0;
                    r3.f22977f = r0;
                    r0 = r3.f22977f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.j():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel$PageInfoModel");
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
                    r0 = 494751103; // 0x1d7d4d7f float:3.3524336E-21 double:2.44439523E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24121a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r0 = 0;
                    r3.h();
                    r1 = r3.m24122a();
                    if (r1 == 0) goto L_0x0047;
                L_0x000a:
                    r1 = r3.m24122a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0047;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel) r0;
                    r1 = r1.b();
                    r0.f22976e = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m24124j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m24124j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.PageInfoModel) r0;
                    r2 = r3.m24124j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel) r1;
                    r1.f22977f = r0;
                L_0x003f:
                    r3.i();
                    if (r1 != 0) goto L_0x0045;
                L_0x0044:
                    return r3;
                L_0x0045:
                    r3 = r1;
                    goto L_0x0044;
                L_0x0047:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24120a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4 = this;
                    r3 = 0;
                    r4.h();
                    r0 = r4.m24122a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m24124j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = 3;
                    r5.c(r2);
                    r2 = r4.f22975d;
                    r5.a(r3, r2, r3);
                    r2 = 1;
                    r5.b(r2, r0);
                    r0 = 2;
                    r5.b(r0, r1);
                    r4.i();
                    r0 = r5.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m24123a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                    r0 = 0;
                    super.a(r2, r3, r4);
                    r0 = r2.a(r3, r0, r0);
                    r1.f22975d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: TURN_ON_MESSAGING */
            public class Serializer extends JsonSerializer<AdminAwareGroupModel> {
                public final void m24125a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m24133a(r0);
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
                    com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.m24177a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.class;
                    r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.Serializer.<clinit>():void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TURN_ON_MESSAGING */
            public final class VisibilitySentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f22978d;

                /* compiled from: TURN_ON_MESSAGING */
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$VisibilitySentenceModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24126a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.VisibilitySentenceParser.m24174a(r11, r4);
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
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$VisibilitySentenceModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: TURN_ON_MESSAGING */
                public class Serializer extends JsonSerializer<VisibilitySentenceModel> {
                    public final void m24127a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24128a(r0);
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
                        com.facebook.groups.memberrequests.protocol.FetchMemberRequestsParsers.FetchMemberRequestsParser.AdminAwareGroupParser.VisibilitySentenceParser.m24175a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.class;
                        r1 = new com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$VisibilitySentenceModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.Serializer.<clinit>():void");
                    }
                }

                public VisibilitySentenceModel() {
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
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m24130a() {
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
                    r0 = r2.f22978d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f22978d = r0;
                    r0 = r2.f22978d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.a():java.lang.String");
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
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24129a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24128a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2.h();
                    r0 = r2.m24130a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            public AdminAwareGroupModel() {
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
                r0 = 6;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.<init>():void");
            }

            public final void m24136a(java.lang.String r2, com.facebook.graphql.visitor.ConsistencyTuple r3) {
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
                r0 = "name";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0018;
            L_0x0008:
                r0 = r1.m24140l();
                r3.a = r0;
                r0 = r1.u_();
                r3.b = r0;
                r0 = 3;
                r3.c = r0;
            L_0x0017:
                return;
            L_0x0018:
                r3.a();
                goto L_0x0017;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            public final void m24137a(java.lang.String r2, java.lang.Object r3, boolean r4) {
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
                r0 = "name";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x000d;
            L_0x0008:
                r3 = (java.lang.String) r3;
                r1.m24131a(r3);
            L_0x000d:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel m24138j() {
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
                r0 = r3.f22979d;
                r1 = 0;
                r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel) r0;
                r3.f22979d = r0;
                r0 = r3.f22979d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.j():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$CoverPhotoModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel m24139k() {
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
                r0 = r3.f22980e;
                r1 = 1;
                r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel) r0;
                r3.f22980e = r0;
                r0 = r3.f22980e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.k():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$GroupPendingMembersModel");
            }

            @javax.annotation.Nullable
            private java.lang.String m24132o() {
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
                r0 = r2.f22981f;
                r1 = 2;
                r0 = super.a(r0, r1);
                r2.f22981f = r0;
                r0 = r2.f22981f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.o():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m24140l() {
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
                r0 = r2.f22982g;
                r1 = 3;
                r0 = super.a(r0, r1);
                r2.f22982g = r0;
                r0 = r2.f22982g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.l():java.lang.String");
            }

            private void m24131a(@javax.annotation.Nullable java.lang.String r5) {
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
                r4.f22982g = r5;
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
                r2 = 3;
                r0.a(r1, r2, r5);
            L_0x0015:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a(java.lang.String):void");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.enums.GraphQLGroupAdminType m24141m() {
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
                r0 = r4.f22983h;
                r1 = 4;
                r2 = com.facebook.graphql.enums.GraphQLGroupAdminType.class;
                r3 = com.facebook.graphql.enums.GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                r0 = super.b(r0, r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLGroupAdminType) r0;
                r4.f22983h = r0;
                r0 = r4.f22983h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.m():com.facebook.graphql.enums.GraphQLGroupAdminType");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel m24142n() {
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
                r0 = r3.f22984i;
                r1 = 5;
                r2 = com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel) r0;
                r3.f22984i = r0;
                r0 = r3.f22984i;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.n():com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels$FetchMemberRequestsModel$AdminAwareGroupModel$VisibilitySentenceModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m24135a() {
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
                r0 = r1.m24132o();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a():java.lang.String");
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
                r0 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24134a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m24138j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m24138j();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.CoverPhotoModel) r0;
                r2 = r3.m24138j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel) r1;
                r1.f22979d = r0;
            L_0x0022:
                r0 = r3.m24139k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m24139k();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel) r0;
                r2 = r3.m24139k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel) r1;
                r1.f22980e = r0;
            L_0x0040:
                r0 = r3.m24142n();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m24142n();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.VisibilitySentenceModel) r0;
                r2 = r3.m24142n();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel) r1;
                r1.f22984i = r0;
            L_0x005e:
                r3.i();
                if (r1 != 0) goto L_0x0064;
            L_0x0063:
                return r3;
            L_0x0064:
                r3 = r1;
                goto L_0x0063;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m24133a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
                r7.h();
                r0 = r7.m24138j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
                r1 = r7.m24139k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r1);
                r2 = r7.m24132o();
                r2 = r8.b(r2);
                r3 = r7.m24140l();
                r3 = r8.b(r3);
                r4 = r7.m24141m();
                r4 = r8.a(r4);
                r5 = r7.m24142n();
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r5);
                r6 = 6;
                r8.c(r6);
                r6 = 0;
                r8.b(r6, r0);
                r0 = 1;
                r8.b(r0, r1);
                r0 = 2;
                r8.b(r0, r2);
                r0 = 3;
                r8.b(r0, r3);
                r0 = 4;
                r8.b(r0, r4);
                r0 = 5;
                r8.b(r0, r5);
                r7.i();
                r0 = r8.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: TURN_ON_MESSAGING */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMemberRequestsModel.class, new Deserializer());
            }

            public Object m24143a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMemberRequestsParser.m24178a(jsonParser);
                Object fetchMemberRequestsModel = new FetchMemberRequestsModel();
                ((BaseModel) fetchMemberRequestsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMemberRequestsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMemberRequestsModel).a();
                }
                return fetchMemberRequestsModel;
            }
        }

        /* compiled from: TURN_ON_MESSAGING */
        public class Serializer extends JsonSerializer<FetchMemberRequestsModel> {
            public final void m24144a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMemberRequestsModel fetchMemberRequestsModel = (FetchMemberRequestsModel) obj;
                if (fetchMemberRequestsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMemberRequestsModel.m24145a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMemberRequestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMemberRequestsModel.w_();
                int u_ = fetchMemberRequestsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_aware_group");
                    AdminAwareGroupParser.m24177a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMemberRequestsModel.class, new Serializer());
            }
        }

        public FetchMemberRequestsModel() {
            super(2);
        }

        public final void m24148a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24149a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminAwareGroupModel m24150j() {
            this.f22985d = (AdminAwareGroupModel) super.a(this.f22985d, 0, AdminAwareGroupModel.class);
            return this.f22985d;
        }

        @Nullable
        public final String m24151k() {
            this.f22986e = super.a(this.f22986e, 1);
            return this.f22986e;
        }

        @Nullable
        public final String m24147a() {
            return m24151k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m24146a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24150j() != null) {
                AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m24150j());
                if (m24150j() != adminAwareGroupModel) {
                    graphQLVisitableModel = (FetchMemberRequestsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22985d = adminAwareGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24145a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24150j());
            int b = flatBufferBuilder.b(m24151k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
