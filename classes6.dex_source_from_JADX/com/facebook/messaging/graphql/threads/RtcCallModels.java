package com.facebook.messaging.graphql.threads;

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
import com.facebook.messaging.graphql.threads.RtcCallParsers.RtcCallDataInfoParser;
import com.facebook.messaging.graphql.threads.RtcCallParsers.RtcCallDataInfoParser.InitiatorParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_broadcast/interrupt_ */
public class RtcCallModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 145680643)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_broadcast/interrupt_ */
    public final class RtcCallDataInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1058d;
        @Nullable
        private InitiatorModel f1059e;
        @Nullable
        private String f1060f;

        /* compiled from: video_broadcast/interrupt_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RtcCallDataInfoModel.class, new Deserializer());
            }

            public Object m1419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RtcCallDataInfoParser.m1438a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object rtcCallDataInfoModel = new RtcCallDataInfoModel();
                ((BaseModel) rtcCallDataInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (rtcCallDataInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) rtcCallDataInfoModel).a();
                }
                return rtcCallDataInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_broadcast/interrupt_ */
        public final class InitiatorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1055d;
            @Nullable
            private String f1056e;
            @Nullable
            private String f1057f;

            /* compiled from: video_broadcast/interrupt_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InitiatorModel.class, new Deserializer());
                }

                public Object m1420a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InitiatorParser.m1436a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object initiatorModel = new InitiatorModel();
                    ((BaseModel) initiatorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (initiatorModel instanceof Postprocessable) {
                        return ((Postprocessable) initiatorModel).a();
                    }
                    return initiatorModel;
                }
            }

            /* compiled from: video_broadcast/interrupt_ */
            public class Serializer extends JsonSerializer<InitiatorModel> {
                public final void m1421a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InitiatorModel initiatorModel = (InitiatorModel) obj;
                    if (initiatorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(initiatorModel.m1424a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        initiatorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InitiatorParser.m1437a(initiatorModel.w_(), initiatorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InitiatorModel.class, new Serializer());
                }
            }

            public InitiatorModel() {
                super(3);
            }

            public final void m1427a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1428a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m1422k() {
                if (this.b != null && this.f1055d == null) {
                    this.f1055d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1055d;
            }

            @Nullable
            public final String m1429j() {
                this.f1056e = super.a(this.f1056e, 1);
                return this.f1056e;
            }

            @Nullable
            private String m1423l() {
                this.f1057f = super.a(this.f1057f, 2);
                return this.f1057f;
            }

            @Nullable
            public final String m1426a() {
                return m1429j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m1425a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1424a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1422k());
                int b = flatBufferBuilder.b(m1429j());
                int b2 = flatBufferBuilder.b(m1423l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_broadcast/interrupt_ */
        public class Serializer extends JsonSerializer<RtcCallDataInfoModel> {
            public final void m1430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RtcCallDataInfoModel rtcCallDataInfoModel = (RtcCallDataInfoModel) obj;
                if (rtcCallDataInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rtcCallDataInfoModel.m1431a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rtcCallDataInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RtcCallDataInfoParser.m1439a(rtcCallDataInfoModel.w_(), rtcCallDataInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RtcCallDataInfoModel.class, new Serializer());
            }
        }

        public RtcCallDataInfoModel() {
            super(3);
        }

        @Nullable
        public final String m1433a() {
            this.f1058d = super.a(this.f1058d, 0);
            return this.f1058d;
        }

        @Nullable
        public final InitiatorModel m1434j() {
            this.f1059e = (InitiatorModel) super.a(this.f1059e, 1, InitiatorModel.class);
            return this.f1059e;
        }

        @Nullable
        public final String m1435k() {
            this.f1060f = super.a(this.f1060f, 2);
            return this.f1060f;
        }

        public final int jK_() {
            return -1299688311;
        }

        public final GraphQLVisitableModel m1432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1434j() != null) {
                InitiatorModel initiatorModel = (InitiatorModel) graphQLModelMutatingVisitor.b(m1434j());
                if (m1434j() != initiatorModel) {
                    graphQLVisitableModel = (RtcCallDataInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1059e = initiatorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1431a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1433a());
            int a = ModelHelper.a(flatBufferBuilder, m1434j());
            int b2 = flatBufferBuilder.b(m1435k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
