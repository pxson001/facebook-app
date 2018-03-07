package com.facebook.redspace.protocol;

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
import com.facebook.graphql.enums.GraphQLRedSpaceActivityType;
import com.facebook.graphql.enums.GraphQLRedSpaceUserAttributeType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.CoverPhotoParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.CoverPhotoParser.PhotoParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.ActivitiesParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.ActivitiesParser.NodesParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.AttributesParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.RecentStoryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.StoriesParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.StoriesParser.ApproximateUnreadCountParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFeedProfileFragmentParser.RedspaceParser.StoriesParser.NodesParser.AttachedStoryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsOverflowCountQueryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsOverflowCountQueryParser.RedspaceParser.OverflowFriendsParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsOverflowCountQueryParser.RedspaceParser.OverflowFriendsParser.ApproximateCountParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsQueryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsQueryParser.ActorParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceFriendsQueryParser.RedspaceParser.FriendsParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpacePageInfoParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.CityHubParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.CityHubParser.WeatherConditionParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.IconParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.TimezoneInfoParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceStoriesQueryParser.RedspaceParser.WallParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceUnreadFriendsQueryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.NodesParser.NodesRedspaceParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.NodesParser.NodesRedspaceParser.StoriesParser.StoriesNodesParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceVisitFragmentParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceVisitFragmentParser.VisitorParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceVisitsQueryParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceVisitsQueryParser.RedspaceParser.VisitsParser;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsParsers.RedSpaceWallItemFragmentParser;
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

