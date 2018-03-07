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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsInterfaces.BusinessRideReceiptFragment;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsParsers.BusinessRideLocationParser;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsParsers.BusinessRideReceiptFragmentParser;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsParsers.BusinessRideReceiptFragmentParser.RideProviderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: verificationStatus */
public class RideThreadFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 918622653)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: verificationStatus */
    public final class BusinessRideLocationModel extends BaseModel implements GraphQLVisitableModel {
        private double f1843d;
        private double f1844e;

        /* compiled from: verificationStatus */
        public final class Builder {
            public double f1841a;
            public double f1842b;

            public final BusinessRideLocationModel m3216a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1841a, 0.0d);
                flatBufferBuilder.a(1, this.f1842b, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new BusinessRideLocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: verificationStatus */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessRideLocationModel.class, new Deserializer());
            }

            public Object m3217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BusinessRideLocationParser.m3245a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object businessRideLocationModel = new BusinessRideLocationModel();
                ((BaseModel) businessRideLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (businessRideLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) businessRideLocationModel).a();
                }
                return businessRideLocationModel;
            }
        }

        /* compiled from: verificationStatus */
        public class Serializer extends JsonSerializer<BusinessRideLocationModel> {
            public final void m3218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BusinessRideLocationModel businessRideLocationModel = (BusinessRideLocationModel) obj;
                if (businessRideLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessRideLocationModel.m3221a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessRideLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BusinessRideLocationParser.m3246a(businessRideLocationModel.w_(), businessRideLocationModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(BusinessRideLocationModel.class, new Serializer());
            }
        }

        public BusinessRideLocationModel() {
            super(2);
        }

        public BusinessRideLocationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double m3220a() {
            a(0, 0);
            return this.f1843d;
        }

        public final double m3224b() {
            a(0, 1);
            return this.f1844e;
        }

        public static BusinessRideLocationModel m3219a(BusinessRideLocationModel businessRideLocationModel) {
            if (businessRideLocationModel == null) {
                return null;
            }
            if (businessRideLocationModel instanceof BusinessRideLocationModel) {
                return businessRideLocationModel;
            }
            Builder builder = new Builder();
            builder.f1841a = businessRideLocationModel.m3220a();
            builder.f1842b = businessRideLocationModel.m3224b();
            return builder.m3216a();
        }

        public final int jK_() {
            return 1965687765;
        }

        public final GraphQLVisitableModel m3222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3221a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f1843d, 0.0d);
            flatBufferBuilder.a(1, this.f1844e, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3223a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1843d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f1844e = mutableFlatBuffer.a(i, 1, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 647031265)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: verificationStatus */
    public final class BusinessRideReceiptFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, BusinessRideReceiptFragment {
        @Nullable
        private GraphQLObjectType f1847d;
        @Nullable
        private String f1848e;
        @Nullable
        private BusinessRideLocationModel f1849f;
        @Nullable
        private String f1850g;
        @Nullable
        private String f1851h;
        private double f1852i;
        @Nullable
        private String f1853j;
        @Nullable
        private String f1854k;
        @Nullable
        private String f1855l;
        @Nullable
        private RideProviderModel f1856m;
        @Nullable
        private String f1857n;
        @Nullable
        private BusinessRideLocationModel f1858o;

        /* compiled from: verificationStatus */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessRideReceiptFragmentModel.class, new Deserializer());
            }

            public Object m3225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BusinessRideReceiptFragmentParser.m3249a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object businessRideReceiptFragmentModel = new BusinessRideReceiptFragmentModel();
                ((BaseModel) businessRideReceiptFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (businessRideReceiptFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) businessRideReceiptFragmentModel).a();
                }
                return businessRideReceiptFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -890196709)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: verificationStatus */
        public final class RideProviderModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LogoImageModel f1846d;

            /* compiled from: verificationStatus */
            public final class Builder {
                @Nullable
                public LogoImageModel f1845a;
            }

            /* compiled from: verificationStatus */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RideProviderModel.class, new Deserializer());
                }

                public Object m3226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RideProviderParser.m3247a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rideProviderModel = new RideProviderModel();
                    ((BaseModel) rideProviderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rideProviderModel instanceof Postprocessable) {
                        return ((Postprocessable) rideProviderModel).a();
                    }
                    return rideProviderModel;
                }
            }

            /* compiled from: verificationStatus */
            public class Serializer extends JsonSerializer<RideProviderModel> {
                public final void m3227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RideProviderModel rideProviderModel = (RideProviderModel) obj;
                    if (rideProviderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rideProviderModel.m3230a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rideProviderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RideProviderParser.m3248a(rideProviderModel.w_(), rideProviderModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RideProviderModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LogoImage m3232a() {
                return m3229j();
            }

            public RideProviderModel() {
                super(1);
            }

            public RideProviderModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private LogoImageModel m3229j() {
                this.f1846d = (LogoImageModel) super.a(this.f1846d, 0, LogoImageModel.class);
                return this.f1846d;
            }

            public static RideProviderModel m3228a(RideProviderModel rideProviderModel) {
                if (rideProviderModel == null) {
                    return null;
                }
                if (rideProviderModel instanceof RideProviderModel) {
                    return rideProviderModel;
                }
                Builder builder = new Builder();
                builder.f1845a = LogoImageModel.m1220a(rideProviderModel.m3232a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1845a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RideProviderModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1029877545;
            }

            public final GraphQLVisitableModel m3231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3229j() != null) {
                    LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m3229j());
                    if (m3229j() != logoImageModel) {
                        graphQLVisitableModel = (RideProviderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1846d = logoImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3230a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3229j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: verificationStatus */
        public class Serializer extends JsonSerializer<BusinessRideReceiptFragmentModel> {
            public final void m3233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BusinessRideReceiptFragmentModel businessRideReceiptFragmentModel = (BusinessRideReceiptFragmentModel) obj;
                if (businessRideReceiptFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessRideReceiptFragmentModel.m3239a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessRideReceiptFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BusinessRideReceiptFragmentParser.m3250a(businessRideReceiptFragmentModel.w_(), businessRideReceiptFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BusinessRideReceiptFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ BusinessRideLocationModel an() {
            return m3235k();
        }

        @Nullable
        public final /* synthetic */ RideProviderModel bg() {
            return m3237m();
        }

        @Nullable
        public final /* synthetic */ BusinessRideLocationModel bm() {
            return m3238n();
        }

        public BusinessRideReceiptFragmentModel() {
            super(12);
        }

        public final void m3243a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3244a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m3234j() {
            if (this.b != null && this.f1847d == null) {
                this.f1847d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1847d;
        }

        @Nullable
        public final String am() {
            this.f1848e = super.a(this.f1848e, 1);
            return this.f1848e;
        }

        @Nullable
        private BusinessRideLocationModel m3235k() {
            this.f1849f = (BusinessRideLocationModel) super.a(this.f1849f, 2, BusinessRideLocationModel.class);
            return this.f1849f;
        }

        @Nullable
        public final String ap() {
            this.f1850g = super.a(this.f1850g, 3);
            return this.f1850g;
        }

        @Nullable
        public final String aq() {
            this.f1851h = super.a(this.f1851h, 4);
            return this.f1851h;
        }

        public final double ar() {
            a(0, 5);
            return this.f1852i;
        }

        @Nullable
        public final String as() {
            this.f1853j = super.a(this.f1853j, 6);
            return this.f1853j;
        }

        @Nullable
        private String m3236l() {
            this.f1854k = super.a(this.f1854k, 7);
            return this.f1854k;
        }

        @Nullable
        public final String bf() {
            this.f1855l = super.a(this.f1855l, 8);
            return this.f1855l;
        }

        @Nullable
        private RideProviderModel m3237m() {
            this.f1856m = (RideProviderModel) super.a(this.f1856m, 9, RideProviderModel.class);
            return this.f1856m;
        }

        @Nullable
        public final String bl() {
            this.f1857n = super.a(this.f1857n, 10);
            return this.f1857n;
        }

        @Nullable
        private BusinessRideLocationModel m3238n() {
            this.f1858o = (BusinessRideLocationModel) super.a(this.f1858o, 11, BusinessRideLocationModel.class);
            return this.f1858o;
        }

        @Nullable
        public final String m3241a() {
            return m3236l();
        }

        public final int jK_() {
            return 1853506135;
        }

        public final GraphQLVisitableModel m3240a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            BusinessRideLocationModel businessRideLocationModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3235k() != null) {
                businessRideLocationModel = (BusinessRideLocationModel) graphQLModelMutatingVisitor.b(m3235k());
                if (m3235k() != businessRideLocationModel) {
                    graphQLVisitableModel = (BusinessRideReceiptFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1849f = businessRideLocationModel;
                }
            }
            if (m3237m() != null) {
                RideProviderModel rideProviderModel = (RideProviderModel) graphQLModelMutatingVisitor.b(m3237m());
                if (m3237m() != rideProviderModel) {
                    graphQLVisitableModel = (BusinessRideReceiptFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1856m = rideProviderModel;
                }
            }
            if (m3238n() != null) {
                businessRideLocationModel = (BusinessRideLocationModel) graphQLModelMutatingVisitor.b(m3238n());
                if (m3238n() != businessRideLocationModel) {
                    graphQLVisitableModel = (BusinessRideReceiptFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1858o = businessRideLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3239a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3234j());
            int b = flatBufferBuilder.b(am());
            int a2 = ModelHelper.a(flatBufferBuilder, m3235k());
            int b2 = flatBufferBuilder.b(ap());
            int b3 = flatBufferBuilder.b(aq());
            int b4 = flatBufferBuilder.b(as());
            int b5 = flatBufferBuilder.b(m3236l());
            int b6 = flatBufferBuilder.b(bf());
            int a3 = ModelHelper.a(flatBufferBuilder, m3237m());
            int b7 = flatBufferBuilder.b(bl());
            int a4 = ModelHelper.a(flatBufferBuilder, m3238n());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f1852i, 0.0d);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, b7);
            flatBufferBuilder.b(11, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3242a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1852i = mutableFlatBuffer.a(i, 5, 0.0d);
        }
    }
}
