package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.ReachEstimateDataQueryParsers.ReachEstimateQueryParser;
import com.facebook.adinterfaces.protocol.ReachEstimateDataQueryParsers.ReachEstimateQueryParser.ReachEstimateDataParser;
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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Video Home prefetch metadata query failed */
public class ReachEstimateDataQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1660328961)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Video Home prefetch metadata query failed */
    public final class ReachEstimateQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f22404d;
        @Nullable
        private ReachEstimateDataModel f22405e;

        /* compiled from: Video Home prefetch metadata query failed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReachEstimateQueryModel.class, new Deserializer());
            }

            public Object m24247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReachEstimateQueryParser.m24263a(jsonParser);
                Object reachEstimateQueryModel = new ReachEstimateQueryModel();
                ((BaseModel) reachEstimateQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reachEstimateQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) reachEstimateQueryModel).a();
                }
                return reachEstimateQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -328364226)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Video Home prefetch metadata query failed */
        public final class ReachEstimateDataModel extends BaseModel implements GraphQLVisitableModel {
            private int f22403d;

            /* compiled from: Video Home prefetch metadata query failed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReachEstimateDataModel.class, new Deserializer());
                }

                public Object m24248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReachEstimateDataParser.m24261a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reachEstimateDataModel = new ReachEstimateDataModel();
                    ((BaseModel) reachEstimateDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reachEstimateDataModel instanceof Postprocessable) {
                        return ((Postprocessable) reachEstimateDataModel).a();
                    }
                    return reachEstimateDataModel;
                }
            }

            /* compiled from: Video Home prefetch metadata query failed */
            public class Serializer extends JsonSerializer<ReachEstimateDataModel> {
                public final void m24249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReachEstimateDataModel reachEstimateDataModel = (ReachEstimateDataModel) obj;
                    if (reachEstimateDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reachEstimateDataModel.m24251a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reachEstimateDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReachEstimateDataParser.m24262a(reachEstimateDataModel.w_(), reachEstimateDataModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReachEstimateDataModel.class, new Serializer());
                }
            }

            public ReachEstimateDataModel() {
                super(1);
            }

            public final int m24250a() {
                a(0, 0);
                return this.f22403d;
            }

            public final int jK_() {
                return -1458785278;
            }

            public final GraphQLVisitableModel m24252a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24251a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f22403d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m24253a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22403d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: Video Home prefetch metadata query failed */
        public class Serializer extends JsonSerializer<ReachEstimateQueryModel> {
            public final void m24254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReachEstimateQueryModel reachEstimateQueryModel = (ReachEstimateQueryModel) obj;
                if (reachEstimateQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reachEstimateQueryModel.m24256a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reachEstimateQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reachEstimateQueryModel.w_();
                int u_ = reachEstimateQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("reach_estimate_data");
                    ReachEstimateDataParser.m24262a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReachEstimateQueryModel.class, new Serializer());
            }
        }

        public ReachEstimateQueryModel() {
            super(2);
        }

        public final void m24259a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24260a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24255j() {
            if (this.b != null && this.f22404d == null) {
                this.f22404d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f22404d;
        }

        @Nullable
        public final ReachEstimateDataModel m24257a() {
            this.f22405e = (ReachEstimateDataModel) super.a(this.f22405e, 1, ReachEstimateDataModel.class);
            return this.f22405e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24257a() != null) {
                ReachEstimateDataModel reachEstimateDataModel = (ReachEstimateDataModel) graphQLModelMutatingVisitor.b(m24257a());
                if (m24257a() != reachEstimateDataModel) {
                    graphQLVisitableModel = (ReachEstimateQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22405e = reachEstimateDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24256a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24255j());
            int a2 = ModelHelper.a(flatBufferBuilder, m24257a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
