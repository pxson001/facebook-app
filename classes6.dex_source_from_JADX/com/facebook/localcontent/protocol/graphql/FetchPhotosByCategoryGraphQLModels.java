package com.facebook.localcontent.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAvailablePhotoCategoryEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLParsers.AvailableCategoriesQueryParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLParsers.AvailableCategoriesQueryParser.PhotosByCategoryParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLParsers.AvailableCategoriesQueryParser.PhotosByCategoryParser.AvailableCategoriesParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLParsers.AvailableCategoriesQueryParser.PhotosByCategoryParser.PrimaryCategoryParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLParsers.PhotosByCategoryQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
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

/* compiled from: last_image_sample_timestamp */
public class FetchPhotosByCategoryGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1096155414)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last_image_sample_timestamp */
    public final class AvailableCategoriesQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosByCategoryModel f11755d;

        /* compiled from: last_image_sample_timestamp */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AvailableCategoriesQueryModel.class, new Deserializer());
            }

            public Object m18456a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AvailableCategoriesQueryParser.m18505a(jsonParser);
                Object availableCategoriesQueryModel = new AvailableCategoriesQueryModel();
                ((BaseModel) availableCategoriesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (availableCategoriesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) availableCategoriesQueryModel).a();
                }
                return availableCategoriesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1428832865)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last_image_sample_timestamp */
        public final class PhotosByCategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<AvailableCategoriesModel> f11752d;
            private boolean f11753e;
            @Nullable
            private PrimaryCategoryModel f11754f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 434642442)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last_image_sample_timestamp */
            public final class AvailableCategoriesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLAvailablePhotoCategoryEnum f11747d;
                @Nullable
                private String f11748e;
                @Nullable
                private String f11749f;
                @Nullable
                private String f11750g;

                /* compiled from: last_image_sample_timestamp */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AvailableCategoriesModel.class, new Deserializer());
                    }

                    public Object m18457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AvailableCategoriesParser.m18500b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object availableCategoriesModel = new AvailableCategoriesModel();
                        ((BaseModel) availableCategoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (availableCategoriesModel instanceof Postprocessable) {
                            return ((Postprocessable) availableCategoriesModel).a();
                        }
                        return availableCategoriesModel;
                    }
                }

                /* compiled from: last_image_sample_timestamp */
                public class Serializer extends JsonSerializer<AvailableCategoriesModel> {
                    public final void m18458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AvailableCategoriesModel availableCategoriesModel = (AvailableCategoriesModel) obj;
                        if (availableCategoriesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(availableCategoriesModel.m18459a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            availableCategoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AvailableCategoriesParser.m18499a(availableCategoriesModel.w_(), availableCategoriesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AvailableCategoriesModel.class, new Serializer());
                    }
                }

                public AvailableCategoriesModel() {
                    super(4);
                }

                @Nullable
                public final GraphQLAvailablePhotoCategoryEnum m18460a() {
                    this.f11747d = (GraphQLAvailablePhotoCategoryEnum) super.b(this.f11747d, 0, GraphQLAvailablePhotoCategoryEnum.class, GraphQLAvailablePhotoCategoryEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f11747d;
                }

                @Nullable
                public final String m18462b() {
                    this.f11748e = super.a(this.f11748e, 1);
                    return this.f11748e;
                }

                @Nullable
                public final String m18463c() {
                    this.f11749f = super.a(this.f11749f, 2);
                    return this.f11749f;
                }

                @Nullable
                public final String m18464d() {
                    this.f11750g = super.a(this.f11750g, 3);
                    return this.f11750g;
                }

                public final int jK_() {
                    return 747760935;
                }

                public final GraphQLVisitableModel m18461a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18459a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m18460a());
                    int b = flatBufferBuilder.b(m18462b());
                    int b2 = flatBufferBuilder.b(m18463c());
                    int b3 = flatBufferBuilder.b(m18464d());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last_image_sample_timestamp */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosByCategoryModel.class, new Deserializer());
                }

                public Object m18465a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosByCategoryParser.m18503a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosByCategoryModel = new PhotosByCategoryModel();
                    ((BaseModel) photosByCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosByCategoryModel instanceof Postprocessable) {
                        return ((Postprocessable) photosByCategoryModel).a();
                    }
                    return photosByCategoryModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1916278678)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last_image_sample_timestamp */
            public final class PrimaryCategoryModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLAvailablePhotoCategoryEnum f11751d;

                /* compiled from: last_image_sample_timestamp */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PrimaryCategoryModel.class, new Deserializer());
                    }

                    public Object m18466a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PrimaryCategoryParser.m18501a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object primaryCategoryModel = new PrimaryCategoryModel();
                        ((BaseModel) primaryCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (primaryCategoryModel instanceof Postprocessable) {
                            return ((Postprocessable) primaryCategoryModel).a();
                        }
                        return primaryCategoryModel;
                    }
                }

                /* compiled from: last_image_sample_timestamp */
                public class Serializer extends JsonSerializer<PrimaryCategoryModel> {
                    public final void m18467a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PrimaryCategoryModel primaryCategoryModel = (PrimaryCategoryModel) obj;
                        if (primaryCategoryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(primaryCategoryModel.m18468a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            primaryCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PrimaryCategoryParser.m18502a(primaryCategoryModel.w_(), primaryCategoryModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PrimaryCategoryModel.class, new Serializer());
                    }
                }

                public PrimaryCategoryModel() {
                    super(1);
                }

                @Nullable
                public final GraphQLAvailablePhotoCategoryEnum m18469a() {
                    this.f11751d = (GraphQLAvailablePhotoCategoryEnum) super.b(this.f11751d, 0, GraphQLAvailablePhotoCategoryEnum.class, GraphQLAvailablePhotoCategoryEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f11751d;
                }

                public final int jK_() {
                    return 747760935;
                }

                public final GraphQLVisitableModel m18470a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18468a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m18469a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last_image_sample_timestamp */
            public class Serializer extends JsonSerializer<PhotosByCategoryModel> {
                public final void m18471a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) obj;
                    if (photosByCategoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosByCategoryModel.m18473a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosByCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosByCategoryParser.m18504a(photosByCategoryModel.w_(), photosByCategoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosByCategoryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PrimaryCategoryModel m18478c() {
                return m18472j();
            }

            public PhotosByCategoryModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<AvailableCategoriesModel> m18475a() {
                this.f11752d = super.a(this.f11752d, 0, AvailableCategoriesModel.class);
                return (ImmutableList) this.f11752d;
            }

            public final boolean m18477b() {
                a(0, 1);
                return this.f11753e;
            }

            @Nullable
            private PrimaryCategoryModel m18472j() {
                this.f11754f = (PrimaryCategoryModel) super.a(this.f11754f, 2, PrimaryCategoryModel.class);
                return this.f11754f;
            }

            public final int jK_() {
                return 565084532;
            }

            public final GraphQLVisitableModel m18474a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PrimaryCategoryModel primaryCategoryModel;
                h();
                if (m18475a() != null) {
                    Builder a = ModelHelper.a(m18475a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) ModelHelper.a(null, this);
                        photosByCategoryModel.f11752d = a.b();
                        graphQLVisitableModel = photosByCategoryModel;
                        if (m18472j() != null) {
                            primaryCategoryModel = (PrimaryCategoryModel) graphQLModelMutatingVisitor.b(m18472j());
                            if (m18472j() != primaryCategoryModel) {
                                graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11754f = primaryCategoryModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m18472j() != null) {
                    primaryCategoryModel = (PrimaryCategoryModel) graphQLModelMutatingVisitor.b(m18472j());
                    if (m18472j() != primaryCategoryModel) {
                        graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11754f = primaryCategoryModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m18473a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18475a());
                int a2 = ModelHelper.a(flatBufferBuilder, m18472j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f11753e);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18476a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11753e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: last_image_sample_timestamp */
        public class Serializer extends JsonSerializer<AvailableCategoriesQueryModel> {
            public final void m18479a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AvailableCategoriesQueryModel availableCategoriesQueryModel = (AvailableCategoriesQueryModel) obj;
                if (availableCategoriesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(availableCategoriesQueryModel.m18481a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    availableCategoriesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = availableCategoriesQueryModel.w_();
                int u_ = availableCategoriesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_by_category");
                    PhotosByCategoryParser.m18504a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AvailableCategoriesQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PhotosByCategoryModel m18483a() {
            return m18480j();
        }

        public AvailableCategoriesQueryModel() {
            super(1);
        }

        public final void m18484a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18485a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PhotosByCategoryModel m18480j() {
            this.f11755d = (PhotosByCategoryModel) super.a(this.f11755d, 0, PhotosByCategoryModel.class);
            return this.f11755d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18480j() != null) {
                PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) graphQLModelMutatingVisitor.b(m18480j());
                if (m18480j() != photosByCategoryModel) {
                    graphQLVisitableModel = (AvailableCategoriesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11755d = photosByCategoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18481a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18480j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -676474488)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last_image_sample_timestamp */
    public final class PhotosByCategoryQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosByCategoryModel f11758d;

        /* compiled from: last_image_sample_timestamp */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotosByCategoryQueryModel.class, new Deserializer());
            }

            public Object m18486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PhotosByCategoryQueryParser.m18508a(jsonParser);
                Object photosByCategoryQueryModel = new PhotosByCategoryQueryModel();
                ((BaseModel) photosByCategoryQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photosByCategoryQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) photosByCategoryQueryModel).a();
                }
                return photosByCategoryQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1823215375)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last_image_sample_timestamp */
        public final class PhotosByCategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PandoraMediaModel> f11756d;
            @Nullable
            private DefaultPageInfoFieldsModel f11757e;

            /* compiled from: last_image_sample_timestamp */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosByCategoryModel.class, new Deserializer());
                }

                public Object m18487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosByCategoryQueryParser.PhotosByCategoryParser.m18506a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosByCategoryModel = new PhotosByCategoryModel();
                    ((BaseModel) photosByCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosByCategoryModel instanceof Postprocessable) {
                        return ((Postprocessable) photosByCategoryModel).a();
                    }
                    return photosByCategoryModel;
                }
            }

            /* compiled from: last_image_sample_timestamp */
            public class Serializer extends JsonSerializer<PhotosByCategoryModel> {
                public final void m18488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) obj;
                    if (photosByCategoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosByCategoryModel.m18489a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosByCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosByCategoryQueryParser.PhotosByCategoryParser.m18507a(photosByCategoryModel.w_(), photosByCategoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosByCategoryModel.class, new Serializer());
                }
            }

            public PhotosByCategoryModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PandoraMediaModel> m18491a() {
                this.f11756d = super.a(this.f11756d, 0, PandoraMediaModel.class);
                return (ImmutableList) this.f11756d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m18492j() {
                this.f11757e = (DefaultPageInfoFieldsModel) super.a(this.f11757e, 1, DefaultPageInfoFieldsModel.class);
                return this.f11757e;
            }

            public final int jK_() {
                return 565084532;
            }

            public final GraphQLVisitableModel m18490a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m18491a() != null) {
                    Builder a = ModelHelper.a(m18491a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) ModelHelper.a(null, this);
                        photosByCategoryModel.f11756d = a.b();
                        graphQLVisitableModel = photosByCategoryModel;
                        if (m18492j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m18492j());
                            if (m18492j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11757e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m18492j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m18492j());
                    if (m18492j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11757e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m18489a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18491a());
                int a2 = ModelHelper.a(flatBufferBuilder, m18492j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last_image_sample_timestamp */
        public class Serializer extends JsonSerializer<PhotosByCategoryQueryModel> {
            public final void m18493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PhotosByCategoryQueryModel photosByCategoryQueryModel = (PhotosByCategoryQueryModel) obj;
                if (photosByCategoryQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photosByCategoryQueryModel.m18494a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photosByCategoryQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photosByCategoryQueryModel.w_();
                int u_ = photosByCategoryQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_by_category");
                    PhotosByCategoryQueryParser.PhotosByCategoryParser.m18507a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PhotosByCategoryQueryModel.class, new Serializer());
            }
        }

        public PhotosByCategoryQueryModel() {
            super(1);
        }

        public final void m18497a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18498a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PhotosByCategoryModel m18496a() {
            this.f11758d = (PhotosByCategoryModel) super.a(this.f11758d, 0, PhotosByCategoryModel.class);
            return this.f11758d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18495a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18496a() != null) {
                PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) graphQLModelMutatingVisitor.b(m18496a());
                if (m18496a() != photosByCategoryModel) {
                    graphQLVisitableModel = (PhotosByCategoryQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11758d = photosByCategoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18494a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18496a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
