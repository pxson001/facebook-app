package com.facebook.commerce.storefront.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceMerchantPageFragmentModel.PageLikersModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceMerchantPageFragmentModel.ProfilePictureModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontQueryParsers.FetchStorefrontQueryParser;
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
import com.facebook.graphql.enums.GraphQLPageCategoryType;
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
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: count_guest_statuses_viewed */
public class FetchStorefrontQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1217796414)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: count_guest_statuses_viewed */
    public final class FetchStorefrontQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f15754d;
        private boolean f15755e;
        @Nullable
        private List<String> f15756f;
        @Nullable
        private GraphQLPageCategoryType f15757g;
        @Nullable
        private CommerceStoreFragmentModel f15758h;
        private boolean f15759i;
        @Nullable
        private String f15760j;
        @Nullable
        private String f15761k;
        @Nullable
        private PageLikersModel f15762l;
        @Nullable
        private ProfilePictureModel f15763m;

        /* compiled from: count_guest_statuses_viewed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchStorefrontQueryModel.class, new Deserializer());
            }

            public Object m16236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchStorefrontQueryParser.m16252a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchStorefrontQueryModel = new FetchStorefrontQueryModel();
                ((BaseModel) fetchStorefrontQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchStorefrontQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchStorefrontQueryModel).a();
                }
                return fetchStorefrontQueryModel;
            }
        }

        /* compiled from: count_guest_statuses_viewed */
        public class Serializer extends JsonSerializer<FetchStorefrontQueryModel> {
            public final void m16237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchStorefrontQueryModel fetchStorefrontQueryModel = (FetchStorefrontQueryModel) obj;
                if (fetchStorefrontQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchStorefrontQueryModel.m16240a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchStorefrontQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchStorefrontQueryParser.m16253a(fetchStorefrontQueryModel.w_(), fetchStorefrontQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchStorefrontQueryModel.class, new Serializer());
            }
        }

        public FetchStorefrontQueryModel() {
            super(10);
        }

        public final void m16244a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16245a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16238p() {
            if (this.b != null && this.f15754d == null) {
                this.f15754d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f15754d;
        }

        @Nonnull
        public final ImmutableList<String> m16246j() {
            this.f15756f = super.a(this.f15756f, 2);
            return (ImmutableList) this.f15756f;
        }

        @Nullable
        private GraphQLPageCategoryType m16239q() {
            this.f15757g = (GraphQLPageCategoryType) super.b(this.f15757g, 3, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f15757g;
        }

        @Nullable
        public final CommerceStoreFragmentModel m16247k() {
            this.f15758h = (CommerceStoreFragmentModel) super.a(this.f15758h, 4, CommerceStoreFragmentModel.class);
            return this.f15758h;
        }

        @Nullable
        public final String m16248l() {
            this.f15760j = super.a(this.f15760j, 6);
            return this.f15760j;
        }

        @Nullable
        public final String m16249m() {
            this.f15761k = super.a(this.f15761k, 7);
            return this.f15761k;
        }

        @Nullable
        public final PageLikersModel m16250n() {
            this.f15762l = (PageLikersModel) super.a(this.f15762l, 8, PageLikersModel.class);
            return this.f15762l;
        }

        @Nullable
        public final ProfilePictureModel m16251o() {
            this.f15763m = (ProfilePictureModel) super.a(this.f15763m, 9, ProfilePictureModel.class);
            return this.f15763m;
        }

        @Nullable
        public final String m16242a() {
            return m16248l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16247k() != null) {
                CommerceStoreFragmentModel commerceStoreFragmentModel = (CommerceStoreFragmentModel) graphQLModelMutatingVisitor.b(m16247k());
                if (m16247k() != commerceStoreFragmentModel) {
                    graphQLVisitableModel = (FetchStorefrontQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15758h = commerceStoreFragmentModel;
                }
            }
            if (m16250n() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m16250n());
                if (m16250n() != pageLikersModel) {
                    graphQLVisitableModel = (FetchStorefrontQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15762l = pageLikersModel;
                }
            }
            if (m16251o() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m16251o());
                if (m16251o() != profilePictureModel) {
                    graphQLVisitableModel = (FetchStorefrontQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15763m = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16240a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16238p());
            int c = flatBufferBuilder.c(m16246j());
            int a2 = flatBufferBuilder.a(m16239q());
            int a3 = ModelHelper.a(flatBufferBuilder, m16247k());
            int b = flatBufferBuilder.b(m16248l());
            int b2 = flatBufferBuilder.b(m16249m());
            int a4 = ModelHelper.a(flatBufferBuilder, m16250n());
            int a5 = ModelHelper.a(flatBufferBuilder, m16251o());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15755e);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, this.f15759i);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15755e = mutableFlatBuffer.a(i, 1);
            this.f15759i = mutableFlatBuffer.a(i, 5);
        }
    }
}
