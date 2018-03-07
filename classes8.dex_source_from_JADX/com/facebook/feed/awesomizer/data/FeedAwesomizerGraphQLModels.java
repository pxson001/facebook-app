package com.facebook.feed.awesomizer.data;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FBFeedAwesomizerProfileListCardProfileFragmentParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FBFeedAwesomizerProfileListCardProfileFragmentParser.CoverPhotoParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FBFeedAwesomizerProfileListCardProfileFragmentParser.CoverPhotoParser.PhotoParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FBFeedAwesomizerProfileListCardProfileFragmentParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardConnectedFriendsFragmentParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardConnectedFriendsFragmentParser.ConnectedFriendsParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardConnectedFriendsFragmentParser.ConnectedFriendsParser.NodesParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardConnectedFriendsFragmentParser.ConnectedFriendsParser.NodesParser.ProfilePictureParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardQueryParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardQueryParser.PageTopicsByCountParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardQueryParser.PageTopicsByCountParser.SuggestedPagesParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardQueryParser.PageTopicsByCountParser.SuggestedPagesParser.EdgesParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverCardQueryParser.PageTopicsByCountParser.SuggestedPagesParser.EdgesParser.NodeParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverTopicQueryParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.PageInfoParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerFollowingQueryParser.FollowedProfilesParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerProfilePictureFragmentParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerProfilePictureFragmentParser.FeedAwesomizerProfilePictureParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerSeefirstCardProfileFragmentParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerSeefirstCardQueryParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerUnfollowingQueryParser;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerUnfollowingQueryParser.UnfollowedProfilesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: has_live_icon */
public class FeedAwesomizerGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1510606757)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FBFeedAwesomizerProfileListCardProfileFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11615d;
        @Nullable
        private CoverPhotoModel f11616e;
        @Nullable
        private FeedAwesomizerProfilePictureModel f11617f;
        @Nullable
        private String f11618g;
        @Nullable
        private String f11619h;
        @Nullable
        private GraphQLSubscribeStatus f11620i;

        /* compiled from: has_live_icon */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f11605a;
            @Nullable
            public CoverPhotoModel f11606b;
            @Nullable
            public FeedAwesomizerProfilePictureModel f11607c;
            @Nullable
            public String f11608d;
            @Nullable
            public String f11609e;
            @Nullable
            public GraphQLSubscribeStatus f11610f;
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -279023138)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f11614d;

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m13511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m13778a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -169108033)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f11612d;
                @Nullable
                private ImageModel f11613e;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m13512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m13776a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object photoModel = new PhotoModel();
                        ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (photoModel instanceof Postprocessable) {
                            return ((Postprocessable) photoModel).a();
                        }
                        return photoModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: has_live_icon */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11611d;

                    /* compiled from: has_live_icon */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m13513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m13774a(r11, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: has_live_icon */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m13514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) r8;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m13515a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m13775a(imageModel.w_(), imageModel.u_(), r9);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m13517a() {
                        this.f11611d = super.a(this.f11611d, 0);
                        return this.f11611d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m13516a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m13515a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = r3.b(m13517a());
                        r3.c(1);
                        r3.b(0, b);
                        i();
                        return r3.d();
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m13518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) r8;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m13520a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m13777a(photoModel.w_(), photoModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(2);
                }

                @Nullable
                private String m13519k() {
                    this.f11612d = super.a(this.f11612d, 0);
                    return this.f11612d;
                }

                @Nullable
                public final ImageModel m13523j() {
                    this.f11613e = (ImageModel) super.a(this.f11613e, 1, ImageModel.class);
                    return this.f11613e;
                }

                @Nullable
                public final String m13522a() {
                    return m13519k();
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m13521a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13523j() != null) {
                        ImageModel imageModel = (ImageModel) r4.b(m13523j());
                        if (m13523j() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11613e = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13520a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r4.b(m13519k());
                    int a = ModelHelper.a(r4, m13523j());
                    r4.c(2);
                    r4.b(0, b);
                    r4.b(1, a);
                    i();
                    return r4.d();
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m13524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) r8;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m13525a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m13779a(coverPhotoModel.w_(), coverPhotoModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(1);
            }

            @Nullable
            public final PhotoModel m13526a() {
                this.f11614d = (PhotoModel) super.a(this.f11614d, 0, PhotoModel.class);
                return this.f11614d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m13527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13526a() != null) {
                    PhotoModel photoModel = (PhotoModel) r4.b(m13526a());
                    if (m13526a() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11614d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13525a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m13526a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFeedAwesomizerProfileListCardProfileFragmentModel.class, new Deserializer());
            }

            public Object m13528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBFeedAwesomizerProfileListCardProfileFragmentParser.m13780a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBFeedAwesomizerProfileListCardProfileFragmentModel = new FBFeedAwesomizerProfileListCardProfileFragmentModel();
                ((BaseModel) fBFeedAwesomizerProfileListCardProfileFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBFeedAwesomizerProfileListCardProfileFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFeedAwesomizerProfileListCardProfileFragmentModel).a();
                }
                return fBFeedAwesomizerProfileListCardProfileFragmentModel;
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FBFeedAwesomizerProfileListCardProfileFragmentModel> {
            public final void m13529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBFeedAwesomizerProfileListCardProfileFragmentModel fBFeedAwesomizerProfileListCardProfileFragmentModel = (FBFeedAwesomizerProfileListCardProfileFragmentModel) obj;
                if (fBFeedAwesomizerProfileListCardProfileFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFeedAwesomizerProfileListCardProfileFragmentModel.m13531a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFeedAwesomizerProfileListCardProfileFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBFeedAwesomizerProfileListCardProfileFragmentParser.m13781a(fBFeedAwesomizerProfileListCardProfileFragmentModel.w_(), fBFeedAwesomizerProfileListCardProfileFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBFeedAwesomizerProfileListCardProfileFragmentModel.class, new Serializer());
            }
        }

        public FBFeedAwesomizerProfileListCardProfileFragmentModel() {
            super(6);
        }

        public FBFeedAwesomizerProfileListCardProfileFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m13534a(String str, ConsistencyTuple consistencyTuple) {
            if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m13541o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m13535a(String str, Object obj, boolean z) {
            if ("subscribe_status".equals(str)) {
                m13530a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m13536j() {
            if (this.b != null && this.f11615d == null) {
                this.f11615d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11615d;
        }

        @Nullable
        public final CoverPhotoModel m13537k() {
            this.f11616e = (CoverPhotoModel) super.a(this.f11616e, 1, CoverPhotoModel.class);
            return this.f11616e;
        }

        @Nullable
        public final FeedAwesomizerProfilePictureModel m13538l() {
            this.f11617f = (FeedAwesomizerProfilePictureModel) super.a(this.f11617f, 2, FeedAwesomizerProfilePictureModel.class);
            return this.f11617f;
        }

        @Nullable
        public final String m13539m() {
            this.f11618g = super.a(this.f11618g, 3);
            return this.f11618g;
        }

        @Nullable
        public final String m13540n() {
            this.f11619h = super.a(this.f11619h, 4);
            return this.f11619h;
        }

        @Nullable
        public final GraphQLSubscribeStatus m13541o() {
            this.f11620i = (GraphQLSubscribeStatus) super.b(this.f11620i, 5, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11620i;
        }

        private void m13530a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f11620i = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final String m13533a() {
            return m13539m();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m13532a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13537k() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m13537k());
                if (m13537k() != coverPhotoModel) {
                    graphQLVisitableModel = (FBFeedAwesomizerProfileListCardProfileFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11616e = coverPhotoModel;
                }
            }
            if (m13538l() != null) {
                FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) graphQLModelMutatingVisitor.b(m13538l());
                if (m13538l() != feedAwesomizerProfilePictureModel) {
                    graphQLVisitableModel = (FBFeedAwesomizerProfileListCardProfileFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11617f = feedAwesomizerProfilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13531a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13536j());
            int a2 = ModelHelper.a(flatBufferBuilder, m13537k());
            int a3 = ModelHelper.a(flatBufferBuilder, m13538l());
            int b = flatBufferBuilder.b(m13539m());
            int b2 = flatBufferBuilder.b(m13540n());
            int a4 = flatBufferBuilder.a(m13541o());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -823697047)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ConnectedFriendsModel f11625d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1628695752)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class ConnectedFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f11623d;
            @Nullable
            private List<NodesModel> f11624e;

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ConnectedFriendsModel.class, new Deserializer());
                }

                public Object m13542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ConnectedFriendsParser.m13786a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object connectedFriendsModel = new ConnectedFriendsModel();
                    ((BaseModel) connectedFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (connectedFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) connectedFriendsModel).a();
                    }
                    return connectedFriendsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 895214265)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private ProfilePictureModel f11622d;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m13543a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m13784b(jsonParser, flatBufferBuilder));
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
                /* compiled from: has_live_icon */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11621d;

                    /* compiled from: has_live_icon */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m13544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m13782a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: has_live_icon */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m13545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m13546a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m13783a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m13548a() {
                        this.f11621d = super.a(this.f11621d, 0);
                        return this.f11621d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m13547a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m13546a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m13548a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m13549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m13550a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m13785b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m13553a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m13554a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final ProfilePictureModel m13551a() {
                    this.f11622d = (ProfilePictureModel) super.a(this.f11622d, 0, ProfilePictureModel.class);
                    return this.f11622d;
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m13552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13551a() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m13551a());
                        if (m13551a() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11622d = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13550a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13551a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<ConnectedFriendsModel> {
                public final void m13555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) obj;
                    if (connectedFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(connectedFriendsModel.m13557a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        connectedFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ConnectedFriendsParser.m13787a(connectedFriendsModel.w_(), connectedFriendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ConnectedFriendsModel.class, new Serializer());
                }
            }

            public ConnectedFriendsModel() {
                super(2);
            }

            public final int m13556a() {
                a(0, 0);
                return this.f11623d;
            }

            @Nonnull
            public final ImmutableList<NodesModel> m13560j() {
                this.f11624e = super.a(this.f11624e, 1, NodesModel.class);
                return (ImmutableList) this.f11624e;
            }

            public final int jK_() {
                return -315905430;
            }

            public final GraphQLVisitableModel m13558a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13560j() != null) {
                    Builder a = ModelHelper.a(m13560j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ConnectedFriendsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11624e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13557a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13560j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f11623d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13559a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11623d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel.class, new Deserializer());
            }

            public Object m13561a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedAwesomizerDiscoverCardConnectedFriendsFragmentParser.m13788a(jsonParser);
                Object feedAwesomizerDiscoverCardConnectedFriendsFragmentModel = new FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel();
                ((BaseModel) feedAwesomizerDiscoverCardConnectedFriendsFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedAwesomizerDiscoverCardConnectedFriendsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerDiscoverCardConnectedFriendsFragmentModel).a();
                }
                return feedAwesomizerDiscoverCardConnectedFriendsFragmentModel;
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel> {
            public final void m13562a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel feedAwesomizerDiscoverCardConnectedFriendsFragmentModel = (FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel) obj;
                if (feedAwesomizerDiscoverCardConnectedFriendsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerDiscoverCardConnectedFriendsFragmentModel.m13564a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerDiscoverCardConnectedFriendsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerDiscoverCardConnectedFriendsFragmentModel.w_();
                int u_ = feedAwesomizerDiscoverCardConnectedFriendsFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("connected_friends");
                    ConnectedFriendsParser.m13787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel.class, new Serializer());
            }
        }

        public FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel() {
            super(1);
        }

        public final void m13566a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13567a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ConnectedFriendsModel m13563a() {
            this.f11625d = (ConnectedFriendsModel) super.a(this.f11625d, 0, ConnectedFriendsModel.class);
            return this.f11625d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m13565a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13563a() != null) {
                ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) graphQLModelMutatingVisitor.b(m13563a());
                if (m13563a() != connectedFriendsModel) {
                    graphQLVisitableModel = (FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11625d = connectedFriendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13564a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13563a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2043468728)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerDiscoverCardQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PageTopicsByCountModel> f11650d;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerDiscoverCardQueryModel.class, new Deserializer());
            }

            public Object m13568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedAwesomizerDiscoverCardQueryParser.m13797a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedAwesomizerDiscoverCardQueryModel = new FeedAwesomizerDiscoverCardQueryModel();
                ((BaseModel) feedAwesomizerDiscoverCardQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedAwesomizerDiscoverCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerDiscoverCardQueryModel).a();
                }
                return feedAwesomizerDiscoverCardQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1365831655)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class PageTopicsByCountModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11647d;
            @Nullable
            private String f11648e;
            @Nullable
            private SuggestedPagesModel f11649f;

            /* compiled from: has_live_icon */
            public final class Builder {
                @Nullable
                public String f11626a;
                @Nullable
                public String f11627b;
                @Nullable
                public SuggestedPagesModel f11628c;

                public static Builder m13569a(PageTopicsByCountModel pageTopicsByCountModel) {
                    Builder builder = new Builder();
                    builder.f11626a = pageTopicsByCountModel.m13609j();
                    builder.f11627b = pageTopicsByCountModel.m13610k();
                    builder.f11628c = pageTopicsByCountModel.m13611l();
                    return builder;
                }

                public final PageTopicsByCountModel m13570a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f11626a);
                    int b2 = flatBufferBuilder.b(this.f11627b);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11628c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PageTopicsByCountModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageTopicsByCountModel.class, new Deserializer());
                }

                public Object m13571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageTopicsByCountParser.m13795b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageTopicsByCountModel = new PageTopicsByCountModel();
                    ((BaseModel) pageTopicsByCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageTopicsByCountModel instanceof Postprocessable) {
                        return ((Postprocessable) pageTopicsByCountModel).a();
                    }
                    return pageTopicsByCountModel;
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<PageTopicsByCountModel> {
                public final void m13572a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageTopicsByCountModel pageTopicsByCountModel = (PageTopicsByCountModel) obj;
                    if (pageTopicsByCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageTopicsByCountModel.m13604a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageTopicsByCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageTopicsByCountParser.m13796b(pageTopicsByCountModel.w_(), pageTopicsByCountModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageTopicsByCountModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2067235688)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class SuggestedPagesModel extends BaseModel implements GraphQLVisitableModel {
                private int f11645d;
                @Nullable
                private List<EdgesModel> f11646e;

                /* compiled from: has_live_icon */
                public final class Builder {
                    public int f11629a;
                    @Nullable
                    public ImmutableList<EdgesModel> f11630b;

                    public static Builder m13573a(SuggestedPagesModel suggestedPagesModel) {
                        Builder builder = new Builder();
                        builder.f11629a = suggestedPagesModel.m13599a();
                        builder.f11630b = suggestedPagesModel.m13603j();
                        return builder;
                    }

                    public final SuggestedPagesModel m13574a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f11630b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f11629a, 0);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new SuggestedPagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SuggestedPagesModel.class, new Deserializer());
                    }

                    public Object m13575a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SuggestedPagesParser.m13793a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object suggestedPagesModel = new SuggestedPagesModel();
                        ((BaseModel) suggestedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (suggestedPagesModel instanceof Postprocessable) {
                            return ((Postprocessable) suggestedPagesModel).a();
                        }
                        return suggestedPagesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 708360986)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: has_live_icon */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f11644d;

                    /* compiled from: has_live_icon */
                    public final class Builder {
                        @Nullable
                        public NodeModel f11631a;

                        public static Builder m13576a(EdgesModel edgesModel) {
                            Builder builder = new Builder();
                            builder.f11631a = edgesModel.m13596a();
                            return builder;
                        }

                        public final EdgesModel m13577a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f11631a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: has_live_icon */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m13578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m13791b(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1323584083)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: has_live_icon */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private GraphQLObjectType f11638d;
                        @Nullable
                        private ConnectedFriendsModel f11639e;
                        @Nullable
                        private FeedAwesomizerProfilePictureModel f11640f;
                        @Nullable
                        private String f11641g;
                        @Nullable
                        private String f11642h;
                        @Nullable
                        private GraphQLSubscribeStatus f11643i;

                        /* compiled from: has_live_icon */
                        public final class Builder {
                            @Nullable
                            public GraphQLObjectType f11632a;
                            @Nullable
                            public ConnectedFriendsModel f11633b;
                            @Nullable
                            public FeedAwesomizerProfilePictureModel f11634c;
                            @Nullable
                            public String f11635d;
                            @Nullable
                            public String f11636e;
                            @Nullable
                            public GraphQLSubscribeStatus f11637f;

                            public static Builder m13579a(NodeModel nodeModel) {
                                Builder builder = new Builder();
                                builder.f11632a = nodeModel.m13588j();
                                builder.f11633b = nodeModel.m13589k();
                                builder.f11634c = nodeModel.m13590l();
                                builder.f11635d = nodeModel.m13591m();
                                builder.f11636e = nodeModel.m13592n();
                                builder.f11637f = nodeModel.m13593o();
                                return builder;
                            }

                            public final NodeModel m13580a() {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int a = ModelHelper.a(flatBufferBuilder, this.f11632a);
                                int a2 = ModelHelper.a(flatBufferBuilder, this.f11633b);
                                int a3 = ModelHelper.a(flatBufferBuilder, this.f11634c);
                                int b = flatBufferBuilder.b(this.f11635d);
                                int b2 = flatBufferBuilder.b(this.f11636e);
                                int a4 = flatBufferBuilder.a(this.f11637f);
                                flatBufferBuilder.c(6);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                flatBufferBuilder.b(3, b);
                                flatBufferBuilder.b(4, b2);
                                flatBufferBuilder.b(5, a4);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }
                        }

                        /* compiled from: has_live_icon */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m13581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m13789a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object nodeModel = new NodeModel();
                                ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (nodeModel instanceof Postprocessable) {
                                    return ((Postprocessable) nodeModel).a();
                                }
                                return nodeModel;
                            }
                        }

                        /* compiled from: has_live_icon */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m13582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m13583a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m13790a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(6);
                        }

                        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(6);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final void m13586a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m13587a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        public final GraphQLObjectType m13588j() {
                            if (this.b != null && this.f11638d == null) {
                                this.f11638d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f11638d;
                        }

                        @Nullable
                        public final ConnectedFriendsModel m13589k() {
                            this.f11639e = (ConnectedFriendsModel) super.a(this.f11639e, 1, ConnectedFriendsModel.class);
                            return this.f11639e;
                        }

                        @Nullable
                        public final FeedAwesomizerProfilePictureModel m13590l() {
                            this.f11640f = (FeedAwesomizerProfilePictureModel) super.a(this.f11640f, 2, FeedAwesomizerProfilePictureModel.class);
                            return this.f11640f;
                        }

                        @Nullable
                        public final String m13591m() {
                            this.f11641g = super.a(this.f11641g, 3);
                            return this.f11641g;
                        }

                        @Nullable
                        public final String m13592n() {
                            this.f11642h = super.a(this.f11642h, 4);
                            return this.f11642h;
                        }

                        @Nullable
                        public final GraphQLSubscribeStatus m13593o() {
                            this.f11643i = (GraphQLSubscribeStatus) super.b(this.f11643i, 5, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f11643i;
                        }

                        @Nullable
                        public final String m13585a() {
                            return m13591m();
                        }

                        public final int jK_() {
                            return 2479791;
                        }

                        public final GraphQLVisitableModel m13584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m13589k() != null) {
                                ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) graphQLModelMutatingVisitor.b(m13589k());
                                if (m13589k() != connectedFriendsModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f11639e = connectedFriendsModel;
                                }
                            }
                            if (m13590l() != null) {
                                FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) graphQLModelMutatingVisitor.b(m13590l());
                                if (m13590l() != feedAwesomizerProfilePictureModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11640f = feedAwesomizerProfilePictureModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m13583a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m13588j());
                            int a2 = ModelHelper.a(flatBufferBuilder, m13589k());
                            int a3 = ModelHelper.a(flatBufferBuilder, m13590l());
                            int b = flatBufferBuilder.b(m13591m());
                            int b2 = flatBufferBuilder.b(m13592n());
                            int a4 = flatBufferBuilder.a(m13593o());
                            flatBufferBuilder.c(6);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, a3);
                            flatBufferBuilder.b(3, b);
                            flatBufferBuilder.b(4, b2);
                            flatBufferBuilder.b(5, a4);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: has_live_icon */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m13594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m13595a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m13792b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final NodeModel m13596a() {
                        this.f11644d = (NodeModel) super.a(this.f11644d, 0, NodeModel.class);
                        return this.f11644d;
                    }

                    public final int jK_() {
                        return -148726300;
                    }

                    public final GraphQLVisitableModel m13597a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m13596a() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m13596a());
                            if (m13596a() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f11644d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m13595a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m13596a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<SuggestedPagesModel> {
                    public final void m13598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) obj;
                        if (suggestedPagesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(suggestedPagesModel.m13600a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            suggestedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SuggestedPagesParser.m13794a(suggestedPagesModel.w_(), suggestedPagesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(SuggestedPagesModel.class, new Serializer());
                    }
                }

                public SuggestedPagesModel() {
                    super(2);
                }

                public SuggestedPagesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m13599a() {
                    a(0, 0);
                    return this.f11645d;
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m13603j() {
                    this.f11646e = super.a(this.f11646e, 1, EdgesModel.class);
                    return (ImmutableList) this.f11646e;
                }

                public final int jK_() {
                    return -1062816315;
                }

                public final GraphQLVisitableModel m13601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13603j() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13603j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (SuggestedPagesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11646e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13600a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13603j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f11645d, 0);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13602a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11645d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            public PageTopicsByCountModel() {
                super(3);
            }

            public PageTopicsByCountModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m13607a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13608a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m13609j() {
                this.f11647d = super.a(this.f11647d, 0);
                return this.f11647d;
            }

            @Nullable
            public final String m13610k() {
                this.f11648e = super.a(this.f11648e, 1);
                return this.f11648e;
            }

            @Nullable
            public final SuggestedPagesModel m13611l() {
                this.f11649f = (SuggestedPagesModel) super.a(this.f11649f, 2, SuggestedPagesModel.class);
                return this.f11649f;
            }

            @Nullable
            public final String m13606a() {
                return m13609j();
            }

            public final int jK_() {
                return 218987185;
            }

            public final GraphQLVisitableModel m13605a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13611l() != null) {
                    SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) graphQLModelMutatingVisitor.b(m13611l());
                    if (m13611l() != suggestedPagesModel) {
                        graphQLVisitableModel = (PageTopicsByCountModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11649f = suggestedPagesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13604a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13609j());
                int b2 = flatBufferBuilder.b(m13610k());
                int a = ModelHelper.a(flatBufferBuilder, m13611l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerDiscoverCardQueryModel> {
            public final void m13612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerDiscoverCardQueryModel feedAwesomizerDiscoverCardQueryModel = (FeedAwesomizerDiscoverCardQueryModel) obj;
                if (feedAwesomizerDiscoverCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerDiscoverCardQueryModel.m13613a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerDiscoverCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerDiscoverCardQueryModel.w_();
                int u_ = feedAwesomizerDiscoverCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("pageTopicsByCount");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        PageTopicsByCountParser.m13796b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerDiscoverCardQueryModel.class, new Serializer());
            }
        }

        public FeedAwesomizerDiscoverCardQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<PageTopicsByCountModel> m13615a() {
            this.f11650d = super.a(this.f11650d, 0, PageTopicsByCountModel.class);
            return (ImmutableList) this.f11650d;
        }

        public final int jK_() {
            return -93741489;
        }

        public final GraphQLVisitableModel m13614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13615a() != null) {
                Builder a = ModelHelper.a(m13615a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FeedAwesomizerDiscoverCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11650d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13613a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13615a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1249738408)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerDiscoverTopicQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11671d;
        @Nullable
        private String f11672e;
        @Nullable
        private SuggestedPagesModel f11673f;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerDiscoverTopicQueryModel.class, new Deserializer());
            }

            public Object m13616a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedAwesomizerDiscoverTopicQueryParser.m13804a(jsonParser);
                Object feedAwesomizerDiscoverTopicQueryModel = new FeedAwesomizerDiscoverTopicQueryModel();
                ((BaseModel) feedAwesomizerDiscoverTopicQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedAwesomizerDiscoverTopicQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerDiscoverTopicQueryModel).a();
                }
                return feedAwesomizerDiscoverTopicQueryModel;
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerDiscoverTopicQueryModel> {
            public final void m13617a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerDiscoverTopicQueryModel feedAwesomizerDiscoverTopicQueryModel = (FeedAwesomizerDiscoverTopicQueryModel) obj;
                if (feedAwesomizerDiscoverTopicQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerDiscoverTopicQueryModel.m13651a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerDiscoverTopicQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerDiscoverTopicQueryModel.w_();
                int u_ = feedAwesomizerDiscoverTopicQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("suggested_pages");
                    FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.m13803a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerDiscoverTopicQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1023290725)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class SuggestedPagesModel extends BaseModel implements GraphQLVisitableModel {
            private int f11668d;
            @Nullable
            private List<NodesModel> f11669e;
            @Nullable
            private PageInfoModel f11670f;

            /* compiled from: has_live_icon */
            public final class Builder {
                public int f11651a;
                @Nullable
                public ImmutableList<NodesModel> f11652b;
                @Nullable
                public PageInfoModel f11653c;

                public static Builder m13618a(SuggestedPagesModel suggestedPagesModel) {
                    Builder builder = new Builder();
                    builder.f11651a = suggestedPagesModel.m13643a();
                    builder.f11652b = suggestedPagesModel.m13647j();
                    builder.f11653c = suggestedPagesModel.m13648k();
                    return builder;
                }

                public final SuggestedPagesModel m13619a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11652b);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f11653c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f11651a, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SuggestedPagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedPagesModel.class, new Deserializer());
                }

                public Object m13620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.m13802a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedPagesModel = new SuggestedPagesModel();
                    ((BaseModel) suggestedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedPagesModel).a();
                    }
                    return suggestedPagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1323584083)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f11660d;
                @Nullable
                private ConnectedFriendsModel f11661e;
                @Nullable
                private FeedAwesomizerProfilePictureModel f11662f;
                @Nullable
                private String f11663g;
                @Nullable
                private String f11664h;
                @Nullable
                private GraphQLSubscribeStatus f11665i;

                /* compiled from: has_live_icon */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f11654a;
                    @Nullable
                    public ConnectedFriendsModel f11655b;
                    @Nullable
                    public FeedAwesomizerProfilePictureModel f11656c;
                    @Nullable
                    public String f11657d;
                    @Nullable
                    public String f11658e;
                    @Nullable
                    public GraphQLSubscribeStatus f11659f;

                    public final NodesModel m13621a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f11654a);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f11655b);
                        int a3 = ModelHelper.a(flatBufferBuilder, this.f11656c);
                        int b = flatBufferBuilder.b(this.f11657d);
                        int b2 = flatBufferBuilder.b(this.f11658e);
                        int a4 = flatBufferBuilder.a(this.f11659f);
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.b(4, b2);
                        flatBufferBuilder.b(5, a4);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m13622a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.NodesParser.m13798b(jsonParser, flatBufferBuilder));
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

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m13623a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m13624a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.NodesParser.m13799b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(6);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(6);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m13627a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m13628a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m13629j() {
                    if (this.b != null && this.f11660d == null) {
                        this.f11660d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f11660d;
                }

                @Nullable
                public final ConnectedFriendsModel m13630k() {
                    this.f11661e = (ConnectedFriendsModel) super.a(this.f11661e, 1, ConnectedFriendsModel.class);
                    return this.f11661e;
                }

                @Nullable
                public final FeedAwesomizerProfilePictureModel m13631l() {
                    this.f11662f = (FeedAwesomizerProfilePictureModel) super.a(this.f11662f, 2, FeedAwesomizerProfilePictureModel.class);
                    return this.f11662f;
                }

                @Nullable
                public final String m13632m() {
                    this.f11663g = super.a(this.f11663g, 3);
                    return this.f11663g;
                }

                @Nullable
                public final String m13633n() {
                    this.f11664h = super.a(this.f11664h, 4);
                    return this.f11664h;
                }

                @Nullable
                public final GraphQLSubscribeStatus m13634o() {
                    this.f11665i = (GraphQLSubscribeStatus) super.b(this.f11665i, 5, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f11665i;
                }

                @Nullable
                public final String m13626a() {
                    return m13632m();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m13625a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13630k() != null) {
                        ConnectedFriendsModel connectedFriendsModel = (ConnectedFriendsModel) graphQLModelMutatingVisitor.b(m13630k());
                        if (m13630k() != connectedFriendsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11661e = connectedFriendsModel;
                        }
                    }
                    if (m13631l() != null) {
                        FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) graphQLModelMutatingVisitor.b(m13631l());
                        if (m13631l() != feedAwesomizerProfilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f11662f = feedAwesomizerProfilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13624a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13629j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m13630k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m13631l());
                    int b = flatBufferBuilder.b(m13632m());
                    int b2 = flatBufferBuilder.b(m13633n());
                    int a4 = flatBufferBuilder.a(m13634o());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11666d;
                private boolean f11667e;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m13635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m13800a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m13636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m13637a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m13801a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m13639a() {
                    this.f11666d = super.a(this.f11666d, 0);
                    return this.f11666d;
                }

                public final boolean m13641j() {
                    a(0, 1);
                    return this.f11667e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m13638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13637a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13639a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f11667e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13640a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11667e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<SuggestedPagesModel> {
                public final void m13642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) obj;
                    if (suggestedPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedPagesModel.m13644a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedAwesomizerDiscoverTopicQueryParser.SuggestedPagesParser.m13803a(suggestedPagesModel.w_(), suggestedPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedPagesModel.class, new Serializer());
                }
            }

            public SuggestedPagesModel() {
                super(3);
            }

            public SuggestedPagesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m13643a() {
                a(0, 0);
                return this.f11668d;
            }

            @Nonnull
            public final ImmutableList<NodesModel> m13647j() {
                this.f11669e = super.a(this.f11669e, 1, NodesModel.class);
                return (ImmutableList) this.f11669e;
            }

            @Nullable
            public final PageInfoModel m13648k() {
                this.f11670f = (PageInfoModel) super.a(this.f11670f, 2, PageInfoModel.class);
                return this.f11670f;
            }

            public final int jK_() {
                return -1062816315;
            }

            public final GraphQLVisitableModel m13645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m13647j() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13647j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) ModelHelper.a(null, this);
                        suggestedPagesModel.f11669e = a.b();
                        graphQLVisitableModel = suggestedPagesModel;
                        if (m13648k() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13648k());
                            if (m13648k() != pageInfoModel) {
                                graphQLVisitableModel = (SuggestedPagesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11670f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13648k() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13648k());
                    if (m13648k() != pageInfoModel) {
                        graphQLVisitableModel = (SuggestedPagesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11670f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13644a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13647j());
                int a2 = ModelHelper.a(flatBufferBuilder, m13648k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f11668d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13646a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11668d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public FeedAwesomizerDiscoverTopicQueryModel() {
            super(3);
        }

        public final void m13654a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13655a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13649j() {
            if (this.b != null && this.f11671d == null) {
                this.f11671d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11671d;
        }

        @Nullable
        private String m13650k() {
            this.f11672e = super.a(this.f11672e, 1);
            return this.f11672e;
        }

        @Nullable
        public final SuggestedPagesModel m13652a() {
            this.f11673f = (SuggestedPagesModel) super.a(this.f11673f, 2, SuggestedPagesModel.class);
            return this.f11673f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13652a() != null) {
                SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) graphQLModelMutatingVisitor.b(m13652a());
                if (m13652a() != suggestedPagesModel) {
                    graphQLVisitableModel = (FeedAwesomizerDiscoverTopicQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11673f = suggestedPagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13651a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13649j());
            int b = flatBufferBuilder.b(m13650k());
            int a2 = ModelHelper.a(flatBufferBuilder, m13652a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1723890262)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerFollowingQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FollowedProfilesModel f11686d;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.class;
                r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m13656a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerFollowingQueryParser.m13811a(r6);
                r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -241972376)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class FollowedProfilesModel extends BaseModel implements GraphQLVisitableModel {
            private int f11683d;
            @Nullable
            private List<EdgesModel> f11684e;
            @Nullable
            private PageInfoModel f11685f;

            /* compiled from: has_live_icon */
            public final class Builder {
                public int f11674a;
                @Nullable
                public ImmutableList<EdgesModel> f11675b;
                @Nullable
                public PageInfoModel f11676c;

                public static com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Builder m13657a(com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$Builder;
                    r0.<init>();
                    r1 = r2.m13676a();
                    r0.f11674a = r1;
                    r1 = r2.m13680j();
                    r0.f11675b = r1;
                    r1 = r2.m13681k();
                    r0.f11676c = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Builder.a(com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel):com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$Builder");
                }

                public final com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel m13658a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r4 = 1;
                    r2 = 0;
                    r6 = 0;
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r7.f11675b;
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                    r3 = r7.f11676c;
                    r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r5 = 3;
                    r0.c(r5);
                    r5 = r7.f11674a;
                    r0.a(r6, r5, r6);
                    r0.b(r4, r1);
                    r1 = 2;
                    r0.b(r1, r3);
                    r1 = r0.d();
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r1.position(r6);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel;
                    r1.<init>(r0);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Builder.a():com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel");
                }
            }

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.class;
                    r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m13659a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerFollowingQueryParser.FollowedProfilesParser.m13809a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1405339254)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FBFeedAwesomizerProfileListCardProfileFragmentModel f11679d;
                private int f11680e;

                /* compiled from: has_live_icon */
                public final class Builder {
                    @Nullable
                    public FBFeedAwesomizerProfileListCardProfileFragmentModel f11677a;
                    public int f11678b;

                    public final com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel m13660a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r6 = this;
                        r4 = 1;
                        r2 = 0;
                        r5 = 0;
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r6.f11677a;
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                        r3 = 2;
                        r0.c(r3);
                        r0.b(r5, r1);
                        r1 = r6.f11678b;
                        r0.a(r4, r1, r5);
                        r1 = r0.d();
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r1.position(r5);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$EdgesModel;
                        r1.<init>(r0);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.Builder.a():com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$EdgesModel");
                    }
                }

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.class;
                        r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m13661a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLParsers.FeedAwesomizerFollowingQueryParser.FollowedProfilesParser.EdgesParser.m13805b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$EdgesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m13662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m13663a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FollowedProfilesParser.EdgesParser.m13806b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.class;
                        r1 = new com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels$FeedAwesomizerFollowingQueryModel$FollowedProfilesModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(r3, FlatBuffer.a(r3.a));
                }

                @Nullable
                public final FBFeedAwesomizerProfileListCardProfileFragmentModel m13664a() {
                    this.f11679d = (FBFeedAwesomizerProfileListCardProfileFragmentModel) super.a(this.f11679d, 0, FBFeedAwesomizerProfileListCardProfileFragmentModel.class);
                    return this.f11679d;
                }

                public final int m13667j() {
                    a(0, 1);
                    return this.f11680e;
                }

                public final int jK_() {
                    return -1492805353;
                }

                public final GraphQLVisitableModel m13665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13664a() != null) {
                        FBFeedAwesomizerProfileListCardProfileFragmentModel fBFeedAwesomizerProfileListCardProfileFragmentModel = (FBFeedAwesomizerProfileListCardProfileFragmentModel) r4.b(m13664a());
                        if (m13664a() != fBFeedAwesomizerProfileListCardProfileFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11679d = fBFeedAwesomizerProfileListCardProfileFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13663a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r4, m13664a());
                    r4.c(2);
                    r4.b(0, a);
                    r4.a(1, this.f11680e, 0);
                    i();
                    return r4.d();
                }

                public final void m13666a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(r3, r4, r5);
                    this.f11680e = r3.a(r4, 1, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11681d;
                private boolean f11682e;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m13668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FollowedProfilesParser.PageInfoParser.m13807a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m13669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) r8;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m13670a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FollowedProfilesParser.PageInfoParser.m13808a(pageInfoModel.w_(), pageInfoModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m13672a() {
                    this.f11681d = super.a(this.f11681d, 0);
                    return this.f11681d;
                }

                public final boolean m13674j() {
                    a(0, 1);
                    return this.f11682e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m13671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13670a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r3.b(m13672a());
                    r3.c(2);
                    r3.b(0, b);
                    r3.a(1, this.f11682e);
                    i();
                    return r3.d();
                }

                public final void m13673a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(r2, r3, r4);
                    this.f11682e = r2.a(r3, 1);
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<FollowedProfilesModel> {
                public final void m13675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) r8;
                    if (followedProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(followedProfilesModel.m13677a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        followedProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FollowedProfilesParser.m13810a(followedProfilesModel.w_(), followedProfilesModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(FollowedProfilesModel.class, new Serializer());
                }
            }

            public FollowedProfilesModel() {
                super(3);
            }

            public FollowedProfilesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(r3, FlatBuffer.a(r3.a));
            }

            public final int m13676a() {
                a(0, 0);
                return this.f11683d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m13680j() {
                this.f11684e = super.a(this.f11684e, 1, EdgesModel.class);
                return (ImmutableList) this.f11684e;
            }

            @Nullable
            public final PageInfoModel m13681k() {
                this.f11685f = (PageInfoModel) super.a(this.f11685f, 2, PageInfoModel.class);
                return this.f11685f;
            }

            public final int jK_() {
                return -989905224;
            }

            public final GraphQLVisitableModel m13678a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m13680j() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13680j(), r4);
                    if (a != null) {
                        FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) ModelHelper.a(null, this);
                        followedProfilesModel.f11684e = a.b();
                        graphQLVisitableModel = followedProfilesModel;
                        if (m13681k() != null) {
                            pageInfoModel = (PageInfoModel) r4.b(m13681k());
                            if (m13681k() != pageInfoModel) {
                                graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11685f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13681k() != null) {
                    pageInfoModel = (PageInfoModel) r4.b(m13681k());
                    if (m13681k() != pageInfoModel) {
                        graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11685f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13677a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r5, m13680j());
                int a2 = ModelHelper.a(r5, m13681k());
                r5.c(3);
                r5.a(0, this.f11683d, 0);
                r5.b(1, a);
                r5.b(2, a2);
                i();
                return r5.d();
            }

            public final void m13679a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(r2, r3, r4);
                this.f11683d = r2.a(r3, 0, 0);
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerFollowingQueryModel> {
            public final void m13682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerFollowingQueryModel feedAwesomizerFollowingQueryModel = (FeedAwesomizerFollowingQueryModel) r9;
                if (feedAwesomizerFollowingQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerFollowingQueryModel.m13683a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerFollowingQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerFollowingQueryModel.w_();
                int u_ = feedAwesomizerFollowingQueryModel.u_();
                r10.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    r10.a("followed_profiles");
                    FollowedProfilesParser.m13810a(mutableFlatBuffer, g, r10, r11);
                }
                r10.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerFollowingQueryModel.class, new Serializer());
            }
        }

        public FeedAwesomizerFollowingQueryModel() {
            super(1);
        }

        @Nullable
        public final FollowedProfilesModel m13684a() {
            this.f11686d = (FollowedProfilesModel) super.a(this.f11686d, 0, FollowedProfilesModel.class);
            return this.f11686d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13685a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13684a() != null) {
                FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) r4.b(m13684a());
                if (m13684a() != followedProfilesModel) {
                    graphQLVisitableModel = (FeedAwesomizerFollowingQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11686d = followedProfilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13683a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r3, m13684a());
            r3.c(1);
            r3.b(0, a);
            i();
            return r3.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 408534788)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerProfilePictureFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11688d;
        @Nullable
        private FeedAwesomizerProfilePictureModel f11689e;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerProfilePictureFragmentModel.class, new Deserializer());
            }

            public Object m13686a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedAwesomizerProfilePictureFragmentParser.m13814a(jsonParser);
                Object feedAwesomizerProfilePictureFragmentModel = new FeedAwesomizerProfilePictureFragmentModel();
                ((BaseModel) feedAwesomizerProfilePictureFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedAwesomizerProfilePictureFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerProfilePictureFragmentModel).a();
                }
                return feedAwesomizerProfilePictureFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class FeedAwesomizerProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11687d;

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedAwesomizerProfilePictureModel.class, new Deserializer());
                }

                public Object m13687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedAwesomizerProfilePictureParser.m13812a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedAwesomizerProfilePictureModel = new FeedAwesomizerProfilePictureModel();
                    ((BaseModel) feedAwesomizerProfilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedAwesomizerProfilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) feedAwesomizerProfilePictureModel).a();
                    }
                    return feedAwesomizerProfilePictureModel;
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<FeedAwesomizerProfilePictureModel> {
                public final void m13688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) obj;
                    if (feedAwesomizerProfilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedAwesomizerProfilePictureModel.m13689a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedAwesomizerProfilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedAwesomizerProfilePictureParser.m13813a(feedAwesomizerProfilePictureModel.w_(), feedAwesomizerProfilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedAwesomizerProfilePictureModel.class, new Serializer());
                }
            }

            public FeedAwesomizerProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m13691a() {
                this.f11687d = super.a(this.f11687d, 0);
                return this.f11687d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m13690a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13689a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13691a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerProfilePictureFragmentModel> {
            public final void m13692a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerProfilePictureFragmentModel feedAwesomizerProfilePictureFragmentModel = (FeedAwesomizerProfilePictureFragmentModel) obj;
                if (feedAwesomizerProfilePictureFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerProfilePictureFragmentModel.m13695a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerProfilePictureFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerProfilePictureFragmentModel.w_();
                int u_ = feedAwesomizerProfilePictureFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedAwesomizerProfilePicture");
                    FeedAwesomizerProfilePictureParser.m13813a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerProfilePictureFragmentModel.class, new Serializer());
            }
        }

        public FeedAwesomizerProfilePictureFragmentModel() {
            super(2);
        }

        public final void m13697a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13698a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13693a() {
            if (this.b != null && this.f11688d == null) {
                this.f11688d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11688d;
        }

        @Nullable
        private FeedAwesomizerProfilePictureModel m13694j() {
            this.f11689e = (FeedAwesomizerProfilePictureModel) super.a(this.f11689e, 1, FeedAwesomizerProfilePictureModel.class);
            return this.f11689e;
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m13696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13694j() != null) {
                FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) graphQLModelMutatingVisitor.b(m13694j());
                if (m13694j() != feedAwesomizerProfilePictureModel) {
                    graphQLVisitableModel = (FeedAwesomizerProfilePictureFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11689e = feedAwesomizerProfilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13695a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13693a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13694j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1732019983)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerSeefirstCardProfileFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11697d;
        @Nullable
        private CoverPhotoModel f11698e;
        @Nullable
        private FeedAwesomizerProfilePictureModel f11699f;
        @Nullable
        private String f11700g;
        @Nullable
        private String f11701h;
        @Nullable
        private GraphQLSecondarySubscribeStatus f11702i;
        @Nullable
        private GraphQLSubscribeStatus f11703j;

        /* compiled from: has_live_icon */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f11690a;
            @Nullable
            public CoverPhotoModel f11691b;
            @Nullable
            public FeedAwesomizerProfilePictureModel f11692c;
            @Nullable
            public String f11693d;
            @Nullable
            public String f11694e;
            @Nullable
            public GraphQLSecondarySubscribeStatus f11695f;
            @Nullable
            public GraphQLSubscribeStatus f11696g;

            public final FeedAwesomizerSeefirstCardProfileFragmentModel m13699a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11690a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11691b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f11692c);
                int b = flatBufferBuilder.b(this.f11693d);
                int b2 = flatBufferBuilder.b(this.f11694e);
                int a4 = flatBufferBuilder.a(this.f11695f);
                int a5 = flatBufferBuilder.a(this.f11696g);
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FeedAwesomizerSeefirstCardProfileFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerSeefirstCardProfileFragmentModel.class, new Deserializer());
            }

            public Object m13700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedAwesomizerSeefirstCardProfileFragmentParser.m13815a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedAwesomizerSeefirstCardProfileFragmentModel = new FeedAwesomizerSeefirstCardProfileFragmentModel();
                ((BaseModel) feedAwesomizerSeefirstCardProfileFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedAwesomizerSeefirstCardProfileFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerSeefirstCardProfileFragmentModel).a();
                }
                return feedAwesomizerSeefirstCardProfileFragmentModel;
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerSeefirstCardProfileFragmentModel> {
            public final void m13701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedAwesomizerSeefirstCardProfileFragmentModel feedAwesomizerSeefirstCardProfileFragmentModel = (FeedAwesomizerSeefirstCardProfileFragmentModel) obj;
                if (feedAwesomizerSeefirstCardProfileFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerSeefirstCardProfileFragmentModel.m13704a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerSeefirstCardProfileFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedAwesomizerSeefirstCardProfileFragmentParser.m13816a(feedAwesomizerSeefirstCardProfileFragmentModel.w_(), feedAwesomizerSeefirstCardProfileFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerSeefirstCardProfileFragmentModel.class, new Serializer());
            }
        }

        public FeedAwesomizerSeefirstCardProfileFragmentModel() {
            super(7);
        }

        public FeedAwesomizerSeefirstCardProfileFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m13707a(String str, ConsistencyTuple consistencyTuple) {
            if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = m13714o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m13715p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m13708a(String str, Object obj, boolean z) {
            if ("secondary_subscribe_status".equals(str)) {
                m13702a((GraphQLSecondarySubscribeStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m13703a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m13709j() {
            if (this.b != null && this.f11697d == null) {
                this.f11697d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11697d;
        }

        @Nullable
        public final CoverPhotoModel m13710k() {
            this.f11698e = (CoverPhotoModel) super.a(this.f11698e, 1, CoverPhotoModel.class);
            return this.f11698e;
        }

        @Nullable
        public final FeedAwesomizerProfilePictureModel m13711l() {
            this.f11699f = (FeedAwesomizerProfilePictureModel) super.a(this.f11699f, 2, FeedAwesomizerProfilePictureModel.class);
            return this.f11699f;
        }

        @Nullable
        public final String m13712m() {
            this.f11700g = super.a(this.f11700g, 3);
            return this.f11700g;
        }

        @Nullable
        public final String m13713n() {
            this.f11701h = super.a(this.f11701h, 4);
            return this.f11701h;
        }

        @Nullable
        public final GraphQLSecondarySubscribeStatus m13714o() {
            this.f11702i = (GraphQLSecondarySubscribeStatus) super.b(this.f11702i, 5, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11702i;
        }

        private void m13702a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f11702i = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final GraphQLSubscribeStatus m13715p() {
            this.f11703j = (GraphQLSubscribeStatus) super.b(this.f11703j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11703j;
        }

        private void m13703a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f11703j = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final String m13706a() {
            return m13712m();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m13705a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13710k() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m13710k());
                if (m13710k() != coverPhotoModel) {
                    graphQLVisitableModel = (FeedAwesomizerSeefirstCardProfileFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11698e = coverPhotoModel;
                }
            }
            if (m13711l() != null) {
                FeedAwesomizerProfilePictureModel feedAwesomizerProfilePictureModel = (FeedAwesomizerProfilePictureModel) graphQLModelMutatingVisitor.b(m13711l());
                if (m13711l() != feedAwesomizerProfilePictureModel) {
                    graphQLVisitableModel = (FeedAwesomizerSeefirstCardProfileFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11699f = feedAwesomizerProfilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13704a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13709j());
            int a2 = ModelHelper.a(flatBufferBuilder, m13710k());
            int a3 = ModelHelper.a(flatBufferBuilder, m13711l());
            int b = flatBufferBuilder.b(m13712m());
            int b2 = flatBufferBuilder.b(m13713n());
            int a4 = flatBufferBuilder.a(m13714o());
            int a5 = flatBufferBuilder.a(m13715p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1491669746)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerSeefirstCardQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FollowedProfilesModel f11714d;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerSeefirstCardQueryModel.class, new Deserializer());
            }

            public Object m13716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedAwesomizerSeefirstCardQueryParser.m13823a(jsonParser);
                Object feedAwesomizerSeefirstCardQueryModel = new FeedAwesomizerSeefirstCardQueryModel();
                ((BaseModel) feedAwesomizerSeefirstCardQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedAwesomizerSeefirstCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerSeefirstCardQueryModel).a();
                }
                return feedAwesomizerSeefirstCardQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -961603236)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class FollowedProfilesModel extends BaseModel implements GraphQLVisitableModel {
            private int f11711d;
            @Nullable
            private List<EdgesModel> f11712e;
            @Nullable
            private PageInfoModel f11713f;

            /* compiled from: has_live_icon */
            public final class Builder {
                public int f11704a;
                @Nullable
                public ImmutableList<EdgesModel> f11705b;
                @Nullable
                public PageInfoModel f11706c;

                public static Builder m13717a(FollowedProfilesModel followedProfilesModel) {
                    Builder builder = new Builder();
                    builder.f11704a = followedProfilesModel.m13734a();
                    builder.f11705b = followedProfilesModel.m13738j();
                    builder.f11706c = followedProfilesModel.m13739k();
                    return builder;
                }

                public final FollowedProfilesModel m13718a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11705b);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f11706c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f11704a, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FollowedProfilesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FollowedProfilesModel.class, new Deserializer());
                }

                public Object m13719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.m13821a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object followedProfilesModel = new FollowedProfilesModel();
                    ((BaseModel) followedProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (followedProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) followedProfilesModel).a();
                    }
                    return followedProfilesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -657926920)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FeedAwesomizerSeefirstCardProfileFragmentModel f11708d;

                /* compiled from: has_live_icon */
                public final class Builder {
                    @Nullable
                    public FeedAwesomizerSeefirstCardProfileFragmentModel f11707a;

                    public final EdgesModel m13720a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f11707a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m13721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.EdgesParser.m13817b(jsonParser, flatBufferBuilder));
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

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m13722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m13723a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.EdgesParser.m13818b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final FeedAwesomizerSeefirstCardProfileFragmentModel m13724a() {
                    this.f11708d = (FeedAwesomizerSeefirstCardProfileFragmentModel) super.a(this.f11708d, 0, FeedAwesomizerSeefirstCardProfileFragmentModel.class);
                    return this.f11708d;
                }

                public final int jK_() {
                    return -1492805353;
                }

                public final GraphQLVisitableModel m13725a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13724a() != null) {
                        FeedAwesomizerSeefirstCardProfileFragmentModel feedAwesomizerSeefirstCardProfileFragmentModel = (FeedAwesomizerSeefirstCardProfileFragmentModel) graphQLModelMutatingVisitor.b(m13724a());
                        if (m13724a() != feedAwesomizerSeefirstCardProfileFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11708d = feedAwesomizerSeefirstCardProfileFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13723a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13724a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11709d;
                private boolean f11710e;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m13726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.PageInfoParser.m13819a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m13727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m13728a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.PageInfoParser.m13820a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m13730a() {
                    this.f11709d = super.a(this.f11709d, 0);
                    return this.f11709d;
                }

                public final boolean m13732j() {
                    a(0, 1);
                    return this.f11710e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m13729a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13728a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13730a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f11710e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13731a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11710e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<FollowedProfilesModel> {
                public final void m13733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) obj;
                    if (followedProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(followedProfilesModel.m13735a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        followedProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.m13822a(followedProfilesModel.w_(), followedProfilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FollowedProfilesModel.class, new Serializer());
                }
            }

            public FollowedProfilesModel() {
                super(3);
            }

            public FollowedProfilesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m13734a() {
                a(0, 0);
                return this.f11711d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m13738j() {
                this.f11712e = super.a(this.f11712e, 1, EdgesModel.class);
                return (ImmutableList) this.f11712e;
            }

            @Nullable
            public final PageInfoModel m13739k() {
                this.f11713f = (PageInfoModel) super.a(this.f11713f, 2, PageInfoModel.class);
                return this.f11713f;
            }

            public final int jK_() {
                return -989905224;
            }

            public final GraphQLVisitableModel m13736a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m13738j() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13738j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) ModelHelper.a(null, this);
                        followedProfilesModel.f11712e = a.b();
                        graphQLVisitableModel = followedProfilesModel;
                        if (m13739k() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13739k());
                            if (m13739k() != pageInfoModel) {
                                graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11713f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13739k() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13739k());
                    if (m13739k() != pageInfoModel) {
                        graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11713f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13735a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13738j());
                int a2 = ModelHelper.a(flatBufferBuilder, m13739k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f11711d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13737a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11711d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerSeefirstCardQueryModel> {
            public final void m13740a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerSeefirstCardQueryModel feedAwesomizerSeefirstCardQueryModel = (FeedAwesomizerSeefirstCardQueryModel) obj;
                if (feedAwesomizerSeefirstCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerSeefirstCardQueryModel.m13741a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerSeefirstCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerSeefirstCardQueryModel.w_();
                int u_ = feedAwesomizerSeefirstCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("followed_profiles");
                    FeedAwesomizerSeefirstCardQueryParser.FollowedProfilesParser.m13822a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerSeefirstCardQueryModel.class, new Serializer());
            }
        }

        public FeedAwesomizerSeefirstCardQueryModel() {
            super(1);
        }

        @Nullable
        public final FollowedProfilesModel m13742a() {
            this.f11714d = (FollowedProfilesModel) super.a(this.f11714d, 0, FollowedProfilesModel.class);
            return this.f11714d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13743a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13742a() != null) {
                FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) graphQLModelMutatingVisitor.b(m13742a());
                if (m13742a() != followedProfilesModel) {
                    graphQLVisitableModel = (FeedAwesomizerSeefirstCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11714d = followedProfilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13741a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13742a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1075098014)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_live_icon */
    public final class FeedAwesomizerUnfollowingQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UnfollowedProfilesModel f11727d;

        /* compiled from: has_live_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedAwesomizerUnfollowingQueryModel.class, new Deserializer());
            }

            public Object m13744a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedAwesomizerUnfollowingQueryParser.m13830a(jsonParser);
                Object feedAwesomizerUnfollowingQueryModel = new FeedAwesomizerUnfollowingQueryModel();
                ((BaseModel) feedAwesomizerUnfollowingQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedAwesomizerUnfollowingQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) feedAwesomizerUnfollowingQueryModel).a();
                }
                return feedAwesomizerUnfollowingQueryModel;
            }
        }

        /* compiled from: has_live_icon */
        public class Serializer extends JsonSerializer<FeedAwesomizerUnfollowingQueryModel> {
            public final void m13745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedAwesomizerUnfollowingQueryModel feedAwesomizerUnfollowingQueryModel = (FeedAwesomizerUnfollowingQueryModel) obj;
                if (feedAwesomizerUnfollowingQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedAwesomizerUnfollowingQueryModel.m13771a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedAwesomizerUnfollowingQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedAwesomizerUnfollowingQueryModel.w_();
                int u_ = feedAwesomizerUnfollowingQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("unfollowed_profiles");
                    UnfollowedProfilesParser.m13829a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedAwesomizerUnfollowingQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -951583182)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_live_icon */
        public final class UnfollowedProfilesModel extends BaseModel implements GraphQLVisitableModel {
            private int f11724d;
            @Nullable
            private List<EdgesModel> f11725e;
            @Nullable
            private PageInfoModel f11726f;

            /* compiled from: has_live_icon */
            public final class Builder {
                public int f11715a;
                @Nullable
                public ImmutableList<EdgesModel> f11716b;
                @Nullable
                public PageInfoModel f11717c;

                public static Builder m13746a(UnfollowedProfilesModel unfollowedProfilesModel) {
                    Builder builder = new Builder();
                    builder.f11715a = unfollowedProfilesModel.m13765a();
                    builder.f11716b = unfollowedProfilesModel.m13769j();
                    builder.f11717c = unfollowedProfilesModel.m13770k();
                    return builder;
                }

                public final UnfollowedProfilesModel m13747a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11716b);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f11717c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f11715a, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new UnfollowedProfilesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: has_live_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UnfollowedProfilesModel.class, new Deserializer());
                }

                public Object m13748a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UnfollowedProfilesParser.m13828a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object unfollowedProfilesModel = new UnfollowedProfilesModel();
                    ((BaseModel) unfollowedProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (unfollowedProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) unfollowedProfilesModel).a();
                    }
                    return unfollowedProfilesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1500628722)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FBFeedAwesomizerProfileListCardProfileFragmentModel f11720d;
                private long f11721e;

                /* compiled from: has_live_icon */
                public final class Builder {
                    @Nullable
                    public FBFeedAwesomizerProfileListCardProfileFragmentModel f11718a;
                    public long f11719b;

                    public final EdgesModel m13749a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f11718a);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.a(1, this.f11719b, 0);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m13750a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UnfollowedProfilesParser.EdgesParser.m13824b(jsonParser, flatBufferBuilder));
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

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m13751a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m13752a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UnfollowedProfilesParser.EdgesParser.m13825b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final FBFeedAwesomizerProfileListCardProfileFragmentModel m13753a() {
                    this.f11720d = (FBFeedAwesomizerProfileListCardProfileFragmentModel) super.a(this.f11720d, 0, FBFeedAwesomizerProfileListCardProfileFragmentModel.class);
                    return this.f11720d;
                }

                public final long m13756j() {
                    a(0, 1);
                    return this.f11721e;
                }

                public final int jK_() {
                    return -1352607440;
                }

                public final GraphQLVisitableModel m13754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13753a() != null) {
                        FBFeedAwesomizerProfileListCardProfileFragmentModel fBFeedAwesomizerProfileListCardProfileFragmentModel = (FBFeedAwesomizerProfileListCardProfileFragmentModel) graphQLModelMutatingVisitor.b(m13753a());
                        if (m13753a() != fBFeedAwesomizerProfileListCardProfileFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11720d = fBFeedAwesomizerProfileListCardProfileFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13752a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13753a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f11721e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13755a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11721e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_live_icon */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11722d;
                private boolean f11723e;

                /* compiled from: has_live_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m13757a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UnfollowedProfilesParser.PageInfoParser.m13826a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: has_live_icon */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m13758a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m13759a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UnfollowedProfilesParser.PageInfoParser.m13827a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m13761a() {
                    this.f11722d = super.a(this.f11722d, 0);
                    return this.f11722d;
                }

                public final boolean m13763j() {
                    a(0, 1);
                    return this.f11723e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m13760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13759a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13761a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f11723e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13762a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11723e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: has_live_icon */
            public class Serializer extends JsonSerializer<UnfollowedProfilesModel> {
                public final void m13764a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UnfollowedProfilesModel unfollowedProfilesModel = (UnfollowedProfilesModel) obj;
                    if (unfollowedProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(unfollowedProfilesModel.m13766a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        unfollowedProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UnfollowedProfilesParser.m13829a(unfollowedProfilesModel.w_(), unfollowedProfilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UnfollowedProfilesModel.class, new Serializer());
                }
            }

            public UnfollowedProfilesModel() {
                super(3);
            }

            public UnfollowedProfilesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m13765a() {
                a(0, 0);
                return this.f11724d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m13769j() {
                this.f11725e = super.a(this.f11725e, 1, EdgesModel.class);
                return (ImmutableList) this.f11725e;
            }

            @Nullable
            public final PageInfoModel m13770k() {
                this.f11726f = (PageInfoModel) super.a(this.f11726f, 2, PageInfoModel.class);
                return this.f11726f;
            }

            public final int jK_() {
                return -1771681775;
            }

            public final GraphQLVisitableModel m13767a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m13769j() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13769j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        UnfollowedProfilesModel unfollowedProfilesModel = (UnfollowedProfilesModel) ModelHelper.a(null, this);
                        unfollowedProfilesModel.f11725e = a.b();
                        graphQLVisitableModel = unfollowedProfilesModel;
                        if (m13770k() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13770k());
                            if (m13770k() != pageInfoModel) {
                                graphQLVisitableModel = (UnfollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11726f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13770k() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13770k());
                    if (m13770k() != pageInfoModel) {
                        graphQLVisitableModel = (UnfollowedProfilesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11726f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13766a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13769j());
                int a2 = ModelHelper.a(flatBufferBuilder, m13770k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f11724d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13768a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11724d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public FeedAwesomizerUnfollowingQueryModel() {
            super(1);
        }

        @Nullable
        public final UnfollowedProfilesModel m13772a() {
            this.f11727d = (UnfollowedProfilesModel) super.a(this.f11727d, 0, UnfollowedProfilesModel.class);
            return this.f11727d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13772a() != null) {
                UnfollowedProfilesModel unfollowedProfilesModel = (UnfollowedProfilesModel) graphQLModelMutatingVisitor.b(m13772a());
                if (m13772a() != unfollowedProfilesModel) {
                    graphQLVisitableModel = (FeedAwesomizerUnfollowingQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11727d = unfollowedProfilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13771a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13772a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
