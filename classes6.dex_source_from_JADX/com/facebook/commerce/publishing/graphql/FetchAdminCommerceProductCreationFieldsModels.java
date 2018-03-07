package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.FeaturedProductCount;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.FeaturedProductCountModel.OrderedCollectionsModel;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsParsers.PageShopProductCreationFieldsParser;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsParsers.PageShopProductCreationFieldsParser.CommerceStoreParser;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsParsers.PageShopProductCreationFieldsParser.CommerceStoreParser.CommerceMerchantSettingsParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: playableSrc */
public class FetchAdminCommerceProductCreationFieldsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1140739165)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: playableSrc */
    public final class PageShopProductCreationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private CommerceStoreModel f7642d;
        @Nullable
        private String f7643e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2073675367)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: playableSrc */
        public final class CommerceStoreModel extends BaseModel implements FeaturedProductCount, GraphQLVisitableModel {
            @Nullable
            private CommerceMerchantSettingsModel f7640d;
            @Nullable
            private OrderedCollectionsModel f7641e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 641986207)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: playableSrc */
            public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7639d;

                /* compiled from: playableSrc */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                    }

                    public Object m10873a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommerceMerchantSettingsParser.m10893a(jsonParser, flatBufferBuilder));
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

                /* compiled from: playableSrc */
                public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                    public final void m10874a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                        if (commerceMerchantSettingsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commerceMerchantSettingsModel.m10875a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommerceMerchantSettingsParser.m10894a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                    }
                }

                public CommerceMerchantSettingsModel() {
                    super(1);
                }

                @Nullable
                public final String m10877a() {
                    this.f7639d = super.a(this.f7639d, 0);
                    return this.f7639d;
                }

                public final int jK_() {
                    return -1128014042;
                }

                public final GraphQLVisitableModel m10876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10875a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10877a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: playableSrc */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceStoreModel.class, new Deserializer());
                }

                public Object m10878a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceStoreParser.m10895a(jsonParser, flatBufferBuilder));
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

            /* compiled from: playableSrc */
            public class Serializer extends JsonSerializer<CommerceStoreModel> {
                public final void m10879a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceStoreModel commerceStoreModel = (CommerceStoreModel) obj;
                    if (commerceStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceStoreModel.m10880a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceStoreParser.m10896a(commerceStoreModel.w_(), commerceStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceStoreModel.class, new Serializer());
                }
            }

            public CommerceStoreModel() {
                super(2);
            }

            @Nullable
            public final CommerceMerchantSettingsModel m10881a() {
                this.f7640d = (CommerceMerchantSettingsModel) super.a(this.f7640d, 0, CommerceMerchantSettingsModel.class);
                return this.f7640d;
            }

            @Nullable
            public final OrderedCollectionsModel m10883j() {
                this.f7641e = (OrderedCollectionsModel) super.a(this.f7641e, 1, OrderedCollectionsModel.class);
                return this.f7641e;
            }

            public final int jK_() {
                return 308731558;
            }

            public final GraphQLVisitableModel m10882a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10881a() != null) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m10881a());
                    if (m10881a() != commerceMerchantSettingsModel) {
                        graphQLVisitableModel = (CommerceStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7640d = commerceMerchantSettingsModel;
                    }
                }
                if (m10883j() != null) {
                    OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) graphQLModelMutatingVisitor.b(m10883j());
                    if (m10883j() != orderedCollectionsModel) {
                        graphQLVisitableModel = (CommerceStoreModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7641e = orderedCollectionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10880a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10881a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10883j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: playableSrc */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageShopProductCreationFieldsModel.class, new Deserializer());
            }

            public Object m10884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageShopProductCreationFieldsParser.m10897a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageShopProductCreationFieldsModel = new PageShopProductCreationFieldsModel();
                ((BaseModel) pageShopProductCreationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageShopProductCreationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageShopProductCreationFieldsModel).a();
                }
                return pageShopProductCreationFieldsModel;
            }
        }

        /* compiled from: playableSrc */
        public class Serializer extends JsonSerializer<PageShopProductCreationFieldsModel> {
            public final void m10885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageShopProductCreationFieldsModel pageShopProductCreationFieldsModel = (PageShopProductCreationFieldsModel) obj;
                if (pageShopProductCreationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageShopProductCreationFieldsModel.m10887a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageShopProductCreationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageShopProductCreationFieldsParser.m10898a(pageShopProductCreationFieldsModel.w_(), pageShopProductCreationFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageShopProductCreationFieldsModel.class, new Serializer());
            }
        }

        public PageShopProductCreationFieldsModel() {
            super(2);
        }

        public final void m10890a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10891a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CommerceStoreModel m10892j() {
            this.f7642d = (CommerceStoreModel) super.a(this.f7642d, 0, CommerceStoreModel.class);
            return this.f7642d;
        }

        @Nullable
        private String m10886k() {
            this.f7643e = super.a(this.f7643e, 1);
            return this.f7643e;
        }

        @Nullable
        public final String m10889a() {
            return m10886k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10888a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10892j() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m10892j());
                if (m10892j() != commerceStoreModel) {
                    graphQLVisitableModel = (PageShopProductCreationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7642d = commerceStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10887a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10892j());
            int b = flatBufferBuilder.b(m10886k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
