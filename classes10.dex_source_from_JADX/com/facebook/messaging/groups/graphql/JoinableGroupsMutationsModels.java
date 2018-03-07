package com.facebook.messaging.groups.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.ApprovalQueueMutationParser;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.ChangeGroupApprovalModeSettingParser;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.ChangeGroupJoinableThreadSettingsParser;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.ChangeGroupJoinableThreadSettingsParser.ThreadParser;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.ChangeGroupJoinableThreadSettingsParser.ThreadParser.JoinableModeParser;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsParsers.JoinGroupThroughHashParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: showMsgReplyPublisher */
public class JoinableGroupsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: showMsgReplyPublisher */
    public final class ApprovalQueueMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2466d;

        /* compiled from: showMsgReplyPublisher */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ApprovalQueueMutationModel.class, new Deserializer());
            }

            public Object m2439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ApprovalQueueMutationParser.m2469a(jsonParser);
                Object approvalQueueMutationModel = new ApprovalQueueMutationModel();
                ((BaseModel) approvalQueueMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (approvalQueueMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) approvalQueueMutationModel).a();
                }
                return approvalQueueMutationModel;
            }
        }

        /* compiled from: showMsgReplyPublisher */
        public class Serializer extends JsonSerializer<ApprovalQueueMutationModel> {
            public final void m2440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ApprovalQueueMutationModel approvalQueueMutationModel = (ApprovalQueueMutationModel) obj;
                if (approvalQueueMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(approvalQueueMutationModel.m2442a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    approvalQueueMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = approvalQueueMutationModel.w_();
                int u_ = approvalQueueMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ApprovalQueueMutationModel.class, new Serializer());
            }
        }

        public ApprovalQueueMutationModel() {
            super(1);
        }

        @Nullable
        private String m2441a() {
            this.f2466d = super.a(this.f2466d, 0);
            return this.f2466d;
        }

        public final int jK_() {
            return -1176048080;
        }

        public final GraphQLVisitableModel m2443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2442a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2441a());
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
    /* compiled from: showMsgReplyPublisher */
    public final class ChangeGroupApprovalModeSettingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2467d;

        /* compiled from: showMsgReplyPublisher */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChangeGroupApprovalModeSettingModel.class, new Deserializer());
            }

            public Object m2444a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ChangeGroupApprovalModeSettingParser.m2470a(jsonParser);
                Object changeGroupApprovalModeSettingModel = new ChangeGroupApprovalModeSettingModel();
                ((BaseModel) changeGroupApprovalModeSettingModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (changeGroupApprovalModeSettingModel instanceof Postprocessable) {
                    return ((Postprocessable) changeGroupApprovalModeSettingModel).a();
                }
                return changeGroupApprovalModeSettingModel;
            }
        }

        /* compiled from: showMsgReplyPublisher */
        public class Serializer extends JsonSerializer<ChangeGroupApprovalModeSettingModel> {
            public final void m2445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ChangeGroupApprovalModeSettingModel changeGroupApprovalModeSettingModel = (ChangeGroupApprovalModeSettingModel) obj;
                if (changeGroupApprovalModeSettingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(changeGroupApprovalModeSettingModel.m2447a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    changeGroupApprovalModeSettingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = changeGroupApprovalModeSettingModel.w_();
                int u_ = changeGroupApprovalModeSettingModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ChangeGroupApprovalModeSettingModel.class, new Serializer());
            }
        }

        public ChangeGroupApprovalModeSettingModel() {
            super(1);
        }

        @Nullable
        private String m2446a() {
            this.f2467d = super.a(this.f2467d, 0);
            return this.f2467d;
        }

        public final int jK_() {
            return 519858561;
        }

        public final GraphQLVisitableModel m2448a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2447a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2446a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -703681928)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: showMsgReplyPublisher */
    public final class ChangeGroupJoinableThreadSettingsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ThreadModel f2470d;

        /* compiled from: showMsgReplyPublisher */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChangeGroupJoinableThreadSettingsModel.class, new Deserializer());
            }

            public Object m2449a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ChangeGroupJoinableThreadSettingsParser.m2475a(jsonParser);
                Object changeGroupJoinableThreadSettingsModel = new ChangeGroupJoinableThreadSettingsModel();
                ((BaseModel) changeGroupJoinableThreadSettingsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (changeGroupJoinableThreadSettingsModel instanceof Postprocessable) {
                    return ((Postprocessable) changeGroupJoinableThreadSettingsModel).a();
                }
                return changeGroupJoinableThreadSettingsModel;
            }
        }

        /* compiled from: showMsgReplyPublisher */
        public class Serializer extends JsonSerializer<ChangeGroupJoinableThreadSettingsModel> {
            public final void m2450a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ChangeGroupJoinableThreadSettingsModel changeGroupJoinableThreadSettingsModel = (ChangeGroupJoinableThreadSettingsModel) obj;
                if (changeGroupJoinableThreadSettingsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(changeGroupJoinableThreadSettingsModel.m2461a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    changeGroupJoinableThreadSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = changeGroupJoinableThreadSettingsModel.w_();
                int u_ = changeGroupJoinableThreadSettingsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("thread");
                    ThreadParser.m2474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ChangeGroupJoinableThreadSettingsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -608066449)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: showMsgReplyPublisher */
        public final class ThreadModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private JoinableModeModel f2469d;

            /* compiled from: showMsgReplyPublisher */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadModel.class, new Deserializer());
                }

                public Object m2451a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadParser.m2473a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadModel = new ThreadModel();
                    ((BaseModel) threadModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadModel instanceof Postprocessable) {
                        return ((Postprocessable) threadModel).a();
                    }
                    return threadModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -760489491)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: showMsgReplyPublisher */
            public final class JoinableModeModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2468d;

                /* compiled from: showMsgReplyPublisher */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(JoinableModeModel.class, new Deserializer());
                    }

                    public Object m2452a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(JoinableModeParser.m2471a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object joinableModeModel = new JoinableModeModel();
                        ((BaseModel) joinableModeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (joinableModeModel instanceof Postprocessable) {
                            return ((Postprocessable) joinableModeModel).a();
                        }
                        return joinableModeModel;
                    }
                }

                /* compiled from: showMsgReplyPublisher */
                public class Serializer extends JsonSerializer<JoinableModeModel> {
                    public final void m2453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        JoinableModeModel joinableModeModel = (JoinableModeModel) obj;
                        if (joinableModeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(joinableModeModel.m2454a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            joinableModeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        JoinableModeParser.m2472a(joinableModeModel.w_(), joinableModeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(JoinableModeModel.class, new Serializer());
                    }
                }

                public JoinableModeModel() {
                    super(1);
                }

                @Nullable
                public final String m2456a() {
                    this.f2468d = super.a(this.f2468d, 0);
                    return this.f2468d;
                }

                public final int jK_() {
                    return 65438904;
                }

                public final GraphQLVisitableModel m2455a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2454a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2456a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: showMsgReplyPublisher */
            public class Serializer extends JsonSerializer<ThreadModel> {
                public final void m2457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadModel threadModel = (ThreadModel) obj;
                    if (threadModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadModel.m2458a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadParser.m2474a(threadModel.w_(), threadModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ThreadModel.class, new Serializer());
                }
            }

            public ThreadModel() {
                super(1);
            }

            @Nullable
            public final JoinableModeModel m2460a() {
                this.f2469d = (JoinableModeModel) super.a(this.f2469d, 0, JoinableModeModel.class);
                return this.f2469d;
            }

            public final int jK_() {
                return -740570927;
            }

            public final GraphQLVisitableModel m2459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2460a() != null) {
                    JoinableModeModel joinableModeModel = (JoinableModeModel) graphQLModelMutatingVisitor.b(m2460a());
                    if (m2460a() != joinableModeModel) {
                        graphQLVisitableModel = (ThreadModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2469d = joinableModeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2458a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2460a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ChangeGroupJoinableThreadSettingsModel() {
            super(1);
        }

        @Nullable
        public final ThreadModel m2463a() {
            this.f2470d = (ThreadModel) super.a(this.f2470d, 0, ThreadModel.class);
            return this.f2470d;
        }

        public final int jK_() {
            return 2024433952;
        }

        public final GraphQLVisitableModel m2462a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2463a() != null) {
                ThreadModel threadModel = (ThreadModel) graphQLModelMutatingVisitor.b(m2463a());
                if (m2463a() != threadModel) {
                    graphQLVisitableModel = (ChangeGroupJoinableThreadSettingsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2470d = threadModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2461a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2463a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: showMsgReplyPublisher */
    public final class JoinGroupThroughHashModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2471d;

        /* compiled from: showMsgReplyPublisher */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(JoinGroupThroughHashModel.class, new Deserializer());
            }

            public Object m2464a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = JoinGroupThroughHashParser.m2476a(jsonParser);
                Object joinGroupThroughHashModel = new JoinGroupThroughHashModel();
                ((BaseModel) joinGroupThroughHashModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (joinGroupThroughHashModel instanceof Postprocessable) {
                    return ((Postprocessable) joinGroupThroughHashModel).a();
                }
                return joinGroupThroughHashModel;
            }
        }

        /* compiled from: showMsgReplyPublisher */
        public class Serializer extends JsonSerializer<JoinGroupThroughHashModel> {
            public final void m2465a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                JoinGroupThroughHashModel joinGroupThroughHashModel = (JoinGroupThroughHashModel) obj;
                if (joinGroupThroughHashModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(joinGroupThroughHashModel.m2467a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    joinGroupThroughHashModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = joinGroupThroughHashModel.w_();
                int u_ = joinGroupThroughHashModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(JoinGroupThroughHashModel.class, new Serializer());
            }
        }

        public JoinGroupThroughHashModel() {
            super(1);
        }

        @Nullable
        private String m2466a() {
            this.f2471d = super.a(this.f2471d, 0);
            return this.f2471d;
        }

        public final int jK_() {
            return -1627194864;
        }

        public final GraphQLVisitableModel m2468a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2467a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2466a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
