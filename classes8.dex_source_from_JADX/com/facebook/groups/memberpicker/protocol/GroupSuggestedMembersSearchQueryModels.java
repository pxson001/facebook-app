package com.facebook.groups.memberpicker.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataInterfaces.FBTaggableUserFragment;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBTaggableUserFragmentModel.BylinesModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: event_card_maybe_tap */
public class GroupSuggestedMembersSearchQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1647779386)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_card_maybe_tap */
    public final class GroupSuggestedMembersSearchQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f14712d;
        @Nullable
        private String f14713e;
        @Nullable
        private SuggestedMembersModel f14714f;

        /* compiled from: event_card_maybe_tap */
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
                r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.class;
                r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m16767a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.m16820a(r6);
                r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: event_card_maybe_tap */
        public class Serializer extends JsonSerializer<GroupSuggestedMembersSearchQueryModel> {
            public final void m16768a(java.lang.Object r10, com.fasterxml.jackson.core.JsonGenerator r11, com.fasterxml.jackson.databind.SerializerProvider r12) {
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
                r10 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel) r10;
                r2 = 0;
                r0 = r10.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r10.m16806a(r0);
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
                r7 = 0;
                r11.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x0050;
            L_0x0048:
                r6 = "__type__";
                r11.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r11);
            L_0x0050:
                r6 = r0.g(r1, r8);
                if (r6 == 0) goto L_0x0062;
            L_0x0056:
                r6 = "id";
                r11.a(r6);
                r6 = r0.c(r1, r8);
                r11.b(r6);
            L_0x0062:
                r6 = 2;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0071;
            L_0x0069:
                r7 = "suggested_members";
                r11.a(r7);
                com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.m16819a(r0, r6, r11, r12);
            L_0x0071:
                r11.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.class;
                r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -769474695)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_card_maybe_tap */
        public final class SuggestedMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f14710d;
            @Nullable
            private PageInfoModel f14711e;

            /* compiled from: event_card_maybe_tap */
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
                    r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.class;
                    r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m16769a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
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
                    r5 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.m16818a(r11, r4);
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
                    r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 39120046)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_card_maybe_tap */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f14705d;

                /* compiled from: event_card_maybe_tap */
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
                        r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.class;
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m16770a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
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
                        r5 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.EdgesParser.m16814b(r11, r4);
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
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1206423124)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: event_card_maybe_tap */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBTaggableUserFragment {
                    @Nullable
                    private List<BylinesModel> f14698d;
                    private double f14699e;
                    @Nullable
                    private String f14700f;
                    @Nullable
                    private String f14701g;
                    @Nullable
                    private List<String> f14702h;
                    @Nullable
                    private FullImageFragmentModel f14703i;
                    @Nullable
                    private FBNameFragmentModel f14704j;

                    /* compiled from: event_card_maybe_tap */
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
                            r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$NodeModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m16771a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
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
                            r5 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.EdgesParser.NodeParser.m16812a(r11, r4);
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
                            r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$NodeModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: event_card_maybe_tap */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16772a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
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
                            r8 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m16776a(r0);
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
                            com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.EdgesParser.NodeParser.m16813a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$NodeModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                        }
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel mo894m() {
                        /* JADX: method processing error */
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
                        r0 = r1.m16774o();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.m():com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels$FullImageFragmentModel");
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.<init>():void");
                    }

                    public final void m16780a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                        /* JADX: method processing error */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                    }

                    public final void m16781a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                        /* JADX: method processing error */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                    }

                    @javax.annotation.Nonnull
                    private com.google.common.collect.ImmutableList<com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBTaggableUserFragmentModel.BylinesModel> m16773n() {
                        /* JADX: method processing error */
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
                        r0 = r3.f14698d;
                        r1 = 0;
                        r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBTaggableUserFragmentModel.BylinesModel.class;
                        r0 = super.a(r0, r1, r2);
                        r3.f14698d = r0;
                        r0 = r3.f14698d;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.n():com.google.common.collect.ImmutableList<com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels$FBTaggableUserFragmentModel$BylinesModel>");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String mo891j() {
                        /* JADX: method processing error */
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
                        r0 = r2.f14700f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f14700f = r0;
                        r0 = r2.f14700f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.j():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String mo892k() {
                        /* JADX: method processing error */
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
                        r0 = r2.f14701g;
                        r1 = 3;
                        r0 = super.a(r0, r1);
                        r2.f14701g = r0;
                        r0 = r2.f14701g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.k():java.lang.String");
                    }

                    @javax.annotation.Nonnull
                    public final com.google.common.collect.ImmutableList<java.lang.String> mo893l() {
                        /* JADX: method processing error */
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
                        r0 = r2.f14702h;
                        r1 = 4;
                        r0 = super.a(r0, r1);
                        r2.f14702h = r0;
                        r0 = r2.f14702h;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.l():com.google.common.collect.ImmutableList<java.lang.String>");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel m16774o() {
                        /* JADX: method processing error */
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
                        r0 = r3.f14703i;
                        r1 = 5;
                        r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel) r0;
                        r3.f14703i = r0;
                        r0 = r3.f14703i;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.o():com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels$FullImageFragmentModel");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel m16775p() {
                        /* JADX: method processing error */
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
                        r0 = r3.f14704j;
                        r1 = 6;
                        r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel) r0;
                        r3.f14704j = r0;
                        r0 = r3.f14704j;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.p():com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels$FBNameFragmentModel");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m16778a() {
                        /* JADX: method processing error */
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
                        r0 = r1.mo891j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a():java.lang.String");
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
                        r0 = 2645995; // 0x285feb float:3.707829E-39 double:1.307295E-317;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m16777a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
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
                        r0 = 0;
                        r3.h();
                        r1 = r3.m16773n();
                        if (r1 == 0) goto L_0x0065;
                    L_0x000a:
                        r1 = r3.m16773n();
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                        if (r1 == 0) goto L_0x0065;
                    L_0x0014:
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                        r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r0;
                        r1 = r1.b();
                        r0.f14698d = r1;
                        r1 = r0;
                    L_0x0021:
                        r0 = r3.m16774o();
                        if (r0 == 0) goto L_0x003f;
                    L_0x0027:
                        r0 = r3.m16774o();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel) r0;
                        r2 = r3.m16774o();
                        if (r2 == r0) goto L_0x003f;
                    L_0x0037:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r1;
                        r1.f14703i = r0;
                    L_0x003f:
                        r0 = r3.m16775p();
                        if (r0 == 0) goto L_0x005d;
                    L_0x0045:
                        r0 = r3.m16775p();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FBNameFragmentModel) r0;
                        r2 = r3.m16775p();
                        if (r2 == r0) goto L_0x005d;
                    L_0x0055:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r1;
                        r1.f14704j = r0;
                    L_0x005d:
                        r3.i();
                        if (r1 != 0) goto L_0x0063;
                    L_0x0062:
                        return r3;
                    L_0x0063:
                        r3 = r1;
                        goto L_0x0062;
                    L_0x0065:
                        r1 = r0;
                        goto L_0x0021;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m16776a(com.facebook.flatbuffers.FlatBufferBuilder r12) {
                        /* JADX: method processing error */
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
                        r11 = this;
                        r11.h();
                        r0 = r11.m16773n();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r0);
                        r1 = r11.mo891j();
                        r6 = r12.b(r1);
                        r1 = r11.mo892k();
                        r7 = r12.b(r1);
                        r1 = r11.mo893l();
                        r8 = r12.c(r1);
                        r1 = r11.m16774o();
                        r9 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r1);
                        r1 = r11.m16775p();
                        r10 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r1);
                        r1 = 7;
                        r12.c(r1);
                        r1 = 0;
                        r12.b(r1, r0);
                        r1 = 1;
                        r2 = r11.f14699e;
                        r4 = 0;
                        r0 = r12;
                        r0.a(r1, r2, r4);
                        r0 = 2;
                        r12.b(r0, r6);
                        r0 = 3;
                        r12.b(r0, r7);
                        r0 = 4;
                        r12.b(r0, r8);
                        r0 = 5;
                        r12.b(r0, r9);
                        r0 = 6;
                        r12.b(r0, r10);
                        r11.i();
                        r0 = r12.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m16779a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
                        /* JADX: method processing error */
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
                        super.a(r5, r6, r7);
                        r0 = 1;
                        r2 = 0;
                        r0 = r5.a(r6, r0, r2);
                        r4.f14699e = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: event_card_maybe_tap */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m16786a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
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
                        r8 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m16788a(r0);
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
                        com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.EdgesParser.m16815b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.class;
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel m16790a() {
                    /* JADX: method processing error */
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
                    r0 = r1.m16787j();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.a():com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$NodeModel");
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.<init>():void");
                }

                @javax.annotation.Nullable
                private com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel m16787j() {
                    /* JADX: method processing error */
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
                    r0 = r3.f14705d;
                    r1 = 0;
                    r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r0;
                    r3.f14705d = r0;
                    r0 = r3.f14705d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.j():com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel$NodeModel");
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
                    r0 = 899908690; // 0x35a38452 float:1.2182957E-6 double:4.44613968E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m16789a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
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
                    r0 = r3.m16787j();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m16787j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.NodeModel) r0;
                    r2 = r3.m16787j();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel) r1;
                    r1.f14705d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m16788a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
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
                    r0 = r2.m16787j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 921619519)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_card_maybe_tap */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14706d;
                private boolean f14707e;
                private boolean f14708f;
                @Nullable
                private String f14709g;

                /* compiled from: event_card_maybe_tap */
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
                        r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.class;
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$PageInfoModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m16791a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
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
                        r5 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.PageInfoParser.m16816a(r11, r4);
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
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$PageInfoModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: event_card_maybe_tap */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m16792a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
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
                        r8 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m16794a(r0);
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
                        com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.PageInfoParser.m16817a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.class;
                        r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$PageInfoModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.Serializer.<clinit>():void");
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m16796a() {
                    /* JADX: method processing error */
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
                    r0 = r2.f14706d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f14706d = r0;
                    r0 = r2.f14706d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.a():java.lang.String");
                }

                public final boolean m16798j() {
                    /* JADX: method processing error */
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
                    r1 = 1;
                    r2.a(r0, r1);
                    r0 = r2.f14707e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.j():boolean");
                }

                @javax.annotation.Nullable
                private java.lang.String m16793k() {
                    /* JADX: method processing error */
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
                    r0 = r2.f14709g;
                    r1 = 3;
                    r0 = super.a(r0, r1);
                    r2.f14709g = r0;
                    r0 = r2.f14709g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.k():java.lang.String");
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
                    r0 = 923779069; // 0x370fbffd float:8.568165E-6 double:4.564075023E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m16795a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m16794a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
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
                    r0 = r3.m16796a();
                    r0 = r4.b(r0);
                    r1 = r3.m16793k();
                    r1 = r4.b(r1);
                    r2 = 4;
                    r4.c(r2);
                    r2 = 0;
                    r4.b(r2, r0);
                    r0 = 1;
                    r2 = r3.f14707e;
                    r4.a(r0, r2);
                    r0 = 2;
                    r2 = r3.f14708f;
                    r4.a(r0, r2);
                    r0 = 3;
                    r4.b(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m16797a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
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
                    super.a(r2, r3, r4);
                    r0 = 1;
                    r0 = r2.a(r3, r0);
                    r1.f14707e = r0;
                    r0 = 2;
                    r0 = r2.a(r3, r0);
                    r1.f14708f = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: event_card_maybe_tap */
            public class Serializer extends JsonSerializer<SuggestedMembersModel> {
                public final void m16799a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
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
                    r8 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m16800a(r0);
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
                    com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryParsers.GroupSuggestedMembersSearchQueryParser.SuggestedMembersParser.m16819a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.class;
                    r1 = new com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.Serializer.<clinit>():void");
                }
            }

            public SuggestedMembersModel() {
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
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel> m16802a() {
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
                r0 = r3.f14710d;
                r1 = 0;
                r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f14710d = r0;
                r0 = r3.f14710d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.a():com.google.common.collect.ImmutableList<com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$EdgesModel>");
            }

            @javax.annotation.Nullable
            public final com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel m16803j() {
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
                r0 = r3.f14711e;
                r1 = 1;
                r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel) r0;
                r3.f14711e = r0;
                r0 = r3.f14711e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.j():com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel$PageInfoModel");
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
                r0 = -1286565453; // 0xffffffffb35091b3 float:-4.8561287E-8 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m16801a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r1 = r3.m16802a();
                if (r1 == 0) goto L_0x0047;
            L_0x000a:
                r1 = r3.m16802a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                if (r1 == 0) goto L_0x0047;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel) r0;
                r1 = r1.b();
                r0.f14710d = r1;
                r1 = r0;
            L_0x0021:
                r0 = r3.m16803j();
                if (r0 == 0) goto L_0x003f;
            L_0x0027:
                r0 = r3.m16803j();
                r0 = r4.b(r0);
                r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel) r0;
                r2 = r3.m16803j();
                if (r2 == r0) goto L_0x003f;
            L_0x0037:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel) r1;
                r1.f14711e = r0;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m16800a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                r0 = r3.m16802a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m16803j();
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public GroupSuggestedMembersSearchQueryModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.<init>():void");
        }

        public final void m16809a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m16810a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m16804k() {
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
            r0 = r4.b;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r4.f14712d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f14712d = r0;
        L_0x0017:
            r0 = r4.f14712d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.k():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nullable
        private java.lang.String m16805l() {
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
            r0 = r2.f14713e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f14713e = r0;
            r0 = r2.f14713e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.l():java.lang.String");
        }

        @javax.annotation.Nullable
        public final com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel m16811j() {
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
            r0 = r3.f14714f;
            r1 = 2;
            r2 = com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel) r0;
            r3.f14714f = r0;
            r0 = r3.f14714f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.j():com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels$GroupSuggestedMembersSearchQueryModel$SuggestedMembersModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m16808a() {
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
            r0 = r1.m16805l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.a():java.lang.String");
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
            r0 = 2433570; // 0x252222 float:3.410158E-39 double:1.2023433E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m16807a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m16811j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m16811j();
            r0 = r4.b(r0);
            r0 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel) r0;
            r2 = r3.m16811j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel) r1;
            r1.f14714f = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m16806a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
            r4.h();
            r0 = r4.m16804k();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
            r1 = r4.m16805l();
            r1 = r5.b(r1);
            r2 = r4.m16811j();
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
