package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser.FriendListsParser;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser.FriendListsParser.EdgesParser;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser.FriendListsParser.EdgesParser.NodeParser;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser.FriendListsParser.EdgesParser.NodeParser.ListFeedParser;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQLParsers.FetchGoodFriendsListFeedParser.FriendListsParser.EdgesParser.NodeParser.ListFeedParser.ListFeedEdgesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: monospace */
public class FetchGoodFriendsListFeedGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1171428544)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: monospace */
    public final class FetchGoodFriendsListFeedModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendListsModel f10215d;

        /* compiled from: monospace */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGoodFriendsListFeedModel.class, new Deserializer());
            }

            public Object m15953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGoodFriendsListFeedParser.m15998a(jsonParser);
                Object fetchGoodFriendsListFeedModel = new FetchGoodFriendsListFeedModel();
                ((BaseModel) fetchGoodFriendsListFeedModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGoodFriendsListFeedModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGoodFriendsListFeedModel).a();
                }
                return fetchGoodFriendsListFeedModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 210366984)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: monospace */
        public final class FriendListsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10214d;

            /* compiled from: monospace */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendListsModel.class, new Deserializer());
                }

                public Object m15954a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendListsParser.m15996a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendListsModel = new FriendListsModel();
                    ((BaseModel) friendListsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendListsModel instanceof Postprocessable) {
                        return ((Postprocessable) friendListsModel).a();
                    }
                    return friendListsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 836478075)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: monospace */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10213d;

                /* compiled from: monospace */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m15955a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m15994b(jsonParser, flatBufferBuilder));
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

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 457008882)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: monospace */
                public final class NodeModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private ListFeedModel f10212d;

                    /* compiled from: monospace */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m15956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m15992a(jsonParser, flatBufferBuilder));
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

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -494187975)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: monospace */
                    public final class ListFeedModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<ListFeedEdgesModel> f10210d;
                        @Nullable
                        private DefaultPageInfoFieldsModel f10211e;

                        /* compiled from: monospace */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ListFeedModel.class, new Deserializer());
                            }

                            public Object m15957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ListFeedParser.m15990a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object listFeedModel = new ListFeedModel();
                                ((BaseModel) listFeedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (listFeedModel instanceof Postprocessable) {
                                    return ((Postprocessable) listFeedModel).a();
                                }
                                return listFeedModel;
                            }
                        }

                        @FragmentModelWithBridge
                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 439840350)
                        @JsonSerialize(using = Serializer.class)
                        /* compiled from: monospace */
                        public final class ListFeedEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f10207d;
                            @Nullable
                            private FeedUnit f10208e;
                            @Nullable
                            private String f10209f;

                            /* compiled from: monospace */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ListFeedEdgesModel.class, new Deserializer());
                                }

                                public Object m15958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ListFeedEdgesParser.m15988b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object listFeedEdgesModel = new ListFeedEdgesModel();
                                    ((BaseModel) listFeedEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (listFeedEdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) listFeedEdgesModel).a();
                                    }
                                    return listFeedEdgesModel;
                                }
                            }

                            /* compiled from: monospace */
                            public class Serializer extends JsonSerializer<ListFeedEdgesModel> {
                                public final void m15959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ListFeedEdgesModel listFeedEdgesModel = (ListFeedEdgesModel) obj;
                                    if (listFeedEdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(listFeedEdgesModel.m15963a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        listFeedEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ListFeedEdgesParser.m15989b(listFeedEdgesModel.w_(), listFeedEdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(ListFeedEdgesModel.class, new Serializer());
                                }
                            }

                            public ListFeedEdgesModel() {
                                super(3);
                            }

                            @Nullable
                            private String m15960a() {
                                this.f10207d = super.a(this.f10207d, 0);
                                return this.f10207d;
                            }

                            @Nullable
                            private FeedUnit m15961j() {
                                this.f10208e = (FeedUnit) super.a(this.f10208e, 1, VirtualFlattenableResolverImpl.a);
                                return this.f10208e;
                            }

                            @Nullable
                            private String m15962k() {
                                this.f10209f = super.a(this.f10209f, 2);
                                return this.f10209f;
                            }

                            public final int jK_() {
                                return 458652951;
                            }

                            public final GraphQLVisitableModel m15964a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m15961j() != null) {
                                    FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m15961j());
                                    if (m15961j() != feedUnit) {
                                        graphQLVisitableModel = (ListFeedEdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f10208e = feedUnit;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m15963a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m15960a());
                                int a = ModelHelper.a(flatBufferBuilder, (MutableFlattenable) m15961j());
                                int b2 = flatBufferBuilder.b(m15962k());
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, a);
                                flatBufferBuilder.b(2, b2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: monospace */
                        public class Serializer extends JsonSerializer<ListFeedModel> {
                            public final void m15965a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ListFeedModel listFeedModel = (ListFeedModel) obj;
                                if (listFeedModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(listFeedModel.m15968a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    listFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ListFeedParser.m15991a(listFeedModel.w_(), listFeedModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(ListFeedModel.class, new Serializer());
                            }
                        }

                        public ListFeedModel() {
                            super(2);
                        }

                        @Nonnull
                        private ImmutableList<ListFeedEdgesModel> m15966a() {
                            this.f10210d = super.a(this.f10210d, 0, ListFeedEdgesModel.class);
                            return (ImmutableList) this.f10210d;
                        }

                        @Nullable
                        private DefaultPageInfoFieldsModel m15967j() {
                            this.f10211e = (DefaultPageInfoFieldsModel) super.a(this.f10211e, 1, DefaultPageInfoFieldsModel.class);
                            return this.f10211e;
                        }

                        public final int jK_() {
                            return -904584520;
                        }

                        public final GraphQLVisitableModel m15969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel;
                            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                            h();
                            if (m15966a() != null) {
                                Builder a = ModelHelper.a(m15966a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    ListFeedModel listFeedModel = (ListFeedModel) ModelHelper.a(null, this);
                                    listFeedModel.f10210d = a.b();
                                    graphQLVisitableModel = listFeedModel;
                                    if (m15967j() != null) {
                                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15967j());
                                        if (m15967j() != defaultPageInfoFieldsModel) {
                                            graphQLVisitableModel = (ListFeedModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f10211e = defaultPageInfoFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                }
                            }
                            graphQLVisitableModel = null;
                            if (m15967j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15967j());
                                if (m15967j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (ListFeedModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f10211e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            if (graphQLVisitableModel != null) {
                            }
                        }

                        public final int m15968a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m15966a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m15967j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: monospace */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m15970a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m15972a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m15993a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public final void m15974a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m15975a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private ListFeedModel m15971a() {
                        this.f10212d = (ListFeedModel) super.a(this.f10212d, 0, ListFeedModel.class);
                        return this.f10212d;
                    }

                    public final int jK_() {
                        return 236555388;
                    }

                    public final GraphQLVisitableModel m15973a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m15971a() != null) {
                            ListFeedModel listFeedModel = (ListFeedModel) graphQLModelMutatingVisitor.b(m15971a());
                            if (m15971a() != listFeedModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10212d = listFeedModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m15972a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m15971a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: monospace */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m15976a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m15978a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m15995b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m15977a() {
                    this.f10213d = (NodeModel) super.a(this.f10213d, 0, NodeModel.class);
                    return this.f10213d;
                }

                public final int jK_() {
                    return -1710468652;
                }

                public final GraphQLVisitableModel m15979a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15977a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m15977a());
                        if (m15977a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10213d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15978a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15977a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: monospace */
            public class Serializer extends JsonSerializer<FriendListsModel> {
                public final void m15980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendListsModel friendListsModel = (FriendListsModel) obj;
                    if (friendListsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendListsModel.m15982a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendListsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendListsParser.m15997a(friendListsModel.w_(), friendListsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendListsModel.class, new Serializer());
                }
            }

            public FriendListsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m15981a() {
                this.f10214d = super.a(this.f10214d, 0, EdgesModel.class);
                return (ImmutableList) this.f10214d;
            }

            public final int jK_() {
                return 1679144373;
            }

            public final GraphQLVisitableModel m15983a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15981a() != null) {
                    Builder a = ModelHelper.a(m15981a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendListsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10214d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15982a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15981a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: monospace */
        public class Serializer extends JsonSerializer<FetchGoodFriendsListFeedModel> {
            public final void m15984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGoodFriendsListFeedModel fetchGoodFriendsListFeedModel = (FetchGoodFriendsListFeedModel) obj;
                if (fetchGoodFriendsListFeedModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGoodFriendsListFeedModel.m15986a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGoodFriendsListFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGoodFriendsListFeedModel.w_();
                int u_ = fetchGoodFriendsListFeedModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_lists");
                    FriendListsParser.m15997a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGoodFriendsListFeedModel.class, new Serializer());
            }
        }

        public FetchGoodFriendsListFeedModel() {
            super(1);
        }

        @Nullable
        private FriendListsModel m15985a() {
            this.f10215d = (FriendListsModel) super.a(this.f10215d, 0, FriendListsModel.class);
            return this.f10215d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15985a() != null) {
                FriendListsModel friendListsModel = (FriendListsModel) graphQLModelMutatingVisitor.b(m15985a());
                if (m15985a() != friendListsModel) {
                    graphQLVisitableModel = (FetchGoodFriendsListFeedModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10215d = friendListsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15986a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15985a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
