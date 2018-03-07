package com.facebook.marketplace.badge;

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
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryParsers.MarketplaceBadgeCountQueryParser;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryParsers.MarketplaceBadgeCountQueryParser.MarketplaceBadgeCountParser;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryParsers.MarketplaceBadgeCountQueryParser.NotifReadnessParser;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryParsers.MarketplaceBadgeCountQueryParser.NotifReadnessParser.EdgesParser;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryParsers.MarketplaceBadgeCountQueryParser.NotifReadnessParser.EdgesParser.NodeParser;
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

/* compiled from: user_status */
public class MarketplaceBadgeCountQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1180129814)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: user_status */
    public final class MarketplaceBadgeCountQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MarketplaceBadgeCountModel f288d;
        @Nullable
        private NotifReadnessModel f289e;

        /* compiled from: user_status */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MarketplaceBadgeCountQueryModel.class, new Deserializer());
            }

            public Object m334a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MarketplaceBadgeCountQueryParser.m371a(jsonParser);
                Object marketplaceBadgeCountQueryModel = new MarketplaceBadgeCountQueryModel();
                ((BaseModel) marketplaceBadgeCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (marketplaceBadgeCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) marketplaceBadgeCountQueryModel).a();
                }
                return marketplaceBadgeCountQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -530021489)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: user_status */
        public final class MarketplaceBadgeCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f280d;
            private int f281e;
            private int f282f;
            private int f283g;

            /* compiled from: user_status */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MarketplaceBadgeCountModel.class, new Deserializer());
                }

                public Object m335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MarketplaceBadgeCountParser.m363a(jsonParser, flatBufferBuilder));
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

            /* compiled from: user_status */
            public class Serializer extends JsonSerializer<MarketplaceBadgeCountModel> {
                public final void m336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MarketplaceBadgeCountModel marketplaceBadgeCountModel = (MarketplaceBadgeCountModel) obj;
                    if (marketplaceBadgeCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(marketplaceBadgeCountModel.m338a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        marketplaceBadgeCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MarketplaceBadgeCountParser.m364a(marketplaceBadgeCountModel.w_(), marketplaceBadgeCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MarketplaceBadgeCountModel.class, new Serializer());
                }
            }

            public MarketplaceBadgeCountModel() {
                super(4);
            }

            public final int m337a() {
                a(0, 1);
                return this.f281e;
            }

            public final int m341j() {
                a(0, 3);
                return this.f283g;
            }

            public final int jK_() {
                return 1164528901;
            }

            public final GraphQLVisitableModel m339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m338a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f280d, 0);
                flatBufferBuilder.a(1, this.f281e, 0);
                flatBufferBuilder.a(2, this.f282f, 0);
                flatBufferBuilder.a(3, this.f283g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m340a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f280d = mutableFlatBuffer.a(i, 0, 0);
                this.f281e = mutableFlatBuffer.a(i, 1, 0);
                this.f282f = mutableFlatBuffer.a(i, 2, 0);
                this.f283g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1116992102)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: user_status */
        public final class NotifReadnessModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f287d;

            /* compiled from: user_status */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotifReadnessModel.class, new Deserializer());
                }

                public Object m342a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotifReadnessParser.m369a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 1718611639)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: user_status */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f286d;

                /* compiled from: user_status */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m343a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m367b(jsonParser, flatBufferBuilder));
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
                /* compiled from: user_status */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f284d;
                    @Nullable
                    private GraphQLStorySeenState f285e;

                    /* compiled from: user_status */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m365a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: user_status */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m348a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m366a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    private String m346a() {
                        this.f284d = super.a(this.f284d, 0);
                        return this.f284d;
                    }

                    @Nullable
                    private GraphQLStorySeenState m347j() {
                        this.f285e = (GraphQLStorySeenState) super.b(this.f285e, 1, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f285e;
                    }

                    public final int jK_() {
                        return -1047025729;
                    }

                    public final GraphQLVisitableModel m349a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m348a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m346a());
                        int a = flatBufferBuilder.a(m347j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: user_status */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m350a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m352a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m368b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m351a() {
                    this.f286d = (NodeModel) super.a(this.f286d, 0, NodeModel.class);
                    return this.f286d;
                }

                public final int jK_() {
                    return -1047304326;
                }

                public final GraphQLVisitableModel m353a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m351a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m351a());
                        if (m351a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f286d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m352a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m351a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: user_status */
            public class Serializer extends JsonSerializer<NotifReadnessModel> {
                public final void m354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotifReadnessModel notifReadnessModel = (NotifReadnessModel) obj;
                    if (notifReadnessModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notifReadnessModel.m355a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notifReadnessModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotifReadnessParser.m370a(notifReadnessModel.w_(), notifReadnessModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotifReadnessModel.class, new Serializer());
                }
            }

            public NotifReadnessModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m357a() {
                this.f287d = super.a(this.f287d, 0, EdgesModel.class);
                return (ImmutableList) this.f287d;
            }

            public final int jK_() {
                return -1165789477;
            }

            public final GraphQLVisitableModel m356a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m357a() != null) {
                    Builder a = ModelHelper.a(m357a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotifReadnessModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f287d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m355a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m357a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: user_status */
        public class Serializer extends JsonSerializer<MarketplaceBadgeCountQueryModel> {
            public final void m358a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MarketplaceBadgeCountQueryModel marketplaceBadgeCountQueryModel = (MarketplaceBadgeCountQueryModel) obj;
                if (marketplaceBadgeCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(marketplaceBadgeCountQueryModel.m359a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    marketplaceBadgeCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = marketplaceBadgeCountQueryModel.w_();
                int u_ = marketplaceBadgeCountQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("marketplace_badge_count");
                    MarketplaceBadgeCountParser.m364a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("notif_readness");
                    NotifReadnessParser.m370a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MarketplaceBadgeCountQueryModel.class, new Serializer());
            }
        }

        public MarketplaceBadgeCountQueryModel() {
            super(2);
        }

        @Nullable
        public final MarketplaceBadgeCountModel m361a() {
            this.f288d = (MarketplaceBadgeCountModel) super.a(this.f288d, 0, MarketplaceBadgeCountModel.class);
            return this.f288d;
        }

        @Nullable
        public final NotifReadnessModel m362j() {
            this.f289e = (NotifReadnessModel) super.a(this.f289e, 1, NotifReadnessModel.class);
            return this.f289e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m360a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m361a() != null) {
                MarketplaceBadgeCountModel marketplaceBadgeCountModel = (MarketplaceBadgeCountModel) graphQLModelMutatingVisitor.b(m361a());
                if (m361a() != marketplaceBadgeCountModel) {
                    graphQLVisitableModel = (MarketplaceBadgeCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f288d = marketplaceBadgeCountModel;
                }
            }
            if (m362j() != null) {
                NotifReadnessModel notifReadnessModel = (NotifReadnessModel) graphQLModelMutatingVisitor.b(m362j());
                if (m362j() != notifReadnessModel) {
                    graphQLVisitableModel = (MarketplaceBadgeCountQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f289e = notifReadnessModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m359a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m361a());
            int a2 = ModelHelper.a(flatBufferBuilder, m362j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
