package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.OrderedImagesModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.ProductImageLargeModel;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsModels.PageShopProductCreationFieldsModel;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductItemParsers.FetchAdminCommerceProductItemParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLObjectType;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: platform_app_call */
public class FetchAdminCommerceProductItemModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -507483837)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: platform_app_call */
    public final class FetchAdminCommerceProductItemModel extends BaseModel implements AdminCommerceProductItem, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7644d;
        private boolean f7645e;
        @Nullable
        private GraphQLCommerceProductVisibility f7646f;
        @Nullable
        private String f7647g;
        @Nullable
        private String f7648h;
        @Nullable
        private String f7649i;
        @Nullable
        private List<OrderedImagesModel> f7650j;
        @Nullable
        private PageShopProductCreationFieldsModel f7651k;
        @Nullable
        private List<ProductImageLargeModel> f7652l;
        @Nullable
        private ProductItemPriceFieldsModel f7653m;

        /* compiled from: platform_app_call */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAdminCommerceProductItemModel.class, new Deserializer());
            }

            public Object m10900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchAdminCommerceProductItemParser.m10916a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchAdminCommerceProductItemModel = new FetchAdminCommerceProductItemModel();
                ((BaseModel) fetchAdminCommerceProductItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchAdminCommerceProductItemModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAdminCommerceProductItemModel).a();
                }
                return fetchAdminCommerceProductItemModel;
            }
        }

        /* compiled from: platform_app_call */
        public class Serializer extends JsonSerializer<FetchAdminCommerceProductItemModel> {
            public final void m10901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchAdminCommerceProductItemModel fetchAdminCommerceProductItemModel = (FetchAdminCommerceProductItemModel) obj;
                if (fetchAdminCommerceProductItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAdminCommerceProductItemModel.m10904a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAdminCommerceProductItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchAdminCommerceProductItemParser.m10917a(fetchAdminCommerceProductItemModel.w_(), fetchAdminCommerceProductItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchAdminCommerceProductItemModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProductItemPriceFieldsModel mo917j() {
            return m10903m();
        }

        public FetchAdminCommerceProductItemModel() {
            super(10);
        }

        public final void m10908a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10909a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10902l() {
            if (this.b != null && this.f7644d == null) {
                this.f7644d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7644d;
        }

        public final boolean mo910b() {
            a(0, 1);
            return this.f7645e;
        }

        @Nullable
        public final GraphQLCommerceProductVisibility mo911c() {
            this.f7646f = (GraphQLCommerceProductVisibility) super.b(this.f7646f, 2, GraphQLCommerceProductVisibility.class, GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7646f;
        }

        @Nullable
        public final String mo915d() {
            this.f7647g = super.a(this.f7647g, 3);
            return this.f7647g;
        }

        @Nullable
        public final String cu_() {
            this.f7648h = super.a(this.f7648h, 4);
            return this.f7648h;
        }

        @Nullable
        public final String mo916g() {
            this.f7649i = super.a(this.f7649i, 5);
            return this.f7649i;
        }

        @Nonnull
        public final ImmutableList<OrderedImagesModel> cv_() {
            this.f7650j = super.a(this.f7650j, 6, OrderedImagesModel.class);
            return (ImmutableList) this.f7650j;
        }

        @Nullable
        public final PageShopProductCreationFieldsModel m10915k() {
            this.f7651k = (PageShopProductCreationFieldsModel) super.a(this.f7651k, 7, PageShopProductCreationFieldsModel.class);
            return this.f7651k;
        }

        @Nonnull
        public final ImmutableList<ProductImageLargeModel> cw_() {
            this.f7652l = super.a(this.f7652l, 8, ProductImageLargeModel.class);
            return (ImmutableList) this.f7652l;
        }

        @Nullable
        private ProductItemPriceFieldsModel m10903m() {
            this.f7653m = (ProductItemPriceFieldsModel) super.a(this.f7653m, 9, ProductItemPriceFieldsModel.class);
            return this.f7653m;
        }

        @Nullable
        public final String m10906a() {
            return cu_();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m10905a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            FetchAdminCommerceProductItemModel fetchAdminCommerceProductItemModel;
            GraphQLVisitableModel graphQLVisitableModel;
            PageShopProductCreationFieldsModel pageShopProductCreationFieldsModel;
            Builder a;
            ProductItemPriceFieldsModel productItemPriceFieldsModel;
            h();
            if (cv_() != null) {
                Builder a2 = ModelHelper.a(cv_(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    fetchAdminCommerceProductItemModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(null, this);
                    fetchAdminCommerceProductItemModel.f7650j = a2.b();
                    graphQLVisitableModel = fetchAdminCommerceProductItemModel;
                    if (m10915k() != null) {
                        pageShopProductCreationFieldsModel = (PageShopProductCreationFieldsModel) graphQLModelMutatingVisitor.b(m10915k());
                        if (m10915k() != pageShopProductCreationFieldsModel) {
                            graphQLVisitableModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7651k = pageShopProductCreationFieldsModel;
                        }
                    }
                    if (cw_() != null) {
                        a = ModelHelper.a(cw_(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            fetchAdminCommerceProductItemModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                            fetchAdminCommerceProductItemModel.f7652l = a.b();
                            graphQLVisitableModel = fetchAdminCommerceProductItemModel;
                        }
                    }
                    if (m10903m() != null) {
                        productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m10903m());
                        if (m10903m() != productItemPriceFieldsModel) {
                            graphQLVisitableModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7653m = productItemPriceFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m10915k() != null) {
                pageShopProductCreationFieldsModel = (PageShopProductCreationFieldsModel) graphQLModelMutatingVisitor.b(m10915k());
                if (m10915k() != pageShopProductCreationFieldsModel) {
                    graphQLVisitableModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7651k = pageShopProductCreationFieldsModel;
                }
            }
            if (cw_() != null) {
                a = ModelHelper.a(cw_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    fetchAdminCommerceProductItemModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchAdminCommerceProductItemModel.f7652l = a.b();
                    graphQLVisitableModel = fetchAdminCommerceProductItemModel;
                }
            }
            if (m10903m() != null) {
                productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m10903m());
                if (m10903m() != productItemPriceFieldsModel) {
                    graphQLVisitableModel = (FetchAdminCommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7653m = productItemPriceFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m10904a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10902l());
            int a2 = flatBufferBuilder.a(mo911c());
            int b = flatBufferBuilder.b(mo915d());
            int b2 = flatBufferBuilder.b(cu_());
            int b3 = flatBufferBuilder.b(mo916g());
            int a3 = ModelHelper.a(flatBufferBuilder, cv_());
            int a4 = ModelHelper.a(flatBufferBuilder, m10915k());
            int a5 = ModelHelper.a(flatBufferBuilder, cw_());
            int a6 = ModelHelper.a(flatBufferBuilder, m10903m());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f7645e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10907a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7645e = mutableFlatBuffer.a(i, 1);
        }
    }
}
