package com.facebook.socialgood.protocol;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.socialgood.protocol.FundraiserPageInterfaces.FundraiserPageHeaderFundraiserToCharityFragment;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserCoverPhotoFragmentParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserCoverPhotoFragmentParser.AlbumParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.InviteSuggestionsParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserPageFragmentParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserPageFragmentParser.CoverPhotoParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserPageFragmentParser.CoverPhotoParser.FocusParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserPersonToCharityFragmentParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserPersonToCharityFragmentParser.OwnerParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderQueryParser;
import com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserSendInvitesMutationFieldsParser;
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

/* compiled from: OPEN_HOURS_ONLY */
public class FundraiserPageModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1752631368)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserCoverPhotoFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f12740d;
        @Nullable
        private AlbumModel f12741e;
        @Nullable
        private String f12742f;
        @Nullable
        private DefaultImageFieldsModel f12743g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: OPEN_HOURS_ONLY */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f12739d;

            /* compiled from: OPEN_HOURS_ONLY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m13292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m13424a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumModel = new AlbumModel();
                    ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumModel instanceof Postprocessable) {
                        return ((Postprocessable) albumModel).a();
                    }
                    return albumModel;
                }
            }

            /* compiled from: OPEN_HOURS_ONLY */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m13293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m13294a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m13425a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            @Nullable
            public final String m13297j() {
                this.f12739d = super.a(this.f12739d, 0);
                return this.f12739d;
            }

            @Nullable
            public final String m13296a() {
                return m13297j();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m13295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13294a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13297j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserCoverPhotoFragmentModel.class, new Deserializer());
            }

            public Object m13298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserCoverPhotoFragmentParser.m13426a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserCoverPhotoFragmentModel = new FundraiserCoverPhotoFragmentModel();
                ((BaseModel) fundraiserCoverPhotoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserCoverPhotoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserCoverPhotoFragmentModel).a();
                }
                return fundraiserCoverPhotoFragmentModel;
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserCoverPhotoFragmentModel> {
            public final void m13299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel = (FundraiserCoverPhotoFragmentModel) obj;
                if (fundraiserCoverPhotoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserCoverPhotoFragmentModel.m13300a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserCoverPhotoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserCoverPhotoFragmentParser.m13427a(fundraiserCoverPhotoFragmentModel.w_(), fundraiserCoverPhotoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserCoverPhotoFragmentModel.class, new Serializer());
            }
        }

        public FundraiserCoverPhotoFragmentModel() {
            super(4);
        }

        @Nullable
        public final String m13303j() {
            this.f12740d = super.a(this.f12740d, 0);
            return this.f12740d;
        }

        @Nullable
        public final AlbumModel m13304k() {
            this.f12741e = (AlbumModel) super.a(this.f12741e, 1, AlbumModel.class);
            return this.f12741e;
        }

        @Nullable
        public final String m13305l() {
            this.f12742f = super.a(this.f12742f, 2);
            return this.f12742f;
        }

        @Nullable
        public final DefaultImageFieldsModel m13306m() {
            this.f12743g = (DefaultImageFieldsModel) super.a(this.f12743g, 3, DefaultImageFieldsModel.class);
            return this.f12743g;
        }

        @Nullable
        public final String m13302a() {
            return m13305l();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m13301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13304k() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m13304k());
                if (m13304k() != albumModel) {
                    graphQLVisitableModel = (FundraiserCoverPhotoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12741e = albumModel;
                }
            }
            if (m13306m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13306m());
                if (m13306m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FundraiserCoverPhotoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12743g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13300a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13303j());
            int a = ModelHelper.a(flatBufferBuilder, m13304k());
            int b2 = flatBufferBuilder.b(m13305l());
            int a2 = ModelHelper.a(flatBufferBuilder, m13306m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 599436263)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserInviteSuggestionsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12748d;
        @Nullable
        private String f12749e;
        @Nullable
        private InviteSuggestionsModel f12750f;

        /* compiled from: OPEN_HOURS_ONLY */
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
                r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.class;
                r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m13307a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.m13432a(r6);
                r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -378548326)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: OPEN_HOURS_ONLY */
        public final class InviteSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f12747d;

            /* compiled from: OPEN_HOURS_ONLY */
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
                    r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.class;
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m13308a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
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
                    r5 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.InviteSuggestionsParser.m13430a(r11, r4);
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
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2106355611)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: OPEN_HOURS_ONLY */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f12744d;
                @Nullable
                private String f12745e;
                @Nullable
                private DefaultImageFieldsModel f12746f;

                /* compiled from: OPEN_HOURS_ONLY */
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
                        r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.class;
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m13309a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
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
                        r5 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.InviteSuggestionsParser.NodesParser.m13428b(r11, r4);
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
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel$NodesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: OPEN_HOURS_ONLY */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m13310a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
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
                        r8 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m13311a(r0);
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
                        com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.InviteSuggestionsParser.NodesParser.m13429b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.class;
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.<init>():void");
                }

                public final void m13314a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m13315a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13316j() {
                    /* JADX: method processing error */
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
                    r0 = r2.f12744d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f12744d = r0;
                    r0 = r2.f12744d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13317k() {
                    /* JADX: method processing error */
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
                    r0 = r2.f12745e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f12745e = r0;
                    r0 = r2.f12745e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.k():java.lang.String");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel m13318l() {
                    /* JADX: method processing error */
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
                    r0 = r3.f12746f;
                    r1 = 2;
                    r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                    r3.f12746f = r0;
                    r0 = r3.f12746f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.l():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13313a() {
                    /* JADX: method processing error */
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
                    r0 = r1.m13316j();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.a():java.lang.String");
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m13312a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
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
                    r0 = r3.m13318l();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m13318l();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
                    r2 = r3.m13318l();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel) r1;
                    r1.f12746f = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m13311a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                    /* JADX: method processing error */
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
                    r0 = r4.m13316j();
                    r0 = r5.b(r0);
                    r1 = r4.m13317k();
                    r1 = r5.b(r1);
                    r2 = r4.m13318l();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: OPEN_HOURS_ONLY */
            public class Serializer extends JsonSerializer<InviteSuggestionsModel> {
                public final void m13319a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
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
                    r8 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m13320a(r0);
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
                    com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserInviteSuggestionsQueryParser.InviteSuggestionsParser.m13431a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.class;
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserInviteSuggestionsQueryModel$InviteSuggestionsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.Serializer.<clinit>():void");
                }
            }

            public InviteSuggestionsModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.<init>():void");
            }

            @Nonnull
            public final ImmutableList<NodesModel> m13322a() {
                this.f12747d = super.a(this.f12747d, 0, NodesModel.class);
                return (ImmutableList) this.f12747d;
            }

            public final int jK_() {
                return -306154679;
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m13321a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                r2.h();
                r1 = r2.m13322a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m13322a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel) r0;
                r1 = r1.b();
                r0.f12747d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m13320a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m13322a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserInviteSuggestionsQueryModel> {
            public final void m13323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserInviteSuggestionsQueryModel fundraiserInviteSuggestionsQueryModel = (FundraiserInviteSuggestionsQueryModel) r10;
                if (fundraiserInviteSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserInviteSuggestionsQueryModel.m13326a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserInviteSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserInviteSuggestionsQueryModel.w_();
                int u_ = fundraiserInviteSuggestionsQueryModel.u_();
                r11.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    r11.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, r11);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    r11.a("id");
                    r11.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    r11.a("invite_suggestions");
                    InviteSuggestionsParser.m13431a(mutableFlatBuffer, g, r11, r12);
                }
                r11.g();
            }

            static {
                FbSerializerProvider.a(FundraiserInviteSuggestionsQueryModel.class, new Serializer());
            }
        }

        public FundraiserInviteSuggestionsQueryModel() {
            super(3);
        }

        public final void m13329a(String str, ConsistencyTuple consistencyTuple) {
            r2.a();
        }

        public final void m13330a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13324k() {
            if (this.b != null && this.f12748d == null) {
                this.f12748d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12748d;
        }

        @Nullable
        private String m13325l() {
            this.f12749e = super.a(this.f12749e, 1);
            return this.f12749e;
        }

        @Nullable
        public final InviteSuggestionsModel m13331j() {
            this.f12750f = (InviteSuggestionsModel) super.a(this.f12750f, 2, InviteSuggestionsModel.class);
            return this.f12750f;
        }

        @Nullable
        public final String m13328a() {
            return m13325l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13327a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13331j() != null) {
                InviteSuggestionsModel inviteSuggestionsModel = (InviteSuggestionsModel) r4.b(m13331j());
                if (m13331j() != inviteSuggestionsModel) {
                    graphQLVisitableModel = (FundraiserInviteSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12750f = inviteSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13326a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r5, m13324k());
            int b = r5.b(m13325l());
            int a2 = ModelHelper.a(r5, m13331j());
            r5.c(3);
            r5.b(0, a);
            r5.b(1, b);
            r5.b(2, a2);
            i();
            return r5.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1290333118)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserPageHeaderFundraiserPageFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CoverPhotoModel f12755d;
        @Nullable
        private String f12756e;
        @Nullable
        private String f12757f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1201295349)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: OPEN_HOURS_ONLY */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FocusModel f12753d;
            @Nullable
            private FundraiserCoverPhotoFragmentModel f12754e;

            /* compiled from: OPEN_HOURS_ONLY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m13332a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m13435a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -496435496)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: OPEN_HOURS_ONLY */
            public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
                private double f12751d;
                private double f12752e;

                /* compiled from: OPEN_HOURS_ONLY */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                    }

                    public Object m13333a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FocusParser.m13433a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object focusModel = new FocusModel();
                        ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (focusModel instanceof Postprocessable) {
                            return ((Postprocessable) focusModel).a();
                        }
                        return focusModel;
                    }
                }

                /* compiled from: OPEN_HOURS_ONLY */
                public class Serializer extends JsonSerializer<FocusModel> {
                    public final void m13334a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FocusModel focusModel = (FocusModel) obj;
                        if (focusModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(focusModel.m13336a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FocusParser.m13434a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FocusModel.class, new Serializer());
                    }
                }

                public FocusModel() {
                    super(2);
                }

                public final double m13335a() {
                    a(0, 0);
                    return this.f12751d;
                }

                public final double m13339j() {
                    a(0, 1);
                    return this.f12752e;
                }

                public final int jK_() {
                    return 82530482;
                }

                public final GraphQLVisitableModel m13337a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13336a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f12751d, 0.0d);
                    flatBufferBuilder.a(1, this.f12752e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13338a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f12751d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f12752e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: OPEN_HOURS_ONLY */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m13340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m13341a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m13436a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(2);
            }

            @Nullable
            public final FocusModel m13343a() {
                this.f12753d = (FocusModel) super.a(this.f12753d, 0, FocusModel.class);
                return this.f12753d;
            }

            @Nullable
            public final FundraiserCoverPhotoFragmentModel m13344j() {
                this.f12754e = (FundraiserCoverPhotoFragmentModel) super.a(this.f12754e, 1, FundraiserCoverPhotoFragmentModel.class);
                return this.f12754e;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m13342a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13343a() != null) {
                    FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m13343a());
                    if (m13343a() != focusModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12753d = focusModel;
                    }
                }
                if (m13344j() != null) {
                    FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel = (FundraiserCoverPhotoFragmentModel) graphQLModelMutatingVisitor.b(m13344j());
                    if (m13344j() != fundraiserCoverPhotoFragmentModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12754e = fundraiserCoverPhotoFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13341a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13343a());
                int a2 = ModelHelper.a(flatBufferBuilder, m13344j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserPageHeaderFundraiserPageFragmentModel.class, new Deserializer());
            }

            public Object m13345a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserPageHeaderFundraiserPageFragmentParser.m13437a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserPageHeaderFundraiserPageFragmentModel = new FundraiserPageHeaderFundraiserPageFragmentModel();
                ((BaseModel) fundraiserPageHeaderFundraiserPageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserPageHeaderFundraiserPageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserPageHeaderFundraiserPageFragmentModel).a();
                }
                return fundraiserPageHeaderFundraiserPageFragmentModel;
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserPageHeaderFundraiserPageFragmentModel> {
            public final void m13346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserPageHeaderFundraiserPageFragmentModel fundraiserPageHeaderFundraiserPageFragmentModel = (FundraiserPageHeaderFundraiserPageFragmentModel) obj;
                if (fundraiserPageHeaderFundraiserPageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserPageHeaderFundraiserPageFragmentModel.m13347a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserPageHeaderFundraiserPageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserPageHeaderFundraiserPageFragmentParser.m13438a(fundraiserPageHeaderFundraiserPageFragmentModel.w_(), fundraiserPageHeaderFundraiserPageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserPageHeaderFundraiserPageFragmentModel.class, new Serializer());
            }
        }

        public FundraiserPageHeaderFundraiserPageFragmentModel() {
            super(3);
        }

        @Nullable
        public final CoverPhotoModel m13350j() {
            this.f12755d = (CoverPhotoModel) super.a(this.f12755d, 0, CoverPhotoModel.class);
            return this.f12755d;
        }

        @Nullable
        public final String m13351k() {
            this.f12756e = super.a(this.f12756e, 1);
            return this.f12756e;
        }

        @Nullable
        public final String m13352l() {
            this.f12757f = super.a(this.f12757f, 2);
            return this.f12757f;
        }

        @Nullable
        public final String m13349a() {
            return m13351k();
        }

        public final int jK_() {
            return 1147287130;
        }

        public final GraphQLVisitableModel m13348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13350j() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m13350j());
                if (m13350j() != coverPhotoModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderFundraiserPageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12755d = coverPhotoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13347a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13350j());
            int b = flatBufferBuilder.b(m13351k());
            int b2 = flatBufferBuilder.b(m13352l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2019547482)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserPageHeaderFundraiserPersonToCharityFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f12760d;
        @Nullable
        private FundraiserCoverPhotoFragmentModel f12761e;
        @Nullable
        private OwnerModel f12762f;
        @Nullable
        private String f12763g;

        /* compiled from: OPEN_HOURS_ONLY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserPageHeaderFundraiserPersonToCharityFragmentModel.class, new Deserializer());
            }

            public Object m13353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserPageHeaderFundraiserPersonToCharityFragmentParser.m13441a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserPageHeaderFundraiserPersonToCharityFragmentModel = new FundraiserPageHeaderFundraiserPersonToCharityFragmentModel();
                ((BaseModel) fundraiserPageHeaderFundraiserPersonToCharityFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserPageHeaderFundraiserPersonToCharityFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserPageHeaderFundraiserPersonToCharityFragmentModel).a();
                }
                return fundraiserPageHeaderFundraiserPersonToCharityFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: OPEN_HOURS_ONLY */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f12758d;
            @Nullable
            private String f12759e;

            /* compiled from: OPEN_HOURS_ONLY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m13354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m13439a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: OPEN_HOURS_ONLY */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m13355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m13356a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m13440a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public final void m13359a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13360a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m13361j() {
                if (this.b != null && this.f12758d == null) {
                    this.f12758d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12758d;
            }

            @Nullable
            public final String m13362k() {
                this.f12759e = super.a(this.f12759e, 1);
                return this.f12759e;
            }

            @Nullable
            public final String m13358a() {
                return m13362k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m13357a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13356a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13361j());
                int b = flatBufferBuilder.b(m13362k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserPageHeaderFundraiserPersonToCharityFragmentModel> {
            public final void m13363a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserPageHeaderFundraiserPersonToCharityFragmentModel fundraiserPageHeaderFundraiserPersonToCharityFragmentModel = (FundraiserPageHeaderFundraiserPersonToCharityFragmentModel) obj;
                if (fundraiserPageHeaderFundraiserPersonToCharityFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserPageHeaderFundraiserPersonToCharityFragmentModel.m13367a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserPageHeaderFundraiserPersonToCharityFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserPageHeaderFundraiserPersonToCharityFragmentModel.w_();
                int u_ = fundraiserPageHeaderFundraiserPersonToCharityFragmentModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_report");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("header_photo");
                    FundraiserCoverPhotoFragmentParser.m13427a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m13440a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserPageHeaderFundraiserPersonToCharityFragmentModel.class, new Serializer());
            }
        }

        public FundraiserPageHeaderFundraiserPersonToCharityFragmentModel() {
            super(4);
        }

        @Nullable
        private FundraiserCoverPhotoFragmentModel m13364a() {
            this.f12761e = (FundraiserCoverPhotoFragmentModel) super.a(this.f12761e, 1, FundraiserCoverPhotoFragmentModel.class);
            return this.f12761e;
        }

        @Nullable
        private OwnerModel m13365j() {
            this.f12762f = (OwnerModel) super.a(this.f12762f, 2, OwnerModel.class);
            return this.f12762f;
        }

        @Nullable
        private String m13366k() {
            this.f12763g = super.a(this.f12763g, 3);
            return this.f12763g;
        }

        public final int jK_() {
            return -1315407331;
        }

        public final GraphQLVisitableModel m13368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13364a() != null) {
                FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel = (FundraiserCoverPhotoFragmentModel) graphQLModelMutatingVisitor.b(m13364a());
                if (m13364a() != fundraiserCoverPhotoFragmentModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderFundraiserPersonToCharityFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12761e = fundraiserCoverPhotoFragmentModel;
                }
            }
            if (m13365j() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m13365j());
                if (m13365j() != ownerModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderFundraiserPersonToCharityFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12762f = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13367a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13364a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13365j());
            int b = flatBufferBuilder.b(m13366k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f12760d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13369a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12760d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 198084467)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserPageHeaderFundraiserToCharityFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, FundraiserPageHeaderFundraiserToCharityFragment {
        @Nullable
        private GraphQLObjectType f12767d;
        @Nullable
        private String f12768e;
        private boolean f12769f;
        @Nullable
        private CharityModel f12770g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f12771h;
        @Nullable
        private String f12772i;
        @Nullable
        private DefaultImageFieldsModel f12773j;
        @Nullable
        private String f12774k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1497708228)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: OPEN_HOURS_ONLY */
        public final class CharityModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PageModel f12766d;

            /* compiled from: OPEN_HOURS_ONLY */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.class;
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m13370a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.CharityParser.m13444a(r11, r4);
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
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1128002616)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: OPEN_HOURS_ONLY */
            public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f12764d;
                private boolean f12765e;

                /* compiled from: OPEN_HOURS_ONLY */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.class;
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$PageModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m13371a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.CharityParser.PageParser.m13442a(r11, r4);
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
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$PageModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: OPEN_HOURS_ONLY */
                public class Serializer extends JsonSerializer<PageModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Serializer.<init>():void");
                    }

                    public final void m13372a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
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
                        r8 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 == 0) goto L_0x0009;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m13373a(r0);
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
                        com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.CharityParser.PageParser.m13443a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.class;
                        r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$PageModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.Serializer.<clinit>():void");
                    }
                }

                public PageModel() {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.<init>():void");
                }

                public final void m13377a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m13378a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13379b() {
                    /* JADX: method processing error */
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
                    r0 = r2.f12764d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f12764d = r0;
                    r0 = r2.f12764d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.b():java.lang.String");
                }

                public final boolean m13380c() {
                    /* JADX: method processing error */
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
                    r0 = r2.f12765e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.c():boolean");
                }

                @javax.annotation.Nullable
                public final java.lang.String m13375a() {
                    /* JADX: method processing error */
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
                    r0 = r1.m13379b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a():java.lang.String");
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
                    r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m13374a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m13373a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
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
                    r0 = r2.m13379b();
                    r0 = r3.b(r0);
                    r1 = 2;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r0 = 1;
                    r1 = r2.f12765e;
                    r3.a(r0, r1);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m13376a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
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
                    r1.f12765e = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: OPEN_HOURS_ONLY */
            public class Serializer extends JsonSerializer<CharityModel> {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Serializer.<init>():void");
                }

                public final void m13381a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
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
                    r8 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 == 0) goto L_0x0009;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m13382a(r0);
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
                    com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.CharityParser.m13445a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.class;
                    r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.Serializer.<clinit>():void");
                }
            }

            public CharityModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel m13384a() {
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
                r0 = r3.f12766d;
                r1 = 0;
                r2 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel) r0;
                r3.f12766d = r0;
                r0 = r3.f12766d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.a():com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel$PageModel");
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
                r0 = 1023857133; // 0x3d06d1ed float:0.032915045 double:5.058526357E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m13383a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m13384a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m13384a();
                r0 = r4.b(r0);
                r0 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel) r0;
                r2 = r3.m13384a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel) r1;
                r1.f12766d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m13382a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m13384a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Deserializer.<init>():void");
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
                r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.class;
                r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m13385a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.m13446a(r11, r4);
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
                r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserPageHeaderFundraiserToCharityFragmentModel> {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Serializer.<init>():void");
            }

            public final void m13386a(java.lang.Object r12, com.fasterxml.jackson.core.JsonGenerator r13, com.fasterxml.jackson.databind.SerializerProvider r14) {
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
                r11 = this;
                r12 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel) r12;
                r2 = 0;
                r0 = r12.w_();
                if (r0 == 0) goto L_0x0009;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r12.m13394a(r0);
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
                r8 = 1;
                r7 = 0;
                r13.f();
                r6 = r0.g(r1, r7);
                if (r6 != 0) goto L_0x004a;
            L_0x004a:
                r6 = "__type__";
                r13.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r13);
            L_0x0052:
                r6 = r0.g(r1, r8);
                if (r6 != 0) goto L_0x0058;
            L_0x0058:
                r6 = "campaign_title";
                r13.a(r6);
                r6 = r0.c(r1, r8);
                r13.b(r6);
            L_0x0064:
                r6 = 2;
                r6 = r0.a(r1, r6);
                if (r6 != 0) goto L_0x006b;
            L_0x006b:
                r7 = "can_invite_to_campaign";
                r13.a(r7);
                r13.a(r6);
            L_0x0073:
                r6 = 3;
                r6 = r0.g(r1, r6);
                if (r6 != 0) goto L_0x007a;
            L_0x007a:
                r7 = "charity";
                r13.a(r7);
                com.facebook.socialgood.protocol.FundraiserPageParsers.FundraiserPageHeaderFundraiserToCharityFragmentParser.CharityParser.m13445a(r0, r6, r13, r14);
            L_0x0082:
                r6 = 4;
                r6 = r0.g(r1, r6);
                if (r6 != 0) goto L_0x0089;
            L_0x0089:
                r7 = "fundraiser_page_subtitle";
                r13.a(r7);
                com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser.b(r0, r6, r13, r14);
            L_0x0091:
                r6 = r0.g(r1, r9);
                if (r6 != 0) goto L_0x0097;
            L_0x0097:
                r6 = "id";
                r13.a(r6);
                r6 = r0.c(r1, r9);
                r13.b(r6);
            L_0x00a3:
                r6 = 6;
                r6 = r0.g(r1, r6);
                if (r6 != 0) goto L_0x00aa;
            L_0x00aa:
                r7 = "logo_image";
                r13.a(r7);
                com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser.a(r0, r6, r13);
            L_0x00b2:
                r6 = r0.g(r1, r10);
                if (r6 != 0) goto L_0x00b8;
            L_0x00b8:
                r6 = "mobile_donate_url";
                r13.a(r6);
                r6 = r0.c(r1, r10);
                r13.b(r6);
            L_0x00c4:
                r13.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.class;
                r1 = new com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.Serializer.<clinit>():void");
            }
        }

        public FundraiserPageHeaderFundraiserToCharityFragmentModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.<init>():void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m13387j() {
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
            r4 = this;
            r0 = r4.b;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r4.f12767d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f12767d = r0;
        L_0x0017:
            r0 = r4.f12767d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.j():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nullable
        private java.lang.String m13388k() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f12768e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f12768e = r0;
            r0 = r2.f12768e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.k():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel m13389l() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f12770g;
            r1 = 3;
            r2 = com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel) r0;
            r3.f12770g = r0;
            r0 = r3.f12770g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.l():com.facebook.socialgood.protocol.FundraiserPageModels$FundraiserPageHeaderFundraiserToCharityFragmentModel$CharityModel");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel m13390m() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f12771h;
            r1 = 4;
            r2 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
            r3.f12771h = r0;
            r0 = r3.f12771h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.m():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels$DefaultTextWithEntitiesLongFieldsModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m13391n() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f12772i;
            r1 = 5;
            r0 = super.a(r0, r1);
            r2.f12772i = r0;
            r0 = r2.f12772i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.n():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel m13392o() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f12773j;
            r1 = 6;
            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r3.f12773j = r0;
            r0 = r3.f12773j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.o():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
        }

        @javax.annotation.Nullable
        private java.lang.String m13393p() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f12774k;
            r1 = 7;
            r0 = super.a(r0, r1);
            r2.f12774k = r0;
            r0 = r2.f12774k;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.p():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m13396a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = r1.m13391n();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = -2117047886; // 0xffffffff81d069b2 float:-7.65588E-38 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m13395a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m13389l();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m13389l();
            r0 = r4.b(r0);
            r0 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel) r0;
            r2 = r3.m13389l();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel) r1;
            r1.f12770g = r0;
        L_0x0022:
            r0 = r3.m13390m();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m13390m();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
            r2 = r3.m13390m();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel) r1;
            r1.f12771h = r0;
        L_0x0040:
            r0 = r3.m13392o();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m13392o();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r2 = r3.m13392o();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel) r1;
            r1.f12773j = r0;
        L_0x005e:
            r3.i();
            if (r1 != 0) goto L_0x0064;
        L_0x0063:
            return r3;
        L_0x0064:
            r3 = r1;
            goto L_0x0063;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m13394a(com.facebook.flatbuffers.FlatBufferBuilder r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r8.h();
            r0 = r8.m13387j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r0);
            r1 = r8.m13388k();
            r1 = r9.b(r1);
            r2 = r8.m13389l();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r2);
            r3 = r8.m13390m();
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r3);
            r4 = r8.m13391n();
            r4 = r9.b(r4);
            r5 = r8.m13392o();
            r5 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r5);
            r6 = r8.m13393p();
            r6 = r9.b(r6);
            r7 = 8;
            r9.c(r7);
            r7 = 0;
            r9.b(r7, r0);
            r0 = 1;
            r9.b(r0, r1);
            r0 = 2;
            r1 = r8.f12769f;
            r9.a(r0, r1);
            r0 = 3;
            r9.b(r0, r2);
            r0 = 4;
            r9.b(r0, r3);
            r0 = 5;
            r9.b(r0, r4);
            r0 = 6;
            r9.b(r0, r5);
            r0 = 7;
            r9.b(r0, r6);
            r8.i();
            r0 = r9.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public final void m13397a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            super.a(r2, r3, r4);
            r0 = 2;
            r0 = r2.a(r3, r0);
            r1.f12769f = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1979502213)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserPageHeaderQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FundraiserPageHeaderFundraiserToCharityFragment {
        @Nullable
        private GraphQLObjectType f12775d;
        @Nullable
        private String f12776e;
        private boolean f12777f;
        private boolean f12778g;
        @Nullable
        private CharityModel f12779h;
        @Nullable
        private FundraiserPageHeaderFundraiserPageFragmentModel f12780i;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f12781j;
        @Nullable
        private FundraiserCoverPhotoFragmentModel f12782k;
        @Nullable
        private String f12783l;
        @Nullable
        private DefaultImageFieldsModel f12784m;
        @Nullable
        private String f12785n;
        @Nullable
        private OwnerModel f12786o;
        @Nullable
        private String f12787p;

        /* compiled from: OPEN_HOURS_ONLY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserPageHeaderQueryModel.class, new Deserializer());
            }

            public Object m13398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserPageHeaderQueryParser.m13447a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserPageHeaderQueryModel = new FundraiserPageHeaderQueryModel();
                ((BaseModel) fundraiserPageHeaderQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserPageHeaderQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserPageHeaderQueryModel).a();
                }
                return fundraiserPageHeaderQueryModel;
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserPageHeaderQueryModel> {
            public final void m13399a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel = (FundraiserPageHeaderQueryModel) obj;
                if (fundraiserPageHeaderQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserPageHeaderQueryModel.m13400a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserPageHeaderQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserPageHeaderQueryParser.m13448a(fundraiserPageHeaderQueryModel.w_(), fundraiserPageHeaderQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserPageHeaderQueryModel.class, new Serializer());
            }
        }

        public FundraiserPageHeaderQueryModel() {
            super(13);
        }

        public final void m13404a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13405a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m13406j() {
            if (this.b != null && this.f12775d == null) {
                this.f12775d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12775d;
        }

        @Nullable
        public final String m13407k() {
            this.f12776e = super.a(this.f12776e, 1);
            return this.f12776e;
        }

        public final boolean m13408l() {
            a(0, 2);
            return this.f12777f;
        }

        public final boolean m13409m() {
            a(0, 3);
            return this.f12778g;
        }

        @Nullable
        public final CharityModel m13410n() {
            this.f12779h = (CharityModel) super.a(this.f12779h, 4, CharityModel.class);
            return this.f12779h;
        }

        @Nullable
        public final FundraiserPageHeaderFundraiserPageFragmentModel m13411o() {
            this.f12780i = (FundraiserPageHeaderFundraiserPageFragmentModel) super.a(this.f12780i, 5, FundraiserPageHeaderFundraiserPageFragmentModel.class);
            return this.f12780i;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m13412p() {
            this.f12781j = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12781j, 6, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f12781j;
        }

        @Nullable
        public final FundraiserCoverPhotoFragmentModel m13413q() {
            this.f12782k = (FundraiserCoverPhotoFragmentModel) super.a(this.f12782k, 7, FundraiserCoverPhotoFragmentModel.class);
            return this.f12782k;
        }

        @Nullable
        public final String m13414r() {
            this.f12783l = super.a(this.f12783l, 8);
            return this.f12783l;
        }

        @Nullable
        public final DefaultImageFieldsModel m13415s() {
            this.f12784m = (DefaultImageFieldsModel) super.a(this.f12784m, 9, DefaultImageFieldsModel.class);
            return this.f12784m;
        }

        @Nullable
        public final String m13416t() {
            this.f12785n = super.a(this.f12785n, 10);
            return this.f12785n;
        }

        @Nullable
        public final OwnerModel m13417u() {
            this.f12786o = (OwnerModel) super.a(this.f12786o, 11, OwnerModel.class);
            return this.f12786o;
        }

        @Nullable
        public final String m13418v() {
            this.f12787p = super.a(this.f12787p, 12);
            return this.f12787p;
        }

        @Nullable
        public final String m13402a() {
            return m13414r();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13401a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13410n() != null) {
                CharityModel charityModel = (CharityModel) graphQLModelMutatingVisitor.b(m13410n());
                if (m13410n() != charityModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12779h = charityModel;
                }
            }
            if (m13411o() != null) {
                FundraiserPageHeaderFundraiserPageFragmentModel fundraiserPageHeaderFundraiserPageFragmentModel = (FundraiserPageHeaderFundraiserPageFragmentModel) graphQLModelMutatingVisitor.b(m13411o());
                if (m13411o() != fundraiserPageHeaderFundraiserPageFragmentModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12780i = fundraiserPageHeaderFundraiserPageFragmentModel;
                }
            }
            if (m13412p() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m13412p());
                if (m13412p() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12781j = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m13413q() != null) {
                FundraiserCoverPhotoFragmentModel fundraiserCoverPhotoFragmentModel = (FundraiserCoverPhotoFragmentModel) graphQLModelMutatingVisitor.b(m13413q());
                if (m13413q() != fundraiserCoverPhotoFragmentModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12782k = fundraiserCoverPhotoFragmentModel;
                }
            }
            if (m13415s() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13415s());
                if (m13415s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12784m = defaultImageFieldsModel;
                }
            }
            if (m13417u() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m13417u());
                if (m13417u() != ownerModel) {
                    graphQLVisitableModel = (FundraiserPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12786o = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13400a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13406j());
            int b = flatBufferBuilder.b(m13407k());
            int a2 = ModelHelper.a(flatBufferBuilder, m13410n());
            int a3 = ModelHelper.a(flatBufferBuilder, m13411o());
            int a4 = ModelHelper.a(flatBufferBuilder, m13412p());
            int a5 = ModelHelper.a(flatBufferBuilder, m13413q());
            int b2 = flatBufferBuilder.b(m13414r());
            int a6 = ModelHelper.a(flatBufferBuilder, m13415s());
            int b3 = flatBufferBuilder.b(m13416t());
            int a7 = ModelHelper.a(flatBufferBuilder, m13417u());
            int b4 = flatBufferBuilder.b(m13418v());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f12777f);
            flatBufferBuilder.a(3, this.f12778g);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13403a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12777f = mutableFlatBuffer.a(i, 2);
            this.f12778g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: OPEN_HOURS_ONLY */
    public final class FundraiserSendInvitesMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12788d;

        /* compiled from: OPEN_HOURS_ONLY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserSendInvitesMutationFieldsModel.class, new Deserializer());
            }

            public Object m13419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserSendInvitesMutationFieldsParser.m13449a(jsonParser);
                Object fundraiserSendInvitesMutationFieldsModel = new FundraiserSendInvitesMutationFieldsModel();
                ((BaseModel) fundraiserSendInvitesMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserSendInvitesMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserSendInvitesMutationFieldsModel).a();
                }
                return fundraiserSendInvitesMutationFieldsModel;
            }
        }

        /* compiled from: OPEN_HOURS_ONLY */
        public class Serializer extends JsonSerializer<FundraiserSendInvitesMutationFieldsModel> {
            public final void m13420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserSendInvitesMutationFieldsModel fundraiserSendInvitesMutationFieldsModel = (FundraiserSendInvitesMutationFieldsModel) obj;
                if (fundraiserSendInvitesMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserSendInvitesMutationFieldsModel.m13422a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserSendInvitesMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserSendInvitesMutationFieldsModel.w_();
                int u_ = fundraiserSendInvitesMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserSendInvitesMutationFieldsModel.class, new Serializer());
            }
        }

        public FundraiserSendInvitesMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private String m13421a() {
            this.f12788d = super.a(this.f12788d, 0);
            return this.f12788d;
        }

        public final int jK_() {
            return 46557526;
        }

        public final GraphQLVisitableModel m13423a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13422a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13421a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
