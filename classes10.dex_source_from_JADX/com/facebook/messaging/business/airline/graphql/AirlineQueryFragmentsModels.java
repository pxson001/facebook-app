package com.facebook.messaging.business.airline.graphql;

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
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser;
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser.ItemizedPriceInfosParser;
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser.ItineraryLegsParser;
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser.ItineraryLegsParser.NodesParser;
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser.ItineraryLegsParser.NodesParser.SegmentsParser;
import com.facebook.messaging.business.airline.graphql.AirlineQueryFragmentsParsers.AirlineItineraryParser.ItineraryLegsParser.NodesParser.SegmentsParser.SegmentsNodesParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineFlightInfoModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlinePassengerSegmentDetailModel;
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

/* compiled from: thread_list_inline_call_back */
public class AirlineQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 403748625)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: thread_list_inline_call_back */
    public final class AirlineItineraryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f1514d;
        @Nullable
        private String f1515e;
        @Nullable
        private String f1516f;
        @Nullable
        private String f1517g;
        @Nullable
        private String f1518h;
        @Nullable
        private String f1519i;
        @Nullable
        private String f1520j;
        @Nullable
        private String f1521k;
        @Nullable
        private String f1522l;
        @Nullable
        private String f1523m;
        @Nullable
        private String f1524n;
        @Nullable
        private String f1525o;
        @Nullable
        private String f1526p;
        @Nullable
        private List<ItemizedPriceInfosModel> f1527q;
        @Nullable
        private ItineraryLegsModel f1528r;
        @Nullable
        private LogoImageModel f1529s;
        @Nullable
        private String f1530t;
        @Nullable
        private String f1531u;
        @Nullable
        private String f1532v;
        @Nullable
        private String f1533w;
        @Nullable
        private String f1534x;
        @Nullable
        private String f1535y;
        @Nullable
        private String f1536z;

        /* compiled from: thread_list_inline_call_back */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineItineraryModel.class, new Deserializer());
            }

            public Object m1478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlineItineraryParser.m1543a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlineItineraryModel = new AirlineItineraryModel();
                ((BaseModel) airlineItineraryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlineItineraryModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineItineraryModel).a();
                }
                return airlineItineraryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1597493773)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_list_inline_call_back */
        public final class ItemizedPriceInfosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1507d;
            @Nullable
            private String f1508e;

            /* compiled from: thread_list_inline_call_back */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemizedPriceInfosModel.class, new Deserializer());
                }

                public Object m1479a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemizedPriceInfosParser.m1534b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemizedPriceInfosModel = new ItemizedPriceInfosModel();
                    ((BaseModel) itemizedPriceInfosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemizedPriceInfosModel instanceof Postprocessable) {
                        return ((Postprocessable) itemizedPriceInfosModel).a();
                    }
                    return itemizedPriceInfosModel;
                }
            }

            /* compiled from: thread_list_inline_call_back */
            public class Serializer extends JsonSerializer<ItemizedPriceInfosModel> {
                public final void m1480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemizedPriceInfosModel itemizedPriceInfosModel = (ItemizedPriceInfosModel) obj;
                    if (itemizedPriceInfosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemizedPriceInfosModel.m1483a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemizedPriceInfosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemizedPriceInfosParser.m1533a(itemizedPriceInfosModel.w_(), itemizedPriceInfosModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemizedPriceInfosModel.class, new Serializer());
                }
            }

            public ItemizedPriceInfosModel() {
                super(2);
            }

            @Nullable
            private String m1481a() {
                this.f1507d = super.a(this.f1507d, 0);
                return this.f1507d;
            }

            @Nullable
            private String m1482j() {
                this.f1508e = super.a(this.f1508e, 1);
                return this.f1508e;
            }

            public final int jK_() {
                return -790195431;
            }

            public final GraphQLVisitableModel m1484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1483a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1481a());
                int b2 = flatBufferBuilder.b(m1482j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -714360943)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_list_inline_call_back */
        public final class ItineraryLegsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1513d;

            /* compiled from: thread_list_inline_call_back */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItineraryLegsModel.class, new Deserializer());
                }

                public Object m1485a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItineraryLegsParser.m1541a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itineraryLegsModel = new ItineraryLegsModel();
                    ((BaseModel) itineraryLegsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itineraryLegsModel instanceof Postprocessable) {
                        return ((Postprocessable) itineraryLegsModel).a();
                    }
                    return itineraryLegsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -93721673)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: thread_list_inline_call_back */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private SegmentsModel f1512d;

                /* compiled from: thread_list_inline_call_back */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1539b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -522617021)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: thread_list_inline_call_back */
                public final class SegmentsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<SegmentsNodesModel> f1511d;

                    /* compiled from: thread_list_inline_call_back */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SegmentsModel.class, new Deserializer());
                        }

                        public Object m1487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SegmentsParser.m1537a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object segmentsModel = new SegmentsModel();
                            ((BaseModel) segmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (segmentsModel instanceof Postprocessable) {
                                return ((Postprocessable) segmentsModel).a();
                            }
                            return segmentsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -872840515)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: thread_list_inline_call_back */
                    public final class SegmentsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private AirlineFlightInfoModel f1509d;
                        @Nullable
                        private List<AirlinePassengerSegmentDetailModel> f1510e;

                        /* compiled from: thread_list_inline_call_back */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SegmentsNodesModel.class, new Deserializer());
                            }

                            public Object m1488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SegmentsNodesParser.m1535b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object segmentsNodesModel = new SegmentsNodesModel();
                                ((BaseModel) segmentsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (segmentsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) segmentsNodesModel).a();
                                }
                                return segmentsNodesModel;
                            }
                        }

                        /* compiled from: thread_list_inline_call_back */
                        public class Serializer extends JsonSerializer<SegmentsNodesModel> {
                            public final void m1489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SegmentsNodesModel segmentsNodesModel = (SegmentsNodesModel) obj;
                                if (segmentsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(segmentsNodesModel.m1492a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    segmentsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SegmentsNodesParser.m1536b(segmentsNodesModel.w_(), segmentsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(SegmentsNodesModel.class, new Serializer());
                            }
                        }

                        public SegmentsNodesModel() {
                            super(2);
                        }

                        @Nullable
                        private AirlineFlightInfoModel m1490a() {
                            this.f1509d = (AirlineFlightInfoModel) super.a(this.f1509d, 0, AirlineFlightInfoModel.class);
                            return this.f1509d;
                        }

                        @Nonnull
                        private ImmutableList<AirlinePassengerSegmentDetailModel> m1491j() {
                            this.f1510e = super.a(this.f1510e, 1, AirlinePassengerSegmentDetailModel.class);
                            return (ImmutableList) this.f1510e;
                        }

                        public final int jK_() {
                            return -867247804;
                        }

                        public final GraphQLVisitableModel m1493a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m1490a() != null) {
                                AirlineFlightInfoModel airlineFlightInfoModel = (AirlineFlightInfoModel) graphQLModelMutatingVisitor.b(m1490a());
                                if (m1490a() != airlineFlightInfoModel) {
                                    graphQLVisitableModel = (SegmentsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1509d = airlineFlightInfoModel;
                                }
                            }
                            if (m1491j() != null) {
                                Builder a = ModelHelper.a(m1491j(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    SegmentsNodesModel segmentsNodesModel = (SegmentsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    segmentsNodesModel.f1510e = a.b();
                                    graphQLVisitableModel = segmentsNodesModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m1492a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m1490a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m1491j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: thread_list_inline_call_back */
                    public class Serializer extends JsonSerializer<SegmentsModel> {
                        public final void m1494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SegmentsModel segmentsModel = (SegmentsModel) obj;
                            if (segmentsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(segmentsModel.m1496a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                segmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SegmentsParser.m1538a(segmentsModel.w_(), segmentsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(SegmentsModel.class, new Serializer());
                        }
                    }

                    public SegmentsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<SegmentsNodesModel> m1495a() {
                        this.f1511d = super.a(this.f1511d, 0, SegmentsNodesModel.class);
                        return (ImmutableList) this.f1511d;
                    }

                    public final int jK_() {
                        return 1957188619;
                    }

                    public final GraphQLVisitableModel m1497a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1495a() != null) {
                            Builder a = ModelHelper.a(m1495a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (SegmentsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1511d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1496a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1495a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: thread_list_inline_call_back */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1498a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1500a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1540b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                private SegmentsModel m1499a() {
                    this.f1512d = (SegmentsModel) super.a(this.f1512d, 0, SegmentsModel.class);
                    return this.f1512d;
                }

                public final int jK_() {
                    return -1233789887;
                }

                public final GraphQLVisitableModel m1501a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1499a() != null) {
                        SegmentsModel segmentsModel = (SegmentsModel) graphQLModelMutatingVisitor.b(m1499a());
                        if (m1499a() != segmentsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1512d = segmentsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1500a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1499a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: thread_list_inline_call_back */
            public class Serializer extends JsonSerializer<ItineraryLegsModel> {
                public final void m1502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItineraryLegsModel itineraryLegsModel = (ItineraryLegsModel) obj;
                    if (itineraryLegsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itineraryLegsModel.m1504a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itineraryLegsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItineraryLegsParser.m1542a(itineraryLegsModel.w_(), itineraryLegsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ItineraryLegsModel.class, new Serializer());
                }
            }

            public ItineraryLegsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m1503a() {
                this.f1513d = super.a(this.f1513d, 0, NodesModel.class);
                return (ImmutableList) this.f1513d;
            }

            public final int jK_() {
                return -403289904;
            }

            public final GraphQLVisitableModel m1505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1503a() != null) {
                    Builder a = ModelHelper.a(m1503a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ItineraryLegsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1513d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1504a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1503a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: thread_list_inline_call_back */
        public class Serializer extends JsonSerializer<AirlineItineraryModel> {
            public final void m1506a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineItineraryModel airlineItineraryModel = (AirlineItineraryModel) obj;
                if (airlineItineraryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineItineraryModel.m1530a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineItineraryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineItineraryParser.m1544a(airlineItineraryModel.w_(), airlineItineraryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlineItineraryModel.class, new Serializer());
            }
        }

        public AirlineItineraryModel() {
            super(23);
        }

        @Nullable
        private String m1513j() {
            this.f1514d = super.a(this.f1514d, 0);
            return this.f1514d;
        }

        @Nullable
        private String m1514k() {
            this.f1515e = super.a(this.f1515e, 1);
            return this.f1515e;
        }

        @Nullable
        private String m1515l() {
            this.f1516f = super.a(this.f1516f, 2);
            return this.f1516f;
        }

        @Nullable
        private String m1516m() {
            this.f1517g = super.a(this.f1517g, 3);
            return this.f1517g;
        }

        @Nullable
        private String m1517n() {
            this.f1518h = super.a(this.f1518h, 4);
            return this.f1518h;
        }

        @Nullable
        private String m1518o() {
            this.f1519i = super.a(this.f1519i, 5);
            return this.f1519i;
        }

        @Nullable
        private String m1519p() {
            this.f1520j = super.a(this.f1520j, 6);
            return this.f1520j;
        }

        @Nullable
        private String m1520q() {
            this.f1521k = super.a(this.f1521k, 7);
            return this.f1521k;
        }

        @Nullable
        private String m1521r() {
            this.f1522l = super.a(this.f1522l, 8);
            return this.f1522l;
        }

        @Nullable
        private String m1522s() {
            this.f1523m = super.a(this.f1523m, 9);
            return this.f1523m;
        }

        @Nullable
        private String m1523t() {
            this.f1524n = super.a(this.f1524n, 10);
            return this.f1524n;
        }

        @Nullable
        private String m1524u() {
            this.f1525o = super.a(this.f1525o, 11);
            return this.f1525o;
        }

        @Nullable
        private String m1525v() {
            this.f1526p = super.a(this.f1526p, 12);
            return this.f1526p;
        }

        @Nonnull
        private ImmutableList<ItemizedPriceInfosModel> m1526w() {
            this.f1527q = super.a(this.f1527q, 13, ItemizedPriceInfosModel.class);
            return (ImmutableList) this.f1527q;
        }

        @Nullable
        private ItineraryLegsModel m1527x() {
            this.f1528r = (ItineraryLegsModel) super.a(this.f1528r, 14, ItineraryLegsModel.class);
            return this.f1528r;
        }

        @Nullable
        private LogoImageModel m1528y() {
            this.f1529s = (LogoImageModel) super.a(this.f1529s, 15, LogoImageModel.class);
            return this.f1529s;
        }

        @Nullable
        private String m1529z() {
            this.f1530t = super.a(this.f1530t, 16);
            return this.f1530t;
        }

        @Nullable
        private String m1507A() {
            this.f1531u = super.a(this.f1531u, 17);
            return this.f1531u;
        }

        @Nullable
        private String m1508B() {
            this.f1532v = super.a(this.f1532v, 18);
            return this.f1532v;
        }

        @Nullable
        private String m1509C() {
            this.f1533w = super.a(this.f1533w, 19);
            return this.f1533w;
        }

        @Nullable
        private String m1510D() {
            this.f1534x = super.a(this.f1534x, 20);
            return this.f1534x;
        }

        @Nullable
        private String m1511E() {
            this.f1535y = super.a(this.f1535y, 21);
            return this.f1535y;
        }

        @Nullable
        private String m1512F() {
            this.f1536z = super.a(this.f1536z, 22);
            return this.f1536z;
        }

        @Nullable
        public final String m1532a() {
            return m1525v();
        }

        public final int jK_() {
            return 1534197117;
        }

        public final GraphQLVisitableModel m1531a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ItineraryLegsModel itineraryLegsModel;
            LogoImageModel logoImageModel;
            h();
            if (m1526w() != null) {
                Builder a = ModelHelper.a(m1526w(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AirlineItineraryModel airlineItineraryModel = (AirlineItineraryModel) ModelHelper.a(null, this);
                    airlineItineraryModel.f1527q = a.b();
                    graphQLVisitableModel = airlineItineraryModel;
                    if (m1527x() != null) {
                        itineraryLegsModel = (ItineraryLegsModel) graphQLModelMutatingVisitor.b(m1527x());
                        if (m1527x() != itineraryLegsModel) {
                            graphQLVisitableModel = (AirlineItineraryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1528r = itineraryLegsModel;
                        }
                    }
                    if (m1528y() != null) {
                        logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1528y());
                        if (m1528y() != logoImageModel) {
                            graphQLVisitableModel = (AirlineItineraryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1529s = logoImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m1527x() != null) {
                itineraryLegsModel = (ItineraryLegsModel) graphQLModelMutatingVisitor.b(m1527x());
                if (m1527x() != itineraryLegsModel) {
                    graphQLVisitableModel = (AirlineItineraryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1528r = itineraryLegsModel;
                }
            }
            if (m1528y() != null) {
                logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1528y());
                if (m1528y() != logoImageModel) {
                    graphQLVisitableModel = (AirlineItineraryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1529s = logoImageModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m1530a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1513j());
            int b2 = flatBufferBuilder.b(m1514k());
            int b3 = flatBufferBuilder.b(m1515l());
            int b4 = flatBufferBuilder.b(m1516m());
            int b5 = flatBufferBuilder.b(m1517n());
            int b6 = flatBufferBuilder.b(m1518o());
            int b7 = flatBufferBuilder.b(m1519p());
            int b8 = flatBufferBuilder.b(m1520q());
            int b9 = flatBufferBuilder.b(m1521r());
            int b10 = flatBufferBuilder.b(m1522s());
            int b11 = flatBufferBuilder.b(m1523t());
            int b12 = flatBufferBuilder.b(m1524u());
            int b13 = flatBufferBuilder.b(m1525v());
            int a = ModelHelper.a(flatBufferBuilder, m1526w());
            int a2 = ModelHelper.a(flatBufferBuilder, m1527x());
            int a3 = ModelHelper.a(flatBufferBuilder, m1528y());
            int b14 = flatBufferBuilder.b(m1529z());
            int b15 = flatBufferBuilder.b(m1507A());
            int b16 = flatBufferBuilder.b(m1508B());
            int b17 = flatBufferBuilder.b(m1509C());
            int b18 = flatBufferBuilder.b(m1510D());
            int b19 = flatBufferBuilder.b(m1511E());
            int b20 = flatBufferBuilder.b(m1512F());
            flatBufferBuilder.c(23);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            flatBufferBuilder.b(5, b6);
            flatBufferBuilder.b(6, b7);
            flatBufferBuilder.b(7, b8);
            flatBufferBuilder.b(8, b9);
            flatBufferBuilder.b(9, b10);
            flatBufferBuilder.b(10, b11);
            flatBufferBuilder.b(11, b12);
            flatBufferBuilder.b(12, b13);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            flatBufferBuilder.b(15, a3);
            flatBufferBuilder.b(16, b14);
            flatBufferBuilder.b(17, b15);
            flatBufferBuilder.b(18, b16);
            flatBufferBuilder.b(19, b17);
            flatBufferBuilder.b(20, b18);
            flatBufferBuilder.b(21, b19);
            flatBufferBuilder.b(22, b20);
            i();
            return flatBufferBuilder.d();
        }
    }
}
