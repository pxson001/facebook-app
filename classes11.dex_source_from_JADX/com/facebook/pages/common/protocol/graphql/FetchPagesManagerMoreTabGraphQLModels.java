package com.facebook.pages.common.protocol.graphql;

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
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.AdminInfoParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.AdminInfoParser.AllDraftPostsParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.AdminInfoParser.AllScheduledPostsParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.AdminInfoParser.PageContactUsLeadsParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.CommerceStoreParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.MenuInfoParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.PageCallToActionParser;
import com.facebook.pages.common.protocol.graphql.FetchPagesManagerMoreTabGraphQLParsers.FetchPagesManagerMoreTabQueryParser.PageCallToActionParser.CtaAdminInfoParser;
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

/* compiled from: setPageData */
public class FetchPagesManagerMoreTabGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -790602591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setPageData */
    public final class FetchPagesManagerMoreTabQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1825d;
        @Nullable
        private AdminInfoModel f1826e;
        @Nullable
        private CommerceStoreModel f1827f;
        private boolean f1828g;
        @Nullable
        private MenuInfoModel f1829h;
        @Nullable
        private PageCallToActionModel f1830i;
        private boolean f1831j;
        private boolean f1832k;
        private boolean f1833l;
        private boolean f1834m;
        private boolean f1835n;
        @Nullable
        private List<String> f1836o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1981634761)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPageData */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AllDraftPostsModel f1817d;
            @Nullable
            private AllScheduledPostsModel f1818e;
            @Nullable
            private PageContactUsLeadsModel f1819f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPageData */
            public final class AllDraftPostsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1814d;

                /* compiled from: setPageData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AllDraftPostsModel.class, new Deserializer());
                    }

                    public Object m2810a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AllDraftPostsParser.m2867a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object allDraftPostsModel = new AllDraftPostsModel();
                        ((BaseModel) allDraftPostsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (allDraftPostsModel instanceof Postprocessable) {
                            return ((Postprocessable) allDraftPostsModel).a();
                        }
                        return allDraftPostsModel;
                    }
                }

                /* compiled from: setPageData */
                public class Serializer extends JsonSerializer<AllDraftPostsModel> {
                    public final void m2811a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) obj;
                        if (allDraftPostsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(allDraftPostsModel.m2812a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            allDraftPostsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AllDraftPostsParser.m2868a(allDraftPostsModel.w_(), allDraftPostsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AllDraftPostsModel.class, new Serializer());
                    }
                }

                public AllDraftPostsModel() {
                    super(1);
                }

                public final int jK_() {
                    return -1445101999;
                }

                public final GraphQLVisitableModel m2813a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2812a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1814d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2814a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1814d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPageData */
            public final class AllScheduledPostsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1815d;

                /* compiled from: setPageData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AllScheduledPostsModel.class, new Deserializer());
                    }

                    public Object m2815a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AllScheduledPostsParser.m2869a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object allScheduledPostsModel = new AllScheduledPostsModel();
                        ((BaseModel) allScheduledPostsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (allScheduledPostsModel instanceof Postprocessable) {
                            return ((Postprocessable) allScheduledPostsModel).a();
                        }
                        return allScheduledPostsModel;
                    }
                }

                /* compiled from: setPageData */
                public class Serializer extends JsonSerializer<AllScheduledPostsModel> {
                    public final void m2816a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AllScheduledPostsModel allScheduledPostsModel = (AllScheduledPostsModel) obj;
                        if (allScheduledPostsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(allScheduledPostsModel.m2817a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            allScheduledPostsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AllScheduledPostsParser.m2870a(allScheduledPostsModel.w_(), allScheduledPostsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AllScheduledPostsModel.class, new Serializer());
                    }
                }

                public AllScheduledPostsModel() {
                    super(1);
                }

                public final int jK_() {
                    return 1175143749;
                }

                public final GraphQLVisitableModel m2818a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2817a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1815d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2819a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1815d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: setPageData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m2820a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m2873a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminInfoModel = new AdminInfoModel();
                    ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) adminInfoModel).a();
                    }
                    return adminInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPageData */
            public final class PageContactUsLeadsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1816d;

                /* compiled from: setPageData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageContactUsLeadsModel.class, new Deserializer());
                    }

                    public Object m2821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageContactUsLeadsParser.m2871a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageContactUsLeadsModel = new PageContactUsLeadsModel();
                        ((BaseModel) pageContactUsLeadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageContactUsLeadsModel instanceof Postprocessable) {
                            return ((Postprocessable) pageContactUsLeadsModel).a();
                        }
                        return pageContactUsLeadsModel;
                    }
                }

                /* compiled from: setPageData */
                public class Serializer extends JsonSerializer<PageContactUsLeadsModel> {
                    public final void m2822a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageContactUsLeadsModel pageContactUsLeadsModel = (PageContactUsLeadsModel) obj;
                        if (pageContactUsLeadsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageContactUsLeadsModel.m2823a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageContactUsLeadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageContactUsLeadsParser.m2872a(pageContactUsLeadsModel.w_(), pageContactUsLeadsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageContactUsLeadsModel.class, new Serializer());
                    }
                }

                public PageContactUsLeadsModel() {
                    super(1);
                }

                public final int jK_() {
                    return 1400270310;
                }

                public final GraphQLVisitableModel m2824a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2823a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1816d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2825a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1816d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: setPageData */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m2826a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m2830a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m2874a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(3);
            }

            @Nullable
            private AllDraftPostsModel m2827a() {
                this.f1817d = (AllDraftPostsModel) super.a(this.f1817d, 0, AllDraftPostsModel.class);
                return this.f1817d;
            }

            @Nullable
            private AllScheduledPostsModel m2828j() {
                this.f1818e = (AllScheduledPostsModel) super.a(this.f1818e, 1, AllScheduledPostsModel.class);
                return this.f1818e;
            }

            @Nullable
            private PageContactUsLeadsModel m2829k() {
                this.f1819f = (PageContactUsLeadsModel) super.a(this.f1819f, 2, PageContactUsLeadsModel.class);
                return this.f1819f;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m2831a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2827a() != null) {
                    AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) graphQLModelMutatingVisitor.b(m2827a());
                    if (m2827a() != allDraftPostsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1817d = allDraftPostsModel;
                    }
                }
                if (m2828j() != null) {
                    AllScheduledPostsModel allScheduledPostsModel = (AllScheduledPostsModel) graphQLModelMutatingVisitor.b(m2828j());
                    if (m2828j() != allScheduledPostsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1818e = allScheduledPostsModel;
                    }
                }
                if (m2829k() != null) {
                    PageContactUsLeadsModel pageContactUsLeadsModel = (PageContactUsLeadsModel) graphQLModelMutatingVisitor.b(m2829k());
                    if (m2829k() != pageContactUsLeadsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1819f = pageContactUsLeadsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2830a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2827a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2828j());
                int a3 = ModelHelper.a(flatBufferBuilder, m2829k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPageData */
        public final class CommerceStoreModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1820d;

            /* compiled from: setPageData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceStoreModel.class, new Deserializer());
                }

                public Object m2832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceStoreParser.m2875a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceStoreModel = new CommerceStoreModel();
                    ((BaseModel) commerceStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceStoreModel).a();
                    }
                    return commerceStoreModel;
                }
            }

            /* compiled from: setPageData */
            public class Serializer extends JsonSerializer<CommerceStoreModel> {
                public final void m2833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceStoreModel commerceStoreModel = (CommerceStoreModel) obj;
                    if (commerceStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceStoreModel.m2835a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceStoreParser.m2876a(commerceStoreModel.w_(), commerceStoreModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CommerceStoreModel.class, new Serializer());
                }
            }

            public CommerceStoreModel() {
                super(1);
            }

            @Nullable
            private String m2834j() {
                this.f1820d = super.a(this.f1820d, 0);
                return this.f1820d;
            }

            @Nullable
            public final String m2837a() {
                return m2834j();
            }

            public final int jK_() {
                return 308731558;
            }

            public final GraphQLVisitableModel m2836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2835a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2834j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setPageData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPagesManagerMoreTabQueryModel.class, new Deserializer());
            }

            public Object m2838a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchPagesManagerMoreTabQueryParser.m2883a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchPagesManagerMoreTabQueryModel = new FetchPagesManagerMoreTabQueryModel();
                ((BaseModel) fetchPagesManagerMoreTabQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchPagesManagerMoreTabQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPagesManagerMoreTabQueryModel).a();
                }
                return fetchPagesManagerMoreTabQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 423934101)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPageData */
        public final class MenuInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f1821d;

            /* compiled from: setPageData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuInfoModel.class, new Deserializer());
                }

                public Object m2839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuInfoParser.m2877a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuInfoModel = new MenuInfoModel();
                    ((BaseModel) menuInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) menuInfoModel).a();
                    }
                    return menuInfoModel;
                }
            }

            /* compiled from: setPageData */
            public class Serializer extends JsonSerializer<MenuInfoModel> {
                public final void m2840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuInfoModel menuInfoModel = (MenuInfoModel) obj;
                    if (menuInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuInfoModel.m2841a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuInfoParser.m2878a(menuInfoModel.w_(), menuInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MenuInfoModel.class, new Serializer());
                }
            }

            public MenuInfoModel() {
                super(1);
            }

            public final int jK_() {
                return 2056274556;
            }

            public final GraphQLVisitableModel m2842a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2841a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1821d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2843a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1821d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2007901413)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPageData */
        public final class PageCallToActionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CtaAdminInfoModel f1823d;
            @Nullable
            private GraphQLPageCallToActionType f1824e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1942567018)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPageData */
            public final class CtaAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f1822d;

                /* compiled from: setPageData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CtaAdminInfoModel.class, new Deserializer());
                    }

                    public Object m2844a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CtaAdminInfoParser.m2879a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ctaAdminInfoModel = new CtaAdminInfoModel();
                        ((BaseModel) ctaAdminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ctaAdminInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) ctaAdminInfoModel).a();
                        }
                        return ctaAdminInfoModel;
                    }
                }

                /* compiled from: setPageData */
                public class Serializer extends JsonSerializer<CtaAdminInfoModel> {
                    public final void m2845a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CtaAdminInfoModel ctaAdminInfoModel = (CtaAdminInfoModel) obj;
                        if (ctaAdminInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ctaAdminInfoModel.m2846a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ctaAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CtaAdminInfoParser.m2880a(ctaAdminInfoModel.w_(), ctaAdminInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CtaAdminInfoModel.class, new Serializer());
                    }
                }

                public CtaAdminInfoModel() {
                    super(1);
                }

                public final int jK_() {
                    return 609433823;
                }

                public final GraphQLVisitableModel m2847a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2846a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1822d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2848a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1822d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: setPageData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageCallToActionModel.class, new Deserializer());
                }

                public Object m2849a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageCallToActionParser.m2881a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageCallToActionModel = new PageCallToActionModel();
                    ((BaseModel) pageCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageCallToActionModel instanceof Postprocessable) {
                        return ((Postprocessable) pageCallToActionModel).a();
                    }
                    return pageCallToActionModel;
                }
            }

            /* compiled from: setPageData */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m2850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) obj;
                    if (pageCallToActionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageCallToActionModel.m2853a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageCallToActionParser.m2882a(pageCallToActionModel.w_(), pageCallToActionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageCallToActionModel.class, new Serializer());
                }
            }

            public PageCallToActionModel() {
                super(2);
            }

            @Nullable
            private CtaAdminInfoModel m2851a() {
                this.f1823d = (CtaAdminInfoModel) super.a(this.f1823d, 0, CtaAdminInfoModel.class);
                return this.f1823d;
            }

            @Nullable
            private GraphQLPageCallToActionType m2852j() {
                this.f1824e = (GraphQLPageCallToActionType) super.b(this.f1824e, 1, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1824e;
            }

            public final int jK_() {
                return 133279070;
            }

            public final GraphQLVisitableModel m2854a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2851a() != null) {
                    CtaAdminInfoModel ctaAdminInfoModel = (CtaAdminInfoModel) graphQLModelMutatingVisitor.b(m2851a());
                    if (m2851a() != ctaAdminInfoModel) {
                        graphQLVisitableModel = (PageCallToActionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1823d = ctaAdminInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2853a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2851a());
                int a2 = flatBufferBuilder.a(m2852j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setPageData */
        public class Serializer extends JsonSerializer<FetchPagesManagerMoreTabQueryModel> {
            public final void m2855a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPagesManagerMoreTabQueryModel fetchPagesManagerMoreTabQueryModel = (FetchPagesManagerMoreTabQueryModel) obj;
                if (fetchPagesManagerMoreTabQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPagesManagerMoreTabQueryModel.m2862a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPagesManagerMoreTabQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPagesManagerMoreTabQueryModel.w_();
                int u_ = fetchPagesManagerMoreTabQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m2874a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreParser.m2876a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("instant_articles_enabled");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("menu_info");
                    MenuInfoParser.m2878a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    PageCallToActionParser.m2882a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(u_, 6);
                if (a) {
                    jsonGenerator.a("should_show_recent_activity_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 7);
                if (a) {
                    jsonGenerator.a("should_show_recent_checkins_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 8);
                if (a) {
                    jsonGenerator.a("should_show_recent_mentions_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 9);
                if (a) {
                    jsonGenerator.a("should_show_recent_shares_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 10);
                if (a) {
                    jsonGenerator.a("should_show_reviews_on_profile");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 11) != 0) {
                    jsonGenerator.a("viewer_profile_permissions");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 11), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPagesManagerMoreTabQueryModel.class, new Serializer());
            }
        }

        public FetchPagesManagerMoreTabQueryModel() {
            super(12);
        }

        public final void m2865a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2866a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2856a() {
            if (this.b != null && this.f1825d == null) {
                this.f1825d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1825d;
        }

        @Nullable
        private AdminInfoModel m2857j() {
            this.f1826e = (AdminInfoModel) super.a(this.f1826e, 1, AdminInfoModel.class);
            return this.f1826e;
        }

        @Nullable
        private CommerceStoreModel m2858k() {
            this.f1827f = (CommerceStoreModel) super.a(this.f1827f, 2, CommerceStoreModel.class);
            return this.f1827f;
        }

        @Nullable
        private MenuInfoModel m2859l() {
            this.f1829h = (MenuInfoModel) super.a(this.f1829h, 4, MenuInfoModel.class);
            return this.f1829h;
        }

        @Nullable
        private PageCallToActionModel m2860m() {
            this.f1830i = (PageCallToActionModel) super.a(this.f1830i, 5, PageCallToActionModel.class);
            return this.f1830i;
        }

        @Nonnull
        private ImmutableList<String> m2861n() {
            this.f1836o = super.a(this.f1836o, 11);
            return (ImmutableList) this.f1836o;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2863a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2857j() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m2857j());
                if (m2857j() != adminInfoModel) {
                    graphQLVisitableModel = (FetchPagesManagerMoreTabQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1826e = adminInfoModel;
                }
            }
            if (m2858k() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m2858k());
                if (m2858k() != commerceStoreModel) {
                    graphQLVisitableModel = (FetchPagesManagerMoreTabQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1827f = commerceStoreModel;
                }
            }
            if (m2859l() != null) {
                MenuInfoModel menuInfoModel = (MenuInfoModel) graphQLModelMutatingVisitor.b(m2859l());
                if (m2859l() != menuInfoModel) {
                    graphQLVisitableModel = (FetchPagesManagerMoreTabQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1829h = menuInfoModel;
                }
            }
            if (m2860m() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m2860m());
                if (m2860m() != pageCallToActionModel) {
                    graphQLVisitableModel = (FetchPagesManagerMoreTabQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1830i = pageCallToActionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2862a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2856a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2857j());
            int a3 = ModelHelper.a(flatBufferBuilder, m2858k());
            int a4 = ModelHelper.a(flatBufferBuilder, m2859l());
            int a5 = ModelHelper.a(flatBufferBuilder, m2860m());
            int c = flatBufferBuilder.c(m2861n());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.a(3, this.f1828g);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.a(6, this.f1831j);
            flatBufferBuilder.a(7, this.f1832k);
            flatBufferBuilder.a(8, this.f1833l);
            flatBufferBuilder.a(9, this.f1834m);
            flatBufferBuilder.a(10, this.f1835n);
            flatBufferBuilder.b(11, c);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2864a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1828g = mutableFlatBuffer.a(i, 3);
            this.f1831j = mutableFlatBuffer.a(i, 6);
            this.f1832k = mutableFlatBuffer.a(i, 7);
            this.f1833l = mutableFlatBuffer.a(i, 8);
            this.f1834m = mutableFlatBuffer.a(i, 9);
            this.f1835n = mutableFlatBuffer.a(i, 10);
        }
    }
}
