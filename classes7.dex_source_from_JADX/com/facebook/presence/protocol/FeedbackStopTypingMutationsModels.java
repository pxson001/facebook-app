package com.facebook.presence.protocol;

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
import com.facebook.presence.protocol.FeedbackStopTypingMutationsParsers.FeedbackStopTypingCoreMutationFieldsParser;
import com.facebook.presence.protocol.FeedbackStopTypingMutationsParsers.FeedbackStopTypingCoreMutationFieldsParser.FeedbackParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: idxmap */
public class FeedbackStopTypingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1548520497)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: idxmap */
    public final class FeedbackStopTypingCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f11209d;

        /* compiled from: idxmap */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackStopTypingCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m13120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackStopTypingCoreMutationFieldsParser.m13136a(jsonParser);
                Object feedbackStopTypingCoreMutationFieldsModel = new FeedbackStopTypingCoreMutationFieldsModel();
                ((BaseModel) feedbackStopTypingCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackStopTypingCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackStopTypingCoreMutationFieldsModel).a();
                }
                return feedbackStopTypingCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1468591901)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: idxmap */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11207d;
            @Nullable
            private String f11208e;

            /* compiled from: idxmap */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m13121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m13134a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: idxmap */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m13122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m13125a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m13135a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m13128a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13129a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m13123j() {
                this.f11207d = super.a(this.f11207d, 0);
                return this.f11207d;
            }

            @Nullable
            private String m13124k() {
                this.f11208e = super.a(this.f11208e, 1);
                return this.f11208e;
            }

            @Nullable
            public final String m13127a() {
                return m13124k();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m13126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13125a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13123j());
                int b2 = flatBufferBuilder.b(m13124k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: idxmap */
        public class Serializer extends JsonSerializer<FeedbackStopTypingCoreMutationFieldsModel> {
            public final void m13130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackStopTypingCoreMutationFieldsModel feedbackStopTypingCoreMutationFieldsModel = (FeedbackStopTypingCoreMutationFieldsModel) obj;
                if (feedbackStopTypingCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackStopTypingCoreMutationFieldsModel.m13132a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackStopTypingCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackStopTypingCoreMutationFieldsModel.w_();
                int u_ = feedbackStopTypingCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m13135a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackStopTypingCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FeedbackStopTypingCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m13131a() {
            this.f11209d = (FeedbackModel) super.a(this.f11209d, 0, FeedbackModel.class);
            return this.f11209d;
        }

        public final int jK_() {
            return 358940815;
        }

        public final GraphQLVisitableModel m13133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13131a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m13131a());
                if (m13131a() != feedbackModel) {
                    graphQLVisitableModel = (FeedbackStopTypingCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11209d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13132a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13131a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
