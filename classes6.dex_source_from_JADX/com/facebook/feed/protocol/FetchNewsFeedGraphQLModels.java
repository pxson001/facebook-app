package com.facebook.feed.protocol;

import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLModels.SponsoredDataFieldsModel;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLParsers.SponsoredDataFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithRangesModel;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitFieldsParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitFieldsParser.CoverPhotoParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitFieldsParser.CoverPhotoParser.FocusParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitFieldsParser.CoverPhotoParser.PhotoParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitSubFieldsParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitSubFieldsParser.BestDescriptionParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.CommonProfileFeedUnitSubFieldsParser.PageLikersParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.DefaultPageInfoFieldsStreamingParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser.ContentSetParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser.ContentSetParser.NodesParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser.ContentSetParser.NodesParser.AttachmentsParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser.ContentSetParser.NodesParser.AttachmentsParser.MediaParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PagesYouMayLikeFeedUnitItemParser.ContentSetParser.NodesParser.AttachmentsParser.MediaParser.ImageParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PeopleYouMayKnowFeedUnitItemParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PeopleYouMayKnowFeedUnitItemParser.ProfileParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PeopleYouMayKnowFeedUnitItemParser.ProfileParser.MutualFriendsParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.PeopleYouMayKnowFeedUnitItemParser.ProfileParser.StructuredNamesParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.TrueTopicFeedOptionFragmentParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.TrueTopicFeedOptionFragmentParser.OptionIconParser;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.TrueTopicFeedOptionFragmentParser.TopicFeedOptionParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: model */
public class FetchNewsFeedGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2031380948)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class CommonProfileFeedUnitFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10233d;
        @Nullable
        private BestDescriptionModel f10234e;
        @Nullable
        private List<String> f10235f;
        @Nullable
        private CoverPhotoModel f10236g;
        private boolean f10237h;
        @Nullable
        private String f10238i;
        @Nullable
        private String f10239j;
        @Nullable
        private PageLikersModel f10240k;
        @Nullable
        private DefaultImageFieldsModel f10241l;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -36441255)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FocusModel f10231d;
            @Nullable
            private PhotoModel f10232e;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m16025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m16210a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -496435496)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: model */
            public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
                private double f10228d;
                private double f10229e;

                /* compiled from: model */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                    }

                    public Object m16026a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FocusParser.m16206a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object focusModel = new FocusModel();
                        ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (focusModel instanceof Postprocessable) {
                            return ((Postprocessable) focusModel).a();
                        }
                        return focusModel;
                    }
                }

                /* compiled from: model */
                public class Serializer extends JsonSerializer<FocusModel> {
                    public final void m16027a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FocusModel focusModel = (FocusModel) obj;
                        if (focusModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(focusModel.m16028a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FocusParser.m16207a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FocusModel.class, new Serializer());
                    }
                }

                public FocusModel() {
                    super(2);
                }

                public final int jK_() {
                    return 82530482;
                }

                public final GraphQLVisitableModel m16029a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16028a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f10228d, 0.0d);
                    flatBufferBuilder.a(1, this.f10229e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16030a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10228d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f10229e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -517249548)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: model */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultImageFieldsModel f10230d;

                /* compiled from: model */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m16031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m16208a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object photoModel = new PhotoModel();
                        ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (photoModel instanceof Postprocessable) {
                            return ((Postprocessable) photoModel).a();
                        }
                        return photoModel;
                    }
                }

                /* compiled from: model */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m16032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m16034a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m16209a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(1);
                }

                @Nullable
                private DefaultImageFieldsModel m16033a() {
                    this.f10230d = (DefaultImageFieldsModel) super.a(this.f10230d, 0, DefaultImageFieldsModel.class);
                    return this.f10230d;
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m16035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16033a() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16033a());
                        if (m16033a() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10230d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16034a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16033a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m16036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m16039a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m16211a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(2);
            }

            @Nullable
            private FocusModel m16037a() {
                this.f10231d = (FocusModel) super.a(this.f10231d, 0, FocusModel.class);
                return this.f10231d;
            }

            @Nullable
            private PhotoModel m16038j() {
                this.f10232e = (PhotoModel) super.a(this.f10232e, 1, PhotoModel.class);
                return this.f10232e;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m16040a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16037a() != null) {
                    FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m16037a());
                    if (m16037a() != focusModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10231d = focusModel;
                    }
                }
                if (m16038j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m16038j());
                    if (m16038j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10232e = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16039a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16037a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16038j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommonProfileFeedUnitFieldsModel.class, new Deserializer());
            }

            public Object m16041a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommonProfileFeedUnitFieldsParser.m16212a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commonProfileFeedUnitFieldsModel = new CommonProfileFeedUnitFieldsModel();
                ((BaseModel) commonProfileFeedUnitFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commonProfileFeedUnitFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commonProfileFeedUnitFieldsModel).a();
                }
                return commonProfileFeedUnitFieldsModel;
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<CommonProfileFeedUnitFieldsModel> {
            public final void m16042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommonProfileFeedUnitFieldsModel commonProfileFeedUnitFieldsModel = (CommonProfileFeedUnitFieldsModel) obj;
                if (commonProfileFeedUnitFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commonProfileFeedUnitFieldsModel.m16053a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commonProfileFeedUnitFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommonProfileFeedUnitFieldsParser.m16213a(commonProfileFeedUnitFieldsModel.w_(), commonProfileFeedUnitFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommonProfileFeedUnitFieldsModel.class, new Serializer());
            }
        }

        public CommonProfileFeedUnitFieldsModel() {
            super(9);
        }

        public final void m16057a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16048n());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16058a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m16043a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private GraphQLObjectType m16044j() {
            if (this.b != null && this.f10233d == null) {
                this.f10233d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10233d;
        }

        @Nullable
        private BestDescriptionModel m16045k() {
            this.f10234e = (BestDescriptionModel) super.a(this.f10234e, 1, BestDescriptionModel.class);
            return this.f10234e;
        }

        @Nonnull
        private ImmutableList<String> m16046l() {
            this.f10235f = super.a(this.f10235f, 2);
            return (ImmutableList) this.f10235f;
        }

        @Nullable
        private CoverPhotoModel m16047m() {
            this.f10236g = (CoverPhotoModel) super.a(this.f10236g, 3, CoverPhotoModel.class);
            return this.f10236g;
        }

        private boolean m16048n() {
            a(0, 4);
            return this.f10237h;
        }

        private void m16043a(boolean z) {
            this.f10237h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        @Nullable
        private String m16049o() {
            this.f10238i = super.a(this.f10238i, 5);
            return this.f10238i;
        }

        @Nullable
        private String m16050p() {
            this.f10239j = super.a(this.f10239j, 6);
            return this.f10239j;
        }

        @Nullable
        private PageLikersModel m16051q() {
            this.f10240k = (PageLikersModel) super.a(this.f10240k, 7, PageLikersModel.class);
            return this.f10240k;
        }

        @Nullable
        private DefaultImageFieldsModel m16052r() {
            this.f10241l = (DefaultImageFieldsModel) super.a(this.f10241l, 8, DefaultImageFieldsModel.class);
            return this.f10241l;
        }

        @Nullable
        public final String m16055a() {
            return m16049o();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m16054a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16045k() != null) {
                BestDescriptionModel bestDescriptionModel = (BestDescriptionModel) graphQLModelMutatingVisitor.b(m16045k());
                if (m16045k() != bestDescriptionModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10234e = bestDescriptionModel;
                }
            }
            if (m16047m() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m16047m());
                if (m16047m() != coverPhotoModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10236g = coverPhotoModel;
                }
            }
            if (m16051q() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m16051q());
                if (m16051q() != pageLikersModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10240k = pageLikersModel;
                }
            }
            if (m16052r() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16052r());
                if (m16052r() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10241l = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16053a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16044j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16045k());
            int c = flatBufferBuilder.c(m16046l());
            int a3 = ModelHelper.a(flatBufferBuilder, m16047m());
            int b = flatBufferBuilder.b(m16049o());
            int b2 = flatBufferBuilder.b(m16050p());
            int a4 = ModelHelper.a(flatBufferBuilder, m16051q());
            int a5 = ModelHelper.a(flatBufferBuilder, m16052r());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.a(4, this.f10237h);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16056a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10237h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2061510323)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class CommonProfileFeedUnitSubFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10244d;
        @Nullable
        private BestDescriptionModel f10245e;
        @Nullable
        private List<String> f10246f;
        private boolean f10247g;
        @Nullable
        private String f10248h;
        @Nullable
        private String f10249i;
        @Nullable
        private PageLikersModel f10250j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class BestDescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10242d;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BestDescriptionModel.class, new Deserializer());
                }

                public Object m16059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BestDescriptionParser.m16214a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bestDescriptionModel = new BestDescriptionModel();
                    ((BaseModel) bestDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bestDescriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) bestDescriptionModel).a();
                    }
                    return bestDescriptionModel;
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<BestDescriptionModel> {
                public final void m16060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BestDescriptionModel bestDescriptionModel = (BestDescriptionModel) obj;
                    if (bestDescriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bestDescriptionModel.m16062a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bestDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BestDescriptionParser.m16215a(bestDescriptionModel.w_(), bestDescriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BestDescriptionModel.class, new Serializer());
                }
            }

            public BestDescriptionModel() {
                super(1);
            }

            @Nullable
            private String m16061a() {
                this.f10242d = super.a(this.f10242d, 0);
                return this.f10242d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m16063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16062a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16061a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommonProfileFeedUnitSubFieldsModel.class, new Deserializer());
            }

            public Object m16064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommonProfileFeedUnitSubFieldsParser.m16218a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commonProfileFeedUnitSubFieldsModel = new CommonProfileFeedUnitSubFieldsModel();
                ((BaseModel) commonProfileFeedUnitSubFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commonProfileFeedUnitSubFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commonProfileFeedUnitSubFieldsModel).a();
                }
                return commonProfileFeedUnitSubFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f10243d;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m16065a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m16216a(jsonParser, flatBufferBuilder));
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

            /* compiled from: model */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m16066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m16067a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m16217a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m16068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16067a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f10243d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16069a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10243d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<CommonProfileFeedUnitSubFieldsModel> {
            public final void m16070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommonProfileFeedUnitSubFieldsModel commonProfileFeedUnitSubFieldsModel = (CommonProfileFeedUnitSubFieldsModel) obj;
                if (commonProfileFeedUnitSubFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commonProfileFeedUnitSubFieldsModel.m16079a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commonProfileFeedUnitSubFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commonProfileFeedUnitSubFieldsModel.w_();
                int u_ = commonProfileFeedUnitSubFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("best_description");
                    BestDescriptionParser.m16215a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 2), jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m16217a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommonProfileFeedUnitSubFieldsModel.class, new Serializer());
            }
        }

        public CommonProfileFeedUnitSubFieldsModel() {
            super(7);
        }

        public final void m16083a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16075m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16084a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m16071a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private GraphQLObjectType m16072j() {
            if (this.b != null && this.f10244d == null) {
                this.f10244d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10244d;
        }

        @Nullable
        private BestDescriptionModel m16073k() {
            this.f10245e = (BestDescriptionModel) super.a(this.f10245e, 1, BestDescriptionModel.class);
            return this.f10245e;
        }

        @Nonnull
        private ImmutableList<String> m16074l() {
            this.f10246f = super.a(this.f10246f, 2);
            return (ImmutableList) this.f10246f;
        }

        private boolean m16075m() {
            a(0, 3);
            return this.f10247g;
        }

        private void m16071a(boolean z) {
            this.f10247g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        @Nullable
        private String m16076n() {
            this.f10248h = super.a(this.f10248h, 4);
            return this.f10248h;
        }

        @Nullable
        private String m16077o() {
            this.f10249i = super.a(this.f10249i, 5);
            return this.f10249i;
        }

        @Nullable
        private PageLikersModel m16078p() {
            this.f10250j = (PageLikersModel) super.a(this.f10250j, 6, PageLikersModel.class);
            return this.f10250j;
        }

        @Nullable
        public final String m16081a() {
            return m16076n();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m16080a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16073k() != null) {
                BestDescriptionModel bestDescriptionModel = (BestDescriptionModel) graphQLModelMutatingVisitor.b(m16073k());
                if (m16073k() != bestDescriptionModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitSubFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10245e = bestDescriptionModel;
                }
            }
            if (m16078p() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m16078p());
                if (m16078p() != pageLikersModel) {
                    graphQLVisitableModel = (CommonProfileFeedUnitSubFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10250j = pageLikersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16079a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16072j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16073k());
            int c = flatBufferBuilder.c(m16074l());
            int b = flatBufferBuilder.b(m16076n());
            int b2 = flatBufferBuilder.b(m16077o());
            int a3 = ModelHelper.a(flatBufferBuilder, m16078p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.a(3, this.f10247g);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16082a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10247g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 921619519)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class DefaultPageInfoFieldsStreamingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f10251d;
        private boolean f10252e;
        private boolean f10253f;
        @Nullable
        private String f10254g;

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultPageInfoFieldsStreamingModel.class, new Deserializer());
            }

            public Object m16085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultPageInfoFieldsStreamingParser.m16219a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultPageInfoFieldsStreamingModel = new DefaultPageInfoFieldsStreamingModel();
                ((BaseModel) defaultPageInfoFieldsStreamingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultPageInfoFieldsStreamingModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultPageInfoFieldsStreamingModel).a();
                }
                return defaultPageInfoFieldsStreamingModel;
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<DefaultPageInfoFieldsStreamingModel> {
            public final void m16086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultPageInfoFieldsStreamingModel defaultPageInfoFieldsStreamingModel = (DefaultPageInfoFieldsStreamingModel) obj;
                if (defaultPageInfoFieldsStreamingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultPageInfoFieldsStreamingModel.m16087a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultPageInfoFieldsStreamingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultPageInfoFieldsStreamingParser.m16220a(defaultPageInfoFieldsStreamingModel.w_(), defaultPageInfoFieldsStreamingModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultPageInfoFieldsStreamingModel.class, new Serializer());
            }
        }

        public DefaultPageInfoFieldsStreamingModel() {
            super(4);
        }

        @Nullable
        public final String m16089a() {
            this.f10251d = super.a(this.f10251d, 0);
            return this.f10251d;
        }

        public final boolean m16091b() {
            a(0, 1);
            return this.f10252e;
        }

        public final boolean m16092c() {
            a(0, 2);
            return this.f10253f;
        }

        @Nullable
        public final String m16093d() {
            this.f10254g = super.a(this.f10254g, 3);
            return this.f10254g;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m16088a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16087a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16089a());
            int b2 = flatBufferBuilder.b(m16093d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f10252e);
            flatBufferBuilder.a(2, this.f10253f);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16090a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10252e = mutableFlatBuffer.a(i, 1);
            this.f10253f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 191310643)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class PagesYouMayLikeFeedUnitItemModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContentSetModel f10268d;
        @Nullable
        private String f10269e;
        @Nullable
        private DefaultTextWithEntitiesWithRangesModel f10270f;
        @Nullable
        private CommonProfileFeedUnitFieldsModel f10271g;
        @Nullable
        private DefaultTextWithEntitiesWithRangesModel f10272h;
        @Nullable
        private SponsoredDataFieldsModel f10273i;
        @Nullable
        private String f10274j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 524811713)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class ContentSetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10267d;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContentSetModel.class, new Deserializer());
                }

                public Object m16094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContentSetParser.m16231a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contentSetModel = new ContentSetModel();
                    ((BaseModel) contentSetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contentSetModel instanceof Postprocessable) {
                        return ((Postprocessable) contentSetModel).a();
                    }
                    return contentSetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1100022209)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: model */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f10261d;
                @Nullable
                private List<AttachmentsModel> f10262e;
                @Nullable
                private String f10263f;
                @Nullable
                private String f10264g;
                @Nullable
                private ImageModel f10265h;
                @Nullable
                private String f10266i;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -57672476)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: model */
                public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private MediaModel f10258d;
                    @Nullable
                    private String f10259e;

                    /* compiled from: model */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                        }

                        public Object m16095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(AttachmentsParser.m16225b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object attachmentsModel = new AttachmentsModel();
                            ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (attachmentsModel instanceof Postprocessable) {
                                return ((Postprocessable) attachmentsModel).a();
                            }
                            return attachmentsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -439185867)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: model */
                    public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private GraphQLObjectType f10256d;
                        @Nullable
                        private ImageModel f10257e;

                        /* compiled from: model */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                            }

                            public Object m16096a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(MediaParser.m16223a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object mediaModel = new MediaModel();
                                ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (mediaModel instanceof Postprocessable) {
                                    return ((Postprocessable) mediaModel).a();
                                }
                                return mediaModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: model */
                        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f10255d;

                            /* compiled from: model */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                                }

                                public Object m16097a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ImageParser.m16221a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: model */
                            public class Serializer extends JsonSerializer<ImageModel> {
                                public final void m16098a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ImageModel imageModel = (ImageModel) obj;
                                    if (imageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(imageModel.m16100a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ImageParser.m16222a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                                }
                            }

                            public ImageModel() {
                                super(1);
                            }

                            @Nullable
                            private String m16099a() {
                                this.f10255d = super.a(this.f10255d, 0);
                                return this.f10255d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m16101a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m16100a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m16099a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: model */
                        public class Serializer extends JsonSerializer<MediaModel> {
                            public final void m16102a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                MediaModel mediaModel = (MediaModel) obj;
                                if (mediaModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(mediaModel.m16105a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                MediaParser.m16224a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(MediaModel.class, new Serializer());
                            }
                        }

                        public MediaModel() {
                            super(2);
                        }

                        @Nullable
                        private GraphQLObjectType m16103a() {
                            if (this.b != null && this.f10256d == null) {
                                this.f10256d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f10256d;
                        }

                        @Nullable
                        private ImageModel m16104j() {
                            this.f10257e = (ImageModel) super.a(this.f10257e, 1, ImageModel.class);
                            return this.f10257e;
                        }

                        public final int jK_() {
                            return 74219460;
                        }

                        public final GraphQLVisitableModel m16106a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m16104j() != null) {
                                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m16104j());
                                if (m16104j() != imageModel) {
                                    graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f10257e = imageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m16105a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m16103a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m16104j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: model */
                    public class Serializer extends JsonSerializer<AttachmentsModel> {
                        public final void m16107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                            if (attachmentsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(attachmentsModel.m16110a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            AttachmentsParser.m16226b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                        }
                    }

                    public AttachmentsModel() {
                        super(2);
                    }

                    @Nullable
                    private MediaModel m16108a() {
                        this.f10258d = (MediaModel) super.a(this.f10258d, 0, MediaModel.class);
                        return this.f10258d;
                    }

                    @Nullable
                    private String m16109j() {
                        this.f10259e = super.a(this.f10259e, 1);
                        return this.f10259e;
                    }

                    public final int jK_() {
                        return -1267730472;
                    }

                    public final GraphQLVisitableModel m16111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16108a() != null) {
                            MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m16108a());
                            if (m16108a() != mediaModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10258d = mediaModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16110a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16108a());
                        int b = flatBufferBuilder.b(m16109j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: model */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m16112a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m16229b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: model */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10260d;

                    /* compiled from: model */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m16113a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.ImageParser.m16227a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: model */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m16114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m16116a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.ImageParser.m16228a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m16115a() {
                        this.f10260d = super.a(this.f10260d, 0);
                        return this.f10260d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m16117a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m16116a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m16115a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: model */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m16118a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m16125a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m16230b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(6);
                }

                public final void m16128a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m16129a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m16119j() {
                    if (this.b != null && this.f10261d == null) {
                        this.f10261d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10261d;
                }

                @Nonnull
                private ImmutableList<AttachmentsModel> m16120k() {
                    this.f10262e = super.a(this.f10262e, 1, AttachmentsModel.class);
                    return (ImmutableList) this.f10262e;
                }

                @Nullable
                private String m16121l() {
                    this.f10263f = super.a(this.f10263f, 2);
                    return this.f10263f;
                }

                @Nullable
                private String m16122m() {
                    this.f10264g = super.a(this.f10264g, 3);
                    return this.f10264g;
                }

                @Nullable
                private ImageModel m16123n() {
                    this.f10265h = (ImageModel) super.a(this.f10265h, 4, ImageModel.class);
                    return this.f10265h;
                }

                @Nullable
                private String m16124o() {
                    this.f10266i = super.a(this.f10266i, 5);
                    return this.f10266i;
                }

                @Nullable
                public final String m16127a() {
                    return m16122m();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m16126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    ImageModel imageModel;
                    h();
                    if (m16120k() != null) {
                        Builder a = ModelHelper.a(m16120k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            NodesModel nodesModel = (NodesModel) ModelHelper.a(null, this);
                            nodesModel.f10262e = a.b();
                            graphQLVisitableModel = nodesModel;
                            if (m16123n() != null) {
                                imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m16123n());
                                if (m16123n() != imageModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f10265h = imageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m16123n() != null) {
                        imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m16123n());
                        if (m16123n() != imageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10265h = imageModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m16125a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16119j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m16120k());
                    int b = flatBufferBuilder.b(m16121l());
                    int b2 = flatBufferBuilder.b(m16122m());
                    int a3 = ModelHelper.a(flatBufferBuilder, m16123n());
                    int b3 = flatBufferBuilder.b(m16124o());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<ContentSetModel> {
                public final void m16130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContentSetModel contentSetModel = (ContentSetModel) obj;
                    if (contentSetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contentSetModel.m16132a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contentSetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContentSetParser.m16232a(contentSetModel.w_(), contentSetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ContentSetModel.class, new Serializer());
                }
            }

            public ContentSetModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m16131a() {
                this.f10267d = super.a(this.f10267d, 0, NodesModel.class);
                return (ImmutableList) this.f10267d;
            }

            public final int jK_() {
                return 438687105;
            }

            public final GraphQLVisitableModel m16133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16131a() != null) {
                    Builder a = ModelHelper.a(m16131a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ContentSetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10267d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16132a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16131a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagesYouMayLikeFeedUnitItemModel.class, new Deserializer());
            }

            public Object m16134a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PagesYouMayLikeFeedUnitItemParser.m16233a(jsonParser);
                Object pagesYouMayLikeFeedUnitItemModel = new PagesYouMayLikeFeedUnitItemModel();
                ((BaseModel) pagesYouMayLikeFeedUnitItemModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pagesYouMayLikeFeedUnitItemModel instanceof Postprocessable) {
                    return ((Postprocessable) pagesYouMayLikeFeedUnitItemModel).a();
                }
                return pagesYouMayLikeFeedUnitItemModel;
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<PagesYouMayLikeFeedUnitItemModel> {
            public final void m16135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PagesYouMayLikeFeedUnitItemModel pagesYouMayLikeFeedUnitItemModel = (PagesYouMayLikeFeedUnitItemModel) obj;
                if (pagesYouMayLikeFeedUnitItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagesYouMayLikeFeedUnitItemModel.m16143a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagesYouMayLikeFeedUnitItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pagesYouMayLikeFeedUnitItemModel.w_();
                int u_ = pagesYouMayLikeFeedUnitItemModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("content_set");
                    ContentSetParser.m16232a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("hideable_token");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("like_sentence");
                    DefaultTextWithEntitiesWithRangesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("profile");
                    CommonProfileFeedUnitFieldsParser.m16213a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    DefaultTextWithEntitiesWithRangesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("sponsored_data");
                    SponsoredDataFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PagesYouMayLikeFeedUnitItemModel.class, new Serializer());
            }
        }

        public PagesYouMayLikeFeedUnitItemModel() {
            super(7);
        }

        @Nullable
        private ContentSetModel m16136a() {
            this.f10268d = (ContentSetModel) super.a(this.f10268d, 0, ContentSetModel.class);
            return this.f10268d;
        }

        @Nullable
        private String m16137j() {
            this.f10269e = super.a(this.f10269e, 1);
            return this.f10269e;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesModel m16138k() {
            this.f10270f = (DefaultTextWithEntitiesWithRangesModel) super.a(this.f10270f, 2, DefaultTextWithEntitiesWithRangesModel.class);
            return this.f10270f;
        }

        @Nullable
        private CommonProfileFeedUnitFieldsModel m16139l() {
            this.f10271g = (CommonProfileFeedUnitFieldsModel) super.a(this.f10271g, 3, CommonProfileFeedUnitFieldsModel.class);
            return this.f10271g;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesModel m16140m() {
            this.f10272h = (DefaultTextWithEntitiesWithRangesModel) super.a(this.f10272h, 4, DefaultTextWithEntitiesWithRangesModel.class);
            return this.f10272h;
        }

        @Nullable
        private SponsoredDataFieldsModel m16141n() {
            this.f10273i = (SponsoredDataFieldsModel) super.a(this.f10273i, 5, SponsoredDataFieldsModel.class);
            return this.f10273i;
        }

        @Nullable
        private String m16142o() {
            this.f10274j = super.a(this.f10274j, 6);
            return this.f10274j;
        }

        public final int jK_() {
            return -2026828458;
        }

        public final GraphQLVisitableModel m16144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesWithRangesModel defaultTextWithEntitiesWithRangesModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16136a() != null) {
                ContentSetModel contentSetModel = (ContentSetModel) graphQLModelMutatingVisitor.b(m16136a());
                if (m16136a() != contentSetModel) {
                    graphQLVisitableModel = (PagesYouMayLikeFeedUnitItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10268d = contentSetModel;
                }
            }
            if (m16138k() != null) {
                defaultTextWithEntitiesWithRangesModel = (DefaultTextWithEntitiesWithRangesModel) graphQLModelMutatingVisitor.b(m16138k());
                if (m16138k() != defaultTextWithEntitiesWithRangesModel) {
                    graphQLVisitableModel = (PagesYouMayLikeFeedUnitItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10270f = defaultTextWithEntitiesWithRangesModel;
                }
            }
            if (m16139l() != null) {
                CommonProfileFeedUnitFieldsModel commonProfileFeedUnitFieldsModel = (CommonProfileFeedUnitFieldsModel) graphQLModelMutatingVisitor.b(m16139l());
                if (m16139l() != commonProfileFeedUnitFieldsModel) {
                    graphQLVisitableModel = (PagesYouMayLikeFeedUnitItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10271g = commonProfileFeedUnitFieldsModel;
                }
            }
            if (m16140m() != null) {
                defaultTextWithEntitiesWithRangesModel = (DefaultTextWithEntitiesWithRangesModel) graphQLModelMutatingVisitor.b(m16140m());
                if (m16140m() != defaultTextWithEntitiesWithRangesModel) {
                    graphQLVisitableModel = (PagesYouMayLikeFeedUnitItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10272h = defaultTextWithEntitiesWithRangesModel;
                }
            }
            if (m16141n() != null) {
                SponsoredDataFieldsModel sponsoredDataFieldsModel = (SponsoredDataFieldsModel) graphQLModelMutatingVisitor.b(m16141n());
                if (m16141n() != sponsoredDataFieldsModel) {
                    graphQLVisitableModel = (PagesYouMayLikeFeedUnitItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10273i = sponsoredDataFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16143a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16136a());
            int b = flatBufferBuilder.b(m16137j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16138k());
            int a3 = ModelHelper.a(flatBufferBuilder, m16139l());
            int a4 = ModelHelper.a(flatBufferBuilder, m16140m());
            int a5 = ModelHelper.a(flatBufferBuilder, m16141n());
            int b2 = flatBufferBuilder.b(m16142o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2087075048)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class PeopleYouMayKnowFeedUnitItemModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileModel f10284d;
        @Nullable
        private DefaultTextWithEntitiesWithRangesModel f10285e;
        @Nullable
        private String f10286f;

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowFeedUnitItemModel.class, new Deserializer());
            }

            public Object m16145a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PeopleYouMayKnowFeedUnitItemParser.m16240a(jsonParser);
                Object peopleYouMayKnowFeedUnitItemModel = new PeopleYouMayKnowFeedUnitItemModel();
                ((BaseModel) peopleYouMayKnowFeedUnitItemModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (peopleYouMayKnowFeedUnitItemModel instanceof Postprocessable) {
                    return ((Postprocessable) peopleYouMayKnowFeedUnitItemModel).a();
                }
                return peopleYouMayKnowFeedUnitItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2077065898)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLFriendshipStatus f10278d;
            @Nullable
            private String f10279e;
            @Nullable
            private MutualFriendsModel f10280f;
            @Nullable
            private String f10281g;
            @Nullable
            private DefaultImageFieldsModel f10282h;
            @Nullable
            private List<StructuredNamesModel> f10283i;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m16146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m16238a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileModel = new ProfileModel();
                    ((BaseModel) profileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileModel instanceof Postprocessable) {
                        return ((Postprocessable) profileModel).a();
                    }
                    return profileModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: model */
            public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                private int f10275d;

                /* compiled from: model */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                    }

                    public Object m16147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MutualFriendsParser.m16234a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mutualFriendsModel = new MutualFriendsModel();
                        ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mutualFriendsModel instanceof Postprocessable) {
                            return ((Postprocessable) mutualFriendsModel).a();
                        }
                        return mutualFriendsModel;
                    }
                }

                /* compiled from: model */
                public class Serializer extends JsonSerializer<MutualFriendsModel> {
                    public final void m16148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                        if (mutualFriendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mutualFriendsModel.m16149a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MutualFriendsParser.m16235a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                    }
                }

                public MutualFriendsModel() {
                    super(1);
                }

                public final int jK_() {
                    return 1532278911;
                }

                public final GraphQLVisitableModel m16150a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16149a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f10275d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16151a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10275d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m16152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m16166a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m16239a(profileModel.w_(), profileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 552388050)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: model */
            public final class StructuredNamesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10276d;
                @Nullable
                private String f10277e;

                /* compiled from: model */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(StructuredNamesModel.class, new Deserializer());
                    }

                    public Object m16153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(StructuredNamesParser.m16237b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object structuredNamesModel = new StructuredNamesModel();
                        ((BaseModel) structuredNamesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (structuredNamesModel instanceof Postprocessable) {
                            return ((Postprocessable) structuredNamesModel).a();
                        }
                        return structuredNamesModel;
                    }
                }

                /* compiled from: model */
                public class Serializer extends JsonSerializer<StructuredNamesModel> {
                    public final void m16154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        StructuredNamesModel structuredNamesModel = (StructuredNamesModel) obj;
                        if (structuredNamesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(structuredNamesModel.m16157a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            structuredNamesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        StructuredNamesParser.m16236a(structuredNamesModel.w_(), structuredNamesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(StructuredNamesModel.class, new Serializer());
                    }
                }

                public StructuredNamesModel() {
                    super(2);
                }

                @Nullable
                private String m16155a() {
                    this.f10276d = super.a(this.f10276d, 0);
                    return this.f10276d;
                }

                @Nullable
                private String m16156j() {
                    this.f10277e = super.a(this.f10277e, 1);
                    return this.f10277e;
                }

                public final int jK_() {
                    return 2420395;
                }

                public final GraphQLVisitableModel m16158a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16157a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16155a());
                    int b2 = flatBufferBuilder.b(m16156j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public ProfileModel() {
                super(6);
            }

            public final void m16169a(String str, ConsistencyTuple consistencyTuple) {
                if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m16160j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16170a(String str, Object obj, boolean z) {
                if ("friendship_status".equals(str)) {
                    m16159a((GraphQLFriendshipStatus) obj);
                }
            }

            @Nullable
            private GraphQLFriendshipStatus m16160j() {
                this.f10278d = (GraphQLFriendshipStatus) super.b(this.f10278d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10278d;
            }

            private void m16159a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10278d = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m16161k() {
                this.f10279e = super.a(this.f10279e, 1);
                return this.f10279e;
            }

            @Nullable
            private MutualFriendsModel m16162l() {
                this.f10280f = (MutualFriendsModel) super.a(this.f10280f, 2, MutualFriendsModel.class);
                return this.f10280f;
            }

            @Nullable
            private String m16163m() {
                this.f10281g = super.a(this.f10281g, 3);
                return this.f10281g;
            }

            @Nullable
            private DefaultImageFieldsModel m16164n() {
                this.f10282h = (DefaultImageFieldsModel) super.a(this.f10282h, 4, DefaultImageFieldsModel.class);
                return this.f10282h;
            }

            @Nonnull
            private ImmutableList<StructuredNamesModel> m16165o() {
                this.f10283i = super.a(this.f10283i, 5, StructuredNamesModel.class);
                return (ImmutableList) this.f10283i;
            }

            @Nullable
            public final String m16168a() {
                return m16161k();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16167a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16162l() != null) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m16162l());
                    if (m16162l() != mutualFriendsModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10280f = mutualFriendsModel;
                    }
                }
                if (m16164n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16164n());
                    if (m16164n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10282h = defaultImageFieldsModel;
                    }
                }
                if (m16165o() != null) {
                    Builder a = ModelHelper.a(m16165o(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ProfileModel profileModel = (ProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                        profileModel.f10283i = a.b();
                        graphQLVisitableModel = profileModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16166a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m16160j());
                int b = flatBufferBuilder.b(m16161k());
                int a2 = ModelHelper.a(flatBufferBuilder, m16162l());
                int b2 = flatBufferBuilder.b(m16163m());
                int a3 = ModelHelper.a(flatBufferBuilder, m16164n());
                int a4 = ModelHelper.a(flatBufferBuilder, m16165o());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<PeopleYouMayKnowFeedUnitItemModel> {
            public final void m16171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PeopleYouMayKnowFeedUnitItemModel peopleYouMayKnowFeedUnitItemModel = (PeopleYouMayKnowFeedUnitItemModel) obj;
                if (peopleYouMayKnowFeedUnitItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peopleYouMayKnowFeedUnitItemModel.m16175a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peopleYouMayKnowFeedUnitItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = peopleYouMayKnowFeedUnitItemModel.w_();
                int u_ = peopleYouMayKnowFeedUnitItemModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile");
                    ProfileParser.m16239a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    DefaultTextWithEntitiesWithRangesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PeopleYouMayKnowFeedUnitItemModel.class, new Serializer());
            }
        }

        public PeopleYouMayKnowFeedUnitItemModel() {
            super(3);
        }

        @Nullable
        private ProfileModel m16172a() {
            this.f10284d = (ProfileModel) super.a(this.f10284d, 0, ProfileModel.class);
            return this.f10284d;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesModel m16173j() {
            this.f10285e = (DefaultTextWithEntitiesWithRangesModel) super.a(this.f10285e, 1, DefaultTextWithEntitiesWithRangesModel.class);
            return this.f10285e;
        }

        @Nullable
        private String m16174k() {
            this.f10286f = super.a(this.f10286f, 2);
            return this.f10286f;
        }

        public final int jK_() {
            return 1031295765;
        }

        public final GraphQLVisitableModel m16176a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16172a() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m16172a());
                if (m16172a() != profileModel) {
                    graphQLVisitableModel = (PeopleYouMayKnowFeedUnitItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10284d = profileModel;
                }
            }
            if (m16173j() != null) {
                DefaultTextWithEntitiesWithRangesModel defaultTextWithEntitiesWithRangesModel = (DefaultTextWithEntitiesWithRangesModel) graphQLModelMutatingVisitor.b(m16173j());
                if (m16173j() != defaultTextWithEntitiesWithRangesModel) {
                    graphQLVisitableModel = (PeopleYouMayKnowFeedUnitItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10285e = defaultTextWithEntitiesWithRangesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16175a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16172a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16173j());
            int b = flatBufferBuilder.b(m16174k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2016874574)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: model */
    public final class TrueTopicFeedOptionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f10296d;
        @Nullable
        private String f10297e;
        private boolean f10298f;
        @Nullable
        private OptionIconModel f10299g;
        @Nullable
        private TopicFeedOptionModel f10300h;

        /* compiled from: model */
        public final class Builder {
            @Nullable
            public String f10287a;
            @Nullable
            public String f10288b;
            public boolean f10289c;
            @Nullable
            public OptionIconModel f10290d;
            @Nullable
            public TopicFeedOptionModel f10291e;

            public static Builder m16177a(TrueTopicFeedOptionFragmentModel trueTopicFeedOptionFragmentModel) {
                Builder builder = new Builder();
                builder.f10287a = trueTopicFeedOptionFragmentModel.m16201j();
                builder.f10288b = trueTopicFeedOptionFragmentModel.m16202k();
                builder.f10289c = trueTopicFeedOptionFragmentModel.m16203l();
                builder.f10290d = trueTopicFeedOptionFragmentModel.m16204m();
                builder.f10291e = trueTopicFeedOptionFragmentModel.m16205n();
                return builder;
            }

            public final TrueTopicFeedOptionFragmentModel m16178a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f10287a);
                int b2 = flatBufferBuilder.b(this.f10288b);
                int a = ModelHelper.a(flatBufferBuilder, this.f10290d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f10291e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.a(2, this.f10289c);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TrueTopicFeedOptionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: model */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TrueTopicFeedOptionFragmentModel.class, new Deserializer());
            }

            public Object m16179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TrueTopicFeedOptionFragmentParser.m16247b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object trueTopicFeedOptionFragmentModel = new TrueTopicFeedOptionFragmentModel();
                ((BaseModel) trueTopicFeedOptionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (trueTopicFeedOptionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) trueTopicFeedOptionFragmentModel).a();
                }
                return trueTopicFeedOptionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class OptionIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10292d;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionIconModel.class, new Deserializer());
                }

                public Object m16180a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionIconParser.m16241a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionIconModel = new OptionIconModel();
                    ((BaseModel) optionIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionIconModel instanceof Postprocessable) {
                        return ((Postprocessable) optionIconModel).a();
                    }
                    return optionIconModel;
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<OptionIconModel> {
                public final void m16181a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionIconModel optionIconModel = (OptionIconModel) obj;
                    if (optionIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionIconModel.m16183a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionIconParser.m16242a(optionIconModel.w_(), optionIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OptionIconModel.class, new Serializer());
                }
            }

            public OptionIconModel() {
                super(1);
            }

            @Nullable
            private String m16182a() {
                this.f10292d = super.a(this.f10292d, 0);
                return this.f10292d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m16184a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16183a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16182a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: model */
        public class Serializer extends JsonSerializer<TrueTopicFeedOptionFragmentModel> {
            public final void m16185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TrueTopicFeedOptionFragmentModel trueTopicFeedOptionFragmentModel = (TrueTopicFeedOptionFragmentModel) obj;
                if (trueTopicFeedOptionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(trueTopicFeedOptionFragmentModel.m16195a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    trueTopicFeedOptionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TrueTopicFeedOptionFragmentParser.m16248b(trueTopicFeedOptionFragmentModel.w_(), trueTopicFeedOptionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TrueTopicFeedOptionFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: model */
        public final class TopicFeedOptionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f10293d;
            @Nullable
            private String f10294e;
            @Nullable
            private String f10295f;

            /* compiled from: model */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopicFeedOptionModel.class, new Deserializer());
                }

                public Object m16186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopicFeedOptionParser.m16243a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topicFeedOptionModel = new TopicFeedOptionModel();
                    ((BaseModel) topicFeedOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topicFeedOptionModel instanceof Postprocessable) {
                        return ((Postprocessable) topicFeedOptionModel).a();
                    }
                    return topicFeedOptionModel;
                }
            }

            /* compiled from: model */
            public class Serializer extends JsonSerializer<TopicFeedOptionModel> {
                public final void m16187a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopicFeedOptionModel topicFeedOptionModel = (TopicFeedOptionModel) obj;
                    if (topicFeedOptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topicFeedOptionModel.m16191a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topicFeedOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopicFeedOptionParser.m16244a(topicFeedOptionModel.w_(), topicFeedOptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopicFeedOptionModel.class, new Serializer());
                }
            }

            public TopicFeedOptionModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m16188j() {
                if (this.b != null && this.f10293d == null) {
                    this.f10293d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10293d;
            }

            @Nullable
            private String m16189k() {
                this.f10294e = super.a(this.f10294e, 1);
                return this.f10294e;
            }

            @Nullable
            private String m16190l() {
                this.f10295f = super.a(this.f10295f, 2);
                return this.f10295f;
            }

            @Nullable
            public final String m16193a() {
                return m16189k();
            }

            public final int jK_() {
                return -19653086;
            }

            public final GraphQLVisitableModel m16192a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16191a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16188j());
                int b = flatBufferBuilder.b(m16189k());
                int b2 = flatBufferBuilder.b(m16190l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TrueTopicFeedOptionFragmentModel() {
            super(5);
        }

        public TrueTopicFeedOptionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m16199a(String str, ConsistencyTuple consistencyTuple) {
            if ("is_checked".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16203l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16200a(String str, Object obj, boolean z) {
            if ("is_checked".equals(str)) {
                m16194a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final String m16201j() {
            this.f10296d = super.a(this.f10296d, 0);
            return this.f10296d;
        }

        @Nullable
        public final String m16202k() {
            this.f10297e = super.a(this.f10297e, 1);
            return this.f10297e;
        }

        public final boolean m16203l() {
            a(0, 2);
            return this.f10298f;
        }

        private void m16194a(boolean z) {
            this.f10298f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        @Nullable
        public final OptionIconModel m16204m() {
            this.f10299g = (OptionIconModel) super.a(this.f10299g, 3, OptionIconModel.class);
            return this.f10299g;
        }

        @Nullable
        public final TopicFeedOptionModel m16205n() {
            this.f10300h = (TopicFeedOptionModel) super.a(this.f10300h, 4, TopicFeedOptionModel.class);
            return this.f10300h;
        }

        @Nullable
        public final String m16197a() {
            return m16202k();
        }

        public final int jK_() {
            return -538844492;
        }

        public final GraphQLVisitableModel m16196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16204m() != null) {
                OptionIconModel optionIconModel = (OptionIconModel) graphQLModelMutatingVisitor.b(m16204m());
                if (m16204m() != optionIconModel) {
                    graphQLVisitableModel = (TrueTopicFeedOptionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10299g = optionIconModel;
                }
            }
            if (m16205n() != null) {
                TopicFeedOptionModel topicFeedOptionModel = (TopicFeedOptionModel) graphQLModelMutatingVisitor.b(m16205n());
                if (m16205n() != topicFeedOptionModel) {
                    graphQLVisitableModel = (TrueTopicFeedOptionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10300h = topicFeedOptionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16195a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16201j());
            int b2 = flatBufferBuilder.b(m16202k());
            int a = ModelHelper.a(flatBufferBuilder, m16204m());
            int a2 = ModelHelper.a(flatBufferBuilder, m16205n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f10298f);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16198a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10298f = mutableFlatBuffer.a(i, 2);
        }
    }
}
