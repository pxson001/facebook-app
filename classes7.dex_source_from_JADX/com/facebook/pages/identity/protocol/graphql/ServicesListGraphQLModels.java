package com.facebook.pages.identity.protocol.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServicesData;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser.OrderedImagesParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser.OrderedImagesParser.ImageParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServicesDataParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServicesDataParser.ServicesCardParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServicesDataParser.ServicesCardParser.ProductCatalogParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServicesDataParser.ServicesCardParser.ProductCatalogParser.CatalogItemsParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServicesDataParser.ServicesCardParser.ProductCatalogParser.CatalogItemsParser.EdgesParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.ServicesListGraphQLParser;
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

/* compiled from: me/live_video_subscriptions */
public class ServicesListGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 42081500)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: me/live_video_subscriptions */
    public final class PageServiceItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f9173d;
        @Nullable
        private String f9174e;
        @Nullable
        private String f9175f;
        @Nullable
        private String f9176g;
        @Nullable
        private List<OrderedImagesModel> f9177h;

        /* compiled from: me/live_video_subscriptions */
        public final class Builder {
            @Nullable
            public String f9164a;
            @Nullable
            public String f9165b;
            @Nullable
            public String f9166c;
            @Nullable
            public String f9167d;
            @Nullable
            public ImmutableList<OrderedImagesModel> f9168e;
        }

        /* compiled from: me/live_video_subscriptions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageServiceItemModel.class, new Deserializer());
            }

            public Object m11104a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageServiceItemModel = new PageServiceItemModel();
                ((BaseModel) pageServiceItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageServiceItemModel instanceof Postprocessable) {
                    return ((Postprocessable) pageServiceItemModel).a();
                }
                return pageServiceItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 801037361)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: me/live_video_subscriptions */
        public final class OrderedImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f9172d;

            /* compiled from: me/live_video_subscriptions */
            public final class Builder {
                @Nullable
                public ImageModel f9169a;
            }

            /* compiled from: me/live_video_subscriptions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OrderedImagesModel.class, new Deserializer());
                }

                public Object m11105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OrderedImagesParser.m11179b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object orderedImagesModel = new OrderedImagesModel();
                    ((BaseModel) orderedImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (orderedImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) orderedImagesModel).a();
                    }
                    return orderedImagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: me/live_video_subscriptions */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9171d;

                /* compiled from: me/live_video_subscriptions */
                public final class Builder {
                    @Nullable
                    public String f9170a;
                }

                /* compiled from: me/live_video_subscriptions */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m11106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m11177a(jsonParser, flatBufferBuilder));
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

                /* compiled from: me/live_video_subscriptions */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m11107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m11109a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m11178a(imageModel.w_(), imageModel.u_(), jsonGenerator);
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
                public final String m11111a() {
                    this.f9171d = super.a(this.f9171d, 0);
                    return this.f9171d;
                }

                public static ImageModel m11108a(ImageModel imageModel) {
                    if (imageModel == null) {
                        return null;
                    }
                    if (imageModel instanceof ImageModel) {
                        return imageModel;
                    }
                    Builder builder = new Builder();
                    builder.f9170a = imageModel.m11111a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f9170a);
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

                public final GraphQLVisitableModel m11110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11109a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11111a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: me/live_video_subscriptions */
            public class Serializer extends JsonSerializer<OrderedImagesModel> {
                public final void m11112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OrderedImagesModel orderedImagesModel = (OrderedImagesModel) obj;
                    if (orderedImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(orderedImagesModel.m11115a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        orderedImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OrderedImagesParser.m11180b(orderedImagesModel.w_(), orderedImagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OrderedImagesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m11117a() {
                return m11114j();
            }

            public OrderedImagesModel() {
                super(1);
            }

            public OrderedImagesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private ImageModel m11114j() {
                this.f9172d = (ImageModel) super.a(this.f9172d, 0, ImageModel.class);
                return this.f9172d;
            }

            public static OrderedImagesModel m11113a(OrderedImagesModel orderedImagesModel) {
                if (orderedImagesModel == null) {
                    return null;
                }
                if (orderedImagesModel instanceof OrderedImagesModel) {
                    return orderedImagesModel;
                }
                Builder builder = new Builder();
                builder.f9169a = ImageModel.m11108a(orderedImagesModel.m11117a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f9169a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OrderedImagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1158348236;
            }

            public final GraphQLVisitableModel m11116a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11114j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m11114j());
                    if (m11114j() != imageModel) {
                        graphQLVisitableModel = (OrderedImagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9172d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11115a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11114j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: me/live_video_subscriptions */
        public class Serializer extends JsonSerializer<PageServiceItemModel> {
            public final void m11118a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) obj;
                if (pageServiceItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageServiceItemModel.m11120a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageServiceItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageServiceItemParser.m11184b(pageServiceItemModel.w_(), pageServiceItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageServiceItemModel.class, new Serializer());
            }
        }

        public PageServiceItemModel() {
            super(5);
        }

        public PageServiceItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m11123b() {
            this.f9173d = super.a(this.f9173d, 0);
            return this.f9173d;
        }

        @Nullable
        public final String m11124c() {
            this.f9174e = super.a(this.f9174e, 1);
            return this.f9174e;
        }

        @Nullable
        public final String m11125d() {
            this.f9175f = super.a(this.f9175f, 2);
            return this.f9175f;
        }

        @Nullable
        public final String eC_() {
            this.f9176g = super.a(this.f9176g, 3);
            return this.f9176g;
        }

        @Nonnull
        public final ImmutableList<OrderedImagesModel> m11126g() {
            this.f9177h = super.a(this.f9177h, 4, OrderedImagesModel.class);
            return (ImmutableList) this.f9177h;
        }

        public static PageServiceItemModel m11119a(PageServiceItemModel pageServiceItemModel) {
            if (pageServiceItemModel == null) {
                return null;
            }
            if (pageServiceItemModel instanceof PageServiceItemModel) {
                return pageServiceItemModel;
            }
            Builder builder = new Builder();
            builder.f9164a = pageServiceItemModel.m11123b();
            builder.f9165b = pageServiceItemModel.m11124c();
            builder.f9166c = pageServiceItemModel.m11125d();
            builder.f9167d = pageServiceItemModel.eC_();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < pageServiceItemModel.m11126g().size(); i++) {
                builder2.c(OrderedImagesModel.m11113a((OrderedImagesModel) pageServiceItemModel.m11126g().get(i)));
            }
            builder.f9168e = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f9164a);
            int b2 = flatBufferBuilder.b(builder.f9165b);
            int b3 = flatBufferBuilder.b(builder.f9166c);
            int b4 = flatBufferBuilder.b(builder.f9167d);
            int a = ModelHelper.a(flatBufferBuilder, builder.f9168e);
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PageServiceItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m11122a() {
            return m11125d();
        }

        public final int jK_() {
            return 175920258;
        }

        public final GraphQLVisitableModel m11121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11126g() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m11126g(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageServiceItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9177h = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11120a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11123b());
            int b2 = flatBufferBuilder.b(m11124c());
            int b3 = flatBufferBuilder.b(m11125d());
            int b4 = flatBufferBuilder.b(eC_());
            int a = ModelHelper.a(flatBufferBuilder, m11126g());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -48347173)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: me/live_video_subscriptions */
    public final class PageServicesDataModel extends BaseModel implements GraphQLVisitableConsistentModel, PageServicesData {
        @Nullable
        private String f9188d;
        @Nullable
        private ServicesCardModel f9189e;

        /* compiled from: me/live_video_subscriptions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageServicesDataModel.class, new Deserializer());
            }

            public Object m11127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageServicesDataParser.m11193a(jsonParser);
                Object pageServicesDataModel = new PageServicesDataModel();
                ((BaseModel) pageServicesDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageServicesDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageServicesDataModel).a();
                }
                return pageServicesDataModel;
            }
        }

        /* compiled from: me/live_video_subscriptions */
        public class Serializer extends JsonSerializer<PageServicesDataModel> {
            public final void m11128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageServicesDataModel pageServicesDataModel = (PageServicesDataModel) obj;
                if (pageServicesDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageServicesDataModel.m11161a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageServicesDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageServicesDataModel.w_();
                int u_ = pageServicesDataModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesCardParser.m11192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageServicesDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -99847733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: me/live_video_subscriptions */
        public final class ServicesCardModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9183d;
            @Nullable
            private String f9184e;
            @Nullable
            private List<PageServiceItemModel> f9185f;
            @Nullable
            private String f9186g;
            @Nullable
            private ProductCatalogModel f9187h;

            /* compiled from: me/live_video_subscriptions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ServicesCardModel.class, new Deserializer());
                }

                public Object m11129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ServicesCardParser.m11191a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object servicesCardModel = new ServicesCardModel();
                    ((BaseModel) servicesCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (servicesCardModel instanceof Postprocessable) {
                        return ((Postprocessable) servicesCardModel).a();
                    }
                    return servicesCardModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1994641226)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: me/live_video_subscriptions */
            public final class ProductCatalogModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private CatalogItemsModel f9180d;
                @Nullable
                private String f9181e;
                @Nullable
                private String f9182f;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 920389321)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: me/live_video_subscriptions */
                public final class CatalogItemsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<EdgesModel> f9179d;

                    /* compiled from: me/live_video_subscriptions */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CatalogItemsModel.class, new Deserializer());
                        }

                        public Object m11130a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CatalogItemsParser.m11187a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object catalogItemsModel = new CatalogItemsModel();
                            ((BaseModel) catalogItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (catalogItemsModel instanceof Postprocessable) {
                                return ((Postprocessable) catalogItemsModel).a();
                            }
                            return catalogItemsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1941297384)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: me/live_video_subscriptions */
                    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private PageServiceItemModel f9178d;

                        /* compiled from: me/live_video_subscriptions */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                            }

                            public Object m11131a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EdgesParser.m11185b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: me/live_video_subscriptions */
                        public class Serializer extends JsonSerializer<EdgesModel> {
                            public final void m11132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EdgesModel edgesModel = (EdgesModel) obj;
                                if (edgesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(edgesModel.m11134a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EdgesParser.m11186b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EdgesModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ PageServiceItemModel m11136a() {
                            return m11133j();
                        }

                        public EdgesModel() {
                            super(1);
                        }

                        @Nullable
                        private PageServiceItemModel m11133j() {
                            this.f9178d = (PageServiceItemModel) super.a(this.f9178d, 0, PageServiceItemModel.class);
                            return this.f9178d;
                        }

                        public final int jK_() {
                            return 1622585331;
                        }

                        public final GraphQLVisitableModel m11135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m11133j() != null) {
                                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(m11133j());
                                if (m11133j() != pageServiceItemModel) {
                                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f9178d = pageServiceItemModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m11134a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m11133j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: me/live_video_subscriptions */
                    public class Serializer extends JsonSerializer<CatalogItemsModel> {
                        public final void m11137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CatalogItemsModel catalogItemsModel = (CatalogItemsModel) obj;
                            if (catalogItemsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(catalogItemsModel.m11138a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                catalogItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CatalogItemsParser.m11188a(catalogItemsModel.w_(), catalogItemsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(CatalogItemsModel.class, new Serializer());
                        }
                    }

                    public CatalogItemsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<EdgesModel> m11140a() {
                        this.f9179d = super.a(this.f9179d, 0, EdgesModel.class);
                        return (ImmutableList) this.f9179d;
                    }

                    public final int jK_() {
                        return -186466156;
                    }

                    public final GraphQLVisitableModel m11139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m11140a() != null) {
                            Builder a = ModelHelper.a(m11140a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (CatalogItemsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f9179d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m11138a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m11140a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: me/live_video_subscriptions */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProductCatalogModel.class, new Deserializer());
                    }

                    public Object m11141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProductCatalogParser.m11189a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object productCatalogModel = new ProductCatalogModel();
                        ((BaseModel) productCatalogModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (productCatalogModel instanceof Postprocessable) {
                            return ((Postprocessable) productCatalogModel).a();
                        }
                        return productCatalogModel;
                    }
                }

                /* compiled from: me/live_video_subscriptions */
                public class Serializer extends JsonSerializer<ProductCatalogModel> {
                    public final void m11142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProductCatalogModel productCatalogModel = (ProductCatalogModel) obj;
                        if (productCatalogModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(productCatalogModel.m11146a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            productCatalogModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProductCatalogParser.m11190a(productCatalogModel.w_(), productCatalogModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ProductCatalogModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CatalogItemsModel m11149b() {
                    return m11143j();
                }

                public ProductCatalogModel() {
                    super(3);
                }

                @Nullable
                private CatalogItemsModel m11143j() {
                    this.f9180d = (CatalogItemsModel) super.a(this.f9180d, 0, CatalogItemsModel.class);
                    return this.f9180d;
                }

                @Nullable
                private String m11144k() {
                    this.f9181e = super.a(this.f9181e, 1);
                    return this.f9181e;
                }

                @Nullable
                private String m11145l() {
                    this.f9182f = super.a(this.f9182f, 2);
                    return this.f9182f;
                }

                @Nullable
                public final String m11148a() {
                    return m11144k();
                }

                public final int jK_() {
                    return -580101046;
                }

                public final GraphQLVisitableModel m11147a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11143j() != null) {
                        CatalogItemsModel catalogItemsModel = (CatalogItemsModel) graphQLModelMutatingVisitor.b(m11143j());
                        if (m11143j() != catalogItemsModel) {
                            graphQLVisitableModel = (ProductCatalogModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9180d = catalogItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11146a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11143j());
                    int b = flatBufferBuilder.b(m11144k());
                    int b2 = flatBufferBuilder.b(m11145l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: me/live_video_subscriptions */
            public class Serializer extends JsonSerializer<ServicesCardModel> {
                public final void m11150a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ServicesCardModel servicesCardModel = (ServicesCardModel) obj;
                    if (servicesCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(servicesCardModel.m11154a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        servicesCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ServicesCardParser.m11192a(servicesCardModel.w_(), servicesCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ServicesCardModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProductCatalogModel m11159d() {
                return m11153l();
            }

            public ServicesCardModel() {
                super(5);
            }

            @Nullable
            public final String m11157b() {
                this.f9183d = super.a(this.f9183d, 0);
                return this.f9183d;
            }

            @Nullable
            private String m11151j() {
                this.f9184e = super.a(this.f9184e, 1);
                return this.f9184e;
            }

            @Nonnull
            public final ImmutableList<PageServiceItemModel> m11158c() {
                this.f9185f = super.a(this.f9185f, 2, PageServiceItemModel.class);
                return (ImmutableList) this.f9185f;
            }

            @Nullable
            private String m11152k() {
                this.f9186g = super.a(this.f9186g, 3);
                return this.f9186g;
            }

            @Nullable
            private ProductCatalogModel m11153l() {
                this.f9187h = (ProductCatalogModel) super.a(this.f9187h, 4, ProductCatalogModel.class);
                return this.f9187h;
            }

            @Nullable
            public final String m11156a() {
                return m11152k();
            }

            public final int jK_() {
                return -1544864547;
            }

            public final GraphQLVisitableModel m11155a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                ProductCatalogModel productCatalogModel;
                h();
                if (m11158c() != null) {
                    Builder a = ModelHelper.a(m11158c(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ServicesCardModel servicesCardModel = (ServicesCardModel) ModelHelper.a(null, this);
                        servicesCardModel.f9185f = a.b();
                        graphQLVisitableModel = servicesCardModel;
                        if (m11153l() != null) {
                            productCatalogModel = (ProductCatalogModel) graphQLModelMutatingVisitor.b(m11153l());
                            if (m11153l() != productCatalogModel) {
                                graphQLVisitableModel = (ServicesCardModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9187h = productCatalogModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m11153l() != null) {
                    productCatalogModel = (ProductCatalogModel) graphQLModelMutatingVisitor.b(m11153l());
                    if (m11153l() != productCatalogModel) {
                        graphQLVisitableModel = (ServicesCardModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9187h = productCatalogModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m11154a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11157b());
                int b2 = flatBufferBuilder.b(m11151j());
                int a = ModelHelper.a(flatBufferBuilder, m11158c());
                int b3 = flatBufferBuilder.b(m11152k());
                int a2 = ModelHelper.a(flatBufferBuilder, m11153l());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ServicesCardModel mo481b() {
            return m11160j();
        }

        public PageServicesDataModel() {
            super(2);
        }

        public final void m11164a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11165a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String mo480a() {
            this.f9188d = super.a(this.f9188d, 0);
            return this.f9188d;
        }

        @Nullable
        private ServicesCardModel m11160j() {
            this.f9189e = (ServicesCardModel) super.a(this.f9189e, 1, ServicesCardModel.class);
            return this.f9189e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m11162a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11160j() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m11160j());
                if (m11160j() != servicesCardModel) {
                    graphQLVisitableModel = (PageServicesDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9189e = servicesCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11161a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo480a());
            int a = ModelHelper.a(flatBufferBuilder, m11160j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 170982502)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: me/live_video_subscriptions */
    public final class ServicesListGraphQLModel extends BaseModel implements GraphQLVisitableConsistentModel, PageServicesData {
        @Nullable
        private GraphQLObjectType f9190d;
        @Nullable
        private String f9191e;
        @Nullable
        private ServicesCardModel f9192f;

        /* compiled from: me/live_video_subscriptions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ServicesListGraphQLModel.class, new Deserializer());
            }

            public Object m11167a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ServicesListGraphQLParser.m11194a(jsonParser);
                Object servicesListGraphQLModel = new ServicesListGraphQLModel();
                ((BaseModel) servicesListGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (servicesListGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) servicesListGraphQLModel).a();
                }
                return servicesListGraphQLModel;
            }
        }

        /* compiled from: me/live_video_subscriptions */
        public class Serializer extends JsonSerializer<ServicesListGraphQLModel> {
            public final void m11168a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ServicesListGraphQLModel servicesListGraphQLModel = (ServicesListGraphQLModel) obj;
                if (servicesListGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(servicesListGraphQLModel.m11171a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    servicesListGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = servicesListGraphQLModel.w_();
                int u_ = servicesListGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesCardParser.m11192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ServicesListGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ServicesCardModel mo481b() {
            return m11170k();
        }

        public ServicesListGraphQLModel() {
            super(3);
        }

        public final void m11174a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11175a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11169j() {
            if (this.b != null && this.f9190d == null) {
                this.f9190d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9190d;
        }

        @Nullable
        public final String mo480a() {
            this.f9191e = super.a(this.f9191e, 1);
            return this.f9191e;
        }

        @Nullable
        private ServicesCardModel m11170k() {
            this.f9192f = (ServicesCardModel) super.a(this.f9192f, 2, ServicesCardModel.class);
            return this.f9192f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m11172a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11170k() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m11170k());
                if (m11170k() != servicesCardModel) {
                    graphQLVisitableModel = (ServicesListGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9192f = servicesCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11171a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11169j());
            int b = flatBufferBuilder.b(mo480a());
            int a2 = ModelHelper.a(flatBufferBuilder, m11170k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
