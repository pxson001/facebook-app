package com.facebook.search.graphql;

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
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.graphql.SearchEntityInterfaces.SearchEntityFragment;
import com.facebook.search.graphql.SearchEntityParsers.PhoneticNameParser;
import com.facebook.search.graphql.SearchEntityParsers.PhoneticNameParser.PartsParser;
import com.facebook.search.graphql.SearchEntityParsers.StructuredGrammarCostParser;
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

/* compiled from: event_update_extended_viewer_watch_status */
public class SearchEntityModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1882635850)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_update_extended_viewer_watch_status */
    public final class PhoneticNameModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PartsModel> f15859d;
        @Nullable
        private String f15860e;

        /* compiled from: event_update_extended_viewer_watch_status */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhoneticNameModel.class, new Deserializer());
            }

            public Object m23483a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhoneticNameParser.m23529a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object phoneticNameModel = new PhoneticNameModel();
                ((BaseModel) phoneticNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (phoneticNameModel instanceof Postprocessable) {
                    return ((Postprocessable) phoneticNameModel).a();
                }
                return phoneticNameModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1501120714)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_update_extended_viewer_watch_status */
        public final class PartsModel extends BaseModel implements GraphQLVisitableModel {
            private int f15856d;
            private int f15857e;
            @Nullable
            private GraphQLStructuredNamePart f15858f;

            /* compiled from: event_update_extended_viewer_watch_status */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PartsModel.class, new Deserializer());
                }

                public Object m23484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PartsParser.m23528b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object partsModel = new PartsModel();
                    ((BaseModel) partsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (partsModel instanceof Postprocessable) {
                        return ((Postprocessable) partsModel).a();
                    }
                    return partsModel;
                }
            }

            /* compiled from: event_update_extended_viewer_watch_status */
            public class Serializer extends JsonSerializer<PartsModel> {
                public final void m23485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PartsModel partsModel = (PartsModel) obj;
                    if (partsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(partsModel.m23487a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        partsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PartsParser.m23527a(partsModel.w_(), partsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PartsModel.class, new Serializer());
                }
            }

            public PartsModel() {
                super(3);
            }

            public final int m23486a() {
                a(0, 0);
                return this.f15856d;
            }

            public final int m23490b() {
                a(0, 1);
                return this.f15857e;
            }

            @Nullable
            public final GraphQLStructuredNamePart m23491c() {
                this.f15858f = (GraphQLStructuredNamePart) super.b(this.f15858f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f15858f;
            }

            public final int jK_() {
                return 1905097022;
            }

            public final GraphQLVisitableModel m23488a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23487a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m23491c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f15856d, 0);
                flatBufferBuilder.a(1, this.f15857e, 0);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23489a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15856d = mutableFlatBuffer.a(i, 0, 0);
                this.f15857e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: event_update_extended_viewer_watch_status */
        public class Serializer extends JsonSerializer<PhoneticNameModel> {
            public final void m23492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhoneticNameModel phoneticNameModel = (PhoneticNameModel) obj;
                if (phoneticNameModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(phoneticNameModel.m23493a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    phoneticNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhoneticNameParser.m23530a(phoneticNameModel.w_(), phoneticNameModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhoneticNameModel.class, new Serializer());
            }
        }

        public PhoneticNameModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<PartsModel> m23495a() {
            this.f15859d = super.a(this.f15859d, 0, PartsModel.class);
            return (ImmutableList) this.f15859d;
        }

        @Nullable
        public final String m23496b() {
            this.f15860e = super.a(this.f15860e, 1);
            return this.f15860e;
        }

        public final int jK_() {
            return 2420395;
        }

        public final GraphQLVisitableModel m23494a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23495a() != null) {
                Builder a = ModelHelper.a(m23495a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PhoneticNameModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15859d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23493a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23495a());
            int b = flatBufferBuilder.b(m23496b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1256669087)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_update_extended_viewer_watch_status */
    public final class SearchEntityFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchEntityFragment {
        @Nullable
        private GraphQLObjectType f15863d;
        private boolean f15864e;
        @Nullable
        private GroupIconModel f15865f;
        @Nullable
        private String f15866g;
        private boolean f15867h;
        @Nullable
        private String f15868i;
        @Nullable
        private DefaultImageFieldsModel f15869j;
        @Nullable
        private GraphQLSavedState f15870k;

        /* compiled from: event_update_extended_viewer_watch_status */
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
                r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.class;
                r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m23497a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r5 = com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.m23535a(r11, r4);
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
                r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 395481515)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: event_update_extended_viewer_watch_status */
        public final class GroupIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DarkIconModel f15862d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: event_update_extended_viewer_watch_status */
            public final class DarkIconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f15861d;

                /* compiled from: event_update_extended_viewer_watch_status */
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
                        r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.class;
                        r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$DarkIconModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m23498a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
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
                        r5 = com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.GroupIconParser.DarkIconParser.m23531a(r11, r4);
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
                        r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$DarkIconModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: event_update_extended_viewer_watch_status */
                public class Serializer extends JsonSerializer<DarkIconModel> {
                    public final void m23499a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
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
                        r8 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m23500a(r0);
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
                        com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.GroupIconParser.DarkIconParser.m23532a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.class;
                        r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$DarkIconModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.Serializer.<clinit>():void");
                    }
                }

                public DarkIconModel() {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m23502a() {
                    /* JADX: method processing error */
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
                    r0 = r2.f15861d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f15861d = r0;
                    r0 = r2.f15861d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.a():java.lang.String");
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
                    r0 = 2273433; // 0x22b099 float:3.185758E-39 double:1.123225E-317;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m23501a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m23500a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
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
                    r0 = r2.m23502a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: event_update_extended_viewer_watch_status */
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
                    r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.class;
                    r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m23503a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
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
                    r5 = com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.GroupIconParser.m23533a(r11, r4);
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
                    r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: event_update_extended_viewer_watch_status */
            public class Serializer extends JsonSerializer<GroupIconModel> {
                public final void m23504a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
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
                    r8 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m23506a(r0);
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
                    com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.GroupIconParser.m23534a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.class;
                    r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel m23508a() {
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
                r0 = r1.m23505j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.a():com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$DarkIconModel");
            }

            public GroupIconModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel m23505j() {
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
                r0 = r3.f15862d;
                r1 = 0;
                r2 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel) r0;
                r3.f15862d = r0;
                r0 = r3.f15862d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.j():com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel$DarkIconModel");
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
                r0 = -452718528; // 0xffffffffe5041040 float:-3.897826E22 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m23507a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m23505j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m23505j();
                r0 = r4.b(r0);
                r0 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.DarkIconModel) r0;
                r2 = r3.m23505j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel) r1;
                r1.f15862d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m23506a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m23505j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: event_update_extended_viewer_watch_status */
        public class Serializer extends JsonSerializer<SearchEntityFragmentModel> {
            public final void m23509a(java.lang.Object r12, com.fasterxml.jackson.core.JsonGenerator r13, com.fasterxml.jackson.databind.SerializerProvider r14) {
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
                r11 = this;
                r12 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel) r12;
                r2 = 0;
                r0 = r12.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r12.m23516a(r0);
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
                r12.a(r0, r1);
            L_0x0035:
                r0 = r12.w_();
                r1 = r12.u_();
                r10 = 7;
                r9 = 5;
                r8 = 3;
                r7 = 0;
                r13.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x0052;
            L_0x004a:
                r6 = "__type__";
                r13.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r13);
            L_0x0052:
                r6 = 1;
                r6 = r0.a(r1, r6);
                if (r6 == 0) goto L_0x0061;
            L_0x0059:
                r7 = "does_viewer_like";
                r13.a(r7);
                r13.a(r6);
            L_0x0061:
                r6 = 2;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0070;
            L_0x0068:
                r7 = "group_icon";
                r13.a(r7);
                com.facebook.search.graphql.SearchEntityParsers.SearchEntityFragmentParser.GroupIconParser.m23534a(r0, r6, r13, r14);
            L_0x0070:
                r6 = r0.g(r1, r8);
                if (r6 == 0) goto L_0x0082;
            L_0x0076:
                r6 = "id";
                r13.a(r6);
                r6 = r0.c(r1, r8);
                r13.b(r6);
            L_0x0082:
                r6 = 4;
                r6 = r0.a(r1, r6);
                if (r6 == 0) goto L_0x0091;
            L_0x0089:
                r7 = "is_viewer_friend";
                r13.a(r7);
                r13.a(r6);
            L_0x0091:
                r6 = r0.g(r1, r9);
                if (r6 == 0) goto L_0x00a3;
            L_0x0097:
                r6 = "name";
                r13.a(r6);
                r6 = r0.c(r1, r9);
                r13.b(r6);
            L_0x00a3:
                r6 = 6;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x00b2;
            L_0x00aa:
                r7 = "profile_picture";
                r13.a(r7);
                com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser.a(r0, r6, r13);
            L_0x00b2:
                r6 = r0.g(r1, r10);
                if (r6 == 0) goto L_0x00c4;
            L_0x00b8:
                r6 = "viewer_saved_state";
                r13.a(r6);
                r6 = r0.b(r1, r10);
                r13.b(r6);
            L_0x00c4:
                r13.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.class;
                r1 = new com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.Serializer.<clinit>():void");
            }
        }

        public SearchEntityFragmentModel() {
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
            r0 = 8;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.<init>():void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m23510j() {
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
            r0 = r4.f15863d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f15863d = r0;
        L_0x0017:
            r0 = r4.f15863d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.j():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nullable
        private com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel m23511k() {
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
            r0 = r3.f15865f;
            r1 = 2;
            r2 = com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel) r0;
            r3.f15865f = r0;
            r0 = r3.f15865f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.k():com.facebook.search.graphql.SearchEntityModels$SearchEntityFragmentModel$GroupIconModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m23512l() {
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
            r0 = r2.f15866g;
            r1 = 3;
            r0 = super.a(r0, r1);
            r2.f15866g = r0;
            r0 = r2.f15866g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.l():java.lang.String");
        }

        @javax.annotation.Nullable
        private java.lang.String m23513m() {
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
            r0 = r2.f15868i;
            r1 = 5;
            r0 = super.a(r0, r1);
            r2.f15868i = r0;
            r0 = r2.f15868i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.m():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel m23514n() {
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
            r0 = r3.f15869j;
            r1 = 6;
            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r3.f15869j = r0;
            r0 = r3.f15869j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.n():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLSavedState m23515o() {
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
            r0 = r4.f15870k;
            r1 = 7;
            r2 = com.facebook.graphql.enums.GraphQLSavedState.class;
            r3 = com.facebook.graphql.enums.GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLSavedState) r0;
            r4.f15870k = r0;
            r0 = r4.f15870k;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.o():com.facebook.graphql.enums.GraphQLSavedState");
        }

        @javax.annotation.Nullable
        public final java.lang.String m23518a() {
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
            r0 = r1.m23512l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.a():java.lang.String");
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
            r0 = 574543248; // 0x223ed590 float:2.586286E-18 double:2.83862081E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m23517a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m23511k();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m23511k();
            r0 = r4.b(r0);
            r0 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel) r0;
            r2 = r3.m23511k();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel) r1;
            r1.f15865f = r0;
        L_0x0022:
            r0 = r3.m23514n();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m23514n();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r2 = r3.m23514n();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel) r1;
            r1.f15869j = r0;
        L_0x0040:
            r3.i();
            if (r1 != 0) goto L_0x0046;
        L_0x0045:
            return r3;
        L_0x0046:
            r3 = r1;
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m23516a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
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
            r7 = this;
            r7.h();
            r0 = r7.m23510j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
            r1 = r7.m23511k();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r1);
            r2 = r7.m23512l();
            r2 = r8.b(r2);
            r3 = r7.m23513m();
            r3 = r8.b(r3);
            r4 = r7.m23514n();
            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r4);
            r5 = r7.m23515o();
            r5 = r8.a(r5);
            r6 = 8;
            r8.c(r6);
            r6 = 0;
            r8.b(r6, r0);
            r0 = 1;
            r6 = r7.f15864e;
            r8.a(r0, r6);
            r0 = 2;
            r8.b(r0, r1);
            r0 = 3;
            r8.b(r0, r2);
            r0 = 4;
            r1 = r7.f15867h;
            r8.a(r0, r1);
            r0 = 5;
            r8.b(r0, r3);
            r0 = 6;
            r8.b(r0, r4);
            r0 = 7;
            r8.b(r0, r5);
            r7.i();
            r0 = r8.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public final void m23519a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
            super.a(r2, r3, r4);
            r0 = 1;
            r0 = r2.a(r3, r0);
            r1.f15864e = r0;
            r0 = 4;
            r0 = r2.a(r3, r0);
            r1.f15867h = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1880476425)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: event_update_extended_viewer_watch_status */
    public final class StructuredGrammarCostModel extends BaseModel implements GraphQLVisitableModel {
        private double f15871d;
        @Nullable
        private String f15872e;

        /* compiled from: event_update_extended_viewer_watch_status */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredGrammarCostModel.class, new Deserializer());
            }

            public Object m23520a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredGrammarCostParser.m23539b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredGrammarCostModel = new StructuredGrammarCostModel();
                ((BaseModel) structuredGrammarCostModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredGrammarCostModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredGrammarCostModel).a();
                }
                return structuredGrammarCostModel;
            }
        }

        /* compiled from: event_update_extended_viewer_watch_status */
        public class Serializer extends JsonSerializer<StructuredGrammarCostModel> {
            public final void m23521a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredGrammarCostModel structuredGrammarCostModel = (StructuredGrammarCostModel) obj;
                if (structuredGrammarCostModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredGrammarCostModel.m23523a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredGrammarCostModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredGrammarCostParser.m23537a(structuredGrammarCostModel.w_(), structuredGrammarCostModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StructuredGrammarCostModel.class, new Serializer());
            }
        }

        public StructuredGrammarCostModel() {
            super(2);
        }

        public final double m23522a() {
            a(0, 0);
            return this.f15871d;
        }

        @Nullable
        public final String m23526b() {
            this.f15872e = super.a(this.f15872e, 1);
            return this.f15872e;
        }

        public final int jK_() {
            return -1360787468;
        }

        public final GraphQLVisitableModel m23524a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23523a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23526b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f15871d, 0.0d);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23525a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15871d = mutableFlatBuffer.a(i, 0, 0.0d);
        }
    }
}
