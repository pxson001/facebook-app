package com.facebook.messaging.graphql.threads.business;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble.Page;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineConfirmationBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineBoardingPassBubbleParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineBoardingPassBubbleParser.BoardingPassesParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineBoardingPassBubbleParser.PageParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineBoardingPassParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser.NodesParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser.NodesParser.SegmentsParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser.NodesParser.SegmentsParser.SegmentsNodesParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineConfirmationBubbleParser.ItineraryLegsParser.NodesParser.SegmentsParser.SegmentsNodesParser.FlightInfoParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineFlightInfoParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineFlightTimeInfoParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlinePassengerParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlinePassengerSegmentDetailParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirlineProductItemParser;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsParsers.AirportInfoParser;
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

/* compiled from: vertical_margin */
public class AirlineThreadFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1802310712)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineBoardingPassBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, AirlineBoardingPassBubble {
        @Nullable
        private BoardingPassesModel f1733d;
        @Nullable
        private String f1734e;
        @Nullable
        private String f1735f;
        @Nullable
        private String f1736g;
        @Nullable
        private String f1737h;
        @Nullable
        private String f1738i;
        @Nullable
        private String f1739j;
        @Nullable
        private String f1740k;
        @Nullable
        private LogoImageModel f1741l;
        @Nullable
        private String f1742m;
        @Nullable
        private PageModel f1743n;
        @Nullable
        private String f1744o;
        @Nullable
        private String f1745p;
        @Nullable
        private String f1746q;
        @Nullable
        private String f1747r;
        @Nullable
        private String f1748s;
        @Nullable
        private String f1749t;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -388231697)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: vertical_margin */
        public final class BoardingPassesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<AirlineBoardingPassModel> f1731d;

            /* compiled from: vertical_margin */
            public final class Builder {
                @Nullable
                public ImmutableList<AirlineBoardingPassModel> f1730a;
            }

            /* compiled from: vertical_margin */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoardingPassesModel.class, new Deserializer());
                }

                public Object m3021a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoardingPassesParser.m3179a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boardingPassesModel = new BoardingPassesModel();
                    ((BaseModel) boardingPassesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boardingPassesModel instanceof Postprocessable) {
                        return ((Postprocessable) boardingPassesModel).a();
                    }
                    return boardingPassesModel;
                }
            }

            /* compiled from: vertical_margin */
            public class Serializer extends JsonSerializer<BoardingPassesModel> {
                public final void m3022a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoardingPassesModel boardingPassesModel = (BoardingPassesModel) obj;
                    if (boardingPassesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boardingPassesModel.m3024a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boardingPassesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoardingPassesParser.m3180a(boardingPassesModel.w_(), boardingPassesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BoardingPassesModel.class, new Serializer());
                }
            }

            public BoardingPassesModel() {
                super(1);
            }

            public BoardingPassesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<AirlineBoardingPassModel> m3026a() {
                this.f1731d = super.a(this.f1731d, 0, AirlineBoardingPassModel.class);
                return (ImmutableList) this.f1731d;
            }

            public static BoardingPassesModel m3023a(BoardingPassesModel boardingPassesModel) {
                if (boardingPassesModel == null) {
                    return null;
                }
                if (boardingPassesModel instanceof BoardingPassesModel) {
                    return boardingPassesModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < boardingPassesModel.m3026a().size(); i++) {
                    builder2.c(AirlineBoardingPassModel.m3057a((AirlineBoardingPassModel) boardingPassesModel.m3026a().get(i)));
                }
                builder.f1730a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1730a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new BoardingPassesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -607014313;
            }

            public final GraphQLVisitableModel m3025a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3026a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m3026a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BoardingPassesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1731d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3024a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3026a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineBoardingPassBubbleModel.class, new Deserializer());
            }

            public Object m3027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AirlineBoardingPassBubbleParser.m3183a(jsonParser);
                Object airlineBoardingPassBubbleModel = new AirlineBoardingPassBubbleModel();
                ((BaseModel) airlineBoardingPassBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (airlineBoardingPassBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineBoardingPassBubbleModel).a();
                }
                return airlineBoardingPassBubbleModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: vertical_margin */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Page {
            @Nullable
            private String f1732d;

            /* compiled from: vertical_margin */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m3028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m3181a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: vertical_margin */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m3029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m3030a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m3182a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m3033a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m3034a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String mo128b() {
                this.f1732d = super.a(this.f1732d, 0);
                return this.f1732d;
            }

            @Nullable
            public final String m3032a() {
                return mo128b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m3031a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3030a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo128b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineBoardingPassBubbleModel> {
            public final void m3036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineBoardingPassBubbleModel airlineBoardingPassBubbleModel = (AirlineBoardingPassBubbleModel) obj;
                if (airlineBoardingPassBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineBoardingPassBubbleModel.m3050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineBoardingPassBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineBoardingPassBubbleParser.m3184a(airlineBoardingPassBubbleModel.w_(), airlineBoardingPassBubbleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlineBoardingPassBubbleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ BoardingPassesModel mo130V() {
            return m3037j();
        }

        @Nullable
        public final /* synthetic */ Page bN() {
            return m3045r();
        }

        public AirlineBoardingPassBubbleModel() {
            super(17);
        }

        @Nullable
        private BoardingPassesModel m3037j() {
            this.f1733d = (BoardingPassesModel) super.a(this.f1733d, 0, BoardingPassesModel.class);
            return this.f1733d;
        }

        @Nullable
        private String m3038k() {
            this.f1734e = super.a(this.f1734e, 1);
            return this.f1734e;
        }

        @Nullable
        private String m3039l() {
            this.f1735f = super.a(this.f1735f, 2);
            return this.f1735f;
        }

        @Nullable
        private String m3040m() {
            this.f1736g = super.a(this.f1736g, 3);
            return this.f1736g;
        }

        @Nullable
        private String m3041n() {
            this.f1737h = super.a(this.f1737h, 4);
            return this.f1737h;
        }

        @Nullable
        private String m3042o() {
            this.f1738i = super.a(this.f1738i, 5);
            return this.f1738i;
        }

        @Nullable
        private String m3043p() {
            this.f1739j = super.a(this.f1739j, 6);
            return this.f1739j;
        }

        @Nullable
        public final String mo68c() {
            this.f1740k = super.a(this.f1740k, 7);
            return this.f1740k;
        }

        @Nullable
        private LogoImageModel m3044q() {
            this.f1741l = (LogoImageModel) super.a(this.f1741l, 8, LogoImageModel.class);
            return this.f1741l;
        }

        @Nullable
        public final String aO() {
            this.f1742m = super.a(this.f1742m, 9);
            return this.f1742m;
        }

        @Nullable
        private PageModel m3045r() {
            this.f1743n = (PageModel) super.a(this.f1743n, 10, PageModel.class);
            return this.f1743n;
        }

        @Nullable
        public final String aU() {
            this.f1744o = super.a(this.f1744o, 11);
            return this.f1744o;
        }

        @Nullable
        private String m3046s() {
            this.f1745p = super.a(this.f1745p, 12);
            return this.f1745p;
        }

        @Nullable
        private String m3047t() {
            this.f1746q = super.a(this.f1746q, 13);
            return this.f1746q;
        }

        @Nullable
        public final String bj() {
            this.f1747r = super.a(this.f1747r, 14);
            return this.f1747r;
        }

        @Nullable
        public final String bq() {
            this.f1748s = super.a(this.f1748s, 15);
            return this.f1748s;
        }

        @Nullable
        private String m3048u() {
            this.f1749t = super.a(this.f1749t, 16);
            return this.f1749t;
        }

        @Nullable
        public final String m3052a() {
            return mo68c();
        }

        public final int jK_() {
            return -1847404063;
        }

        public final GraphQLVisitableModel m3051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3037j() != null) {
                BoardingPassesModel boardingPassesModel = (BoardingPassesModel) graphQLModelMutatingVisitor.b(m3037j());
                if (m3037j() != boardingPassesModel) {
                    graphQLVisitableModel = (AirlineBoardingPassBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1733d = boardingPassesModel;
                }
            }
            if (m3044q() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m3044q());
                if (m3044q() != logoImageModel) {
                    graphQLVisitableModel = (AirlineBoardingPassBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1741l = logoImageModel;
                }
            }
            if (m3045r() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m3045r());
                if (m3045r() != pageModel) {
                    graphQLVisitableModel = (AirlineBoardingPassBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1743n = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3037j());
            int b = flatBufferBuilder.b(m3038k());
            int b2 = flatBufferBuilder.b(m3039l());
            int b3 = flatBufferBuilder.b(m3040m());
            int b4 = flatBufferBuilder.b(m3041n());
            int b5 = flatBufferBuilder.b(m3042o());
            int b6 = flatBufferBuilder.b(m3043p());
            int b7 = flatBufferBuilder.b(mo68c());
            int a2 = ModelHelper.a(flatBufferBuilder, m3044q());
            int b8 = flatBufferBuilder.b(aO());
            int a3 = ModelHelper.a(flatBufferBuilder, m3045r());
            int b9 = flatBufferBuilder.b(aU());
            int b10 = flatBufferBuilder.b(m3046s());
            int b11 = flatBufferBuilder.b(m3047t());
            int b12 = flatBufferBuilder.b(bj());
            int b13 = flatBufferBuilder.b(bq());
            int b14 = flatBufferBuilder.b(m3048u());
            flatBufferBuilder.c(17);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, b6);
            flatBufferBuilder.b(7, b7);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, b8);
            flatBufferBuilder.b(10, a3);
            flatBufferBuilder.b(11, b9);
            flatBufferBuilder.b(12, b10);
            flatBufferBuilder.b(13, b11);
            flatBufferBuilder.b(14, b12);
            flatBufferBuilder.b(15, b13);
            flatBufferBuilder.b(16, b14);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 580291707)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineBoardingPassModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1760d;
        @Nullable
        private List<AirlineProductItemModel> f1761e;
        @Nullable
        private AirlineFlightInfoModel f1762f;
        @Nullable
        private String f1763g;
        @Nullable
        private AirlineProductItemModel f1764h;
        @Nullable
        private AirlinePassengerSegmentDetailModel f1765i;
        @Nullable
        private String f1766j;
        @Nullable
        private String f1767k;
        @Nullable
        private String f1768l;
        @Nullable
        private List<AirlineProductItemModel> f1769m;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1750a;
            @Nullable
            public ImmutableList<AirlineProductItemModel> f1751b;
            @Nullable
            public AirlineFlightInfoModel f1752c;
            @Nullable
            public String f1753d;
            @Nullable
            public AirlineProductItemModel f1754e;
            @Nullable
            public AirlinePassengerSegmentDetailModel f1755f;
            @Nullable
            public String f1756g;
            @Nullable
            public String f1757h;
            @Nullable
            public String f1758i;
            @Nullable
            public ImmutableList<AirlineProductItemModel> f1759j;

            public final AirlineBoardingPassModel m3054a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f1750a);
                int a = ModelHelper.a(flatBufferBuilder, this.f1751b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f1752c);
                int b2 = flatBufferBuilder.b(this.f1753d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f1754e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f1755f);
                int b3 = flatBufferBuilder.b(this.f1756g);
                int b4 = flatBufferBuilder.b(this.f1757h);
                int b5 = flatBufferBuilder.b(this.f1758i);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f1759j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.b(7, b4);
                flatBufferBuilder.b(8, b5);
                flatBufferBuilder.b(9, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AirlineBoardingPassModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineBoardingPassModel.class, new Deserializer());
            }

            public Object m3055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlineBoardingPassParser.m3185b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlineBoardingPassModel = new AirlineBoardingPassModel();
                ((BaseModel) airlineBoardingPassModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlineBoardingPassModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineBoardingPassModel).a();
                }
                return airlineBoardingPassModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineBoardingPassModel> {
            public final void m3056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineBoardingPassModel airlineBoardingPassModel = (AirlineBoardingPassModel) obj;
                if (airlineBoardingPassModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineBoardingPassModel.m3061a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineBoardingPassModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineBoardingPassParser.m3186b(airlineBoardingPassModel.w_(), airlineBoardingPassModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlineBoardingPassModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AirlineProductItemModel aU_() {
            return m3059m();
        }

        @Nullable
        public final /* synthetic */ AirlineFlightInfoModel m3065c() {
            return m3058l();
        }

        @Nullable
        public final /* synthetic */ AirlinePassengerSegmentDetailModel m3067g() {
            return m3060n();
        }

        public AirlineBoardingPassModel() {
            super(10);
        }

        public AirlineBoardingPassModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3063a() {
            this.f1760d = super.a(this.f1760d, 0);
            return this.f1760d;
        }

        @Nonnull
        public final ImmutableList<AirlineProductItemModel> m3064b() {
            this.f1761e = super.a(this.f1761e, 1, AirlineProductItemModel.class);
            return (ImmutableList) this.f1761e;
        }

        @Nullable
        private AirlineFlightInfoModel m3058l() {
            this.f1762f = (AirlineFlightInfoModel) super.a(this.f1762f, 2, AirlineFlightInfoModel.class);
            return this.f1762f;
        }

        @Nullable
        public final String m3066d() {
            this.f1763g = super.a(this.f1763g, 3);
            return this.f1763g;
        }

        @Nullable
        private AirlineProductItemModel m3059m() {
            this.f1764h = (AirlineProductItemModel) super.a(this.f1764h, 4, AirlineProductItemModel.class);
            return this.f1764h;
        }

        @Nullable
        private AirlinePassengerSegmentDetailModel m3060n() {
            this.f1765i = (AirlinePassengerSegmentDetailModel) super.a(this.f1765i, 5, AirlinePassengerSegmentDetailModel.class);
            return this.f1765i;
        }

        @Nullable
        public final String aS_() {
            this.f1766j = super.a(this.f1766j, 6);
            return this.f1766j;
        }

        @Nullable
        public final String aT_() {
            this.f1767k = super.a(this.f1767k, 7);
            return this.f1767k;
        }

        @Nullable
        public final String m3068j() {
            this.f1768l = super.a(this.f1768l, 8);
            return this.f1768l;
        }

        @Nonnull
        public final ImmutableList<AirlineProductItemModel> m3069k() {
            this.f1769m = super.a(this.f1769m, 9, AirlineProductItemModel.class);
            return (ImmutableList) this.f1769m;
        }

        public static AirlineBoardingPassModel m3057a(AirlineBoardingPassModel airlineBoardingPassModel) {
            int i = 0;
            if (airlineBoardingPassModel == null) {
                return null;
            }
            if (airlineBoardingPassModel instanceof AirlineBoardingPassModel) {
                return airlineBoardingPassModel;
            }
            Builder builder = new Builder();
            builder.f1750a = airlineBoardingPassModel.m3063a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < airlineBoardingPassModel.m3064b().size(); i2++) {
                builder2.c(AirlineProductItemModel.m3165a((AirlineProductItemModel) airlineBoardingPassModel.m3064b().get(i2)));
            }
            builder.f1751b = builder2.b();
            builder.f1752c = AirlineFlightInfoModel.m3126a(airlineBoardingPassModel.m3065c());
            builder.f1753d = airlineBoardingPassModel.m3066d();
            builder.f1754e = AirlineProductItemModel.m3165a(airlineBoardingPassModel.aU_());
            builder.f1755f = AirlinePassengerSegmentDetailModel.m3155a(airlineBoardingPassModel.m3067g());
            builder.f1756g = airlineBoardingPassModel.aS_();
            builder.f1757h = airlineBoardingPassModel.aT_();
            builder.f1758i = airlineBoardingPassModel.m3068j();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < airlineBoardingPassModel.m3069k().size()) {
                builder3.c(AirlineProductItemModel.m3165a((AirlineProductItemModel) airlineBoardingPassModel.m3069k().get(i)));
                i++;
            }
            builder.f1759j = builder3.b();
            return builder.m3054a();
        }

        public final int jK_() {
            return 1838182175;
        }

        public final GraphQLVisitableModel m3062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            AirlineBoardingPassModel airlineBoardingPassModel;
            GraphQLVisitableModel graphQLVisitableModel;
            AirlineFlightInfoModel airlineFlightInfoModel;
            AirlineProductItemModel airlineProductItemModel;
            AirlinePassengerSegmentDetailModel airlinePassengerSegmentDetailModel;
            com.google.common.collect.ImmutableList.Builder a;
            h();
            if (m3064b() != null) {
                com.google.common.collect.ImmutableList.Builder a2 = ModelHelper.a(m3064b(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    airlineBoardingPassModel = (AirlineBoardingPassModel) ModelHelper.a(null, this);
                    airlineBoardingPassModel.f1761e = a2.b();
                    graphQLVisitableModel = airlineBoardingPassModel;
                    if (m3058l() != null) {
                        airlineFlightInfoModel = (AirlineFlightInfoModel) graphQLModelMutatingVisitor.b(m3058l());
                        if (m3058l() != airlineFlightInfoModel) {
                            graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1762f = airlineFlightInfoModel;
                        }
                    }
                    if (m3059m() != null) {
                        airlineProductItemModel = (AirlineProductItemModel) graphQLModelMutatingVisitor.b(m3059m());
                        if (m3059m() != airlineProductItemModel) {
                            graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1764h = airlineProductItemModel;
                        }
                    }
                    if (m3060n() != null) {
                        airlinePassengerSegmentDetailModel = (AirlinePassengerSegmentDetailModel) graphQLModelMutatingVisitor.b(m3060n());
                        if (m3060n() != airlinePassengerSegmentDetailModel) {
                            graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1765i = airlinePassengerSegmentDetailModel;
                        }
                    }
                    if (m3069k() != null) {
                        a = ModelHelper.a(m3069k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            airlineBoardingPassModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                            airlineBoardingPassModel.f1769m = a.b();
                            graphQLVisitableModel = airlineBoardingPassModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m3058l() != null) {
                airlineFlightInfoModel = (AirlineFlightInfoModel) graphQLModelMutatingVisitor.b(m3058l());
                if (m3058l() != airlineFlightInfoModel) {
                    graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1762f = airlineFlightInfoModel;
                }
            }
            if (m3059m() != null) {
                airlineProductItemModel = (AirlineProductItemModel) graphQLModelMutatingVisitor.b(m3059m());
                if (m3059m() != airlineProductItemModel) {
                    graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1764h = airlineProductItemModel;
                }
            }
            if (m3060n() != null) {
                airlinePassengerSegmentDetailModel = (AirlinePassengerSegmentDetailModel) graphQLModelMutatingVisitor.b(m3060n());
                if (m3060n() != airlinePassengerSegmentDetailModel) {
                    graphQLVisitableModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1765i = airlinePassengerSegmentDetailModel;
                }
            }
            if (m3069k() != null) {
                a = ModelHelper.a(m3069k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    airlineBoardingPassModel = (AirlineBoardingPassModel) ModelHelper.a(graphQLVisitableModel, this);
                    airlineBoardingPassModel.f1769m = a.b();
                    graphQLVisitableModel = airlineBoardingPassModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m3061a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3063a());
            int a = ModelHelper.a(flatBufferBuilder, m3064b());
            int a2 = ModelHelper.a(flatBufferBuilder, m3058l());
            int b2 = flatBufferBuilder.b(m3066d());
            int a3 = ModelHelper.a(flatBufferBuilder, m3059m());
            int a4 = ModelHelper.a(flatBufferBuilder, m3060n());
            int b3 = flatBufferBuilder.b(aS_());
            int b4 = flatBufferBuilder.b(aT_());
            int b5 = flatBufferBuilder.b(m3068j());
            int a5 = ModelHelper.a(flatBufferBuilder, m3069k());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, b5);
            flatBufferBuilder.b(9, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1008334340)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineConfirmationBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, AirlineConfirmationBubble {
        @Nullable
        private String f1786d;
        @Nullable
        private String f1787e;
        @Nullable
        private String f1788f;
        @Nullable
        private ItineraryLegsModel f1789g;
        @Nullable
        private LogoImageModel f1790h;
        @Nullable
        private List<AirlinePassengerModel> f1791i;
        @Nullable
        private String f1792j;
        @Nullable
        private String f1793k;
        @Nullable
        private String f1794l;
        @Nullable
        private String f1795m;
        @Nullable
        private String f1796n;

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineConfirmationBubbleModel.class, new Deserializer());
            }

            public Object m3070a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AirlineConfirmationBubbleParser.m3197a(jsonParser);
                Object airlineConfirmationBubbleModel = new AirlineConfirmationBubbleModel();
                ((BaseModel) airlineConfirmationBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (airlineConfirmationBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineConfirmationBubbleModel).a();
                }
                return airlineConfirmationBubbleModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -678578822)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: vertical_margin */
        public final class ItineraryLegsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1785d;

            /* compiled from: vertical_margin */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f1770a;
            }

            /* compiled from: vertical_margin */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItineraryLegsModel.class, new Deserializer());
                }

                public Object m3071a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItineraryLegsParser.m3195a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 1117111183)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: vertical_margin */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1783d;
                @Nullable
                private SegmentsModel f1784e;

                /* compiled from: vertical_margin */
                public final class Builder {
                    @Nullable
                    public String f1771a;
                    @Nullable
                    public SegmentsModel f1772b;
                }

                /* compiled from: vertical_margin */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m3072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m3193b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1459387402)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: vertical_margin */
                public final class SegmentsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<SegmentsNodesModel> f1782d;

                    /* compiled from: vertical_margin */
                    public final class Builder {
                        @Nullable
                        public ImmutableList<SegmentsNodesModel> f1773a;
                    }

                    /* compiled from: vertical_margin */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SegmentsModel.class, new Deserializer());
                        }

                        public Object m3073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SegmentsParser.m3191a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 1493595711)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: vertical_margin */
                    public final class SegmentsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private FlightInfoModel f1781d;

                        /* compiled from: vertical_margin */
                        public final class Builder {
                            @Nullable
                            public FlightInfoModel f1774a;
                        }

                        /* compiled from: vertical_margin */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SegmentsNodesModel.class, new Deserializer());
                            }

                            public Object m3074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SegmentsNodesParser.m3189b(jsonParser, flatBufferBuilder));
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

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1183880450)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: vertical_margin */
                        public final class FlightInfoModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private AirportInfoModel f1778d;
                            @Nullable
                            private AirportInfoModel f1779e;
                            @Nullable
                            private AirlineFlightTimeInfoModel f1780f;

                            /* compiled from: vertical_margin */
                            public final class Builder {
                                @Nullable
                                public AirportInfoModel f1775a;
                                @Nullable
                                public AirportInfoModel f1776b;
                                @Nullable
                                public AirlineFlightTimeInfoModel f1777c;
                            }

                            /* compiled from: vertical_margin */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(FlightInfoModel.class, new Deserializer());
                                }

                                public Object m3075a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(FlightInfoParser.m3187a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object flightInfoModel = new FlightInfoModel();
                                    ((BaseModel) flightInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (flightInfoModel instanceof Postprocessable) {
                                        return ((Postprocessable) flightInfoModel).a();
                                    }
                                    return flightInfoModel;
                                }
                            }

                            /* compiled from: vertical_margin */
                            public class Serializer extends JsonSerializer<FlightInfoModel> {
                                public final void m3076a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    FlightInfoModel flightInfoModel = (FlightInfoModel) obj;
                                    if (flightInfoModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(flightInfoModel.m3081a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        flightInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    FlightInfoParser.m3188a(flightInfoModel.w_(), flightInfoModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(FlightInfoModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ AirportInfoModel m3083a() {
                                return m3078j();
                            }

                            @Nullable
                            public final /* synthetic */ AirportInfoModel m3084b() {
                                return m3079k();
                            }

                            @Nullable
                            public final /* synthetic */ AirlineFlightTimeInfoModel m3085c() {
                                return m3080l();
                            }

                            public FlightInfoModel() {
                                super(3);
                            }

                            public FlightInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                                super(3);
                                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }

                            @Nullable
                            private AirportInfoModel m3078j() {
                                this.f1778d = (AirportInfoModel) super.a(this.f1778d, 0, AirportInfoModel.class);
                                return this.f1778d;
                            }

                            @Nullable
                            private AirportInfoModel m3079k() {
                                this.f1779e = (AirportInfoModel) super.a(this.f1779e, 1, AirportInfoModel.class);
                                return this.f1779e;
                            }

                            @Nullable
                            private AirlineFlightTimeInfoModel m3080l() {
                                this.f1780f = (AirlineFlightTimeInfoModel) super.a(this.f1780f, 2, AirlineFlightTimeInfoModel.class);
                                return this.f1780f;
                            }

                            public static FlightInfoModel m3077a(FlightInfoModel flightInfoModel) {
                                if (flightInfoModel == null) {
                                    return null;
                                }
                                if (flightInfoModel instanceof FlightInfoModel) {
                                    return flightInfoModel;
                                }
                                Builder builder = new Builder();
                                builder.f1775a = AirportInfoModel.m3172a(flightInfoModel.m3083a());
                                builder.f1776b = AirportInfoModel.m3172a(flightInfoModel.m3084b());
                                builder.f1777c = AirlineFlightTimeInfoModel.m3141a(flightInfoModel.m3085c());
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int a = ModelHelper.a(flatBufferBuilder, builder.f1775a);
                                int a2 = ModelHelper.a(flatBufferBuilder, builder.f1776b);
                                int a3 = ModelHelper.a(flatBufferBuilder, builder.f1777c);
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new FlightInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }

                            public final int jK_() {
                                return 578256892;
                            }

                            public final GraphQLVisitableModel m3082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                AirportInfoModel airportInfoModel;
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m3078j() != null) {
                                    airportInfoModel = (AirportInfoModel) graphQLModelMutatingVisitor.b(m3078j());
                                    if (m3078j() != airportInfoModel) {
                                        graphQLVisitableModel = (FlightInfoModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f1778d = airportInfoModel;
                                    }
                                }
                                if (m3079k() != null) {
                                    airportInfoModel = (AirportInfoModel) graphQLModelMutatingVisitor.b(m3079k());
                                    if (m3079k() != airportInfoModel) {
                                        graphQLVisitableModel = (FlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f1779e = airportInfoModel;
                                    }
                                }
                                if (m3080l() != null) {
                                    AirlineFlightTimeInfoModel airlineFlightTimeInfoModel = (AirlineFlightTimeInfoModel) graphQLModelMutatingVisitor.b(m3080l());
                                    if (m3080l() != airlineFlightTimeInfoModel) {
                                        graphQLVisitableModel = (FlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f1780f = airlineFlightTimeInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m3081a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m3078j());
                                int a2 = ModelHelper.a(flatBufferBuilder, m3079k());
                                int a3 = ModelHelper.a(flatBufferBuilder, m3080l());
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: vertical_margin */
                        public class Serializer extends JsonSerializer<SegmentsNodesModel> {
                            public final void m3086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SegmentsNodesModel segmentsNodesModel = (SegmentsNodesModel) obj;
                                if (segmentsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(segmentsNodesModel.m3089a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    segmentsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SegmentsNodesParser.m3190b(segmentsNodesModel.w_(), segmentsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(SegmentsNodesModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ FlightInfoModel m3091a() {
                            return m3088j();
                        }

                        public SegmentsNodesModel() {
                            super(1);
                        }

                        public SegmentsNodesModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(1);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        @Nullable
                        private FlightInfoModel m3088j() {
                            this.f1781d = (FlightInfoModel) super.a(this.f1781d, 0, FlightInfoModel.class);
                            return this.f1781d;
                        }

                        public static SegmentsNodesModel m3087a(SegmentsNodesModel segmentsNodesModel) {
                            if (segmentsNodesModel == null) {
                                return null;
                            }
                            if (segmentsNodesModel instanceof SegmentsNodesModel) {
                                return segmentsNodesModel;
                            }
                            Builder builder = new Builder();
                            builder.f1774a = FlightInfoModel.m3077a(segmentsNodesModel.m3091a());
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, builder.f1774a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new SegmentsNodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }

                        public final int jK_() {
                            return -867247804;
                        }

                        public final GraphQLVisitableModel m3090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m3088j() != null) {
                                FlightInfoModel flightInfoModel = (FlightInfoModel) graphQLModelMutatingVisitor.b(m3088j());
                                if (m3088j() != flightInfoModel) {
                                    graphQLVisitableModel = (SegmentsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1781d = flightInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m3089a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m3088j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: vertical_margin */
                    public class Serializer extends JsonSerializer<SegmentsModel> {
                        public final void m3092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SegmentsModel segmentsModel = (SegmentsModel) obj;
                            if (segmentsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(segmentsModel.m3094a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                segmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SegmentsParser.m3192a(segmentsModel.w_(), segmentsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(SegmentsModel.class, new Serializer());
                        }
                    }

                    public SegmentsModel() {
                        super(1);
                    }

                    public SegmentsModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nonnull
                    public final ImmutableList<SegmentsNodesModel> m3096a() {
                        this.f1782d = super.a(this.f1782d, 0, SegmentsNodesModel.class);
                        return (ImmutableList) this.f1782d;
                    }

                    public static SegmentsModel m3093a(SegmentsModel segmentsModel) {
                        if (segmentsModel == null) {
                            return null;
                        }
                        if (segmentsModel instanceof SegmentsModel) {
                            return segmentsModel;
                        }
                        Builder builder = new Builder();
                        com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                        for (int i = 0; i < segmentsModel.m3096a().size(); i++) {
                            builder2.c(SegmentsNodesModel.m3087a((SegmentsNodesModel) segmentsModel.m3096a().get(i)));
                        }
                        builder.f1773a = builder2.b();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f1773a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new SegmentsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 1957188619;
                    }

                    public final GraphQLVisitableModel m3095a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m3096a() != null) {
                            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m3096a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (SegmentsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1782d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m3094a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m3096a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: vertical_margin */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m3097a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m3100a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m3194b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SegmentsModel m3103b() {
                    return m3099j();
                }

                public NodesModel() {
                    super(2);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m3102a() {
                    this.f1783d = super.a(this.f1783d, 0);
                    return this.f1783d;
                }

                @Nullable
                private SegmentsModel m3099j() {
                    this.f1784e = (SegmentsModel) super.a(this.f1784e, 1, SegmentsModel.class);
                    return this.f1784e;
                }

                public static NodesModel m3098a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f1771a = nodesModel.m3102a();
                    builder.f1772b = SegmentsModel.m3093a(nodesModel.m3103b());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f1771a);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f1772b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1233789887;
                }

                public final GraphQLVisitableModel m3101a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3099j() != null) {
                        SegmentsModel segmentsModel = (SegmentsModel) graphQLModelMutatingVisitor.b(m3099j());
                        if (m3099j() != segmentsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1784e = segmentsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3100a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m3102a());
                    int a = ModelHelper.a(flatBufferBuilder, m3099j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: vertical_margin */
            public class Serializer extends JsonSerializer<ItineraryLegsModel> {
                public final void m3104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItineraryLegsModel itineraryLegsModel = (ItineraryLegsModel) obj;
                    if (itineraryLegsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itineraryLegsModel.m3106a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itineraryLegsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItineraryLegsParser.m3196a(itineraryLegsModel.w_(), itineraryLegsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ItineraryLegsModel.class, new Serializer());
                }
            }

            public ItineraryLegsModel() {
                super(1);
            }

            public ItineraryLegsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m3108a() {
                this.f1785d = super.a(this.f1785d, 0, NodesModel.class);
                return (ImmutableList) this.f1785d;
            }

            public static ItineraryLegsModel m3105a(ItineraryLegsModel itineraryLegsModel) {
                if (itineraryLegsModel == null) {
                    return null;
                }
                if (itineraryLegsModel instanceof ItineraryLegsModel) {
                    return itineraryLegsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < itineraryLegsModel.m3108a().size(); i++) {
                    builder2.c(NodesModel.m3098a((NodesModel) itineraryLegsModel.m3108a().get(i)));
                }
                builder.f1770a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1770a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ItineraryLegsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -403289904;
            }

            public final GraphQLVisitableModel m3107a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3108a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m3108a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ItineraryLegsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1785d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3106a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3108a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineConfirmationBubbleModel> {
            public final void m3109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineConfirmationBubbleModel airlineConfirmationBubbleModel = (AirlineConfirmationBubbleModel) obj;
                if (airlineConfirmationBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineConfirmationBubbleModel.m3121a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineConfirmationBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineConfirmationBubbleParser.m3198a(airlineConfirmationBubbleModel.w_(), airlineConfirmationBubbleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlineConfirmationBubbleModel.class, new Serializer());
            }
        }

        public AirlineConfirmationBubbleModel() {
            super(11);
        }

        @Nullable
        private String m3110j() {
            this.f1786d = super.a(this.f1786d, 0);
            return this.f1786d;
        }

        @Nullable
        private String m3111k() {
            this.f1787e = super.a(this.f1787e, 1);
            return this.f1787e;
        }

        @Nullable
        private String m3112l() {
            this.f1788f = super.a(this.f1788f, 2);
            return this.f1788f;
        }

        @Nullable
        private ItineraryLegsModel m3113m() {
            this.f1789g = (ItineraryLegsModel) super.a(this.f1789g, 3, ItineraryLegsModel.class);
            return this.f1789g;
        }

        @Nullable
        private LogoImageModel m3114n() {
            this.f1790h = (LogoImageModel) super.a(this.f1790h, 4, LogoImageModel.class);
            return this.f1790h;
        }

        @Nonnull
        private ImmutableList<AirlinePassengerModel> m3115o() {
            this.f1791i = super.a(this.f1791i, 5, AirlinePassengerModel.class);
            return (ImmutableList) this.f1791i;
        }

        @Nullable
        private String m3116p() {
            this.f1792j = super.a(this.f1792j, 6);
            return this.f1792j;
        }

        @Nullable
        private String m3117q() {
            this.f1793k = super.a(this.f1793k, 7);
            return this.f1793k;
        }

        @Nullable
        private String m3118r() {
            this.f1794l = super.a(this.f1794l, 8);
            return this.f1794l;
        }

        @Nullable
        private String m3119s() {
            this.f1795m = super.a(this.f1795m, 9);
            return this.f1795m;
        }

        @Nullable
        private String m3120t() {
            this.f1796n = super.a(this.f1796n, 10);
            return this.f1796n;
        }

        @Nullable
        public final String m3123a() {
            return m3112l();
        }

        public final int jK_() {
            return 1534197117;
        }

        public final GraphQLVisitableModel m3122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3113m() != null) {
                ItineraryLegsModel itineraryLegsModel = (ItineraryLegsModel) graphQLModelMutatingVisitor.b(m3113m());
                if (m3113m() != itineraryLegsModel) {
                    graphQLVisitableModel = (AirlineConfirmationBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1789g = itineraryLegsModel;
                }
            }
            if (m3114n() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m3114n());
                if (m3114n() != logoImageModel) {
                    graphQLVisitableModel = (AirlineConfirmationBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1790h = logoImageModel;
                }
            }
            if (m3115o() != null) {
                Builder a = ModelHelper.a(m3115o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AirlineConfirmationBubbleModel airlineConfirmationBubbleModel = (AirlineConfirmationBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    airlineConfirmationBubbleModel.f1791i = a.b();
                    graphQLVisitableModel = airlineConfirmationBubbleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3121a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3110j());
            int b2 = flatBufferBuilder.b(m3111k());
            int b3 = flatBufferBuilder.b(m3112l());
            int a = ModelHelper.a(flatBufferBuilder, m3113m());
            int a2 = ModelHelper.a(flatBufferBuilder, m3114n());
            int a3 = ModelHelper.a(flatBufferBuilder, m3115o());
            int b4 = flatBufferBuilder.b(m3116p());
            int b5 = flatBufferBuilder.b(m3117q());
            int b6 = flatBufferBuilder.b(m3118r());
            int b7 = flatBufferBuilder.b(m3119s());
            int b8 = flatBufferBuilder.b(m3120t());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, b7);
            flatBufferBuilder.b(10, b8);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 498150178)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineFlightInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1804d;
        @Nullable
        private AirportInfoModel f1805e;
        @Nullable
        private AirlineFlightTimeInfoModel f1806f;
        @Nullable
        private AirlineFlightTimeInfoModel f1807g;
        @Nullable
        private AirportInfoModel f1808h;
        @Nullable
        private AirlineFlightTimeInfoModel f1809i;
        @Nullable
        private String f1810j;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1797a;
            @Nullable
            public AirportInfoModel f1798b;
            @Nullable
            public AirlineFlightTimeInfoModel f1799c;
            @Nullable
            public AirlineFlightTimeInfoModel f1800d;
            @Nullable
            public AirportInfoModel f1801e;
            @Nullable
            public AirlineFlightTimeInfoModel f1802f;
            @Nullable
            public String f1803g;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineFlightInfoModel.class, new Deserializer());
            }

            public Object m3124a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlineFlightInfoParser.m3199a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlineFlightInfoModel = new AirlineFlightInfoModel();
                ((BaseModel) airlineFlightInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlineFlightInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineFlightInfoModel).a();
                }
                return airlineFlightInfoModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineFlightInfoModel> {
            public final void m3125a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineFlightInfoModel airlineFlightInfoModel = (AirlineFlightInfoModel) obj;
                if (airlineFlightInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineFlightInfoModel.m3132a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineFlightInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineFlightInfoParser.m3201b(airlineFlightInfoModel.w_(), airlineFlightInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlineFlightInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AirportInfoModel aW_() {
            return m3130m();
        }

        @Nullable
        public final /* synthetic */ AirportInfoModel m3135b() {
            return m3127j();
        }

        @Nullable
        public final /* synthetic */ AirlineFlightTimeInfoModel m3136c() {
            return m3128k();
        }

        @Nullable
        public final /* synthetic */ AirlineFlightTimeInfoModel m3137d() {
            return m3129l();
        }

        @Nullable
        public final /* synthetic */ AirlineFlightTimeInfoModel m3138g() {
            return m3131n();
        }

        public AirlineFlightInfoModel() {
            super(7);
        }

        public AirlineFlightInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3134a() {
            this.f1804d = super.a(this.f1804d, 0);
            return this.f1804d;
        }

        @Nullable
        private AirportInfoModel m3127j() {
            this.f1805e = (AirportInfoModel) super.a(this.f1805e, 1, AirportInfoModel.class);
            return this.f1805e;
        }

        @Nullable
        private AirlineFlightTimeInfoModel m3128k() {
            this.f1806f = (AirlineFlightTimeInfoModel) super.a(this.f1806f, 2, AirlineFlightTimeInfoModel.class);
            return this.f1806f;
        }

        @Nullable
        private AirlineFlightTimeInfoModel m3129l() {
            this.f1807g = (AirlineFlightTimeInfoModel) super.a(this.f1807g, 3, AirlineFlightTimeInfoModel.class);
            return this.f1807g;
        }

        @Nullable
        private AirportInfoModel m3130m() {
            this.f1808h = (AirportInfoModel) super.a(this.f1808h, 4, AirportInfoModel.class);
            return this.f1808h;
        }

        @Nullable
        private AirlineFlightTimeInfoModel m3131n() {
            this.f1809i = (AirlineFlightTimeInfoModel) super.a(this.f1809i, 5, AirlineFlightTimeInfoModel.class);
            return this.f1809i;
        }

        @Nullable
        public final String aV_() {
            this.f1810j = super.a(this.f1810j, 6);
            return this.f1810j;
        }

        public static AirlineFlightInfoModel m3126a(AirlineFlightInfoModel airlineFlightInfoModel) {
            if (airlineFlightInfoModel == null) {
                return null;
            }
            if (airlineFlightInfoModel instanceof AirlineFlightInfoModel) {
                return airlineFlightInfoModel;
            }
            Builder builder = new Builder();
            builder.f1797a = airlineFlightInfoModel.m3134a();
            builder.f1798b = AirportInfoModel.m3172a(airlineFlightInfoModel.m3135b());
            builder.f1799c = AirlineFlightTimeInfoModel.m3141a(airlineFlightInfoModel.m3136c());
            builder.f1800d = AirlineFlightTimeInfoModel.m3141a(airlineFlightInfoModel.m3137d());
            builder.f1801e = AirportInfoModel.m3172a(airlineFlightInfoModel.aW_());
            builder.f1802f = AirlineFlightTimeInfoModel.m3141a(airlineFlightInfoModel.m3138g());
            builder.f1803g = airlineFlightInfoModel.aV_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1797a);
            int a = ModelHelper.a(flatBufferBuilder, builder.f1798b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f1799c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f1800d);
            int a4 = ModelHelper.a(flatBufferBuilder, builder.f1801e);
            int a5 = ModelHelper.a(flatBufferBuilder, builder.f1802f);
            int b2 = flatBufferBuilder.b(builder.f1803g);
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirlineFlightInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 578256892;
        }

        public final GraphQLVisitableModel m3133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            AirportInfoModel airportInfoModel;
            AirlineFlightTimeInfoModel airlineFlightTimeInfoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3127j() != null) {
                airportInfoModel = (AirportInfoModel) graphQLModelMutatingVisitor.b(m3127j());
                if (m3127j() != airportInfoModel) {
                    graphQLVisitableModel = (AirlineFlightInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1805e = airportInfoModel;
                }
            }
            if (m3128k() != null) {
                airlineFlightTimeInfoModel = (AirlineFlightTimeInfoModel) graphQLModelMutatingVisitor.b(m3128k());
                if (m3128k() != airlineFlightTimeInfoModel) {
                    graphQLVisitableModel = (AirlineFlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1806f = airlineFlightTimeInfoModel;
                }
            }
            if (m3129l() != null) {
                airlineFlightTimeInfoModel = (AirlineFlightTimeInfoModel) graphQLModelMutatingVisitor.b(m3129l());
                if (m3129l() != airlineFlightTimeInfoModel) {
                    graphQLVisitableModel = (AirlineFlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1807g = airlineFlightTimeInfoModel;
                }
            }
            if (m3130m() != null) {
                airportInfoModel = (AirportInfoModel) graphQLModelMutatingVisitor.b(m3130m());
                if (m3130m() != airportInfoModel) {
                    graphQLVisitableModel = (AirlineFlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1808h = airportInfoModel;
                }
            }
            if (m3131n() != null) {
                airlineFlightTimeInfoModel = (AirlineFlightTimeInfoModel) graphQLModelMutatingVisitor.b(m3131n());
                if (m3131n() != airlineFlightTimeInfoModel) {
                    graphQLVisitableModel = (AirlineFlightInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1809i = airlineFlightTimeInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3132a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3134a());
            int a = ModelHelper.a(flatBufferBuilder, m3127j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3128k());
            int a3 = ModelHelper.a(flatBufferBuilder, m3129l());
            int a4 = ModelHelper.a(flatBufferBuilder, m3130m());
            int a5 = ModelHelper.a(flatBufferBuilder, m3131n());
            int b2 = flatBufferBuilder.b(aV_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1402090837)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineFlightTimeInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1814d;
        @Nullable
        private String f1815e;
        @Nullable
        private String f1816f;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1811a;
            @Nullable
            public String f1812b;
            @Nullable
            public String f1813c;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineFlightTimeInfoModel.class, new Deserializer());
            }

            public Object m3139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlineFlightTimeInfoParser.m3202a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlineFlightTimeInfoModel = new AirlineFlightTimeInfoModel();
                ((BaseModel) airlineFlightTimeInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlineFlightTimeInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineFlightTimeInfoModel).a();
                }
                return airlineFlightTimeInfoModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineFlightTimeInfoModel> {
            public final void m3140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineFlightTimeInfoModel airlineFlightTimeInfoModel = (AirlineFlightTimeInfoModel) obj;
                if (airlineFlightTimeInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineFlightTimeInfoModel.m3142a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineFlightTimeInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineFlightTimeInfoParser.m3203a(airlineFlightTimeInfoModel.w_(), airlineFlightTimeInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AirlineFlightTimeInfoModel.class, new Serializer());
            }
        }

        public AirlineFlightTimeInfoModel() {
            super(3);
        }

        public AirlineFlightTimeInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3144a() {
            this.f1814d = super.a(this.f1814d, 0);
            return this.f1814d;
        }

        @Nullable
        public final String m3145b() {
            this.f1815e = super.a(this.f1815e, 1);
            return this.f1815e;
        }

        @Nullable
        public final String m3146c() {
            this.f1816f = super.a(this.f1816f, 2);
            return this.f1816f;
        }

        public static AirlineFlightTimeInfoModel m3141a(AirlineFlightTimeInfoModel airlineFlightTimeInfoModel) {
            if (airlineFlightTimeInfoModel == null) {
                return null;
            }
            if (airlineFlightTimeInfoModel instanceof AirlineFlightTimeInfoModel) {
                return airlineFlightTimeInfoModel;
            }
            Builder builder = new Builder();
            builder.f1811a = airlineFlightTimeInfoModel.m3144a();
            builder.f1812b = airlineFlightTimeInfoModel.m3145b();
            builder.f1813c = airlineFlightTimeInfoModel.m3146c();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1811a);
            int b2 = flatBufferBuilder.b(builder.f1812b);
            int b3 = flatBufferBuilder.b(builder.f1813c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirlineFlightTimeInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1808481943;
        }

        public final GraphQLVisitableModel m3143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3142a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3144a());
            int b2 = flatBufferBuilder.b(m3145b());
            int b3 = flatBufferBuilder.b(m3146c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 273304230)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlinePassengerModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1818d;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1817a;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlinePassengerModel.class, new Deserializer());
            }

            public Object m3147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlinePassengerParser.m3204a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlinePassengerModel = new AirlinePassengerModel();
                ((BaseModel) airlinePassengerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlinePassengerModel instanceof Postprocessable) {
                    return ((Postprocessable) airlinePassengerModel).a();
                }
                return airlinePassengerModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlinePassengerModel> {
            public final void m3148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlinePassengerModel airlinePassengerModel = (AirlinePassengerModel) obj;
                if (airlinePassengerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlinePassengerModel.m3150a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlinePassengerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlinePassengerParser.m3205a(airlinePassengerModel.w_(), airlinePassengerModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AirlinePassengerModel.class, new Serializer());
            }
        }

        public AirlinePassengerModel() {
            super(1);
        }

        public AirlinePassengerModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3152a() {
            this.f1818d = super.a(this.f1818d, 0);
            return this.f1818d;
        }

        public static AirlinePassengerModel m3149a(AirlinePassengerModel airlinePassengerModel) {
            if (airlinePassengerModel == null) {
                return null;
            }
            if (airlinePassengerModel instanceof AirlinePassengerModel) {
                return airlinePassengerModel;
            }
            Builder builder = new Builder();
            builder.f1817a = airlinePassengerModel.m3152a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1817a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirlinePassengerModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 391064092;
        }

        public final GraphQLVisitableModel m3151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3150a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3152a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1356773422)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlinePassengerSegmentDetailModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AirlinePassengerModel f1824d;
        @Nullable
        private List<AirlineProductItemModel> f1825e;
        @Nullable
        private String f1826f;
        @Nullable
        private String f1827g;
        @Nullable
        private String f1828h;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public AirlinePassengerModel f1819a;
            @Nullable
            public ImmutableList<AirlineProductItemModel> f1820b;
            @Nullable
            public String f1821c;
            @Nullable
            public String f1822d;
            @Nullable
            public String f1823e;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlinePassengerSegmentDetailModel.class, new Deserializer());
            }

            public Object m3153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlinePassengerSegmentDetailParser.m3208a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlinePassengerSegmentDetailModel = new AirlinePassengerSegmentDetailModel();
                ((BaseModel) airlinePassengerSegmentDetailModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlinePassengerSegmentDetailModel instanceof Postprocessable) {
                    return ((Postprocessable) airlinePassengerSegmentDetailModel).a();
                }
                return airlinePassengerSegmentDetailModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlinePassengerSegmentDetailModel> {
            public final void m3154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlinePassengerSegmentDetailModel airlinePassengerSegmentDetailModel = (AirlinePassengerSegmentDetailModel) obj;
                if (airlinePassengerSegmentDetailModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlinePassengerSegmentDetailModel.m3157a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlinePassengerSegmentDetailModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlinePassengerSegmentDetailParser.m3209b(airlinePassengerSegmentDetailModel.w_(), airlinePassengerSegmentDetailModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AirlinePassengerSegmentDetailModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AirlinePassengerModel m3159a() {
            return m3156j();
        }

        public AirlinePassengerSegmentDetailModel() {
            super(5);
        }

        public AirlinePassengerSegmentDetailModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private AirlinePassengerModel m3156j() {
            this.f1824d = (AirlinePassengerModel) super.a(this.f1824d, 0, AirlinePassengerModel.class);
            return this.f1824d;
        }

        @Nonnull
        public final ImmutableList<AirlineProductItemModel> m3160b() {
            this.f1825e = super.a(this.f1825e, 1, AirlineProductItemModel.class);
            return (ImmutableList) this.f1825e;
        }

        @Nullable
        public final String m3161c() {
            this.f1826f = super.a(this.f1826f, 2);
            return this.f1826f;
        }

        @Nullable
        public final String m3162d() {
            this.f1827g = super.a(this.f1827g, 3);
            return this.f1827g;
        }

        @Nullable
        public final String aX_() {
            this.f1828h = super.a(this.f1828h, 4);
            return this.f1828h;
        }

        public static AirlinePassengerSegmentDetailModel m3155a(AirlinePassengerSegmentDetailModel airlinePassengerSegmentDetailModel) {
            if (airlinePassengerSegmentDetailModel == null) {
                return null;
            }
            if (airlinePassengerSegmentDetailModel instanceof AirlinePassengerSegmentDetailModel) {
                return airlinePassengerSegmentDetailModel;
            }
            Builder builder = new Builder();
            builder.f1819a = AirlinePassengerModel.m3149a(airlinePassengerSegmentDetailModel.m3159a());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < airlinePassengerSegmentDetailModel.m3160b().size(); i++) {
                builder2.c(AirlineProductItemModel.m3165a((AirlineProductItemModel) airlinePassengerSegmentDetailModel.m3160b().get(i)));
            }
            builder.f1820b = builder2.b();
            builder.f1821c = airlinePassengerSegmentDetailModel.m3161c();
            builder.f1822d = airlinePassengerSegmentDetailModel.m3162d();
            builder.f1823e = airlinePassengerSegmentDetailModel.aX_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f1819a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f1820b);
            int b = flatBufferBuilder.b(builder.f1821c);
            int b2 = flatBufferBuilder.b(builder.f1822d);
            int b3 = flatBufferBuilder.b(builder.f1823e);
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirlinePassengerSegmentDetailModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1965327528;
        }

        public final GraphQLVisitableModel m3158a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3156j() != null) {
                AirlinePassengerModel airlinePassengerModel = (AirlinePassengerModel) graphQLModelMutatingVisitor.b(m3156j());
                if (m3156j() != airlinePassengerModel) {
                    graphQLVisitableModel = (AirlinePassengerSegmentDetailModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1824d = airlinePassengerModel;
                }
            }
            if (m3160b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m3160b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AirlinePassengerSegmentDetailModel airlinePassengerSegmentDetailModel = (AirlinePassengerSegmentDetailModel) ModelHelper.a(graphQLVisitableModel, this);
                    airlinePassengerSegmentDetailModel.f1825e = a.b();
                    graphQLVisitableModel = airlinePassengerSegmentDetailModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3157a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3156j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3160b());
            int b = flatBufferBuilder.b(m3161c());
            int b2 = flatBufferBuilder.b(m3162d());
            int b3 = flatBufferBuilder.b(aX_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -599131306)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirlineProductItemModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1831d;
        @Nullable
        private String f1832e;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1829a;
            @Nullable
            public String f1830b;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirlineProductItemModel.class, new Deserializer());
            }

            public Object m3163a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirlineProductItemParser.m3210a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airlineProductItemModel = new AirlineProductItemModel();
                ((BaseModel) airlineProductItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airlineProductItemModel instanceof Postprocessable) {
                    return ((Postprocessable) airlineProductItemModel).a();
                }
                return airlineProductItemModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirlineProductItemModel> {
            public final void m3164a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirlineProductItemModel airlineProductItemModel = (AirlineProductItemModel) obj;
                if (airlineProductItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airlineProductItemModel.m3166a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airlineProductItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirlineProductItemParser.m3211a(airlineProductItemModel.w_(), airlineProductItemModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AirlineProductItemModel.class, new Serializer());
            }
        }

        public AirlineProductItemModel() {
            super(2);
        }

        public AirlineProductItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3168a() {
            this.f1831d = super.a(this.f1831d, 0);
            return this.f1831d;
        }

        @Nullable
        public final String m3169b() {
            this.f1832e = super.a(this.f1832e, 1);
            return this.f1832e;
        }

        public static AirlineProductItemModel m3165a(AirlineProductItemModel airlineProductItemModel) {
            if (airlineProductItemModel == null) {
                return null;
            }
            if (airlineProductItemModel instanceof AirlineProductItemModel) {
                return airlineProductItemModel;
            }
            Builder builder = new Builder();
            builder.f1829a = airlineProductItemModel.m3168a();
            builder.f1830b = airlineProductItemModel.m3169b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1829a);
            int b2 = flatBufferBuilder.b(builder.f1830b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirlineProductItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1911346780;
        }

        public final GraphQLVisitableModel m3167a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3166a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3168a());
            int b2 = flatBufferBuilder.b(m3169b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1371759860)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vertical_margin */
    public final class AirportInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1837d;
        @Nullable
        private String f1838e;
        @Nullable
        private String f1839f;
        @Nullable
        private String f1840g;

        /* compiled from: vertical_margin */
        public final class Builder {
            @Nullable
            public String f1833a;
            @Nullable
            public String f1834b;
            @Nullable
            public String f1835c;
            @Nullable
            public String f1836d;
        }

        /* compiled from: vertical_margin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AirportInfoModel.class, new Deserializer());
            }

            public Object m3170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AirportInfoParser.m3214a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object airportInfoModel = new AirportInfoModel();
                ((BaseModel) airportInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (airportInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) airportInfoModel).a();
                }
                return airportInfoModel;
            }
        }

        /* compiled from: vertical_margin */
        public class Serializer extends JsonSerializer<AirportInfoModel> {
            public final void m3171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AirportInfoModel airportInfoModel = (AirportInfoModel) obj;
                if (airportInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(airportInfoModel.m3173a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    airportInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AirportInfoParser.m3215a(airportInfoModel.w_(), airportInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AirportInfoModel.class, new Serializer());
            }
        }

        public AirportInfoModel() {
            super(4);
        }

        public AirportInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m3175a() {
            this.f1837d = super.a(this.f1837d, 0);
            return this.f1837d;
        }

        @Nullable
        public final String m3176b() {
            this.f1838e = super.a(this.f1838e, 1);
            return this.f1838e;
        }

        @Nullable
        public final String m3177c() {
            this.f1839f = super.a(this.f1839f, 2);
            return this.f1839f;
        }

        @Nullable
        public final String m3178d() {
            this.f1840g = super.a(this.f1840g, 3);
            return this.f1840g;
        }

        public static AirportInfoModel m3172a(AirportInfoModel airportInfoModel) {
            if (airportInfoModel == null) {
                return null;
            }
            if (airportInfoModel instanceof AirportInfoModel) {
                return airportInfoModel;
            }
            Builder builder = new Builder();
            builder.f1833a = airportInfoModel.m3175a();
            builder.f1834b = airportInfoModel.m3176b();
            builder.f1835c = airportInfoModel.m3177c();
            builder.f1836d = airportInfoModel.m3178d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1833a);
            int b2 = flatBufferBuilder.b(builder.f1834b);
            int b3 = flatBufferBuilder.b(builder.f1835c);
            int b4 = flatBufferBuilder.b(builder.f1836d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AirportInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 839876601;
        }

        public final GraphQLVisitableModel m3174a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3173a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3175a());
            int b2 = flatBufferBuilder.b(m3176b());
            int b3 = flatBufferBuilder.b(m3177c());
            int b4 = flatBufferBuilder.b(m3178d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
