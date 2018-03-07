package com.facebook.reviews.protocol.graphql;

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
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsParsers.PageOverallStarRatingParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.OverallRatingAndViewerReviewStoryParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.OverallRatingAndViewerReviewStoryParser.ViewerRecommendationParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.ReviewsFeedHeaderParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.ReviewsFeedStoriesParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.ReviewsFeedStoriesParser.ReviewFeedStoriesParser;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryParsers.ReviewsFeedStoriesParser.ReviewFeedStoriesParser.EdgesParser;
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

/* compiled from: setInitialTargetData */
public class ReviewsFeedQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 775487100)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialTargetData */
    public final class OverallRatingAndViewerReviewStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageOverallStarRatingModel f4711d;
        @Nullable
        private ViewerRecommendationModel f4712e;

        /* compiled from: setInitialTargetData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OverallRatingAndViewerReviewStoryModel.class, new Deserializer());
            }

            public Object m7338a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OverallRatingAndViewerReviewStoryParser.m7392a(jsonParser);
                Object overallRatingAndViewerReviewStoryModel = new OverallRatingAndViewerReviewStoryModel();
                ((BaseModel) overallRatingAndViewerReviewStoryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (overallRatingAndViewerReviewStoryModel instanceof Postprocessable) {
                    return ((Postprocessable) overallRatingAndViewerReviewStoryModel).a();
                }
                return overallRatingAndViewerReviewStoryModel;
            }
        }

        /* compiled from: setInitialTargetData */
        public class Serializer extends JsonSerializer<OverallRatingAndViewerReviewStoryModel> {
            public final void m7339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OverallRatingAndViewerReviewStoryModel overallRatingAndViewerReviewStoryModel = (OverallRatingAndViewerReviewStoryModel) obj;
                if (overallRatingAndViewerReviewStoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(overallRatingAndViewerReviewStoryModel.m7345a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    overallRatingAndViewerReviewStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = overallRatingAndViewerReviewStoryModel.w_();
                int u_ = overallRatingAndViewerReviewStoryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    PageOverallStarRatingParser.m7162a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer_recommendation");
                    ViewerRecommendationParser.m7391a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OverallRatingAndViewerReviewStoryModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1090867653)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setInitialTargetData */
        public final class ViewerRecommendationModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLStory f4710d;

            /* compiled from: setInitialTargetData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerRecommendationModel.class, new Deserializer());
                }

                public Object m7340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerRecommendationParser.m7390a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerRecommendationModel = new ViewerRecommendationModel();
                    ((BaseModel) viewerRecommendationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerRecommendationModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerRecommendationModel).a();
                    }
                    return viewerRecommendationModel;
                }
            }

            /* compiled from: setInitialTargetData */
            public class Serializer extends JsonSerializer<ViewerRecommendationModel> {
                public final void m7341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerRecommendationModel viewerRecommendationModel = (ViewerRecommendationModel) obj;
                    if (viewerRecommendationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerRecommendationModel.m7342a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerRecommendationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerRecommendationParser.m7391a(viewerRecommendationModel.w_(), viewerRecommendationModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerRecommendationModel.class, new Serializer());
                }
            }

            public ViewerRecommendationModel() {
                super(1);
            }

            @Nullable
            public final GraphQLStory m7343a() {
                this.f4710d = (GraphQLStory) super.a(this.f4710d, 0, GraphQLStory.class);
                return this.f4710d;
            }

            public final int jK_() {
                return -131209055;
            }

            public final GraphQLVisitableModel m7344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7343a() != null) {
                    GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7343a());
                    if (m7343a() != graphQLStory) {
                        graphQLVisitableModel = (ViewerRecommendationModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4710d = graphQLStory;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7342a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7343a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public OverallRatingAndViewerReviewStoryModel() {
            super(2);
        }

        public final void m7348a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7349a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PageOverallStarRatingModel m7347a() {
            this.f4711d = (PageOverallStarRatingModel) super.a(this.f4711d, 0, PageOverallStarRatingModel.class);
            return this.f4711d;
        }

        @Nullable
        public final ViewerRecommendationModel m7350j() {
            this.f4712e = (ViewerRecommendationModel) super.a(this.f4712e, 1, ViewerRecommendationModel.class);
            return this.f4712e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7346a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7347a() != null) {
                PageOverallStarRatingModel pageOverallStarRatingModel = (PageOverallStarRatingModel) graphQLModelMutatingVisitor.b(m7347a());
                if (m7347a() != pageOverallStarRatingModel) {
                    graphQLVisitableModel = (OverallRatingAndViewerReviewStoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4711d = pageOverallStarRatingModel;
                }
            }
            if (m7350j() != null) {
                ViewerRecommendationModel viewerRecommendationModel = (ViewerRecommendationModel) graphQLModelMutatingVisitor.b(m7350j());
                if (m7350j() != viewerRecommendationModel) {
                    graphQLVisitableModel = (OverallRatingAndViewerReviewStoryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4712e = viewerRecommendationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7345a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7347a());
            int a2 = ModelHelper.a(flatBufferBuilder, m7350j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 290653273)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setInitialTargetData */
    public final class ReviewsFeedHeaderModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f4714d;
        @Nullable
        private PageOverallStarRatingModel f4715e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f4716f;
        @Nullable
        private ViewerRecommendationModel f4717g;

        /* compiled from: setInitialTargetData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewsFeedHeaderModel.class, new Deserializer());
            }

            public Object m7351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReviewsFeedHeaderParser.m7395a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reviewsFeedHeaderModel = new ReviewsFeedHeaderModel();
                ((BaseModel) reviewsFeedHeaderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reviewsFeedHeaderModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewsFeedHeaderModel).a();
                }
                return reviewsFeedHeaderModel;
            }
        }

        /* compiled from: setInitialTargetData */
        public class Serializer extends JsonSerializer<ReviewsFeedHeaderModel> {
            public final void m7352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReviewsFeedHeaderModel reviewsFeedHeaderModel = (ReviewsFeedHeaderModel) obj;
                if (reviewsFeedHeaderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewsFeedHeaderModel.m7362a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewsFeedHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reviewsFeedHeaderModel.w_();
                int u_ = reviewsFeedHeaderModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_rate");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    PageOverallStarRatingParser.m7162a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("spotlight_snippets_message");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("viewer_recommendation");
                    ReviewsFeedHeaderParser.ViewerRecommendationParser.m7394a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReviewsFeedHeaderModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setInitialTargetData */
        public final class ViewerRecommendationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f4713d;

            /* compiled from: setInitialTargetData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerRecommendationModel.class, new Deserializer());
                }

                public Object m7353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewsFeedHeaderParser.ViewerRecommendationParser.m7393a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerRecommendationModel = new ViewerRecommendationModel();
                    ((BaseModel) viewerRecommendationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerRecommendationModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerRecommendationModel).a();
                    }
                    return viewerRecommendationModel;
                }
            }

            /* compiled from: setInitialTargetData */
            public class Serializer extends JsonSerializer<ViewerRecommendationModel> {
                public final void m7354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerRecommendationModel viewerRecommendationModel = (ViewerRecommendationModel) obj;
                    if (viewerRecommendationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerRecommendationModel.m7356a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerRecommendationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewsFeedHeaderParser.ViewerRecommendationParser.m7394a(viewerRecommendationModel.w_(), viewerRecommendationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerRecommendationModel.class, new Serializer());
                }
            }

            public ViewerRecommendationModel() {
                super(1);
            }

            @Nullable
            private String m7355j() {
                this.f4713d = super.a(this.f4713d, 0);
                return this.f4713d;
            }

            @Nullable
            public final String m7358a() {
                return m7355j();
            }

            public final int jK_() {
                return -131209055;
            }

            public final GraphQLVisitableModel m7357a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7356a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7355j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ PageOverallStarRatingModel m7368b() {
            return m7359j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m7369c() {
            return m7360k();
        }

        @Nullable
        public final /* synthetic */ ViewerRecommendationModel m7370d() {
            return m7361l();
        }

        public ReviewsFeedHeaderModel() {
            super(4);
        }

        public final void m7365a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7366a(String str, Object obj, boolean z) {
        }

        public final boolean m7367a() {
            a(0, 0);
            return this.f4714d;
        }

        @Nullable
        private PageOverallStarRatingModel m7359j() {
            this.f4715e = (PageOverallStarRatingModel) super.a(this.f4715e, 1, PageOverallStarRatingModel.class);
            return this.f4715e;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m7360k() {
            this.f4716f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f4716f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f4716f;
        }

        @Nullable
        private ViewerRecommendationModel m7361l() {
            this.f4717g = (ViewerRecommendationModel) super.a(this.f4717g, 3, ViewerRecommendationModel.class);
            return this.f4717g;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7363a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7359j() != null) {
                PageOverallStarRatingModel pageOverallStarRatingModel = (PageOverallStarRatingModel) graphQLModelMutatingVisitor.b(m7359j());
                if (m7359j() != pageOverallStarRatingModel) {
                    graphQLVisitableModel = (ReviewsFeedHeaderModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4715e = pageOverallStarRatingModel;
                }
            }
            if (m7360k() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m7360k());
                if (m7360k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (ReviewsFeedHeaderModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4716f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m7361l() != null) {
                ViewerRecommendationModel viewerRecommendationModel = (ViewerRecommendationModel) graphQLModelMutatingVisitor.b(m7361l());
                if (m7361l() != viewerRecommendationModel) {
                    graphQLVisitableModel = (ReviewsFeedHeaderModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4717g = viewerRecommendationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7362a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7359j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7360k());
            int a3 = ModelHelper.a(flatBufferBuilder, m7361l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f4714d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7364a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4714d = mutableFlatBuffer.a(i, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -508409784)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialTargetData */
    public final class ReviewsFeedStoriesModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ReviewFeedStoriesModel f4721d;

        /* compiled from: setInitialTargetData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewsFeedStoriesModel.class, new Deserializer());
            }

            public Object m7371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReviewsFeedStoriesParser.m7400a(jsonParser);
                Object reviewsFeedStoriesModel = new ReviewsFeedStoriesModel();
                ((BaseModel) reviewsFeedStoriesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reviewsFeedStoriesModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewsFeedStoriesModel).a();
                }
                return reviewsFeedStoriesModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2108275985)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setInitialTargetData */
        public final class ReviewFeedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f4719d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f4720e;

            /* compiled from: setInitialTargetData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewFeedStoriesModel.class, new Deserializer());
                }

                public Object m7372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewFeedStoriesParser.m7398a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewFeedStoriesModel = new ReviewFeedStoriesModel();
                    ((BaseModel) reviewFeedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewFeedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewFeedStoriesModel).a();
                    }
                    return reviewFeedStoriesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1376866408)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: setInitialTargetData */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLStory f4718d;

                /* compiled from: setInitialTargetData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7396b(jsonParser, flatBufferBuilder));
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

                /* compiled from: setInitialTargetData */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7374a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7375a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7397b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final GraphQLStory m7376a() {
                    this.f4718d = (GraphQLStory) super.a(this.f4718d, 0, GraphQLStory.class);
                    return this.f4718d;
                }

                public final int jK_() {
                    return 943458714;
                }

                public final GraphQLVisitableModel m7377a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7376a() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7376a());
                        if (m7376a() != graphQLStory) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4718d = graphQLStory;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7375a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7376a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: setInitialTargetData */
            public class Serializer extends JsonSerializer<ReviewFeedStoriesModel> {
                public final void m7378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewFeedStoriesModel reviewFeedStoriesModel = (ReviewFeedStoriesModel) obj;
                    if (reviewFeedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewFeedStoriesModel.m7380a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewFeedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewFeedStoriesParser.m7399a(reviewFeedStoriesModel.w_(), reviewFeedStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewFeedStoriesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoTailFields m7383b() {
                return m7379j();
            }

            public ReviewFeedStoriesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m7382a() {
                this.f4719d = super.a(this.f4719d, 0, EdgesModel.class);
                return (ImmutableList) this.f4719d;
            }

            @Nullable
            private DefaultPageInfoTailFieldsModel m7379j() {
                this.f4720e = (DefaultPageInfoTailFieldsModel) super.a(this.f4720e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f4720e;
            }

            public final int jK_() {
                return -512622341;
            }

            public final GraphQLVisitableModel m7381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m7382a() != null) {
                    Builder a = ModelHelper.a(m7382a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReviewFeedStoriesModel reviewFeedStoriesModel = (ReviewFeedStoriesModel) ModelHelper.a(null, this);
                        reviewFeedStoriesModel.f4719d = a.b();
                        graphQLVisitableModel = reviewFeedStoriesModel;
                        if (m7379j() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m7379j());
                            if (m7379j() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (ReviewFeedStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4720e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m7379j() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m7379j());
                    if (m7379j() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (ReviewFeedStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4720e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m7380a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7382a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7379j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setInitialTargetData */
        public class Serializer extends JsonSerializer<ReviewsFeedStoriesModel> {
            public final void m7384a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReviewsFeedStoriesModel reviewsFeedStoriesModel = (ReviewsFeedStoriesModel) obj;
                if (reviewsFeedStoriesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewsFeedStoriesModel.m7385a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewsFeedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reviewsFeedStoriesModel.w_();
                int u_ = reviewsFeedStoriesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("review_feed_stories");
                    ReviewFeedStoriesParser.m7399a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReviewsFeedStoriesModel.class, new Serializer());
            }
        }

        public ReviewsFeedStoriesModel() {
            super(1);
        }

        public final void m7388a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7389a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ReviewFeedStoriesModel m7387a() {
            this.f4721d = (ReviewFeedStoriesModel) super.a(this.f4721d, 0, ReviewFeedStoriesModel.class);
            return this.f4721d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7387a() != null) {
                ReviewFeedStoriesModel reviewFeedStoriesModel = (ReviewFeedStoriesModel) graphQLModelMutatingVisitor.b(m7387a());
                if (m7387a() != reviewFeedStoriesModel) {
                    graphQLVisitableModel = (ReviewsFeedStoriesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4721d = reviewFeedStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7385a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7387a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
