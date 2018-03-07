package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser.CrowdsourcingPlaceQuestionValueParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser.PlaceQuestionAnswersParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser.PlaceQuestionAnswersParser.PlaceQuestionAnswerLabelParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser.PlaceQuestionSubtextParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionFragmentParser.PlaceQuestionTextParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionsQueryParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionsQueryParser.CrowdsourcingPlaceQuestionsDataParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionsQueryParser.CrowdsourcingPlaceQuestionsDataParser.PlaceQuestionsParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesParsers.FBCrowdsourcingPlaceQuestionsQueryParser.CrowdsourcingPlaceQuestionsDataParser.PlaceQuestionsParser.EdgesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: tap_check_in_button */
public class CrowdsourcingPlaceQuestionQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1702892175)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_check_in_button */
    public final class FBCrowdsourcingPlaceQuestionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CrowdsourcingPlaceQuestionValueModel f2319d;
        @Nullable
        private String f2320e;
        @Nullable
        private List<PlaceQuestionAnswersModel> f2321f;
        @Nullable
        private PlaceQuestionSubtextModel f2322g;
        @Nullable
        private PlaceQuestionTextModel f2323h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2040128980)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tap_check_in_button */
        public final class CrowdsourcingPlaceQuestionValueModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f2312d;
            @Nullable
            private String f2313e;

            /* compiled from: tap_check_in_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CrowdsourcingPlaceQuestionValueModel.class, new Deserializer());
                }

                public Object m2266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CrowdsourcingPlaceQuestionValueParser.m2333a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object crowdsourcingPlaceQuestionValueModel = new CrowdsourcingPlaceQuestionValueModel();
                    ((BaseModel) crowdsourcingPlaceQuestionValueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (crowdsourcingPlaceQuestionValueModel instanceof Postprocessable) {
                        return ((Postprocessable) crowdsourcingPlaceQuestionValueModel).a();
                    }
                    return crowdsourcingPlaceQuestionValueModel;
                }
            }

            /* compiled from: tap_check_in_button */
            public class Serializer extends JsonSerializer<CrowdsourcingPlaceQuestionValueModel> {
                public final void m2267a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CrowdsourcingPlaceQuestionValueModel crowdsourcingPlaceQuestionValueModel = (CrowdsourcingPlaceQuestionValueModel) obj;
                    if (crowdsourcingPlaceQuestionValueModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(crowdsourcingPlaceQuestionValueModel.m2269a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        crowdsourcingPlaceQuestionValueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CrowdsourcingPlaceQuestionValueParser.m2334a(crowdsourcingPlaceQuestionValueModel.w_(), crowdsourcingPlaceQuestionValueModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CrowdsourcingPlaceQuestionValueModel.class, new Serializer());
                }
            }

            public CrowdsourcingPlaceQuestionValueModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m2268j() {
                if (this.b != null && this.f2312d == null) {
                    this.f2312d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f2312d;
            }

            @Nullable
            public final String m2271a() {
                this.f2313e = super.a(this.f2313e, 1);
                return this.f2313e;
            }

            public final int jK_() {
                return -1148314748;
            }

            public final GraphQLVisitableModel m2270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2269a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2268j());
                int b = flatBufferBuilder.b(m2271a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tap_check_in_button */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBCrowdsourcingPlaceQuestionFragmentModel.class, new Deserializer());
            }

            public Object m2272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBCrowdsourcingPlaceQuestionFragmentParser.m2343a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBCrowdsourcingPlaceQuestionFragmentModel = new FBCrowdsourcingPlaceQuestionFragmentModel();
                ((BaseModel) fBCrowdsourcingPlaceQuestionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBCrowdsourcingPlaceQuestionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBCrowdsourcingPlaceQuestionFragmentModel).a();
                }
                return fBCrowdsourcingPlaceQuestionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -461077623)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tap_check_in_button */
        public final class PlaceQuestionAnswersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PlaceQuestionAnswerLabelModel f2315d;
            @Nullable
            private String f2316e;

            /* compiled from: tap_check_in_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionAnswersModel.class, new Deserializer());
                }

                public Object m2273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionAnswersParser.m2337b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionAnswersModel = new PlaceQuestionAnswersModel();
                    ((BaseModel) placeQuestionAnswersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionAnswersModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionAnswersModel).a();
                    }
                    return placeQuestionAnswersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tap_check_in_button */
            public final class PlaceQuestionAnswerLabelModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2314d;

                /* compiled from: tap_check_in_button */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PlaceQuestionAnswerLabelModel.class, new Deserializer());
                    }

                    public Object m2274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PlaceQuestionAnswerLabelParser.m2335a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object placeQuestionAnswerLabelModel = new PlaceQuestionAnswerLabelModel();
                        ((BaseModel) placeQuestionAnswerLabelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (placeQuestionAnswerLabelModel instanceof Postprocessable) {
                            return ((Postprocessable) placeQuestionAnswerLabelModel).a();
                        }
                        return placeQuestionAnswerLabelModel;
                    }
                }

                /* compiled from: tap_check_in_button */
                public class Serializer extends JsonSerializer<PlaceQuestionAnswerLabelModel> {
                    public final void m2275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PlaceQuestionAnswerLabelModel placeQuestionAnswerLabelModel = (PlaceQuestionAnswerLabelModel) obj;
                        if (placeQuestionAnswerLabelModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(placeQuestionAnswerLabelModel.m2276a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            placeQuestionAnswerLabelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PlaceQuestionAnswerLabelParser.m2336a(placeQuestionAnswerLabelModel.w_(), placeQuestionAnswerLabelModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PlaceQuestionAnswerLabelModel.class, new Serializer());
                    }
                }

                public PlaceQuestionAnswerLabelModel() {
                    super(1);
                }

                @Nullable
                public final String m2278a() {
                    this.f2314d = super.a(this.f2314d, 0);
                    return this.f2314d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2276a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2278a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tap_check_in_button */
            public class Serializer extends JsonSerializer<PlaceQuestionAnswersModel> {
                public final void m2279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionAnswersModel placeQuestionAnswersModel = (PlaceQuestionAnswersModel) obj;
                    if (placeQuestionAnswersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionAnswersModel.m2281a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionAnswersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionAnswersParser.m2338b(placeQuestionAnswersModel.w_(), placeQuestionAnswersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionAnswersModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PlaceQuestionAnswerLabelModel m2282a() {
                return m2280j();
            }

            public PlaceQuestionAnswersModel() {
                super(2);
            }

            @Nullable
            private PlaceQuestionAnswerLabelModel m2280j() {
                this.f2315d = (PlaceQuestionAnswerLabelModel) super.a(this.f2315d, 0, PlaceQuestionAnswerLabelModel.class);
                return this.f2315d;
            }

            @Nullable
            public final String m2284b() {
                this.f2316e = super.a(this.f2316e, 1);
                return this.f2316e;
            }

            public final int jK_() {
                return -1827014645;
            }

            public final GraphQLVisitableModel m2283a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2280j() != null) {
                    PlaceQuestionAnswerLabelModel placeQuestionAnswerLabelModel = (PlaceQuestionAnswerLabelModel) graphQLModelMutatingVisitor.b(m2280j());
                    if (m2280j() != placeQuestionAnswerLabelModel) {
                        graphQLVisitableModel = (PlaceQuestionAnswersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2315d = placeQuestionAnswerLabelModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2281a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2280j());
                int b = flatBufferBuilder.b(m2284b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tap_check_in_button */
        public final class PlaceQuestionSubtextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2317d;

            /* compiled from: tap_check_in_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionSubtextModel.class, new Deserializer());
                }

                public Object m2285a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionSubtextParser.m2339a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionSubtextModel = new PlaceQuestionSubtextModel();
                    ((BaseModel) placeQuestionSubtextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionSubtextModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionSubtextModel).a();
                    }
                    return placeQuestionSubtextModel;
                }
            }

            /* compiled from: tap_check_in_button */
            public class Serializer extends JsonSerializer<PlaceQuestionSubtextModel> {
                public final void m2286a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionSubtextModel placeQuestionSubtextModel = (PlaceQuestionSubtextModel) obj;
                    if (placeQuestionSubtextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionSubtextModel.m2287a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionSubtextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionSubtextParser.m2340a(placeQuestionSubtextModel.w_(), placeQuestionSubtextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionSubtextModel.class, new Serializer());
                }
            }

            public PlaceQuestionSubtextModel() {
                super(1);
            }

            @Nullable
            public final String m2289a() {
                this.f2317d = super.a(this.f2317d, 0);
                return this.f2317d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m2288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2287a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2289a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tap_check_in_button */
        public final class PlaceQuestionTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2318d;

            /* compiled from: tap_check_in_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionTextModel.class, new Deserializer());
                }

                public Object m2290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionTextParser.m2341a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionTextModel = new PlaceQuestionTextModel();
                    ((BaseModel) placeQuestionTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionTextModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionTextModel).a();
                    }
                    return placeQuestionTextModel;
                }
            }

            /* compiled from: tap_check_in_button */
            public class Serializer extends JsonSerializer<PlaceQuestionTextModel> {
                public final void m2291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionTextModel placeQuestionTextModel = (PlaceQuestionTextModel) obj;
                    if (placeQuestionTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionTextModel.m2292a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionTextParser.m2342a(placeQuestionTextModel.w_(), placeQuestionTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionTextModel.class, new Serializer());
                }
            }

            public PlaceQuestionTextModel() {
                super(1);
            }

            @Nullable
            public final String m2294a() {
                this.f2318d = super.a(this.f2318d, 0);
                return this.f2318d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m2293a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2292a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2294a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tap_check_in_button */
        public class Serializer extends JsonSerializer<FBCrowdsourcingPlaceQuestionFragmentModel> {
            public final void m2295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBCrowdsourcingPlaceQuestionFragmentModel fBCrowdsourcingPlaceQuestionFragmentModel = (FBCrowdsourcingPlaceQuestionFragmentModel) obj;
                if (fBCrowdsourcingPlaceQuestionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBCrowdsourcingPlaceQuestionFragmentModel.m2299a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBCrowdsourcingPlaceQuestionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBCrowdsourcingPlaceQuestionFragmentParser.m2344a(fBCrowdsourcingPlaceQuestionFragmentModel.w_(), fBCrowdsourcingPlaceQuestionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBCrowdsourcingPlaceQuestionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CrowdsourcingPlaceQuestionValueModel m2302b() {
            return m2296j();
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionSubtextModel eo_() {
            return m2297k();
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionTextModel m2305g() {
            return m2298l();
        }

        public FBCrowdsourcingPlaceQuestionFragmentModel() {
            super(5);
        }

        @Nullable
        private CrowdsourcingPlaceQuestionValueModel m2296j() {
            this.f2319d = (CrowdsourcingPlaceQuestionValueModel) super.a(this.f2319d, 0, CrowdsourcingPlaceQuestionValueModel.class);
            return this.f2319d;
        }

        @Nullable
        public final String m2303c() {
            this.f2320e = super.a(this.f2320e, 1);
            return this.f2320e;
        }

        @Nonnull
        public final ImmutableList<PlaceQuestionAnswersModel> m2304d() {
            this.f2321f = super.a(this.f2321f, 2, PlaceQuestionAnswersModel.class);
            return (ImmutableList) this.f2321f;
        }

        @Nullable
        private PlaceQuestionSubtextModel m2297k() {
            this.f2322g = (PlaceQuestionSubtextModel) super.a(this.f2322g, 3, PlaceQuestionSubtextModel.class);
            return this.f2322g;
        }

        @Nullable
        private PlaceQuestionTextModel m2298l() {
            this.f2323h = (PlaceQuestionTextModel) super.a(this.f2323h, 4, PlaceQuestionTextModel.class);
            return this.f2323h;
        }

        @Nullable
        public final String m2301a() {
            return m2303c();
        }

        public final int jK_() {
            return 1651118184;
        }

        public final GraphQLVisitableModel m2300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2296j() != null) {
                CrowdsourcingPlaceQuestionValueModel crowdsourcingPlaceQuestionValueModel = (CrowdsourcingPlaceQuestionValueModel) graphQLModelMutatingVisitor.b(m2296j());
                if (m2296j() != crowdsourcingPlaceQuestionValueModel) {
                    graphQLVisitableModel = (FBCrowdsourcingPlaceQuestionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2319d = crowdsourcingPlaceQuestionValueModel;
                }
            }
            if (m2304d() != null) {
                Builder a = ModelHelper.a(m2304d(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FBCrowdsourcingPlaceQuestionFragmentModel fBCrowdsourcingPlaceQuestionFragmentModel = (FBCrowdsourcingPlaceQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    fBCrowdsourcingPlaceQuestionFragmentModel.f2321f = a.b();
                    graphQLVisitableModel = fBCrowdsourcingPlaceQuestionFragmentModel;
                }
            }
            if (m2297k() != null) {
                PlaceQuestionSubtextModel placeQuestionSubtextModel = (PlaceQuestionSubtextModel) graphQLModelMutatingVisitor.b(m2297k());
                if (m2297k() != placeQuestionSubtextModel) {
                    graphQLVisitableModel = (FBCrowdsourcingPlaceQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2322g = placeQuestionSubtextModel;
                }
            }
            if (m2298l() != null) {
                PlaceQuestionTextModel placeQuestionTextModel = (PlaceQuestionTextModel) graphQLModelMutatingVisitor.b(m2298l());
                if (m2298l() != placeQuestionTextModel) {
                    graphQLVisitableModel = (FBCrowdsourcingPlaceQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2323h = placeQuestionTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2299a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2296j());
            int b = flatBufferBuilder.b(m2303c());
            int a2 = ModelHelper.a(flatBufferBuilder, m2304d());
            int a3 = ModelHelper.a(flatBufferBuilder, m2297k());
            int a4 = ModelHelper.a(flatBufferBuilder, m2298l());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1070627488)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_check_in_button */
    public final class FBCrowdsourcingPlaceQuestionsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private CrowdsourcingPlaceQuestionsDataModel f2327d;
        @Nullable
        private String f2328e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1780217192)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tap_check_in_button */
        public final class CrowdsourcingPlaceQuestionsDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PlaceQuestionsModel f2326d;

            /* compiled from: tap_check_in_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CrowdsourcingPlaceQuestionsDataModel.class, new Deserializer());
                }

                public Object m2306a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CrowdsourcingPlaceQuestionsDataParser.m2349a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object crowdsourcingPlaceQuestionsDataModel = new CrowdsourcingPlaceQuestionsDataModel();
                    ((BaseModel) crowdsourcingPlaceQuestionsDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (crowdsourcingPlaceQuestionsDataModel instanceof Postprocessable) {
                        return ((Postprocessable) crowdsourcingPlaceQuestionsDataModel).a();
                    }
                    return crowdsourcingPlaceQuestionsDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415412708)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tap_check_in_button */
            public final class PlaceQuestionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f2325d;

                /* compiled from: tap_check_in_button */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PlaceQuestionsModel.class, new Deserializer());
                    }

                    public Object m2307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PlaceQuestionsParser.m2347a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object placeQuestionsModel = new PlaceQuestionsModel();
                        ((BaseModel) placeQuestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (placeQuestionsModel instanceof Postprocessable) {
                            return ((Postprocessable) placeQuestionsModel).a();
                        }
                        return placeQuestionsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -153492929)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: tap_check_in_button */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private FBCrowdsourcingPlaceQuestionFragmentModel f2324d;

                    /* compiled from: tap_check_in_button */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m2308a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m2345b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: tap_check_in_button */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m2309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m2311a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m2346b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ FBCrowdsourcingPlaceQuestionFragmentModel m2312a() {
                        return m2310j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private FBCrowdsourcingPlaceQuestionFragmentModel m2310j() {
                        this.f2324d = (FBCrowdsourcingPlaceQuestionFragmentModel) super.a(this.f2324d, 0, FBCrowdsourcingPlaceQuestionFragmentModel.class);
                        return this.f2324d;
                    }

                    public final int jK_() {
                        return -1790090904;
                    }

                    public final GraphQLVisitableModel m2313a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2310j() != null) {
                            FBCrowdsourcingPlaceQuestionFragmentModel fBCrowdsourcingPlaceQuestionFragmentModel = (FBCrowdsourcingPlaceQuestionFragmentModel) graphQLModelMutatingVisitor.b(m2310j());
                            if (m2310j() != fBCrowdsourcingPlaceQuestionFragmentModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f2324d = fBCrowdsourcingPlaceQuestionFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2311a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2310j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: tap_check_in_button */
                public class Serializer extends JsonSerializer<PlaceQuestionsModel> {
                    public final void m2314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PlaceQuestionsModel placeQuestionsModel = (PlaceQuestionsModel) obj;
                        if (placeQuestionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(placeQuestionsModel.m2315a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            placeQuestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PlaceQuestionsParser.m2348a(placeQuestionsModel.w_(), placeQuestionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PlaceQuestionsModel.class, new Serializer());
                    }
                }

                public PlaceQuestionsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m2317a() {
                    this.f2325d = super.a(this.f2325d, 0, EdgesModel.class);
                    return (ImmutableList) this.f2325d;
                }

                public final int jK_() {
                    return 1026147913;
                }

                public final GraphQLVisitableModel m2316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2317a() != null) {
                        Builder a = ModelHelper.a(m2317a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PlaceQuestionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2325d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2315a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2317a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tap_check_in_button */
            public class Serializer extends JsonSerializer<CrowdsourcingPlaceQuestionsDataModel> {
                public final void m2318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CrowdsourcingPlaceQuestionsDataModel crowdsourcingPlaceQuestionsDataModel = (CrowdsourcingPlaceQuestionsDataModel) obj;
                    if (crowdsourcingPlaceQuestionsDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(crowdsourcingPlaceQuestionsDataModel.m2320a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        crowdsourcingPlaceQuestionsDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CrowdsourcingPlaceQuestionsDataParser.m2350a(crowdsourcingPlaceQuestionsDataModel.w_(), crowdsourcingPlaceQuestionsDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CrowdsourcingPlaceQuestionsDataModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PlaceQuestionsModel m2321a() {
                return m2319j();
            }

            public CrowdsourcingPlaceQuestionsDataModel() {
                super(1);
            }

            @Nullable
            private PlaceQuestionsModel m2319j() {
                this.f2326d = (PlaceQuestionsModel) super.a(this.f2326d, 0, PlaceQuestionsModel.class);
                return this.f2326d;
            }

            public final int jK_() {
                return -1790123179;
            }

            public final GraphQLVisitableModel m2322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2319j() != null) {
                    PlaceQuestionsModel placeQuestionsModel = (PlaceQuestionsModel) graphQLModelMutatingVisitor.b(m2319j());
                    if (m2319j() != placeQuestionsModel) {
                        graphQLVisitableModel = (CrowdsourcingPlaceQuestionsDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2326d = placeQuestionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2320a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2319j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tap_check_in_button */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBCrowdsourcingPlaceQuestionsQueryModel.class, new Deserializer());
            }

            public Object m2323a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBCrowdsourcingPlaceQuestionsQueryParser.m2351a(jsonParser);
                Object fBCrowdsourcingPlaceQuestionsQueryModel = new FBCrowdsourcingPlaceQuestionsQueryModel();
                ((BaseModel) fBCrowdsourcingPlaceQuestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBCrowdsourcingPlaceQuestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBCrowdsourcingPlaceQuestionsQueryModel).a();
                }
                return fBCrowdsourcingPlaceQuestionsQueryModel;
            }
        }

        /* compiled from: tap_check_in_button */
        public class Serializer extends JsonSerializer<FBCrowdsourcingPlaceQuestionsQueryModel> {
            public final void m2324a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBCrowdsourcingPlaceQuestionsQueryModel fBCrowdsourcingPlaceQuestionsQueryModel = (FBCrowdsourcingPlaceQuestionsQueryModel) obj;
                if (fBCrowdsourcingPlaceQuestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBCrowdsourcingPlaceQuestionsQueryModel.m2327a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBCrowdsourcingPlaceQuestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBCrowdsourcingPlaceQuestionsQueryModel.w_();
                int u_ = fBCrowdsourcingPlaceQuestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("crowdsourcing_place_questions_data");
                    CrowdsourcingPlaceQuestionsDataParser.m2350a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBCrowdsourcingPlaceQuestionsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CrowdsourcingPlaceQuestionsDataModel m2332b() {
            return m2325j();
        }

        public FBCrowdsourcingPlaceQuestionsQueryModel() {
            super(2);
        }

        public final void m2330a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2331a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CrowdsourcingPlaceQuestionsDataModel m2325j() {
            this.f2327d = (CrowdsourcingPlaceQuestionsDataModel) super.a(this.f2327d, 0, CrowdsourcingPlaceQuestionsDataModel.class);
            return this.f2327d;
        }

        @Nullable
        private String m2326k() {
            this.f2328e = super.a(this.f2328e, 1);
            return this.f2328e;
        }

        @Nullable
        public final String m2329a() {
            return m2326k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2325j() != null) {
                CrowdsourcingPlaceQuestionsDataModel crowdsourcingPlaceQuestionsDataModel = (CrowdsourcingPlaceQuestionsDataModel) graphQLModelMutatingVisitor.b(m2325j());
                if (m2325j() != crowdsourcingPlaceQuestionsDataModel) {
                    graphQLVisitableModel = (FBCrowdsourcingPlaceQuestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2327d = crowdsourcingPlaceQuestionsDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2327a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2325j());
            int b = flatBufferBuilder.b(m2326k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
