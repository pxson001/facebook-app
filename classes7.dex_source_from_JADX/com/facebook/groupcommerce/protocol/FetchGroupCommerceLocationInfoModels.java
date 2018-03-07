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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoParsers.StructuredLocationFragmentParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoParsers.StructuredLocationFragmentParser.LocationParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoParsers.StructuredLocationQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: refresh_interval */
public class FetchGroupCommerceLocationInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 374227560)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: refresh_interval */
    public final class StructuredLocationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f5373d;
        @Nullable
        private LocationModel f5374e;
        @Nullable
        private String f5375f;

        /* compiled from: refresh_interval */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredLocationFragmentModel.class, new Deserializer());
            }

            public Object m5805a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredLocationFragmentParser.m5829a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredLocationFragmentModel = new StructuredLocationFragmentModel();
                ((BaseModel) structuredLocationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredLocationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredLocationFragmentModel).a();
                }
                return structuredLocationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: refresh_interval */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f5371d;
            private double f5372e;

            /* compiled from: refresh_interval */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m5806a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m5827a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: refresh_interval */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m5807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m5809a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m5828a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(2);
            }

            public final double m5808a() {
                a(0, 0);
                return this.f5371d;
            }

            public final double m5812j() {
                a(0, 1);
                return this.f5372e;
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m5810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5809a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5371d, 0.0d);
                flatBufferBuilder.a(1, this.f5372e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5811a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5371d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f5372e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: refresh_interval */
        public class Serializer extends JsonSerializer<StructuredLocationFragmentModel> {
            public final void m5813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredLocationFragmentModel structuredLocationFragmentModel = (StructuredLocationFragmentModel) obj;
                if (structuredLocationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredLocationFragmentModel.m5814a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredLocationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredLocationFragmentParser.m5830a(structuredLocationFragmentModel.w_(), structuredLocationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredLocationFragmentModel.class, new Serializer());
            }
        }

        public StructuredLocationFragmentModel() {
            super(3);
        }

        public final void m5817a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5818a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m5819j() {
            this.f5373d = super.a(this.f5373d, 0);
            return this.f5373d;
        }

        @Nullable
        public final LocationModel m5820k() {
            this.f5374e = (LocationModel) super.a(this.f5374e, 1, LocationModel.class);
            return this.f5374e;
        }

        @Nullable
        public final String m5821l() {
            this.f5375f = super.a(this.f5375f, 2);
            return this.f5375f;
        }

        @Nullable
        public final String m5816a() {
            return m5819j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m5815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5820k() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5820k());
                if (m5820k() != locationModel) {
                    graphQLVisitableModel = (StructuredLocationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5374e = locationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5814a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5819j());
            int a = ModelHelper.a(flatBufferBuilder, m5820k());
            int b2 = flatBufferBuilder.b(m5821l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1315633688)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: refresh_interval */
    public final class StructuredLocationQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StructuredLocationFragmentModel f5376d;

        /* compiled from: refresh_interval */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredLocationQueryModel.class, new Deserializer());
            }

            public Object m5822a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StructuredLocationQueryParser.m5831a(jsonParser);
                Object structuredLocationQueryModel = new StructuredLocationQueryModel();
                ((BaseModel) structuredLocationQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (structuredLocationQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredLocationQueryModel).a();
                }
                return structuredLocationQueryModel;
            }
        }

        /* compiled from: refresh_interval */
        public class Serializer extends JsonSerializer<StructuredLocationQueryModel> {
            public final void m5823a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StructuredLocationQueryModel structuredLocationQueryModel = (StructuredLocationQueryModel) obj;
                if (structuredLocationQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredLocationQueryModel.m5824a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredLocationQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = structuredLocationQueryModel.w_();
                int u_ = structuredLocationQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_commerce_suggested_location");
                    StructuredLocationFragmentParser.m5830a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StructuredLocationQueryModel.class, new Serializer());
            }
        }

        public StructuredLocationQueryModel() {
            super(1);
        }

        @Nullable
        public final StructuredLocationFragmentModel m5826a() {
            this.f5376d = (StructuredLocationFragmentModel) super.a(this.f5376d, 0, StructuredLocationFragmentModel.class);
            return this.f5376d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5825a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5826a() != null) {
                StructuredLocationFragmentModel structuredLocationFragmentModel = (StructuredLocationFragmentModel) graphQLModelMutatingVisitor.b(m5826a());
                if (m5826a() != structuredLocationFragmentModel) {
                    graphQLVisitableModel = (StructuredLocationQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5376d = structuredLocationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5824a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5826a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
