package com.facebook.marketplace;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.marketplace.FBMarketplaceBadgeCountQueryParsers.FBMarketplaceBadgeCountQueryParser;
import com.facebook.marketplace.FBMarketplaceBadgeCountQueryParsers.FBMarketplaceBadgeCountQueryParser.MarketplaceBadgeCountParser;
import com.facebook.marketplace.FBMarketplaceBadgeCountQueryParsers.FBMarketplaceBadgeCountQueryParser.NotifReadnessParser;
import com.facebook.marketplace.FBMarketplaceBadgeCountQueryParsers.FBMarketplaceBadgeCountQueryParser.NotifReadnessParser.EdgesParser;
import com.facebook.marketplace.FBMarketplaceBadgeCountQueryParsers.FBMarketplaceBadgeCountQueryParser.NotifReadnessParser.EdgesParser.NodeParser;
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

/* compiled from: utm_nonce */
public class FBMarketplaceBadgeCountQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -165555043)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: utm_nonce */
    public final class FBMarketplaceBadgeCountQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MarketplaceBadgeCountModel f278d;
        @Nullable
        private NotifReadnessModel f279e;

        /* compiled from: utm_nonce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBMarketplaceBadgeCountQueryModel.class, new Deserializer());
            }

            public Object m298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBMarketplaceBadgeCountQueryParser.m333a(jsonParser);
                Object fBMarketplaceBadgeCountQueryModel = new FBMarketplaceBadgeCountQueryModel();
                ((BaseModel) fBMarketplaceBadgeCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBMarketplaceBadgeCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBMarketplaceBadgeCountQueryModel).a();
                }
                return fBMarketplaceBadgeCountQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -530021489)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: utm_nonce */
        public final class MarketplaceBadgeCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f270d;
            private int f271e;
            private int f272f;
            private int f273g;

            /* compiled from: utm_nonce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MarketplaceBadgeCountModel.class, new Deserializer());
                }

                public Object m299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MarketplaceBadgeCountParser.m325a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object marketplaceBadgeCountModel = new MarketplaceBadgeCountModel();
                    ((BaseModel) marketplaceBadgeCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (marketplaceBadgeCountModel instanceof Postprocessable) {
                        return ((Postprocessable) marketplaceBadgeCountModel).a();
                    }
                    return marketplaceBadgeCountModel;
                }
            }

            /* compiled from: utm_nonce */
            public class Serializer extends JsonSerializer<MarketplaceBadgeCountModel> {
                public final void m300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MarketplaceBadgeCountModel marketplaceBadgeCountModel = (MarketplaceBadgeCountModel) obj;
                    if (marketplaceBadgeCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(marketplaceBadgeCountModel.m301a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        marketplaceBadgeCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MarketplaceBadgeCountParser.m326a(marketplaceBadgeCountModel.w_(), marketplaceBadgeCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MarketplaceBadgeCountModel.class, new Serializer());
                }
            }

            public MarketplaceBadgeCountModel() {
                super(4);
            }

            public final int jK_() {
                return 1164528901;
            }

            public final GraphQLVisitableModel m302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m301a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f270d, 0);
                flatBufferBuilder.a(1, this.f271e, 0);
                flatBufferBuilder.a(2, this.f272f, 0);
                flatBufferBuilder.a(3, this.f273g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m303a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f270d = mutableFlatBuffer.a(i, 0, 0);
                this.f271e = mutableFlatBuffer.a(i, 1, 0);
                this.f272f = mutableFlatBuffer.a(i, 2, 0);
                this.f273g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 630387855)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: utm_nonce */
        public final class NotifReadnessModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f277d;

            /* compiled from: utm_nonce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotifReadnessModel.class, new Deserializer());
                }

                public Object m304a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotifReadnessParser.m331a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object notifReadnessModel = new NotifReadnessModel();
                    ((BaseModel) notifReadnessModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (notifReadnessModel instanceof Postprocessable) {
                        return ((Postprocessable) notifReadnessModel).a();
                    }
                    return notifReadnessModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -48394398)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: utm_nonce */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f276d;

                /* compiled from: utm_nonce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m305a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m329b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 611749739)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: utm_nonce */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f274d;
                    @Nullable
                    private GraphQLStorySeenState f275e;

                    /* compiled from: utm_nonce */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m306a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m327a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: utm_nonce */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m307a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m310a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m328a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    private String m308a() {
                        this.f274d = super.a(this.f274d, 0);
                        return this.f274d;
                    }

                    @Nullable
                    private GraphQLStorySeenState m309j() {
                        this.f275e = (GraphQLStorySeenState) super.b(this.f275e, 1, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f275e;
                    }

                    public final int jK_() {
                        return -1047025729;
                    }

                    public final GraphQLVisitableModel m311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m310a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m308a());
                        int a = flatBufferBuilder.a(m309j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: utm_nonce */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m312a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m314a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m330b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m313a() {
                    this.f276d = (NodeModel) super.a(this.f276d, 0, NodeModel.class);
                    return this.f276d;
                }

                public final int jK_() {
                    return -1047304326;
                }

                public final GraphQLVisitableModel m315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m313a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m313a());
                        if (m313a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f276d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m314a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m313a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: utm_nonce */
            public class Serializer extends JsonSerializer<NotifReadnessModel> {
                public final void m316a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotifReadnessModel notifReadnessModel = (NotifReadnessModel) obj;
                    if (notifReadnessModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notifReadnessModel.m318a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notifReadnessModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotifReadnessParser.m332a(notifReadnessModel.w_(), notifReadnessModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotifReadnessModel.class, new Serializer());
                }
            }

            public NotifReadnessModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m317a() {
                this.f277d = super.a(this.f277d, 0, EdgesModel.class);
                return (ImmutableList) this.f277d;
            }

            public final int jK_() {
                return -1165789477;
            }

            public final GraphQLVisitableModel m319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m317a() != null) {
                    Builder a = ModelHelper.a(m317a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotifReadnessModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f277d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m318a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m317a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: utm_nonce */
        public class Serializer extends JsonSerializer<FBMarketplaceBadgeCountQueryModel> {
            public final void m320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBMarketplaceBadgeCountQueryModel fBMarketplaceBadgeCountQueryModel = (FBMarketplaceBadgeCountQueryModel) obj;
                if (fBMarketplaceBadgeCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBMarketplaceBadgeCountQueryModel.m323a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBMarketplaceBadgeCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBMarketplaceBadgeCountQueryModel.w_();
                int u_ = fBMarketplaceBadgeCountQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("marketplace_badge_count");
                    MarketplaceBadgeCountParser.m326a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("notif_readness");
                    NotifReadnessParser.m332a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBMarketplaceBadgeCountQueryModel.class, new Serializer());
            }
        }

        public FBMarketplaceBadgeCountQueryModel() {
            super(2);
        }

        @Nullable
        private MarketplaceBadgeCountModel m321a() {
            this.f278d = (MarketplaceBadgeCountModel) super.a(this.f278d, 0, MarketplaceBadgeCountModel.class);
            return this.f278d;
        }

        @Nullable
        private NotifReadnessModel m322j() {
            this.f279e = (NotifReadnessModel) super.a(this.f279e, 1, NotifReadnessModel.class);
            return this.f279e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m321a() != null) {
                MarketplaceBadgeCountModel marketplaceBadgeCountModel = (MarketplaceBadgeCountModel) graphQLModelMutatingVisitor.b(m321a());
                if (m321a() != marketplaceBadgeCountModel) {
                    graphQLVisitableModel = (FBMarketplaceBadgeCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f278d = marketplaceBadgeCountModel;
                }
            }
            if (m322j() != null) {
                NotifReadnessModel notifReadnessModel = (NotifReadnessModel) graphQLModelMutatingVisitor.b(m322j());
                if (m322j() != notifReadnessModel) {
                    graphQLVisitableModel = (FBMarketplaceBadgeCountQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f279e = notifReadnessModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m323a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m321a());
            int a2 = ModelHelper.a(flatBufferBuilder, m322j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
