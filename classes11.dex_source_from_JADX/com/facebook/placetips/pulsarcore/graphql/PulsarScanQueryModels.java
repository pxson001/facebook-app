package com.facebook.placetips.pulsarcore.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBeaconScanResultConfidenceLevel;
import com.facebook.graphql.enums.GraphQLPulsarScanQueryResultCode;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentModels.PlaceTipWithReactionUnitsGraphQlFragmentModel;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryParsers.PulsarScanQueryParser;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryParsers.PulsarScanQueryParser.BestGuessParser;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryParsers.PulsarScanQueryParser.BestGuessParser.PulsarParser;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryParsers.SimplePulsarScanQueryParser;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryParsers.SimplePulsarScanQueryParser.BestGuessParser.PulsarParser.PageParser;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentParsers.GravitySettingsGraphQlFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: The ViewPager doesnt have an adapter */
public class PulsarScanQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1709086924)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: The ViewPager doesnt have an adapter */
    public final class PulsarScanQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BestGuessModel f10705d;
        @Nullable
        private GraphQLBeaconScanResultConfidenceLevel f10706e;
        @Nullable
        private GravitySettingsGraphQlFragmentModel f10707f;
        @Nullable
        private GraphQLPulsarScanQueryResultCode f10708g;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1999822156)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: The ViewPager doesnt have an adapter */
        public final class BestGuessModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PulsarModel f10703d;
            private int f10704e;

            /* compiled from: The ViewPager doesnt have an adapter */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BestGuessModel.class, new Deserializer());
                }

                public Object m11200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BestGuessParser.m11251a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bestGuessModel = new BestGuessModel();
                    ((BaseModel) bestGuessModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bestGuessModel instanceof Postprocessable) {
                        return ((Postprocessable) bestGuessModel).a();
                    }
                    return bestGuessModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1848030410)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: The ViewPager doesnt have an adapter */
            public final class PulsarModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PlaceTipWithReactionUnitsGraphQlFragmentModel f10702d;

                /* compiled from: The ViewPager doesnt have an adapter */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PulsarModel.class, new Deserializer());
                    }

                    public Object m11201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PulsarParser.m11249a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pulsarModel = new PulsarModel();
                        ((BaseModel) pulsarModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pulsarModel instanceof Postprocessable) {
                            return ((Postprocessable) pulsarModel).a();
                        }
                        return pulsarModel;
                    }
                }

                /* compiled from: The ViewPager doesnt have an adapter */
                public class Serializer extends JsonSerializer<PulsarModel> {
                    public final void m11202a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PulsarModel pulsarModel = (PulsarModel) obj;
                        if (pulsarModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pulsarModel.m11204a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pulsarModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PulsarParser.m11250a(pulsarModel.w_(), pulsarModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PulsarModel.class, new Serializer());
                    }
                }

                public PulsarModel() {
                    super(1);
                }

                @Nullable
                private PlaceTipWithReactionUnitsGraphQlFragmentModel m11203a() {
                    this.f10702d = (PlaceTipWithReactionUnitsGraphQlFragmentModel) super.a(this.f10702d, 0, PlaceTipWithReactionUnitsGraphQlFragmentModel.class);
                    return this.f10702d;
                }

                public final int jK_() {
                    return -1893252195;
                }

                public final GraphQLVisitableModel m11205a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11203a() != null) {
                        PlaceTipWithReactionUnitsGraphQlFragmentModel placeTipWithReactionUnitsGraphQlFragmentModel = (PlaceTipWithReactionUnitsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m11203a());
                        if (m11203a() != placeTipWithReactionUnitsGraphQlFragmentModel) {
                            graphQLVisitableModel = (PulsarModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10702d = placeTipWithReactionUnitsGraphQlFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11204a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11203a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: The ViewPager doesnt have an adapter */
            public class Serializer extends JsonSerializer<BestGuessModel> {
                public final void m11206a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BestGuessModel bestGuessModel = (BestGuessModel) obj;
                    if (bestGuessModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bestGuessModel.m11208a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bestGuessModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BestGuessParser.m11252a(bestGuessModel.w_(), bestGuessModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BestGuessModel.class, new Serializer());
                }
            }

            public BestGuessModel() {
                super(2);
            }

            @Nullable
            private PulsarModel m11207a() {
                this.f10703d = (PulsarModel) super.a(this.f10703d, 0, PulsarModel.class);
                return this.f10703d;
            }

            public final int jK_() {
                return 1549464029;
            }

            public final GraphQLVisitableModel m11209a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11207a() != null) {
                    PulsarModel pulsarModel = (PulsarModel) graphQLModelMutatingVisitor.b(m11207a());
                    if (m11207a() != pulsarModel) {
                        graphQLVisitableModel = (BestGuessModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10703d = pulsarModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11208a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11207a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10704e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11210a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10704e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: The ViewPager doesnt have an adapter */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PulsarScanQueryModel.class, new Deserializer());
            }

            public Object m11211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PulsarScanQueryParser.m11253a(jsonParser);
                Object pulsarScanQueryModel = new PulsarScanQueryModel();
                ((BaseModel) pulsarScanQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pulsarScanQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pulsarScanQueryModel).a();
                }
                return pulsarScanQueryModel;
            }
        }

        /* compiled from: The ViewPager doesnt have an adapter */
        public class Serializer extends JsonSerializer<PulsarScanQueryModel> {
            public final void m11212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PulsarScanQueryModel pulsarScanQueryModel = (PulsarScanQueryModel) obj;
                if (pulsarScanQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pulsarScanQueryModel.m11217a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pulsarScanQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pulsarScanQueryModel.w_();
                int u_ = pulsarScanQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("best_guess");
                    BestGuessParser.m11252a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("confidence_level");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("gravity_settings");
                    GravitySettingsGraphQlFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("result_code");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PulsarScanQueryModel.class, new Serializer());
            }
        }

        public PulsarScanQueryModel() {
            super(4);
        }

        @Nullable
        private BestGuessModel m11213a() {
            this.f10705d = (BestGuessModel) super.a(this.f10705d, 0, BestGuessModel.class);
            return this.f10705d;
        }

        @Nullable
        private GraphQLBeaconScanResultConfidenceLevel m11214j() {
            this.f10706e = (GraphQLBeaconScanResultConfidenceLevel) super.b(this.f10706e, 1, GraphQLBeaconScanResultConfidenceLevel.class, GraphQLBeaconScanResultConfidenceLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10706e;
        }

        @Nullable
        private GravitySettingsGraphQlFragmentModel m11215k() {
            this.f10707f = (GravitySettingsGraphQlFragmentModel) super.a(this.f10707f, 2, GravitySettingsGraphQlFragmentModel.class);
            return this.f10707f;
        }

        @Nullable
        private GraphQLPulsarScanQueryResultCode m11216l() {
            this.f10708g = (GraphQLPulsarScanQueryResultCode) super.b(this.f10708g, 3, GraphQLPulsarScanQueryResultCode.class, GraphQLPulsarScanQueryResultCode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10708g;
        }

        public final int jK_() {
            return -2117537905;
        }

        public final GraphQLVisitableModel m11218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11213a() != null) {
                BestGuessModel bestGuessModel = (BestGuessModel) graphQLModelMutatingVisitor.b(m11213a());
                if (m11213a() != bestGuessModel) {
                    graphQLVisitableModel = (PulsarScanQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10705d = bestGuessModel;
                }
            }
            if (m11215k() != null) {
                GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m11215k());
                if (m11215k() != gravitySettingsGraphQlFragmentModel) {
                    graphQLVisitableModel = (PulsarScanQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10707f = gravitySettingsGraphQlFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11217a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11213a());
            int a2 = flatBufferBuilder.a(m11214j());
            int a3 = ModelHelper.a(flatBufferBuilder, m11215k());
            int a4 = flatBufferBuilder.a(m11216l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1184110735)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: The ViewPager doesnt have an adapter */
    public final class SimplePulsarScanQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BestGuessModel f10715d;
        @Nullable
        private GraphQLBeaconScanResultConfidenceLevel f10716e;
        @Nullable
        private GravitySettingsGraphQlFragmentModel f10717f;
        @Nullable
        private GraphQLPulsarScanQueryResultCode f10718g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -555421637)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: The ViewPager doesnt have an adapter */
        public final class BestGuessModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PulsarModel f10713d;
            private int f10714e;

            /* compiled from: The ViewPager doesnt have an adapter */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BestGuessModel.class, new Deserializer());
                }

                public Object m11219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SimplePulsarScanQueryParser.BestGuessParser.m11258a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bestGuessModel = new BestGuessModel();
                    ((BaseModel) bestGuessModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bestGuessModel instanceof Postprocessable) {
                        return ((Postprocessable) bestGuessModel).a();
                    }
                    return bestGuessModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -95845354)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: The ViewPager doesnt have an adapter */
            public final class PulsarModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PageModel f10712d;

                /* compiled from: The ViewPager doesnt have an adapter */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PulsarModel.class, new Deserializer());
                    }

                    public Object m11220a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SimplePulsarScanQueryParser.BestGuessParser.PulsarParser.m11256a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pulsarModel = new PulsarModel();
                        ((BaseModel) pulsarModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pulsarModel instanceof Postprocessable) {
                            return ((Postprocessable) pulsarModel).a();
                        }
                        return pulsarModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -729452712)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: The ViewPager doesnt have an adapter */
                public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f10709d;
                    @Nullable
                    private String f10710e;
                    @Nullable
                    private PlaceTipsFeedUnitFragmentModel f10711f;

                    /* compiled from: The ViewPager doesnt have an adapter */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                        }

                        public Object m11221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageParser.m11254a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: The ViewPager doesnt have an adapter */
                    public class Serializer extends JsonSerializer<PageModel> {
                        public final void m11222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageModel pageModel = (PageModel) obj;
                            if (pageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageModel.m11223a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageParser.m11255a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PageModel.class, new Serializer());
                        }
                    }

                    public PageModel() {
                        super(3);
                    }

                    public final void m11226a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m11227a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m11228j() {
                        this.f10709d = super.a(this.f10709d, 0);
                        return this.f10709d;
                    }

                    @Nullable
                    public final String m11229k() {
                        this.f10710e = super.a(this.f10710e, 1);
                        return this.f10710e;
                    }

                    @Nullable
                    public final PlaceTipsFeedUnitFragmentModel m11230l() {
                        this.f10711f = (PlaceTipsFeedUnitFragmentModel) super.a(this.f10711f, 2, PlaceTipsFeedUnitFragmentModel.class);
                        return this.f10711f;
                    }

                    @Nullable
                    public final String m11225a() {
                        return m11228j();
                    }

                    public final int jK_() {
                        return 2479791;
                    }

                    public final GraphQLVisitableModel m11224a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m11230l() != null) {
                            PlaceTipsFeedUnitFragmentModel placeTipsFeedUnitFragmentModel = (PlaceTipsFeedUnitFragmentModel) graphQLModelMutatingVisitor.b(m11230l());
                            if (m11230l() != placeTipsFeedUnitFragmentModel) {
                                graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10711f = placeTipsFeedUnitFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m11223a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11228j());
                        int b2 = flatBufferBuilder.b(m11229k());
                        int a = ModelHelper.a(flatBufferBuilder, m11230l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: The ViewPager doesnt have an adapter */
                public class Serializer extends JsonSerializer<PulsarModel> {
                    public final void m11231a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PulsarModel pulsarModel = (PulsarModel) obj;
                        if (pulsarModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pulsarModel.m11232a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pulsarModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SimplePulsarScanQueryParser.BestGuessParser.PulsarParser.m11257a(pulsarModel.w_(), pulsarModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PulsarModel.class, new Serializer());
                    }
                }

                public PulsarModel() {
                    super(1);
                }

                @Nullable
                public final PageModel m11234a() {
                    this.f10712d = (PageModel) super.a(this.f10712d, 0, PageModel.class);
                    return this.f10712d;
                }

                public final int jK_() {
                    return -1893252195;
                }

                public final GraphQLVisitableModel m11233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11234a() != null) {
                        PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m11234a());
                        if (m11234a() != pageModel) {
                            graphQLVisitableModel = (PulsarModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10712d = pageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11232a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11234a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: The ViewPager doesnt have an adapter */
            public class Serializer extends JsonSerializer<BestGuessModel> {
                public final void m11235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BestGuessModel bestGuessModel = (BestGuessModel) obj;
                    if (bestGuessModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bestGuessModel.m11236a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bestGuessModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SimplePulsarScanQueryParser.BestGuessParser.m11259a(bestGuessModel.w_(), bestGuessModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BestGuessModel.class, new Serializer());
                }
            }

            public BestGuessModel() {
                super(2);
            }

            @Nullable
            public final PulsarModel m11238a() {
                this.f10713d = (PulsarModel) super.a(this.f10713d, 0, PulsarModel.class);
                return this.f10713d;
            }

            public final int m11240j() {
                a(0, 1);
                return this.f10714e;
            }

            public final int jK_() {
                return 1549464029;
            }

            public final GraphQLVisitableModel m11237a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11238a() != null) {
                    PulsarModel pulsarModel = (PulsarModel) graphQLModelMutatingVisitor.b(m11238a());
                    if (m11238a() != pulsarModel) {
                        graphQLVisitableModel = (BestGuessModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10713d = pulsarModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11236a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11238a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10714e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11239a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10714e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: The ViewPager doesnt have an adapter */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SimplePulsarScanQueryModel.class, new Deserializer());
            }

            public Object m11241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SimplePulsarScanQueryParser.m11260a(jsonParser);
                Object simplePulsarScanQueryModel = new SimplePulsarScanQueryModel();
                ((BaseModel) simplePulsarScanQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (simplePulsarScanQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) simplePulsarScanQueryModel).a();
                }
                return simplePulsarScanQueryModel;
            }
        }

        /* compiled from: The ViewPager doesnt have an adapter */
        public class Serializer extends JsonSerializer<SimplePulsarScanQueryModel> {
            public final void m11242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SimplePulsarScanQueryModel simplePulsarScanQueryModel = (SimplePulsarScanQueryModel) obj;
                if (simplePulsarScanQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(simplePulsarScanQueryModel.m11243a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    simplePulsarScanQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = simplePulsarScanQueryModel.w_();
                int u_ = simplePulsarScanQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("best_guess");
                    SimplePulsarScanQueryParser.BestGuessParser.m11259a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("confidence_level");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("gravity_settings");
                    GravitySettingsGraphQlFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("result_code");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SimplePulsarScanQueryModel.class, new Serializer());
            }
        }

        public SimplePulsarScanQueryModel() {
            super(4);
        }

        @Nullable
        public final BestGuessModel m11245a() {
            this.f10715d = (BestGuessModel) super.a(this.f10715d, 0, BestGuessModel.class);
            return this.f10715d;
        }

        @Nullable
        public final GraphQLBeaconScanResultConfidenceLevel m11246j() {
            this.f10716e = (GraphQLBeaconScanResultConfidenceLevel) super.b(this.f10716e, 1, GraphQLBeaconScanResultConfidenceLevel.class, GraphQLBeaconScanResultConfidenceLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10716e;
        }

        @Nullable
        public final GravitySettingsGraphQlFragmentModel m11247k() {
            this.f10717f = (GravitySettingsGraphQlFragmentModel) super.a(this.f10717f, 2, GravitySettingsGraphQlFragmentModel.class);
            return this.f10717f;
        }

        @Nullable
        public final GraphQLPulsarScanQueryResultCode m11248l() {
            this.f10718g = (GraphQLPulsarScanQueryResultCode) super.b(this.f10718g, 3, GraphQLPulsarScanQueryResultCode.class, GraphQLPulsarScanQueryResultCode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10718g;
        }

        public final int jK_() {
            return -2117537905;
        }

        public final GraphQLVisitableModel m11244a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11245a() != null) {
                BestGuessModel bestGuessModel = (BestGuessModel) graphQLModelMutatingVisitor.b(m11245a());
                if (m11245a() != bestGuessModel) {
                    graphQLVisitableModel = (SimplePulsarScanQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10715d = bestGuessModel;
                }
            }
            if (m11247k() != null) {
                GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m11247k());
                if (m11247k() != gravitySettingsGraphQlFragmentModel) {
                    graphQLVisitableModel = (SimplePulsarScanQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10717f = gravitySettingsGraphQlFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11243a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11245a());
            int a2 = flatBufferBuilder.a(m11246j());
            int a3 = ModelHelper.a(flatBufferBuilder, m11247k());
            int a4 = flatBufferBuilder.a(m11248l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
