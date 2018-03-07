package com.facebook.api.graphql.poll;

import com.facebook.api.graphql.poll.FetchPollVotersGraphQLParsers.FetchPollVotersParser;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLParsers.FetchPollVotersParser.VotersParser;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLParsers.FetchPollVotersParser.VotersParser.NodesParser;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLParsers.FetchPollVotersParser.VotersParser.PageInfoParser;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsParsers.VideoHomeBadgeSubParser;
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

/* compiled from: video_editing_cancel */
public class FetchPollVotersGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -912219136)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_editing_cancel */
    public final class FetchPollVotersModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private VotersModel f590d;

        /* compiled from: video_editing_cancel */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPollVotersModel.class, new Deserializer());
            }

            public Object m636a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPollVotersParser.m675a(jsonParser);
                Object fetchPollVotersModel = new FetchPollVotersModel();
                ((BaseModel) fetchPollVotersModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPollVotersModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPollVotersModel).a();
                }
                return fetchPollVotersModel;
            }
        }

        /* compiled from: video_editing_cancel */
        public class Serializer extends JsonSerializer<FetchPollVotersModel> {
            public final void m637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPollVotersModel fetchPollVotersModel = (FetchPollVotersModel) obj;
                if (fetchPollVotersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPollVotersModel.m666a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPollVotersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPollVotersModel.w_();
                int u_ = fetchPollVotersModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("voters");
                    VideoHomeBadgeSubParser.m19763a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPollVotersModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -307026855)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_editing_cancel */
        public final class VotersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f588d;
            @Nullable
            private PageInfoModel f589e;

            /* compiled from: video_editing_cancel */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VotersModel.class, new Deserializer());
                }

                public Object m638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VotersParser.m674a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object votersModel = new VotersModel();
                    ((BaseModel) votersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (votersModel instanceof Postprocessable) {
                        return ((Postprocessable) votersModel).a();
                    }
                    return votersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 311514124)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_editing_cancel */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLFriendshipStatus f579d;
                @Nullable
                private String f580e;
                @Nullable
                private String f581f;
                @Nullable
                private DefaultImageFieldsModel f582g;

                /* compiled from: video_editing_cancel */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m671b(jsonParser, flatBufferBuilder));
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

                /* compiled from: video_editing_cancel */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m643a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoHomeBadgeSubParser.m19764b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields ho_() {
                    return m642j();
                }

                public NodesModel() {
                    super(4);
                }

                public final void m646a(String str, ConsistencyTuple consistencyTuple) {
                    if ("friendship_status".equals(str)) {
                        consistencyTuple.a = m648b();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m647a(String str, Object obj, boolean z) {
                    if ("friendship_status".equals(str)) {
                        m641a((GraphQLFriendshipStatus) obj);
                    }
                }

                @Nullable
                public final GraphQLFriendshipStatus m648b() {
                    this.f579d = (GraphQLFriendshipStatus) super.b(this.f579d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f579d;
                }

                private void m641a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                    this.f579d = graphQLFriendshipStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                    }
                }

                @Nullable
                public final String m649c() {
                    this.f580e = super.a(this.f580e, 1);
                    return this.f580e;
                }

                @Nullable
                public final String m650d() {
                    this.f581f = super.a(this.f581f, 2);
                    return this.f581f;
                }

                @Nullable
                private DefaultImageFieldsModel m642j() {
                    this.f582g = (DefaultImageFieldsModel) super.a(this.f582g, 3, DefaultImageFieldsModel.class);
                    return this.f582g;
                }

                @Nullable
                public final String m645a() {
                    return m649c();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m644a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m642j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m642j());
                        if (m642j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f582g = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m643a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m648b());
                    int b = flatBufferBuilder.b(m649c());
                    int b2 = flatBufferBuilder.b(m650d());
                    int a2 = ModelHelper.a(flatBufferBuilder, m642j());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1536830492)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_editing_cancel */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f583d;
                @Nullable
                private String f584e;
                private boolean f585f;
                private boolean f586g;
                @Nullable
                private String f587h;

                /* compiled from: video_editing_cancel */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m651a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m672a(jsonParser, flatBufferBuilder));
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

                /* compiled from: video_editing_cancel */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m652a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m654a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m673a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(5);
                }

                @Nullable
                private String m653m() {
                    this.f583d = super.a(this.f583d, 0);
                    return this.f583d;
                }

                @Nullable
                public final String m656a() {
                    this.f584e = super.a(this.f584e, 1);
                    return this.f584e;
                }

                public final boolean m658j() {
                    a(0, 2);
                    return this.f585f;
                }

                public final boolean m659k() {
                    a(0, 3);
                    return this.f586g;
                }

                @Nullable
                public final String m660l() {
                    this.f587h = super.a(this.f587h, 4);
                    return this.f587h;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m655a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m654a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m653m());
                    int b2 = flatBufferBuilder.b(m656a());
                    int b3 = flatBufferBuilder.b(m660l());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.a(2, this.f585f);
                    flatBufferBuilder.a(3, this.f586g);
                    flatBufferBuilder.b(4, b3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m657a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f585f = mutableFlatBuffer.a(i, 2);
                    this.f586g = mutableFlatBuffer.a(i, 3);
                }
            }

            /* compiled from: video_editing_cancel */
            public class Serializer extends JsonSerializer<VotersModel> {
                public final void m661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VotersModel votersModel = (VotersModel) obj;
                    if (votersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(votersModel.m662a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        votersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoHomeBadgeSubParser.m19763a(votersModel.w_(), votersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VotersModel.class, new Serializer());
                }
            }

            public VotersModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m664a() {
                this.f588d = super.a(this.f588d, 0, NodesModel.class);
                return (ImmutableList) this.f588d;
            }

            @Nullable
            public final PageInfoModel m665j() {
                this.f589e = (PageInfoModel) super.a(this.f589e, 1, PageInfoModel.class);
                return this.f589e;
            }

            public final int jK_() {
                return 280409636;
            }

            public final GraphQLVisitableModel m663a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m664a() != null) {
                    Builder a = ModelHelper.a(m664a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        VotersModel votersModel = (VotersModel) ModelHelper.a(null, this);
                        votersModel.f588d = a.b();
                        graphQLVisitableModel = votersModel;
                        if (m665j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m665j());
                            if (m665j() != pageInfoModel) {
                                graphQLVisitableModel = (VotersModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f589e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m665j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m665j());
                    if (m665j() != pageInfoModel) {
                        graphQLVisitableModel = (VotersModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f589e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m662a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m664a());
                int a2 = ModelHelper.a(flatBufferBuilder, m665j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchPollVotersModel() {
            super(1);
        }

        public final void m669a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m670a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final VotersModel m667a() {
            this.f590d = (VotersModel) super.a(this.f590d, 0, VotersModel.class);
            return this.f590d;
        }

        public final int jK_() {
            return 955873307;
        }

        public final GraphQLVisitableModel m668a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m667a() != null) {
                VotersModel votersModel = (VotersModel) graphQLModelMutatingVisitor.b(m667a());
                if (m667a() != votersModel) {
                    graphQLVisitableModel = (FetchPollVotersModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f590d = votersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m666a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m667a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
