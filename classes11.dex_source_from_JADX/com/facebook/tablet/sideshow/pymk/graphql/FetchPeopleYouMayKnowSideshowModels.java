package com.facebook.tablet.sideshow.pymk.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser.PeopleYouMayKnowParser;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser.PeopleYouMayKnowParser.NodesParser;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser.PeopleYouMayKnowParser.NodesParser.BioTextParser;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser.PeopleYouMayKnowParser.NodesParser.MutualFriendsParser;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowParsers.FetchPeopleYouMayKnowSideshowParser.PeopleYouMayKnowParser.NodesParser.ProfilePictureParser;
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

/* compiled from: onEndEditingCapture */
public class FetchPeopleYouMayKnowSideshowModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2087647117)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: onEndEditingCapture */
    public final class FetchPeopleYouMayKnowSideshowModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PeopleYouMayKnowModel f4765d;

        /* compiled from: onEndEditingCapture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPeopleYouMayKnowSideshowModel.class, new Deserializer());
            }

            public Object m5920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPeopleYouMayKnowSideshowParser.m5970a(jsonParser);
                Object fetchPeopleYouMayKnowSideshowModel = new FetchPeopleYouMayKnowSideshowModel();
                ((BaseModel) fetchPeopleYouMayKnowSideshowModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPeopleYouMayKnowSideshowModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPeopleYouMayKnowSideshowModel).a();
                }
                return fetchPeopleYouMayKnowSideshowModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -138326423)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: onEndEditingCapture */
        public final class PeopleYouMayKnowModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f4764d;

            /* compiled from: onEndEditingCapture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowModel.class, new Deserializer());
                }

                public Object m5921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeopleYouMayKnowParser.m5968a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object peopleYouMayKnowModel = new PeopleYouMayKnowModel();
                    ((BaseModel) peopleYouMayKnowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (peopleYouMayKnowModel instanceof Postprocessable) {
                        return ((Postprocessable) peopleYouMayKnowModel).a();
                    }
                    return peopleYouMayKnowModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2142818961)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: onEndEditingCapture */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private BioTextModel f4758d;
                @Nullable
                private GraphQLFriendshipStatus f4759e;
                @Nullable
                private String f4760f;
                @Nullable
                private MutualFriendsModel f4761g;
                @Nullable
                private String f4762h;
                @Nullable
                private ProfilePictureModel f4763i;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: onEndEditingCapture */
                public final class BioTextModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f4755d;

                    /* compiled from: onEndEditingCapture */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(BioTextModel.class, new Deserializer());
                        }

                        public Object m5922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(BioTextParser.m5960a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object bioTextModel = new BioTextModel();
                            ((BaseModel) bioTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (bioTextModel instanceof Postprocessable) {
                                return ((Postprocessable) bioTextModel).a();
                            }
                            return bioTextModel;
                        }
                    }

                    /* compiled from: onEndEditingCapture */
                    public class Serializer extends JsonSerializer<BioTextModel> {
                        public final void m5923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            BioTextModel bioTextModel = (BioTextModel) obj;
                            if (bioTextModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(bioTextModel.m5924a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                bioTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            BioTextParser.m5961a(bioTextModel.w_(), bioTextModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(BioTextModel.class, new Serializer());
                        }
                    }

                    public BioTextModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m5926a() {
                        this.f4755d = super.a(this.f4755d, 0);
                        return this.f4755d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m5925a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5924a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m5926a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: onEndEditingCapture */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m5927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m5966b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1723990064)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: onEndEditingCapture */
                public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                    private int f4756d;

                    /* compiled from: onEndEditingCapture */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                        }

                        public Object m5928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MutualFriendsParser.m5962a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: onEndEditingCapture */
                    public class Serializer extends JsonSerializer<MutualFriendsModel> {
                        public final void m5929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                            if (mutualFriendsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(mutualFriendsModel.m5931a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MutualFriendsParser.m5963a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                        }
                    }

                    public MutualFriendsModel() {
                        super(1);
                    }

                    public final int m5930a() {
                        a(0, 0);
                        return this.f4756d;
                    }

                    public final int jK_() {
                        return 1532278911;
                    }

                    public final GraphQLVisitableModel m5932a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5931a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f4756d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5933a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4756d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: onEndEditingCapture */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f4757d;

                    /* compiled from: onEndEditingCapture */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m5934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m5964a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: onEndEditingCapture */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m5935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m5936a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m5965a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m5938a() {
                        this.f4757d = super.a(this.f4757d, 0);
                        return this.f4757d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m5937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5936a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m5938a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: onEndEditingCapture */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m5939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m5941a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m5967b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(6);
                }

                public final void m5944a(String str, ConsistencyTuple consistencyTuple) {
                    if ("friendship_status".equals(str)) {
                        consistencyTuple.a = m5947k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m5945a(String str, Object obj, boolean z) {
                    if ("friendship_status".equals(str)) {
                        m5940a((GraphQLFriendshipStatus) obj);
                    }
                }

                @Nullable
                public final BioTextModel m5946j() {
                    this.f4758d = (BioTextModel) super.a(this.f4758d, 0, BioTextModel.class);
                    return this.f4758d;
                }

                @Nullable
                public final GraphQLFriendshipStatus m5947k() {
                    this.f4759e = (GraphQLFriendshipStatus) super.b(this.f4759e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f4759e;
                }

                private void m5940a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                    this.f4759e = graphQLFriendshipStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                    }
                }

                @Nullable
                public final String m5948l() {
                    this.f4760f = super.a(this.f4760f, 2);
                    return this.f4760f;
                }

                @Nullable
                public final MutualFriendsModel m5949m() {
                    this.f4761g = (MutualFriendsModel) super.a(this.f4761g, 3, MutualFriendsModel.class);
                    return this.f4761g;
                }

                @Nullable
                public final String m5950n() {
                    this.f4762h = super.a(this.f4762h, 4);
                    return this.f4762h;
                }

                @Nullable
                public final ProfilePictureModel m5951o() {
                    this.f4763i = (ProfilePictureModel) super.a(this.f4763i, 5, ProfilePictureModel.class);
                    return this.f4763i;
                }

                @Nullable
                public final String m5943a() {
                    return m5948l();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m5942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5946j() != null) {
                        BioTextModel bioTextModel = (BioTextModel) graphQLModelMutatingVisitor.b(m5946j());
                        if (m5946j() != bioTextModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4758d = bioTextModel;
                        }
                    }
                    if (m5949m() != null) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m5949m());
                        if (m5949m() != mutualFriendsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4761g = mutualFriendsModel;
                        }
                    }
                    if (m5951o() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m5951o());
                        if (m5951o() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4763i = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5941a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5946j());
                    int a2 = flatBufferBuilder.a(m5947k());
                    int b = flatBufferBuilder.b(m5948l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m5949m());
                    int b2 = flatBufferBuilder.b(m5950n());
                    int a4 = ModelHelper.a(flatBufferBuilder, m5951o());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: onEndEditingCapture */
            public class Serializer extends JsonSerializer<PeopleYouMayKnowModel> {
                public final void m5952a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
                    if (peopleYouMayKnowModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peopleYouMayKnowModel.m5953a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peopleYouMayKnowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeopleYouMayKnowParser.m5969a(peopleYouMayKnowModel.w_(), peopleYouMayKnowModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeopleYouMayKnowModel.class, new Serializer());
                }
            }

            public PeopleYouMayKnowModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m5955a() {
                this.f4764d = super.a(this.f4764d, 0, NodesModel.class);
                return (ImmutableList) this.f4764d;
            }

            public final int jK_() {
                return 1781614462;
            }

            public final GraphQLVisitableModel m5954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5955a() != null) {
                    Builder a = ModelHelper.a(m5955a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4764d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5953a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5955a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: onEndEditingCapture */
        public class Serializer extends JsonSerializer<FetchPeopleYouMayKnowSideshowModel> {
            public final void m5956a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPeopleYouMayKnowSideshowModel fetchPeopleYouMayKnowSideshowModel = (FetchPeopleYouMayKnowSideshowModel) obj;
                if (fetchPeopleYouMayKnowSideshowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPeopleYouMayKnowSideshowModel.m5957a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPeopleYouMayKnowSideshowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPeopleYouMayKnowSideshowModel.w_();
                int u_ = fetchPeopleYouMayKnowSideshowModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("people_you_may_know");
                    PeopleYouMayKnowParser.m5969a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPeopleYouMayKnowSideshowModel.class, new Serializer());
            }
        }

        public FetchPeopleYouMayKnowSideshowModel() {
            super(1);
        }

        @Nullable
        public final PeopleYouMayKnowModel m5959a() {
            this.f4765d = (PeopleYouMayKnowModel) super.a(this.f4765d, 0, PeopleYouMayKnowModel.class);
            return this.f4765d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5958a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5959a() != null) {
                PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) graphQLModelMutatingVisitor.b(m5959a());
                if (m5959a() != peopleYouMayKnowModel) {
                    graphQLVisitableModel = (FetchPeopleYouMayKnowSideshowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4765d = peopleYouMayKnowModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5957a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5959a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
