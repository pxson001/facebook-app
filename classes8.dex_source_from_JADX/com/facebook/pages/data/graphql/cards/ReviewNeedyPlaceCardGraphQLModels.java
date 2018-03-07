package com.facebook.pages.data.graphql.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.EntityWithImageFragmentParser;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.EntityWithImageFragmentParser.ImageParser;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.ReviewNeedyPlaceCardQueryParser;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.ReviewNeedyPlaceCardQueryParser.ReviewNeedyPlaceCardParser;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.ReviewWithPillTextWithEntitiesFieldsParser;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLParsers.ReviewWithPillTextWithEntitiesFieldsParser.ImageRangesParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser;
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

/* compiled from: confirmation_success */
public class ReviewNeedyPlaceCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -651016267)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_success */
    public final class EntityWithImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f17046d;
        @Nullable
        private ImageModel f17047e;

        /* compiled from: confirmation_success */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EntityWithImageFragmentModel.class, new Deserializer());
            }

            public Object m20710a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EntityWithImageFragmentParser.m20757a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object entityWithImageFragmentModel = new EntityWithImageFragmentModel();
                ((BaseModel) entityWithImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (entityWithImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) entityWithImageFragmentModel).a();
                }
                return entityWithImageFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_success */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17045d;

            /* compiled from: confirmation_success */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m20711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m20755a(jsonParser, flatBufferBuilder));
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

            /* compiled from: confirmation_success */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m20712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m20713a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m20756a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            public final String m20715a() {
                this.f17045d = super.a(this.f17045d, 0);
                return this.f17045d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m20714a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20713a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20715a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_success */
        public class Serializer extends JsonSerializer<EntityWithImageFragmentModel> {
            public final void m20716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EntityWithImageFragmentModel entityWithImageFragmentModel = (EntityWithImageFragmentModel) obj;
                if (entityWithImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(entityWithImageFragmentModel.m20718a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    entityWithImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EntityWithImageFragmentParser.m20758a(entityWithImageFragmentModel.w_(), entityWithImageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EntityWithImageFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageModel m20721b() {
            return m20717j();
        }

        public EntityWithImageFragmentModel() {
            super(2);
        }

        @Nullable
        public final GraphQLObjectType m20719a() {
            if (this.b != null && this.f17046d == null) {
                this.f17046d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17046d;
        }

        @Nullable
        private ImageModel m20717j() {
            this.f17047e = (ImageModel) super.a(this.f17047e, 1, ImageModel.class);
            return this.f17047e;
        }

        public final int jK_() {
            return 463681394;
        }

        public final GraphQLVisitableModel m20720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20717j() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m20717j());
                if (m20717j() != imageModel) {
                    graphQLVisitableModel = (EntityWithImageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17047e = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20718a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20719a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20717j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 138216573)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: confirmation_success */
    public final class ReviewNeedyPlaceCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ReviewNeedyPlaceCardModel f17050d;
        @Nullable
        private ReviewBasicFieldsModel f17051e;

        /* compiled from: confirmation_success */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewNeedyPlaceCardQueryModel.class, new Deserializer());
            }

            public Object m20722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReviewNeedyPlaceCardQueryParser.m20761a(jsonParser);
                Object reviewNeedyPlaceCardQueryModel = new ReviewNeedyPlaceCardQueryModel();
                ((BaseModel) reviewNeedyPlaceCardQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reviewNeedyPlaceCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewNeedyPlaceCardQueryModel).a();
                }
                return reviewNeedyPlaceCardQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2117476257)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_success */
        public final class ReviewNeedyPlaceCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ReviewWithPillTextWithEntitiesFieldsModel f17048d;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f17049e;

            /* compiled from: confirmation_success */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewNeedyPlaceCardModel.class, new Deserializer());
                }

                public Object m20723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewNeedyPlaceCardParser.m20759a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewNeedyPlaceCardModel = new ReviewNeedyPlaceCardModel();
                    ((BaseModel) reviewNeedyPlaceCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewNeedyPlaceCardModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewNeedyPlaceCardModel).a();
                    }
                    return reviewNeedyPlaceCardModel;
                }
            }

            /* compiled from: confirmation_success */
            public class Serializer extends JsonSerializer<ReviewNeedyPlaceCardModel> {
                public final void m20724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewNeedyPlaceCardModel reviewNeedyPlaceCardModel = (ReviewNeedyPlaceCardModel) obj;
                    if (reviewNeedyPlaceCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewNeedyPlaceCardModel.m20726a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewNeedyPlaceCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewNeedyPlaceCardParser.m20760a(reviewNeedyPlaceCardModel.w_(), reviewNeedyPlaceCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewNeedyPlaceCardModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReviewWithPillTextWithEntitiesFieldsModel m20728a() {
                return m20725k();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m20729b() {
                return m20730j();
            }

            public ReviewNeedyPlaceCardModel() {
                super(2);
            }

            @Nullable
            private ReviewWithPillTextWithEntitiesFieldsModel m20725k() {
                this.f17048d = (ReviewWithPillTextWithEntitiesFieldsModel) super.a(this.f17048d, 0, ReviewWithPillTextWithEntitiesFieldsModel.class);
                return this.f17048d;
            }

            @Nullable
            public final DefaultTextWithEntitiesFieldsModel m20730j() {
                this.f17049e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17049e, 1, DefaultTextWithEntitiesFieldsModel.class);
                return this.f17049e;
            }

            public final int jK_() {
                return 1093207788;
            }

            public final GraphQLVisitableModel m20727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20725k() != null) {
                    ReviewWithPillTextWithEntitiesFieldsModel reviewWithPillTextWithEntitiesFieldsModel = (ReviewWithPillTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m20725k());
                    if (m20725k() != reviewWithPillTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (ReviewNeedyPlaceCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17048d = reviewWithPillTextWithEntitiesFieldsModel;
                    }
                }
                if (m20730j() != null) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m20730j());
                    if (m20730j() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (ReviewNeedyPlaceCardModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17049e = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20726a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20725k());
                int a2 = ModelHelper.a(flatBufferBuilder, m20730j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_success */
        public class Serializer extends JsonSerializer<ReviewNeedyPlaceCardQueryModel> {
            public final void m20731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReviewNeedyPlaceCardQueryModel reviewNeedyPlaceCardQueryModel = (ReviewNeedyPlaceCardQueryModel) obj;
                if (reviewNeedyPlaceCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewNeedyPlaceCardQueryModel.m20733a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewNeedyPlaceCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reviewNeedyPlaceCardQueryModel.w_();
                int u_ = reviewNeedyPlaceCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("review_needy_place_card");
                    ReviewNeedyPlaceCardParser.m20760a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer_recommendation");
                    ReviewBasicFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReviewNeedyPlaceCardQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReviewNeedyPlaceCardModel m20735a() {
            return m20739j();
        }

        @Nullable
        public final /* synthetic */ ReviewBasicFields m20738b() {
            return m20732k();
        }

        public ReviewNeedyPlaceCardQueryModel() {
            super(2);
        }

        public final void m20736a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20737a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ReviewNeedyPlaceCardModel m20739j() {
            this.f17050d = (ReviewNeedyPlaceCardModel) super.a(this.f17050d, 0, ReviewNeedyPlaceCardModel.class);
            return this.f17050d;
        }

        @Nullable
        private ReviewBasicFieldsModel m20732k() {
            this.f17051e = (ReviewBasicFieldsModel) super.a(this.f17051e, 1, ReviewBasicFieldsModel.class);
            return this.f17051e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20734a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20739j() != null) {
                ReviewNeedyPlaceCardModel reviewNeedyPlaceCardModel = (ReviewNeedyPlaceCardModel) graphQLModelMutatingVisitor.b(m20739j());
                if (m20739j() != reviewNeedyPlaceCardModel) {
                    graphQLVisitableModel = (ReviewNeedyPlaceCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17050d = reviewNeedyPlaceCardModel;
                }
            }
            if (m20732k() != null) {
                ReviewBasicFieldsModel reviewBasicFieldsModel = (ReviewBasicFieldsModel) graphQLModelMutatingVisitor.b(m20732k());
                if (m20732k() != reviewBasicFieldsModel) {
                    graphQLVisitableModel = (ReviewNeedyPlaceCardQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17051e = reviewBasicFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20733a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20739j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20732k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1465844641)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_success */
    public final class ReviewWithPillTextWithEntitiesFieldsModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel {
        @Nullable
        private List<ImageRangesModel> f17055d;
        @Nullable
        private String f17056e;

        /* compiled from: confirmation_success */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewWithPillTextWithEntitiesFieldsModel.class, new Deserializer());
            }

            public Object m20740a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReviewWithPillTextWithEntitiesFieldsParser.m20764a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reviewWithPillTextWithEntitiesFieldsModel = new ReviewWithPillTextWithEntitiesFieldsModel();
                ((BaseModel) reviewWithPillTextWithEntitiesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reviewWithPillTextWithEntitiesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewWithPillTextWithEntitiesFieldsModel).a();
                }
                return reviewWithPillTextWithEntitiesFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 981348204)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_success */
        public final class ImageRangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityWithImageFragmentModel f17052d;
            private int f17053e;
            private int f17054f;

            /* compiled from: confirmation_success */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageRangesModel.class, new Deserializer());
                }

                public Object m20741a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageRangesParser.m20762b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageRangesModel = new ImageRangesModel();
                    ((BaseModel) imageRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) imageRangesModel).a();
                    }
                    return imageRangesModel;
                }
            }

            /* compiled from: confirmation_success */
            public class Serializer extends JsonSerializer<ImageRangesModel> {
                public final void m20742a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageRangesModel imageRangesModel = (ImageRangesModel) obj;
                    if (imageRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageRangesModel.m20744a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageRangesParser.m20763b(imageRangesModel.w_(), imageRangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ImageRangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityWithImageFragmentModel m20746a() {
                return m20743j();
            }

            public ImageRangesModel() {
                super(3);
            }

            @Nullable
            private EntityWithImageFragmentModel m20743j() {
                this.f17052d = (EntityWithImageFragmentModel) super.a(this.f17052d, 0, EntityWithImageFragmentModel.class);
                return this.f17052d;
            }

            public final int m20748b() {
                a(0, 1);
                return this.f17053e;
            }

            public final int m20749c() {
                a(0, 2);
                return this.f17054f;
            }

            public final int jK_() {
                return 55835407;
            }

            public final GraphQLVisitableModel m20745a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20743j() != null) {
                    EntityWithImageFragmentModel entityWithImageFragmentModel = (EntityWithImageFragmentModel) graphQLModelMutatingVisitor.b(m20743j());
                    if (m20743j() != entityWithImageFragmentModel) {
                        graphQLVisitableModel = (ImageRangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17052d = entityWithImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20744a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20743j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f17053e, 0);
                flatBufferBuilder.a(2, this.f17054f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20747a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17053e = mutableFlatBuffer.a(i, 1, 0);
                this.f17054f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: confirmation_success */
        public class Serializer extends JsonSerializer<ReviewWithPillTextWithEntitiesFieldsModel> {
            public final void m20750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReviewWithPillTextWithEntitiesFieldsModel reviewWithPillTextWithEntitiesFieldsModel = (ReviewWithPillTextWithEntitiesFieldsModel) obj;
                if (reviewWithPillTextWithEntitiesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewWithPillTextWithEntitiesFieldsModel.m20751a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewWithPillTextWithEntitiesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReviewWithPillTextWithEntitiesFieldsParser.m20765a(reviewWithPillTextWithEntitiesFieldsModel.w_(), reviewWithPillTextWithEntitiesFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReviewWithPillTextWithEntitiesFieldsModel.class, new Serializer());
            }
        }

        public ReviewWithPillTextWithEntitiesFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<ImageRangesModel> m20754b() {
            this.f17055d = super.a(this.f17055d, 0, ImageRangesModel.class);
            return (ImmutableList) this.f17055d;
        }

        @Nullable
        public final String m20753a() {
            this.f17056e = super.a(this.f17056e, 1);
            return this.f17056e;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m20752a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20754b() != null) {
                Builder a = ModelHelper.a(m20754b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ReviewWithPillTextWithEntitiesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17055d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20751a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20754b());
            int b = flatBufferBuilder.b(m20753a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
