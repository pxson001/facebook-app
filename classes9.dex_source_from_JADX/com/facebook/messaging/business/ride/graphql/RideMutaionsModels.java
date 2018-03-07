package com.facebook.messaging.business.ride.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLRideRequestOutcome;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideCancelMutationParser;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideRequestMutationParser;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideRequestMutationParser.RideRequestParser;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideRequestMutationParser.SurgeEstimateParser;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideSendGiveGetPromoMutationParser;
import com.facebook.messaging.business.ride.graphql.RideMutaionsParsers.RideSignupMessageMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: more */
public class RideMutaionsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 582881409)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: more */
    public final class RideCancelMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9057d;
        @Nullable
        private GraphQLRideRequestOutcome f9058e;

        /* compiled from: more */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RideCancelMutationModel.class, new Deserializer());
            }

            public Object m9373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RideCancelMutationParser.m9413a(jsonParser);
                Object rideCancelMutationModel = new RideCancelMutationModel();
                ((BaseModel) rideCancelMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rideCancelMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rideCancelMutationModel).a();
                }
                return rideCancelMutationModel;
            }
        }

        /* compiled from: more */
        public class Serializer extends JsonSerializer<RideCancelMutationModel> {
            public final void m9374a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RideCancelMutationModel rideCancelMutationModel = (RideCancelMutationModel) obj;
                if (rideCancelMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rideCancelMutationModel.m9375a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rideCancelMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rideCancelMutationModel.w_();
                int u_ = rideCancelMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("error_message");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("result");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RideCancelMutationModel.class, new Serializer());
            }
        }

        public RideCancelMutationModel() {
            super(2);
        }

        @Nullable
        public final String m9377a() {
            this.f9057d = super.a(this.f9057d, 0);
            return this.f9057d;
        }

        @Nullable
        public final GraphQLRideRequestOutcome m9378j() {
            this.f9058e = (GraphQLRideRequestOutcome) super.b(this.f9058e, 1, GraphQLRideRequestOutcome.class, GraphQLRideRequestOutcome.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9058e;
        }

        public final int jK_() {
            return -339353093;
        }

        public final GraphQLVisitableModel m9376a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9375a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9377a());
            int a = flatBufferBuilder.a(m9378j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1288271141)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: more */
    public final class RideRequestMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9066d;
        @Nullable
        private GraphQLRideRequestOutcome f9067e;
        @Nullable
        private RideRequestModel f9068f;
        @Nullable
        private SurgeEstimateModel f9069g;

        /* compiled from: more */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RideRequestMutationModel.class, new Deserializer());
            }

            public Object m9379a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RideRequestMutationParser.m9418a(jsonParser);
                Object rideRequestMutationModel = new RideRequestMutationModel();
                ((BaseModel) rideRequestMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rideRequestMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rideRequestMutationModel).a();
                }
                return rideRequestMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1807925239)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: more */
        public final class RideRequestModel extends BaseModel implements GraphQLVisitableModel {
            private int f9059d;
            @Nullable
            private String f9060e;
            @Nullable
            private String f9061f;

            /* compiled from: more */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RideRequestModel.class, new Deserializer());
                }

                public Object m9380a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RideRequestParser.m9414a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rideRequestModel = new RideRequestModel();
                    ((BaseModel) rideRequestModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rideRequestModel instanceof Postprocessable) {
                        return ((Postprocessable) rideRequestModel).a();
                    }
                    return rideRequestModel;
                }
            }

            /* compiled from: more */
            public class Serializer extends JsonSerializer<RideRequestModel> {
                public final void m9381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RideRequestModel rideRequestModel = (RideRequestModel) obj;
                    if (rideRequestModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rideRequestModel.m9384a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rideRequestModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RideRequestParser.m9415a(rideRequestModel.w_(), rideRequestModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RideRequestModel.class, new Serializer());
                }
            }

            public RideRequestModel() {
                super(3);
            }

            @Nullable
            private String m9382a() {
                this.f9060e = super.a(this.f9060e, 1);
                return this.f9060e;
            }

            @Nullable
            private String m9383j() {
                this.f9061f = super.a(this.f9061f, 2);
                return this.f9061f;
            }

            public final int jK_() {
                return 1853506135;
            }

            public final GraphQLVisitableModel m9385a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9384a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9382a());
                int b2 = flatBufferBuilder.b(m9383j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f9059d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9386a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9059d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: more */
        public class Serializer extends JsonSerializer<RideRequestMutationModel> {
            public final void m9387a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RideRequestMutationModel rideRequestMutationModel = (RideRequestMutationModel) obj;
                if (rideRequestMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rideRequestMutationModel.m9397a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rideRequestMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rideRequestMutationModel.w_();
                int u_ = rideRequestMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("error_message");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("result");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("ride_request");
                    RideRequestParser.m9415a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("surge_estimate");
                    SurgeEstimateParser.m9417a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RideRequestMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1359758927)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: more */
        public final class SurgeEstimateModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9062d;
            @Nullable
            private String f9063e;
            private double f9064f;
            private double f9065g;

            /* compiled from: more */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SurgeEstimateModel.class, new Deserializer());
                }

                public Object m9388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SurgeEstimateParser.m9416a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object surgeEstimateModel = new SurgeEstimateModel();
                    ((BaseModel) surgeEstimateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (surgeEstimateModel instanceof Postprocessable) {
                        return ((Postprocessable) surgeEstimateModel).a();
                    }
                    return surgeEstimateModel;
                }
            }

            /* compiled from: more */
            public class Serializer extends JsonSerializer<SurgeEstimateModel> {
                public final void m9389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SurgeEstimateModel surgeEstimateModel = (SurgeEstimateModel) obj;
                    if (surgeEstimateModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(surgeEstimateModel.m9390a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        surgeEstimateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SurgeEstimateParser.m9417a(surgeEstimateModel.w_(), surgeEstimateModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SurgeEstimateModel.class, new Serializer());
                }
            }

            public SurgeEstimateModel() {
                super(4);
            }

            @Nullable
            public final String m9392a() {
                this.f9062d = super.a(this.f9062d, 0);
                return this.f9062d;
            }

            @Nullable
            public final String m9394j() {
                this.f9063e = super.a(this.f9063e, 1);
                return this.f9063e;
            }

            public final double m9395k() {
                a(0, 2);
                return this.f9064f;
            }

            public final double m9396l() {
                a(0, 3);
                return this.f9065g;
            }

            public final int jK_() {
                return 57593440;
            }

            public final GraphQLVisitableModel m9391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9390a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9392a());
                int b2 = flatBufferBuilder.b(m9394j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.a(2, this.f9064f, 0.0d);
                flatBufferBuilder.a(3, this.f9065g, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9393a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9064f = mutableFlatBuffer.a(i, 2, 0.0d);
                this.f9065g = mutableFlatBuffer.a(i, 3, 0.0d);
            }
        }

        public RideRequestMutationModel() {
            super(4);
        }

        @Nullable
        public final String m9399a() {
            this.f9066d = super.a(this.f9066d, 0);
            return this.f9066d;
        }

        @Nullable
        public final GraphQLRideRequestOutcome m9400j() {
            this.f9067e = (GraphQLRideRequestOutcome) super.b(this.f9067e, 1, GraphQLRideRequestOutcome.class, GraphQLRideRequestOutcome.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9067e;
        }

        @Nullable
        public final RideRequestModel m9401k() {
            this.f9068f = (RideRequestModel) super.a(this.f9068f, 2, RideRequestModel.class);
            return this.f9068f;
        }

        @Nullable
        public final SurgeEstimateModel m9402l() {
            this.f9069g = (SurgeEstimateModel) super.a(this.f9069g, 3, SurgeEstimateModel.class);
            return this.f9069g;
        }

        public final int jK_() {
            return -915307686;
        }

        public final GraphQLVisitableModel m9398a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9401k() != null) {
                RideRequestModel rideRequestModel = (RideRequestModel) graphQLModelMutatingVisitor.b(m9401k());
                if (m9401k() != rideRequestModel) {
                    graphQLVisitableModel = (RideRequestMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9068f = rideRequestModel;
                }
            }
            if (m9402l() != null) {
                SurgeEstimateModel surgeEstimateModel = (SurgeEstimateModel) graphQLModelMutatingVisitor.b(m9402l());
                if (m9402l() != surgeEstimateModel) {
                    graphQLVisitableModel = (RideRequestMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9069g = surgeEstimateModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9397a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9399a());
            int a = flatBufferBuilder.a(m9400j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9401k());
            int a3 = ModelHelper.a(flatBufferBuilder, m9402l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: more */
    public final class RideSendGiveGetPromoMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9070d;

        /* compiled from: more */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RideSendGiveGetPromoMutationModel.class, new Deserializer());
            }

            public Object m9403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RideSendGiveGetPromoMutationParser.m9419a(jsonParser);
                Object rideSendGiveGetPromoMutationModel = new RideSendGiveGetPromoMutationModel();
                ((BaseModel) rideSendGiveGetPromoMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rideSendGiveGetPromoMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rideSendGiveGetPromoMutationModel).a();
                }
                return rideSendGiveGetPromoMutationModel;
            }
        }

        /* compiled from: more */
        public class Serializer extends JsonSerializer<RideSendGiveGetPromoMutationModel> {
            public final void m9404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RideSendGiveGetPromoMutationModel rideSendGiveGetPromoMutationModel = (RideSendGiveGetPromoMutationModel) obj;
                if (rideSendGiveGetPromoMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rideSendGiveGetPromoMutationModel.m9406a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rideSendGiveGetPromoMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rideSendGiveGetPromoMutationModel.w_();
                int u_ = rideSendGiveGetPromoMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RideSendGiveGetPromoMutationModel.class, new Serializer());
            }
        }

        public RideSendGiveGetPromoMutationModel() {
            super(1);
        }

        @Nullable
        private String m9405a() {
            this.f9070d = super.a(this.f9070d, 0);
            return this.f9070d;
        }

        public final int jK_() {
            return -1391009671;
        }

        public final GraphQLVisitableModel m9407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9406a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9405a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: more */
    public final class RideSignupMessageMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9071d;

        /* compiled from: more */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RideSignupMessageMutationModel.class, new Deserializer());
            }

            public Object m9408a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RideSignupMessageMutationParser.m9420a(jsonParser);
                Object rideSignupMessageMutationModel = new RideSignupMessageMutationModel();
                ((BaseModel) rideSignupMessageMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rideSignupMessageMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rideSignupMessageMutationModel).a();
                }
                return rideSignupMessageMutationModel;
            }
        }

        /* compiled from: more */
        public class Serializer extends JsonSerializer<RideSignupMessageMutationModel> {
            public final void m9409a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RideSignupMessageMutationModel rideSignupMessageMutationModel = (RideSignupMessageMutationModel) obj;
                if (rideSignupMessageMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rideSignupMessageMutationModel.m9411a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rideSignupMessageMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rideSignupMessageMutationModel.w_();
                int u_ = rideSignupMessageMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RideSignupMessageMutationModel.class, new Serializer());
            }
        }

        public RideSignupMessageMutationModel() {
            super(1);
        }

        @Nullable
        private String m9410a() {
            this.f9071d = super.a(this.f9071d, 0);
            return this.f9071d;
        }

        public final int jK_() {
            return 1251533406;
        }

        public final GraphQLVisitableModel m9412a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9411a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9410a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
