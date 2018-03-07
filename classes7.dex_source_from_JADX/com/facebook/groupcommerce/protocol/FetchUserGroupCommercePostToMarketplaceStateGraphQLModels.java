package com.facebook.groupcommerce.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLParsers.UserGroupCommercePostToMarketplaceStateQueryParser;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLParsers.UserGroupCommercePostToMarketplaceStateQueryParser.GroupSellConfigParser;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLParsers.UserGroupCommercePostToMarketplaceStateQueryParser.GroupSellConfigParser.EdgesParser;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLParsers.UserGroupCommercePostToMarketplaceStateQueryParser.GroupSellConfigParser.EdgesParser.NodeParser;
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

/* compiled from: recent_search */
public class FetchUserGroupCommercePostToMarketplaceStateGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1523217694)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: recent_search */
    public final class UserGroupCommercePostToMarketplaceStateQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupSellConfigModel f5398d;

        /* compiled from: recent_search */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserGroupCommercePostToMarketplaceStateQueryModel.class, new Deserializer());
            }

            public Object m5934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserGroupCommercePostToMarketplaceStateQueryParser.m5963a(jsonParser);
                Object userGroupCommercePostToMarketplaceStateQueryModel = new UserGroupCommercePostToMarketplaceStateQueryModel();
                ((BaseModel) userGroupCommercePostToMarketplaceStateQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userGroupCommercePostToMarketplaceStateQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) userGroupCommercePostToMarketplaceStateQueryModel).a();
                }
                return userGroupCommercePostToMarketplaceStateQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1406662776)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recent_search */
        public final class GroupSellConfigModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5397d;

            /* compiled from: recent_search */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupSellConfigModel.class, new Deserializer());
                }

                public Object m5935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupSellConfigParser.m5961a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupSellConfigModel = new GroupSellConfigModel();
                    ((BaseModel) groupSellConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupSellConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) groupSellConfigModel).a();
                    }
                    return groupSellConfigModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 564068976)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recent_search */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5396d;

                /* compiled from: recent_search */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m5936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m5959b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1347297012)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recent_search */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    private boolean f5395d;

                    /* compiled from: recent_search */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m5937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m5957a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: recent_search */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m5938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m5939a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m5958a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public final boolean m5942a() {
                        a(0, 0);
                        return this.f5395d;
                    }

                    public final int jK_() {
                        return -482299661;
                    }

                    public final GraphQLVisitableModel m5940a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5939a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f5395d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5941a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f5395d = mutableFlatBuffer.a(i, 0);
                    }
                }

                /* compiled from: recent_search */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m5943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m5944a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m5960b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m5946a() {
                    this.f5396d = (NodeModel) super.a(this.f5396d, 0, NodeModel.class);
                    return this.f5396d;
                }

                public final int jK_() {
                    return -85434922;
                }

                public final GraphQLVisitableModel m5945a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5946a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m5946a());
                        if (m5946a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5396d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5944a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5946a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: recent_search */
            public class Serializer extends JsonSerializer<GroupSellConfigModel> {
                public final void m5947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) obj;
                    if (groupSellConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupSellConfigModel.m5948a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupSellConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupSellConfigParser.m5962a(groupSellConfigModel.w_(), groupSellConfigModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupSellConfigModel.class, new Serializer());
                }
            }

            public GroupSellConfigModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m5950a() {
                this.f5397d = super.a(this.f5397d, 0, EdgesModel.class);
                return (ImmutableList) this.f5397d;
            }

            public final int jK_() {
                return -461031369;
            }

            public final GraphQLVisitableModel m5949a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5950a() != null) {
                    Builder a = ModelHelper.a(m5950a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupSellConfigModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5397d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5948a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5950a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: recent_search */
        public class Serializer extends JsonSerializer<UserGroupCommercePostToMarketplaceStateQueryModel> {
            public final void m5951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserGroupCommercePostToMarketplaceStateQueryModel userGroupCommercePostToMarketplaceStateQueryModel = (UserGroupCommercePostToMarketplaceStateQueryModel) obj;
                if (userGroupCommercePostToMarketplaceStateQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userGroupCommercePostToMarketplaceStateQueryModel.m5952a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userGroupCommercePostToMarketplaceStateQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userGroupCommercePostToMarketplaceStateQueryModel.w_();
                int u_ = userGroupCommercePostToMarketplaceStateQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_sell_config");
                    GroupSellConfigParser.m5962a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserGroupCommercePostToMarketplaceStateQueryModel.class, new Serializer());
            }
        }

        public UserGroupCommercePostToMarketplaceStateQueryModel() {
            super(1);
        }

        public final void m5955a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5956a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupSellConfigModel m5954a() {
            this.f5398d = (GroupSellConfigModel) super.a(this.f5398d, 0, GroupSellConfigModel.class);
            return this.f5398d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m5953a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5954a() != null) {
                GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) graphQLModelMutatingVisitor.b(m5954a());
                if (m5954a() != groupSellConfigModel) {
                    graphQLVisitableModel = (UserGroupCommercePostToMarketplaceStateQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5398d = groupSellConfigModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5952a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5954a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
