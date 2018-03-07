package com.facebook.facecastdisplay.protocol;

import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.CompleteReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.CompleteReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.CompleteReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveReactionsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser.FeedbackParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser.FeedbackParser.ReactionTimeSlicesParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser.FeedbackParser.ReactionTimeSlicesParser.ReactionsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser.FeedbackParser.ReactionTimeSlicesParser.ReactionsParser.ImportantReactorsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.FetchLiveVODReactionsQueryParser.FeedbackParser.ReactionTimeSlicesParser.ReactionsParser.ReactionInfoParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.LiveReactionSubscriptionParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.LiveReactionSubscriptionParser.ReactorParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.LiveReactionsAddStreamingReactionMutationFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.LiveReactionsFeedbackFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryParsers.LiveReactionsFeedbackFragmentParser.ReactionsStreamParser;
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

/* compiled from: store_conversion_notification_replaced */
public class FetchLiveReactionsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1425184816)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: store_conversion_notification_replaced */
    public final class FetchLiveReactionsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private LiveReactionsFeedbackFragmentModel f3041d;
        @Nullable
        private String f3042e;

        /* compiled from: store_conversion_notification_replaced */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveReactionsQueryModel.class, new Deserializer());
            }

            public Object m3320a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveReactionsQueryParser.m3447a(jsonParser);
                Object fetchLiveReactionsQueryModel = new FetchLiveReactionsQueryModel();
                ((BaseModel) fetchLiveReactionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveReactionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveReactionsQueryModel).a();
                }
                return fetchLiveReactionsQueryModel;
            }
        }

        /* compiled from: store_conversion_notification_replaced */
        public class Serializer extends JsonSerializer<FetchLiveReactionsQueryModel> {
            public final void m3321a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveReactionsQueryModel fetchLiveReactionsQueryModel = (FetchLiveReactionsQueryModel) obj;
                if (fetchLiveReactionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveReactionsQueryModel.m3323a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveReactionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveReactionsQueryModel.w_();
                int u_ = fetchLiveReactionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    LiveReactionsFeedbackFragmentParser.m3473a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveReactionsQueryModel.class, new Serializer());
            }
        }

        public FetchLiveReactionsQueryModel() {
            super(2);
        }

        @Nullable
        public final LiveReactionsFeedbackFragmentModel m3326j() {
            this.f3041d = (LiveReactionsFeedbackFragmentModel) super.a(this.f3041d, 0, LiveReactionsFeedbackFragmentModel.class);
            return this.f3041d;
        }

        @Nullable
        private String m3322k() {
            this.f3042e = super.a(this.f3042e, 1);
            return this.f3042e;
        }

        @Nullable
        public final String m3325a() {
            return m3322k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3326j() != null) {
                LiveReactionsFeedbackFragmentModel liveReactionsFeedbackFragmentModel = (LiveReactionsFeedbackFragmentModel) graphQLModelMutatingVisitor.b(m3326j());
                if (m3326j() != liveReactionsFeedbackFragmentModel) {
                    graphQLVisitableModel = (FetchLiveReactionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3041d = liveReactionsFeedbackFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3323a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3326j());
            int b = flatBufferBuilder.b(m3322k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -966505785)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: store_conversion_notification_replaced */
    public final class FetchLiveVODReactionsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f3055d;
        @Nullable
        private String f3056e;

        /* compiled from: store_conversion_notification_replaced */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVODReactionsQueryModel.class, new Deserializer());
            }

            public Object m3327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVODReactionsQueryParser.m3459a(jsonParser);
                Object fetchLiveVODReactionsQueryModel = new FetchLiveVODReactionsQueryModel();
                ((BaseModel) fetchLiveVODReactionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVODReactionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVODReactionsQueryModel).a();
                }
                return fetchLiveVODReactionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -752440178)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: store_conversion_notification_replaced */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f3053d;
            @Nullable
            private List<ReactionTimeSlicesModel> f3054e;

            /* compiled from: store_conversion_notification_replaced */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m3328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m3457a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1535696906)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: store_conversion_notification_replaced */
            public final class ReactionTimeSlicesModel extends BaseModel implements GraphQLVisitableModel {
                private long f3050d;
                @Nullable
                private List<ReactionsModel> f3051e;
                private long f3052f;

                /* compiled from: store_conversion_notification_replaced */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ReactionTimeSlicesModel.class, new Deserializer());
                    }

                    public Object m3329a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionTimeSlicesParser.m3455b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object reactionTimeSlicesModel = new ReactionTimeSlicesModel();
                        ((BaseModel) reactionTimeSlicesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (reactionTimeSlicesModel instanceof Postprocessable) {
                            return ((Postprocessable) reactionTimeSlicesModel).a();
                        }
                        return reactionTimeSlicesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 2044100755)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: store_conversion_notification_replaced */
                public final class ReactionsModel extends BaseModel implements GraphQLVisitableModel {
                    private int f3047d;
                    @Nullable
                    private List<ImportantReactorsModel> f3048e;
                    @Nullable
                    private ReactionInfoModel f3049f;

                    /* compiled from: store_conversion_notification_replaced */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ReactionsModel.class, new Deserializer());
                        }

                        public Object m3330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ReactionsParser.m3453b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object reactionsModel = new ReactionsModel();
                            ((BaseModel) reactionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (reactionsModel instanceof Postprocessable) {
                                return ((Postprocessable) reactionsModel).a();
                            }
                            return reactionsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1787905591)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: store_conversion_notification_replaced */
                    public final class ImportantReactorsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private GraphQLObjectType f3043d;
                        @Nullable
                        private String f3044e;

                        /* compiled from: store_conversion_notification_replaced */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImportantReactorsModel.class, new Deserializer());
                            }

                            public Object m3331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImportantReactorsParser.m3449b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object importantReactorsModel = new ImportantReactorsModel();
                                ((BaseModel) importantReactorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (importantReactorsModel instanceof Postprocessable) {
                                    return ((Postprocessable) importantReactorsModel).a();
                                }
                                return importantReactorsModel;
                            }
                        }

                        /* compiled from: store_conversion_notification_replaced */
                        public class Serializer extends JsonSerializer<ImportantReactorsModel> {
                            public final void m3332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) obj;
                                if (importantReactorsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(importantReactorsModel.m3334a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    importantReactorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImportantReactorsParser.m3448a(importantReactorsModel.w_(), importantReactorsModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImportantReactorsModel.class, new Serializer());
                            }
                        }

                        public ImportantReactorsModel() {
                            super(2);
                        }

                        public final void m3337a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m3338a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private GraphQLObjectType m3333k() {
                            if (this.b != null && this.f3043d == null) {
                                this.f3043d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f3043d;
                        }

                        @Nullable
                        public final String m3339j() {
                            this.f3044e = super.a(this.f3044e, 1);
                            return this.f3044e;
                        }

                        @Nullable
                        public final String m3336a() {
                            return m3339j();
                        }

                        public final int jK_() {
                            return 63093205;
                        }

                        public final GraphQLVisitableModel m3335a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m3334a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m3333k());
                            int b = flatBufferBuilder.b(m3339j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 608824058)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: store_conversion_notification_replaced */
                    public final class ReactionInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f3045d;
                        private int f3046e;

                        /* compiled from: store_conversion_notification_replaced */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ReactionInfoModel.class, new Deserializer());
                            }

                            public Object m3340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ReactionInfoParser.m3450a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object reactionInfoModel = new ReactionInfoModel();
                                ((BaseModel) reactionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (reactionInfoModel instanceof Postprocessable) {
                                    return ((Postprocessable) reactionInfoModel).a();
                                }
                                return reactionInfoModel;
                            }
                        }

                        /* compiled from: store_conversion_notification_replaced */
                        public class Serializer extends JsonSerializer<ReactionInfoModel> {
                            public final void m3341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ReactionInfoModel reactionInfoModel = (ReactionInfoModel) obj;
                                if (reactionInfoModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(reactionInfoModel.m3343a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    reactionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ReactionInfoParser.m3451a(reactionInfoModel.w_(), reactionInfoModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ReactionInfoModel.class, new Serializer());
                            }
                        }

                        public ReactionInfoModel() {
                            super(2);
                        }

                        @Nullable
                        private String m3342k() {
                            this.f3045d = super.a(this.f3045d, 0);
                            return this.f3045d;
                        }

                        public final int m3347j() {
                            a(0, 1);
                            return this.f3046e;
                        }

                        @Nullable
                        public final String m3345a() {
                            return m3342k();
                        }

                        public final int jK_() {
                            return -1654469956;
                        }

                        public final GraphQLVisitableModel m3344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m3343a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m3342k());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.a(1, this.f3046e, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m3346a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f3046e = mutableFlatBuffer.a(i, 1, 0);
                        }
                    }

                    /* compiled from: store_conversion_notification_replaced */
                    public class Serializer extends JsonSerializer<ReactionsModel> {
                        public final void m3348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ReactionsModel reactionsModel = (ReactionsModel) obj;
                            if (reactionsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(reactionsModel.m3350a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                reactionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ReactionsParser.m3454b(reactionsModel.w_(), reactionsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ReactionsModel.class, new Serializer());
                        }
                    }

                    public ReactionsModel() {
                        super(3);
                    }

                    public final int m3349a() {
                        a(0, 0);
                        return this.f3047d;
                    }

                    @Nonnull
                    public final ImmutableList<ImportantReactorsModel> m3353j() {
                        this.f3048e = super.a(this.f3048e, 1, ImportantReactorsModel.class);
                        return (ImmutableList) this.f3048e;
                    }

                    @Nullable
                    public final ReactionInfoModel m3354k() {
                        this.f3049f = (ReactionInfoModel) super.a(this.f3049f, 2, ReactionInfoModel.class);
                        return this.f3049f;
                    }

                    public final int jK_() {
                        return -1531702133;
                    }

                    public final GraphQLVisitableModel m3351a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel;
                        ReactionInfoModel reactionInfoModel;
                        h();
                        if (m3353j() != null) {
                            Builder a = ModelHelper.a(m3353j(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                ReactionsModel reactionsModel = (ReactionsModel) ModelHelper.a(null, this);
                                reactionsModel.f3048e = a.b();
                                graphQLVisitableModel = reactionsModel;
                                if (m3354k() != null) {
                                    reactionInfoModel = (ReactionInfoModel) graphQLModelMutatingVisitor.b(m3354k());
                                    if (m3354k() != reactionInfoModel) {
                                        graphQLVisitableModel = (ReactionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f3049f = reactionInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                            }
                        }
                        graphQLVisitableModel = null;
                        if (m3354k() != null) {
                            reactionInfoModel = (ReactionInfoModel) graphQLModelMutatingVisitor.b(m3354k());
                            if (m3354k() != reactionInfoModel) {
                                graphQLVisitableModel = (ReactionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3049f = reactionInfoModel;
                            }
                        }
                        i();
                        if (graphQLVisitableModel != null) {
                        }
                    }

                    public final int m3350a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m3353j());
                        int a2 = ModelHelper.a(flatBufferBuilder, m3354k());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.a(0, this.f3047d, 0);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, a2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m3352a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f3047d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: store_conversion_notification_replaced */
                public class Serializer extends JsonSerializer<ReactionTimeSlicesModel> {
                    public final void m3355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ReactionTimeSlicesModel reactionTimeSlicesModel = (ReactionTimeSlicesModel) obj;
                        if (reactionTimeSlicesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(reactionTimeSlicesModel.m3356a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            reactionTimeSlicesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionTimeSlicesParser.m3456b(reactionTimeSlicesModel.w_(), reactionTimeSlicesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ReactionTimeSlicesModel.class, new Serializer());
                    }
                }

                public ReactionTimeSlicesModel() {
                    super(3);
                }

                public final long m3357a() {
                    a(0, 0);
                    return this.f3050d;
                }

                @Nonnull
                public final ImmutableList<ReactionsModel> m3360j() {
                    this.f3051e = super.a(this.f3051e, 1, ReactionsModel.class);
                    return (ImmutableList) this.f3051e;
                }

                public final long m3361k() {
                    a(0, 2);
                    return this.f3052f;
                }

                public final int jK_() {
                    return 1959171708;
                }

                public final GraphQLVisitableModel m3358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3360j() != null) {
                        Builder a = ModelHelper.a(m3360j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ReactionTimeSlicesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3051e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3356a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3360j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f3050d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.a(2, this.f3052f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m3359a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f3050d = mutableFlatBuffer.a(i, 0, 0);
                    this.f3052f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: store_conversion_notification_replaced */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m3362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m3364a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m3458a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m3367a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m3368a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m3363j() {
                this.f3053d = super.a(this.f3053d, 0);
                return this.f3053d;
            }

            @Nonnull
            public final ImmutableList<ReactionTimeSlicesModel> m3366a() {
                this.f3054e = super.a(this.f3054e, 1, ReactionTimeSlicesModel.class);
                return (ImmutableList) this.f3054e;
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m3365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3366a() != null) {
                    Builder a = ModelHelper.a(m3366a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3054e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3364a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3363j());
                int a = ModelHelper.a(flatBufferBuilder, m3366a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: store_conversion_notification_replaced */
        public class Serializer extends JsonSerializer<FetchLiveVODReactionsQueryModel> {
            public final void m3369a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVODReactionsQueryModel fetchLiveVODReactionsQueryModel = (FetchLiveVODReactionsQueryModel) obj;
                if (fetchLiveVODReactionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVODReactionsQueryModel.m3371a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVODReactionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVODReactionsQueryModel.w_();
                int u_ = fetchLiveVODReactionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m3458a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVODReactionsQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVODReactionsQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackModel m3374j() {
            this.f3055d = (FeedbackModel) super.a(this.f3055d, 0, FeedbackModel.class);
            return this.f3055d;
        }

        @Nullable
        private String m3370k() {
            this.f3056e = super.a(this.f3056e, 1);
            return this.f3056e;
        }

        @Nullable
        public final String m3373a() {
            return m3370k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3372a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3374j() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m3374j());
                if (m3374j() != feedbackModel) {
                    graphQLVisitableModel = (FetchLiveVODReactionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3055d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3371a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3374j());
            int b = flatBufferBuilder.b(m3370k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 955428840)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: store_conversion_notification_replaced */
    public final class LiveReactionSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LiveReactionsFeedbackFragmentModel f3063d;
        @Nullable
        private ReactionInfoModel f3064e;
        @Nullable
        private ReactorModel f3065f;

        /* compiled from: store_conversion_notification_replaced */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveReactionSubscriptionModel.class, new Deserializer());
            }

            public Object m3375a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveReactionSubscriptionParser.m3464a(jsonParser);
                Object liveReactionSubscriptionModel = new LiveReactionSubscriptionModel();
                ((BaseModel) liveReactionSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveReactionSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) liveReactionSubscriptionModel).a();
                }
                return liveReactionSubscriptionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 608824058)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: store_conversion_notification_replaced */
        public final class ReactionInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f3057d;
            private int f3058e;

            /* compiled from: store_conversion_notification_replaced */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionInfoModel.class, new Deserializer());
                }

                public Object m3376a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveReactionSubscriptionParser.ReactionInfoParser.m3460a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionInfoModel = new ReactionInfoModel();
                    ((BaseModel) reactionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionInfoModel).a();
                    }
                    return reactionInfoModel;
                }
            }

            /* compiled from: store_conversion_notification_replaced */
            public class Serializer extends JsonSerializer<ReactionInfoModel> {
                public final void m3377a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionInfoModel reactionInfoModel = (ReactionInfoModel) obj;
                    if (reactionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionInfoModel.m3379a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveReactionSubscriptionParser.ReactionInfoParser.m3461a(reactionInfoModel.w_(), reactionInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReactionInfoModel.class, new Serializer());
                }
            }

            public ReactionInfoModel() {
                super(2);
            }

            @Nullable
            private String m3378k() {
                this.f3057d = super.a(this.f3057d, 0);
                return this.f3057d;
            }

            public final int m3383j() {
                a(0, 1);
                return this.f3058e;
            }

            @Nullable
            public final String m3381a() {
                return m3378k();
            }

            public final int jK_() {
                return -1654469956;
            }

            public final GraphQLVisitableModel m3380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3379a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3378k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f3058e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3382a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3058e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1573578728)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: store_conversion_notification_replaced */
        public final class ReactorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3059d;
            @Nullable
            private String f3060e;
            private boolean f3061f;
            @Nullable
            private String f3062g;

            /* compiled from: store_conversion_notification_replaced */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactorModel.class, new Deserializer());
                }

                public Object m3384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactorParser.m3462a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactorModel = new ReactorModel();
                    ((BaseModel) reactorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactorModel instanceof Postprocessable) {
                        return ((Postprocessable) reactorModel).a();
                    }
                    return reactorModel;
                }
            }

            /* compiled from: store_conversion_notification_replaced */
            public class Serializer extends JsonSerializer<ReactorModel> {
                public final void m3385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactorModel reactorModel = (ReactorModel) obj;
                    if (reactorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactorModel.m3388a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactorParser.m3463a(reactorModel.w_(), reactorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReactorModel.class, new Serializer());
                }
            }

            public ReactorModel() {
                super(4);
            }

            public final void m3392a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m3393a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m3386l() {
                if (this.b != null && this.f3059d == null) {
                    this.f3059d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3059d;
            }

            @Nullable
            public final String m3394j() {
                this.f3060e = super.a(this.f3060e, 1);
                return this.f3060e;
            }

            public final boolean m3395k() {
                a(0, 2);
                return this.f3061f;
            }

            @Nullable
            private String m3387m() {
                this.f3062g = super.a(this.f3062g, 3);
                return this.f3062g;
            }

            @Nullable
            public final String m3390a() {
                return m3394j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m3389a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3388a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3386l());
                int b = flatBufferBuilder.b(m3394j());
                int b2 = flatBufferBuilder.b(m3387m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f3061f);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3391a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3061f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: store_conversion_notification_replaced */
        public class Serializer extends JsonSerializer<LiveReactionSubscriptionModel> {
            public final void m3396a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveReactionSubscriptionModel liveReactionSubscriptionModel = (LiveReactionSubscriptionModel) obj;
                if (liveReactionSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveReactionSubscriptionModel.m3397a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveReactionSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveReactionSubscriptionModel.w_();
                int u_ = liveReactionSubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    LiveReactionsFeedbackFragmentParser.m3473a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("reaction_info");
                    LiveReactionSubscriptionParser.ReactionInfoParser.m3461a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("reactor");
                    ReactorParser.m3463a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveReactionSubscriptionModel.class, new Serializer());
            }
        }

        public LiveReactionSubscriptionModel() {
            super(3);
        }

        @Nullable
        public final LiveReactionsFeedbackFragmentModel m3398a() {
            this.f3063d = (LiveReactionsFeedbackFragmentModel) super.a(this.f3063d, 0, LiveReactionsFeedbackFragmentModel.class);
            return this.f3063d;
        }

        @Nullable
        public final ReactionInfoModel m3400j() {
            this.f3064e = (ReactionInfoModel) super.a(this.f3064e, 1, ReactionInfoModel.class);
            return this.f3064e;
        }

        @Nullable
        public final ReactorModel m3401k() {
            this.f3065f = (ReactorModel) super.a(this.f3065f, 2, ReactorModel.class);
            return this.f3065f;
        }

        public final int jK_() {
            return -1145157442;
        }

        public final GraphQLVisitableModel m3399a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3398a() != null) {
                LiveReactionsFeedbackFragmentModel liveReactionsFeedbackFragmentModel = (LiveReactionsFeedbackFragmentModel) graphQLModelMutatingVisitor.b(m3398a());
                if (m3398a() != liveReactionsFeedbackFragmentModel) {
                    graphQLVisitableModel = (LiveReactionSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3063d = liveReactionsFeedbackFragmentModel;
                }
            }
            if (m3400j() != null) {
                ReactionInfoModel reactionInfoModel = (ReactionInfoModel) graphQLModelMutatingVisitor.b(m3400j());
                if (m3400j() != reactionInfoModel) {
                    graphQLVisitableModel = (LiveReactionSubscriptionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3064e = reactionInfoModel;
                }
            }
            if (m3401k() != null) {
                ReactorModel reactorModel = (ReactorModel) graphQLModelMutatingVisitor.b(m3401k());
                if (m3401k() != reactorModel) {
                    graphQLVisitableModel = (LiveReactionSubscriptionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3065f = reactorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3397a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3398a());
            int a2 = ModelHelper.a(flatBufferBuilder, m3400j());
            int a3 = ModelHelper.a(flatBufferBuilder, m3401k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -361648259)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: store_conversion_notification_replaced */
    public final class LiveReactionsAddStreamingReactionMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f3076d;

        /* compiled from: store_conversion_notification_replaced */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveReactionsAddStreamingReactionMutationFragmentModel.class, new Deserializer());
            }

            public Object m3402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveReactionsAddStreamingReactionMutationFragmentParser.m3467a(jsonParser);
                Object liveReactionsAddStreamingReactionMutationFragmentModel = new LiveReactionsAddStreamingReactionMutationFragmentModel();
                ((BaseModel) liveReactionsAddStreamingReactionMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveReactionsAddStreamingReactionMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) liveReactionsAddStreamingReactionMutationFragmentModel).a();
                }
                return liveReactionsAddStreamingReactionMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 651844646)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: store_conversion_notification_replaced */
        public final class FeedbackModel extends BaseModel implements CompleteReactionsFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f3066d;
            private boolean f3067e;
            @Nullable
            private String f3068f;
            @Nullable
            private ImportantReactorsModel f3069g;
            @Nullable
            private String f3070h;
            @Nullable
            private ReactorsModel f3071i;
            @Nullable
            private List<SupportedReactionsModel> f3072j;
            @Nullable
            private TopReactionsModel f3073k;
            @Nullable
            private ViewerActsAsPersonModel f3074l;
            private int f3075m;

            /* compiled from: store_conversion_notification_replaced */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m3403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveReactionsAddStreamingReactionMutationFragmentParser.FeedbackParser.m3465a(jsonParser, flatBufferBuilder));
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

            /* compiled from: store_conversion_notification_replaced */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m3404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m3414a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveReactionsAddStreamingReactionMutationFragmentParser.FeedbackParser.m3466a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(10);
            }

            public final void m3418a(String str, ConsistencyTuple consistencyTuple) {
                if ("reactors.count".equals(str)) {
                    ReactorsModel m = m3409m();
                    if (m != null) {
                        consistencyTuple.a = Integer.valueOf(m.a());
                        consistencyTuple.b = m.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m3413q());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 9;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m3419a(String str, Object obj, boolean z) {
                if ("reactors.count".equals(str)) {
                    ReactorsModel m = m3409m();
                    if (m == null) {
                        return;
                    }
                    if (z) {
                        m = (ReactorsModel) m.clone();
                        m.a(((Integer) obj).intValue());
                        this.f3071i = m;
                        return;
                    }
                    m.a(((Integer) obj).intValue());
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    m3405a(((Integer) obj).intValue());
                }
            }

            @Nullable
            private String m3406j() {
                this.f3068f = super.a(this.f3068f, 2);
                return this.f3068f;
            }

            @Nullable
            private ImportantReactorsModel m3407k() {
                this.f3069g = (ImportantReactorsModel) super.a(this.f3069g, 3, ImportantReactorsModel.class);
                return this.f3069g;
            }

            @Nullable
            private String m3408l() {
                this.f3070h = super.a(this.f3070h, 4);
                return this.f3070h;
            }

            @Nullable
            private ReactorsModel m3409m() {
                this.f3071i = (ReactorsModel) super.a(this.f3071i, 5, ReactorsModel.class);
                return this.f3071i;
            }

            @Nonnull
            private ImmutableList<SupportedReactionsModel> m3410n() {
                this.f3072j = super.a(this.f3072j, 6, SupportedReactionsModel.class);
                return (ImmutableList) this.f3072j;
            }

            @Nullable
            private TopReactionsModel m3411o() {
                this.f3073k = (TopReactionsModel) super.a(this.f3073k, 7, TopReactionsModel.class);
                return this.f3073k;
            }

            @Nullable
            private ViewerActsAsPersonModel m3412p() {
                this.f3074l = (ViewerActsAsPersonModel) super.a(this.f3074l, 8, ViewerActsAsPersonModel.class);
                return this.f3074l;
            }

            private int m3413q() {
                a(1, 1);
                return this.f3075m;
            }

            private void m3405a(int i) {
                this.f3075m = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 9, i);
                }
            }

            @Nullable
            public final String m3416a() {
                return m3408l();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m3415a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3407k() != null) {
                    ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m3407k());
                    if (m3407k() != importantReactorsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3069g = importantReactorsModel;
                    }
                }
                if (m3409m() != null) {
                    ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m3409m());
                    if (m3409m() != reactorsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3071i = reactorsModel;
                    }
                }
                if (m3410n() != null) {
                    Builder a = ModelHelper.a(m3410n(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FeedbackModel feedbackModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        feedbackModel.f3072j = a.b();
                        graphQLVisitableModel = feedbackModel;
                    }
                }
                if (m3411o() != null) {
                    TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m3411o());
                    if (m3411o() != topReactionsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3073k = topReactionsModel;
                    }
                }
                if (m3412p() != null) {
                    ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m3412p());
                    if (m3412p() != viewerActsAsPersonModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3074l = viewerActsAsPersonModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3414a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3406j());
                int a = ModelHelper.a(flatBufferBuilder, m3407k());
                int b2 = flatBufferBuilder.b(m3408l());
                int a2 = ModelHelper.a(flatBufferBuilder, m3409m());
                int a3 = ModelHelper.a(flatBufferBuilder, m3410n());
                int a4 = ModelHelper.a(flatBufferBuilder, m3411o());
                int a5 = ModelHelper.a(flatBufferBuilder, m3412p());
                flatBufferBuilder.c(10);
                flatBufferBuilder.a(0, this.f3066d);
                flatBufferBuilder.a(1, this.f3067e);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, a3);
                flatBufferBuilder.b(7, a4);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.a(9, this.f3075m, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3417a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3066d = mutableFlatBuffer.a(i, 0);
                this.f3067e = mutableFlatBuffer.a(i, 1);
                this.f3075m = mutableFlatBuffer.a(i, 9, 0);
            }
        }

        /* compiled from: store_conversion_notification_replaced */
        public class Serializer extends JsonSerializer<LiveReactionsAddStreamingReactionMutationFragmentModel> {
            public final void m3420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveReactionsAddStreamingReactionMutationFragmentModel liveReactionsAddStreamingReactionMutationFragmentModel = (LiveReactionsAddStreamingReactionMutationFragmentModel) obj;
                if (liveReactionsAddStreamingReactionMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveReactionsAddStreamingReactionMutationFragmentModel.m3422a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveReactionsAddStreamingReactionMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveReactionsAddStreamingReactionMutationFragmentModel.w_();
                int u_ = liveReactionsAddStreamingReactionMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    LiveReactionsAddStreamingReactionMutationFragmentParser.FeedbackParser.m3466a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveReactionsAddStreamingReactionMutationFragmentModel.class, new Serializer());
            }
        }

        public LiveReactionsAddStreamingReactionMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m3421a() {
            this.f3076d = (FeedbackModel) super.a(this.f3076d, 0, FeedbackModel.class);
            return this.f3076d;
        }

        public final int jK_() {
            return -1145157442;
        }

        public final GraphQLVisitableModel m3423a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3421a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m3421a());
                if (m3421a() != feedbackModel) {
                    graphQLVisitableModel = (LiveReactionsAddStreamingReactionMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3076d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3422a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3421a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1860490248)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: store_conversion_notification_replaced */
    public final class LiveReactionsFeedbackFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f3081d;
        @Nullable
        private List<ReactionsStreamModel> f3082e;

        /* compiled from: store_conversion_notification_replaced */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveReactionsFeedbackFragmentModel.class, new Deserializer());
            }

            public Object m3424a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveReactionsFeedbackFragmentParser.m3472a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveReactionsFeedbackFragmentModel = new LiveReactionsFeedbackFragmentModel();
                ((BaseModel) liveReactionsFeedbackFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveReactionsFeedbackFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) liveReactionsFeedbackFragmentModel).a();
                }
                return liveReactionsFeedbackFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -460238943)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: store_conversion_notification_replaced */
        public final class ReactionsStreamModel extends BaseModel implements GraphQLVisitableModel {
            private int f3079d;
            @Nullable
            private ReactionInfoModel f3080e;

            /* compiled from: store_conversion_notification_replaced */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionsStreamModel.class, new Deserializer());
                }

                public Object m3425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionsStreamParser.m3470b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionsStreamModel = new ReactionsStreamModel();
                    ((BaseModel) reactionsStreamModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionsStreamModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionsStreamModel).a();
                    }
                    return reactionsStreamModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 608824058)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: store_conversion_notification_replaced */
            public final class ReactionInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f3077d;
                private int f3078e;

                /* compiled from: store_conversion_notification_replaced */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ReactionInfoModel.class, new Deserializer());
                    }

                    public Object m3426a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionsStreamParser.ReactionInfoParser.m3468a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object reactionInfoModel = new ReactionInfoModel();
                        ((BaseModel) reactionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (reactionInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) reactionInfoModel).a();
                        }
                        return reactionInfoModel;
                    }
                }

                /* compiled from: store_conversion_notification_replaced */
                public class Serializer extends JsonSerializer<ReactionInfoModel> {
                    public final void m3427a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ReactionInfoModel reactionInfoModel = (ReactionInfoModel) obj;
                        if (reactionInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(reactionInfoModel.m3429a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            reactionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionsStreamParser.ReactionInfoParser.m3469a(reactionInfoModel.w_(), reactionInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ReactionInfoModel.class, new Serializer());
                    }
                }

                public ReactionInfoModel() {
                    super(2);
                }

                @Nullable
                private String m3428k() {
                    this.f3077d = super.a(this.f3077d, 0);
                    return this.f3077d;
                }

                public final int m3433j() {
                    a(0, 1);
                    return this.f3078e;
                }

                @Nullable
                public final String m3431a() {
                    return m3428k();
                }

                public final int jK_() {
                    return -1654469956;
                }

                public final GraphQLVisitableModel m3430a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m3429a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m3428k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f3078e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m3432a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f3078e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: store_conversion_notification_replaced */
            public class Serializer extends JsonSerializer<ReactionsStreamModel> {
                public final void m3434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionsStreamModel reactionsStreamModel = (ReactionsStreamModel) obj;
                    if (reactionsStreamModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionsStreamModel.m3436a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionsStreamModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionsStreamParser.m3471b(reactionsStreamModel.w_(), reactionsStreamModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionsStreamModel.class, new Serializer());
                }
            }

            public ReactionsStreamModel() {
                super(2);
            }

            public final int m3435a() {
                a(0, 0);
                return this.f3079d;
            }

            @Nullable
            public final ReactionInfoModel m3439j() {
                this.f3080e = (ReactionInfoModel) super.a(this.f3080e, 1, ReactionInfoModel.class);
                return this.f3080e;
            }

            public final int jK_() {
                return -1531702133;
            }

            public final GraphQLVisitableModel m3437a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3439j() != null) {
                    ReactionInfoModel reactionInfoModel = (ReactionInfoModel) graphQLModelMutatingVisitor.b(m3439j());
                    if (m3439j() != reactionInfoModel) {
                        graphQLVisitableModel = (ReactionsStreamModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3080e = reactionInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3436a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3439j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f3079d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3438a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3079d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: store_conversion_notification_replaced */
        public class Serializer extends JsonSerializer<LiveReactionsFeedbackFragmentModel> {
            public final void m3440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveReactionsFeedbackFragmentModel liveReactionsFeedbackFragmentModel = (LiveReactionsFeedbackFragmentModel) obj;
                if (liveReactionsFeedbackFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveReactionsFeedbackFragmentModel.m3441a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveReactionsFeedbackFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveReactionsFeedbackFragmentParser.m3473a(liveReactionsFeedbackFragmentModel.w_(), liveReactionsFeedbackFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveReactionsFeedbackFragmentModel.class, new Serializer());
            }
        }

        public LiveReactionsFeedbackFragmentModel() {
            super(2);
        }

        public final void m3444a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3445a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m3443a() {
            this.f3081d = super.a(this.f3081d, 0);
            return this.f3081d;
        }

        @Nonnull
        public final ImmutableList<ReactionsStreamModel> m3446j() {
            this.f3082e = super.a(this.f3082e, 1, ReactionsStreamModel.class);
            return (ImmutableList) this.f3082e;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3442a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3446j() != null) {
                Builder a = ModelHelper.a(m3446j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LiveReactionsFeedbackFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3082e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3441a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3443a());
            int a = ModelHelper.a(flatBufferBuilder, m3446j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
