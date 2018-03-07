package com.facebook.pages.data.graphql.cards;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
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
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.CommerceMerchantSettingsParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser.NodesParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser.CollectionProductItemsNodesParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser.CollectionProductItemsNodesParser.OrderedImagesParser;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLParsers.PageIdentityCommerceCardQueryParser.CommerceStoreParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser.CollectionProductItemsNodesParser.OrderedImagesParser.ImageParser;
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

/* compiled from: contextItemInfoCards */
public class PageIdentityCommerceCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1025636246)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contextItemInfoCards */
    public final class PageIdentityCommerceCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CommerceStoreModel f17018d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -366584016)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contextItemInfoCards */
        public final class CommerceStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CommerceMerchantSettingsModel f17015d;
            @Nullable
            private OrderedCollectionsModel f17016e;
            @Nullable
            private String f17017f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2012061014)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: contextItemInfoCards */
            public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLVisitableModel {
                private int f17003d;
                private boolean f17004e;

                /* compiled from: contextItemInfoCards */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                    }

                    public Object m20494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommerceMerchantSettingsParser.m20556a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commerceMerchantSettingsModel = new CommerceMerchantSettingsModel();
                        ((BaseModel) commerceMerchantSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (commerceMerchantSettingsModel instanceof Postprocessable) {
                            return ((Postprocessable) commerceMerchantSettingsModel).a();
                        }
                        return commerceMerchantSettingsModel;
                    }
                }

                /* compiled from: contextItemInfoCards */
                public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                    public final void m20495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                        if (commerceMerchantSettingsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commerceMerchantSettingsModel.m20497a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommerceMerchantSettingsParser.m20557a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                    }
                }

                public CommerceMerchantSettingsModel() {
                    super(2);
                }

                public final int m20496a() {
                    a(0, 0);
                    return this.f17003d;
                }

                public final boolean m20500b() {
                    a(0, 1);
                    return this.f17004e;
                }

                public final int jK_() {
                    return -1128014042;
                }

                public final GraphQLVisitableModel m20498a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20497a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f17003d, 0);
                    flatBufferBuilder.a(1, this.f17004e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20499a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17003d = mutableFlatBuffer.a(i, 0, 0);
                    this.f17004e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: contextItemInfoCards */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceStoreModel.class, new Deserializer());
                }

                public Object m20501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceStoreParser.m20570a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1585677439)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: contextItemInfoCards */
            public final class OrderedCollectionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f17014d;

                /* compiled from: contextItemInfoCards */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OrderedCollectionsModel.class, new Deserializer());
                    }

                    public Object m20502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OrderedCollectionsParser.m20568a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object orderedCollectionsModel = new OrderedCollectionsModel();
                        ((BaseModel) orderedCollectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (orderedCollectionsModel instanceof Postprocessable) {
                            return ((Postprocessable) orderedCollectionsModel).a();
                        }
                        return orderedCollectionsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1286629967)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: contextItemInfoCards */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private CollectionProductItemsModel f17012d;
                    @Nullable
                    private String f17013e;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1036161285)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: contextItemInfoCards */
                    public final class CollectionProductItemsModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<CollectionProductItemsNodesModel> f17011d;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1640842473)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: contextItemInfoCards */
                        public final class CollectionProductItemsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                            @Nullable
                            private String f17007d;
                            @Nullable
                            private String f17008e;
                            @Nullable
                            private List<OrderedImagesModel> f17009f;
                            @Nullable
                            private ProductItemPriceFieldsModel f17010g;

                            /* compiled from: contextItemInfoCards */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(CollectionProductItemsNodesModel.class, new Deserializer());
                                }

                                public Object m20503a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(CollectionProductItemsNodesParser.m20562b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object collectionProductItemsNodesModel = new CollectionProductItemsNodesModel();
                                    ((BaseModel) collectionProductItemsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (collectionProductItemsNodesModel instanceof Postprocessable) {
                                        return ((Postprocessable) collectionProductItemsNodesModel).a();
                                    }
                                    return collectionProductItemsNodesModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 2107135841)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: contextItemInfoCards */
                            public final class OrderedImagesModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private ImageModel f17006d;

                                /* compiled from: contextItemInfoCards */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(OrderedImagesModel.class, new Deserializer());
                                    }

                                    public Object m20504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(OrderedImagesParser.m20560b(jsonParser, flatBufferBuilder));
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
                                /* compiled from: contextItemInfoCards */
                                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f17005d;

                                    /* compiled from: contextItemInfoCards */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                                        }

                                        public Object m20505a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(ImageParser.m20558a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: contextItemInfoCards */
                                    public class Serializer extends JsonSerializer<ImageModel> {
                                        public final void m20506a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            ImageModel imageModel = (ImageModel) obj;
                                            if (imageModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(imageModel.m20507a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            ImageParser.m20559a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                                        }
                                    }

                                    public ImageModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    public final String m20509a() {
                                        this.f17005d = super.a(this.f17005d, 0);
                                        return this.f17005d;
                                    }

                                    public final int jK_() {
                                        return 70760763;
                                    }

                                    public final GraphQLVisitableModel m20508a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m20507a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m20509a());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, b);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: contextItemInfoCards */
                                public class Serializer extends JsonSerializer<OrderedImagesModel> {
                                    public final void m20510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        OrderedImagesModel orderedImagesModel = (OrderedImagesModel) obj;
                                        if (orderedImagesModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(orderedImagesModel.m20512a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            orderedImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        OrderedImagesParser.m20561b(orderedImagesModel.w_(), orderedImagesModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(OrderedImagesModel.class, new Serializer());
                                    }
                                }

                                @Nullable
                                public final /* synthetic */ ImageModel m20514a() {
                                    return m20511j();
                                }

                                public OrderedImagesModel() {
                                    super(1);
                                }

                                @Nullable
                                private ImageModel m20511j() {
                                    this.f17006d = (ImageModel) super.a(this.f17006d, 0, ImageModel.class);
                                    return this.f17006d;
                                }

                                public final int jK_() {
                                    return 1158348236;
                                }

                                public final GraphQLVisitableModel m20513a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m20511j() != null) {
                                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m20511j());
                                        if (m20511j() != imageModel) {
                                            graphQLVisitableModel = (OrderedImagesModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f17006d = imageModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m20512a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m20511j());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, a);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: contextItemInfoCards */
                            public class Serializer extends JsonSerializer<CollectionProductItemsNodesModel> {
                                public final void m20515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    CollectionProductItemsNodesModel collectionProductItemsNodesModel = (CollectionProductItemsNodesModel) obj;
                                    if (collectionProductItemsNodesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(collectionProductItemsNodesModel.m20517a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        collectionProductItemsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    CollectionProductItemsNodesParser.m20563b(collectionProductItemsNodesModel.w_(), collectionProductItemsNodesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(CollectionProductItemsNodesModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ ProductItemPriceFieldsModel kx_() {
                                return m20516j();
                            }

                            public CollectionProductItemsNodesModel() {
                                super(4);
                            }

                            @Nullable
                            public final String m20520b() {
                                this.f17007d = super.a(this.f17007d, 0);
                                return this.f17007d;
                            }

                            @Nullable
                            public final String m20521c() {
                                this.f17008e = super.a(this.f17008e, 1);
                                return this.f17008e;
                            }

                            @Nonnull
                            public final ImmutableList<OrderedImagesModel> m20522d() {
                                this.f17009f = super.a(this.f17009f, 2, OrderedImagesModel.class);
                                return (ImmutableList) this.f17009f;
                            }

                            @Nullable
                            private ProductItemPriceFieldsModel m20516j() {
                                this.f17010g = (ProductItemPriceFieldsModel) super.a(this.f17010g, 3, ProductItemPriceFieldsModel.class);
                                return this.f17010g;
                            }

                            @Nullable
                            public final String m20519a() {
                                return m20520b();
                            }

                            public final int jK_() {
                                return 175920258;
                            }

                            public final GraphQLVisitableModel m20518a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel;
                                ProductItemPriceFieldsModel productItemPriceFieldsModel;
                                h();
                                if (m20522d() != null) {
                                    Builder a = ModelHelper.a(m20522d(), graphQLModelMutatingVisitor);
                                    if (a != null) {
                                        CollectionProductItemsNodesModel collectionProductItemsNodesModel = (CollectionProductItemsNodesModel) ModelHelper.a(null, this);
                                        collectionProductItemsNodesModel.f17009f = a.b();
                                        graphQLVisitableModel = collectionProductItemsNodesModel;
                                        if (m20516j() != null) {
                                            productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m20516j());
                                            if (m20516j() != productItemPriceFieldsModel) {
                                                graphQLVisitableModel = (CollectionProductItemsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                                graphQLVisitableModel.f17010g = productItemPriceFieldsModel;
                                            }
                                        }
                                        i();
                                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                    }
                                }
                                graphQLVisitableModel = null;
                                if (m20516j() != null) {
                                    productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m20516j());
                                    if (m20516j() != productItemPriceFieldsModel) {
                                        graphQLVisitableModel = (CollectionProductItemsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f17010g = productItemPriceFieldsModel;
                                    }
                                }
                                i();
                                if (graphQLVisitableModel != null) {
                                }
                            }

                            public final int m20517a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m20520b());
                                int b2 = flatBufferBuilder.b(m20521c());
                                int a = ModelHelper.a(flatBufferBuilder, m20522d());
                                int a2 = ModelHelper.a(flatBufferBuilder, m20516j());
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                flatBufferBuilder.b(2, a);
                                flatBufferBuilder.b(3, a2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: contextItemInfoCards */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(CollectionProductItemsModel.class, new Deserializer());
                            }

                            public Object m20523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(CollectionProductItemsParser.m20564a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object collectionProductItemsModel = new CollectionProductItemsModel();
                                ((BaseModel) collectionProductItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (collectionProductItemsModel instanceof Postprocessable) {
                                    return ((Postprocessable) collectionProductItemsModel).a();
                                }
                                return collectionProductItemsModel;
                            }
                        }

                        /* compiled from: contextItemInfoCards */
                        public class Serializer extends JsonSerializer<CollectionProductItemsModel> {
                            public final void m20524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) obj;
                                if (collectionProductItemsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(collectionProductItemsModel.m20525a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    collectionProductItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                CollectionProductItemsParser.m20565a(collectionProductItemsModel.w_(), collectionProductItemsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(CollectionProductItemsModel.class, new Serializer());
                            }
                        }

                        public CollectionProductItemsModel() {
                            super(1);
                        }

                        @Nonnull
                        public final ImmutableList<CollectionProductItemsNodesModel> m20527a() {
                            this.f17011d = super.a(this.f17011d, 0, CollectionProductItemsNodesModel.class);
                            return (ImmutableList) this.f17011d;
                        }

                        public final int jK_() {
                            return -1537844013;
                        }

                        public final GraphQLVisitableModel m20526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m20527a() != null) {
                                Builder a = ModelHelper.a(m20527a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (CollectionProductItemsModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f17011d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m20525a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m20527a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: contextItemInfoCards */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m20528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m20566b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodesModel = new NodesModel();
                            ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodesModel instanceof Postprocessable) {
                                return ((Postprocessable) nodesModel).a();
                            }
                            return nodesModel;
                        }
                    }

                    /* compiled from: contextItemInfoCards */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m20529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m20531a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m20567b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ CollectionProductItemsModel m20534b() {
                        return m20530j();
                    }

                    public NodesModel() {
                        super(2);
                    }

                    @Nullable
                    private CollectionProductItemsModel m20530j() {
                        this.f17012d = (CollectionProductItemsModel) super.a(this.f17012d, 0, CollectionProductItemsModel.class);
                        return this.f17012d;
                    }

                    @Nullable
                    public final String m20535c() {
                        this.f17013e = super.a(this.f17013e, 1);
                        return this.f17013e;
                    }

                    @Nullable
                    public final String m20533a() {
                        return m20535c();
                    }

                    public final int jK_() {
                        return -1187196444;
                    }

                    public final GraphQLVisitableModel m20532a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20530j() != null) {
                            CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) graphQLModelMutatingVisitor.b(m20530j());
                            if (m20530j() != collectionProductItemsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f17012d = collectionProductItemsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20531a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m20530j());
                        int b = flatBufferBuilder.b(m20535c());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: contextItemInfoCards */
                public class Serializer extends JsonSerializer<OrderedCollectionsModel> {
                    public final void m20536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) obj;
                        if (orderedCollectionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(orderedCollectionsModel.m20537a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            orderedCollectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OrderedCollectionsParser.m20569a(orderedCollectionsModel.w_(), orderedCollectionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OrderedCollectionsModel.class, new Serializer());
                    }
                }

                public OrderedCollectionsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m20539a() {
                    this.f17014d = super.a(this.f17014d, 0, NodesModel.class);
                    return (ImmutableList) this.f17014d;
                }

                public final int jK_() {
                    return 1993375565;
                }

                public final GraphQLVisitableModel m20538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20539a() != null) {
                        Builder a = ModelHelper.a(m20539a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (OrderedCollectionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17014d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20537a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20539a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: contextItemInfoCards */
            public class Serializer extends JsonSerializer<CommerceStoreModel> {
                public final void m20540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceStoreModel commerceStoreModel = (CommerceStoreModel) obj;
                    if (commerceStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceStoreModel.m20542a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceStoreParser.m20571a(commerceStoreModel.w_(), commerceStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceStoreModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ CommerceMerchantSettingsModel m20544a() {
                return m20541k();
            }

            @Nullable
            public final /* synthetic */ OrderedCollectionsModel m20545b() {
                return m20547j();
            }

            public CommerceStoreModel() {
                super(3);
            }

            @Nullable
            private CommerceMerchantSettingsModel m20541k() {
                this.f17015d = (CommerceMerchantSettingsModel) super.a(this.f17015d, 0, CommerceMerchantSettingsModel.class);
                return this.f17015d;
            }

            @Nullable
            public final OrderedCollectionsModel m20547j() {
                this.f17016e = (OrderedCollectionsModel) super.a(this.f17016e, 1, OrderedCollectionsModel.class);
                return this.f17016e;
            }

            @Nullable
            public final String m20546c() {
                this.f17017f = super.a(this.f17017f, 2);
                return this.f17017f;
            }

            public final int jK_() {
                return 308731558;
            }

            public final GraphQLVisitableModel m20543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20541k() != null) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m20541k());
                    if (m20541k() != commerceMerchantSettingsModel) {
                        graphQLVisitableModel = (CommerceStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17015d = commerceMerchantSettingsModel;
                    }
                }
                if (m20547j() != null) {
                    OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) graphQLModelMutatingVisitor.b(m20547j());
                    if (m20547j() != orderedCollectionsModel) {
                        graphQLVisitableModel = (CommerceStoreModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17016e = orderedCollectionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20542a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20541k());
                int a2 = ModelHelper.a(flatBufferBuilder, m20547j());
                int b = flatBufferBuilder.b(m20546c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contextItemInfoCards */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageIdentityCommerceCardQueryModel.class, new Deserializer());
            }

            public Object m20548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageIdentityCommerceCardQueryParser.m20572a(jsonParser);
                Object pageIdentityCommerceCardQueryModel = new PageIdentityCommerceCardQueryModel();
                ((BaseModel) pageIdentityCommerceCardQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageIdentityCommerceCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageIdentityCommerceCardQueryModel).a();
                }
                return pageIdentityCommerceCardQueryModel;
            }
        }

        /* compiled from: contextItemInfoCards */
        public class Serializer extends JsonSerializer<PageIdentityCommerceCardQueryModel> {
            public final void m20549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel = (PageIdentityCommerceCardQueryModel) obj;
                if (pageIdentityCommerceCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageIdentityCommerceCardQueryModel.m20550a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageIdentityCommerceCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageIdentityCommerceCardQueryModel.w_();
                int u_ = pageIdentityCommerceCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreParser.m20571a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageIdentityCommerceCardQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceStoreModel m20552a() {
            return m20555j();
        }

        public PageIdentityCommerceCardQueryModel() {
            super(1);
        }

        public final void m20553a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20554a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CommerceStoreModel m20555j() {
            this.f17018d = (CommerceStoreModel) super.a(this.f17018d, 0, CommerceStoreModel.class);
            return this.f17018d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20555j() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m20555j());
                if (m20555j() != commerceStoreModel) {
                    graphQLVisitableModel = (PageIdentityCommerceCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17018d = commerceStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20550a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20555j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
