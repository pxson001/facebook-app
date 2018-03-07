package com.facebook.heisman.protocol;

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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.CategoryBrowserQueryParser;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.CategoryBrowserSearchQueryParser;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.CategoryBrowserSearchQueryParser.PagesParser;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.ProfileOverlayCategoriesConnectionFieldsParser;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.ProfileOverlayCategoryWithPageLimitFieldsParser;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLParsers.ProfileOverlayCategoryWithPageLimitFieldsParser.PagesParser.PageInfoParser;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
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

/* compiled from: mMessengerInvitePriority */
public class CategoryBrowserGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 677370222)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mMessengerInvitePriority */
    public final class CategoryBrowserQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileOverlayCategoriesConnectionFieldsModel f11015d;

        /* compiled from: mMessengerInvitePriority */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CategoryBrowserQueryModel.class, new Deserializer());
            }

            public Object m17655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CategoryBrowserQueryParser.m17696a(jsonParser);
                Object categoryBrowserQueryModel = new CategoryBrowserQueryModel();
                ((BaseModel) categoryBrowserQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (categoryBrowserQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) categoryBrowserQueryModel).a();
                }
                return categoryBrowserQueryModel;
            }
        }

        /* compiled from: mMessengerInvitePriority */
        public class Serializer extends JsonSerializer<CategoryBrowserQueryModel> {
            public final void m17656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CategoryBrowserQueryModel categoryBrowserQueryModel = (CategoryBrowserQueryModel) obj;
                if (categoryBrowserQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(categoryBrowserQueryModel.m17657a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    categoryBrowserQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = categoryBrowserQueryModel.w_();
                int u_ = categoryBrowserQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("categories");
                    ProfileOverlayCategoriesConnectionFieldsParser.m17701a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CategoryBrowserQueryModel.class, new Serializer());
            }
        }

        public CategoryBrowserQueryModel() {
            super(1);
        }

        @Nullable
        public final ProfileOverlayCategoriesConnectionFieldsModel m17659a() {
            this.f11015d = (ProfileOverlayCategoriesConnectionFieldsModel) super.a(this.f11015d, 0, ProfileOverlayCategoriesConnectionFieldsModel.class);
            return this.f11015d;
        }

        public final int jK_() {
            return -1939474423;
        }

        public final GraphQLVisitableModel m17658a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17659a() != null) {
                ProfileOverlayCategoriesConnectionFieldsModel profileOverlayCategoriesConnectionFieldsModel = (ProfileOverlayCategoriesConnectionFieldsModel) graphQLModelMutatingVisitor.b(m17659a());
                if (m17659a() != profileOverlayCategoriesConnectionFieldsModel) {
                    graphQLVisitableModel = (CategoryBrowserQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11015d = profileOverlayCategoriesConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17657a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17659a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1979798019)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mMessengerInvitePriority */
    public final class CategoryBrowserSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PagesModel f11017d;

        /* compiled from: mMessengerInvitePriority */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CategoryBrowserSearchQueryModel.class, new Deserializer());
            }

            public Object m17660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CategoryBrowserSearchQueryParser.m17699a(jsonParser);
                Object categoryBrowserSearchQueryModel = new CategoryBrowserSearchQueryModel();
                ((BaseModel) categoryBrowserSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (categoryBrowserSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) categoryBrowserSearchQueryModel).a();
                }
                return categoryBrowserSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1249418613)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mMessengerInvitePriority */
        public final class PagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ProfileOverlayCategoryPageFieldsModel> f11016d;

            /* compiled from: mMessengerInvitePriority */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagesModel.class, new Deserializer());
                }

                public Object m17661a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PagesParser.m17697a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagesModel = new PagesModel();
                    ((BaseModel) pagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagesModel instanceof Postprocessable) {
                        return ((Postprocessable) pagesModel).a();
                    }
                    return pagesModel;
                }
            }

            /* compiled from: mMessengerInvitePriority */
            public class Serializer extends JsonSerializer<PagesModel> {
                public final void m17662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagesModel pagesModel = (PagesModel) obj;
                    if (pagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagesModel.m17663a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PagesParser.m17698a(pagesModel.w_(), pagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PagesModel.class, new Serializer());
                }
            }

            public PagesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ProfileOverlayCategoryPageFieldsModel> m17665a() {
                this.f11016d = super.a(this.f11016d, 0, ProfileOverlayCategoryPageFieldsModel.class);
                return (ImmutableList) this.f11016d;
            }

            public final int jK_() {
                return -974667717;
            }

            public final GraphQLVisitableModel m17664a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17665a() != null) {
                    Builder a = ModelHelper.a(m17665a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11016d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17663a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17665a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mMessengerInvitePriority */
        public class Serializer extends JsonSerializer<CategoryBrowserSearchQueryModel> {
            public final void m17666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CategoryBrowserSearchQueryModel categoryBrowserSearchQueryModel = (CategoryBrowserSearchQueryModel) obj;
                if (categoryBrowserSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(categoryBrowserSearchQueryModel.m17667a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    categoryBrowserSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = categoryBrowserSearchQueryModel.w_();
                int u_ = categoryBrowserSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("pages");
                    PagesParser.m17698a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CategoryBrowserSearchQueryModel.class, new Serializer());
            }
        }

        public CategoryBrowserSearchQueryModel() {
            super(1);
        }

        @Nullable
        public final PagesModel m17669a() {
            this.f11017d = (PagesModel) super.a(this.f11017d, 0, PagesModel.class);
            return this.f11017d;
        }

        public final int jK_() {
            return -1939474423;
        }

        public final GraphQLVisitableModel m17668a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17669a() != null) {
                PagesModel pagesModel = (PagesModel) graphQLModelMutatingVisitor.b(m17669a());
                if (m17669a() != pagesModel) {
                    graphQLVisitableModel = (CategoryBrowserSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11017d = pagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17667a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17669a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -45528724)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mMessengerInvitePriority */
    public final class ProfileOverlayCategoriesConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProfileOverlayCategoryWithPageLimitFieldsModel> f11018d;

        /* compiled from: mMessengerInvitePriority */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoriesConnectionFieldsModel.class, new Deserializer());
            }

            public Object m17670a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayCategoriesConnectionFieldsParser.m17700a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayCategoriesConnectionFieldsModel = new ProfileOverlayCategoriesConnectionFieldsModel();
                ((BaseModel) profileOverlayCategoriesConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayCategoriesConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayCategoriesConnectionFieldsModel).a();
                }
                return profileOverlayCategoriesConnectionFieldsModel;
            }
        }

        /* compiled from: mMessengerInvitePriority */
        public class Serializer extends JsonSerializer<ProfileOverlayCategoriesConnectionFieldsModel> {
            public final void m17671a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileOverlayCategoriesConnectionFieldsModel profileOverlayCategoriesConnectionFieldsModel = (ProfileOverlayCategoriesConnectionFieldsModel) obj;
                if (profileOverlayCategoriesConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayCategoriesConnectionFieldsModel.m17672a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayCategoriesConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileOverlayCategoriesConnectionFieldsParser.m17701a(profileOverlayCategoriesConnectionFieldsModel.w_(), profileOverlayCategoriesConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileOverlayCategoriesConnectionFieldsModel.class, new Serializer());
            }
        }

        public ProfileOverlayCategoriesConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ProfileOverlayCategoryWithPageLimitFieldsModel> m17674a() {
            this.f11018d = super.a(this.f11018d, 0, ProfileOverlayCategoryWithPageLimitFieldsModel.class);
            return (ImmutableList) this.f11018d;
        }

        public final int jK_() {
            return 658831169;
        }

        public final GraphQLVisitableModel m17673a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17674a() != null) {
                Builder a = ModelHelper.a(m17674a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProfileOverlayCategoriesConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11018d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17672a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17674a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1738939333)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mMessengerInvitePriority */
    public final class ProfileOverlayCategoryWithPageLimitFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f11022d;
        @Nullable
        private PagesModel f11023e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11024f;

        /* compiled from: mMessengerInvitePriority */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoryWithPageLimitFieldsModel.class, new Deserializer());
            }

            public Object m17675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayCategoryWithPageLimitFieldsParser.m17706b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayCategoryWithPageLimitFieldsModel = new ProfileOverlayCategoryWithPageLimitFieldsModel();
                ((BaseModel) profileOverlayCategoryWithPageLimitFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayCategoryWithPageLimitFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayCategoryWithPageLimitFieldsModel).a();
                }
                return profileOverlayCategoryWithPageLimitFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1078116299)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mMessengerInvitePriority */
        public final class PagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ProfileOverlayCategoryPageFieldsModel> f11020d;
            @Nullable
            private PageInfoModel f11021e;

            /* compiled from: mMessengerInvitePriority */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagesModel.class, new Deserializer());
                }

                public Object m17676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileOverlayCategoryWithPageLimitFieldsParser.PagesParser.m17704a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagesModel = new PagesModel();
                    ((BaseModel) pagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagesModel instanceof Postprocessable) {
                        return ((Postprocessable) pagesModel).a();
                    }
                    return pagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1947362733)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mMessengerInvitePriority */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f11019d;

                /* compiled from: mMessengerInvitePriority */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m17677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m17702a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: mMessengerInvitePriority */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m17678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m17679a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m17703a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final boolean m17682a() {
                    a(0, 0);
                    return this.f11019d;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m17680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17679a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f11019d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17681a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11019d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: mMessengerInvitePriority */
            public class Serializer extends JsonSerializer<PagesModel> {
                public final void m17683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagesModel pagesModel = (PagesModel) obj;
                    if (pagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagesModel.m17684a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileOverlayCategoryWithPageLimitFieldsParser.PagesParser.m17705a(pagesModel.w_(), pagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PagesModel.class, new Serializer());
                }
            }

            public PagesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ProfileOverlayCategoryPageFieldsModel> m17686a() {
                this.f11020d = super.a(this.f11020d, 0, ProfileOverlayCategoryPageFieldsModel.class);
                return (ImmutableList) this.f11020d;
            }

            @Nullable
            public final PageInfoModel m17687j() {
                this.f11021e = (PageInfoModel) super.a(this.f11021e, 1, PageInfoModel.class);
                return this.f11021e;
            }

            public final int jK_() {
                return -985606563;
            }

            public final GraphQLVisitableModel m17685a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m17686a() != null) {
                    Builder a = ModelHelper.a(m17686a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PagesModel pagesModel = (PagesModel) ModelHelper.a(null, this);
                        pagesModel.f11020d = a.b();
                        graphQLVisitableModel = pagesModel;
                        if (m17687j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m17687j());
                            if (m17687j() != pageInfoModel) {
                                graphQLVisitableModel = (PagesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11021e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17687j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m17687j());
                    if (m17687j() != pageInfoModel) {
                        graphQLVisitableModel = (PagesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11021e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17684a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17686a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17687j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mMessengerInvitePriority */
        public class Serializer extends JsonSerializer<ProfileOverlayCategoryWithPageLimitFieldsModel> {
            public final void m17688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileOverlayCategoryWithPageLimitFieldsModel profileOverlayCategoryWithPageLimitFieldsModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) obj;
                if (profileOverlayCategoryWithPageLimitFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayCategoryWithPageLimitFieldsModel.m17690a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayCategoryWithPageLimitFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileOverlayCategoryWithPageLimitFieldsParser.m17707b(profileOverlayCategoryWithPageLimitFieldsModel.w_(), profileOverlayCategoryWithPageLimitFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileOverlayCategoryWithPageLimitFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m17694c() {
            return m17689k();
        }

        public ProfileOverlayCategoryWithPageLimitFieldsModel() {
            super(3);
        }

        @Nullable
        public final String m17693b() {
            this.f11022d = super.a(this.f11022d, 0);
            return this.f11022d;
        }

        @Nullable
        public final PagesModel m17695j() {
            this.f11023e = (PagesModel) super.a(this.f11023e, 1, PagesModel.class);
            return this.f11023e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m17689k() {
            this.f11024f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11024f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11024f;
        }

        @Nullable
        public final String m17692a() {
            return m17693b();
        }

        public final int jK_() {
            return -2042279771;
        }

        public final GraphQLVisitableModel m17691a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17695j() != null) {
                PagesModel pagesModel = (PagesModel) graphQLModelMutatingVisitor.b(m17695j());
                if (m17695j() != pagesModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11023e = pagesModel;
                }
            }
            if (m17689k() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m17689k());
                if (m17689k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11024f = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17690a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17693b());
            int a = ModelHelper.a(flatBufferBuilder, m17695j());
            int a2 = ModelHelper.a(flatBufferBuilder, m17689k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