/* compiled from: should_force_new_fetch */
public class RedSpaceFeedFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1554532921)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceFeedProfileFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private CoverPhotoModel f4428d;
        @Nullable
        private String f4429e;
        @Nullable
        private DefaultImageFieldsModel f4430f;
        @Nullable
        private RedspaceModel f4431g;
        @Nullable
        private DefaultNameFieldsModel f4432h;

        /* compiled from: should_force_new_fetch */
        public final class Builder {
            @Nullable
            public CoverPhotoModel f4391a;
            @Nullable
            public String f4392b;
            @Nullable
            public DefaultImageFieldsModel f4393c;
            @Nullable
            public RedspaceModel f4394d;
            @Nullable
            public DefaultNameFieldsModel f4395e;

            public final RedSpaceFeedProfileFragmentModel m6473a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4391a);
                int b = flatBufferBuilder.b(this.f4392b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4393c);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f4394d);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f4395e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RedSpaceFeedProfileFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -438390518)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f4399d;

            /* compiled from: should_force_new_fetch */
            public final class Builder {
                @Nullable
                public PhotoModel f4396a;

                public final CoverPhotoModel m6474a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f4396a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m6475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m6824a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1236209140)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultImageFieldsModel f4398d;

                /* compiled from: should_force_new_fetch */
                public final class Builder {
                    @Nullable
                    public DefaultImageFieldsModel f4397a;

                    public final PhotoModel m6476a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f4397a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m6477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m6822a(jsonParser, flatBufferBuilder));
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

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m6478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m6479a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m6823a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(1);
                }

                public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final DefaultImageFieldsModel m6480a() {
                    this.f4398d = (DefaultImageFieldsModel) super.a(this.f4398d, 0, DefaultImageFieldsModel.class);
                    return this.f4398d;
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m6481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6480a() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m6480a());
                        if (m6480a() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4398d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6479a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6480a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m6482a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m6483a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m6825a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(1);
            }

            public CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final PhotoModel m6485a() {
                this.f4399d = (PhotoModel) super.a(this.f4399d, 0, PhotoModel.class);
                return this.f4399d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m6484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6485a() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m6485a());
                    if (m6485a() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4399d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6483a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6485a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFeedProfileFragmentModel.class, new Deserializer());
            }

            public Object m6486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RedSpaceFeedProfileFragmentParser.m6846b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object redSpaceFeedProfileFragmentModel = new RedSpaceFeedProfileFragmentModel();
                ((BaseModel) redSpaceFeedProfileFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (redSpaceFeedProfileFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFeedProfileFragmentModel).a();
                }
                return redSpaceFeedProfileFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2008668058)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActivitiesModel f4423d;
            @Nullable
            private List<AttributesModel> f4424e;
            @Nullable
            private String f4425f;
            @Nullable
            private RecentStoryModel f4426g;
            @Nullable
            private StoriesModel f4427h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -548164708)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class ActivitiesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f4402d;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActivitiesModel.class, new Deserializer());
                    }

                    public Object m6487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActivitiesParser.m6828a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object activitiesModel = new ActivitiesModel();
                        ((BaseModel) activitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (activitiesModel instanceof Postprocessable) {
                            return ((Postprocessable) activitiesModel).a();
                        }
                        return activitiesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 28663612)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f4400d;
                    @Nullable
                    private GraphQLRedSpaceActivityType f4401e;

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m6827b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6491a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m6826a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLObjectType m6490j() {
                        if (this.b != null && this.f4400d == null) {
                            this.f4400d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f4400d;
                    }

                    @Nullable
                    public final GraphQLRedSpaceActivityType m6492a() {
                        this.f4401e = (GraphQLRedSpaceActivityType) super.b(this.f4401e, 1, GraphQLRedSpaceActivityType.class, GraphQLRedSpaceActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f4401e;
                    }

                    public final int jK_() {
                        return -1537945276;
                    }

                    public final GraphQLVisitableModel m6493a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6491a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6490j());
                        int a2 = flatBufferBuilder.a(m6492a());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<ActivitiesModel> {
                    public final void m6494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActivitiesModel activitiesModel = (ActivitiesModel) obj;
                        if (activitiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(activitiesModel.m6495a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            activitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActivitiesParser.m6829a(activitiesModel.w_(), activitiesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ActivitiesModel.class, new Serializer());
                    }
                }

                public ActivitiesModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6497a() {
                    this.f4402d = super.a(this.f4402d, 0, NodesModel.class);
                    return (ImmutableList) this.f4402d;
                }

                public final int jK_() {
                    return 1705609568;
                }

                public final GraphQLVisitableModel m6496a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6497a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6497a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ActivitiesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4402d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6495a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6497a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2130092585)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class AttributesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f4403d;
                @Nullable
                private GraphQLRedSpaceUserAttributeType f4404e;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AttributesModel.class, new Deserializer());
                    }

                    public Object m6498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AttributesParser.m6831b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object attributesModel = new AttributesModel();
                        ((BaseModel) attributesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (attributesModel instanceof Postprocessable) {
                            return ((Postprocessable) attributesModel).a();
                        }
                        return attributesModel;
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<AttributesModel> {
                    public final void m6499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AttributesModel attributesModel = (AttributesModel) obj;
                        if (attributesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(attributesModel.m6501a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            attributesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AttributesParser.m6830a(attributesModel.w_(), attributesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AttributesModel.class, new Serializer());
                    }
                }

                public AttributesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m6500j() {
                    if (this.b != null && this.f4403d == null) {
                        this.f4403d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f4403d;
                }

                @Nullable
                public final GraphQLRedSpaceUserAttributeType m6502a() {
                    this.f4404e = (GraphQLRedSpaceUserAttributeType) super.b(this.f4404e, 1, GraphQLRedSpaceUserAttributeType.class, GraphQLRedSpaceUserAttributeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f4404e;
                }

                public final int jK_() {
                    return -1038438916;
                }

                public final GraphQLVisitableModel m6503a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6501a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6500j());
                    int a2 = flatBufferBuilder.a(m6502a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public final class Builder {
                @Nullable
                public ActivitiesModel f4405a;
                @Nullable
                public ImmutableList<AttributesModel> f4406b;
                @Nullable
                public String f4407c;
                @Nullable
                public RecentStoryModel f4408d;
                @Nullable
                public StoriesModel f4409e;

                public final RedspaceModel m6504a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f4405a);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f4406b);
                    int b = flatBufferBuilder.b(this.f4407c);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f4408d);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f4409e);
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new RedspaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6505a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedspaceParser.m6844a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1911840377)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class RecentStoryModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f4411d;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RecentStoryModel.class, new Deserializer());
                    }

                    public Object m6506a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RecentStoryParser.m6834a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object recentStoryModel = new RecentStoryModel();
                        ((BaseModel) recentStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (recentStoryModel instanceof Postprocessable) {
                            return ((Postprocessable) recentStoryModel).a();
                        }
                        return recentStoryModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1191792094)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    private long f4410d;

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6507a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RecentStoryParser.NodesParser.m6833b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6508a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6509a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RecentStoryParser.NodesParser.m6832a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(1);
                    }

                    public final void m6513a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m6514a(String str, Object obj, boolean z) {
                    }

                    public final long m6510a() {
                        a(0, 0);
                        return this.f4410d;
                    }

                    public final int jK_() {
                        return 80218325;
                    }

                    public final GraphQLVisitableModel m6511a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6509a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f4410d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6512a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4410d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<RecentStoryModel> {
                    public final void m6515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RecentStoryModel recentStoryModel = (RecentStoryModel) obj;
                        if (recentStoryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(recentStoryModel.m6516a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            recentStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RecentStoryParser.m6835a(recentStoryModel.w_(), recentStoryModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RecentStoryModel.class, new Serializer());
                    }
                }

                public RecentStoryModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6518a() {
                    this.f4411d = super.a(this.f4411d, 0, NodesModel.class);
                    return (ImmutableList) this.f4411d;
                }

                public final int jK_() {
                    return 717116145;
                }

                public final GraphQLVisitableModel m6517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6518a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6518a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (RecentStoryModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4411d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6516a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6518a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6551a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedspaceParser.m6845a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 525932556)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class StoriesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ApproximateUnreadCountModel f4421d;
                @Nullable
                private List<NodesModel> f4422e;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1515330131)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class ApproximateUnreadCountModel extends BaseModel implements GraphQLVisitableModel {
                    private int f4414d;
                    private boolean f4415e;

                    /* compiled from: should_force_new_fetch */
                    public final class Builder {
                        public int f4412a;
                        public boolean f4413b;
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ApproximateUnreadCountModel.class, new Deserializer());
                        }

                        public Object m6520a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ApproximateUnreadCountParser.m6836a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object approximateUnreadCountModel = new ApproximateUnreadCountModel();
                            ((BaseModel) approximateUnreadCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (approximateUnreadCountModel instanceof Postprocessable) {
                                return ((Postprocessable) approximateUnreadCountModel).a();
                            }
                            return approximateUnreadCountModel;
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<ApproximateUnreadCountModel> {
                        public final void m6521a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ApproximateUnreadCountModel approximateUnreadCountModel = (ApproximateUnreadCountModel) obj;
                            if (approximateUnreadCountModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(approximateUnreadCountModel.m6523a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                approximateUnreadCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ApproximateUnreadCountParser.m6837a(approximateUnreadCountModel.w_(), approximateUnreadCountModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ApproximateUnreadCountModel.class, new Serializer());
                        }
                    }

                    public ApproximateUnreadCountModel() {
                        super(2);
                    }

                    public ApproximateUnreadCountModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final int m6522a() {
                        a(0, 0);
                        return this.f4414d;
                    }

                    public final boolean m6526j() {
                        a(0, 1);
                        return this.f4415e;
                    }

                    public final int jK_() {
                        return 382256763;
                    }

                    public final GraphQLVisitableModel m6524a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6523a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f4414d, 0);
                        flatBufferBuilder.a(1, this.f4415e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6525a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4414d = mutableFlatBuffer.a(i, 0, 0);
                        this.f4415e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: should_force_new_fetch */
                public final class Builder {
                    @Nullable
                    public ApproximateUnreadCountModel f4416a;
                    @Nullable
                    public ImmutableList<NodesModel> f4417b;

                    public final StoriesModel m6527a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f4416a);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f4417b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new StoriesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(StoriesModel.class, new Deserializer());
                    }

                    public Object m6528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(StoriesParser.m6842a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object storiesModel = new StoriesModel();
                        ((BaseModel) storiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (storiesModel instanceof Postprocessable) {
                            return ((Postprocessable) storiesModel).a();
                        }
                        return storiesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1406506917)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private AttachedStoryModel f4419d;
                    @Nullable
                    private String f4420e;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: should_force_new_fetch */
                    public final class AttachedStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f4418d;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(AttachedStoryModel.class, new Deserializer());
                            }

                            public Object m6529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(AttachedStoryParser.m6838a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object attachedStoryModel = new AttachedStoryModel();
                                ((BaseModel) attachedStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (attachedStoryModel instanceof Postprocessable) {
                                    return ((Postprocessable) attachedStoryModel).a();
                                }
                                return attachedStoryModel;
                            }
                        }

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<AttachedStoryModel> {
                            public final void m6530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                AttachedStoryModel attachedStoryModel = (AttachedStoryModel) obj;
                                if (attachedStoryModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(attachedStoryModel.m6531a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    attachedStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                AttachedStoryParser.m6839a(attachedStoryModel.w_(), attachedStoryModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(AttachedStoryModel.class, new Serializer());
                            }
                        }

                        public AttachedStoryModel() {
                            super(1);
                        }

                        public final void m6534a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m6535a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        public final String m6536j() {
                            this.f4418d = super.a(this.f4418d, 0);
                            return this.f4418d;
                        }

                        @Nullable
                        public final String m6533a() {
                            return m6536j();
                        }

                        public final int jK_() {
                            return 80218325;
                        }

                        public final GraphQLVisitableModel m6532a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6531a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6536j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6537a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(StoriesParser.NodesParser.m6840b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6538a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6539a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            StoriesParser.NodesParser.m6841b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(2);
                    }

                    public final void m6542a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m6543a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final AttachedStoryModel m6544j() {
                        this.f4419d = (AttachedStoryModel) super.a(this.f4419d, 0, AttachedStoryModel.class);
                        return this.f4419d;
                    }

                    @Nullable
                    public final String m6545k() {
                        this.f4420e = super.a(this.f4420e, 1);
                        return this.f4420e;
                    }

                    @Nullable
                    public final String m6541a() {
                        return m6545k();
                    }

                    public final int jK_() {
                        return 80218325;
                    }

                    public final GraphQLVisitableModel m6540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6544j() != null) {
                            AttachedStoryModel attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.b(m6544j());
                            if (m6544j() != attachedStoryModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4419d = attachedStoryModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6539a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6544j());
                        int b = flatBufferBuilder.b(m6545k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<StoriesModel> {
                    public final void m6546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        StoriesModel storiesModel = (StoriesModel) obj;
                        if (storiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(storiesModel.m6547a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            storiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        StoriesParser.m6843a(storiesModel.w_(), storiesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(StoriesModel.class, new Serializer());
                    }
                }

                public StoriesModel() {
                    super(2);
                }

                public StoriesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final ApproximateUnreadCountModel m6549a() {
                    this.f4421d = (ApproximateUnreadCountModel) super.a(this.f4421d, 0, ApproximateUnreadCountModel.class);
                    return this.f4421d;
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6550j() {
                    this.f4422e = super.a(this.f4422e, 1, NodesModel.class);
                    return (ImmutableList) this.f4422e;
                }

                public final int jK_() {
                    return 717116145;
                }

                public final GraphQLVisitableModel m6548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6549a() != null) {
                        ApproximateUnreadCountModel approximateUnreadCountModel = (ApproximateUnreadCountModel) graphQLModelMutatingVisitor.b(m6549a());
                        if (m6549a() != approximateUnreadCountModel) {
                            graphQLVisitableModel = (StoriesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4421d = approximateUnreadCountModel;
                        }
                    }
                    if (m6550j() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6550j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            StoriesModel storiesModel = (StoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                            storiesModel.f4422e = a.b();
                            graphQLVisitableModel = storiesModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6547a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6549a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6550j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public RedspaceModel() {
                super(5);
            }

            public RedspaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(5);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final ActivitiesModel m6553a() {
                this.f4423d = (ActivitiesModel) super.a(this.f4423d, 0, ActivitiesModel.class);
                return this.f4423d;
            }

            @Nonnull
            public final ImmutableList<AttributesModel> m6554j() {
                this.f4424e = super.a(this.f4424e, 1, AttributesModel.class);
                return (ImmutableList) this.f4424e;
            }

            @Nullable
            public final String m6555k() {
                this.f4425f = super.a(this.f4425f, 2);
                return this.f4425f;
            }

            @Nullable
            public final RecentStoryModel m6556l() {
                this.f4426g = (RecentStoryModel) super.a(this.f4426g, 3, RecentStoryModel.class);
                return this.f4426g;
            }

            @Nullable
            public final StoriesModel m6557m() {
                this.f4427h = (StoriesModel) super.a(this.f4427h, 4, StoriesModel.class);
                return this.f4427h;
            }

            public final int jK_() {
                return -148781746;
            }

            public final GraphQLVisitableModel m6552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6553a() != null) {
                    ActivitiesModel activitiesModel = (ActivitiesModel) graphQLModelMutatingVisitor.b(m6553a());
                    if (m6553a() != activitiesModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4423d = activitiesModel;
                    }
                }
                if (m6554j() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6554j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        RedspaceModel redspaceModel = (RedspaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        redspaceModel.f4424e = a.b();
                        graphQLVisitableModel = redspaceModel;
                    }
                }
                if (m6556l() != null) {
                    RecentStoryModel recentStoryModel = (RecentStoryModel) graphQLModelMutatingVisitor.b(m6556l());
                    if (m6556l() != recentStoryModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4426g = recentStoryModel;
                    }
                }
                if (m6557m() != null) {
                    StoriesModel storiesModel = (StoriesModel) graphQLModelMutatingVisitor.b(m6557m());
                    if (m6557m() != storiesModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4427h = storiesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6551a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6553a());
                int a2 = ModelHelper.a(flatBufferBuilder, m6554j());
                int b = flatBufferBuilder.b(m6555k());
                int a3 = ModelHelper.a(flatBufferBuilder, m6556l());
                int a4 = ModelHelper.a(flatBufferBuilder, m6557m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceFeedProfileFragmentModel> {
            public final void m6558a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = (RedSpaceFeedProfileFragmentModel) obj;
                if (redSpaceFeedProfileFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFeedProfileFragmentModel.m6559a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFeedProfileFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RedSpaceFeedProfileFragmentParser.m6847b(redSpaceFeedProfileFragmentModel.w_(), redSpaceFeedProfileFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RedSpaceFeedProfileFragmentModel.class, new Serializer());
            }
        }

        public RedSpaceFeedProfileFragmentModel() {
            super(5);
        }

        public RedSpaceFeedProfileFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m6562a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6563a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CoverPhotoModel m6564j() {
            this.f4428d = (CoverPhotoModel) super.a(this.f4428d, 0, CoverPhotoModel.class);
            return this.f4428d;
        }

        @Nullable
        public final String m6565k() {
            this.f4429e = super.a(this.f4429e, 1);
            return this.f4429e;
        }

        @Nullable
        public final DefaultImageFieldsModel m6566l() {
            this.f4430f = (DefaultImageFieldsModel) super.a(this.f4430f, 2, DefaultImageFieldsModel.class);
            return this.f4430f;
        }

        @Nullable
        public final RedspaceModel m6567m() {
            this.f4431g = (RedspaceModel) super.a(this.f4431g, 3, RedspaceModel.class);
            return this.f4431g;
        }

        @Nullable
        public final DefaultNameFieldsModel m6568n() {
            this.f4432h = (DefaultNameFieldsModel) super.a(this.f4432h, 4, DefaultNameFieldsModel.class);
            return this.f4432h;
        }

        @Nullable
        public final String m6561a() {
            return m6565k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m6560a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6564j() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m6564j());
                if (m6564j() != coverPhotoModel) {
                    graphQLVisitableModel = (RedSpaceFeedProfileFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4428d = coverPhotoModel;
                }
            }
            if (m6566l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m6566l());
                if (m6566l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (RedSpaceFeedProfileFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4430f = defaultImageFieldsModel;
                }
            }
            if (m6567m() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6567m());
                if (m6567m() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceFeedProfileFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4431g = redspaceModel;
                }
            }
            if (m6568n() != null) {
                DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m6568n());
                if (m6568n() != defaultNameFieldsModel) {
                    graphQLVisitableModel = (RedSpaceFeedProfileFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4432h = defaultNameFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6559a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6564j());
            int b = flatBufferBuilder.b(m6565k());
            int a2 = ModelHelper.a(flatBufferBuilder, m6566l());
            int a3 = ModelHelper.a(flatBufferBuilder, m6567m());
            int a4 = ModelHelper.a(flatBufferBuilder, m6568n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 987926944)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceFriendsOverflowCountQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RedspaceModel f4444d;

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFriendsOverflowCountQueryModel.class, new Deserializer());
            }

            public Object m6569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceFriendsOverflowCountQueryParser.m6856a(jsonParser);
                Object redSpaceFriendsOverflowCountQueryModel = new RedSpaceFriendsOverflowCountQueryModel();
                ((BaseModel) redSpaceFriendsOverflowCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceFriendsOverflowCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFriendsOverflowCountQueryModel).a();
                }
                return redSpaceFriendsOverflowCountQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2078619274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private OverflowFriendsModel f4443d;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceFriendsOverflowCountQueryParser.RedspaceParser.m6854a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -824587704)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class OverflowFriendsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ApproximateCountModel f4441d;
                @Nullable
                private List<NodesModel> f4442e;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1515330131)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class ApproximateCountModel extends BaseModel implements GraphQLVisitableModel {
                    private int f4435d;
                    private boolean f4436e;

                    /* compiled from: should_force_new_fetch */
                    public final class Builder {
                        public int f4433a;
                        public boolean f4434b;

                        public static Builder m6571a(ApproximateCountModel approximateCountModel) {
                            Builder builder = new Builder();
                            builder.f4433a = approximateCountModel.m6575a();
                            builder.f4434b = approximateCountModel.m6579j();
                            return builder;
                        }

                        public final ApproximateCountModel m6572a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f4433a, 0);
                            flatBufferBuilder.a(1, this.f4434b);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new ApproximateCountModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ApproximateCountModel.class, new Deserializer());
                        }

                        public Object m6573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ApproximateCountParser.m6848a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object approximateCountModel = new ApproximateCountModel();
                            ((BaseModel) approximateCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (approximateCountModel instanceof Postprocessable) {
                                return ((Postprocessable) approximateCountModel).a();
                            }
                            return approximateCountModel;
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<ApproximateCountModel> {
                        public final void m6574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ApproximateCountModel approximateCountModel = (ApproximateCountModel) obj;
                            if (approximateCountModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(approximateCountModel.m6576a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                approximateCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ApproximateCountParser.m6849a(approximateCountModel.w_(), approximateCountModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ApproximateCountModel.class, new Serializer());
                        }
                    }

                    public ApproximateCountModel() {
                        super(2);
                    }

                    public ApproximateCountModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final int m6575a() {
                        a(0, 0);
                        return this.f4435d;
                    }

                    public final boolean m6579j() {
                        a(0, 1);
                        return this.f4436e;
                    }

                    public final int jK_() {
                        return 382256763;
                    }

                    public final GraphQLVisitableModel m6577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6576a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f4435d, 0);
                        flatBufferBuilder.a(1, this.f4436e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6578a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4435d = mutableFlatBuffer.a(i, 0, 0);
                        this.f4436e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: should_force_new_fetch */
                public final class Builder {
                    @Nullable
                    public ApproximateCountModel f4437a;
                    @Nullable
                    public ImmutableList<NodesModel> f4438b;

                    public static Builder m6580a(OverflowFriendsModel overflowFriendsModel) {
                        Builder builder = new Builder();
                        builder.f4437a = overflowFriendsModel.m6594a();
                        builder.f4438b = overflowFriendsModel.m6595j();
                        return builder;
                    }

                    public final OverflowFriendsModel m6581a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f4437a);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f4438b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new OverflowFriendsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OverflowFriendsModel.class, new Deserializer());
                    }

                    public Object m6582a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OverflowFriendsParser.m6852a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object overflowFriendsModel = new OverflowFriendsModel();
                        ((BaseModel) overflowFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (overflowFriendsModel instanceof Postprocessable) {
                            return ((Postprocessable) overflowFriendsModel).a();
                        }
                        return overflowFriendsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1097398158)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private DefaultImageFieldsModel f4440d;

                    /* compiled from: should_force_new_fetch */
                    public final class Builder {
                        @Nullable
                        public DefaultImageFieldsModel f4439a;

                        public final NodesModel m6583a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f4439a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6584a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OverflowFriendsParser.NodesParser.m6850b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6585a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6586a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OverflowFriendsParser.NodesParser.m6851b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(1);
                    }

                    public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m6589a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m6590a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final DefaultImageFieldsModel m6587a() {
                        this.f4440d = (DefaultImageFieldsModel) super.a(this.f4440d, 0, DefaultImageFieldsModel.class);
                        return this.f4440d;
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m6588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6587a() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m6587a());
                            if (m6587a() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4440d = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6586a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6587a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<OverflowFriendsModel> {
                    public final void m6591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OverflowFriendsModel overflowFriendsModel = (OverflowFriendsModel) obj;
                        if (overflowFriendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(overflowFriendsModel.m6592a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            overflowFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OverflowFriendsParser.m6853a(overflowFriendsModel.w_(), overflowFriendsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OverflowFriendsModel.class, new Serializer());
                    }
                }

                public OverflowFriendsModel() {
                    super(2);
                }

                public OverflowFriendsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final ApproximateCountModel m6594a() {
                    this.f4441d = (ApproximateCountModel) super.a(this.f4441d, 0, ApproximateCountModel.class);
                    return this.f4441d;
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6595j() {
                    this.f4442e = super.a(this.f4442e, 1, NodesModel.class);
                    return (ImmutableList) this.f4442e;
                }

                public final int jK_() {
                    return -596919362;
                }

                public final GraphQLVisitableModel m6593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6594a() != null) {
                        ApproximateCountModel approximateCountModel = (ApproximateCountModel) graphQLModelMutatingVisitor.b(m6594a());
                        if (m6594a() != approximateCountModel) {
                            graphQLVisitableModel = (OverflowFriendsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4441d = approximateCountModel;
                        }
                    }
                    if (m6595j() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6595j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            OverflowFriendsModel overflowFriendsModel = (OverflowFriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                            overflowFriendsModel.f4442e = a.b();
                            graphQLVisitableModel = overflowFriendsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6592a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6594a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6595j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6596a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6597a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceFriendsOverflowCountQueryParser.RedspaceParser.m6855a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            public RedspaceModel() {
                super(1);
            }

            @Nullable
            public final OverflowFriendsModel m6599a() {
                this.f4443d = (OverflowFriendsModel) super.a(this.f4443d, 0, OverflowFriendsModel.class);
                return this.f4443d;
            }

            public final int jK_() {
                return 399824597;
            }

            public final GraphQLVisitableModel m6598a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6599a() != null) {
                    OverflowFriendsModel overflowFriendsModel = (OverflowFriendsModel) graphQLModelMutatingVisitor.b(m6599a());
                    if (m6599a() != overflowFriendsModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4443d = overflowFriendsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6597a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6599a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceFriendsOverflowCountQueryModel> {
            public final void m6600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceFriendsOverflowCountQueryModel redSpaceFriendsOverflowCountQueryModel = (RedSpaceFriendsOverflowCountQueryModel) obj;
                if (redSpaceFriendsOverflowCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFriendsOverflowCountQueryModel.m6601a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFriendsOverflowCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceFriendsOverflowCountQueryModel.w_();
                int u_ = redSpaceFriendsOverflowCountQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("redspace");
                    RedSpaceFriendsOverflowCountQueryParser.RedspaceParser.m6855a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceFriendsOverflowCountQueryModel.class, new Serializer());
            }
        }

        public RedSpaceFriendsOverflowCountQueryModel() {
            super(1);
        }

        @Nullable
        public final RedspaceModel m6603a() {
            this.f4444d = (RedspaceModel) super.a(this.f4444d, 0, RedspaceModel.class);
            return this.f4444d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6603a() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6603a());
                if (m6603a() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceFriendsOverflowCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4444d = redspaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6601a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6603a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2041882604)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceFriendsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f4453d;
        @Nullable
        private RedspaceModel f4454e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1153792592)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f4448d;
            @Nullable
            private RedspaceModel f4449e;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m6604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m6863a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -436326022)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private RecentStoryModel f4447d;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                    }

                    public Object m6605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.RedspaceParser.m6861a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object redspaceModel = new RedspaceModel();
                        ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (redspaceModel instanceof Postprocessable) {
                            return ((Postprocessable) redspaceModel).a();
                        }
                        return redspaceModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 2012442356)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class RecentStoryModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<NodesModel> f4446d;

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RecentStoryModel.class, new Deserializer());
                        }

                        public Object m6606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ActorParser.RedspaceParser.RecentStoryParser.m6859a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object recentStoryModel = new RecentStoryModel();
                            ((BaseModel) recentStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (recentStoryModel instanceof Postprocessable) {
                                return ((Postprocessable) recentStoryModel).a();
                            }
                            return recentStoryModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1191792094)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: should_force_new_fetch */
                    public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                        private long f4445d;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                            }

                            public Object m6607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ActorParser.RedspaceParser.RecentStoryParser.NodesParser.m6858b(jsonParser, flatBufferBuilder));
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

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<NodesModel> {
                            public final void m6608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodesModel nodesModel = (NodesModel) obj;
                                if (nodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodesModel.m6609a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ActorParser.RedspaceParser.RecentStoryParser.NodesParser.m6857a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodesModel.class, new Serializer());
                            }
                        }

                        public NodesModel() {
                            super(1);
                        }

                        public final void m6613a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m6614a(String str, Object obj, boolean z) {
                        }

                        public final long m6610a() {
                            a(0, 0);
                            return this.f4445d;
                        }

                        public final int jK_() {
                            return 80218325;
                        }

                        public final GraphQLVisitableModel m6611a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6609a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.a(0, this.f4445d, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m6612a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f4445d = mutableFlatBuffer.a(i, 0, 0);
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<RecentStoryModel> {
                        public final void m6615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RecentStoryModel recentStoryModel = (RecentStoryModel) obj;
                            if (recentStoryModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(recentStoryModel.m6616a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                recentStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ActorParser.RedspaceParser.RecentStoryParser.m6860a(recentStoryModel.w_(), recentStoryModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(RecentStoryModel.class, new Serializer());
                        }
                    }

                    public RecentStoryModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<NodesModel> m6618a() {
                        this.f4446d = super.a(this.f4446d, 0, NodesModel.class);
                        return (ImmutableList) this.f4446d;
                    }

                    public final int jK_() {
                        return 717116145;
                    }

                    public final GraphQLVisitableModel m6617a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6618a() != null) {
                            Builder a = ModelHelper.a(m6618a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (RecentStoryModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4446d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6616a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6618a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<RedspaceModel> {
                    public final void m6619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RedspaceModel redspaceModel = (RedspaceModel) obj;
                        if (redspaceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(redspaceModel.m6620a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorParser.RedspaceParser.m6862a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                    }
                }

                public RedspaceModel() {
                    super(1);
                }

                @Nullable
                public final RecentStoryModel m6622a() {
                    this.f4447d = (RecentStoryModel) super.a(this.f4447d, 0, RecentStoryModel.class);
                    return this.f4447d;
                }

                public final int jK_() {
                    return -148781746;
                }

                public final GraphQLVisitableModel m6621a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6622a() != null) {
                        RecentStoryModel recentStoryModel = (RecentStoryModel) graphQLModelMutatingVisitor.b(m6622a());
                        if (m6622a() != recentStoryModel) {
                            graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4447d = recentStoryModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6620a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6622a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m6623a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m6625a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m6864a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m6628a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6629a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m6624j() {
                if (this.b != null && this.f4448d == null) {
                    this.f4448d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f4448d;
            }

            @Nullable
            public final RedspaceModel m6627a() {
                this.f4449e = (RedspaceModel) super.a(this.f4449e, 1, RedspaceModel.class);
                return this.f4449e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m6626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6627a() != null) {
                    RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6627a());
                    if (m6627a() != redspaceModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4449e = redspaceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6625a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6624j());
                int a2 = ModelHelper.a(flatBufferBuilder, m6627a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceFriendsQueryModel.class, new Deserializer());
            }

            public Object m6630a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceFriendsQueryParser.m6869a(jsonParser);
                Object redSpaceFriendsQueryModel = new RedSpaceFriendsQueryModel();
                ((BaseModel) redSpaceFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceFriendsQueryModel).a();
                }
                return redSpaceFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -517966419)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FriendsModel f4452d;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceFriendsQueryParser.RedspaceParser.m6867a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 136774089)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RedSpaceFeedProfileFragmentModel> f4450d;
                @Nullable
                private RedSpacePageInfoModel f4451e;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                    }

                    public Object m6632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FriendsParser.m6865a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object friendsModel = new FriendsModel();
                        ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (friendsModel instanceof Postprocessable) {
                            return ((Postprocessable) friendsModel).a();
                        }
                        return friendsModel;
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<FriendsModel> {
                    public final void m6633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FriendsModel friendsModel = (FriendsModel) obj;
                        if (friendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(friendsModel.m6634a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FriendsParser.m6866a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FriendsModel.class, new Serializer());
                    }
                }

                public FriendsModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<RedSpaceFeedProfileFragmentModel> m6636a() {
                    this.f4450d = super.a(this.f4450d, 0, RedSpaceFeedProfileFragmentModel.class);
                    return (ImmutableList) this.f4450d;
                }

                @Nullable
                public final RedSpacePageInfoModel m6637j() {
                    this.f4451e = (RedSpacePageInfoModel) super.a(this.f4451e, 1, RedSpacePageInfoModel.class);
                    return this.f4451e;
                }

                public final int jK_() {
                    return -596919362;
                }

                public final GraphQLVisitableModel m6635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    RedSpacePageInfoModel redSpacePageInfoModel;
                    h();
                    if (m6636a() != null) {
                        Builder a = ModelHelper.a(m6636a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                            friendsModel.f4450d = a.b();
                            graphQLVisitableModel = friendsModel;
                            if (m6637j() != null) {
                                redSpacePageInfoModel = (RedSpacePageInfoModel) graphQLModelMutatingVisitor.b(m6637j());
                                if (m6637j() != redSpacePageInfoModel) {
                                    graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4451e = redSpacePageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m6637j() != null) {
                        redSpacePageInfoModel = (RedSpacePageInfoModel) graphQLModelMutatingVisitor.b(m6637j());
                        if (m6637j() != redSpacePageInfoModel) {
                            graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4451e = redSpacePageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m6634a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6636a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6637j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6639a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceFriendsQueryParser.RedspaceParser.m6868a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            public RedspaceModel() {
                super(1);
            }

            @Nullable
            public final FriendsModel m6641a() {
                this.f4452d = (FriendsModel) super.a(this.f4452d, 0, FriendsModel.class);
                return this.f4452d;
            }

            public final int jK_() {
                return 399824597;
            }

            public final GraphQLVisitableModel m6640a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6641a() != null) {
                    FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m6641a());
                    if (m6641a() != friendsModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4452d = friendsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6639a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6641a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceFriendsQueryModel> {
            public final void m6642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceFriendsQueryModel redSpaceFriendsQueryModel = (RedSpaceFriendsQueryModel) obj;
                if (redSpaceFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceFriendsQueryModel.m6643a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceFriendsQueryModel.w_();
                int u_ = redSpaceFriendsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    ActorParser.m6864a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("redspace");
                    RedSpaceFriendsQueryParser.RedspaceParser.m6868a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceFriendsQueryModel.class, new Serializer());
            }
        }

        public RedSpaceFriendsQueryModel() {
            super(2);
        }

        @Nullable
        public final ActorModel m6645a() {
            this.f4453d = (ActorModel) super.a(this.f4453d, 0, ActorModel.class);
            return this.f4453d;
        }

        @Nullable
        public final RedspaceModel m6646j() {
            this.f4454e = (RedspaceModel) super.a(this.f4454e, 1, RedspaceModel.class);
            return this.f4454e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6644a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6645a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m6645a());
                if (m6645a() != actorModel) {
                    graphQLVisitableModel = (RedSpaceFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4453d = actorModel;
                }
            }
            if (m6646j() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6646j());
                if (m6646j() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceFriendsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4454e = redspaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6643a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6645a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6646j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2005169142)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpacePageInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4457d;
        private boolean f4458e;

        /* compiled from: should_force_new_fetch */
        public final class Builder {
            @Nullable
            public String f4455a;
            public boolean f4456b;
        }

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpacePageInfoModel.class, new Deserializer());
            }

            public Object m6647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RedSpacePageInfoParser.m6870a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object redSpacePageInfoModel = new RedSpacePageInfoModel();
                ((BaseModel) redSpacePageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (redSpacePageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpacePageInfoModel).a();
                }
                return redSpacePageInfoModel;
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpacePageInfoModel> {
            public final void m6648a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RedSpacePageInfoModel redSpacePageInfoModel = (RedSpacePageInfoModel) obj;
                if (redSpacePageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpacePageInfoModel.m6649a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpacePageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RedSpacePageInfoParser.m6871a(redSpacePageInfoModel.w_(), redSpacePageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RedSpacePageInfoModel.class, new Serializer());
            }
        }

        public RedSpacePageInfoModel() {
            super(2);
        }

        public RedSpacePageInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m6651a() {
            this.f4457d = super.a(this.f4457d, 0);
            return this.f4457d;
        }

        public final boolean m6653j() {
            a(0, 1);
            return this.f4458e;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m6650a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6649a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6651a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f4458e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6652a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4458e = mutableFlatBuffer.a(i, 1);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1381586644)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceStoriesQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f4478d;
        @Nullable
        private String f4479e;
        @Nullable
        private RedspaceModel f4480f;

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceStoriesQueryModel.class, new Deserializer());
            }

            public Object m6654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceStoriesQueryParser.m6888a(jsonParser);
                Object redSpaceStoriesQueryModel = new RedSpaceStoriesQueryModel();
                ((BaseModel) redSpaceStoriesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceStoriesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceStoriesQueryModel).a();
                }
                return redSpaceStoriesQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1956000789)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActivitiesModel f4476d;
            @Nullable
            private WallModel f4477e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1433320443)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class ActivitiesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f4473d;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActivitiesModel.class, new Deserializer());
                    }

                    public Object m6655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.m6882a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object activitiesModel = new ActivitiesModel();
                        ((BaseModel) activitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (activitiesModel instanceof Postprocessable) {
                            return ((Postprocessable) activitiesModel).a();
                        }
                        return activitiesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1984446846)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f4464d;
                    @Nullable
                    private GraphQLRedSpaceActivityType f4465e;
                    @Nullable
                    private CityHubModel f4466f;
                    @Nullable
                    private String f4467g;
                    @Nullable
                    private IconModel f4468h;
                    @Nullable
                    private LinkableTextWithEntitiesModel f4469i;
                    @Nullable
                    private String f4470j;
                    @Nullable
                    private TimezoneInfoModel f4471k;
                    @Nullable
                    private String f4472l;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1698017476)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: should_force_new_fetch */
                    public final class CityHubModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f4460d;
                        @Nullable
                        private WeatherConditionModel f4461e;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(CityHubModel.class, new Deserializer());
                            }

                            public Object m6656a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(CityHubParser.m6874a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object cityHubModel = new CityHubModel();
                                ((BaseModel) cityHubModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (cityHubModel instanceof Postprocessable) {
                                    return ((Postprocessable) cityHubModel).a();
                                }
                                return cityHubModel;
                            }
                        }

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<CityHubModel> {
                            public final void m6657a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                CityHubModel cityHubModel = (CityHubModel) obj;
                                if (cityHubModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(cityHubModel.m6664a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    cityHubModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                CityHubParser.m6875a(cityHubModel.w_(), cityHubModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(CityHubModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1457016151)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: should_force_new_fetch */
                        public final class WeatherConditionModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f4459d;

                            /* compiled from: should_force_new_fetch */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(WeatherConditionModel.class, new Deserializer());
                                }

                                public Object m6658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(WeatherConditionParser.m6872a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object weatherConditionModel = new WeatherConditionModel();
                                    ((BaseModel) weatherConditionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (weatherConditionModel instanceof Postprocessable) {
                                        return ((Postprocessable) weatherConditionModel).a();
                                    }
                                    return weatherConditionModel;
                                }
                            }

                            /* compiled from: should_force_new_fetch */
                            public class Serializer extends JsonSerializer<WeatherConditionModel> {
                                public final void m6659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    WeatherConditionModel weatherConditionModel = (WeatherConditionModel) obj;
                                    if (weatherConditionModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(weatherConditionModel.m6660a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        weatherConditionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    WeatherConditionParser.m6873a(weatherConditionModel.w_(), weatherConditionModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(WeatherConditionModel.class, new Serializer());
                                }
                            }

                            public WeatherConditionModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m6662a() {
                                this.f4459d = super.a(this.f4459d, 0);
                                return this.f4459d;
                            }

                            public final int jK_() {
                                return -1346286681;
                            }

                            public final GraphQLVisitableModel m6661a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m6660a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m6662a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public CityHubModel() {
                            super(2);
                        }

                        public final void m6667a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m6668a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private String m6663k() {
                            this.f4460d = super.a(this.f4460d, 0);
                            return this.f4460d;
                        }

                        @Nullable
                        public final WeatherConditionModel m6669j() {
                            this.f4461e = (WeatherConditionModel) super.a(this.f4461e, 1, WeatherConditionModel.class);
                            return this.f4461e;
                        }

                        @Nullable
                        public final String m6666a() {
                            return m6663k();
                        }

                        public final int jK_() {
                            return 2479791;
                        }

                        public final GraphQLVisitableModel m6665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m6669j() != null) {
                                WeatherConditionModel weatherConditionModel = (WeatherConditionModel) graphQLModelMutatingVisitor.b(m6669j());
                                if (m6669j() != weatherConditionModel) {
                                    graphQLVisitableModel = (CityHubModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f4461e = weatherConditionModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m6664a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6663k());
                            int a = ModelHelper.a(flatBufferBuilder, m6669j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6670a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.m6880b(jsonParser, flatBufferBuilder));
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
                    /* compiled from: should_force_new_fetch */
                    public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f4462d;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                            }

                            public Object m6671a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(IconParser.m6876a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object iconModel = new IconModel();
                                ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (iconModel instanceof Postprocessable) {
                                    return ((Postprocessable) iconModel).a();
                                }
                                return iconModel;
                            }
                        }

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<IconModel> {
                            public final void m6672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                IconModel iconModel = (IconModel) obj;
                                if (iconModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(iconModel.m6673a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                IconParser.m6877a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(IconModel.class, new Serializer());
                            }
                        }

                        public IconModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m6675a() {
                            this.f4462d = super.a(this.f4462d, 0);
                            return this.f4462d;
                        }

                        public final int jK_() {
                            return 2273433;
                        }

                        public final GraphQLVisitableModel m6674a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6673a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6675a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6676a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6683a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.NodesParser.m6881b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 855047979)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: should_force_new_fetch */
                    public final class TimezoneInfoModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f4463d;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TimezoneInfoModel.class, new Deserializer());
                            }

                            public Object m6677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TimezoneInfoParser.m6878a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object timezoneInfoModel = new TimezoneInfoModel();
                                ((BaseModel) timezoneInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (timezoneInfoModel instanceof Postprocessable) {
                                    return ((Postprocessable) timezoneInfoModel).a();
                                }
                                return timezoneInfoModel;
                            }
                        }

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<TimezoneInfoModel> {
                            public final void m6678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) obj;
                                if (timezoneInfoModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(timezoneInfoModel.m6679a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    timezoneInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TimezoneInfoParser.m6879a(timezoneInfoModel.w_(), timezoneInfoModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(TimezoneInfoModel.class, new Serializer());
                            }
                        }

                        public TimezoneInfoModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m6681a() {
                            this.f4463d = super.a(this.f4463d, 0);
                            return this.f4463d;
                        }

                        public final int jK_() {
                            return 1290195047;
                        }

                        public final GraphQLVisitableModel m6680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m6679a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m6681a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public NodesModel() {
                        super(9);
                    }

                    @Nullable
                    private GraphQLObjectType m6682q() {
                        if (this.b != null && this.f4464d == null) {
                            this.f4464d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f4464d;
                    }

                    @Nullable
                    public final GraphQLRedSpaceActivityType m6684a() {
                        this.f4465e = (GraphQLRedSpaceActivityType) super.b(this.f4465e, 1, GraphQLRedSpaceActivityType.class, GraphQLRedSpaceActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f4465e;
                    }

                    @Nullable
                    public final CityHubModel m6686j() {
                        this.f4466f = (CityHubModel) super.a(this.f4466f, 2, CityHubModel.class);
                        return this.f4466f;
                    }

                    @Nullable
                    public final String m6687k() {
                        this.f4467g = super.a(this.f4467g, 3);
                        return this.f4467g;
                    }

                    @Nullable
                    public final IconModel m6688l() {
                        this.f4468h = (IconModel) super.a(this.f4468h, 4, IconModel.class);
                        return this.f4468h;
                    }

                    @Nullable
                    public final LinkableTextWithEntitiesModel m6689m() {
                        this.f4469i = (LinkableTextWithEntitiesModel) super.a(this.f4469i, 5, LinkableTextWithEntitiesModel.class);
                        return this.f4469i;
                    }

                    @Nullable
                    public final String m6690n() {
                        this.f4470j = super.a(this.f4470j, 6);
                        return this.f4470j;
                    }

                    @Nullable
                    public final TimezoneInfoModel m6691o() {
                        this.f4471k = (TimezoneInfoModel) super.a(this.f4471k, 7, TimezoneInfoModel.class);
                        return this.f4471k;
                    }

                    @Nullable
                    public final String m6692p() {
                        this.f4472l = super.a(this.f4472l, 8);
                        return this.f4472l;
                    }

                    public final int jK_() {
                        return -1537945276;
                    }

                    public final GraphQLVisitableModel m6685a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6686j() != null) {
                            CityHubModel cityHubModel = (CityHubModel) graphQLModelMutatingVisitor.b(m6686j());
                            if (m6686j() != cityHubModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4466f = cityHubModel;
                            }
                        }
                        if (m6688l() != null) {
                            IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m6688l());
                            if (m6688l() != iconModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4468h = iconModel;
                            }
                        }
                        if (m6689m() != null) {
                            LinkableTextWithEntitiesModel linkableTextWithEntitiesModel = (LinkableTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m6689m());
                            if (m6689m() != linkableTextWithEntitiesModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4469i = linkableTextWithEntitiesModel;
                            }
                        }
                        if (m6691o() != null) {
                            TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) graphQLModelMutatingVisitor.b(m6691o());
                            if (m6691o() != timezoneInfoModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4471k = timezoneInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6683a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6682q());
                        int a2 = flatBufferBuilder.a(m6684a());
                        int a3 = ModelHelper.a(flatBufferBuilder, m6686j());
                        int b = flatBufferBuilder.b(m6687k());
                        int a4 = ModelHelper.a(flatBufferBuilder, m6688l());
                        int a5 = ModelHelper.a(flatBufferBuilder, m6689m());
                        int b2 = flatBufferBuilder.b(m6690n());
                        int a6 = ModelHelper.a(flatBufferBuilder, m6691o());
                        int b3 = flatBufferBuilder.b(m6692p());
                        flatBufferBuilder.c(9);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.b(4, a4);
                        flatBufferBuilder.b(5, a5);
                        flatBufferBuilder.b(6, b2);
                        flatBufferBuilder.b(7, a6);
                        flatBufferBuilder.b(8, b3);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<ActivitiesModel> {
                    public final void m6693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActivitiesModel activitiesModel = (ActivitiesModel) obj;
                        if (activitiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(activitiesModel.m6694a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            activitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RedSpaceStoriesQueryParser.RedspaceParser.ActivitiesParser.m6883a(activitiesModel.w_(), activitiesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ActivitiesModel.class, new Serializer());
                    }
                }

                public ActivitiesModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6696a() {
                    this.f4473d = super.a(this.f4473d, 0, NodesModel.class);
                    return (ImmutableList) this.f4473d;
                }

                public final int jK_() {
                    return 1705609568;
                }

                public final GraphQLVisitableModel m6695a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6696a() != null) {
                        Builder a = ModelHelper.a(m6696a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ActivitiesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4473d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6694a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6696a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceStoriesQueryParser.RedspaceParser.m6886a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6705a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceStoriesQueryParser.RedspaceParser.m6887a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -358829966)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: should_force_new_fetch */
            public final class WallModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RedSpaceWallItemFragmentModel> f4474d;
                @Nullable
                private DefaultPageInfoFieldsModel f4475e;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(WallModel.class, new Deserializer());
                    }

                    public Object m6699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(WallParser.m6884a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object wallModel = new WallModel();
                        ((BaseModel) wallModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (wallModel instanceof Postprocessable) {
                            return ((Postprocessable) wallModel).a();
                        }
                        return wallModel;
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<WallModel> {
                    public final void m6700a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        WallModel wallModel = (WallModel) obj;
                        if (wallModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(wallModel.m6701a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            wallModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        WallParser.m6885a(wallModel.w_(), wallModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(WallModel.class, new Serializer());
                    }
                }

                public WallModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<RedSpaceWallItemFragmentModel> m6703a() {
                    this.f4474d = super.a(this.f4474d, 0, RedSpaceWallItemFragmentModel.class);
                    return (ImmutableList) this.f4474d;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m6704j() {
                    this.f4475e = (DefaultPageInfoFieldsModel) super.a(this.f4475e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f4475e;
                }

                public final int jK_() {
                    return -237610307;
                }

                public final GraphQLVisitableModel m6702a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m6703a() != null) {
                        Builder a = ModelHelper.a(m6703a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            WallModel wallModel = (WallModel) ModelHelper.a(null, this);
                            wallModel.f4474d = a.b();
                            graphQLVisitableModel = wallModel;
                            if (m6704j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m6704j());
                                if (m6704j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (WallModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4475e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m6704j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m6704j());
                        if (m6704j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (WallModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4475e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m6701a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6703a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6704j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public RedspaceModel() {
                super(2);
            }

            @Nullable
            public final ActivitiesModel m6707a() {
                this.f4476d = (ActivitiesModel) super.a(this.f4476d, 0, ActivitiesModel.class);
                return this.f4476d;
            }

            @Nullable
            public final WallModel m6708j() {
                this.f4477e = (WallModel) super.a(this.f4477e, 1, WallModel.class);
                return this.f4477e;
            }

            public final int jK_() {
                return -148781746;
            }

            public final GraphQLVisitableModel m6706a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6707a() != null) {
                    ActivitiesModel activitiesModel = (ActivitiesModel) graphQLModelMutatingVisitor.b(m6707a());
                    if (m6707a() != activitiesModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4476d = activitiesModel;
                    }
                }
                if (m6708j() != null) {
                    WallModel wallModel = (WallModel) graphQLModelMutatingVisitor.b(m6708j());
                    if (m6708j() != wallModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4477e = wallModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6705a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6707a());
                int a2 = ModelHelper.a(flatBufferBuilder, m6708j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceStoriesQueryModel> {
            public final void m6709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceStoriesQueryModel redSpaceStoriesQueryModel = (RedSpaceStoriesQueryModel) obj;
                if (redSpaceStoriesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceStoriesQueryModel.m6712a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceStoriesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceStoriesQueryModel.w_();
                int u_ = redSpaceStoriesQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("redspace");
                    RedSpaceStoriesQueryParser.RedspaceParser.m6887a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceStoriesQueryModel.class, new Serializer());
            }
        }

        public RedSpaceStoriesQueryModel() {
            super(3);
        }

        public final void m6715a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6716a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m6710k() {
            if (this.b != null && this.f4478d == null) {
                this.f4478d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f4478d;
        }

        @Nullable
        private String m6711l() {
            this.f4479e = super.a(this.f4479e, 1);
            return this.f4479e;
        }

        @Nullable
        public final RedspaceModel m6717j() {
            this.f4480f = (RedspaceModel) super.a(this.f4480f, 2, RedspaceModel.class);
            return this.f4480f;
        }

        @Nullable
        public final String m6714a() {
            return m6711l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m6713a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6717j() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6717j());
                if (m6717j() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceStoriesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4480f = redspaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6712a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6710k());
            int b = flatBufferBuilder.b(m6711l());
            int a2 = ModelHelper.a(flatBufferBuilder, m6717j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1341927040)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceUnreadFriendsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RedspaceModel f4494d;

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceUnreadFriendsQueryModel.class, new Deserializer());
            }

            public Object m6718a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceUnreadFriendsQueryParser.m6905a(jsonParser);
                Object redSpaceUnreadFriendsQueryModel = new RedSpaceUnreadFriendsQueryModel();
                ((BaseModel) redSpaceUnreadFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceUnreadFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceUnreadFriendsQueryModel).a();
                }
                return redSpaceUnreadFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1802644154)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FriendsModel f4493d;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceUnreadFriendsQueryParser.RedspaceParser.m6903a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -845468704)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ApproximateCountModel f4490d;
                private boolean f4491e;
                @Nullable
                private List<NodesModel> f4492f;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1515330131)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class ApproximateCountModel extends BaseModel implements GraphQLVisitableModel {
                    private int f4481d;
                    private boolean f4482e;

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ApproximateCountModel.class, new Deserializer());
                        }

                        public Object m6720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.ApproximateCountParser.m6889a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object approximateCountModel = new ApproximateCountModel();
                            ((BaseModel) approximateCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (approximateCountModel instanceof Postprocessable) {
                                return ((Postprocessable) approximateCountModel).a();
                            }
                            return approximateCountModel;
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<ApproximateCountModel> {
                        public final void m6721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ApproximateCountModel approximateCountModel = (ApproximateCountModel) obj;
                            if (approximateCountModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(approximateCountModel.m6723a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                approximateCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.ApproximateCountParser.m6890a(approximateCountModel.w_(), approximateCountModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ApproximateCountModel.class, new Serializer());
                        }
                    }

                    public ApproximateCountModel() {
                        super(2);
                    }

                    public final int m6722a() {
                        a(0, 0);
                        return this.f4481d;
                    }

                    public final boolean m6726j() {
                        a(0, 1);
                        return this.f4482e;
                    }

                    public final int jK_() {
                        return 382256763;
                    }

                    public final GraphQLVisitableModel m6724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6723a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f4481d, 0);
                        flatBufferBuilder.a(1, this.f4482e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6725a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4481d = mutableFlatBuffer.a(i, 0, 0);
                        this.f4482e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                    }

                    public Object m6727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.m6901a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object friendsModel = new FriendsModel();
                        ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (friendsModel instanceof Postprocessable) {
                            return ((Postprocessable) friendsModel).a();
                        }
                        return friendsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1794287740)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: should_force_new_fetch */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f4488d;
                    @Nullable
                    private NodesRedspaceModel f4489e;

                    /* compiled from: should_force_new_fetch */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m6728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.NodesParser.m6899b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = -503301813)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: should_force_new_fetch */
                    public final class NodesRedspaceModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private StoriesModel f4487d;

                        /* compiled from: should_force_new_fetch */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodesRedspaceModel.class, new Deserializer());
                            }

                            public Object m6729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodesRedspaceParser.m6897a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object nodesRedspaceModel = new NodesRedspaceModel();
                                ((BaseModel) nodesRedspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (nodesRedspaceModel instanceof Postprocessable) {
                                    return ((Postprocessable) nodesRedspaceModel).a();
                                }
                                return nodesRedspaceModel;
                            }
                        }

                        /* compiled from: should_force_new_fetch */
                        public class Serializer extends JsonSerializer<NodesRedspaceModel> {
                            public final void m6730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodesRedspaceModel nodesRedspaceModel = (NodesRedspaceModel) obj;
                                if (nodesRedspaceModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodesRedspaceModel.m6753a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodesRedspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodesRedspaceParser.m6898a(nodesRedspaceModel.w_(), nodesRedspaceModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodesRedspaceModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1101673071)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: should_force_new_fetch */
                        public final class StoriesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private List<StoriesNodesModel> f4486d;

                            /* compiled from: should_force_new_fetch */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(StoriesModel.class, new Deserializer());
                                }

                                public Object m6731a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NodesRedspaceParser.StoriesParser.m6895a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object storiesModel = new StoriesModel();
                                    ((BaseModel) storiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (storiesModel instanceof Postprocessable) {
                                        return ((Postprocessable) storiesModel).a();
                                    }
                                    return storiesModel;
                                }
                            }

                            /* compiled from: should_force_new_fetch */
                            public class Serializer extends JsonSerializer<StoriesModel> {
                                public final void m6732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    StoriesModel storiesModel = (StoriesModel) obj;
                                    if (storiesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(storiesModel.m6750a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        storiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NodesRedspaceParser.StoriesParser.m6896a(storiesModel.w_(), storiesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(StoriesModel.class, new Serializer());
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -999892992)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: should_force_new_fetch */
                            public final class StoriesNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                @Nullable
                                private AttachedStoryModel f4484d;
                                @Nullable
                                private String f4485e;

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1801334754)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: should_force_new_fetch */
                                public final class AttachedStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                    @Nullable
                                    private String f4483d;

                                    /* compiled from: should_force_new_fetch */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(AttachedStoryModel.class, new Deserializer());
                                        }

                                        public Object m6733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(StoriesNodesParser.AttachedStoryParser.m6891a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object attachedStoryModel = new AttachedStoryModel();
                                            ((BaseModel) attachedStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (attachedStoryModel instanceof Postprocessable) {
                                                return ((Postprocessable) attachedStoryModel).a();
                                            }
                                            return attachedStoryModel;
                                        }
                                    }

                                    /* compiled from: should_force_new_fetch */
                                    public class Serializer extends JsonSerializer<AttachedStoryModel> {
                                        public final void m6734a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            AttachedStoryModel attachedStoryModel = (AttachedStoryModel) obj;
                                            if (attachedStoryModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(attachedStoryModel.m6735a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                attachedStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            StoriesNodesParser.AttachedStoryParser.m6892a(attachedStoryModel.w_(), attachedStoryModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(AttachedStoryModel.class, new Serializer());
                                        }
                                    }

                                    public AttachedStoryModel() {
                                        super(1);
                                    }

                                    public final void m6738a(String str, ConsistencyTuple consistencyTuple) {
                                        consistencyTuple.a();
                                    }

                                    public final void m6739a(String str, Object obj, boolean z) {
                                    }

                                    @Nullable
                                    public final String m6740j() {
                                        this.f4483d = super.a(this.f4483d, 0);
                                        return this.f4483d;
                                    }

                                    @Nullable
                                    public final String m6737a() {
                                        return m6740j();
                                    }

                                    public final int jK_() {
                                        return 80218325;
                                    }

                                    public final GraphQLVisitableModel m6736a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m6735a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m6740j());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, b);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: should_force_new_fetch */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(StoriesNodesModel.class, new Deserializer());
                                    }

                                    public Object m6741a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(StoriesNodesParser.m6893b(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object storiesNodesModel = new StoriesNodesModel();
                                        ((BaseModel) storiesNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (storiesNodesModel instanceof Postprocessable) {
                                            return ((Postprocessable) storiesNodesModel).a();
                                        }
                                        return storiesNodesModel;
                                    }
                                }

                                /* compiled from: should_force_new_fetch */
                                public class Serializer extends JsonSerializer<StoriesNodesModel> {
                                    public final void m6742a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        StoriesNodesModel storiesNodesModel = (StoriesNodesModel) obj;
                                        if (storiesNodesModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(storiesNodesModel.m6743a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            storiesNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        StoriesNodesParser.m6894b(storiesNodesModel.w_(), storiesNodesModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(StoriesNodesModel.class, new Serializer());
                                    }
                                }

                                public StoriesNodesModel() {
                                    super(2);
                                }

                                public final void m6746a(String str, ConsistencyTuple consistencyTuple) {
                                    consistencyTuple.a();
                                }

                                public final void m6747a(String str, Object obj, boolean z) {
                                }

                                @Nullable
                                public final AttachedStoryModel m6748j() {
                                    this.f4484d = (AttachedStoryModel) super.a(this.f4484d, 0, AttachedStoryModel.class);
                                    return this.f4484d;
                                }

                                @Nullable
                                public final String m6749k() {
                                    this.f4485e = super.a(this.f4485e, 1);
                                    return this.f4485e;
                                }

                                @Nullable
                                public final String m6745a() {
                                    return m6749k();
                                }

                                public final int jK_() {
                                    return 80218325;
                                }

                                public final GraphQLVisitableModel m6744a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m6748j() != null) {
                                        AttachedStoryModel attachedStoryModel = (AttachedStoryModel) graphQLModelMutatingVisitor.b(m6748j());
                                        if (m6748j() != attachedStoryModel) {
                                            graphQLVisitableModel = (StoriesNodesModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f4484d = attachedStoryModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m6743a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m6748j());
                                    int b = flatBufferBuilder.b(m6749k());
                                    flatBufferBuilder.c(2);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.b(1, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            public StoriesModel() {
                                super(1);
                            }

                            @Nonnull
                            public final ImmutableList<StoriesNodesModel> m6752a() {
                                this.f4486d = super.a(this.f4486d, 0, StoriesNodesModel.class);
                                return (ImmutableList) this.f4486d;
                            }

                            public final int jK_() {
                                return 717116145;
                            }

                            public final GraphQLVisitableModel m6751a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m6752a() != null) {
                                    Builder a = ModelHelper.a(m6752a(), graphQLModelMutatingVisitor);
                                    if (a != null) {
                                        graphQLVisitableModel = (StoriesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f4486d = a.b();
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m6750a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m6752a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public NodesRedspaceModel() {
                            super(1);
                        }

                        @Nullable
                        public final StoriesModel m6755a() {
                            this.f4487d = (StoriesModel) super.a(this.f4487d, 0, StoriesModel.class);
                            return this.f4487d;
                        }

                        public final int jK_() {
                            return -148781746;
                        }

                        public final GraphQLVisitableModel m6754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m6755a() != null) {
                                StoriesModel storiesModel = (StoriesModel) graphQLModelMutatingVisitor.b(m6755a());
                                if (m6755a() != storiesModel) {
                                    graphQLVisitableModel = (NodesRedspaceModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f4487d = storiesModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m6753a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m6755a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: should_force_new_fetch */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m6756a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m6757a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.NodesParser.m6900b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(2);
                    }

                    public final void m6760a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m6761a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m6762j() {
                        this.f4488d = super.a(this.f4488d, 0);
                        return this.f4488d;
                    }

                    @Nullable
                    public final NodesRedspaceModel m6763k() {
                        this.f4489e = (NodesRedspaceModel) super.a(this.f4489e, 1, NodesRedspaceModel.class);
                        return this.f4489e;
                    }

                    @Nullable
                    public final String m6759a() {
                        return m6762j();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m6758a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6763k() != null) {
                            NodesRedspaceModel nodesRedspaceModel = (NodesRedspaceModel) graphQLModelMutatingVisitor.b(m6763k());
                            if (m6763k() != nodesRedspaceModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4489e = nodesRedspaceModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6757a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6762j());
                        int a = ModelHelper.a(flatBufferBuilder, m6763k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<FriendsModel> {
                    public final void m6764a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FriendsModel friendsModel = (FriendsModel) obj;
                        if (friendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(friendsModel.m6765a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RedSpaceUnreadFriendsQueryParser.RedspaceParser.FriendsParser.m6902a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FriendsModel.class, new Serializer());
                    }
                }

                public FriendsModel() {
                    super(3);
                }

                @Nullable
                public final ApproximateCountModel m6767a() {
                    this.f4490d = (ApproximateCountModel) super.a(this.f4490d, 0, ApproximateCountModel.class);
                    return this.f4490d;
                }

                @Nonnull
                public final ImmutableList<NodesModel> m6769j() {
                    this.f4492f = super.a(this.f4492f, 2, NodesModel.class);
                    return (ImmutableList) this.f4492f;
                }

                public final int jK_() {
                    return -596919362;
                }

                public final GraphQLVisitableModel m6766a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6767a() != null) {
                        ApproximateCountModel approximateCountModel = (ApproximateCountModel) graphQLModelMutatingVisitor.b(m6767a());
                        if (m6767a() != approximateCountModel) {
                            graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4490d = approximateCountModel;
                        }
                    }
                    if (m6769j() != null) {
                        Builder a = ModelHelper.a(m6769j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            FriendsModel friendsModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                            friendsModel.f4492f = a.b();
                            graphQLVisitableModel = friendsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6765a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6767a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6769j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f4491e);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6768a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4491e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6771a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceUnreadFriendsQueryParser.RedspaceParser.m6904a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            public RedspaceModel() {
                super(1);
            }

            @Nullable
            public final FriendsModel m6773a() {
                this.f4493d = (FriendsModel) super.a(this.f4493d, 0, FriendsModel.class);
                return this.f4493d;
            }

            public final int jK_() {
                return 399824597;
            }

            public final GraphQLVisitableModel m6772a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6773a() != null) {
                    FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m6773a());
                    if (m6773a() != friendsModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4493d = friendsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6771a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6773a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceUnreadFriendsQueryModel> {
            public final void m6774a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceUnreadFriendsQueryModel redSpaceUnreadFriendsQueryModel = (RedSpaceUnreadFriendsQueryModel) obj;
                if (redSpaceUnreadFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceUnreadFriendsQueryModel.m6775a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceUnreadFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceUnreadFriendsQueryModel.w_();
                int u_ = redSpaceUnreadFriendsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("redspace");
                    RedSpaceUnreadFriendsQueryParser.RedspaceParser.m6904a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceUnreadFriendsQueryModel.class, new Serializer());
            }
        }

        public RedSpaceUnreadFriendsQueryModel() {
            super(1);
        }

        @Nullable
        public final RedspaceModel m6777a() {
            this.f4494d = (RedspaceModel) super.a(this.f4494d, 0, RedspaceModel.class);
            return this.f4494d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6776a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6777a() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6777a());
                if (m6777a() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceUnreadFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4494d = redspaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6775a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6777a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1313828086)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceVisitFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f4498d;
        @Nullable
        private VisitorModel f4499e;

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceVisitFragmentModel.class, new Deserializer());
            }

            public Object m6778a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RedSpaceVisitFragmentParser.m6909b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object redSpaceVisitFragmentModel = new RedSpaceVisitFragmentModel();
                ((BaseModel) redSpaceVisitFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (redSpaceVisitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceVisitFragmentModel).a();
                }
                return redSpaceVisitFragmentModel;
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceVisitFragmentModel> {
            public final void m6779a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RedSpaceVisitFragmentModel redSpaceVisitFragmentModel = (RedSpaceVisitFragmentModel) obj;
                if (redSpaceVisitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceVisitFragmentModel.m6790a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceVisitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RedSpaceVisitFragmentParser.m6910b(redSpaceVisitFragmentModel.w_(), redSpaceVisitFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RedSpaceVisitFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1387433814)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class VisitorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f4495d;
            @Nullable
            private DefaultImageFieldsModel f4496e;
            @Nullable
            private DefaultNameFieldsModel f4497f;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VisitorModel.class, new Deserializer());
                }

                public Object m6780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VisitorParser.m6906a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object visitorModel = new VisitorModel();
                    ((BaseModel) visitorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (visitorModel instanceof Postprocessable) {
                        return ((Postprocessable) visitorModel).a();
                    }
                    return visitorModel;
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<VisitorModel> {
                public final void m6781a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VisitorModel visitorModel = (VisitorModel) obj;
                    if (visitorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(visitorModel.m6784a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        visitorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VisitorParser.m6907a(visitorModel.w_(), visitorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VisitorModel.class, new Serializer());
                }
            }

            public VisitorModel() {
                super(3);
            }

            public final void m6787a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6788a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6782k() {
                this.f4495d = super.a(this.f4495d, 0);
                return this.f4495d;
            }

            @Nullable
            public final DefaultImageFieldsModel m6789j() {
                this.f4496e = (DefaultImageFieldsModel) super.a(this.f4496e, 1, DefaultImageFieldsModel.class);
                return this.f4496e;
            }

            @Nullable
            private DefaultNameFieldsModel m6783l() {
                this.f4497f = (DefaultNameFieldsModel) super.a(this.f4497f, 2, DefaultNameFieldsModel.class);
                return this.f4497f;
            }

            @Nullable
            public final String m6786a() {
                return m6782k();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m6785a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6789j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m6789j());
                    if (m6789j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (VisitorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4496e = defaultImageFieldsModel;
                    }
                }
                if (m6783l() != null) {
                    DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m6783l());
                    if (m6783l() != defaultNameFieldsModel) {
                        graphQLVisitableModel = (VisitorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4497f = defaultNameFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6784a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6782k());
                int a = ModelHelper.a(flatBufferBuilder, m6789j());
                int a2 = ModelHelper.a(flatBufferBuilder, m6783l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RedSpaceVisitFragmentModel() {
            super(2);
        }

        public final boolean m6793a() {
            a(0, 0);
            return this.f4498d;
        }

        @Nullable
        public final VisitorModel m6794j() {
            this.f4499e = (VisitorModel) super.a(this.f4499e, 1, VisitorModel.class);
            return this.f4499e;
        }

        public final int jK_() {
            return 751182646;
        }

        public final GraphQLVisitableModel m6791a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6794j() != null) {
                VisitorModel visitorModel = (VisitorModel) graphQLModelMutatingVisitor.b(m6794j());
                if (m6794j() != visitorModel) {
                    graphQLVisitableModel = (RedSpaceVisitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4499e = visitorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6790a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6794j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4498d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6792a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4498d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1715112203)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceVisitsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RedspaceModel f4505d;

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceVisitsQueryModel.class, new Deserializer());
            }

            public Object m6795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RedSpaceVisitsQueryParser.m6915a(jsonParser);
                Object redSpaceVisitsQueryModel = new RedSpaceVisitsQueryModel();
                ((BaseModel) redSpaceVisitsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (redSpaceVisitsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceVisitsQueryModel).a();
                }
                return redSpaceVisitsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1393146395)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_force_new_fetch */
        public final class RedspaceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private VisitsModel f4504d;

            /* compiled from: should_force_new_fetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedspaceModel.class, new Deserializer());
                }

                public Object m6796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedSpaceVisitsQueryParser.RedspaceParser.m6913a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redspaceModel = new RedspaceModel();
                    ((BaseModel) redspaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redspaceModel instanceof Postprocessable) {
                        return ((Postprocessable) redspaceModel).a();
                    }
                    return redspaceModel;
                }
            }

            /* compiled from: should_force_new_fetch */
            public class Serializer extends JsonSerializer<RedspaceModel> {
                public final void m6797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedspaceModel redspaceModel = (RedspaceModel) obj;
                    if (redspaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redspaceModel.m6807a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redspaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedSpaceVisitsQueryParser.RedspaceParser.m6914a(redspaceModel.w_(), redspaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedspaceModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 709260312)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_force_new_fetch */
            public final class VisitsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4500d;
                private int f4501e;
                @Nullable
                private List<RedSpaceVisitFragmentModel> f4502f;
                @Nullable
                private DefaultPageInfoFieldsModel f4503g;

                /* compiled from: should_force_new_fetch */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(VisitsModel.class, new Deserializer());
                    }

                    public Object m6798a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VisitsParser.m6911a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object visitsModel = new VisitsModel();
                        ((BaseModel) visitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (visitsModel instanceof Postprocessable) {
                            return ((Postprocessable) visitsModel).a();
                        }
                        return visitsModel;
                    }
                }

                /* compiled from: should_force_new_fetch */
                public class Serializer extends JsonSerializer<VisitsModel> {
                    public final void m6799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        VisitsModel visitsModel = (VisitsModel) obj;
                        if (visitsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(visitsModel.m6801a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            visitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VisitsParser.m6912a(visitsModel.w_(), visitsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(VisitsModel.class, new Serializer());
                    }
                }

                public VisitsModel() {
                    super(4);
                }

                @Nullable
                public final String m6803a() {
                    this.f4500d = super.a(this.f4500d, 0);
                    return this.f4500d;
                }

                public final int m6805j() {
                    a(0, 1);
                    return this.f4501e;
                }

                @Nonnull
                public final ImmutableList<RedSpaceVisitFragmentModel> m6806k() {
                    this.f4502f = super.a(this.f4502f, 2, RedSpaceVisitFragmentModel.class);
                    return (ImmutableList) this.f4502f;
                }

                @Nullable
                private DefaultPageInfoFieldsModel m6800l() {
                    this.f4503g = (DefaultPageInfoFieldsModel) super.a(this.f4503g, 3, DefaultPageInfoFieldsModel.class);
                    return this.f4503g;
                }

                public final int jK_() {
                    return 1340180155;
                }

                public final GraphQLVisitableModel m6802a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m6806k() != null) {
                        Builder a = ModelHelper.a(m6806k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            VisitsModel visitsModel = (VisitsModel) ModelHelper.a(null, this);
                            visitsModel.f4502f = a.b();
                            graphQLVisitableModel = visitsModel;
                            if (m6800l() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m6800l());
                                if (m6800l() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (VisitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4503g = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m6800l() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m6800l());
                        if (m6800l() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (VisitsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4503g = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m6801a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6803a());
                    int a = ModelHelper.a(flatBufferBuilder, m6806k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6800l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f4501e, 0);
                    flatBufferBuilder.b(2, a);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6804a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4501e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            public RedspaceModel() {
                super(1);
            }

            @Nullable
            public final VisitsModel m6809a() {
                this.f4504d = (VisitsModel) super.a(this.f4504d, 0, VisitsModel.class);
                return this.f4504d;
            }

            public final int jK_() {
                return 399824597;
            }

            public final GraphQLVisitableModel m6808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6809a() != null) {
                    VisitsModel visitsModel = (VisitsModel) graphQLModelMutatingVisitor.b(m6809a());
                    if (m6809a() != visitsModel) {
                        graphQLVisitableModel = (RedspaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4504d = visitsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6807a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6809a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceVisitsQueryModel> {
            public final void m6810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RedSpaceVisitsQueryModel redSpaceVisitsQueryModel = (RedSpaceVisitsQueryModel) obj;
                if (redSpaceVisitsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceVisitsQueryModel.m6811a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceVisitsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = redSpaceVisitsQueryModel.w_();
                int u_ = redSpaceVisitsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("redspace");
                    RedSpaceVisitsQueryParser.RedspaceParser.m6914a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RedSpaceVisitsQueryModel.class, new Serializer());
            }
        }

        public RedSpaceVisitsQueryModel() {
            super(1);
        }

        @Nullable
        public final RedspaceModel m6813a() {
            this.f4505d = (RedspaceModel) super.a(this.f4505d, 0, RedspaceModel.class);
            return this.f4505d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6813a() != null) {
                RedspaceModel redspaceModel = (RedspaceModel) graphQLModelMutatingVisitor.b(m6813a());
                if (m6813a() != redspaceModel) {
                    graphQLVisitableModel = (RedSpaceVisitsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4505d = redspaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6811a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6813a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 115090940)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: should_force_new_fetch */
    public final class RedSpaceWallItemFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f4509d;
        @Nullable
        private GraphQLStory f4510e;
        @Nullable
        private String f4511f;

        /* compiled from: should_force_new_fetch */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f4506a;
            @Nullable
            public GraphQLStory f4507b;
            @Nullable
            public String f4508c;

            public final RedSpaceWallItemFragmentModel m6814a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4506a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4507b);
                int b = flatBufferBuilder.b(this.f4508c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = new RedSpaceWallItemFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
                if (this.f4507b != null) {
                    redSpaceWallItemFragmentModel.m6820j().aN = this.f4507b.U_();
                }
                return redSpaceWallItemFragmentModel;
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RedSpaceWallItemFragmentModel.class, new Deserializer());
            }

            public Object m6815a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RedSpaceWallItemFragmentParser.m6916b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object redSpaceWallItemFragmentModel = new RedSpaceWallItemFragmentModel();
                ((BaseModel) redSpaceWallItemFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (redSpaceWallItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) redSpaceWallItemFragmentModel).a();
                }
                return redSpaceWallItemFragmentModel;
            }
        }

        /* compiled from: should_force_new_fetch */
        public class Serializer extends JsonSerializer<RedSpaceWallItemFragmentModel> {
            public final void m6816a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) obj;
                if (redSpaceWallItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(redSpaceWallItemFragmentModel.m6817a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    redSpaceWallItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RedSpaceWallItemFragmentParser.m6917b(redSpaceWallItemFragmentModel.w_(), redSpaceWallItemFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RedSpaceWallItemFragmentModel.class, new Serializer());
            }
        }

        public RedSpaceWallItemFragmentModel() {
            super(3);
        }

        public RedSpaceWallItemFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m6818a() {
            if (this.b != null && this.f4509d == null) {
                this.f4509d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f4509d;
        }

        @Nullable
        public final GraphQLStory m6820j() {
            this.f4510e = (GraphQLStory) super.a(this.f4510e, 1, GraphQLStory.class);
            return this.f4510e;
        }

        @Nullable
        public final String m6821k() {
            this.f4511f = super.a(this.f4511f, 2);
            return this.f4511f;
        }

        public final int jK_() {
            return 441543218;
        }

        public final GraphQLVisitableModel m6819a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6820j() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m6820j());
                if (m6820j() != graphQLStory) {
                    graphQLVisitableModel = (RedSpaceWallItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4510e = graphQLStory;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6817a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6818a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6820j());
            int b = flatBufferBuilder.b(m6821k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
