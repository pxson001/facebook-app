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
import com.facebook.presence.protocol.FeedbackStartTypingMutationsParsers.FeedbackStartTypingCoreMutationFieldsParser;
import com.facebook.presence.protocol.FeedbackStartTypingMutationsParsers.FeedbackStartTypingCoreMutationFieldsParser.FeedbackParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: image is null */
public class FeedbackStartTypingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1839081988)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: image is null */
    public final class FeedbackStartTypingCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f11206d;

        /* compiled from: image is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackStartTypingCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m13102a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackStartTypingCoreMutationFieldsParser.m13118a(jsonParser);
                Object feedbackStartTypingCoreMutationFieldsModel = new FeedbackStartTypingCoreMutationFieldsModel();
                ((BaseModel) feedbackStartTypingCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackStartTypingCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackStartTypingCoreMutationFieldsModel).a();
                }
                return feedbackStartTypingCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1468591901)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: image is null */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11204d;
            @Nullable
            private String f11205e;

            /* compiled from: image is null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m13103a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m13116a(jsonParser, flatBufferBuilder));
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

            /* compiled from: image is null */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m13104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m13107a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m13117a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m13110a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13111a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m13105j() {
                this.f11204d = super.a(this.f11204d, 0);
                return this.f11204d;
            }

            @Nullable
            private String m13106k() {
                this.f11205e = super.a(this.f11205e, 1);
                return this.f11205e;
            }

            @Nullable
            public final String m13109a() {
                return m13106k();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m13108a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13107a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13105j());
                int b2 = flatBufferBuilder.b(m13106k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: image is null */
        public class Serializer extends JsonSerializer<FeedbackStartTypingCoreMutationFieldsModel> {
            public final void m13112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackStartTypingCoreMutationFieldsModel feedbackStartTypingCoreMutationFieldsModel = (FeedbackStartTypingCoreMutationFieldsModel) obj;
                if (feedbackStartTypingCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackStartTypingCoreMutationFieldsModel.m13114a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackStartTypingCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackStartTypingCoreMutationFieldsModel.w_();
                int u_ = feedbackStartTypingCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m13117a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackStartTypingCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FeedbackStartTypingCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m13113a() {
            this.f11206d = (FeedbackModel) super.a(this.f11206d, 0, FeedbackModel.class);
            return this.f11206d;
        }

        public final int jK_() {
            return -1741343783;
        }

        public final GraphQLVisitableModel m13115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13113a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m13113a());
                if (m13113a() != feedbackModel) {
                    graphQLVisitableModel = (FeedbackStartTypingCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11206d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13114a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13113a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
