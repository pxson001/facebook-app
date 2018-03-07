package com.facebook.timeline.aboutpage.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineCollectionsSectionViewQueryParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineCollectionsSectionViewQueryParser.CollectionsParser;
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

/* compiled from: MODAL */
public class FetchTimelineCollectionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1831598631)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MODAL */
    public final class FetchTimelineCollectionsSectionViewQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsAppSection {
        @Nullable
        private CollectionsModel f13480d;
        @Nullable
        private DefaultImageFieldsModel f13481e;
        @Nullable
        private String f13482f;
        @Nullable
        private String f13483g;
        @Nullable
        private GraphQLTimelineAppSectionType f13484h;
        @Nullable
        private String f13485i;
        @Nullable
        private SubtitleModel f13486j;
        @Nullable
        private TitleModel f13487k;
        @Nullable
        private String f13488l;
        @Nullable
        private String f13489m;

        /* compiled from: MODAL */
        public final class Builder {
            @Nullable
            public CollectionsModel f13464a;
            @Nullable
            public DefaultImageFieldsModel f13465b;
            @Nullable
            public String f13466c;
            @Nullable
            public String f13467d;
            @Nullable
            public GraphQLTimelineAppSectionType f13468e;
            @Nullable
            public String f13469f;
            @Nullable
            public SubtitleModel f13470g;
            @Nullable
            public TitleModel f13471h;
            @Nullable
            public String f13472i;
            @Nullable
            public String f13473j;

            public final FetchTimelineCollectionsSectionViewQueryModel m14695a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13464a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13465b);
                int b = flatBufferBuilder.b(this.f13466c);
                int b2 = flatBufferBuilder.b(this.f13467d);
                int a3 = flatBufferBuilder.a(this.f13468e);
                int b3 = flatBufferBuilder.b(this.f13469f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13470g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13471h);
                int b4 = flatBufferBuilder.b(this.f13472i);
                int b5 = flatBufferBuilder.b(this.f13473j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, b4);
                flatBufferBuilder.b(9, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FetchTimelineCollectionsSectionViewQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -723909592)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MODAL */
        public final class CollectionsModel extends BaseModel implements GraphQLVisitableModel {
            private int f13477d;
            @Nullable
            private List<CollectionWithItemsAndSuggestionsModel> f13478e;
            @Nullable
            private DefaultPageInfoFieldsModel f13479f;

            /* compiled from: MODAL */
            public final class Builder {
                public int f13474a;
                @Nullable
                public ImmutableList<CollectionWithItemsAndSuggestionsModel> f13475b;
                @Nullable
                public DefaultPageInfoFieldsModel f13476c;
            }

            /* compiled from: MODAL */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CollectionsModel.class, new Deserializer());
                }

                public Object m14696a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollectionsParser.m14737a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object collectionsModel = new CollectionsModel();
                    ((BaseModel) collectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (collectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) collectionsModel).a();
                    }
                    return collectionsModel;
                }
            }

            /* compiled from: MODAL */
            public class Serializer extends JsonSerializer<CollectionsModel> {
                public final void m14697a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CollectionsModel collectionsModel = (CollectionsModel) obj;
                    if (collectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(collectionsModel.m14698a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        collectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollectionsParser.m14738a(collectionsModel.w_(), collectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CollectionsModel.class, new Serializer());
                }
            }

            public CollectionsModel() {
                super(3);
            }

            public CollectionsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<CollectionWithItemsAndSuggestionsModel> m14700a() {
                this.f13478e = super.a(this.f13478e, 1, CollectionWithItemsAndSuggestionsModel.class);
                return (ImmutableList) this.f13478e;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m14702j() {
                this.f13479f = (DefaultPageInfoFieldsModel) super.a(this.f13479f, 2, DefaultPageInfoFieldsModel.class);
                return this.f13479f;
            }

            public final int jK_() {
                return -306448333;
            }

            public final GraphQLVisitableModel m14699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m14700a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14700a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        CollectionsModel collectionsModel = (CollectionsModel) ModelHelper.a(null, this);
                        collectionsModel.f13478e = a.b();
                        graphQLVisitableModel = collectionsModel;
                        if (m14702j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14702j());
                            if (m14702j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (CollectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13479f = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m14702j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14702j());
                    if (m14702j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (CollectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13479f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m14698a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14700a());
                int a2 = ModelHelper.a(flatBufferBuilder, m14702j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f13477d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14701a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13477d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: MODAL */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTimelineCollectionsSectionViewQueryModel.class, new Deserializer());
            }

            public Object m14703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTimelineCollectionsSectionViewQueryParser.m14739a(jsonParser);
                Object fetchTimelineCollectionsSectionViewQueryModel = new FetchTimelineCollectionsSectionViewQueryModel();
                ((BaseModel) fetchTimelineCollectionsSectionViewQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTimelineCollectionsSectionViewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTimelineCollectionsSectionViewQueryModel).a();
                }
                return fetchTimelineCollectionsSectionViewQueryModel;
            }
        }

        /* compiled from: MODAL */
        public class Serializer extends JsonSerializer<FetchTimelineCollectionsSectionViewQueryModel> {
            public final void m14704a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchTimelineCollectionsSectionViewQueryModel fetchTimelineCollectionsSectionViewQueryModel = (FetchTimelineCollectionsSectionViewQueryModel) obj;
                if (fetchTimelineCollectionsSectionViewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTimelineCollectionsSectionViewQueryModel.m14708a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTimelineCollectionsSectionViewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchTimelineCollectionsSectionViewQueryParser.m14740a(fetchTimelineCollectionsSectionViewQueryModel.w_(), fetchTimelineCollectionsSectionViewQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchTimelineCollectionsSectionViewQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo388b() {
            return m14705l();
        }

        @Nullable
        public final /* synthetic */ CollectionsModel m14715j() {
            return m14716k();
        }

        public FetchTimelineCollectionsSectionViewQueryModel() {
            super(10);
        }

        public FetchTimelineCollectionsSectionViewQueryModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final CollectionsModel m14716k() {
            this.f13480d = (CollectionsModel) super.a(this.f13480d, 0, CollectionsModel.class);
            return this.f13480d;
        }

        @Nullable
        private DefaultImageFieldsModel m14705l() {
            this.f13481e = (DefaultImageFieldsModel) super.a(this.f13481e, 1, DefaultImageFieldsModel.class);
            return this.f13481e;
        }

        @Nullable
        public final String mo389c() {
            this.f13482f = super.a(this.f13482f, 2);
            return this.f13482f;
        }

        @Nullable
        public final String mo390d() {
            this.f13483g = super.a(this.f13483g, 3);
            return this.f13483g;
        }

        @Nullable
        public final GraphQLTimelineAppSectionType nP_() {
            this.f13484h = (GraphQLTimelineAppSectionType) super.b(this.f13484h, 4, GraphQLTimelineAppSectionType.class, GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13484h;
        }

        @Nullable
        public final String mo391g() {
            this.f13485i = super.a(this.f13485i, 5);
            return this.f13485i;
        }

        @Nullable
        private SubtitleModel m14706m() {
            this.f13486j = (SubtitleModel) super.a(this.f13486j, 6, SubtitleModel.class);
            return this.f13486j;
        }

        @Nullable
        private TitleModel m14707n() {
            this.f13487k = (TitleModel) super.a(this.f13487k, 7, TitleModel.class);
            return this.f13487k;
        }

        @Nullable
        public final String nQ_() {
            this.f13488l = super.a(this.f13488l, 8);
            return this.f13488l;
        }

        @Nullable
        public final String nR_() {
            this.f13489m = super.a(this.f13489m, 9);
            return this.f13489m;
        }

        @Nullable
        public final String m14710a() {
            return mo389c();
        }

        public final int jK_() {
            return 1842803909;
        }

        public final GraphQLVisitableModel m14709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14716k() != null) {
                CollectionsModel collectionsModel = (CollectionsModel) graphQLModelMutatingVisitor.b(m14716k());
                if (m14716k() != collectionsModel) {
                    graphQLVisitableModel = (FetchTimelineCollectionsSectionViewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13480d = collectionsModel;
                }
            }
            if (m14705l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14705l());
                if (m14705l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FetchTimelineCollectionsSectionViewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13481e = defaultImageFieldsModel;
                }
            }
            if (m14706m() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m14706m());
                if (m14706m() != subtitleModel) {
                    graphQLVisitableModel = (FetchTimelineCollectionsSectionViewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13486j = subtitleModel;
                }
            }
            if (m14707n() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14707n());
                if (m14707n() != titleModel) {
                    graphQLVisitableModel = (FetchTimelineCollectionsSectionViewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13487k = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14708a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14716k());
            int a2 = ModelHelper.a(flatBufferBuilder, m14705l());
            int b = flatBufferBuilder.b(mo389c());
            int b2 = flatBufferBuilder.b(mo390d());
            int a3 = flatBufferBuilder.a(nP_());
            int b3 = flatBufferBuilder.b(mo391g());
            int a4 = ModelHelper.a(flatBufferBuilder, m14706m());
            int a5 = ModelHelper.a(flatBufferBuilder, m14707n());
            int b4 = flatBufferBuilder.b(nQ_());
            int b5 = flatBufferBuilder.b(nR_());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b4);
            flatBufferBuilder.b(9, b5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2035407042)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MODAL */
    public final class FetchTimelineSingleCollectionViewQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsAppSection {
        @Nullable
        private CollectionsModel f13502d;
        @Nullable
        private DefaultImageFieldsModel f13503e;
        @Nullable
        private String f13504f;
        @Nullable
        private String f13505g;
        @Nullable
        private GraphQLTimelineAppSectionType f13506h;
        @Nullable
        private String f13507i;
        @Nullable
        private SubtitleModel f13508j;
        @Nullable
        private TitleModel f13509k;
        @Nullable
        private String f13510l;
        @Nullable
        private String f13511m;

        /* compiled from: MODAL */
        public final class Builder {
            @Nullable
            public CollectionsModel f13490a;
            @Nullable
            public DefaultImageFieldsModel f13491b;
            @Nullable
            public String f13492c;
            @Nullable
            public String f13493d;
            @Nullable
            public GraphQLTimelineAppSectionType f13494e;
            @Nullable
            public String f13495f;
            @Nullable
            public SubtitleModel f13496g;
            @Nullable
            public TitleModel f13497h;
            @Nullable
            public String f13498i;
            @Nullable
            public String f13499j;

            public final com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel m14717a() {
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
                r15 = this;
                r4 = 1;
                r14 = 0;
                r2 = 0;
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r15.f13490a;
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                r3 = r15.f13491b;
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r5 = r15.f13492c;
                r5 = r0.b(r5);
                r6 = r15.f13493d;
                r6 = r0.b(r6);
                r7 = r15.f13494e;
                r7 = r0.a(r7);
                r8 = r15.f13495f;
                r8 = r0.b(r8);
                r9 = r15.f13496g;
                r9 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r9);
                r10 = r15.f13497h;
                r10 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r10);
                r11 = r15.f13498i;
                r11 = r0.b(r11);
                r12 = r15.f13499j;
                r12 = r0.b(r12);
                r13 = 10;
                r0.c(r13);
                r0.b(r14, r1);
                r0.b(r4, r3);
                r1 = 2;
                r0.b(r1, r5);
                r1 = 3;
                r0.b(r1, r6);
                r1 = 4;
                r0.b(r1, r7);
                r1 = 5;
                r0.b(r1, r8);
                r1 = 6;
                r0.b(r1, r9);
                r1 = 7;
                r0.b(r1, r10);
                r1 = 8;
                r0.b(r1, r11);
                r1 = 9;
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
                r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel;
                r1.<init>(r0);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.Builder.a():com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -804178240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MODAL */
        public final class CollectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CollectionWithItemsAndSuggestionsModel> f13501d;

            /* compiled from: MODAL */
            public final class Builder {
                @Nullable
                public ImmutableList<CollectionWithItemsAndSuggestionsModel> f13500a;
            }

            /* compiled from: MODAL */
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
                    r0 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.class;
                    r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$CollectionsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m14718a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
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
                    r5 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser.CollectionsParser.m14741a(r11, r4);
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
                    r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$CollectionsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: MODAL */
            public class Serializer extends JsonSerializer<CollectionsModel> {
                public final void m14719a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
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
                    r8 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m14720a(r0);
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
                    com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser.CollectionsParser.m14742a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.class;
                    r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$CollectionsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.Serializer.<clinit>():void");
                }
            }

            public CollectionsModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.<init>():void");
            }

            public CollectionsModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel> m14722a() {
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
                r0 = r3.f13501d;
                r1 = 0;
                r2 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f13501d = r0;
                r0 = r3.f13501d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.a():com.google.common.collect.ImmutableList<com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels$CollectionWithItemsAndSuggestionsModel>");
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
                r0 = -306448333; // 0xffffffffedbbf833 float:-7.271719E27 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m14721a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                r1 = r2.m14722a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m14722a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel) r0;
                r1 = r1.b();
                r0.f13501d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m14720a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m14722a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: MODAL */
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
                r0 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.class;
                r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m14723a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser.m14743a(r6);
                r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: MODAL */
        public class Serializer extends JsonSerializer<FetchTimelineSingleCollectionViewQueryModel> {
            public final void m14724a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r8 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m14727a(r0);
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
                com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser.m14746a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.class;
                r1 = new com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.Serializer.<clinit>():void");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields mo388b() {
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
            r0 = r1.m14736l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.b():com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel m14734j() {
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
            r0 = r1.m14735k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.j():com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$CollectionsModel");
        }

        public FetchTimelineSingleCollectionViewQueryModel() {
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
            r0 = 10;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.<init>():void");
        }

        public FetchTimelineSingleCollectionViewQueryModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
            r0 = 10;
            r2.<init>(r0);
            r1 = r3.a;
            r0 = r1;
            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
            r2.a(r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel m14735k() {
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
            r0 = r3.f13502d;
            r1 = 0;
            r2 = com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel) r0;
            r3.f13502d = r0;
            r0 = r3.f13502d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.k():com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels$FetchTimelineSingleCollectionViewQueryModel$CollectionsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel m14736l() {
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
            r0 = r3.f13503e;
            r1 = 1;
            r2 = com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r3.f13503e = r0;
            r0 = r3.f13503e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.l():com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo389c() {
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
            r0 = r2.f13504f;
            r1 = 2;
            r0 = super.a(r0, r1);
            r2.f13504f = r0;
            r0 = r2.f13504f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.c():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo390d() {
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
            r0 = r2.f13505g;
            r1 = 3;
            r0 = super.a(r0, r1);
            r2.f13505g = r0;
            r0 = r2.f13505g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.d():java.lang.String");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.enums.GraphQLTimelineAppSectionType nP_() {
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
            r0 = r4.f13506h;
            r1 = 4;
            r2 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.class;
            r3 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLTimelineAppSectionType) r0;
            r4.f13506h = r0;
            r0 = r4.f13506h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.nP_():com.facebook.graphql.enums.GraphQLTimelineAppSectionType");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo391g() {
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
            r0 = r2.f13507i;
            r1 = 5;
            r0 = super.a(r0, r1);
            r2.f13507i = r0;
            r0 = r2.f13507i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.g():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel m14725m() {
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
            r0 = r3.f13508j;
            r1 = 6;
            r2 = com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel) r0;
            r3.f13508j = r0;
            r0 = r3.f13508j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.m():com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels$CollectionsAppSectionModel$SubtitleModel");
        }

        @javax.annotation.Nullable
        private com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel m14726n() {
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
            r0 = r3.f13509k;
            r1 = 7;
            r2 = com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel) r0;
            r3.f13509k = r0;
            r0 = r3.f13509k;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.n():com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels$CollectionsAppSectionModel$TitleModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String nQ_() {
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
            r0 = r2.f13510l;
            r1 = 8;
            r0 = super.a(r0, r1);
            r2.f13510l = r0;
            r0 = r2.f13510l;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.nQ_():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String nR_() {
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
            r0 = r2.f13511m;
            r1 = 9;
            r0 = super.a(r0, r1);
            r2.f13511m = r0;
            r0 = r2.f13511m;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.nR_():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m14729a() {
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
            r0 = r1.mo389c();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.a():java.lang.String");
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
            r0 = 1842803909; // 0x6dd6f4c5 float:8.3157125E27 double:9.104661035E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m14728a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m14735k();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m14735k();
            r0 = r4.b(r0);
            r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel) r0;
            r2 = r3.m14735k();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel) r1;
            r1.f13502d = r0;
        L_0x0022:
            r0 = r3.m14736l();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m14736l();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel) r0;
            r2 = r3.m14736l();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel) r1;
            r1.f13503e = r0;
        L_0x0040:
            r0 = r3.m14725m();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m14725m();
            r0 = r4.b(r0);
            r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel) r0;
            r2 = r3.m14725m();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel) r1;
            r1.f13508j = r0;
        L_0x005e:
            r0 = r3.m14726n();
            if (r0 == 0) goto L_0x007c;
        L_0x0064:
            r0 = r3.m14726n();
            r0 = r4.b(r0);
            r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel) r0;
            r2 = r3.m14726n();
            if (r2 == r0) goto L_0x007c;
        L_0x0074:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel) r1;
            r1.f13509k = r0;
        L_0x007c:
            r3.i();
            if (r1 != 0) goto L_0x0082;
        L_0x0081:
            return r3;
        L_0x0082:
            r3 = r1;
            goto L_0x0081;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m14727a(com.facebook.flatbuffers.FlatBufferBuilder r12) {
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
            r11 = this;
            r11.h();
            r0 = r11.m14735k();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r0);
            r1 = r11.m14736l();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r1);
            r2 = r11.mo389c();
            r2 = r12.b(r2);
            r3 = r11.mo390d();
            r3 = r12.b(r3);
            r4 = r11.nP_();
            r4 = r12.a(r4);
            r5 = r11.mo391g();
            r5 = r12.b(r5);
            r6 = r11.m14725m();
            r6 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r6);
            r7 = r11.m14726n();
            r7 = com.facebook.graphql.modelutil.ModelHelper.a(r12, r7);
            r8 = r11.nQ_();
            r8 = r12.b(r8);
            r9 = r11.nR_();
            r9 = r12.b(r9);
            r10 = 10;
            r12.c(r10);
            r10 = 0;
            r12.b(r10, r0);
            r0 = 1;
            r12.b(r0, r1);
            r0 = 2;
            r12.b(r0, r2);
            r0 = 3;
            r12.b(r0, r3);
            r0 = 4;
            r12.b(r0, r4);
            r0 = 5;
            r12.b(r0, r5);
            r0 = 6;
            r12.b(r0, r6);
            r0 = 7;
            r12.b(r0, r7);
            r0 = 8;
            r12.b(r0, r8);
            r0 = 9;
            r12.b(r0, r9);
            r11.i();
            r0 = r12.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
