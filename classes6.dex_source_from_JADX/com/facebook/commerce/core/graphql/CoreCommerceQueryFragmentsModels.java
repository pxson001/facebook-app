package com.facebook.commerce.core.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceMerchantPageFragmentParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceMerchantPageFragmentParser.PageLikersParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceMerchantPageFragmentParser.ProfilePictureParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceProductItemParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceProductItemParser.ImagesParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceProductItemParser.ProductCatalogImageParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceProductItemParser.ProductImageLargeParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceStoreFragmentParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceStoreFragmentParser.CommerceCollectionsParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceStoreFragmentParser.CommerceCollectionsParser.CollectionProductItemsParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceStoreFragmentParser.CommerceCollectionsParser.CollectionProductItemsParser.EdgesParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.CommerceStoreFragmentParser.CommerceMerchantSettingsParser;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.ProductItemPriceFieldsParser;
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
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser;
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

/* compiled from: previous_privacy */
public class CoreCommerceQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1753925482)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: previous_privacy */
    public final class CommerceMerchantPageFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f7461d;
        @Nullable
        private List<String> f7462e;
        @Nullable
        private GraphQLPageCategoryType f7463f;
        private boolean f7464g;
        @Nullable
        private String f7465h;
        @Nullable
        private String f7466i;
        @Nullable
        private PageLikersModel f7467j;
        @Nullable
        private ProfilePictureModel f7468k;

        /* compiled from: previous_privacy */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceMerchantPageFragmentModel.class, new Deserializer());
            }

            public Object m10512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceMerchantPageFragmentParser.m10624a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceMerchantPageFragmentModel = new CommerceMerchantPageFragmentModel();
                ((BaseModel) commerceMerchantPageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceMerchantPageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceMerchantPageFragmentModel).a();
                }
                return commerceMerchantPageFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f7459d;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m10513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m10620a(jsonParser, flatBufferBuilder));
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

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m10514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m10516a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m10621a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public final int m10515a() {
                a(0, 0);
                return this.f7459d;
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m10517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10516a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f7459d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10518a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f7459d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7460d;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m10519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m10622a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m10520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m10521a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m10623a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m10523a() {
                this.f7460d = super.a(this.f7460d, 0);
                return this.f7460d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10521a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10523a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: previous_privacy */
        public class Serializer extends JsonSerializer<CommerceMerchantPageFragmentModel> {
            public final void m10524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceMerchantPageFragmentModel commerceMerchantPageFragmentModel = (CommerceMerchantPageFragmentModel) obj;
                if (commerceMerchantPageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceMerchantPageFragmentModel.m10528a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceMerchantPageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceMerchantPageFragmentParser.m10625a(commerceMerchantPageFragmentModel.w_(), commerceMerchantPageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceMerchantPageFragmentModel.class, new Serializer());
            }
        }

        public CommerceMerchantPageFragmentModel() {
            super(8);
        }

        public final void m10532a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m10527p());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m10533a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m10525a(((Boolean) obj).booleanValue());
            }
        }

        @Nonnull
        public final ImmutableList<String> m10534j() {
            this.f7462e = super.a(this.f7462e, 1);
            return (ImmutableList) this.f7462e;
        }

        @Nullable
        private GraphQLPageCategoryType m10526o() {
            this.f7463f = (GraphQLPageCategoryType) super.b(this.f7463f, 2, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7463f;
        }

        private boolean m10527p() {
            a(0, 3);
            return this.f7464g;
        }

        private void m10525a(boolean z) {
            this.f7464g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        @Nullable
        public final String m10535k() {
            this.f7465h = super.a(this.f7465h, 4);
            return this.f7465h;
        }

        @Nullable
        public final String m10536l() {
            this.f7466i = super.a(this.f7466i, 5);
            return this.f7466i;
        }

        @Nullable
        public final PageLikersModel m10537m() {
            this.f7467j = (PageLikersModel) super.a(this.f7467j, 6, PageLikersModel.class);
            return this.f7467j;
        }

        @Nullable
        public final ProfilePictureModel m10538n() {
            this.f7468k = (ProfilePictureModel) super.a(this.f7468k, 7, ProfilePictureModel.class);
            return this.f7468k;
        }

        @Nullable
        public final String m10530a() {
            return m10535k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10529a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10537m() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m10537m());
                if (m10537m() != pageLikersModel) {
                    graphQLVisitableModel = (CommerceMerchantPageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7467j = pageLikersModel;
                }
            }
            if (m10538n() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m10538n());
                if (m10538n() != profilePictureModel) {
                    graphQLVisitableModel = (CommerceMerchantPageFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7468k = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10528a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m10534j());
            int a = flatBufferBuilder.a(m10526o());
            int b = flatBufferBuilder.b(m10535k());
            int b2 = flatBufferBuilder.b(m10536l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10537m());
            int a3 = ModelHelper.a(flatBufferBuilder, m10538n());
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f7461d);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f7464g);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10531a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7461d = mutableFlatBuffer.a(i, 0);
            this.f7464g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1970300062)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: previous_privacy */
    public final class CommerceProductItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLCommerceProductVisibility f7472d;
        @Nullable
        private ProductItemPriceFieldsModel f7473e;
        @Nullable
        private String f7474f;
        @Nullable
        private String f7475g;
        @Nullable
        private String f7476h;
        @Nullable
        private List<ImagesModel> f7477i;
        private boolean f7478j;
        @Nullable
        private String f7479k;
        @Nullable
        private ProductCatalogImageModel f7480l;
        @Nullable
        private ProductImageLargeModel f7481m;
        @Nullable
        private ProductItemPriceFieldsModel f7482n;

        /* compiled from: previous_privacy */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceProductItemModel.class, new Deserializer());
            }

            public Object m10539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceProductItemParser.m10633a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceProductItemModel = new CommerceProductItemModel();
                ((BaseModel) commerceProductItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceProductItemModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceProductItemModel).a();
                }
                return commerceProductItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class ImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7469d;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImagesModel.class, new Deserializer());
                }

                public Object m10540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImagesParser.m10628b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imagesModel = new ImagesModel();
                    ((BaseModel) imagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imagesModel instanceof Postprocessable) {
                        return ((Postprocessable) imagesModel).a();
                    }
                    return imagesModel;
                }
            }

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<ImagesModel> {
                public final void m10541a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImagesModel imagesModel = (ImagesModel) obj;
                    if (imagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imagesModel.m10543a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImagesParser.m10627a(imagesModel.w_(), imagesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImagesModel.class, new Serializer());
                }
            }

            public ImagesModel() {
                super(1);
            }

            @Nullable
            private String m10542a() {
                this.f7469d = super.a(this.f7469d, 0);
                return this.f7469d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10544a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10543a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10542a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class ProductCatalogImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7470d;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductCatalogImageModel.class, new Deserializer());
                }

                public Object m10545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductCatalogImageParser.m10629a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productCatalogImageModel = new ProductCatalogImageModel();
                    ((BaseModel) productCatalogImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productCatalogImageModel instanceof Postprocessable) {
                        return ((Postprocessable) productCatalogImageModel).a();
                    }
                    return productCatalogImageModel;
                }
            }

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<ProductCatalogImageModel> {
                public final void m10546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductCatalogImageModel productCatalogImageModel = (ProductCatalogImageModel) obj;
                    if (productCatalogImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productCatalogImageModel.m10547a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productCatalogImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductCatalogImageParser.m10630a(productCatalogImageModel.w_(), productCatalogImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProductCatalogImageModel.class, new Serializer());
                }
            }

            public ProductCatalogImageModel() {
                super(1);
            }

            @Nullable
            public final String m10549a() {
                this.f7470d = super.a(this.f7470d, 0);
                return this.f7470d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10547a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10549a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class ProductImageLargeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7471d;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductImageLargeModel.class, new Deserializer());
                }

                public Object m10550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductImageLargeParser.m10631a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productImageLargeModel = new ProductImageLargeModel();
                    ((BaseModel) productImageLargeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productImageLargeModel instanceof Postprocessable) {
                        return ((Postprocessable) productImageLargeModel).a();
                    }
                    return productImageLargeModel;
                }
            }

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<ProductImageLargeModel> {
                public final void m10551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductImageLargeModel productImageLargeModel = (ProductImageLargeModel) obj;
                    if (productImageLargeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productImageLargeModel.m10552a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productImageLargeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductImageLargeParser.m10632a(productImageLargeModel.w_(), productImageLargeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProductImageLargeModel.class, new Serializer());
                }
            }

            public ProductImageLargeModel() {
                super(1);
            }

            @Nullable
            public final String m10554a() {
                this.f7471d = super.a(this.f7471d, 0);
                return this.f7471d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10552a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10554a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: previous_privacy */
        public class Serializer extends JsonSerializer<CommerceProductItemModel> {
            public final void m10555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceProductItemModel commerceProductItemModel = (CommerceProductItemModel) obj;
                if (commerceProductItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceProductItemModel.m10559a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceProductItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceProductItemParser.m10634a(commerceProductItemModel.w_(), commerceProductItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceProductItemModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProductItemPriceFieldsModel ct_() {
            return m10558q();
        }

        @Nullable
        public final /* synthetic */ ProductCatalogImageModel m10565d() {
            return m10569m();
        }

        public CommerceProductItemModel() {
            super(11);
        }

        @Nullable
        public final GraphQLCommerceProductVisibility m10563b() {
            this.f7472d = (GraphQLCommerceProductVisibility) super.b(this.f7472d, 0, GraphQLCommerceProductVisibility.class, GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7472d;
        }

        @Nullable
        public final ProductItemPriceFieldsModel m10566j() {
            this.f7473e = (ProductItemPriceFieldsModel) super.a(this.f7473e, 1, ProductItemPriceFieldsModel.class);
            return this.f7473e;
        }

        @Nullable
        private String m10556o() {
            this.f7474f = super.a(this.f7474f, 2);
            return this.f7474f;
        }

        @Nullable
        public final String m10567k() {
            this.f7475g = super.a(this.f7475g, 3);
            return this.f7475g;
        }

        @Nullable
        public final String m10568l() {
            this.f7476h = super.a(this.f7476h, 4);
            return this.f7476h;
        }

        @Nonnull
        private ImmutableList<ImagesModel> m10557p() {
            this.f7477i = super.a(this.f7477i, 5, ImagesModel.class);
            return (ImmutableList) this.f7477i;
        }

        @Nullable
        public final String m10564c() {
            this.f7479k = super.a(this.f7479k, 7);
            return this.f7479k;
        }

        @Nullable
        public final ProductCatalogImageModel m10569m() {
            this.f7480l = (ProductCatalogImageModel) super.a(this.f7480l, 8, ProductCatalogImageModel.class);
            return this.f7480l;
        }

        @Nullable
        public final ProductImageLargeModel m10570n() {
            this.f7481m = (ProductImageLargeModel) super.a(this.f7481m, 9, ProductImageLargeModel.class);
            return this.f7481m;
        }

        @Nullable
        private ProductItemPriceFieldsModel m10558q() {
            this.f7482n = (ProductItemPriceFieldsModel) super.a(this.f7482n, 10, ProductItemPriceFieldsModel.class);
            return this.f7482n;
        }

        @Nullable
        public final String m10561a() {
            return m10568l();
        }

        public final int jK_() {
            return 175920258;
        }

        public final GraphQLVisitableModel m10560a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ProductItemPriceFieldsModel productItemPriceFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10566j() != null) {
                productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m10566j());
                if (m10566j() != productItemPriceFieldsModel) {
                    graphQLVisitableModel = (CommerceProductItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7473e = productItemPriceFieldsModel;
                }
            }
            if (m10557p() != null) {
                Builder a = ModelHelper.a(m10557p(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommerceProductItemModel commerceProductItemModel = (CommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    commerceProductItemModel.f7477i = a.b();
                    graphQLVisitableModel = commerceProductItemModel;
                }
            }
            if (m10569m() != null) {
                ProductCatalogImageModel productCatalogImageModel = (ProductCatalogImageModel) graphQLModelMutatingVisitor.b(m10569m());
                if (m10569m() != productCatalogImageModel) {
                    graphQLVisitableModel = (CommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7480l = productCatalogImageModel;
                }
            }
            if (m10570n() != null) {
                ProductImageLargeModel productImageLargeModel = (ProductImageLargeModel) graphQLModelMutatingVisitor.b(m10570n());
                if (m10570n() != productImageLargeModel) {
                    graphQLVisitableModel = (CommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7481m = productImageLargeModel;
                }
            }
            if (m10558q() != null) {
                productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m10558q());
                if (m10558q() != productItemPriceFieldsModel) {
                    graphQLVisitableModel = (CommerceProductItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7482n = productItemPriceFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10559a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m10563b());
            int a2 = ModelHelper.a(flatBufferBuilder, m10566j());
            int b = flatBufferBuilder.b(m10556o());
            int b2 = flatBufferBuilder.b(m10567k());
            int b3 = flatBufferBuilder.b(m10568l());
            int a3 = ModelHelper.a(flatBufferBuilder, m10557p());
            int b4 = flatBufferBuilder.b(m10564c());
            int a4 = ModelHelper.a(flatBufferBuilder, m10569m());
            int a5 = ModelHelper.a(flatBufferBuilder, m10570n());
            int a6 = ModelHelper.a(flatBufferBuilder, m10558q());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.a(6, this.f7478j);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10562a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7478j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 884747213)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: previous_privacy */
    public final class CommerceStoreFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<CommerceCollectionsModel> f7493d;
        @Nullable
        private CommerceMerchantSettingsModel f7494e;
        @Nullable
        private String f7495f;
        @Nullable
        private String f7496g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -862837341)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class CommerceCollectionsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private CollectionProductItemsModel f7486d;
            @Nullable
            private String f7487e;
            @Nullable
            private String f7488f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 527365724)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: previous_privacy */
            public final class CollectionProductItemsModel extends BaseModel implements GraphQLVisitableModel {
                private int f7484d;
                @Nullable
                private List<EdgesModel> f7485e;

                /* compiled from: previous_privacy */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CollectionProductItemsModel.class, new Deserializer());
                    }

                    public Object m10571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CollectionProductItemsParser.m10636a(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1504010723)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: previous_privacy */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private CommerceProductItemModel f7483d;

                    /* compiled from: previous_privacy */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m10572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m10635b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: previous_privacy */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m10573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m10574a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ZeroUpsellRecoParser.b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    public final CommerceProductItemModel m10575a() {
                        this.f7483d = (CommerceProductItemModel) super.a(this.f7483d, 0, CommerceProductItemModel.class);
                        return this.f7483d;
                    }

                    public final int jK_() {
                        return -1524095118;
                    }

                    public final GraphQLVisitableModel m10576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10575a() != null) {
                            CommerceProductItemModel commerceProductItemModel = (CommerceProductItemModel) graphQLModelMutatingVisitor.b(m10575a());
                            if (m10575a() != commerceProductItemModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f7483d = commerceProductItemModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10574a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m10575a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: previous_privacy */
                public class Serializer extends JsonSerializer<CollectionProductItemsModel> {
                    public final void m10577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) obj;
                        if (collectionProductItemsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(collectionProductItemsModel.m10579a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            collectionProductItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CollectionProductItemsParser.m10637a(collectionProductItemsModel.w_(), collectionProductItemsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CollectionProductItemsModel.class, new Serializer());
                    }
                }

                public CollectionProductItemsModel() {
                    super(2);
                }

                public final int m10578a() {
                    a(0, 0);
                    return this.f7484d;
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m10582j() {
                    this.f7485e = super.a(this.f7485e, 1, EdgesModel.class);
                    return (ImmutableList) this.f7485e;
                }

                public final int jK_() {
                    return -1537844013;
                }

                public final GraphQLVisitableModel m10580a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10582j() != null) {
                        Builder a = ModelHelper.a(m10582j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (CollectionProductItemsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f7485e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10579a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10582j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f7484d, 0);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m10581a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f7484d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceCollectionsModel.class, new Deserializer());
                }

                public Object m10583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceCollectionsParser.m10638b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceCollectionsModel = new CommerceCollectionsModel();
                    ((BaseModel) commerceCollectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceCollectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceCollectionsModel).a();
                    }
                    return commerceCollectionsModel;
                }
            }

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<CommerceCollectionsModel> {
                public final void m10584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceCollectionsModel commerceCollectionsModel = (CommerceCollectionsModel) obj;
                    if (commerceCollectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceCollectionsModel.m10585a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceCollectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceCollectionsParser.m10639b(commerceCollectionsModel.w_(), commerceCollectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceCollectionsModel.class, new Serializer());
                }
            }

            public CommerceCollectionsModel() {
                super(3);
            }

            @Nullable
            public final CollectionProductItemsModel m10588j() {
                this.f7486d = (CollectionProductItemsModel) super.a(this.f7486d, 0, CollectionProductItemsModel.class);
                return this.f7486d;
            }

            @Nullable
            public final String m10589k() {
                this.f7487e = super.a(this.f7487e, 1);
                return this.f7487e;
            }

            @Nullable
            public final String m10590l() {
                this.f7488f = super.a(this.f7488f, 2);
                return this.f7488f;
            }

            @Nullable
            public final String m10587a() {
                return m10589k();
            }

            public final int jK_() {
                return -1187196444;
            }

            public final GraphQLVisitableModel m10586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10588j() != null) {
                    CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) graphQLModelMutatingVisitor.b(m10588j());
                    if (m10588j() != collectionProductItemsModel) {
                        graphQLVisitableModel = (CommerceCollectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7486d = collectionProductItemsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10585a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10588j());
                int b = flatBufferBuilder.b(m10589k());
                int b2 = flatBufferBuilder.b(m10590l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 855604852)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: previous_privacy */
        public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7489d;
            private boolean f7490e;
            private int f7491f;
            private boolean f7492g;

            /* compiled from: previous_privacy */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                }

                public Object m10591a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceMerchantSettingsParser.m10640a(jsonParser, flatBufferBuilder));
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

            /* compiled from: previous_privacy */
            public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                public final void m10592a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                    if (commerceMerchantSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceMerchantSettingsModel.m10593a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceMerchantSettingsParser.m10641a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                }
            }

            public CommerceMerchantSettingsModel() {
                super(4);
            }

            @Nullable
            public final String m10597j() {
                this.f7489d = super.a(this.f7489d, 0);
                return this.f7489d;
            }

            public final boolean m10598k() {
                a(0, 1);
                return this.f7490e;
            }

            public final int m10599l() {
                a(0, 2);
                return this.f7491f;
            }

            public final boolean m10600m() {
                a(0, 3);
                return this.f7492g;
            }

            @Nullable
            public final String m10595a() {
                return m10597j();
            }

            public final int jK_() {
                return -1128014042;
            }

            public final GraphQLVisitableModel m10594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10593a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10597j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f7490e);
                flatBufferBuilder.a(2, this.f7491f, 0);
                flatBufferBuilder.a(3, this.f7492g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10596a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f7490e = mutableFlatBuffer.a(i, 1);
                this.f7491f = mutableFlatBuffer.a(i, 2, 0);
                this.f7492g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: previous_privacy */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceStoreFragmentModel.class, new Deserializer());
            }

            public Object m10601a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceStoreFragmentParser.m10642a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceStoreFragmentModel = new CommerceStoreFragmentModel();
                ((BaseModel) commerceStoreFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceStoreFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceStoreFragmentModel).a();
                }
                return commerceStoreFragmentModel;
            }
        }

        /* compiled from: previous_privacy */
        public class Serializer extends JsonSerializer<CommerceStoreFragmentModel> {
            public final void m10602a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceStoreFragmentModel commerceStoreFragmentModel = (CommerceStoreFragmentModel) obj;
                if (commerceStoreFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceStoreFragmentModel.m10604a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceStoreFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceStoreFragmentParser.m10643a(commerceStoreFragmentModel.w_(), commerceStoreFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceStoreFragmentModel.class, new Serializer());
            }
        }

        public CommerceStoreFragmentModel() {
            super(4);
        }

        @Nonnull
        public final ImmutableList<CommerceCollectionsModel> m10606a() {
            this.f7493d = super.a(this.f7493d, 0, CommerceCollectionsModel.class);
            return (ImmutableList) this.f7493d;
        }

        @Nullable
        public final CommerceMerchantSettingsModel m10607j() {
            this.f7494e = (CommerceMerchantSettingsModel) super.a(this.f7494e, 1, CommerceMerchantSettingsModel.class);
            return this.f7494e;
        }

        @Nullable
        public final String m10608k() {
            this.f7495f = super.a(this.f7495f, 2);
            return this.f7495f;
        }

        @Nullable
        private String m10603l() {
            this.f7496g = super.a(this.f7496g, 3);
            return this.f7496g;
        }

        public final int jK_() {
            return 308731558;
        }

        public final GraphQLVisitableModel m10605a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            CommerceMerchantSettingsModel commerceMerchantSettingsModel;
            h();
            if (m10606a() != null) {
                Builder a = ModelHelper.a(m10606a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommerceStoreFragmentModel commerceStoreFragmentModel = (CommerceStoreFragmentModel) ModelHelper.a(null, this);
                    commerceStoreFragmentModel.f7493d = a.b();
                    graphQLVisitableModel = commerceStoreFragmentModel;
                    if (m10607j() != null) {
                        commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m10607j());
                        if (m10607j() != commerceMerchantSettingsModel) {
                            graphQLVisitableModel = (CommerceStoreFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7494e = commerceMerchantSettingsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m10607j() != null) {
                commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m10607j());
                if (m10607j() != commerceMerchantSettingsModel) {
                    graphQLVisitableModel = (CommerceStoreFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7494e = commerceMerchantSettingsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m10604a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10606a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10607j());
            int b = flatBufferBuilder.b(m10608k());
            int b2 = flatBufferBuilder.b(m10603l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1377760999)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: previous_privacy */
    public final class ProductItemPriceFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f7499d;
        @Nullable
        private String f7500e;

        /* compiled from: previous_privacy */
        public final class Builder {
            public int f7497a;
            @Nullable
            public String f7498b;

            public final Builder m10609a(int i) {
                this.f7497a = i;
                return this;
            }

            public final Builder m10610a(@Nullable String str) {
                this.f7498b = str;
                return this;
            }

            public final ProductItemPriceFieldsModel m10611a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f7498b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f7497a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProductItemPriceFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: previous_privacy */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductItemPriceFieldsModel.class, new Deserializer());
            }

            public Object m10612a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProductItemPriceFieldsParser.m10644a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object productItemPriceFieldsModel = new ProductItemPriceFieldsModel();
                ((BaseModel) productItemPriceFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (productItemPriceFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) productItemPriceFieldsModel).a();
                }
                return productItemPriceFieldsModel;
            }
        }

        /* compiled from: previous_privacy */
        public class Serializer extends JsonSerializer<ProductItemPriceFieldsModel> {
            public final void m10613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProductItemPriceFieldsModel productItemPriceFieldsModel = (ProductItemPriceFieldsModel) obj;
                if (productItemPriceFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productItemPriceFieldsModel.m10616a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productItemPriceFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProductItemPriceFieldsParser.m10645a(productItemPriceFieldsModel.w_(), productItemPriceFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ProductItemPriceFieldsModel.class, new Serializer());
            }
        }

        public ProductItemPriceFieldsModel() {
            super(2);
        }

        public ProductItemPriceFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m10615a() {
            a(0, 0);
            return this.f7499d;
        }

        @Nullable
        public final String m10619b() {
            this.f7500e = super.a(this.f7500e, 1);
            return this.f7500e;
        }

        public static ProductItemPriceFieldsModel m10614a(ProductItemPriceFieldsModel productItemPriceFieldsModel) {
            if (productItemPriceFieldsModel == null) {
                return null;
            }
            if (productItemPriceFieldsModel instanceof ProductItemPriceFieldsModel) {
                return productItemPriceFieldsModel;
            }
            Builder builder = new Builder();
            builder.f7497a = productItemPriceFieldsModel.m10615a();
            builder.f7498b = productItemPriceFieldsModel.m10619b();
            return builder.m10611a();
        }

        public final int jK_() {
            return -1840781335;
        }

        public final GraphQLVisitableModel m10617a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10616a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10619b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f7499d, 0);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10618a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7499d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}
