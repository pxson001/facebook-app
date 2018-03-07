package com.facebook.placetips.gpscore.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentModels.PlaceTipWithReactionUnitsGraphQlFragmentModel;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryWithReactionParser;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryWithReactionParser.SuggestionsParser;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryWithReactionParser.SuggestionsParser.EdgesParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel;
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

/* compiled from: Tigon retry state */
public class GravitySuggestifierQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 570573312)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Tigon retry state */
    public final class GravitySuggestifierQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestionsModel f10638d;

        /* compiled from: Tigon retry state */
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Deserializer.<init>():void");
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
                r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.class;
                r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m11111a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
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
                r2 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.m11168a(r6);
                r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: Tigon retry state */
        public class Serializer extends JsonSerializer<GravitySuggestifierQueryModel> {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Serializer.<init>():void");
            }

            public final void m11112a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
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
                r9 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m11141a(r0);
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
                r7 = "suggestions";
                r10.a(r7);
                com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.m11167a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.class;
                r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 503098188)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Tigon retry state */
        public final class SuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            private int f10636d;
            @Nullable
            private List<EdgesModel> f10637e;

            /* compiled from: Tigon retry state */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.class;
                    r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m11113a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
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
                    r5 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.m11166a(r11, r4);
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
                    r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 212258457)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: Tigon retry state */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLPlaceSuggestionConfidenceLevel f10633d;
                @Nullable
                private NodeModel f10634e;
                @Nullable
                private String f10635f;

                /* compiled from: Tigon retry state */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.class;
                        r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m11114a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
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
                        r5 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.EdgesParser.m11164b(r11, r4);
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
                        r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1694594991)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: Tigon retry state */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f10628d;
                    @Nullable
                    private List<String> f10629e;
                    @Nullable
                    private String f10630f;
                    @Nullable
                    private String f10631g;
                    @Nullable
                    private PlaceTipsFeedUnitFragmentModel f10632h;

                    /* compiled from: Tigon retry state */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$NodeModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m11115a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
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
                            r5 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.EdgesParser.NodeParser.m11162a(r11, r4);
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
                            r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$NodeModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: Tigon retry state */
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Serializer.<init>():void");
                        }

                        public final void m11116a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
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
                            r8 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m11120a(r0);
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
                            com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.EdgesParser.NodeParser.m11163a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$NodeModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                        }
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel oh_() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                        r0 = r1.m11119k();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.oh_():com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels$PlaceTipsFeedUnitFragmentModel");
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
                        r0 = 5;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.<init>():void");
                    }

                    public final void m11123a(java.lang.String r2, com.facebook.graphql.visitor.ConsistencyTuple r3) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                        r0 = "name";
                        r0 = r0.equals(r2);
                        if (r0 == 0) goto L_0x0018;
                    L_0x0008:
                        r0 = r1.m11127d();
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                    }

                    public final void m11124a(java.lang.String r2, java.lang.Object r3, boolean r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                        r0 = "name";
                        r0 = r0.equals(r2);
                        if (r0 == 0) goto L_0x000d;
                    L_0x0008:
                        r3 = (java.lang.String) r3;
                        r1.m11117a(r3);
                    L_0x000d:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.graphql.enums.GraphQLObjectType m11118j() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                        r0 = r4.f10628d;
                        if (r0 != 0) goto L_0x0017;
                    L_0x0008:
                        r0 = r4.b;
                        r1 = r4.c;
                        r2 = 0;
                        r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                        r0 = r0.d(r1, r2, r3);
                        r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                        r4.f10628d = r0;
                    L_0x0017:
                        r0 = r4.f10628d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.j():com.facebook.graphql.enums.GraphQLObjectType");
                    }

                    @javax.annotation.Nonnull
                    public final com.google.common.collect.ImmutableList<java.lang.String> m11125b() {
                        /* JADX: method processing error */
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
                        r0 = r2.f10629e;
                        r1 = 1;
                        r0 = super.a(r0, r1);
                        r2.f10629e = r0;
                        r0 = r2.f10629e;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.b():com.google.common.collect.ImmutableList<java.lang.String>");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m11126c() {
                        /* JADX: method processing error */
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
                        r0 = r2.f10630f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f10630f = r0;
                        r0 = r2.f10630f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.c():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m11127d() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                        r0 = r2.f10631g;
                        r1 = 3;
                        r0 = super.a(r0, r1);
                        r2.f10631g = r0;
                        r0 = r2.f10631g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.d():java.lang.String");
                    }

                    private void m11117a(@javax.annotation.Nullable java.lang.String r5) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                        r4.f10631g = r5;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a(java.lang.String):void");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel m11119k() {
                        /* JADX: method processing error */
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
                        r0 = r3.f10632h;
                        r1 = 4;
                        r2 = com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel) r0;
                        r3.f10632h = r0;
                        r0 = r3.f10632h;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.k():com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels$PlaceTipsFeedUnitFragmentModel");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m11122a() {
                        /* JADX: method processing error */
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
                        r0 = r1.m11126c();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a():java.lang.String");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                        r0 = 77195495; // 0x499e8e7 float:3.6184014E-36 double:3.8139642E-316;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m11121a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                        r0 = r3.m11119k();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m11119k();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel) r0;
                        r2 = r3.m11119k();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel) r1;
                        r1.f10632h = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m11120a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
                        /* JADX: method processing error */
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
                        r6 = this;
                        r6.h();
                        r0 = r6.m11118j();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r0);
                        r1 = r6.m11125b();
                        r1 = r7.c(r1);
                        r2 = r6.m11126c();
                        r2 = r7.b(r2);
                        r3 = r6.m11127d();
                        r3 = r7.b(r3);
                        r4 = r6.m11119k();
                        r4 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r4);
                        r5 = 5;
                        r7.c(r5);
                        r5 = 0;
                        r7.b(r5, r0);
                        r0 = 1;
                        r7.b(r0, r1);
                        r0 = 2;
                        r7.b(r0, r2);
                        r0 = 3;
                        r7.b(r0, r3);
                        r0 = 4;
                        r7.b(r0, r4);
                        r6.i();
                        r0 = r7.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: Tigon retry state */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Serializer.<init>():void");
                    }

                    public final void m11128a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m11130a(r0);
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
                        com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.EdgesParser.m11165b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.access$000(ProcessVariables.java:36)
	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processInsn(ProcessVariables.java:158)
	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processBlockTraced(ProcessVariables.java:135)
	at jadx.core.dex.visitors.regions.TracedRegionVisitor.processBlock(TracedRegionVisitor.java:23)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:53)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:187)
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
                        r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.class;
                        r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel m11133b() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = r1.m11129j();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.b():com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$NodeModel");
                }

                public EdgesModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel m11131a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = r4.f10633d;
                    r1 = 0;
                    r2 = com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel.class;
                    r3 = com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel) r0;
                    r4.f10633d = r0;
                    r0 = r4.f10633d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.a():com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel");
                }

                @javax.annotation.Nullable
                private com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel m11129j() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = r3.f10634e;
                    r1 = 1;
                    r2 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel) r0;
                    r3.f10634e = r0;
                    r0 = r3.f10634e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.j():com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel$NodeModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m11134c() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = r2.f10635f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f10635f = r0;
                    r0 = r2.f10635f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.c():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = -847651457; // 0xffffffffcd79dd7f float:-2.62002672E8 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m11132a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                    r0 = r3.m11129j();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m11129j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel) r0;
                    r2 = r3.m11129j();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel) r1;
                    r1.f10634e = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m11130a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    r0 = r4.m11131a();
                    r0 = r5.a(r0);
                    r1 = r4.m11129j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = r4.m11134c();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: Tigon retry state */
            public class Serializer extends JsonSerializer<SuggestionsModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Serializer.<init>():void");
                }

                public final void m11135a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r7 = this;
                    r8 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m11137a(r0);
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
                    com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryParsers.GravitySuggestifierQueryParser.SuggestionsParser.m11167a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.access$000(ProcessVariables.java:36)
	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processInsn(ProcessVariables.java:158)
	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processBlockTraced(ProcessVariables.java:135)
	at jadx.core.dex.visitors.regions.TracedRegionVisitor.processBlock(TracedRegionVisitor.java:23)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:53)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:187)
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
                    r0 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.class;
                    r1 = new com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.Serializer.<clinit>():void");
                }
            }

            public SuggestionsModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.<init>():void");
            }

            public final int m11136a() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                r0 = r1.f10636d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.a():int");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel> m11140b() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                r0 = r3.f10637e;
                r1 = 1;
                r2 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f10637e = r0;
                r0 = r3.f10637e;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.b():com.google.common.collect.ImmutableList<com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel$EdgesModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                r0 = -373779168; // 0xffffffffe9b89520 float:-2.7893322E25 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m11138a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                r1 = r2.m11140b();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m11140b();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel) r0;
                r1 = r1.b();
                r0.f10637e = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m11137a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                r0 = r3.m11140b();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = 2;
                r4.c(r1);
                r1 = r3.f10636d;
                r4.a(r2, r1, r2);
                r1 = 1;
                r4.b(r1, r0);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m11139a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
                super.a(r2, r3, r4);
                r0 = r2.a(r3, r0, r0);
                r1.f10636d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        public GravitySuggestifierQueryModel() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel m11143a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
            r0 = r3.f10638d;
            r1 = 0;
            r2 = com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel) r0;
            r3.f10638d = r0;
            r0 = r3.f10638d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.a():com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels$GravitySuggestifierQueryModel$SuggestionsModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
            r0 = -1042435661; // 0xffffffffc1ddb1b3 float:-27.711767 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m11142a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
            r0 = r3.m11143a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m11143a();
            r0 = r4.b(r0);
            r0 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel) r0;
            r2 = r3.m11143a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel) r1;
            r1.f10638d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m11141a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
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
            r0 = r2.m11143a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -90477567)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: Tigon retry state */
    public final class GravitySuggestifierQueryWithReactionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestionsModel f10644d;

        /* compiled from: Tigon retry state */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GravitySuggestifierQueryWithReactionModel.class, new Deserializer());
            }

            public Object m11144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GravitySuggestifierQueryWithReactionParser.m11173a(jsonParser);
                Object gravitySuggestifierQueryWithReactionModel = new GravitySuggestifierQueryWithReactionModel();
                ((BaseModel) gravitySuggestifierQueryWithReactionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gravitySuggestifierQueryWithReactionModel instanceof Postprocessable) {
                    return ((Postprocessable) gravitySuggestifierQueryWithReactionModel).a();
                }
                return gravitySuggestifierQueryWithReactionModel;
            }
        }

        /* compiled from: Tigon retry state */
        public class Serializer extends JsonSerializer<GravitySuggestifierQueryWithReactionModel> {
            public final void m11145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GravitySuggestifierQueryWithReactionModel gravitySuggestifierQueryWithReactionModel = (GravitySuggestifierQueryWithReactionModel) obj;
                if (gravitySuggestifierQueryWithReactionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gravitySuggestifierQueryWithReactionModel.m11160a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gravitySuggestifierQueryWithReactionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gravitySuggestifierQueryWithReactionModel.w_();
                int u_ = gravitySuggestifierQueryWithReactionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestions");
                    SuggestionsParser.m11172a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GravitySuggestifierQueryWithReactionModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -105297007)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: Tigon retry state */
        public final class SuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            private int f10642d;
            @Nullable
            private List<EdgesModel> f10643e;

            /* compiled from: Tigon retry state */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionsModel.class, new Deserializer());
                }

                public Object m11146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionsParser.m11171a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionsModel = new SuggestionsModel();
                    ((BaseModel) suggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionsModel).a();
                    }
                    return suggestionsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1306574837)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: Tigon retry state */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLPlaceSuggestionConfidenceLevel f10639d;
                @Nullable
                private PlaceTipWithReactionUnitsGraphQlFragmentModel f10640e;
                @Nullable
                private String f10641f;

                /* compiled from: Tigon retry state */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m11147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m11169b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: Tigon retry state */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m11148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m11152a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m11170b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                private GraphQLPlaceSuggestionConfidenceLevel m11149a() {
                    this.f10639d = (GraphQLPlaceSuggestionConfidenceLevel) super.b(this.f10639d, 0, GraphQLPlaceSuggestionConfidenceLevel.class, GraphQLPlaceSuggestionConfidenceLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f10639d;
                }

                @Nullable
                private PlaceTipWithReactionUnitsGraphQlFragmentModel m11150j() {
                    this.f10640e = (PlaceTipWithReactionUnitsGraphQlFragmentModel) super.a(this.f10640e, 1, PlaceTipWithReactionUnitsGraphQlFragmentModel.class);
                    return this.f10640e;
                }

                @Nullable
                private String m11151k() {
                    this.f10641f = super.a(this.f10641f, 2);
                    return this.f10641f;
                }

                public final int jK_() {
                    return -847651457;
                }

                public final GraphQLVisitableModel m11153a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11150j() != null) {
                        PlaceTipWithReactionUnitsGraphQlFragmentModel placeTipWithReactionUnitsGraphQlFragmentModel = (PlaceTipWithReactionUnitsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m11150j());
                        if (m11150j() != placeTipWithReactionUnitsGraphQlFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10640e = placeTipWithReactionUnitsGraphQlFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11152a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m11149a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11150j());
                    int b = flatBufferBuilder.b(m11151k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: Tigon retry state */
            public class Serializer extends JsonSerializer<SuggestionsModel> {
                public final void m11154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionsModel suggestionsModel = (SuggestionsModel) obj;
                    if (suggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionsModel.m11156a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionsParser.m11172a(suggestionsModel.w_(), suggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestionsModel.class, new Serializer());
                }
            }

            public SuggestionsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m11155a() {
                this.f10643e = super.a(this.f10643e, 1, EdgesModel.class);
                return (ImmutableList) this.f10643e;
            }

            public final int jK_() {
                return -373779168;
            }

            public final GraphQLVisitableModel m11157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11155a() != null) {
                    Builder a = ModelHelper.a(m11155a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10643e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11156a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11155a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10642d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11158a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10642d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public GravitySuggestifierQueryWithReactionModel() {
            super(1);
        }

        @Nullable
        private SuggestionsModel m11159a() {
            this.f10644d = (SuggestionsModel) super.a(this.f10644d, 0, SuggestionsModel.class);
            return this.f10644d;
        }

        public final int jK_() {
            return -1042435661;
        }

        public final GraphQLVisitableModel m11161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11159a() != null) {
                SuggestionsModel suggestionsModel = (SuggestionsModel) graphQLModelMutatingVisitor.b(m11159a());
                if (m11159a() != suggestionsModel) {
                    graphQLVisitableModel = (GravitySuggestifierQueryWithReactionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10644d = suggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11160a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11159a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
