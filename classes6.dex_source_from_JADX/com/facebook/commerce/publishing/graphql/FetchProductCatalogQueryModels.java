package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryParsers.ProductCatalogFieldsParser;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryParsers.ProductCatalogFieldsParser.CatalogItemsParser;
import com.facebook.commerce.publishing.graphql.FetchProductCatalogQueryParsers.ProductItemEdgeParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: places_grammar_module_map */
public class FetchProductCatalogQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 597513505)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: places_grammar_module_map */
    public final class ProductCatalogFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CatalogItemsModel f7667d;
        @Nullable
        private String f7668e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2122282731)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: places_grammar_module_map */
        public final class CatalogItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f7665d;
            @Nullable
            private List<ProductItemEdgeModel> f7666e;

            /* compiled from: places_grammar_module_map */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CatalogItemsModel.class, new Deserializer());
                }

                public Object m10959a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CatalogItemsParser.m10978a(jsonParser, flatBufferBuilder));
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

            /* compiled from: places_grammar_module_map */
            public class Serializer extends JsonSerializer<CatalogItemsModel> {
                public final void m10960a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CatalogItemsModel catalogItemsModel = (CatalogItemsModel) obj;
                    if (catalogItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(catalogItemsModel.m10961a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        catalogItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CatalogItemsParser.m10979a(catalogItemsModel.w_(), catalogItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CatalogItemsModel.class, new Serializer());
                }
            }

            public CatalogItemsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ProductItemEdgeModel> m10963a() {
                this.f7666e = super.a(this.f7666e, 1, ProductItemEdgeModel.class);
                return (ImmutableList) this.f7666e;
            }

            public final int jK_() {
                return -186466156;
            }

            public final GraphQLVisitableModel m10962a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10963a() != null) {
                    Builder a = ModelHelper.a(m10963a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CatalogItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7666e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10961a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10963a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f7665d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10964a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f7665d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: places_grammar_module_map */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductCatalogFieldsModel.class, new Deserializer());
            }

            public Object m10965a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProductCatalogFieldsParser.m10980a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object productCatalogFieldsModel = new ProductCatalogFieldsModel();
                ((BaseModel) productCatalogFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (productCatalogFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) productCatalogFieldsModel).a();
                }
                return productCatalogFieldsModel;
            }
        }

        /* compiled from: places_grammar_module_map */
        public class Serializer extends JsonSerializer<ProductCatalogFieldsModel> {
            public final void m10966a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProductCatalogFieldsModel productCatalogFieldsModel = (ProductCatalogFieldsModel) obj;
                if (productCatalogFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productCatalogFieldsModel.m10968a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productCatalogFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProductCatalogFieldsParser.m10981a(productCatalogFieldsModel.w_(), productCatalogFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProductCatalogFieldsModel.class, new Serializer());
            }
        }

        public ProductCatalogFieldsModel() {
            super(2);
        }

        @Nullable
        public final CatalogItemsModel m10971j() {
            this.f7667d = (CatalogItemsModel) super.a(this.f7667d, 0, CatalogItemsModel.class);
            return this.f7667d;
        }

        @Nullable
        private String m10967k() {
            this.f7668e = super.a(this.f7668e, 1);
            return this.f7668e;
        }

        @Nullable
        public final String m10970a() {
            return m10967k();
        }

        public final int jK_() {
            return -580101046;
        }

        public final GraphQLVisitableModel m10969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10971j() != null) {
                CatalogItemsModel catalogItemsModel = (CatalogItemsModel) graphQLModelMutatingVisitor.b(m10971j());
                if (m10971j() != catalogItemsModel) {
                    graphQLVisitableModel = (ProductCatalogFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7667d = catalogItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10968a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10971j());
            int b = flatBufferBuilder.b(m10967k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2010303473)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: places_grammar_module_map */
    public final class ProductItemEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f7669d;
        @Nullable
        private AdminCommerceProductItemModel f7670e;

        /* compiled from: places_grammar_module_map */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductItemEdgeModel.class, new Deserializer());
            }

            public Object m10972a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProductItemEdgeParser.m10982b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object productItemEdgeModel = new ProductItemEdgeModel();
                ((BaseModel) productItemEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (productItemEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) productItemEdgeModel).a();
                }
                return productItemEdgeModel;
            }
        }

        /* compiled from: places_grammar_module_map */
        public class Serializer extends JsonSerializer<ProductItemEdgeModel> {
            public final void m10973a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProductItemEdgeModel productItemEdgeModel = (ProductItemEdgeModel) obj;
                if (productItemEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productItemEdgeModel.m10975a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productItemEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProductItemEdgeParser.m10983b(productItemEdgeModel.w_(), productItemEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProductItemEdgeModel.class, new Serializer());
            }
        }

        public ProductItemEdgeModel() {
            super(2);
        }

        @Nullable
        private String m10974j() {
            this.f7669d = super.a(this.f7669d, 0);
            return this.f7669d;
        }

        @Nullable
        public final AdminCommerceProductItemModel m10976a() {
            this.f7670e = (AdminCommerceProductItemModel) super.a(this.f7670e, 1, AdminCommerceProductItemModel.class);
            return this.f7670e;
        }

        public final int jK_() {
            return 1622585331;
        }

        public final GraphQLVisitableModel m10977a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10976a() != null) {
                AdminCommerceProductItemModel adminCommerceProductItemModel = (AdminCommerceProductItemModel) graphQLModelMutatingVisitor.b(m10976a());
                if (m10976a() != adminCommerceProductItemModel) {
                    graphQLVisitableModel = (ProductItemEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7670e = adminCommerceProductItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10975a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10974j());
            int a = ModelHelper.a(flatBufferBuilder, m10976a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
