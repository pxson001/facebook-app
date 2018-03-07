package com.facebook.browser.liteclient.protocol;

import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.InteractorsFriendParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.InteractorsFriendParser.NodesParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.InteractorsFriendParser.NodesParser.ProfilePictureParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.InteractorsNotFriendParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.LikersParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryFeedbackUsingIDParser.TopLevelCommentsParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryGetUrlContextParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryGetUrlContextParser.AllShareStoriesParser;
import com.facebook.browser.liteclient.protocol.BrowserGraphQlFragmentsParsers.QueryGetUrlContextParser.TitleParser;
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
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser;
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

/* compiled from: max_child_locations */
public class BrowserGraphQlFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1586610780)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: max_child_locations */
    public final class QueryFeedbackUsingIDModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f5543d;
        private boolean f5544e;
        private boolean f5545f;
        private boolean f5546g;
        @Nullable
        private String f5547h;
        @Nullable
        private InteractorsFriendModel f5548i;
        @Nullable
        private InteractorsNotFriendModel f5549j;
        @Nullable
        private String f5550k;
        @Nullable
        private LikersModel f5551l;
        @Nullable
        private TopLevelCommentsModel f5552m;

        /* compiled from: max_child_locations */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QueryFeedbackUsingIDModel.class, new Deserializer());
            }

            public Object m6762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QueryFeedbackUsingIDParser.m6869a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object queryFeedbackUsingIDModel = new QueryFeedbackUsingIDModel();
                ((BaseModel) queryFeedbackUsingIDModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (queryFeedbackUsingIDModel instanceof Postprocessable) {
                    return ((Postprocessable) queryFeedbackUsingIDModel).a();
                }
                return queryFeedbackUsingIDModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2041736597)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class InteractorsFriendModel extends BaseModel implements GraphQLVisitableModel {
            private int f5535d;
            @Nullable
            private List<NodesModel> f5536e;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InteractorsFriendModel.class, new Deserializer());
                }

                public Object m6763a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InteractorsFriendParser.m6857a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object interactorsFriendModel = new InteractorsFriendModel();
                    ((BaseModel) interactorsFriendModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (interactorsFriendModel instanceof Postprocessable) {
                        return ((Postprocessable) interactorsFriendModel).a();
                    }
                    return interactorsFriendModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2103280009)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: max_child_locations */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f5533d;
                @Nullable
                private ProfilePictureModel f5534e;

                /* compiled from: max_child_locations */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6764a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m6856b(jsonParser, flatBufferBuilder));
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
                /* compiled from: max_child_locations */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5532d;

                    /* compiled from: max_child_locations */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m6765a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m6855a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: max_child_locations */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m6766a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m6768a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FetchTimelineSingleCollectionViewQueryParser.m14745a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    private String m6767a() {
                        this.f5532d = super.a(this.f5532d, 0);
                        return this.f5532d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m6769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6768a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6767a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: max_child_locations */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6773a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchTimelineSingleCollectionViewQueryParser.m14748b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m6775a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6776a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m6771a() {
                    if (this.b != null && this.f5533d == null) {
                        this.f5533d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5533d;
                }

                @Nullable
                private ProfilePictureModel m6772j() {
                    this.f5534e = (ProfilePictureModel) super.a(this.f5534e, 1, ProfilePictureModel.class);
                    return this.f5534e;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m6774a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6772j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m6772j());
                        if (m6772j() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5534e = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6773a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6771a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6772j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<InteractorsFriendModel> {
                public final void m6777a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InteractorsFriendModel interactorsFriendModel = (InteractorsFriendModel) obj;
                    if (interactorsFriendModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(interactorsFriendModel.m6779a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        interactorsFriendModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InteractorsFriendParser.m6858a(interactorsFriendModel.w_(), interactorsFriendModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InteractorsFriendModel.class, new Serializer());
                }
            }

            public InteractorsFriendModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<NodesModel> m6778a() {
                this.f5536e = super.a(this.f5536e, 1, NodesModel.class);
                return (ImmutableList) this.f5536e;
            }

            public final int jK_() {
                return 1567367000;
            }

            public final GraphQLVisitableModel m6780a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6778a() != null) {
                    Builder a = ModelHelper.a(m6778a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (InteractorsFriendModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5536e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6779a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6778a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5535d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6781a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5535d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1678533409)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class InteractorsNotFriendModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5540d;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InteractorsNotFriendModel.class, new Deserializer());
                }

                public Object m6782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InteractorsNotFriendParser.m6863a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object interactorsNotFriendModel = new InteractorsNotFriendModel();
                    ((BaseModel) interactorsNotFriendModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (interactorsNotFriendModel instanceof Postprocessable) {
                        return ((Postprocessable) interactorsNotFriendModel).a();
                    }
                    return interactorsNotFriendModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1482298422)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: max_child_locations */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f5538d;
                @Nullable
                private ProfilePictureModel f5539e;

                /* compiled from: max_child_locations */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6783a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(InteractorsNotFriendParser.NodesParser.m6861b(jsonParser, flatBufferBuilder));
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
                /* compiled from: max_child_locations */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5537d;

                    /* compiled from: max_child_locations */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m6784a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(InteractorsNotFriendParser.NodesParser.ProfilePictureParser.m6859a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: max_child_locations */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m6785a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m6787a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            InteractorsNotFriendParser.NodesParser.ProfilePictureParser.m6860a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    private String m6786a() {
                        this.f5537d = super.a(this.f5537d, 0);
                        return this.f5537d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m6788a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6787a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6786a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: max_child_locations */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6792a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        InteractorsNotFriendParser.NodesParser.m6862b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m6794a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6795a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m6790a() {
                    if (this.b != null && this.f5538d == null) {
                        this.f5538d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5538d;
                }

                @Nullable
                private ProfilePictureModel m6791j() {
                    this.f5539e = (ProfilePictureModel) super.a(this.f5539e, 1, ProfilePictureModel.class);
                    return this.f5539e;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m6793a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6791j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m6791j());
                        if (m6791j() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5539e = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6792a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6790a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6791j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<InteractorsNotFriendModel> {
                public final void m6796a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InteractorsNotFriendModel interactorsNotFriendModel = (InteractorsNotFriendModel) obj;
                    if (interactorsNotFriendModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(interactorsNotFriendModel.m6798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        interactorsNotFriendModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InteractorsNotFriendParser.m6864a(interactorsNotFriendModel.w_(), interactorsNotFriendModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InteractorsNotFriendModel.class, new Serializer());
                }
            }

            public InteractorsNotFriendModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m6797a() {
                this.f5540d = super.a(this.f5540d, 0, NodesModel.class);
                return (ImmutableList) this.f5540d;
            }

            public final int jK_() {
                return 1567367000;
            }

            public final GraphQLVisitableModel m6799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6797a() != null) {
                    Builder a = ModelHelper.a(m6797a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (InteractorsNotFriendModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5540d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6797a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f5541d;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m6800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m6865a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m6801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m6803a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m6866a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public final int m6802a() {
                a(0, 0);
                return this.f5541d;
            }

            public final void m6805a(int i) {
                this.f5541d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m6804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6803a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5541d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6806a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5541d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: max_child_locations */
        public class Serializer extends JsonSerializer<QueryFeedbackUsingIDModel> {
            public final void m6807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                QueryFeedbackUsingIDModel queryFeedbackUsingIDModel = (QueryFeedbackUsingIDModel) obj;
                if (queryFeedbackUsingIDModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(queryFeedbackUsingIDModel.m6827a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    queryFeedbackUsingIDModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = queryFeedbackUsingIDModel.w_();
                int u_ = queryFeedbackUsingIDModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_see_voice_switcher");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_comment");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                int g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("interactors_friend");
                    InteractorsFriendParser.m6858a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("interactors_not_friend");
                    InteractorsNotFriendParser.m6864a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("legacy_api_post_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 7));
                }
                g = mutableFlatBuffer.g(u_, 8);
                if (g != 0) {
                    jsonGenerator.a("likers");
                    LikersParser.m6866a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 9);
                if (g != 0) {
                    jsonGenerator.a("top_level_comments");
                    TopLevelCommentsParser.m6868a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(QueryFeedbackUsingIDModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class TopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f5542d;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m6808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m6867a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topLevelCommentsModel = new TopLevelCommentsModel();
                    ((BaseModel) topLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topLevelCommentsModel instanceof Postprocessable) {
                        return ((Postprocessable) topLevelCommentsModel).a();
                    }
                    return topLevelCommentsModel;
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m6809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m6811a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m6868a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(1);
            }

            public final int m6810a() {
                a(0, 0);
                return this.f5542d;
            }

            public final void m6813a(int i) {
                this.f5542d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m6812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6811a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5542d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6814a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5542d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public QueryFeedbackUsingIDModel() {
            super(10);
        }

        public final void m6831a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m6818j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m6819k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m6820l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel q = m6825q();
                    if (q != null) {
                        consistencyTuple.a = Integer.valueOf(q.m6802a());
                        consistencyTuple.b = q.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    TopLevelCommentsModel r = m6826r();
                    if (r != null) {
                        consistencyTuple.a = Integer.valueOf(r.m6810a());
                        consistencyTuple.b = r.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }
        }

        public final void m6832a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m6815a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m6816b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m6817c(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel q = m6825q();
                if (q == null) {
                    return;
                }
                if (z) {
                    q = (LikersModel) q.clone();
                    q.m6805a(((Integer) obj).intValue());
                    this.f5551l = q;
                    return;
                }
                q.m6805a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                TopLevelCommentsModel r = m6826r();
                if (r == null) {
                    return;
                }
                if (z) {
                    r = (TopLevelCommentsModel) r.clone();
                    r.m6813a(((Integer) obj).intValue());
                    this.f5552m = r;
                    return;
                }
                r.m6813a(((Integer) obj).intValue());
            }
        }

        private boolean m6818j() {
            a(0, 1);
            return this.f5544e;
        }

        private void m6815a(boolean z) {
            this.f5544e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        private boolean m6819k() {
            a(0, 2);
            return this.f5545f;
        }

        private void m6816b(boolean z) {
            this.f5545f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        private boolean m6820l() {
            a(0, 3);
            return this.f5546g;
        }

        private void m6817c(boolean z) {
            this.f5546g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        @Nullable
        private String m6821m() {
            this.f5547h = super.a(this.f5547h, 4);
            return this.f5547h;
        }

        @Nullable
        private InteractorsFriendModel m6822n() {
            this.f5548i = (InteractorsFriendModel) super.a(this.f5548i, 5, InteractorsFriendModel.class);
            return this.f5548i;
        }

        @Nullable
        private InteractorsNotFriendModel m6823o() {
            this.f5549j = (InteractorsNotFriendModel) super.a(this.f5549j, 6, InteractorsNotFriendModel.class);
            return this.f5549j;
        }

        @Nullable
        private String m6824p() {
            this.f5550k = super.a(this.f5550k, 7);
            return this.f5550k;
        }

        @Nullable
        private LikersModel m6825q() {
            this.f5551l = (LikersModel) super.a(this.f5551l, 8, LikersModel.class);
            return this.f5551l;
        }

        @Nullable
        private TopLevelCommentsModel m6826r() {
            this.f5552m = (TopLevelCommentsModel) super.a(this.f5552m, 9, TopLevelCommentsModel.class);
            return this.f5552m;
        }

        @Nullable
        public final String m6829a() {
            return m6824p();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m6828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6822n() != null) {
                InteractorsFriendModel interactorsFriendModel = (InteractorsFriendModel) graphQLModelMutatingVisitor.b(m6822n());
                if (m6822n() != interactorsFriendModel) {
                    graphQLVisitableModel = (QueryFeedbackUsingIDModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5548i = interactorsFriendModel;
                }
            }
            if (m6823o() != null) {
                InteractorsNotFriendModel interactorsNotFriendModel = (InteractorsNotFriendModel) graphQLModelMutatingVisitor.b(m6823o());
                if (m6823o() != interactorsNotFriendModel) {
                    graphQLVisitableModel = (QueryFeedbackUsingIDModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5549j = interactorsNotFriendModel;
                }
            }
            if (m6825q() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m6825q());
                if (m6825q() != likersModel) {
                    graphQLVisitableModel = (QueryFeedbackUsingIDModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5551l = likersModel;
                }
            }
            if (m6826r() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m6826r());
                if (m6826r() != topLevelCommentsModel) {
                    graphQLVisitableModel = (QueryFeedbackUsingIDModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5552m = topLevelCommentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6827a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6821m());
            int a = ModelHelper.a(flatBufferBuilder, m6822n());
            int a2 = ModelHelper.a(flatBufferBuilder, m6823o());
            int b2 = flatBufferBuilder.b(m6824p());
            int a3 = ModelHelper.a(flatBufferBuilder, m6825q());
            int a4 = ModelHelper.a(flatBufferBuilder, m6826r());
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, this.f5543d);
            flatBufferBuilder.a(1, this.f5544e);
            flatBufferBuilder.a(2, this.f5545f);
            flatBufferBuilder.a(3, this.f5546g);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, a);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6830a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5543d = mutableFlatBuffer.a(i, 0);
            this.f5544e = mutableFlatBuffer.a(i, 1);
            this.f5545f = mutableFlatBuffer.a(i, 2);
            this.f5546g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1255720685)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: max_child_locations */
    public final class QueryGetUrlContextModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f5555d;
        @Nullable
        private AllShareStoriesModel f5556e;
        @Nullable
        private String f5557f;
        @Nullable
        private String f5558g;
        @Nullable
        private TitleModel f5559h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class AllShareStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f5553d;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllShareStoriesModel.class, new Deserializer());
                }

                public Object m6833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllShareStoriesParser.m6870a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allShareStoriesModel = new AllShareStoriesModel();
                    ((BaseModel) allShareStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allShareStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) allShareStoriesModel).a();
                    }
                    return allShareStoriesModel;
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<AllShareStoriesModel> {
                public final void m6834a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) obj;
                    if (allShareStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allShareStoriesModel.m6835a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allShareStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllShareStoriesParser.m6871a(allShareStoriesModel.w_(), allShareStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AllShareStoriesModel.class, new Serializer());
                }
            }

            public AllShareStoriesModel() {
                super(1);
            }

            public final int jK_() {
                return -1051680685;
            }

            public final GraphQLVisitableModel m6836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6835a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5553d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6837a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5553d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: max_child_locations */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QueryGetUrlContextModel.class, new Deserializer());
            }

            public Object m6838a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = QueryGetUrlContextParser.m6874a(jsonParser);
                Object queryGetUrlContextModel = new QueryGetUrlContextModel();
                ((BaseModel) queryGetUrlContextModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (queryGetUrlContextModel instanceof Postprocessable) {
                    return ((Postprocessable) queryGetUrlContextModel).a();
                }
                return queryGetUrlContextModel;
            }
        }

        /* compiled from: max_child_locations */
        public class Serializer extends JsonSerializer<QueryGetUrlContextModel> {
            public final void m6839a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                QueryGetUrlContextModel queryGetUrlContextModel = (QueryGetUrlContextModel) obj;
                if (queryGetUrlContextModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(queryGetUrlContextModel.m6850a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    queryGetUrlContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = queryGetUrlContextModel.w_();
                int u_ = queryGetUrlContextModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("all_share_stories");
                    AllShareStoriesParser.m6871a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("external_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m6873a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(QueryGetUrlContextModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: max_child_locations */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5554d;

            /* compiled from: max_child_locations */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m6840a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m6872a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: max_child_locations */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m6841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m6843a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m6873a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            private String m6842a() {
                this.f5554d = super.a(this.f5554d, 0);
                return this.f5554d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m6844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6843a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6842a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public QueryGetUrlContextModel() {
            super(5);
        }

        public final void m6853a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6854a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m6845j() {
            if (this.b != null && this.f5555d == null) {
                this.f5555d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f5555d;
        }

        @Nullable
        private AllShareStoriesModel m6846k() {
            this.f5556e = (AllShareStoriesModel) super.a(this.f5556e, 1, AllShareStoriesModel.class);
            return this.f5556e;
        }

        @Nullable
        private String m6847l() {
            this.f5557f = super.a(this.f5557f, 2);
            return this.f5557f;
        }

        @Nullable
        private String m6848m() {
            this.f5558g = super.a(this.f5558g, 3);
            return this.f5558g;
        }

        @Nullable
        private TitleModel m6849n() {
            this.f5559h = (TitleModel) super.a(this.f5559h, 4, TitleModel.class);
            return this.f5559h;
        }

        @Nullable
        public final String m6852a() {
            return m6848m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m6851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6846k() != null) {
                AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) graphQLModelMutatingVisitor.b(m6846k());
                if (m6846k() != allShareStoriesModel) {
                    graphQLVisitableModel = (QueryGetUrlContextModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5556e = allShareStoriesModel;
                }
            }
            if (m6849n() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m6849n());
                if (m6849n() != titleModel) {
                    graphQLVisitableModel = (QueryGetUrlContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5559h = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6850a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6845j());
            int a2 = ModelHelper.a(flatBufferBuilder, m6846k());
            int b = flatBufferBuilder.b(m6847l());
            int b2 = flatBufferBuilder.b(m6848m());
            int a3 = ModelHelper.a(flatBufferBuilder, m6849n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
