package com.facebook.zero.upsell.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser.MobileCarrierAccountParser;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser.MobileCarrierAccountParser.CarrierAccountUpsellProductsParser;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser.MobileCarrierAccountParser.CarrierAccountUpsellProductsParser.EdgesParser;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser.MobileCarrierAccountParser.CarrierAccountUpsellProductsParser.EdgesParser.NodeParser;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser.MobileCarrierAccountParser.MobileCarrierParser;
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

/* compiled from: voip capability bits */
public class ZeroUpsellGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1113555102)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: voip capability bits */
    public final class ZeroUpsellRecoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MobileCarrierAccountModel f282d;

        /* compiled from: voip capability bits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ZeroUpsellRecoModel.class, new Deserializer());
            }

            public Object m270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ZeroUpsellRecoParser.m325a(jsonParser);
                Object zeroUpsellRecoModel = new ZeroUpsellRecoModel();
                ((BaseModel) zeroUpsellRecoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (zeroUpsellRecoModel instanceof Postprocessable) {
                    return ((Postprocessable) zeroUpsellRecoModel).a();
                }
                return zeroUpsellRecoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1245021590)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: voip capability bits */
        public final class MobileCarrierAccountModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CarrierAccountUpsellProductsModel f280d;
            @Nullable
            private MobileCarrierModel f281e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2095623732)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: voip capability bits */
            public final class CarrierAccountUpsellProductsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f272d;
                @Nullable
                private List<EdgesModel> f273e;
                private int f274f;
                @Nullable
                private String f275g;
                @Nullable
                private String f276h;
                @Nullable
                private String f277i;

                /* compiled from: voip capability bits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CarrierAccountUpsellProductsModel.class, new Deserializer());
                    }

                    public Object m271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CarrierAccountUpsellProductsParser.m319a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object carrierAccountUpsellProductsModel = new CarrierAccountUpsellProductsModel();
                        ((BaseModel) carrierAccountUpsellProductsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (carrierAccountUpsellProductsModel instanceof Postprocessable) {
                            return ((Postprocessable) carrierAccountUpsellProductsModel).a();
                        }
                        return carrierAccountUpsellProductsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2131686818)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: voip capability bits */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f269d;
                    @Nullable
                    private NodeModel f270e;
                    @Nullable
                    private String f271f;

                    /* compiled from: voip capability bits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m317b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 761756085)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: voip capability bits */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f264d;
                        private double f265e;
                        @Nullable
                        private String f266f;
                        private boolean f267g;
                        @Nullable
                        private String f268h;

                        /* compiled from: voip capability bits */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m314a(r11, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object nodeModel = new NodeModel();
                                ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                                if (nodeModel instanceof Postprocessable) {
                                    return ((Postprocessable) nodeModel).a();
                                }
                                return nodeModel;
                            }
                        }

                        /* compiled from: voip capability bits */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m274a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) r8;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m275a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m315a(nodeModel.w_(), nodeModel.u_(), r9);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(5);
                        }

                        @Nullable
                        public final String m279j() {
                            this.f264d = super.a(this.f264d, 0);
                            return this.f264d;
                        }

                        @Nullable
                        public final String m280k() {
                            this.f266f = super.a(this.f266f, 2);
                            return this.f266f;
                        }

                        @Nullable
                        public final String m281l() {
                            this.f268h = super.a(this.f268h, 4);
                            return this.f268h;
                        }

                        @Nullable
                        public final String m277a() {
                            return m280k();
                        }

                        public final int jK_() {
                            return -1731205954;
                        }

                        public final GraphQLVisitableModel m276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m275a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = r9.b(m279j());
                            int b2 = r9.b(m280k());
                            int b3 = r9.b(m281l());
                            r9.c(5);
                            r9.b(0, b);
                            r9.a(1, this.f265e, 0.0d);
                            r9.b(2, b2);
                            r9.a(3, this.f267g);
                            r9.b(4, b3);
                            i();
                            return r9.d();
                        }

                        public final void m278a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(r5, r6, r7);
                            this.f265e = r5.a(r6, 1, 0.0d);
                            this.f267g = r5.a(r6, 3);
                        }
                    }

                    /* compiled from: voip capability bits */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) r8;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m284a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m318b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(3);
                    }

                    @Nullable
                    private String m283k() {
                        this.f269d = super.a(this.f269d, 0);
                        return this.f269d;
                    }

                    @Nullable
                    public final NodeModel m286a() {
                        this.f270e = (NodeModel) super.a(this.f270e, 1, NodeModel.class);
                        return this.f270e;
                    }

                    @Nullable
                    public final String m287j() {
                        this.f271f = super.a(this.f271f, 2);
                        return this.f271f;
                    }

                    public final int jK_() {
                        return -290149593;
                    }

                    public final GraphQLVisitableModel m285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m286a() != null) {
                            NodeModel nodeModel = (NodeModel) r4.b(m286a());
                            if (m286a() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f270e = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m284a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = r5.b(m283k());
                        int a = ModelHelper.a(r5, m286a());
                        int b2 = r5.b(m287j());
                        r5.c(3);
                        r5.b(0, b);
                        r5.b(1, a);
                        r5.b(2, b2);
                        i();
                        return r5.d();
                    }
                }

                /* compiled from: voip capability bits */
                public class Serializer extends JsonSerializer<CarrierAccountUpsellProductsModel> {
                    public final void m288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CarrierAccountUpsellProductsModel carrierAccountUpsellProductsModel = (CarrierAccountUpsellProductsModel) r8;
                        if (carrierAccountUpsellProductsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(carrierAccountUpsellProductsModel.m289a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            carrierAccountUpsellProductsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CarrierAccountUpsellProductsParser.m320a(carrierAccountUpsellProductsModel.w_(), carrierAccountUpsellProductsModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(CarrierAccountUpsellProductsModel.class, new Serializer());
                    }
                }

                public CarrierAccountUpsellProductsModel() {
                    super(6);
                }

                @Nullable
                public final String m291a() {
                    this.f272d = super.a(this.f272d, 0);
                    return this.f272d;
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m293j() {
                    this.f273e = super.a(this.f273e, 1, EdgesModel.class);
                    return (ImmutableList) this.f273e;
                }

                public final int m294k() {
                    a(0, 2);
                    return this.f274f;
                }

                @Nullable
                public final String m295l() {
                    this.f275g = super.a(this.f275g, 3);
                    return this.f275g;
                }

                @Nullable
                public final String m296m() {
                    this.f276h = super.a(this.f276h, 4);
                    return this.f276h;
                }

                @Nullable
                public final String m297n() {
                    this.f277i = super.a(this.f277i, 5);
                    return this.f277i;
                }

                public final int jK_() {
                    return -872643384;
                }

                public final GraphQLVisitableModel m290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m293j() != null) {
                        Builder a = ModelHelper.a(m293j(), r3);
                        if (a != null) {
                            graphQLVisitableModel = (CarrierAccountUpsellProductsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f273e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m289a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r8.b(m291a());
                    int a = ModelHelper.a(r8, m293j());
                    int b2 = r8.b(m295l());
                    int b3 = r8.b(m296m());
                    int b4 = r8.b(m297n());
                    r8.c(6);
                    r8.b(0, b);
                    r8.b(1, a);
                    r8.a(2, this.f274f, 0);
                    r8.b(3, b2);
                    r8.b(4, b3);
                    r8.b(5, b4);
                    i();
                    return r8.d();
                }

                public final void m292a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(r3, r4, r5);
                    this.f274f = r3.a(r4, 2, 0);
                }
            }

            /* compiled from: voip capability bits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MobileCarrierAccountModel.class, new Deserializer());
                }

                public Object m298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MobileCarrierAccountParser.m323a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mobileCarrierAccountModel = new MobileCarrierAccountModel();
                    ((BaseModel) mobileCarrierAccountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (mobileCarrierAccountModel instanceof Postprocessable) {
                        return ((Postprocessable) mobileCarrierAccountModel).a();
                    }
                    return mobileCarrierAccountModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1976397873)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: voip capability bits */
            public final class MobileCarrierModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f278d;
                @Nullable
                private String f279e;

                /* compiled from: voip capability bits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MobileCarrierModel.class, new Deserializer());
                    }

                    public Object m299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MobileCarrierParser.m321a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mobileCarrierModel = new MobileCarrierModel();
                        ((BaseModel) mobileCarrierModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (mobileCarrierModel instanceof Postprocessable) {
                            return ((Postprocessable) mobileCarrierModel).a();
                        }
                        return mobileCarrierModel;
                    }
                }

                /* compiled from: voip capability bits */
                public class Serializer extends JsonSerializer<MobileCarrierModel> {
                    public final void m300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MobileCarrierModel mobileCarrierModel = (MobileCarrierModel) r8;
                        if (mobileCarrierModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mobileCarrierModel.m302a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mobileCarrierModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MobileCarrierParser.m322a(mobileCarrierModel.w_(), mobileCarrierModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(MobileCarrierModel.class, new Serializer());
                    }
                }

                public MobileCarrierModel() {
                    super(2);
                }

                @Nullable
                private String m301j() {
                    this.f278d = super.a(this.f278d, 0);
                    return this.f278d;
                }

                @Nullable
                public final String m304a() {
                    this.f279e = super.a(this.f279e, 1);
                    return this.f279e;
                }

                public final int jK_() {
                    return 1377074134;
                }

                public final GraphQLVisitableModel m303a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m302a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r4.b(m301j());
                    int b2 = r4.b(m304a());
                    r4.c(2);
                    r4.b(0, b);
                    r4.b(1, b2);
                    i();
                    return r4.d();
                }
            }

            /* compiled from: voip capability bits */
            public class Serializer extends JsonSerializer<MobileCarrierAccountModel> {
                public final void m305a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MobileCarrierAccountModel mobileCarrierAccountModel = (MobileCarrierAccountModel) r8;
                    if (mobileCarrierAccountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mobileCarrierAccountModel.m306a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mobileCarrierAccountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MobileCarrierAccountParser.m324a(mobileCarrierAccountModel.w_(), mobileCarrierAccountModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(MobileCarrierAccountModel.class, new Serializer());
                }
            }

            public MobileCarrierAccountModel() {
                super(2);
            }

            @Nullable
            public final CarrierAccountUpsellProductsModel m308a() {
                this.f280d = (CarrierAccountUpsellProductsModel) super.a(this.f280d, 0, CarrierAccountUpsellProductsModel.class);
                return this.f280d;
            }

            @Nullable
            public final MobileCarrierModel m309j() {
                this.f281e = (MobileCarrierModel) super.a(this.f281e, 1, MobileCarrierModel.class);
                return this.f281e;
            }

            public final int jK_() {
                return -606038834;
            }

            public final GraphQLVisitableModel m307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m308a() != null) {
                    CarrierAccountUpsellProductsModel carrierAccountUpsellProductsModel = (CarrierAccountUpsellProductsModel) r4.b(m308a());
                    if (m308a() != carrierAccountUpsellProductsModel) {
                        graphQLVisitableModel = (MobileCarrierAccountModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f280d = carrierAccountUpsellProductsModel;
                    }
                }
                if (m309j() != null) {
                    MobileCarrierModel mobileCarrierModel = (MobileCarrierModel) r4.b(m309j());
                    if (m309j() != mobileCarrierModel) {
                        graphQLVisitableModel = (MobileCarrierAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f281e = mobileCarrierModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m306a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r4, m308a());
                int a2 = ModelHelper.a(r4, m309j());
                r4.c(2);
                r4.b(0, a);
                r4.b(1, a2);
                i();
                return r4.d();
            }
        }

        /* compiled from: voip capability bits */
        public class Serializer extends JsonSerializer<ZeroUpsellRecoModel> {
            public final void m310a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ZeroUpsellRecoModel zeroUpsellRecoModel = (ZeroUpsellRecoModel) obj;
                if (zeroUpsellRecoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(zeroUpsellRecoModel.m311a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    zeroUpsellRecoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = zeroUpsellRecoModel.w_();
                int u_ = zeroUpsellRecoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mobile_carrier_account");
                    MobileCarrierAccountParser.m324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ZeroUpsellRecoModel.class, new Serializer());
            }
        }

        public ZeroUpsellRecoModel() {
            super(1);
        }

        @Nullable
        public final MobileCarrierAccountModel m313a() {
            this.f282d = (MobileCarrierAccountModel) super.a(this.f282d, 0, MobileCarrierAccountModel.class);
            return this.f282d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m312a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m313a() != null) {
                MobileCarrierAccountModel mobileCarrierAccountModel = (MobileCarrierAccountModel) graphQLModelMutatingVisitor.b(m313a());
                if (m313a() != mobileCarrierAccountModel) {
                    graphQLVisitableModel = (ZeroUpsellRecoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f282d = mobileCarrierAccountModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m311a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m313a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
