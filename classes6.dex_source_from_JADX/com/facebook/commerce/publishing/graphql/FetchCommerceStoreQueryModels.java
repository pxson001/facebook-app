package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.FeaturedProductCount;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.FeaturedProductCountModel.OrderedCollectionsModel;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryParsers.CommerceStoreFieldsParser;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryParsers.CommerceStoreFieldsParser.CommerceMerchantSettingsParser;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryParsers.CommerceStoreFieldsParser.PageParser;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryParsers.FetchCommerceStoreQueryParser;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryModels.ProductCatalogFieldsModel;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: placetopic */
public class FetchCommerceStoreQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -221804715)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: placetopic */
    public final class CommerceStoreFieldsModel extends BaseModel implements FeaturedProductCount, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CommerceMerchantSettingsModel f7658d;
        @Nullable
        private String f7659e;
        @Nullable
        private String f7660f;
        @Nullable
        private OrderedCollectionsModel f7661g;
        @Nullable
        private PageModel f7662h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1747129211)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: placetopic */
        public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7654d;
            @Nullable
            private String f7655e;
            @Nullable
            private ProductCatalogFieldsModel f7656f;

            /* compiled from: placetopic */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                }

                public Object m10919a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceMerchantSettingsParser.m10952a(jsonParser, flatBufferBuilder));
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

            /* compiled from: placetopic */
            public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                public final void m10920a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                    if (commerceMerchantSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceMerchantSettingsModel.m10921a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceMerchantSettingsParser.m10953a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                }
            }

            public CommerceMerchantSettingsModel() {
                super(3);
            }

            @Nullable
            public final String m10924j() {
                this.f7654d = super.a(this.f7654d, 0);
                return this.f7654d;
            }

            @Nullable
            public final String m10925k() {
                this.f7655e = super.a(this.f7655e, 1);
                return this.f7655e;
            }

            @Nullable
            public final ProductCatalogFieldsModel m10926l() {
                this.f7656f = (ProductCatalogFieldsModel) super.a(this.f7656f, 2, ProductCatalogFieldsModel.class);
                return this.f7656f;
            }

            @Nullable
            public final String m10923a() {
                return m10925k();
            }

            public final int jK_() {
                return -1128014042;
            }

            public final GraphQLVisitableModel m10922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10926l() != null) {
                    ProductCatalogFieldsModel productCatalogFieldsModel = (ProductCatalogFieldsModel) graphQLModelMutatingVisitor.b(m10926l());
                    if (m10926l() != productCatalogFieldsModel) {
                        graphQLVisitableModel = (CommerceMerchantSettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7656f = productCatalogFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10921a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10924j());
                int b2 = flatBufferBuilder.b(m10925k());
                int a = ModelHelper.a(flatBufferBuilder, m10926l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: placetopic */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceStoreFieldsModel.class, new Deserializer());
            }

            public Object m10927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceStoreFieldsParser.m10956a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceStoreFieldsModel = new CommerceStoreFieldsModel();
                ((BaseModel) commerceStoreFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceStoreFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceStoreFieldsModel).a();
                }
                return commerceStoreFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: placetopic */
        public final class PageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f7657d;

            /* compiled from: placetopic */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m10928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m10954a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: placetopic */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m10929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m10930a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m10955a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m10933a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10934a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m10932a() {
                this.f7657d = super.a(this.f7657d, 0);
                return this.f7657d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m10931a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10930a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10932a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: placetopic */
        public class Serializer extends JsonSerializer<CommerceStoreFieldsModel> {
            public final void m10935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceStoreFieldsModel commerceStoreFieldsModel = (CommerceStoreFieldsModel) obj;
                if (commerceStoreFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceStoreFieldsModel.m10936a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceStoreFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceStoreFieldsParser.m10957a(commerceStoreFieldsModel.w_(), commerceStoreFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceStoreFieldsModel.class, new Serializer());
            }
        }

        public CommerceStoreFieldsModel() {
            super(5);
        }

        @Nullable
        public final CommerceMerchantSettingsModel m10939j() {
            this.f7658d = (CommerceMerchantSettingsModel) super.a(this.f7658d, 0, CommerceMerchantSettingsModel.class);
            return this.f7658d;
        }

        @Nullable
        public final String m10940k() {
            this.f7659e = super.a(this.f7659e, 1);
            return this.f7659e;
        }

        @Nullable
        public final String m10941l() {
            this.f7660f = super.a(this.f7660f, 2);
            return this.f7660f;
        }

        @Nullable
        public final OrderedCollectionsModel m10942m() {
            this.f7661g = (OrderedCollectionsModel) super.a(this.f7661g, 3, OrderedCollectionsModel.class);
            return this.f7661g;
        }

        @Nullable
        public final PageModel m10943n() {
            this.f7662h = (PageModel) super.a(this.f7662h, 4, PageModel.class);
            return this.f7662h;
        }

        @Nullable
        public final String m10938a() {
            return m10940k();
        }

        public final int jK_() {
            return 308731558;
        }

        public final GraphQLVisitableModel m10937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10939j() != null) {
                CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m10939j());
                if (m10939j() != commerceMerchantSettingsModel) {
                    graphQLVisitableModel = (CommerceStoreFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7658d = commerceMerchantSettingsModel;
                }
            }
            if (m10942m() != null) {
                OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) graphQLModelMutatingVisitor.b(m10942m());
                if (m10942m() != orderedCollectionsModel) {
                    graphQLVisitableModel = (CommerceStoreFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7661g = orderedCollectionsModel;
                }
            }
            if (m10943n() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m10943n());
                if (m10943n() != pageModel) {
                    graphQLVisitableModel = (CommerceStoreFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7662h = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10936a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10939j());
            int b = flatBufferBuilder.b(m10940k());
            int b2 = flatBufferBuilder.b(m10941l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10942m());
            int a3 = ModelHelper.a(flatBufferBuilder, m10943n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1810315126)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: placetopic */
    public final class FetchCommerceStoreQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7663d;
        @Nullable
        private CommerceStoreFieldsModel f7664e;

        /* compiled from: placetopic */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchCommerceStoreQueryModel.class, new Deserializer());
            }

            public Object m10944a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchCommerceStoreQueryParser.m10958a(jsonParser);
                Object fetchCommerceStoreQueryModel = new FetchCommerceStoreQueryModel();
                ((BaseModel) fetchCommerceStoreQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchCommerceStoreQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchCommerceStoreQueryModel).a();
                }
                return fetchCommerceStoreQueryModel;
            }
        }

        /* compiled from: placetopic */
        public class Serializer extends JsonSerializer<FetchCommerceStoreQueryModel> {
            public final void m10945a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchCommerceStoreQueryModel fetchCommerceStoreQueryModel = (FetchCommerceStoreQueryModel) obj;
                if (fetchCommerceStoreQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchCommerceStoreQueryModel.m10947a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchCommerceStoreQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchCommerceStoreQueryModel.w_();
                int u_ = fetchCommerceStoreQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreFieldsParser.m10957a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchCommerceStoreQueryModel.class, new Serializer());
            }
        }

        public FetchCommerceStoreQueryModel() {
            super(2);
        }

        public final void m10950a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10951a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10946j() {
            if (this.b != null && this.f7663d == null) {
                this.f7663d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7663d;
        }

        @Nullable
        public final CommerceStoreFieldsModel m10948a() {
            this.f7664e = (CommerceStoreFieldsModel) super.a(this.f7664e, 1, CommerceStoreFieldsModel.class);
            return this.f7664e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m10949a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10948a() != null) {
                CommerceStoreFieldsModel commerceStoreFieldsModel = (CommerceStoreFieldsModel) graphQLModelMutatingVisitor.b(m10948a());
                if (m10948a() != commerceStoreFieldsModel) {
                    graphQLVisitableModel = (FetchCommerceStoreQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7664e = commerceStoreFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10947a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10946j());
            int a2 = ModelHelper.a(flatBufferBuilder, m10948a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
