package com.facebook.negativefeedback.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackFlowForMessageThreadQueryParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackFlowStepQueryParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.CompletedSubtitleParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.CompletedTitleParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.ConfirmationHeaderParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.ConfirmationMessageParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.SubtitleParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.TargetParser;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryParsers.NegativeFeedbackPromptQueryFragmentParser.ResponsesParser.TitleParser;
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

/* compiled from: notification_tracking */
public class NegativeFeedbackQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 38671032)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: notification_tracking */
    public final class NegativeFeedbackFlowForMessageThreadQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NegativeFeedbackPromptQueryFragmentModel f7977d;

        /* compiled from: notification_tracking */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NegativeFeedbackFlowForMessageThreadQueryModel.class, new Deserializer());
            }

            public Object m9612a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NegativeFeedbackFlowForMessageThreadQueryParser.m9699a(jsonParser);
                Object negativeFeedbackFlowForMessageThreadQueryModel = new NegativeFeedbackFlowForMessageThreadQueryModel();
                ((BaseModel) negativeFeedbackFlowForMessageThreadQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (negativeFeedbackFlowForMessageThreadQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) negativeFeedbackFlowForMessageThreadQueryModel).a();
                }
                return negativeFeedbackFlowForMessageThreadQueryModel;
            }
        }

        /* compiled from: notification_tracking */
        public class Serializer extends JsonSerializer<NegativeFeedbackFlowForMessageThreadQueryModel> {
            public final void m9613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NegativeFeedbackFlowForMessageThreadQueryModel negativeFeedbackFlowForMessageThreadQueryModel = (NegativeFeedbackFlowForMessageThreadQueryModel) obj;
                if (negativeFeedbackFlowForMessageThreadQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(negativeFeedbackFlowForMessageThreadQueryModel.m9614a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    negativeFeedbackFlowForMessageThreadQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = negativeFeedbackFlowForMessageThreadQueryModel.w_();
                int u_ = negativeFeedbackFlowForMessageThreadQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("negative_feedback_prompt");
                    NegativeFeedbackPromptQueryFragmentParser.m9720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NegativeFeedbackFlowForMessageThreadQueryModel.class, new Serializer());
            }
        }

        public NegativeFeedbackFlowForMessageThreadQueryModel() {
            super(1);
        }

        @Nullable
        public final NegativeFeedbackPromptQueryFragmentModel m9616a() {
            this.f7977d = (NegativeFeedbackPromptQueryFragmentModel) super.a(this.f7977d, 0, NegativeFeedbackPromptQueryFragmentModel.class);
            return this.f7977d;
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m9615a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9616a() != null) {
                NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel = (NegativeFeedbackPromptQueryFragmentModel) graphQLModelMutatingVisitor.b(m9616a());
                if (m9616a() != negativeFeedbackPromptQueryFragmentModel) {
                    graphQLVisitableModel = (NegativeFeedbackFlowForMessageThreadQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7977d = negativeFeedbackPromptQueryFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9614a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9616a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -15210686)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: notification_tracking */
    public final class NegativeFeedbackFlowStepQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7978d;
        @Nullable
        private NegativeFeedbackPromptQueryFragmentModel f7979e;

        /* compiled from: notification_tracking */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NegativeFeedbackFlowStepQueryModel.class, new Deserializer());
            }

            public Object m9617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NegativeFeedbackFlowStepQueryParser.m9700a(jsonParser);
                Object negativeFeedbackFlowStepQueryModel = new NegativeFeedbackFlowStepQueryModel();
                ((BaseModel) negativeFeedbackFlowStepQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (negativeFeedbackFlowStepQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) negativeFeedbackFlowStepQueryModel).a();
                }
                return negativeFeedbackFlowStepQueryModel;
            }
        }

        /* compiled from: notification_tracking */
        public class Serializer extends JsonSerializer<NegativeFeedbackFlowStepQueryModel> {
            public final void m9618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NegativeFeedbackFlowStepQueryModel negativeFeedbackFlowStepQueryModel = (NegativeFeedbackFlowStepQueryModel) obj;
                if (negativeFeedbackFlowStepQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(negativeFeedbackFlowStepQueryModel.m9620a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    negativeFeedbackFlowStepQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = negativeFeedbackFlowStepQueryModel.w_();
                int u_ = negativeFeedbackFlowStepQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("negative_feedback_prompt");
                    NegativeFeedbackPromptQueryFragmentParser.m9720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NegativeFeedbackFlowStepQueryModel.class, new Serializer());
            }
        }

        public NegativeFeedbackFlowStepQueryModel() {
            super(2);
        }

        public final void m9623a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9624a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m9619j() {
            if (this.b != null && this.f7978d == null) {
                this.f7978d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7978d;
        }

        @Nullable
        public final NegativeFeedbackPromptQueryFragmentModel m9622a() {
            this.f7979e = (NegativeFeedbackPromptQueryFragmentModel) super.a(this.f7979e, 1, NegativeFeedbackPromptQueryFragmentModel.class);
            return this.f7979e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m9621a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9622a() != null) {
                NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel = (NegativeFeedbackPromptQueryFragmentModel) graphQLModelMutatingVisitor.b(m9622a());
                if (m9622a() != negativeFeedbackPromptQueryFragmentModel) {
                    graphQLVisitableModel = (NegativeFeedbackFlowStepQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7979e = negativeFeedbackPromptQueryFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9620a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9619j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9622a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 958739110)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: notification_tracking */
    public final class NegativeFeedbackPromptQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ResponsesModel> f8004d;
        @Nullable
        private TitleModel f8005e;

        /* compiled from: notification_tracking */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NegativeFeedbackPromptQueryFragmentModel.class, new Deserializer());
            }

            public Object m9625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NegativeFeedbackPromptQueryFragmentParser.m9719a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object negativeFeedbackPromptQueryFragmentModel = new NegativeFeedbackPromptQueryFragmentModel();
                ((BaseModel) negativeFeedbackPromptQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (negativeFeedbackPromptQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) negativeFeedbackPromptQueryFragmentModel).a();
                }
                return negativeFeedbackPromptQueryFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 851977800)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: notification_tracking */
        public final class ResponsesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f7989d;
            private boolean f7990e;
            @Nullable
            private CompletedSubtitleModel f7991f;
            @Nullable
            private CompletedTitleModel f7992g;
            @Nullable
            private ConfirmationHeaderModel f7993h;
            @Nullable
            private ConfirmationMessageModel f7994i;
            @Nullable
            private String f7995j;
            @Nullable
            private GraphQLNegativeFeedbackActionType f7996k;
            @Nullable
            private String f7997l;
            @Nullable
            private SubtitleModel f7998m;
            @Nullable
            private TargetModel f7999n;
            private boolean f8000o;
            @Nullable
            private TitleModel f8001p;
            @Nullable
            private String f8002q;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: notification_tracking */
            public final class CompletedSubtitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7980d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CompletedSubtitleModel.class, new Deserializer());
                    }

                    public Object m9626a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CompletedSubtitleParser.m9701a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object completedSubtitleModel = new CompletedSubtitleModel();
                        ((BaseModel) completedSubtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (completedSubtitleModel instanceof Postprocessable) {
                            return ((Postprocessable) completedSubtitleModel).a();
                        }
                        return completedSubtitleModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<CompletedSubtitleModel> {
                    public final void m9627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CompletedSubtitleModel completedSubtitleModel = (CompletedSubtitleModel) obj;
                        if (completedSubtitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(completedSubtitleModel.m9628a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            completedSubtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CompletedSubtitleParser.m9702a(completedSubtitleModel.w_(), completedSubtitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CompletedSubtitleModel.class, new Serializer());
                    }
                }

                public CompletedSubtitleModel() {
                    super(1);
                }

                @Nullable
                public final String m9630a() {
                    this.f7980d = super.a(this.f7980d, 0);
                    return this.f7980d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9629a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9628a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9630a());
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
            /* compiled from: notification_tracking */
            public final class CompletedTitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7981d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CompletedTitleModel.class, new Deserializer());
                    }

                    public Object m9631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CompletedTitleParser.m9703a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object completedTitleModel = new CompletedTitleModel();
                        ((BaseModel) completedTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (completedTitleModel instanceof Postprocessable) {
                            return ((Postprocessable) completedTitleModel).a();
                        }
                        return completedTitleModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<CompletedTitleModel> {
                    public final void m9632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CompletedTitleModel completedTitleModel = (CompletedTitleModel) obj;
                        if (completedTitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(completedTitleModel.m9633a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            completedTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CompletedTitleParser.m9704a(completedTitleModel.w_(), completedTitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CompletedTitleModel.class, new Serializer());
                    }
                }

                public CompletedTitleModel() {
                    super(1);
                }

                @Nullable
                public final String m9635a() {
                    this.f7981d = super.a(this.f7981d, 0);
                    return this.f7981d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9633a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9635a());
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
            /* compiled from: notification_tracking */
            public final class ConfirmationHeaderModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7982d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ConfirmationHeaderModel.class, new Deserializer());
                    }

                    public Object m9636a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ConfirmationHeaderParser.m9705a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object confirmationHeaderModel = new ConfirmationHeaderModel();
                        ((BaseModel) confirmationHeaderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (confirmationHeaderModel instanceof Postprocessable) {
                            return ((Postprocessable) confirmationHeaderModel).a();
                        }
                        return confirmationHeaderModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<ConfirmationHeaderModel> {
                    public final void m9637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ConfirmationHeaderModel confirmationHeaderModel = (ConfirmationHeaderModel) obj;
                        if (confirmationHeaderModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(confirmationHeaderModel.m9639a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            confirmationHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ConfirmationHeaderParser.m9706a(confirmationHeaderModel.w_(), confirmationHeaderModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ConfirmationHeaderModel.class, new Serializer());
                    }
                }

                public ConfirmationHeaderModel() {
                    super(1);
                }

                @Nullable
                private String m9638a() {
                    this.f7982d = super.a(this.f7982d, 0);
                    return this.f7982d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9640a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9639a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9638a());
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
            /* compiled from: notification_tracking */
            public final class ConfirmationMessageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7983d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ConfirmationMessageModel.class, new Deserializer());
                    }

                    public Object m9641a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ConfirmationMessageParser.m9707a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object confirmationMessageModel = new ConfirmationMessageModel();
                        ((BaseModel) confirmationMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (confirmationMessageModel instanceof Postprocessable) {
                            return ((Postprocessable) confirmationMessageModel).a();
                        }
                        return confirmationMessageModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<ConfirmationMessageModel> {
                    public final void m9642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ConfirmationMessageModel confirmationMessageModel = (ConfirmationMessageModel) obj;
                        if (confirmationMessageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(confirmationMessageModel.m9644a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            confirmationMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ConfirmationMessageParser.m9708a(confirmationMessageModel.w_(), confirmationMessageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ConfirmationMessageModel.class, new Serializer());
                    }
                }

                public ConfirmationMessageModel() {
                    super(1);
                }

                @Nullable
                private String m9643a() {
                    this.f7983d = super.a(this.f7983d, 0);
                    return this.f7983d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9644a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9643a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: notification_tracking */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResponsesModel.class, new Deserializer());
                }

                public Object m9646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResponsesParser.m9715b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object responsesModel = new ResponsesModel();
                    ((BaseModel) responsesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (responsesModel instanceof Postprocessable) {
                        return ((Postprocessable) responsesModel).a();
                    }
                    return responsesModel;
                }
            }

            /* compiled from: notification_tracking */
            public class Serializer extends JsonSerializer<ResponsesModel> {
                public final void m9647a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResponsesModel responsesModel = (ResponsesModel) obj;
                    if (responsesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(responsesModel.m9676a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        responsesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResponsesParser.m9716b(responsesModel.w_(), responsesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResponsesModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: notification_tracking */
            public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7984d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                    }

                    public Object m9648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SubtitleParser.m9709a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object subtitleModel = new SubtitleModel();
                        ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (subtitleModel instanceof Postprocessable) {
                            return ((Postprocessable) subtitleModel).a();
                        }
                        return subtitleModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<SubtitleModel> {
                    public final void m9649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SubtitleModel subtitleModel = (SubtitleModel) obj;
                        if (subtitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(subtitleModel.m9650a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SubtitleParser.m9710a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                    }
                }

                public SubtitleModel() {
                    super(1);
                }

                @Nullable
                public final String m9652a() {
                    this.f7984d = super.a(this.f7984d, 0);
                    return this.f7984d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9650a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9652a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: notification_tracking */
            public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f7985d;
                @Nullable
                private String f7986e;
                @Nullable
                private String f7987f;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                    }

                    public Object m9653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TargetParser.m9711a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object targetModel = new TargetModel();
                        ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (targetModel instanceof Postprocessable) {
                            return ((Postprocessable) targetModel).a();
                        }
                        return targetModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<TargetModel> {
                    public final void m9654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TargetModel targetModel = (TargetModel) obj;
                        if (targetModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(targetModel.m9656a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TargetParser.m9712a(targetModel.w_(), targetModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TargetModel.class, new Serializer());
                    }
                }

                public TargetModel() {
                    super(3);
                }

                public final void m9659a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m9660a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m9655j() {
                    if (this.b != null && this.f7985d == null) {
                        this.f7985d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f7985d;
                }

                @Nullable
                public final String m9661b() {
                    this.f7986e = super.a(this.f7986e, 1);
                    return this.f7986e;
                }

                @Nullable
                public final String m9662c() {
                    this.f7987f = super.a(this.f7987f, 2);
                    return this.f7987f;
                }

                @Nullable
                public final String m9658a() {
                    return m9661b();
                }

                public final int jK_() {
                    return 1355227529;
                }

                public final GraphQLVisitableModel m9657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9656a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9655j());
                    int b = flatBufferBuilder.b(m9661b());
                    int b2 = flatBufferBuilder.b(m9662c());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: notification_tracking */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7988d;

                /* compiled from: notification_tracking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m9663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m9713a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object titleModel = new TitleModel();
                        ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (titleModel instanceof Postprocessable) {
                            return ((Postprocessable) titleModel).a();
                        }
                        return titleModel;
                    }
                }

                /* compiled from: notification_tracking */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m9664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m9665a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m9714a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m9667a() {
                    this.f7988d = super.a(this.f7988d, 0);
                    return this.f7988d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9665a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9667a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ CompletedSubtitleModel m9681c() {
                return m9669o();
            }

            @Nullable
            public final /* synthetic */ CompletedTitleModel m9682d() {
                return m9670p();
            }

            @Nullable
            public final /* synthetic */ SubtitleModel gN_() {
                return m9673s();
            }

            @Nullable
            public final /* synthetic */ TargetModel m9684j() {
                return m9674t();
            }

            @Nullable
            public final /* synthetic */ TitleModel m9686l() {
                return m9675u();
            }

            public ResponsesModel() {
                super(14);
            }

            @Nullable
            private GraphQLObjectType m9668n() {
                if (this.b != null && this.f7989d == null) {
                    this.f7989d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f7989d;
            }

            public final boolean m9680b() {
                a(0, 1);
                return this.f7990e;
            }

            @Nullable
            private CompletedSubtitleModel m9669o() {
                this.f7991f = (CompletedSubtitleModel) super.a(this.f7991f, 2, CompletedSubtitleModel.class);
                return this.f7991f;
            }

            @Nullable
            private CompletedTitleModel m9670p() {
                this.f7992g = (CompletedTitleModel) super.a(this.f7992g, 3, CompletedTitleModel.class);
                return this.f7992g;
            }

            @Nullable
            private ConfirmationHeaderModel m9671q() {
                this.f7993h = (ConfirmationHeaderModel) super.a(this.f7993h, 4, ConfirmationHeaderModel.class);
                return this.f7993h;
            }

            @Nullable
            private ConfirmationMessageModel m9672r() {
                this.f7994i = (ConfirmationMessageModel) super.a(this.f7994i, 5, ConfirmationMessageModel.class);
                return this.f7994i;
            }

            @Nullable
            public final String gL_() {
                this.f7995j = super.a(this.f7995j, 6);
                return this.f7995j;
            }

            @Nullable
            public final GraphQLNegativeFeedbackActionType m9683g() {
                this.f7996k = (GraphQLNegativeFeedbackActionType) super.b(this.f7996k, 7, GraphQLNegativeFeedbackActionType.class, GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f7996k;
            }

            @Nullable
            public final String gM_() {
                this.f7997l = super.a(this.f7997l, 8);
                return this.f7997l;
            }

            @Nullable
            private SubtitleModel m9673s() {
                this.f7998m = (SubtitleModel) super.a(this.f7998m, 9, SubtitleModel.class);
                return this.f7998m;
            }

            @Nullable
            private TargetModel m9674t() {
                this.f7999n = (TargetModel) super.a(this.f7999n, 10, TargetModel.class);
                return this.f7999n;
            }

            public final boolean m9685k() {
                a(1, 3);
                return this.f8000o;
            }

            @Nullable
            private TitleModel m9675u() {
                this.f8001p = (TitleModel) super.a(this.f8001p, 12, TitleModel.class);
                return this.f8001p;
            }

            @Nullable
            public final String m9687m() {
                this.f8002q = super.a(this.f8002q, 13);
                return this.f8002q;
            }

            @Nullable
            public final String m9678a() {
                return gL_();
            }

            public final int jK_() {
                return -660178597;
            }

            public final GraphQLVisitableModel m9677a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9669o() != null) {
                    CompletedSubtitleModel completedSubtitleModel = (CompletedSubtitleModel) graphQLModelMutatingVisitor.b(m9669o());
                    if (m9669o() != completedSubtitleModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7991f = completedSubtitleModel;
                    }
                }
                if (m9670p() != null) {
                    CompletedTitleModel completedTitleModel = (CompletedTitleModel) graphQLModelMutatingVisitor.b(m9670p());
                    if (m9670p() != completedTitleModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7992g = completedTitleModel;
                    }
                }
                if (m9671q() != null) {
                    ConfirmationHeaderModel confirmationHeaderModel = (ConfirmationHeaderModel) graphQLModelMutatingVisitor.b(m9671q());
                    if (m9671q() != confirmationHeaderModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7993h = confirmationHeaderModel;
                    }
                }
                if (m9672r() != null) {
                    ConfirmationMessageModel confirmationMessageModel = (ConfirmationMessageModel) graphQLModelMutatingVisitor.b(m9672r());
                    if (m9672r() != confirmationMessageModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7994i = confirmationMessageModel;
                    }
                }
                if (m9673s() != null) {
                    SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m9673s());
                    if (m9673s() != subtitleModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7998m = subtitleModel;
                    }
                }
                if (m9674t() != null) {
                    TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m9674t());
                    if (m9674t() != targetModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7999n = targetModel;
                    }
                }
                if (m9675u() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m9675u());
                    if (m9675u() != titleModel) {
                        graphQLVisitableModel = (ResponsesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8001p = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9676a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9668n());
                int a2 = ModelHelper.a(flatBufferBuilder, m9669o());
                int a3 = ModelHelper.a(flatBufferBuilder, m9670p());
                int a4 = ModelHelper.a(flatBufferBuilder, m9671q());
                int a5 = ModelHelper.a(flatBufferBuilder, m9672r());
                int b = flatBufferBuilder.b(gL_());
                int a6 = flatBufferBuilder.a(m9683g());
                int b2 = flatBufferBuilder.b(gM_());
                int a7 = ModelHelper.a(flatBufferBuilder, m9673s());
                int a8 = ModelHelper.a(flatBufferBuilder, m9674t());
                int a9 = ModelHelper.a(flatBufferBuilder, m9675u());
                int b3 = flatBufferBuilder.b(m9687m());
                flatBufferBuilder.c(14);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f7990e);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, b2);
                flatBufferBuilder.b(9, a7);
                flatBufferBuilder.b(10, a8);
                flatBufferBuilder.a(11, this.f8000o);
                flatBufferBuilder.b(12, a9);
                flatBufferBuilder.b(13, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9679a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f7990e = mutableFlatBuffer.a(i, 1);
                this.f8000o = mutableFlatBuffer.a(i, 11);
            }
        }

        /* compiled from: notification_tracking */
        public class Serializer extends JsonSerializer<NegativeFeedbackPromptQueryFragmentModel> {
            public final void m9688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel = (NegativeFeedbackPromptQueryFragmentModel) obj;
                if (negativeFeedbackPromptQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(negativeFeedbackPromptQueryFragmentModel.m9695a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    negativeFeedbackPromptQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NegativeFeedbackPromptQueryFragmentParser.m9720a(negativeFeedbackPromptQueryFragmentModel.w_(), negativeFeedbackPromptQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NegativeFeedbackPromptQueryFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: notification_tracking */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8003d;

            /* compiled from: notification_tracking */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m9689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NegativeFeedbackPromptQueryFragmentParser.TitleParser.m9717a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: notification_tracking */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m9690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m9691a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NegativeFeedbackPromptQueryFragmentParser.TitleParser.m9718a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m9693a() {
                this.f8003d = super.a(this.f8003d, 0);
                return this.f8003d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9691a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9693a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ TitleModel m9698b() {
            return m9694j();
        }

        public NegativeFeedbackPromptQueryFragmentModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<ResponsesModel> m9697a() {
            this.f8004d = super.a(this.f8004d, 0, ResponsesModel.class);
            return (ImmutableList) this.f8004d;
        }

        @Nullable
        private TitleModel m9694j() {
            this.f8005e = (TitleModel) super.a(this.f8005e, 1, TitleModel.class);
            return this.f8005e;
        }

        public final int jK_() {
            return 1098071294;
        }

        public final GraphQLVisitableModel m9696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            TitleModel titleModel;
            h();
            if (m9697a() != null) {
                Builder a = ModelHelper.a(m9697a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel = (NegativeFeedbackPromptQueryFragmentModel) ModelHelper.a(null, this);
                    negativeFeedbackPromptQueryFragmentModel.f8004d = a.b();
                    graphQLVisitableModel = negativeFeedbackPromptQueryFragmentModel;
                    if (m9694j() != null) {
                        titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m9694j());
                        if (m9694j() != titleModel) {
                            graphQLVisitableModel = (NegativeFeedbackPromptQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8005e = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m9694j() != null) {
                titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m9694j());
                if (m9694j() != titleModel) {
                    graphQLVisitableModel = (NegativeFeedbackPromptQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8005e = titleModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m9695a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9697a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9694j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
