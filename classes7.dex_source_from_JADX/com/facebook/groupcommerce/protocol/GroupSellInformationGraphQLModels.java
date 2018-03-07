package com.facebook.groupcommerce.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLInterfaces.GroupSellInformation;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: reactions */
public class GroupSellInformationGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1259075093)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reactions */
    public final class GroupSellInformationModel extends BaseModel implements GraphQLVisitableConsistentModel, GroupSellInformation {
        @Nullable
        private GroupSellConfigModel f5489d;

        /* compiled from: reactions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSellInformationModel.class, new Deserializer());
            }

            public Object m6072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSellInformationParser.m6176a(jsonParser);
                Object groupSellInformationModel = new GroupSellInformationModel();
                ((BaseModel) groupSellInformationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSellInformationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSellInformationModel).a();
                }
                return groupSellInformationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1005776992)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: reactions */
        public final class GroupSellConfigModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5488d;

            /* compiled from: reactions */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f5419a;
            }

            /* compiled from: reactions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupSellConfigModel.class, new Deserializer());
                }

                public Object m6073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupSellConfigParser.m6174a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupSellConfigModel = new GroupSellConfigModel();
                    ((BaseModel) groupSellConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupSellConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) groupSellConfigModel).a();
                    }
                    return groupSellConfigModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -354975052)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: reactions */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5487d;

                /* compiled from: reactions */
                public final class Builder {
                    @Nullable
                    public NodeModel f5420a;

                    public Builder() {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Builder.<init>():void");
                    }
                }

                /* compiled from: reactions */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.class;
                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6074a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.m6172b(r11, r4);
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
                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1701701809)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: reactions */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private List<String> f5475d;
                    @Nullable
                    private ForSaleCategoriesModel f5476e;
                    @Nullable
                    private String f5477f;
                    private boolean f5478g;
                    private boolean f5479h;
                    @Nullable
                    private LocationPickerSettingModel f5480i;
                    @Nullable
                    private MarketplaceCrossPostSettingModel f5481j;
                    @Nullable
                    private List<String> f5482k;
                    @Nullable
                    private List<String> f5483l;
                    @Nullable
                    private String f5484m;
                    private boolean f5485n;
                    private boolean f5486o;

                    /* compiled from: reactions */
                    public final class Builder {
                        @Nullable
                        public ImmutableList<String> f5421a;
                        @Nullable
                        public ForSaleCategoriesModel f5422b;
                        @Nullable
                        public String f5423c;
                        public boolean f5424d;
                        public boolean f5425e;
                        @Nullable
                        public LocationPickerSettingModel f5426f;
                        @Nullable
                        public MarketplaceCrossPostSettingModel f5427g;
                        @Nullable
                        public ImmutableList<String> f5428h;
                        @Nullable
                        public ImmutableList<String> f5429i;
                        @Nullable
                        public String f5430j;
                        public boolean f5431k;
                        public boolean f5432l;

                        public Builder() {
                            /* JADX: method processing error */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Builder.<init>():void");
                        }

                        public final com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel m6075a() {
                            /* JADX: method processing error */
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
                            r13 = this;
                            r4 = 1;
                            r12 = 0;
                            r2 = 0;
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r13.f5421a;
                            r1 = r0.c(r1);
                            r3 = r13.f5422b;
                            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                            r5 = r13.f5423c;
                            r5 = r0.b(r5);
                            r6 = r13.f5426f;
                            r6 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                            r7 = r13.f5427g;
                            r7 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r7);
                            r8 = r13.f5428h;
                            r8 = r0.c(r8);
                            r9 = r13.f5429i;
                            r9 = r0.c(r9);
                            r10 = r13.f5430j;
                            r10 = r0.b(r10);
                            r11 = 12;
                            r0.c(r11);
                            r0.b(r12, r1);
                            r0.b(r4, r3);
                            r1 = 2;
                            r0.b(r1, r5);
                            r1 = 3;
                            r3 = r13.f5424d;
                            r0.a(r1, r3);
                            r1 = 4;
                            r3 = r13.f5425e;
                            r0.a(r1, r3);
                            r1 = 5;
                            r0.b(r1, r6);
                            r1 = 6;
                            r0.b(r1, r7);
                            r1 = 7;
                            r0.b(r1, r8);
                            r1 = 8;
                            r0.b(r1, r9);
                            r1 = 9;
                            r0.b(r1, r10);
                            r1 = 10;
                            r3 = r13.f5431k;
                            r0.a(r1, r3);
                            r1 = 11;
                            r3 = r13.f5432l;
                            r0.a(r1, r3);
                            r1 = r0.d();
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r1.position(r12);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel;
                            r1.<init>(r0);
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Builder.a():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel");
                        }
                    }

                    /* compiled from: reactions */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m6076a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
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
                            r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.m6170a(r11, r4);
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
                            r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1980396175)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: reactions */
                    public final class ForSaleCategoriesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<ForSaleCategoriesEdgesModel> f5440d;

                        /* compiled from: reactions */
                        public final class Builder {
                            @Nullable
                            public ImmutableList<ForSaleCategoriesEdgesModel> f5433a;

                            public Builder() {
                                /* JADX: method processing error */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Builder.<init>():void");
                            }
                        }

                        /* compiled from: reactions */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Deserializer.<init>():void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m6077a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                /* JADX: method processing error */
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
                                r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.m6164a(r11, r4);
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
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -390994405)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: reactions */
                        public final class ForSaleCategoriesEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private ForSaleCategoriesEdgesNodeModel f5439d;

                            /* compiled from: reactions */
                            public final class Builder {
                                @Nullable
                                public ForSaleCategoriesEdgesNodeModel f5434a;

                                public Builder() {
                                    /* JADX: method processing error */
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Builder.<init>():void");
                                }
                            }

                            /* compiled from: reactions */
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Deserializer.<init>():void");
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
                                    r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.class;
                                    r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$Deserializer;
                                    r1.<init>();
                                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Deserializer.<clinit>():void");
                                }

                                public java.lang.Object m6078a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                    /* JADX: method processing error */
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
                                    r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.ForSaleCategoriesEdgesParser.m6162b(r11, r4);
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
                                    r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel;
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1185712657)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: reactions */
                            public final class ForSaleCategoriesEdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                @Nullable
                                private String f5437d;
                                @Nullable
                                private String f5438e;

                                /* compiled from: reactions */
                                public final class Builder {
                                    @Nullable
                                    public String f5435a;
                                    @Nullable
                                    public String f5436b;

                                    public Builder() {
                                        /* JADX: method processing error */
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
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Builder.<init>():void");
                                    }
                                }

                                /* compiled from: reactions */
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
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Deserializer.<init>():void");
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
                                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.class;
                                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel$Deserializer;
                                        r1.<init>();
                                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Deserializer.<clinit>():void");
                                    }

                                    public java.lang.Object m6079a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                        /* JADX: method processing error */
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
                                        r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.ForSaleCategoriesEdgesParser.ForSaleCategoriesEdgesNodeParser.m6160a(r11, r4);
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
                                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel;
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
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                                    }
                                }

                                /* compiled from: reactions */
                                public class Serializer extends JsonSerializer<ForSaleCategoriesEdgesNodeModel> {
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
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Serializer.<init>():void");
                                    }

                                    public final void m6080a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                        /* JADX: method processing error */
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
                                        r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel) r8;
                                        r2 = 0;
                                        r0 = r8.w_();
                                        if (r0 != 0) goto L_0x0035;
                                    L_0x0009:
                                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                        r0.<init>(r1);
                                        r1 = r8.m6082a(r0);
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
                                        com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.ForSaleCategoriesEdgesParser.ForSaleCategoriesEdgesNodeParser.m6161a(r0, r1, r9);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.class;
                                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel$Serializer;
                                        r1.<init>();
                                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                        return;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.Serializer.<clinit>():void");
                                    }
                                }

                                public ForSaleCategoriesEdgesNodeModel() {
                                    /* JADX: method processing error */
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
                                    r0 = 2;
                                    r1.<init>(r0);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.<init>():void");
                                }

                                public ForSaleCategoriesEdgesNodeModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                    /* JADX: method processing error */
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
                                    r0 = 2;
                                    r2.<init>(r0);
                                    r1 = r3.a;
                                    r0 = r1;
                                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                    r2.a(r3, r0);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                                }

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                @javax.annotation.Nullable
                                public final java.lang.String m6085b() {
                                    /* JADX: method processing error */
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
                                    r0 = r2.f5437d;
                                    r1 = null;
                                    r0 = super.a(r0, r1);
                                    r2.f5437d = r0;
                                    r0 = r2.f5437d;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.b():java.lang.String");
                                }

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                @javax.annotation.Nullable
                                public final java.lang.String m6086c() {
                                    /* JADX: method processing error */
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
                                    r0 = r2.f5438e;
                                    r1 = 1;
                                    r0 = super.a(r0, r1);
                                    r2.f5438e = r0;
                                    r0 = r2.f5438e;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.c():java.lang.String");
                                }

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel m6081a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel r9) {
                                    /* JADX: method processing error */
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
                                    if (r9 != null) goto L_0x0004;
                                L_0x0002:
                                    r9 = null;
                                L_0x0003:
                                    return r9;
                                L_0x0004:
                                    r0 = r9 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel;
                                    if (r0 == null) goto L_0x000b;
                                L_0x0008:
                                    r9 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel) r9;
                                    goto L_0x0003;
                                L_0x000b:
                                    r0 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel$Builder;
                                    r0.<init>();
                                    r1 = r9.m6085b();
                                    r0.f5435a = r1;
                                    r1 = r9.m6086c();
                                    r0.f5436b = r1;
                                    r6 = 1;
                                    r8 = null;
                                    r4 = null;
                                    r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r3 = 128;
                                    r2.<init>(r3);
                                    r3 = r0.f5435a;
                                    r3 = r2.b(r3);
                                    r5 = r0.f5436b;
                                    r5 = r2.b(r5);
                                    r7 = 2;
                                    r2.c(r7);
                                    r2.b(r8, r3);
                                    r2.b(r6, r5);
                                    r3 = r2.d();
                                    r2.d(r3);
                                    r2 = r2.e();
                                    r3 = java.nio.ByteBuffer.wrap(r2);
                                    r3.position(r8);
                                    r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                    r5 = r4;
                                    r7 = r4;
                                    r2.<init>(r3, r4, r5, r6, r7);
                                    r3 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel;
                                    r3.<init>(r2);
                                    r9 = r3;
                                    goto L_0x0003;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel");
                                }

                                @javax.annotation.Nullable
                                public final java.lang.String m6084a() {
                                    /* JADX: method processing error */
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
                                    r0 = r1.m6085b();
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.a():java.lang.String");
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
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
                                    r0 = 997147247;
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.jK_():int");
                                }

                                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6083a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                                    /* JADX: method processing error */
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
                                    r0.h();
                                    r0.i();
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                                }

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final int m6082a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                                    /* JADX: method processing error */
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
                                    r3.h();
                                    r0 = r3.m6085b();
                                    r0 = r4.b(r0);
                                    r1 = r3.m6086c();
                                    r1 = r4.b(r1);
                                    r2 = 2;
                                    r4.c(r2);
                                    r2 = null;
                                    r4.b(r2, r0);
                                    r0 = 1;
                                    r4.b(r0, r1);
                                    r3.i();
                                    r0 = r4.d();
                                    return r0;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                                }
                            }

                            /* compiled from: reactions */
                            public class Serializer extends JsonSerializer<ForSaleCategoriesEdgesModel> {
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Serializer.<init>():void");
                                }

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void m6087a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                    /* JADX: method processing error */
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
                                    r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel) r8;
                                    r2 = null;
                                    r0 = r8.w_();
                                    if (r0 != null) goto L_0x0035;
                                L_0x0009:
                                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                    r1 = 128;
                                    r0.<init>(r1);
                                    r1 = r8.m6090a(r0);
                                    r0.d(r1);
                                    r0 = r0.e();
                                    r1 = java.nio.ByteBuffer.wrap(r0);
                                    r0 = null;
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
                                    com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.ForSaleCategoriesEdgesParser.m6163b(r0, r1, r9, r10);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                    r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.class;
                                    r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$Serializer;
                                    r1.<init>();
                                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                    return;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.Serializer.<clinit>():void");
                                }
                            }

                            @javax.annotation.Nullable
                            public final /* synthetic */ com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel m6092a() {
                                /* JADX: method processing error */
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
                                r0 = r1.m6089j();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.a():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public ForSaleCategoriesEdgesModel() {
                                /* JADX: method processing error */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.<init>():void");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public ForSaleCategoriesEdgesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                                /* JADX: method processing error */
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
                                r0 = 1;
                                r2.<init>(r0);
                                r1 = r3.a;
                                r0 = r1;
                                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r2.a(r3, r0);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                            }

                            @javax.annotation.Nullable
                            private com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel m6089j() {
                                /* JADX: method processing error */
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
                                r0 = r3.f5439d;
                                r1 = 0;
                                r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.class;
                                r0 = super.a(r0, r1, r2);
                                r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel) r0;
                                r3.f5439d = r0;
                                r0 = r3.f5439d;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.j():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$ForSaleCategoriesEdgesNodeModel");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel m6088a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel r8) {
                                /* JADX: method processing error */
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
                                if (r8 != null) goto L_0x0004;
                            L_0x0002:
                                r8 = null;
                            L_0x0003:
                                return r8;
                            L_0x0004:
                                r0 = r8 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel;
                                if (r0 == null) goto L_0x000b;
                            L_0x0008:
                                r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel) r8;
                                goto L_0x0003;
                            L_0x000b:
                                r0 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel$Builder;
                                r0.<init>();
                                r1 = r8.m6092a();
                                r1 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel.m6081a(r1);
                                r0.f5434a = r1;
                                r6 = 1;
                                r5 = null;
                                r4 = null;
                                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r3 = 128;
                                r2.<init>(r3);
                                r3 = r0.f5434a;
                                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                                r2.c(r6);
                                r2.b(r5, r3);
                                r3 = r2.d();
                                r2.d(r3);
                                r2 = r2.e();
                                r3 = java.nio.ByteBuffer.wrap(r2);
                                r3.position(r5);
                                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r5 = r4;
                                r7 = r4;
                                r2.<init>(r3, r4, r5, r6, r7);
                                r3 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel;
                                r3.<init>(r2);
                                r8 = r3;
                                goto L_0x0003;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel");
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
                                r0 = 1869222940;
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.jK_():int");
                            }

                            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6091a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                                /* JADX: method processing error */
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
                                r0 = r3.m6089j();
                                if (r0 == 0) goto L_0x0022;
                            L_0x000a:
                                r0 = r3.m6089j();
                                r0 = r4.b(r0);
                                r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.ForSaleCategoriesEdgesNodeModel) r0;
                                r2 = r3.m6089j();
                                if (r2 == r0) goto L_0x0022;
                            L_0x001a:
                                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                                r1 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel) r1;
                                r1.f5439d = r0;
                            L_0x0022:
                                r3.i();
                                if (r1 != 0) goto L_0x0028;
                            L_0x0027:
                                return r3;
                            L_0x0028:
                                r3 = r1;
                                goto L_0x0027;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                            }

                            public final int m6090a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                                /* JADX: method processing error */
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
                                r0 = r2.m6089j();
                                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                                r1 = 1;
                                r3.c(r1);
                                r1 = 0;
                                r3.b(r1, r0);
                                r2.i();
                                r0 = r3.d();
                                return r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                            }
                        }

                        /* compiled from: reactions */
                        public class Serializer extends JsonSerializer<ForSaleCategoriesModel> {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Serializer.<init>():void");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void m6093a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                /* JADX: method processing error */
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
                                r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel) r8;
                                r2 = null;
                                r0 = r8.w_();
                                if (r0 != null) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128;
                                r0.<init>(r1);
                                r1 = r8.m6095a(r0);
                                r0.d(r1);
                                r0 = r0.e();
                                r1 = java.nio.ByteBuffer.wrap(r0);
                                r0 = null;
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
                                com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.ForSaleCategoriesParser.m6165a(r0, r1, r9, r10);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.Serializer.<clinit>():void");
                            }
                        }

                        public ForSaleCategoriesModel() {
                            /* JADX: method processing error */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.<init>():void");
                        }

                        public ForSaleCategoriesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                            /* JADX: method processing error */
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
                            r0 = 1;
                            r2.<init>(r0);
                            r1 = r3.a;
                            r0 = r1;
                            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r2.a(r3, r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                        }

                        @javax.annotation.Nonnull
                        public final com.google.common.collect.ImmutableList<com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel> m6097a() {
                            /* JADX: method processing error */
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
                            r0 = r3.f5440d;
                            r1 = 0;
                            r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.class;
                            r0 = super.a(r0, r1, r2);
                            r3.f5440d = r0;
                            r0 = r3.f5440d;
                            r0 = (com.google.common.collect.ImmutableList) r0;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.a():com.google.common.collect.ImmutableList<com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$ForSaleCategoriesEdgesModel>");
                        }

                        public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel m6094a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel r10) {
                            /* JADX: method processing error */
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
                            if (r10 != 0) goto L_0x0004;
                        L_0x0002:
                            r10 = 0;
                        L_0x0003:
                            return r10;
                        L_0x0004:
                            r0 = r10 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel;
                            if (r0 == 0) goto L_0x000b;
                        L_0x0008:
                            r10 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel) r10;
                            goto L_0x0003;
                        L_0x000b:
                            r2 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel$Builder;
                            r2.<init>();
                            r3 = com.google.common.collect.ImmutableList.builder();
                            r0 = 0;
                            r1 = r0;
                        L_0x0016:
                            r0 = r10.m6097a();
                            r0 = r0.size();
                            if (r1 >= r0) goto L_0x0035;
                        L_0x0020:
                            r0 = r10.m6097a();
                            r0 = r0.get(r1);
                            r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel) r0;
                            r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel.m6088a(r0);
                            r3.c(r0);
                            r0 = r1 + 1;
                            r1 = r0;
                            goto L_0x0016;
                        L_0x0035:
                            r0 = r3.b();
                            r2.f5433a = r0;
                            r8 = 1;
                            r7 = 0;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = r2.f5433a;
                            r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                            r4.c(r8);
                            r4.b(r7, r5);
                            r5 = r4.d();
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r5.position(r7);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel;
                            r5.<init>(r4);
                            r10 = r5;
                            goto L_0x0003;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel");
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
                            r0 = 1499111933; // 0x595aa1fd float:3.84622831E15 double:7.406597054E-315;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6096a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                            /* JADX: method processing error */
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
                            r2.h();
                            r1 = r2.m6097a();
                            if (r1 == 0) goto L_0x0020;
                        L_0x000a:
                            r1 = r2.m6097a();
                            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                            if (r1 == 0) goto L_0x0020;
                        L_0x0014:
                            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                            r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel) r0;
                            r1 = r1.b();
                            r0.f5440d = r1;
                        L_0x0020:
                            r2.i();
                            if (r0 != 0) goto L_0x0026;
                        L_0x0025:
                            return r2;
                        L_0x0026:
                            r2 = r0;
                            goto L_0x0025;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m6095a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                            /* JADX: method processing error */
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
                            r0 = r2.m6097a();
                            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                            r1 = 1;
                            r3.c(r1);
                            r1 = 0;
                            r3.b(r1, r0);
                            r2.i();
                            r0 = r3.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 562279586)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: reactions */
                    public final class LocationPickerSettingModel extends BaseModel implements GraphQLVisitableModel {
                        private boolean f5444d;
                        private boolean f5445e;
                        private boolean f5446f;

                        /* compiled from: reactions */
                        public final class Builder {
                            public boolean f5441a;
                            public boolean f5442b;
                            public boolean f5443c;

                            public Builder() {
                                /* JADX: method processing error */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Builder.<init>():void");
                            }
                        }

                        /* compiled from: reactions */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Deserializer.<init>():void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Deserializer.<clinit>():void");
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public java.lang.Object m6098a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                /* JADX: method processing error */
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
                                r6 = null;
                                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r5 = 128;
                                r4.<init>(r5);
                                r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.LocationPickerSettingParser.m6166a(r11, r4);
                                r4.d(r5);
                                r4 = r4.e();
                                r5 = java.nio.ByteBuffer.wrap(r4);
                                r4 = null;
                                r5.position(r4);
                                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r7 = r6;
                                r9 = r6;
                                r4.<init>(r5, r6, r7, r8, r9);
                                r5 = 4;
                                r6 = java.lang.Boolean.valueOf(r8);
                                r4.a(r5, r6);
                                r2 = r4;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel;
                                r1.<init>();
                                r4 = r2.a;
                                r0 = r4;
                                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r0 = r1;
                                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                r0.a(r2, r3, r11);
                                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                if (r0 == null) goto L_0x0048;
                            L_0x0042:
                                r1 = (com.facebook.common.json.Postprocessable) r1;
                                r1 = r1.a();
                            L_0x0048:
                                return r1;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: reactions */
                        public class Serializer extends JsonSerializer<LocationPickerSettingModel> {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Serializer.<init>():void");
                            }

                            public final void m6099a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                /* JADX: method processing error */
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
                                r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m6101a(r0);
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
                                com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.LocationPickerSettingParser.m6167a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.Serializer.<clinit>():void");
                            }
                        }

                        public LocationPickerSettingModel() {
                            /* JADX: method processing error */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.<init>():void");
                        }

                        public LocationPickerSettingModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                            /* JADX: method processing error */
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
                            r0 = 3;
                            r2.<init>(r0);
                            r1 = r3.a;
                            r0 = r1;
                            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r2.a(r3, r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                        }

                        public final boolean m6104a() {
                            /* JADX: method processing error */
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
                            r0 = 0;
                            r1.a(r0, r0);
                            r0 = r1.f5444d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.a():boolean");
                        }

                        public final boolean m6105b() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5445e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.b():boolean");
                        }

                        public final boolean m6106c() {
                            /* JADX: method processing error */
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
                            r2.a(r0, r1);
                            r0 = r2.f5446f;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.c():boolean");
                        }

                        public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel m6100a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel r8) {
                            /* JADX: method processing error */
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
                            if (r8 != 0) goto L_0x0004;
                        L_0x0002:
                            r8 = 0;
                        L_0x0003:
                            return r8;
                        L_0x0004:
                            r0 = r8 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel;
                            if (r0 == 0) goto L_0x000b;
                        L_0x0008:
                            r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel) r8;
                            goto L_0x0003;
                        L_0x000b:
                            r0 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel$Builder;
                            r0.<init>();
                            r1 = r8.m6104a();
                            r0.f5441a = r1;
                            r1 = r8.m6105b();
                            r0.f5442b = r1;
                            r1 = r8.m6106c();
                            r0.f5443c = r1;
                            r6 = 1;
                            r7 = 0;
                            r4 = 0;
                            r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r2.<init>(r3);
                            r3 = 3;
                            r2.c(r3);
                            r3 = r0.f5441a;
                            r2.a(r7, r3);
                            r3 = r0.f5442b;
                            r2.a(r6, r3);
                            r3 = 2;
                            r5 = r0.f5443c;
                            r2.a(r3, r5);
                            r3 = r2.d();
                            r2.d(r3);
                            r2 = r2.e();
                            r3 = java.nio.ByteBuffer.wrap(r2);
                            r3.position(r7);
                            r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r5 = r4;
                            r7 = r4;
                            r2.<init>(r3, r4, r5, r6, r7);
                            r3 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel;
                            r3.<init>(r2);
                            r8 = r3;
                            goto L_0x0003;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel");
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
                            r0 = -1750885796; // 0xffffffff97a39a5c float:-1.0572594E-24 double:NaN;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6102a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                            /* JADX: method processing error */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m6101a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                            /* JADX: method processing error */
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
                            r0 = 3;
                            r3.c(r0);
                            r0 = 0;
                            r1 = r2.f5444d;
                            r3.a(r0, r1);
                            r0 = 1;
                            r1 = r2.f5445e;
                            r3.a(r0, r1);
                            r0 = 2;
                            r1 = r2.f5446f;
                            r3.a(r0, r1);
                            r2.i();
                            r0 = r3.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public final void m6103a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                            /* JADX: method processing error */
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
                            r0 = 0;
                            r0 = r2.a(r3, r0);
                            r1.f5444d = r0;
                            r0 = 1;
                            r0 = r2.a(r3, r0);
                            r1.f5445e = r0;
                            r0 = 2;
                            r0 = r2.a(r3, r0);
                            r1.f5446f = r0;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 810503864)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: reactions */
                    public final class MarketplaceCrossPostSettingModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f5461d;
                        @Nullable
                        private String f5462e;
                        @Nullable
                        private String f5463f;
                        private boolean f5464g;
                        private boolean f5465h;
                        @Nullable
                        private String f5466i;
                        private boolean f5467j;
                        private boolean f5468k;
                        @Nullable
                        private String f5469l;
                        @Nullable
                        private String f5470m;
                        @Nullable
                        private String f5471n;
                        @Nullable
                        private String f5472o;
                        @Nullable
                        private String f5473p;
                        @Nullable
                        private String f5474q;

                        /* compiled from: reactions */
                        public final class Builder {
                            @Nullable
                            public String f5447a;
                            @Nullable
                            public String f5448b;
                            @Nullable
                            public String f5449c;
                            public boolean f5450d;
                            public boolean f5451e;
                            @Nullable
                            public String f5452f;
                            public boolean f5453g;
                            public boolean f5454h;
                            @Nullable
                            public String f5455i;
                            @Nullable
                            public String f5456j;
                            @Nullable
                            public String f5457k;
                            @Nullable
                            public String f5458l;
                            @Nullable
                            public String f5459m;
                            @Nullable
                            public String f5460n;

                            public Builder() {
                                /* JADX: method processing error */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Builder.<init>():void");
                            }

                            public final com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel m6107a() {
                                /* JADX: method processing error */
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
                                r15 = this;
                                r4 = 1;
                                r14 = 0;
                                r2 = 0;
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r15.f5447a;
                                r1 = r0.b(r1);
                                r3 = r15.f5448b;
                                r3 = r0.b(r3);
                                r5 = r15.f5449c;
                                r5 = r0.b(r5);
                                r6 = r15.f5452f;
                                r6 = r0.b(r6);
                                r7 = r15.f5455i;
                                r7 = r0.b(r7);
                                r8 = r15.f5456j;
                                r8 = r0.b(r8);
                                r9 = r15.f5457k;
                                r9 = r0.b(r9);
                                r10 = r15.f5458l;
                                r10 = r0.b(r10);
                                r11 = r15.f5459m;
                                r11 = r0.b(r11);
                                r12 = r15.f5460n;
                                r12 = r0.b(r12);
                                r13 = 14;
                                r0.c(r13);
                                r0.b(r14, r1);
                                r0.b(r4, r3);
                                r1 = 2;
                                r0.b(r1, r5);
                                r1 = 3;
                                r3 = r15.f5450d;
                                r0.a(r1, r3);
                                r1 = 4;
                                r3 = r15.f5451e;
                                r0.a(r1, r3);
                                r1 = 5;
                                r0.b(r1, r6);
                                r1 = 6;
                                r3 = r15.f5453g;
                                r0.a(r1, r3);
                                r1 = 7;
                                r3 = r15.f5454h;
                                r0.a(r1, r3);
                                r1 = 8;
                                r0.b(r1, r7);
                                r1 = 9;
                                r0.b(r1, r8);
                                r1 = 10;
                                r0.b(r1, r9);
                                r1 = 11;
                                r0.b(r1, r10);
                                r1 = 12;
                                r0.b(r1, r11);
                                r1 = 13;
                                r0.b(r1, r12);
                                r1 = r0.d();
                                r0.d(r1);
                                r0 = r0.e();
                                r1 = java.nio.ByteBuffer.wrap(r0);
                                r1.position(r14);
                                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r3 = r2;
                                r5 = r2;
                                r0.<init>(r1, r2, r3, r4, r5);
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel;
                                r1.<init>(r0);
                                return r1;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Builder.a():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel");
                            }
                        }

                        /* compiled from: reactions */
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Deserializer.<init>():void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m6108a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                /* JADX: method processing error */
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
                                r5 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.MarketplaceCrossPostSettingParser.m6168a(r11, r4);
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
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel;
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: reactions */
                        public class Serializer extends JsonSerializer<MarketplaceCrossPostSettingModel> {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Serializer.<init>():void");
                            }

                            public final void m6109a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                /* JADX: method processing error */
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
                                r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m6111a(r0);
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
                                com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.MarketplaceCrossPostSettingParser.m6169a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                                r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.class;
                                r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.Serializer.<clinit>():void");
                            }
                        }

                        public MarketplaceCrossPostSettingModel() {
                            /* JADX: method processing error */
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
                            r0 = 14;
                            r1.<init>(r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.<init>():void");
                        }

                        public MarketplaceCrossPostSettingModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                            /* JADX: method processing error */
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
                            r0 = 14;
                            r2.<init>(r0);
                            r1 = r3.a;
                            r0 = r1;
                            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r2.a(r3, r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m6113a() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5461d;
                            r1 = 0;
                            r0 = super.a(r0, r1);
                            r2.f5461d = r0;
                            r0 = r2.f5461d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.a():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m6115b() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5462e;
                            r1 = 1;
                            r0 = super.a(r0, r1);
                            r2.f5462e = r0;
                            r0 = r2.f5462e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.b():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m6116c() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5463f;
                            r1 = 2;
                            r0 = super.a(r0, r1);
                            r2.f5463f = r0;
                            r0 = r2.f5463f;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.c():java.lang.String");
                        }

                        public final boolean m6117d() {
                            /* JADX: method processing error */
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
                            r2.a(r0, r1);
                            r0 = r2.f5464g;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.d():boolean");
                        }

                        public final boolean gS_() {
                            /* JADX: method processing error */
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
                            r1 = 4;
                            r2.a(r0, r1);
                            r0 = r2.f5465h;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.gS_():boolean");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m6118g() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5466i;
                            r1 = 5;
                            r0 = super.a(r0, r1);
                            r2.f5466i = r0;
                            r0 = r2.f5466i;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.g():java.lang.String");
                        }

                        public final boolean gT_() {
                            /* JADX: method processing error */
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
                            r1 = 6;
                            r2.a(r0, r1);
                            r0 = r2.f5467j;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.gT_():boolean");
                        }

                        public final boolean gU_() {
                            /* JADX: method processing error */
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
                            r1 = 7;
                            r2.a(r0, r1);
                            r0 = r2.f5468k;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.gU_():boolean");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m6119j() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5469l;
                            r1 = 8;
                            r0 = super.a(r0, r1);
                            r2.f5469l = r0;
                            r0 = r2.f5469l;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.j():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m6120k() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5470m;
                            r1 = 9;
                            r0 = super.a(r0, r1);
                            r2.f5470m = r0;
                            r0 = r2.f5470m;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.k():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m6121l() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5471n;
                            r1 = 10;
                            r0 = super.a(r0, r1);
                            r2.f5471n = r0;
                            r0 = r2.f5471n;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.l():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m6122m() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5472o;
                            r1 = 11;
                            r0 = super.a(r0, r1);
                            r2.f5472o = r0;
                            r0 = r2.f5472o;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.m():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m6123n() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5473p;
                            r1 = 12;
                            r0 = super.a(r0, r1);
                            r2.f5473p = r0;
                            r0 = r2.f5473p;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.n():java.lang.String");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        @javax.annotation.Nullable
                        public final java.lang.String m6124o() {
                            /* JADX: method processing error */
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
                            r0 = r2.f5474q;
                            r1 = 13;
                            r0 = super.a(r0, r1);
                            r2.f5474q = r0;
                            r0 = r2.f5474q;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.o():java.lang.String");
                        }

                        public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel m6110a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel r2) {
                            /* JADX: method processing error */
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
                            if (r2 != 0) goto L_0x0004;
                        L_0x0002:
                            r2 = 0;
                        L_0x0003:
                            return r2;
                        L_0x0004:
                            r0 = r2 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel;
                            if (r0 == 0) goto L_0x000b;
                        L_0x0008:
                            r2 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel) r2;
                            goto L_0x0003;
                        L_0x000b:
                            r0 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel$Builder;
                            r0.<init>();
                            r1 = r2.m6113a();
                            r0.f5447a = r1;
                            r1 = r2.m6115b();
                            r0.f5448b = r1;
                            r1 = r2.m6116c();
                            r0.f5449c = r1;
                            r1 = r2.m6117d();
                            r0.f5450d = r1;
                            r1 = r2.gS_();
                            r0.f5451e = r1;
                            r1 = r2.m6118g();
                            r0.f5452f = r1;
                            r1 = r2.gT_();
                            r0.f5453g = r1;
                            r1 = r2.gU_();
                            r0.f5454h = r1;
                            r1 = r2.m6119j();
                            r0.f5455i = r1;
                            r1 = r2.m6120k();
                            r0.f5456j = r1;
                            r1 = r2.m6121l();
                            r0.f5457k = r1;
                            r1 = r2.m6122m();
                            r0.f5458l = r1;
                            r1 = r2.m6123n();
                            r0.f5459m = r1;
                            r1 = r2.m6124o();
                            r0.f5460n = r1;
                            r2 = r0.m6107a();
                            goto L_0x0003;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel");
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
                            r0 = -1582934902; // 0xffffffffa1a6548a float:-1.1270975E-18 double:NaN;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6112a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                            /* JADX: method processing error */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m6111a(com.facebook.flatbuffers.FlatBufferBuilder r12) {
                            /* JADX: method processing error */
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
                            r11 = this;
                            r11.h();
                            r0 = r11.m6113a();
                            r0 = r12.b(r0);
                            r1 = r11.m6115b();
                            r1 = r12.b(r1);
                            r2 = r11.m6116c();
                            r2 = r12.b(r2);
                            r3 = r11.m6118g();
                            r3 = r12.b(r3);
                            r4 = r11.m6119j();
                            r4 = r12.b(r4);
                            r5 = r11.m6120k();
                            r5 = r12.b(r5);
                            r6 = r11.m6121l();
                            r6 = r12.b(r6);
                            r7 = r11.m6122m();
                            r7 = r12.b(r7);
                            r8 = r11.m6123n();
                            r8 = r12.b(r8);
                            r9 = r11.m6124o();
                            r9 = r12.b(r9);
                            r10 = 14;
                            r12.c(r10);
                            r10 = 0;
                            r12.b(r10, r0);
                            r0 = 1;
                            r12.b(r0, r1);
                            r0 = 2;
                            r12.b(r0, r2);
                            r0 = 3;
                            r1 = r11.f5464g;
                            r12.a(r0, r1);
                            r0 = 4;
                            r1 = r11.f5465h;
                            r12.a(r0, r1);
                            r0 = 5;
                            r12.b(r0, r3);
                            r0 = 6;
                            r1 = r11.f5467j;
                            r12.a(r0, r1);
                            r0 = 7;
                            r1 = r11.f5468k;
                            r12.a(r0, r1);
                            r0 = 8;
                            r12.b(r0, r4);
                            r0 = 9;
                            r12.b(r0, r5);
                            r0 = 10;
                            r12.b(r0, r6);
                            r0 = 11;
                            r12.b(r0, r7);
                            r0 = 12;
                            r12.b(r0, r8);
                            r0 = 13;
                            r12.b(r0, r9);
                            r11.i();
                            r0 = r12.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }

                        public final void m6114a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                            /* JADX: method processing error */
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
                            r0 = 3;
                            r0 = r2.a(r3, r0);
                            r1.f5464g = r0;
                            r0 = 4;
                            r0 = r2.a(r3, r0);
                            r1.f5465h = r0;
                            r0 = 6;
                            r0 = r2.a(r3, r0);
                            r1.f5467j = r0;
                            r0 = 7;
                            r0 = r2.a(r3, r0);
                            r1.f5468k = r0;
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                        }
                    }

                    /* compiled from: reactions */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Serializer.<init>():void");
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void m6125a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
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
                            r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r8;
                            r2 = null;
                            r0 = r8.w_();
                            if (r0 != null) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128;
                            r0.<init>(r1);
                            r1 = r8.m6130a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = null;
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
                            com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.NodeParser.m6171a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.class;
                            r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                        }
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel m6135c() {
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
                        r0 = r1.m6127o();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.c():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel gQ_() {
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
                        r0 = r1.m6129q();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.gQ_():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel");
                    }

                    @javax.annotation.Nullable
                    public final /* synthetic */ com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel gR_() {
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
                        r0 = r1.m6128p();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.gR_():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 12;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.<init>():void");
                    }

                    public NodeModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
                        r0 = 12;
                        r2.<init>(r0);
                        r1 = r3.a;
                        r0 = r1;
                        r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r2.a(r3, r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                    }

                    @javax.annotation.Nonnull
                    public final com.google.common.collect.ImmutableList<java.lang.String> m6134b() {
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
                        r0 = r2.f5475d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f5475d = r0;
                        r0 = r2.f5475d;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.b():com.google.common.collect.ImmutableList<java.lang.String>");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel m6127o() {
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
                        r0 = r3.f5476e;
                        r1 = 1;
                        r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel) r0;
                        r3.f5476e = r0;
                        r0 = r3.f5476e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.o():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$ForSaleCategoriesModel");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m6136d() {
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
                        r0 = r2.f5477f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f5477f = r0;
                        r0 = r2.f5477f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.d():java.lang.String");
                    }

                    public final boolean gP_() {
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
                        r0 = r2.f5478g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.gP_():boolean");
                    }

                    public final boolean m6137g() {
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
                        r1 = 4;
                        r2.a(r0, r1);
                        r0 = r2.f5479h;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.g():boolean");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel m6128p() {
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
                        r0 = r3.f5480i;
                        r1 = 5;
                        r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel) r0;
                        r3.f5480i = r0;
                        r0 = r3.f5480i;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.p():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$LocationPickerSettingModel");
                    }

                    @javax.annotation.Nullable
                    private com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel m6129q() {
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
                        r0 = r3.f5481j;
                        r1 = 6;
                        r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel) r0;
                        r3.f5481j = r0;
                        r0 = r3.f5481j;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.q():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$MarketplaceCrossPostSettingModel");
                    }

                    @javax.annotation.Nonnull
                    public final com.google.common.collect.ImmutableList<java.lang.String> m6138j() {
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
                        r0 = r2.f5482k;
                        r1 = 7;
                        r0 = super.a(r0, r1);
                        r2.f5482k = r0;
                        r0 = r2.f5482k;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.j():com.google.common.collect.ImmutableList<java.lang.String>");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    @javax.annotation.Nonnull
                    public final com.google.common.collect.ImmutableList<java.lang.String> m6139k() {
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
                        r0 = r2.f5483l;
                        r1 = 8;
                        r0 = super.a(r0, r1);
                        r2.f5483l = r0;
                        r0 = r2.f5483l;
                        r0 = (com.google.common.collect.ImmutableList) r0;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.k():com.google.common.collect.ImmutableList<java.lang.String>");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m6140l() {
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
                        r0 = r2.f5484m;
                        r1 = 9;
                        r0 = super.a(r0, r1);
                        r2.f5484m = r0;
                        r0 = r2.f5484m;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.l():java.lang.String");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean m6141m() {
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
                        r0 = 1;
                        r1 = 2;
                        r2.a(r0, r1);
                        r0 = r2.f5485n;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.m():boolean");
                    }

                    public final boolean m6142n() {
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
                        r0 = 1;
                        r1 = 3;
                        r2.a(r0, r1);
                        r0 = r2.f5486o;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.n():boolean");
                    }

                    public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel m6126a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel r5) {
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
                        r1 = 0;
                        if (r5 != 0) goto L_0x0005;
                    L_0x0003:
                        r5 = 0;
                    L_0x0004:
                        return r5;
                    L_0x0005:
                        r0 = r5 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel;
                        if (r0 == 0) goto L_0x000c;
                    L_0x0009:
                        r5 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r5;
                        goto L_0x0004;
                    L_0x000c:
                        r2 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel$Builder;
                        r2.<init>();
                        r3 = com.google.common.collect.ImmutableList.builder();
                        r0 = r1;
                    L_0x0016:
                        r4 = r5.m6134b();
                        r4 = r4.size();
                        if (r0 >= r4) goto L_0x002e;
                    L_0x0020:
                        r4 = r5.m6134b();
                        r4 = r4.get(r0);
                        r3.c(r4);
                        r0 = r0 + 1;
                        goto L_0x0016;
                    L_0x002e:
                        r0 = r3.b();
                        r2.f5421a = r0;
                        r0 = r5.m6135c();
                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.m6094a(r0);
                        r2.f5422b = r0;
                        r0 = r5.m6136d();
                        r2.f5423c = r0;
                        r0 = r5.gP_();
                        r2.f5424d = r0;
                        r0 = r5.m6137g();
                        r2.f5425e = r0;
                        r0 = r5.gR_();
                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel.m6100a(r0);
                        r2.f5426f = r0;
                        r0 = r5.gQ_();
                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel.m6110a(r0);
                        r2.f5427g = r0;
                        r3 = com.google.common.collect.ImmutableList.builder();
                        r0 = r1;
                    L_0x0069:
                        r4 = r5.m6138j();
                        r4 = r4.size();
                        if (r0 >= r4) goto L_0x0081;
                    L_0x0073:
                        r4 = r5.m6138j();
                        r4 = r4.get(r0);
                        r3.c(r4);
                        r0 = r0 + 1;
                        goto L_0x0069;
                    L_0x0081:
                        r0 = r3.b();
                        r2.f5428h = r0;
                        r0 = com.google.common.collect.ImmutableList.builder();
                    L_0x008b:
                        r3 = r5.m6139k();
                        r3 = r3.size();
                        if (r1 >= r3) goto L_0x00a3;
                    L_0x0095:
                        r3 = r5.m6139k();
                        r3 = r3.get(r1);
                        r0.c(r3);
                        r1 = r1 + 1;
                        goto L_0x008b;
                    L_0x00a3:
                        r0 = r0.b();
                        r2.f5429i = r0;
                        r0 = r5.m6140l();
                        r2.f5430j = r0;
                        r0 = r5.m6141m();
                        r2.f5431k = r0;
                        r0 = r5.m6142n();
                        r2.f5432l = r0;
                        r5 = r2.m6075a();
                        goto L_0x0004;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m6132a() {
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
                        r0 = r1.m6136d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.a():java.lang.String");
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
                        r0 = -482299661; // 0xffffffffe340b0f3 float:-3.5545254E21 double:NaN;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m6131a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                        r0 = r3.m6127o();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m6127o();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel) r0;
                        r2 = r3.m6127o();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r1;
                        r1.f5476e = r0;
                    L_0x0022:
                        r0 = r3.m6128p();
                        if (r0 == 0) goto L_0x0040;
                    L_0x0028:
                        r0 = r3.m6128p();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel) r0;
                        r2 = r3.m6128p();
                        if (r2 == r0) goto L_0x0040;
                    L_0x0038:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r1;
                        r1.f5480i = r0;
                    L_0x0040:
                        r0 = r3.m6129q();
                        if (r0 == 0) goto L_0x005e;
                    L_0x0046:
                        r0 = r3.m6129q();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.MarketplaceCrossPostSettingModel) r0;
                        r2 = r3.m6129q();
                        if (r2 == r0) goto L_0x005e;
                    L_0x0056:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r1;
                        r1.f5481j = r0;
                    L_0x005e:
                        r3.i();
                        if (r1 != 0) goto L_0x0064;
                    L_0x0063:
                        return r3;
                    L_0x0064:
                        r3 = r1;
                        goto L_0x0063;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final int m6130a(com.facebook.flatbuffers.FlatBufferBuilder r10) {
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
                        r9.h();
                        r0 = r9.m6134b();
                        r0 = r10.c(r0);
                        r1 = r9.m6127o();
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r10, r1);
                        r2 = r9.m6136d();
                        r2 = r10.b(r2);
                        r3 = r9.m6128p();
                        r3 = com.facebook.graphql.modelutil.ModelHelper.a(r10, r3);
                        r4 = r9.m6129q();
                        r4 = com.facebook.graphql.modelutil.ModelHelper.a(r10, r4);
                        r5 = r9.m6138j();
                        r5 = r10.c(r5);
                        r6 = r9.m6139k();
                        r6 = r10.c(r6);
                        r7 = r9.m6140l();
                        r7 = r10.b(r7);
                        r8 = 12;
                        r10.c(r8);
                        r8 = null;
                        r10.b(r8, r0);
                        r0 = 1;
                        r10.b(r0, r1);
                        r0 = 2;
                        r10.b(r0, r2);
                        r0 = 3;
                        r1 = r9.f5478g;
                        r10.a(r0, r1);
                        r0 = 4;
                        r1 = r9.f5479h;
                        r10.a(r0, r1);
                        r0 = 5;
                        r10.b(r0, r3);
                        r0 = 6;
                        r10.b(r0, r4);
                        r0 = 7;
                        r10.b(r0, r5);
                        r0 = 8;
                        r10.b(r0, r6);
                        r0 = 9;
                        r10.b(r0, r7);
                        r0 = 10;
                        r1 = r9.f5485n;
                        r10.a(r0, r1);
                        r0 = 11;
                        r1 = r9.f5486o;
                        r10.a(r0, r1);
                        r9.i();
                        r0 = r10.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m6133a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                        r0 = 3;
                        r0 = r2.a(r3, r0);
                        r1.f5478g = r0;
                        r0 = 4;
                        r0 = r2.a(r3, r0);
                        r1.f5479h = r0;
                        r0 = 10;
                        r0 = r2.a(r3, r0);
                        r1.f5485n = r0;
                        r0 = 11;
                        r0 = r2.a(r3, r0);
                        r1.f5486o = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: reactions */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Serializer.<init>():void");
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void m6143a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel) r8;
                        r2 = null;
                        r0 = r8.w_();
                        if (r0 != null) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128;
                        r0.<init>(r1);
                        r1 = r8.m6146a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = null;
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
                        com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLParsers.GroupSellInformationParser.GroupSellConfigParser.EdgesParser.m6173b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.class;
                        r1 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel m6148a() {
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
                    r0 = r1.m6145j();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.a():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel");
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.<init>():void");
                }

                public EdgesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
                    r0 = 1;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                @javax.annotation.Nullable
                private com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel m6145j() {
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
                    r0 = r3.f5487d;
                    r1 = 0;
                    r2 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r0;
                    r3.f5487d = r0;
                    r0 = r3.f5487d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.j():com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$NodeModel");
                }

                public static com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel m6144a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel r8) {
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
                    if (r8 != 0) goto L_0x0004;
                L_0x0002:
                    r8 = 0;
                L_0x0003:
                    return r8;
                L_0x0004:
                    r0 = r8 instanceof com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel;
                    if (r0 == 0) goto L_0x000b;
                L_0x0008:
                    r8 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel) r8;
                    goto L_0x0003;
                L_0x000b:
                    r0 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel$Builder;
                    r0.<init>();
                    r1 = r8.m6148a();
                    r1 = com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.m6126a(r1);
                    r0.f5420a = r1;
                    r6 = 1;
                    r5 = 0;
                    r4 = 0;
                    r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r2.<init>(r3);
                    r3 = r0.f5420a;
                    r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                    r2.c(r6);
                    r2.b(r5, r3);
                    r3 = r2.d();
                    r2.d(r3);
                    r2 = r2.e();
                    r3 = java.nio.ByteBuffer.wrap(r2);
                    r3.position(r5);
                    r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r5 = r4;
                    r7 = r4;
                    r2.<init>(r3, r4, r5, r6, r7);
                    r3 = new com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel;
                    r3.<init>(r2);
                    r8 = r3;
                    goto L_0x0003;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.a(com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel):com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels$GroupSellInformationModel$GroupSellConfigModel$EdgesModel");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -85434922;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6147a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r0 = r3.m6145j();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m6145j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel) r0;
                    r2 = r3.m6145j();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel) r1;
                    r1.f5487d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6146a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m6145j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: reactions */
            public class Serializer extends JsonSerializer<GroupSellConfigModel> {
                public final void m6149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) obj;
                    if (groupSellConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupSellConfigModel.m6151a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupSellConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupSellConfigParser.m6175a(groupSellConfigModel.w_(), groupSellConfigModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupSellConfigModel.class, new Serializer());
                }
            }

            public GroupSellConfigModel() {
                super(1);
            }

            public GroupSellConfigModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m6153a() {
                this.f5488d = super.a(this.f5488d, 0, EdgesModel.class);
                return (ImmutableList) this.f5488d;
            }

            public static GroupSellConfigModel m6150a(GroupSellConfigModel groupSellConfigModel) {
                if (groupSellConfigModel == null) {
                    return null;
                }
                if (groupSellConfigModel instanceof GroupSellConfigModel) {
                    return groupSellConfigModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupSellConfigModel.m6153a().size(); i++) {
                    builder2.c(EdgesModel.m6144a((EdgesModel) groupSellConfigModel.m6153a().get(i)));
                }
                builder.f5419a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5419a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupSellConfigModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -461031369;
            }

            public final GraphQLVisitableModel m6152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6153a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6153a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupSellConfigModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5488d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6151a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6153a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: reactions */
        public class Serializer extends JsonSerializer<GroupSellInformationModel> {
            public final void m6154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSellInformationModel groupSellInformationModel = (GroupSellInformationModel) obj;
                if (groupSellInformationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSellInformationModel.m6156a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSellInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSellInformationModel.w_();
                int u_ = groupSellInformationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_sell_config");
                    GroupSellConfigParser.m6175a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSellInformationModel.class, new Serializer());
            }
        }

        public GroupSellInformationModel() {
            super(1);
        }

        public final void m6158a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6159a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupSellConfigModel m6155a() {
            this.f5489d = (GroupSellConfigModel) super.a(this.f5489d, 0, GroupSellConfigModel.class);
            return this.f5489d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6155a() != null) {
                GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) graphQLModelMutatingVisitor.b(m6155a());
                if (m6155a() != groupSellConfigModel) {
                    graphQLVisitableModel = (GroupSellInformationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5489d = groupSellConfigModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6156a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6155a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
