package com.facebook.addresstypeahead.protocol;

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

/* compiled from: sent. */
public class AddressTypeAheadQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -81548939)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sent. */
    public final class AddressTypeAheadQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StreetResultsModel f3928d;

        /* compiled from: sent. */
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Deserializer.<init>():void");
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
                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.class;
                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m3771a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.m3820a(r6);
                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: sent. */
        public class Serializer extends JsonSerializer<AddressTypeAheadQueryModel> {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Serializer.<init>():void");
            }

            public final void m3772a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r9 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m3810a(r0);
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
                r7 = "street_results";
                r10.a(r7);
                com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.m3819a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.class;
                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1670192824)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sent. */
        public final class StreetResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3927d;

            /* compiled from: sent. */
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
                    r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.class;
                    r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.Deserializer.<clinit>():void");
                }

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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.Deserializer.<init>():void");
                }

                public java.lang.Object m3773a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.m3818a(r11, r4);
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
                    r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -905141412)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sent. */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f3926d;

                /* compiled from: sent. */
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
                        r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.class;
                        r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.Deserializer.<clinit>():void");
                    }

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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.Deserializer.<init>():void");
                    }

                    public java.lang.Object m3774a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.EdgesParser.m3817b(r11, r4);
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
                        r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 690344190)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: sent. */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private CityModel f3919d;
                    @Nullable
                    private String f3920e;
                    @Nullable
                    private LocationModel f3921f;
                    @Nullable
                    private String f3922g;
                    @Nullable
                    private String f3923h;
                    @Nullable
                    private String f3924i;
                    @Nullable
                    private String f3925j;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1185712657)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: sent. */
                    public final class CityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f3915d;
                        @Nullable
                        private String f3916e;

                        /* compiled from: sent. */
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Deserializer.<init>():void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.class;
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$CityModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m3775a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                r5 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.EdgesParser.NodeParser.CityParser.m3813a(r11, r4);
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
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$CityModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: sent. */
                        public class Serializer extends JsonSerializer<CityModel> {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Serializer.<init>():void");
                            }

                            public final void m3776a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                r8 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m3779a(r0);
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
                                com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLParsers.PageResponsivenessContextParser.m18452a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.class;
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$CityModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.Serializer.<clinit>():void");
                            }
                        }

                        public CityModel() {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.<init>():void");
                        }

                        public final void m3782a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                        }

                        public final void m3783a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.a(java.lang.String, java.lang.Object, boolean):void");
                        }

                        @javax.annotation.Nullable
                        private java.lang.String m3777j() {
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
                            r0 = r2.f3915d;
                            r1 = 0;
                            r0 = super.a(r0, r1);
                            r2.f3915d = r0;
                            r0 = r2.f3915d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.j():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        private java.lang.String m3778k() {
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
                            r0 = r2.f3916e;
                            r1 = 1;
                            r0 = super.a(r0, r1);
                            r2.f3916e = r0;
                            r0 = r2.f3916e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.k():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m3781a() {
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
                            r0 = r1.m3777j();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.a():java.lang.String");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                            r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m3780a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m3779a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                            r0 = r3.m3777j();
                            r0 = r4.b(r0);
                            r1 = r3.m3778k();
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }
                    }

                    /* compiled from: sent. */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.Deserializer.<init>():void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m3784a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.EdgesParser.NodeParser.m3816a(r11, r4);
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
                            r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 918622653)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: sent. */
                    public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                        private double f3917d;
                        private double f3918e;

                        /* compiled from: sent. */
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Deserializer.<init>():void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.class;
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$LocationModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m3785a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                r5 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.EdgesParser.NodeParser.LocationParser.m3814a(r11, r4);
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
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$LocationModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: sent. */
                        public class Serializer extends JsonSerializer<LocationModel> {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Serializer.<init>():void");
                            }

                            public final void m3786a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                r8 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m3788a(r0);
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
                                com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.EdgesParser.NodeParser.LocationParser.m3815a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.class;
                                r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$LocationModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.Serializer.<clinit>():void");
                            }
                        }

                        public LocationModel() {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.<init>():void");
                        }

                        public final double m3787a() {
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
                            r2.a(r0, r0);
                            r0 = r2.f3917d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.a():double");
                        }

                        public final double m3791j() {
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
                            r0 = r2.f3918e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.j():double");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                            r0 = 1965687765; // 0x752a03d5 float:2.1551958E32 double:9.71178795E-315;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m3789a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m3788a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
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
                            r4 = 0;
                            r6.h();
                            r0 = 2;
                            r7.c(r0);
                            r1 = 0;
                            r2 = r6.f3917d;
                            r0 = r7;
                            r0.a(r1, r2, r4);
                            r1 = 1;
                            r2 = r6.f3918e;
                            r0 = r7;
                            r0.a(r1, r2, r4);
                            r6.i();
                            r0 = r7.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public final void m3790a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                            r2 = 0;
                            super.a(r5, r6, r7);
                            r0 = 0;
                            r0 = r5.a(r6, r0, r2);
                            r4.f3917d = r0;
                            r0 = 1;
                            r0 = r5.a(r6, r0, r2);
                            r4.f3918e = r0;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                        }
                    }

                    /* compiled from: sent. */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m3792a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m3797a(r0);
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
                            com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLParsers.PageResponsivenessContextParser.m18453a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                        }
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m3799a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Duplicate predecessors in PHI insn: B:9:0x0038, PHI: (r1 ?) = (r1_3 ?), (r1_3 ?), (r1_5 ?) binds: {(r1_3 ?)=B:6:0x0026, (r1_3 ?)=B:8:0x0036, (r1_5 ?)=B:9:0x0038}
	at jadx.core.dex.instructions.PhiInsn.bindArg(PhiInsn.java:37)
	at jadx.core.dex.instructions.PhiInsn.bindArg(PhiInsn.java:31)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:191)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
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
                        r0 = r3.m3793l();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m3793l();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel) r0;
                        r2 = r3.m3793l();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel) r1;
                        r1.f3919d = r0;
                    L_0x0022:
                        r0 = r3.m3798a();
                        if (r0 == 0) goto L_0x0040;
                    L_0x0028:
                        r0 = r3.m3798a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel) r0;
                        r2 = r3.m3798a();
                        if (r2 == r0) goto L_0x0040;
                    L_0x0038:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel) r1;
                        r1.f3921f = r0;
                    L_0x0040:
                        r3.i();
                        if (r1 != 0) goto L_0x0046;
                    L_0x0045:
                        return r3;
                    L_0x0046:
                        r3 = r1;
                        goto L_0x0045;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public NodeModel() {
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
                        r1 = this;
                        r0 = 7;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel m3793l() {
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
                        r3 = this;
                        r0 = r3.f3919d;
                        r1 = 0;
                        r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.CityModel) r0;
                        r3.f3919d = r0;
                        r0 = r3.f3919d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.l():com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$CityModel");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m3794m() {
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
                        r2 = this;
                        r0 = r2.f3920e;
                        r1 = 1;
                        r0 = super.a(r0, r1);
                        r2.f3920e = r0;
                        r0 = r2.f3920e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.m():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel m3798a() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r0 = r3.f3921f;
                        r1 = 2;
                        r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.LocationModel) r0;
                        r3.f3921f = r0;
                        r0 = r3.f3921f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.a():com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel$LocationModel");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m3800j() {
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
                        r2 = this;
                        r0 = r2.f3922g;
                        r1 = 3;
                        r0 = super.a(r0, r1);
                        r2.f3922g = r0;
                        r0 = r2.f3922g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.j():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m3795n() {
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
                        r2 = this;
                        r0 = r2.f3923h;
                        r1 = 4;
                        r0 = super.a(r0, r1);
                        r2.f3923h = r0;
                        r0 = r2.f3923h;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.n():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m3796o() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r0 = r2.f3924i;
                        r1 = 5;
                        r0 = super.a(r0, r1);
                        r2.f3924i = r0;
                        r0 = r2.f3924i;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.o():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m3801k() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r0 = r2.f3925j;
                        r1 = 6;
                        r0 = super.a(r0, r1);
                        r2.f3925j = r0;
                        r0 = r2.f3925j;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.k():java.lang.String");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r0 = 1717482862; // 0x665eb56e float:2.6292804E23 double:8.485492794E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.jK_():int");
                    }

                    public final int m3797a(com.facebook.flatbuffers.FlatBufferBuilder r9) {
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
                        r8 = this;
                        r8.h();
                        r0 = r8.m3793l();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r0);
                        r1 = r8.m3794m();
                        r1 = r9.b(r1);
                        r2 = r8.m3798a();
                        r2 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r2);
                        r3 = r8.m3800j();
                        r3 = r9.b(r3);
                        r4 = r8.m3795n();
                        r4 = r9.b(r4);
                        r5 = r8.m3796o();
                        r5 = r9.b(r5);
                        r6 = r8.m3801k();
                        r6 = r9.b(r6);
                        r7 = 7;
                        r9.c(r7);
                        r7 = 0;
                        r9.b(r7, r0);
                        r0 = 1;
                        r9.b(r0, r1);
                        r0 = 2;
                        r9.b(r0, r2);
                        r0 = 3;
                        r9.b(r0, r3);
                        r0 = 4;
                        r9.b(r0, r4);
                        r0 = 5;
                        r9.b(r0, r5);
                        r0 = 6;
                        r9.b(r0, r6);
                        r8.i();
                        r0 = r9.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: sent. */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m3802a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                        r8 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m3803a(r0);
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
                        com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLParsers.PageResponsivenessContextParser.m18454b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
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
                        r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.class;
                        r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m3805a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.clearBlocksState(BlockProcessor.java:412)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:54)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
                    r0 = r3.m3804a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m3804a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel) r0;
                    r2 = r3.m3804a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel) r1;
                    r1.f3926d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public EdgesModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel m3804a() {
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
                    r0 = r3.f3926d;
                    r1 = 0;
                    r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel) r0;
                    r3.f3926d = r0;
                    r0 = r3.f3926d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.a():com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel$NodeModel");
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
                    r0 = 1689858109; // 0x64b9303d float:2.7328989E22 double:8.34900838E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.jK_():int");
                }

                public final int m3803a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m3804a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: sent. */
            public class Serializer extends JsonSerializer<StreetResultsModel> {
                public final void m3806a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m3807a(r0);
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
                    com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryParsers.AddressTypeAheadQueryParser.StreetResultsParser.m3819a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.class;
                    r1 = new com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.Serializer.<clinit>():void");
                }
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m3808a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Duplicate predecessors in PHI insn: B:4:0x0014, PHI: (r0 ?) = (r0_0 ?), (r0_0 ?), (r0_2 ?) binds: {(r0_0 ?)=B:1:0x0008, (r0_2 ?)=B:4:0x0014, (r0_0 ?)=B:3:0x0012}
	at jadx.core.dex.instructions.PhiInsn.bindArg(PhiInsn.java:37)
	at jadx.core.dex.instructions.PhiInsn.bindArg(PhiInsn.java:31)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:191)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
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
                r0 = 0;
                r2.h();
                r1 = r2.m3809a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m3809a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel) r0;
                r1 = r1.b();
                r0.f3927d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public StreetResultsModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel> m3809a() {
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
                r3 = this;
                r0 = r3.f3927d;
                r1 = 0;
                r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f3927d = r0;
                r0 = r3.f3927d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.a():com.google.common.collect.ImmutableList<com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel$EdgesModel>");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -678272674; // 0xffffffffd792615e float:-3.21893773E14 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.jK_():int");
            }

            public final int m3807a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m3809a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public AddressTypeAheadQueryModel() {
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
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.<init>():void");
        }

        public final int m3810a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r2.h();
            r0 = r2.m3811a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        @javax.annotation.Nullable
        public final com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel m3811a() {
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
            r0 = r3.f3928d;
            r1 = 0;
            r2 = com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel) r0;
            r3.f3928d = r0;
            r0 = r3.f3928d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.a():com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels$AddressTypeAheadQueryModel$StreetResultsModel");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m3812a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r1 = 0;
            r3.h();
            r0 = r3.m3811a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m3811a();
            r0 = r4.b(r0);
            r0 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel) r0;
            r2 = r3.m3811a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel) r1;
            r1.f3928d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -1113330254; // 0xffffffffbda3edb2 float:-0.08004321 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.jK_():int");
        }
    }
}
