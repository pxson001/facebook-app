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
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLParsers.FetchMarketplaceCrossPostShowSettingsParser;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLParsers.FetchMarketplaceCrossPostShowSettingsParser.GroupSellConfigParser;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLParsers.FetchMarketplaceCrossPostShowSettingsParser.GroupSellConfigParser.EdgesParser;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLParsers.FetchMarketplaceCrossPostShowSettingsParser.GroupSellConfigParser.EdgesParser.NodeParser;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLParsers.FetchMarketplaceCrossPostShowSettingsParser.GroupSellConfigParser.EdgesParser.NodeParser.MarketplaceCrossPostSettingParser;
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

/* compiled from: recommendation_like_fail */
public class FetchMarketplaceCrossPostShowSettingsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 246491991)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: recommendation_like_fail */
    public final class FetchMarketplaceCrossPostShowSettingsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupSellConfigModel f5394d;

        /* compiled from: recommendation_like_fail */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMarketplaceCrossPostShowSettingsModel.class, new Deserializer());
            }

            public Object m5896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMarketplaceCrossPostShowSettingsParser.m5932a(jsonParser);
                Object fetchMarketplaceCrossPostShowSettingsModel = new FetchMarketplaceCrossPostShowSettingsModel();
                ((BaseModel) fetchMarketplaceCrossPostShowSettingsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMarketplaceCrossPostShowSettingsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMarketplaceCrossPostShowSettingsModel).a();
                }
                return fetchMarketplaceCrossPostShowSettingsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1155158157)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recommendation_like_fail */
        public final class GroupSellConfigModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5393d;

            /* compiled from: recommendation_like_fail */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupSellConfigModel.class, new Deserializer());
                }

                public Object m5897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupSellConfigParser.m5930a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 1440732141)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recommendation_like_fail */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5392d;

                /* compiled from: recommendation_like_fail */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m5898a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m5928b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 372240669)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recommendation_like_fail */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private MarketplaceCrossPostSettingModel f5391d;

                    /* compiled from: recommendation_like_fail */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m5899a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m5926a(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -53246143)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: recommendation_like_fail */
                    public final class MarketplaceCrossPostSettingModel extends BaseModel implements GraphQLVisitableModel {
                        private boolean f5388d;
                        private boolean f5389e;
                        private boolean f5390f;

                        /* compiled from: recommendation_like_fail */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(MarketplaceCrossPostSettingModel.class, new Deserializer());
                            }

                            public Object m5900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(MarketplaceCrossPostSettingParser.m5924a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object marketplaceCrossPostSettingModel = new MarketplaceCrossPostSettingModel();
                                ((BaseModel) marketplaceCrossPostSettingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (marketplaceCrossPostSettingModel instanceof Postprocessable) {
                                    return ((Postprocessable) marketplaceCrossPostSettingModel).a();
                                }
                                return marketplaceCrossPostSettingModel;
                            }
                        }

                        /* compiled from: recommendation_like_fail */
                        public class Serializer extends JsonSerializer<MarketplaceCrossPostSettingModel> {
                            public final void m5901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = (MarketplaceCrossPostSettingModel) obj;
                                if (marketplaceCrossPostSettingModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(marketplaceCrossPostSettingModel.m5902a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    marketplaceCrossPostSettingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                MarketplaceCrossPostSettingParser.m5925a(marketplaceCrossPostSettingModel.w_(), marketplaceCrossPostSettingModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(MarketplaceCrossPostSettingModel.class, new Serializer());
                            }
                        }

                        public MarketplaceCrossPostSettingModel() {
                            super(3);
                        }

                        public final boolean m5905a() {
                            a(0, 2);
                            return this.f5390f;
                        }

                        public final int jK_() {
                            return -1582934902;
                        }

                        public final GraphQLVisitableModel m5903a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m5902a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, this.f5388d);
                            flatBufferBuilder.a(1, this.f5389e);
                            flatBufferBuilder.a(2, this.f5390f);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m5904a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f5388d = mutableFlatBuffer.a(i, 0);
                            this.f5389e = mutableFlatBuffer.a(i, 1);
                            this.f5390f = mutableFlatBuffer.a(i, 2);
                        }
                    }

                    /* compiled from: recommendation_like_fail */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m5906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m5907a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m5927a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    @Nullable
                    public final MarketplaceCrossPostSettingModel m5909a() {
                        this.f5391d = (MarketplaceCrossPostSettingModel) super.a(this.f5391d, 0, MarketplaceCrossPostSettingModel.class);
                        return this.f5391d;
                    }

                    public final int jK_() {
                        return -482299661;
                    }

                    public final GraphQLVisitableModel m5908a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5909a() != null) {
                            MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = (MarketplaceCrossPostSettingModel) graphQLModelMutatingVisitor.b(m5909a());
                            if (m5909a() != marketplaceCrossPostSettingModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5391d = marketplaceCrossPostSettingModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5907a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m5909a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: recommendation_like_fail */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m5910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m5911a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m5929b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m5913a() {
                    this.f5392d = (NodeModel) super.a(this.f5392d, 0, NodeModel.class);
                    return this.f5392d;
                }

                public final int jK_() {
                    return -85434922;
                }

                public final GraphQLVisitableModel m5912a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5913a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m5913a());
                        if (m5913a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5392d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5911a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5913a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: recommendation_like_fail */
            public class Serializer extends JsonSerializer<GroupSellConfigModel> {
                public final void m5914a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) obj;
                    if (groupSellConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupSellConfigModel.m5915a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupSellConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupSellConfigParser.m5931a(groupSellConfigModel.w_(), groupSellConfigModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupSellConfigModel.class, new Serializer());
                }
            }

            public GroupSellConfigModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m5917a() {
                this.f5393d = super.a(this.f5393d, 0, EdgesModel.class);
                return (ImmutableList) this.f5393d;
            }

            public final int jK_() {
                return -461031369;
            }

            public final GraphQLVisitableModel m5916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5917a() != null) {
                    Builder a = ModelHelper.a(m5917a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupSellConfigModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5393d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5915a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5917a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: recommendation_like_fail */
        public class Serializer extends JsonSerializer<FetchMarketplaceCrossPostShowSettingsModel> {
            public final void m5918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMarketplaceCrossPostShowSettingsModel fetchMarketplaceCrossPostShowSettingsModel = (FetchMarketplaceCrossPostShowSettingsModel) obj;
                if (fetchMarketplaceCrossPostShowSettingsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMarketplaceCrossPostShowSettingsModel.m5919a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMarketplaceCrossPostShowSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMarketplaceCrossPostShowSettingsModel.w_();
                int u_ = fetchMarketplaceCrossPostShowSettingsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_sell_config");
                    GroupSellConfigParser.m5931a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMarketplaceCrossPostShowSettingsModel.class, new Serializer());
            }
        }

        public FetchMarketplaceCrossPostShowSettingsModel() {
            super(1);
        }

        public final void m5922a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5923a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupSellConfigModel m5921a() {
            this.f5394d = (GroupSellConfigModel) super.a(this.f5394d, 0, GroupSellConfigModel.class);
            return this.f5394d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m5920a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5921a() != null) {
                GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) graphQLModelMutatingVisitor.b(m5921a());
                if (m5921a() != groupSellConfigModel) {
                    graphQLVisitableModel = (FetchMarketplaceCrossPostShowSettingsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5394d = groupSellConfigModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5919a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5921a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
