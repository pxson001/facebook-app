package com.facebook.search.results.protocol.entity;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageInterfaces.SearchResultsPage;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageCTAParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageCTAParser.PhoneNumberParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.CoverPhotoParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.CoverPhotoParser.PhotoParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.PageLikersParser;
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

/* compiled from: minImpressionDelayMs */
public class SearchResultsPageModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1806488535)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: minImpressionDelayMs */
    public final class SearchResultsPageCTAModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLPageCallToActionType f8623d;
        @Nullable
        private String f8624e;
        @Nullable
        private String f8625f;
        @Nullable
        private PhoneNumberModel f8626g;

        /* compiled from: minImpressionDelayMs */
        public final class Builder {
            @Nullable
            public GraphQLPageCallToActionType f8617a;
            @Nullable
            public String f8618b;
            @Nullable
            public String f8619c;
            @Nullable
            public PhoneNumberModel f8620d;
        }

        /* compiled from: minImpressionDelayMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsPageCTAModel.class, new Deserializer());
            }

            public Object m9967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsPageCTAParser.m10031a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsPageCTAModel = new SearchResultsPageCTAModel();
                ((BaseModel) searchResultsPageCTAModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsPageCTAModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsPageCTAModel).a();
                }
                return searchResultsPageCTAModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -760636128)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: minImpressionDelayMs */
        public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8622d;

            /* compiled from: minImpressionDelayMs */
            public final class Builder {
                @Nullable
                public String f8621a;
            }

            /* compiled from: minImpressionDelayMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                }

                public Object m9968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhoneNumberParser.m10029a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object phoneNumberModel = new PhoneNumberModel();
                    ((BaseModel) phoneNumberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (phoneNumberModel instanceof Postprocessable) {
                        return ((Postprocessable) phoneNumberModel).a();
                    }
                    return phoneNumberModel;
                }
            }

            /* compiled from: minImpressionDelayMs */
            public class Serializer extends JsonSerializer<PhoneNumberModel> {
                public final void m9969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                    if (phoneNumberModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(phoneNumberModel.m9971a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhoneNumberParser.m10030a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                }
            }

            public PhoneNumberModel() {
                super(1);
            }

            public PhoneNumberModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m9973a() {
                this.f8622d = super.a(this.f8622d, 0);
                return this.f8622d;
            }

            public static PhoneNumberModel m9970a(PhoneNumberModel phoneNumberModel) {
                if (phoneNumberModel == null) {
                    return null;
                }
                if (phoneNumberModel instanceof PhoneNumberModel) {
                    return phoneNumberModel;
                }
                Builder builder = new Builder();
                builder.f8621a = phoneNumberModel.m9973a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8621a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PhoneNumberModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 474898999;
            }

            public final GraphQLVisitableModel m9972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9971a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9973a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: minImpressionDelayMs */
        public class Serializer extends JsonSerializer<SearchResultsPageCTAModel> {
            public final void m9974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsPageCTAModel searchResultsPageCTAModel = (SearchResultsPageCTAModel) obj;
                if (searchResultsPageCTAModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsPageCTAModel.m9977a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsPageCTAModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsPageCTAParser.m10032a(searchResultsPageCTAModel.w_(), searchResultsPageCTAModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsPageCTAModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PhoneNumberModel jf_() {
            return m9976j();
        }

        public SearchResultsPageCTAModel() {
            super(4);
        }

        public SearchResultsPageCTAModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLPageCallToActionType m9980b() {
            this.f8623d = (GraphQLPageCallToActionType) super.b(this.f8623d, 0, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8623d;
        }

        @Nullable
        public final String m9981c() {
            this.f8624e = super.a(this.f8624e, 1);
            return this.f8624e;
        }

        @Nullable
        public final String m9982d() {
            this.f8625f = super.a(this.f8625f, 2);
            return this.f8625f;
        }

        @Nullable
        private PhoneNumberModel m9976j() {
            this.f8626g = (PhoneNumberModel) super.a(this.f8626g, 3, PhoneNumberModel.class);
            return this.f8626g;
        }

        public static SearchResultsPageCTAModel m9975a(SearchResultsPageCTAModel searchResultsPageCTAModel) {
            if (searchResultsPageCTAModel == null) {
                return null;
            }
            if (searchResultsPageCTAModel instanceof SearchResultsPageCTAModel) {
                return searchResultsPageCTAModel;
            }
            Builder builder = new Builder();
            builder.f8617a = searchResultsPageCTAModel.m9980b();
            builder.f8618b = searchResultsPageCTAModel.m9981c();
            builder.f8619c = searchResultsPageCTAModel.m9982d();
            builder.f8620d = PhoneNumberModel.m9970a(searchResultsPageCTAModel.jf_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f8617a);
            int b = flatBufferBuilder.b(builder.f8618b);
            int b2 = flatBufferBuilder.b(builder.f8619c);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f8620d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SearchResultsPageCTAModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m9979a() {
            return m9982d();
        }

        public final int jK_() {
            return 133279070;
        }

        public final GraphQLVisitableModel m9978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9976j() != null) {
                PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m9976j());
                if (m9976j() != phoneNumberModel) {
                    graphQLVisitableModel = (SearchResultsPageCTAModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8626g = phoneNumberModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9977a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m9980b());
            int b = flatBufferBuilder.b(m9981c());
            int b2 = flatBufferBuilder.b(m9982d());
            int a2 = ModelHelper.a(flatBufferBuilder, m9976j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1701510216)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: minImpressionDelayMs */
    public final class SearchResultsPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsPage {
        @Nullable
        private GraphQLObjectType f8635d;
        private boolean f8636e;
        @Nullable
        private List<String> f8637f;
        @Nullable
        private CoverPhotoModel f8638g;
        private boolean f8639h;
        @Nullable
        private String f8640i;
        private boolean f8641j;
        @Nullable
        private String f8642k;
        @Nullable
        private SearchResultsPageCTAModel f8643l;
        @Nullable
        private PageLikersModel f8644m;
        @Nullable
        private DefaultImageFieldsModel f8645n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1306735391)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: minImpressionDelayMs */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f8632d;

            /* compiled from: minImpressionDelayMs */
            public final class Builder {
                @Nullable
                public PhotoModel f8627a;
            }

            /* compiled from: minImpressionDelayMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m9983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m10037a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1474925270)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: minImpressionDelayMs */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f8631d;

                /* compiled from: minImpressionDelayMs */
                public final class Builder {
                    @Nullable
                    public ImageModel f8628a;
                }

                /* compiled from: minImpressionDelayMs */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m9984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m10035a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object photoModel = new PhotoModel();
                        ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (photoModel instanceof Postprocessable) {
                            return ((Postprocessable) photoModel).a();
                        }
                        return photoModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: minImpressionDelayMs */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8630d;

                    /* compiled from: minImpressionDelayMs */
                    public final class Builder {
                        @Nullable
                        public String f8629a;
                    }

                    /* compiled from: minImpressionDelayMs */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m9985a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m10033a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: minImpressionDelayMs */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m9986a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m9988a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m10034a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m9990a() {
                        this.f8630d = super.a(this.f8630d, 0);
                        return this.f8630d;
                    }

                    public static ImageModel m9987a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f8629a = imageModel.m9990a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f8629a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m9989a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9988a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9990a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: minImpressionDelayMs */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m9991a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m9994a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m10036a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m9996a() {
                    return m9993j();
                }

                public PhotoModel() {
                    super(1);
                }

                public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private ImageModel m9993j() {
                    this.f8631d = (ImageModel) super.a(this.f8631d, 0, ImageModel.class);
                    return this.f8631d;
                }

                public static PhotoModel m9992a(PhotoModel photoModel) {
                    if (photoModel == null) {
                        return null;
                    }
                    if (photoModel instanceof PhotoModel) {
                        return photoModel;
                    }
                    Builder builder = new Builder();
                    builder.f8628a = ImageModel.m9987a(photoModel.m9996a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8628a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m9995a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9993j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m9993j());
                        if (m9993j() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8631d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9994a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9993j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: minImpressionDelayMs */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m9997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m10000a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m10038a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhotoModel m10002a() {
                return m9999j();
            }

            public CoverPhotoModel() {
                super(1);
            }

            public CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PhotoModel m9999j() {
                this.f8632d = (PhotoModel) super.a(this.f8632d, 0, PhotoModel.class);
                return this.f8632d;
            }

            public static CoverPhotoModel m9998a(CoverPhotoModel coverPhotoModel) {
                if (coverPhotoModel == null) {
                    return null;
                }
                if (coverPhotoModel instanceof CoverPhotoModel) {
                    return coverPhotoModel;
                }
                Builder builder = new Builder();
                builder.f8627a = PhotoModel.m9992a(coverPhotoModel.m10002a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8627a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m10001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9999j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m9999j());
                    if (m9999j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8632d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10000a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9999j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: minImpressionDelayMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsPageModel.class, new Deserializer());
            }

            public Object m10003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsPageParser.m10041a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsPageModel = new SearchResultsPageModel();
                ((BaseModel) searchResultsPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsPageModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsPageModel).a();
                }
                return searchResultsPageModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: minImpressionDelayMs */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f8634d;

            /* compiled from: minImpressionDelayMs */
            public final class Builder {
                public int f8633a;
            }

            /* compiled from: minImpressionDelayMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m10004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m10039a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            /* compiled from: minImpressionDelayMs */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m10005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m10008a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m10040a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public PageLikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m10007a() {
                a(0, 0);
                return this.f8634d;
            }

            public static PageLikersModel m10006a(PageLikersModel pageLikersModel) {
                if (pageLikersModel == null) {
                    return null;
                }
                if (pageLikersModel instanceof PageLikersModel) {
                    return pageLikersModel;
                }
                Builder builder = new Builder();
                builder.f8633a = pageLikersModel.m10007a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f8633a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageLikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m10009a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10008a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f8634d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10010a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8634d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: minImpressionDelayMs */
        public class Serializer extends JsonSerializer<SearchResultsPageModel> {
            public final void m10011a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultsPageModel searchResultsPageModel = (SearchResultsPageModel) obj;
                if (searchResultsPageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsPageModel.m10021a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultsPageModel.w_();
                int u_ = searchResultsPageModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 2), jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m10038a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                a = mutableFlatBuffer.a(u_, 6);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 7));
                }
                g = mutableFlatBuffer.g(u_, 8);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    SearchResultsPageCTAParser.m10032a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 9);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m10040a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 10);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultsPageModel.class, new Serializer());
            }
        }

        public SearchResultsPageModel() {
            super(11);
        }

        public final void m10025a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m10016o());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m10026a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m10012a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private GraphQLObjectType m10013l() {
            if (this.b != null && this.f8635d == null) {
                this.f8635d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8635d;
        }

        @Nonnull
        private ImmutableList<String> m10014m() {
            this.f8637f = super.a(this.f8637f, 2);
            return (ImmutableList) this.f8637f;
        }

        @Nullable
        private CoverPhotoModel m10015n() {
            this.f8638g = (CoverPhotoModel) super.a(this.f8638g, 3, CoverPhotoModel.class);
            return this.f8638g;
        }

        private boolean m10016o() {
            a(0, 4);
            return this.f8639h;
        }

        private void m10012a(boolean z) {
            this.f8639h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        @Nullable
        private String m10017p() {
            this.f8640i = super.a(this.f8640i, 5);
            return this.f8640i;
        }

        public final boolean mo562j() {
            a(0, 6);
            return this.f8641j;
        }

        @Nullable
        public final String mo563k() {
            this.f8642k = super.a(this.f8642k, 7);
            return this.f8642k;
        }

        @Nullable
        private SearchResultsPageCTAModel m10018q() {
            this.f8643l = (SearchResultsPageCTAModel) super.a(this.f8643l, 8, SearchResultsPageCTAModel.class);
            return this.f8643l;
        }

        @Nullable
        private PageLikersModel m10019r() {
            this.f8644m = (PageLikersModel) super.a(this.f8644m, 9, PageLikersModel.class);
            return this.f8644m;
        }

        @Nullable
        private DefaultImageFieldsModel m10020s() {
            this.f8645n = (DefaultImageFieldsModel) super.a(this.f8645n, 10, DefaultImageFieldsModel.class);
            return this.f8645n;
        }

        @Nullable
        public final String m10023a() {
            return m10017p();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10015n() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m10015n());
                if (m10015n() != coverPhotoModel) {
                    graphQLVisitableModel = (SearchResultsPageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8638g = coverPhotoModel;
                }
            }
            if (m10018q() != null) {
                SearchResultsPageCTAModel searchResultsPageCTAModel = (SearchResultsPageCTAModel) graphQLModelMutatingVisitor.b(m10018q());
                if (m10018q() != searchResultsPageCTAModel) {
                    graphQLVisitableModel = (SearchResultsPageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8643l = searchResultsPageCTAModel;
                }
            }
            if (m10019r() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m10019r());
                if (m10019r() != pageLikersModel) {
                    graphQLVisitableModel = (SearchResultsPageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8644m = pageLikersModel;
                }
            }
            if (m10020s() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10020s());
                if (m10020s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsPageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8645n = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10021a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10013l());
            int c = flatBufferBuilder.c(m10014m());
            int a2 = ModelHelper.a(flatBufferBuilder, m10015n());
            int b = flatBufferBuilder.b(m10017p());
            int b2 = flatBufferBuilder.b(mo563k());
            int a3 = ModelHelper.a(flatBufferBuilder, m10018q());
            int a4 = ModelHelper.a(flatBufferBuilder, m10019r());
            int a5 = ModelHelper.a(flatBufferBuilder, m10020s());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8636e);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.a(4, this.f8639h);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f8641j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.b(10, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10024a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8636e = mutableFlatBuffer.a(i, 1);
            this.f8639h = mutableFlatBuffer.a(i, 4);
            this.f8641j = mutableFlatBuffer.a(i, 6);
        }
    }
}
